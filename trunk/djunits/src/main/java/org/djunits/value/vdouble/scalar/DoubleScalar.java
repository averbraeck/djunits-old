package org.djunits.value.vdouble.scalar;

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
import org.djunits.value.vdouble.DoubleMathFunctions;

/**
 * Immutable DoubleScalar, with Abs and Rel static subclasses.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit; the unit of this DoubleScalar
 */
public abstract class DoubleScalar<U extends Unit<U>> extends Scalar<U> implements DoubleMathFunctions<DoubleScalar<U>>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Immutable DoubleScalar.
     * @param unit U; the unit of the new DoubleScalar
     */
    protected DoubleScalar(final U unit)
    {
        super(unit);
    }

    /**
     * Absolute Immutable DoubleScalar.
     * @param <U> Unit
     */
    public static class Abs<U extends Unit<U>> extends DoubleScalar<U> implements Absolute, Comparable<Abs<U>>,
        MathFunctionsAbs<DoubleScalar.Abs<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /** The value, stored in the standard SI unit. */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        public final double si;

        /**
         * Construct a new Absolute Immutable DoubleScalar.
         * @param value double; the value of the new Absolute Immutable DoubleScalar
         * @param unit U; the unit of the new Absolute Immutable DoubleScalar
         */
        public Abs(final double value, final U unit)
        {
            super(unit);
            this.si = unit.equals(unit.getStandardUnit()) ? value : expressAsSIUnit(value);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar from an existing Absolute Immutable DoubleScalar.
         * @param value DoubleScalar.Abs&lt;U&gt;; the reference
         */
        public Abs(final DoubleScalar.Abs<U> value)
        {
            super(value.getUnit());
            this.si = value.si;
        }

        /** {@inheritDoc} */
        @Override
        public final int compareTo(final Abs<U> o)
        {
            return new Double(this.si).compareTo(o.si);
        }

        /**
         * Retrieve the value in the underlying SI unit.
         * @return double
         */
        public final double getSI()
        {
            return this.si;
        }

        /**
         * Test if this DoubleScalar.Abs&lt;U&gt; is less than a DoubleScalar.Abs&lt;U&gt;.
         * @param o DoubleScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean lt(final DoubleScalar.Abs<U> o)
        {
            return this.si < o.si;
        }

        /**
         * Test if this DoubleScalar.Abs&lt;U&gt; is less than or equal to a DoubleScalar.Abs&lt;U&gt;.
         * @param o DoubleScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean le(final DoubleScalar.Abs<U> o)
        {
            return this.si <= o.si;
        }

        /**
         * Test if this DoubleScalar.Abs&lt;U&gt; is greater than or equal to a DoubleScalar.Abs&lt;U&gt;.
         * @param o DoubleScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean gt(final DoubleScalar.Abs<U> o)
        {
            return this.si > o.si;
        }

        /**
         * Test if this DoubleScalar.Abs&lt;U&gt; is greater than a DoubleScalar.Abs&lt;U&gt;.
         * @param o DoubleScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ge(final DoubleScalar.Abs<U> o)
        {
            return this.si >= o.si;
        }

        /**
         * Test if this DoubleScalar.Abs&lt;U&gt; is equal to a DoubleScalar.Abs&lt;U&gt;.
         * @param o DoubleScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean eq(final DoubleScalar.Abs<U> o)
        {
            return this.si == o.si;
        }

        /**
         * Test if this DoubleScalar.Abs&lt;U&gt; is not equal to a DoubleScalar.Abs&lt;U&gt;.
         * @param o DoubleScalar.Abs&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ne(final DoubleScalar.Abs<U> o)
        {
            return this.si != o.si;
        }

        /**
         * Increment the value by the supplied value and return the result.
         * @param increment DoubleScalar.Rel&lt;U&gt;; amount by which the value is incremented
         * @return DoubleScalar.Abs&lt;U&gt;
         */
        public final DoubleScalar.Abs<U> plus(final DoubleScalar.Rel<U> increment)
        {
            return plus(this, increment);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement DoubleScalar.Rel&lt;U&gt;; amount by which the value is decremented
         * @return DoubleScalar.Abs&lt;U&gt;
         */
        public final DoubleScalar.Abs<U> minus(final DoubleScalar.Rel<U> decrement)
        {
            return minus(this, decrement);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement DoubleScalar.Abs&lt;U&gt;; amount by which the value is decremented
         * @return DoubleScalar.Rel&lt;U&gt;
         */
        public final DoubleScalar.Rel<U> minus(final DoubleScalar.Abs<U> decrement)
        {
            return minus(this, decrement);
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Abs<U> ceil()
        {
            return new DoubleScalar.Abs<U>(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Abs<U> floor()
        {
            return new DoubleScalar.Abs<U>(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Abs<U> rint()
        {
            return new DoubleScalar.Abs<U>(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Abs<U> round()
        {
            return new DoubleScalar.Abs<U>(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Abs<U> multiplyBy(final double constant)
        {
            return new DoubleScalar.Abs<U>(getInUnit() * constant, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Abs<U> divideBy(final double constant)
        {
            return new DoubleScalar.Abs<U>(getInUnit() / constant, getUnit());
        }
    }

    /**
     * Relative Immutable DoubleScalar.
     * @param <U> Unit
     */
    public static class Rel<U extends Unit<U>> extends DoubleScalar<U> implements Relative, Comparable<Rel<U>>,
        MathFunctionsRel<DoubleScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /** The value, stored in the standard SI unit. */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        public final double si;

        /**
         * Construct a new Relative Immutable DoubleScalar.
         * @param value double; the value of the new Relative Immutable DoubleScalar
         * @param unit U; the unit of the new Relative Immutable DoubleScalar
         */
        public Rel(final double value, final U unit)
        {
            super(unit);
            this.si = unit.equals(unit.getStandardUnit()) ? value : expressAsSIUnit(value);
        }

        /**
         * Construct a new Relative Immutable DoubleScalar from an existing Relative Immutable DoubleScalar.
         * @param value DoubleScalar.Rel&lt;U&gt;; the reference
         */
        public Rel(final DoubleScalar.Rel<U> value)
        {
            super(value.getUnit());
            this.si = value.si;
        }

        /** {@inheritDoc} */
        @Override
        public final int compareTo(final Rel<U> o)
        {
            return new Double(this.si).compareTo(o.si);
        }

        /**
         * Retrieve the value in the underlying SI unit.
         * @return double
         */
        public final double getSI()
        {
            return this.si;
        }

        /**
         * Test if this DoubleScalar.Rel&lt;U&gt; is less than a DoubleScalar.Rel&lt;U&gt;.
         * @param o DoubleScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean lt(final DoubleScalar.Rel<U> o)
        {
            return this.si < o.si;
        }

        /**
         * Test if this DoubleScalar.Rel&lt;U&gt; is less than or equal to a DoubleScalar.Rel&lt;U&gt;.
         * @param o DoubleScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean le(final DoubleScalar.Rel<U> o)
        {
            return this.si <= o.si;
        }

        /**
         * Test if this DoubleScalar.Rel&lt;U&gt; is greater than or equal to a DoubleScalar.Rel&lt;U&gt;.
         * @param o DoubleScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean gt(final DoubleScalar.Rel<U> o)
        {
            return this.si > o.si;
        }

        /**
         * Test if this DoubleScalar.Rel&lt;U&gt; is greater than a DoubleScalar.Rel&lt;U&gt;.
         * @param o DoubleScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ge(final DoubleScalar.Rel<U> o)
        {
            return this.si >= o.si;
        }

        /**
         * Test if this DoubleScalar.Rel&lt;U&gt; is equal to a DoubleScalar.Rel&lt;U&gt;.
         * @param o DoubleScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean eq(final DoubleScalar.Rel<U> o)
        {
            return this.si == o.si;
        }

        /**
         * Test if this DoubleScalar.Rel&lt;U&gt; is not equal to a DoubleScalar.Rel&lt;U&gt;.
         * @param o DoubleScalar.Rel&lt;U&gt;; the right hand side operand of the comparison
         * @return boolean
         */
        public final boolean ne(final DoubleScalar.Rel<U> o)
        {
            return this.si != o.si;
        }

        /**
         * Increment the value by the supplied value and return the result.
         * @param increment DoubleScalar.Rel&lt;U&gt;; amount by which the value is incremented
         * @return DoubleScalar.Abs&lt;U&gt;
         */
        public final DoubleScalar.Rel<U> plus(final DoubleScalar.Rel<U> increment)
        {
            return plus(this, increment);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement DoubleScalar.Rel&lt;U&gt;; amount by which the value is decremented
         * @return DoubleScalar.Rel&lt;U&gt;
         */
        public final DoubleScalar.Rel<U> minus(final DoubleScalar.Rel<U> decrement)
        {
            return minus(this, decrement);
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> abs()
        {
            return new DoubleScalar.Rel<U>(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> ceil()
        {
            return new DoubleScalar.Rel<U>(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> floor()
        {
            return new DoubleScalar.Rel<U>(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> rint()
        {
            return new DoubleScalar.Rel<U>(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> round()
        {
            return new DoubleScalar.Rel<U>(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> multiplyBy(final double constant)
        {
            return new DoubleScalar.Rel<U>(getInUnit() * constant, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("checkstyle:designforextension")
        public DoubleScalar.Rel<U> divideBy(final double constant)
        {
            return new DoubleScalar.Rel<U>(getInUnit() / constant, getUnit());
        }

    }

    /**
     * Retrieve the value in the underlying SI unit.
     * @return double
     */
    public abstract double getSI();

    /**
     * Retrieve the value in the original unit.
     * @return double
     */
    public final double getInUnit()
    {
        return expressAsSpecifiedUnit(getSI());
    }

    /**
     * Retrieve the value converted into some specified unit.
     * @param targetUnit U; the unit to convert the value into
     * @return double
     */
    public final double getInUnit(final U targetUnit)
    {
        return ValueUtil.expressAsUnit(getSI(), targetUnit);
    }

    /**********************************************************************************/
    /********************************* NUMBER METHODS *********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final int intValue()
    {
        return (int) Math.round(getSI());
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
        return (float) getSI();
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
     * Print this DoubleScalar with the value expressed in the specified unit.
     * @param displayUnit U; the unit into which the value is converted for display
     * @return String; printable string with the scalar contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this DoubleScalar with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the scalar contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this DoubleScalar with the value expressed in the specified unit.
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
            if (this instanceof DoubleScalar.Abs)
            {
                buf.append("Abs ");
            }
            else if (this instanceof DoubleScalar.Rel)
            {
                buf.append("Rel ");
            }
            else
            {
                buf.append("??? ");
            }
        }
        double d = ValueUtil.expressAsUnit(getSI(), displayUnit);
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
        long temp;
        temp = Double.doubleToLongBits(this.getSI());
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        if (!(obj instanceof DoubleScalar))
        {
            return false;
        }
        DoubleScalar<?> other = (DoubleScalar<?>) obj;
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
        if (Double.doubleToLongBits(this.getSI()) != Double.doubleToLongBits(other.getSI()))
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
     * @param left DoubleScalar.Abs&lt;U&gt;; the left argument
     * @param right DoubleScalar.Rel&lt;U&gt;; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Abs&lt;U&gt;; the sum of the values as an Absolute value
     */
    public static <U extends Unit<U>> DoubleScalar.Abs<U> plus(final DoubleScalar.Abs<U> left,
        final DoubleScalar.Rel<U> right)
    {
        return new DoubleScalar.Abs<U>(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Add an Absolute value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left DoubleScalar.Abs&lt;U&gt;; the left argument
     * @param right DoubleScalar.Rel&lt;U&gt;; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Abs&lt;U&gt;; the sum of the values as an Absolute value
     */
    public static <U extends Unit<U>> DoubleScalar.Abs<U> plus(final DoubleScalar.Rel<U> left,
        final DoubleScalar.Abs<U> right)
    {
        return new DoubleScalar.Abs<U>(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Add a Relative value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left DoubleScalar.Rel&lt;U&gt;; the left argument
     * @param right DoubleScalar.Rel&lt;U&gt;; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Rel&lt;U&gt;; the sum of the values as a Relative value
     */
    public static <U extends Unit<U>> DoubleScalar.Rel<U> plus(final DoubleScalar.Rel<U> left,
        final DoubleScalar.Rel<U> right)
    {
        return new DoubleScalar.Rel<U>(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract a Relative value from an absolute value. Return a new instance of the value. The unit of the return value will
     * be the unit of the left argument.
     * @param left DoubleScalar.Abs&lt;U&gt;; the left value
     * @param right DoubleScalar.Rel&lt;U&gt;; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Abs&lt;U&gt;; the resulting value as an absolute value
     */
    public static <U extends Unit<U>> DoubleScalar.Abs<U> minus(final DoubleScalar.Abs<U> left,
        final DoubleScalar.Rel<U> right)
    {
        return new DoubleScalar.Abs<U>(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract a relative value from a relative value. Return a new instance of the value. The unit of the value will be the
     * unit of the first argument.
     * @param left DoubleScalar.Rel&lt;U&gt;; the left value
     * @param right DoubleScalar.Rel&lt;U&gt;; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Rel&lt;U&gt;; the resulting value as a relative value
     */
    public static <U extends Unit<U>> DoubleScalar.Rel<U> minus(final DoubleScalar.Rel<U> left,
        final DoubleScalar.Rel<U> right)
    {
        return new DoubleScalar.Rel<U>(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract two absolute values. Return a new instance of a relative value of the difference. The unit of the value will be
     * the unit of the first argument.
     * @param left DoubleScalar.Abs&lt;U&gt;; value 1
     * @param right DoubleScalar.Abs&lt;U&gt;; value 2
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Rel&lt;U&gt;; the difference of the two absolute values as a relative value
     */
    public static <U extends Unit<U>> DoubleScalar.Rel<U> minus(final DoubleScalar.Abs<U> left,
        final DoubleScalar.Abs<U> right)
    {
        return new DoubleScalar.Rel<U>(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left DoubleScalar.Abs&lt;?&gt;; the left operand
     * @param right DoubleScalar.Abs&lt;?&gt;; the right operand
     * @return DoubleScalar.Abs&lt;SIUnit&gt;; the product of the two values
     */
    public static DoubleScalar.Abs<SIUnit> multiply(final DoubleScalar.Abs<?> left, final DoubleScalar.Abs<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.multiply(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new DoubleScalar.Abs<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left DoubleScalar.Rel&lt;?&gt;; the left operand
     * @param right DoubleScalar.Rel&lt;?&gt;; the right operand
     * @return DoubleScalar.Rel&lt;SIUnit&gt;; the product of the two values
     */
    public static DoubleScalar.Rel<SIUnit> multiply(final DoubleScalar.Rel<?> left, final DoubleScalar.Rel<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.multiply(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new DoubleScalar.Rel<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left DoubleScalar.Abs&lt;?&gt;; the left operand
     * @param right DoubleScalar.Abs&lt;?&gt;; the right operand
     * @return DoubleScalar.Abs&lt;SIUnit&gt;; the ratio of the two values
     */
    public static DoubleScalar.Abs<SIUnit> divide(final DoubleScalar.Abs<?> left, final DoubleScalar.Abs<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.divide(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new DoubleScalar.Abs<SIUnit>(left.getSI() / right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left DoubleScalar.Rel&lt;?&gt;; the left operand
     * @param right DoubleScalar.Rel&lt;?&gt;; the right operand
     * @return DoubleScalar.Rel&lt;SIUnit&gt;; the ratio of the two values
     */
    public static DoubleScalar.Rel<SIUnit> divide(final DoubleScalar.Rel<?> left, final DoubleScalar.Rel<?> right)
    {
        SIUnit targetUnit =
            Unit.lookupOrCreateSIUnitWithSICoefficients(SICoefficients.divide(left.getUnit().getSICoefficients(),
                right.getUnit().getSICoefficients()).toString());
        return new DoubleScalar.Rel<SIUnit>(left.getSI() / right.getSI(), targetUnit);
    }

    /**
     * Interpolate between or extrapolate over two values.
     * @param zero DoubleScalar.Abs&lt;U&gt;; zero reference (returned when ratio == 0)
     * @param one DoubleScalar.Abs&lt;U&gt;; one reference (returned when ratio == 1)
     * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Abs&lt;U&gt;
     */
    public static <U extends Unit<U>> DoubleScalar.Abs<U> interpolate(final DoubleScalar.Abs<U> zero,
        final DoubleScalar.Abs<U> one, final double ratio)
    {
        return new DoubleScalar.Abs<U>(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
            zero.getUnit());
    }

    /**
     * Interpolate between or extrapolate over two values.
     * @param zero DoubleScalar.Rel&lt;U&gt;; zero reference (returned when ratio == 0)
     * @param one DoubleScalar.Rel&lt;U&gt;; one reference (returned when ratio == 1)
     * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
     * @param <U> Unit; the unit of the parameters and the result
     * @return DoubleScalar.Rel&lt;U&gt;
     */
    public static <U extends Unit<U>> DoubleScalar.Rel<U> interpolate(final DoubleScalar.Rel<U> zero,
        final DoubleScalar.Rel<U> one, final double ratio)
    {
        return new DoubleScalar.Rel<U>(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
            zero.getUnit());
    }

}
