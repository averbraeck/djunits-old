package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AngleSolid FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;AngleSolidUnit&gt; value = new FloatScalar.Rel&lt;AngleSolidUnit&gt;(100.0, AngleSolidUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatAngleSolid value = new FloatAngleSolid(100.0, AngleSolidUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAngleSolid extends TypedFloatScalarRel<AngleSolidUnit, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatAngleSolid scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAngleSolid(final float value, final AngleSolidUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAngleSolid scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAngleSolid(final FloatAngleSolid value)
    {
        super(value);
    }

    /**
     * Construct FloatAngleSolid scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatAngleSolid(final double value, final AngleSolidUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolid instantiateTypeRel(final float value, final AngleSolidUnit unit)
    {
        return new FloatAngleSolid(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAngleSolid interpolate(final FloatAngleSolid zero, final FloatAngleSolid one, final float ratio)
    {
        return new FloatAngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of FloatAngleSolid and FloatAngleSolid, which results in a FloatDimensionless scalar.
     * @param v FloatAngleSolid scalar
     * @return FloatDimensionless scalar as a division of FloatAngleSolid and FloatAngleSolid
     */
    public final FloatDimensionless divideBy(final FloatAngleSolid v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}