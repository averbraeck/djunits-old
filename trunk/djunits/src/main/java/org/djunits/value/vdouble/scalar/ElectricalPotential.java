package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the ElectricalPotential DoubleScalar, which is relative by definition. An example is Money. Instead
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
public class ElectricalPotential extends DoubleScalar.Rel<ElectricalPotentialUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct ElectricalPotential scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalPotential(final double value, final ElectricalPotentialUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalPotential scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalPotential(final DoubleScalar.Rel<ElectricalPotentialUnit> value)
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
    public static ElectricalPotential interpolate(final ElectricalPotential zero, final ElectricalPotential one,
        final double ratio)
    {
        return new ElectricalPotential(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential abs()
    {
        return new ElectricalPotential(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential acos()
    {
        return new ElectricalPotential(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential asin()
    {
        return new ElectricalPotential(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential atan()
    {
        return new ElectricalPotential(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential cbrt()
    {
        return new ElectricalPotential(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential ceil()
    {
        return new ElectricalPotential(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential cos()
    {
        return new ElectricalPotential(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential cosh()
    {
        return new ElectricalPotential(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential exp()
    {
        return new ElectricalPotential(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential expm1()
    {
        return new ElectricalPotential(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential floor()
    {
        return new ElectricalPotential(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential log()
    {
        return new ElectricalPotential(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential log10()
    {
        return new ElectricalPotential(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential log1p()
    {
        return new ElectricalPotential(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential rint()
    {
        return new ElectricalPotential(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential round()
    {
        return new ElectricalPotential(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential signum()
    {
        return new ElectricalPotential(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential sin()
    {
        return new ElectricalPotential(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential sinh()
    {
        return new ElectricalPotential(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential sqrt()
    {
        return new ElectricalPotential(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential tan()
    {
        return new ElectricalPotential(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential tanh()
    {
        return new ElectricalPotential(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential inv()
    {
        return new ElectricalPotential(1.0 / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential toDegrees()
    {
        return new ElectricalPotential(Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential toRadians()
    {
        return new ElectricalPotential(Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential pow(final double x)
    {
        return new ElectricalPotential(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential multiplyBy(final double factor)
    {
        return new ElectricalPotential(getInUnit() * factor, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential divideBy(final double divisor)
    {
        return new ElectricalPotential(getInUnit() / divisor, getUnit());
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final ElectricalPotential plus(final ElectricalPotential v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalPotential(getInUnit() + v.getInUnit(), getUnit())
            : new ElectricalPotential(this.si + v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final ElectricalPotential minus(final ElectricalPotential v)
    {
        return getUnit().equals(v.getUnit()) ? new ElectricalPotential(getInUnit() - v.getInUnit(), getUnit())
            : new ElectricalPotential(this.si - v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalPotential, which results in a Dimensionless scalar.
     * @param v ElectricalPotential scalar
     * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
     */
    public final Dimensionless.Rel divideBy(final ElectricalPotential v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalPotential and ElectricalCurrent, which results in a Power scalar.
     * @param v ElectricalPotential scalar
     * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
     */
    public final Power multiplyBy(final ElectricalCurrent v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalCurrent, which results in a ElectricalResistance scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
     */
    public final ElectricalResistance divideBy(final ElectricalCurrent v)
    {
        return new ElectricalResistance(this.si / v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalResistance, which results in a ElectricalCurrent scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalCurrent scalar as a division of ElectricalPotential and ElectricalResistance
     */
    public final ElectricalCurrent divideBy(final ElectricalResistance v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

}
