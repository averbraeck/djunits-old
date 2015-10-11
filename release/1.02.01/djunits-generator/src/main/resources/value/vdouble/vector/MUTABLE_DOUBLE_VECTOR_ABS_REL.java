package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.%Type%Unit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.%Type%;

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
public interface Mutable%Type%Vector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of %Type%Vector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<%Type%Unit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable%Type%Vector.
         * @param unit U; the unit of the new Absolute Mutable%Type%Vector
         */
        protected Abs(final %Type%Unit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract Mutable%Type%Vector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract %Type%Vector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract Mutable%Type%Vector.Abs copy();

        /** {@inheritDoc} */
        public abstract Mutable%Type%Vector.Abs toDense();

        /** {@inheritDoc} */
        public abstract Mutable%Type%Vector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of Mutable%Type%Vector.
         */
        public static class Dense extends Mutable%Type%Vector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable %Type%Vector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable %Type%Vector
             * @param unit U; the unit of the new Absolute Dense Mutable%Type%Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable %Type%Vector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable %Type%Vector
             * @param unit U; the unit of the new Absolute Dense Mutable %Type%Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable %Type%Vector.
             * @param values %Type%.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            Mutable%Type%Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final %Type%.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable %Type%Vector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable %Type%Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<%Type%Unit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable %Type%Vector.
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
            @SuppressWarnings("designforextension")
            public %Type%Vector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new %Type%Vector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Mutable%Type%Vector.Abs mutable()
            {
                setCopyOnWrite(true);
                final Mutable%Type%Vector.Abs.Dense result =
                    new Mutable%Type%Vector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public Mutable%Type%Vector.Abs copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataDense getData()
            {
                return (DoubleVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Mutable%Type%Vector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Mutable%Type%Vector.Abs toSparse()
            {
                return new Mutable%Type%Vector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of Mutable%Type%Vector.
         */
        public static class Sparse extends Mutable%Type%Vector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable %Type%Vector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable %Type%Vector
             * @param unit U; the unit of the new Absolute Sparse Mutable %Type%Vector
             * @param %type% the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int %type%)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, %type%);
            }

            /**
             * Construct a new Absolute Sparse Mutable %Type%Vector.
             * @param values %Type%.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            %Type%Vector
             * @param %type% the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<%Type%Unit>> values, final int %type%) throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, %type%);
            }

            /**
             * Construct a new Absolute Sparse Mutable %Type%Vector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable %Type%Vector
             * @param unit U; the unit of the new Absolute Sparse Mutable %Type%Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable %Type%Vector.
             * @param values %Type%.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            %Type%Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final %Type%.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable %Type%Vector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable %Type%Vector
             */
            Sparse(final DoubleVectorDataSparse data, final %Type%Unit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public %Type%Vector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new %Type%Vector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public Mutable%Type%Vector.Abs mutable()
            {
                setCopyOnWrite(true);
                final Mutable%Type%Vector.Abs.Sparse result =
                    new Mutable%Type%Vector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public Mutable%Type%Vector.Abs copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataSparse getData()
            {
                return (DoubleVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Mutable%Type%Vector.Abs toDense()
            {
                return new Mutable%Type%Vector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Mutable%Type%Vector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public %Type%.Abs get(final int index) throws ValueException
        {
            return new %Type%.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Abs plus(final %Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Abs minus(final %Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel minus(final %Type%Vector.Abs abs) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs abs()
        {
            return (Mutable%Type%Vector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs acos()
        {
            return (Mutable%Type%Vector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs asin()
        {
            return (Mutable%Type%Vector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs atan()
        {
            return (Mutable%Type%Vector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs cbrt()
        {
            return (Mutable%Type%Vector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs ceil()
        {
            return (Mutable%Type%Vector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs cos()
        {
            return (Mutable%Type%Vector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs cosh()
        {
            return (Mutable%Type%Vector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs exp()
        {
            return (Mutable%Type%Vector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs expm1()
        {
            return (Mutable%Type%Vector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs floor()
        {
            return (Mutable%Type%Vector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs log()
        {
            return (Mutable%Type%Vector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs log10()
        {
            return (Mutable%Type%Vector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs log1p()
        {
            return (Mutable%Type%Vector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs pow(final double x)
        {
            return (Mutable%Type%Vector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs rint()
        {
            return (Mutable%Type%Vector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs round()
        {
            return (Mutable%Type%Vector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs signum()
        {
            return (Mutable%Type%Vector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs sin()
        {
            return (Mutable%Type%Vector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs sinh()
        {
            return (Mutable%Type%Vector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs sqrt()
        {
            return (Mutable%Type%Vector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs tan()
        {
            return (Mutable%Type%Vector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs tanh()
        {
            return (Mutable%Type%Vector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs toDegrees()
        {
            return (Mutable%Type%Vector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs toRadians()
        {
            return (Mutable%Type%Vector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs inv()
        {
            return (Mutable%Type%Vector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs multiplyBy(final double constant)
        {
            return (Mutable%Type%Vector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Abs divideBy(final double constant)
        {
            return (Mutable%Type%Vector.Abs) super.divideBy(constant);
        }
        
%FORMULAS%%Type%.Abs%

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of %Type%Vector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<%Type%Unit> 
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute Mutable%Type%Vector.
         * @param unit U; the unit of the new Absolute Mutable%Type%Vector
         */
        protected Rel(final %Type%Unit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract Mutable%Type%Vector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract %Type%Vector.Rel immutable();

        /** {@inheritDoc} */
        public abstract Mutable%Type%Vector.Rel toDense();

        /** {@inheritDoc} */
        public abstract Mutable%Type%Vector.Rel toSparse();

        /**
         * Double Dense Relative Immutable %Type% class.
         */
        public static class Dense extends Mutable%Type%Vector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double %Type% Vector. An area is always relative.
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
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
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
             * @param values List&lt;%Type%&gt;; the values of the Scalar %Type% entries in the new Relative Dense Immutable
             *            %Type% Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<%Type%Unit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable %Type% Vector. An area is always relative.
             * @param values %Type%[]; the values of the Scalar %Type% entries in the new Relative Dense Immutable %Type% Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final %Type%.Rel[] values) throws ValueException
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
            public final %Type%Vector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new %Type%Vector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final Mutable%Type%Vector.Rel mutable()
            {
                setCopyOnWrite(true);
                final Mutable%Type%Vector.Rel.Dense result = new Mutable%Type%Vector.Rel.Dense(getData(), getUnit());
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
            public final Mutable%Type%Vector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final Mutable%Type%Vector.Rel toSparse()
            {
                return new Mutable%Type%Vector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable %Type% class.
         */
        public static class Sparse extends Mutable%Type%Vector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable %Type% Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable %Type% Vector
             * @param unit %Type%Unit; the unit of the new Relative Sparse Immutable %Type% Vector
             * @param %type% the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int %type%)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, %type%);
            }

            /**
             * Construct a new Sparse Immutable %Type% Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable %Type%
             *            Vector
             * @param %type% the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<%Type%Unit>> values, final int %type%)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, %type%);
            }

            /**
             * Construct a new Sparse Immutable Double %Type% Vector. An area is always relative.
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
             * Construct a new Relative Sparse Immutable %Type% Vector. An area is always relative.
             * @param values %Type%[]; the values of the Scalar %Type% entries in the new Relative Sparse Immutable %Type%
             *            Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final %Type%.Rel[] values) throws ValueException
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
            public final %Type%Vector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new %Type%Vector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final Mutable%Type%Vector.Rel mutable()
            {
                setCopyOnWrite(true);
                final Mutable%Type%Vector.Rel.Sparse result = new Mutable%Type%Vector.Rel.Sparse(getData(), getUnit());
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
            public final Mutable%Type%Vector.Rel toDense()
            {
                return new Mutable%Type%Vector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final Mutable%Type%Vector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel get(final int index) throws ValueException
        {
            return (%Type%.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel copy()
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
        public final %Type%Vector.Rel plus(final %Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel minus(final %Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel times(final %Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel divide(final %Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel plus(final Mutable%Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel minus(final Mutable%Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel times(final Mutable%Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final %Type%Vector.Rel divide(final Mutable%Type%Vector.Rel rel) throws ValueException
        {
            return %Type%Vector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel abs()
        {
            return (Mutable%Type%Vector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel acos()
        {
            return (Mutable%Type%Vector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel asin()
        {
            return (Mutable%Type%Vector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel atan()
        {
            return (Mutable%Type%Vector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel cbrt()
        {
            return (Mutable%Type%Vector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel ceil()
        {
            return (Mutable%Type%Vector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel cos()
        {
            return (Mutable%Type%Vector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel cosh()
        {
            return (Mutable%Type%Vector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel exp()
        {
            return (Mutable%Type%Vector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel expm1()
        {
            return (Mutable%Type%Vector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel floor()
        {
            return (Mutable%Type%Vector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel log()
        {
            return (Mutable%Type%Vector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel log10()
        {
            return (Mutable%Type%Vector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel log1p()
        {
            return (Mutable%Type%Vector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel pow(final double x)
        {
            return (Mutable%Type%Vector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel rint()
        {
            return (Mutable%Type%Vector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel round()
        {
            return (Mutable%Type%Vector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel signum()
        {
            return (Mutable%Type%Vector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel sin()
        {
            return (Mutable%Type%Vector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel sinh()
        {
            return (Mutable%Type%Vector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel sqrt()
        {
            return (Mutable%Type%Vector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel tan()
        {
            return (Mutable%Type%Vector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel tanh()
        {
            return (Mutable%Type%Vector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel toDegrees()
        {
            return (Mutable%Type%Vector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel toRadians()
        {
            return (Mutable%Type%Vector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel inv()
        {
            return (Mutable%Type%Vector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel multiplyBy(final double constant)
        {
            return (Mutable%Type%Vector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final Mutable%Type%Vector.Rel divideBy(final double constant)
        {
            return (Mutable%Type%Vector.Rel) super.divideBy(constant);
        }
        
%FORMULAS%%Type%.Rel%

    }
}
