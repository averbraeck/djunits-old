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
 * Immutable Temperature Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface TemperatureVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TemperatureVector.
     */
    public abstract static class Abs extends DoubleVector.Abs<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param unit U; the unit of the new Absolute Immutable DoubleVector
         */
        protected Abs(final TemperatureUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableTemperatureVector.Abs mutable();

        /** {@inheritDoc} */
        public abstract TemperatureVector.Abs toDense();

        /** {@inheritDoc} */
        public abstract TemperatureVector.Abs toSparse();

        /**
         * ABSOLUTE DENSE implementation of DoubleVector.
         */
        public static class Dense extends TemperatureVector.Abs implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final TemperatureUnit unit) throws ValueException
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
            public Dense(final List<Double> values, final TemperatureUnit unit) throws ValueException
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
            public Dense(final Temperature.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<TemperatureUnit>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
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
            public final MutableTemperatureVector.Abs mutable()
            {
                return new MutableTemperatureVector.Abs.Dense(getData(), getUnit());
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
            public TemperatureVector.Abs toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public TemperatureVector.Abs toSparse()
            {
                return new TemperatureVector.Abs.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of DoubleVector.
         */
        public static class Sparse extends TemperatureVector.Abs implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
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
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            DoubleVector
             * @param temperature the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<TemperatureUnit>> values, final int temperature)
                throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMA(values, temperature);
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final TemperatureUnit unit) throws ValueException
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
            public Sparse(final Temperature.Abs[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             */
            Sparse(final DoubleVectorDataSparse data, final TemperatureUnit unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableTemperatureVector.Abs mutable()
            {
                return new MutableTemperatureVector.Abs.Sparse(getData(), getUnit());
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
            public TemperatureVector.Abs toDense()
            {
                return new TemperatureVector.Abs.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public TemperatureVector.Abs toSparse()
            {
                return this;
            }
        }

        /* ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public Temperature.Abs get(final int index) throws ValueException
        {
            return new Temperature.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the DoubleVectorData
         * @param unit the unit to use
         * @return an TemperatureVector
         */
        static TemperatureVector.Abs instantiateAbs(final DoubleVectorData dvData, final TemperatureUnit unit)
        {
            if (dvData instanceof DoubleVectorDataSparse)
            {
                return new TemperatureVector.Abs.Sparse((DoubleVectorDataSparse) dvData, unit);
            }
            else
            {
                return new TemperatureVector.Abs.Dense((DoubleVectorDataDense) dvData, unit);
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
        public final TemperatureVector.Abs plus(final TemperatureVector.Rel rel) throws ValueException
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
        public final TemperatureVector.Abs minus(final TemperatureVector.Rel rel) throws ValueException
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
        public final TemperatureVector.Rel minus(final TemperatureVector.Abs abs) throws ValueException
        {
            return TemperatureVector.Rel.instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TemperatureVector.
     */
    public abstract static class Rel extends DoubleVector.Rel<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * @param unit the unit to use
         */
        public Rel(final TemperatureUnit unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableTemperatureVector.Rel mutable();

        /** {@inheritDoc} */
        public abstract TemperatureVector.Rel toDense();

        /** {@inheritDoc} */
        public abstract TemperatureVector.Rel toSparse();

        /**
         * Double Dense Relative Immutable Temperature class.
         */
        public static class Dense extends TemperatureVector.Rel implements DenseData
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
             *            Immutable DoubleVector
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
             * Construct a new Relative Dense Immutable DoubleVector.
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
            public final MutableTemperatureVector.Rel mutable()
            {
                return new MutableTemperatureVector.Rel.Dense(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataDense getData()
            {
                return (DoubleVectorDataDense) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final TemperatureVector.Rel toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            public final TemperatureVector.Rel toSparse()
            {
                return new TemperatureVector.Rel.Sparse(getData().toSparse(), getUnit());
            }
        }

        /**
         * Double Sparse Relative Immutable Temperature class.
         */
        public static class Sparse extends TemperatureVector.Rel implements SparseData
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
             * Construct a new Relative Sparse Immutable DoubleVector.
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
            public final MutableTemperatureVector.Rel mutable()
            {
                return new MutableTemperatureVector.Rel.Sparse(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleVectorDataSparse getData()
            {
                return (DoubleVectorDataSparse) this.data;
            }

            /** {@inheritDoc} */
            @Override
            public final TemperatureVector.Rel toDense()
            {
                return new TemperatureVector.Rel.Dense(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final TemperatureVector.Rel toSparse()
            {
                return this;
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

        /**
         * Instantiate a vector based on the type of data.
         * @param dvData the DoubleVectorData
         * @param unit the unit to use
         * @return an TemperatureVector
         */
        static TemperatureVector.Rel instantiateRel(final DoubleVectorData dvData, final TemperatureUnit unit)
        {
            if (dvData instanceof DoubleVectorDataSparse)
            {
                return new TemperatureVector.Rel.Sparse((DoubleVectorDataSparse) dvData, unit);
            }
            else
            {
                return new TemperatureVector.Rel.Dense((DoubleVectorDataDense) dvData, unit);
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
        public final TemperatureVector.Rel plus(final TemperatureVector.Rel rel) throws ValueException
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
        public final TemperatureVector.Rel minus(final TemperatureVector.Rel rel) throws ValueException
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
        public final TemperatureVector.Rel times(final TemperatureVector.Rel rel) throws ValueException
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
        public final TemperatureVector.Rel divide(final TemperatureVector.Rel rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

    }

}
