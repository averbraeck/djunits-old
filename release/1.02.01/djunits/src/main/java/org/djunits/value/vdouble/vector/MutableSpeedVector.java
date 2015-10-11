package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.SpeedUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Speed;

/**
 * Mutable Speed Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableSpeedVector extends MutableDoubleVector.Rel<SpeedUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableSpeedVector(final SpeedUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableSpeedVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract SpeedVector immutable();

    /** {@inheritDoc} */
    public abstract MutableSpeedVector toDense();

    /** {@inheritDoc} */
    public abstract MutableSpeedVector toSparse();

    /**
     * Double Dense Relative Immutable Speed class.
     */
    public static class Dense extends MutableSpeedVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Speed Vector. An speed is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Speed Vector
         * @param unit U; the unit of the new Dense Immutable Speed Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final SpeedUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An speed is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Speed Vector
         * @param unit U; the unit of the new Relative Dense Immutable Speed Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final SpeedUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Speed&gt;; the values of the Scalar Speed entries in the new Relative Dense Immutable Speed
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<SpeedUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Speed Vector. An speed is always relative.
         * @param values Speed[]; the values of the Scalar Speed entries in the new Relative Dense Immutable Speed Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Speed[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Speed Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final SpeedUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final SpeedVector immutable()
        {
            setCopyOnWrite(true);
            return new SpeedVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableSpeedVector mutable()
        {
            setCopyOnWrite(true);
            final MutableSpeedVector.Dense result = new MutableSpeedVector.Dense(getData(), getUnit());
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
        public final MutableSpeedVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableSpeedVector toSparse()
        {
            return new MutableSpeedVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Speed class.
     */
    public static class Sparse extends MutableSpeedVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Speed Vector. An speed is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Speed Vector
         * @param unit SpeedUnit; the unit of the new Relative Sparse Immutable Speed Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final SpeedUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Speed Vector. An speed is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Speed
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<SpeedUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Speed Vector. An speed is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Speed Vector
         * @param unit U; the unit of the new Sparse Immutable Speed Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final SpeedUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Speed Vector. An speed is always relative.
         * @param values Speed[]; the values of the Scalar Speed entries in the new Relative Sparse Immutable Speed Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Speed[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Speed Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final SpeedUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final SpeedVector immutable()
        {
            setCopyOnWrite(true);
            return new SpeedVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableSpeedVector mutable()
        {
            setCopyOnWrite(true);
            final MutableSpeedVector.Sparse result = new MutableSpeedVector.Sparse(getData(), getUnit());
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
        public final MutableSpeedVector toDense()
        {
            return new MutableSpeedVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableSpeedVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Speed get(final int index) throws ValueException
    {
        return (Speed) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector copy()
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
    public final SpeedVector plus(final SpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector minus(final SpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector times(final SpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector divide(final SpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector plus(final MutableSpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector minus(final MutableSpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector times(final MutableSpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final SpeedVector divide(final MutableSpeedVector rel) throws ValueException
    {
        return SpeedVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector abs()
    {
        return (MutableSpeedVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector acos()
    {
        return (MutableSpeedVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector asin()
    {
        return (MutableSpeedVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector atan()
    {
        return (MutableSpeedVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector cbrt()
    {
        return (MutableSpeedVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector ceil()
    {
        return (MutableSpeedVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector cos()
    {
        return (MutableSpeedVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector cosh()
    {
        return (MutableSpeedVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector exp()
    {
        return (MutableSpeedVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector expm1()
    {
        return (MutableSpeedVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector floor()
    {
        return (MutableSpeedVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector log()
    {
        return (MutableSpeedVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector log10()
    {
        return (MutableSpeedVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector log1p()
    {
        return (MutableSpeedVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector pow(final double x)
    {
        return (MutableSpeedVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector rint()
    {
        return (MutableSpeedVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector round()
    {
        return (MutableSpeedVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector signum()
    {
        return (MutableSpeedVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector sin()
    {
        return (MutableSpeedVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector sinh()
    {
        return (MutableSpeedVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector sqrt()
    {
        return (MutableSpeedVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector tan()
    {
        return (MutableSpeedVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector tanh()
    {
        return (MutableSpeedVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector toDegrees()
    {
        return (MutableSpeedVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector toRadians()
    {
        return (MutableSpeedVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector inv()
    {
        return (MutableSpeedVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector multiplyBy(final double constant)
    {
        return (MutableSpeedVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableSpeedVector divideBy(final double constant)
    {
        return (MutableSpeedVector) super.divideBy(constant);
    }

}
