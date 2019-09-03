package org.djunits4.value.vfloat.scalar;

import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.Scalar;
import org.djunits4.value.ValueUtil;
import org.djunits4.value.formatter.Format;

/**
 * The most basic abstract class for the FloatScalar.
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
public class AbstractFloatScalar<U extends Unit<U>, T extends AbstractFloatScalar<U, T>> extends Scalar<U>
        implements FloatScalarInterface, Comparable<T>
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

    /**
     * Test if this Relative FloatScalar is less than another Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean; true if this is less than other; false if this is not less than other
     */
    public final boolean lt(final T o)
    {
        return this.getSI() < o.getSI();
    }

    /**
     * Test if this Relative FloatScalar is less than or equal to another Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean le(final T o)
    {
        return this.getSI() <= o.getSI();
    }

    /**
     * Test if this Relative FloatScalar is greater than or equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean; true if this is greater than or equal to other; false if this is not greater than or equal to other
     */
    public final boolean gt(final T o)
    {
        return this.getSI() > o.getSI();
    }

    /**
     * Test if this Relative FloatScalar is greater than a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean; true if this is greater than other; false if this is not greater than other
     */
    public final boolean ge(final T o)
    {
        return this.getSI() >= o.getSI();
    }

    /**
     * Test if this Relative FloatScalar is equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean; true if this is equal to other; false if this is not equal to other
     */
    public final boolean eq(final T o)
    {
        return this.getSI() == o.getSI();
    }

    /**
     * Test if this Relative FloatScalar is not equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean; true if this is not equal to other; false if this is equal to other
     */
    public final boolean ne(final T o)
    {
        return this.getSI() != o.getSI();
    }

    /**
     * Test if this Relative FloatScalar is less than 0.0.
     * @return boolean; true if this is less than 0.0; false if this is not less than 0.0
     */
    public final boolean lt0()
    {
        return this.getSI() < 0.0f;
    }

    /**
     * Test if this Relative FloatScalar is less than or equal to 0.0.
     * @return boolean; true if this is less than or equal to 0.0; false if this is not less than or equal to 0.0
     */
    public final boolean le0()
    {
        return this.getSI() <= 0.0f;
    }

    /**
     * Test if this Relative FloatScalar is greater than or equal to 0.0.
     * @return boolean; true if this is greater than or equal to 0.0; false if this is not greater than or equal to 0.0
     */
    public final boolean gt0()
    {
        return this.getSI() > 0.0f;
    }

    /**
     * Test if this Relative FloatScalar is greater than 0.0.
     * @return boolean; true if this is greater than 0.0; false if this is not greater than 0.0
     */
    public final boolean ge0()
    {
        return this.getSI() >= 0.0f;
    }

    /**
     * Test if this Relative FloatScalar is equal to 0.0.
     * @return boolean; true if this is equal to 0.0; false if this is not equal to 0.0
     */
    public final boolean eq0()
    {
        return this.getSI() == 0.0f;
    }

    /**
     * Test if this Relative FloatScalar is not equal to 0.0.
     * @return boolean; true if this is not equal to 0.0; false if this is equal to 0.0
     */
    public final boolean ne0()
    {
        return this.getSI() != 0.0f;
    }

    /** {@inheritDoc} */
    @Override
    public final int compareTo(final T o)
    {
        return Float.compare(this.getSI(), o.getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit()
    {
        return (float) expressAsSpecifiedUnit(getSI());
    }

    /**
     * Retrieve the value converted into some specified unit.
     * @param targetUnit U; the unit to convert the value into
     * @return float; the value in the specified <code>targetUnit</code>
     */
    public final float getInUnit(final U targetUnit)
    {
        return (float) ValueUtil.expressAsUnit(getSI(), targetUnit);
    }

    /**********************************************************************************/
    /********************************* NUMBER METHODS *********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final int intValue()
    {
        return Math.round(getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final long longValue()
    {
        return Math.round(getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final double doubleValue()
    {
        return getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final float floatValue()
    {
        return getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final String toString()
    {
        return toString(getUnit(), false, true);
    }

    /**
     * Print this FloatScalar with the value expressed in the specified unit.
     * @param displayUnit U; the unit into which the value is converted for display
     * @return String; printable string with the scalar contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this FloatScalar with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the scalar contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this FloatScalar with the value expressed in the specified unit.
     * @param displayUnit U; the unit into which the value is converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the scalar contents
     */
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
        result = prime * result + Float.floatToIntBits(this.getSI());
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
        AbstractFloatScalar<U, T> other = (AbstractFloatScalar<U, T>) obj;
        if (!getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
            return false;
        if (Float.floatToIntBits(this.getSI()) != Float.floatToIntBits(other.getSI()))
            return false;
        return true;
    }

}
