package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.MoneyPerEnergy;

/**
 * Mutable MoneyPerEnergy Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyPerEnergyVector extends MutableDoubleVector.Rel<MoneyPerEnergyUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyPerEnergyVector(final MoneyPerEnergyUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyPerEnergyVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyPerEnergyVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerEnergyVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerEnergyVector toSparse();

    /**
     * Double Dense Relative Immutable MoneyPerEnergy class.
     */
    public static class Dense extends MutableMoneyPerEnergyVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double MoneyPerEnergy Vector. An moneyperenergy is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double MoneyPerEnergy Vector
         * @param unit U; the unit of the new Dense Immutable MoneyPerEnergy Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyPerEnergyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An moneyperenergy is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable MoneyPerEnergy Vector
         * @param unit U; the unit of the new Relative Dense Immutable MoneyPerEnergy Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyPerEnergyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;MoneyPerEnergy&gt;; the values of the Scalar MoneyPerEnergy entries in the new Relative Dense
         *            Immutable MoneyPerEnergy Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyPerEnergyUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable MoneyPerEnergy Vector. An moneyperenergy is always relative.
         * @param values MoneyPerEnergy[]; the values of the Scalar MoneyPerEnergy entries in the new Relative Dense Immutable
         *            MoneyPerEnergy Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final MoneyPerEnergy[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable MoneyPerEnergy Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyPerEnergyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerEnergyVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerEnergyVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerEnergyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerEnergyVector.Dense result =
                new MutableMoneyPerEnergyVector.Dense(getData(), getUnit());
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
        public final MutableMoneyPerEnergyVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerEnergyVector toSparse()
        {
            return new MutableMoneyPerEnergyVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable MoneyPerEnergy class.
     */
    public static class Sparse extends MutableMoneyPerEnergyVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable MoneyPerEnergy Vector. An moneyperenergy is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable MoneyPerEnergy Vector
         * @param unit MoneyPerEnergyUnit; the unit of the new Relative Sparse Immutable MoneyPerEnergy Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyPerEnergyUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable MoneyPerEnergy Vector. An moneyperenergy is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            MoneyPerEnergy Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyPerEnergyUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double MoneyPerEnergy Vector. An moneyperenergy is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double MoneyPerEnergy Vector
         * @param unit U; the unit of the new Sparse Immutable MoneyPerEnergy Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyPerEnergyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable MoneyPerEnergy Vector. An moneyperenergy is always relative.
         * @param values MoneyPerEnergy[]; the values of the Scalar MoneyPerEnergy entries in the new Relative Sparse Immutable
         *            MoneyPerEnergy Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final MoneyPerEnergy[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable MoneyPerEnergy Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyPerEnergyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerEnergyVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerEnergyVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerEnergyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerEnergyVector.Sparse result =
                new MutableMoneyPerEnergyVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyPerEnergyVector toDense()
        {
            return new MutableMoneyPerEnergyVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerEnergyVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy get(final int index) throws ValueException
    {
        return (MoneyPerEnergy) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector copy()
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
    public final MoneyPerEnergyVector plus(final MoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector minus(final MoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector times(final MoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector divide(final MoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector plus(final MutableMoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector minus(final MutableMoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector times(final MutableMoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerEnergyVector divide(final MutableMoneyPerEnergyVector rel) throws ValueException
    {
        return MoneyPerEnergyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector abs()
    {
        return (MutableMoneyPerEnergyVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector acos()
    {
        return (MutableMoneyPerEnergyVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector asin()
    {
        return (MutableMoneyPerEnergyVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector atan()
    {
        return (MutableMoneyPerEnergyVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector cbrt()
    {
        return (MutableMoneyPerEnergyVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector ceil()
    {
        return (MutableMoneyPerEnergyVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector cos()
    {
        return (MutableMoneyPerEnergyVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector cosh()
    {
        return (MutableMoneyPerEnergyVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector exp()
    {
        return (MutableMoneyPerEnergyVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector expm1()
    {
        return (MutableMoneyPerEnergyVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector floor()
    {
        return (MutableMoneyPerEnergyVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector log()
    {
        return (MutableMoneyPerEnergyVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector log10()
    {
        return (MutableMoneyPerEnergyVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector log1p()
    {
        return (MutableMoneyPerEnergyVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector pow(final double x)
    {
        return (MutableMoneyPerEnergyVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector rint()
    {
        return (MutableMoneyPerEnergyVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector round()
    {
        return (MutableMoneyPerEnergyVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector signum()
    {
        return (MutableMoneyPerEnergyVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector sin()
    {
        return (MutableMoneyPerEnergyVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector sinh()
    {
        return (MutableMoneyPerEnergyVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector sqrt()
    {
        return (MutableMoneyPerEnergyVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector tan()
    {
        return (MutableMoneyPerEnergyVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector tanh()
    {
        return (MutableMoneyPerEnergyVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector toDegrees()
    {
        return (MutableMoneyPerEnergyVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector toRadians()
    {
        return (MutableMoneyPerEnergyVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector inv()
    {
        return (MutableMoneyPerEnergyVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector multiplyBy(final double constant)
    {
        return (MutableMoneyPerEnergyVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyVector divideBy(final double constant)
    {
        return (MutableMoneyPerEnergyVector) super.divideBy(constant);
    }

}
