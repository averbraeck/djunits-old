package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the LinearDensity FloatScalar. Instead of <br>
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
public interface LinearDensity extends UNITS
{
    /**
     * Easy access methods for the LinearDensity FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<LinearDensityUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct LinearDensity.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final LinearDensityUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct LinearDensity.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<LinearDensityUnit> value)
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
        public static LinearDensity.Rel interpolate(final LinearDensity.Rel zero, final LinearDensity.Rel one,
            final float ratio)
        {
            return new LinearDensity.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel abs()
        {
            return new LinearDensity.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel acos()
        {
            return new LinearDensity.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel asin()
        {
            return new LinearDensity.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel atan()
        {
            return new LinearDensity.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel cbrt()
        {
            return new LinearDensity.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel ceil()
        {
            return new LinearDensity.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel cos()
        {
            return new LinearDensity.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel cosh()
        {
            return new LinearDensity.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel exp()
        {
            return new LinearDensity.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel expm1()
        {
            return new LinearDensity.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel floor()
        {
            return new LinearDensity.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel log()
        {
            return new LinearDensity.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel log10()
        {
            return new LinearDensity.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel log1p()
        {
            return new LinearDensity.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel rint()
        {
            return new LinearDensity.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel round()
        {
            return new LinearDensity.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel signum()
        {
            return new LinearDensity.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel sin()
        {
            return new LinearDensity.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel sinh()
        {
            return new LinearDensity.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel sqrt()
        {
            return new LinearDensity.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel tan()
        {
            return new LinearDensity.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel tanh()
        {
            return new LinearDensity.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel inv()
        {
            return new LinearDensity.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel toDegrees()
        {
            return new LinearDensity.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel toRadians()
        {
            return new LinearDensity.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel pow(final double x)
        {
            return new LinearDensity.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel multiplyBy(final float factor)
        {
            return new LinearDensity.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Rel divideBy(final float divisor)
        {
            return new LinearDensity.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final LinearDensity.Rel plus(final LinearDensity.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new LinearDensity.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new LinearDensity.Rel(this.si + v.si, LinearDensityUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final LinearDensity.Rel minus(final LinearDensity.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new LinearDensity.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new LinearDensity.Rel(this.si - v.si, LinearDensityUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final LinearDensity.Abs plus(final LinearDensity.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new LinearDensity.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new LinearDensity.Abs(this.si + v.si, LinearDensityUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Dimensionless scalar as a division of LinearDensity and LinearDensity
         */
        public final Dimensionless.Rel divideBy(final LinearDensity.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Length scalar as a multiplication of LinearDensity and Area
         */
        public final Length.Rel multiplyBy(final Area.Rel v)
        {
            return new Length.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Force scalar as a multiplication of LinearDensity and Energy
         */
        public final Force.Rel multiplyBy(final Energy.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Frequency scalar as a multiplication of LinearDensity and Speed
         */
        public final Frequency.Rel multiplyBy(final Speed.Rel v)
        {
            return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI);
        }

    }

    /**
     * Easy access methods for the LinearDensity FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<LinearDensityUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct LinearDensity.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final LinearDensityUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct LinearDensity.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<LinearDensityUnit> value)
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
        public static LinearDensity.Abs interpolate(final LinearDensity.Abs zero, final LinearDensity.Abs one,
            final float ratio)
        {
            return new LinearDensity.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs abs()
        {
            return new LinearDensity.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs acos()
        {
            return new LinearDensity.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs asin()
        {
            return new LinearDensity.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs atan()
        {
            return new LinearDensity.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs cbrt()
        {
            return new LinearDensity.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs ceil()
        {
            return new LinearDensity.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs cos()
        {
            return new LinearDensity.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs cosh()
        {
            return new LinearDensity.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs exp()
        {
            return new LinearDensity.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs expm1()
        {
            return new LinearDensity.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs floor()
        {
            return new LinearDensity.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs log()
        {
            return new LinearDensity.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs log10()
        {
            return new LinearDensity.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs log1p()
        {
            return new LinearDensity.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs rint()
        {
            return new LinearDensity.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs round()
        {
            return new LinearDensity.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs signum()
        {
            return new LinearDensity.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs sin()
        {
            return new LinearDensity.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs sinh()
        {
            return new LinearDensity.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs sqrt()
        {
            return new LinearDensity.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs tan()
        {
            return new LinearDensity.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs tanh()
        {
            return new LinearDensity.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs inv()
        {
            return new LinearDensity.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs toDegrees()
        {
            return new LinearDensity.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs toRadians()
        {
            return new LinearDensity.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs pow(final double x)
        {
            return new LinearDensity.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs multiplyBy(final float factor)
        {
            return new LinearDensity.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final LinearDensity.Abs divideBy(final float divisor)
        {
            return new LinearDensity.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final LinearDensity.Abs plus(final LinearDensity.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new LinearDensity.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new LinearDensity.Abs(this.si + v.si, LinearDensityUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final LinearDensity.Rel minus(final LinearDensity.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new LinearDensity.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new LinearDensity.Rel(this.si - v.si, LinearDensityUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final LinearDensity.Abs minus(final LinearDensity.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new LinearDensity.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new LinearDensity.Abs(this.si - v.si, LinearDensityUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Dimensionless scalar as a division of LinearDensity and LinearDensity
         */
        public final Dimensionless.Abs divideBy(final LinearDensity.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Length scalar as a multiplication of LinearDensity and Area
         */
        public final Length.Abs multiplyBy(final Area.Abs v)
        {
            return new Length.Abs(this.si * v.si, LengthUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Force scalar as a multiplication of LinearDensity and Energy
         */
        public final Force.Abs multiplyBy(final Energy.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * @param v LinearDensity scalar
         * @return Frequency scalar as a multiplication of LinearDensity and Speed
         */
        public final Frequency.Abs multiplyBy(final Speed.Abs v)
        {
            return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI);
        }

    }
}
