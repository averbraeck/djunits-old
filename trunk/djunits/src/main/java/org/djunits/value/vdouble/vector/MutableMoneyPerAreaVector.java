package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.MoneyPerArea;

/**
 * Mutable MoneyPerArea Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyPerAreaVector extends MutableDoubleVector.Rel<MoneyPerAreaUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyPerAreaVector(final MoneyPerAreaUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyPerAreaVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyPerAreaVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerAreaVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerAreaVector toSparse();

    /**
     * Double Dense Relative Immutable MoneyPerArea class.
     */
    public static class Dense extends MutableMoneyPerAreaVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double MoneyPerArea Vector. An moneyperarea is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double MoneyPerArea Vector
         * @param unit U; the unit of the new Dense Immutable MoneyPerArea Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyPerAreaUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An moneyperarea is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable MoneyPerArea Vector
         * @param unit U; the unit of the new Relative Dense Immutable MoneyPerArea Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyPerAreaUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;MoneyPerArea&gt;; the values of the Scalar MoneyPerArea entries in the new Relative Dense
         *            Immutable MoneyPerArea Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyPerAreaUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable MoneyPerArea Vector. An moneyperarea is always relative.
         * @param values MoneyPerArea[]; the values of the Scalar MoneyPerArea entries in the new Relative Dense Immutable
         *            MoneyPerArea Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final MoneyPerArea[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable MoneyPerArea Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyPerAreaUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerAreaVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerAreaVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerAreaVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerAreaVector.Dense result = new MutableMoneyPerAreaVector.Dense(getData(), getUnit());
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
        public final MutableMoneyPerAreaVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerAreaVector toSparse()
        {
            return new MutableMoneyPerAreaVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable MoneyPerArea class.
     */
    public static class Sparse extends MutableMoneyPerAreaVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable MoneyPerArea Vector. An moneyperarea is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable MoneyPerArea Vector
         * @param unit MoneyPerAreaUnit; the unit of the new Relative Sparse Immutable MoneyPerArea Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyPerAreaUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable MoneyPerArea Vector. An moneyperarea is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            MoneyPerArea Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyPerAreaUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double MoneyPerArea Vector. An moneyperarea is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double MoneyPerArea Vector
         * @param unit U; the unit of the new Sparse Immutable MoneyPerArea Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyPerAreaUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable MoneyPerArea Vector. An moneyperarea is always relative.
         * @param values MoneyPerArea[]; the values of the Scalar MoneyPerArea entries in the new Relative Sparse Immutable
         *            MoneyPerArea Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final MoneyPerArea[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable MoneyPerArea Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyPerAreaUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerAreaVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerAreaVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerAreaVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerAreaVector.Sparse result = new MutableMoneyPerAreaVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyPerAreaVector toDense()
        {
            return new MutableMoneyPerAreaVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerAreaVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea get(final int index) throws ValueException
    {
        return (MoneyPerArea) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector copy()
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
    public final MoneyPerAreaVector plus(final MoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector minus(final MoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector times(final MoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector divide(final MoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector plus(final MutableMoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector minus(final MutableMoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector times(final MutableMoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerAreaVector divide(final MutableMoneyPerAreaVector rel) throws ValueException
    {
        return MoneyPerAreaVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector abs()
    {
        return (MutableMoneyPerAreaVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector acos()
    {
        return (MutableMoneyPerAreaVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector asin()
    {
        return (MutableMoneyPerAreaVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector atan()
    {
        return (MutableMoneyPerAreaVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector cbrt()
    {
        return (MutableMoneyPerAreaVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector ceil()
    {
        return (MutableMoneyPerAreaVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector cos()
    {
        return (MutableMoneyPerAreaVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector cosh()
    {
        return (MutableMoneyPerAreaVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector exp()
    {
        return (MutableMoneyPerAreaVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector expm1()
    {
        return (MutableMoneyPerAreaVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector floor()
    {
        return (MutableMoneyPerAreaVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector log()
    {
        return (MutableMoneyPerAreaVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector log10()
    {
        return (MutableMoneyPerAreaVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector log1p()
    {
        return (MutableMoneyPerAreaVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector pow(final double x)
    {
        return (MutableMoneyPerAreaVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector rint()
    {
        return (MutableMoneyPerAreaVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector round()
    {
        return (MutableMoneyPerAreaVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector signum()
    {
        return (MutableMoneyPerAreaVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector sin()
    {
        return (MutableMoneyPerAreaVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector sinh()
    {
        return (MutableMoneyPerAreaVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector sqrt()
    {
        return (MutableMoneyPerAreaVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector tan()
    {
        return (MutableMoneyPerAreaVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector tanh()
    {
        return (MutableMoneyPerAreaVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector toDegrees()
    {
        return (MutableMoneyPerAreaVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector toRadians()
    {
        return (MutableMoneyPerAreaVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector inv()
    {
        return (MutableMoneyPerAreaVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector multiplyBy(final double constant)
    {
        return (MutableMoneyPerAreaVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector divideBy(final double constant)
    {
        return (MutableMoneyPerAreaVector) super.divideBy(constant);
    }

}
