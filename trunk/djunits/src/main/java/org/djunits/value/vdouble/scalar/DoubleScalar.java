package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AbsoluteLinearUnit;
import org.djunits.unit.SICoefficients;
import org.djunits.unit.SIUnit;
import org.djunits.unit.Unit;

/**
 * Immutable DoubleScalar, with Abs and Rel static subclasses.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class DoubleScalar
{
    /**
     * Absolute Immutable DoubleScalar.
     * @param <AU> Absolute unit
     * @param <RU> Relative unit
     */
    public static class Abs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>>
            extends AbstractDoubleScalarAbs<AU, DoubleScalar.Abs<AU, RU>, RU, DoubleScalar.Rel<RU>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Absolute Immutable DoubleScalar.
         * @param value double; the value of the new Absolute Immutable DoubleScalar
         * @param unit AU; the unit of the new Absolute Immutable DoubleScalar
         */
        public Abs(final double value, final AU unit)
        {
            super(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar from an existing Absolute Immutable DoubleScalar.
         * @param value DoubleScalar.Abs&lt;AU, RU&gt;; the reference
         */
        public Abs(final DoubleScalar.Abs<AU, RU> value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        public final DoubleScalar.Abs<AU, RU> instantiateAbs(final double value, final AU unit)
        {
            return new DoubleScalar.Abs<>(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final DoubleScalar.Rel<RU> instantiateRel(final double value, final RU unit)
        {
            return new DoubleScalar.Rel<>(value, unit);
        }

    }

    /**
     * Relative Immutable DoubleScalar.
     * @param <U> Unit
     */
    public static class Rel<U extends Unit<U>> extends AbstractDoubleScalarRel<U, DoubleScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Relative Immutable DoubleScalar.
         * @param value double; the value of the new Relative Immutable DoubleScalar
         * @param unit U; the unit of the new Relative Immutable DoubleScalar
         */
        public Rel(final double value, final U unit)
        {
            super(value, unit);
        }

        /**
         * Construct a new Relative Immutable DoubleScalar from an existing Relative Immutable DoubleScalar.
         * @param value DoubleScalar.Rel&lt;U&gt;; the reference
         */
        public Rel(final DoubleScalar.Rel<U> value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        public final DoubleScalar.Rel<U> instantiateRel(final double value, final U unit)
        {
            return new DoubleScalar.Rel<>(value, unit);
        }

    }

    /**********************************************************************************/
    /********************************* STATIC METHODS *********************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to an Absolute value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left A, an absolute typed DoubleScalar; the left argument
     * @param right R, a relative typed DoubleScalar; the right argument
     * @param <AU> Unit; the absolute unit of the parameters and the result
     * @param <RU> Unit; the relative unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return A, an absolute typed DoubleScalar; the sum of the values as an Absolute value
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, R extends AbstractDoubleScalarRel<RU, R>,
            A extends AbstractDoubleScalarAbs<AU, A, RU, R>> A plus(final A left, final R right)
    {
        return left.plus(right);
    }

    /**
     * Add an Absolute value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left A, an absolute typed DoubleScalar; the left argument
     * @param right R, a relative typed DoubleScalar; the right argument
     * @param <AU> Unit; the absolute unit of the parameters and the result
     * @param <RU> Unit; the relative unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return A, an absolute typed DoubleScalar; the sum of the values as an Absolute value
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, R extends AbstractDoubleScalarRel<RU, R>,
            A extends AbstractDoubleScalarAbs<AU, A, RU, R>> A plus(final R left, final A right)
    {
        return right.plus(left);
    }

    /**
     * Add a Relative value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left R, a relative typed DoubleScalar; the left argument
     * @param right R, a relative typed DoubleScalar; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @return R, a relative typed DoubleScalar; the sum of the values as a Relative value
     */
    public static <U extends Unit<U>, R extends AbstractDoubleScalarRel<U, R>> R plus(final R left, final R right)
    {
        return left.plus(right);
    }

    /**
     * Subtract a Relative value from an absolute value. Return a new instance of the value. The unit of the return value will
     * be the unit of the left argument.
     * @param left A, an absolute typed DoubleScalar; the left value
     * @param right R, a relative typed DoubleScalar; the right value
     * @param <AU> Unit; the absolute unit of the parameters and the result
     * @param <RU> Unit; the relative unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return A, an absolute typed DoubleScalar; the resulting value as an absolute value
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, R extends AbstractDoubleScalarRel<RU, R>,
            A extends AbstractDoubleScalarAbs<AU, A, RU, R>> A minus(final A left, final R right)
    {
        return left.minus(right);
    }

    /**
     * Subtract a relative value from a relative value. Return a new instance of the value. The unit of the value will be the
     * unit of the first argument.
     * @param left R, a relative typed DoubleScalar; the left value
     * @param right R, a relative typed DoubleScalar; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @return R, a relative typed DoubleScalar; the resulting value as a relative value
     */
    public static <U extends Unit<U>, R extends AbstractDoubleScalarRel<U, R>> R minus(final R left, final R right)
    {
        return left.minus(right);
    }

    /**
     * Subtract two absolute values. Return a new instance of a relative value of the difference. The unit of the value will be
     * the unit of the first argument.
     * @param left A, an absolute typed DoubleScalar; value 1
     * @param right A, an absolute typed DoubleScalar; value 2
     * @param <AU> Unit; the absolute unit of the parameters and the result
     * @param <RU> Unit; the relative unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return R, a relative typed DoubleScalar; the difference of the two absolute values as a relative value
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, R extends AbstractDoubleScalarRel<RU, R>,
            A extends AbstractDoubleScalarAbs<AU, A, RU, R>> R minus(final A left, final A right)
    {
        return left.minus(right);
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left AbstractDoubleScalarRel&lt;?, ?&gt;; the left operand
     * @param right AbstractDoubleScalarRel&lt;?, ?&gt;; the right operand
     * @return DoubleScalar.Rel&lt;SIUnit&gt;; the product of the two values
     */
    public static DoubleScalar.Rel<SIUnit> multiply(final AbstractDoubleScalarRel<?, ?> left,
            final AbstractDoubleScalarRel<?, ?> right)
    {
        SIUnit targetUnit = Unit.lookupOrCreateSIUnitWithSICoefficients(
                SICoefficients.multiply(left.getUnit().getSICoefficients(), right.getUnit().getSICoefficients()).toString());
        return new DoubleScalar.Rel<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left AbstractDoubleScalarRel&lt;?, ?&gt;; the left operand
     * @param right AbstractDoubleScalarRel&lt;?, ?&gt;; the right operand
     * @return DoubleScalar.Rel&lt;SIUnit&gt;; the ratio of the two values
     */
    public static DoubleScalar.Rel<SIUnit> divide(final AbstractDoubleScalarRel<?, ?> left,
            final AbstractDoubleScalarRel<?, ?> right)
    {
        SIUnit targetUnit = Unit.lookupOrCreateSIUnitWithSICoefficients(
                SICoefficients.divide(left.getUnit().getSICoefficients(), right.getUnit().getSICoefficients()).toString());
        return new DoubleScalar.Rel<SIUnit>(left.getSI() / right.getSI(), targetUnit);
    }

    /**
     * Interpolate between two values. Made to be able to call e.g., Area a = DoubleScalar.interpolate(a1, a2, 0.4);
     * @param zero R; the low value
     * @param one R; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @return a Scalar at the ratio between
     */
    public static <U extends Unit<U>, R extends AbstractDoubleScalarRel<U, R>> R interpolate(final R zero, final R one,
            final double ratio)
    {
        return zero.instantiateRel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values. Made to be able to call e.g., Time t = DoubleScalar.interpolate(t1, t2, 0.4);
     * @param zero A; the low value
     * @param one A; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @param <AU> Unit; the absolute unit of the parameters and the result
     * @param <RU> Unit; the relative unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return a Scalar at the ratio between
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, R extends AbstractDoubleScalarRel<RU, R>,
            A extends AbstractDoubleScalarAbs<AU, A, RU, R>> A interpolate(final A zero, final A one, final double ratio)
    {
        return zero.instantiateAbs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 T; the first scalar
     * @param r2 T; the second scalar
     * @param <U> Unit; the unit of the parameters and the result
     * @param <T> the argument and result type
     * @return the maximum value of two relative scalars
     */
    public static <U extends Unit<U>, T extends AbstractDoubleScalar<U, T>> T max(final T r1, final T r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 T; the first scalar
     * @param r2 T; the second scalar
     * @param rn T...; the other scalars
     * @param <U> Unit; the unit of the parameters and the result
     * @param <T> the argument and result type
     * @return the maximum value of more than two relative scalars
     */
    @SafeVarargs
    public static <U extends Unit<U>, T extends AbstractDoubleScalar<U, T>> T max(final T r1, final T r2, final T... rn)
    {
        T maxr = (r1.gt(r2)) ? r1 : r2;
        for (T r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 T; the first scalar
     * @param r2 T; the second scalar
     * @param <U> Unit; the unit of the parameters and the result
     * @param <T> the argument and result type
     * @return the minimum value of two relative scalars
     */
    public static <U extends Unit<U>, T extends AbstractDoubleScalar<U, T>> T min(final T r1, final T r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 T; the first scalar
     * @param r2 T; the second scalar
     * @param rn T...; the other scalars
     * @param <U> Unit; the unit of the parameters and the result
     * @param <T> the argument and result type
     * @return the minimum value of more than two relative scalars
     */
    @SafeVarargs
    public static <U extends Unit<U>, T extends AbstractDoubleScalar<U, T>> T min(final T r1, final T r2, final T... rn)
    {
        T minr = (r1.lt(r2)) ? r1 : r2;
        for (T r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

}
