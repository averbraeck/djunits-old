package org.djunits.value.vfloat.vector;

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
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Immutable FloatVector.
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
public abstract class FloatVector<U extends Unit<U>> extends AbstractValue<U> implements FloatVectorInterface<U>,
    Serializable
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected FloatVectorData data;

    /**
     * @return the internal data -- can only be used within package.
     */
    protected abstract FloatVectorData getData();

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param unit U; the unit of the new Absolute Immutable FloatVector
     */
    protected FloatVector(final U unit)
    {
        super(unit);
    }

    /** ============================================================================================ */
    /** ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /** ============================================================================================ */

    /**
     * @param <U> Unit the unit for which this Vector will be created
     */
    public abstract static class Abs<U extends Unit<U>> extends FloatVector<U> implements Absolute,
        FunctionsAbs<U, FloatVector.Abs<U>, FloatVector.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param unit U; the unit of the new Absolute Immutable FloatVector
         */
        protected Abs(final U unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatVector.Abs<U> mutable();

        /** {@inheritDoc} */
        public abstract FloatVector.Abs<U> toDense();

        /** {@inheritDoc} */
        public abstract FloatVector.Abs<U> toSparse();


        /**
         * ABSOLUTE DENSE implementation of FloatVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Dense<U extends Unit<U>> extends Abs<U> implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @param unit U; the unit of the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final U unit) throws ValueException
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
            public Dense(final List<Float> values, final U unit) throws ValueException
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
            public Dense(final FloatScalar.Abs<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param values List; the values of the entries in the new Absolute Dense Immutable FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Abs<U>> values) throws ValueException
            {
                super(checkNonEmptyLA(values).get(0).getUnit());
                this.data = initializeDenseLA(values);
            }

            /**
             * Construct a new Absolute Dense Immutable FloatVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final FloatVectorDataDense data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final MutableFloatVector.Abs<U> mutable()
            {
                return new MutableFloatVector.Abs.Dense<U>(getData(), getUnit());
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
            public FloatVector.Abs<U> toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatVector.Abs<U> toSparse()
            {
                return new FloatVector.Abs.Sparse<U>(getData().toSparse(), getUnit());
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of FloatVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Sparse<U extends Unit<U>> extends Abs<U> implements SparseData
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
            public Sparse(final SortedMap<Integer, Float> values, final U unit, final int length)
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
            public Sparse(final SortedMap<Integer, FloatScalar.Abs<U>> values, final int length) throws ValueException
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
            public Sparse(final float[] values, final U unit) throws ValueException
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
            public Sparse(final FloatScalar.Abs<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Absolute Sparse Immutable FloatVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
             */
            Sparse(final FloatVectorDataSparse data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatVector.Abs<U> mutable()
            {
                return new MutableFloatVector.Abs.Sparse<U>(getData(), getUnit());
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
            public FloatVector.Abs<U> toDense()
            {
                return new FloatVector.Abs.Dense<U>(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatVector.Abs<U> toSparse()
            {
                return this;
            }
        }

        /** ================================= ABS GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatScalar.Abs<U> get(final int index) throws ValueException
        {
            return new FloatScalar.Abs<U>(getInUnit(index, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Abs<U> plus(final FloatVector.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Abs<U> minus(final FloatVector.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Rel<U> minus(final FloatVector.Abs<U> abs) throws ValueException
        {
            return instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }
    }

    /** ============================================================================================ */
    /** ================================= RELATIVE IMPLEMENTATION ================================== */
    /** ============================================================================================ */

    /**
     * @param <U> Unit the unit for which this Vector will be created
     */
    public abstract static class Rel<U extends Unit<U>> extends FloatVector<U> implements Relative,
        FunctionsRel<U, FloatVector.Abs<U>, FloatVector.Rel<U>>

    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param unit U; the unit of the new Relative Immutable FloatVector
         */
        protected Rel(final U unit)
        {
            super(unit);
        }

        /** {@inheritDoc} */
        @Override
        public abstract MutableFloatVector.Rel<U> mutable();

        /** {@inheritDoc} */
        public abstract FloatVector.Rel<U> toDense();

        /** {@inheritDoc} */
        public abstract FloatVector.Rel<U> toSparse();

        /**
         * RELATIVE DENSE implementation of FloatVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Dense<U extends Unit<U>> extends Rel<U> implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Relative Dense Immutable FloatVector
             * @param unit U; the unit of the new Relative Dense Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Dense(final float[] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param values List; the values of the entries in the new Relative Dense Immutable FloatVector
             * @param unit U; the unit of the new Relative Dense Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Dense(final List<Float> values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Dense Immutable
             *            FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final FloatScalar.Rel<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param values List; the values of the entries in the new Relative Dense Immutable FloatVector
             * @throws ValueException when values has zero entries
             */
            public Dense(final List<FloatScalar.Rel<U>> values) throws ValueException
            {
                super(checkNonEmptyLR(values).get(0).getUnit());
                this.data = initializeDenseLR(values);
            }

            /**
             * Construct a new Relative Dense Immutable FloatVector.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final FloatVectorDataDense data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatVector.Rel<U> mutable()
            {
                return new MutableFloatVector.Rel.Dense<U>(getData(), getUnit());
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
            public FloatVector.Rel<U> toDense()
            {
                return this;
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatVector.Rel<U> toSparse()
            {
                return new FloatVector.Rel.Sparse<U>(getData().toSparse(), getUnit());
            }
        }

        /**
         * RELATIVE SPARSE implementation of FloatVector.
         * @param <U> Unit the unit for which this Vector will be created
         */
        public static class Sparse<U extends Unit<U>> extends Rel<U> implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20150626L;

            /**
             * Construct a new Relative Sparse Immutable FloatVector.
             * @param values Map; the map of indexes to values of the Relative Sparse Immutable FloatVector
             * @param unit U; the unit of the new Relative Sparse Immutable FloatVector
             * @param length the size of the vector
             * @throws ValueException when values is null
             */
            public Sparse(final SortedMap<Integer, Float> values, final U unit, final int length)
                throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values, length);
            }

            /**
             * Construct a new Relative Sparse Immutable FloatVector.
             * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            FloatVector
             * @param length the size of the vector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final SortedMap<Integer, FloatScalar.Rel<U>> values, final int length) throws ValueException
            {
                super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
                this.data = initializeSparseMR(values, length);
            }

            /**
             * Construct a new Relative Sparse Immutable FloatVector.
             * @param values float[]; the values of the entries in the new Relative Sparse Immutable FloatVector
             * @param unit U; the unit of the new Relative Sparse Immutable FloatVector
             * @throws ValueException when values is null
             */
            public Sparse(final float[] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable FloatVector.
             * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
             *            FloatVector
             * @throws ValueException when values has zero entries
             */
            public Sparse(final FloatScalar.Rel<U>[] values) throws ValueException
            {
                super(checkNonEmpty(values)[0].getUnit());
                this.data = initializeDense(values).toSparse();
            }

            /**
             * Construct a new Relative Sparse Immutable FloatVector, package method.
             * @param data the sparse data (internal structure)
             * @param unit U; the unit of the new Absolute Sparse Immutable FloatVector
             */
            Sparse(final FloatVectorDataSparse data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public MutableFloatVector.Rel<U> mutable()
            {
                return new MutableFloatVector.Rel.Sparse<U>(getData(), getUnit());
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
            public FloatVector.Rel<U> toDense()
            {
                return new FloatVector.Rel.Dense<U>(getData().toDense(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            @SuppressWarnings("designforextension")
            public FloatVector.Rel<U> toSparse()
            {
                return this;
            }
        }

        /** ================================= REL GENERAL METHODS ================================== */

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatScalar.Rel<U> get(final int index) throws ValueException
        {
            return new FloatScalar.Rel<U>(getInUnit(index, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Rel<U> plus(final FloatVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Abs<U> plus(final FloatVector.Abs<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final FloatVector.Rel<U> minus(final FloatVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final FloatVector.Rel<U> times(final FloatVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final FloatVector.Rel<U> divide(final FloatVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }
    }

    /** ============================================================================================ */
    /** ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /** ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatVector.
     * @param dsArray FloatScalar&lt;U&gt;[]; the provided array
     * @param <U> Unit; the unit of the FloatScalar array
     * @return FloatScalar&lt;U&gt;[]; the provided array
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>> FloatScalar.Abs<U>[] checkNonEmpty(final FloatScalar.Abs<U>[] dsArray)
        throws ValueException
    {
        if (0 == dsArray.length)
        {
            throw new ValueException(
                "Cannot create a FloatVector or MutableFloatVector from an empty array of FloatScalar");
        }
        return dsArray;
    }

    /**
     * Check that a provided List can be used to create some descendant of a FloatVector.
     * @param dsList the provided list
     * @param <U> Unit; the unit of the FloatScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> List<FloatScalar.Abs<U>> checkNonEmptyLA(final List<FloatScalar.Abs<U>> dsList)
        throws ValueException
    {
        if (0 == dsList.size())
        {
            throw new ValueException(
                "Cannot create a FloatVector or MutableFloatVector from an empty List of FloatScalar");
        }
        return dsList;
    }

    /**
     * Check that a provided Map can be used to create some descendant of a FloatVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the FloatScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> SortedMap<Integer, FloatScalar.Abs<U>> checkNonEmptyMA(
        final SortedMap<Integer, FloatScalar.Abs<U>> dsMap) throws ValueException
    {
        if (0 == dsMap.size())
        {
            throw new ValueException(
                "Cannot create a FloatVector or MutableFloatVector from an empty List of FloatScalar");
        }
        return dsMap;
    }

    /**
     * Check that a provided array can be used to create some descendant of a FloatVector.
     * @param dsArray FloatScalar&lt;U&gt;[]; the provided array
     * @param <U> Unit; the unit of the FloatScalar array
     * @return FloatScalar&lt;U&gt;[]; the provided array
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>> FloatScalar.Rel<U>[] checkNonEmpty(final FloatScalar.Rel<U>[] dsArray)
        throws ValueException
    {
        if (0 == dsArray.length)
        {
            throw new ValueException(
                "Cannot create a FloatVector or MutableFloatVector from an empty array of FloatScalar");
        }
        return dsArray;
    }

    /**
     * Check that a provided List can be used to create some descendant of a FloatVector.
     * @param dsList the provided list
     * @param <U> Unit; the unit of the FloatScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> List<FloatScalar.Rel<U>> checkNonEmptyLR(final List<FloatScalar.Rel<U>> dsList)
        throws ValueException
    {
        if (0 == dsList.size())
        {
            throw new ValueException(
                "Cannot create a FloatVector or MutableFloatVector from an empty List of FloatScalar");
        }
        return dsList;
    }

    /**
     * Check that a provided Map can be used to create some descendant of a FloatVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the FloatScalar list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>> SortedMap<Integer, FloatScalar.Rel<U>> checkNonEmptyMR(
        final SortedMap<Integer, FloatScalar.Rel<U>> dsMap) throws ValueException
    {
        if (0 == dsMap.size())
        {
            throw new ValueException(
                "Cannot create a FloatVector or MutableFloatVector from an empty List of FloatScalar");
        }
        return dsMap;
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final FloatVectorDataDense initializeDense(final float[] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        float[] vectorSI = new float[values.length];
        if (getUnit().equals(getUnit().getStandardUnit()))
        {
            System.arraycopy(values, 0, vectorSI, 0, values.length);
        }
        else
        {
            // TODO optimize for linear scale: multiply by factor
            for (int index = values.length; --index >= 0;)
            {
                vectorSI[index] = (float) expressAsSIUnit(values[index]);
            }
        }
        return new FloatVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final FloatVectorDataDense initializeDense(final List<Float> values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        float[] vectorSI = new float[values.size()];
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
                vectorSI[index] = (float) expressAsSIUnit(values.get(index));
            }
        }
        return new FloatVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final FloatVectorDataDense initializeDense(final FloatScalar<U>[] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        float[] vectorSI = new float[values.length];
        for (int index = 0; index < values.length; index++)
        {
            vectorSI[index] = values[index].getSI();
        }
        return new FloatVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final FloatVectorDataDense initializeDenseLA(final List<FloatScalar.Abs<U>> values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        float[] vectorSI = new float[values.size()];
        for (int index = 0; index < values.size(); index++)
        {
            vectorSI[index] = values.get(index).getSI();
        }
        return new FloatVectorDataDense(vectorSI);
    }

    /**
     * Initialize a dense vector.
     * @param values the values to store in the vector
     * @return the dense vector
     * @throws ValueException when no values are present
     */
    final FloatVectorDataDense initializeDenseLR(final List<FloatScalar.Rel<U>> values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("values is null");
        }
        float[] vectorSI = new float[values.size()];
        for (int index = 0; index < values.size(); index++)
        {
            vectorSI[index] = values.get(index).getSI();
        }
        return new FloatVectorDataDense(vectorSI);
    }

    /**
     * Import the values from a sparse map of integers and values.
     * @param values Map&lt;Integer, Float&gt;; the values
     * @param length the size of the vector
     * @return the sparse vector
     */
    protected final FloatVectorDataSparse initializeSparse(final SortedMap<Integer, Float> values, final int length)
    {
        boolean isSI = getUnit().equals(getUnit().getStandardUnit());
        float[] vectorSI = new float[values.size()];
        int[] indices = new int[values.size()];
        int index = 0;
        for (Entry<Integer, Float> entry : values.entrySet())
        {
            vectorSI[index] = isSI ? entry.getValue() : (float) expressAsSIUnit(entry.getValue());
            indices[index] = entry.getKey();
            index++;
        }
        return new FloatVectorDataSparse(vectorSI, indices, length);
    }

    /**
     * Import the values from a sparse map of integers and values.
     * @param values Map&lt;Integer, Float&gt;; the values
     * @param length the size of the vector
     * @return the sparse vector
     */
    protected final FloatVectorDataSparse initializeSparseMA(final SortedMap<Integer, FloatScalar.Abs<U>> values,
        final int length)
    {
        boolean isSI = getUnit().equals(getUnit().getStandardUnit());
        float[] vectorSI = new float[values.size()];
        int[] indices = new int[values.size()];
        int index = 0;
        for (Entry<Integer, FloatScalar.Abs<U>> entry : values.entrySet())
        {
            vectorSI[index] = isSI ? entry.getValue().si : (float) expressAsSIUnit(entry.getValue().si);
            indices[index] = entry.getKey();
            index++;
        }
        return new FloatVectorDataSparse(vectorSI, indices, length);
    }

    /**
     * Import the values from a sparse map of integers and values.
     * @param values Map&lt;Integer, Float&gt;; the values
     * @param length the size of the vector
     * @return the sparse vector
     */
    protected final FloatVectorDataSparse initializeSparseMR(final SortedMap<Integer, FloatScalar.Rel<U>> values,
        final int length)
    {
        boolean isSI = getUnit().equals(getUnit().getStandardUnit());
        float[] vectorSI = new float[values.size()];
        int[] indices = new int[values.size()];
        int index = 0;
        for (Entry<Integer, FloatScalar.Rel<U>> entry : values.entrySet())
        {
            vectorSI[index] = isSI ? entry.getValue().si : (float) expressAsSIUnit(entry.getValue().si);
            indices[index] = entry.getKey();
            index++;
        }
        return new FloatVectorDataSparse(vectorSI, indices, length);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the FloatVectorData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> FloatVector.Rel<U> instantiateRel(final FloatVectorData dvData, final U unit)
    {
        if (dvData instanceof FloatVectorDataSparse)
        {
            return new FloatVector.Rel.Sparse<U>((FloatVectorDataSparse) dvData, unit);
        }
        else
        {
            return new FloatVector.Rel.Dense<U>((FloatVectorDataDense) dvData, unit);
        }
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the FloatVectorData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> FloatVector.Abs<U> instantiateAbs(final FloatVectorData dvData, final U unit)
    {
        if (dvData instanceof FloatVectorDataSparse)
        {
            return new FloatVector.Abs.Sparse<U>((FloatVectorDataSparse) dvData, unit);
        }
        else
        {
            return new FloatVector.Abs.Dense<U>((FloatVectorDataDense) dvData, unit);
        }
    }

    /** ============================================================================================ */
    /** ================================== GENERIC VECTOR METHODS ================================== */
    /** ============================================================================================ */

    /**
     * Create a float[] array filled with the values in the standard SI unit.
     * @return float[]; array of values in the standard SI unit
     */
    public final float[] getValuesSI()
    {
        return this.data.getDenseVectorSI();
    }

    /**
     * Create a float[] array filled with the values in the original unit.
     * @return float[]; the values in the original unit
     */
    public final float[] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /**
     * Create a float[] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return float[]; the values converted into the specified unit
     */
    public final float[] getValuesInUnit(final U targetUnit)
    {
        float[] values = getValuesSI();
        for (int i = values.length; --i >= 0;)
        {
            values[i] = (float) ValueUtil.expressAsUnit(values[i], targetUnit);
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
    public final float getSI(final int index) throws ValueException
    {
        checkIndex(index);
        return this.data.getSI(index);
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int index) throws ValueException
    {
        return (float) expressAsSpecifiedUnit(getSI(index));
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int index, final U targetUnit) throws ValueException
    {
        return (float) ValueUtil.expressAsUnit(getSI(index), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final float zSum()
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
     * Print this FloatVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the vector contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this FloatVector with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this FloatVector with the values expressed in the specified unit.
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
            if (this instanceof MutableFloatVector)
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
            float f = (float) ValueUtil.expressAsUnit(safeGet(i), displayUnit);
            buf.append(" " + Format.format(f));
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
     * @param other FloatVector&lt;?&gt;; other FloatVector
     * @throws ValueException when other is null, or vectors have unequal size
     */
    protected final void checkSize(final FloatVector<?> other) throws ValueException
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
     * @param other float[]; array of float
     * @throws ValueException when vectors have unequal size
     */
    protected final void checkSize(final float[] other) throws ValueException
    {
        if (size() != other.length)
        {
            throw new ValueException("The vector and the array have different sizes: " + size() + " != " + other.length);
        }
    }

    /**
     * Retrieve a value in vectorSI without checking validity of the index.
     * @param index int; the index
     * @return float; the value stored at that index
     */
    protected final float safeGet(final int index)
    {
        return this.data.getSI(index);
    }

    /**
     * Modify a value in vectorSI without checking validity of the index.
     * @param index int; the index
     * @param valueSI float; the new value for the entry in vectorSI
     */
    protected final void safeSet(final int index, final float valueSI)
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
        FloatVector<?> other = (FloatVector<?>) obj;
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
    // * @param zero FloatVector.Abs.Dense&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one FloatVector.Abs.Dense&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableFloatVector.Abs.Dense&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableFloatVector.Abs<U> interpolate(final FloatVector.Abs.Dense<U> zero,
    // final FloatVector.Abs.Dense<U> one, final float ratio) throws ValueException
    // {
    // MutableFloatVector.Abs<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero FloatVector.Rel.Dense&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one FloatVector.Rel.Dense&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableFloatVector.Rel.Dense&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableFloatVector.Rel<U> interpolate(final FloatVector.Rel.Dense<U> zero,
    // final FloatVector.Rel.Dense<U> one, final float ratio) throws ValueException
    // {
    // MutableFloatVector.Rel<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero FloatVector.Abs.Sparse&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one FloatVector.Abs.Sparse&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableFloatVector.Abs.Sparse&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableFloatVector.Abs<U> interpolate(final FloatVector.Abs.Sparse<U> zero,
    // final FloatVector.Abs.Sparse<U> one, final float ratio) throws ValueException
    // {
    // MutableFloatVector.Abs<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero FloatVector.Rel.Sparse&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one FloatVector.Rel.Sparse&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableFloatVector.Rel.Sparse&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableFloatVector.Rel<U> interpolate(final FloatVector.Rel.Sparse<U> zero,
    // final FloatVector.Rel.Sparse<U> one, final float ratio) throws ValueException
    // {
    // MutableFloatVector.Rel<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }

}
