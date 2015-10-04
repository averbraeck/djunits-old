package org.djunits.value.vdouble.scalar;

import org.djunits.unit.*;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the %Type% DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass.Rel margin = new Mass.Rel(0.2, KILOGRAM);</i><br>
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
public interface %Type%
{
    /**
     * Easy access methods for the %Type% DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;%Type%Unit&gt; value = new DoubleScalar.Rel&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>%Type%.Rel value = new %Type%.Rel(100.0, %Type%Unit.SI);</i><br>
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
    public static class Rel extends DoubleScalar.Rel<%Type%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %Type%.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %Type%.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<%Type%Unit> value)
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
        public static %Type%.Rel interpolate(final %Type%.Rel zero, final %Type%.Rel one, final double ratio)
        {
            return new %Type%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel abs()
        {
            return new %Type%.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel acos()
        {
            return new %Type%.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel asin()
        {
            return new %Type%.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel atan()
        {
            return new %Type%.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel cbrt()
        {
            return new %Type%.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel ceil()
        {
            return new %Type%.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel cos()
        {
            return new %Type%.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel cosh()
        {
            return new %Type%.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel exp()
        {
            return new %Type%.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel expm1()
        {
            return new %Type%.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel floor()
        {
            return new %Type%.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel log()
        {
            return new %Type%.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel log10()
        {
            return new %Type%.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel log1p()
        {
            return new %Type%.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel rint()
        {
            return new %Type%.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel round()
        {
            return new %Type%.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel signum()
        {
            return new %Type%.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel sin()
        {
            return new %Type%.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel sinh()
        {
            return new %Type%.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel sqrt()
        {
            return new %Type%.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel tan()
        {
            return new %Type%.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel tanh()
        {
            return new %Type%.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel inv()
        {
            return new %Type%.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel toDegrees()
        {
            return new %Type%.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel toRadians()
        {
            return new %Type%.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel pow(final double x)
        {
            return new %Type%.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel multiplyBy(final double factor)
        {
            return new %Type%.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel divideBy(final double divisor)
        {
            return new %Type%.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %Type%.Rel plus(final %Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %Type%.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new %Type%.Rel(this.si + v.si, %Type%Unit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final %Type%.Rel minus(final %Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %Type%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new %Type%.Rel(this.si - v.si, %Type%Unit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %Type%.Abs plus(final %Type%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new %Type%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new %Type%.Abs(this.si + v.si, %Type%Unit.SI);
        }

        /** 
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %type% scalar.
         */
        public final %Type%.Abs toAbs()
        {
            return new %Type%.Abs(getInUnit(), getUnit());
        }
        
%FORMULAS%%Type%.Rel%
    }

    /**
     * Easy access methods for the %Type% DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;%Type%Unit&gt; value = new DoubleScalar.Abs&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>%Type%.Abs value = new %Type%.Abs(100.0, %Type%Unit.SI);</i><br>
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
    public static class Abs extends DoubleScalar.Abs<%Type%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %Type%.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %Type%.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<%Type%Unit> value)
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
        public static %Type%.Abs interpolate(final %Type%.Abs zero, final %Type%.Abs one, final double ratio)
        {
            return new %Type%.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs abs()
        {
            return new %Type%.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs acos()
        {
            return new %Type%.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs asin()
        {
            return new %Type%.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs atan()
        {
            return new %Type%.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs cbrt()
        {
            return new %Type%.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs ceil()
        {
            return new %Type%.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs cos()
        {
            return new %Type%.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs cosh()
        {
            return new %Type%.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs exp()
        {
            return new %Type%.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs expm1()
        {
            return new %Type%.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs floor()
        {
            return new %Type%.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs log()
        {
            return new %Type%.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs log10()
        {
            return new %Type%.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs log1p()
        {
            return new %Type%.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs rint()
        {
            return new %Type%.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs round()
        {
            return new %Type%.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs signum()
        {
            return new %Type%.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs sin()
        {
            return new %Type%.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs sinh()
        {
            return new %Type%.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs sqrt()
        {
            return new %Type%.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs tan()
        {
            return new %Type%.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs tanh()
        {
            return new %Type%.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs inv()
        {
            return new %Type%.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs toDegrees()
        {
            return new %Type%.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs toRadians()
        {
            return new %Type%.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs pow(final double x)
        {
            return new %Type%.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %Type%.Abs plus(final %Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %Type%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new %Type%.Abs(this.si + v.si, %Type%Unit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final %Type%.Rel minus(final %Type%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new %Type%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new %Type%.Rel(this.si - v.si, %Type%Unit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final %Type%.Abs minus(final %Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new %Type%.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new %Type%.Abs(this.si - v.si, %Type%Unit.SI);
        }

        /** 
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute %type% scalar.
         */
        public final %Type%.Rel toRel()
        {
            return new %Type%.Rel(getInUnit(), getUnit());
        }

%FORMULAS%%Type%.Abs%
    }
}

