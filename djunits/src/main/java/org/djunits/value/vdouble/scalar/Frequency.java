package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Frequency DoubleScalar. Instead of <br>
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
public interface Frequency extends UNITS
{
    /**
     * Easy access methods for the Frequency DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<FrequencyUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Frequency.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final FrequencyUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Frequency.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<FrequencyUnit> value)
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
        public static Frequency.Rel interpolate(final Frequency.Rel zero, final Frequency.Rel one, final double ratio)
        {
            return new Frequency.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel abs()
        {
            return new Frequency.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel acos()
        {
            return new Frequency.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel asin()
        {
            return new Frequency.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel atan()
        {
            return new Frequency.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel cbrt()
        {
            return new Frequency.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel ceil()
        {
            return new Frequency.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel cos()
        {
            return new Frequency.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel cosh()
        {
            return new Frequency.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel exp()
        {
            return new Frequency.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel expm1()
        {
            return new Frequency.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel floor()
        {
            return new Frequency.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel log()
        {
            return new Frequency.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel log10()
        {
            return new Frequency.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel log1p()
        {
            return new Frequency.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel rint()
        {
            return new Frequency.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel round()
        {
            return new Frequency.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel signum()
        {
            return new Frequency.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel sin()
        {
            return new Frequency.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel sinh()
        {
            return new Frequency.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel sqrt()
        {
            return new Frequency.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel tan()
        {
            return new Frequency.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel tanh()
        {
            return new Frequency.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel inv()
        {
            return new Frequency.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel toDegrees()
        {
            return new Frequency.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel toRadians()
        {
            return new Frequency.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel pow(final double x)
        {
            return new Frequency.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel multiplyBy(final double factor)
        {
            return new Frequency.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Rel divideBy(final double divisor)
        {
            return new Frequency.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Frequency.Rel plus(final Frequency.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Frequency.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Frequency.Rel(this.si + v.si, FrequencyUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Frequency.Rel minus(final Frequency.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Frequency.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Frequency.Rel(this.si - v.si, FrequencyUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Frequency.Abs plus(final Frequency.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Frequency.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Frequency.Abs(this.si + v.si, FrequencyUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative frequency scalar.
         */
        public final Frequency.Abs toAbs()
        {
            return new Frequency.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Frequency and Frequency, which results in a Dimensionless scalar.
         * @param v Frequency scalar
         * @return Dimensionless scalar as a division of Frequency and Frequency
         */
        public final Dimensionless.Rel divideBy(final Frequency.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Time, which results in a Dimensionless scalar.
         * @param v Frequency scalar
         * @return Dimensionless scalar as a multiplication of Frequency and Time
         */
        public final Dimensionless.Rel multiplyBy(final Time.Rel v)
        {
            return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Length, which results in a Speed scalar.
         * @param v Frequency scalar
         * @return Speed scalar as a multiplication of Frequency and Length
         */
        public final Speed.Rel multiplyBy(final Length.Rel v)
        {
            return new Speed.Rel(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Speed, which results in a Acceleration scalar.
         * @param v Frequency scalar
         * @return Acceleration scalar as a multiplication of Frequency and Speed
         */
        public final Acceleration.Rel multiplyBy(final Speed.Rel v)
        {
            return new Acceleration.Rel(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Energy, which results in a Power scalar.
         * @param v Frequency scalar
         * @return Power scalar as a multiplication of Frequency and Energy
         */
        public final Power.Rel multiplyBy(final Energy.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Money, which results in a MoneyPerTime scalar.
         * @param v Frequency scalar
         * @return MoneyPerTime scalar as a multiplication of Frequency and Money
         */
        public final MoneyPerTime multiplyBy(final Money v)
        {
            return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
        }

    }

    /**
     * Easy access methods for the Frequency DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<FrequencyUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Frequency.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final FrequencyUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Frequency.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<FrequencyUnit> value)
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
        public static Frequency.Abs interpolate(final Frequency.Abs zero, final Frequency.Abs one, final double ratio)
        {
            return new Frequency.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs abs()
        {
            return new Frequency.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs acos()
        {
            return new Frequency.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs asin()
        {
            return new Frequency.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs atan()
        {
            return new Frequency.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs cbrt()
        {
            return new Frequency.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs ceil()
        {
            return new Frequency.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs cos()
        {
            return new Frequency.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs cosh()
        {
            return new Frequency.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs exp()
        {
            return new Frequency.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs expm1()
        {
            return new Frequency.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs floor()
        {
            return new Frequency.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs log()
        {
            return new Frequency.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs log10()
        {
            return new Frequency.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs log1p()
        {
            return new Frequency.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs rint()
        {
            return new Frequency.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs round()
        {
            return new Frequency.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs signum()
        {
            return new Frequency.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs sin()
        {
            return new Frequency.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs sinh()
        {
            return new Frequency.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs sqrt()
        {
            return new Frequency.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs tan()
        {
            return new Frequency.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs tanh()
        {
            return new Frequency.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs inv()
        {
            return new Frequency.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs toDegrees()
        {
            return new Frequency.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs toRadians()
        {
            return new Frequency.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs pow(final double x)
        {
            return new Frequency.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs multiplyBy(final double factor)
        {
            return new Frequency.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Frequency.Abs divideBy(final double divisor)
        {
            return new Frequency.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Frequency.Abs plus(final Frequency.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Frequency.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Frequency.Abs(this.si + v.si, FrequencyUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Frequency.Rel minus(final Frequency.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Frequency.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Frequency.Rel(this.si - v.si, FrequencyUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Frequency.Abs minus(final Frequency.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Frequency.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Frequency.Abs(this.si - v.si, FrequencyUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute frequency scalar.
         */
        public final Frequency.Rel toRel()
        {
            return new Frequency.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Frequency and Frequency, which results in a Dimensionless scalar.
         * @param v Frequency scalar
         * @return Dimensionless scalar as a division of Frequency and Frequency
         */
        public final Dimensionless.Abs divideBy(final Frequency.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Time, which results in a Dimensionless scalar.
         * @param v Frequency scalar
         * @return Dimensionless scalar as a multiplication of Frequency and Time
         */
        public final Dimensionless.Abs multiplyBy(final Time.Abs v)
        {
            return new Dimensionless.Abs(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Length, which results in a Speed scalar.
         * @param v Frequency scalar
         * @return Speed scalar as a multiplication of Frequency and Length
         */
        public final Speed.Abs multiplyBy(final Length.Abs v)
        {
            return new Speed.Abs(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Speed, which results in a Acceleration scalar.
         * @param v Frequency scalar
         * @return Acceleration scalar as a multiplication of Frequency and Speed
         */
        public final Acceleration.Abs multiplyBy(final Speed.Abs v)
        {
            return new Acceleration.Abs(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Energy, which results in a Power scalar.
         * @param v Frequency scalar
         * @return Power scalar as a multiplication of Frequency and Energy
         */
        public final Power.Abs multiplyBy(final Energy.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Frequency and Money, which results in a MoneyPerTime scalar.
         * @param v Frequency scalar
         * @return MoneyPerTime scalar as a multiplication of Frequency and Money
         */
        public final MoneyPerTime multiplyBy(final Money v)
        {
            return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
        }

    }
}
