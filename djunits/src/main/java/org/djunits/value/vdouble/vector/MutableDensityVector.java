package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DensityUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Density;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable Density Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableDensityVector extends MutableDoubleVector.Rel<DensityUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableDensityVector(final DensityUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableDensityVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract DensityVector immutable();

    /** {@inheritDoc} */
    public abstract MutableDensityVector toDense();

    /** {@inheritDoc} */
    public abstract MutableDensityVector toSparse();

    /**
     * Double Dense Relative Immutable Density class.
     */
    public static class Dense extends MutableDensityVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Density Vector. An density is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Density Vector
         * @param unit U; the unit of the new Dense Immutable Density Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final DensityUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An density is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Density Vector
         * @param unit U; the unit of the new Relative Dense Immutable Density Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final DensityUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Density&gt;; the values of the Scalar Density entries in the new Relative Dense Immutable
         *            Density Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<DensityUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Density Vector. An density is always relative.
         * @param values Density[]; the values of the Scalar Density entries in the new Relative Dense Immutable Density Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Density[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Density Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final DensityUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final DensityVector immutable()
        {
            setCopyOnWrite(true);
            return new DensityVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDensityVector mutable()
        {
            setCopyOnWrite(true);
            final MutableDensityVector.Dense result = new MutableDensityVector.Dense(getData(), getUnit());
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
        public final MutableDensityVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDensityVector toSparse()
        {
            return new MutableDensityVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Density class.
     */
    public static class Sparse extends MutableDensityVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Density Vector. An density is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Density Vector
         * @param unit DensityUnit; the unit of the new Relative Sparse Immutable Density Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final DensityUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Density Vector. An density is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Density
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<DensityUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Density Vector. An density is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Density Vector
         * @param unit U; the unit of the new Sparse Immutable Density Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final DensityUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Density Vector. An density is always relative.
         * @param values Density[]; the values of the Scalar Density entries in the new Relative Sparse Immutable Density Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Density[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Density Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final DensityUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final DensityVector immutable()
        {
            setCopyOnWrite(true);
            return new DensityVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDensityVector mutable()
        {
            setCopyOnWrite(true);
            final MutableDensityVector.Sparse result = new MutableDensityVector.Sparse(getData(), getUnit());
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
        public final MutableDensityVector toDense()
        {
            return new MutableDensityVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDensityVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Density get(final int index) throws ValueException
    {
        return (Density) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector copy()
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
    public final DensityVector plus(final DensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector minus(final DensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector times(final DensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector divide(final DensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector plus(final MutableDensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector minus(final MutableDensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector times(final MutableDensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final DensityVector divide(final MutableDensityVector rel) throws ValueException
    {
        return DensityVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector abs()
    {
        return (MutableDensityVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector acos()
    {
        return (MutableDensityVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector asin()
    {
        return (MutableDensityVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector atan()
    {
        return (MutableDensityVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector cbrt()
    {
        return (MutableDensityVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector ceil()
    {
        return (MutableDensityVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector cos()
    {
        return (MutableDensityVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector cosh()
    {
        return (MutableDensityVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector exp()
    {
        return (MutableDensityVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector expm1()
    {
        return (MutableDensityVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector floor()
    {
        return (MutableDensityVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector log()
    {
        return (MutableDensityVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector log10()
    {
        return (MutableDensityVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector log1p()
    {
        return (MutableDensityVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector pow(final double x)
    {
        return (MutableDensityVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector rint()
    {
        return (MutableDensityVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector round()
    {
        return (MutableDensityVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector signum()
    {
        return (MutableDensityVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector sin()
    {
        return (MutableDensityVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector sinh()
    {
        return (MutableDensityVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector sqrt()
    {
        return (MutableDensityVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector tan()
    {
        return (MutableDensityVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector tanh()
    {
        return (MutableDensityVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector toDegrees()
    {
        return (MutableDensityVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector toRadians()
    {
        return (MutableDensityVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector inv()
    {
        return (MutableDensityVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector multiplyBy(final double constant)
    {
        return (MutableDensityVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector divideBy(final double constant)
    {
        return (MutableDensityVector) super.divideBy(constant);
    }

}
