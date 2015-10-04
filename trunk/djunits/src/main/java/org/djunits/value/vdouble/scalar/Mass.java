package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Mass DoubleScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MassUnit&gt; value = new DoubleScalar.Rel&lt;MassUnit&gt;(100.0, MassUnit.SI);</i><br>
 * we can now write <br>
 * <i>Mass value = new Mass(100.0, MassUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Mass extends DoubleScalar.Rel<MassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Mass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Mass(final double value, final MassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Mass scalar.
     * @param value Scalar from which to construct this instance
     */
    public Mass(final DoubleScalar.Rel<MassUnit> value)
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
    public static Mass interpolate(final Mass zero, final Mass one, final double ratio)
    {
        return new Mass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass abs()
    {
        return new Mass(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass acos()
    {
        return new Mass(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass asin()
    {
        return new Mass(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass atan()
    {
        return new Mass(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass cbrt()
    {
        return new Mass(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass ceil()
    {
        return new Mass(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass cos()
    {
        return new Mass(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass cosh()
    {
        return new Mass(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass exp()
    {
        return new Mass(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass expm1()
    {
        return new Mass(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass floor()
    {
        return new Mass(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass log()
    {
        return new Mass(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass log10()
    {
        return new Mass(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass log1p()
    {
        return new Mass(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass rint()
    {
        return new Mass(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass round()
    {
        return new Mass(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass signum()
    {
        return new Mass(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass sin()
    {
        return new Mass(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass sinh()
    {
        return new Mass(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass sqrt()
    {
        return new Mass(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass tan()
    {
        return new Mass(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass tanh()
    {
        return new Mass(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass inv()
    {
        return new Mass(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass toDegrees()
    {
        return new Mass(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass toRadians()
    {
        return new Mass(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass pow(final double x)
    {
        return new Mass(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass multiplyBy(final double factor)
    {
        return new Mass(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mass divideBy(final double divisor)
    {
        return new Mass(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Mass plus(final Mass v)
    {
        return getUnit().equals(v.getUnit()) ? new Mass(getInUnit() + v.getInUnit(), getUnit()) : new Mass(this.si
            + v.si, MassUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Mass minus(final Mass v)
    {
        return getUnit().equals(v.getUnit()) ? new Mass(getInUnit() - v.getInUnit(), getUnit()) : new Mass(this.si
            - v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of Mass and Mass, which results in a Dimensionless scalar.
     * @param v Mass scalar
     * @return Dimensionless scalar as a division of Mass and Mass
     */
    public final Dimensionless.Rel divideBy(final Mass v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Mass and FlowMass, which results in a Time scalar.
     * @param v Mass scalar
     * @return Time scalar as a division of Mass and FlowMass
     */
    public final Time.Rel divideBy(final FlowMass v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of Mass and Time, which results in a FlowMass scalar.
     * @param v Mass scalar
     * @return FlowMass scalar as a division of Mass and Time
     */
    public final FlowMass divideBy(final Time.Rel v)
    {
        return new FlowMass(this.si / v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and Acceleration, which results in a Force scalar.
     * @param v Mass scalar
     * @return Force scalar as a multiplication of Mass and Acceleration
     */
    public final Force multiplyBy(final Acceleration v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and Frequency, which results in a FlowMass scalar.
     * @param v Mass scalar
     * @return FlowMass scalar as a multiplication of Mass and Frequency
     */
    public final FlowMass multiplyBy(final Frequency v)
    {
        return new FlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of Mass and Density, which results in a Volume scalar.
     * @param v Mass scalar
     * @return Volume scalar as a division of Mass and Density
     */
    public final Volume divideBy(final Density v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Mass and Volume, which results in a Density scalar.
     * @param v Mass scalar
     * @return Density scalar as a division of Mass and Volume
     */
    public final Density divideBy(final Volume v)
    {
        return new Density(this.si / v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and MoneyPerMass, which results in a Money scalar.
     * @param v Mass scalar
     * @return Money scalar as a multiplication of Mass and MoneyPerMass
     */
    public final Money multiplyBy(final MoneyPerMass v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
