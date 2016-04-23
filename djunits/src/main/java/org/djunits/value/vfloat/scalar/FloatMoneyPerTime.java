package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerTime FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyPerTimeUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerTimeUnit&gt;(100.0,
 * MoneyPerTimeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatMoneyPerTime value = new FloatMoneyPerTime(100.0, MoneyPerTimeUnit.SI);</i><br>
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
public class FloatMoneyPerTime extends TypedFloatScalarRel<MoneyPerTimeUnit, FloatMoneyPerTime>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerTime scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerTime(final float value, final MoneyPerTimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerTime scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerTime(final FloatMoneyPerTime value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerTime scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoneyPerTime(final double value, final MoneyPerTimeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerTime instantiateTypeRel(final float value, final MoneyPerTimeUnit unit)
    {
        return new FloatMoneyPerTime(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerTime interpolate(final FloatMoneyPerTime zero, final FloatMoneyPerTime one, final float ratio)
    {
        return new FloatMoneyPerTime(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerTime and FloatMoneyPerTime, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerTime scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerTime and FloatMoneyPerTime
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerTime v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerTime and FloatDuration, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerTime scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerTime and FloatDuration
     */
    public final FloatMoney multiplyBy(final FloatDuration v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of FloatMoneyPerTime and FloatFrequency, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerTime scalar
     * @return FloatMoney scalar as a division of FloatMoneyPerTime and FloatFrequency
     */
    public final FloatMoney divideBy(final FloatFrequency v)
    {
        return new FloatMoney(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
