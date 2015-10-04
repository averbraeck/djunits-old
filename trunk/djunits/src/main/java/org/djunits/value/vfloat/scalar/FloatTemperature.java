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
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatTemperature
{
    /**
     * Easy access methods for the Temperature FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;TemperatureUnit&gt; value = new FloatScalar.Rel&lt;TemperatureUnit&gt;(100.0, TemperatureUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatTemperature.Rel value = new FloatTemperature.Rel(100.0, TemperatureUnit.SI);</i><br>
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
    public static class Rel extends FloatScalar.Rel<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatTemperature.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatTemperature.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final TemperatureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatTemperature.Rel scalar.
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
        public static FloatTemperature.Rel interpolate(final FloatTemperature.Rel zero, final FloatTemperature.Rel one, final float ratio)
        {
            return new FloatTemperature.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatTemperature.Rel interpolate(final FloatTemperature.Rel zero, final FloatTemperature.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel abs()
        {
            return new FloatTemperature.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel acos()
        {
            return new FloatTemperature.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel asin()
        {
            return new FloatTemperature.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel atan()
        {
            return new FloatTemperature.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel cbrt()
        {
            return new FloatTemperature.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel ceil()
        {
            return new FloatTemperature.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel cos()
        {
            return new FloatTemperature.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel cosh()
        {
            return new FloatTemperature.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel exp()
        {
            return new FloatTemperature.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel expm1()
        {
            return new FloatTemperature.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel floor()
        {
            return new FloatTemperature.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel log()
        {
            return new FloatTemperature.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel log10()
        {
            return new FloatTemperature.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel log1p()
        {
            return new FloatTemperature.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel rint()
        {
            return new FloatTemperature.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel round()
        {
            return new FloatTemperature.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel signum()
        {
            return new FloatTemperature.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel sin()
        {
            return new FloatTemperature.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel sinh()
        {
            return new FloatTemperature.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel sqrt()
        {
            return new FloatTemperature.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel tan()
        {
            return new FloatTemperature.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel tanh()
        {
            return new FloatTemperature.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel inv()
        {
            return new FloatTemperature.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel toDegrees()
        {
            return new FloatTemperature.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel toRadians()
        {
            return new FloatTemperature.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel pow(final double x)
        {
            return new FloatTemperature.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel multiplyBy(final float factor)
        {
            return new FloatTemperature.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative temperature
         */
        public final FloatTemperature.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel divideBy(final float divisor)
        {
            return new FloatTemperature.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative temperature
         */
        public final FloatTemperature.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTemperature.Rel plus(final FloatTemperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTemperature.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FloatTemperature.Rel(this.si + v.si, TemperatureUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatTemperature.Rel minus(final FloatTemperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTemperature.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatTemperature.Rel(this.si - v.si, TemperatureUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTemperature.Abs plus(final FloatTemperature.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTemperature.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatTemperature.Abs(this.si + v.si, TemperatureUnit.SI);
        }

        /** 
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative temperature scalar.
         */
        public final FloatTemperature.Abs toAbs()
        {
            return new FloatTemperature.Abs(getInUnit(), getUnit());
        }
        /**
         * Calculate the division of FloatTemperature and FloatTemperature, which results in a FloatDimensionless scalar.
         * @param v FloatTemperature scalar
         * @return FloatDimensionless scalar as a division of FloatTemperature and FloatTemperature
         */
        public final FloatDimensionless.Rel divideBy(final FloatTemperature.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }


    }

    /**
     * Easy access methods for the Temperature FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;TemperatureUnit&gt; value = new FloatScalar.Abs&lt;TemperatureUnit&gt;(100.0, TemperatureUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatTemperature.Abs value = new FloatTemperature.Abs(100.0, TemperatureUnit.SI);</i><br>
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
    public static class Abs extends FloatScalar.Abs<TemperatureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatTemperature.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatTemperature.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final TemperatureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatTemperature.Abs scalar.
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
        public static FloatTemperature.Abs interpolate(final FloatTemperature.Abs zero, final FloatTemperature.Abs one, final float ratio)
        {
            return new FloatTemperature.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatTemperature.Abs interpolate(final FloatTemperature.Abs zero, final FloatTemperature.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs abs()
        {
            return new FloatTemperature.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs acos()
        {
            return new FloatTemperature.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs asin()
        {
            return new FloatTemperature.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs atan()
        {
            return new FloatTemperature.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs cbrt()
        {
            return new FloatTemperature.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs ceil()
        {
            return new FloatTemperature.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs cos()
        {
            return new FloatTemperature.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs cosh()
        {
            return new FloatTemperature.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs exp()
        {
            return new FloatTemperature.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs expm1()
        {
            return new FloatTemperature.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs floor()
        {
            return new FloatTemperature.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs log()
        {
            return new FloatTemperature.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs log10()
        {
            return new FloatTemperature.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs log1p()
        {
            return new FloatTemperature.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs rint()
        {
            return new FloatTemperature.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs round()
        {
            return new FloatTemperature.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs signum()
        {
            return new FloatTemperature.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs sin()
        {
            return new FloatTemperature.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs sinh()
        {
            return new FloatTemperature.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs sqrt()
        {
            return new FloatTemperature.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs tan()
        {
            return new FloatTemperature.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs tanh()
        {
            return new FloatTemperature.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs inv()
        {
            return new FloatTemperature.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs toDegrees()
        {
            return new FloatTemperature.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs toRadians()
        {
            return new FloatTemperature.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs pow(final double x)
        {
            return new FloatTemperature.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTemperature.Abs plus(final FloatTemperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTemperature.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatTemperature.Abs(this.si + v.si, TemperatureUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatTemperature.Rel minus(final FloatTemperature.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTemperature.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatTemperature.Rel(this.si - v.si, TemperatureUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatTemperature.Abs minus(final FloatTemperature.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatTemperature.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FloatTemperature.Abs(this.si - v.si, TemperatureUnit.SI);
        }

        /** 
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute temperature scalar.
         */
        public final FloatTemperature.Rel toRel()
        {
            return new FloatTemperature.Rel(getInUnit(), getUnit());
        }
        
    }
}