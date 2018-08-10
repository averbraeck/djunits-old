package org.djunits.value.vdouble.vector;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.djunits.value.StorageType;
import org.djunits.value.ValueException;

/**
 * Stores sparse data for a DoubleVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DoubleVectorDataSparse extends DoubleVectorData
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
    public DoubleVectorDataSparse(final double[] vectorSI, final int[] indices, final int size)
    {
        super(StorageType.SPARSE);
        this.vectorSI = vectorSI;
        this.indices = indices;
        this.size = size;
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleVectorDataDense toDense()
    {
        double[] denseSI = new double[this.size];
        for (int index = 0; index < this.vectorSI.length; index++)
        {
            denseSI[this.indices[index]] = this.vectorSI[index];
        }
        return new DoubleVectorDataDense(denseSI);
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.size;
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int index)
    {
        int internalIndex = Arrays.binarySearch(this.indices, index);
        return internalIndex < 0 ? 0.0 : this.vectorSI[internalIndex];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int index, final double valueSI)
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
        double[] vectorSINew = new double[this.vectorSI.length + 1];
        System.arraycopy(this.indices, 0, indicesNew, 0, internalIndex);
        System.arraycopy(this.vectorSI, 0, vectorSINew, 0, internalIndex);
        // System.out.println("arraycopy1 current size is " + this.indices.length + " srcPos=" + internalIndex +
        // ", new size is "
        // + indicesNew.length + " dstPos=" + (internalIndex + 1) + " length=" + (this.indices.length - internalIndex));
        System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex + 1, this.indices.length - internalIndex);
        System.arraycopy(this.vectorSI, internalIndex, vectorSINew, internalIndex + 1, this.indices.length - internalIndex);
        // System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex - 1, this.indices.length - internalIndex);
        // System.arraycopy(this.vectorSI, internalIndex, vectorSINew, internalIndex - 1, this.indices.length - internalIndex);
        indicesNew[internalIndex] = index;
        vectorSINew[internalIndex] = valueSI;
        this.indices = indicesNew;
        this.vectorSI = vectorSINew;
    }

    /** {@inheritDoc} */
    @Override
    public final double[] getDenseVectorSI()
    {
        return toDense().vectorSI;
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleVectorDataSparse copy()
    {
        double[] vCopy = new double[this.vectorSI.length];
        System.arraycopy(this.vectorSI, 0, vCopy, 0, this.vectorSI.length);
        int[] iCopy = new int[this.indices.length];
        System.arraycopy(this.indices, 0, iCopy, 0, this.indices.length);
        return new DoubleVectorDataSparse(vCopy, iCopy, this.size);
    }

    /**
     * Instantiate a DoubleVectorDataSparse from an array.
     * @param valuesSI the (SI) values to store
     * @return the DoubleVectorDataSparse
     */
    public static DoubleVectorDataSparse instantiate(final double[] valuesSI)
    {
        // determine number of non-null cells
        int length = (int) Arrays.stream(valuesSI).parallel().filter(d -> d != 0.0).count();
        double[] sparseSI = new double[length];
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
        return new DoubleVectorDataSparse(sparseSI, indices, valuesSI.length);
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final DoubleVectorData right) throws ValueException
    {
        int newLength =
                (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 || right.getSI(i) != 0.0).count();
        double[] newVectorSI = new double[newLength];
        int[] newIndices = new int[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        // note: if adding -2 and +2, a 0-value will be part of the new sparse vector.
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
    public final void decrementBy(final DoubleVectorData right) throws ValueException
    {
        int newLength =
                (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 || right.getSI(i) != 0.0).count();
        double[] newVectorSI = new double[newLength];
        int[] newIndices = new int[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        // note: if subtracting 2 from 2, a 0-value will be part of the new sparse vector.
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
    public final void multiplyBy(final DoubleVectorData right) throws ValueException
    {
        int newLength =
                (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 && right.getSI(i) != 0.0).count();
        double[] newVectorSI = new double[newLength];
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
    public final void divideBy(final DoubleVectorData right) throws ValueException
    {
        int newLength =
                (int) IntStream.range(0, size()).parallel().filter(i -> this.getSI(i) != 0.0 && right.getSI(i) != 0.0).count();
        double[] newVectorSI = new double[newLength];
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
    @SuppressWarnings({ "checkstyle:needbraces", "checkstyle:designforextension" })
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleVectorDataSparse other = (DoubleVectorDataSparse) obj;
        if (!Arrays.equals(this.indices, other.indices))
            return false;
        if (this.size != other.size)
            return false;
        return true;
    }
}
