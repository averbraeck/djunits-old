package org.djunits.value.vfloat.scalar;

import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the AbsoluteTemperature FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Abs&lt;TemperatureUnit&gt; value = new FloatScalar.Abs&lt;TemperatureUnit&gt;(100.0, TemperatureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatAbsoluteTemperature value = new FloatAbsoluteTemperature(100.0, TemperatureUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2016-05-28 14:25:52 +0200 (Sat, 28 May 2016) $, @version $Revision: 202 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAbsoluteTemperature
        extends AbstractFloatScalarAbs<TemperatureUnit, FloatAbsoluteTemperature, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAbsoluteTemperature ZERO = new FloatAbsoluteTemperature(0.0f, TemperatureUnit.SI);

    /**
     * Construct FloatAbsoluteTemperature scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAbsoluteTemperature(final float value, final TemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAbsoluteTemperature scalar using a double value.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAbsoluteTemperature(final double value, final TemperatureUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatAbsoluteTemperature scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAbsoluteTemperature(final FloatAbsoluteTemperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsoluteTemperature instantiateAbs(final float value, final TemperatureUnit unit)
    {
        return new FloatAbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTemperature instantiateRel(final float value, final TemperatureUnit unit)
    {
        return new FloatTemperature(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAbsoluteTemperature interpolate(final FloatAbsoluteTemperature zero, final FloatAbsoluteTemperature one,
            final float ratio)
    {
        return new FloatAbsoluteTemperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static FloatAbsoluteTemperature max(final FloatAbsoluteTemperature a1, final FloatAbsoluteTemperature a2)
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
    public static FloatAbsoluteTemperature max(final FloatAbsoluteTemperature a1, final FloatAbsoluteTemperature a2,
            final FloatAbsoluteTemperature... an)
    {
        FloatAbsoluteTemperature maxa = (a1.gt(a2)) ? a1 : a2;
        for (FloatAbsoluteTemperature a : an)
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
    public static FloatAbsoluteTemperature min(final FloatAbsoluteTemperature a1, final FloatAbsoluteTemperature a2)
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
    public static FloatAbsoluteTemperature min(final FloatAbsoluteTemperature a1, final FloatAbsoluteTemperature a2,
            final FloatAbsoluteTemperature... an)
    {
        FloatAbsoluteTemperature mina = (a1.lt(a2)) ? a1 : a2;
        for (FloatAbsoluteTemperature a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

}
