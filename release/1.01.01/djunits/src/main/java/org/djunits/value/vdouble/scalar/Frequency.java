package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Frequency DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, EUR);</i><br>
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
public class Frequency extends DoubleScalar.Rel<FrequencyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Frequency scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Frequency(final double value, final FrequencyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Frequency scalar.
     * @param value Scalar from which to construct this instance
     */
    public Frequency(final DoubleScalar.Rel<FrequencyUnit> value)
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
    public static Frequency interpolate(final Frequency zero, final Frequency one, final double ratio)
    {
        return new Frequency(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency abs()
    {
        return new Frequency(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency acos()
    {
        return new Frequency(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency asin()
    {
        return new Frequency(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency atan()
    {
        return new Frequency(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency cbrt()
    {
        return new Frequency(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency ceil()
    {
        return new Frequency(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency cos()
    {
        return new Frequency(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency cosh()
    {
        return new Frequency(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency exp()
    {
        return new Frequency(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency expm1()
    {
        return new Frequency(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency floor()
    {
        return new Frequency(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency log()
    {
        return new Frequency(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency log10()
    {
        return new Frequency(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency log1p()
    {
        return new Frequency(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency rint()
    {
        return new Frequency(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency round()
    {
        return new Frequency(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency signum()
    {
        return new Frequency(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency sin()
    {
        return new Frequency(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency sinh()
    {
        return new Frequency(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency sqrt()
    {
        return new Frequency(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency tan()
    {
        return new Frequency(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency tanh()
    {
        return new Frequency(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency inv()
    {
        return new Frequency(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency toDegrees()
    {
        return new Frequency(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency toRadians()
    {
        return new Frequency(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency pow(final double x)
    {
        return new Frequency(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency multiplyBy(final double factor)
    {
        return new Frequency(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency divideBy(final double divisor)
    {
        return new Frequency(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Frequency plus(final Frequency v)
    {
        return getUnit().equals(v.getUnit()) ? new Frequency(getInUnit() + v.getInUnit(), getUnit()) : new Frequency(
            this.si + v.si, FrequencyUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Frequency minus(final Frequency v)
    {
        return getUnit().equals(v.getUnit()) ? new Frequency(getInUnit() - v.getInUnit(), getUnit()) : new Frequency(
            this.si - v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Frequency and Frequency, which results in a Dimensionless scalar.
     * @param v Frequency scalar
     * @return Dimensionless scalar as a division of Frequency and Frequency
     */
    public final Dimensionless.Rel divideBy(final Frequency v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Time, which results in a Dimensionless scalar.
     * @param v Frequency scalar
     * @return Dimensionless scalar as a multiplication of Frequency and Time
     */
    public final Dimensionless.Rel multiplyBy(final Time.Rel v)
    {
        return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Length, which results in a Speed scalar.
     * @param v Frequency scalar
     * @return Speed scalar as a multiplication of Frequency and Length
     */
    public final Speed multiplyBy(final Length.Rel v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Speed, which results in a Acceleration scalar.
     * @param v Frequency scalar
     * @return Acceleration scalar as a multiplication of Frequency and Speed
     */
    public final Acceleration multiplyBy(final Speed v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Energy, which results in a Power scalar.
     * @param v Frequency scalar
     * @return Power scalar as a multiplication of Frequency and Energy
     */
    public final Power multiplyBy(final Energy v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Money, which results in a MoneyPerTime scalar.
     * @param v Frequency scalar
     * @return MoneyPerTime scalar as a multiplication of Frequency and Money
     */
    public final MoneyPerTime multiplyBy(final Money v)
    {
        return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

}