package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.%Type%Unit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.Float%Type%;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Immutable Float%Type% Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Float%Type%Vector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of Float%Type%Vector.
     */
    public abstract static class Abs extends FloatVector.Abs<%Type%Unit>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param unit U; the unit of the new Absolute Immutable FloatVector
         */
        protected Abs(final %Type%Unit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloat%Type%Vector.Abs mutable();

        /** {@inheritDoc} */
        public abstract Float%Type%Vector.Abs toDense();

        /** {@inheritDoc} */
        public abstract Float%Type%Vector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of FloatVector.
         */
        public static class Dense extends Float%Type%Vector.Abs implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @param unit U; the unit of the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @param unit U; the unit of the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Float> values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense Immutable
             *            FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Float%Type%.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Abs<%Type%Unit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
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
            public final MutableFloat%Type%Vector.Abs mutable()
            {
                return new MutableFloat%Type%Vector.Abs.Dense(getData(), getUnit());
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
            public Float%Type%Vector.Abs toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Float%Type%Vector.Abs toSparse()
            {
                return new Float%Type%Vector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of FloatVector.
         */
        public static class Sparse extends Float%Type%Vector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Immutable FloatVector
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
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
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            FloatVector
             * @param %type% the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Abs<%Type%Unit>> values, final int %type%)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMA(values, %type%);
            }

            /**
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Absolute Sparse Immutable FloatVector
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final %Type%Unit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            FloatVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Float%Type%.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable FloatVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
             */
            Sparse(final FloatVectorDataSparse data, final %Type%Unit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloat%Type%Vector.Abs mutable()
            {
                return new MutableFloat%Type%Vector.Abs.Sparse(getData(), getUnit());
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
            public Float%Type%Vector.Abs toDense()
            {
                return new Float%Type%Vector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public Float%Type%Vector.Abs toSparse()
            {
                return this;
            }
        }

        /* ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public Float%Type%.Abs get(final int index) throws ValueException
        {
            return new Float%Type%.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the FloatVectorData
         * @param unit the unit to use
         * @return an Float%Type%Vector
         */
        static Float%Type%Vector.Abs instantiateAbs(final FloatVectorData dvData, final %Type%Unit unit)
        {
            if (dvData instanceof FloatVectorDataSparse)
            {
                return new Float%Type%Vector.Abs.Sparse((FloatVectorDataSparse) dvData, unit);
            }
            else
            {
                return new Float%Type%Vector.Abs.Dense((FloatVectorDataDense) dvData, unit);
            }
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
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
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
            return instantiateAbs(this.getData().minus(rel.getData()), getUnit());
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
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of Float%Type%Vector.
     */
    public abstract static class Rel extends FloatVector.Rel<%Type%Unit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * @param unit the unit to use
         */
        public Rel(final %Type%Unit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloat%Type%Vector.Rel mutable();

        /** {@inheritDoc} */
        public abstract Float%Type%Vector.Rel toDense();

        /** {@inheritDoc} */
        public abstract Float%Type%Vector.Rel toSparse();

        /**
         * Float Dense Relative Immutable Float%Type% class.
         */
        public static class Dense extends Float%Type%Vector.Rel implements DenseData
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
             * @param values List&lt;Float%Type%&gt;; the values of the Scalar Float%Type% entries in the new Relative Dense
             *            Immutable FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Rel<%Type%Unit>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable Float%Type% Vector. An area is always relative.
             * @param values Float%Type%[]; the values of the Scalar Float%Type% entries in the new Relative Dense Immutable
             *            Float%Type% Vector
             * @throws ValueException when values has zero entries
             */
            public Dense(final Float%Type%.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
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
            public final MutableFloat%Type%Vector.Rel mutable()
            {
                return new MutableFloat%Type%Vector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final FloatVectorDataDense getData()
            {
                return (FloatVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final Float%Type%Vector.Rel toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            public final Float%Type%Vector.Rel toSparse()
            {
                return new Float%Type%Vector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Float Sparse Relative Immutable Float%Type% class.
         */
        public static class Sparse extends Float%Type%Vector.Rel implements SparseData
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
             * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            Float%Type% Vector
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
             * @param values Float%Type%[]; the values of the Scalar Float%Type% entries in the new Relative Sparse Immutable
             *            Float%Type% Vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final Float%Type%.Rel[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable FloatVector.
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
            public final MutableFloat%Type%Vector.Rel mutable()
            {
                return new MutableFloat%Type%Vector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final FloatVectorDataSparse getData()
            {
                return (FloatVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final Float%Type%Vector.Rel toDense()
            {
                return new Float%Type%Vector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final Float%Type%Vector.Rel toSparse()
            {
                return this;
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

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the FloatVectorData
         * @param unit the unit to use
         * @return an Float%Type%Vector
         */
        static Float%Type%Vector.Rel instantiateRel(final FloatVectorData dvData, final %Type%Unit unit)
        {
            if (dvData instanceof FloatVectorDataSparse)
            {
                return new Float%Type%Vector.Rel.Sparse((FloatVectorDataSparse) dvData, unit);
            }
            else
            {
                return new Float%Type%Vector.Rel.Dense((FloatVectorDataDense) dvData, unit);
            }
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
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
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
            return instantiateRel(this.getData().minus(rel.getData()), getUnit());
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
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
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
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }
    }

}
