package org.djunits.value.vfloat.vector;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.djunits.value.StorageType;
import org.djunits.value.ValueException;

/**
 * Stores sparse data for a FloatVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatVectorDataSparse extends FloatVectorData
{
    /** the index values of the Vector. */
    private int[] indices;

    /** the length of the vector (padded with 0 after highest index in indices). */
    private final int size;

    /**
     * Create a vector with sparse data.
     * @param vectorSI the data to store
     * @param indices the index values of the Vector
     * @param size the length of the vector (padded with 0 after highest index in indices)
     */
    public FloatVectorDataSparse(final float[] vectorSI, final int[] indices, final int size)
    {
        super(StorageType.SPARSE);
        this.vectorSI = vectorSI;
        this.indices = indices;
        this.size = size;
    }

    /**
     * @return a dense variant of the data.
     */
    public final FloatVectorDataDense toDense()
    {
        float[] denseSI = new float[this.size];
        for (int index = 0; index < this.vectorSI.length; index++)
        {
            denseSI[this.indices[index]] = this.vectorSI[index];
        }
        return new FloatVectorDataDense(denseSI);
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.size;
    }

    /** {@inheritDoc} */
    @Override
    public final float getSI(final int index)
    {
        int internalIndex = Arrays.binarySearch(this.indices, index);
        return internalIndex < 0 ? 0.0f : this.vectorSI[internalIndex];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int index, final float valueSI)
    {
        int internalIndex = Arrays.binarySearch(this.indices, index);
        if (internalIndex >= 0)
        {
            this.vectorSI[internalIndex] = valueSI;
            return;
        }

        // make room. TODO increase size in chunks
        internalIndex = -internalIndex - 1;
        int[] indicesNew = new int[this.indices.length + 1];
        float[] vectorSINew = new float[this.vectorSI.length + 1];
        System.arraycopy(this.indices, 0, indicesNew, 0, internalIndex);
        System.arraycopy(this.vectorSI, 0, vectorSINew, 0, internalIndex);
        System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex - 1, this.indices.length
            - internalIndex);
        System.arraycopy(this.vectorSI, internalIndex, vectorSINew, internalIndex - 1, this.indices.length
            - internalIndex);
        indicesNew[internalIndex] = index;
        vectorSINew[internalIndex] = valueSI;
        this.indices = indicesNew;
        this.vectorSI = vectorSINew;
    }

    /** {@inheritDoc} */
    @Override
    public final float[] getDenseVectorSI()
    {
        return toDense().vectorSI;
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVectorDataSparse copy()
    {
        float[] vCopy = new float[this.vectorSI.length];
        System.arraycopy(this.vectorSI, 0, vCopy, 0, this.vectorSI.length);
        int[] iCopy = new int[this.indices.length];
        System.arraycopy(this.indices, 0, iCopy, 0, this.indices.length);
        return new FloatVectorDataSparse(vCopy, iCopy, this.size);
    }

    /**
     * Instantiate a FloatVectorDataSparse from an array.
     * @param valuesSI the (SI) values to store
     * @return the FloatVectorDataSparse
     */
    public static FloatVectorDataSparse instantiate(final float[] valuesSI)
    {
        // determine number of non-null cells
        int length =
            (int) IntStream.range(0, valuesSI.length).parallel().mapToDouble(i -> valuesSI[i]).filter(f -> f != 0.0f)
                .count();
        float[] sparseSI = new float[length];
        int[] indices = new int[length];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int i = 0; i < valuesSI.length; i++)
        {
            if (valuesSI[i] != 0.0)
            {
                sparseSI[count] = valuesSI[i];
                indices[count] = i;
                count++;
            }
        }
        return new FloatVectorDataSparse(sparseSI, indices, valuesSI.length);
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final FloatVectorData right) throws ValueException
    {
        int newLength =
            (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 || right.getSI(i) != 0.0)
                .count();
        float[] newVectorSI = new float[newLength];
        int[] newIndices = new int[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        // note: if adding -2 and +2, a 0-value will be part of the new sparse matrix.
        int count = 0;
        for (int i = 0; i < size(); i++)
        {
            if (this.getSI(i) != 0.0 || right.getSI(i) != 0.0)
            {
                newVectorSI[count] = getSI(i) + right.getSI(i);
                newIndices[count] = i;
                count++;
            }
        }

        this.indices = newIndices;
        this.vectorSI = newVectorSI;
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final FloatVectorData right) throws ValueException
    {
        int newLength =
            (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 || right.getSI(i) != 0.0)
                .count();
        float[] newVectorSI = new float[newLength];
        int[] newIndices = new int[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        // note: if subtracting 2 from 2, a 0-value will be part of the new sparse matrix.
        int count = 0;
        for (int i = 0; i < size(); i++)
        {
            if (this.getSI(i) != 0.0 || right.getSI(i) != 0.0)
            {
                newVectorSI[count] = getSI(i) - right.getSI(i);
                newIndices[count] = i;
                count++;
            }
        }

        this.indices = newIndices;
        this.vectorSI = newVectorSI;
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final FloatVectorData right) throws ValueException
    {
        int newLength =
            (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 && right.getSI(i) != 0.0)
                .count();
        float[] newVectorSI = new float[newLength];
        int[] newIndices = new int[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int i = 0; i < size(); i++)
        {
            if (this.getSI(i) != 0.0 && right.getSI(i) != 0.0)
            {
                newVectorSI[count] = getSI(i) * right.getSI(i);
                newIndices[count] = i;
                count++;
            }
        }

        this.indices = newIndices;
        this.vectorSI = newVectorSI;
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final FloatVectorData right) throws ValueException
    {
        int newLength =
            (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 && right.getSI(i) != 0.0)
                .count();
        float[] newVectorSI = new float[newLength];
        int[] newIndices = new int[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int i = 0; i < size(); i++)
        {
            if (this.getSI(i) != 0.0 && right.getSI(i) != 0.0)
            {
                newVectorSI[count] = getSI(i) / right.getSI(i);
                newIndices[count] = i;
                count++;
            }
        }

        this.indices = newIndices;
        this.vectorSI = newVectorSI;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(this.indices);
        result = prime * result + this.size;
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings({"checkstyle:needbraces", "checkstyle:designforextension"})
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FloatVectorDataSparse other = (FloatVectorDataSparse) obj;
        if (!Arrays.equals(this.indices, other.indices))
            return false;
        if (this.size != other.size)
            return false;
        return true;
    }
}
