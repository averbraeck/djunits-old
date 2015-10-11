package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Time;

/**
 * Mutable Time Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableTimeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TimeVector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<TimeUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableTimeVector.
         * @param unit U; the unit of the new Absolute MutableTimeVector
         */
        protected Abs(final TimeUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableTimeVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract TimeVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableTimeVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableTimeVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableTimeVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableTimeVector.
         */
        public static class Dense extends MutableTimeVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable TimeVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable TimeVector
             * @param unit U; the unit of the new Absolute Dense MutableTimeVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final TimeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TimeVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable TimeVector
             * @param unit U; the unit of the new Absolute Dense Mutable TimeVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final TimeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TimeVector.
             * @param values Time.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense MutableTimeVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Time.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TimeVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable TimeVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<TimeUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TimeVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final TimeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public TimeVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new TimeVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTimeVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableTimeVector.Abs.Dense result = new MutableTimeVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableTimeVector.Abs copy()
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
            public MutableTimeVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTimeVector.Abs toSparse()
            {
                return new MutableTimeVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableTimeVector.
         */
        public static class Sparse extends MutableTimeVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable TimeVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable TimeVector
             * @param unit U; the unit of the new Absolute Sparse Mutable TimeVector
             * @param time the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final TimeUnit unit, final int time)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, time);
            }

            /**
             * Construct a new Absolute Sparse Mutable TimeVector.
             * @param values Time.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable TimeVector
             * @param time the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<TimeUnit>> values, final int time)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, time);
            }

            /**
             * Construct a new Absolute Sparse Mutable TimeVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable TimeVector
             * @param unit U; the unit of the new Absolute Sparse Mutable TimeVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final TimeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable TimeVector.
             * @param values Time.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable TimeVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Time.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable TimeVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable TimeVector
             */
            Sparse(final DoubleVectorDataSparse data, final TimeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public TimeVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new TimeVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableTimeVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableTimeVector.Abs.Sparse result = new MutableTimeVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableTimeVector.Abs copy()
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
            public MutableTimeVector.Abs toDense()
            {
                return new MutableTimeVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTimeVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public Time.Abs get(final int index) throws ValueException
        {
            return new Time.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Abs plus(final TimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Abs minus(final TimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel minus(final TimeVector.Abs abs) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs abs()
        {
            return (MutableTimeVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs acos()
        {
            return (MutableTimeVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs asin()
        {
            return (MutableTimeVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs atan()
        {
            return (MutableTimeVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs cbrt()
        {
            return (MutableTimeVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs ceil()
        {
            return (MutableTimeVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs cos()
        {
            return (MutableTimeVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs cosh()
        {
            return (MutableTimeVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs exp()
        {
            return (MutableTimeVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs expm1()
        {
            return (MutableTimeVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs floor()
        {
            return (MutableTimeVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs log()
        {
            return (MutableTimeVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs log10()
        {
            return (MutableTimeVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs log1p()
        {
            return (MutableTimeVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs pow(final double x)
        {
            return (MutableTimeVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs rint()
        {
            return (MutableTimeVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs round()
        {
            return (MutableTimeVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs signum()
        {
            return (MutableTimeVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs sin()
        {
            return (MutableTimeVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs sinh()
        {
            return (MutableTimeVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs sqrt()
        {
            return (MutableTimeVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs tan()
        {
            return (MutableTimeVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs tanh()
        {
            return (MutableTimeVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs toDegrees()
        {
            return (MutableTimeVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs toRadians()
        {
            return (MutableTimeVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs inv()
        {
            return (MutableTimeVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs multiplyBy(final double constant)
        {
            return (MutableTimeVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Abs divideBy(final double constant)
        {
            return (MutableTimeVector.Abs) super.divideBy(constant);
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TimeVector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<TimeUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableTimeVector.
         * @param unit U; the unit of the new Absolute MutableTimeVector
         */
        protected Rel(final TimeUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableTimeVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract TimeVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableTimeVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableTimeVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable Time class.
         */
        public static class Dense extends MutableTimeVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double Time Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Dense Immutable Double Time Vector
             * @param unit U; the unit of the new Dense Immutable Time Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final TimeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable Time Vector
             * @param unit U; the unit of the new Relative Dense Immutable Time Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final TimeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List&lt;Time&gt;; the values of the Scalar Time entries in the new Relative Dense Immutable Time
             *            Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<TimeUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable Time Vector. An area is always relative.
             * @param values Time[]; the values of the Scalar Time entries in the new Relative Dense Immutable Time Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Time.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable Time Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final TimeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final TimeVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new TimeVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTimeVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableTimeVector.Rel.Dense result = new MutableTimeVector.Rel.Dense(getData(), getUnit());
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
            public final MutableTimeVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTimeVector.Rel toSparse()
            {
                return new MutableTimeVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable Time class.
         */
        public static class Sparse extends MutableTimeVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable Time Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable Time Vector
             * @param unit TimeUnit; the unit of the new Relative Sparse Immutable Time Vector
             * @param time the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final TimeUnit unit, final int time)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, time);
            }

            /**
             * Construct a new Sparse Immutable Time Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Time
             *            Vector
             * @param time the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<TimeUnit>> values, final int time)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, time);
            }

            /**
             * Construct a new Sparse Immutable Double Time Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Sparse Immutable Double Time Vector
             * @param unit U; the unit of the new Sparse Immutable Time Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final TimeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable Time Vector. An area is always relative.
             * @param values Time[]; the values of the Scalar Time entries in the new Relative Sparse Immutable Time Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Time.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable Time Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleVectorDataSparse data, final TimeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final TimeVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new TimeVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTimeVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableTimeVector.Rel.Sparse result = new MutableTimeVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableTimeVector.Rel toDense()
            {
                return new MutableTimeVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTimeVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Time.Rel get(final int index) throws ValueException
        {
            return (Time.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel copy()
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
        public final TimeVector.Rel plus(final TimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel minus(final TimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel times(final TimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel divide(final TimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel plus(final MutableTimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel minus(final MutableTimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel times(final MutableTimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TimeVector.Rel divide(final MutableTimeVector.Rel rel) throws ValueException
        {
            return TimeVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel abs()
        {
            return (MutableTimeVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel acos()
        {
            return (MutableTimeVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel asin()
        {
            return (MutableTimeVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel atan()
        {
            return (MutableTimeVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel cbrt()
        {
            return (MutableTimeVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel ceil()
        {
            return (MutableTimeVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel cos()
        {
            return (MutableTimeVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel cosh()
        {
            return (MutableTimeVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel exp()
        {
            return (MutableTimeVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel expm1()
        {
            return (MutableTimeVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel floor()
        {
            return (MutableTimeVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel log()
        {
            return (MutableTimeVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel log10()
        {
            return (MutableTimeVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel log1p()
        {
            return (MutableTimeVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel pow(final double x)
        {
            return (MutableTimeVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel rint()
        {
            return (MutableTimeVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel round()
        {
            return (MutableTimeVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel signum()
        {
            return (MutableTimeVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel sin()
        {
            return (MutableTimeVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel sinh()
        {
            return (MutableTimeVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel sqrt()
        {
            return (MutableTimeVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel tan()
        {
            return (MutableTimeVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel tanh()
        {
            return (MutableTimeVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel toDegrees()
        {
            return (MutableTimeVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel toRadians()
        {
            return (MutableTimeVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel inv()
        {
            return (MutableTimeVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel multiplyBy(final double constant)
        {
            return (MutableTimeVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTimeVector.Rel divideBy(final double constant)
        {
            return (MutableTimeVector.Rel) super.divideBy(constant);
        }

    }
}
