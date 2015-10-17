package org.djunits.value.vdouble.vector;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.IntStream;

import org.djunits.unit.scale.Scale;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Stores the data for a DoubleVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
abstract class DoubleVectorData
{
    /** the internal storage of the Vector; can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected double[] vectorSI;

    /** the data type. */
    private final StorageType storageType;

    /**
     * @param storageType the data type.
     */
    DoubleVectorData(final StorageType storageType)
    {
        super();
        this.storageType = storageType;
    }

    /** ============================================================================================ */
    /** ====================================== INSTANTIATION ======================================= */
    /** ============================================================================================ */

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values the (SI) values to store
     * @param scale the scale of the unit to use for conversion to SI
     * @param storageType the data type to use
     * @return the DoubleVectorData with the right data type
     * @throws ValueException when values are null, or storageType is null
     */
    public static DoubleVectorData instantiate(final double[] values, final Scale scale, final StorageType storageType)
        throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleVectorData.instantiate: double[] values is null");
        }

        double[] valuesSI = new double[values.length];
        IntStream.range(0, values.length).parallel().forEach(i -> valuesSI[i] = scale.toStandardUnit(values[i]));

        switch (storageType)
        {
            case DENSE:
                return new DoubleVectorDataDense(valuesSI);

            case SPARSE:
                return DoubleVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values the values to store
     * @param scale the scale of the unit to use for conversion to SI
     * @param storageType the data type to use
     * @return the DoubleVectorData with the right data type
     * @throws ValueException when list is null, or storageType is null
     */
    public static DoubleVectorData instantiate(final List<Double> values, final Scale scale, final StorageType storageType)
        throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleVectorData.instantiate: List<Double> values is null");
        }

        switch (storageType)
        {
            case DENSE:
                return new DoubleVectorDataDense(values.parallelStream().mapToDouble(d -> scale.toStandardUnit(d))
                    .toArray());

            case SPARSE:
                return DoubleVectorDataSparse.instantiate(values.parallelStream().mapToDouble(
                    d -> scale.toStandardUnit(d)).toArray());

            default:
                throw new ValueException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values the values to store
     * @param storageType the data type to use
     * @return the DoubleVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static DoubleVectorData instantiate(final DoubleScalar<?>[] values, final StorageType storageType)
        throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleVectorData.instantiate: DoubleScalar[] values is null");
        }

        double[] valuesSI = Arrays.stream(values).parallel().mapToDouble(s -> s.getSI()).toArray();

        switch (storageType)
        {
            case DENSE:
                return new DoubleVectorDataDense(valuesSI);

            case SPARSE:
                return DoubleVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values the DoubleScalar values to store
     * @param storageType the data type to use
     * @return the DoubleVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static DoubleVectorData instantiateLD(final List<? extends DoubleScalar<?>> values, final StorageType storageType)
        throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleVectorData.instantiate: values list is null");
        }

        double[] valuesSI = values.parallelStream().mapToDouble(s -> s.getSI()).toArray();

        switch (storageType)
        {
            case DENSE:
                return new DoubleVectorDataDense(valuesSI);

            case SPARSE:
                return DoubleVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values the DoubleScalar values to store
     * @param length the length of the vector to pad with 0 after last entry in map
     * @param storageType the data type to use
     * @param <S> the scalar type to use
     * @return the DoubleVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static <S extends DoubleScalar<?>> DoubleVectorData instantiateMD(final SortedMap<Integer, S> values,
        final int length, final StorageType storageType) throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleVectorData.instantiate: values map is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI =
                    values.keySet().parallelStream().mapToDouble(index -> values.get(index).getSI()).toArray();
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int[] indices = values.keySet().parallelStream().mapToInt(i -> i).toArray();
                double[] valuesSI = values.values().parallelStream().mapToDouble(s -> s.getSI()).toArray();
                return new DoubleVectorDataSparse(valuesSI, indices, length);
            }

            default:
                throw new ValueException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleVectorData with the right data type.
     * @param values the DoubleScalar values to store
     * @param length the length of the vector to pad with 0 after last entry in map
     * @param scale the scale of the unit to use for conversion to SI
     * @param storageType the data type to use
     * @return the DoubleVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static DoubleVectorData instantiate(final SortedMap<Integer, Double> values, final int length,
        final Scale scale, final StorageType storageType) throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleVectorData.instantiate: values map is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI =
                    values.keySet().parallelStream().mapToDouble(index -> scale.toStandardUnit(values.get(index)))
                        .toArray();
                return new DoubleVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int[] indices = values.keySet().parallelStream().mapToInt(i -> i).toArray();
                double[] valuesSI =
                    values.values().parallelStream().mapToDouble(d -> scale.toStandardUnit(d)).toArray();
                return new DoubleVectorDataSparse(valuesSI, indices, length);
            }

            default:
                throw new ValueException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /** ============================================================================================ */
    /** ==================================== UTILITY FUNCTIONS ===================================== */
    /** ============================================================================================ */

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Vector.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Vector
     */
    public final StorageType getStorageType()
    {
        return this.storageType;
    }

    /**
     * @return the size of the vector
     */
    public abstract int size();

    /**
     * @return whether data type is sparse.
     */
    public boolean isSparse()
    {
        return this.storageType.equals(StorageType.SPARSE);
    }

    /**
     * @return the sparse transformation of this data
     */
    public DoubleVectorDataSparse toSparse()
    {
        return isSparse() ? (DoubleVectorDataSparse) this : ((DoubleVectorDataDense) this).toSparse();
    }

    /**
     * @return whether data type is dense.
     */
    public boolean isDense()
    {
        return this.storageType.equals(StorageType.DENSE);
    }

    /**
     * @return the dense transformation of this data
     */
    public DoubleVectorDataDense toDense()
    {
        return isDense() ? (DoubleVectorDataDense) this : ((DoubleVectorDataSparse) this).toDense();
    }

    /**
     * @param index the index to get the value for
     * @return the value at the index
     */
    public abstract double getSI(final int index);

    /**
     * Sets a value at the index in the vector.
     * @param index the index to set the value for
     * @param valueSI the value at the index
     */
    public abstract void setSI(final int index, final double valueSI);

    /**
     * @return the number of non-zero cells.
     */
    public final int cardinality()
    {
        return (int) Arrays.stream(this.vectorSI).parallel().filter(d -> d != 0.0).count();
    }

    /**
     * @return the sum of the values of all cells.
     */
    public final double zSum()
    {
        return Arrays.stream(this.vectorSI).parallel().sum();
    }

    /**
     * @return a deep copy of the data.
     */
    public abstract DoubleVectorData copy();

    /**
     * @return a safe copy of VectorSI
     */
    public abstract double[] getDenseVectorSI();

    /**
     * Check the sizes of this data object and the other data object.
     * @param other the other data object
     * @throws ValueException if vectors have different lengths
     */
    private void checkSizes(final DoubleVectorData other) throws ValueException
    {
        if (this.size() != other.size())
        {
            throw new ValueException("Two data objects used in a DoubleVector operation do not have the same size");
        }
    }

    /** ============================================================================================ */
    /** ================================== CALCULATION FUNCTIONS =================================== */
    /** ============================================================================================ */

    /**
     * Add two vectors on a cell-by-cell basis. If both vectors are sparse, a sparse vector is returned, otherwise a dense
     * vector is returned.
     * @param right the other data object to add
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public DoubleVectorData plus(final DoubleVectorData right) throws ValueException
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
     * @param right the other data object to add
     * @throws ValueException if vectors have different lengths
     */
    public abstract void incrementBy(final DoubleVectorData right) throws ValueException;

    /**
     * Add a number to this vector on a cell-by-cell basis.
     * @param valueSI the value to add
     */
    public void incrementBy(final double valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] += valueSI);
    }

    /**
     * Subtract two vectors on a cell-by-cell basis. If both vectors are sparse, a sparse vector is returned, otherwise a dense
     * vector is returned.
     * @param right the other data object to subtract
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public DoubleVectorData minus(final DoubleVectorData right) throws ValueException
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
     * @param right the other data object to subtract
     * @throws ValueException if vectors have different lengths
     */
    public abstract void decrementBy(final DoubleVectorData right) throws ValueException;

    /**
     * Subtract a number from this vector on a cell-by-cell basis.
     * @param valueSI the value to subtract
     */
    public void decrementBy(final double valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] -= valueSI);
    }

    /**
     * Multiply two vector on a cell-by-cell basis. If both vectors are dense, a dense vector is returned, otherwise a sparse
     * vector is returned.
     * @param right the other data object to multiply with
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public DoubleVectorData times(final DoubleVectorData right) throws ValueException
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
     * @param right the other data object to multiply with
     * @throws ValueException if vectors have different lengths
     */
    public abstract void multiplyBy(final DoubleVectorData right) throws ValueException;

    /**
     * Multiply the values of this vector with a number on a cell-by-cell basis.
     * @param valueSI the value to multiply with
     */
    public void multiplyBy(final double valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] *= valueSI);
    }

    /**
     * Divide two vectors on a cell-by-cell basis. If both vectors are dense, a dense vector is returned, otherwise a sparse
     * vector is returned.
     * @param right the other data object to divide by
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public DoubleVectorData divide(final DoubleVectorData right) throws ValueException
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
     * @param right the other data object to divide by
     * @throws ValueException if vectors have different lengths
     */
    public abstract void divideBy(final DoubleVectorData right) throws ValueException;

    /**
     * Divide the values of this vector by a number on a cell-by-cell basis.
     * @param valueSI the value to multiply with
     */
    public void divideBy(final double valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] /= valueSI);
    }

    /** ============================================================================================ */
    /** =============================== EQUALS, HASHCODE, TOSTRING ================================= */
    /** ============================================================================================ */

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
