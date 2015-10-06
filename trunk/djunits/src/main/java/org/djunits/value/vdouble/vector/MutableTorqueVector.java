package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TorqueUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Torque;

/**
 * Mutable Torque Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableTorqueVector extends MutableDoubleVector.Rel<TorqueUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableTorqueVector(final TorqueUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableTorqueVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract TorqueVector immutable();

    /** {@inheritDoc} */
    public abstract MutableTorqueVector toDense();

    /** {@inheritDoc} */
    public abstract MutableTorqueVector toSparse();

    /**
     * Double Dense Relative Immutable Torque class.
     */
    public static class Dense extends MutableTorqueVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Torque Vector. An torque is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Torque Vector
         * @param unit U; the unit of the new Dense Immutable Torque Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final TorqueUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An torque is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Torque Vector
         * @param unit U; the unit of the new Relative Dense Immutable Torque Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final TorqueUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Torque&gt;; the values of the Scalar Torque entries in the new Relative Dense Immutable Torque
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<TorqueUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Torque Vector. An torque is always relative.
         * @param values Torque[]; the values of the Scalar Torque entries in the new Relative Dense Immutable Torque Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Torque[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Torque Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final TorqueUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final TorqueVector immutable()
        {
            setCopyOnWrite(true);
            return new TorqueVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTorqueVector mutable()
        {
            setCopyOnWrite(true);
            final MutableTorqueVector.Dense result = new MutableTorqueVector.Dense(getData(), getUnit());
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
        public final MutableTorqueVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTorqueVector toSparse()
        {
            return new MutableTorqueVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Torque class.
     */
    public static class Sparse extends MutableTorqueVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Torque Vector. An torque is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Torque Vector
         * @param unit TorqueUnit; the unit of the new Relative Sparse Immutable Torque Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final TorqueUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Torque Vector. An torque is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Torque
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<TorqueUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Torque Vector. An torque is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Torque Vector
         * @param unit U; the unit of the new Sparse Immutable Torque Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final TorqueUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Torque Vector. An torque is always relative.
         * @param values Torque[]; the values of the Scalar Torque entries in the new Relative Sparse Immutable Torque Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Torque[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Torque Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final TorqueUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final TorqueVector immutable()
        {
            setCopyOnWrite(true);
            return new TorqueVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTorqueVector mutable()
        {
            setCopyOnWrite(true);
            final MutableTorqueVector.Sparse result = new MutableTorqueVector.Sparse(getData(), getUnit());
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
        public final MutableTorqueVector toDense()
        {
            return new MutableTorqueVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTorqueVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Torque get(final int index) throws ValueException
    {
        return (Torque) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector copy()
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
    public final TorqueVector plus(final TorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector minus(final TorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector times(final TorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector divide(final TorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector plus(final MutableTorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector minus(final MutableTorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector times(final MutableTorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final TorqueVector divide(final MutableTorqueVector rel) throws ValueException
    {
        return TorqueVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector abs()
    {
        return (MutableTorqueVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector acos()
    {
        return (MutableTorqueVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector asin()
    {
        return (MutableTorqueVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector atan()
    {
        return (MutableTorqueVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector cbrt()
    {
        return (MutableTorqueVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector ceil()
    {
        return (MutableTorqueVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector cos()
    {
        return (MutableTorqueVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector cosh()
    {
        return (MutableTorqueVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector exp()
    {
        return (MutableTorqueVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector expm1()
    {
        return (MutableTorqueVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector floor()
    {
        return (MutableTorqueVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector log()
    {
        return (MutableTorqueVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector log10()
    {
        return (MutableTorqueVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector log1p()
    {
        return (MutableTorqueVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector pow(final double x)
    {
        return (MutableTorqueVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector rint()
    {
        return (MutableTorqueVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector round()
    {
        return (MutableTorqueVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector signum()
    {
        return (MutableTorqueVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector sin()
    {
        return (MutableTorqueVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector sinh()
    {
        return (MutableTorqueVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector sqrt()
    {
        return (MutableTorqueVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector tan()
    {
        return (MutableTorqueVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector tanh()
    {
        return (MutableTorqueVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector toDegrees()
    {
        return (MutableTorqueVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector toRadians()
    {
        return (MutableTorqueVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector inv()
    {
        return (MutableTorqueVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector multiplyBy(final double constant)
    {
        return (MutableTorqueVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector divideBy(final double constant)
    {
        return (MutableTorqueVector) super.divideBy(constant);
    }

}
