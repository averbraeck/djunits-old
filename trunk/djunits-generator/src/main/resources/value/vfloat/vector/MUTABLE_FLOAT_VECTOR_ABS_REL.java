package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.%Type%Unit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;
import org.djunits.value.vfloat.scalar.Float%Type%;

/**
 * Mutable Float%Type% Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloat%Type%Vector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of Float%Type%Vector.
     */
    public abstract static class Abs extends MutableFloatVector.Abs<%Type%Unit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableFloat%Type%Vector.
         * @param unit U; the unit of the new Absolute MutableFloat%Type%Vector
         */
        protected Abs(final %Type%Unit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloat%Type%Vector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract Float%Type%Vector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloat%Type%Vector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableFloat%Type%Vector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableFloat%Type%Vector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableFloat%Type%Vector.
         */
        public static class Dense extends MutableFloat%Type%Vector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable Float%Type%Vector.
             * @param values float[]; the values of the entries in the new Absolute Dense Mutable Float%Type%Vector
             * @param unit U; the unit of the new Absolute Dense MutableFloat%Type%Vector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable Float%Type%Vector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable Float%Type%Vector
             * @param unit U; the unit of the new Absolute Dense Mutable Float%Type%Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Float> values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable Float%Type%Vector.
             * @param values Float%Type%.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            MutableFloat%Type%Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Float%Type%.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable Float%Type%Vector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable Float%Type%Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Abs<%Type%Unit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable Float%Type%Vector.
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
            @SuppressWarnings("designforextension")
            public Float%Type%Vector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new Float%Type%Vector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloat%Type%Vector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableFloat%Type%Vector.Abs.Dense result =
                    new MutableFloat%Type%Vector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableFloat%Type%Vector.Abs copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final FloatVectorDataDense getData()
            {
                return (FloatVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloat%Type%Vector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloat%Type%Vector.Abs toSparse()
            {
                return new MutableFloat%Type%Vector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableFloat%Type%Vector.
         */
        public static class Sparse extends MutableFloat%Type%Vector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable Float%Type%Vector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Float%Type%Vector
             * @param unit U; the unit of the new Absolute Sparse Mutable Float%Type%Vector
             * @param %type% the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int %type%)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, %type%);
            }

            /**
             * Construct a new Absolute Sparse Mutable Float%Type%Vector.
             * @param values Float%Type%.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            Float%Type%Vector
             * @param %type% the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Abs<%Type%Unit>> values, final int %type%) throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, %type%);
            }

            /**
             * Construct a new Absolute Sparse Mutable Float%Type%Vector.
             * @param values float[]; the values of the entries in the new Absolute Sparse Mutable Float%Type%Vector
             * @param unit U; the unit of the new Absolute Sparse Mutable Float%Type%Vector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable Float%Type%Vector.
             * @param values Float%Type%.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            Float%Type%Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Float%Type%.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable Float%Type%Vector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable Float%Type%Vector
             */
            Sparse(final FloatVectorDataSparse data, final %Type%Unit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public Float%Type%Vector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new Float%Type%Vector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableFloat%Type%Vector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableFloat%Type%Vector.Abs.Sparse result =
                    new MutableFloat%Type%Vector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableFloat%Type%Vector.Abs copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final FloatVectorDataSparse getData()
            {
                return (FloatVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloat%Type%Vector.Abs toDense()
            {
                return new MutableFloat%Type%Vector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloat%Type%Vector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public Float%Type%.Abs get(final int index) throws ValueException
        {
            return new Float%Type%.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Abs plus(final Float%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Abs minus(final Float%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel minus(final Float%Type%Vector.Abs abs) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs abs()
        {
            return (MutableFloat%Type%Vector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs acos()
        {
            return (MutableFloat%Type%Vector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs asin()
        {
            return (MutableFloat%Type%Vector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs atan()
        {
            return (MutableFloat%Type%Vector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs cbrt()
        {
            return (MutableFloat%Type%Vector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs ceil()
        {
            return (MutableFloat%Type%Vector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs cos()
        {
            return (MutableFloat%Type%Vector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs cosh()
        {
            return (MutableFloat%Type%Vector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs exp()
        {
            return (MutableFloat%Type%Vector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs expm1()
        {
            return (MutableFloat%Type%Vector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs floor()
        {
            return (MutableFloat%Type%Vector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs log()
        {
            return (MutableFloat%Type%Vector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs log10()
        {
            return (MutableFloat%Type%Vector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs log1p()
        {
            return (MutableFloat%Type%Vector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs pow(final double x)
        {
            return (MutableFloat%Type%Vector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs rint()
        {
            return (MutableFloat%Type%Vector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs round()
        {
            return (MutableFloat%Type%Vector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs signum()
        {
            return (MutableFloat%Type%Vector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs sin()
        {
            return (MutableFloat%Type%Vector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs sinh()
        {
            return (MutableFloat%Type%Vector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs sqrt()
        {
            return (MutableFloat%Type%Vector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs tan()
        {
            return (MutableFloat%Type%Vector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs tanh()
        {
            return (MutableFloat%Type%Vector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs toDegrees()
        {
            return (MutableFloat%Type%Vector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs toRadians()
        {
            return (MutableFloat%Type%Vector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs inv()
        {
            return (MutableFloat%Type%Vector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs multiplyBy(final float constant)
        {
            return (MutableFloat%Type%Vector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Abs divideBy(final float constant)
        {
            return (MutableFloat%Type%Vector.Abs) super.divideBy(constant);
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of Float%Type%Vector.
     */
    public abstract static class Rel extends MutableFloatVector.Rel<%Type%Unit> 
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableFloat%Type%Vector.
         * @param unit U; the unit of the new Absolute MutableFloat%Type%Vector
         */
        protected Rel(final %Type%Unit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloat%Type%Vector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract Float%Type%Vector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableFloat%Type%Vector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableFloat%Type%Vector.Rel toSparse();

        /**
         * Float Dense Relative Immutable Float%Type% class.
         */
        public static class Dense extends MutableFloat%Type%Vector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Float Float%Type% Vector. An area is always relative.
             * @param values float[]; the values of the entries in the new Dense Immutable Float Float%Type% Vector
             * @param unit U; the unit of the new Dense Immutable Float%Type% Vector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable Float%Type% Vector
             * @param unit U; the unit of the new Relative Dense Immutable Float%Type% Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Float> values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param values List&lt;Float%Type%&gt;; the values of the Scalar Float%Type% entries in the new Relative Dense Immutable
             *            Float%Type% Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Rel<%Type%Unit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable Float%Type% Vector. An area is always relative.
             * @param values Float%Type%[]; the values of the Scalar Float%Type% entries in the new Relative Dense Immutable Float%Type% Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Float%Type%.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable Float%Type% Vector.
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
            public final Float%Type%Vector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new Float%Type%Vector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloat%Type%Vector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableFloat%Type%Vector.Rel.Dense result = new MutableFloat%Type%Vector.Rel.Dense(getData(), getUnit());
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
            public final MutableFloat%Type%Vector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloat%Type%Vector.Rel toSparse()
            {
                return new MutableFloat%Type%Vector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Float Sparse Relative Immutable Float%Type% class.
         */
        public static class Sparse extends MutableFloat%Type%Vector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable Float%Type% Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable Float%Type% Vector
             * @param unit %Type%Unit; the unit of the new Relative Sparse Immutable Float%Type% Vector
             * @param %type% the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int %type%)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, %type%);
            }

            /**
             * Construct a new Sparse Immutable Float%Type% Vector. An area is always relative.
             * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Float%Type%
             *            Vector
             * @param %type% the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Rel<%Type%Unit>> values, final int %type%)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, %type%);
            }

            /**
             * Construct a new Sparse Immutable Float Float%Type% Vector. An area is always relative.
             * @param values float[]; the values of the entries in the new Sparse Immutable Float Float%Type% Vector
             * @param unit U; the unit of the new Sparse Immutable Float%Type% Vector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable Float%Type% Vector. An area is always relative.
             * @param values Float%Type%[]; the values of the Scalar Float%Type% entries in the new Relative Sparse Immutable Float%Type%
             *            Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Float%Type%.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable Float%Type% Vector.
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
            public final Float%Type%Vector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new Float%Type%Vector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloat%Type%Vector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableFloat%Type%Vector.Rel.Sparse result = new MutableFloat%Type%Vector.Rel.Sparse(getData(), getUnit());
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
            public final MutableFloat%Type%Vector.Rel toDense()
            {
                return new MutableFloat%Type%Vector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloat%Type%Vector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel get(final int index) throws ValueException
        {
            return (Float%Type%.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel copy()
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
        public final Float%Type%Vector.Rel plus(final Float%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel minus(final Float%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel times(final Float%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel divide(final Float%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel plus(final MutableFloat%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel minus(final MutableFloat%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel times(final MutableFloat%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final Float%Type%Vector.Rel divide(final MutableFloat%Type%Vector.Rel rel) throws ValueException
        {
            return Float%Type%Vector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel abs()
        {
            return (MutableFloat%Type%Vector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel acos()
        {
            return (MutableFloat%Type%Vector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel asin()
        {
            return (MutableFloat%Type%Vector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel atan()
        {
            return (MutableFloat%Type%Vector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel cbrt()
        {
            return (MutableFloat%Type%Vector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel ceil()
        {
            return (MutableFloat%Type%Vector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel cos()
        {
            return (MutableFloat%Type%Vector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel cosh()
        {
            return (MutableFloat%Type%Vector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel exp()
        {
            return (MutableFloat%Type%Vector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel expm1()
        {
            return (MutableFloat%Type%Vector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel floor()
        {
            return (MutableFloat%Type%Vector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel log()
        {
            return (MutableFloat%Type%Vector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel log10()
        {
            return (MutableFloat%Type%Vector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel log1p()
        {
            return (MutableFloat%Type%Vector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel pow(final double x)
        {
            return (MutableFloat%Type%Vector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel rint()
        {
            return (MutableFloat%Type%Vector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel round()
        {
            return (MutableFloat%Type%Vector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel signum()
        {
            return (MutableFloat%Type%Vector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel sin()
        {
            return (MutableFloat%Type%Vector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel sinh()
        {
            return (MutableFloat%Type%Vector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel sqrt()
        {
            return (MutableFloat%Type%Vector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel tan()
        {
            return (MutableFloat%Type%Vector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel tanh()
        {
            return (MutableFloat%Type%Vector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel toDegrees()
        {
            return (MutableFloat%Type%Vector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel toRadians()
        {
            return (MutableFloat%Type%Vector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel inv()
        {
            return (MutableFloat%Type%Vector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel multiplyBy(final float constant)
        {
            return (MutableFloat%Type%Vector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloat%Type%Vector.Rel divideBy(final float constant)
        {
            return (MutableFloat%Type%Vector.Rel) super.divideBy(constant);
        }
    }
}
