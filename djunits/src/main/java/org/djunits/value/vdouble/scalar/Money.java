package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the Money DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyUnit&gt; value = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Money value = new Money(100.0, MoneyUnit.SI);
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
public class Money extends AbstractDoubleScalarRel<MoneyUnit, Money>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Money scalar.
     * @param value double; double value
     * @param unit MoneyUnit; unit for the double value
     */
    public Money(final double value, final MoneyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Money scalar.
     * @param value Money; Scalar from which to construct this instance
     */
    public Money(final Money value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Money instantiateRel(final double value, final MoneyUnit unit)
    {
        return new Money(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero Money; the low value
     * @param one Money; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Money interpolate(final Money zero, final Money one, final double ratio)
    {
        return new Money(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 Money; the first scalar
     * @param r2 Money; the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static Money max(final Money r1, final Money r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 Money; the first scalar
     * @param r2 Money; the second scalar
     * @param rn Money...; the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static Money max(final Money r1, final Money r2, final Money... rn)
    {
        Money maxr = (r1.gt(r2)) ? r1 : r2;
        for (Money r : rn)
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
     * @param r1 Money; the first scalar
     * @param r2 Money; the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static Money min(final Money r1, final Money r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 Money; the first scalar
     * @param r2 Money; the second scalar
     * @param rn Money...; the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static Money min(final Money r1, final Money r2, final Money... rn)
    {
        Money minr = (r1.lt(r2)) ? r1 : r2;
        for (Money r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Money and Money, which results in a Dimensionless scalar.
     * @param v Money; Money scalar
     * @return Dimensionless scalar as a division of Money and Money
     */
    public final Dimensionless divideBy(final Money v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Money and Area, which results in a MoneyPerArea scalar.
     * @param v Area; Money scalar
     * @return MoneyPerArea scalar as a division of Money and Area
     */
    public final MoneyPerArea divideBy(final Area v)
    {
        return new MoneyPerArea(this.si / v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of Money and Energy, which results in a MoneyPerEnergy scalar.
     * @param v Energy; Money scalar
     * @return MoneyPerEnergy scalar as a division of Money and Energy
     */
    public final MoneyPerEnergy divideBy(final Energy v)
    {
        return new MoneyPerEnergy(this.si / v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of Money and Length, which results in a MoneyPerLength scalar.
     * @param v Length; Money scalar
     * @return MoneyPerLength scalar as a division of Money and Length
     */
    public final MoneyPerLength divideBy(final Length v)
    {
        return new MoneyPerLength(this.si / v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of Money and LinearDensity, which results in a MoneyPerLength scalar.
     * @param v LinearDensity; Money scalar
     * @return MoneyPerLength scalar as a multiplication of Money and LinearDensity
     */
    public final MoneyPerLength multiplyBy(final LinearDensity v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the division of Money and Mass, which results in a MoneyPerMass scalar.
     * @param v Mass; Money scalar
     * @return MoneyPerMass scalar as a division of Money and Mass
     */
    public final MoneyPerMass divideBy(final Mass v)
    {
        return new MoneyPerMass(this.si / v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the division of Money and Duration, which results in a MoneyPerDuration scalar.
     * @param v Duration; Money scalar
     * @return MoneyPerDuration scalar as a division of Money and Duration
     */
    public final MoneyPerDuration divideBy(final Duration v)
    {
        return new MoneyPerDuration(this.si / v.si, MoneyPerDurationUnit.getStandardMoneyPerDurationUnit());
    }

    /**
     * Calculate the multiplication of Money and Frequency, which results in a MoneyPerDuration scalar.
     * @param v Frequency; Money scalar
     * @return MoneyPerDuration scalar as a multiplication of Money and Frequency
     */
    public final MoneyPerDuration multiplyBy(final Frequency v)
    {
        return new MoneyPerDuration(this.si * v.si, MoneyPerDurationUnit.getStandardMoneyPerDurationUnit());
    }

    /**
     * Calculate the division of Money and Volume, which results in a MoneyPerVolume scalar.
     * @param v Volume; Money scalar
     * @return MoneyPerVolume scalar as a division of Money and Volume
     */
    public final MoneyPerVolume divideBy(final Volume v)
    {
        return new MoneyPerVolume(this.si / v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

}
