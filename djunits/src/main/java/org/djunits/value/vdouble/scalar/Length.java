package org.djunits.value.vdouble.scalar;

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
 * Easy access methods for the Length DoubleScalar. Instead of <br>
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
public interface Length
{
    /**
     * Easy access methods for the Relative Length DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; value = new DoubleScalar.Rel&lt;LengthUnit&gt;(100.0, LengthUnit.SI);</i><br>
     * we can now write <br>
     * <i>Length.Rel value = new Length.Rel(100.0, LengthUnit.SI);</i><br>
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
    class Rel extends TypedDoubleScalarRel<LengthUnit, Length.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Length.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final LengthUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Length.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final Length.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Length.Rel instantiateTypeRel(final double value, final LengthUnit unit)
        {
            return new Length.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final Length.Abs instantiateTypeAbs(final double value, final LengthUnit unit)
        {
            return new Length.Abs(value, unit);
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
            return new Length.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Length.Abs plus(final Length.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
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
        public final Dimensionless divideBy(final Length.Rel v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
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
     * Easy access methods for the Absolute Length DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;LengthUnit&gt; value = new DoubleScalar.Abs&lt;LengthUnit&gt;(100.0, LengthUnit.SI);</i><br>
     * we can now write <br>
     * <i>Length.Abs value = new Length.Abs(100.0, LengthUnit.SI);</i><br>
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
    class Abs extends TypedDoubleScalarAbs<LengthUnit, Length.Abs, Length.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Length.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final LengthUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Length.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final Length.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Length.Abs instantiateTypeAbs(final double value, final LengthUnit unit)
        {
            return new Length.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Length.Rel instantiateTypeRel(final double value, final LengthUnit unit)
        {
            return new Length.Rel(value, unit);
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
            return new Length.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

    }
}
