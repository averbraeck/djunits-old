package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the FlowVolume DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class FlowVolume extends DoubleScalar.Rel<FlowVolumeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FlowVolume scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public FlowVolume(final double value, final FlowVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FlowVolume(final DoubleScalar.Rel<FlowVolumeUnit> value)
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
    public static FlowVolume interpolate(final FlowVolume zero, final FlowVolume one, final double ratio)
    {
        return new FlowVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume abs()
    {
        return new FlowVolume(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume acos()
    {
        return new FlowVolume(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume asin()
    {
        return new FlowVolume(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume atan()
    {
        return new FlowVolume(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume cbrt()
    {
        return new FlowVolume(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume ceil()
    {
        return new FlowVolume(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume cos()
    {
        return new FlowVolume(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume cosh()
    {
        return new FlowVolume(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume exp()
    {
        return new FlowVolume(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume expm1()
    {
        return new FlowVolume(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume floor()
    {
        return new FlowVolume(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume log()
    {
        return new FlowVolume(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume log10()
    {
        return new FlowVolume(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume log1p()
    {
        return new FlowVolume(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume rint()
    {
        return new FlowVolume(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume round()
    {
        return new FlowVolume(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume signum()
    {
        return new FlowVolume(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume sin()
    {
        return new FlowVolume(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume sinh()
    {
        return new FlowVolume(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume sqrt()
    {
        return new FlowVolume(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume tan()
    {
        return new FlowVolume(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume tanh()
    {
        return new FlowVolume(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume inv()
    {
        return new FlowVolume(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume toDegrees()
    {
        return new FlowVolume(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume toRadians()
    {
        return new FlowVolume(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume pow(final double x)
    {
        return new FlowVolume(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume multiplyBy(final double factor)
    {
        return new FlowVolume(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume divideBy(final double divisor)
    {
        return new FlowVolume(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FlowVolume plus(final FlowVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FlowVolume(getInUnit() + v.getInUnit(), getUnit()) : new FlowVolume(
            this.si + v.si, FlowVolumeUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FlowVolume minus(final FlowVolume v)
    {
        return getUnit().equals(v.getUnit()) ? new FlowVolume(getInUnit() - v.getInUnit(), getUnit()) : new FlowVolume(
            this.si - v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and FlowVolume, which results in a Dimensionless scalar.
     * @param v FlowVolume scalar
     * @return Dimensionless scalar as a division of FlowVolume and FlowVolume
     */
    public final Dimensionless.Rel divideBy(final FlowVolume v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowVolume and Time, which results in a Volume scalar.
     * @param v FlowVolume scalar
     * @return Volume scalar as a multiplication of FlowVolume and Time
     */
    public final Volume multiplyBy(final Time.Rel v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Frequency, which results in a Volume scalar.
     * @param v FlowVolume scalar
     * @return Volume scalar as a division of FlowVolume and Frequency
     */
    public final Volume divideBy(final Frequency v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Volume, which results in a Frequency scalar.
     * @param v FlowVolume scalar
     * @return Frequency scalar as a division of FlowVolume and Volume
     */
    public final Frequency divideBy(final Volume v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Area, which results in a Speed scalar.
     * @param v FlowVolume scalar
     * @return Speed scalar as a division of FlowVolume and Area
     */
    public final Speed divideBy(final Area v)
    {
        return new Speed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Speed, which results in a Area scalar.
     * @param v FlowVolume scalar
     * @return Area scalar as a division of FlowVolume and Speed
     */
    public final Area divideBy(final Speed v)
    {
        return new Area(this.si / v.si, AreaUnit.SI);
    }

}