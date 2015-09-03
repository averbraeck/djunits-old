package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the AngleSolid FloatScalar. Instead of <br>
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
public interface AngleSolid extends UNITS
{
    /**
     * Easy access methods for the AngleSolid FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<AngleSolidUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AngleSolid.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AngleSolidUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AngleSolid.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final AngleSolidUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct AngleSolid.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<AngleSolidUnit> value)
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
        public static AngleSolid.Rel interpolate(final AngleSolid.Rel zero, final AngleSolid.Rel one, final float ratio)
        {
            return new AngleSolid.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AngleSolid.Rel interpolate(final AngleSolid.Rel zero, final AngleSolid.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel abs()
        {
            return new AngleSolid.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel acos()
        {
            return new AngleSolid.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel asin()
        {
            return new AngleSolid.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel atan()
        {
            return new AngleSolid.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel cbrt()
        {
            return new AngleSolid.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel ceil()
        {
            return new AngleSolid.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel cos()
        {
            return new AngleSolid.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel cosh()
        {
            return new AngleSolid.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel exp()
        {
            return new AngleSolid.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel expm1()
        {
            return new AngleSolid.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel floor()
        {
            return new AngleSolid.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel log()
        {
            return new AngleSolid.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel log10()
        {
            return new AngleSolid.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel log1p()
        {
            return new AngleSolid.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel rint()
        {
            return new AngleSolid.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel round()
        {
            return new AngleSolid.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel signum()
        {
            return new AngleSolid.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel sin()
        {
            return new AngleSolid.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel sinh()
        {
            return new AngleSolid.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel sqrt()
        {
            return new AngleSolid.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel tan()
        {
            return new AngleSolid.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel tanh()
        {
            return new AngleSolid.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel inv()
        {
            return new AngleSolid.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel toDegrees()
        {
            return new AngleSolid.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel toRadians()
        {
            return new AngleSolid.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel pow(final double x)
        {
            return new AngleSolid.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel multiplyBy(final float factor)
        {
            return new AngleSolid.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative anglesolid
         */
        public final AngleSolid.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Rel divideBy(final float divisor)
        {
            return new AngleSolid.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative anglesolid
         */
        public final AngleSolid.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSolid.Rel plus(final AngleSolid.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSolid.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new AngleSolid.Rel(this.si + v.si, AngleSolidUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AngleSolid.Rel minus(final AngleSolid.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSolid.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new AngleSolid.Rel(this.si - v.si, AngleSolidUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSolid.Abs plus(final AngleSolid.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSolid.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new AngleSolid.Abs(this.si + v.si, AngleSolidUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative anglesolid scalar.
         */
        public final AngleSolid.Abs toAbs()
        {
            return new AngleSolid.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
         * @param v AngleSolid scalar
         * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
         */
        public final Dimensionless.Rel divideBy(final AngleSolid.Abs v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
         * @param v AngleSolid scalar
         * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
         */
        public final Dimensionless.Rel divideBy(final AngleSolid.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AngleSolid FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<AngleSolidUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AngleSolid.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AngleSolidUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AngleSolid.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AngleSolidUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct AngleSolid.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<AngleSolidUnit> value)
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
        public static AngleSolid.Abs interpolate(final AngleSolid.Abs zero, final AngleSolid.Abs one, final float ratio)
        {
            return new AngleSolid.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AngleSolid.Abs interpolate(final AngleSolid.Abs zero, final AngleSolid.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs abs()
        {
            return new AngleSolid.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs acos()
        {
            return new AngleSolid.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs asin()
        {
            return new AngleSolid.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs atan()
        {
            return new AngleSolid.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs cbrt()
        {
            return new AngleSolid.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs ceil()
        {
            return new AngleSolid.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs cos()
        {
            return new AngleSolid.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs cosh()
        {
            return new AngleSolid.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs exp()
        {
            return new AngleSolid.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs expm1()
        {
            return new AngleSolid.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs floor()
        {
            return new AngleSolid.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs log()
        {
            return new AngleSolid.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs log10()
        {
            return new AngleSolid.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs log1p()
        {
            return new AngleSolid.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs rint()
        {
            return new AngleSolid.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs round()
        {
            return new AngleSolid.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs signum()
        {
            return new AngleSolid.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs sin()
        {
            return new AngleSolid.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs sinh()
        {
            return new AngleSolid.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs sqrt()
        {
            return new AngleSolid.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs tan()
        {
            return new AngleSolid.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs tanh()
        {
            return new AngleSolid.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs inv()
        {
            return new AngleSolid.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs toDegrees()
        {
            return new AngleSolid.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs toRadians()
        {
            return new AngleSolid.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs pow(final double x)
        {
            return new AngleSolid.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs multiplyBy(final float factor)
        {
            return new AngleSolid.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute anglesolid
         */
        public final AngleSolid.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolid.Abs divideBy(final float divisor)
        {
            return new AngleSolid.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute anglesolid
         */
        public final AngleSolid.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSolid.Abs plus(final AngleSolid.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSolid.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new AngleSolid.Abs(this.si + v.si, AngleSolidUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AngleSolid.Rel minus(final AngleSolid.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSolid.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new AngleSolid.Rel(this.si - v.si, AngleSolidUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AngleSolid.Abs minus(final AngleSolid.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AngleSolid.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new AngleSolid.Abs(this.si - v.si, AngleSolidUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute anglesolid scalar.
         */
        public final AngleSolid.Rel toRel()
        {
            return new AngleSolid.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
         * @param v AngleSolid scalar
         * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
         */
        public final Dimensionless.Abs divideBy(final AngleSolid.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
         * @param v AngleSolid scalar
         * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
         */
        public final Dimensionless.Abs divideBy(final AngleSolid.Rel v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

    }
}
