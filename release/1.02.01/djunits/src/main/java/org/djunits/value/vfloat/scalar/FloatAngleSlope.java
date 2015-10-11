package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatAngleSlope
{
    /**
     * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;AngleSlopeUnit&gt; value = new FloatScalar.Rel&lt;AngleSlopeUnit&gt;(100.0, AngleSlopeUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAngleSlope.Rel value = new FloatAngleSlope.Rel(100.0, AngleSlopeUnit.SI);</i><br>
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
    public static class Rel extends FloatScalar.Rel<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAngleSlope.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAngleSlope.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final AngleSlopeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAngleSlope.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<AngleSlopeUnit> value)
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
        public static FloatAngleSlope.Rel interpolate(final FloatAngleSlope.Rel zero, final FloatAngleSlope.Rel one,
            final float ratio)
        {
            return new FloatAngleSlope.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAngleSlope.Rel interpolate(final FloatAngleSlope.Rel zero, final FloatAngleSlope.Rel one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel abs()
        {
            return new FloatAngleSlope.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel acos()
        {
            return new FloatAngleSlope.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel asin()
        {
            return new FloatAngleSlope.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel atan()
        {
            return new FloatAngleSlope.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel cbrt()
        {
            return new FloatAngleSlope.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel ceil()
        {
            return new FloatAngleSlope.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel cos()
        {
            return new FloatAngleSlope.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel cosh()
        {
            return new FloatAngleSlope.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel exp()
        {
            return new FloatAngleSlope.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel expm1()
        {
            return new FloatAngleSlope.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel floor()
        {
            return new FloatAngleSlope.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel log()
        {
            return new FloatAngleSlope.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel log10()
        {
            return new FloatAngleSlope.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel log1p()
        {
            return new FloatAngleSlope.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel rint()
        {
            return new FloatAngleSlope.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel round()
        {
            return new FloatAngleSlope.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel signum()
        {
            return new FloatAngleSlope.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel sin()
        {
            return new FloatAngleSlope.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel sinh()
        {
            return new FloatAngleSlope.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel sqrt()
        {
            return new FloatAngleSlope.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel tan()
        {
            return new FloatAngleSlope.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel tanh()
        {
            return new FloatAngleSlope.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel inv()
        {
            return new FloatAngleSlope.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel toDegrees()
        {
            return new FloatAngleSlope.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel toRadians()
        {
            return new FloatAngleSlope.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel pow(final double x)
        {
            return new FloatAngleSlope.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel multiplyBy(final float factor)
        {
            return new FloatAngleSlope.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative angleslope
         */
        public final FloatAngleSlope.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel divideBy(final float divisor)
        {
            return new FloatAngleSlope.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative angleslope
         */
        public final FloatAngleSlope.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAngleSlope.Rel plus(final FloatAngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAngleSlope.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FloatAngleSlope.Rel(this.si + v.si, AngleSlopeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatAngleSlope.Rel minus(final FloatAngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAngleSlope.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatAngleSlope.Rel(this.si - v.si, AngleSlopeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAngleSlope.Abs plus(final FloatAngleSlope.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAngleSlope.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatAngleSlope.Abs(this.si + v.si, AngleSlopeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleslope scalar.
         */
        public final FloatAngleSlope.Abs toAbs()
        {
            return new FloatAngleSlope.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatAngleSlope and FloatAngleSlope, which results in a FloatDimensionless scalar.
         * @param v FloatAngleSlope scalar
         * @return FloatDimensionless scalar as a division of FloatAngleSlope and FloatAngleSlope
         */
        public final FloatDimensionless.Rel divideBy(final FloatAngleSlope.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;AngleSlopeUnit&gt; value = new FloatScalar.Abs&lt;AngleSlopeUnit&gt;(100.0, AngleSlopeUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAngleSlope.Abs value = new FloatAngleSlope.Abs(100.0, AngleSlopeUnit.SI);</i><br>
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
    public static class Abs extends FloatScalar.Abs<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAngleSlope.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAngleSlope.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AngleSlopeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAngleSlope.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<AngleSlopeUnit> value)
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
        public static FloatAngleSlope.Abs interpolate(final FloatAngleSlope.Abs zero, final FloatAngleSlope.Abs one,
            final float ratio)
        {
            return new FloatAngleSlope.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAngleSlope.Abs interpolate(final FloatAngleSlope.Abs zero, final FloatAngleSlope.Abs one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs abs()
        {
            return new FloatAngleSlope.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs acos()
        {
            return new FloatAngleSlope.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs asin()
        {
            return new FloatAngleSlope.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs atan()
        {
            return new FloatAngleSlope.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs cbrt()
        {
            return new FloatAngleSlope.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs ceil()
        {
            return new FloatAngleSlope.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs cos()
        {
            return new FloatAngleSlope.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs cosh()
        {
            return new FloatAngleSlope.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs exp()
        {
            return new FloatAngleSlope.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs expm1()
        {
            return new FloatAngleSlope.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs floor()
        {
            return new FloatAngleSlope.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs log()
        {
            return new FloatAngleSlope.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs log10()
        {
            return new FloatAngleSlope.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs log1p()
        {
            return new FloatAngleSlope.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs rint()
        {
            return new FloatAngleSlope.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs round()
        {
            return new FloatAngleSlope.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs signum()
        {
            return new FloatAngleSlope.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs sin()
        {
            return new FloatAngleSlope.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs sinh()
        {
            return new FloatAngleSlope.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs sqrt()
        {
            return new FloatAngleSlope.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs tan()
        {
            return new FloatAngleSlope.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs tanh()
        {
            return new FloatAngleSlope.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs inv()
        {
            return new FloatAngleSlope.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs toDegrees()
        {
            return new FloatAngleSlope.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs toRadians()
        {
            return new FloatAngleSlope.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs pow(final double x)
        {
            return new FloatAngleSlope.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAngleSlope.Abs plus(final FloatAngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAngleSlope.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatAngleSlope.Abs(this.si + v.si, AngleSlopeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatAngleSlope.Rel minus(final FloatAngleSlope.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAngleSlope.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatAngleSlope.Rel(this.si - v.si, AngleSlopeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatAngleSlope.Abs minus(final FloatAngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAngleSlope.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FloatAngleSlope.Abs(this.si - v.si, AngleSlopeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute angleslope scalar.
         */
        public final FloatAngleSlope.Rel toRel()
        {
            return new FloatAngleSlope.Rel(getInUnit(), getUnit());
        }

    }
}
