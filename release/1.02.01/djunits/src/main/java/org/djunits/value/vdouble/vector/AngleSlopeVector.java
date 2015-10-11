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
 * Immutable AngleSlope Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AngleSlopeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AngleSlopeVector.
     */
    public abstract static class Abs extends DoubleVector.Abs<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param unit U; the unit of the new Absolute Immutable DoubleVector
         */
        protected Abs(final AngleSlopeUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAngleSlopeVector.Abs mutable();

        /** {@inheritDoc} */
        public abstract AngleSlopeVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract AngleSlopeVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of DoubleVector.
         */
        public static class Dense extends AngleSlopeVector.Abs implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Dense Immutable
             *            DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final AngleSlope.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<AngleSlopeUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
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
            public final MutableAngleSlopeVector.Abs mutable()
            {
                return new MutableAngleSlopeVector.Abs.Dense(getData(), getUnit());
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
            public AngleSlopeVector.Abs toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public AngleSlopeVector.Abs toSparse()
            {
                return new AngleSlopeVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of DoubleVector.
         */
        public static class Sparse extends AngleSlopeVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
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
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            DoubleVector
             * @param angleslope the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<AngleSlopeUnit>> values, final int angleslope)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMA(values, angleslope);
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final AngleSlopeUnit unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final AngleSlope.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             */
            Sparse(final DoubleVectorDataSparse data, final AngleSlopeUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAngleSlopeVector.Abs mutable()
            {
                return new MutableAngleSlopeVector.Abs.Sparse(getData(), getUnit());
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
            public AngleSlopeVector.Abs toDense()
            {
                return new AngleSlopeVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public AngleSlopeVector.Abs toSparse()
            {
                return this;
            }
        }

        /* ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public AngleSlope.Abs get(final int index) throws ValueException
        {
            return new AngleSlope.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the DoubleVectorData
         * @param unit the unit to use
         * @return an AngleSlopeVector
         */
        static AngleSlopeVector.Abs instantiateAbs(final DoubleVectorData dvData, final AngleSlopeUnit unit)
        {
            if (dvData instanceof DoubleVectorDataSparse)
            {
                return new AngleSlopeVector.Abs.Sparse((DoubleVectorDataSparse) dvData, unit);
            }
            else
            {
                return new AngleSlopeVector.Abs.Dense((DoubleVectorDataDense) dvData, unit);
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
        public final AngleSlopeVector.Abs plus(final AngleSlopeVector.Rel rel) throws ValueException
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
        public final AngleSlopeVector.Abs minus(final AngleSlopeVector.Rel rel) throws ValueException
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
        public final AngleSlopeVector.Rel minus(final AngleSlopeVector.Abs abs) throws ValueException
        {
            return AngleSlopeVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AngleSlopeVector.
     */
    public abstract static class Rel extends DoubleVector.Rel<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * @param unit the unit to use
         */
        public Rel(final AngleSlopeUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAngleSlopeVector.Rel mutable();

        /** {@inheritDoc} */
        public abstract AngleSlopeVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract AngleSlopeVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable AngleSlope class.
         */
        public static class Dense extends AngleSlopeVector.Rel implements DenseData
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
             *            Immutable DoubleVector
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
             * Construct a new Relative Dense Immutable DoubleVector.
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
            public final MutableAngleSlopeVector.Rel mutable()
            {
                return new MutableAngleSlopeVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataDense getData()
            {
                return (DoubleVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final AngleSlopeVector.Rel toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            public final AngleSlopeVector.Rel toSparse()
            {
                return new AngleSlopeVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable AngleSlope class.
         */
        public static class Sparse extends AngleSlopeVector.Rel implements SparseData
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
             * Construct a new Relative Sparse Immutable DoubleVector.
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
            public final MutableAngleSlopeVector.Rel mutable()
            {
                return new MutableAngleSlopeVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataSparse getData()
            {
                return (DoubleVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final AngleSlopeVector.Rel toDense()
            {
                return new AngleSlopeVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final AngleSlopeVector.Rel toSparse()
            {
                return this;
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

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the DoubleVectorData
         * @param unit the unit to use
         * @return an AngleSlopeVector
         */
        static AngleSlopeVector.Rel instantiateRel(final DoubleVectorData dvData, final AngleSlopeUnit unit)
        {
            if (dvData instanceof DoubleVectorDataSparse)
            {
                return new AngleSlopeVector.Rel.Sparse((DoubleVectorDataSparse) dvData, unit);
            }
            else
            {
                return new AngleSlopeVector.Rel.Dense((DoubleVectorDataDense) dvData, unit);
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
        public final AngleSlopeVector.Rel plus(final AngleSlopeVector.Rel rel) throws ValueException
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
        public final AngleSlopeVector.Rel minus(final AngleSlopeVector.Rel rel) throws ValueException
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
        public final AngleSlopeVector.Rel times(final AngleSlopeVector.Rel rel) throws ValueException
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
        public final AngleSlopeVector.Rel divide(final AngleSlopeVector.Rel rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

    }

}
