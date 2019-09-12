package org.djunits4.value.vfloat.vector.data;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;

/**
 * Stores sparse data for a FloatVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatVectorDataSparse extends FloatVectorData
{
    /** */
    private static final long serialVersionUID = 1L;

    /** The index values of the Vector. */
    private int[] indices;

    /** The length of the vector (padded with 0 after highest index in indices). */
    private final int size;

    /**
     * Create a vector with sparse data.
     * @param vectorSI float[]; the data to store
     * @param indices int[]; the index values of the Vector
     * @param size int; the length of the vector (padded with 0 after highest index in indices)
     */
    public FloatVectorDataSparse(final float[] vectorSI, final int[] indices, final int size)
    {
        super(StorageType.SPARSE);
        this.vectorSI = vectorSI;
        this.indices = indices;
        this.size = size;
    }

    /** {@inheritDoc} */
    @Override
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
        // System.out.println("arraycopy1 current size is " + this.indices.length + " srcPos=" + internalIndex +
        // ", new size is "
        // + indicesNew.length + " dstPos=" + (internalIndex + 1) + " length=" + (this.indices.length - internalIndex));
        System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex + 1, this.indices.length - internalIndex);
        System.arraycopy(this.vectorSI, internalIndex, vectorSINew, internalIndex + 1, this.indices.length - internalIndex);
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
     * @param valuesSI float[]; the (SI) values to store
     * @return the FloatVectorDataSparse
     */
    public static FloatVectorDataSparse instantiate(final float[] valuesSI)
    {
        // determine number of non-null cells
        int length = (int) IntStream.range(0, valuesSI.length).parallel().mapToDouble(i -> valuesSI[i]).filter(f -> f != 0.0f)
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
    public final void incrementBy(final FloatVectorData right) throws ValueRuntimeException
    {
        int maxLength =
                (right.isSparse() ? this.indices.length + ((FloatVectorDataSparse) right).indices.length : right.size());
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        if (right.isSparse())
        {
            int ownIndex = 0;
            int rightIndex = 0;
            FloatVectorDataSparse rightData = (FloatVectorDataSparse) right;
            while (ownIndex < this.indices.length || rightIndex < rightData.indices.length)
            {
                float value;
                int index;
                if (ownIndex < this.indices.length && rightIndex < rightData.indices.length)
                { // neither we nor right has run out of values
                    if (this.indices[ownIndex] == rightData.indices[rightIndex])
                    {
                        value = this.vectorSI[ownIndex] + rightData.vectorSI[rightIndex];
                        index = this.indices[ownIndex];
                        ownIndex++;
                        rightIndex++;
                    }
                    else if (this.indices[ownIndex] < rightData.indices[rightIndex])
                    {
                        value = this.vectorSI[ownIndex];
                        index = this.indices[ownIndex];
                        ownIndex++;
                    }
                    else
                    {
                        value = rightData.vectorSI[rightIndex];
                        index = rightData.indices[rightIndex];
                        rightIndex++;
                    }
                }
                else if (ownIndex < this.indices.length)
                { // right has run out of values; we have not
                    value = this.vectorSI[ownIndex];
                    index = this.indices[ownIndex];
                    ownIndex++;
                }
                else
                { // we have run out of values; right has not
                    value = rightData.vectorSI[rightIndex];
                    index = rightData.indices[rightIndex];
                    rightIndex++;
                }
                if (value != 0f)
                {
                    tempIndices[nextIndex] = index;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        else
        {
            int ownIndex = 0;
            for (int i = 0; i < right.size(); i++)
            {
                if (ownIndex < this.indices.length && i > this.indices[ownIndex])
                {
                    ownIndex++;
                }
                float value = (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f)
                        + right.getSI(i);
                if (value != 0f)
                {
                    tempIndices[nextIndex] = i;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final float valueSI)
    {
        int maxLength = size();
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        int ownIndex = 0;
        for (int i = 0; i < size(); i++)
        {
            if (ownIndex < this.indices.length && i > this.indices[ownIndex])
            {
                ownIndex++;
            }
            float value =
                    (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f) + valueSI;
            if (value != 0f)
            {
                tempIndices[nextIndex] = i;
                tempVectorSI[nextIndex] = value;
                nextIndex++;
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final FloatVectorData right) throws ValueRuntimeException
    {
        int maxLength =
                (right.isSparse() ? this.indices.length + ((FloatVectorDataSparse) right).indices.length : right.size());
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        if (right.isSparse())
        {
            int ownIndex = 0;
            int rightIndex = 0;
            FloatVectorDataSparse rightData = (FloatVectorDataSparse) right;
            while (ownIndex < this.indices.length || rightIndex < rightData.indices.length)
            {
                float value;
                int index;
                if (ownIndex < this.indices.length && rightIndex < rightData.indices.length)
                { // neither we nor right has run out of values
                    if (this.indices[ownIndex] == rightData.indices[rightIndex])
                    {
                        value = this.vectorSI[ownIndex] - rightData.vectorSI[rightIndex];
                        index = this.indices[ownIndex];
                        ownIndex++;
                        rightIndex++;
                    }
                    else if (this.indices[ownIndex] < rightData.indices[rightIndex])
                    {
                        value = this.vectorSI[ownIndex];
                        index = this.indices[ownIndex];
                        ownIndex++;
                    }
                    else
                    {
                        value = 0f - rightData.vectorSI[rightIndex];
                        index = rightData.indices[rightIndex];
                        rightIndex++;
                    }
                }
                else if (ownIndex < this.indices.length)
                { // right has run out of values; we have not
                    value = this.vectorSI[ownIndex];
                    index = this.indices[ownIndex];
                    ownIndex++;
                }
                else
                { // we have run out of values; right has not
                    value = 0f - rightData.vectorSI[rightIndex];
                    index = rightData.indices[rightIndex];
                    rightIndex++;
                }
                if (value != 0f)
                {
                    tempIndices[nextIndex] = index;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        else
        {
            int ownIndex = 0;
            for (int i = 0; i < right.size(); i++)
            {
                if (ownIndex < this.indices.length && i > this.indices[ownIndex])
                {
                    ownIndex++;
                }
                float value = (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f)
                        - right.getSI(i);
                if (value != 0f)
                {
                    tempIndices[nextIndex] = i;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final float valueSI)
    {
        int maxLength = size();
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        int ownIndex = 0;
        for (int i = 0; i < size(); i++)
        {
            if (ownIndex < this.indices.length && i > this.indices[ownIndex])
            {
                ownIndex++;
            }
            float value =
                    (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f) - valueSI;
            if (value != 0f)
            {
                tempIndices[nextIndex] = i;
                tempVectorSI[nextIndex] = value;
                nextIndex++;
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final FloatVectorData right) throws ValueRuntimeException
    {
        int maxLength =
                (right.isSparse() ? this.indices.length + ((FloatVectorDataSparse) right).indices.length : right.size());
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        if (right.isSparse())
        {
            int ownIndex = 0;
            int rightIndex = 0;
            FloatVectorDataSparse rightData = (FloatVectorDataSparse) right;
            while (ownIndex < this.indices.length || rightIndex < rightData.indices.length)
            {
                float value = 0f;
                int index = -1;
                if (ownIndex < this.indices.length && rightIndex < rightData.indices.length)
                { // neither we nor right has run out of values
                    if (this.indices[ownIndex] == rightData.indices[rightIndex])
                    {
                        value = this.vectorSI[ownIndex] * rightData.vectorSI[rightIndex];
                        index = this.indices[ownIndex];
                        ownIndex++;
                        rightIndex++;
                    }
                    else if (this.indices[ownIndex] < rightData.indices[rightIndex])
                    {
                        if (Float.isNaN(this.vectorSI[ownIndex]))
                        {
                            value = Float.NaN;
                            index = this.indices[ownIndex];
                        }
                        ownIndex++;
                    }
                    else if (this.indices[ownIndex] > rightData.indices[rightIndex])
                    {
                        if (Float.isNaN(rightData.vectorSI[rightIndex]))
                        {
                            value = Float.NaN;
                            index = rightData.indices[rightIndex];
                        }
                        rightIndex++;
                    }
                }
                else if (ownIndex < this.indices.length)
                { // right has run out of values; we have not
                    if (Float.isNaN(this.vectorSI[ownIndex]))
                    {
                        value = Float.NaN;
                        index = this.indices[ownIndex];
                    }
                    ownIndex++;
                }
                else
                { // we have run out of values; right has not
                    if (Float.isNaN(rightData.vectorSI[rightIndex]))
                    {
                        value = Float.NaN;
                        index = rightData.indices[rightIndex];
                    }
                    rightIndex++;
                }
                if (value != 0f)
                {
                    tempIndices[nextIndex] = index;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        else
        {
            int ownIndex = 0;
            for (int i = 0; i < right.size(); i++)
            {
                if (ownIndex < this.indices.length && i > this.indices[ownIndex])
                {
                    ownIndex++;
                }
                float value = (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f)
                        * right.getSI(i);
                if (value != 0f)
                {
                    tempIndices[nextIndex] = i;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final float valueSI)
    {
        int maxLength = size();
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        int ownIndex = 0;
        for (int i = 0; i < size(); i++)
        {
            if (ownIndex < this.indices.length && i > this.indices[ownIndex])
            {
                ownIndex++;
            }
            float value =
                    (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f) * valueSI;
            if (value != 0f)
            {
                tempIndices[nextIndex] = i;
                tempVectorSI[nextIndex] = value;
                nextIndex++;
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final FloatVectorData right) throws ValueRuntimeException
    {
        int maxLength = size();
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        if (right.isSparse())
        {
            int ownIndex = 0;
            int rightIndex = 0;
            FloatVectorDataSparse rightData = (FloatVectorDataSparse) right;
            for (int index = 0; index < size(); index++)
            {
                float value = Float.NaN;
                if (ownIndex < this.indices.length && rightIndex < rightData.indices.length)
                { // neither we nor right has run out of values
                    if (this.indices[ownIndex] == index && rightData.indices[rightIndex] == index)
                    {
                        value = this.vectorSI[ownIndex] / rightData.vectorSI[rightIndex];
                        ownIndex++;
                        rightIndex++;
                    }
                    else if (this.indices[ownIndex] == index)
                    {
                        value = this.vectorSI[ownIndex] / 0f;
                        ownIndex++;
                    }
                    else if (rightData.indices[rightIndex] == index)
                    {
                        value = 0f / rightData.vectorSI[rightIndex];
                        rightIndex++;
                    }
                }
                else if (ownIndex < this.indices.length)
                { // right has run out of values; we have not
                    value = (this.indices[ownIndex] == index ? this.vectorSI[ownIndex] : 0f) / 0f;
                    ownIndex++;
                }
                else
                { // we have run out of values; right has not
                    value = 0f / rightData.vectorSI[rightIndex];
                    rightIndex++;
                }
                if (value != 0f)
                {
                    tempIndices[nextIndex] = index;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        else
        {
            int ownIndex = 0;
            for (int i = 0; i < right.size(); i++)
            {
                if (ownIndex < this.indices.length && i > this.indices[ownIndex])
                {
                    ownIndex++;
                }
                float value = (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f)
                        / right.getSI(i);
                if (value != 0f)
                {
                    tempIndices[nextIndex] = i;
                    tempVectorSI[nextIndex] = value;
                    nextIndex++;
                }
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final float valueSI)
    {
        int maxLength = size();
        float[] tempVectorSI = new float[maxLength];
        int[] tempIndices = new int[maxLength];
        int nextIndex = 0;
        int ownIndex = 0;
        for (int i = 0; i < size(); i++)
        {
            if (ownIndex < this.indices.length && i > this.indices[ownIndex])
            {
                ownIndex++;
            }
            float value =
                    (ownIndex < this.indices.length && i == this.indices[ownIndex] ? this.vectorSI[ownIndex] : 0f) / valueSI;
            if (value != 0f)
            {
                tempIndices[nextIndex] = i;
                tempVectorSI[nextIndex] = value;
                nextIndex++;
            }
        }
        this.indices = Arrays.copyOf(tempIndices, nextIndex);
        this.vectorSI = Arrays.copyOf(tempVectorSI, nextIndex);
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
