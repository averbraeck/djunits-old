package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Length FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatLength
{
    /**
     * Easy access methods for the Length FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;LengthUnit&gt; value = new FloatScalar.Rel&lt;LengthUnit&gt;(100.0, LengthUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatLength.Rel value = new FloatLength.Rel(100.0, LengthUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Rel extends FloatScalar.Rel<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatLength.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final LengthUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatLength.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final LengthUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatLength.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<LengthUnit> value)
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
        public static FloatLength.Rel interpolate(final FloatLength.Rel zero, final FloatLength.Rel one,
            final float ratio)
        {
            return new FloatLength.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatLength.Rel interpolate(final FloatLength.Rel zero, final FloatLength.Rel one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel abs()
        {
            return new FloatLength.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel acos()
        {
            return new FloatLength.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel asin()
        {
            return new FloatLength.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel atan()
        {
            return new FloatLength.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel cbrt()
        {
            return new FloatLength.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel ceil()
        {
            return new FloatLength.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel cos()
        {
            return new FloatLength.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel cosh()
        {
            return new FloatLength.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel exp()
        {
            return new FloatLength.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel expm1()
        {
            return new FloatLength.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel floor()
        {
            return new FloatLength.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel log()
        {
            return new FloatLength.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel log10()
        {
            return new FloatLength.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel log1p()
        {
            return new FloatLength.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel rint()
        {
            return new FloatLength.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel round()
        {
            return new FloatLength.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel signum()
        {
            return new FloatLength.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel sin()
        {
            return new FloatLength.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel sinh()
        {
            return new FloatLength.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel sqrt()
        {
            return new FloatLength.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel tan()
        {
            return new FloatLength.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel tanh()
        {
            return new FloatLength.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel inv()
        {
            return new FloatLength.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel toDegrees()
        {
            return new FloatLength.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel toRadians()
        {
            return new FloatLength.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel pow(final double x)
        {
            return new FloatLength.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel multiplyBy(final float factor)
        {
            return new FloatLength.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative length
         */
        public final FloatLength.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel divideBy(final float divisor)
        {
            return new FloatLength.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative length
         */
        public final FloatLength.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatLength.Rel plus(final FloatLength.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatLength.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FloatLength.Rel(this.si + v.si, LengthUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatLength.Rel minus(final FloatLength.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatLength.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatLength.Rel(this.si - v.si, LengthUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatLength.Abs plus(final FloatLength.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatLength.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatLength.Abs(this.si + v.si, LengthUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative length scalar.
         */
        public final FloatLength.Abs toAbs()
        {
            return new FloatLength.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatLength and FloatLength, which results in a FloatDimensionless scalar.
         * @param v FloatLength scalar
         * @return FloatDimensionless scalar as a division of FloatLength and FloatLength
         */
        public final FloatDimensionless.Rel divideBy(final FloatLength.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLength and FloatLength, which results in a FloatArea scalar.
         * @param v FloatLength scalar
         * @return FloatArea scalar as a multiplication of FloatLength and FloatLength
         */
        public final FloatArea multiplyBy(final FloatLength.Rel v)
        {
            return new FloatArea(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of FloatLength and FloatLinearDensity, which results in a FloatArea scalar.
         * @param v FloatLength scalar
         * @return FloatArea scalar as a division of FloatLength and FloatLinearDensity
         */
        public final FloatArea divideBy(final FloatLinearDensity v)
        {
            return new FloatArea(this.si / v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of FloatLength and FloatArea, which results in a FloatLinearDensity scalar.
         * @param v FloatLength scalar
         * @return FloatLinearDensity scalar as a division of FloatLength and FloatArea
         */
        public final FloatLinearDensity divideBy(final FloatArea v)
        {
            return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLength and FloatArea, which results in a FloatVolume scalar.
         * @param v FloatLength scalar
         * @return FloatVolume scalar as a multiplication of FloatLength and FloatArea
         */
        public final FloatVolume multiplyBy(final FloatArea v)
        {
            return new FloatVolume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLength and FloatForce, which results in a FloatEnergy scalar.
         * @param v FloatLength scalar
         * @return FloatEnergy scalar as a multiplication of FloatLength and FloatForce
         */
        public final FloatEnergy multiplyBy(final FloatForce v)
        {
            return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLength and FloatFrequency, which results in a FloatSpeed scalar.
         * @param v FloatLength scalar
         * @return FloatSpeed scalar as a multiplication of FloatLength and FloatFrequency
         */
        public final FloatSpeed multiplyBy(final FloatFrequency v)
        {
            return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of FloatLength and FloatTime, which results in a FloatSpeed scalar.
         * @param v FloatLength scalar
         * @return FloatSpeed scalar as a division of FloatLength and FloatTime
         */
        public final FloatSpeed divideBy(final FloatTime.Rel v)
        {
            return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of FloatLength and FloatSpeed, which results in a FloatTime scalar.
         * @param v FloatLength scalar
         * @return FloatTime scalar as a division of FloatLength and FloatSpeed
         */
        public final FloatTime.Rel divideBy(final FloatSpeed v)
        {
            return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLength and FloatMoneyPerLength, which results in a FloatMoney scalar.
         * @param v FloatLength scalar
         * @return FloatMoney scalar as a multiplication of FloatLength and FloatMoneyPerLength
         */
        public final FloatMoney multiplyBy(final FloatMoneyPerLength v)
        {
            return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Length FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;LengthUnit&gt; value = new FloatScalar.Abs&lt;LengthUnit&gt;(100.0, LengthUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatLength.Abs value = new FloatLength.Abs(100.0, LengthUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Abs extends FloatScalar.Abs<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatLength.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final LengthUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatLength.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final LengthUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatLength.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<LengthUnit> value)
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
        public static FloatLength.Abs interpolate(final FloatLength.Abs zero, final FloatLength.Abs one,
            final float ratio)
        {
            return new FloatLength.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatLength.Abs interpolate(final FloatLength.Abs zero, final FloatLength.Abs one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs abs()
        {
            return new FloatLength.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs acos()
        {
            return new FloatLength.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs asin()
        {
            return new FloatLength.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs atan()
        {
            return new FloatLength.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs cbrt()
        {
            return new FloatLength.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs ceil()
        {
            return new FloatLength.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs cos()
        {
            return new FloatLength.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs cosh()
        {
            return new FloatLength.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs exp()
        {
            return new FloatLength.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs expm1()
        {
            return new FloatLength.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs floor()
        {
            return new FloatLength.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs log()
        {
            return new FloatLength.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs log10()
        {
            return new FloatLength.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs log1p()
        {
            return new FloatLength.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs rint()
        {
            return new FloatLength.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs round()
        {
            return new FloatLength.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs signum()
        {
            return new FloatLength.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs sin()
        {
            return new FloatLength.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs sinh()
        {
            return new FloatLength.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs sqrt()
        {
            return new FloatLength.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs tan()
        {
            return new FloatLength.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs tanh()
        {
            return new FloatLength.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs inv()
        {
            return new FloatLength.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs toDegrees()
        {
            return new FloatLength.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs toRadians()
        {
            return new FloatLength.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs pow(final double x)
        {
            return new FloatLength.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatLength.Abs plus(final FloatLength.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatLength.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatLength.Abs(this.si + v.si, LengthUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatLength.Rel minus(final FloatLength.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatLength.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatLength.Rel(this.si - v.si, LengthUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatLength.Abs minus(final FloatLength.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatLength.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FloatLength.Abs(this.si - v.si, LengthUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute length scalar.
         */
        public final FloatLength.Rel toRel()
        {
            return new FloatLength.Rel(getInUnit(), getUnit());
        }

    }
}
