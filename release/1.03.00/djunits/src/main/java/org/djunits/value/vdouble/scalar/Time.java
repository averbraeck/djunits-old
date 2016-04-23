package org.djunits.value.vdouble.scalar;

import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the Absolute %Type% DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Abs&lt;TimeUnit&gt; value = new DoubleScalar.Abs&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
 * we can now write <br>
 * <i>Time value = new Time(100.0, TimeUnit.SI);</i><br>
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
public class Time extends TypedDoubleScalarAbs<TimeUnit, Time, Duration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Time ZERO = new Time(0.0, TimeUnit.SI);

    /**
     * Construct Time scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Time(final double value, final TimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Time scalar.
     * @param value Scalar from which to construct this instance
     */
    public Time(final Time value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Time instantiateTypeAbs(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Duration instantiateTypeRel(final double value, final TimeUnit unit)
    {
        return new Duration(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Time interpolate(final Time zero, final Time one, final double ratio)
    {
        return new Time(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

}
