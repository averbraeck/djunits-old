package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AreaUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Area;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable Area Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableAreaVector extends MutableDoubleVector.Rel<AreaUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableAreaVector(final AreaUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableAreaVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract AreaVector immutable();

    /** {@inheritDoc} */
    public abstract MutableAreaVector toDense();

    /** {@inheritDoc} */
    public abstract MutableAreaVector toSparse();

    /**
     * Double Dense Relative Immutable Area class.
     */
    public static class Dense extends MutableAreaVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Area Vector. An area is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Area Vector
         * @param unit U; the unit of the new Dense Immutable Area Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final AreaUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Area Vector
         * @param unit U; the unit of the new Relative Dense Immutable Area Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final AreaUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Area&gt;; the values of the Scalar Area entries in the new Relative Dense Immutable Area Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<AreaUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Area Vector. An area is always relative.
         * @param values Area[]; the values of the Scalar Area entries in the new Relative Dense Immutable Area Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Area[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Area Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final AreaUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final AreaVector immutable()
        {
            setCopyOnWrite(true);
            return new AreaVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAreaVector mutable()
        {
            setCopyOnWrite(true);
            final MutableAreaVector.Dense result = new MutableAreaVector.Dense(getData(), getUnit());
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
        public final MutableAreaVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAreaVector toSparse()
        {
            return new MutableAreaVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Area class.
     */
    public static class Sparse extends MutableAreaVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Area Vector. An area is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Area Vector
         * @param unit AreaUnit; the unit of the new Relative Sparse Immutable Area Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final AreaUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Area Vector. An area is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Area Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<AreaUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Area Vector. An area is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Area Vector
         * @param unit U; the unit of the new Sparse Immutable Area Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final AreaUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Area Vector. An area is always relative.
         * @param values Area[]; the values of the Scalar Area entries in the new Relative Sparse Immutable Area Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Area[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Area Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final AreaUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final AreaVector immutable()
        {
            setCopyOnWrite(true);
            return new AreaVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAreaVector mutable()
        {
            setCopyOnWrite(true);
            final MutableAreaVector.Sparse result = new MutableAreaVector.Sparse(getData(), getUnit());
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
        public final MutableAreaVector toDense()
        {
            return new MutableAreaVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAreaVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Area get(final int index) throws ValueException
    {
        return (Area) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector copy()
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
    public final AreaVector plus(final AreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector minus(final AreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector times(final AreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector divide(final AreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector plus(final MutableAreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector minus(final MutableAreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector times(final MutableAreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AreaVector divide(final MutableAreaVector rel) throws ValueException
    {
        return AreaVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector abs()
    {
        return (MutableAreaVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector acos()
    {
        return (MutableAreaVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector asin()
    {
        return (MutableAreaVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector atan()
    {
        return (MutableAreaVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector cbrt()
    {
        return (MutableAreaVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector ceil()
    {
        return (MutableAreaVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector cos()
    {
        return (MutableAreaVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector cosh()
    {
        return (MutableAreaVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector exp()
    {
        return (MutableAreaVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector expm1()
    {
        return (MutableAreaVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector floor()
    {
        return (MutableAreaVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector log()
    {
        return (MutableAreaVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector log10()
    {
        return (MutableAreaVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector log1p()
    {
        return (MutableAreaVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector pow(final double x)
    {
        return (MutableAreaVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector rint()
    {
        return (MutableAreaVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector round()
    {
        return (MutableAreaVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector signum()
    {
        return (MutableAreaVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector sin()
    {
        return (MutableAreaVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector sinh()
    {
        return (MutableAreaVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector sqrt()
    {
        return (MutableAreaVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector tan()
    {
        return (MutableAreaVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector tanh()
    {
        return (MutableAreaVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector toDegrees()
    {
        return (MutableAreaVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector toRadians()
    {
        return (MutableAreaVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector inv()
    {
        return (MutableAreaVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector multiplyBy(final double constant)
    {
        return (MutableAreaVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaVector divideBy(final double constant)
    {
        return (MutableAreaVector) super.divideBy(constant);
    }

}
