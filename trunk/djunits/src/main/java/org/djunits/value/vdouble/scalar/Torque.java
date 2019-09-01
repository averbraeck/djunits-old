package org.djunits.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Torque DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;TorqueUnit&gt; value = new DoubleScalar.Rel&lt;TorqueUnit&gt;(100.0, TorqueUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Torque value = new Torque(100.0, TorqueUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class Torque extends AbstractDoubleScalarRel<TorqueUnit, Torque>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Torque ZERO = new Torque(0.0, TorqueUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Torque NaN = new Torque(Double.NaN, TorqueUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Torque POSITIVE_INFINITY = new Torque(Double.POSITIVE_INFINITY, TorqueUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Torque NEGATIVE_INFINITY = new Torque(Double.NEGATIVE_INFINITY, TorqueUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Torque POS_MAXVALUE = new Torque(Double.MAX_VALUE, TorqueUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Torque NEG_MAXVALUE = new Torque(-Double.MAX_VALUE, TorqueUnit.SI);

    /**
     * Construct Torque scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Torque(final double value, final TorqueUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Torque scalar.
     * @param value Scalar from which to construct this instance
     */
    public Torque(final Torque value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Torque instantiateRel(final double value, final TorqueUnit unit)
    {
        return new Torque(value, unit);
    }

    /**
     * Construct Torque scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Torque createSI(final double value)
    {
        return new Torque(value, TorqueUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Torque interpolate(final Torque zero, final Torque one, final double ratio)
    {
        return new Torque(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Torque max(final Torque r1, final Torque r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Torque max(final Torque r1, final Torque r2, final Torque... rn)
    {
        Torque maxr = (r1.gt(r2)) ? r1 : r2;
        for (Torque r : rn)
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
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Torque min(final Torque r1, final Torque r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Torque min(final Torque r1, final Torque r2, final Torque... rn)
    {
        Torque minr = (r1.lt(r2)) ? r1 : r2;
        for (Torque r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Torque representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a Torque
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Torque valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Torque -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (TorqueUnit unit : Unit.getUnits(TorqueUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Torque(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Torque from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Torque from " + text);
    }

    /**
     * Calculate the division of Torque and Torque, which results in a Dimensionless scalar.
     * @param v Torque scalar
     * @return Dimensionless scalar as a division of Torque and Torque
     */
    public final Dimensionless divideBy(final Torque v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Torque and Force, which results in a Length scalar.
     * @param v Torque scalar
     * @return Length scalar as a division of Torque and Force
     */
    public final Length divideBy(final Force v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Torque and Length, which results in a Force scalar.
     * @param v Torque scalar
     * @return Force scalar as a division of Torque and Length
     */
    public final Force divideBy(final Length v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Torque and LinearDensity, which results in a Force scalar.
     * @param v Torque scalar
     * @return Force scalar as a multiplication of Torque and LinearDensity
     */
    public final Force multiplyBy(final LinearDensity v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Torque and Duration, which results in a Power scalar.
     * @param v Torque scalar
     * @return Power scalar as a division of Torque and Duration
     */
    public final Power divideBy(final Duration v)
    {
        return new Power(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Torque and Power, which results in a Duration scalar.
     * @param v Torque scalar
     * @return Duration scalar as a division of Torque and Power
     */
    public final Duration divideBy(final Power v)
    {
        return new Duration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of Torque and Frequency, which results in a Power scalar.
     * @param v Torque scalar
     * @return Power scalar as a multiplication of Torque and Frequency
     */
    public final Power multiplyBy(final Frequency v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Torque and Volume, which results in a Pressure scalar.
     * @param v Torque scalar
     * @return Pressure scalar as a division of Torque and Volume
     */
    public final Pressure divideBy(final Volume v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of Torque and Pressure, which results in a Volume scalar.
     * @param v Torque scalar
     * @return Volume scalar as a division of Torque and Pressure
     */
    public final Volume divideBy(final Pressure v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

}
