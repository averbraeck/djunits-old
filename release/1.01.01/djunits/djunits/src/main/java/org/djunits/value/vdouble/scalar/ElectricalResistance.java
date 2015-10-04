package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalResistance DoubleScalar, which is relative by definition. An example is Money. Instead
 * of <br>
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
public class ElectricalResistance extends DoubleScalar.Rel<ElectricalResistanceUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct ElectricalResistance scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalResistance(final double value, final ElectricalResistanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalResistance scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalResistance(final DoubleScalar.Rel<ElectricalResistanceUnit> value)
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
    public static ElectricalResistance interpolate(final ElectricalResistance zero, final ElectricalResistance one,
        final double ratio)
    {
        return new ElectricalResistance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance abs()
    {
        return new ElectricalResistance(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance acos()
    {
        return new ElectricalResistance(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance asin()
    {
        return new ElectricalResistance(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance atan()
    {
        return new ElectricalResistance(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance cbrt()
    {
        return new ElectricalResistance(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance ceil()
    {
        return new ElectricalResistance(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance cos()
    {
        return new ElectricalResistance(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance cosh()
    {
        return new ElectricalResistance(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance exp()
    {
        return new ElectricalResistance(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance expm1()
    {
        return new ElectricalResistance(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance floor()
    {
        return new ElectricalResistance(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance log()
    {
        return new ElectricalResistance(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance log10()
    {
        return new ElectricalResistance(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance log1p()
    {
        return new ElectricalResistance(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance rint()
    {
        return new ElectricalResistance(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance round()
    {
        return new ElectricalResistance(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance signum()
    {
        return new ElectricalResistance(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance sin()
    {
        return new ElectricalResistance(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance sinh()
    {
        return new ElectricalResistance(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance sqrt()
    {
        return new ElectricalResistance(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance tan()
    {
        return new ElectricalResistance(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance tanh()
    {
        return new ElectricalResistance(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance inv()
    {
        return new ElectricalResistance(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance toDegrees()
    {
        return new ElectricalResistance(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance toRadians()
    {
        return new ElectricalResistance(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance pow(final double x)
    {
        return new ElectricalResistance(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance multiplyBy(final double factor)
    {
        return new ElectricalResistance(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance divideBy(final double divisor)
    {
        return new ElectricalResistance(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final ElectricalResistance plus(final ElectricalResistance v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalResistance(getInUnit() + v.getInUnit(), getUnit())
            : new ElectricalResistance(this.si + v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final ElectricalResistance minus(final ElectricalResistance v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalResistance(getInUnit() - v.getInUnit(), getUnit())
            : new ElectricalResistance(this.si - v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of ElectricalResistance and ElectricalResistance, which results in a Dimensionless scalar.
     * @param v ElectricalResistance scalar
     * @return Dimensionless scalar as a division of ElectricalResistance and ElectricalResistance
     */
    public final Dimensionless.Rel divideBy(final ElectricalResistance v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalResistance and ElectricalCurrent, which results in a ElectricalPotential
     * scalar.
     * @param v ElectricalResistance scalar
     * @return ElectricalPotential scalar as a multiplication of ElectricalResistance and ElectricalCurrent
     */
    public final ElectricalPotential multiplyBy(final ElectricalCurrent v)
    {
        return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
