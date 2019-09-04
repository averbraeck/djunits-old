package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerArea DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerAreaUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerAreaUnit&gt;(100.0, MoneyPerAreaUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerArea value = new MoneyPerArea(100.0, MoneyPerAreaUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MoneyPerArea extends AbstractDoubleScalarRel<MoneyPerAreaUnit, MoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerArea scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerArea(final double value, final MoneyPerAreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerArea(final MoneyPerArea value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerArea instantiateRel(final double value, final MoneyPerAreaUnit unit)
    {
        return new MoneyPerArea(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerArea interpolate(final MoneyPerArea zero, final MoneyPerArea one, final double ratio)
    {
        return new MoneyPerArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerArea max(final MoneyPerArea r1, final MoneyPerArea r2)
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
    public static MoneyPerArea max(final MoneyPerArea r1, final MoneyPerArea r2, final MoneyPerArea... rn)
    {
        MoneyPerArea maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerArea r : rn)
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
    public static MoneyPerArea min(final MoneyPerArea r1, final MoneyPerArea r2)
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
    public static MoneyPerArea min(final MoneyPerArea r1, final MoneyPerArea r2, final MoneyPerArea... rn)
    {
        MoneyPerArea minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerArea r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerArea and MoneyPerArea, which results in a Dimensionless scalar.
     * @param v MoneyPerArea scalar
     * @return Dimensionless scalar as a division of MoneyPerArea and MoneyPerArea
     */
    public final Dimensionless divideBy(final MoneyPerArea v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerArea and Area, which results in a Money scalar.
     * @param v MoneyPerArea scalar
     * @return Money scalar as a multiplication of MoneyPerArea and Area
     */
    public final Money multiplyBy(final Area v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
