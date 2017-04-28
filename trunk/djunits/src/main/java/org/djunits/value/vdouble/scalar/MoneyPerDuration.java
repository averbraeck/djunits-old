package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerDuration DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerDurationUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerDurationUnit&gt;(100.0, MoneyPerDurationUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerDuration value = new MoneyPerDuration(100.0, MoneyPerDurationUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerDuration extends AbstractDoubleScalarRel<MoneyPerDurationUnit, MoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerDuration scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerDuration(final double value, final MoneyPerDurationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerDuration scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerDuration(final MoneyPerDuration value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerDuration instantiateRel(final double value, final MoneyPerDurationUnit unit)
    {
        return new MoneyPerDuration(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerDuration interpolate(final MoneyPerDuration zero, final MoneyPerDuration one, final double ratio)
    {
        return new MoneyPerDuration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerDuration max(final MoneyPerDuration r1, final MoneyPerDuration r2)
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
    public static MoneyPerDuration max(final MoneyPerDuration r1, final MoneyPerDuration r2, final MoneyPerDuration... rn)
    {
        MoneyPerDuration maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerDuration r : rn)
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
    public static MoneyPerDuration min(final MoneyPerDuration r1, final MoneyPerDuration r2)
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
    public static MoneyPerDuration min(final MoneyPerDuration r1, final MoneyPerDuration r2, final MoneyPerDuration... rn)
    {
        MoneyPerDuration minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerDuration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerDuration and MoneyPerDuration, which results in a Dimensionless scalar.
     * @param v MoneyPerDuration scalar
     * @return Dimensionless scalar as a division of MoneyPerDuration and MoneyPerDuration
     */
    public final Dimensionless divideBy(final MoneyPerDuration v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerDuration and Duration, which results in a Money scalar.
     * @param v MoneyPerDuration scalar
     * @return Money scalar as a multiplication of MoneyPerDuration and Duration
     */
    public final Money multiplyBy(final Duration v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of MoneyPerDuration and Frequency, which results in a Money scalar.
     * @param v MoneyPerDuration scalar
     * @return Money scalar as a division of MoneyPerDuration and Frequency
     */
    public final Money divideBy(final Frequency v)
    {
        return new Money(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
