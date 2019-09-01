package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerArea FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyPerAreaUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerAreaUnit&gt;(100.0, MoneyPerAreaUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoneyPerArea value = new FloatMoneyPerArea(100.0, MoneyPerAreaUnit.SI);
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
public class FloatMoneyPerArea extends AbstractFloatScalarRel<MoneyPerAreaUnit, FloatMoneyPerArea>
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
    public final FloatMoneyPerArea instantiateRel(final float value, final MoneyPerAreaUnit unit)
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
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoneyPerArea max(final FloatMoneyPerArea r1, final FloatMoneyPerArea r2)
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
    public static FloatMoneyPerArea max(final FloatMoneyPerArea r1, final FloatMoneyPerArea r2, final FloatMoneyPerArea... rn)
    {
        FloatMoneyPerArea maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoneyPerArea r : rn)
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
    public static FloatMoneyPerArea min(final FloatMoneyPerArea r1, final FloatMoneyPerArea r2)
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
    public static FloatMoneyPerArea min(final FloatMoneyPerArea r1, final FloatMoneyPerArea r2, final FloatMoneyPerArea... rn)
    {
        FloatMoneyPerArea minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoneyPerArea r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
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
