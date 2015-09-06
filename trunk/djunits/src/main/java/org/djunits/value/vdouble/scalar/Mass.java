package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Mass DoubleScalar. Instead of <br>
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
public interface Mass extends UNITS
{
    /**
     * Easy access methods for the Mass DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<MassUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Mass.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final MassUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Mass.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<MassUnit> value)
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
        public static Mass.Rel interpolate(final Mass.Rel zero, final Mass.Rel one, final double ratio)
        {
            return new Mass.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel abs()
        {
            return new Mass.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel acos()
        {
            return new Mass.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel asin()
        {
            return new Mass.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel atan()
        {
            return new Mass.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel cbrt()
        {
            return new Mass.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel ceil()
        {
            return new Mass.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel cos()
        {
            return new Mass.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel cosh()
        {
            return new Mass.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel exp()
        {
            return new Mass.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel expm1()
        {
            return new Mass.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel floor()
        {
            return new Mass.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel log()
        {
            return new Mass.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel log10()
        {
            return new Mass.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel log1p()
        {
            return new Mass.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel rint()
        {
            return new Mass.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel round()
        {
            return new Mass.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel signum()
        {
            return new Mass.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel sin()
        {
            return new Mass.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel sinh()
        {
            return new Mass.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel sqrt()
        {
            return new Mass.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel tan()
        {
            return new Mass.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel tanh()
        {
            return new Mass.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel inv()
        {
            return new Mass.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel toDegrees()
        {
            return new Mass.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel toRadians()
        {
            return new Mass.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel pow(final double x)
        {
            return new Mass.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel multiplyBy(final double factor)
        {
            return new Mass.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Rel divideBy(final double divisor)
        {
            return new Mass.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Mass.Rel plus(final Mass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Mass.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Mass.Rel(
                this.si + v.si, MassUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Mass.Rel minus(final Mass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Mass.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Mass.Rel(
                this.si - v.si, MassUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Mass.Abs plus(final Mass.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Mass.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Mass.Abs(
                this.si + v.si, MassUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative mass scalar.
         */
        public final Mass.Abs toAbs()
        {
            return new Mass.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Mass and Mass, which results in a Dimensionless scalar.
         * @param v Mass scalar
         * @return Dimensionless scalar as a division of Mass and Mass
         */
        public final Dimensionless.Rel divideBy(final Mass.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Mass and FlowMass, which results in a Time scalar.
         * @param v Mass scalar
         * @return Time scalar as a division of Mass and FlowMass
         */
        public final Time.Rel divideBy(final FlowMass.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the division of Mass and Time, which results in a FlowMass scalar.
         * @param v Mass scalar
         * @return FlowMass scalar as a division of Mass and Time
         */
        public final FlowMass.Rel divideBy(final Time.Rel v)
        {
            return new FlowMass.Rel(this.si / v.si, FlowMassUnit.SI);
        }

        /**
         * Calculate the multiplication of Mass and Acceleration, which results in a Force scalar.
         * @param v Mass scalar
         * @return Force scalar as a multiplication of Mass and Acceleration
         */
        public final Force.Rel multiplyBy(final Acceleration.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Mass and Frequency, which results in a FlowMass scalar.
         * @param v Mass scalar
         * @return FlowMass scalar as a multiplication of Mass and Frequency
         */
        public final FlowMass.Rel multiplyBy(final Frequency.Rel v)
        {
            return new FlowMass.Rel(this.si * v.si, FlowMassUnit.SI);
        }

        /**
         * Calculate the division of Mass and Density, which results in a Volume scalar.
         * @param v Mass scalar
         * @return Volume scalar as a division of Mass and Density
         */
        public final Volume.Rel divideBy(final Density.Rel v)
        {
            return new Volume.Rel(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Mass and Volume, which results in a Density scalar.
         * @param v Mass scalar
         * @return Density scalar as a division of Mass and Volume
         */
        public final Density.Rel divideBy(final Volume.Rel v)
        {
            return new Density.Rel(this.si / v.si, DensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Mass and MoneyPerMass, which results in a Money scalar.
         * @param v Mass scalar
         * @return Money scalar as a multiplication of Mass and MoneyPerMass
         */
        public final Money multiplyBy(final MoneyPerMass v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Mass DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<MassUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Mass.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final MassUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Mass.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<MassUnit> value)
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
        public static Mass.Abs interpolate(final Mass.Abs zero, final Mass.Abs one, final double ratio)
        {
            return new Mass.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs abs()
        {
            return new Mass.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs acos()
        {
            return new Mass.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs asin()
        {
            return new Mass.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs atan()
        {
            return new Mass.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs cbrt()
        {
            return new Mass.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs ceil()
        {
            return new Mass.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs cos()
        {
            return new Mass.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs cosh()
        {
            return new Mass.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs exp()
        {
            return new Mass.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs expm1()
        {
            return new Mass.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs floor()
        {
            return new Mass.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs log()
        {
            return new Mass.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs log10()
        {
            return new Mass.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs log1p()
        {
            return new Mass.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs rint()
        {
            return new Mass.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs round()
        {
            return new Mass.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs signum()
        {
            return new Mass.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs sin()
        {
            return new Mass.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs sinh()
        {
            return new Mass.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs sqrt()
        {
            return new Mass.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs tan()
        {
            return new Mass.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs tanh()
        {
            return new Mass.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs inv()
        {
            return new Mass.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs toDegrees()
        {
            return new Mass.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs toRadians()
        {
            return new Mass.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs pow(final double x)
        {
            return new Mass.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs multiplyBy(final double factor)
        {
            return new Mass.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Mass.Abs divideBy(final double divisor)
        {
            return new Mass.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Mass.Abs plus(final Mass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Mass.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Mass.Abs(
                this.si + v.si, MassUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Mass.Rel minus(final Mass.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Mass.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Mass.Rel(
                this.si - v.si, MassUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Mass.Abs minus(final Mass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Mass.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Mass.Abs(
                this.si - v.si, MassUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute mass scalar.
         */
        public final Mass.Rel toRel()
        {
            return new Mass.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Mass and Mass, which results in a Dimensionless scalar.
         * @param v Mass scalar
         * @return Dimensionless scalar as a division of Mass and Mass
         */
        public final Dimensionless.Abs divideBy(final Mass.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Mass and FlowMass, which results in a Time scalar.
         * @param v Mass scalar
         * @return Time scalar as a division of Mass and FlowMass
         */
        public final Time.Abs divideBy(final FlowMass.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the division of Mass and Time, which results in a FlowMass scalar.
         * @param v Mass scalar
         * @return FlowMass scalar as a division of Mass and Time
         */
        public final FlowMass.Abs divideBy(final Time.Abs v)
        {
            return new FlowMass.Abs(this.si / v.si, FlowMassUnit.SI);
        }

        /**
         * Calculate the multiplication of Mass and Acceleration, which results in a Force scalar.
         * @param v Mass scalar
         * @return Force scalar as a multiplication of Mass and Acceleration
         */
        public final Force.Abs multiplyBy(final Acceleration.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Mass and Frequency, which results in a FlowMass scalar.
         * @param v Mass scalar
         * @return FlowMass scalar as a multiplication of Mass and Frequency
         */
        public final FlowMass.Abs multiplyBy(final Frequency.Abs v)
        {
            return new FlowMass.Abs(this.si * v.si, FlowMassUnit.SI);
        }

        /**
         * Calculate the division of Mass and Density, which results in a Volume scalar.
         * @param v Mass scalar
         * @return Volume scalar as a division of Mass and Density
         */
        public final Volume.Abs divideBy(final Density.Abs v)
        {
            return new Volume.Abs(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Mass and Volume, which results in a Density scalar.
         * @param v Mass scalar
         * @return Density scalar as a division of Mass and Volume
         */
        public final Density.Abs divideBy(final Volume.Abs v)
        {
            return new Density.Abs(this.si / v.si, DensityUnit.SI);
        }

        /**
         * Calculate the multiplication of Mass and MoneyPerMass, which results in a Money scalar.
         * @param v Mass scalar
         * @return Money scalar as a multiplication of Mass and MoneyPerMass
         */
        public final Money multiplyBy(final MoneyPerMass v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }
}
