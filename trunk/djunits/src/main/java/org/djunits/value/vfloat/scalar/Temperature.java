package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Temperature FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
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
public interface Temperature
{
    /**
     * Easy access methods for the Temperature FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Temperature.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Temperature.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final TemperatureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Temperature.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<TemperatureUnit> value)
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
        public static Temperature.Rel interpolate(final Temperature.Rel zero, final Temperature.Rel one,
            final float ratio)
        {
            return new Temperature.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Temperature.Rel interpolate(final Temperature.Rel zero, final Temperature.Rel one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel abs()
        {
            return new Temperature.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel acos()
        {
            return new Temperature.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel asin()
        {
            return new Temperature.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel atan()
        {
            return new Temperature.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel cbrt()
        {
            return new Temperature.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel ceil()
        {
            return new Temperature.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel cos()
        {
            return new Temperature.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel cosh()
        {
            return new Temperature.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel exp()
        {
            return new Temperature.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel expm1()
        {
            return new Temperature.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel floor()
        {
            return new Temperature.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel log()
        {
            return new Temperature.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel log10()
        {
            return new Temperature.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel log1p()
        {
            return new Temperature.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel rint()
        {
            return new Temperature.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel round()
        {
            return new Temperature.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel signum()
        {
            return new Temperature.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel sin()
        {
            return new Temperature.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel sinh()
        {
            return new Temperature.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel sqrt()
        {
            return new Temperature.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel tan()
        {
            return new Temperature.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel tanh()
        {
            return new Temperature.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel inv()
        {
            return new Temperature.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel toDegrees()
        {
            return new Temperature.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel toRadians()
        {
            return new Temperature.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel pow(final double x)
        {
            return new Temperature.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel multiplyBy(final float factor)
        {
            return new Temperature.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative temperature
         */
        public final Temperature.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel divideBy(final float divisor)
        {
            return new Temperature.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative temperature
         */
        public final Temperature.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Temperature.Rel plus(final Temperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Temperature.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Temperature.Rel(this.si + v.si, TemperatureUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Temperature.Rel minus(final Temperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Temperature.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Temperature.Rel(this.si - v.si, TemperatureUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Temperature.Abs plus(final Temperature.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Temperature.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Temperature.Abs(this.si + v.si, TemperatureUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative temperature scalar.
         */
        public final Temperature.Abs toAbs()
        {
            return new Temperature.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Temperature and Temperature, which results in a Dimensionless scalar.
         * @param v Temperature scalar
         * @return Dimensionless scalar as a division of Temperature and Temperature
         */
        public final Dimensionless.Rel divideBy(final Temperature.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Temperature FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Temperature.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Temperature.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final TemperatureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Temperature.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<TemperatureUnit> value)
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
        public static Temperature.Abs interpolate(final Temperature.Abs zero, final Temperature.Abs one,
            final float ratio)
        {
            return new Temperature.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Temperature.Abs interpolate(final Temperature.Abs zero, final Temperature.Abs one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs abs()
        {
            return new Temperature.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs acos()
        {
            return new Temperature.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs asin()
        {
            return new Temperature.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs atan()
        {
            return new Temperature.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs cbrt()
        {
            return new Temperature.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs ceil()
        {
            return new Temperature.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs cos()
        {
            return new Temperature.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs cosh()
        {
            return new Temperature.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs exp()
        {
            return new Temperature.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs expm1()
        {
            return new Temperature.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs floor()
        {
            return new Temperature.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs log()
        {
            return new Temperature.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs log10()
        {
            return new Temperature.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs log1p()
        {
            return new Temperature.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs rint()
        {
            return new Temperature.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs round()
        {
            return new Temperature.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs signum()
        {
            return new Temperature.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs sin()
        {
            return new Temperature.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs sinh()
        {
            return new Temperature.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs sqrt()
        {
            return new Temperature.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs tan()
        {
            return new Temperature.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs tanh()
        {
            return new Temperature.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs inv()
        {
            return new Temperature.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs toDegrees()
        {
            return new Temperature.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs toRadians()
        {
            return new Temperature.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs pow(final double x)
        {
            return new Temperature.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Temperature.Abs plus(final Temperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Temperature.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Temperature.Abs(this.si + v.si, TemperatureUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Temperature.Rel minus(final Temperature.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Temperature.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Temperature.Rel(this.si - v.si, TemperatureUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Temperature.Abs minus(final Temperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Temperature.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Temperature.Abs(this.si - v.si, TemperatureUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute temperature scalar.
         */
        public final Temperature.Rel toRel()
        {
            return new Temperature.Rel(getInUnit(), getUnit());
        }

    }
}
