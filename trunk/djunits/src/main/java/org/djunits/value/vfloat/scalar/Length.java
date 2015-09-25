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
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Length
{
    /**
     * Easy access methods for the Length FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;LengthUnit&gt; margin = new FloatScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
     * we can now write <br>
     * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Rel extends FloatScalar.Rel<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Length.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final LengthUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Length.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final LengthUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Length.Rel scalar.
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
        public static Length.Rel interpolate(final Length.Rel zero, final Length.Rel one, final float ratio)
        {
            return new Length.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Length.Rel interpolate(final Length.Rel zero, final Length.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel abs()
        {
            return new Length.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel acos()
        {
            return new Length.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel asin()
        {
            return new Length.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel atan()
        {
            return new Length.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel cbrt()
        {
            return new Length.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel ceil()
        {
            return new Length.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel cos()
        {
            return new Length.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel cosh()
        {
            return new Length.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel exp()
        {
            return new Length.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel expm1()
        {
            return new Length.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel floor()
        {
            return new Length.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel log()
        {
            return new Length.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel log10()
        {
            return new Length.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel log1p()
        {
            return new Length.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel rint()
        {
            return new Length.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel round()
        {
            return new Length.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel signum()
        {
            return new Length.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel sin()
        {
            return new Length.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel sinh()
        {
            return new Length.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel sqrt()
        {
            return new Length.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel tan()
        {
            return new Length.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel tanh()
        {
            return new Length.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel inv()
        {
            return new Length.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel toDegrees()
        {
            return new Length.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel toRadians()
        {
            return new Length.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel pow(final double x)
        {
            return new Length.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel multiplyBy(final float factor)
        {
            return new Length.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative length
         */
        public final Length.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel divideBy(final float divisor)
        {
            return new Length.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative length
         */
        public final Length.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Length.Rel plus(final Length.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Length.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Length.Rel(this.si + v.si, LengthUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Length.Rel minus(final Length.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Length.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Length.Rel(this.si - v.si, LengthUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Length.Abs plus(final Length.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Length.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Length.Abs(this.si + v.si, LengthUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative length scalar.
         */
        public final Length.Abs toAbs()
        {
            return new Length.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Length and Length, which results in a Dimensionless scalar.
         * @param v Length scalar
         * @return Dimensionless scalar as a division of Length and Length
         */
        public final Dimensionless.Rel divideBy(final Length.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Length and Length, which results in a Area scalar.
         * @param v Length scalar
         * @return Area scalar as a multiplication of Length and Length
         */
        public final Area multiplyBy(final Length.Rel v)
        {
            return new Area(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Length and LinearDensity, which results in a Area scalar.
         * @param v Length scalar
         * @return Area scalar as a division of Length and LinearDensity
         */
        public final Area divideBy(final LinearDensity v)
        {
            return new Area(this.si / v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Length and Area, which results in a LinearDensity scalar.
         * @param v Length scalar
         * @return LinearDensity scalar as a division of Length and Area
         */
        public final LinearDensity divideBy(final Area v)
        {
            return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Length and Area, which results in a Volume scalar.
         * @param v Length scalar
         * @return Volume scalar as a multiplication of Length and Area
         */
        public final Volume multiplyBy(final Area v)
        {
            return new Volume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Length and Force, which results in a Energy scalar.
         * @param v Length scalar
         * @return Energy scalar as a multiplication of Length and Force
         */
        public final Energy multiplyBy(final Force v)
        {
            return new Energy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Length and Frequency, which results in a Speed scalar.
         * @param v Length scalar
         * @return Speed scalar as a multiplication of Length and Frequency
         */
        public final Speed multiplyBy(final Frequency v)
        {
            return new Speed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Length and Time, which results in a Speed scalar.
         * @param v Length scalar
         * @return Speed scalar as a division of Length and Time
         */
        public final Speed divideBy(final Time.Rel v)
        {
            return new Speed(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Length and Speed, which results in a Time scalar.
         * @param v Length scalar
         * @return Time scalar as a division of Length and Speed
         */
        public final Time.Rel divideBy(final Speed v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Length and MoneyPerLength, which results in a Money scalar.
         * @param v Length scalar
         * @return Money scalar as a multiplication of Length and MoneyPerLength
         */
        public final Money multiplyBy(final MoneyPerLength v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Length FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;LengthUnit&gt; margin = new FloatScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
     * we can now write <br>
     * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Abs extends FloatScalar.Abs<LengthUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Length.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final LengthUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Length.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final LengthUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Length.Abs scalar.
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
        public static Length.Abs interpolate(final Length.Abs zero, final Length.Abs one, final float ratio)
        {
            return new Length.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Length.Abs interpolate(final Length.Abs zero, final Length.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs abs()
        {
            return new Length.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs acos()
        {
            return new Length.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs asin()
        {
            return new Length.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs atan()
        {
            return new Length.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs cbrt()
        {
            return new Length.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs ceil()
        {
            return new Length.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs cos()
        {
            return new Length.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs cosh()
        {
            return new Length.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs exp()
        {
            return new Length.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs expm1()
        {
            return new Length.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs floor()
        {
            return new Length.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs log()
        {
            return new Length.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs log10()
        {
            return new Length.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs log1p()
        {
            return new Length.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs rint()
        {
            return new Length.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs round()
        {
            return new Length.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs signum()
        {
            return new Length.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs sin()
        {
            return new Length.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs sinh()
        {
            return new Length.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs sqrt()
        {
            return new Length.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs tan()
        {
            return new Length.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs tanh()
        {
            return new Length.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs inv()
        {
            return new Length.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs toDegrees()
        {
            return new Length.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs toRadians()
        {
            return new Length.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs pow(final double x)
        {
            return new Length.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Length.Abs plus(final Length.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Length.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Length.Abs(this.si + v.si, LengthUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Length.Rel minus(final Length.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Length.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Length.Rel(this.si - v.si, LengthUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Length.Abs minus(final Length.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Length.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Length.Abs(this.si - v.si, LengthUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute length scalar.
         */
        public final Length.Rel toRel()
        {
            return new Length.Rel(getInUnit(), getUnit());
        }

    }
}
