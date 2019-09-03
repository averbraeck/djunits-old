package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;

/**
 * Easy access methods for the FloatTime FloatScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.112Z")
public class FloatTime extends AbstractFloatScalarAbs<TimeUnit, FloatTime, DurationUnit, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final FloatTime ZERO = new FloatTime(0.0f, TimeUnit.DEFAULT);

    /**
     * Construct FloatTime scalar.
     * @param value float; the float value
     * @param unit TimeUnit; unit for the float value
     */
    public FloatTime(final float value, final TimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatTime scalar using a double value.
     * @param value double; the double value
     * @param unit TimeUnit; unit for the resulting float value
     */
    public FloatTime(final double value, final TimeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatTime scalar.
     * @param value FloatTime; Scalar from which to construct this instance
     */
    public FloatTime(final FloatTime value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTime instantiateAbs(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDuration instantiateRel(final float value, final DurationUnit unit)
    {
        return new FloatDuration(value, unit);
    }

    /**
     * Construct FloatTime scalar.
     * @param value float; the float value in BASE units
     * @return FloatTime; the new scalar with the BASE value
     */
    public static final FloatTime createSI(final float value)
    {
        return new FloatTime(value, TimeUnit.DEFAULT);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatTime; the low value
     * @param one FloatTime; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return FloatTime; a Scalar at the ratio between
     */
    public static FloatTime interpolate(final FloatTime zero, final FloatTime one, final float ratio)
    {
        return new FloatTime(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 FloatTime; the first scalar
     * @param a2 FloatTime; the second scalar
     * @return FloatTime; the maximum value of two absolute scalars
     */
    public static FloatTime max(final FloatTime a1, final FloatTime a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 FloatTime; the first scalar
     * @param a2 FloatTime; the second scalar
     * @param an FloatTime...; the other scalars
     * @return FloatTime; the maximum value of more than two absolute scalars
     */
    public static FloatTime max(final FloatTime a1, final FloatTime a2, final FloatTime... an)
    {
        FloatTime maxa = (a1.gt(a2)) ? a1 : a2;
        for (FloatTime a : an)
        {
            if (a.gt(maxa))
            {
                maxa = a;
            }
        }
        return maxa;
    }

    /**
     * Return the minimum value of two absolute scalars.
     * @param a1 FloatTime; the first scalar
     * @param a2 FloatTime; the second scalar
     * @return FloatTime; the minimum value of two absolute scalars
     */
    public static FloatTime min(final FloatTime a1, final FloatTime a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 FloatTime; the first scalar
     * @param a2 FloatTime; the second scalar
     * @param an FloatTime...; the other scalars
     * @return FloatTime; the minimum value of more than two absolute scalars
     */
    public static FloatTime min(final FloatTime a1, final FloatTime a2, final FloatTime... an)
    {
        FloatTime mina = (a1.lt(a2)) ? a1 : a2;
        for (FloatTime a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a FloatTime representation of a textual representation of a value with a unit. The String representation that can
     * be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatTime
     * @return FloatTime; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static FloatTime valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing FloatTime: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing FloatTime: empty unitString");
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                TimeUnit unit = TimeUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatTime(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatTime from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatTime from " + text);
    }

    /**
     * Returns a FloatTime based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return FloatTime; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatTime of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing FloatTime: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatTime: empty unitString");
        TimeUnit unit = TimeUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new FloatTime(value, unit);
        }
        throw new IllegalArgumentException("Error parsing FloatTime with unit " + unitString);
    }

}
