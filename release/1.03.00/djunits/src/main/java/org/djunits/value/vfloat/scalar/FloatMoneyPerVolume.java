package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerVolume FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyPerVolumeUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerVolumeUnit&gt;(100.0,
 * MoneyPerVolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatMoneyPerVolume value = new FloatMoneyPerVolume(100.0, MoneyPerVolumeUnit.SI);</i><br>
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
public class FloatMoneyPerVolume extends TypedFloatScalarRel<MoneyPerVolumeUnit, FloatMoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerVolume(final float value, final MoneyPerVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerVolume(final FloatMoneyPerVolume value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoneyPerVolume(final double value, final MoneyPerVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolume instantiateTypeRel(final float value, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerVolume interpolate(final FloatMoneyPerVolume zero, final FloatMoneyPerVolume one,
            final float ratio)
    {
        return new FloatMoneyPerVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerVolume and FloatMoneyPerVolume, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerVolume scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerVolume and FloatMoneyPerVolume
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerVolume v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerVolume and FloatVolume, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerVolume scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerVolume and FloatVolume
     */
    public final FloatMoney multiplyBy(final FloatVolume v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}