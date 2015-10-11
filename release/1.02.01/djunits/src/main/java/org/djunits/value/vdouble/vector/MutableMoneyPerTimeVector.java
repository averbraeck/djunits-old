package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.MoneyPerTime;

/**
 * Mutable MoneyPerTime Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyPerTimeVector extends MutableDoubleVector.Rel<MoneyPerTimeUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyPerTimeVector(final MoneyPerTimeUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyPerTimeVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyPerTimeVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerTimeVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerTimeVector toSparse();

    /**
     * Double Dense Relative Immutable MoneyPerTime class.
     */
    public static class Dense extends MutableMoneyPerTimeVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double MoneyPerTime Vector. An moneypertime is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double MoneyPerTime Vector
         * @param unit U; the unit of the new Dense Immutable MoneyPerTime Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyPerTimeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An moneypertime is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable MoneyPerTime Vector
         * @param unit U; the unit of the new Relative Dense Immutable MoneyPerTime Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyPerTimeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;MoneyPerTime&gt;; the values of the Scalar MoneyPerTime entries in the new Relative Dense
         *            Immutable MoneyPerTime Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyPerTimeUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable MoneyPerTime Vector. An moneypertime is always relative.
         * @param values MoneyPerTime[]; the values of the Scalar MoneyPerTime entries in the new Relative Dense Immutable
         *            MoneyPerTime Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final MoneyPerTime[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable MoneyPerTime Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyPerTimeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerTimeVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerTimeVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerTimeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerTimeVector.Dense result = new MutableMoneyPerTimeVector.Dense(getData(), getUnit());
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
        public final MutableMoneyPerTimeVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerTimeVector toSparse()
        {
            return new MutableMoneyPerTimeVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable MoneyPerTime class.
     */
    public static class Sparse extends MutableMoneyPerTimeVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable MoneyPerTime Vector. An moneypertime is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable MoneyPerTime Vector
         * @param unit MoneyPerTimeUnit; the unit of the new Relative Sparse Immutable MoneyPerTime Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyPerTimeUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable MoneyPerTime Vector. An moneypertime is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            MoneyPerTime Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyPerTimeUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double MoneyPerTime Vector. An moneypertime is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double MoneyPerTime Vector
         * @param unit U; the unit of the new Sparse Immutable MoneyPerTime Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyPerTimeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable MoneyPerTime Vector. An moneypertime is always relative.
         * @param values MoneyPerTime[]; the values of the Scalar MoneyPerTime entries in the new Relative Sparse Immutable
         *            MoneyPerTime Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final MoneyPerTime[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable MoneyPerTime Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyPerTimeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerTimeVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerTimeVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerTimeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerTimeVector.Sparse result = new MutableMoneyPerTimeVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyPerTimeVector toDense()
        {
            return new MutableMoneyPerTimeVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerTimeVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime get(final int index) throws ValueException
    {
        return (MoneyPerTime) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector copy()
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
    public final MoneyPerTimeVector plus(final MoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector minus(final MoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector times(final MoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector divide(final MoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector plus(final MutableMoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector minus(final MutableMoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector times(final MutableMoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerTimeVector divide(final MutableMoneyPerTimeVector rel) throws ValueException
    {
        return MoneyPerTimeVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector abs()
    {
        return (MutableMoneyPerTimeVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector acos()
    {
        return (MutableMoneyPerTimeVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector asin()
    {
        return (MutableMoneyPerTimeVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector atan()
    {
        return (MutableMoneyPerTimeVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector cbrt()
    {
        return (MutableMoneyPerTimeVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector ceil()
    {
        return (MutableMoneyPerTimeVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector cos()
    {
        return (MutableMoneyPerTimeVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector cosh()
    {
        return (MutableMoneyPerTimeVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector exp()
    {
        return (MutableMoneyPerTimeVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector expm1()
    {
        return (MutableMoneyPerTimeVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector floor()
    {
        return (MutableMoneyPerTimeVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector log()
    {
        return (MutableMoneyPerTimeVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector log10()
    {
        return (MutableMoneyPerTimeVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector log1p()
    {
        return (MutableMoneyPerTimeVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector pow(final double x)
    {
        return (MutableMoneyPerTimeVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector rint()
    {
        return (MutableMoneyPerTimeVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector round()
    {
        return (MutableMoneyPerTimeVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector signum()
    {
        return (MutableMoneyPerTimeVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector sin()
    {
        return (MutableMoneyPerTimeVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector sinh()
    {
        return (MutableMoneyPerTimeVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector sqrt()
    {
        return (MutableMoneyPerTimeVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector tan()
    {
        return (MutableMoneyPerTimeVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector tanh()
    {
        return (MutableMoneyPerTimeVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector toDegrees()
    {
        return (MutableMoneyPerTimeVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector toRadians()
    {
        return (MutableMoneyPerTimeVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector inv()
    {
        return (MutableMoneyPerTimeVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector multiplyBy(final double constant)
    {
        return (MutableMoneyPerTimeVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerTimeVector divideBy(final double constant)
    {
        return (MutableMoneyPerTimeVector) super.divideBy(constant);
    }

}
