package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalCharge DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
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
public class ElectricalCharge extends DoubleScalar.Rel<ElectricalChargeUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct ElectricalCharge scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalCharge(final double value, final ElectricalChargeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalCharge scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalCharge(final DoubleScalar.Rel<ElectricalChargeUnit> value)
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
    public static ElectricalCharge interpolate(final ElectricalCharge zero, final ElectricalCharge one,
        final double ratio)
    {
        return new ElectricalCharge(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge abs()
    {
        return new ElectricalCharge(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge acos()
    {
        return new ElectricalCharge(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge asin()
    {
        return new ElectricalCharge(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge atan()
    {
        return new ElectricalCharge(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge cbrt()
    {
        return new ElectricalCharge(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge ceil()
    {
        return new ElectricalCharge(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge cos()
    {
        return new ElectricalCharge(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge cosh()
    {
        return new ElectricalCharge(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge exp()
    {
        return new ElectricalCharge(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge expm1()
    {
        return new ElectricalCharge(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge floor()
    {
        return new ElectricalCharge(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge log()
    {
        return new ElectricalCharge(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge log10()
    {
        return new ElectricalCharge(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge log1p()
    {
        return new ElectricalCharge(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge rint()
    {
        return new ElectricalCharge(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge round()
    {
        return new ElectricalCharge(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge signum()
    {
        return new ElectricalCharge(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge sin()
    {
        return new ElectricalCharge(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge sinh()
    {
        return new ElectricalCharge(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge sqrt()
    {
        return new ElectricalCharge(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge tan()
    {
        return new ElectricalCharge(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge tanh()
    {
        return new ElectricalCharge(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge inv()
    {
        return new ElectricalCharge(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge toDegrees()
    {
        return new ElectricalCharge(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge toRadians()
    {
        return new ElectricalCharge(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge pow(final double x)
    {
        return new ElectricalCharge(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge multiplyBy(final double factor)
    {
        return new ElectricalCharge(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge divideBy(final double divisor)
    {
        return new ElectricalCharge(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final ElectricalCharge plus(final ElectricalCharge v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalCharge(getInUnit() + v.getInUnit(), getUnit())
            : new ElectricalCharge(this.si + v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final ElectricalCharge minus(final ElectricalCharge v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalCharge(getInUnit() - v.getInUnit(), getUnit())
            : new ElectricalCharge(this.si - v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the division of ElectricalCharge and ElectricalCharge, which results in a Dimensionless scalar.
     * @param v ElectricalCharge scalar
     * @return Dimensionless scalar as a division of ElectricalCharge and ElectricalCharge
     */
    public final Dimensionless.Rel divideBy(final ElectricalCharge v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of ElectricalCharge and Time, which results in a ElectricalCurrent scalar.
     * @param v ElectricalCharge scalar
     * @return ElectricalCurrent scalar as a division of ElectricalCharge and Time
     */
    public final ElectricalCurrent divideBy(final Time.Rel v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of ElectricalCharge and ElectricalCurrent, which results in a Time scalar.
     * @param v ElectricalCharge scalar
     * @return Time scalar as a division of ElectricalCharge and ElectricalCurrent
     */
    public final Time.Rel divideBy(final ElectricalCurrent v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

}
