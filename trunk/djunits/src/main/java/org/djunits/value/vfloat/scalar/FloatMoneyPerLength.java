package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerLength FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyPerLengthUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerLengthUnit&gt;(100.0,
 * MoneyPerLengthUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatMoneyPerLength value = new FloatMoneyPerLength(100.0, MoneyPerLengthUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMoneyPerLength extends TypedFloatScalarRel<MoneyPerLengthUnit, FloatMoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerLength scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerLength(final float value, final MoneyPerLengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerLength scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerLength(final FloatMoneyPerLength value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerLength scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoneyPerLength(final double value, final MoneyPerLengthUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLength instantiateTypeRel(final float value, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLength(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerLength interpolate(final FloatMoneyPerLength zero, final FloatMoneyPerLength one,
        final float ratio)
    {
        return new FloatMoneyPerLength(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerLength and FloatMoneyPerLength, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerLength scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerLength and FloatMoneyPerLength
     */
    public final FloatDimensionless.Rel divideBy(final FloatMoneyPerLength v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerLength and FloatLength, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerLength scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerLength and FloatLength
     */
    public final FloatMoney multiplyBy(final FloatLength.Rel v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerLength and FloatLinearDensity, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerLength scalar
     * @return FloatMoney scalar as a division of FloatMoneyPerLength and FloatLinearDensity
     */
    public final FloatMoney divideBy(final FloatLinearDensity v)
    {
        return new FloatMoney(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
