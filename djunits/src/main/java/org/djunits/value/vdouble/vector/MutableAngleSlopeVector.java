package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AngleSlope;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable AngleSlope Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableAngleSlopeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AngleSlopeVector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<AngleSlopeUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableAngleSlopeVector.
         * @param unit U; the unit of the new Absolute MutableAngleSlopeVector
         */
        protected Abs(final AngleSlopeUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAngleSlopeVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract AngleSlopeVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableAngleSlopeVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableAngleSlopeVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableAngleSlopeVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableAngleSlopeVector.
         */
        public static class Dense extends MutableAngleSlopeVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable AngleSlopeVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable AngleSlopeVector
             * @param unit U; the unit of the new Absolute Dense MutableAngleSlopeVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AngleSlopeVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable AngleSlopeVector
             * @param unit U; the unit of the new Absolute Dense Mutable AngleSlopeVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AngleSlopeVector.
             * @param values AngleSlope.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            MutableAngleSlopeVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final AngleSlope.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AngleSlopeVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable AngleSlopeVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<AngleSlopeUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable AngleSlopeVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final AngleSlopeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public AngleSlopeVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new AngleSlopeVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAngleSlopeVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableAngleSlopeVector.Abs.Dense result =
                    new MutableAngleSlopeVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableAngleSlopeVector.Abs copy()
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
            public MutableAngleSlopeVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAngleSlopeVector.Abs toSparse()
            {
                return new MutableAngleSlopeVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableAngleSlopeVector.
         */
        public static class Sparse extends MutableAngleSlopeVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable AngleSlopeVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable AngleSlopeVector
             * @param unit U; the unit of the new Absolute Sparse Mutable AngleSlopeVector
             * @param angleslope the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final AngleSlopeUnit unit, final int angleslope)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, angleslope);
            }

            /**
             * Construct a new Absolute Sparse Mutable AngleSlopeVector.
             * @param values AngleSlope.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            AngleSlopeVector
             * @param angleslope the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<AngleSlopeUnit>> values, final int angleslope)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, angleslope);
            }

            /**
             * Construct a new Absolute Sparse Mutable AngleSlopeVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable AngleSlopeVector
             * @param unit U; the unit of the new Absolute Sparse Mutable AngleSlopeVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable AngleSlopeVector.
             * @param values AngleSlope.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            AngleSlopeVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final AngleSlope.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable AngleSlopeVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable AngleSlopeVector
             */
            Sparse(final DoubleVectorDataSparse data, final AngleSlopeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public AngleSlopeVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new AngleSlopeVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableAngleSlopeVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableAngleSlopeVector.Abs.Sparse result =
                    new MutableAngleSlopeVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableAngleSlopeVector.Abs copy()
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
            public MutableAngleSlopeVector.Abs toDense()
            {
                return new MutableAngleSlopeVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAngleSlopeVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public AngleSlope.Abs get(final int index) throws ValueException
        {
            return new AngleSlope.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Abs plus(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Abs minus(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel minus(final AngleSlopeVector.Abs abs) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs abs()
        {
            return (MutableAngleSlopeVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs acos()
        {
            return (MutableAngleSlopeVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs asin()
        {
            return (MutableAngleSlopeVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs atan()
        {
            return (MutableAngleSlopeVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs cbrt()
        {
            return (MutableAngleSlopeVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs ceil()
        {
            return (MutableAngleSlopeVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs cos()
        {
            return (MutableAngleSlopeVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs cosh()
        {
            return (MutableAngleSlopeVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs exp()
        {
            return (MutableAngleSlopeVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs expm1()
        {
            return (MutableAngleSlopeVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs floor()
        {
            return (MutableAngleSlopeVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs log()
        {
            return (MutableAngleSlopeVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs log10()
        {
            return (MutableAngleSlopeVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs log1p()
        {
            return (MutableAngleSlopeVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs pow(final double x)
        {
            return (MutableAngleSlopeVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs rint()
        {
            return (MutableAngleSlopeVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs round()
        {
            return (MutableAngleSlopeVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs signum()
        {
            return (MutableAngleSlopeVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs sin()
        {
            return (MutableAngleSlopeVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs sinh()
        {
            return (MutableAngleSlopeVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs sqrt()
        {
            return (MutableAngleSlopeVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs tan()
        {
            return (MutableAngleSlopeVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs tanh()
        {
            return (MutableAngleSlopeVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs toDegrees()
        {
            return (MutableAngleSlopeVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs toRadians()
        {
            return (MutableAngleSlopeVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs inv()
        {
            return (MutableAngleSlopeVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs multiplyBy(final double constant)
        {
            return (MutableAngleSlopeVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Abs divideBy(final double constant)
        {
            return (MutableAngleSlopeVector.Abs) super.divideBy(constant);
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AngleSlopeVector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableAngleSlopeVector.
         * @param unit U; the unit of the new Absolute MutableAngleSlopeVector
         */
        protected Rel(final AngleSlopeUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAngleSlopeVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract AngleSlopeVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableAngleSlopeVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableAngleSlopeVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable AngleSlope class.
         */
        public static class Dense extends MutableAngleSlopeVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double AngleSlope Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Dense Immutable Double AngleSlope Vector
             * @param unit U; the unit of the new Dense Immutable AngleSlope Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable AngleSlope Vector
             * @param unit U; the unit of the new Relative Dense Immutable AngleSlope Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List&lt;AngleSlope&gt;; the values of the Scalar AngleSlope entries in the new Relative Dense
             *            Immutable AngleSlope Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<AngleSlopeUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable AngleSlope Vector. An area is always relative.
             * @param values AngleSlope[]; the values of the Scalar AngleSlope entries in the new Relative Dense Immutable
             *            AngleSlope Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final AngleSlope.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable AngleSlope Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final AngleSlopeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final AngleSlopeVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new AngleSlopeVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAngleSlopeVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableAngleSlopeVector.Rel.Dense result =
                    new MutableAngleSlopeVector.Rel.Dense(getData(), getUnit());
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
            public final MutableAngleSlopeVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAngleSlopeVector.Rel toSparse()
            {
                return new MutableAngleSlopeVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable AngleSlope class.
         */
        public static class Sparse extends MutableAngleSlopeVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable AngleSlope Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable AngleSlope Vector
             * @param unit AngleSlopeUnit; the unit of the new Relative Sparse Immutable AngleSlope Vector
             * @param angleslope the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final AngleSlopeUnit unit, final int angleslope)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, angleslope);
            }

            /**
             * Construct a new Sparse Immutable AngleSlope Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            AngleSlope Vector
             * @param angleslope the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<AngleSlopeUnit>> values, final int angleslope)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, angleslope);
            }

            /**
             * Construct a new Sparse Immutable Double AngleSlope Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Sparse Immutable Double AngleSlope Vector
             * @param unit U; the unit of the new Sparse Immutable AngleSlope Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable AngleSlope Vector. An area is always relative.
             * @param values AngleSlope[]; the values of the Scalar AngleSlope entries in the new Relative Sparse Immutable
             *            AngleSlope Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final AngleSlope.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable AngleSlope Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleVectorDataSparse data, final AngleSlopeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final AngleSlopeVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new AngleSlopeVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAngleSlopeVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableAngleSlopeVector.Rel.Sparse result =
                    new MutableAngleSlopeVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableAngleSlopeVector.Rel toDense()
            {
                return new MutableAngleSlopeVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableAngleSlopeVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel get(final int index) throws ValueException
        {
            return (AngleSlope.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel copy()
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
        public final AngleSlopeVector.Rel plus(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel minus(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel times(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel divide(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel plus(final MutableAngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel minus(final MutableAngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel times(final MutableAngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final AngleSlopeVector.Rel divide(final MutableAngleSlopeVector.Rel rel) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel abs()
        {
            return (MutableAngleSlopeVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel acos()
        {
            return (MutableAngleSlopeVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel asin()
        {
            return (MutableAngleSlopeVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel atan()
        {
            return (MutableAngleSlopeVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel cbrt()
        {
            return (MutableAngleSlopeVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel ceil()
        {
            return (MutableAngleSlopeVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel cos()
        {
            return (MutableAngleSlopeVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel cosh()
        {
            return (MutableAngleSlopeVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel exp()
        {
            return (MutableAngleSlopeVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel expm1()
        {
            return (MutableAngleSlopeVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel floor()
        {
            return (MutableAngleSlopeVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel log()
        {
            return (MutableAngleSlopeVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel log10()
        {
            return (MutableAngleSlopeVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel log1p()
        {
            return (MutableAngleSlopeVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel pow(final double x)
        {
            return (MutableAngleSlopeVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel rint()
        {
            return (MutableAngleSlopeVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel round()
        {
            return (MutableAngleSlopeVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel signum()
        {
            return (MutableAngleSlopeVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel sin()
        {
            return (MutableAngleSlopeVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel sinh()
        {
            return (MutableAngleSlopeVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel sqrt()
        {
            return (MutableAngleSlopeVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel tan()
        {
            return (MutableAngleSlopeVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel tanh()
        {
            return (MutableAngleSlopeVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel toDegrees()
        {
            return (MutableAngleSlopeVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel toRadians()
        {
            return (MutableAngleSlopeVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel inv()
        {
            return (MutableAngleSlopeVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel multiplyBy(final double constant)
        {
            return (MutableAngleSlopeVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSlopeVector.Rel divideBy(final double constant)
        {
            return (MutableAngleSlopeVector.Rel) super.divideBy(constant);
        }

    }
}
