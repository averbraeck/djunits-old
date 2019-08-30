package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PowerUnit;
import org.djunits4.unit.PressureUnit;

/**
 * Easy access methods for the Energy DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;EnergyUnit&gt; value = new DoubleScalar.Rel&lt;EnergyUnit&gt;(100.0, EnergyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Energy value = new Energy(100.0, EnergyUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Energy extends AbstractDoubleScalarRel<EnergyUnit, Energy>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Energy ZERO = new Energy(0.0, EnergyUnit.SI);

    /** constant with value one. */
    public static final Energy ONE = new Energy(1.0, EnergyUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Energy NaN = new Energy(Double.NaN, EnergyUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Energy POSITIVE_INFINITY = new Energy(Double.POSITIVE_INFINITY, EnergyUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Energy NEGATIVE_INFINITY = new Energy(Double.NEGATIVE_INFINITY, EnergyUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Energy POS_MAXVALUE = new Energy(Double.MAX_VALUE, EnergyUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Energy NEG_MAXVALUE = new Energy(-Double.MAX_VALUE, EnergyUnit.SI);

    /**
     * Construct Energy scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Energy(final double value, final EnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Energy scalar.
     * @param value Scalar from which to construct this instance
     */
    public Energy(final Energy value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Energy instantiateRel(final double value, final EnergyUnit unit)
    {
        return new Energy(value, unit);
    }

    /**
     * Construct Energy scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Energy createSI(final double value)
    {
        return new Energy(value, EnergyUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Energy interpolate(final Energy zero, final Energy one, final double ratio)
    {
        return new Energy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Energy max(final Energy r1, final Energy r2)
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
    public static Energy max(final Energy r1, final Energy r2, final Energy... rn)
    {
        Energy maxr = (r1.gt(r2)) ? r1 : r2;
        for (Energy r : rn)
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
    public static Energy min(final Energy r1, final Energy r2)
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
    public static Energy min(final Energy r1, final Energy r2, final Energy... rn)
    {
        Energy minr = (r1.lt(r2)) ? r1 : r2;
        for (Energy r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Energy representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a Energy
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Energy valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Energy -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (EnergyUnit unit : EnergyUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Energy(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Energy from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Energy from " + text);
    }

    /**
     * Calculate the division of Energy and Energy, which results in a Dimensionless scalar.
     * @param v Energy scalar
     * @return Dimensionless scalar as a division of Energy and Energy
     */
    public final Dimensionless divideBy(final Energy v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Energy and Force, which results in a Length scalar.
     * @param v Energy scalar
     * @return Length scalar as a division of Energy and Force
     */
    public final Length divideBy(final Force v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Energy and Length, which results in a Force scalar.
     * @param v Energy scalar
     * @return Force scalar as a division of Energy and Length
     */
    public final Force divideBy(final Length v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and LinearDensity, which results in a Force scalar.
     * @param v Energy scalar
     * @return Force scalar as a multiplication of Energy and LinearDensity
     */
    public final Force multiplyBy(final LinearDensity v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Energy and Duration, which results in a Power scalar.
     * @param v Energy scalar
     * @return Power scalar as a division of Energy and Duration
     */
    public final Power divideBy(final Duration v)
    {
        return new Power(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Energy and Power, which results in a Duration scalar.
     * @param v Energy scalar
     * @return Duration scalar as a division of Energy and Power
     */
    public final Duration divideBy(final Power v)
    {
        return new Duration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the division of Energy and Volume, which results in a Pressure scalar.
     * @param v Energy scalar
     * @return Pressure scalar as a division of Energy and Volume
     */
    public final Pressure divideBy(final Volume v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and Frequency, which results in a Power scalar.
     * @param v Energy scalar
     * @return Power scalar as a multiplication of Energy and Frequency
     */
    public final Power multiplyBy(final Frequency v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

}
