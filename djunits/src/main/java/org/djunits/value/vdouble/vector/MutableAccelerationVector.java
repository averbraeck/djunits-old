package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Acceleration;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable Acceleration Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableAccelerationVector extends MutableDoubleVector.Rel<AccelerationUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableAccelerationVector(final AccelerationUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableAccelerationVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract AccelerationVector immutable();

    /** {@inheritDoc} */
    public abstract MutableAccelerationVector toDense();

    /** {@inheritDoc} */
    public abstract MutableAccelerationVector toSparse();

    /**
     * Double Dense Relative Immutable Acceleration class.
     */
    public static class Dense extends MutableAccelerationVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Acceleration Vector. An acceleration is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Acceleration Vector
         * @param unit U; the unit of the new Dense Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final AccelerationUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An acceleration is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Acceleration Vector
         * @param unit U; the unit of the new Relative Dense Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final AccelerationUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Acceleration&gt;; the values of the Scalar Acceleration entries in the new Relative Dense
         *            Immutable Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<AccelerationUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Acceleration[]; the values of the Scalar Acceleration entries in the new Relative Dense Immutable
         *            Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Acceleration[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Acceleration Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final AccelerationUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final AccelerationVector immutable()
        {
            setCopyOnWrite(true);
            return new AccelerationVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAccelerationVector mutable()
        {
            setCopyOnWrite(true);
            final MutableAccelerationVector.Dense result = new MutableAccelerationVector.Dense(getData(), getUnit());
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
        public final MutableAccelerationVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAccelerationVector toSparse()
        {
            return new MutableAccelerationVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Acceleration class.
     */
    public static class Sparse extends MutableAccelerationVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Acceleration Vector
         * @param unit AccelerationUnit; the unit of the new Relative Sparse Immutable Acceleration Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final AccelerationUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            Acceleration Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<AccelerationUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Acceleration Vector. An acceleration is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Acceleration Vector
         * @param unit U; the unit of the new Sparse Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final AccelerationUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Acceleration[]; the values of the Scalar Acceleration entries in the new Relative Sparse Immutable
         *            Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Acceleration[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Acceleration Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final AccelerationUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final AccelerationVector immutable()
        {
            setCopyOnWrite(true);
            return new AccelerationVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAccelerationVector mutable()
        {
            setCopyOnWrite(true);
            final MutableAccelerationVector.Sparse result = new MutableAccelerationVector.Sparse(getData(), getUnit());
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
        public final MutableAccelerationVector toDense()
        {
            return new MutableAccelerationVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAccelerationVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Acceleration get(final int index) throws ValueException
    {
        return (Acceleration) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector copy()
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
    public final AccelerationVector plus(final AccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector minus(final AccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector times(final AccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector divide(final AccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector plus(final MutableAccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector minus(final MutableAccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector times(final MutableAccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AccelerationVector divide(final MutableAccelerationVector rel) throws ValueException
    {
        return AccelerationVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector abs()
    {
        return (MutableAccelerationVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector acos()
    {
        return (MutableAccelerationVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector asin()
    {
        return (MutableAccelerationVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector atan()
    {
        return (MutableAccelerationVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector cbrt()
    {
        return (MutableAccelerationVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector ceil()
    {
        return (MutableAccelerationVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector cos()
    {
        return (MutableAccelerationVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector cosh()
    {
        return (MutableAccelerationVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector exp()
    {
        return (MutableAccelerationVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector expm1()
    {
        return (MutableAccelerationVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector floor()
    {
        return (MutableAccelerationVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector log()
    {
        return (MutableAccelerationVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector log10()
    {
        return (MutableAccelerationVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector log1p()
    {
        return (MutableAccelerationVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector pow(final double x)
    {
        return (MutableAccelerationVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector rint()
    {
        return (MutableAccelerationVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector round()
    {
        return (MutableAccelerationVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector signum()
    {
        return (MutableAccelerationVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector sin()
    {
        return (MutableAccelerationVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector sinh()
    {
        return (MutableAccelerationVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector sqrt()
    {
        return (MutableAccelerationVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector tan()
    {
        return (MutableAccelerationVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector tanh()
    {
        return (MutableAccelerationVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector toDegrees()
    {
        return (MutableAccelerationVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector toRadians()
    {
        return (MutableAccelerationVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector inv()
    {
        return (MutableAccelerationVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector multiplyBy(final double constant)
    {
        return (MutableAccelerationVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector divideBy(final double constant)
    {
        return (MutableAccelerationVector) super.divideBy(constant);
    }

}
