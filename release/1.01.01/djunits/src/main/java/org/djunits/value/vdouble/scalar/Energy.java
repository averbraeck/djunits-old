package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Energy DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class Energy extends DoubleScalar.Rel<EnergyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Energy scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Energy(final double value, final EnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Energy scalar.
     * @param value Scalar from which to construct this instance
     */
    public Energy(final DoubleScalar.Rel<EnergyUnit> value)
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
    public static Energy interpolate(final Energy zero, final Energy one, final double ratio)
    {
        return new Energy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy abs()
    {
        return new Energy(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy acos()
    {
        return new Energy(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy asin()
    {
        return new Energy(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy atan()
    {
        return new Energy(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy cbrt()
    {
        return new Energy(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy ceil()
    {
        return new Energy(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy cos()
    {
        return new Energy(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy cosh()
    {
        return new Energy(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy exp()
    {
        return new Energy(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy expm1()
    {
        return new Energy(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy floor()
    {
        return new Energy(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy log()
    {
        return new Energy(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy log10()
    {
        return new Energy(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy log1p()
    {
        return new Energy(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy rint()
    {
        return new Energy(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy round()
    {
        return new Energy(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy signum()
    {
        return new Energy(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy sin()
    {
        return new Energy(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy sinh()
    {
        return new Energy(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy sqrt()
    {
        return new Energy(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy tan()
    {
        return new Energy(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy tanh()
    {
        return new Energy(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy inv()
    {
        return new Energy(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy toDegrees()
    {
        return new Energy(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy toRadians()
    {
        return new Energy(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy pow(final double x)
    {
        return new Energy(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy multiplyBy(final double factor)
    {
        return new Energy(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Energy divideBy(final double divisor)
    {
        return new Energy(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Energy plus(final Energy v)
    {
        return getUnit().equals(v.getUnit()) ? new Energy(getInUnit() + v.getInUnit(), getUnit()) : new Energy(this.si
            + v.si, EnergyUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Energy minus(final Energy v)
    {
        return getUnit().equals(v.getUnit()) ? new Energy(getInUnit() - v.getInUnit(), getUnit()) : new Energy(this.si
            - v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Energy and Energy, which results in a Dimensionless scalar.
     * @param v Energy scalar
     * @return Dimensionless scalar as a division of Energy and Energy
     */
    public final Dimensionless.Rel divideBy(final Energy v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Energy and Force, which results in a Length scalar.
     * @param v Energy scalar
     * @return Length scalar as a division of Energy and Force
     */
    public final Length.Rel divideBy(final Force v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Energy and Length, which results in a Force scalar.
     * @param v Energy scalar
     * @return Force scalar as a division of Energy and Length
     */
    public final Force divideBy(final Length.Rel v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and LinearDensity, which results in a Force scalar.
     * @param v Energy scalar
     * @return Force scalar as a multiplication of Energy and LinearDensity
     */
    public final Force multiplyBy(final LinearDensity v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Energy and Time, which results in a Power scalar.
     * @param v Energy scalar
     * @return Power scalar as a division of Energy and Time
     */
    public final Power divideBy(final Time.Rel v)
    {
        return new Power(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Energy and Power, which results in a Time scalar.
     * @param v Energy scalar
     * @return Time scalar as a division of Energy and Power
     */
    public final Time.Rel divideBy(final Power v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of Energy and Volume, which results in a Pressure scalar.
     * @param v Energy scalar
     * @return Pressure scalar as a division of Energy and Volume
     */
    public final Pressure divideBy(final Volume v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and Frequency, which results in a Power scalar.
     * @param v Energy scalar
     * @return Power scalar as a multiplication of Energy and Frequency
     */
    public final Power multiplyBy(final Frequency v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and MoneyPerEnergy, which results in a Money scalar.
     * @param v Energy scalar
     * @return Money scalar as a multiplication of Energy and MoneyPerEnergy
     */
    public final Money multiplyBy(final MoneyPerEnergy v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
