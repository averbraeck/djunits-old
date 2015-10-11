package org.djunits.value.vfloat.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of <br>
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
public interface Float%Type%
{
    /**
     * Easy access methods for the %Type% FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;%Type%Unit&gt; value = new FloatScalar.Rel&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>Float%Type%.Rel value = new Float%Type%.Rel(100.0, %Type%Unit.SI);</i><br>
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
    public static class Rel extends FloatScalar.Rel<%Type%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Float%Type%.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Float%Type%.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final %Type%Unit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Float%Type%.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<%Type%Unit> value)
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
        public static Float%Type%.Rel interpolate(final Float%Type%.Rel zero, final Float%Type%.Rel one, final float ratio)
        {
            return new Float%Type%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Float%Type%.Rel interpolate(final Float%Type%.Rel zero, final Float%Type%.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel abs()
        {
            return new Float%Type%.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel acos()
        {
            return new Float%Type%.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel asin()
        {
            return new Float%Type%.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel atan()
        {
            return new Float%Type%.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel cbrt()
        {
            return new Float%Type%.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel ceil()
        {
            return new Float%Type%.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel cos()
        {
            return new Float%Type%.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel cosh()
        {
            return new Float%Type%.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel exp()
        {
            return new Float%Type%.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel expm1()
        {
            return new Float%Type%.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel floor()
        {
            return new Float%Type%.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel log()
        {
            return new Float%Type%.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel log10()
        {
            return new Float%Type%.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel log1p()
        {
            return new Float%Type%.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel rint()
        {
            return new Float%Type%.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel round()
        {
            return new Float%Type%.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel signum()
        {
            return new Float%Type%.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel sin()
        {
            return new Float%Type%.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel sinh()
        {
            return new Float%Type%.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel sqrt()
        {
            return new Float%Type%.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel tan()
        {
            return new Float%Type%.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel tanh()
        {
            return new Float%Type%.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel inv()
        {
            return new Float%Type%.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel toDegrees()
        {
            return new Float%Type%.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel toRadians()
        {
            return new Float%Type%.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel pow(final double x)
        {
            return new Float%Type%.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel multiplyBy(final float factor)
        {
            return new Float%Type%.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative %type%
         */
        public final Float%Type%.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel divideBy(final float divisor)
        {
            return new Float%Type%.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative %type%
         */
        public final Float%Type%.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Float%Type%.Rel plus(final Float%Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%Type%.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Float%Type%.Rel(this.si + v.si, %Type%Unit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Float%Type%.Rel minus(final Float%Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%Type%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Float%Type%.Rel(this.si - v.si, %Type%Unit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Float%Type%.Abs plus(final Float%Type%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%Type%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Float%Type%.Abs(this.si + v.si, %Type%Unit.SI);
        }

        /** 
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %type% scalar.
         */
        public final Float%Type%.Abs toAbs()
        {
            return new Float%Type%.Abs(getInUnit(), getUnit());
        }

%FORMULAS%%Type%.Rel%
    }

    /**
     * Easy access methods for the %Type% FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;%Type%Unit&gt; value = new FloatScalar.Abs&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>Float%Type%.Abs value = new Float%Type%.Abs(100.0, %Type%Unit.SI);</i><br>
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
    public static class Abs extends FloatScalar.Abs<%Type%Unit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Float%Type%.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Float%Type%.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final %Type%Unit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Float%Type%.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<%Type%Unit> value)
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
        public static Float%Type%.Abs interpolate(final Float%Type%.Abs zero, final Float%Type%.Abs one, final float ratio)
        {
            return new Float%Type%.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Float%Type%.Abs interpolate(final Float%Type%.Abs zero, final Float%Type%.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs abs()
        {
            return new Float%Type%.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs acos()
        {
            return new Float%Type%.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs asin()
        {
            return new Float%Type%.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs atan()
        {
            return new Float%Type%.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs cbrt()
        {
            return new Float%Type%.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs ceil()
        {
            return new Float%Type%.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs cos()
        {
            return new Float%Type%.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs cosh()
        {
            return new Float%Type%.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs exp()
        {
            return new Float%Type%.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs expm1()
        {
            return new Float%Type%.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs floor()
        {
            return new Float%Type%.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs log()
        {
            return new Float%Type%.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs log10()
        {
            return new Float%Type%.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs log1p()
        {
            return new Float%Type%.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs rint()
        {
            return new Float%Type%.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs round()
        {
            return new Float%Type%.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs signum()
        {
            return new Float%Type%.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs sin()
        {
            return new Float%Type%.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs sinh()
        {
            return new Float%Type%.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs sqrt()
        {
            return new Float%Type%.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs tan()
        {
            return new Float%Type%.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs tanh()
        {
            return new Float%Type%.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs inv()
        {
            return new Float%Type%.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs toDegrees()
        {
            return new Float%Type%.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs toRadians()
        {
            return new Float%Type%.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs pow(final double x)
        {
            return new Float%Type%.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Float%Type%.Abs plus(final Float%Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%Type%.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Float%Type%.Abs(this.si + v.si, %Type%Unit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Float%Type%.Rel minus(final Float%Type%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%Type%.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Float%Type%.Rel(this.si - v.si, %Type%Unit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Float%Type%.Abs minus(final Float%Type%.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Float%Type%.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Float%Type%.Abs(this.si - v.si, %Type%Unit.SI);
        }

        /** 
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute %type% scalar.
         */
        public final Float%Type%.Rel toRel()
        {
            return new Float%Type%.Rel(getInUnit(), getUnit());
        }
        
%FORMULAS%%Type%.Abs%
    }
}

