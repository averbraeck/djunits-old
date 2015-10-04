package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AnglePlane FloatScalar. Instead of <br>
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
public interface FloatAnglePlane
{
    /**
     * Easy access methods for the AnglePlane FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;AnglePlaneUnit&gt; value = new FloatScalar.Rel&lt;AnglePlaneUnit&gt;(100.0, AnglePlaneUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAnglePlane.Rel value = new FloatAnglePlane.Rel(100.0, AnglePlaneUnit.SI);</i><br>
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
    public static class Rel extends FloatScalar.Rel<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAnglePlane.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAnglePlane.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final AnglePlaneUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAnglePlane.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<AnglePlaneUnit> value)
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
        public static FloatAnglePlane.Rel interpolate(final FloatAnglePlane.Rel zero, final FloatAnglePlane.Rel one,
            final float ratio)
        {
            return new FloatAnglePlane.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAnglePlane.Rel interpolate(final FloatAnglePlane.Rel zero, final FloatAnglePlane.Rel one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel abs()
        {
            return new FloatAnglePlane.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel acos()
        {
            return new FloatAnglePlane.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel asin()
        {
            return new FloatAnglePlane.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel atan()
        {
            return new FloatAnglePlane.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel cbrt()
        {
            return new FloatAnglePlane.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel ceil()
        {
            return new FloatAnglePlane.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel cos()
        {
            return new FloatAnglePlane.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel cosh()
        {
            return new FloatAnglePlane.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel exp()
        {
            return new FloatAnglePlane.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel expm1()
        {
            return new FloatAnglePlane.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel floor()
        {
            return new FloatAnglePlane.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel log()
        {
            return new FloatAnglePlane.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel log10()
        {
            return new FloatAnglePlane.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel log1p()
        {
            return new FloatAnglePlane.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel rint()
        {
            return new FloatAnglePlane.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel round()
        {
            return new FloatAnglePlane.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel signum()
        {
            return new FloatAnglePlane.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel sin()
        {
            return new FloatAnglePlane.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel sinh()
        {
            return new FloatAnglePlane.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel sqrt()
        {
            return new FloatAnglePlane.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel tan()
        {
            return new FloatAnglePlane.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel tanh()
        {
            return new FloatAnglePlane.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel inv()
        {
            return new FloatAnglePlane.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel toDegrees()
        {
            return new FloatAnglePlane.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel toRadians()
        {
            return new FloatAnglePlane.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel pow(final double x)
        {
            return new FloatAnglePlane.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel multiplyBy(final float factor)
        {
            return new FloatAnglePlane.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative angleplane
         */
        public final FloatAnglePlane.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel divideBy(final float divisor)
        {
            return new FloatAnglePlane.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative angleplane
         */
        public final FloatAnglePlane.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAnglePlane.Rel plus(final FloatAnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAnglePlane.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FloatAnglePlane.Rel(this.si + v.si, AnglePlaneUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatAnglePlane.Rel minus(final FloatAnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAnglePlane.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatAnglePlane.Rel(this.si - v.si, AnglePlaneUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAnglePlane.Abs plus(final FloatAnglePlane.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAnglePlane.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatAnglePlane.Abs(this.si + v.si, AnglePlaneUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleplane scalar.
         */
        public final FloatAnglePlane.Abs toAbs()
        {
            return new FloatAnglePlane.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatAnglePlane and FloatAnglePlane, which results in a FloatDimensionless scalar.
         * @param v FloatAnglePlane scalar
         * @return FloatDimensionless scalar as a division of FloatAnglePlane and FloatAnglePlane
         */
        public final FloatDimensionless.Rel divideBy(final FloatAnglePlane.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AnglePlane FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;AnglePlaneUnit&gt; value = new FloatScalar.Abs&lt;AnglePlaneUnit&gt;(100.0, AnglePlaneUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAnglePlane.Abs value = new FloatAnglePlane.Abs(100.0, AnglePlaneUnit.SI);</i><br>
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
    public static class Abs extends FloatScalar.Abs<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAnglePlane.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAnglePlane.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AnglePlaneUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAnglePlane.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<AnglePlaneUnit> value)
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
        public static FloatAnglePlane.Abs interpolate(final FloatAnglePlane.Abs zero, final FloatAnglePlane.Abs one,
            final float ratio)
        {
            return new FloatAnglePlane.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAnglePlane.Abs interpolate(final FloatAnglePlane.Abs zero, final FloatAnglePlane.Abs one,
            final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs abs()
        {
            return new FloatAnglePlane.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs acos()
        {
            return new FloatAnglePlane.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs asin()
        {
            return new FloatAnglePlane.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs atan()
        {
            return new FloatAnglePlane.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs cbrt()
        {
            return new FloatAnglePlane.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs ceil()
        {
            return new FloatAnglePlane.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs cos()
        {
            return new FloatAnglePlane.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs cosh()
        {
            return new FloatAnglePlane.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs exp()
        {
            return new FloatAnglePlane.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs expm1()
        {
            return new FloatAnglePlane.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs floor()
        {
            return new FloatAnglePlane.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs log()
        {
            return new FloatAnglePlane.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs log10()
        {
            return new FloatAnglePlane.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs log1p()
        {
            return new FloatAnglePlane.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs rint()
        {
            return new FloatAnglePlane.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs round()
        {
            return new FloatAnglePlane.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs signum()
        {
            return new FloatAnglePlane.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs sin()
        {
            return new FloatAnglePlane.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs sinh()
        {
            return new FloatAnglePlane.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs sqrt()
        {
            return new FloatAnglePlane.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs tan()
        {
            return new FloatAnglePlane.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs tanh()
        {
            return new FloatAnglePlane.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs inv()
        {
            return new FloatAnglePlane.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs toDegrees()
        {
            return new FloatAnglePlane.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs toRadians()
        {
            return new FloatAnglePlane.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs pow(final double x)
        {
            return new FloatAnglePlane.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAnglePlane.Abs plus(final FloatAnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAnglePlane.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatAnglePlane.Abs(this.si + v.si, AnglePlaneUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatAnglePlane.Rel minus(final FloatAnglePlane.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAnglePlane.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatAnglePlane.Rel(this.si - v.si, AnglePlaneUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatAnglePlane.Abs minus(final FloatAnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatAnglePlane.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FloatAnglePlane.Abs(this.si - v.si, AnglePlaneUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute angleplane scalar.
         */
        public final FloatAnglePlane.Rel toRel()
        {
            return new FloatAnglePlane.Rel(getInUnit(), getUnit());
        }

    }
}
