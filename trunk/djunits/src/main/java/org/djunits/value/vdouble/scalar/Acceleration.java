package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Acceleration DoubleScalar. Instead of <br>
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
public interface Acceleration extends UNITS
{
    /**
     * Easy access methods for the Acceleration DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<AccelerationUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Acceleration.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final AccelerationUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Acceleration.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<AccelerationUnit> value)
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
        public static Acceleration.Rel interpolate(final Acceleration.Rel zero, final Acceleration.Rel one,
            final double ratio)
        {
            return new Acceleration.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel abs()
        {
            return new Acceleration.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel acos()
        {
            return new Acceleration.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel asin()
        {
            return new Acceleration.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel atan()
        {
            return new Acceleration.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel cbrt()
        {
            return new Acceleration.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel ceil()
        {
            return new Acceleration.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel cos()
        {
            return new Acceleration.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel cosh()
        {
            return new Acceleration.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel exp()
        {
            return new Acceleration.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel expm1()
        {
            return new Acceleration.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel floor()
        {
            return new Acceleration.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel log()
        {
            return new Acceleration.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel log10()
        {
            return new Acceleration.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel log1p()
        {
            return new Acceleration.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel rint()
        {
            return new Acceleration.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel round()
        {
            return new Acceleration.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel signum()
        {
            return new Acceleration.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel sin()
        {
            return new Acceleration.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel sinh()
        {
            return new Acceleration.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel sqrt()
        {
            return new Acceleration.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel tan()
        {
            return new Acceleration.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel tanh()
        {
            return new Acceleration.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel inv()
        {
            return new Acceleration.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel toDegrees()
        {
            return new Acceleration.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel toRadians()
        {
            return new Acceleration.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel pow(final double x)
        {
            return new Acceleration.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel multiplyBy(final double factor)
        {
            return new Acceleration.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Rel divideBy(final double divisor)
        {
            return new Acceleration.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Acceleration.Rel plus(final Acceleration.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Acceleration.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Acceleration.Rel(this.si + v.si, AccelerationUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Acceleration.Rel minus(final Acceleration.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Acceleration.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Acceleration.Rel(this.si - v.si, AccelerationUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Acceleration.Abs plus(final Acceleration.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Acceleration.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Acceleration.Abs(this.si + v.si, AccelerationUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative acceleration scalar.
         */
        public final Acceleration.Abs toAbs()
        {
            return new Acceleration.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Acceleration and Acceleration, which results in a Dimensionless scalar.
         * @param v Acceleration scalar
         * @return Dimensionless scalar as a division of Acceleration and Acceleration
         */
        public final Dimensionless.Rel divideBy(final Acceleration.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Acceleration and Mass, which results in a Force scalar.
         * @param v Acceleration scalar
         * @return Force scalar as a multiplication of Acceleration and Mass
         */
        public final Force.Rel multiplyBy(final Mass.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Acceleration and Time, which results in a Speed scalar.
         * @param v Acceleration scalar
         * @return Speed scalar as a multiplication of Acceleration and Time
         */
        public final Speed.Rel multiplyBy(final Time.Rel v)
        {
            return new Speed.Rel(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Acceleration and Frequency, which results in a Speed scalar.
         * @param v Acceleration scalar
         * @return Speed scalar as a division of Acceleration and Frequency
         */
        public final Speed.Rel divideBy(final Frequency.Rel v)
        {
            return new Speed.Rel(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Acceleration and Speed, which results in a Frequency scalar.
         * @param v Acceleration scalar
         * @return Frequency scalar as a division of Acceleration and Speed
         */
        public final Frequency.Rel divideBy(final Speed.Rel v)
        {
            return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI);
        }

    }

    /**
     * Easy access methods for the Acceleration DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<AccelerationUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Acceleration.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final AccelerationUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Acceleration.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<AccelerationUnit> value)
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
        public static Acceleration.Abs interpolate(final Acceleration.Abs zero, final Acceleration.Abs one,
            final double ratio)
        {
            return new Acceleration.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs abs()
        {
            return new Acceleration.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs acos()
        {
            return new Acceleration.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs asin()
        {
            return new Acceleration.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs atan()
        {
            return new Acceleration.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs cbrt()
        {
            return new Acceleration.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs ceil()
        {
            return new Acceleration.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs cos()
        {
            return new Acceleration.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs cosh()
        {
            return new Acceleration.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs exp()
        {
            return new Acceleration.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs expm1()
        {
            return new Acceleration.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs floor()
        {
            return new Acceleration.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs log()
        {
            return new Acceleration.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs log10()
        {
            return new Acceleration.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs log1p()
        {
            return new Acceleration.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs rint()
        {
            return new Acceleration.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs round()
        {
            return new Acceleration.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs signum()
        {
            return new Acceleration.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs sin()
        {
            return new Acceleration.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs sinh()
        {
            return new Acceleration.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs sqrt()
        {
            return new Acceleration.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs tan()
        {
            return new Acceleration.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs tanh()
        {
            return new Acceleration.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs inv()
        {
            return new Acceleration.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs toDegrees()
        {
            return new Acceleration.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs toRadians()
        {
            return new Acceleration.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs pow(final double x)
        {
            return new Acceleration.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs multiplyBy(final double factor)
        {
            return new Acceleration.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration.Abs divideBy(final double divisor)
        {
            return new Acceleration.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Acceleration.Abs plus(final Acceleration.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Acceleration.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Acceleration.Abs(this.si + v.si, AccelerationUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Acceleration.Rel minus(final Acceleration.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Acceleration.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Acceleration.Rel(this.si - v.si, AccelerationUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Acceleration.Abs minus(final Acceleration.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Acceleration.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Acceleration.Abs(this.si - v.si, AccelerationUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute acceleration scalar.
         */
        public final Acceleration.Rel toRel()
        {
            return new Acceleration.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Acceleration and Acceleration, which results in a Dimensionless scalar.
         * @param v Acceleration scalar
         * @return Dimensionless scalar as a division of Acceleration and Acceleration
         */
        public final Dimensionless.Abs divideBy(final Acceleration.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Acceleration and Mass, which results in a Force scalar.
         * @param v Acceleration scalar
         * @return Force scalar as a multiplication of Acceleration and Mass
         */
        public final Force.Abs multiplyBy(final Mass.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Acceleration and Time, which results in a Speed scalar.
         * @param v Acceleration scalar
         * @return Speed scalar as a multiplication of Acceleration and Time
         */
        public final Speed.Abs multiplyBy(final Time.Abs v)
        {
            return new Speed.Abs(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Acceleration and Frequency, which results in a Speed scalar.
         * @param v Acceleration scalar
         * @return Speed scalar as a division of Acceleration and Frequency
         */
        public final Speed.Abs divideBy(final Frequency.Abs v)
        {
            return new Speed.Abs(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Acceleration and Speed, which results in a Frequency scalar.
         * @param v Acceleration scalar
         * @return Frequency scalar as a division of Acceleration and Speed
         */
        public final Frequency.Abs divideBy(final Speed.Abs v)
        {
            return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI);
        }

    }
}
