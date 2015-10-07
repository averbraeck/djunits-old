package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Money DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, MoneyUnit.EUR);</i><br>
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
public class Money extends DoubleScalar.Rel<MoneyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Money scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Money(final double value, final MoneyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Money scalar.
     * @param value Scalar from which to construct this instance
     */
    public Money(final DoubleScalar.Rel<MoneyUnit> value)
    {
        super(value);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Money interpolate(final Money zero, final Money one, final double ratio)
    {
        return new Money(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money abs()
    {
        return new Money(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money acos()
    {
        return new Money(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money asin()
    {
        return new Money(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money atan()
    {
        return new Money(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money cbrt()
    {
        return new Money(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money ceil()
    {
        return new Money(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money cos()
    {
        return new Money(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money cosh()
    {
        return new Money(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money exp()
    {
        return new Money(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money expm1()
    {
        return new Money(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money floor()
    {
        return new Money(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money log()
    {
        return new Money(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money log10()
    {
        return new Money(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money log1p()
    {
        return new Money(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money rint()
    {
        return new Money(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money round()
    {
        return new Money(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money signum()
    {
        return new Money(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money sin()
    {
        return new Money(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money sinh()
    {
        return new Money(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money sqrt()
    {
        return new Money(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money tan()
    {
        return new Money(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money tanh()
    {
        return new Money(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money inv()
    {
        return new Money(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money toDegrees()
    {
        return new Money(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money toRadians()
    {
        return new Money(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money pow(final double x)
    {
        return new Money(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money multiplyBy(final double factor)
    {
        return new Money(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Money divideBy(final double divisor)
    {
        return new Money(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Money plus(final Money v)
    {
        return getUnit().equals(v.getUnit()) ? new Money(getInUnit() + v.getInUnit(), getUnit()) : new Money(this.si
            + v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Money minus(final Money v)
    {
        return getUnit().equals(v.getUnit()) ? new Money(getInUnit() - v.getInUnit(), getUnit()) : new Money(this.si
            - v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of Money and Money, which results in a Dimensionless scalar.
     * @param v Money scalar
     * @return Dimensionless scalar as a division of Money and Money
     */
    public final Dimensionless.Rel divideBy(final Money v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Money and Area, which results in a MoneyPerArea scalar.
     * @param v Money scalar
     * @return MoneyPerArea scalar as a division of Money and Area
     */
    public final MoneyPerArea divideBy(final Area v)
    {
        return new MoneyPerArea(this.si / v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of Money and Energy, which results in a MoneyPerEnergy scalar.
     * @param v Money scalar
     * @return MoneyPerEnergy scalar as a division of Money and Energy
     */
    public final MoneyPerEnergy divideBy(final Energy v)
    {
        return new MoneyPerEnergy(this.si / v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of Money and Length, which results in a MoneyPerLength scalar.
     * @param v Money scalar
     * @return MoneyPerLength scalar as a division of Money and Length
     */
    public final MoneyPerLength divideBy(final Length.Rel v)
    {
        return new MoneyPerLength(this.si / v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of Money and LinearDensity, which results in a MoneyPerLength scalar.
     * @param v Money scalar
     * @return MoneyPerLength scalar as a multiplication of Money and LinearDensity
     */
    public final MoneyPerLength multiplyBy(final LinearDensity v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the division of Money and Mass, which results in a MoneyPerMass scalar.
     * @param v Money scalar
     * @return MoneyPerMass scalar as a division of Money and Mass
     */
    public final MoneyPerMass divideBy(final Mass v)
    {
        return new MoneyPerMass(this.si / v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the division of Money and Time, which results in a MoneyPerTime scalar.
     * @param v Money scalar
     * @return MoneyPerTime scalar as a division of Money and Time
     */
    public final MoneyPerTime divideBy(final Time.Rel v)
    {
        return new MoneyPerTime(this.si / v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the multiplication of Money and Frequency, which results in a MoneyPerTime scalar.
     * @param v Money scalar
     * @return MoneyPerTime scalar as a multiplication of Money and Frequency
     */
    public final MoneyPerTime multiplyBy(final Frequency v)
    {
        return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the division of Money and Volume, which results in a MoneyPerVolume scalar.
     * @param v Money scalar
     * @return MoneyPerVolume scalar as a division of Money and Volume
     */
    public final MoneyPerVolume divideBy(final Volume v)
    {
        return new MoneyPerVolume(this.si / v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

}
