package org.djunits.value.vfloat.scalar;

import org.djunits.unit.*;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the %TYPE% FloatScalar. Instead of <br>
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
public interface %TYPE% extends UNITS
{
    /**
     * Easy access methods for the %TYPE% FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<%TYPE%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %TYPE%.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final %TYPE%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %TYPE%.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<%TYPE%Unit> value)
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
        public static %TYPE%.Rel interpolate(final %TYPE%.Rel zero, final %TYPE%.Rel one, final float ratio)
        {
            return new %TYPE%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel abs()
        {
            return new %TYPE%.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel acos()
        {
            return new %TYPE%.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel asin()
        {
            return new %TYPE%.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel atan()
        {
            return new %TYPE%.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel cbrt()
        {
            return new %TYPE%.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel ceil()
        {
            return new %TYPE%.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel cos()
        {
            return new %TYPE%.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel cosh()
        {
            return new %TYPE%.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel exp()
        {
            return new %TYPE%.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel expm1()
        {
            return new %TYPE%.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel floor()
        {
            return new %TYPE%.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel log()
        {
            return new %TYPE%.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel log10()
        {
            return new %TYPE%.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel log1p()
        {
            return new %TYPE%.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel rint()
        {
            return new %TYPE%.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel round()
        {
            return new %TYPE%.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel signum()
        {
            return new %TYPE%.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel sin()
        {
            return new %TYPE%.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel sinh()
        {
            return new %TYPE%.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel sqrt()
        {
            return new %TYPE%.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel tan()
        {
            return new %TYPE%.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel tanh()
        {
            return new %TYPE%.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel inv()
        {
            return new %TYPE%.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel toDegrees()
        {
            return new %TYPE%.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel toRadians()
        {
            return new %TYPE%.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel pow(final double x)
        {
            return new %TYPE%.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel multiplyBy(final float factor)
        {
            return new %TYPE%.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel divideBy(final float divisor)
        {
            return new %TYPE%.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %TYPE%.Rel plus(final %TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %TYPE%.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new %TYPE%.Rel(this.si + v.si, %TYPE%Unit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final %TYPE%.Rel minus(final %TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %TYPE%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new %TYPE%.Rel(this.si - v.si, %TYPE%Unit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %TYPE%.Abs plus(final %TYPE%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new %TYPE%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new %TYPE%.Abs(this.si + v.si, %TYPE%Unit.SI);
        }
%FORMULAS%%TYPE%.Rel%
    }

    /**
     * Easy access methods for the %TYPE% FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<%TYPE%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %TYPE%.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final %TYPE%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %TYPE%.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<%TYPE%Unit> value)
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
        public static %TYPE%.Abs interpolate(final %TYPE%.Abs zero, final %TYPE%.Abs one, final float ratio)
        {
            return new %TYPE%.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs abs()
        {
            return new %TYPE%.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs acos()
        {
            return new %TYPE%.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs asin()
        {
            return new %TYPE%.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs atan()
        {
            return new %TYPE%.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs cbrt()
        {
            return new %TYPE%.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs ceil()
        {
            return new %TYPE%.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs cos()
        {
            return new %TYPE%.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs cosh()
        {
            return new %TYPE%.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs exp()
        {
            return new %TYPE%.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs expm1()
        {
            return new %TYPE%.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs floor()
        {
            return new %TYPE%.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs log()
        {
            return new %TYPE%.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs log10()
        {
            return new %TYPE%.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs log1p()
        {
            return new %TYPE%.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs rint()
        {
            return new %TYPE%.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs round()
        {
            return new %TYPE%.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs signum()
        {
            return new %TYPE%.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs sin()
        {
            return new %TYPE%.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs sinh()
        {
            return new %TYPE%.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs sqrt()
        {
            return new %TYPE%.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs tan()
        {
            return new %TYPE%.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs tanh()
        {
            return new %TYPE%.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs inv()
        {
            return new %TYPE%.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs toDegrees()
        {
            return new %TYPE%.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs toRadians()
        {
            return new %TYPE%.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs pow(final double x)
        {
            return new %TYPE%.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs multiplyBy(final float factor)
        {
            return new %TYPE%.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs divideBy(final float divisor)
        {
            return new %TYPE%.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %TYPE%.Abs plus(final %TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %TYPE%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new %TYPE%.Abs(this.si + v.si, %TYPE%Unit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final %TYPE%.Rel minus(final %TYPE%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new %TYPE%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new %TYPE%.Rel(this.si - v.si, %TYPE%Unit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final %TYPE%.Abs minus(final %TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %TYPE%.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new %TYPE%.Abs(this.si - v.si, %TYPE%Unit.SI);
        }
%FORMULAS%%TYPE%.Abs%
    }
}
