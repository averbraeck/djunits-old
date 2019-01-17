package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerVolume DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerVolumeUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerVolumeUnit&gt;(100.0, MoneyPerVolumeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerVolume value = new MoneyPerVolume(100.0, MoneyPerVolumeUnit.SI);
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
public class MoneyPerVolume extends AbstractDoubleScalarRel<MoneyPerVolumeUnit, MoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerVolume scalar.
     * @param value double; double value
     * @param unit MoneyPerVolumeUnit; unit for the double value
     */
    public MoneyPerVolume(final double value, final MoneyPerVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerVolume scalar.
     * @param value MoneyPerVolume; Scalar from which to construct this instance
     */
    public MoneyPerVolume(final MoneyPerVolume value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume instantiateRel(final double value, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero MoneyPerVolume; the low value
     * @param one MoneyPerVolume; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerVolume interpolate(final MoneyPerVolume zero, final MoneyPerVolume one, final double ratio)
    {
        return new MoneyPerVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 MoneyPerVolume; the first scalar
     * @param r2 MoneyPerVolume; the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerVolume max(final MoneyPerVolume r1, final MoneyPerVolume r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 MoneyPerVolume; the first scalar
     * @param r2 MoneyPerVolume; the second scalar
     * @param rn MoneyPerVolume...; the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static MoneyPerVolume max(final MoneyPerVolume r1, final MoneyPerVolume r2, final MoneyPerVolume... rn)
    {
        MoneyPerVolume maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerVolume r : rn)
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
     * @param r1 MoneyPerVolume; the first scalar
     * @param r2 MoneyPerVolume; the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static MoneyPerVolume min(final MoneyPerVolume r1, final MoneyPerVolume r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 MoneyPerVolume; the first scalar
     * @param r2 MoneyPerVolume; the second scalar
     * @param rn MoneyPerVolume...; the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static MoneyPerVolume min(final MoneyPerVolume r1, final MoneyPerVolume r2, final MoneyPerVolume... rn)
    {
        MoneyPerVolume minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerVolume r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerVolume and MoneyPerVolume, which results in a Dimensionless scalar.
     * @param v MoneyPerVolume; MoneyPerVolume scalar
     * @return Dimensionless scalar as a division of MoneyPerVolume and MoneyPerVolume
     */
    public final Dimensionless divideBy(final MoneyPerVolume v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerVolume and Volume, which results in a Money scalar.
     * @param v Volume; MoneyPerVolume scalar
     * @return Money scalar as a multiplication of MoneyPerVolume and Volume
     */
    public final Money multiplyBy(final Volume v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
