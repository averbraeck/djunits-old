package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the AbsoluteTemperature FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Abs&lt;AbsoluteTemperatureUnit&gt; value =
 *         new FloatScalar.Abs&lt;AbsoluteTemperatureUnit&gt;(100.0, AbsoluteTemperatureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatAbsoluteTemperature value = new FloatAbsoluteTemperature(100.0, AbsoluteTemperatureUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2017-01-30 14:23:11 +0100 (Mon, 30 Jan 2017) $, @version $Revision: 234 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAbsoluteTemperature
        extends AbstractFloatScalarAbs<AbsoluteTemperatureUnit, FloatAbsoluteTemperature, TemperatureUnit, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAbsoluteTemperature ZERO = new FloatAbsoluteTemperature(0.0f, AbsoluteTemperatureUnit.BASE);

    /**
     * Construct FloatAbsoluteTemperature scalar.
     * @param value float; float value
     * @param unit AbsoluteTemperatureUnit; unit for the float value
     */
    public FloatAbsoluteTemperature(final float value, final AbsoluteTemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAbsoluteTemperature scalar using a double value.
     * @param value double; double value
     * @param unit AbsoluteTemperatureUnit; unit for the resulting float value
     */
    public FloatAbsoluteTemperature(final double value, final AbsoluteTemperatureUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatAbsoluteTemperature scalar.
     * @param value FloatAbsoluteTemperature; Scalar from which to construct this instance
     */
    public FloatAbsoluteTemperature(final FloatAbsoluteTemperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsoluteTemperature instantiateAbs(final float value, final AbsoluteTemperatureUnit unit)
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
     * Construct FloatAbsoluteTemperature scalar.
     * @param value float; float value in BASE units
     * @return the new scalar with the BASE value
     */
    public static final FloatAbsoluteTemperature createSI(final float value)
    {
        return new FloatAbsoluteTemperature(value, AbsoluteTemperatureUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatAbsoluteTemperature; the low value
     * @param one FloatAbsoluteTemperature; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
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
     * @param a1 FloatAbsoluteTemperature; the first scalar
     * @param a2 FloatAbsoluteTemperature; the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static FloatAbsoluteTemperature max(final FloatAbsoluteTemperature a1, final FloatAbsoluteTemperature a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 FloatAbsoluteTemperature; the first scalar
     * @param a2 FloatAbsoluteTemperature; the second scalar
     * @param an FloatAbsoluteTemperature...; the other scalars
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
     * @param a1 FloatAbsoluteTemperature; the first scalar
     * @param a2 FloatAbsoluteTemperature; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static FloatAbsoluteTemperature min(final FloatAbsoluteTemperature a1, final FloatAbsoluteTemperature a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 FloatAbsoluteTemperature; the first scalar
     * @param a2 FloatAbsoluteTemperature; the second scalar
     * @param an FloatAbsoluteTemperature...; the other scalars
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
