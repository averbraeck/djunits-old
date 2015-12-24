package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the AngleSolid DoubleScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>DoubleScalar.Rel&lt;AngleSolidUnit&gt; value = new DoubleScalar.Rel&lt;AngleSolidUnit&gt;(100.0, AngleSolidUnit.SI);</i><br>
 * we can now write <br>
 * <i>AngleSolid value = new AngleSolid(100.0, AngleSolidUnit.SI);</i><br>
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
public class AngleSolid extends DoubleScalar.Rel<AngleSolidUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct AngleSolid scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AngleSolid(final double value, final AngleSolidUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AngleSolid scalar.
     * @param value Scalar from which to construct this instance
     */
    public AngleSolid(final DoubleScalar.Rel<AngleSolidUnit> value)
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
    public static AngleSolid interpolate(final AngleSolid zero, final AngleSolid one, final double ratio)
    {
        return new AngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid abs()
    {
        return new AngleSolid(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid acos()
    {
        return new AngleSolid(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid asin()
    {
        return new AngleSolid(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid atan()
    {
        return new AngleSolid(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid cbrt()
    {
        return new AngleSolid(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid ceil()
    {
        return new AngleSolid(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid cos()
    {
        return new AngleSolid(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid cosh()
    {
        return new AngleSolid(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid exp()
    {
        return new AngleSolid(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid expm1()
    {
        return new AngleSolid(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid floor()
    {
        return new AngleSolid(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid log()
    {
        return new AngleSolid(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid log10()
    {
        return new AngleSolid(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid log1p()
    {
        return new AngleSolid(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid rint()
    {
        return new AngleSolid(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid round()
    {
        return new AngleSolid(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid signum()
    {
        return new AngleSolid(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid sin()
    {
        return new AngleSolid(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid sinh()
    {
        return new AngleSolid(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid sqrt()
    {
        return new AngleSolid(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid tan()
    {
        return new AngleSolid(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid tanh()
    {
        return new AngleSolid(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid inv()
    {
        return new AngleSolid(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid toDegrees()
    {
        return new AngleSolid(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid toRadians()
    {
        return new AngleSolid(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid pow(final double x)
    {
        return new AngleSolid(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid multiplyBy(final double factor)
    {
        return new AngleSolid(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid divideBy(final double divisor)
    {
        return new AngleSolid(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final AngleSolid plus(final AngleSolid v)
    {
        return getUnit().equals(v.getUnit()) ? new AngleSolid(getInUnit() + v.getInUnit(), getUnit()) : new AngleSolid(
            this.si + v.si, AngleSolidUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final AngleSolid minus(final AngleSolid v)
    {
        return getUnit().equals(v.getUnit()) ? new AngleSolid(getInUnit() - v.getInUnit(), getUnit()) : new AngleSolid(
            this.si - v.si, AngleSolidUnit.SI);
    }

    /**
     * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
     * @param v AngleSolid scalar
     * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
     */
    public final Dimensionless.Rel divideBy(final AngleSolid v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

}