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
 * Immutable FloatLength Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatLengthVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatLengthVector.
     */
    public abstract static class Abs extends FloatVector.Abs<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param unit U; the unit of the new Absolute Immutable FloatVector
         */
        protected Abs(final LengthUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatLengthVector.Abs mutable();

        /** {@inheritDoc} */
        public abstract FloatLengthVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract FloatLengthVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of FloatVector.
         */
        public static class Dense extends FloatLengthVector.Abs implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @param unit U; the unit of the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final LengthUnit unit) throws ValueException
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
            public Dense(final List<Float> values, final LengthUnit unit) throws ValueException
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
            public Dense(final FloatLength.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Abs<LengthUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
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
            public final MutableFloatLengthVector.Abs mutable()
            {
                return new MutableFloatLengthVector.Abs.Dense(getData(), getUnit());
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
            public FloatLengthVector.Abs toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatLengthVector.Abs toSparse()
            {
                return new FloatLengthVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of FloatVector.
         */
        public static class Sparse extends FloatLengthVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Immutable FloatVector
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
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
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            FloatVector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Abs<LengthUnit>> values, final int length)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMA(values, length);
            }

            /**
             * Construct a new Absolute Sparse Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Absolute Sparse Immutable FloatVector
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final LengthUnit unit) throws ValueException
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
            public Sparse(final FloatLength.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable FloatVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
             */
            Sparse(final FloatVectorDataSparse data, final LengthUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatLengthVector.Abs mutable()
            {
                return new MutableFloatLengthVector.Abs.Sparse(getData(), getUnit());
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
            public FloatLengthVector.Abs toDense()
            {
                return new FloatLengthVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatLengthVector.Abs toSparse()
            {
                return this;
            }
        }

        /* ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatLength.Abs get(final int index) throws ValueException
        {
            return new FloatLength.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the FloatVectorData
         * @param unit the unit to use
         * @return an FloatLengthVector
         */
        static FloatLengthVector.Abs instantiateAbs(final FloatVectorData dvData, final LengthUnit unit)
        {
            if (dvData instanceof FloatVectorDataSparse)
            {
                return new FloatLengthVector.Abs.Sparse((FloatVectorDataSparse) dvData, unit);
            }
            else
            {
                return new FloatLengthVector.Abs.Dense((FloatVectorDataDense) dvData, unit);
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
        public final FloatLengthVector.Abs plus(final FloatLengthVector.Rel rel) throws ValueException
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
        public final FloatLengthVector.Abs minus(final FloatLengthVector.Rel rel) throws ValueException
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
        public final FloatLengthVector.Rel minus(final FloatLengthVector.Abs abs) throws ValueException
        {
            return FloatLengthVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatLengthVector.
     */
    public abstract static class Rel extends FloatVector.Rel<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * @param unit the unit to use
         */
        public Rel(final LengthUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatLengthVector.Rel mutable();

        /** {@inheritDoc} */
        public abstract FloatLengthVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract FloatLengthVector.Rel toSparse();

        /**
         * Float Dense Relative Immutable FloatLength class.
         */
        public static class Dense extends FloatLengthVector.Rel implements DenseData
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
             *            Immutable FloatVector
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
             * Construct a new Relative Dense Immutable FloatVector.
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
            public final MutableFloatLengthVector.Rel mutable()
            {
                return new MutableFloatLengthVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final FloatVectorDataDense getData()
            {
                return (FloatVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final FloatLengthVector.Rel toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            public final FloatLengthVector.Rel toSparse()
            {
                return new FloatLengthVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Float Sparse Relative Immutable FloatLength class.
         */
        public static class Sparse extends FloatLengthVector.Rel implements SparseData
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
             * Construct a new Relative Sparse Immutable FloatVector.
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
            public final MutableFloatLengthVector.Rel mutable()
            {
                return new MutableFloatLengthVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final FloatVectorDataSparse getData()
            {
                return (FloatVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final FloatLengthVector.Rel toDense()
            {
                return new FloatLengthVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final FloatLengthVector.Rel toSparse()
            {
                return this;
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

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the FloatVectorData
         * @param unit the unit to use
         * @return an FloatLengthVector
         */
        static FloatLengthVector.Rel instantiateRel(final FloatVectorData dvData, final LengthUnit unit)
        {
            if (dvData instanceof FloatVectorDataSparse)
            {
                return new FloatLengthVector.Rel.Sparse((FloatVectorDataSparse) dvData, unit);
            }
            else
            {
                return new FloatLengthVector.Rel.Dense((FloatVectorDataDense) dvData, unit);
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
        public final FloatLengthVector.Rel plus(final FloatLengthVector.Rel rel) throws ValueException
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
        public final FloatLengthVector.Rel minus(final FloatLengthVector.Rel rel) throws ValueException
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
        public final FloatLengthVector.Rel times(final FloatLengthVector.Rel rel) throws ValueException
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
        public final FloatLengthVector.Rel divide(final FloatLengthVector.Rel rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }
    }

}
