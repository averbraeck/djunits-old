package org.djunits.value.vfloat.scalar;

import org.djunits.unit.*;

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
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Float%TYPE%
{
    /**
     * Easy access methods for the %TYPE% FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;%TYPE%Unit&gt; value = new FloatScalar.Rel&lt;%TYPE%Unit&gt;(100.0, %TYPE%Unit.SI);</i><br>
     * we can now write <br>
     * <i>Float%TYPE%.Rel value = new Float%TYPE%.Rel(100.0, %TYPE%Unit.SI);</i><br>
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
    public static class Rel extends FloatScalar.Rel<%TYPE%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Float%TYPE%.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final %TYPE%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Float%TYPE%.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final %TYPE%Unit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Float%TYPE%.Rel scalar.
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
        public static Float%TYPE%.Rel interpolate(final Float%TYPE%.Rel zero, final Float%TYPE%.Rel one, final float ratio)
        {
            return new Float%TYPE%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Float%TYPE%.Rel interpolate(final Float%TYPE%.Rel zero, final Float%TYPE%.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel abs()
        {
            return new Float%TYPE%.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel acos()
        {
            return new Float%TYPE%.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel asin()
        {
            return new Float%TYPE%.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel atan()
        {
            return new Float%TYPE%.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel cbrt()
        {
            return new Float%TYPE%.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel ceil()
        {
            return new Float%TYPE%.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel cos()
        {
            return new Float%TYPE%.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel cosh()
        {
            return new Float%TYPE%.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel exp()
        {
            return new Float%TYPE%.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel expm1()
        {
            return new Float%TYPE%.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel floor()
        {
            return new Float%TYPE%.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel log()
        {
            return new Float%TYPE%.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel log10()
        {
            return new Float%TYPE%.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel log1p()
        {
            return new Float%TYPE%.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel rint()
        {
            return new Float%TYPE%.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel round()
        {
            return new Float%TYPE%.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel signum()
        {
            return new Float%TYPE%.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel sin()
        {
            return new Float%TYPE%.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel sinh()
        {
            return new Float%TYPE%.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel sqrt()
        {
            return new Float%TYPE%.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel tan()
        {
            return new Float%TYPE%.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel tanh()
        {
            return new Float%TYPE%.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel inv()
        {
            return new Float%TYPE%.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel toDegrees()
        {
            return new Float%TYPE%.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel toRadians()
        {
            return new Float%TYPE%.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel pow(final double x)
        {
            return new Float%TYPE%.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel multiplyBy(final float factor)
        {
            return new Float%TYPE%.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative %type%
         */
        public final Float%TYPE%.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Rel divideBy(final float divisor)
        {
            return new Float%TYPE%.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative %type%
         */
        public final Float%TYPE%.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Float%TYPE%.Rel plus(final Float%TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%TYPE%.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Float%TYPE%.Rel(this.si + v.si, %TYPE%Unit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Float%TYPE%.Rel minus(final Float%TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%TYPE%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Float%TYPE%.Rel(this.si - v.si, %TYPE%Unit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Float%TYPE%.Abs plus(final Float%TYPE%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%TYPE%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Float%TYPE%.Abs(this.si + v.si, %TYPE%Unit.SI);
        }

        /** 
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %type% scalar.
         */
        public final Float%TYPE%.Abs toAbs()
        {
            return new Float%TYPE%.Abs(getInUnit(), getUnit());
        }

%FORMULAS%%TYPE%.Rel%
    }

    /**
     * Easy access methods for the %TYPE% FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;%TYPE%Unit&gt; value = new FloatScalar.Abs&lt;%TYPE%Unit&gt;(100.0, %TYPE%Unit.SI);</i><br>
     * we can now write <br>
     * <i>Float%TYPE%.Abs value = new Float%TYPE%.Abs(100.0, %TYPE%Unit.SI);</i><br>
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
    public static class Abs extends FloatScalar.Abs<%TYPE%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Float%TYPE%.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final %TYPE%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Float%TYPE%.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final %TYPE%Unit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Float%TYPE%.Abs scalar.
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
        public static Float%TYPE%.Abs interpolate(final Float%TYPE%.Abs zero, final Float%TYPE%.Abs one, final float ratio)
        {
            return new Float%TYPE%.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Float%TYPE%.Abs interpolate(final Float%TYPE%.Abs zero, final Float%TYPE%.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs abs()
        {
            return new Float%TYPE%.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs acos()
        {
            return new Float%TYPE%.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs asin()
        {
            return new Float%TYPE%.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs atan()
        {
            return new Float%TYPE%.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs cbrt()
        {
            return new Float%TYPE%.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs ceil()
        {
            return new Float%TYPE%.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs cos()
        {
            return new Float%TYPE%.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs cosh()
        {
            return new Float%TYPE%.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs exp()
        {
            return new Float%TYPE%.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs expm1()
        {
            return new Float%TYPE%.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs floor()
        {
            return new Float%TYPE%.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs log()
        {
            return new Float%TYPE%.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs log10()
        {
            return new Float%TYPE%.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs log1p()
        {
            return new Float%TYPE%.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs rint()
        {
            return new Float%TYPE%.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs round()
        {
            return new Float%TYPE%.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs signum()
        {
            return new Float%TYPE%.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs sin()
        {
            return new Float%TYPE%.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs sinh()
        {
            return new Float%TYPE%.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs sqrt()
        {
            return new Float%TYPE%.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs tan()
        {
            return new Float%TYPE%.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs tanh()
        {
            return new Float%TYPE%.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs inv()
        {
            return new Float%TYPE%.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs toDegrees()
        {
            return new Float%TYPE%.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs toRadians()
        {
            return new Float%TYPE%.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%TYPE%.Abs pow(final double x)
        {
            return new Float%TYPE%.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Float%TYPE%.Abs plus(final Float%TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%TYPE%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Float%TYPE%.Abs(this.si + v.si, %TYPE%Unit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Float%TYPE%.Rel minus(final Float%TYPE%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%TYPE%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Float%TYPE%.Rel(this.si - v.si, %TYPE%Unit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Float%TYPE%.Abs minus(final Float%TYPE%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%TYPE%.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Float%TYPE%.Abs(this.si - v.si, %TYPE%Unit.SI);
        }

        /** 
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute %type% scalar.
         */
        public final Float%TYPE%.Rel toRel()
        {
            return new Float%TYPE%.Rel(getInUnit(), getUnit());
        }
        
%FORMULAS%%TYPE%.Abs%
    }
}
