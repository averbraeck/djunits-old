package org.djunits.value.vfloat.scalar;

import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of <br>
 * <i>FloatScalar.Abs&lt;TimeUnit&gt; value = new FloatScalar.Abs&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatTime value = new FloatTime(100.0, TimeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatTime extends TypedFloatScalarAbs<TimeUnit, FloatTime, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatTime ZERO = new FloatTime(0.0f, TimeUnit.SI);

    /**
     * Construct FloatTime scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatTime(final float value, final TimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatTime scalar using a double value.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatTime(final double value, final TimeUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatTime scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatTime(final FloatTime value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTime instantiateTypeAbs(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDuration instantiateTypeRel(final float value, final TimeUnit unit)
    {
        return new FloatDuration(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatTime interpolate(final FloatTime zero, final FloatTime one, final float ratio)
    {
        return new FloatTime(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

}
