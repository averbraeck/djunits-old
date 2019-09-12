package org.djunits4.value.vfloat.scalar.base;

import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.AbstractValue;
import org.djunits4.value.formatter.Format;
import org.djunits4.value.util.ValueUtil;

/**
 * The most basic abstract class for the FloatScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <S> the type
 */
public abstract class AbstractFloatScalar<U extends Unit<U>, S extends AbstractFloatScalar<U, S>> extends AbstractValue<U, S>
        implements FloatScalarInterface<U, S>
{
    /** */
    private static final long serialVersionUID = 20161015L;

    /** The value, stored in the standard SI unit. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final float si;

    /**
     * Construct a new AbstractFloatScalar;
     * @param unit U; the unit
     * @param si float; the si value to store
     */
    AbstractFloatScalar(final U unit, final float si)
    {
        super(unit);
        this.si = si;
    }

    /** {@inheritDoc} */
    @Override
    public final float getSI()
    {
        return this.si;
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit()
    {
        return (float) ValueUtil.expressAsUnit(getSI(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final U targetUnit)
    {
        return (float) ValueUtil.expressAsUnit(getSI(), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final boolean lt(final S o)
    {
        return this.getSI() < o.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final boolean le(final S o)
    {
        return this.getSI() <= o.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final boolean gt(final S o)
    {
        return this.getSI() > o.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final boolean ge(final S o)
    {
        return this.getSI() >= o.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final boolean eq(final S o)
    {
        return this.getSI() == o.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final boolean ne(final S o)
    {
        return this.getSI() != o.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final boolean lt0()
    {
        return this.getSI() < 0.0;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean le0()
    {
        return this.getSI() <= 0.0;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean gt0()
    {
        return this.getSI() > 0.0;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean ge0()
    {
        return this.getSI() >= 0.0;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean eq0()
    {
        return this.getSI() == 0.0;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean ne0()
    {
        return this.getSI() != 0.0;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public final int compareTo(final S o)
    {
        return Float.compare(this.getSI(), o.getSI());
    }

    /**********************************************************************************/
    /********************************* GENERIC METHODS ********************************/
    /**********************************************************************************/

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
            buf.append(this instanceof Absolute ? "Abs " : "Rel ");
        }
        float d = (float) ValueUtil.expressAsUnit(getSI(), displayUnit);
        buf.append(Format.format(d));
        if (withUnit)
        {
            buf.append(displayUnit.getDefaultDisplayAbbreviation());
        }
        return buf.toString();
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = getUnit().getStandardUnit().hashCode();
        long temp;
        temp = Float.floatToIntBits(this.getSI());
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        AbstractFloatScalar<U, S> other = (AbstractFloatScalar<U, S>) obj;
        if (!getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
            return false;
        if (Float.floatToIntBits(this.getSI()) != Float.floatToIntBits(other.getSI()))
            return false;
        return true;
    }

}
