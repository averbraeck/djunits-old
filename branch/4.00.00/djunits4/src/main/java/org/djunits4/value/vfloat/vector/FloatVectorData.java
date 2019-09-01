package org.djunits4.value.vfloat.vector;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.IntStream;

import org.djunits4.unit.scale.Scale;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatScalarInterface;

/**
 * Stores the data for a FloatVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
abstract class FloatVectorData implements Serializable
{
    /** */
    private static final long serialVersionUID = 1L;

    /** the internal storage of the Vector; can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected float[] vectorSI;

    /** the data type. */
    private final StorageType storageType;

    /**
     * @param storageType StorageType; the data type.
     */
    FloatVectorData(final StorageType storageType)
    {
        super();
        this.storageType = storageType;
    }

    /** ============================================================================================ */
    /** ====================================== INSTANTIATION ======================================= */
    /** ============================================================================================ */

    /**
     * Instantiate a FloatVectorData with the right data type.
     * @param values float[]; the (SI) values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return the FloatVectorData with the right data type
     * @throws ValueException when values are null, or storageType is null
     */
    public static FloatVectorData instantiate(final float[] values, final Scale scale, final StorageType storageType)
            throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatVectorData.instantiate: float[] values is null");
        }

        float[] valuesSI = new float[values.length];
        IntStream.range(0, values.length).parallel().forEach(i -> valuesSI[i] = (float) scale.toStandardUnit(values[i]));

        switch (storageType)
        {
            case DENSE:
                return new FloatVectorDataDense(valuesSI);

            case SPARSE:
                return FloatVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatVectorData with the right data type.
     * @param values List&lt;Float&gt;; the values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return the FloatVectorData with the right data type
     * @throws ValueException when list is null, or storageType is null
     */
    public static FloatVectorData instantiate(final List<Float> values, final Scale scale, final StorageType storageType)
            throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatVectorData.instantiate: List<Float> values is null");
        }

        float[] valuesSI = new float[values.size()];
        IntStream.range(0, values.size()).parallel().forEach(i -> valuesSI[i] = (float) scale.toStandardUnit(values.get(i)));

        switch (storageType)
        {
            case DENSE:
                return new FloatVectorDataDense(valuesSI);

            case SPARSE:
                return FloatVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatVectorData with the right data type.
     * @param values FloatScalarInterface[]; the values to store
     * @param storageType StorageType; the data type to use
     * @return the FloatVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static FloatVectorData instantiate(final FloatScalarInterface[] values, final StorageType storageType)
            throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatVectorData.instantiate: FloatScalar[] values is null");
        }

        float[] valuesSI = new float[values.length];
        IntStream.range(0, values.length).parallel().forEach(i -> valuesSI[i] = values[i].getSI());

        switch (storageType)
        {
            case DENSE:
                return new FloatVectorDataDense(valuesSI);

            case SPARSE:
                return FloatVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatVectorData with the right data type.
     * @param values List&lt;? extends FloatScalarInterface&gt;; the FloatScalar values to store
     * @param storageType StorageType; the data type to use
     * @return the FloatVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static FloatVectorData instantiateLD(final List<? extends FloatScalarInterface> values,
            final StorageType storageType) throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatVectorData.instantiate: values list is null");
        }

        float[] valuesSI = new float[values.size()];
        IntStream.range(0, values.size()).parallel().forEach(i -> valuesSI[i] = values.get(i).getSI());

        switch (storageType)
        {
            case DENSE:
                return new FloatVectorDataDense(valuesSI);

            case SPARSE:
                return FloatVectorDataSparse.instantiate(valuesSI);

            default:
                throw new ValueException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatVectorData with the right data type.
     * @param values SortedMap&lt;Integer,S&gt;; the FloatScalar values to store
     * @param length int; the length of the vector to pad with 0 after last entry in map
     * @param storageType StorageType; the data type to use
     * @param <S> the scalar type to use
     * @return the FloatVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static <S extends FloatScalarInterface> FloatVectorData instantiateMD(final SortedMap<Integer, S> values,
            final int length, final StorageType storageType) throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatVectorData.instantiate: values map is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                float[] valuesSI = new float[length];
                values.keySet().parallelStream().forEach(index -> valuesSI[index] = values.get(index).getSI());
                return new FloatVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int[] indices = values.keySet().parallelStream().mapToInt(i -> i).toArray();
                float[] valuesSI = new float[values.size()];
                IntStream.range(0, values.size()).parallel()
                        .forEach(index -> valuesSI[index] = values.get(indices[index]).getSI());
                return new FloatVectorDataSparse(valuesSI, indices, length);
            }

            default:
                throw new ValueException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatVectorData with the right data type.
     * @param values SortedMap&lt;Integer,Float&gt;; the FloatScalar values to store
     * @param length int; the length of the vector to pad with 0 after last entry in map
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return the FloatVectorData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static FloatVectorData instantiate(final SortedMap<Integer, Float> values, final int length, final Scale scale,
            final StorageType storageType) throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatVectorData.instantiate: values map is null");
        }

        switch (storageType)
        {
            case DENSE:
            {
                float[] valuesSI = new float[length];
                values.keySet().parallelStream()
                        .forEach(index -> valuesSI[index] = (float) scale.toStandardUnit(values.get(index)));
                return new FloatVectorDataDense(valuesSI);
            }

            case SPARSE:
            {
                int[] indices = values.keySet().parallelStream().mapToInt(i -> i).toArray();
                float[] valuesSI = new float[values.size()];
                IntStream.range(0, values.size()).parallel()
                        .forEach(index -> valuesSI[index] = (float) scale.toStandardUnit(values.get(indices[index])));
                return new FloatVectorDataSparse(valuesSI, indices, length);
            }

            default:
                throw new ValueException("Unknown data type in FloatVectorData.instantiate: " + storageType);
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
    public FloatVectorDataSparse toSparse()
    {
        return isSparse() ? (FloatVectorDataSparse) this : ((FloatVectorDataDense) this).toSparse();
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
    public FloatVectorDataDense toDense()
    {
        return isDense() ? (FloatVectorDataDense) this : ((FloatVectorDataSparse) this).toDense();
    }

    /**
     * @param index int; the index to get the value for
     * @return the value at the index
     */
    public abstract float getSI(int index);

    /**
     * Sets a value at the index in the vector.
     * @param index int; the index to set the value for
     * @param valueSI float; the value at the index
     */
    public abstract void setSI(int index, float valueSI);

    /**
     * @return the number of non-zero cells.
     */
    public final int cardinality()
    {
        // this does not copy the data. See http://stackoverflow.com/questions/23106093/how-to-get-a-stream-from-a-float
        return (int) IntStream.range(0, this.vectorSI.length).parallel().mapToDouble(i -> this.vectorSI[i])
                .filter(d -> d != 0.0).count();
    }

    /**
     * @return the sum of the values of all cells.
     */
    public final float zSum()
    {
        // this does not copy the data. See http://stackoverflow.com/questions/23106093/how-to-get-a-stream-from-a-float
        return (float) IntStream.range(0, this.vectorSI.length).parallel().mapToDouble(i -> this.vectorSI[i]).sum();
    }

    /**
     * @return a deep copy of the data.
     */
    public abstract FloatVectorData copy();

    /**
     * @return a safe copy of VectorSI
     */
    public abstract float[] getDenseVectorSI();

    /**
     * Check the sizes of this data object and the other data object.
     * @param other FloatVectorData; the other data object
     * @throws ValueException if vectors have different lengths
     */
    private void checkSizes(final FloatVectorData other) throws ValueException
    {
        if (this.size() != other.size())
        {
            throw new ValueException("Two data objects used in a FloatVector operation do not have the same size");
        }
    }

    /** ============================================================================================ */
    /** ================================== CALCULATION FUNCTIONS =================================== */
    /** ============================================================================================ */

    /**
     * Add two vectors on a cell-by-cell basis. If both vectors are sparse, a sparse vector is returned, otherwise a dense
     * vector is returned.
     * @param right FloatVectorData; the other data object to add
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public FloatVectorData plus(final FloatVectorData right) throws ValueException
    {
        checkSizes(right);
        float[] dv = new float[size()];
        // TODO this may cause an out of memory condition even though the result fits easily in available memory
        IntStream.range(0, size()).parallel().forEach(i -> dv[i] = getSI(i) + right.getSI(i));
        if (this instanceof FloatVectorDataSparse && right instanceof FloatVectorDataSparse)
        {
            return new FloatVectorDataDense(dv).toSparse();
        }
        return new FloatVectorDataDense(dv);
    }

    /**
     * Add a vector to this vector on a cell-by-cell basis. The type of vector (sparse, dense) stays the same.
     * @param right FloatVectorData; the other data object to add
     * @throws ValueException if vectors have different lengths
     */
    public abstract void incrementBy(FloatVectorData right) throws ValueException;

    /**
     * Add a number to this vector on a cell-by-cell basis.
     * @param valueSI float; the value to add
     */
    public abstract void incrementBy(float valueSI);

    /**
     * Subtract two vectors on a cell-by-cell basis. If both vectors are sparse, a sparse vector is returned, otherwise a dense
     * vector is returned.
     * @param right FloatVectorData; the other data object to subtract
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public FloatVectorData minus(final FloatVectorData right) throws ValueException
    {
        checkSizes(right);
        float[] dv = new float[size()];
        IntStream.range(0, size()).parallel().forEach(i -> dv[i] = getSI(i) - right.getSI(i));
        if (this instanceof FloatVectorDataSparse && right instanceof FloatVectorDataSparse)
        {
            return new FloatVectorDataDense(dv).toSparse();
        }
        return new FloatVectorDataDense(dv);
    }

    /**
     * Subtract a vector from this vector on a cell-by-cell basis. The type of vector (sparse, dense) stays the same.
     * @param right FloatVectorData; the other data object to subtract
     * @throws ValueException if vectors have different lengths
     */
    public abstract void decrementBy(FloatVectorData right) throws ValueException;

    /**
     * Subtract a number from this vector on a cell-by-cell basis.
     * @param valueSI float; the value to subtract
     */
    public abstract void decrementBy(float valueSI);

    /**
     * Multiply two vector on a cell-by-cell basis. If both vectors are dense, a dense vector is returned, otherwise a sparse
     * vector is returned.
     * @param right FloatVectorData; the other data object to multiply with
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public FloatVectorData times(final FloatVectorData right) throws ValueException
    {
        checkSizes(right);
        float[] dv = new float[size()];
        IntStream.range(0, size()).parallel().forEach(i -> dv[i] = getSI(i) * right.getSI(i));
        if (this instanceof FloatVectorDataDense && right instanceof FloatVectorDataDense)
        {
            return new FloatVectorDataDense(dv);
        }
        return new FloatVectorDataDense(dv).toSparse();
    }

    /**
     * Multiply a vector with the values of another vector on a cell-by-cell basis. The type of vector (sparse, dense) stays the
     * same.
     * @param right FloatVectorData; the other data object to multiply with
     * @throws ValueException if vectors have different lengths
     */
    public abstract void multiplyBy(FloatVectorData right) throws ValueException;

    /**
     * Multiply the values of this vector with a number on a cell-by-cell basis.
     * @param valueSI float; the value to multiply with
     */
    public abstract void multiplyBy(float valueSI);

    /**
     * Divide two vectors on a cell-by-cell basis. If both vectors are dense, a dense vector is returned, otherwise a sparse
     * vector is returned.
     * @param right FloatVectorData; the other data object to divide by
     * @return the sum of this data object and the other data object
     * @throws ValueException if vectors have different lengths
     */
    public FloatVectorData divide(final FloatVectorData right) throws ValueException
    {
        checkSizes(right);
        float[] dv = new float[size()];
        IntStream.range(0, size()).parallel().forEach(i -> dv[i] = getSI(i) / right.getSI(i));
        if (this instanceof FloatVectorDataDense && right instanceof FloatVectorDataDense)
        {
            return new FloatVectorDataDense(dv);
        }
        return new FloatVectorDataDense(dv).toSparse();
    }

    /**
     * Divide the values of a vector by the values of another vector on a cell-by-cell basis. The type of vector (sparse, dense)
     * stays the same.
     * @param right FloatVectorData; the other data object to divide by
     * @throws ValueException if vectors have different lengths
     */
    public abstract void divideBy(FloatVectorData right) throws ValueException;

    /**
     * Divide the values of this vector by a number on a cell-by-cell basis.
     * @param valueSI float; the value to multiply with
     */
    public abstract void divideBy(float valueSI);

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
        FloatVectorData other = (FloatVectorData) obj;
        if (!Arrays.equals(this.vectorSI, other.vectorSI))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "FloatVectorData [storageType=" + this.storageType + ", vectorSI=" + Arrays.toString(this.vectorSI) + "]";
    }
}
