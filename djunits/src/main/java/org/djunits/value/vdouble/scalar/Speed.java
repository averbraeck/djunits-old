package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Speed DoubleScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SpeedUnit&gt; value = new DoubleScalar.Rel&lt;SpeedUnit&gt;(100.0, SpeedUnit.SI);</i><br>
 * we can now write <br>
 * <i>Speed value = new Speed(100.0, SpeedUnit.SI);</i><br>
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
public class Speed extends DoubleScalar.Rel<SpeedUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Speed scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Speed(final double value, final SpeedUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Speed scalar.
     * @param value Scalar from which to construct this instance
     */
    public Speed(final DoubleScalar.Rel<SpeedUnit> value)
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
    public static Speed interpolate(final Speed zero, final Speed one, final double ratio)
    {
        return new Speed(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed abs()
    {
        return new Speed(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed acos()
    {
        return new Speed(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed asin()
    {
        return new Speed(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed atan()
    {
        return new Speed(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed cbrt()
    {
        return new Speed(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed ceil()
    {
        return new Speed(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed cos()
    {
        return new Speed(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed cosh()
    {
        return new Speed(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed exp()
    {
        return new Speed(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed expm1()
    {
        return new Speed(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed floor()
    {
        return new Speed(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed log()
    {
        return new Speed(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed log10()
    {
        return new Speed(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed log1p()
    {
        return new Speed(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed rint()
    {
        return new Speed(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed round()
    {
        return new Speed(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed signum()
    {
        return new Speed(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed sin()
    {
        return new Speed(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed sinh()
    {
        return new Speed(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed sqrt()
    {
        return new Speed(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed tan()
    {
        return new Speed(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed tanh()
    {
        return new Speed(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed inv()
    {
        return new Speed(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed toDegrees()
    {
        return new Speed(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed toRadians()
    {
        return new Speed(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed pow(final double x)
    {
        return new Speed(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed multiplyBy(final double factor)
    {
        return new Speed(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Speed divideBy(final double divisor)
    {
        return new Speed(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Speed plus(final Speed v)
    {
        return getUnit().equals(v.getUnit()) ? new Speed(getInUnit() + v.getInUnit(), getUnit()) : new Speed(this.si
            + v.si, SpeedUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Speed minus(final Speed v)
    {
        return getUnit().equals(v.getUnit()) ? new Speed(getInUnit() - v.getInUnit(), getUnit()) : new Speed(this.si
            - v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Speed and Speed, which results in a Dimensionless scalar.
     * @param v Speed scalar
     * @return Dimensionless scalar as a division of Speed and Speed
     */
    public final Dimensionless.Rel divideBy(final Speed v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Area, which results in a FlowVolume scalar.
     * @param v Speed scalar
     * @return FlowVolume scalar as a multiplication of Speed and Area
     */
    public final FlowVolume multiplyBy(final Area v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Force, which results in a Power scalar.
     * @param v Speed scalar
     * @return Power scalar as a multiplication of Speed and Force
     */
    public final Power multiplyBy(final Force v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Frequency, which results in a Acceleration scalar.
     * @param v Speed scalar
     * @return Acceleration scalar as a multiplication of Speed and Frequency
     */
    public final Acceleration multiplyBy(final Frequency v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Speed and Length, which results in a Frequency scalar.
     * @param v Speed scalar
     * @return Frequency scalar as a division of Speed and Length
     */
    public final Frequency divideBy(final Length.Rel v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Speed and Frequency, which results in a Length scalar.
     * @param v Speed scalar
     * @return Length scalar as a division of Speed and Frequency
     */
    public final Length.Rel divideBy(final Frequency v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and LinearDensity, which results in a Frequency scalar.
     * @param v Speed scalar
     * @return Frequency scalar as a multiplication of Speed and LinearDensity
     */
    public final Frequency multiplyBy(final LinearDensity v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Time, which results in a Length scalar.
     * @param v Speed scalar
     * @return Length scalar as a multiplication of Speed and Time
     */
    public final Length.Rel multiplyBy(final Time.Rel v)
    {
        return new Length.Rel(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Speed and Time, which results in a Acceleration scalar.
     * @param v Speed scalar
     * @return Acceleration scalar as a division of Speed and Time
     */
    public final Acceleration divideBy(final Time.Rel v)
    {
        return new Acceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Speed and Acceleration, which results in a Time scalar.
     * @param v Speed scalar
     * @return Time scalar as a division of Speed and Acceleration
     */
    public final Time.Rel divideBy(final Acceleration v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and FlowMass, which results in a Force scalar.
     * @param v Speed scalar
     * @return Force scalar as a multiplication of Speed and FlowMass
     */
    public final Force multiplyBy(final FlowMass v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}
