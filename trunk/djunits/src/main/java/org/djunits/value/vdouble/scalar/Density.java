package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MassUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Density DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class Density extends DoubleScalar.Rel<DensityUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Density scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Density(final double value, final DensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Density scalar.
     * @param value Scalar from which to construct this instance
     */
    public Density(final DoubleScalar.Rel<DensityUnit> value)
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
    public static Density interpolate(final Density zero, final Density one, final double ratio)
    {
        return new Density(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density abs()
    {
        return new Density(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density acos()
    {
        return new Density(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density asin()
    {
        return new Density(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density atan()
    {
        return new Density(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density cbrt()
    {
        return new Density(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density ceil()
    {
        return new Density(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density cos()
    {
        return new Density(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density cosh()
    {
        return new Density(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density exp()
    {
        return new Density(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density expm1()
    {
        return new Density(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density floor()
    {
        return new Density(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density log()
    {
        return new Density(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density log10()
    {
        return new Density(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density log1p()
    {
        return new Density(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density rint()
    {
        return new Density(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density round()
    {
        return new Density(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density signum()
    {
        return new Density(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density sin()
    {
        return new Density(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density sinh()
    {
        return new Density(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density sqrt()
    {
        return new Density(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density tan()
    {
        return new Density(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density tanh()
    {
        return new Density(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density inv()
    {
        return new Density(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density toDegrees()
    {
        return new Density(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density toRadians()
    {
        return new Density(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density pow(final double x)
    {
        return new Density(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density multiplyBy(final double factor)
    {
        return new Density(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Density divideBy(final double divisor)
    {
        return new Density(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Density plus(final Density v)
    {
        return getUnit().equals(v.getUnit()) ? new Density(getInUnit() + v.getInUnit(), getUnit()) : new Density(
            this.si + v.si, DensityUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final Density minus(final Density v)
    {
        return getUnit().equals(v.getUnit()) ? new Density(getInUnit() - v.getInUnit(), getUnit()) : new Density(
            this.si - v.si, DensityUnit.SI);
    }

    /**
     * Calculate the division of Density and Density, which results in a Dimensionless scalar.
     * @param v Density scalar
     * @return Dimensionless scalar as a division of Density and Density
     */
    public final Dimensionless.Rel divideBy(final Density v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Density and Volume, which results in a Mass scalar.
     * @param v Density scalar
     * @return Mass scalar as a multiplication of Density and Volume
     */
    public final Mass multiplyBy(final Volume v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

}
