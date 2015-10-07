package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AnglePlane;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable AnglePlane Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableAnglePlaneVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AnglePlaneVector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<AnglePlaneUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableAnglePlaneVector.
         * @param unit U; the unit of the new Absolute MutableAnglePlaneVector
         */
        protected Abs(final AnglePlaneUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAnglePlaneVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract AnglePlaneVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableAnglePlaneVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableAnglePlaneVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableAnglePlaneVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableAnglePlaneVector.
         */
        public static class Dense extends MutableAnglePlaneVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable AnglePlaneVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable AnglePlaneVector
             * @param unit U; the unit of the new Absolute Dense MutableAnglePlaneVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final AnglePlaneUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AnglePlaneVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable AnglePlaneVector
             * @param unit U; the unit of the new Absolute Dense Mutable AnglePlaneVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final AnglePlaneUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AnglePlaneVector.
             * @param values AnglePlane.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            MutableAnglePlaneVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final AnglePlane.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AnglePlaneVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable AnglePlaneVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<AnglePlaneUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AnglePlaneVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final AnglePlaneUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public AnglePlaneVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new AnglePlaneVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAnglePlaneVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableAnglePlaneVector.Abs.Dense result =
                    new MutableAnglePlaneVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableAnglePlaneVector.Abs copy()
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
            public MutableAnglePlaneVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAnglePlaneVector.Abs toSparse()
            {
                return new MutableAnglePlaneVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableAnglePlaneVector.
         */
        public static class Sparse extends MutableAnglePlaneVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable AnglePlaneVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable AnglePlaneVector
             * @param unit U; the unit of the new Absolute Sparse Mutable AnglePlaneVector
             * @param angleplane the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final AnglePlaneUnit unit, final int angleplane)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, angleplane);
            }

            /**
             * Construct a new Absolute Sparse Mutable AnglePlaneVector.
             * @param values AnglePlane.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            AnglePlaneVector
             * @param angleplane the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<AnglePlaneUnit>> values, final int angleplane)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, angleplane);
            }

            /**
             * Construct a new Absolute Sparse Mutable AnglePlaneVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable AnglePlaneVector
             * @param unit U; the unit of the new Absolute Sparse Mutable AnglePlaneVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final AnglePlaneUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable AnglePlaneVector.
             * @param values AnglePlane.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            AnglePlaneVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final AnglePlane.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable AnglePlaneVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable AnglePlaneVector
             */
            Sparse(final DoubleVectorDataSparse data, final AnglePlaneUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public AnglePlaneVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new AnglePlaneVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableAnglePlaneVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableAnglePlaneVector.Abs.Sparse result =
                    new MutableAnglePlaneVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableAnglePlaneVector.Abs copy()
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
            public MutableAnglePlaneVector.Abs toDense()
            {
                return new MutableAnglePlaneVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAnglePlaneVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public AnglePlane.Abs get(final int index) throws ValueException
        {
            return new AnglePlane.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Abs plus(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Abs minus(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel minus(final AnglePlaneVector.Abs abs) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs abs()
        {
            return (MutableAnglePlaneVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs acos()
        {
            return (MutableAnglePlaneVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs asin()
        {
            return (MutableAnglePlaneVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs atan()
        {
            return (MutableAnglePlaneVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs cbrt()
        {
            return (MutableAnglePlaneVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs ceil()
        {
            return (MutableAnglePlaneVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs cos()
        {
            return (MutableAnglePlaneVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs cosh()
        {
            return (MutableAnglePlaneVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs exp()
        {
            return (MutableAnglePlaneVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs expm1()
        {
            return (MutableAnglePlaneVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs floor()
        {
            return (MutableAnglePlaneVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs log()
        {
            return (MutableAnglePlaneVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs log10()
        {
            return (MutableAnglePlaneVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs log1p()
        {
            return (MutableAnglePlaneVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs pow(final double x)
        {
            return (MutableAnglePlaneVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs rint()
        {
            return (MutableAnglePlaneVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs round()
        {
            return (MutableAnglePlaneVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs signum()
        {
            return (MutableAnglePlaneVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs sin()
        {
            return (MutableAnglePlaneVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs sinh()
        {
            return (MutableAnglePlaneVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs sqrt()
        {
            return (MutableAnglePlaneVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs tan()
        {
            return (MutableAnglePlaneVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs tanh()
        {
            return (MutableAnglePlaneVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs toDegrees()
        {
            return (MutableAnglePlaneVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs toRadians()
        {
            return (MutableAnglePlaneVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs inv()
        {
            return (MutableAnglePlaneVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs multiplyBy(final double constant)
        {
            return (MutableAnglePlaneVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Abs divideBy(final double constant)
        {
            return (MutableAnglePlaneVector.Abs) super.divideBy(constant);
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AnglePlaneVector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableAnglePlaneVector.
         * @param unit U; the unit of the new Absolute MutableAnglePlaneVector
         */
        protected Rel(final AnglePlaneUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAnglePlaneVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract AnglePlaneVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableAnglePlaneVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableAnglePlaneVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable AnglePlane class.
         */
        public static class Dense extends MutableAnglePlaneVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double AnglePlane Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Dense Immutable Double AnglePlane Vector
             * @param unit U; the unit of the new Dense Immutable AnglePlane Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final AnglePlaneUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable AnglePlane Vector
             * @param unit U; the unit of the new Relative Dense Immutable AnglePlane Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final AnglePlaneUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List&lt;AnglePlane&gt;; the values of the Scalar AnglePlane entries in the new Relative Dense
             *            Immutable AnglePlane Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<AnglePlaneUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable AnglePlane Vector. An area is always relative.
             * @param values AnglePlane[]; the values of the Scalar AnglePlane entries in the new Relative Dense Immutable
             *            AnglePlane Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final AnglePlane.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable AnglePlane Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final AnglePlaneUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final AnglePlaneVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new AnglePlaneVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAnglePlaneVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableAnglePlaneVector.Rel.Dense result =
                    new MutableAnglePlaneVector.Rel.Dense(getData(), getUnit());
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
            public final MutableAnglePlaneVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAnglePlaneVector.Rel toSparse()
            {
                return new MutableAnglePlaneVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable AnglePlane class.
         */
        public static class Sparse extends MutableAnglePlaneVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable AnglePlane Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable AnglePlane Vector
             * @param unit AnglePlaneUnit; the unit of the new Relative Sparse Immutable AnglePlane Vector
             * @param angleplane the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final AnglePlaneUnit unit, final int angleplane)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, angleplane);
            }

            /**
             * Construct a new Sparse Immutable AnglePlane Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            AnglePlane Vector
             * @param angleplane the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<AnglePlaneUnit>> values, final int angleplane)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, angleplane);
            }

            /**
             * Construct a new Sparse Immutable Double AnglePlane Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Sparse Immutable Double AnglePlane Vector
             * @param unit U; the unit of the new Sparse Immutable AnglePlane Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final AnglePlaneUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable AnglePlane Vector. An area is always relative.
             * @param values AnglePlane[]; the values of the Scalar AnglePlane entries in the new Relative Sparse Immutable
             *            AnglePlane Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final AnglePlane.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable AnglePlane Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleVectorDataSparse data, final AnglePlaneUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final AnglePlaneVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new AnglePlaneVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAnglePlaneVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableAnglePlaneVector.Rel.Sparse result =
                    new MutableAnglePlaneVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableAnglePlaneVector.Rel toDense()
            {
                return new MutableAnglePlaneVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAnglePlaneVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel get(final int index) throws ValueException
        {
            return (AnglePlane.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel copy()
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
        public final AnglePlaneVector.Rel plus(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel minus(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel times(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel divide(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel plus(final MutableAnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel minus(final MutableAnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel times(final MutableAnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AnglePlaneVector.Rel divide(final MutableAnglePlaneVector.Rel rel) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel abs()
        {
            return (MutableAnglePlaneVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel acos()
        {
            return (MutableAnglePlaneVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel asin()
        {
            return (MutableAnglePlaneVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel atan()
        {
            return (MutableAnglePlaneVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel cbrt()
        {
            return (MutableAnglePlaneVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel ceil()
        {
            return (MutableAnglePlaneVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel cos()
        {
            return (MutableAnglePlaneVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel cosh()
        {
            return (MutableAnglePlaneVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel exp()
        {
            return (MutableAnglePlaneVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel expm1()
        {
            return (MutableAnglePlaneVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel floor()
        {
            return (MutableAnglePlaneVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel log()
        {
            return (MutableAnglePlaneVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel log10()
        {
            return (MutableAnglePlaneVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel log1p()
        {
            return (MutableAnglePlaneVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel pow(final double x)
        {
            return (MutableAnglePlaneVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel rint()
        {
            return (MutableAnglePlaneVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel round()
        {
            return (MutableAnglePlaneVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel signum()
        {
            return (MutableAnglePlaneVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel sin()
        {
            return (MutableAnglePlaneVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel sinh()
        {
            return (MutableAnglePlaneVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel sqrt()
        {
            return (MutableAnglePlaneVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel tan()
        {
            return (MutableAnglePlaneVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel tanh()
        {
            return (MutableAnglePlaneVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel toDegrees()
        {
            return (MutableAnglePlaneVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel toRadians()
        {
            return (MutableAnglePlaneVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel inv()
        {
            return (MutableAnglePlaneVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel multiplyBy(final double constant)
        {
            return (MutableAnglePlaneVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAnglePlaneVector.Rel divideBy(final double constant)
        {
            return (MutableAnglePlaneVector.Rel) super.divideBy(constant);
        }

    }
}
