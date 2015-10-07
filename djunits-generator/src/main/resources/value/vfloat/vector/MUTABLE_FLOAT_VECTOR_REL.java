package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.%Type%Unit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.Float%Type%;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Mutable %Type% Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableFloat%Type%Vector extends MutableFloatVector.Rel<%Type%Unit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableFloat%Type%Vector(final %Type%Unit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableFloat%Type%Vector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract Float%Type%Vector immutable();

    /** {@inheritDoc} */
    public abstract MutableFloat%Type%Vector toDense();

    /** {@inheritDoc} */
    public abstract MutableFloat%Type%Vector toSparse();

    /**
     * Float Dense Relative Immutable %Type% class.
     */
    public static class Dense extends MutableFloat%Type%Vector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Float %Type% Vector. An %type% is always relative.
         * @param values float[]; the values of the entries in the new Dense Immutable Float %Type% Vector
         * @param unit U; the unit of the new Dense Immutable %Type% Vector
         * @throws ValueException when values is null
         */
        public Dense(final float[] values, final %Type%Unit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable FloatVector. An %type% is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable %Type% Vector
         * @param unit U; the unit of the new Relative Dense Immutable %Type% Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Float> values, final %Type%Unit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable FloatVector.
         * @param values List&lt;%Type%&gt;; the values of the Scalar %Type% entries in the new Relative Dense
         *            Immutable %Type% Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<FloatScalar.Rel<%Type%Unit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable %Type% Vector. An %type% is always relative.
         * @param values %Type%[]; the values of the Scalar %Type% entries in the new Relative Dense Immutable
         *            %Type% Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Float%Type%[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable %Type% Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final FloatVectorDataDense data, final %Type%Unit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%Vector immutable()
        {
            setCopyOnWrite(true);
            return new Float%Type%Vector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector mutable()
        {
            setCopyOnWrite(true);
            final MutableFloat%Type%Vector.Dense result = new MutableFloat%Type%Vector.Dense(getData(), getUnit());
            result.setCopyOnWrite(true);
            return result;
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVectorDataDense getData()
        {
            return (FloatVectorDataDense) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector toSparse()
        {
            return new MutableFloat%Type%Vector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Float Sparse Relative Immutable %Type% class.
     */
    public static class Sparse extends MutableFloat%Type%Vector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable %Type% Vector. An %type% is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable %Type% Vector
         * @param unit %Type%Unit; the unit of the new Relative Sparse Immutable %Type% Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable %Type% Vector. An %type% is always relative.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            %Type% Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, FloatScalar.Rel<%Type%Unit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Float %Type% Vector. An %type% is always relative.
         * @param values float[]; the values of the entries in the new Sparse Immutable Float %Type% Vector
         * @param unit U; the unit of the new Sparse Immutable %Type% Vector
         * @throws ValueException when values is null
         */
        public Sparse(final float[] values, final %Type%Unit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable %Type% Vector. An %type% is always relative.
         * @param values %Type%[]; the values of the Scalar %Type% entries in the new Relative Sparse Immutable
         *            %Type% Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Float%Type%[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable %Type% Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final FloatVectorDataSparse data, final %Type%Unit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%Vector immutable()
        {
            setCopyOnWrite(true);
            return new Float%Type%Vector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector mutable()
        {
            setCopyOnWrite(true);
            final MutableFloat%Type%Vector.Sparse result = new MutableFloat%Type%Vector.Sparse(getData(), getUnit());
            result.setCopyOnWrite(true);
            return result;
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVectorDataSparse getData()
        {
            return (FloatVectorDataSparse) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector toDense()
        {
            return new MutableFloat%Type%Vector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Float%Type% get(final int index) throws ValueException
    {
        return (Float%Type%) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector copy()
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
    public final Float%Type%Vector plus(final Float%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector minus(final Float%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector times(final Float%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector divide(final Float%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector plus(final MutableFloat%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector minus(final MutableFloat%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector times(final MutableFloat%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final Float%Type%Vector divide(final MutableFloat%Type%Vector rel) throws ValueException
    {
        return Float%Type%Vector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector abs()
    {
        return (MutableFloat%Type%Vector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector acos()
    {
        return (MutableFloat%Type%Vector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector asin()
    {
        return (MutableFloat%Type%Vector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector atan()
    {
        return (MutableFloat%Type%Vector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector cbrt()
    {
        return (MutableFloat%Type%Vector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector ceil()
    {
        return (MutableFloat%Type%Vector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector cos()
    {
        return (MutableFloat%Type%Vector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector cosh()
    {
        return (MutableFloat%Type%Vector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector exp()
    {
        return (MutableFloat%Type%Vector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector expm1()
    {
        return (MutableFloat%Type%Vector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector floor()
    {
        return (MutableFloat%Type%Vector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector log()
    {
        return (MutableFloat%Type%Vector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector log10()
    {
        return (MutableFloat%Type%Vector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector log1p()
    {
        return (MutableFloat%Type%Vector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector pow(final double x)
    {
        return (MutableFloat%Type%Vector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector rint()
    {
        return (MutableFloat%Type%Vector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector round()
    {
        return (MutableFloat%Type%Vector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector signum()
    {
        return (MutableFloat%Type%Vector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector sin()
    {
        return (MutableFloat%Type%Vector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector sinh()
    {
        return (MutableFloat%Type%Vector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector sqrt()
    {
        return (MutableFloat%Type%Vector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector tan()
    {
        return (MutableFloat%Type%Vector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector tanh()
    {
        return (MutableFloat%Type%Vector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector toDegrees()
    {
        return (MutableFloat%Type%Vector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector toRadians()
    {
        return (MutableFloat%Type%Vector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector inv()
    {
        return (MutableFloat%Type%Vector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector multiplyBy(final float constant)
    {
        return (MutableFloat%Type%Vector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector divideBy(final float constant)
    {
        return (MutableFloat%Type%Vector) super.divideBy(constant);
    }
    
%FORMULAS%%Type%.Rel%
}

