package org.djunits.value.vdouble.scalar;

import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Absolute %Type% DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Abs&lt;TemperatureUnit&gt; value = new DoubleScalar.Abs&lt;TemperatureUnit&gt;(100.0,
 * TemperatureUnit.SI);</i><br>
 * we can now write <br>
 * <i>AbsoluteTemperature value = new AbsoluteTemperature(100.0, TemperatureUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AbsoluteTemperature extends TypedDoubleScalarAbs<TemperatureUnit, AbsoluteTemperature, Temperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final AbsoluteTemperature ZERO = new AbsoluteTemperature(0.0, TemperatureUnit.SI);

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AbsoluteTemperature(final double value, final TemperatureUnit unit)
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
    protected final AbsoluteTemperature instantiateTypeAbs(final double value, final TemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Temperature instantiateTypeRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
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

}
