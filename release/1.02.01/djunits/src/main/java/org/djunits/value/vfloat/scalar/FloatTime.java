package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Time FloatScalar. Instead of <br>
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
public interface FloatTime
{
    /**
     * Easy access methods for the Time FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;TimeUnit&gt; value = new FloatScalar.Rel&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatTime.Rel value = new FloatTime.Rel(100.0, TimeUnit.SI);</i><br>
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
    public static class Rel extends FloatScalar.Rel<TimeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatTime.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final TimeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatTime.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final TimeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatTime.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<TimeUnit> value)
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
        public static FloatTime.Rel interpolate(final FloatTime.Rel zero, final FloatTime.Rel one, final float ratio)
        {
            return new FloatTime.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatTime.Rel interpolate(final FloatTime.Rel zero, final FloatTime.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel abs()
        {
            return new FloatTime.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel acos()
        {
            return new FloatTime.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel asin()
        {
            return new FloatTime.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel atan()
        {
            return new FloatTime.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel cbrt()
        {
            return new FloatTime.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel ceil()
        {
            return new FloatTime.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel cos()
        {
            return new FloatTime.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel cosh()
        {
            return new FloatTime.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel exp()
        {
            return new FloatTime.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel expm1()
        {
            return new FloatTime.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel floor()
        {
            return new FloatTime.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel log()
        {
            return new FloatTime.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel log10()
        {
            return new FloatTime.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel log1p()
        {
            return new FloatTime.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel rint()
        {
            return new FloatTime.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel round()
        {
            return new FloatTime.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel signum()
        {
            return new FloatTime.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel sin()
        {
            return new FloatTime.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel sinh()
        {
            return new FloatTime.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel sqrt()
        {
            return new FloatTime.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel tan()
        {
            return new FloatTime.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel tanh()
        {
            return new FloatTime.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel inv()
        {
            return new FloatTime.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel toDegrees()
        {
            return new FloatTime.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel toRadians()
        {
            return new FloatTime.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel pow(final double x)
        {
            return new FloatTime.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel multiplyBy(final float factor)
        {
            return new FloatTime.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative time
         */
        public final FloatTime.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel divideBy(final float divisor)
        {
            return new FloatTime.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative time
         */
        public final FloatTime.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTime.Rel plus(final FloatTime.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTime.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FloatTime.Rel(this.si + v.si, TimeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatTime.Rel minus(final FloatTime.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTime.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatTime.Rel(this.si - v.si, TimeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTime.Abs plus(final FloatTime.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTime.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatTime.Abs(this.si + v.si, TimeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative time scalar.
         */
        public final FloatTime.Abs toAbs()
        {
            return new FloatTime.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatTime and FloatTime, which results in a FloatDimensionless scalar.
         * @param v FloatTime scalar
         * @return FloatDimensionless scalar as a division of FloatTime and FloatTime
         */
        public final FloatDimensionless.Rel divideBy(final FloatTime.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatFrequency, which results in a FloatDimensionless scalar.
         * @param v FloatTime scalar
         * @return FloatDimensionless scalar as a multiplication of FloatTime and FloatFrequency
         */
        public final FloatDimensionless.Rel multiplyBy(final FloatFrequency v)
        {
            return new FloatDimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatElectricalCurrent, which results in a FloatElectricalCharge
         * scalar.
         * @param v FloatTime scalar
         * @return FloatElectricalCharge scalar as a multiplication of FloatTime and FloatElectricalCurrent
         */
        public final FloatElectricalCharge multiplyBy(final FloatElectricalCurrent v)
        {
            return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatFlowMass, which results in a FloatMass scalar.
         * @param v FloatTime scalar
         * @return FloatMass scalar as a multiplication of FloatTime and FloatFlowMass
         */
        public final FloatMass multiplyBy(final FloatFlowMass v)
        {
            return new FloatMass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatFlowVolume, which results in a FloatVolume scalar.
         * @param v FloatTime scalar
         * @return FloatVolume scalar as a multiplication of FloatTime and FloatFlowVolume
         */
        public final FloatVolume multiplyBy(final FloatFlowVolume v)
        {
            return new FloatVolume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatAcceleration, which results in a FloatSpeed scalar.
         * @param v FloatTime scalar
         * @return FloatSpeed scalar as a multiplication of FloatTime and FloatAcceleration
         */
        public final FloatSpeed multiplyBy(final FloatAcceleration v)
        {
            return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatPower, which results in a FloatEnergy scalar.
         * @param v FloatTime scalar
         * @return FloatEnergy scalar as a multiplication of FloatTime and FloatPower
         */
        public final FloatEnergy multiplyBy(final FloatPower v)
        {
            return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatSpeed, which results in a FloatLength scalar.
         * @param v FloatTime scalar
         * @return FloatLength scalar as a multiplication of FloatTime and FloatSpeed
         */
        public final FloatLength.Rel multiplyBy(final FloatSpeed v)
        {
            return new FloatLength.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatMoneyPerTime, which results in a FloatMoney scalar.
         * @param v FloatTime scalar
         * @return FloatMoney scalar as a multiplication of FloatTime and FloatMoneyPerTime
         */
        public final FloatMoney multiplyBy(final FloatMoneyPerTime v)
        {
            return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Time FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;TimeUnit&gt; value = new FloatScalar.Abs&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatTime.Abs value = new FloatTime.Abs(100.0, TimeUnit.SI);</i><br>
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
    public static class Abs extends FloatScalar.Abs<TimeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatTime.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final TimeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatTime.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final TimeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatTime.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<TimeUnit> value)
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
        public static FloatTime.Abs interpolate(final FloatTime.Abs zero, final FloatTime.Abs one, final float ratio)
        {
            return new FloatTime.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatTime.Abs interpolate(final FloatTime.Abs zero, final FloatTime.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs abs()
        {
            return new FloatTime.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs acos()
        {
            return new FloatTime.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs asin()
        {
            return new FloatTime.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs atan()
        {
            return new FloatTime.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs cbrt()
        {
            return new FloatTime.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs ceil()
        {
            return new FloatTime.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs cos()
        {
            return new FloatTime.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs cosh()
        {
            return new FloatTime.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs exp()
        {
            return new FloatTime.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs expm1()
        {
            return new FloatTime.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs floor()
        {
            return new FloatTime.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs log()
        {
            return new FloatTime.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs log10()
        {
            return new FloatTime.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs log1p()
        {
            return new FloatTime.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs rint()
        {
            return new FloatTime.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs round()
        {
            return new FloatTime.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs signum()
        {
            return new FloatTime.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs sin()
        {
            return new FloatTime.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs sinh()
        {
            return new FloatTime.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs sqrt()
        {
            return new FloatTime.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs tan()
        {
            return new FloatTime.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs tanh()
        {
            return new FloatTime.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs inv()
        {
            return new FloatTime.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs toDegrees()
        {
            return new FloatTime.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs toRadians()
        {
            return new FloatTime.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs pow(final double x)
        {
            return new FloatTime.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTime.Abs plus(final FloatTime.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTime.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatTime.Abs(this.si + v.si, TimeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatTime.Rel minus(final FloatTime.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTime.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatTime.Rel(this.si - v.si, TimeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatTime.Abs minus(final FloatTime.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTime.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FloatTime.Abs(this.si - v.si, TimeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute time scalar.
         */
        public final FloatTime.Rel toRel()
        {
            return new FloatTime.Rel(getInUnit(), getUnit());
        }

    }
}
