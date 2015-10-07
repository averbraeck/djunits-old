package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.MoneyPerVolume;

/**
 * Mutable MoneyPerVolume Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMoneyPerVolumeVector extends MutableDoubleVector.Rel<MoneyPerVolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMoneyPerVolumeVector(final MoneyPerVolumeUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMoneyPerVolumeVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MoneyPerVolumeVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerVolumeVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMoneyPerVolumeVector toSparse();

    /**
     * Double Dense Relative Immutable MoneyPerVolume class.
     */
    public static class Dense extends MutableMoneyPerVolumeVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double MoneyPerVolume Vector. An moneypervolume is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double MoneyPerVolume Vector
         * @param unit U; the unit of the new Dense Immutable MoneyPerVolume Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MoneyPerVolumeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An moneypervolume is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable MoneyPerVolume Vector
         * @param unit U; the unit of the new Relative Dense Immutable MoneyPerVolume Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MoneyPerVolumeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;MoneyPerVolume&gt;; the values of the Scalar MoneyPerVolume entries in the new Relative Dense
         *            Immutable MoneyPerVolume Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MoneyPerVolumeUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable MoneyPerVolume Vector. An moneypervolume is always relative.
         * @param values MoneyPerVolume[]; the values of the Scalar MoneyPerVolume entries in the new Relative Dense Immutable
         *            MoneyPerVolume Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final MoneyPerVolume[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable MoneyPerVolume Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MoneyPerVolumeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerVolumeVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerVolumeVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerVolumeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerVolumeVector.Dense result =
                new MutableMoneyPerVolumeVector.Dense(getData(), getUnit());
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
        public final MutableMoneyPerVolumeVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerVolumeVector toSparse()
        {
            return new MutableMoneyPerVolumeVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable MoneyPerVolume class.
     */
    public static class Sparse extends MutableMoneyPerVolumeVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable MoneyPerVolume Vector. An moneypervolume is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable MoneyPerVolume Vector
         * @param unit MoneyPerVolumeUnit; the unit of the new Relative Sparse Immutable MoneyPerVolume Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MoneyPerVolumeUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable MoneyPerVolume Vector. An moneypervolume is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            MoneyPerVolume Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MoneyPerVolumeUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double MoneyPerVolume Vector. An moneypervolume is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double MoneyPerVolume Vector
         * @param unit U; the unit of the new Sparse Immutable MoneyPerVolume Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MoneyPerVolumeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable MoneyPerVolume Vector. An moneypervolume is always relative.
         * @param values MoneyPerVolume[]; the values of the Scalar MoneyPerVolume entries in the new Relative Sparse Immutable
         *            MoneyPerVolume Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final MoneyPerVolume[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable MoneyPerVolume Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MoneyPerVolumeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MoneyPerVolumeVector immutable()
        {
            setCopyOnWrite(true);
            return new MoneyPerVolumeVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerVolumeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMoneyPerVolumeVector.Sparse result =
                new MutableMoneyPerVolumeVector.Sparse(getData(), getUnit());
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
        public final MutableMoneyPerVolumeVector toDense()
        {
            return new MutableMoneyPerVolumeVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMoneyPerVolumeVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume get(final int index) throws ValueException
    {
        return (MoneyPerVolume) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector copy()
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
    public final MoneyPerVolumeVector plus(final MoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector minus(final MoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector times(final MoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector divide(final MoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector plus(final MutableMoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector minus(final MutableMoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector times(final MutableMoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MoneyPerVolumeVector divide(final MutableMoneyPerVolumeVector rel) throws ValueException
    {
        return MoneyPerVolumeVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector abs()
    {
        return (MutableMoneyPerVolumeVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector acos()
    {
        return (MutableMoneyPerVolumeVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector asin()
    {
        return (MutableMoneyPerVolumeVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector atan()
    {
        return (MutableMoneyPerVolumeVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector cbrt()
    {
        return (MutableMoneyPerVolumeVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector ceil()
    {
        return (MutableMoneyPerVolumeVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector cos()
    {
        return (MutableMoneyPerVolumeVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector cosh()
    {
        return (MutableMoneyPerVolumeVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector exp()
    {
        return (MutableMoneyPerVolumeVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector expm1()
    {
        return (MutableMoneyPerVolumeVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector floor()
    {
        return (MutableMoneyPerVolumeVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector log()
    {
        return (MutableMoneyPerVolumeVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector log10()
    {
        return (MutableMoneyPerVolumeVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector log1p()
    {
        return (MutableMoneyPerVolumeVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector pow(final double x)
    {
        return (MutableMoneyPerVolumeVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector rint()
    {
        return (MutableMoneyPerVolumeVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector round()
    {
        return (MutableMoneyPerVolumeVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector signum()
    {
        return (MutableMoneyPerVolumeVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector sin()
    {
        return (MutableMoneyPerVolumeVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector sinh()
    {
        return (MutableMoneyPerVolumeVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector sqrt()
    {
        return (MutableMoneyPerVolumeVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector tan()
    {
        return (MutableMoneyPerVolumeVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector tanh()
    {
        return (MutableMoneyPerVolumeVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector toDegrees()
    {
        return (MutableMoneyPerVolumeVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector toRadians()
    {
        return (MutableMoneyPerVolumeVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector inv()
    {
        return (MutableMoneyPerVolumeVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector multiplyBy(final double constant)
    {
        return (MutableMoneyPerVolumeVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerVolumeVector divideBy(final double constant)
    {
        return (MutableMoneyPerVolumeVector) super.divideBy(constant);
    }

}
