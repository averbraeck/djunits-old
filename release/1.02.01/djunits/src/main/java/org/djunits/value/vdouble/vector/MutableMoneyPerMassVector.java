package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.MoneyPerMass;

/**
 * Mutable MoneyPerMass Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyPerMassVector extends MutableDoubleVector.Rel<MoneyPerMassUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyPerMassVector(final MoneyPerMassUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyPerMassVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyPerMassVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerMassVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerMassVector toSparse();

    /**
     * Double Dense Relative Immutable MoneyPerMass class.
     */
    public static class Dense extends MutableMoneyPerMassVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double MoneyPerMass Vector. An moneypermass is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double MoneyPerMass Vector
         * @param unit U; the unit of the new Dense Immutable MoneyPerMass Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyPerMassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An moneypermass is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable MoneyPerMass Vector
         * @param unit U; the unit of the new Relative Dense Immutable MoneyPerMass Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyPerMassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;MoneyPerMass&gt;; the values of the Scalar MoneyPerMass entries in the new Relative Dense
         *            Immutable MoneyPerMass Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyPerMassUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable MoneyPerMass Vector. An moneypermass is always relative.
         * @param values MoneyPerMass[]; the values of the Scalar MoneyPerMass entries in the new Relative Dense Immutable
         *            MoneyPerMass Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final MoneyPerMass[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable MoneyPerMass Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyPerMassUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerMassVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerMassVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerMassVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerMassVector.Dense result = new MutableMoneyPerMassVector.Dense(getData(), getUnit());
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
        public final MutableMoneyPerMassVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerMassVector toSparse()
        {
            return new MutableMoneyPerMassVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable MoneyPerMass class.
     */
    public static class Sparse extends MutableMoneyPerMassVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable MoneyPerMass Vector. An moneypermass is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable MoneyPerMass Vector
         * @param unit MoneyPerMassUnit; the unit of the new Relative Sparse Immutable MoneyPerMass Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyPerMassUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable MoneyPerMass Vector. An moneypermass is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            MoneyPerMass Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyPerMassUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double MoneyPerMass Vector. An moneypermass is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double MoneyPerMass Vector
         * @param unit U; the unit of the new Sparse Immutable MoneyPerMass Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyPerMassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable MoneyPerMass Vector. An moneypermass is always relative.
         * @param values MoneyPerMass[]; the values of the Scalar MoneyPerMass entries in the new Relative Sparse Immutable
         *            MoneyPerMass Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final MoneyPerMass[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable MoneyPerMass Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyPerMassUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerMassVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerMassVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerMassVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerMassVector.Sparse result = new MutableMoneyPerMassVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyPerMassVector toDense()
        {
            return new MutableMoneyPerMassVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerMassVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMass get(final int index) throws ValueException
    {
        return (MoneyPerMass) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector copy()
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
    public final MoneyPerMassVector plus(final MoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector minus(final MoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector times(final MoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector divide(final MoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector plus(final MutableMoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector minus(final MutableMoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector times(final MutableMoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerMassVector divide(final MutableMoneyPerMassVector rel) throws ValueException
    {
        return MoneyPerMassVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector abs()
    {
        return (MutableMoneyPerMassVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector acos()
    {
        return (MutableMoneyPerMassVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector asin()
    {
        return (MutableMoneyPerMassVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector atan()
    {
        return (MutableMoneyPerMassVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector cbrt()
    {
        return (MutableMoneyPerMassVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector ceil()
    {
        return (MutableMoneyPerMassVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector cos()
    {
        return (MutableMoneyPerMassVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector cosh()
    {
        return (MutableMoneyPerMassVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector exp()
    {
        return (MutableMoneyPerMassVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector expm1()
    {
        return (MutableMoneyPerMassVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector floor()
    {
        return (MutableMoneyPerMassVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector log()
    {
        return (MutableMoneyPerMassVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector log10()
    {
        return (MutableMoneyPerMassVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector log1p()
    {
        return (MutableMoneyPerMassVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector pow(final double x)
    {
        return (MutableMoneyPerMassVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector rint()
    {
        return (MutableMoneyPerMassVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector round()
    {
        return (MutableMoneyPerMassVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector signum()
    {
        return (MutableMoneyPerMassVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector sin()
    {
        return (MutableMoneyPerMassVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector sinh()
    {
        return (MutableMoneyPerMassVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector sqrt()
    {
        return (MutableMoneyPerMassVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector tan()
    {
        return (MutableMoneyPerMassVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector tanh()
    {
        return (MutableMoneyPerMassVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector toDegrees()
    {
        return (MutableMoneyPerMassVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector toRadians()
    {
        return (MutableMoneyPerMassVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector inv()
    {
        return (MutableMoneyPerMassVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector multiplyBy(final double constant)
    {
        return (MutableMoneyPerMassVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector divideBy(final double constant)
    {
        return (MutableMoneyPerMassVector) super.divideBy(constant);
    }

}
