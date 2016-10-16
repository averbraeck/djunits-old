package org.djunits.value.vfloat.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.Scalar;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;

/**
 * The most basic abstract class for the FloatScalar.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 16, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
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
     * @param unit the unit
     * @param si the si value to store
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
     * Test if this Relative FloatScalar is less than a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean lt(final T o)
    {
        return this.si < o.si;
    }

    /**
     * Test if this Relative FloatScalar is less than or equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean le(final T o)
    {
        return this.si <= o.si;
    }

    /**
     * Test if this Relative FloatScalar is greater than or equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean gt(final T o)
    {
        return this.si > o.si;
    }

    /**
     * Test if this Relative FloatScalar is greater than a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean ge(final T o)
    {
        return this.si >= o.si;
    }

    /**
     * Test if this Relative FloatScalar is equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean eq(final T o)
    {
        return this.si == o.si;
    }

    /**
     * Test if this Relative FloatScalar is not equal to a Relative FloatScalar.
     * @param o T, a relative typed FloatScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean ne(final T o)
    {
        return this.si != o.si;
    }

    /** {@inheritDoc} */
    @Override
    public final int compareTo(final T o)
    {
        return new Float(this.si).compareTo(o.si);
    }

    /**
     * Retrieve the value in the original unit.
     * @return float
     */
    public final float getInUnit()
    {
        return (float) expressAsSpecifiedUnit(getSI());
    }

    /**
     * Retrieve the value converted into some specified unit.
     * @param targetUnit U; the unit to convert the value into
     * @return float
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
            buf.append(displayUnit.getAbbreviation());
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
        result = prime * result + Float.floatToIntBits(this.si);
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
        if (Float.floatToIntBits(this.si) != Float.floatToIntBits(other.si))
            return false;
        return true;
    }

}
