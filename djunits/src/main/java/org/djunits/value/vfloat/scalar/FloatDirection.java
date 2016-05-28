package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleUnit;

/**
 * Easy access methods for the Direction FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Abs&lt;AngleUnit&gt; value = new FloatScalar.Abs&lt;AngleUnit&gt;(100.0, AngleUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatDirection value = new FloatDirection(100.0, AngleUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2016-04-23 21:28:04 +0200 (Sat, 23 Apr 2016) $, @version $Revision: 191 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDirection extends TypedFloatScalarAbs<AngleUnit, FloatDirection, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDirection ZERO = new FloatDirection(0.0f, AngleUnit.SI);

    /**
     * Construct FloatDirection scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDirection(final float value, final AngleUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDirection scalar using a double value.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDirection(final double value, final AngleUnit unit)
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
    protected final FloatDirection instantiateTypeAbs(final float value, final AngleUnit unit)
    {
        return new FloatDirection(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngle instantiateTypeRel(final float value, final AngleUnit unit)
    {
        return new FloatAngle(value, unit);
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

}
