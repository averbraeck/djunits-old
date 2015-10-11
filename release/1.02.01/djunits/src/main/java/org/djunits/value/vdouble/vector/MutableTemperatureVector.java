package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Temperature;

/**
 * Mutable Temperature Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableTemperatureVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TemperatureVector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<TemperatureUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableTemperatureVector.
         * @param unit U; the unit of the new Absolute MutableTemperatureVector
         */
        protected Abs(final TemperatureUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableTemperatureVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract TemperatureVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableTemperatureVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableTemperatureVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableTemperatureVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableTemperatureVector.
         */
        public static class Dense extends MutableTemperatureVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable TemperatureVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable TemperatureVector
             * @param unit U; the unit of the new Absolute Dense MutableTemperatureVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final TemperatureUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TemperatureVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable TemperatureVector
             * @param unit U; the unit of the new Absolute Dense Mutable TemperatureVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final TemperatureUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TemperatureVector.
             * @param values Temperature.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            MutableTemperatureVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Temperature.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TemperatureVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable TemperatureVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<TemperatureUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable TemperatureVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final TemperatureUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public TemperatureVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new TemperatureVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTemperatureVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableTemperatureVector.Abs.Dense result =
                    new MutableTemperatureVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableTemperatureVector.Abs copy()
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
            public MutableTemperatureVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTemperatureVector.Abs toSparse()
            {
                return new MutableTemperatureVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableTemperatureVector.
         */
        public static class Sparse extends MutableTemperatureVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable TemperatureVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable TemperatureVector
             * @param unit U; the unit of the new Absolute Sparse Mutable TemperatureVector
             * @param temperature the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final TemperatureUnit unit, final int temperature)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, temperature);
            }

            /**
             * Construct a new Absolute Sparse Mutable TemperatureVector.
             * @param values Temperature.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            TemperatureVector
             * @param temperature the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<TemperatureUnit>> values, final int temperature)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, temperature);
            }

            /**
             * Construct a new Absolute Sparse Mutable TemperatureVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable TemperatureVector
             * @param unit U; the unit of the new Absolute Sparse Mutable TemperatureVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final TemperatureUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable TemperatureVector.
             * @param values Temperature.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            TemperatureVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Temperature.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable TemperatureVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable TemperatureVector
             */
            Sparse(final DoubleVectorDataSparse data, final TemperatureUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public TemperatureVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new TemperatureVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableTemperatureVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableTemperatureVector.Abs.Sparse result =
                    new MutableTemperatureVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableTemperatureVector.Abs copy()
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
            public MutableTemperatureVector.Abs toDense()
            {
                return new MutableTemperatureVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTemperatureVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public Temperature.Abs get(final int index) throws ValueException
        {
            return new Temperature.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Abs plus(final TemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Abs minus(final TemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel minus(final TemperatureVector.Abs abs) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs abs()
        {
            return (MutableTemperatureVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs acos()
        {
            return (MutableTemperatureVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs asin()
        {
            return (MutableTemperatureVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs atan()
        {
            return (MutableTemperatureVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs cbrt()
        {
            return (MutableTemperatureVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs ceil()
        {
            return (MutableTemperatureVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs cos()
        {
            return (MutableTemperatureVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs cosh()
        {
            return (MutableTemperatureVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs exp()
        {
            return (MutableTemperatureVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs expm1()
        {
            return (MutableTemperatureVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs floor()
        {
            return (MutableTemperatureVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs log()
        {
            return (MutableTemperatureVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs log10()
        {
            return (MutableTemperatureVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs log1p()
        {
            return (MutableTemperatureVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs pow(final double x)
        {
            return (MutableTemperatureVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs rint()
        {
            return (MutableTemperatureVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs round()
        {
            return (MutableTemperatureVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs signum()
        {
            return (MutableTemperatureVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs sin()
        {
            return (MutableTemperatureVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs sinh()
        {
            return (MutableTemperatureVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs sqrt()
        {
            return (MutableTemperatureVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs tan()
        {
            return (MutableTemperatureVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs tanh()
        {
            return (MutableTemperatureVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs toDegrees()
        {
            return (MutableTemperatureVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs toRadians()
        {
            return (MutableTemperatureVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs inv()
        {
            return (MutableTemperatureVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs multiplyBy(final double constant)
        {
            return (MutableTemperatureVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Abs divideBy(final double constant)
        {
            return (MutableTemperatureVector.Abs) super.divideBy(constant);
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TemperatureVector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableTemperatureVector.
         * @param unit U; the unit of the new Absolute MutableTemperatureVector
         */
        protected Rel(final TemperatureUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableTemperatureVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract TemperatureVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableTemperatureVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableTemperatureVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable Temperature class.
         */
        public static class Dense extends MutableTemperatureVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double Temperature Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Dense Immutable Double Temperature Vector
             * @param unit U; the unit of the new Dense Immutable Temperature Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final TemperatureUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable Temperature Vector
             * @param unit U; the unit of the new Relative Dense Immutable Temperature Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final TemperatureUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List&lt;Temperature&gt;; the values of the Scalar Temperature entries in the new Relative Dense
             *            Immutable Temperature Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<TemperatureUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable Temperature Vector. An area is always relative.
             * @param values Temperature[]; the values of the Scalar Temperature entries in the new Relative Dense Immutable
             *            Temperature Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Temperature.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable Temperature Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final TemperatureUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final TemperatureVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new TemperatureVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTemperatureVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableTemperatureVector.Rel.Dense result =
                    new MutableTemperatureVector.Rel.Dense(getData(), getUnit());
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
            public final MutableTemperatureVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTemperatureVector.Rel toSparse()
            {
                return new MutableTemperatureVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable Temperature class.
         */
        public static class Sparse extends MutableTemperatureVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable Temperature Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable Temperature Vector
             * @param unit TemperatureUnit; the unit of the new Relative Sparse Immutable Temperature Vector
             * @param temperature the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final TemperatureUnit unit, final int temperature)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, temperature);
            }

            /**
             * Construct a new Sparse Immutable Temperature Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            Temperature Vector
             * @param temperature the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<TemperatureUnit>> values, final int temperature)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, temperature);
            }

            /**
             * Construct a new Sparse Immutable Double Temperature Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Sparse Immutable Double Temperature Vector
             * @param unit U; the unit of the new Sparse Immutable Temperature Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final TemperatureUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable Temperature Vector. An area is always relative.
             * @param values Temperature[]; the values of the Scalar Temperature entries in the new Relative Sparse Immutable
             *            Temperature Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Temperature.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable Temperature Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleVectorDataSparse data, final TemperatureUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final TemperatureVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new TemperatureVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTemperatureVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableTemperatureVector.Rel.Sparse result =
                    new MutableTemperatureVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableTemperatureVector.Rel toDense()
            {
                return new MutableTemperatureVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableTemperatureVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel get(final int index) throws ValueException
        {
            return (Temperature.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel copy()
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
        public final TemperatureVector.Rel plus(final TemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel minus(final TemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel times(final TemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel divide(final TemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel plus(final MutableTemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel minus(final MutableTemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel times(final MutableTemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final TemperatureVector.Rel divide(final MutableTemperatureVector.Rel rel) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel abs()
        {
            return (MutableTemperatureVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel acos()
        {
            return (MutableTemperatureVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel asin()
        {
            return (MutableTemperatureVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel atan()
        {
            return (MutableTemperatureVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel cbrt()
        {
            return (MutableTemperatureVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel ceil()
        {
            return (MutableTemperatureVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel cos()
        {
            return (MutableTemperatureVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel cosh()
        {
            return (MutableTemperatureVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel exp()
        {
            return (MutableTemperatureVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel expm1()
        {
            return (MutableTemperatureVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel floor()
        {
            return (MutableTemperatureVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel log()
        {
            return (MutableTemperatureVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel log10()
        {
            return (MutableTemperatureVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel log1p()
        {
            return (MutableTemperatureVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel pow(final double x)
        {
            return (MutableTemperatureVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel rint()
        {
            return (MutableTemperatureVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel round()
        {
            return (MutableTemperatureVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel signum()
        {
            return (MutableTemperatureVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel sin()
        {
            return (MutableTemperatureVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel sinh()
        {
            return (MutableTemperatureVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel sqrt()
        {
            return (MutableTemperatureVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel tan()
        {
            return (MutableTemperatureVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel tanh()
        {
            return (MutableTemperatureVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel toDegrees()
        {
            return (MutableTemperatureVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel toRadians()
        {
            return (MutableTemperatureVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel inv()
        {
            return (MutableTemperatureVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel multiplyBy(final double constant)
        {
            return (MutableTemperatureVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableTemperatureVector.Rel divideBy(final double constant)
        {
            return (MutableTemperatureVector.Rel) super.divideBy(constant);
        }

    }
}
