package org.djunits.value.vdouble.vector;

import java.util.Arrays;

import org.djunits.value.ValueException;

/**
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

    /**
     * @return the size of the vector
     */
    public abstract int size();

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
        int count = 0;
        for (int i = 0; i < this.vectorSI.length; i++)
        {
            if (this.vectorSI[i] != 0.0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the sum of the values of all cells.
     */
    public final double zSum()
    {
        double result = 0.0;
        for (int i = 0; i < this.vectorSI.length; i++)
        {
            result += this.vectorSI[i];
        }
        return result;
    }

    /**
     * @return a deep copy of the data.
     */
    public abstract DoubleVectorData copy();

    /**
     * @return a safe copy of VectorSI
     */
    public abstract double[] getDenseVectorSI();

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
        double[] dv = new double[this.size()];
        for (int i = 0; i < dv.length; i++)
        {
            dv[i] = this.getSI(i) + right.getSI(i);
        }
        if (this instanceof DoubleVectorDataSparse && right instanceof DoubleVectorDataSparse)
        {
            return new DoubleVectorDataDense(dv).toSparse();
        }
        return new DoubleVectorDataDense(dv);
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
        double[] dv = new double[this.size()];
        for (int i = 0; i < dv.length; i++)
        {
            dv[i] = this.getSI(i) - right.getSI(i);
        }
        if (this instanceof DoubleVectorDataSparse && right instanceof DoubleVectorDataSparse)
        {
            return new DoubleVectorDataDense(dv).toSparse();
        }
        return new DoubleVectorDataDense(dv);
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
        double[] dv = new double[this.size()];
        for (int i = 0; i < dv.length; i++)
        {
            dv[i] = this.getSI(i) * right.getSI(i);
        }
        if (this instanceof DoubleVectorDataDense && right instanceof DoubleVectorDataDense)
        {
            return new DoubleVectorDataDense(dv);
        }
        return new DoubleVectorDataDense(dv).toSparse();
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
        double[] dv = new double[this.size()];
        for (int i = 0; i < dv.length; i++)
        {
            dv[i] = this.getSI(i) / right.getSI(i);
        }
        if (this instanceof DoubleVectorDataDense && right instanceof DoubleVectorDataDense)
        {
            return new DoubleVectorDataDense(dv);
        }
        return new DoubleVectorDataDense(dv).toSparse();
    }

    /**
     * - Assigns the result of a function to each cell; <tt>x[i] = function(x[i])</tt>. (Iterates downwards from
     * <tt>[size()-1]</tt> to <tt>[0]</tt>).
     * <p>
     * <b>Example:</b>
     * 
     * <pre>
     *   // change each cell to its sine
     *   matrix =   0.5      1.5      2.5       3.5 
     *   matrix.assign(cern.jet.math.Functions.sin);
     *   --&gt;
     *   matrix ==  0.479426 0.997495 0.598472 -0.350783
     * 
     * </pre>
     * 
     * For further examples, see the <a href="package-summary.html#FunctionObjects">package doc</a>.
     * @param f a function object taking as argument the current cell's value.
     * @return <tt>this</tt> (for convenience only).
     * @see cern.jet.math.tdouble.DoubleFunctions
     */
    /*-
    public DoubleMatrix1D assign(final cern.colt.function.tdouble.DoubleFunction f) {
        int nthreads = ConcurrencyUtils.getNumberOfThreads();
        if ((nthreads > 1) && (size >= ConcurrencyUtils.getThreadsBeginN_1D())) {
            nthreads = Math.min(nthreads, size);
            Future<?>[] futures = new Future[nthreads];
            int k = size / nthreads;
            for (int j = 0; j < nthreads; j++) {
                final int firstIdx = j * k;
                final int lastIdx = (j == nthreads - 1) ? size : firstIdx + k;
                futures[j] = ConcurrencyUtils.submit(new Runnable() {

                    public void run() {
                        for (int i = firstIdx; i < lastIdx; i++) {
                            setQuick(i, f.apply(getQuick(i)));
                        }
                    }
                });
            }
            ConcurrencyUtils.waitForCompletion(futures);
        } else {
            for (int i = 0; i < size; i++) {
                setQuick(i, f.apply(getQuick(i)));
            }
        }
        return this;
    }
     */

}
