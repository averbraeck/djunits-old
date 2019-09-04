package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;
import org.djunits.unit.Unit;

/**
 * Easy access methods for the Direction FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Abs&lt;DirectionUnit&gt; value = new FloatScalar.Abs&lt;DirectionUnit&gt;(100.0, DirectionUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatDirection value = new FloatDirection(100.0, DirectionUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatDirection extends AbstractFloatScalarAbs<DirectionUnit, FloatDirection, AngleUnit, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDirection ZERO = new FloatDirection(0.0f, DirectionUnit.BASE);

    /**
     * Construct FloatDirection scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDirection(final float value, final DirectionUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDirection scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatDirection(final double value, final DirectionUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatDirection scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatDirection(final FloatDirection value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDirection instantiateAbs(final float value, final DirectionUnit unit)
    {
        return new FloatDirection(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngle instantiateRel(final float value, final AngleUnit unit)
    {
        return new FloatAngle(value, unit);
    }

    /**
     * Construct FloatDirection scalar.
     * @param value float value in BASE units
     * @return the new scalar with the BASE value
     */
    public static final FloatDirection createSI(final float value)
    {
        return new FloatDirection(value, DirectionUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDirection interpolate(final FloatDirection zero, final FloatDirection one, final float ratio)
    {
        return new FloatDirection(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static FloatDirection max(final FloatDirection a1, final FloatDirection a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static FloatDirection max(final FloatDirection a1, final FloatDirection a2, final FloatDirection... an)
    {
        FloatDirection maxa = (a1.gt(a2)) ? a1 : a2;
        for (FloatDirection a : an)
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
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static FloatDirection min(final FloatDirection a1, final FloatDirection a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static FloatDirection min(final FloatDirection a1, final FloatDirection a2, final FloatDirection... an)
    {
        FloatDirection mina = (a1.lt(a2)) ? a1 : a2;
        for (FloatDirection a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a FloatDirection representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatDirection
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatDirection valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatDirection -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (DirectionUnit unit : Unit.getUnits(DirectionUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatDirection(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatDirection from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatDirection from " + text);
    }

}
