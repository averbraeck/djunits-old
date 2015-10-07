package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Money FloatScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>FloatScalar.Rel&lt;MoneyUnit&gt; price = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>FloatMoney price = new FloatMoney(100.0, MoneyUnit.EUR);</i><br>
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
public class FloatMoney extends FloatScalar.Rel<MoneyUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoney scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoney(final float value, final MoneyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoney scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoney(final double value, final MoneyUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoney scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoney(final FloatScalar.Rel<MoneyUnit> value)
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
    public static FloatMoney interpolate(final FloatMoney zero, final FloatMoney one, final float ratio)
    {
        return new FloatMoney(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoney interpolate(final FloatMoney zero, final FloatMoney one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney abs()
    {
        return new FloatMoney(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney acos()
    {
        return new FloatMoney((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney asin()
    {
        return new FloatMoney((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney atan()
    {
        return new FloatMoney((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney cbrt()
    {
        return new FloatMoney((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney ceil()
    {
        return new FloatMoney((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney cos()
    {
        return new FloatMoney((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney cosh()
    {
        return new FloatMoney((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney exp()
    {
        return new FloatMoney((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney expm1()
    {
        return new FloatMoney((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney floor()
    {
        return new FloatMoney((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney log()
    {
        return new FloatMoney((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney log10()
    {
        return new FloatMoney((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney log1p()
    {
        return new FloatMoney((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney rint()
    {
        return new FloatMoney((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney round()
    {
        return new FloatMoney(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney signum()
    {
        return new FloatMoney(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney sin()
    {
        return new FloatMoney((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney sinh()
    {
        return new FloatMoney((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney sqrt()
    {
        return new FloatMoney((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney tan()
    {
        return new FloatMoney((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney tanh()
    {
        return new FloatMoney((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney inv()
    {
        return new FloatMoney(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney toDegrees()
    {
        return new FloatMoney((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney toRadians()
    {
        return new FloatMoney((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney pow(final double x)
    {
        return new FloatMoney((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney multiplyBy(final float factor)
    {
        return new FloatMoney(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative money
     */
    public final FloatMoney multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoney divideBy(final float divisor)
    {
        return new FloatMoney(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative money
     */
    public final FloatMoney divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoney plus(final FloatMoney v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoney(getInUnit() + v.getInUnit(), getUnit()) : new FloatMoney(
            this.si + v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoney minus(final FloatMoney v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoney(getInUnit() - v.getInUnit(), getUnit()) : new FloatMoney(
            this.si - v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatMoney, which results in a FloatDimensionless scalar.
     * @param v FloatMoney scalar
     * @return FloatDimensionless scalar as a division of FloatMoney and FloatMoney
     */
    public final FloatDimensionless.Rel divideBy(final FloatMoney v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatMoney and FloatArea, which results in a FloatMoneyPerArea scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerArea scalar as a division of FloatMoney and FloatArea
     */
    public final FloatMoneyPerArea divideBy(final FloatArea v)
    {
        return new FloatMoneyPerArea(this.si / v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatEnergy, which results in a FloatMoneyPerEnergy scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerEnergy scalar as a division of FloatMoney and FloatEnergy
     */
    public final FloatMoneyPerEnergy divideBy(final FloatEnergy v)
    {
        return new FloatMoneyPerEnergy(this.si / v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatLength, which results in a FloatMoneyPerLength scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerLength scalar as a division of FloatMoney and FloatLength
     */
    public final FloatMoneyPerLength divideBy(final FloatLength.Rel v)
    {
        return new FloatMoneyPerLength(this.si / v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of FloatMoney and FloatLinearDensity, which results in a FloatMoneyPerLength scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerLength scalar as a multiplication of FloatMoney and FloatLinearDensity
     */
    public final FloatMoneyPerLength multiplyBy(final FloatLinearDensity v)
    {
        return new FloatMoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatMass, which results in a FloatMoneyPerMass scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerMass scalar as a division of FloatMoney and FloatMass
     */
    public final FloatMoneyPerMass divideBy(final FloatMass v)
    {
        return new FloatMoneyPerMass(this.si / v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatTime, which results in a FloatMoneyPerTime scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerTime scalar as a division of FloatMoney and FloatTime
     */
    public final FloatMoneyPerTime divideBy(final FloatTime.Rel v)
    {
        return new FloatMoneyPerTime(this.si / v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the multiplication of FloatMoney and FloatFrequency, which results in a FloatMoneyPerTime scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerTime scalar as a multiplication of FloatMoney and FloatFrequency
     */
    public final FloatMoneyPerTime multiplyBy(final FloatFrequency v)
    {
        return new FloatMoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatVolume, which results in a FloatMoneyPerVolume scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerVolume scalar as a division of FloatMoney and FloatVolume
     */
    public final FloatMoneyPerVolume divideBy(final FloatVolume v)
    {
        return new FloatMoneyPerVolume(this.si / v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

}
