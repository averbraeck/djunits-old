package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Torque FloatScalar. Instead of <br>
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
public interface Torque extends UNITS
{
    /**
     * Easy access methods for the Torque FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<TorqueUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Torque.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final TorqueUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Torque.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final TorqueUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Torque.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<TorqueUnit> value)
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
        public static Torque.Rel interpolate(final Torque.Rel zero, final Torque.Rel one, final float ratio)
        {
            return new Torque.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Torque.Rel interpolate(final Torque.Rel zero, final Torque.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel abs()
        {
            return new Torque.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel acos()
        {
            return new Torque.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel asin()
        {
            return new Torque.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel atan()
        {
            return new Torque.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel cbrt()
        {
            return new Torque.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel ceil()
        {
            return new Torque.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel cos()
        {
            return new Torque.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel cosh()
        {
            return new Torque.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel exp()
        {
            return new Torque.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel expm1()
        {
            return new Torque.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel floor()
        {
            return new Torque.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel log()
        {
            return new Torque.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel log10()
        {
            return new Torque.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel log1p()
        {
            return new Torque.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel rint()
        {
            return new Torque.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel round()
        {
            return new Torque.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel signum()
        {
            return new Torque.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel sin()
        {
            return new Torque.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel sinh()
        {
            return new Torque.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel sqrt()
        {
            return new Torque.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel tan()
        {
            return new Torque.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel tanh()
        {
            return new Torque.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel inv()
        {
            return new Torque.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel toDegrees()
        {
            return new Torque.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel toRadians()
        {
            return new Torque.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel pow(final double x)
        {
            return new Torque.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel multiplyBy(final float factor)
        {
            return new Torque.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative torque
         */
        public final Torque.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Rel divideBy(final float divisor)
        {
            return new Torque.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative torque
         */
        public final Torque.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Torque.Rel plus(final Torque.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Torque.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Torque.Rel(
                    this.si + v.si, TorqueUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Torque.Rel minus(final Torque.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Torque.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Torque.Rel(
                    this.si - v.si, TorqueUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Torque.Abs plus(final Torque.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Torque.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Torque.Abs(
                    this.si + v.si, TorqueUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative torque scalar.
         */
        public final Torque.Abs toAbs()
        {
            return new Torque.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Torque and Torque, which results in a Dimensionless scalar.
         * @param v Torque scalar
         * @return Dimensionless scalar as a division of Torque and Torque
         */
        public final Dimensionless.Rel divideBy(final Torque.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Torque and Force, which results in a Length scalar.
         * @param v Torque scalar
         * @return Length scalar as a division of Torque and Force
         */
        public final Length.Rel divideBy(final Force.Rel v)
        {
            return new Length.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Torque and Length, which results in a Force scalar.
         * @param v Torque scalar
         * @return Force scalar as a division of Torque and Length
         */
        public final Force.Rel divideBy(final Length.Rel v)
        {
            return new Force.Rel(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Torque and LinearDensity, which results in a Force scalar.
         * @param v Torque scalar
         * @return Force scalar as a multiplication of Torque and LinearDensity
         */
        public final Force.Rel multiplyBy(final LinearDensity.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of Torque and Time, which results in a Power scalar.
         * @param v Torque scalar
         * @return Power scalar as a division of Torque and Time
         */
        public final Power.Rel divideBy(final Time.Rel v)
        {
            return new Power.Rel(this.si / v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of Torque and Power, which results in a Time scalar.
         * @param v Torque scalar
         * @return Time scalar as a division of Torque and Power
         */
        public final Time.Rel divideBy(final Power.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Torque and Frequency, which results in a Power scalar.
         * @param v Torque scalar
         * @return Power scalar as a multiplication of Torque and Frequency
         */
        public final Power.Rel multiplyBy(final Frequency.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of Torque and Volume, which results in a Pressure scalar.
         * @param v Torque scalar
         * @return Pressure scalar as a division of Torque and Volume
         */
        public final Pressure.Rel divideBy(final Volume.Rel v)
        {
            return new Pressure.Rel(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the division of Torque and Pressure, which results in a Volume scalar.
         * @param v Torque scalar
         * @return Volume scalar as a division of Torque and Pressure
         */
        public final Volume.Rel divideBy(final Pressure.Rel v)
        {
            return new Volume.Rel(this.si / v.si, VolumeUnit.SI);
        }

    }

    /**
     * Easy access methods for the Torque FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<TorqueUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Torque.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final TorqueUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Torque.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final TorqueUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Torque.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<TorqueUnit> value)
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
        public static Torque.Abs interpolate(final Torque.Abs zero, final Torque.Abs one, final float ratio)
        {
            return new Torque.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Torque.Abs interpolate(final Torque.Abs zero, final Torque.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs abs()
        {
            return new Torque.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs acos()
        {
            return new Torque.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs asin()
        {
            return new Torque.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs atan()
        {
            return new Torque.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs cbrt()
        {
            return new Torque.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs ceil()
        {
            return new Torque.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs cos()
        {
            return new Torque.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs cosh()
        {
            return new Torque.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs exp()
        {
            return new Torque.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs expm1()
        {
            return new Torque.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs floor()
        {
            return new Torque.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs log()
        {
            return new Torque.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs log10()
        {
            return new Torque.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs log1p()
        {
            return new Torque.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs rint()
        {
            return new Torque.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs round()
        {
            return new Torque.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs signum()
        {
            return new Torque.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs sin()
        {
            return new Torque.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs sinh()
        {
            return new Torque.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs sqrt()
        {
            return new Torque.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs tan()
        {
            return new Torque.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs tanh()
        {
            return new Torque.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs inv()
        {
            return new Torque.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs toDegrees()
        {
            return new Torque.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs toRadians()
        {
            return new Torque.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs pow(final double x)
        {
            return new Torque.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs multiplyBy(final float factor)
        {
            return new Torque.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute torque
         */
        public final Torque.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Torque.Abs divideBy(final float divisor)
        {
            return new Torque.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute torque
         */
        public final Torque.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Torque.Abs plus(final Torque.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Torque.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Torque.Abs(
                    this.si + v.si, TorqueUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Torque.Rel minus(final Torque.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Torque.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Torque.Rel(
                    this.si - v.si, TorqueUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Torque.Abs minus(final Torque.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Torque.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Torque.Abs(
                    this.si - v.si, TorqueUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute torque scalar.
         */
        public final Torque.Rel toRel()
        {
            return new Torque.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Torque and Torque, which results in a Dimensionless scalar.
         * @param v Torque scalar
         * @return Dimensionless scalar as a division of Torque and Torque
         */
        public final Dimensionless.Abs divideBy(final Torque.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Torque and Force, which results in a Length scalar.
         * @param v Torque scalar
         * @return Length scalar as a division of Torque and Force
         */
        public final Length.Abs divideBy(final Force.Abs v)
        {
            return new Length.Abs(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Torque and Length, which results in a Force scalar.
         * @param v Torque scalar
         * @return Force scalar as a division of Torque and Length
         */
        public final Force.Abs divideBy(final Length.Abs v)
        {
            return new Force.Abs(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Torque and LinearDensity, which results in a Force scalar.
         * @param v Torque scalar
         * @return Force scalar as a multiplication of Torque and LinearDensity
         */
        public final Force.Abs multiplyBy(final LinearDensity.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of Torque and Time, which results in a Power scalar.
         * @param v Torque scalar
         * @return Power scalar as a division of Torque and Time
         */
        public final Power.Abs divideBy(final Time.Abs v)
        {
            return new Power.Abs(this.si / v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of Torque and Power, which results in a Time scalar.
         * @param v Torque scalar
         * @return Time scalar as a division of Torque and Power
         */
        public final Time.Abs divideBy(final Power.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Torque and Frequency, which results in a Power scalar.
         * @param v Torque scalar
         * @return Power scalar as a multiplication of Torque and Frequency
         */
        public final Power.Abs multiplyBy(final Frequency.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of Torque and Volume, which results in a Pressure scalar.
         * @param v Torque scalar
         * @return Pressure scalar as a division of Torque and Volume
         */
        public final Pressure.Abs divideBy(final Volume.Abs v)
        {
            return new Pressure.Abs(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the division of Torque and Pressure, which results in a Volume scalar.
         * @param v Torque scalar
         * @return Volume scalar as a division of Torque and Pressure
         */
        public final Volume.Abs divideBy(final Pressure.Abs v)
        {
            return new Volume.Abs(this.si / v.si, VolumeUnit.SI);
        }

    }
}
