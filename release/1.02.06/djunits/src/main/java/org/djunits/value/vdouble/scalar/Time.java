package org.djunits.value.vdouble.scalar;

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
 * Easy access methods for the Time DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface Time
{
    /**
     * Easy access methods for the Relative Time DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;TimeUnit&gt; value = new DoubleScalar.Rel&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
     * we can now write <br>
     * <i>Time.Rel value = new Time.Rel(100.0, TimeUnit.SI);</i><br>
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
    class Rel extends TypedDoubleScalarRel<TimeUnit, Time.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final Time.Rel ZERO = new Time.Rel(0.0, TimeUnit.SI);

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
        public Rel(final Time.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Time.Rel instantiateTypeRel(final double value, final TimeUnit unit)
        {
            return new Time.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final Time.Abs instantiateTypeAbs(final double value, final TimeUnit unit)
        {
            return new Time.Abs(value, unit);
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

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Time.Abs plus(final Time.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
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
        public final Dimensionless divideBy(final Time.Rel v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Frequency, which results in a Dimensionless scalar.
         * @param v Time scalar
         * @return Dimensionless scalar as a multiplication of Time and Frequency
         */
        public final Dimensionless multiplyBy(final Frequency v)
        {
            return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and ElectricalCurrent, which results in a ElectricalCharge scalar.
         * @param v Time scalar
         * @return ElectricalCharge scalar as a multiplication of Time and ElectricalCurrent
         */
        public final ElectricalCharge multiplyBy(final ElectricalCurrent v)
        {
            return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and FlowMass, which results in a Mass scalar.
         * @param v Time scalar
         * @return Mass scalar as a multiplication of Time and FlowMass
         */
        public final Mass multiplyBy(final FlowMass v)
        {
            return new Mass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and FlowVolume, which results in a Volume scalar.
         * @param v Time scalar
         * @return Volume scalar as a multiplication of Time and FlowVolume
         */
        public final Volume multiplyBy(final FlowVolume v)
        {
            return new Volume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Acceleration, which results in a Speed scalar.
         * @param v Time scalar
         * @return Speed scalar as a multiplication of Time and Acceleration
         */
        public final Speed multiplyBy(final Acceleration v)
        {
            return new Speed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Power, which results in a Energy scalar.
         * @param v Time scalar
         * @return Energy scalar as a multiplication of Time and Power
         */
        public final Energy multiplyBy(final Power v)
        {
            return new Energy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and Speed, which results in a Length scalar.
         * @param v Time scalar
         * @return Length scalar as a multiplication of Time and Speed
         */
        public final Length.Rel multiplyBy(final Speed v)
        {
            return new Length.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Time and MoneyPerTime, which results in a Money scalar.
         * @param v Time scalar
         * @return Money scalar as a multiplication of Time and MoneyPerTime
         */
        public final Money multiplyBy(final MoneyPerTime v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Absolute Time DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;TimeUnit&gt; value = new DoubleScalar.Abs&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
     * we can now write <br>
     * <i>Time.Abs value = new Time.Abs(100.0, TimeUnit.SI);</i><br>
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
    class Abs extends TypedDoubleScalarAbs<TimeUnit, Time.Abs, Time.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final Time.Abs ZERO = new Time.Abs(0.0, TimeUnit.SI);

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
        public Abs(final Time.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Time.Abs instantiateTypeAbs(final double value, final TimeUnit unit)
        {
            return new Time.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Time.Rel instantiateTypeRel(final double value, final TimeUnit unit)
        {
            return new Time.Rel(value, unit);
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

    }
}
