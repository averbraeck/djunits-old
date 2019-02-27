package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.Unit;

/**
 * Easy access methods for the Absolute AbsoluteTemperature DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar.Abs&lt;AbsoluteTemperatureUnit&gt; value =
 *         new DoubleScalar.Abs&lt;AbsoluteTemperatureUnit&gt;(100.0, AbsoluteTemperatureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * AbsoluteTemperature value = new AbsoluteTemperature(100.0, AbsoluteTemperatureUnit.BASE);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AbsoluteTemperature
        extends AbstractDoubleScalarAbs<AbsoluteTemperatureUnit, AbsoluteTemperature, TemperatureUnit, Temperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final AbsoluteTemperature ZERO = new AbsoluteTemperature(0.0, AbsoluteTemperatureUnit.BASE);

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AbsoluteTemperature(final double value, final AbsoluteTemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value Scalar from which to construct this instance
     */
    public AbsoluteTemperature(final AbsoluteTemperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperature instantiateAbs(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Temperature instantiateRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

    /**
     * Construct %TypeAbsl% scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final AbsoluteTemperature createSI(final double value)
    {
        return new AbsoluteTemperature(value, AbsoluteTemperatureUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static AbsoluteTemperature interpolate(final AbsoluteTemperature zero, final AbsoluteTemperature one,
            final double ratio)
    {
        return new AbsoluteTemperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static AbsoluteTemperature max(final AbsoluteTemperature a1, final AbsoluteTemperature a2)
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
    public static AbsoluteTemperature max(final AbsoluteTemperature a1, final AbsoluteTemperature a2,
            final AbsoluteTemperature... an)
    {
        AbsoluteTemperature maxa = (a1.gt(a2)) ? a1 : a2;
        for (AbsoluteTemperature a : an)
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
    public static AbsoluteTemperature min(final AbsoluteTemperature a1, final AbsoluteTemperature a2)
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
    public static AbsoluteTemperature min(final AbsoluteTemperature a1, final AbsoluteTemperature a2,
            final AbsoluteTemperature... an)
    {
        AbsoluteTemperature mina = (a1.lt(a2)) ? a1 : a2;
        for (AbsoluteTemperature a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a AbsoluteTemperature representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a AbsoluteTemperature
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static AbsoluteTemperature valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing AbsoluteTemperature -- null or empty argument");
        }
        int index = text.length() - 1;
        while ("0123456789.".indexOf(text.charAt(index)) == -1 && index > 0)
        {
            index--;
        }
        try
        {
            String unitString = text.substring(index + 1).trim();
            String valueString = text.substring(0, index + 1).trim();
            for (AbsoluteTemperatureUnit unit : Unit.getUnits(AbsoluteTemperatureUnit.class))
            {
                if (unitString.equals(unit.getAbbreviation()))
                {
                    double d = Double.parseDouble(valueString);
                    return new AbsoluteTemperature(d, unit);
                }
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing AbsoluteTemperature from " + text, exception);
        }
        throw new IllegalArgumentException("Error parsing AbsoluteTemperature from " + text);
    }

}
