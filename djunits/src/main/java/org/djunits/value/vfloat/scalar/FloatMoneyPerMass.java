package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the MoneyPerMass FloatScalar, which is relative by definition. An example is Money. Instead of <br>
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
public class FloatMoneyPerMass extends FloatScalar.Rel<MoneyPerMassUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatMoneyPerMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerMass(final float value, final MoneyPerMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerMass scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatMoneyPerMass(final double value, final MoneyPerMassUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatMoneyPerMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerMass(final FloatScalar.Rel<MoneyPerMassUnit> value)
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
    public static FloatMoneyPerMass interpolate(final FloatMoneyPerMass zero, final FloatMoneyPerMass one, final float ratio)
    {
        return new FloatMoneyPerMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerMass interpolate(final FloatMoneyPerMass zero, final FloatMoneyPerMass one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass abs()
    {
        return new FloatMoneyPerMass(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass acos()
    {
        return new FloatMoneyPerMass((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass asin()
    {
        return new FloatMoneyPerMass((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass atan()
    {
        return new FloatMoneyPerMass((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass cbrt()
    {
        return new FloatMoneyPerMass((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass ceil()
    {
        return new FloatMoneyPerMass((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass cos()
    {
        return new FloatMoneyPerMass((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass cosh()
    {
        return new FloatMoneyPerMass((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass exp()
    {
        return new FloatMoneyPerMass((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass expm1()
    {
        return new FloatMoneyPerMass((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass floor()
    {
        return new FloatMoneyPerMass((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass log()
    {
        return new FloatMoneyPerMass((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass log10()
    {
        return new FloatMoneyPerMass((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass log1p()
    {
        return new FloatMoneyPerMass((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass rint()
    {
        return new FloatMoneyPerMass((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass round()
    {
        return new FloatMoneyPerMass(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass signum()
    {
        return new FloatMoneyPerMass(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass sin()
    {
        return new FloatMoneyPerMass((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass sinh()
    {
        return new FloatMoneyPerMass((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass sqrt()
    {
        return new FloatMoneyPerMass((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass tan()
    {
        return new FloatMoneyPerMass((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass tanh()
    {
        return new FloatMoneyPerMass((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass inv()
    {
        return new FloatMoneyPerMass(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass toDegrees()
    {
        return new FloatMoneyPerMass((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass toRadians()
    {
        return new FloatMoneyPerMass((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass pow(final double x)
    {
        return new FloatMoneyPerMass((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass multiplyBy(final float factor)
    {
        return new FloatMoneyPerMass(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative moneypermass
     */
    public final FloatMoneyPerMass multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMass divideBy(final float divisor)
    {
        return new FloatMoneyPerMass(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative moneypermass
     */
    public final FloatMoneyPerMass divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatMoneyPerMass plus(final FloatMoneyPerMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerMass(getInUnit() + v.getInUnit(), getUnit()) : new FloatMoneyPerMass(this.si
            + v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatMoneyPerMass minus(final FloatMoneyPerMass v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatMoneyPerMass(getInUnit() - v.getInUnit(), getUnit()) : new FloatMoneyPerMass(this.si
            - v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }
        /**
         * Calculate the division of FloatMoneyPerMass and FloatMoneyPerMass, which results in a FloatDimensionless scalar.
         * @param v FloatMoneyPerMass scalar
         * @return FloatDimensionless scalar as a division of FloatMoneyPerMass and FloatMoneyPerMass
         */
        public final FloatDimensionless.Rel divideBy(final FloatMoneyPerMass v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatMoneyPerMass and FloatMass, which results in a FloatMoney scalar.
         * @param v FloatMoneyPerMass scalar
         * @return FloatMoney scalar as a multiplication of FloatMoneyPerMass and FloatMass
         */
        public final FloatMoney multiplyBy(final FloatMass v)
        {
            return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }


}
