package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Pressure DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class Pressure extends DoubleScalar.Rel<PressureUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Pressure scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Pressure(final double value, final PressureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Pressure scalar.
     * @param value Scalar from which to construct this instance
     */
    public Pressure(final DoubleScalar.Rel<PressureUnit> value)
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
    public static Pressure interpolate(final Pressure zero, final Pressure one, final double ratio)
    {
        return new Pressure(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure abs()
    {
        return new Pressure(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure acos()
    {
        return new Pressure(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure asin()
    {
        return new Pressure(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure atan()
    {
        return new Pressure(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure cbrt()
    {
        return new Pressure(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure ceil()
    {
        return new Pressure(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure cos()
    {
        return new Pressure(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure cosh()
    {
        return new Pressure(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure exp()
    {
        return new Pressure(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure expm1()
    {
        return new Pressure(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure floor()
    {
        return new Pressure(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure log()
    {
        return new Pressure(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure log10()
    {
        return new Pressure(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure log1p()
    {
        return new Pressure(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure rint()
    {
        return new Pressure(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure round()
    {
        return new Pressure(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure signum()
    {
        return new Pressure(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure sin()
    {
        return new Pressure(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure sinh()
    {
        return new Pressure(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure sqrt()
    {
        return new Pressure(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure tan()
    {
        return new Pressure(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure tanh()
    {
        return new Pressure(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure inv()
    {
        return new Pressure(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure toDegrees()
    {
        return new Pressure(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure toRadians()
    {
        return new Pressure(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure pow(final double x)
    {
        return new Pressure(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure multiplyBy(final double factor)
    {
        return new Pressure(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure divideBy(final double divisor)
    {
        return new Pressure(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Pressure plus(final Pressure v)
    {
        return getUnit().equals(v.getUnit()) ? new Pressure(getInUnit() + v.getInUnit(), getUnit()) : new Pressure(
            this.si + v.si, PressureUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Pressure minus(final Pressure v)
    {
        return getUnit().equals(v.getUnit()) ? new Pressure(getInUnit() - v.getInUnit(), getUnit()) : new Pressure(
            this.si - v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of Pressure and Pressure, which results in a Dimensionless scalar.
     * @param v Pressure scalar
     * @return Dimensionless scalar as a division of Pressure and Pressure
     */
    public final Dimensionless.Rel divideBy(final Pressure v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Pressure and Area, which results in a Force scalar.
     * @param v Pressure scalar
     * @return Force scalar as a multiplication of Pressure and Area
     */
    public final Force multiplyBy(final Area v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Pressure and Volume, which results in a Energy scalar.
     * @param v Pressure scalar
     * @return Energy scalar as a multiplication of Pressure and Volume
     */
    public final Energy multiplyBy(final Volume v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

}
