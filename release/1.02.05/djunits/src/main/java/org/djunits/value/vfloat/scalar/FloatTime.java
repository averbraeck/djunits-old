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
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
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
    class Rel extends TypedFloatScalarRel<TimeUnit, FloatTime.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatTime.Rel ZERO = new FloatTime.Rel(0.0f, TimeUnit.SI);

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
         * Construct FloatTime.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatTime.Rel value)
        {
            super(value);
        }

        /**
         * Construct FloatTime.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final TimeUnit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTime.Rel instantiateTypeRel(final float value, final TimeUnit unit)
        {
            return new FloatTime.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final FloatTime.Abs instantiateTypeAbs(final float value, final TimeUnit unit)
        {
            return new FloatTime.Abs(value, unit);
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
            return new FloatTime.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTime.Abs plus(final FloatTime.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
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
        public final FloatDimensionless divideBy(final FloatTime.Rel v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatTime and FloatFrequency, which results in a FloatDimensionless scalar.
         * @param v FloatTime scalar
         * @return FloatDimensionless scalar as a multiplication of FloatTime and FloatFrequency
         */
        public final FloatDimensionless multiplyBy(final FloatFrequency v)
        {
            return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
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
    class Abs extends TypedFloatScalarAbs<TimeUnit, FloatTime.Abs, FloatTime.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatTime.Abs ZERO = new FloatTime.Abs(0.0f, TimeUnit.SI);

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
        public Abs(final FloatTime.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTime.Abs instantiateTypeAbs(final float value, final TimeUnit unit)
        {
            return new FloatTime.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTime.Rel instantiateTypeRel(final float value, final TimeUnit unit)
        {
            return new FloatTime.Rel(value, unit);
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
            return new FloatTime.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

    }
}
