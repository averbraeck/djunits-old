package org.djunits4.value.vfloat.vector;

import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.AbstractValue;
import org.djunits4.value.IsMutable;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.formatter.Format;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalar;

/**
 * The most basic abstract class for the FloatVector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <T> the type
 */
public abstract class AbstractFloatVector<U extends Unit<U>, T extends AbstractFloatVector<U, T>> extends AbstractValue<U>
        implements FloatVectorInterface<U>
{
    /** */
    private static final long serialVersionUID = 20151015L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected FloatVectorData data;

    /**
     * Construct a new FloatVector.
     * @param unit U; the unit
     * @param data FloatVectorData; an internal data object
     */
    AbstractFloatVector(final U unit, final FloatVectorData data)
    {
        super(unit);
        this.data = data;
    }

    /**
     * Retrieve the data.
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final FloatVectorData getData()
    {
        return this.data;
    }

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Vector.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Vector
     */
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
    }

    /**
     * Retrieve a value from the vector.
     * @param index int; the index to retrieve the value at
     * @return the value as a FloatScalar
     * @throws ValueRuntimeException in case index is out of bounds
     */
    public abstract AbstractFloatScalar<U, ?> get(int index) throws ValueRuntimeException;

    /** {@inheritDoc} */
    @Override
    public final float[] getValuesSI()
    {
        return this.data.getDenseVectorSI();
    }

    /** {@inheritDoc} */
    @Override
    public final float[] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /** {@inheritDoc} */
    @Override
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
     * @throws ValueRuntimeException when index is invalid
     */
    protected final void checkIndex(final int index) throws ValueRuntimeException
    {
        if (index < 0 || index >= size())
        {
            throw new ValueRuntimeException("index out of range (valid range is 0.." + (size() - 1) + ", got " + index + ")");
        }
    }

    /** {@inheritDoc} */
    @Override
    public final float getSI(final int index) throws ValueRuntimeException
    {
        checkIndex(index);
        return this.data.getSI(index);
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int index) throws ValueRuntimeException
    {
        return (float) expressAsSpecifiedUnit(getSI(index));
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int index, final U targetUnit) throws ValueRuntimeException
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

    /** {@inheritDoc} */
    @Override
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            String ar = this instanceof Absolute ? "Abs " : "Rel ";
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
            if (this instanceof IsMutable)
            {
                buf.append("Mutable   " + ar + ds);
            }
            else
            {
                buf.append("Immutable " + ar + ds);
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
            catch (ValueRuntimeException ve)
            {
                buf.append(" " + "********************".substring(0, Format.DEFAULTSIZE));
            }
        }
        buf.append("]");
        if (withUnit)
        {
            buf.append(" " + displayUnit.getDefaultDisplayAbbreviation());
        }
        return buf.toString();
    }

    /**
     * Centralized size equality check.
     * @param other AbstractFloatVector&lt;U, ?&gt;; other FloatVector
     * @throws ValueRuntimeException when other is null, or vectors have unequal size
     */
    protected final void checkSize(final AbstractFloatVector<U, ?> other) throws ValueRuntimeException
    {
        if (null == other)
        {
            throw new ValueRuntimeException("other is null");
        }
        if (size() != other.size())
        {
            throw new ValueRuntimeException("The vectors have different sizes: " + size() + " != " + other.size());
        }
    }

    /**
     * Centralized size equality check.
     * @param other float[]; array of float
     * @throws ValueRuntimeException when vectors have unequal size
     */
    protected final void checkSize(final float[] other) throws ValueRuntimeException
    {
        if (size() != other.length)
        {
            throw new ValueRuntimeException("The vector and the array have different sizes: " + size() + " != " + other.length);
        }
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = getUnit().getStandardUnit().hashCode();
        result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "checkstyle:needbraces", "unchecked"})
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractFloatVector<U, T> other = (AbstractFloatVector<U, T>) obj;
        if (!getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
            return false;
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
