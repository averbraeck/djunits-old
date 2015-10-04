package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalCurrent FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class ElectricalCurrent extends FloatScalar.Rel<ElectricalCurrentUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct ElectricalCurrent scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public ElectricalCurrent(final float value, final ElectricalCurrentUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalCurrent scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public ElectricalCurrent(final double value, final ElectricalCurrentUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct ElectricalCurrent scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalCurrent(final FloatScalar.Rel<ElectricalCurrentUnit> value)
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
    public static ElectricalCurrent interpolate(final ElectricalCurrent zero, final ElectricalCurrent one,
        final float ratio)
    {
        return new ElectricalCurrent(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalCurrent interpolate(final ElectricalCurrent zero, final ElectricalCurrent one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent abs()
    {
        return new ElectricalCurrent(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent acos()
    {
        return new ElectricalCurrent((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent asin()
    {
        return new ElectricalCurrent((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent atan()
    {
        return new ElectricalCurrent((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent cbrt()
    {
        return new ElectricalCurrent((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent ceil()
    {
        return new ElectricalCurrent((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent cos()
    {
        return new ElectricalCurrent((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent cosh()
    {
        return new ElectricalCurrent((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent exp()
    {
        return new ElectricalCurrent((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent expm1()
    {
        return new ElectricalCurrent((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent floor()
    {
        return new ElectricalCurrent((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent log()
    {
        return new ElectricalCurrent((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent log10()
    {
        return new ElectricalCurrent((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent log1p()
    {
        return new ElectricalCurrent((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent rint()
    {
        return new ElectricalCurrent((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent round()
    {
        return new ElectricalCurrent(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent signum()
    {
        return new ElectricalCurrent(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent sin()
    {
        return new ElectricalCurrent((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent sinh()
    {
        return new ElectricalCurrent((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent sqrt()
    {
        return new ElectricalCurrent((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent tan()
    {
        return new ElectricalCurrent((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent tanh()
    {
        return new ElectricalCurrent((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent inv()
    {
        return new ElectricalCurrent(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent toDegrees()
    {
        return new ElectricalCurrent((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent toRadians()
    {
        return new ElectricalCurrent((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent pow(final double x)
    {
        return new ElectricalCurrent((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent multiplyBy(final float factor)
    {
        return new ElectricalCurrent(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative electricalcurrent
     */
    public final ElectricalCurrent multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent divideBy(final float divisor)
    {
        return new ElectricalCurrent(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative electricalcurrent
     */
    public final ElectricalCurrent divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final ElectricalCurrent plus(final ElectricalCurrent v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalCurrent(getInUnit() + v.getInUnit(), getUnit())
            : new ElectricalCurrent(this.si + v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final ElectricalCurrent minus(final ElectricalCurrent v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalCurrent(getInUnit() - v.getInUnit(), getUnit())
            : new ElectricalCurrent(this.si - v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of ElectricalCurrent and ElectricalCurrent, which results in a Dimensionless scalar.
     * @param v ElectricalCurrent scalar
     * @return Dimensionless scalar as a division of ElectricalCurrent and ElectricalCurrent
     */
    public final Dimensionless.Rel divideBy(final ElectricalCurrent v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalCurrent and ElectricalPotential, which results in a Power scalar.
     * @param v ElectricalCurrent scalar
     * @return Power scalar as a multiplication of ElectricalCurrent and ElectricalPotential
     */
    public final Power multiplyBy(final ElectricalPotential v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalCurrent and Time, which results in a ElectricalCharge scalar.
     * @param v ElectricalCurrent scalar
     * @return ElectricalCharge scalar as a multiplication of ElectricalCurrent and Time
     */
    public final ElectricalCharge multiplyBy(final Time.Rel v)
    {
        return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalCurrent and ElectricalResistance, which results in a ElectricalPotential
     * scalar.
     * @param v ElectricalCurrent scalar
     * @return ElectricalPotential scalar as a multiplication of ElectricalCurrent and ElectricalResistance
     */
    public final ElectricalPotential multiplyBy(final ElectricalResistance v)
    {
        return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
