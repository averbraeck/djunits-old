package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Speed FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass.Rel margin = new Mass.Rel(0.2, KILOGRAM);</i><br>
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
public interface Speed extends UNITS
{
    /**
     * Easy access methods for the Speed FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<SpeedUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Speed.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final SpeedUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Speed.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final SpeedUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Speed.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<SpeedUnit> value)
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
        public static Speed.Rel interpolate(final Speed.Rel zero, final Speed.Rel one, final float ratio)
        {
            return new Speed.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Speed.Rel interpolate(final Speed.Rel zero, final Speed.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel abs()
        {
            return new Speed.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel acos()
        {
            return new Speed.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel asin()
        {
            return new Speed.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel atan()
        {
            return new Speed.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel cbrt()
        {
            return new Speed.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel ceil()
        {
            return new Speed.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel cos()
        {
            return new Speed.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel cosh()
        {
            return new Speed.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel exp()
        {
            return new Speed.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel expm1()
        {
            return new Speed.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel floor()
        {
            return new Speed.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel log()
        {
            return new Speed.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel log10()
        {
            return new Speed.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel log1p()
        {
            return new Speed.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel rint()
        {
            return new Speed.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel round()
        {
            return new Speed.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel signum()
        {
            return new Speed.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel sin()
        {
            return new Speed.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel sinh()
        {
            return new Speed.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel sqrt()
        {
            return new Speed.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel tan()
        {
            return new Speed.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel tanh()
        {
            return new Speed.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel inv()
        {
            return new Speed.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel toDegrees()
        {
            return new Speed.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel toRadians()
        {
            return new Speed.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel pow(final double x)
        {
            return new Speed.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel multiplyBy(final float factor)
        {
            return new Speed.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative speed
         */
        public final Speed.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Rel divideBy(final float divisor)
        {
            return new Speed.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative speed
         */
        public final Speed.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Speed.Rel plus(final Speed.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Speed.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Speed.Rel(
                    this.si + v.si, SpeedUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Speed.Rel minus(final Speed.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Speed.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Speed.Rel(
                    this.si - v.si, SpeedUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Speed.Abs plus(final Speed.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Speed.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Speed.Abs(
                    this.si + v.si, SpeedUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative speed scalar.
         */
        public final Speed.Abs toAbs()
        {
            return new Speed.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Speed and Speed, which results in a Dimensionless scalar.
         * @param v Speed scalar
         * @return Dimensionless scalar as a division of Speed and Speed
         */
        public final Dimensionless.Rel divideBy(final Speed.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Area, which results in a FlowVolume scalar.
         * @param v Speed scalar
         * @return FlowVolume scalar as a multiplication of Speed and Area
         */
        public final FlowVolume.Rel multiplyBy(final Area.Rel v)
        {
            return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Force, which results in a Power scalar.
         * @param v Speed scalar
         * @return Power scalar as a multiplication of Speed and Force
         */
        public final Power.Rel multiplyBy(final Force.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Frequency, which results in a Acceleration scalar.
         * @param v Speed scalar
         * @return Acceleration scalar as a multiplication of Speed and Frequency
         */
        public final Acceleration.Rel multiplyBy(final Frequency.Rel v)
        {
            return new Acceleration.Rel(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the division of Speed and Length, which results in a Frequency scalar.
         * @param v Speed scalar
         * @return Frequency scalar as a division of Speed and Length
         */
        public final Frequency.Rel divideBy(final Length.Rel v)
        {
            return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of Speed and Frequency, which results in a Length scalar.
         * @param v Speed scalar
         * @return Length scalar as a division of Speed and Frequency
         */
        public final Length.Rel divideBy(final Frequency.Rel v)
        {
            return new Length.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and LinearDensity, which results in a Frequency scalar.
         * @param v Speed scalar
         * @return Frequency scalar as a multiplication of Speed and LinearDensity
         */
        public final Frequency.Rel multiplyBy(final LinearDensity.Rel v)
        {
            return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Time, which results in a Length scalar.
         * @param v Speed scalar
         * @return Length scalar as a multiplication of Speed and Time
         */
        public final Length.Rel multiplyBy(final Time.Rel v)
        {
            return new Length.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Speed and Time, which results in a Acceleration scalar.
         * @param v Speed scalar
         * @return Acceleration scalar as a division of Speed and Time
         */
        public final Acceleration.Rel divideBy(final Time.Rel v)
        {
            return new Acceleration.Rel(this.si / v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the division of Speed and Acceleration, which results in a Time scalar.
         * @param v Speed scalar
         * @return Time scalar as a division of Speed and Acceleration
         */
        public final Time.Rel divideBy(final Acceleration.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and FlowMass, which results in a Force scalar.
         * @param v Speed scalar
         * @return Force scalar as a multiplication of Speed and FlowMass
         */
        public final Force.Rel multiplyBy(final FlowMass.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

    }

    /**
     * Easy access methods for the Speed FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<SpeedUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Speed.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final SpeedUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Speed.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final SpeedUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Speed.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<SpeedUnit> value)
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
        public static Speed.Abs interpolate(final Speed.Abs zero, final Speed.Abs one, final float ratio)
        {
            return new Speed.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Speed.Abs interpolate(final Speed.Abs zero, final Speed.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs abs()
        {
            return new Speed.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs acos()
        {
            return new Speed.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs asin()
        {
            return new Speed.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs atan()
        {
            return new Speed.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs cbrt()
        {
            return new Speed.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs ceil()
        {
            return new Speed.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs cos()
        {
            return new Speed.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs cosh()
        {
            return new Speed.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs exp()
        {
            return new Speed.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs expm1()
        {
            return new Speed.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs floor()
        {
            return new Speed.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs log()
        {
            return new Speed.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs log10()
        {
            return new Speed.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs log1p()
        {
            return new Speed.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs rint()
        {
            return new Speed.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs round()
        {
            return new Speed.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs signum()
        {
            return new Speed.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs sin()
        {
            return new Speed.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs sinh()
        {
            return new Speed.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs sqrt()
        {
            return new Speed.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs tan()
        {
            return new Speed.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs tanh()
        {
            return new Speed.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs inv()
        {
            return new Speed.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs toDegrees()
        {
            return new Speed.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs toRadians()
        {
            return new Speed.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs pow(final double x)
        {
            return new Speed.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs multiplyBy(final float factor)
        {
            return new Speed.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute speed
         */
        public final Speed.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Speed.Abs divideBy(final float divisor)
        {
            return new Speed.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute speed
         */
        public final Speed.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Speed.Abs plus(final Speed.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Speed.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Speed.Abs(
                    this.si + v.si, SpeedUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Speed.Rel minus(final Speed.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Speed.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Speed.Rel(
                    this.si - v.si, SpeedUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Speed.Abs minus(final Speed.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Speed.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Speed.Abs(
                    this.si - v.si, SpeedUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute speed scalar.
         */
        public final Speed.Rel toRel()
        {
            return new Speed.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Speed and Speed, which results in a Dimensionless scalar.
         * @param v Speed scalar
         * @return Dimensionless scalar as a division of Speed and Speed
         */
        public final Dimensionless.Abs divideBy(final Speed.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Area, which results in a FlowVolume scalar.
         * @param v Speed scalar
         * @return FlowVolume scalar as a multiplication of Speed and Area
         */
        public final FlowVolume.Abs multiplyBy(final Area.Abs v)
        {
            return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Force, which results in a Power scalar.
         * @param v Speed scalar
         * @return Power scalar as a multiplication of Speed and Force
         */
        public final Power.Abs multiplyBy(final Force.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Frequency, which results in a Acceleration scalar.
         * @param v Speed scalar
         * @return Acceleration scalar as a multiplication of Speed and Frequency
         */
        public final Acceleration.Abs multiplyBy(final Frequency.Abs v)
        {
            return new Acceleration.Abs(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the division of Speed and Length, which results in a Frequency scalar.
         * @param v Speed scalar
         * @return Frequency scalar as a division of Speed and Length
         */
        public final Frequency.Abs divideBy(final Length.Abs v)
        {
            return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of Speed and Frequency, which results in a Length scalar.
         * @param v Speed scalar
         * @return Length scalar as a division of Speed and Frequency
         */
        public final Length.Abs divideBy(final Frequency.Abs v)
        {
            return new Length.Abs(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and LinearDensity, which results in a Frequency scalar.
         * @param v Speed scalar
         * @return Frequency scalar as a multiplication of Speed and LinearDensity
         */
        public final Frequency.Abs multiplyBy(final LinearDensity.Abs v)
        {
            return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and Time, which results in a Length scalar.
         * @param v Speed scalar
         * @return Length scalar as a multiplication of Speed and Time
         */
        public final Length.Abs multiplyBy(final Time.Abs v)
        {
            return new Length.Abs(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Speed and Time, which results in a Acceleration scalar.
         * @param v Speed scalar
         * @return Acceleration scalar as a division of Speed and Time
         */
        public final Acceleration.Abs divideBy(final Time.Abs v)
        {
            return new Acceleration.Abs(this.si / v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the division of Speed and Acceleration, which results in a Time scalar.
         * @param v Speed scalar
         * @return Time scalar as a division of Speed and Acceleration
         */
        public final Time.Abs divideBy(final Acceleration.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Speed and FlowMass, which results in a Force scalar.
         * @param v Speed scalar
         * @return Force scalar as a multiplication of Speed and FlowMass
         */
        public final Force.Abs multiplyBy(final FlowMass.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

    }
}
