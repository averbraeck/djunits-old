package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerTime DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerTimeUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerTimeUnit&gt;(100.0, MoneyPerTimeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerTime value = new MoneyPerTime(100.0, MoneyPerTimeUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerTime extends TypedDoubleScalarRel<MoneyPerTimeUnit, MoneyPerTime>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerTime scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerTime(final double value, final MoneyPerTimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerTime scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerTime(final MoneyPerTime value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerTime instantiateTypeRel(final double value, final MoneyPerTimeUnit unit)
    {
        return new MoneyPerTime(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerTime interpolate(final MoneyPerTime zero, final MoneyPerTime one, final double ratio)
    {
        return new MoneyPerTime(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerTime max(final MoneyPerTime r1, final MoneyPerTime r2)
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
    public static MoneyPerTime max(final MoneyPerTime r1, final MoneyPerTime r2, final MoneyPerTime... rn)
    {
        MoneyPerTime maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerTime r : rn)
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
    public static MoneyPerTime min(final MoneyPerTime r1, final MoneyPerTime r2)
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
    public static MoneyPerTime min(final MoneyPerTime r1, final MoneyPerTime r2, final MoneyPerTime... rn)
    {
        MoneyPerTime minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerTime r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerTime and MoneyPerTime, which results in a Dimensionless scalar.
     * @param v MoneyPerTime scalar
     * @return Dimensionless scalar as a division of MoneyPerTime and MoneyPerTime
     */
    public final Dimensionless divideBy(final MoneyPerTime v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerTime and Duration, which results in a Money scalar.
     * @param v MoneyPerTime scalar
     * @return Money scalar as a multiplication of MoneyPerTime and Duration
     */
    public final Money multiplyBy(final Duration v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of MoneyPerTime and Frequency, which results in a Money scalar.
     * @param v MoneyPerTime scalar
     * @return Money scalar as a division of MoneyPerTime and Frequency
     */
    public final Money divideBy(final Frequency v)
    {
        return new Money(this.si / v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
