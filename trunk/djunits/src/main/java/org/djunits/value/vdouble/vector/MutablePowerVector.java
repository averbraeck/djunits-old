package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.PowerUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Power;

/**
 * Mutable Power Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutablePowerVector extends MutableDoubleVector.Rel<PowerUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutablePowerVector(final PowerUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutablePowerVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract PowerVector immutable();

    /** {@inheritDoc} */
    public abstract MutablePowerVector toDense();

    /** {@inheritDoc} */
    public abstract MutablePowerVector toSparse();

    /**
     * Double Dense Relative Immutable Power class.
     */
    public static class Dense extends MutablePowerVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Power Vector. An power is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Power Vector
         * @param unit U; the unit of the new Dense Immutable Power Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final PowerUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An power is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Power Vector
         * @param unit U; the unit of the new Relative Dense Immutable Power Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final PowerUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Power&gt;; the values of the Scalar Power entries in the new Relative Dense Immutable Power
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<PowerUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Power Vector. An power is always relative.
         * @param values Power[]; the values of the Scalar Power entries in the new Relative Dense Immutable Power Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Power[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Power Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final PowerUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final PowerVector immutable()
        {
            setCopyOnWrite(true);
            return new PowerVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutablePowerVector mutable()
        {
            setCopyOnWrite(true);
            final MutablePowerVector.Dense result = new MutablePowerVector.Dense(getData(), getUnit());
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
        public final MutablePowerVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutablePowerVector toSparse()
        {
            return new MutablePowerVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Power class.
     */
    public static class Sparse extends MutablePowerVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Power Vector. An power is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Power Vector
         * @param unit PowerUnit; the unit of the new Relative Sparse Immutable Power Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final PowerUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Power Vector. An power is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Power
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<PowerUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Power Vector. An power is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Power Vector
         * @param unit U; the unit of the new Sparse Immutable Power Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final PowerUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Power Vector. An power is always relative.
         * @param values Power[]; the values of the Scalar Power entries in the new Relative Sparse Immutable Power Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Power[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Power Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final PowerUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final PowerVector immutable()
        {
            setCopyOnWrite(true);
            return new PowerVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutablePowerVector mutable()
        {
            setCopyOnWrite(true);
            final MutablePowerVector.Sparse result = new MutablePowerVector.Sparse(getData(), getUnit());
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
        public final MutablePowerVector toDense()
        {
            return new MutablePowerVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutablePowerVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Power get(final int index) throws ValueException
    {
        return (Power) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector copy()
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
    public final PowerVector plus(final PowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector minus(final PowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector times(final PowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector divide(final PowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector plus(final MutablePowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector minus(final MutablePowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector times(final MutablePowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final PowerVector divide(final MutablePowerVector rel) throws ValueException
    {
        return PowerVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector abs()
    {
        return (MutablePowerVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector acos()
    {
        return (MutablePowerVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector asin()
    {
        return (MutablePowerVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector atan()
    {
        return (MutablePowerVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector cbrt()
    {
        return (MutablePowerVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector ceil()
    {
        return (MutablePowerVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector cos()
    {
        return (MutablePowerVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector cosh()
    {
        return (MutablePowerVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector exp()
    {
        return (MutablePowerVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector expm1()
    {
        return (MutablePowerVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector floor()
    {
        return (MutablePowerVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector log()
    {
        return (MutablePowerVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector log10()
    {
        return (MutablePowerVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector log1p()
    {
        return (MutablePowerVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector pow(final double x)
    {
        return (MutablePowerVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector rint()
    {
        return (MutablePowerVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector round()
    {
        return (MutablePowerVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector signum()
    {
        return (MutablePowerVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector sin()
    {
        return (MutablePowerVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector sinh()
    {
        return (MutablePowerVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector sqrt()
    {
        return (MutablePowerVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector tan()
    {
        return (MutablePowerVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector tanh()
    {
        return (MutablePowerVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector toDegrees()
    {
        return (MutablePowerVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector toRadians()
    {
        return (MutablePowerVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector inv()
    {
        return (MutablePowerVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector multiplyBy(final double constant)
    {
        return (MutablePowerVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerVector divideBy(final double constant)
    {
        return (MutablePowerVector) super.divideBy(constant);
    }

}
