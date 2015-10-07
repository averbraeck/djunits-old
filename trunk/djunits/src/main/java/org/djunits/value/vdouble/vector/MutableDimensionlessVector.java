package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Dimensionless;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable Dimensionless Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableDimensionlessVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of DimensionlessVector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<DimensionlessUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableDimensionlessVector.
         * @param unit U; the unit of the new Absolute MutableDimensionlessVector
         */
        protected Abs(final DimensionlessUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableDimensionlessVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract DimensionlessVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableDimensionlessVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableDimensionlessVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableDimensionlessVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableDimensionlessVector.
         */
        public static class Dense extends MutableDimensionlessVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable DimensionlessVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable DimensionlessVector
             * @param unit U; the unit of the new Absolute Dense MutableDimensionlessVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final DimensionlessUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable DimensionlessVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable DimensionlessVector
             * @param unit U; the unit of the new Absolute Dense Mutable DimensionlessVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final DimensionlessUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable DimensionlessVector.
             * @param values Dimensionless.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            MutableDimensionlessVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Dimensionless.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable DimensionlessVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable DimensionlessVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<DimensionlessUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable DimensionlessVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final DimensionlessUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public DimensionlessVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new DimensionlessVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableDimensionlessVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableDimensionlessVector.Abs.Dense result =
                    new MutableDimensionlessVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableDimensionlessVector.Abs copy()
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
            public MutableDimensionlessVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableDimensionlessVector.Abs toSparse()
            {
                return new MutableDimensionlessVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableDimensionlessVector.
         */
        public static class Sparse extends MutableDimensionlessVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable DimensionlessVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable DimensionlessVector
             * @param unit U; the unit of the new Absolute Sparse Mutable DimensionlessVector
             * @param dimensionless the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final DimensionlessUnit unit, final int dimensionless)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, dimensionless);
            }

            /**
             * Construct a new Absolute Sparse Mutable DimensionlessVector.
             * @param values Dimensionless.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            DimensionlessVector
             * @param dimensionless the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<DimensionlessUnit>> values, final int dimensionless)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, dimensionless);
            }

            /**
             * Construct a new Absolute Sparse Mutable DimensionlessVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable DimensionlessVector
             * @param unit U; the unit of the new Absolute Sparse Mutable DimensionlessVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final DimensionlessUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable DimensionlessVector.
             * @param values Dimensionless.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            DimensionlessVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Dimensionless.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable DimensionlessVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable DimensionlessVector
             */
            Sparse(final DoubleVectorDataSparse data, final DimensionlessUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public DimensionlessVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new DimensionlessVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableDimensionlessVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableDimensionlessVector.Abs.Sparse result =
                    new MutableDimensionlessVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableDimensionlessVector.Abs copy()
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
            public MutableDimensionlessVector.Abs toDense()
            {
                return new MutableDimensionlessVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableDimensionlessVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public Dimensionless.Abs get(final int index) throws ValueException
        {
            return new Dimensionless.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Abs plus(final DimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Abs minus(final DimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel minus(final DimensionlessVector.Abs abs) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs abs()
        {
            return (MutableDimensionlessVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs acos()
        {
            return (MutableDimensionlessVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs asin()
        {
            return (MutableDimensionlessVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs atan()
        {
            return (MutableDimensionlessVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs cbrt()
        {
            return (MutableDimensionlessVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs ceil()
        {
            return (MutableDimensionlessVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs cos()
        {
            return (MutableDimensionlessVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs cosh()
        {
            return (MutableDimensionlessVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs exp()
        {
            return (MutableDimensionlessVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs expm1()
        {
            return (MutableDimensionlessVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs floor()
        {
            return (MutableDimensionlessVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs log()
        {
            return (MutableDimensionlessVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs log10()
        {
            return (MutableDimensionlessVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs log1p()
        {
            return (MutableDimensionlessVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs pow(final double x)
        {
            return (MutableDimensionlessVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs rint()
        {
            return (MutableDimensionlessVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs round()
        {
            return (MutableDimensionlessVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs signum()
        {
            return (MutableDimensionlessVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs sin()
        {
            return (MutableDimensionlessVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs sinh()
        {
            return (MutableDimensionlessVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs sqrt()
        {
            return (MutableDimensionlessVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs tan()
        {
            return (MutableDimensionlessVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs tanh()
        {
            return (MutableDimensionlessVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs toDegrees()
        {
            return (MutableDimensionlessVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs toRadians()
        {
            return (MutableDimensionlessVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs inv()
        {
            return (MutableDimensionlessVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs multiplyBy(final double constant)
        {
            return (MutableDimensionlessVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Abs divideBy(final double constant)
        {
            return (MutableDimensionlessVector.Abs) super.divideBy(constant);
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of DimensionlessVector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<DimensionlessUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableDimensionlessVector.
         * @param unit U; the unit of the new Absolute MutableDimensionlessVector
         */
        protected Rel(final DimensionlessUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableDimensionlessVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract DimensionlessVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableDimensionlessVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableDimensionlessVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable Dimensionless class.
         */
        public static class Dense extends MutableDimensionlessVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double Dimensionless Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Dense Immutable Double Dimensionless Vector
             * @param unit U; the unit of the new Dense Immutable Dimensionless Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final DimensionlessUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable Dimensionless Vector
             * @param unit U; the unit of the new Relative Dense Immutable Dimensionless Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final DimensionlessUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List&lt;Dimensionless&gt;; the values of the Scalar Dimensionless entries in the new Relative Dense
             *            Immutable Dimensionless Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<DimensionlessUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable Dimensionless Vector. An area is always relative.
             * @param values Dimensionless[]; the values of the Scalar Dimensionless entries in the new Relative Dense Immutable
             *            Dimensionless Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Dimensionless.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable Dimensionless Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final DimensionlessUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final DimensionlessVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new DimensionlessVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDimensionlessVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableDimensionlessVector.Rel.Dense result =
                    new MutableDimensionlessVector.Rel.Dense(getData(), getUnit());
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
            public final MutableDimensionlessVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDimensionlessVector.Rel toSparse()
            {
                return new MutableDimensionlessVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable Dimensionless class.
         */
        public static class Sparse extends MutableDimensionlessVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable Dimensionless Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable Dimensionless Vector
             * @param unit DimensionlessUnit; the unit of the new Relative Sparse Immutable Dimensionless Vector
             * @param dimensionless the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final DimensionlessUnit unit, final int dimensionless)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, dimensionless);
            }

            /**
             * Construct a new Sparse Immutable Dimensionless Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            Dimensionless Vector
             * @param dimensionless the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<DimensionlessUnit>> values, final int dimensionless)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, dimensionless);
            }

            /**
             * Construct a new Sparse Immutable Double Dimensionless Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Sparse Immutable Double Dimensionless Vector
             * @param unit U; the unit of the new Sparse Immutable Dimensionless Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final DimensionlessUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable Dimensionless Vector. An area is always relative.
             * @param values Dimensionless[]; the values of the Scalar Dimensionless entries in the new Relative Sparse
             *            Immutable Dimensionless Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Dimensionless.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable Dimensionless Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleVectorDataSparse data, final DimensionlessUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final DimensionlessVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new DimensionlessVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDimensionlessVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableDimensionlessVector.Rel.Sparse result =
                    new MutableDimensionlessVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableDimensionlessVector.Rel toDense()
            {
                return new MutableDimensionlessVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDimensionlessVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel get(final int index) throws ValueException
        {
            return (Dimensionless.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel copy()
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
        public final DimensionlessVector.Rel plus(final DimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel minus(final DimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel times(final DimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel divide(final DimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel plus(final MutableDimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel minus(final MutableDimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel times(final MutableDimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final DimensionlessVector.Rel divide(final MutableDimensionlessVector.Rel rel) throws ValueException
        {
            return DimensionlessVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel abs()
        {
            return (MutableDimensionlessVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel acos()
        {
            return (MutableDimensionlessVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel asin()
        {
            return (MutableDimensionlessVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel atan()
        {
            return (MutableDimensionlessVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel cbrt()
        {
            return (MutableDimensionlessVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel ceil()
        {
            return (MutableDimensionlessVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel cos()
        {
            return (MutableDimensionlessVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel cosh()
        {
            return (MutableDimensionlessVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel exp()
        {
            return (MutableDimensionlessVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel expm1()
        {
            return (MutableDimensionlessVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel floor()
        {
            return (MutableDimensionlessVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel log()
        {
            return (MutableDimensionlessVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel log10()
        {
            return (MutableDimensionlessVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel log1p()
        {
            return (MutableDimensionlessVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel pow(final double x)
        {
            return (MutableDimensionlessVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel rint()
        {
            return (MutableDimensionlessVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel round()
        {
            return (MutableDimensionlessVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel signum()
        {
            return (MutableDimensionlessVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel sin()
        {
            return (MutableDimensionlessVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel sinh()
        {
            return (MutableDimensionlessVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel sqrt()
        {
            return (MutableDimensionlessVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel tan()
        {
            return (MutableDimensionlessVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel tanh()
        {
            return (MutableDimensionlessVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel toDegrees()
        {
            return (MutableDimensionlessVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel toRadians()
        {
            return (MutableDimensionlessVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel inv()
        {
            return (MutableDimensionlessVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel multiplyBy(final double constant)
        {
            return (MutableDimensionlessVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDimensionlessVector.Rel divideBy(final double constant)
        {
            return (MutableDimensionlessVector.Rel) super.divideBy(constant);
        }

    }
}
