package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;

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
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2017-01-30 14:23:11 +0100 (Mon, 30 Jan 2017) $, @version $Revision: 234 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDirection extends AbstractFloatScalarAbs<DirectionUnit, FloatDirection, AngleUnit, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDirection ZERO = new FloatDirection(0.0f, DirectionUnit.BASE);

    /**
     * Construct FloatDirection scalar.
     * @param value float; float value
     * @param unit DirectionUnit; unit for the float value
     */
    public FloatDirection(final float value, final DirectionUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDirection scalar using a double value.
     * @param value double; double value
     * @param unit DirectionUnit; unit for the resulting float value
     */
    public FloatDirection(final double value, final DirectionUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatDirection scalar.
     * @param value FloatDirection; Scalar from which to construct this instance
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
     * @param value float; float value in BASE units
     * @return the new scalar with the BASE value
     */
    public static final FloatDirection createSI(final float value)
    {
        return new FloatDirection(value, DirectionUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatDirection; the low value
     * @param one FloatDirection; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDirection interpolate(final FloatDirection zero, final FloatDirection one, final float ratio)
    {
        return new FloatDirection(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 FloatDirection; the first scalar
     * @param a2 FloatDirection; the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static FloatDirection max(final FloatDirection a1, final FloatDirection a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 FloatDirection; the first scalar
     * @param a2 FloatDirection; the second scalar
     * @param an FloatDirection...; the other scalars
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
     * @param a1 FloatDirection; the first scalar
     * @param a2 FloatDirection; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static FloatDirection min(final FloatDirection a1, final FloatDirection a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 FloatDirection; the first scalar
     * @param a2 FloatDirection; the second scalar
     * @param an FloatDirection...; the other scalars
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
