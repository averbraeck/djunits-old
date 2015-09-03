package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Time DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface Time extends UNITS
{
    /**
     * Easy access methods for the Time DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
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
    public static class Rel extends DoubleScalar.Rel<TimeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Time.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final TimeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Time.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<TimeUnit> value)
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
        public static Time.Rel interpolate(final Time.Rel zero, final Time.Rel one, final double ratio)
        {
            return new Time.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel abs()
        {
            return new Time.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel acos()
        {
            return new Time.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel asin()
        {
            return new Time.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel atan()
        {
            return new Time.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel cbrt()
        {
            return new Time.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel ceil()
        {
            return new Time.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel cos()
        {
            return new Time.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel cosh()
        {
            return new Time.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel exp()
        {
            return new Time.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel expm1()
        {
            return new Time.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel floor()
        {
            return new Time.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel log()
        {
            return new Time.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel log10()
        {
            return new Time.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel log1p()
        {
            return new Time.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel rint()
        {
            return new Time.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel round()
        {
            return new Time.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel signum()
        {
            return new Time.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel sin()
        {
            return new Time.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel sinh()
        {
            return new Time.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel sqrt()
        {
            return new Time.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel tan()
        {
            return new Time.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel tanh()
        {
            return new Time.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel inv()
        {
            return new Time.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel toDegrees()
        {
            return new Time.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel toRadians()
        {
            return new Time.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel pow(final double x)
        {
            return new Time.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel multiplyBy(final double factor)
        {
            return new Time.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel divideBy(final double divisor)
        {
            return new Time.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Time.Rel plus(final Time.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Time.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Time.Rel(this.si
                    + v.si, TimeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Time.Rel minus(final Time.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Time.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Time.Rel(this.si
                    - v.si, TimeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Time.Abs plus(final Time.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Time.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Time.Abs(this.si
                    + v.si, TimeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative time scalar.
         */
        public final Time.Abs toAbs()
        {
            return new Time.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Time and Time, which results in a Dimensionless scalar.
         * @param v Time scalar
         * @return Dimensionless scalar as a division of Time and Time
         */
        public final Dimensionless.Rel divideBy(final Time.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Frequency, which results in a Dimensionless scalar.
         * @param v Time scalar
         * @return Dimensionless scalar as a multiplication of Time and Frequency
         */
        public final Dimensionless.Rel multiplyBy(final Frequency.Rel v)
        {
            return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and ElectricalCurrent, which results in a ElectricalCharge scalar.
         * @param v Time scalar
         * @return ElectricalCharge scalar as a multiplication of Time and ElectricalCurrent
         */
        public final ElectricalCharge.Rel multiplyBy(final ElectricalCurrent.Rel v)
        {
            return new ElectricalCharge.Rel(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and FlowMass, which results in a Mass scalar.
         * @param v Time scalar
         * @return Mass scalar as a multiplication of Time and FlowMass
         */
        public final Mass.Rel multiplyBy(final FlowMass.Rel v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and FlowVolume, which results in a Volume scalar.
         * @param v Time scalar
         * @return Volume scalar as a multiplication of Time and FlowVolume
         */
        public final Volume.Rel multiplyBy(final FlowVolume.Rel v)
        {
            return new Volume.Rel(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Acceleration, which results in a Speed scalar.
         * @param v Time scalar
         * @return Speed scalar as a multiplication of Time and Acceleration
         */
        public final Speed.Rel multiplyBy(final Acceleration.Rel v)
        {
            return new Speed.Rel(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Power, which results in a Energy scalar.
         * @param v Time scalar
         * @return Energy scalar as a multiplication of Time and Power
         */
        public final Energy.Rel multiplyBy(final Power.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Speed, which results in a Length scalar.
         * @param v Time scalar
         * @return Length scalar as a multiplication of Time and Speed
         */
        public final Length.Rel multiplyBy(final Speed.Rel v)
        {
            return new Length.Rel(this.si * v.si, LengthUnit.SI);
        }

    }

    /**
     * Easy access methods for the Time DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
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
    public static class Abs extends DoubleScalar.Abs<TimeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Time.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final TimeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Time.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<TimeUnit> value)
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
        public static Time.Abs interpolate(final Time.Abs zero, final Time.Abs one, final double ratio)
        {
            return new Time.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs abs()
        {
            return new Time.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs acos()
        {
            return new Time.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs asin()
        {
            return new Time.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs atan()
        {
            return new Time.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs cbrt()
        {
            return new Time.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs ceil()
        {
            return new Time.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs cos()
        {
            return new Time.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs cosh()
        {
            return new Time.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs exp()
        {
            return new Time.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs expm1()
        {
            return new Time.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs floor()
        {
            return new Time.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs log()
        {
            return new Time.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs log10()
        {
            return new Time.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs log1p()
        {
            return new Time.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs rint()
        {
            return new Time.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs round()
        {
            return new Time.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs signum()
        {
            return new Time.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs sin()
        {
            return new Time.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs sinh()
        {
            return new Time.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs sqrt()
        {
            return new Time.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs tan()
        {
            return new Time.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs tanh()
        {
            return new Time.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs inv()
        {
            return new Time.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs toDegrees()
        {
            return new Time.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs toRadians()
        {
            return new Time.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs pow(final double x)
        {
            return new Time.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs multiplyBy(final double factor)
        {
            return new Time.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs divideBy(final double divisor)
        {
            return new Time.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Time.Abs plus(final Time.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Time.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Time.Abs(this.si
                    + v.si, TimeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Time.Rel minus(final Time.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Time.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Time.Rel(this.si
                    - v.si, TimeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Time.Abs minus(final Time.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Time.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Time.Abs(this.si
                    - v.si, TimeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute time scalar.
         */
        public final Time.Rel toRel()
        {
            return new Time.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Time and Time, which results in a Dimensionless scalar.
         * @param v Time scalar
         * @return Dimensionless scalar as a division of Time and Time
         */
        public final Dimensionless.Abs divideBy(final Time.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Frequency, which results in a Dimensionless scalar.
         * @param v Time scalar
         * @return Dimensionless scalar as a multiplication of Time and Frequency
         */
        public final Dimensionless.Abs multiplyBy(final Frequency.Abs v)
        {
            return new Dimensionless.Abs(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and ElectricalCurrent, which results in a ElectricalCharge scalar.
         * @param v Time scalar
         * @return ElectricalCharge scalar as a multiplication of Time and ElectricalCurrent
         */
        public final ElectricalCharge.Abs multiplyBy(final ElectricalCurrent.Abs v)
        {
            return new ElectricalCharge.Abs(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and FlowMass, which results in a Mass scalar.
         * @param v Time scalar
         * @return Mass scalar as a multiplication of Time and FlowMass
         */
        public final Mass.Abs multiplyBy(final FlowMass.Abs v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and FlowVolume, which results in a Volume scalar.
         * @param v Time scalar
         * @return Volume scalar as a multiplication of Time and FlowVolume
         */
        public final Volume.Abs multiplyBy(final FlowVolume.Abs v)
        {
            return new Volume.Abs(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Acceleration, which results in a Speed scalar.
         * @param v Time scalar
         * @return Speed scalar as a multiplication of Time and Acceleration
         */
        public final Speed.Abs multiplyBy(final Acceleration.Abs v)
        {
            return new Speed.Abs(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Power, which results in a Energy scalar.
         * @param v Time scalar
         * @return Energy scalar as a multiplication of Time and Power
         */
        public final Energy.Abs multiplyBy(final Power.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Speed, which results in a Length scalar.
         * @param v Time scalar
         * @return Length scalar as a multiplication of Time and Speed
         */
        public final Length.Abs multiplyBy(final Speed.Abs v)
        {
            return new Length.Abs(this.si * v.si, LengthUnit.SI);
        }

    }
}
