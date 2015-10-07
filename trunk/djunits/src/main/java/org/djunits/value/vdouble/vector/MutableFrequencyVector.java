package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.FrequencyUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Frequency;

/**
 * Mutable Frequency Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableFrequencyVector extends MutableDoubleVector.Rel<FrequencyUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableFrequencyVector(final FrequencyUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableFrequencyVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract FrequencyVector immutable();

    /** {@inheritDoc} */
    public abstract MutableFrequencyVector toDense();

    /** {@inheritDoc} */
    public abstract MutableFrequencyVector toSparse();

    /**
     * Double Dense Relative Immutable Frequency class.
     */
    public static class Dense extends MutableFrequencyVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Frequency Vector. An frequency is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Frequency Vector
         * @param unit U; the unit of the new Dense Immutable Frequency Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final FrequencyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An frequency is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Frequency Vector
         * @param unit U; the unit of the new Relative Dense Immutable Frequency Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final FrequencyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Frequency&gt;; the values of the Scalar Frequency entries in the new Relative Dense Immutable
         *            Frequency Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<FrequencyUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Frequency Vector. An frequency is always relative.
         * @param values Frequency[]; the values of the Scalar Frequency entries in the new Relative Dense Immutable Frequency
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Frequency[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Frequency Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final FrequencyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final FrequencyVector immutable()
        {
            setCopyOnWrite(true);
            return new FrequencyVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFrequencyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableFrequencyVector.Dense result = new MutableFrequencyVector.Dense(getData(), getUnit());
            result.setCopyOnWrite(true);
            return result;
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataDense getData()
        {
            return (DoubleVectorDataDense) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFrequencyVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFrequencyVector toSparse()
        {
            return new MutableFrequencyVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Frequency class.
     */
    public static class Sparse extends MutableFrequencyVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Frequency Vector. An frequency is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Frequency Vector
         * @param unit FrequencyUnit; the unit of the new Relative Sparse Immutable Frequency Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final FrequencyUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Frequency Vector. An frequency is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Frequency
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<FrequencyUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Frequency Vector. An frequency is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Frequency Vector
         * @param unit U; the unit of the new Sparse Immutable Frequency Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final FrequencyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Frequency Vector. An frequency is always relative.
         * @param values Frequency[]; the values of the Scalar Frequency entries in the new Relative Sparse Immutable Frequency
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Frequency[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Frequency Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final FrequencyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final FrequencyVector immutable()
        {
            setCopyOnWrite(true);
            return new FrequencyVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFrequencyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableFrequencyVector.Sparse result = new MutableFrequencyVector.Sparse(getData(), getUnit());
            result.setCopyOnWrite(true);
            return result;
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataSparse getData()
        {
            return (DoubleVectorDataSparse) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFrequencyVector toDense()
        {
            return new MutableFrequencyVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFrequencyVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Frequency get(final int index) throws ValueException
    {
        return (Frequency) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector copy()
    {
        return mutable();
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector plus(final FrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector minus(final FrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector times(final FrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector divide(final FrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector plus(final MutableFrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector minus(final MutableFrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector times(final MutableFrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FrequencyVector divide(final MutableFrequencyVector rel) throws ValueException
    {
        return FrequencyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector abs()
    {
        return (MutableFrequencyVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector acos()
    {
        return (MutableFrequencyVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector asin()
    {
        return (MutableFrequencyVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector atan()
    {
        return (MutableFrequencyVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector cbrt()
    {
        return (MutableFrequencyVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector ceil()
    {
        return (MutableFrequencyVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector cos()
    {
        return (MutableFrequencyVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector cosh()
    {
        return (MutableFrequencyVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector exp()
    {
        return (MutableFrequencyVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector expm1()
    {
        return (MutableFrequencyVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector floor()
    {
        return (MutableFrequencyVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector log()
    {
        return (MutableFrequencyVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector log10()
    {
        return (MutableFrequencyVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector log1p()
    {
        return (MutableFrequencyVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector pow(final double x)
    {
        return (MutableFrequencyVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector rint()
    {
        return (MutableFrequencyVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector round()
    {
        return (MutableFrequencyVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector signum()
    {
        return (MutableFrequencyVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector sin()
    {
        return (MutableFrequencyVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector sinh()
    {
        return (MutableFrequencyVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector sqrt()
    {
        return (MutableFrequencyVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector tan()
    {
        return (MutableFrequencyVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector tanh()
    {
        return (MutableFrequencyVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector toDegrees()
    {
        return (MutableFrequencyVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector toRadians()
    {
        return (MutableFrequencyVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector inv()
    {
        return (MutableFrequencyVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector multiplyBy(final double constant)
    {
        return (MutableFrequencyVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFrequencyVector divideBy(final double constant)
    {
        return (MutableFrequencyVector) super.divideBy(constant);
    }

}
