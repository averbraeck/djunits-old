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
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
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
    class Rel extends TypedFloatScalarRel<LengthUnit, FloatLength.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatLength.Rel ZERO = new FloatLength.Rel(0.0f, LengthUnit.SI);

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
         * Construct FloatLength.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatLength.Rel value)
        {
            super(value);
        }

        /**
         * Construct FloatLength.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final LengthUnit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLength.Rel instantiateTypeRel(final float value, final LengthUnit unit)
        {
            return new FloatLength.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final FloatLength.Abs instantiateTypeAbs(final float value, final LengthUnit unit)
        {
            return new FloatLength.Abs(value, unit);
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
            return new FloatLength.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatLength.Abs plus(final FloatLength.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
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
        public final FloatDimensionless divideBy(final FloatLength.Rel v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
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
    class Abs extends TypedFloatScalarAbs<LengthUnit, FloatLength.Abs, FloatLength.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatLength.Abs ZERO = new FloatLength.Abs(0.0f, LengthUnit.SI);

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
        public Abs(final FloatLength.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLength.Abs instantiateTypeAbs(final float value, final LengthUnit unit)
        {
            return new FloatLength.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLength.Rel instantiateTypeRel(final float value, final LengthUnit unit)
        {
            return new FloatLength.Rel(value, unit);
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
            return new FloatLength.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

    }
}
