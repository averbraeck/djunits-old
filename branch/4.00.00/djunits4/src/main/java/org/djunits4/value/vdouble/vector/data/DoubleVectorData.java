package org.djunits4.value.vdouble.vector.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.IntStream;

import org.djunits4.unit.Unit;
import org.djunits4.unit.scale.Scale;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;

/**
 * Stores the data for a DoubleVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class DoubleVectorData implements Serializable
{
    /** */
    private static final long serialVersionUID = 1L;

    /** The internal storage of the Vector; can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected double[] vectorSI;

    /** The data type. */
    private final StorageType storageType;

    /** Threshold to do parallel execution. */
    protected static final int PARALLEL_THRESHOLD = 1000;

    /**
     * Construct a new DoubleVectorData object.
     * @param storageType StorageType; the data type.
     */
    DoubleVectorData(final StorageType storageType)
    {
        this.storageType = storageType;
    }

    /* ============================================================================================ */
    /* ====================================== INSTANTIATION ======================================= */
    /* ============================================================================================ */

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values double[]; the (SI) values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return DoubleVectorData; the DoubleVectorData with the right data type
     * @throws ValueRuntimeException when values are null, or storageType is null
     */
    public static DoubleVectorData instantiate(final double[] values, final Scale scale, final StorageType storageType)
            throws ValueRuntimeException
    {
        if (values == null)
        {
            throw new ValueRuntimeException("DoubleVectorData.instantiate: double[] values is null");
        }

        double[] valuesSI = scale.isBaseSIScale() ? values : new double[values.length];
        if (!scale.isBaseSIScale())
        {
            if (values.length > PARALLEL_THRESHOLD)
            {
                IntStream.range(0, values.length).parallel().forEach(i -> valuesSI[i] = scale.toStandardUnit(values[i]));
            }
            else
            {
                IntStream.range(0, values.length).forEach(i -> valuesSI[i] = scale.toStandardUnit(values[i]));
            }
        }

        switch (storageType)
        {
            case DENSE:
                return new DoubleVectorDataDense(valuesSI);

            case SPARSE:
                return DoubleVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values List&lt;Double&gt;; the values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return DoubleVectorData; the DoubleVectorData with the right data type
     * @throws ValueRuntimeException when list is null, or storageType is null
     */
    public static DoubleVectorData instantiate(final List<Double> values, final Scale scale, final StorageType storageType)
            throws ValueRuntimeException
    {
        if (values == null)
        {
            throw new ValueRuntimeException("DoubleVectorData.instantiate: List<Double> values is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI;
                if (values.size() > PARALLEL_THRESHOLD)
                {
                    if (scale.isBaseSIScale())
                    {
                        valuesSI = values.parallelStream().mapToDouble(d -> d).toArray();
                    }
                    else
                    {
                        valuesSI = values.parallelStream().mapToDouble(d -> scale.toStandardUnit(d)).toArray();
                    }
                }
                else
                {
                    if (scale.isBaseSIScale())
                    {
                        valuesSI = values.stream().mapToDouble(d -> d).toArray();
                    }
                    else
                    {
                        valuesSI = values.stream().mapToDouble(d -> scale.toStandardUnit(d)).toArray();
                    }
                }
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int nonZeroCount;
                if (values.size() > PARALLEL_THRESHOLD)
                {
                    if (scale.isBaseSIScale())
                    {
                        nonZeroCount = (int) values.parallelStream().mapToDouble(d -> d).count();
                    }
                    else
                    {
                        nonZeroCount = (int) values.parallelStream().mapToDouble(d -> scale.toStandardUnit(d)).count();
                    }
                }
                else
                {
                    if (scale.isBaseSIScale())
                    {
                        nonZeroCount = (int) values.stream().mapToDouble(d -> d).count();
                    }
                    else
                    {
                        nonZeroCount = (int) values.stream().mapToDouble(d -> scale.toStandardUnit(d)).count();
                    }
                }
                int[] indices = new int[nonZeroCount];
                double[] valuesSI = new double[nonZeroCount];
                // Counting non zeros could be done in parallel; but filling the arrays has to be done sequentially
                int index = 0;
                for (int i = 0; i < values.size(); i++)
                {
                    double d = scale.toStandardUnit(values.get(i));
                    if (d != 0.0)
                    {
                        indices[index] = i;
                        valuesSI[index] = d;
                        index++;
                    }
                }
                return new DoubleVectorDataSparse(valuesSI, indices, values.size());
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values DoubleScalarInterface[]; the values to store
     * @param storageType StorageType; the data type to use
     * @return DoubleVectorData; the DoubleVectorData with the right data type
     * @throws ValueRuntimeException when values is null, or storageType is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> DoubleVectorData instantiate(final S[] values,
            final StorageType storageType) throws ValueRuntimeException
    {
        if (values == null)
        {
            throw new ValueRuntimeException("DoubleVectorData.instantiate: DoubleScalar[] values is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI;
                if (values.length > PARALLEL_THRESHOLD)
                {
                    valuesSI = Arrays.stream(values).parallel().mapToDouble(s -> s.getSI()).toArray();
                }
                else
                {
                    valuesSI = Arrays.stream(values).mapToDouble(s -> s.getSI()).toArray();
                }
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int nonZeroCount;
                if (values.length > PARALLEL_THRESHOLD)
                {
                    nonZeroCount = (int) Arrays.stream(values).parallel().filter(s -> s.getSI() != 0).count();
                }
                else
                {
                    nonZeroCount = (int) Arrays.stream(values).filter(s -> s.getSI() != 0.0).count();
                }                
                int[] indices = new int[nonZeroCount];
                double[] valuesSI = new double[nonZeroCount];
                // Counting non zeros could be done in parallel; but filling the arrays has to be done sequentially
                int index = 0;
                for (int i = 0; i < values.length; i++)
                {
                    double d = values[i].si;
                    if (d != 0.0)
                    {
                        indices[index] = i;
                        valuesSI[index] = d;
                        index++;
                    }
                }
                return new DoubleVectorDataSparse(valuesSI, indices, values.length);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param valueList List&lt;S&gt;; the values to store
     * @param storageType StorageType; the data type to use
     * @return DoubleVectorData; the DoubleVectorData with the right data type
     * @throws ValueRuntimeException when values is null, or storageType is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> DoubleVectorData instantiateList(
            final List<S> valueList, final StorageType storageType) throws ValueRuntimeException
    {
        if (valueList == null)
        {
            throw new ValueRuntimeException("DoubleVectorData.instantiate: List<DoubleScalar> values is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI;
                if (valueList.size() > PARALLEL_THRESHOLD)
                {
                    valuesSI = valueList.stream().parallel().mapToDouble(s -> s.getSI()).toArray();
                }
                else
                {
                    valuesSI = valueList.stream().mapToDouble(s -> s.getSI()).toArray();
                }
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int nonZeroCount = (int) valueList.parallelStream().filter(s -> s.si != 0.0).count();
                int[] indices = new int[nonZeroCount];
                double[] valuesSI = new double[nonZeroCount];
                // Counting non zeros could be done in parallel; but filling the arrays has to be done sequentially
                int index = 0;
                for (int i = 0; i < valueList.size(); i++)
                {
                    double d = valueList.get(i).si;
                    if (d != 0.0)
                    {
                        indices[index] = i;
                        valuesSI[index] = d;
                        index++;
                    }
                }
                return new DoubleVectorDataSparse(valuesSI, indices, valueList.size());
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values SortedMap&lt;Integer,Double&gt;; the DoubleScalar values to store
     * @param length int; the length of the vector to pad with 0 after last entry in map
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return DoubleVectorData; the DoubleVectorData with the right data type
     * @throws ValueRuntimeException when values is null, or storageType is null
     */
    public static DoubleVectorData instantiate(final SortedMap<Integer, Double> values, final int length, final Scale scale,
            final StorageType storageType) throws ValueRuntimeException
    {
        if (values == null)
        {
            throw new ValueRuntimeException("DoubleVectorData.instantiate: values map is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI = new double[length];
                values.entrySet().parallelStream().forEach(entry -> valuesSI[entry.getKey()] = entry.getValue());
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int nonZeroCount;
                if (scale.isBaseSIScale())
                {
                    nonZeroCount = (int) values.keySet().parallelStream().filter(d -> d != 0d).count();
                }
                else
                {
                    nonZeroCount = (int) values.keySet().parallelStream().filter(d -> scale.toStandardUnit(d) != 0d).count();
                }
                int[] indices = new int[nonZeroCount];
                double[] valuesSI = new double[nonZeroCount];
                int index = 0;
                if (scale.isBaseSIScale())
                {
                    for (Integer key : values.keySet())
                    {
                        double value = values.get(key);
                        if (0.0 != value)
                        {
                            indices[index] = key;
                            valuesSI[index] = value;
                            index++;
                        }
                    }
                }
                else
                {
                    for (Integer key : values.keySet())
                    {
                        double value = scale.toStandardUnit(values.get(key));
                        if (0.0 != value)
                        {
                            indices[index] = key;
                            valuesSI[index] = value;
                            index++;
                        }
                    }
                }
                return new DoubleVectorDataSparse(valuesSI, indices, length);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values Map&lt;Integer,S&gt;; the DoubleScalar values to store
     * @param length int; the length of the vector to pad with 0 after last entry in map
     * @param storageType StorageType; the data type to use
     * @return DoubleVectorData; the DoubleVectorData with the right data type
     * @throws ValueRuntimeException when values is null, or storageType is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> DoubleVectorData instantiateMap(
            final Map<Integer, S> values, final int length, final StorageType storageType) throws ValueRuntimeException
    {
        if (values == null)
        {
            throw new ValueRuntimeException("DoubleVectorData.instantiateMap: values map is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI = new double[length];
                values.entrySet().parallelStream().forEach(entry -> valuesSI[entry.getKey()] = entry.getValue().si);
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int nonZeroCount = (int) values.values().parallelStream().filter(s -> s.si != 0d).count();
                int[] indices = new int[nonZeroCount];
                double[] valuesSI = new double[nonZeroCount];
                int index = 0;
                for (Integer key : values.keySet())
                {
                    double value = values.get(key).si;
                    if (0.0 != value)
                    {
                        indices[index] = key;
                        valuesSI[index] = value;
                        index++;
                    }
                }
                return new DoubleVectorDataSparse(valuesSI, indices, length);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /* ============================================================================================ */
    /* ==================================== UTILITY FUNCTIONS ===================================== */
    /* ============================================================================================ */

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Vector.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Vector
     */
    public final StorageType getStorageType()
    {
        return this.storageType;
    }

    /**
     * Retrieve the size of the vector.
     * @return int; the size of the vector
     */
    public abstract int size();

    /**
     * Is the data storage sparse?
     * @return boolean; true if the data storage is sparse; false if the data storage is not sparse
     */
    public boolean isSparse()
    {
        return this.storageType.equals(StorageType.SPARSE);
    }

    /**
     * Return the sparsely stored equivalent of this data.
     * @return DoubleVectorDataSparse; the sparse transformation of this data
     */
    public DoubleVectorDataSparse toSparse()
    {
        return isSparse() ? (DoubleVectorDataSparse) this : ((DoubleVectorDataDense) this).toSparse();
    }

    /**
     * Is the data storage dense?
     * @return boolean; true if the data storage is dense; false if the data storage is not dense
     */
    public boolean isDense()
    {
        return this.storageType.equals(StorageType.DENSE);
    }

    /**
     * Return the densely stored equivalent of this data.
     * @return DoubleVectorDataDense; the dense transformation of this data
     */
    public DoubleVectorDataDense toDense()
    {
        return isDense() ? (DoubleVectorDataDense) this : ((DoubleVectorDataSparse) this).toDense();
    }

    /**
     * Retrieve the SI value of one element of this data.
     * @param index int; the index to get the value for
     * @return double; the value at the index
     */
    public abstract double getSI(int index);

    /**
     * Sets a value at the index in the vector.
     * @param index int; the index to set the value for
     * @param valueSI double; the value at the index
     */
    public abstract void setSI(int index, double valueSI);

    /**
     * Retrieve the number of non-zero cells.
     * @return int; the number of non-zero cells
     */
    public final int cardinality()
    {
        return (int) Arrays.stream(this.vectorSI).parallel().filter(d -> d != 0.0).count();
    }

    /**
     * Compute and return the sum of all values.
     * @return double; the sum of the values of all cells
     */
    public final double zSum()
    {
        return Arrays.stream(this.vectorSI).parallel().sum();
    }

    /**
     * Create and return a deep copy of the data.
     * @return DoubleVectorData; a deep copy of the data
     */
    public abstract DoubleVectorData copy();

    /**
     * Create and return a dense copy of the data.
     * @return double[]; a safe copy of VectorSI
     */
    public abstract double[] getDenseVectorSI();

    /**
     * Check the sizes of this data object and the other data object.
     * @param other DoubleVectorData; the other data object
     * @throws ValueRuntimeException if vectors have different lengths
     */
    private void checkSizes(final DoubleVectorData other) throws ValueRuntimeException
    {
        if (this.size() != other.size())
        {
            throw new ValueRuntimeException("Two data objects used in a DoubleVector operation do not have the same size");
        }
    }

    /* ============================================================================================ */
    /* ================================== CALCULATION FUNCTIONS =================================== */
    /* ============================================================================================ */

    /**
     * Add two vectors on a cell-by-cell basis. If both vectors are sparse, a sparse vector is returned, otherwise a dense
     * vector is returned. Neither of the two objects is changed.
     * @param right DoubleVectorData; the other data object to add
     * @return DoubleVectorData; the sum of this data object and the other data object as a new data object
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public DoubleVectorData plus(final DoubleVectorData right) throws ValueRuntimeException
    {
        checkSizes(right);
        double[] dv = IntStream.range(0, size()).parallel().mapToDouble(i -> getSI(i) + right.getSI(i)).toArray();
        if (this instanceof DoubleVectorDataSparse && right instanceof DoubleVectorDataSparse)
        {
            return new DoubleVectorDataDense(dv).toSparse();
        }
        return new DoubleVectorDataDense(dv);
    }

    /**
     * Add a vector to this vector on a cell-by-cell basis. The type of vector (sparse, dense) stays the same.
     * @param right DoubleVectorData; the other data object to add
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public abstract void incrementBy(DoubleVectorData right) throws ValueRuntimeException;

    /**
     * Add a number to this vector on a cell-by-cell basis.
     * @param valueSI double; the value to add
     */
    public abstract void incrementBy(double valueSI);

    /**
     * Subtract two vectors on a cell-by-cell basis. If both vectors are sparse, a sparse vector is returned, otherwise a dense
     * vector is returned. Neither of the two objects is changed.
     * @param right DoubleVectorData; the other data object to subtract
     * @return DoubleVectorData; the difference of this data object and the other data object as a new data object
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public DoubleVectorData minus(final DoubleVectorData right) throws ValueRuntimeException
    {
        checkSizes(right);
        double[] dv = IntStream.range(0, size()).parallel().mapToDouble(i -> getSI(i) - right.getSI(i)).toArray();
        if (this instanceof DoubleVectorDataSparse && right instanceof DoubleVectorDataSparse)
        {
            return new DoubleVectorDataDense(dv).toSparse();
        }
        return new DoubleVectorDataDense(dv);
    }

    /**
     * Subtract a vector from this vector on a cell-by-cell basis. The type of vector (sparse, dense) stays the same.
     * @param right DoubleVectorData; the other data object to subtract
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public abstract void decrementBy(DoubleVectorData right) throws ValueRuntimeException;

    /**
     * Subtract a number from this vector on a cell-by-cell basis.
     * @param valueSI double; the value to subtract
     */
    public abstract void decrementBy(double valueSI);

    /**
     * Multiply two vector on a cell-by-cell basis. If both vectors are dense, a dense vector is returned, otherwise a sparse
     * vector is returned.
     * @param right DoubleVectorData; the other data object to multiply with
     * @return DoubleVectorData; the product of this data object and the other data object
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public DoubleVectorData times(final DoubleVectorData right) throws ValueRuntimeException
    {
        checkSizes(right);
        double[] dv = IntStream.range(0, size()).parallel().mapToDouble(i -> getSI(i) * right.getSI(i)).toArray();
        if (this instanceof DoubleVectorDataDense && right instanceof DoubleVectorDataDense)
        {
            return new DoubleVectorDataDense(dv);
        }
        return new DoubleVectorDataDense(dv).toSparse();
    }

    /**
     * Multiply a vector with the values of another vector on a cell-by-cell basis. The type of vector (sparse, dense) stays the
     * same.
     * @param right DoubleVectorData; the other data object to multiply with
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public abstract void multiplyBy(DoubleVectorData right) throws ValueRuntimeException;

    /**
     * Multiply the values of this vector with a number on a cell-by-cell basis.
     * @param valueSI double; the value to multiply with
     */
    public abstract void multiplyBy(double valueSI);

    /**
     * Divide two vectors on a cell-by-cell basis. If both vectors are dense, a dense vector is returned, otherwise a sparse
     * vector is returned.
     * @param right DoubleVectorData; the other data object to divide by
     * @return DoubleVectorData; the division of this data object and the other data object
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public DoubleVectorData divide(final DoubleVectorData right) throws ValueRuntimeException
    {
        checkSizes(right);
        double[] dv = IntStream.range(0, size()).parallel().mapToDouble(i -> getSI(i) / right.getSI(i)).toArray();
        if (this instanceof DoubleVectorDataDense && right instanceof DoubleVectorDataDense)
        {
            return new DoubleVectorDataDense(dv);
        }
        return new DoubleVectorDataDense(dv).toSparse();
    }

    /**
     * Divide the values of a vector by the values of another vector on a cell-by-cell basis. The type of vector (sparse, dense)
     * stays the same.
     * @param right DoubleVectorData; the other data object to divide by
     * @throws ValueRuntimeException if vectors have different lengths
     */
    public abstract void divideBy(DoubleVectorData right) throws ValueRuntimeException;

    /**
     * Divide the values of this vector by a number on a cell-by-cell basis.
     * @param valueSI double; the value to multiply with
     */
    public abstract void divideBy(double valueSI);

    /* ============================================================================================ */
    /* =============================== EQUALS, HASHCODE, TOSTRING ================================= */
    /* ============================================================================================ */

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.vectorSI);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:needbraces")
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleVectorData other = (DoubleVectorData) obj;
        if (!Arrays.equals(this.vectorSI, other.vectorSI))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "DoubleVectorData [storageType=" + this.storageType + ", vectorSI=" + Arrays.toString(this.vectorSI) + "]";
    }

}
