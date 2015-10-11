package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLength;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Mutable FloatLength Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatLengthVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatLengthVector.
     */
    public abstract static class Abs extends MutableFloatVector.Abs<LengthUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableFloatLengthVector.
         * @param unit U; the unit of the new Absolute MutableFloatLengthVector
         */
        protected Abs(final LengthUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatLengthVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract FloatLengthVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatLengthVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableFloatLengthVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableFloatLengthVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableFloatLengthVector.
         */
        public static class Dense extends MutableFloatLengthVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable FloatLengthVector.
             * @param values float[]; the values of the entries in the new Absolute Dense Mutable FloatLengthVector
             * @param unit U; the unit of the new Absolute Dense MutableFloatLengthVector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable FloatLengthVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable FloatLengthVector
             * @param unit U; the unit of the new Absolute Dense Mutable FloatLengthVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Float> values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable FloatLengthVector.
             * @param values FloatLength.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense
             *            MutableFloatLengthVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final FloatLength.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable FloatLengthVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable FloatLengthVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Abs<LengthUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable FloatLengthVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final FloatVectorDataDense data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatLengthVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new FloatLengthVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatLengthVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableFloatLengthVector.Abs.Dense result =
                    new MutableFloatLengthVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableFloatLengthVector.Abs copy()
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
            public MutableFloatLengthVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatLengthVector.Abs toSparse()
            {
                return new MutableFloatLengthVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableFloatLengthVector.
         */
        public static class Sparse extends MutableFloatLengthVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable FloatLengthVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatLengthVector
             * @param unit U; the unit of the new Absolute Sparse Mutable FloatLengthVector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Float> values, final LengthUnit unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Absolute Sparse Mutable FloatLengthVector.
             * @param values FloatLength.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            FloatLengthVector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Abs<LengthUnit>> values, final int length)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, length);
            }

            /**
             * Construct a new Absolute Sparse Mutable FloatLengthVector.
             * @param values float[]; the values of the entries in the new Absolute Sparse Mutable FloatLengthVector
             * @param unit U; the unit of the new Absolute Sparse Mutable FloatLengthVector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable FloatLengthVector.
             * @param values FloatLength.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
             *            FloatLengthVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final FloatLength.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable FloatLengthVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable FloatLengthVector
             */
            Sparse(final FloatVectorDataSparse data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public FloatLengthVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new FloatLengthVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableFloatLengthVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableFloatLengthVector.Abs.Sparse result =
                    new MutableFloatLengthVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableFloatLengthVector.Abs copy()
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
            public MutableFloatLengthVector.Abs toDense()
            {
                return new MutableFloatLengthVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatLengthVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatLength.Abs get(final int index) throws ValueException
        {
            return new FloatLength.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Abs plus(final FloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Abs minus(final FloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel minus(final FloatLengthVector.Abs abs) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs abs()
        {
            return (MutableFloatLengthVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs acos()
        {
            return (MutableFloatLengthVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs asin()
        {
            return (MutableFloatLengthVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs atan()
        {
            return (MutableFloatLengthVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs cbrt()
        {
            return (MutableFloatLengthVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs ceil()
        {
            return (MutableFloatLengthVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs cos()
        {
            return (MutableFloatLengthVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs cosh()
        {
            return (MutableFloatLengthVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs exp()
        {
            return (MutableFloatLengthVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs expm1()
        {
            return (MutableFloatLengthVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs floor()
        {
            return (MutableFloatLengthVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs log()
        {
            return (MutableFloatLengthVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs log10()
        {
            return (MutableFloatLengthVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs log1p()
        {
            return (MutableFloatLengthVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs pow(final double x)
        {
            return (MutableFloatLengthVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs rint()
        {
            return (MutableFloatLengthVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs round()
        {
            return (MutableFloatLengthVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs signum()
        {
            return (MutableFloatLengthVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs sin()
        {
            return (MutableFloatLengthVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs sinh()
        {
            return (MutableFloatLengthVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs sqrt()
        {
            return (MutableFloatLengthVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs tan()
        {
            return (MutableFloatLengthVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs tanh()
        {
            return (MutableFloatLengthVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs toDegrees()
        {
            return (MutableFloatLengthVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs toRadians()
        {
            return (MutableFloatLengthVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs inv()
        {
            return (MutableFloatLengthVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs multiplyBy(final float constant)
        {
            return (MutableFloatLengthVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Abs divideBy(final float constant)
        {
            return (MutableFloatLengthVector.Abs) super.divideBy(constant);
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatLengthVector.
     */
    public abstract static class Rel extends MutableFloatVector.Rel<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableFloatLengthVector.
         * @param unit U; the unit of the new Absolute MutableFloatLengthVector
         */
        protected Rel(final LengthUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatLengthVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract FloatLengthVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableFloatLengthVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableFloatLengthVector.Rel toSparse();

        /**
         * Float Dense Relative Immutable FloatLength class.
         */
        public static class Dense extends MutableFloatLengthVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Float FloatLength Vector. An area is always relative.
             * @param values float[]; the values of the entries in the new Dense Immutable Float FloatLength Vector
             * @param unit U; the unit of the new Dense Immutable FloatLength Vector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable FloatLength Vector
             * @param unit U; the unit of the new Relative Dense Immutable FloatLength Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Float> values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param values List&lt;FloatLength&gt;; the values of the Scalar FloatLength entries in the new Relative Dense
             *            Immutable FloatLength Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Rel<LengthUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatLength Vector. An area is always relative.
             * @param values FloatLength[]; the values of the Scalar FloatLength entries in the new Relative Dense Immutable
             *            FloatLength Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final FloatLength.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable FloatLength Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final FloatVectorDataDense data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final FloatLengthVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new FloatLengthVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloatLengthVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableFloatLengthVector.Rel.Dense result =
                    new MutableFloatLengthVector.Rel.Dense(getData(), getUnit());
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
            public final MutableFloatLengthVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloatLengthVector.Rel toSparse()
            {
                return new MutableFloatLengthVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Float Sparse Relative Immutable FloatLength class.
         */
        public static class Sparse extends MutableFloatLengthVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable FloatLength Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable FloatLength Vector
             * @param unit LengthUnit; the unit of the new Relative Sparse Immutable FloatLength Vector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Float> values, final LengthUnit unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Sparse Immutable FloatLength Vector. An area is always relative.
             * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            FloatLength Vector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Rel<LengthUnit>> values, final int length)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, length);
            }

            /**
             * Construct a new Sparse Immutable Float FloatLength Vector. An area is always relative.
             * @param values float[]; the values of the entries in the new Sparse Immutable Float FloatLength Vector
             * @param unit U; the unit of the new Sparse Immutable FloatLength Vector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable FloatLength Vector. An area is always relative.
             * @param values FloatLength[]; the values of the Scalar FloatLength entries in the new Relative Sparse Immutable
             *            FloatLength Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final FloatLength.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable FloatLength Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final FloatVectorDataSparse data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final FloatLengthVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new FloatLengthVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloatLengthVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableFloatLengthVector.Rel.Sparse result =
                    new MutableFloatLengthVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableFloatLengthVector.Rel toDense()
            {
                return new MutableFloatLengthVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloatLengthVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel get(final int index) throws ValueException
        {
            return (FloatLength.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel copy()
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
        public final FloatLengthVector.Rel plus(final FloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel minus(final FloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel times(final FloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel divide(final FloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel plus(final MutableFloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel minus(final MutableFloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel times(final MutableFloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final FloatLengthVector.Rel divide(final MutableFloatLengthVector.Rel rel) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel abs()
        {
            return (MutableFloatLengthVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel acos()
        {
            return (MutableFloatLengthVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel asin()
        {
            return (MutableFloatLengthVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel atan()
        {
            return (MutableFloatLengthVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel cbrt()
        {
            return (MutableFloatLengthVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel ceil()
        {
            return (MutableFloatLengthVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel cos()
        {
            return (MutableFloatLengthVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel cosh()
        {
            return (MutableFloatLengthVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel exp()
        {
            return (MutableFloatLengthVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel expm1()
        {
            return (MutableFloatLengthVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel floor()
        {
            return (MutableFloatLengthVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel log()
        {
            return (MutableFloatLengthVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel log10()
        {
            return (MutableFloatLengthVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel log1p()
        {
            return (MutableFloatLengthVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel pow(final double x)
        {
            return (MutableFloatLengthVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel rint()
        {
            return (MutableFloatLengthVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel round()
        {
            return (MutableFloatLengthVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel signum()
        {
            return (MutableFloatLengthVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel sin()
        {
            return (MutableFloatLengthVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel sinh()
        {
            return (MutableFloatLengthVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel sqrt()
        {
            return (MutableFloatLengthVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel tan()
        {
            return (MutableFloatLengthVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel tanh()
        {
            return (MutableFloatLengthVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel toDegrees()
        {
            return (MutableFloatLengthVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel toRadians()
        {
            return (MutableFloatLengthVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel inv()
        {
            return (MutableFloatLengthVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel multiplyBy(final float constant)
        {
            return (MutableFloatLengthVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatLengthVector.Rel divideBy(final float constant)
        {
            return (MutableFloatLengthVector.Rel) super.divideBy(constant);
        }
    }
}
