package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.FlowMassUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.FrequencyUnit;
import org.djunits4.unit.MassUnit;

/**
 * Easy access methods for the FlowMass DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FlowMass extends AbstractDoubleScalarRel<FlowMassUnit, FlowMass>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final FlowMass ZERO = new FlowMass(0.0, FlowMassUnit.SI);

    /** constant with value one. */
    public static final FlowMass ONE = new FlowMass(1.0, FlowMassUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FlowMass NaN = new FlowMass(Double.NaN, FlowMassUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FlowMass POSITIVE_INFINITY = new FlowMass(Double.POSITIVE_INFINITY, FlowMassUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FlowMass NEGATIVE_INFINITY = new FlowMass(Double.NEGATIVE_INFINITY, FlowMassUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FlowMass POS_MAXVALUE = new FlowMass(Double.MAX_VALUE, FlowMassUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FlowMass NEG_MAXVALUE = new FlowMass(-Double.MAX_VALUE, FlowMassUnit.SI);

    /**
     * Construct FlowMass scalar.
     * @param value double; the double value
     * @param unit FlowMassUnit; unit for the double value
     */
    public FlowMass(final double value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value FlowMass; Scalar from which to construct this instance
     */
    public FlowMass(final FlowMass value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass instantiateRel(final double value, final FlowMassUnit unit)
    {
        return new FlowMass(value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value double; the double value in SI units
     * @return FlowMass; the new scalar with the SI value
     */
    public static final FlowMass createSI(final double value)
    {
        return new FlowMass(value, FlowMassUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FlowMass; the low value
     * @param one FlowMass; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return FlowMass; a Scalar at the ratio between
     */
    public static FlowMass interpolate(final FlowMass zero, final FlowMass one, final double ratio)
    {
        return new FlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FlowMass; the first scalar
     * @param r2 FlowMass; the second scalar
     * @return FlowMass; the maximum value of two relative scalars
     */
    public static FlowMass max(final FlowMass r1, final FlowMass r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FlowMass; the first scalar
     * @param r2 FlowMass; the second scalar
     * @param rn FlowMass...; the other scalars
     * @return FlowMass; the maximum value of more than two relative scalars
     */
    public static FlowMass max(final FlowMass r1, final FlowMass r2, final FlowMass... rn)
    {
        FlowMass maxr = (r1.gt(r2)) ? r1 : r2;
        for (FlowMass r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 FlowMass; the first scalar
     * @param r2 FlowMass; the second scalar
     * @return FlowMass; the minimum value of two relative scalars
     */
    public static FlowMass min(final FlowMass r1, final FlowMass r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FlowMass; the first scalar
     * @param r2 FlowMass; the second scalar
     * @param rn FlowMass...; the other scalars
     * @return FlowMass; the minimum value of more than two relative scalars
     */
    public static FlowMass min(final FlowMass r1, final FlowMass r2, final FlowMass... rn)
    {
        FlowMass minr = (r1.lt(r2)) ? r1 : r2;
        for (FlowMass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FlowMass representation of a textual representation of a value with a unit. The String representation that can
     * be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a FlowMass
     * @return FlowMass; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static FlowMass valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing FlowMass: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing FlowMass: empty unitString");
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                FlowMassUnit unit = FlowMassUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        double d = Double.parseDouble(valueString);
                        return new FlowMass(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FlowMass from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FlowMass from " + text);
    }

    /**
     * Returns a FlowMass based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return FlowMass; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FlowMass of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing FlowMass: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FlowMass: empty unitString");
        FlowMassUnit unit = FlowMassUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new FlowMass(value, unit);
        }
        throw new IllegalArgumentException("Error parsing FlowMass with unit " + unitString);
    }

    /**
     * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
     * @param v FlowMass scalar
     * @return Dimensionless scalar as a division of FlowMass and FlowMass
     */
    public final Dimensionless divideBy(final FlowMass v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Duration, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a multiplication of FlowMass and Duration
     */
    public final Mass multiplyBy(final Duration v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a division of FlowMass and Frequency
     */
    public final Mass divideBy(final Frequency v)
    {
        return new Mass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
     * @param v FlowMass scalar
     * @return Frequency scalar as a division of FlowMass and Mass
     */
    public final Frequency divideBy(final Mass v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
     * @param v FlowMass scalar
     * @return Force scalar as a multiplication of FlowMass and Speed
     */
    public final Force multiplyBy(final Speed v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}