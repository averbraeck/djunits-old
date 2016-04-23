package org.djunits.value.vfloat.scalar;

import org.djunits.unit.LengthUnit;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of <br>
 * <i>FloatScalar.Abs&lt;LengthUnit&gt; value = new FloatScalar.Abs&lt;LengthUnit&gt;(100.0, LengthUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatPosition value = new FloatPosition(100.0, LengthUnit.SI);</i><br>
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
public class FloatPosition extends TypedFloatScalarAbs<LengthUnit, FloatPosition, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatPosition ZERO = new FloatPosition(0.0f, LengthUnit.SI);

    /**
     * Construct FloatPosition scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPosition(final float value, final LengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPosition scalar using a double value.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPosition(final double value, final LengthUnit unit)
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
    protected final FloatPosition instantiateTypeAbs(final float value, final LengthUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLength instantiateTypeRel(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
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

}
