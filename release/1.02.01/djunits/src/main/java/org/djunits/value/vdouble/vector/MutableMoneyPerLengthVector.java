package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.MoneyPerLength;

/**
 * Mutable MoneyPerLength Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyPerLengthVector extends MutableDoubleVector.Rel<MoneyPerLengthUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyPerLengthVector(final MoneyPerLengthUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyPerLengthVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyPerLengthVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerLengthVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerLengthVector toSparse();

    /**
     * Double Dense Relative Immutable MoneyPerLength class.
     */
    public static class Dense extends MutableMoneyPerLengthVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double MoneyPerLength Vector. An moneyperlength is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double MoneyPerLength Vector
         * @param unit U; the unit of the new Dense Immutable MoneyPerLength Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyPerLengthUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An moneyperlength is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable MoneyPerLength Vector
         * @param unit U; the unit of the new Relative Dense Immutable MoneyPerLength Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyPerLengthUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;MoneyPerLength&gt;; the values of the Scalar MoneyPerLength entries in the new Relative Dense
         *            Immutable MoneyPerLength Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyPerLengthUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable MoneyPerLength Vector. An moneyperlength is always relative.
         * @param values MoneyPerLength[]; the values of the Scalar MoneyPerLength entries in the new Relative Dense Immutable
         *            MoneyPerLength Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final MoneyPerLength[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable MoneyPerLength Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyPerLengthUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerLengthVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerLengthVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerLengthVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerLengthVector.Dense result =
                new MutableMoneyPerLengthVector.Dense(getData(), getUnit());
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
        public final MutableMoneyPerLengthVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerLengthVector toSparse()
        {
            return new MutableMoneyPerLengthVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable MoneyPerLength class.
     */
    public static class Sparse extends MutableMoneyPerLengthVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable MoneyPerLength Vector. An moneyperlength is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable MoneyPerLength Vector
         * @param unit MoneyPerLengthUnit; the unit of the new Relative Sparse Immutable MoneyPerLength Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyPerLengthUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable MoneyPerLength Vector. An moneyperlength is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            MoneyPerLength Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyPerLengthUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double MoneyPerLength Vector. An moneyperlength is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double MoneyPerLength Vector
         * @param unit U; the unit of the new Sparse Immutable MoneyPerLength Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyPerLengthUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable MoneyPerLength Vector. An moneyperlength is always relative.
         * @param values MoneyPerLength[]; the values of the Scalar MoneyPerLength entries in the new Relative Sparse Immutable
         *            MoneyPerLength Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final MoneyPerLength[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable MoneyPerLength Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyPerLengthUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerLengthVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerLengthVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerLengthVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerLengthVector.Sparse result =
                new MutableMoneyPerLengthVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyPerLengthVector toDense()
        {
            return new MutableMoneyPerLengthVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerLengthVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength get(final int index) throws ValueException
    {
        return (MoneyPerLength) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector copy()
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
    public final MoneyPerLengthVector plus(final MoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector minus(final MoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector times(final MoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector divide(final MoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector plus(final MutableMoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector minus(final MutableMoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector times(final MutableMoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerLengthVector divide(final MutableMoneyPerLengthVector rel) throws ValueException
    {
        return MoneyPerLengthVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector abs()
    {
        return (MutableMoneyPerLengthVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector acos()
    {
        return (MutableMoneyPerLengthVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector asin()
    {
        return (MutableMoneyPerLengthVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector atan()
    {
        return (MutableMoneyPerLengthVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector cbrt()
    {
        return (MutableMoneyPerLengthVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector ceil()
    {
        return (MutableMoneyPerLengthVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector cos()
    {
        return (MutableMoneyPerLengthVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector cosh()
    {
        return (MutableMoneyPerLengthVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector exp()
    {
        return (MutableMoneyPerLengthVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector expm1()
    {
        return (MutableMoneyPerLengthVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector floor()
    {
        return (MutableMoneyPerLengthVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector log()
    {
        return (MutableMoneyPerLengthVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector log10()
    {
        return (MutableMoneyPerLengthVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector log1p()
    {
        return (MutableMoneyPerLengthVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector pow(final double x)
    {
        return (MutableMoneyPerLengthVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector rint()
    {
        return (MutableMoneyPerLengthVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector round()
    {
        return (MutableMoneyPerLengthVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector signum()
    {
        return (MutableMoneyPerLengthVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector sin()
    {
        return (MutableMoneyPerLengthVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector sinh()
    {
        return (MutableMoneyPerLengthVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector sqrt()
    {
        return (MutableMoneyPerLengthVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector tan()
    {
        return (MutableMoneyPerLengthVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector tanh()
    {
        return (MutableMoneyPerLengthVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector toDegrees()
    {
        return (MutableMoneyPerLengthVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector toRadians()
    {
        return (MutableMoneyPerLengthVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector inv()
    {
        return (MutableMoneyPerLengthVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector multiplyBy(final double constant)
    {
        return (MutableMoneyPerLengthVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthVector divideBy(final double constant)
    {
        return (MutableMoneyPerLengthVector) super.divideBy(constant);
    }

}
