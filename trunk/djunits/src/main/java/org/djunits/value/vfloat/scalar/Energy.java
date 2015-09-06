package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Energy FloatScalar. Instead of <br>
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
public interface Energy extends UNITS
{
    /**
     * Easy access methods for the Energy FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<EnergyUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Energy.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final EnergyUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Energy.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final EnergyUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Energy.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<EnergyUnit> value)
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
        public static Energy.Rel interpolate(final Energy.Rel zero, final Energy.Rel one, final float ratio)
        {
            return new Energy.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Energy.Rel interpolate(final Energy.Rel zero, final Energy.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel abs()
        {
            return new Energy.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel acos()
        {
            return new Energy.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel asin()
        {
            return new Energy.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel atan()
        {
            return new Energy.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel cbrt()
        {
            return new Energy.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel ceil()
        {
            return new Energy.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel cos()
        {
            return new Energy.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel cosh()
        {
            return new Energy.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel exp()
        {
            return new Energy.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel expm1()
        {
            return new Energy.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel floor()
        {
            return new Energy.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel log()
        {
            return new Energy.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel log10()
        {
            return new Energy.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel log1p()
        {
            return new Energy.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel rint()
        {
            return new Energy.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel round()
        {
            return new Energy.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel signum()
        {
            return new Energy.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel sin()
        {
            return new Energy.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel sinh()
        {
            return new Energy.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel sqrt()
        {
            return new Energy.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel tan()
        {
            return new Energy.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel tanh()
        {
            return new Energy.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel inv()
        {
            return new Energy.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel toDegrees()
        {
            return new Energy.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel toRadians()
        {
            return new Energy.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel pow(final double x)
        {
            return new Energy.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel multiplyBy(final float factor)
        {
            return new Energy.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative energy
         */
        public final Energy.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Rel divideBy(final float divisor)
        {
            return new Energy.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative energy
         */
        public final Energy.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Energy.Rel plus(final Energy.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Energy.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Energy.Rel(
                this.si + v.si, EnergyUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Energy.Rel minus(final Energy.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Energy.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Energy.Rel(
                this.si - v.si, EnergyUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Energy.Abs plus(final Energy.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Energy.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Energy.Abs(
                this.si + v.si, EnergyUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative energy scalar.
         */
        public final Energy.Abs toAbs()
        {
            return new Energy.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Energy and Energy, which results in a Dimensionless scalar.
         * @param v Energy scalar
         * @return Dimensionless scalar as a division of Energy and Energy
         */
        public final Dimensionless.Rel divideBy(final Energy.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Energy and Force, which results in a Length scalar.
         * @param v Energy scalar
         * @return Length scalar as a division of Energy and Force
         */
        public final Length.Rel divideBy(final Force.Rel v)
        {
            return new Length.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Energy and Length, which results in a Force scalar.
         * @param v Energy scalar
         * @return Force scalar as a division of Energy and Length
         */
        public final Force.Rel divideBy(final Length.Rel v)
        {
            return new Force.Rel(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Energy and LinearDensity, which results in a Force scalar.
         * @param v Energy scalar
         * @return Force scalar as a multiplication of Energy and LinearDensity
         */
        public final Force.Rel multiplyBy(final LinearDensity.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of Energy and Time, which results in a Power scalar.
         * @param v Energy scalar
         * @return Power scalar as a division of Energy and Time
         */
        public final Power.Rel divideBy(final Time.Rel v)
        {
            return new Power.Rel(this.si / v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of Energy and Power, which results in a Time scalar.
         * @param v Energy scalar
         * @return Time scalar as a division of Energy and Power
         */
        public final Time.Rel divideBy(final Power.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the division of Energy and Volume, which results in a Pressure scalar.
         * @param v Energy scalar
         * @return Pressure scalar as a division of Energy and Volume
         */
        public final Pressure.Rel divideBy(final Volume.Rel v)
        {
            return new Pressure.Rel(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the multiplication of Energy and Frequency, which results in a Power scalar.
         * @param v Energy scalar
         * @return Power scalar as a multiplication of Energy and Frequency
         */
        public final Power.Rel multiplyBy(final Frequency.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Energy and MoneyPerEnergy, which results in a Money scalar.
         * @param v Energy scalar
         * @return Money scalar as a multiplication of Energy and MoneyPerEnergy
         */
        public final Money multiplyBy(final MoneyPerEnergy v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Energy FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<EnergyUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Energy.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final EnergyUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Energy.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final EnergyUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Energy.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<EnergyUnit> value)
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
        public static Energy.Abs interpolate(final Energy.Abs zero, final Energy.Abs one, final float ratio)
        {
            return new Energy.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Energy.Abs interpolate(final Energy.Abs zero, final Energy.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs abs()
        {
            return new Energy.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs acos()
        {
            return new Energy.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs asin()
        {
            return new Energy.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs atan()
        {
            return new Energy.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs cbrt()
        {
            return new Energy.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs ceil()
        {
            return new Energy.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs cos()
        {
            return new Energy.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs cosh()
        {
            return new Energy.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs exp()
        {
            return new Energy.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs expm1()
        {
            return new Energy.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs floor()
        {
            return new Energy.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs log()
        {
            return new Energy.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs log10()
        {
            return new Energy.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs log1p()
        {
            return new Energy.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs rint()
        {
            return new Energy.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs round()
        {
            return new Energy.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs signum()
        {
            return new Energy.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs sin()
        {
            return new Energy.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs sinh()
        {
            return new Energy.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs sqrt()
        {
            return new Energy.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs tan()
        {
            return new Energy.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs tanh()
        {
            return new Energy.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs inv()
        {
            return new Energy.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs toDegrees()
        {
            return new Energy.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs toRadians()
        {
            return new Energy.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs pow(final double x)
        {
            return new Energy.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs multiplyBy(final float factor)
        {
            return new Energy.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute energy
         */
        public final Energy.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Energy.Abs divideBy(final float divisor)
        {
            return new Energy.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute energy
         */
        public final Energy.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Energy.Abs plus(final Energy.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Energy.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Energy.Abs(
                this.si + v.si, EnergyUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Energy.Rel minus(final Energy.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Energy.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Energy.Rel(
                this.si - v.si, EnergyUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Energy.Abs minus(final Energy.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Energy.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Energy.Abs(
                this.si - v.si, EnergyUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute energy scalar.
         */
        public final Energy.Rel toRel()
        {
            return new Energy.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Energy and Energy, which results in a Dimensionless scalar.
         * @param v Energy scalar
         * @return Dimensionless scalar as a division of Energy and Energy
         */
        public final Dimensionless.Abs divideBy(final Energy.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Energy and Force, which results in a Length scalar.
         * @param v Energy scalar
         * @return Length scalar as a division of Energy and Force
         */
        public final Length.Abs divideBy(final Force.Abs v)
        {
            return new Length.Abs(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Energy and Length, which results in a Force scalar.
         * @param v Energy scalar
         * @return Force scalar as a division of Energy and Length
         */
        public final Force.Abs divideBy(final Length.Abs v)
        {
            return new Force.Abs(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Energy and LinearDensity, which results in a Force scalar.
         * @param v Energy scalar
         * @return Force scalar as a multiplication of Energy and LinearDensity
         */
        public final Force.Abs multiplyBy(final LinearDensity.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of Energy and Time, which results in a Power scalar.
         * @param v Energy scalar
         * @return Power scalar as a division of Energy and Time
         */
        public final Power.Abs divideBy(final Time.Abs v)
        {
            return new Power.Abs(this.si / v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of Energy and Power, which results in a Time scalar.
         * @param v Energy scalar
         * @return Time scalar as a division of Energy and Power
         */
        public final Time.Abs divideBy(final Power.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the division of Energy and Volume, which results in a Pressure scalar.
         * @param v Energy scalar
         * @return Pressure scalar as a division of Energy and Volume
         */
        public final Pressure.Abs divideBy(final Volume.Abs v)
        {
            return new Pressure.Abs(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the multiplication of Energy and Frequency, which results in a Power scalar.
         * @param v Energy scalar
         * @return Power scalar as a multiplication of Energy and Frequency
         */
        public final Power.Abs multiplyBy(final Frequency.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Energy and MoneyPerEnergy, which results in a Money scalar.
         * @param v Energy scalar
         * @return Money scalar as a multiplication of Energy and MoneyPerEnergy
         */
        public final Money multiplyBy(final MoneyPerEnergy v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }
}
