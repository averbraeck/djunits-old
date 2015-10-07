package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Money;

/**
 * Mutable Money Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyVector extends MutableDoubleVector.Rel<MoneyUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyVector(final MoneyUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyVector toSparse();

    /**
     * Double Dense Relative Immutable Money class.
     */
    public static class Dense extends MutableMoneyVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Money Vector. An money is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Money Vector
         * @param unit U; the unit of the new Dense Immutable Money Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An money is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Money Vector
         * @param unit U; the unit of the new Relative Dense Immutable Money Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Money&gt;; the values of the Scalar Money entries in the new Relative Dense Immutable Money
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Money Vector. An money is always relative.
         * @param values Money[]; the values of the Scalar Money entries in the new Relative Dense Immutable Money Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Money[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Money Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyVector.Dense result = new MutableMoneyVector.Dense(getData(), getUnit());
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
        public final MutableMoneyVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyVector toSparse()
        {
            return new MutableMoneyVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Money class.
     */
    public static class Sparse extends MutableMoneyVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Money Vector. An money is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Money Vector
         * @param unit MoneyUnit; the unit of the new Relative Sparse Immutable Money Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Money Vector. An money is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Money
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Money Vector. An money is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Money Vector
         * @param unit U; the unit of the new Sparse Immutable Money Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Money Vector. An money is always relative.
         * @param values Money[]; the values of the Scalar Money entries in the new Relative Sparse Immutable Money Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Money[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Money Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyVector.Sparse result = new MutableMoneyVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyVector toDense()
        {
            return new MutableMoneyVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Money get(final int index) throws ValueException
    {
        return (Money) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector copy()
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
    public final MoneyVector plus(final MoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector minus(final MoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector times(final MoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector divide(final MoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector plus(final MutableMoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector minus(final MutableMoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector times(final MutableMoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyVector divide(final MutableMoneyVector rel) throws ValueException
    {
        return MoneyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector abs()
    {
        return (MutableMoneyVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector acos()
    {
        return (MutableMoneyVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector asin()
    {
        return (MutableMoneyVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector atan()
    {
        return (MutableMoneyVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector cbrt()
    {
        return (MutableMoneyVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector ceil()
    {
        return (MutableMoneyVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector cos()
    {
        return (MutableMoneyVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector cosh()
    {
        return (MutableMoneyVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector exp()
    {
        return (MutableMoneyVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector expm1()
    {
        return (MutableMoneyVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector floor()
    {
        return (MutableMoneyVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector log()
    {
        return (MutableMoneyVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector log10()
    {
        return (MutableMoneyVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector log1p()
    {
        return (MutableMoneyVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector pow(final double x)
    {
        return (MutableMoneyVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector rint()
    {
        return (MutableMoneyVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector round()
    {
        return (MutableMoneyVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector signum()
    {
        return (MutableMoneyVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector sin()
    {
        return (MutableMoneyVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector sinh()
    {
        return (MutableMoneyVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector sqrt()
    {
        return (MutableMoneyVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector tan()
    {
        return (MutableMoneyVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector tanh()
    {
        return (MutableMoneyVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector toDegrees()
    {
        return (MutableMoneyVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector toRadians()
    {
        return (MutableMoneyVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector inv()
    {
        return (MutableMoneyVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector multiplyBy(final double constant)
    {
        return (MutableMoneyVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector divideBy(final double constant)
    {
        return (MutableMoneyVector) super.divideBy(constant);
    }

}
