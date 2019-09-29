package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PowerUnit;
import org.djunits4.unit.PressureUnit;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;

/**
 * Easy access methods for the Energy DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class Energy extends AbstractDoubleScalarRel<EnergyUnit, Energy>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** Constant with value zero. */
    public static final Energy ZERO = new Energy(0.0, EnergyUnit.SI);

    /** Constant with value one. */
    public static final Energy ONE = new Energy(1.0, EnergyUnit.SI);

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Energy NaN = new Energy(Double.NaN, EnergyUnit.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final Energy POSITIVE_INFINITY = new Energy(Double.POSITIVE_INFINITY, EnergyUnit.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final Energy NEGATIVE_INFINITY = new Energy(Double.NEGATIVE_INFINITY, EnergyUnit.SI);

    /** Constant with value MAX_VALUE. */
    public static final Energy POS_MAXVALUE = new Energy(Double.MAX_VALUE, EnergyUnit.SI);

    /** Constant with value -MAX_VALUE. */
    public static final Energy NEG_MAXVALUE = new Energy(-Double.MAX_VALUE, EnergyUnit.SI);

    /**
     * Construct Energy scalar.
     * @param value double; the double value
     * @param unit EnergyUnit; unit for the double value
     */
    public Energy(final double value, final EnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Energy scalar.
     * @param value Energy; Scalar from which to construct this instance
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
     * @param value double; the double value in SI units
     * @return Energy; the new scalar with the SI value
     */
    public static final Energy createSI(final double value)
    {
        return new Energy(value, EnergyUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Energy; the low value
     * @param one Energy; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return Energy; a Scalar at the ratio between
     */
    public static Energy interpolate(final Energy zero, final Energy one, final double ratio)
    {
        return new Energy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero.getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Energy; the first scalar
     * @param r2 Energy; the second scalar
     * @return Energy; the maximum value of two relative scalars
     */
    public static Energy max(final Energy r1, final Energy r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Energy; the first scalar
     * @param r2 Energy; the second scalar
     * @param rn Energy...; the other scalars
     * @return Energy; the maximum value of more than two relative scalars
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
     * @param r1 Energy; the first scalar
     * @param r2 Energy; the second scalar
     * @return Energy; the minimum value of two relative scalars
     */
    public static Energy min(final Energy r1, final Energy r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Energy; the first scalar
     * @param r2 Energy; the second scalar
     * @param rn Energy...; the other scalars
     * @return Energy; the minimum value of more than two relative scalars
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
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a Energy
     * @return Energy; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static Energy valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing Energy: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing Energy: empty unitString");
        Matcher matcher = ValueUtil.NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                EnergyUnit unit = EnergyUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
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
     * Returns a Energy based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return Energy; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static Energy of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing Energy: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing Energy: empty unitString");
        EnergyUnit unit = EnergyUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new Energy(value, unit);
        }
        throw new IllegalArgumentException("Error parsing Energy with unit " + unitString);
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
