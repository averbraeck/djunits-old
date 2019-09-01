package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerLength FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyPerLengthUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerLengthUnit&gt;(100.0, MoneyPerLengthUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoneyPerLength value = new FloatMoneyPerLength(100.0, MoneyPerLengthUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerLength extends AbstractFloatScalarRel<MoneyPerLengthUnit, FloatMoneyPerLength>
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
    public final FloatMoneyPerLength instantiateRel(final float value, final MoneyPerLengthUnit unit)
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
        return new FloatMoneyPerLength(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoneyPerLength max(final FloatMoneyPerLength r1, final FloatMoneyPerLength r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static FloatMoneyPerLength max(final FloatMoneyPerLength r1, final FloatMoneyPerLength r2,
            final FloatMoneyPerLength... rn)
    {
        FloatMoneyPerLength maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoneyPerLength r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static FloatMoneyPerLength min(final FloatMoneyPerLength r1, final FloatMoneyPerLength r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static FloatMoneyPerLength min(final FloatMoneyPerLength r1, final FloatMoneyPerLength r2,
            final FloatMoneyPerLength... rn)
    {
        FloatMoneyPerLength minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoneyPerLength r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMoneyPerLength and FloatMoneyPerLength, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerLength scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerLength and FloatMoneyPerLength
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerLength v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerLength and FloatLength, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerLength scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerLength and FloatLength
     */
    public final FloatMoney multiplyBy(final FloatLength v)
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
