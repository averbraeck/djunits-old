package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.%Type%Unit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.%Type%;
import org.djunits.value.vdouble.scalar.DoubleScalar;

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
public abstract class Mutable%Type%Vector extends MutableDoubleVector.Rel<%Type%Unit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public Mutable%Type%Vector(final %Type%Unit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract Mutable%Type%Vector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract %Type%Vector immutable();

    /** {@inheritDoc} */
    public abstract Mutable%Type%Vector toDense();

    /** {@inheritDoc} */
    public abstract Mutable%Type%Vector toSparse();

    /**
     * Double Dense Relative Immutable %Type% class.
     */
    public static class Dense extends Mutable%Type%Vector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double %Type% Vector. An %type% is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double %Type% Vector
         * @param unit U; the unit of the new Dense Immutable %Type% Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final %Type%Unit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An %type% is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable %Type% Vector
         * @param unit U; the unit of the new Relative Dense Immutable %Type% Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final %Type%Unit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;%Type%&gt;; the values of the Scalar %Type% entries in the new Relative Dense
         *            Immutable %Type% Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<%Type%Unit>> values) throws ValueException
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
        public Dense(final %Type%[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable %Type% Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final %Type%Unit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%Vector immutable()
        {
            setCopyOnWrite(true);
            return new %Type%Vector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector mutable()
        {
            setCopyOnWrite(true);
            final Mutable%Type%Vector.Dense result = new Mutable%Type%Vector.Dense(getData(), getUnit());
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
        public final Mutable%Type%Vector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector toSparse()
        {
            return new Mutable%Type%Vector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable %Type% class.
     */
    public static class Sparse extends Mutable%Type%Vector implements SparseData
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
        public Sparse(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable %Type% Vector. An %type% is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            %Type% Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<%Type%Unit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double %Type% Vector. An %type% is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double %Type% Vector
         * @param unit U; the unit of the new Sparse Immutable %Type% Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final %Type%Unit unit) throws ValueException
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
        public Sparse(final %Type%[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable %Type% Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final %Type%Unit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%Vector immutable()
        {
            setCopyOnWrite(true);
            return new %Type%Vector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector mutable()
        {
            setCopyOnWrite(true);
            final Mutable%Type%Vector.Sparse result = new Mutable%Type%Vector.Sparse(getData(), getUnit());
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
        public final Mutable%Type%Vector toDense()
        {
            return new Mutable%Type%Vector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final %Type% get(final int index) throws ValueException
    {
        return (%Type%) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector copy()
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
    public final %Type%Vector plus(final %Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector minus(final %Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector times(final %Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector divide(final %Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector plus(final Mutable%Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector minus(final Mutable%Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector times(final Mutable%Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Type%Vector divide(final Mutable%Type%Vector rel) throws ValueException
    {
        return %Type%Vector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector abs()
    {
        return (Mutable%Type%Vector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector acos()
    {
        return (Mutable%Type%Vector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector asin()
    {
        return (Mutable%Type%Vector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector atan()
    {
        return (Mutable%Type%Vector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector cbrt()
    {
        return (Mutable%Type%Vector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector ceil()
    {
        return (Mutable%Type%Vector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector cos()
    {
        return (Mutable%Type%Vector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector cosh()
    {
        return (Mutable%Type%Vector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector exp()
    {
        return (Mutable%Type%Vector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector expm1()
    {
        return (Mutable%Type%Vector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector floor()
    {
        return (Mutable%Type%Vector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector log()
    {
        return (Mutable%Type%Vector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector log10()
    {
        return (Mutable%Type%Vector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector log1p()
    {
        return (Mutable%Type%Vector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector pow(final double x)
    {
        return (Mutable%Type%Vector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector rint()
    {
        return (Mutable%Type%Vector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector round()
    {
        return (Mutable%Type%Vector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector signum()
    {
        return (Mutable%Type%Vector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector sin()
    {
        return (Mutable%Type%Vector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector sinh()
    {
        return (Mutable%Type%Vector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector sqrt()
    {
        return (Mutable%Type%Vector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector tan()
    {
        return (Mutable%Type%Vector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector tanh()
    {
        return (Mutable%Type%Vector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector toDegrees()
    {
        return (Mutable%Type%Vector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector toRadians()
    {
        return (Mutable%Type%Vector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector inv()
    {
        return (Mutable%Type%Vector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector multiplyBy(final double constant)
    {
        return (Mutable%Type%Vector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Vector divideBy(final double constant)
    {
        return (Mutable%Type%Vector) super.divideBy(constant);
    }
    
%FORMULAS%%Type%.Rel%
}


