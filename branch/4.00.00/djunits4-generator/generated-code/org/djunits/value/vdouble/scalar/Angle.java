package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.*;

/**
 * Easy access methods for the Relative Angle DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Angle extends AbstractDoubleScalarRel<AngleUnit, Angle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Angle ZERO = new Angle(0.0, AngleUnit.SI);

    /** constant with value zero. */
    public static final Angle ONE = new Angle(1.0, AngleUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Angle NaN = new Angle(Double.NaN, AngleUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Angle POSITIVE_INFINITY = new Angle(Double.POSITIVE_INFINITY, AngleUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Angle NEGATIVE_INFINITY = new Angle(Double.NEGATIVE_INFINITY, AngleUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Angle POS_MAXVALUE = new Angle(Double.MAX_VALUE, AngleUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Angle NEG_MAXVALUE = new Angle(-Double.MAX_VALUE, AngleUnit.SI);

    /**
     * Construct Angle scalar.
     * @param value double; double value
     * @param unit AngleUnit; unit for the double value
     */
    public Angle(final double value, final AngleUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Angle scalar.
     * @param value Angle; Scalar from which to construct this instance
     */
    public Angle(final Angle value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Angle instantiateRel(final double value, final AngleUnit unit)
    {
        return new Angle(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit DirectionUnit; the unit
     * @return Direction; a new absolute instance of the DoubleScalar of the right type
     */
    public final Direction instantiateAbs(final double value, final DirectionUnit unit)
    {
        return new Direction(value, unit);
    }

    /**
     * Construct Angle scalar.
     * @param value double; the double value in SI units
     * @return Angle; the new scalar with the SI value
     */
    public static final Angle createSI(final double value)
    {
        return new Angle(value, AngleUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Angle; the low value
     * @param one Angle; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return Angle; a Scalar at the ratio between
     */
    public static Angle interpolate(final Angle zero, final Angle one, final double ratio)
    {
        return new Angle(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v %TypAbs%; the value to add
     * @return Direction; sum of this value and v as a new object
     */
    public final Direction plus(final Direction v)
    {
        DirectionUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @return Angle; the maximum value of two relative scalars
     */
    public static Angle max(final Angle r1, final Angle r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @param rn Angle...; the other scalars
     * @return Angle; the maximum value of more than two relative scalars
     */
    public static Angle max(final Angle r1, final Angle r2, final Angle... rn)
    {
        Angle maxr = (r1.gt(r2)) ? r1 : r2;
        for (Angle r : rn)
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
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @return Angle; the minimum value of two relative scalars
     */
    public static Angle min(final Angle r1, final Angle r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @param rn Angle...; the other scalars
     * @return Angle; the minimum value of more than two relative scalars
     */
    public static Angle min(final Angle r1, final Angle r2, final Angle... rn)
    {
        Angle minr = (r1.lt(r2)) ? r1 : r2;
        for (Angle r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }
    
    /**
     * Returns a Angle representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a Angle
     * @return Angle; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static Angle valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing Angle: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing Angle: empty unitString");
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                AngleUnit unit = AngleUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        double d = Double.parseDouble(valueString);
                        return new Angle(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Angle from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Angle from " + text);
    }

    /**
     * Returns a Angle based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return Angle; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static Angle of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing Angle: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing Angle: empty unitString");
        AngleUnit unit = AngleUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new Angle(value, unit);
        }
        throw new IllegalArgumentException("Error parsing Angle with unit " + unitString);
    }

        /**
         * Calculate the division of Angle and Angle, which results in a Dimensionless scalar.
         * @param v Angle scalar
         * @return Dimensionless scalar as a division of Angle and Angle
         */
        public final Dimensionless divideBy(final Angle v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }


    
}
