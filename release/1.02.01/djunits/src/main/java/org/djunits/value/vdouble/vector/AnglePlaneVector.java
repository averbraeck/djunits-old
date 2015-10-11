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
 * Immutable AnglePlane Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AnglePlaneVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AnglePlaneVector.
     */
    public abstract static class Abs extends DoubleVector.Abs<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param unit U; the unit of the new Absolute Immutable DoubleVector
         */
        protected Abs(final AnglePlaneUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAnglePlaneVector.Abs mutable();

        /** {@inheritDoc} */
        public abstract AnglePlaneVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract AnglePlaneVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of DoubleVector.
         */
        public static class Dense extends AnglePlaneVector.Abs implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final AnglePlaneUnit unit) throws ValueException
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
            public Dense(final List<Double> values, final AnglePlaneUnit unit) throws ValueException
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
            public Dense(final AnglePlane.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<AnglePlaneUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
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
            public final MutableAnglePlaneVector.Abs mutable()
            {
                return new MutableAnglePlaneVector.Abs.Dense(getData(), getUnit());
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
            public AnglePlaneVector.Abs toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public AnglePlaneVector.Abs toSparse()
            {
                return new AnglePlaneVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of DoubleVector.
         */
        public static class Sparse extends AnglePlaneVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
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
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            DoubleVector
             * @param angleplane the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<AnglePlaneUnit>> values, final int angleplane)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMA(values, angleplane);
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final AnglePlaneUnit unit) throws ValueException
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
            public Sparse(final AnglePlane.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             */
            Sparse(final DoubleVectorDataSparse data, final AnglePlaneUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableAnglePlaneVector.Abs mutable()
            {
                return new MutableAnglePlaneVector.Abs.Sparse(getData(), getUnit());
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
            public AnglePlaneVector.Abs toDense()
            {
                return new AnglePlaneVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public AnglePlaneVector.Abs toSparse()
            {
                return this;
            }
        }

        /* ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public AnglePlane.Abs get(final int index) throws ValueException
        {
            return new AnglePlane.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the DoubleVectorData
         * @param unit the unit to use
         * @return an AnglePlaneVector
         */
        static AnglePlaneVector.Abs instantiateAbs(final DoubleVectorData dvData, final AnglePlaneUnit unit)
        {
            if (dvData instanceof DoubleVectorDataSparse)
            {
                return new AnglePlaneVector.Abs.Sparse((DoubleVectorDataSparse) dvData, unit);
            }
            else
            {
                return new AnglePlaneVector.Abs.Dense((DoubleVectorDataDense) dvData, unit);
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
        public final AnglePlaneVector.Abs plus(final AnglePlaneVector.Rel rel) throws ValueException
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
        public final AnglePlaneVector.Abs minus(final AnglePlaneVector.Rel rel) throws ValueException
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
        public final AnglePlaneVector.Rel minus(final AnglePlaneVector.Abs abs) throws ValueException
        {
            return AnglePlaneVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AnglePlaneVector.
     */
    public abstract static class Rel extends DoubleVector.Rel<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * @param unit the unit to use
         */
        public Rel(final AnglePlaneUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableAnglePlaneVector.Rel mutable();

        /** {@inheritDoc} */
        public abstract AnglePlaneVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract AnglePlaneVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable AnglePlane class.
         */
        public static class Dense extends AnglePlaneVector.Rel implements DenseData
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
             *            Immutable DoubleVector
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
             * Construct a new Relative Dense Immutable DoubleVector.
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
            public final MutableAnglePlaneVector.Rel mutable()
            {
                return new MutableAnglePlaneVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataDense getData()
            {
                return (DoubleVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final AnglePlaneVector.Rel toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            public final AnglePlaneVector.Rel toSparse()
            {
                return new AnglePlaneVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable AnglePlane class.
         */
        public static class Sparse extends AnglePlaneVector.Rel implements SparseData
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
             * Construct a new Relative Sparse Immutable DoubleVector.
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
            public final MutableAnglePlaneVector.Rel mutable()
            {
                return new MutableAnglePlaneVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataSparse getData()
            {
                return (DoubleVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final AnglePlaneVector.Rel toDense()
            {
                return new AnglePlaneVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final AnglePlaneVector.Rel toSparse()
            {
                return this;
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

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the DoubleVectorData
         * @param unit the unit to use
         * @return an AnglePlaneVector
         */
        static AnglePlaneVector.Rel instantiateRel(final DoubleVectorData dvData, final AnglePlaneUnit unit)
        {
            if (dvData instanceof DoubleVectorDataSparse)
            {
                return new AnglePlaneVector.Rel.Sparse((DoubleVectorDataSparse) dvData, unit);
            }
            else
            {
                return new AnglePlaneVector.Rel.Dense((DoubleVectorDataDense) dvData, unit);
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
        public final AnglePlaneVector.Rel plus(final AnglePlaneVector.Rel rel) throws ValueException
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
        public final AnglePlaneVector.Rel minus(final AnglePlaneVector.Rel rel) throws ValueException
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
        public final AnglePlaneVector.Rel times(final AnglePlaneVector.Rel rel) throws ValueException
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
        public final AnglePlaneVector.Rel divide(final AnglePlaneVector.Rel rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

    }

}
