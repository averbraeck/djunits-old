package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface AngleSlope extends UNITS
{
    /**
     * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AngleSlope.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AngleSlope.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final AngleSlopeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct AngleSlope.Rel scalar.
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
        public static AngleSlope.Rel interpolate(final AngleSlope.Rel zero, final AngleSlope.Rel one, final float ratio)
        {
            return new AngleSlope.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AngleSlope.Rel interpolate(final AngleSlope.Rel zero, final AngleSlope.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel abs()
        {
            return new AngleSlope.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel acos()
        {
            return new AngleSlope.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel asin()
        {
            return new AngleSlope.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel atan()
        {
            return new AngleSlope.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel cbrt()
        {
            return new AngleSlope.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel ceil()
        {
            return new AngleSlope.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel cos()
        {
            return new AngleSlope.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel cosh()
        {
            return new AngleSlope.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel exp()
        {
            return new AngleSlope.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel expm1()
        {
            return new AngleSlope.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel floor()
        {
            return new AngleSlope.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel log()
        {
            return new AngleSlope.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel log10()
        {
            return new AngleSlope.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel log1p()
        {
            return new AngleSlope.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel rint()
        {
            return new AngleSlope.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel round()
        {
            return new AngleSlope.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel signum()
        {
            return new AngleSlope.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel sin()
        {
            return new AngleSlope.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel sinh()
        {
            return new AngleSlope.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel sqrt()
        {
            return new AngleSlope.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel tan()
        {
            return new AngleSlope.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel tanh()
        {
            return new AngleSlope.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel inv()
        {
            return new AngleSlope.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel toDegrees()
        {
            return new AngleSlope.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel toRadians()
        {
            return new AngleSlope.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel pow(final double x)
        {
            return new AngleSlope.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel multiplyBy(final float factor)
        {
            return new AngleSlope.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative angleslope
         */
        public final AngleSlope.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel divideBy(final float divisor)
        {
            return new AngleSlope.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative angleslope
         */
        public final AngleSlope.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSlope.Rel plus(final AngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSlope.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new AngleSlope.Rel(this.si + v.si, AngleSlopeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AngleSlope.Rel minus(final AngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSlope.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new AngleSlope.Rel(this.si - v.si, AngleSlopeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSlope.Abs plus(final AngleSlope.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSlope.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new AngleSlope.Abs(this.si + v.si, AngleSlopeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleslope scalar.
         */
        public final AngleSlope.Abs toAbs()
        {
            return new AngleSlope.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AngleSlope and AngleSlope, which results in a Dimensionless scalar.
         * @param v AngleSlope scalar
         * @return Dimensionless scalar as a division of AngleSlope and AngleSlope
         */
        public final Dimensionless.Rel divideBy(final AngleSlope.Abs v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of AngleSlope and AngleSlope, which results in a Dimensionless scalar.
         * @param v AngleSlope scalar
         * @return Dimensionless scalar as a division of AngleSlope and AngleSlope
         */
        public final Dimensionless.Rel divideBy(final AngleSlope.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<AngleSlopeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AngleSlope.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AngleSlope.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AngleSlopeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct AngleSlope.Abs scalar.
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
        public static AngleSlope.Abs interpolate(final AngleSlope.Abs zero, final AngleSlope.Abs one, final float ratio)
        {
            return new AngleSlope.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AngleSlope.Abs interpolate(final AngleSlope.Abs zero, final AngleSlope.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs abs()
        {
            return new AngleSlope.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs acos()
        {
            return new AngleSlope.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs asin()
        {
            return new AngleSlope.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs atan()
        {
            return new AngleSlope.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs cbrt()
        {
            return new AngleSlope.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs ceil()
        {
            return new AngleSlope.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs cos()
        {
            return new AngleSlope.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs cosh()
        {
            return new AngleSlope.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs exp()
        {
            return new AngleSlope.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs expm1()
        {
            return new AngleSlope.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs floor()
        {
            return new AngleSlope.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs log()
        {
            return new AngleSlope.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs log10()
        {
            return new AngleSlope.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs log1p()
        {
            return new AngleSlope.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs rint()
        {
            return new AngleSlope.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs round()
        {
            return new AngleSlope.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs signum()
        {
            return new AngleSlope.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs sin()
        {
            return new AngleSlope.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs sinh()
        {
            return new AngleSlope.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs sqrt()
        {
            return new AngleSlope.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs tan()
        {
            return new AngleSlope.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs tanh()
        {
            return new AngleSlope.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs inv()
        {
            return new AngleSlope.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs toDegrees()
        {
            return new AngleSlope.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs toRadians()
        {
            return new AngleSlope.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs pow(final double x)
        {
            return new AngleSlope.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs multiplyBy(final float factor)
        {
            return new AngleSlope.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute angleslope
         */
        public final AngleSlope.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs divideBy(final float divisor)
        {
            return new AngleSlope.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute angleslope
         */
        public final AngleSlope.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSlope.Abs plus(final AngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSlope.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new AngleSlope.Abs(this.si + v.si, AngleSlopeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AngleSlope.Rel minus(final AngleSlope.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSlope.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new AngleSlope.Rel(this.si - v.si, AngleSlopeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AngleSlope.Abs minus(final AngleSlope.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSlope.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new AngleSlope.Abs(this.si - v.si, AngleSlopeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute angleslope scalar.
         */
        public final AngleSlope.Rel toRel()
        {
            return new AngleSlope.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AngleSlope and AngleSlope, which results in a Dimensionless scalar.
         * @param v AngleSlope scalar
         * @return Dimensionless scalar as a division of AngleSlope and AngleSlope
         */
        public final Dimensionless.Abs divideBy(final AngleSlope.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of AngleSlope and AngleSlope, which results in a Dimensionless scalar.
         * @param v AngleSlope scalar
         * @return Dimensionless scalar as a division of AngleSlope and AngleSlope
         */
        public final Dimensionless.Abs divideBy(final AngleSlope.Rel v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

    }
}
