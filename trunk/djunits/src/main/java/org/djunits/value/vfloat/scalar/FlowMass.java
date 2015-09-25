package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the FlowMass FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, EUR);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FlowMass extends FloatScalar.Rel<FlowMassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FlowMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FlowMass(final float value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowMass scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FlowMass(final double value, final FlowMassUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FlowMass(final FloatScalar.Rel<FlowMassUnit> value)
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
    public static FlowMass interpolate(final FlowMass zero, final FlowMass one, final float ratio)
    {
        return new FlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FlowMass interpolate(final FlowMass zero, final FlowMass one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass abs()
    {
        return new FlowMass(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass acos()
    {
        return new FlowMass((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass asin()
    {
        return new FlowMass((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass atan()
    {
        return new FlowMass((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass cbrt()
    {
        return new FlowMass((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass ceil()
    {
        return new FlowMass((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass cos()
    {
        return new FlowMass((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass cosh()
    {
        return new FlowMass((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass exp()
    {
        return new FlowMass((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass expm1()
    {
        return new FlowMass((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass floor()
    {
        return new FlowMass((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass log()
    {
        return new FlowMass((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass log10()
    {
        return new FlowMass((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass log1p()
    {
        return new FlowMass((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass rint()
    {
        return new FlowMass((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass round()
    {
        return new FlowMass(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass signum()
    {
        return new FlowMass(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass sin()
    {
        return new FlowMass((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass sinh()
    {
        return new FlowMass((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass sqrt()
    {
        return new FlowMass((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass tan()
    {
        return new FlowMass((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass tanh()
    {
        return new FlowMass((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass inv()
    {
        return new FlowMass(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass toDegrees()
    {
        return new FlowMass((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass toRadians()
    {
        return new FlowMass((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass pow(final double x)
    {
        return new FlowMass((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass multiplyBy(final float factor)
    {
        return new FlowMass(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative flowmass
     */
    public final FlowMass multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass divideBy(final float divisor)
    {
        return new FlowMass(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative flowmass
     */
    public final FlowMass divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FlowMass plus(final FlowMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FlowMass(getInUnit() + v.getInUnit(), getUnit()) : new FlowMass(
            this.si + v.si, FlowMassUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FlowMass minus(final FlowMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FlowMass(getInUnit() - v.getInUnit(), getUnit()) : new FlowMass(
            this.si - v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
     * @param v FlowMass scalar
     * @return Dimensionless scalar as a division of FlowMass and FlowMass
     */
    public final Dimensionless.Rel divideBy(final FlowMass v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Time, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a multiplication of FlowMass and Time
     */
    public final Mass multiplyBy(final Time.Rel v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a division of FlowMass and Frequency
     */
    public final Mass divideBy(final Frequency v)
    {
        return new Mass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
     * @param v FlowMass scalar
     * @return Frequency scalar as a division of FlowMass and Mass
     */
    public final Frequency divideBy(final Mass v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
     * @param v FlowMass scalar
     * @return Force scalar as a multiplication of FlowMass and Speed
     */
    public final Force multiplyBy(final Speed v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}
