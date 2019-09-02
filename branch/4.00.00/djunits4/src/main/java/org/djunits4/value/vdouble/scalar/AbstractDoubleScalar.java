package org.djunits4.value.vdouble.scalar;

import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.Scalar;
import org.djunits4.value.ValueUtil;
import org.djunits4.value.formatter.Format;

/**
 * The most basic abstract class for the DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 15, 2016 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <T> the type
 */
public abstract class AbstractDoubleScalar<U extends Unit<U>, T extends AbstractDoubleScalar<U, T>> extends Scalar<U>
        implements DoubleScalarInterface, Comparable<T>
{
    /** */
    private static final long serialVersionUID = 20161015L;

    /** The value, stored in the standard SI unit. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final double si;

    /**
     * Construct a new AbstractDoubleScalar;
     * @param unit U; the unit
     * @param si double; the si value to store
     */
    AbstractDoubleScalar(final U unit, final double si)
    {
        super(unit);
        this.si = si;
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI()
    {
        return this.si;
    }

    /**
     * Test if this DoubleScalar is less than another DoubleScalar.
     * @param o T, a relative typed DoubleScalar; the right hand side operand of the comparison
     * @return boolean; true if this is less than other; false if this is not less than other
     */
    public final boolean lt(final T o)
    {
        return this.getSI() < o.getSI();
    }

    /**
     * Test if this DoubleScalar is less than or equal to another DoubleScalar.
     * @param o T, a relative typed DoubleScalar; the right hand side operand of the comparison
     * @return boolean
     */
    public final boolean le(final T o)
    {
        return this.getSI() <= o.getSI();
    }

    /**
     * Test if this DoubleScalar is greater than or equal to a DoubleScalar.
     * @param o T, a relative typed DoubleScalar; the right hand side operand of the comparison
     * @return boolean; true if this is greater than or equal to other; false if this is not greater than or equal to other
     */
    public final boolean gt(final T o)
    {
        return this.getSI() > o.getSI();
    }

    /**
     * Test if this DoubleScalar is greater than a DoubleScalar.
     * @param o T, a relative typed DoubleScalar; the right hand side operand of the comparison
     * @return boolean; true if this is greater than other; false if this is not greater than other
     */
    public final boolean ge(final T o)
    {
        return this.getSI() >= o.getSI();
    }

    /**
     * Test if this DoubleScalar is equal to a DoubleScalar.
     * @param o T, a relative typed DoubleScalar; the right hand side operand of the comparison
     * @return boolean; true if this is equal to other; false if this is not equal to other
     */
    public final boolean eq(final T o)
    {
        return this.getSI() == o.getSI();
    }

    /**
     * Test if this DoubleScalar is not equal to a DoubleScalar.
     * @param o T, a relative typed DoubleScalar; the right hand side operand of the comparison
     * @return boolean; true if this is not equal to other; false if this is equal to other
     */
    public final boolean ne(final T o)
    {
        return this.getSI() != o.getSI();
    }

    /**
     * Test if this DoubleScalar is less than 0.0.
     * @return boolean; true if this is less than 0.0; false if this is not less than 0.0
     */
    public final boolean lt0()
    {
        return this.getSI() < 0.0;
    }

    /**
     * Test if this DoubleScalar is less than or equal to 0.0.
     * @return boolean; true if this is less than or equal to 0.0; false if this is not less than or equal to 0.0
     */
    public final boolean le0()
    {
        return this.getSI() <= 0.0;
    }

    /**
     * Test if this DoubleScalar is greater than or equal to 0.0.
     * @return boolean; true if this is greater than or equal to 0.0; false if this is not greater than or equal to 0.0
     */
    public final boolean gt0()
    {
        return this.getSI() >= 0.0;
    }

    /**
     * Test if this DoubleScalar is greater than 0.0.
     * @return boolean; true if this is greater than 0.0; false if this is not greater than 0.0
     */
    public final boolean ge0()
    {
        return this.getSI() > 0.0;
    }

    /**
     * Test if this DoubleScalar is equal to 0.0.
     * @return boolean; true if this is equal to 0.0; false if this is not equal to 0.0
     */
    public final boolean eq0()
    {
        return this.getSI() == 0.0;
    }

    /**
     * Test if this DoubleScalar is not equal to 0.0.
     * @return boolean; true if this is not equal to 0.0; false if this is equal to 0.0
     */
    public final boolean ne0()
    {
        return this.getSI() != 0.0;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public final int compareTo(final T o)
    {
        return Double.compare(this.getSI(), o.getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit()
    {
        return expressAsSpecifiedUnit(getSI());
    }

    /**
     * Retrieve the value converted into some specified unit.
     * @param targetUnit U; the unit to convert the value into
     * @return double
     */
    public final double getInUnit(final U targetUnit)
    {
        return ValueUtil.expressAsUnit(getSI(), targetUnit);
    }

    /**********************************************************************************/
    /********************************* NUMBER METHODS *********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final int intValue()
    {
        return (int) Math.round(getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final long longValue()
    {
        return Math.round(getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final float floatValue()
    {
        return (float) getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final double doubleValue()
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
     * Print this DoubleScalar with the value expressed in the specified unit.
     * @param displayUnit U; the unit into which the value is converted for display
     * @return String; printable string with the scalar contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this DoubleScalar with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the scalar contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this DoubleScalar with the value expressed in the specified unit.
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
        double d = ValueUtil.expressAsUnit(getSI(), displayUnit);
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
        temp = Double.doubleToLongBits(this.getSI());
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
        AbstractDoubleScalar<U, T> other = (AbstractDoubleScalar<U, T>) obj;
        if (!getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
            return false;
        if (Double.doubleToLongBits(this.getSI()) != Double.doubleToLongBits(other.getSI()))
            return false;
        return true;
    }

}
