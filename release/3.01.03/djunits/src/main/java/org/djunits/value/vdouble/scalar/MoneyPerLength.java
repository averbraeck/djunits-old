package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerLength DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerLengthUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerLengthUnit&gt;(100.0, MoneyPerLengthUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerLength value = new MoneyPerLength(100.0, MoneyPerLengthUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerLength extends AbstractDoubleScalarRel<MoneyPerLengthUnit, MoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerLength scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerLength(final double value, final MoneyPerLengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerLength scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerLength(final MoneyPerLength value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLength instantiateRel(final double value, final MoneyPerLengthUnit unit)
    {
        return new MoneyPerLength(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerLength interpolate(final MoneyPerLength zero, final MoneyPerLength one, final double ratio)
    {
        return new MoneyPerLength(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerLength max(final MoneyPerLength r1, final MoneyPerLength r2)
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
    public static MoneyPerLength max(final MoneyPerLength r1, final MoneyPerLength r2, final MoneyPerLength... rn)
    {
        MoneyPerLength maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerLength r : rn)
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
    public static MoneyPerLength min(final MoneyPerLength r1, final MoneyPerLength r2)
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
    public static MoneyPerLength min(final MoneyPerLength r1, final MoneyPerLength r2, final MoneyPerLength... rn)
    {
        MoneyPerLength minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerLength r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerLength and MoneyPerLength, which results in a Dimensionless scalar.
     * @param v MoneyPerLength scalar
     * @return Dimensionless scalar as a division of MoneyPerLength and MoneyPerLength
     */
    public final Dimensionless divideBy(final MoneyPerLength v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerLength and Length, which results in a Money scalar.
     * @param v MoneyPerLength scalar
     * @return Money scalar as a multiplication of MoneyPerLength and Length
     */
    public final Money multiplyBy(final Length v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of MoneyPerLength and LinearDensity, which results in a Money scalar.
     * @param v MoneyPerLength scalar
     * @return Money scalar as a division of MoneyPerLength and LinearDensity
     */
    public final Money divideBy(final LinearDensity v)
    {
        return new Money(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
