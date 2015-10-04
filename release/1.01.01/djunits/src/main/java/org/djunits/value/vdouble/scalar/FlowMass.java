package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the FlowMass DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class FlowMass extends DoubleScalar.Rel<FlowMassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FlowMass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public FlowMass(final double value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FlowMass(final DoubleScalar.Rel<FlowMassUnit> value)
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
    public static FlowMass interpolate(final FlowMass zero, final FlowMass one, final double ratio)
    {
        return new FlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
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
        return new FlowMass(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass asin()
    {
        return new FlowMass(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass atan()
    {
        return new FlowMass(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass cbrt()
    {
        return new FlowMass(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass ceil()
    {
        return new FlowMass(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass cos()
    {
        return new FlowMass(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass cosh()
    {
        return new FlowMass(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass exp()
    {
        return new FlowMass(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass expm1()
    {
        return new FlowMass(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass floor()
    {
        return new FlowMass(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass log()
    {
        return new FlowMass(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass log10()
    {
        return new FlowMass(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass log1p()
    {
        return new FlowMass(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass rint()
    {
        return new FlowMass(Math.rint(getInUnit()), getUnit());
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
        return new FlowMass(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass sinh()
    {
        return new FlowMass(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass sqrt()
    {
        return new FlowMass(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass tan()
    {
        return new FlowMass(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass tanh()
    {
        return new FlowMass(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass inv()
    {
        return new FlowMass(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass toDegrees()
    {
        return new FlowMass(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass toRadians()
    {
        return new FlowMass(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass pow(final double x)
    {
        return new FlowMass(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass multiplyBy(final double factor)
    {
        return new FlowMass(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMass divideBy(final double divisor)
    {
        return new FlowMass(getInUnit() / divisor, getUnit());
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
