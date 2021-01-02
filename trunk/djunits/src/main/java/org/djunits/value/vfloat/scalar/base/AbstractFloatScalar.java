package org.djunits.value.vfloat.scalar.base;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.AbstractScalar;
import org.djunits.value.formatter.Format;
import org.djunits.value.util.ValueUtil;

/**
 * The most basic abstract class for the FloatScalar.
 * <p>
 * Copyright (c) 2013-2021 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <S> the type
 */
public abstract class AbstractFloatScalar<U extends Unit<U>, S extends AbstractFloatScalar<U, S>> extends AbstractScalar<U, S>
        implements FloatScalarInterface<U, S>
{
    /** */
    private static final long serialVersionUID = 20161015L;

    /** The value, stored in the standard SI unit. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final float si;

    /**
     * Construct a new AbstractFloatScalar.
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
        return (float) ValueUtil.expressAsUnit(getSI(), getDisplayUnit());
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
    public final int compareTo(final S o)
    {
        return Float.compare(this.getSI(), o.getSI());
    }

    /** {@inheritDoc} */
    @Override
    public int intValue()
    {
        return (int) this.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public long longValue()
    {
        return (long) this.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public float floatValue()
    {
        return this.getSI();
    }

    /** {@inheritDoc} */
    @Override
    public double doubleValue()
    {
        return this.getSI();
    }

    /**********************************************************************************/
    /********************************* GENERIC METHODS ********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return toString(getDisplayUnit(), false, true);
    }

    /** {@inheritDoc} */
    @Override
    public String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /** {@inheritDoc} */
    @Override
    public String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getDisplayUnit(), verbose, withUnit);
    }

    /** {@inheritDoc} */
    @Override
    public String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
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
            buf.append(" "); // Insert one space as prescribed by SI writing conventions
            buf.append(displayUnit.getDefaultDisplayAbbreviation());
        }
        return buf.toString();
    }

    /** {@inheritDoc} */
    @Override
    public String toTextualString()
    {
        return toTextualString(getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    public String toTextualString(final U displayUnit)
    {
        float f = (float) ValueUtil.expressAsUnit(getSI(), displayUnit);
        return f + " " + displayUnit.getDefaultTextualAbbreviation();
    }

    /** {@inheritDoc} */
    @Override
    public String toDisplayString()
    {
        return toDisplayString(getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    public String toDisplayString(final U displayUnit)
    {
        float f = (float) ValueUtil.expressAsUnit(getSI(), displayUnit);
        return f + " " + displayUnit.getDefaultDisplayAbbreviation();
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = getDisplayUnit().getStandardUnit().hashCode();
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
        if (!getDisplayUnit().getStandardUnit().equals(other.getDisplayUnit().getStandardUnit()))
            return false;
        if (Float.floatToIntBits(this.getSI()) != Float.floatToIntBits(other.getSI()))
            return false;
        return true;
    }

}
