package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Force DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class Force extends DoubleScalar.Rel<ForceUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Force scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Force(final double value, final ForceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Force scalar.
     * @param value Scalar from which to construct this instance
     */
    public Force(final DoubleScalar.Rel<ForceUnit> value)
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
    public static Force interpolate(final Force zero, final Force one, final double ratio)
    {
        return new Force(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force abs()
    {
        return new Force(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force acos()
    {
        return new Force(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force asin()
    {
        return new Force(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force atan()
    {
        return new Force(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force cbrt()
    {
        return new Force(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force ceil()
    {
        return new Force(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force cos()
    {
        return new Force(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force cosh()
    {
        return new Force(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force exp()
    {
        return new Force(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force expm1()
    {
        return new Force(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force floor()
    {
        return new Force(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force log()
    {
        return new Force(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force log10()
    {
        return new Force(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force log1p()
    {
        return new Force(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force rint()
    {
        return new Force(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force round()
    {
        return new Force(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force signum()
    {
        return new Force(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force sin()
    {
        return new Force(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force sinh()
    {
        return new Force(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force sqrt()
    {
        return new Force(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force tan()
    {
        return new Force(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force tanh()
    {
        return new Force(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force inv()
    {
        return new Force(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force toDegrees()
    {
        return new Force(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force toRadians()
    {
        return new Force(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force pow(final double x)
    {
        return new Force(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force multiplyBy(final double factor)
    {
        return new Force(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Force divideBy(final double divisor)
    {
        return new Force(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Force plus(final Force v)
    {
        return getUnit().equals(v.getUnit()) ? new Force(getInUnit() + v.getInUnit(), getUnit()) : new Force(this.si
            + v.si, ForceUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Force minus(final Force v)
    {
        return getUnit().equals(v.getUnit()) ? new Force(getInUnit() - v.getInUnit(), getUnit()) : new Force(this.si
            - v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Force and Force, which results in a Dimensionless scalar.
     * @param v Force scalar
     * @return Dimensionless scalar as a division of Force and Force
     */
    public final Dimensionless.Rel divideBy(final Force v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Force and Length, which results in a Energy scalar.
     * @param v Force scalar
     * @return Energy scalar as a multiplication of Force and Length
     */
    public final Energy multiplyBy(final Length.Rel v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Force and LinearDensity, which results in a Energy scalar.
     * @param v Force scalar
     * @return Energy scalar as a division of Force and LinearDensity
     */
    public final Energy divideBy(final LinearDensity v)
    {
        return new Energy(this.si / v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Force and Energy, which results in a LinearDensity scalar.
     * @param v Force scalar
     * @return LinearDensity scalar as a division of Force and Energy
     */
    public final LinearDensity divideBy(final Energy v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Force and Speed, which results in a Power scalar.
     * @param v Force scalar
     * @return Power scalar as a multiplication of Force and Speed
     */
    public final Power multiplyBy(final Speed v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Force and Mass, which results in a Acceleration scalar.
     * @param v Force scalar
     * @return Acceleration scalar as a division of Force and Mass
     */
    public final Acceleration divideBy(final Mass v)
    {
        return new Acceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Force and Acceleration, which results in a Mass scalar.
     * @param v Force scalar
     * @return Mass scalar as a division of Force and Acceleration
     */
    public final Mass divideBy(final Acceleration v)
    {
        return new Mass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of Force and Area, which results in a Pressure scalar.
     * @param v Force scalar
     * @return Pressure scalar as a division of Force and Area
     */
    public final Pressure divideBy(final Area v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of Force and Pressure, which results in a Area scalar.
     * @param v Force scalar
     * @return Area scalar as a division of Force and Pressure
     */
    public final Area divideBy(final Pressure v)
    {
        return new Area(this.si / v.si, AreaUnit.SI);
    }

}
