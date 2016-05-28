package org.djunits.value.vfloat.vector;

import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.AbstractValue;
import org.djunits.value.FunctionsAbs;
import org.djunits.value.FunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Immutable FloatVector.
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 30 Oct, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit the unit for which this Vector will be created
 */
public abstract class FloatVector<U extends Unit<U>> extends AbstractValue<U> implements FloatVectorInterface<U>, Serializable
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected FloatVectorData data;

    /**
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final FloatVectorData getData()
    {
        return this.data;
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param unit U; the unit of the new Absolute Immutable FloatVector
     */
    protected FloatVector(final U unit)
    {
        super(unit);
    }

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Vector.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Vector
     */
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
    }

    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatVector.
     * @param <U> Unit the unit for which this Vector will be created
     */
    public static class Abs<U extends Unit<U>> extends FloatVector<U> implements Absolute,
            FunctionsAbs<U, FloatVector.Abs<U>, FloatVector.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param values float[]; the values of the entries in the new Absolute Immutable FloatVector
         * @param unit U; the unit of the new Absolute Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = FloatVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatVector
         * @param unit U; the unit of the new Absolute Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = FloatVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatScalar.Abs<U>[] values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = FloatVectorData.instantiate(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends FloatScalar.Abs<U>> Abs(final List<S> values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = FloatVectorData.instantiateLD(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends FloatScalar.Abs<U>> Abs(final SortedMap<Integer, S> values, final int length,
                final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = FloatVectorData.instantiateMD(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(unit);
            this.data = FloatVectorData.instantiate(values, length, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final U unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @SuppressWarnings("checkstyle:designforextension")
        @Override
        public MutableFloatVector.Abs<U> mutable()
        {
            return MutableFloatVector.instantiateMutableAbs(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Abs<U> toDense()
        {
            return this.data.isDense() ? this : instantiateAbs(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Abs<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateAbs(this.data.toSparse(), getUnit());
        }

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

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatVector.
     * @param <U> Unit the unit for which this Vector will be created
     */
    public static class Rel<U extends Unit<U>> extends FloatVector<U> implements Relative,
            FunctionsRel<U, FloatVector.Abs<U>, FloatVector.Rel<U>>

    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values float[]; the values of the entries in the new Relative Immutable FloatVector
         * @param unit U; the unit of the new Relative Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = FloatVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatVector
         * @param unit U; the unit of the new Relative Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = FloatVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatScalar.Rel<U>[] values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = FloatVectorData.instantiate(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends FloatScalar.Rel<U>> Rel(final List<S> values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = FloatVectorData.instantiateLD(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends FloatScalar.Rel<U>> Rel(final SortedMap<Integer, S> values, final int length,
                final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = FloatVectorData.instantiateMD(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(unit);
            this.data = FloatVectorData.instantiate(values, length, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable FloatVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final U unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @SuppressWarnings("checkstyle:designforextension")
        @Override
        public MutableFloatVector.Rel<U> mutable()
        {
            return new MutableFloatVector.Rel<U>(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Rel<U> toDense()
        {
            return this.data.isDense() ? this : instantiateRel(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatVector.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateRel(this.data.toSparse(), getUnit());
        }

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
        public FloatVector.Abs<U> plus(final FloatVector.Abs<U> abs) throws ValueException
        {
            return instantiateAbs(this.getData().plus(abs.getData()), getUnit());
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

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsArray the array to check and get the unit for
     * @param <U> the unit
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>> U checkUnit(final FloatScalar<U>[] dsArray) throws ValueException
    {
        if (dsArray.length > 0)
        {
            return dsArray[0].getUnit();
        }
        throw new ValueException("Cannot create a FloatVector or MutableFloatVector from an empty array of FloatScalar");
    }

    /**
     * Check that a provided list can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsList the list to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar in the list
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends FloatScalar<U>> U checkUnit(final List<S> dsList) throws ValueException
    {
        if (dsList.size() > 0)
        {
            return dsList.get(0).getUnit();
        }
        throw new ValueException("Cannot create a FloatVector or MutableFloatVector from an empty list of FloatScalar");
    }

    /**
     * Check that a provided Map can be used to create some descendant of a FloatVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the FloatScalar list
     * @param <S> the scalar in the list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>, S extends FloatScalar<U>> U checkUnit(final SortedMap<Integer, S> dsMap) throws ValueException
    {
        if (dsMap.size() > 0)
        {
            return dsMap.get(dsMap.firstKey()).getUnit();
        }
        throw new ValueException("Cannot create a FloatVector or MutableFloatVector from an empty Map of FloatScalar");
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
        return new FloatVector.Rel<U>(dvData, unit);
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
        return new FloatVector.Abs<U>(dvData, unit);
    }

    /* ============================================================================================ */
    /* ================================== GENERIC VECTOR METHODS ================================== */
    /* ============================================================================================ */

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
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
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
            try
            {
                float d = (float) ValueUtil.expressAsUnit(getSI(i), displayUnit);
                buf.append(" " + Format.format(d));
            }
            catch (ValueException ve)
            {
                buf.append(" " + "********************".substring(0, Format.DEFAULTSIZE));
            }
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
    @SuppressWarnings({ "checkstyle:needbraces", "checkstyle:designforextension" })
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
}
