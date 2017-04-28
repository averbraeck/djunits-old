package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DurationUnit;
import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the Absolute Time DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar.Abs&lt;TimeUnit&gt; value = new DoubleScalar.Abs&lt;TimeUnit&gt;(100.0, TimeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Time value = new Time(100.0, TimeUnit.BASE);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Time extends AbstractDoubleScalarAbs<TimeUnit, Time, DurationUnit, Duration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Time ZERO = new Time(0.0, TimeUnit.BASE);

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
    public final Time instantiateAbs(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Duration instantiateRel(final double value, final DurationUnit unit)
    {
        return new Duration(value, unit);
    }

    /**
     * Construct %TypeAbsl% scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Time createSI(final double value)
    {
        return new Time(value, TimeUnit.BASE);
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

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static Time max(final Time a1, final Time a2)
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
    public static Time max(final Time a1, final Time a2, final Time... an)
    {
        Time maxa = (a1.gt(a2)) ? a1 : a2;
        for (Time a : an)
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
    public static Time min(final Time a1, final Time a2)
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
    public static Time min(final Time a1, final Time a2, final Time... an)
    {
        Time mina = (a1.lt(a2)) ? a1 : a2;
        for (Time a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

}
