package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Length;

/**
 * Mutable Length Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableLengthVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of LengthVector.
     */
    public abstract static class Abs extends MutableDoubleVector.Abs<LengthUnit>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableLengthVector.
         * @param unit U; the unit of the new Absolute MutableLengthVector
         */
        protected Abs(final LengthUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableLengthVector.Abs mutable();

        /** {@inheritDoc} */
        @Override
        public abstract LengthVector.Abs immutable();

        /** {@inheritDoc} */
        @Override
        public abstract MutableLengthVector.Abs copy();

        /** {@inheritDoc} */
        public abstract MutableLengthVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract MutableLengthVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of MutableLengthVector.
         */
        public static class Dense extends MutableLengthVector.Abs implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Mutable LengthVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Mutable LengthVector
             * @param unit U; the unit of the new Absolute Dense MutableLengthVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable LengthVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable LengthVector
             * @param unit U; the unit of the new Absolute Dense Mutable LengthVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable LengthVector.
             * @param values Length.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense MutableLengthVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Length.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable LengthVector.
             * @param values List; the values of the entries in the new Absolute Dense Mutable LengthVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<LengthUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Mutable LengthVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public LengthVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new LengthVector.Abs.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableLengthVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableLengthVector.Abs.Dense result = new MutableLengthVector.Abs.Dense(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableLengthVector.Abs copy()
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
            public MutableLengthVector.Abs toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableLengthVector.Abs toSparse()
            {
                return new MutableLengthVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableLengthVector.
         */
        public static class Sparse extends MutableLengthVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse Mutable LengthVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Mutable LengthVector
             * @param unit U; the unit of the new Absolute Sparse Mutable LengthVector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final LengthUnit unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Absolute Sparse Mutable LengthVector.
             * @param values Length.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable LengthVector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<LengthUnit>> values, final int length)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                initializeSparseMA(values, length);
            }

            /**
             * Construct a new Absolute Sparse Mutable LengthVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Mutable LengthVector
             * @param unit U; the unit of the new Absolute Sparse Mutable LengthVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable LengthVector.
             * @param values Length.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable LengthVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Length.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Mutable LengthVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Mutable LengthVector
             */
            Sparse(final DoubleVectorDataSparse data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public LengthVector.Abs immutable()
            {
                setCopyOnWrite(true);
                return new LengthVector.Abs.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableLengthVector.Abs mutable()
            {
                setCopyOnWrite(true);
                final MutableLengthVector.Abs.Sparse result = new MutableLengthVector.Abs.Sparse(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("checkstyle:designforextension")
            public MutableLengthVector.Abs copy()
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
            public MutableLengthVector.Abs toDense()
            {
                return new MutableLengthVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableLengthVector.Abs toSparse()
            {
                return copy();
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public Length.Abs get(final int index) throws ValueException
        {
            return new Length.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the
         * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Abs plus(final LengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Abs.instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Absolute value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Abs minus(final LengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Abs.instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
         * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param abs the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel minus(final LengthVector.Abs abs) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs abs()
        {
            return (MutableLengthVector.Abs) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs acos()
        {
            return (MutableLengthVector.Abs) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs asin()
        {
            return (MutableLengthVector.Abs) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs atan()
        {
            return (MutableLengthVector.Abs) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs cbrt()
        {
            return (MutableLengthVector.Abs) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs ceil()
        {
            return (MutableLengthVector.Abs) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs cos()
        {
            return (MutableLengthVector.Abs) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs cosh()
        {
            return (MutableLengthVector.Abs) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs exp()
        {
            return (MutableLengthVector.Abs) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs expm1()
        {
            return (MutableLengthVector.Abs) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs floor()
        {
            return (MutableLengthVector.Abs) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs log()
        {
            return (MutableLengthVector.Abs) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs log10()
        {
            return (MutableLengthVector.Abs) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs log1p()
        {
            return (MutableLengthVector.Abs) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs pow(final double x)
        {
            return (MutableLengthVector.Abs) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs rint()
        {
            return (MutableLengthVector.Abs) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs round()
        {
            return (MutableLengthVector.Abs) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs signum()
        {
            return (MutableLengthVector.Abs) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs sin()
        {
            return (MutableLengthVector.Abs) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs sinh()
        {
            return (MutableLengthVector.Abs) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs sqrt()
        {
            return (MutableLengthVector.Abs) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs tan()
        {
            return (MutableLengthVector.Abs) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs tanh()
        {
            return (MutableLengthVector.Abs) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs toDegrees()
        {
            return (MutableLengthVector.Abs) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs toRadians()
        {
            return (MutableLengthVector.Abs) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs inv()
        {
            return (MutableLengthVector.Abs) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs multiplyBy(final double constant)
        {
            return (MutableLengthVector.Abs) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Abs divideBy(final double constant)
        {
            return (MutableLengthVector.Abs) super.divideBy(constant);
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of LengthVector.
     */
    public abstract static class Rel extends MutableDoubleVector.Rel<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Absolute MutableLengthVector.
         * @param unit U; the unit of the new Absolute MutableLengthVector
         */
        protected Rel(final LengthUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableLengthVector.Rel mutable();

        /** {@inheritDoc} */
        @Override
        public abstract LengthVector.Rel immutable();

        /** {@inheritDoc} */
        public abstract MutableLengthVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract MutableLengthVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable Length class.
         */
        public static class Dense extends MutableLengthVector.Rel implements DenseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Dense Immutable Double Length Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Dense Immutable Double Length Vector
             * @param unit U; the unit of the new Dense Immutable Length Vector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector. An area is always relative.
             * @param values List; the values of the entries in the new Relative Dense Immutable Length Vector
             * @param unit U; the unit of the new Relative Dense Immutable Length Vector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List&lt;Length&gt;; the values of the Scalar Length entries in the new Relative Dense Immutable
             *            Length Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<LengthUnit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable Length Vector. An area is always relative.
             * @param values Length[]; the values of the Scalar Length entries in the new Relative Dense Immutable Length Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Length.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable Length Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final LengthVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new LengthVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableLengthVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableLengthVector.Rel.Dense result = new MutableLengthVector.Rel.Dense(getData(), getUnit());
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
            public final MutableLengthVector.Rel toDense()
            {
                return copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableLengthVector.Rel toSparse()
            {
                return new MutableLengthVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable Length class.
         */
        public static class Sparse extends MutableLengthVector.Rel implements SparseData
        {
            /** */
            private static final long serialVersionUID = 20150905L;

            /**
             * Construct a new Sparse Immutable Length Vector. An area is always relative.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable Length Vector
             * @param unit LengthUnit; the unit of the new Relative Sparse Immutable Length Vector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final LengthUnit unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Sparse Immutable Length Vector. An area is always relative.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Length
             *            Vector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<LengthUnit>> values, final int length)
                throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, length);
            }

            /**
             * Construct a new Sparse Immutable Double Length Vector. An area is always relative.
             * @param values double[]; the values of the entries in the new Sparse Immutable Double Length Vector
             * @param unit U; the unit of the new Sparse Immutable Length Vector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final LengthUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable Length Vector. An area is always relative.
             * @param values Length[]; the values of the Scalar Length entries in the new Relative Sparse Immutable Length
             *            Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Length.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Mutable Length Vector.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleVectorDataSparse data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final LengthVector.Rel immutable()
            {
                setCopyOnWrite(true);
                return new LengthVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableLengthVector.Rel mutable()
            {
                setCopyOnWrite(true);
                final MutableLengthVector.Rel.Sparse result = new MutableLengthVector.Rel.Sparse(getData(), getUnit());
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
            public final MutableLengthVector.Rel toDense()
            {
                return new MutableLengthVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableLengthVector.Rel toSparse()
            {
                return copy();
            }
        }

        /**********************************************************************************/
        /**************************** TYPED CALCULATION METHODS ***************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final Length.Rel get(final int index) throws ValueException
        {
            return (Length.Rel) super.get(index);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel copy()
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
        public final LengthVector.Rel plus(final LengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel minus(final LengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel times(final LengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel divide(final LengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**
         * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
         * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
         * result is a dense vector or matrix.
         * @param rel the right operand
         * @return the addition of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel plus(final MutableLengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /**
         * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
         * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
         * otherwise the result is a dense vector or matrix.
         * @param rel the right operand
         * @return the subtraction of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel minus(final MutableLengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /**
         * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value
         * and store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
         * otherwise the result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the multiplication of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel times(final MutableLengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /**
         * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store
         * the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
         * result is a sparse vector or matrix.
         * @param rel the right operand
         * @return the division of this vector and the operand
         * @throws ValueException in case this vector or matrix and the operand have a different size
         */
        public final LengthVector.Rel divide(final MutableLengthVector.Rel rel) throws ValueException
        {
            return LengthVector.Rel.instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel abs()
        {
            return (MutableLengthVector.Rel) super.abs();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel acos()
        {
            return (MutableLengthVector.Rel) super.acos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel asin()
        {
            return (MutableLengthVector.Rel) super.asin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel atan()
        {
            return (MutableLengthVector.Rel) super.atan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel cbrt()
        {
            return (MutableLengthVector.Rel) super.cbrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel ceil()
        {
            return (MutableLengthVector.Rel) super.ceil();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel cos()
        {
            return (MutableLengthVector.Rel) super.cos();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel cosh()
        {
            return (MutableLengthVector.Rel) super.cosh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel exp()
        {
            return (MutableLengthVector.Rel) super.exp();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel expm1()
        {
            return (MutableLengthVector.Rel) super.expm1();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel floor()
        {
            return (MutableLengthVector.Rel) super.floor();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel log()
        {
            return (MutableLengthVector.Rel) super.log();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel log10()
        {
            return (MutableLengthVector.Rel) super.log10();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel log1p()
        {
            return (MutableLengthVector.Rel) super.log1p();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel pow(final double x)
        {
            return (MutableLengthVector.Rel) super.pow(x);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel rint()
        {
            return (MutableLengthVector.Rel) super.rint();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel round()
        {
            return (MutableLengthVector.Rel) super.round();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel signum()
        {
            return (MutableLengthVector.Rel) super.signum();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel sin()
        {
            return (MutableLengthVector.Rel) super.sin();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel sinh()
        {
            return (MutableLengthVector.Rel) super.sinh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel sqrt()
        {
            return (MutableLengthVector.Rel) super.sqrt();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel tan()
        {
            return (MutableLengthVector.Rel) super.tan();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel tanh()
        {
            return (MutableLengthVector.Rel) super.tanh();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel toDegrees()
        {
            return (MutableLengthVector.Rel) super.toDegrees();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel toRadians()
        {
            return (MutableLengthVector.Rel) super.toRadians();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel inv()
        {
            return (MutableLengthVector.Rel) super.inv();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel multiplyBy(final double constant)
        {
            return (MutableLengthVector.Rel) super.multiplyBy(constant);
        }

        /** {@inheritDoc} */
        @Override
        public final MutableLengthVector.Rel divideBy(final double constant)
        {
            return (MutableLengthVector.Rel) super.divideBy(constant);
        }

    }
}
