package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerArea FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyPerAreaUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerAreaUnit&gt;(100.0,
 * MoneyPerAreaUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatMoneyPerArea value = new FloatMoneyPerArea(100.0, MoneyPerAreaUnit.SI);</i><br>
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
public class FloatMoneyPerArea extends TypedFloatScalarRel<MoneyPerAreaUnit, FloatMoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerArea scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerArea(final float value, final MoneyPerAreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerArea(final FloatMoneyPerArea value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerArea scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoneyPerArea(final double value, final MoneyPerAreaUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerArea instantiateTypeRel(final float value, final MoneyPerAreaUnit unit)
    {
        return new FloatMoneyPerArea(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerArea interpolate(final FloatMoneyPerArea zero, final FloatMoneyPerArea one, final float ratio)
    {
        return new FloatMoneyPerArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerArea and FloatMoneyPerArea, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerArea scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerArea and FloatMoneyPerArea
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerArea v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerArea and FloatArea, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerArea scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerArea and FloatArea
     */
    public final FloatMoney multiplyBy(final FloatArea v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
