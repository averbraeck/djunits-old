package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Torque DoubleScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>DoubleScalar.Rel&lt;TorqueUnit&gt; value = new DoubleScalar.Rel&lt;TorqueUnit&gt;(100.0, TorqueUnit.SI);</i><br>
 * we can now write <br>
 * <i>Torque value = new Torque(100.0, TorqueUnit.SI);</i><br>
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
public class Torque extends DoubleScalar.Rel<TorqueUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Torque scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Torque(final double value, final TorqueUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Torque scalar.
     * @param value Scalar from which to construct this instance
     */
    public Torque(final DoubleScalar.Rel<TorqueUnit> value)
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
    public static Torque interpolate(final Torque zero, final Torque one, final double ratio)
    {
        return new Torque(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque abs()
    {
        return new Torque(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque acos()
    {
        return new Torque(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque asin()
    {
        return new Torque(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque atan()
    {
        return new Torque(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque cbrt()
    {
        return new Torque(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque ceil()
    {
        return new Torque(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque cos()
    {
        return new Torque(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque cosh()
    {
        return new Torque(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque exp()
    {
        return new Torque(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque expm1()
    {
        return new Torque(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque floor()
    {
        return new Torque(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque log()
    {
        return new Torque(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque log10()
    {
        return new Torque(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque log1p()
    {
        return new Torque(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque rint()
    {
        return new Torque(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque round()
    {
        return new Torque(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque signum()
    {
        return new Torque(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque sin()
    {
        return new Torque(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque sinh()
    {
        return new Torque(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque sqrt()
    {
        return new Torque(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque tan()
    {
        return new Torque(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque tanh()
    {
        return new Torque(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque inv()
    {
        return new Torque(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque toDegrees()
    {
        return new Torque(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque toRadians()
    {
        return new Torque(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque pow(final double x)
    {
        return new Torque(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque multiplyBy(final double factor)
    {
        return new Torque(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Torque divideBy(final double divisor)
    {
        return new Torque(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Torque plus(final Torque v)
    {
        return getUnit().equals(v.getUnit()) ? new Torque(getInUnit() + v.getInUnit(), getUnit()) : new Torque(this.si
            + v.si, TorqueUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Torque minus(final Torque v)
    {
        return getUnit().equals(v.getUnit()) ? new Torque(getInUnit() - v.getInUnit(), getUnit()) : new Torque(this.si
            - v.si, TorqueUnit.SI);
    }

    /**
     * Calculate the division of Torque and Torque, which results in a Dimensionless scalar.
     * @param v Torque scalar
     * @return Dimensionless scalar as a division of Torque and Torque
     */
    public final Dimensionless.Rel divideBy(final Torque v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Torque and Force, which results in a Length scalar.
     * @param v Torque scalar
     * @return Length scalar as a division of Torque and Force
     */
    public final Length.Rel divideBy(final Force v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Torque and Length, which results in a Force scalar.
     * @param v Torque scalar
     * @return Force scalar as a division of Torque and Length
     */
    public final Force divideBy(final Length.Rel v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Torque and LinearDensity, which results in a Force scalar.
     * @param v Torque scalar
     * @return Force scalar as a multiplication of Torque and LinearDensity
     */
    public final Force multiplyBy(final LinearDensity v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Torque and Time, which results in a Power scalar.
     * @param v Torque scalar
     * @return Power scalar as a division of Torque and Time
     */
    public final Power divideBy(final Time.Rel v)
    {
        return new Power(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Torque and Power, which results in a Time scalar.
     * @param v Torque scalar
     * @return Time scalar as a division of Torque and Power
     */
    public final Time.Rel divideBy(final Power v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of Torque and Frequency, which results in a Power scalar.
     * @param v Torque scalar
     * @return Power scalar as a multiplication of Torque and Frequency
     */
    public final Power multiplyBy(final Frequency v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Torque and Volume, which results in a Pressure scalar.
     * @param v Torque scalar
     * @return Pressure scalar as a division of Torque and Volume
     */
    public final Pressure divideBy(final Volume v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of Torque and Pressure, which results in a Volume scalar.
     * @param v Torque scalar
     * @return Volume scalar as a division of Torque and Pressure
     */
    public final Volume divideBy(final Pressure v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

}
