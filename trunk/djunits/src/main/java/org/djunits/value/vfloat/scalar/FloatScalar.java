package org.djunits.value.vfloat.scalar;

import org.djunits.unit.SICoefficients;
import org.djunits.unit.SIUnit;
import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.MathFunctionsAbs;
import org.djunits.value.MathFunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.Scalar;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.djunits.value.vfloat.FloatMathFunctions;

/**
 * Immutable FloatScalar.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit; the unit of this FloatScalar
 */
public abstract class FloatScalar<U extends Unit<U>> extends Scalar<U> implements FloatMathFunctions<FloatScalar<U>>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Immutable FloatScalar.
     * @param unit U; the unit of the new FloatScalar
     */
    protected FloatScalar(final U unit)
    {
        super(unit);
    }

    /**
     * @param <U> Unit
     */
    public static class Abs<U extends Unit<U>> extends FloatScalar<U> implements Absolute, Comparable<Abs<U>>,
        MathFunctionsAbs<FloatScalar.Abs<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /** The value, stored in the standard SI unit. */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        public final float si;

        /**
         * Construct a new Absolute Immutable FloatScalar.
         * @param value float; the value of the new Absolute Immutable FloatScalar
         * @param unit U; the unit of the new Absolute Immutable FloatScalar
         */
        public Abs(final float value, final U unit)
        {
            super(unit);
            this.si = unit.equals(unit.getStandardUnit()) ? value : (float) expressAsSIUnit(value);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar from an existing Absolute Immutable FloatScalar.
         * @param value FloatScalar.Abs&lt;U&gt;; the reference
         */
        public Abs(final FloatScalar.Abs<U> value)
        {
            super(value.getUnit());
            this.si = value.si;
        }

        /** {@inheritDoc} */
        @Override
        public final int compareTo(final Abs<U> o)
        {
            return new Float(this.si).compareTo(o.si);
        }

        /**
         * Retrieve the value in the underlying SI unit.
         * @return float
         */
        public final float getSI()
        {
            return this.si;
        }

        /**
         * Test if this FloatScalar.Abs&lt;U&gt; is less than a FloatScalar.Abs&lt;U&gt;.
         * @param o FloatScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean lt(final FloatScalar.Abs<U> o)
        {
            return this.si < o.si;
        }

        /**
         * Test if this FloatScalar.Abs&lt;U&gt; is less than or equal to a FloatScalar.Abs&lt;U&gt;.
         * @param o FloatScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean le(final FloatScalar.Abs<U> o)
        {
            return this.si <= o.si;
        }

        /**
         * Test if this FloatScalar.Abs&lt;U&gt; is greater than or equal to a FloatScalar.Abs&lt;U&gt;.
         * @param o FloatScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean gt(final FloatScalar.Abs<U> o)
        {
            return this.si > o.si;
        }

        /**
         * Test if this FloatScalar.Abs&lt;U&gt; is greater than a FloatScalar.Abs&lt;U&gt;.
         * @param o FloatScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ge(final FloatScalar.Abs<U> o)
        {
            return this.si >= o.si;
        }

        /**
         * Test if this FloatScalar.Abs&lt;U&gt; is equal to a FloatScalar.Abs&lt;U&gt;.
         * @param o FloatScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean eq(final FloatScalar.Abs<U> o)
        {
            return this.si == o.si;
        }

        /**
         * Test if this FloatScalar.Abs&lt;U&gt; is not equal to a FloatScalar.Abs&lt;U&gt;.
         * @param o FloatScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ne(final FloatScalar.Abs<U> o)
        {
            return this.si != o.si;
        }

        /**
         * Increment the value by the supplied value and return the result.
         * @param increment FloatScalar.Rel&lt;U&gt;; amount by which the value is incremented
         * @return FloatScalar.Abs&lt;U&gt;
         */
        public final FloatScalar.Abs<U> plus(final FloatScalar.Rel<U> increment)
        {
            return plus(this, increment);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement FloatScalar.Rel&lt;U&gt;; amount by which the value is decremented
         * @return FloatScalar.Abs&lt;U&gt;
         */
        public final FloatScalar.Abs<U> minus(final FloatScalar.Rel<U> decrement)
        {
            return minus(this, decrement);
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Abs<U> ceil()
        {
            return new FloatScalar.Abs<U>((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Abs<U> floor()
        {
            return new FloatScalar.Abs<U>((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Abs<U> rint()
        {
            return new FloatScalar.Abs<U>((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Abs<U> round()
        {
            return new FloatScalar.Abs<U>(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Abs<U> multiplyBy(final float constant)
        {
            return new FloatScalar.Abs<U>(getInUnit() * constant, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Abs<U> divideBy(final float constant)
        {
            return new FloatScalar.Abs<U>(getInUnit() / constant, getUnit());
        }

    }

    /**
     * @param <U> Unit
     */
    public static class Rel<U extends Unit<U>> extends FloatScalar<U> implements Relative, Comparable<Rel<U>>,
        MathFunctionsRel<FloatScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /** The value, stored in the standard SI unit. */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        public final float si;

        /**
         * Construct a new Relative Immutable FloatScalar.
         * @param value float; the value of the new Relative Immutable FloatScalar
         * @param unit U; the unit of the new Relative Immutable FloatScalar
         */
        public Rel(final float value, final U unit)
        {
            super(unit);
            this.si = (float) (unit.equals(unit.getStandardUnit()) ? value : expressAsSIUnit(value));
        }

        /**
         * Construct a new Relative Immutable FloatScalar from an existing Relative Immutable FloatScalar.
         * @param value FloatScalar.Rel&lt;U&gt;; the reference
         */
        public Rel(final FloatScalar.Rel<U> value)
        {
            super(value.getUnit());
            this.si = value.si;
        }

        /** {@inheritDoc} */
        @Override
        public final int compareTo(final Rel<U> o)
        {
            return new Float(this.si).compareTo(o.si);
        }

        /**
         * Retrieve the value in the underlying SI unit.
         * @return float
         */
        public final float getSI()
        {
            return this.si;
        }

        /**
         * Test if this FloatScalar.Rel&lt;U&gt; is less than a FloatScalar.Rel&lt;U&gt;.
         * @param o FloatScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean lt(final FloatScalar.Rel<U> o)
        {
            return this.si < o.si;
        }

        /**
         * Test if this FloatScalar.Rel&lt;U&gt; is less than or equal to a FloatScalar.Rel&lt;U&gt;.
         * @param o FloatScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean le(final FloatScalar.Rel<U> o)
        {
            return this.si <= o.si;
        }

        /**
         * Test if this FloatScalar.Rel&lt;U&gt; is greater than or equal to a FloatScalar.Rel&lt;U&gt;.
         * @param o FloatScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean gt(final FloatScalar.Rel<U> o)
        {
            return this.si > o.si;
        }

        /**
         * Test if this FloatScalar.Rel&lt;U&gt; is greater than a FloatScalar.Rel&lt;U&gt;.
         * @param o FloatScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ge(final FloatScalar.Rel<U> o)
        {
            return this.si >= o.si;
        }

        /**
         * Test if this FloatScalar.Rel&lt;U&gt; is equal to a FloatScalar.Rel&lt;U&gt;.
         * @param o FloatScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean eq(final FloatScalar.Rel<U> o)
        {
            return this.si == o.si;
        }

        /**
         * Test if this FloatScalar.Rel&lt;U&gt; is not equal to a FloatScalar.Rel&lt;U&gt;.
         * @param o FloatScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ne(final FloatScalar.Rel<U> o)
        {
            return this.si != o.si;
        }

        /**
         * Increment the value by the supplied value and return the result.
         * @param increment FloatScalar.Rel&lt;U&gt;; amount by which the value is incremented
         * @return FloatScalar.Abs&lt;U&gt;
         */
        public final FloatScalar.Rel<U> plus(final FloatScalar.Rel<U> increment)
        {
            return plus(this, increment);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement FloatScalar.Rel&lt;U&gt;; amount by which the value is decremented
         * @return FloatScalar.Rel&lt;U&gt;
         */
        public final FloatScalar.Rel<U> minus(final FloatScalar.Rel<U> decrement)
        {
            return minus(this, decrement);
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> abs()
        {
            return new FloatScalar.Rel<U>(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> ceil()
        {
            return new FloatScalar.Rel<U>((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> floor()
        {
            return new FloatScalar.Rel<U>((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> rint()
        {
            return new FloatScalar.Rel<U>((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> round()
        {
            return new FloatScalar.Rel<U>(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> multiplyBy(final float constant)
        {
            return new FloatScalar.Rel<U>(getInUnit() * constant, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public FloatScalar.Rel<U> divideBy(final float constant)
        {
            return new FloatScalar.Rel<U>(getInUnit() / constant, getUnit());
        }

    }

    /**
     * Retrieve the value in the underlying SI unit.
     * @return float
     */
    public abstract float getSI();

    /**
     * Retrieve the value in the original unit.
     * @return float
     */
    public final float getInUnit()
    {
        return (float) expressAsSpecifiedUnit(getSI());
    }

    /**
     * Retrieve the value converted into some specified unit.
     * @param targetUnit U; the unit to convert the value into
     * @return float
     */
    public final float getInUnit(final U targetUnit)
    {
        return (float) ValueUtil.expressAsUnit(getSI(), targetUnit);
    }

    /**********************************************************************************/
    /********************************* NUMBER METHODS *********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final int intValue()
    {
        return Math.round(getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final long longValue()
    {
        return Math.round(getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final float floatValue()
    {
        return getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final double doubleValue()
    {
        return getSI();
    }

    /** {@inheritDoc} */
    @Override
    public final String toString()
    {
        return toString(getUnit(), false, true);
    }

    /**
     * Print this FloatScalar with the value expressed in the specified unit.
     * @param displayUnit U; the unit into which the value is converted for display
     * @return String; printable string with the scalar contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this FloatScalar with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the scalar contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this FloatScalar with the value expressed in the specified unit.
     * @param displayUnit U; the unit into which the value is converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the scalar contents
     */
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            if (this instanceof FloatScalar.Abs)
            {
                buf.append("Abs ");
            }
            else if (this instanceof FloatScalar.Rel)
            {
                buf.append("Rel ");
            }
            else
            {
                buf.append("??? ");
            }
        }
        float d = (float) ValueUtil.expressAsUnit(getSI(), displayUnit);
        buf.append(Format.format(d));
        if (withUnit)
        {
            buf.append(displayUnit.getAbbreviation());
        }
        return buf.toString();
    }

    /** {@inheritDoc} */
    @Override
    public final int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(this.getSI());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof FloatScalar))
        {
            return false;
        }
        FloatScalar<?> other = (FloatScalar<?>) obj;
        // unequal if not both Absolute or both Relative
        if (this.isAbsolute() != other.isAbsolute() || this.isRelative() != other.isRelative())
        {
            return false;
        }
        // unequal if the standard SI units differ
        if (!this.getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
        {
            return false;
        }
        if (Float.floatToIntBits(this.getSI()) != Float.floatToIntBits(other.getSI()))
        {
            return false;
        }
        return true;
    }

    /**********************************************************************************/
    /********************************* STATIC METHODS *********************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to an Absolute value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left FloatScalar.Abs&lt;U&gt;; the left argument
     * @param right FloatScalar.Rel&lt;U&gt;; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Abs&lt;U&gt;; the sum of the values as an Absolute value
     */
    public static <U extends Unit<U>> FloatScalar.Abs<U> plus(final FloatScalar.Abs<U> left,
        final FloatScalar.Rel<U> right)
    {
        return new FloatScalar.Abs<U>(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Add an Absolute value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left FloatScalar.Abs&lt;U&gt;; the left argument
     * @param right FloatScalar.Rel&lt;U&gt;; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Abs&lt;U&gt;; the sum of the values as an Absolute value
     */
    public static <U extends Unit<U>> FloatScalar.Abs<U> plus(final FloatScalar.Rel<U> left,
        final FloatScalar.Abs<U> right)
    {
        return new FloatScalar.Abs<U>(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Add a Relative value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left FloatScalar.Rel&lt;U&gt;; the left argument
     * @param right FloatScalar.Rel&lt;U&gt;; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Rel&lt;U&gt;; the sum of the values as a Relative value
     */
    public static <U extends Unit<U>> FloatScalar.Rel<U> plus(final FloatScalar.Rel<U> left,
        final FloatScalar.Rel<U> right)
    {
        return new FloatScalar.Rel<U>(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract a Relative value from an absolute value. Return a new instance of the value. The unit of the return value will
     * be the unit of the left argument.
     * @param left FloatScalar.Abs&lt;U&gt;; the left value
     * @param right FloatScalar.Rel&lt;U&gt;; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Abs&lt;U&gt;; the resulting value as an absolute value
     */
    public static <U extends Unit<U>> FloatScalar.Abs<U> minus(final FloatScalar.Abs<U> left,
        final FloatScalar.Rel<U> right)
    {
        return new FloatScalar.Abs<U>(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract a relative value from a relative value. Return a new instance of the value. The unit of the value will be the
     * unit of the first argument.
     * @param left FloatScalar.Rel&lt;U&gt;; the left value
     * @param right FloatScalar.Rel&lt;U&gt;; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Rel&lt;U&gt;; the resulting value as a relative value
     */
    public static <U extends Unit<U>> FloatScalar.Rel<U> minus(final FloatScalar.Rel<U> left,
        final FloatScalar.Rel<U> right)
    {
        return new FloatScalar.Rel<U>(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract two absolute values. Return a new instance of a relative value of the difference. The unit of the value will be
     * the unit of the first argument.
     * @param left FloatScalar.Abs&lt;U&gt;; value 1
     * @param right FloatScalar.Abs&lt;U&gt;; value 2
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Rel&lt;U&gt;; the difference of the two absolute values as a relative value
     */
    public static <U extends Unit<U>> FloatScalar.Rel<U> minus(final FloatScalar.Abs<U> left,
        final FloatScalar.Abs<U> right)
    {
        return new FloatScalar.Rel<U>(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Abs&lt;?&gt;; the left operand
     * @param right FloatScalar.Abs&lt;?&gt;; the right operand
     * @return FloatScalar.Abs&lt;SIUnit&gt;; the product of the two values
     */
    public static FloatScalar.Abs<SIUnit> multiply(final FloatScalar.Abs<?> left, final FloatScalar.Abs<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.multiply(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Abs<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Rel&lt;?&gt;; the left operand
     * @param right FloatScalar.Rel&lt;?&gt;; the right operand
     * @return FloatScalar.Rel&lt;SIUnit&gt;; the product of the two values
     */
    public static FloatScalar.Rel<SIUnit> multiply(final FloatScalar.Rel<?> left, final FloatScalar.Rel<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.multiply(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Rel<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Abs&lt;?&gt;; the left operand
     * @param right FloatScalar.Abs&lt;?&gt;; the right operand
     * @return FloatScalar.Abs&lt;SIUnit&gt;; the ratio of the two values
     */
    public static FloatScalar.Abs<SIUnit> divide(final FloatScalar.Abs<?> left, final FloatScalar.Abs<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.divide(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Abs<SIUnit>(left.getSI() / right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Rel&lt;?&gt;; the left operand
     * @param right FloatScalar.Rel&lt;?&gt;; the right operand
     * @return FloatScalar.Rel&lt;SIUnit&gt;; the ratio of the two values
     */
    public static FloatScalar.Rel<SIUnit> divide(final FloatScalar.Rel<?> left, final FloatScalar.Rel<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.divide(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Rel<SIUnit>(left.getSI() / right.getSI(), targetUnit);
    }

    /**
     * Interpolate between or extrapolate over two values.
     * @param zero FloatScalar.Abs&lt;U&gt;; zero reference (returned when ratio == 0)
     * @param one FloatScalar.Abs&lt;U&gt;; one reference (returned when ratio == 1)
     * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Abs&lt;U&gt;
     */
    public static <U extends Unit<U>> FloatScalar.Abs<U> interpolate(final FloatScalar.Abs<U> zero,
        final FloatScalar.Abs<U> one, final float ratio)
    {
        return new FloatScalar.Abs<U>(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between or extrapolate over two values.
     * @param zero FloatScalar.Rel&lt;U&gt;; zero reference (returned when ratio == 0)
     * @param one FloatScalar.Rel&lt;U&gt;; one reference (returned when ratio == 1)
     * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
     * @param <U> Unit; the unit of the parameters and the result
     * @return FloatScalar.Rel&lt;U&gt;
     */
    public static <U extends Unit<U>> FloatScalar.Rel<U> interpolate(final FloatScalar.Rel<U> zero,
        final FloatScalar.Rel<U> one, final float ratio)
    {
        return new FloatScalar.Rel<U>(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

}
