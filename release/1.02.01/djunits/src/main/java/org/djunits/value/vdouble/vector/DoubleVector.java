package org.djunits.value.vdouble.vector;

import java.io.Serializable;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.AbstractValue;
import org.djunits.value.DenseData;
import org.djunits.value.FunctionsAbs;
import org.djunits.value.FunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Immutable DoubleVector.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version 30 Oct, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit the unit for which this Vector will be created
 */
public abstract class DoubleVector<U extends Unit<U>> extends AbstractValue<U> implements DoubleVectorInterface<U>,
    Serializable
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected DoubleVectorData data;

    /**
     * @return the internal data -- can only be used within package.
     */
    protected abstract DoubleVectorData getData();

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param unit U; the unit of the new Absolute Immutable DoubleVector
     */
    protected DoubleVector(final U unit)
    {
        super(unit);
    }

    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * @param <U> Unit the unit for which this Vector will be created
     */
    public abstract static class Abs<U extends Unit<U>> extends DoubleVector<U> implements Absolute,
        FunctionsAbs<U, DoubleVector.Abs<U>, DoubleVector.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param unit U; the unit of the new Absolute Immutable DoubleVector
         */
        protected Abs(final U unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableDoubleVector.Abs<U> mutable();

        /** {@inheritDoc} */
        public abstract DoubleVector.Abs<U> toDense();

        /** {@inheritDoc} */
        public abstract DoubleVector.Abs<U> toSparse();

        /**
         * ABSOLUTE DENSE implementation of DoubleVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Dense<U extends Unit<U>> extends Abs<U> implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final U unit) throws ValueException
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
            public Dense(final List<Double> values, final U unit) throws ValueException
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
            public Dense(final DoubleScalar.Abs<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Abs<U>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable DoubleVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleVector.Abs<U> mutable()
            {
                return new MutableDoubleVector.Abs.Dense<U>(getData(), getUnit());
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
            public DoubleVector.Abs<U> toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public DoubleVector.Abs<U> toSparse()
            {
                return new DoubleVector.Abs.Sparse<U>(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of DoubleVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Sparse<U extends Unit<U>> extends Abs<U> implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values Map; the map of indexes to values of the Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final U unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Immutable
             *            DoubleVector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Abs<U>> values, final int length) throws ValueException
            {
                super(checkNonEmptyMA(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMA(values, length);
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Absolute Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final U unit) throws ValueException
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
            public Sparse(final DoubleScalar.Abs<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable DoubleVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             */
            Sparse(final DoubleVectorDataSparse data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableDoubleVector.Abs<U> mutable()
            {
                return new MutableDoubleVector.Abs.Sparse<U>(getData(), getUnit());
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
            public DoubleVector.Abs<U> toDense()
            {
                return new DoubleVector.Abs.Dense<U>(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public DoubleVector.Abs<U> toSparse()
            {
                return this;
            }
        }

        /* ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleScalar.Abs<U> get(final int index) throws ValueException
        {
            return new DoubleScalar.Abs<U>(getInUnit(index, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> plus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> minus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Rel<U> minus(final DoubleVector.Abs<U> abs) throws ValueException
        {
            return instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * @param <U> Unit the unit for which this Vector will be created
     */
    public abstract static class Rel<U extends Unit<U>> extends DoubleVector<U> implements Relative,
        FunctionsRel<U, DoubleVector.Abs<U>, DoubleVector.Rel<U>>

    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param unit U; the unit of the new Relative Immutable DoubleVector
         */
        protected Rel(final U unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableDoubleVector.Rel<U> mutable();

        /** {@inheritDoc} */
        public abstract DoubleVector.Rel<U> toDense();

        /** {@inheritDoc} */
        public abstract DoubleVector.Rel<U> toSparse();

        /**
         * RELATIVE DENSE implementation of DoubleVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Dense<U extends Unit<U>> extends Rel<U> implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Relative Dense Immutable DoubleVector
             * @param unit U; the unit of the new Relative Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final double[] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Relative Dense Immutable DoubleVector
             * @param unit U; the unit of the new Relative Dense Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Double> values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Dense Immutable
             *            DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final DoubleScalar.Rel<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param values List; the values of the entries in the new Relative Dense Immutable DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<DoubleScalar.Rel<U>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable DoubleVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleVectorDataDense data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableDoubleVector.Rel<U> mutable()
            {
                return new MutableDoubleVector.Rel.Dense<U>(getData(), getUnit());
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
            public DoubleVector.Rel<U> toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public DoubleVector.Rel<U> toSparse()
            {
                return new DoubleVector.Rel.Sparse<U>(getData().toSparse(), getUnit());
            }
        }

        /**
         * RELATIVE SPARSE implementation of DoubleVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Sparse<U extends Unit<U>> extends Rel<U> implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Relative Sparse Immutable DoubleVector.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Relative Sparse Immutable DoubleVector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Double> values, final U unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Relative Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            DoubleVector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, DoubleScalar.Rel<U>> values, final int length) throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, length);
            }

            /**
             * Construct a new Relative Sparse Immutable DoubleVector.
             * @param values double[]; the values of the entries in the new Relative Sparse Immutable DoubleVector
             * @param unit U; the unit of the new Relative Sparse Immutable DoubleVector
             * @throws ValueException when values is null
             */
            public Sparse(final double[] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable DoubleVector.
             * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            DoubleVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final DoubleScalar.Rel<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable DoubleVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable DoubleVector
             */
            Sparse(final DoubleVectorDataSparse data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableDoubleVector.Rel<U> mutable()
            {
                return new MutableDoubleVector.Rel.Sparse<U>(getData(), getUnit());
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
            public DoubleVector.Rel<U> toDense()
            {
                return new DoubleVector.Rel.Dense<U>(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public DoubleVector.Rel<U> toSparse()
            {
                return this;
            }
        }

        /* ================================= REL GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleScalar.Rel<U> get(final int index) throws ValueException
        {
            return new DoubleScalar.Rel<U>(getInUnit(index, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Rel<U> plus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> plus(final DoubleVector.Abs<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleVector.Rel<U> minus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleVector.Rel<U> times(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleVector.Rel<U> divide(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a DoubleVector.
     * @param dsArray DoubleScalar&lt;U&gt;[]; the provided array
     * @param <U> Unit; the unit of the DoubleScalar array
     * @return DoubleScalar&lt;U&gt;[]; the provided array
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>> DoubleScalar.Abs<U>[] checkNonEmpty(final DoubleScalar.Abs<U>[] dsArray)
        throws ValueException
    {
        if (0 == dsArray.length)
        {
            throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from an empty array of DoubleScalar");
        }
        return dsArray;
    }

    /**
     * Check that a provided List can be used to create some descendant of a DoubleVector.
     * @param dsList the provided list
     * @param <U> Unit; the unit of the DoubleScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> List<DoubleScalar.Abs<U>> checkNonEmptyLA(final List<DoubleScalar.Abs<U>> dsList)
        throws ValueException
    {
        if (0 == dsList.size())
        {
            throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from an empty List of DoubleScalar");
        }
        return dsList;
    }

    /**
     * Check that a provided Map can be used to create some descendant of a DoubleVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the DoubleScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> SortedMap<Integer, DoubleScalar.Abs<U>> checkNonEmptyMA(
        final SortedMap<Integer, DoubleScalar.Abs<U>> dsMap) throws ValueException
    {
        if (0 == dsMap.size())
        {
            throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from an empty List of DoubleScalar");
        }
        return dsMap;
    }

    /**
     * Check that a provided array can be used to create some descendant of a DoubleVector.
     * @param dsArray DoubleScalar&lt;U&gt;[]; the provided array
     * @param <U> Unit; the unit of the DoubleScalar array
     * @return DoubleScalar&lt;U&gt;[]; the provided array
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>> DoubleScalar.Rel<U>[] checkNonEmpty(final DoubleScalar.Rel<U>[] dsArray)
        throws ValueException
    {
        if (0 == dsArray.length)
        {
            throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from an empty array of DoubleScalar");
        }
        return dsArray;
    }

    /**
     * Check that a provided List can be used to create some descendant of a DoubleVector.
     * @param dsList the provided list
     * @param <U> Unit; the unit of the DoubleScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> List<DoubleScalar.Rel<U>> checkNonEmptyLR(final List<DoubleScalar.Rel<U>> dsList)
        throws ValueException
    {
        if (0 == dsList.size())
        {
            throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from an empty List of DoubleScalar");
        }
        return dsList;
    }

    /**
     * Check that a provided Map can be used to create some descendant of a DoubleVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the DoubleScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> SortedMap<Integer, DoubleScalar.Rel<U>> checkNonEmptyMR(
        final SortedMap<Integer, DoubleScalar.Rel<U>> dsMap) throws ValueException
    {
        if (0 == dsMap.size())
        {
            throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from an empty List of DoubleScalar");
        }
        return dsMap;
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final DoubleVectorDataDense initializeDense(final double[] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        double[] vectorSI = new double[values.length];
        if (getUnit().equals(getUnit().getStandardUnit()))
        {
            System.arraycopy(values, 0, vectorSI, 0, values.length);
        }
        else
        {
            // TODO optimize for linear scale: multiply by factor
            for (int index = values.length; --index >= 0;)
            {
                vectorSI[index] = expressAsSIUnit(values[index]);
            }
        }
        return new DoubleVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final DoubleVectorDataDense initializeDense(final List<Double> values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        double[] vectorSI = new double[values.size()];
        if (getUnit().equals(getUnit().getStandardUnit()))
        {
            for (int index = 0; index < values.size(); index++)
            {
                vectorSI[index] = values.get(index);
            }
        }
        else
        {
            for (int index = values.size(); --index >= 0;)
            {
                // TODO optimize for linear scale: multiply by factor
                vectorSI[index] = expressAsSIUnit(values.get(index));
            }
        }
        return new DoubleVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final DoubleVectorDataDense initializeDense(final DoubleScalar<U>[] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        double[] vectorSI = new double[values.length];
        for (int index = 0; index < values.length; index++)
        {
            vectorSI[index] = values[index].getSI();
        }
        return new DoubleVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final DoubleVectorDataDense initializeDenseLA(final List<DoubleScalar.Abs<U>> values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        double[] vectorSI = new double[values.size()];
        for (int index = 0; index < values.size(); index++)
        {
            vectorSI[index] = values.get(index).getSI();
        }
        return new DoubleVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final DoubleVectorDataDense initializeDenseLR(final List<DoubleScalar.Rel<U>> values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        double[] vectorSI = new double[values.size()];
        for (int index = 0; index < values.size(); index++)
        {
            vectorSI[index] = values.get(index).getSI();
        }
        return new DoubleVectorDataDense(vectorSI);
    }

    /**
     * Import the values from a sparse map of integers and values.
     * @param values Map&lt;Integer, Double&gt;; the values
     * @param length the size of the vector
     * @return the sparse vector
     */
    protected final DoubleVectorDataSparse initializeSparse(final SortedMap<Integer, Double> values, final int length)
    {
        boolean isSI = getUnit().equals(getUnit().getStandardUnit());
        double[] vectorSI = new double[values.size()];
        int[] indices = new int[values.size()];
        int index = 0;
        for (Entry<Integer, Double> entry : values.entrySet())
        {
            vectorSI[index] = isSI ? entry.getValue() : expressAsSIUnit(entry.getValue());
            indices[index] = entry.getKey();
            index++;
        }
        return new DoubleVectorDataSparse(vectorSI, indices, length);
    }

    /**
     * Import the values from a sparse map of integers and values.
     * @param values Map&lt;Integer, Double&gt;; the values
     * @param length the size of the vector
     * @return the sparse vector
     */
    protected final DoubleVectorDataSparse initializeSparseMA(final SortedMap<Integer, DoubleScalar.Abs<U>> values,
        final int length)
    {
        boolean isSI = getUnit().equals(getUnit().getStandardUnit());
        double[] vectorSI = new double[values.size()];
        int[] indices = new int[values.size()];
        int index = 0;
        for (Entry<Integer, DoubleScalar.Abs<U>> entry : values.entrySet())
        {
            vectorSI[index] = isSI ? entry.getValue().si : expressAsSIUnit(entry.getValue().si);
            indices[index] = entry.getKey();
            index++;
        }
        return new DoubleVectorDataSparse(vectorSI, indices, length);
    }

    /**
     * Import the values from a sparse map of integers and values.
     * @param values Map&lt;Integer, Double&gt;; the values
     * @param length the size of the vector
     * @return the sparse vector
     */
    protected final DoubleVectorDataSparse initializeSparseMR(final SortedMap<Integer, DoubleScalar.Rel<U>> values,
        final int length)
    {
        boolean isSI = getUnit().equals(getUnit().getStandardUnit());
        double[] vectorSI = new double[values.size()];
        int[] indices = new int[values.size()];
        int index = 0;
        for (Entry<Integer, DoubleScalar.Rel<U>> entry : values.entrySet())
        {
            vectorSI[index] = isSI ? entry.getValue().si : expressAsSIUnit(entry.getValue().si);
            indices[index] = entry.getKey();
            index++;
        }
        return new DoubleVectorDataSparse(vectorSI, indices, length);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the DoubleVectorData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> DoubleVector.Rel<U> instantiateRel(final DoubleVectorData dvData, final U unit)
    {
        if (dvData instanceof DoubleVectorDataSparse)
        {
            return new DoubleVector.Rel.Sparse<U>((DoubleVectorDataSparse) dvData, unit);
        }
        else
        {
            return new DoubleVector.Rel.Dense<U>((DoubleVectorDataDense) dvData, unit);
        }
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the DoubleVectorData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> DoubleVector.Abs<U> instantiateAbs(final DoubleVectorData dvData, final U unit)
    {
        if (dvData instanceof DoubleVectorDataSparse)
        {
            return new DoubleVector.Abs.Sparse<U>((DoubleVectorDataSparse) dvData, unit);
        }
        else
        {
            return new DoubleVector.Abs.Dense<U>((DoubleVectorDataDense) dvData, unit);
        }
    }

    /* ============================================================================================ */
    /* ================================== GENERIC VECTOR METHODS ================================== */
    /* ============================================================================================ */

    /**
     * Create a double[] array filled with the values in the standard SI unit.
     * @return double[]; array of values in the standard SI unit
     */
    public final double[] getValuesSI()
    {
        return this.data.getDenseVectorSI();
    }

    /**
     * Create a double[] array filled with the values in the original unit.
     * @return double[]; the values in the original unit
     */
    public final double[] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /**
     * Create a double[] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return double[]; the values converted into the specified unit
     */
    public final double[] getValuesInUnit(final U targetUnit)
    {
        double[] values = getValuesSI();
        for (int i = values.length; --i >= 0;)
        {
            values[i] = ValueUtil.expressAsUnit(values[i], targetUnit);
        }
        return values;
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.data.size();
    }

    /**
     * Check that a provided index is valid.
     * @param index int; the value to check
     * @throws ValueException when index is invalid
     */
    protected final void checkIndex(final int index) throws ValueException
    {
        if (index < 0 || index >= size())
        {
            throw new ValueException("index out of range (valid range is 0.." + (size() - 1) + ", got " + index + ")");
        }
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int index) throws ValueException
    {
        checkIndex(index);
        return this.data.getSI(index);
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int index) throws ValueException
    {
        return expressAsSpecifiedUnit(getSI(index));
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int index, final U targetUnit) throws ValueException
    {
        return ValueUtil.expressAsUnit(getSI(index), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final double zSum()
    {
        return this.data.zSum();
    }

    /** {@inheritDoc} */
    @Override
    public final int cardinality()
    {
        return this.data.cardinality();
    }

    /** {@inheritDoc} */
    @Override
    public final String toString()
    {
        return toString(getUnit(), false, true);
    }

    /**
     * Print this DoubleVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the vector contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this DoubleVector with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this DoubleVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            String ab = this instanceof Absolute ? "Abs " : this instanceof Relative ? "Rel " : "??? ";
            String ds = this instanceof DenseData ? "Dense  " : this instanceof SparseData ? "Sparse " : "?????? ";
            if (this instanceof MutableDoubleVector)
            {
                buf.append("Mutable   " + ab + ds);
            }
            else
            {
                buf.append("Immutable " + ab + ds);
            }
        }
        buf.append("[");
        for (int i = 0; i < size(); i++)
        {
            double d = ValueUtil.expressAsUnit(safeGet(i), displayUnit);
            buf.append(" " + Format.format(d));
        }
        buf.append("]");
        if (withUnit)
        {
            buf.append(" " + displayUnit.getAbbreviation());
        }
        return buf.toString();
    }

    /**
     * Centralized size equality check.
     * @param other DoubleVector&lt;?&gt;; other DoubleVector
     * @throws ValueException when other is null, or vectors have unequal size
     */
    protected final void checkSize(final DoubleVector<?> other) throws ValueException
    {
        if (null == other)
        {
            throw new ValueException("other is null");
        }
        if (size() != other.size())
        {
            throw new ValueException("The vectors have different sizes: " + size() + " != " + other.size());
        }
    }

    /**
     * Centralized size equality check.
     * @param other double[]; array of double
     * @throws ValueException when vectors have unequal size
     */
    protected final void checkSize(final double[] other) throws ValueException
    {
        if (size() != other.length)
        {
            throw new ValueException("The vector and the array have different sizes: " + size() + " != " + other.length);
        }
    }

    /**
     * Retrieve a value in vectorSI without checking validity of the index.
     * @param index int; the index
     * @return double; the value stored at that index
     */
    protected final double safeGet(final int index)
    {
        return this.data.getSI(index);
    }

    /**
     * Modify a value in vectorSI without checking validity of the index.
     * @param index int; the index
     * @param valueSI double; the new value for the entry in vectorSI
     */
    protected final void safeSet(final int index, final double valueSI)
    {
        this.data.setSI(index, valueSI);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:needbraces", "checkstyle:designforextension"})
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleVector<?> other = (DoubleVector<?>) obj;
        if (this.data == null)
        {
            if (other.data != null)
                return false;
        }
        else if (!this.data.equals(other.data))
            return false;
        return true;
    }

    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Abs.Dense&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Abs.Dense&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Abs.Dense&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Abs<U> interpolate(final DoubleVector.Abs.Dense<U> zero,
    // final DoubleVector.Abs.Dense<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Abs<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Rel.Dense&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Rel.Dense&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Rel.Dense&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Rel<U> interpolate(final DoubleVector.Rel.Dense<U> zero,
    // final DoubleVector.Rel.Dense<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Rel<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Abs.Sparse&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Abs.Sparse&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Abs.Sparse&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Abs<U> interpolate(final DoubleVector.Abs.Sparse<U> zero,
    // final DoubleVector.Abs.Sparse<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Abs<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Rel.Sparse&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Rel.Sparse&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Rel.Sparse&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Rel<U> interpolate(final DoubleVector.Rel.Sparse<U> zero,
    // final DoubleVector.Rel.Sparse<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Rel<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }

}
