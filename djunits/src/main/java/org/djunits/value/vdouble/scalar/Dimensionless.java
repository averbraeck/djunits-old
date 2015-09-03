package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Dimensionless DoubleScalar. Instead of <br>
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
public interface Dimensionless extends UNITS
{
    /**
     * Easy access methods for the Dimensionless DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<DimensionlessUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Dimensionless.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final DimensionlessUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Dimensionless.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<DimensionlessUnit> value)
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
        public static Dimensionless.Rel interpolate(final Dimensionless.Rel zero, final Dimensionless.Rel one,
                final double ratio)
        {
            return new Dimensionless.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel abs()
        {
            return new Dimensionless.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel acos()
        {
            return new Dimensionless.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel asin()
        {
            return new Dimensionless.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel atan()
        {
            return new Dimensionless.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel cbrt()
        {
            return new Dimensionless.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel ceil()
        {
            return new Dimensionless.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel cos()
        {
            return new Dimensionless.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel cosh()
        {
            return new Dimensionless.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel exp()
        {
            return new Dimensionless.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel expm1()
        {
            return new Dimensionless.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel floor()
        {
            return new Dimensionless.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel log()
        {
            return new Dimensionless.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel log10()
        {
            return new Dimensionless.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel log1p()
        {
            return new Dimensionless.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel rint()
        {
            return new Dimensionless.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel round()
        {
            return new Dimensionless.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel signum()
        {
            return new Dimensionless.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel sin()
        {
            return new Dimensionless.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel sinh()
        {
            return new Dimensionless.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel sqrt()
        {
            return new Dimensionless.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel tan()
        {
            return new Dimensionless.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel tanh()
        {
            return new Dimensionless.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel inv()
        {
            return new Dimensionless.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel toDegrees()
        {
            return new Dimensionless.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel toRadians()
        {
            return new Dimensionless.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel pow(final double x)
        {
            return new Dimensionless.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel multiplyBy(final double factor)
        {
            return new Dimensionless.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel divideBy(final double divisor)
        {
            return new Dimensionless.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Dimensionless.Rel plus(final Dimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Dimensionless.Rel(getInUnit() + v.getInUnit(), getUnit())
                    : new Dimensionless.Rel(this.si + v.si, DimensionlessUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Dimensionless.Rel minus(final Dimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Dimensionless.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new Dimensionless.Rel(this.si - v.si, DimensionlessUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Dimensionless.Abs plus(final Dimensionless.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Dimensionless.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new Dimensionless.Abs(this.si + v.si, DimensionlessUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative dimensionless scalar.
         */
        public final Dimensionless.Abs toAbs()
        {
            return new Dimensionless.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
         * @param v Dimensionless scalar
         * @return Dimensionless scalar as a division of Dimensionless and Dimensionless
         */
        public final Dimensionless.Rel divideBy(final Dimensionless.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Acceleration, which results in a Acceleration scalar.
         * @param v Dimensionless scalar
         * @return Acceleration scalar as a multiplication of Dimensionless and Acceleration
         */
        public final Acceleration.Rel multiplyBy(final Acceleration.Rel v)
        {
            return new Acceleration.Rel(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and AnglePlane, which results in a AnglePlane scalar.
         * @param v Dimensionless scalar
         * @return AnglePlane scalar as a multiplication of Dimensionless and AnglePlane
         */
        public final AnglePlane.Rel multiplyBy(final AnglePlane.Rel v)
        {
            return new AnglePlane.Rel(this.si * v.si, AnglePlaneUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and AngleSlope, which results in a AngleSlope scalar.
         * @param v Dimensionless scalar
         * @return AngleSlope scalar as a multiplication of Dimensionless and AngleSlope
         */
        public final AngleSlope.Rel multiplyBy(final AngleSlope.Rel v)
        {
            return new AngleSlope.Rel(this.si * v.si, AngleSlopeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and AngleSolid, which results in a AngleSolid scalar.
         * @param v Dimensionless scalar
         * @return AngleSolid scalar as a multiplication of Dimensionless and AngleSolid
         */
        public final AngleSolid.Rel multiplyBy(final AngleSolid.Rel v)
        {
            return new AngleSolid.Rel(this.si * v.si, AngleSolidUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Area, which results in a Area scalar.
         * @param v Dimensionless scalar
         * @return Area scalar as a multiplication of Dimensionless and Area
         */
        public final Area.Rel multiplyBy(final Area.Rel v)
        {
            return new Area.Rel(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Density, which results in a Density scalar.
         * @param v Dimensionless scalar
         * @return Density scalar as a multiplication of Dimensionless and Density
         */
        public final Density.Rel multiplyBy(final Density.Rel v)
        {
            return new Density.Rel(this.si * v.si, DensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
         * @param v Dimensionless scalar
         * @return Dimensionless scalar as a multiplication of Dimensionless and Dimensionless
         */
        public final Dimensionless.Rel multiplyBy(final Dimensionless.Rel v)
        {
            return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalCharge, which results in a ElectricalCharge scalar.
         * @param v Dimensionless scalar
         * @return ElectricalCharge scalar as a multiplication of Dimensionless and ElectricalCharge
         */
        public final ElectricalCharge.Rel multiplyBy(final ElectricalCharge.Rel v)
        {
            return new ElectricalCharge.Rel(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalCurrent, which results in a ElectricalCurrent scalar.
         * @param v Dimensionless scalar
         * @return ElectricalCurrent scalar as a multiplication of Dimensionless and ElectricalCurrent
         */
        public final ElectricalCurrent.Rel multiplyBy(final ElectricalCurrent.Rel v)
        {
            return new ElectricalCurrent.Rel(this.si * v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalPotential, which results in a ElectricalPotential scalar.
         * @param v Dimensionless scalar
         * @return ElectricalPotential scalar as a multiplication of Dimensionless and ElectricalPotential
         */
        public final ElectricalPotential.Rel multiplyBy(final ElectricalPotential.Rel v)
        {
            return new ElectricalPotential.Rel(this.si * v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalResistance, which results in a ElectricalResistance
         * scalar.
         * @param v Dimensionless scalar
         * @return ElectricalResistance scalar as a multiplication of Dimensionless and ElectricalResistance
         */
        public final ElectricalResistance.Rel multiplyBy(final ElectricalResistance.Rel v)
        {
            return new ElectricalResistance.Rel(this.si * v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Energy, which results in a Energy scalar.
         * @param v Dimensionless scalar
         * @return Energy scalar as a multiplication of Dimensionless and Energy
         */
        public final Energy.Rel multiplyBy(final Energy.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and FlowMass, which results in a FlowMass scalar.
         * @param v Dimensionless scalar
         * @return FlowMass scalar as a multiplication of Dimensionless and FlowMass
         */
        public final FlowMass.Rel multiplyBy(final FlowMass.Rel v)
        {
            return new FlowMass.Rel(this.si * v.si, FlowMassUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and FlowVolume, which results in a FlowVolume scalar.
         * @param v Dimensionless scalar
         * @return FlowVolume scalar as a multiplication of Dimensionless and FlowVolume
         */
        public final FlowVolume.Rel multiplyBy(final FlowVolume.Rel v)
        {
            return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Force, which results in a Force scalar.
         * @param v Dimensionless scalar
         * @return Force scalar as a multiplication of Dimensionless and Force
         */
        public final Force.Rel multiplyBy(final Force.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Frequency, which results in a Frequency scalar.
         * @param v Dimensionless scalar
         * @return Frequency scalar as a multiplication of Dimensionless and Frequency
         */
        public final Frequency.Rel multiplyBy(final Frequency.Rel v)
        {
            return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Length, which results in a Length scalar.
         * @param v Dimensionless scalar
         * @return Length scalar as a multiplication of Dimensionless and Length
         */
        public final Length.Rel multiplyBy(final Length.Rel v)
        {
            return new Length.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and LinearDensity, which results in a LinearDensity scalar.
         * @param v Dimensionless scalar
         * @return LinearDensity scalar as a multiplication of Dimensionless and LinearDensity
         */
        public final LinearDensity.Rel multiplyBy(final LinearDensity.Rel v)
        {
            return new LinearDensity.Rel(this.si * v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Mass, which results in a Mass scalar.
         * @param v Dimensionless scalar
         * @return Mass scalar as a multiplication of Dimensionless and Mass
         */
        public final Mass.Rel multiplyBy(final Mass.Rel v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Power, which results in a Power scalar.
         * @param v Dimensionless scalar
         * @return Power scalar as a multiplication of Dimensionless and Power
         */
        public final Power.Rel multiplyBy(final Power.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Pressure, which results in a Pressure scalar.
         * @param v Dimensionless scalar
         * @return Pressure scalar as a multiplication of Dimensionless and Pressure
         */
        public final Pressure.Rel multiplyBy(final Pressure.Rel v)
        {
            return new Pressure.Rel(this.si * v.si, PressureUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Speed, which results in a Speed scalar.
         * @param v Dimensionless scalar
         * @return Speed scalar as a multiplication of Dimensionless and Speed
         */
        public final Speed.Rel multiplyBy(final Speed.Rel v)
        {
            return new Speed.Rel(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Temperature, which results in a Temperature scalar.
         * @param v Dimensionless scalar
         * @return Temperature scalar as a multiplication of Dimensionless and Temperature
         */
        public final Temperature.Rel multiplyBy(final Temperature.Rel v)
        {
            return new Temperature.Rel(this.si * v.si, TemperatureUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Time, which results in a Time scalar.
         * @param v Dimensionless scalar
         * @return Time scalar as a multiplication of Dimensionless and Time
         */
        public final Time.Rel multiplyBy(final Time.Rel v)
        {
            return new Time.Rel(this.si * v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Torque, which results in a Torque scalar.
         * @param v Dimensionless scalar
         * @return Torque scalar as a multiplication of Dimensionless and Torque
         */
        public final Torque.Rel multiplyBy(final Torque.Rel v)
        {
            return new Torque.Rel(this.si * v.si, TorqueUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Volume, which results in a Volume scalar.
         * @param v Dimensionless scalar
         * @return Volume scalar as a multiplication of Dimensionless and Volume
         */
        public final Volume.Rel multiplyBy(final Volume.Rel v)
        {
            return new Volume.Rel(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and Length, which results in a LinearDensity scalar.
         * @param v Dimensionless scalar
         * @return LinearDensity scalar as a division of Dimensionless and Length
         */
        public final LinearDensity.Rel divideBy(final Length.Rel v)
        {
            return new LinearDensity.Rel(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and LinearDensity, which results in a Length scalar.
         * @param v Dimensionless scalar
         * @return Length scalar as a division of Dimensionless and LinearDensity
         */
        public final Length.Rel divideBy(final LinearDensity.Rel v)
        {
            return new Length.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and Time, which results in a Frequency scalar.
         * @param v Dimensionless scalar
         * @return Frequency scalar as a division of Dimensionless and Time
         */
        public final Frequency.Rel divideBy(final Time.Rel v)
        {
            return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and Frequency, which results in a Time scalar.
         * @param v Dimensionless scalar
         * @return Time scalar as a division of Dimensionless and Frequency
         */
        public final Time.Rel divideBy(final Frequency.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

    }

    /**
     * Easy access methods for the Dimensionless DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<DimensionlessUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Dimensionless.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final DimensionlessUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Dimensionless.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<DimensionlessUnit> value)
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
        public static Dimensionless.Abs interpolate(final Dimensionless.Abs zero, final Dimensionless.Abs one,
                final double ratio)
        {
            return new Dimensionless.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs abs()
        {
            return new Dimensionless.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs acos()
        {
            return new Dimensionless.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs asin()
        {
            return new Dimensionless.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs atan()
        {
            return new Dimensionless.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs cbrt()
        {
            return new Dimensionless.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs ceil()
        {
            return new Dimensionless.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs cos()
        {
            return new Dimensionless.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs cosh()
        {
            return new Dimensionless.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs exp()
        {
            return new Dimensionless.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs expm1()
        {
            return new Dimensionless.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs floor()
        {
            return new Dimensionless.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs log()
        {
            return new Dimensionless.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs log10()
        {
            return new Dimensionless.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs log1p()
        {
            return new Dimensionless.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs rint()
        {
            return new Dimensionless.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs round()
        {
            return new Dimensionless.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs signum()
        {
            return new Dimensionless.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs sin()
        {
            return new Dimensionless.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs sinh()
        {
            return new Dimensionless.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs sqrt()
        {
            return new Dimensionless.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs tan()
        {
            return new Dimensionless.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs tanh()
        {
            return new Dimensionless.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs inv()
        {
            return new Dimensionless.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs toDegrees()
        {
            return new Dimensionless.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs toRadians()
        {
            return new Dimensionless.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs pow(final double x)
        {
            return new Dimensionless.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs multiplyBy(final double factor)
        {
            return new Dimensionless.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs divideBy(final double divisor)
        {
            return new Dimensionless.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Dimensionless.Abs plus(final Dimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Dimensionless.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new Dimensionless.Abs(this.si + v.si, DimensionlessUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Dimensionless.Rel minus(final Dimensionless.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Dimensionless.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new Dimensionless.Rel(this.si - v.si, DimensionlessUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Dimensionless.Abs minus(final Dimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Dimensionless.Abs(getInUnit() - v.getInUnit(), getUnit())
                    : new Dimensionless.Abs(this.si - v.si, DimensionlessUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute dimensionless scalar.
         */
        public final Dimensionless.Rel toRel()
        {
            return new Dimensionless.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
         * @param v Dimensionless scalar
         * @return Dimensionless scalar as a division of Dimensionless and Dimensionless
         */
        public final Dimensionless.Abs divideBy(final Dimensionless.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Acceleration, which results in a Acceleration scalar.
         * @param v Dimensionless scalar
         * @return Acceleration scalar as a multiplication of Dimensionless and Acceleration
         */
        public final Acceleration.Abs multiplyBy(final Acceleration.Abs v)
        {
            return new Acceleration.Abs(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and AnglePlane, which results in a AnglePlane scalar.
         * @param v Dimensionless scalar
         * @return AnglePlane scalar as a multiplication of Dimensionless and AnglePlane
         */
        public final AnglePlane.Abs multiplyBy(final AnglePlane.Abs v)
        {
            return new AnglePlane.Abs(this.si * v.si, AnglePlaneUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and AngleSlope, which results in a AngleSlope scalar.
         * @param v Dimensionless scalar
         * @return AngleSlope scalar as a multiplication of Dimensionless and AngleSlope
         */
        public final AngleSlope.Abs multiplyBy(final AngleSlope.Abs v)
        {
            return new AngleSlope.Abs(this.si * v.si, AngleSlopeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and AngleSolid, which results in a AngleSolid scalar.
         * @param v Dimensionless scalar
         * @return AngleSolid scalar as a multiplication of Dimensionless and AngleSolid
         */
        public final AngleSolid.Abs multiplyBy(final AngleSolid.Abs v)
        {
            return new AngleSolid.Abs(this.si * v.si, AngleSolidUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Area, which results in a Area scalar.
         * @param v Dimensionless scalar
         * @return Area scalar as a multiplication of Dimensionless and Area
         */
        public final Area.Abs multiplyBy(final Area.Abs v)
        {
            return new Area.Abs(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Density, which results in a Density scalar.
         * @param v Dimensionless scalar
         * @return Density scalar as a multiplication of Dimensionless and Density
         */
        public final Density.Abs multiplyBy(final Density.Abs v)
        {
            return new Density.Abs(this.si * v.si, DensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
         * @param v Dimensionless scalar
         * @return Dimensionless scalar as a multiplication of Dimensionless and Dimensionless
         */
        public final Dimensionless.Abs multiplyBy(final Dimensionless.Abs v)
        {
            return new Dimensionless.Abs(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalCharge, which results in a ElectricalCharge scalar.
         * @param v Dimensionless scalar
         * @return ElectricalCharge scalar as a multiplication of Dimensionless and ElectricalCharge
         */
        public final ElectricalCharge.Abs multiplyBy(final ElectricalCharge.Abs v)
        {
            return new ElectricalCharge.Abs(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalCurrent, which results in a ElectricalCurrent scalar.
         * @param v Dimensionless scalar
         * @return ElectricalCurrent scalar as a multiplication of Dimensionless and ElectricalCurrent
         */
        public final ElectricalCurrent.Abs multiplyBy(final ElectricalCurrent.Abs v)
        {
            return new ElectricalCurrent.Abs(this.si * v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalPotential, which results in a ElectricalPotential scalar.
         * @param v Dimensionless scalar
         * @return ElectricalPotential scalar as a multiplication of Dimensionless and ElectricalPotential
         */
        public final ElectricalPotential.Abs multiplyBy(final ElectricalPotential.Abs v)
        {
            return new ElectricalPotential.Abs(this.si * v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and ElectricalResistance, which results in a ElectricalResistance
         * scalar.
         * @param v Dimensionless scalar
         * @return ElectricalResistance scalar as a multiplication of Dimensionless and ElectricalResistance
         */
        public final ElectricalResistance.Abs multiplyBy(final ElectricalResistance.Abs v)
        {
            return new ElectricalResistance.Abs(this.si * v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Energy, which results in a Energy scalar.
         * @param v Dimensionless scalar
         * @return Energy scalar as a multiplication of Dimensionless and Energy
         */
        public final Energy.Abs multiplyBy(final Energy.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and FlowMass, which results in a FlowMass scalar.
         * @param v Dimensionless scalar
         * @return FlowMass scalar as a multiplication of Dimensionless and FlowMass
         */
        public final FlowMass.Abs multiplyBy(final FlowMass.Abs v)
        {
            return new FlowMass.Abs(this.si * v.si, FlowMassUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and FlowVolume, which results in a FlowVolume scalar.
         * @param v Dimensionless scalar
         * @return FlowVolume scalar as a multiplication of Dimensionless and FlowVolume
         */
        public final FlowVolume.Abs multiplyBy(final FlowVolume.Abs v)
        {
            return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Force, which results in a Force scalar.
         * @param v Dimensionless scalar
         * @return Force scalar as a multiplication of Dimensionless and Force
         */
        public final Force.Abs multiplyBy(final Force.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Frequency, which results in a Frequency scalar.
         * @param v Dimensionless scalar
         * @return Frequency scalar as a multiplication of Dimensionless and Frequency
         */
        public final Frequency.Abs multiplyBy(final Frequency.Abs v)
        {
            return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Length, which results in a Length scalar.
         * @param v Dimensionless scalar
         * @return Length scalar as a multiplication of Dimensionless and Length
         */
        public final Length.Abs multiplyBy(final Length.Abs v)
        {
            return new Length.Abs(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and LinearDensity, which results in a LinearDensity scalar.
         * @param v Dimensionless scalar
         * @return LinearDensity scalar as a multiplication of Dimensionless and LinearDensity
         */
        public final LinearDensity.Abs multiplyBy(final LinearDensity.Abs v)
        {
            return new LinearDensity.Abs(this.si * v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Mass, which results in a Mass scalar.
         * @param v Dimensionless scalar
         * @return Mass scalar as a multiplication of Dimensionless and Mass
         */
        public final Mass.Abs multiplyBy(final Mass.Abs v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Power, which results in a Power scalar.
         * @param v Dimensionless scalar
         * @return Power scalar as a multiplication of Dimensionless and Power
         */
        public final Power.Abs multiplyBy(final Power.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Pressure, which results in a Pressure scalar.
         * @param v Dimensionless scalar
         * @return Pressure scalar as a multiplication of Dimensionless and Pressure
         */
        public final Pressure.Abs multiplyBy(final Pressure.Abs v)
        {
            return new Pressure.Abs(this.si * v.si, PressureUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Speed, which results in a Speed scalar.
         * @param v Dimensionless scalar
         * @return Speed scalar as a multiplication of Dimensionless and Speed
         */
        public final Speed.Abs multiplyBy(final Speed.Abs v)
        {
            return new Speed.Abs(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Temperature, which results in a Temperature scalar.
         * @param v Dimensionless scalar
         * @return Temperature scalar as a multiplication of Dimensionless and Temperature
         */
        public final Temperature.Abs multiplyBy(final Temperature.Abs v)
        {
            return new Temperature.Abs(this.si * v.si, TemperatureUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Time, which results in a Time scalar.
         * @param v Dimensionless scalar
         * @return Time scalar as a multiplication of Dimensionless and Time
         */
        public final Time.Abs multiplyBy(final Time.Abs v)
        {
            return new Time.Abs(this.si * v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Torque, which results in a Torque scalar.
         * @param v Dimensionless scalar
         * @return Torque scalar as a multiplication of Dimensionless and Torque
         */
        public final Torque.Abs multiplyBy(final Torque.Abs v)
        {
            return new Torque.Abs(this.si * v.si, TorqueUnit.SI);
        }

        /**
         * Calculate the multiplication of Dimensionless and Volume, which results in a Volume scalar.
         * @param v Dimensionless scalar
         * @return Volume scalar as a multiplication of Dimensionless and Volume
         */
        public final Volume.Abs multiplyBy(final Volume.Abs v)
        {
            return new Volume.Abs(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and Length, which results in a LinearDensity scalar.
         * @param v Dimensionless scalar
         * @return LinearDensity scalar as a division of Dimensionless and Length
         */
        public final LinearDensity.Abs divideBy(final Length.Abs v)
        {
            return new LinearDensity.Abs(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and LinearDensity, which results in a Length scalar.
         * @param v Dimensionless scalar
         * @return Length scalar as a division of Dimensionless and LinearDensity
         */
        public final Length.Abs divideBy(final LinearDensity.Abs v)
        {
            return new Length.Abs(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and Time, which results in a Frequency scalar.
         * @param v Dimensionless scalar
         * @return Frequency scalar as a division of Dimensionless and Time
         */
        public final Frequency.Abs divideBy(final Time.Abs v)
        {
            return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of Dimensionless and Frequency, which results in a Time scalar.
         * @param v Dimensionless scalar
         * @return Time scalar as a division of Dimensionless and Frequency
         */
        public final Time.Abs divideBy(final Frequency.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

    }
}
