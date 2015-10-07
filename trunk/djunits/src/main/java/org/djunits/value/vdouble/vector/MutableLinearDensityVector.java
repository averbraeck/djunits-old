package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LinearDensityUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.LinearDensity;

/**
 * Mutable LinearDensity Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableLinearDensityVector extends MutableDoubleVector.Rel<LinearDensityUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableLinearDensityVector(final LinearDensityUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableLinearDensityVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract LinearDensityVector immutable();

    /** {@inheritDoc} */
    public abstract MutableLinearDensityVector toDense();

    /** {@inheritDoc} */
    public abstract MutableLinearDensityVector toSparse();

    /**
     * Double Dense Relative Immutable LinearDensity class.
     */
    public static class Dense extends MutableLinearDensityVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double LinearDensity Vector. An lineardensity is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double LinearDensity Vector
         * @param unit U; the unit of the new Dense Immutable LinearDensity Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final LinearDensityUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An lineardensity is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable LinearDensity Vector
         * @param unit U; the unit of the new Relative Dense Immutable LinearDensity Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final LinearDensityUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;LinearDensity&gt;; the values of the Scalar LinearDensity entries in the new Relative Dense
         *            Immutable LinearDensity Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<LinearDensityUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable LinearDensity Vector. An lineardensity is always relative.
         * @param values LinearDensity[]; the values of the Scalar LinearDensity entries in the new Relative Dense Immutable
         *            LinearDensity Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final LinearDensity[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable LinearDensity Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final LinearDensityUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensityVector immutable()
        {
            setCopyOnWrite(true);
            return new LinearDensityVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLinearDensityVector mutable()
        {
            setCopyOnWrite(true);
            final MutableLinearDensityVector.Dense result = new MutableLinearDensityVector.Dense(getData(), getUnit());
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
        public final MutableLinearDensityVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLinearDensityVector toSparse()
        {
            return new MutableLinearDensityVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable LinearDensity class.
     */
    public static class Sparse extends MutableLinearDensityVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable LinearDensity Vector. An lineardensity is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable LinearDensity Vector
         * @param unit LinearDensityUnit; the unit of the new Relative Sparse Immutable LinearDensity Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final LinearDensityUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable LinearDensity Vector. An lineardensity is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            LinearDensity Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<LinearDensityUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double LinearDensity Vector. An lineardensity is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double LinearDensity Vector
         * @param unit U; the unit of the new Sparse Immutable LinearDensity Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final LinearDensityUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable LinearDensity Vector. An lineardensity is always relative.
         * @param values LinearDensity[]; the values of the Scalar LinearDensity entries in the new Relative Sparse Immutable
         *            LinearDensity Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final LinearDensity[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable LinearDensity Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final LinearDensityUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensityVector immutable()
        {
            setCopyOnWrite(true);
            return new LinearDensityVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLinearDensityVector mutable()
        {
            setCopyOnWrite(true);
            final MutableLinearDensityVector.Sparse result =
                new MutableLinearDensityVector.Sparse(getData(), getUnit());
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
        public final MutableLinearDensityVector toDense()
        {
            return new MutableLinearDensityVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLinearDensityVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final LinearDensity get(final int index) throws ValueException
    {
        return (LinearDensity) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector copy()
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
    public final LinearDensityVector plus(final LinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector minus(final LinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector times(final LinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector divide(final LinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector plus(final MutableLinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector minus(final MutableLinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector times(final MutableLinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final LinearDensityVector divide(final MutableLinearDensityVector rel) throws ValueException
    {
        return LinearDensityVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector abs()
    {
        return (MutableLinearDensityVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector acos()
    {
        return (MutableLinearDensityVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector asin()
    {
        return (MutableLinearDensityVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector atan()
    {
        return (MutableLinearDensityVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector cbrt()
    {
        return (MutableLinearDensityVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector ceil()
    {
        return (MutableLinearDensityVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector cos()
    {
        return (MutableLinearDensityVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector cosh()
    {
        return (MutableLinearDensityVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector exp()
    {
        return (MutableLinearDensityVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector expm1()
    {
        return (MutableLinearDensityVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector floor()
    {
        return (MutableLinearDensityVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector log()
    {
        return (MutableLinearDensityVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector log10()
    {
        return (MutableLinearDensityVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector log1p()
    {
        return (MutableLinearDensityVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector pow(final double x)
    {
        return (MutableLinearDensityVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector rint()
    {
        return (MutableLinearDensityVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector round()
    {
        return (MutableLinearDensityVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector signum()
    {
        return (MutableLinearDensityVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector sin()
    {
        return (MutableLinearDensityVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector sinh()
    {
        return (MutableLinearDensityVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector sqrt()
    {
        return (MutableLinearDensityVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector tan()
    {
        return (MutableLinearDensityVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector tanh()
    {
        return (MutableLinearDensityVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector toDegrees()
    {
        return (MutableLinearDensityVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector toRadians()
    {
        return (MutableLinearDensityVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector inv()
    {
        return (MutableLinearDensityVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector multiplyBy(final double constant)
    {
        return (MutableLinearDensityVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector divideBy(final double constant)
    {
        return (MutableLinearDensityVector) super.divideBy(constant);
    }

}
