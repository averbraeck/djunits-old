package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.unit.Unit;

/**
 * Easy access methods for the Position FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Abs&lt;PositionUnit&gt; value = new FloatScalar.Abs&lt;PositionUnit&gt;(100.0, PositionUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatPosition value = new FloatPosition(100.0, PositionUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2019-02-27 23:44:43 +0100 (Wed, 27 Feb 2019) $, @version $Revision: 333 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPosition extends AbstractFloatScalarAbs<PositionUnit, FloatPosition, LengthUnit, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatPosition ZERO = new FloatPosition(0.0f, PositionUnit.BASE);

    /**
     * Construct FloatPosition scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPosition(final float value, final PositionUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPosition scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatPosition(final double value, final PositionUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatPosition scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatPosition(final FloatPosition value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPosition instantiateAbs(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLength instantiateRel(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
    }

    /**
     * Construct FloatPosition scalar.
     * @param value float value in BASE units
     * @return the new scalar with the BASE value
     */
    public static final FloatPosition createSI(final float value)
    {
        return new FloatPosition(value, PositionUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPosition interpolate(final FloatPosition zero, final FloatPosition one, final float ratio)
    {
        return new FloatPosition(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static FloatPosition max(final FloatPosition a1, final FloatPosition a2)
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
    public static FloatPosition max(final FloatPosition a1, final FloatPosition a2, final FloatPosition... an)
    {
        FloatPosition maxa = (a1.gt(a2)) ? a1 : a2;
        for (FloatPosition a : an)
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
    public static FloatPosition min(final FloatPosition a1, final FloatPosition a2)
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
    public static FloatPosition min(final FloatPosition a1, final FloatPosition a2, final FloatPosition... an)
    {
        FloatPosition mina = (a1.lt(a2)) ? a1 : a2;
        for (FloatPosition a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a FloatPosition representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatPosition
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatPosition valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatPosition -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (PositionUnit unit : Unit.getUnits(PositionUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatPosition(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatPosition from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatPosition from " + text);
    }

}
