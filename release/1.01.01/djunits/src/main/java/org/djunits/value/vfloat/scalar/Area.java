package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Area FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
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
public class Area extends FloatScalar.Rel<AreaUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Area scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public Area(final float value, final AreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Area scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public Area(final double value, final AreaUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct Area scalar.
     * @param value Scalar from which to construct this instance
     */
    public Area(final FloatScalar.Rel<AreaUnit> value)
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
    public static Area interpolate(final Area zero, final Area one, final float ratio)
    {
        return new Area(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Area interpolate(final Area zero, final Area one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final Area abs()
    {
        return new Area(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area acos()
    {
        return new Area((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area asin()
    {
        return new Area((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area atan()
    {
        return new Area((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area cbrt()
    {
        return new Area((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area ceil()
    {
        return new Area((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area cos()
    {
        return new Area((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area cosh()
    {
        return new Area((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area exp()
    {
        return new Area((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area expm1()
    {
        return new Area((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area floor()
    {
        return new Area((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area log()
    {
        return new Area((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area log10()
    {
        return new Area((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area log1p()
    {
        return new Area((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area rint()
    {
        return new Area((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area round()
    {
        return new Area(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area signum()
    {
        return new Area(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area sin()
    {
        return new Area((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area sinh()
    {
        return new Area((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area sqrt()
    {
        return new Area((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area tan()
    {
        return new Area((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area tanh()
    {
        return new Area((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area inv()
    {
        return new Area(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area toDegrees()
    {
        return new Area((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area toRadians()
    {
        return new Area((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area pow(final double x)
    {
        return new Area((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Area multiplyBy(final float factor)
    {
        return new Area(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative area
     */
    public final Area multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final Area divideBy(final float divisor)
    {
        return new Area(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative area
     */
    public final Area divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Area plus(final Area v)
    {
        return getUnit().equals(v.getUnit()) ? new Area(getInUnit() + v.getInUnit(), getUnit()) : new Area(this.si
            + v.si, AreaUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Area minus(final Area v)
    {
        return getUnit().equals(v.getUnit()) ? new Area(getInUnit() - v.getInUnit(), getUnit()) : new Area(this.si
            - v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of Area and Area, which results in a Dimensionless scalar.
     * @param v Area scalar
     * @return Dimensionless scalar as a division of Area and Area
     */
    public final Dimensionless.Rel divideBy(final Area v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and Length, which results in a Volume scalar.
     * @param v Area scalar
     * @return Volume scalar as a multiplication of Area and Length
     */
    public final Volume multiplyBy(final Length.Rel v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Area and LinearDensity, which results in a Volume scalar.
     * @param v Area scalar
     * @return Volume scalar as a division of Area and LinearDensity
     */
    public final Volume divideBy(final LinearDensity v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Area and Volume, which results in a LinearDensity scalar.
     * @param v Area scalar
     * @return LinearDensity scalar as a division of Area and Volume
     */
    public final LinearDensity divideBy(final Volume v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of Area and Length, which results in a Length scalar.
     * @param v Area scalar
     * @return Length scalar as a division of Area and Length
     */
    public final Length.Rel divideBy(final Length.Rel v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and LinearDensity, which results in a Length scalar.
     * @param v Area scalar
     * @return Length scalar as a multiplication of Area and LinearDensity
     */
    public final Length.Rel multiplyBy(final LinearDensity v)
    {
        return new Length.Rel(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and Speed, which results in a FlowVolume scalar.
     * @param v Area scalar
     * @return FlowVolume scalar as a multiplication of Area and Speed
     */
    public final FlowVolume multiplyBy(final Speed v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and Pressure, which results in a Force scalar.
     * @param v Area scalar
     * @return Force scalar as a multiplication of Area and Pressure
     */
    public final Force multiplyBy(final Pressure v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and MoneyPerArea, which results in a Money scalar.
     * @param v Area scalar
     * @return Money scalar as a multiplication of Area and MoneyPerArea
     */
    public final Money multiplyBy(final MoneyPerArea v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
