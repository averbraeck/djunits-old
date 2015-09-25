package org.djunits.value.vdouble.scalar;

import org.djunits.unit.*;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the %TYPE% DoubleScalar. Instead of <br>
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
public interface %TYPE%
{
    /**
     * Easy access methods for the %TYPE% DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<%TYPE%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %TYPE%.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final %TYPE%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %TYPE%.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<%TYPE%Unit> value)
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
        public static %TYPE%.Rel interpolate(final %TYPE%.Rel zero, final %TYPE%.Rel one, final double ratio)
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
            return new %TYPE%.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel asin()
        {
            return new %TYPE%.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel atan()
        {
            return new %TYPE%.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel cbrt()
        {
            return new %TYPE%.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel ceil()
        {
            return new %TYPE%.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel cos()
        {
            return new %TYPE%.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel cosh()
        {
            return new %TYPE%.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel exp()
        {
            return new %TYPE%.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel expm1()
        {
            return new %TYPE%.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel floor()
        {
            return new %TYPE%.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel log()
        {
            return new %TYPE%.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel log10()
        {
            return new %TYPE%.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel log1p()
        {
            return new %TYPE%.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel rint()
        {
            return new %TYPE%.Rel(Math.rint(getInUnit()), getUnit());
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
            return new %TYPE%.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel sinh()
        {
            return new %TYPE%.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel sqrt()
        {
            return new %TYPE%.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel tan()
        {
            return new %TYPE%.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel tanh()
        {
            return new %TYPE%.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel inv()
        {
            return new %TYPE%.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel toDegrees()
        {
            return new %TYPE%.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel toRadians()
        {
            return new %TYPE%.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel pow(final double x)
        {
            return new %TYPE%.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel multiplyBy(final double factor)
        {
            return new %TYPE%.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Rel divideBy(final double divisor)
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

        /** 
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %type% scalar.
         */
        public final %TYPE%.Abs toAbs()
        {
            return new %TYPE%.Abs(getInUnit(), getUnit());
        }
        
%FORMULAS%%TYPE%.Rel%
    }

    /**
     * Easy access methods for the %TYPE% DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<%TYPE%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %TYPE%.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final %TYPE%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %TYPE%.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<%TYPE%Unit> value)
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
        public static %TYPE%.Abs interpolate(final %TYPE%.Abs zero, final %TYPE%.Abs one, final double ratio)
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
            return new %TYPE%.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs asin()
        {
            return new %TYPE%.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs atan()
        {
            return new %TYPE%.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs cbrt()
        {
            return new %TYPE%.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs ceil()
        {
            return new %TYPE%.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs cos()
        {
            return new %TYPE%.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs cosh()
        {
            return new %TYPE%.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs exp()
        {
            return new %TYPE%.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs expm1()
        {
            return new %TYPE%.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs floor()
        {
            return new %TYPE%.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs log()
        {
            return new %TYPE%.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs log10()
        {
            return new %TYPE%.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs log1p()
        {
            return new %TYPE%.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs rint()
        {
            return new %TYPE%.Abs(Math.rint(getInUnit()), getUnit());
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
            return new %TYPE%.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs sinh()
        {
            return new %TYPE%.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs sqrt()
        {
            return new %TYPE%.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs tan()
        {
            return new %TYPE%.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs tanh()
        {
            return new %TYPE%.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs inv()
        {
            return new %TYPE%.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs toDegrees()
        {
            return new %TYPE%.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs toRadians()
        {
            return new %TYPE%.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %TYPE%.Abs pow(final double x)
        {
            return new %TYPE%.Abs(Math.pow(getInUnit(), x), getUnit());
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

        /** 
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute %type% scalar.
         */
        public final %TYPE%.Rel toRel()
        {
            return new %TYPE%.Rel(getInUnit(), getUnit());
        }

%FORMULAS%%TYPE%.Abs%
    }
}
