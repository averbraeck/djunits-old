package org.djunits.value.vfloat.scalar;

import org.djunits.unit.SICoefficients;
import org.djunits.unit.SIUnit;
import org.djunits.unit.Unit;

/**
 * Immutable FloatScalar.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class FloatScalar
{
    /**
     * Absolute Immutable FloatScalar.
     * @param <U> Unit
     */
    public static class Abs<U extends Unit<U>> extends AbstractFloatScalarAbs<U, FloatScalar.Abs<U>, FloatScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Absolute Immutable FloatScalar.
         * @param value float; the value of the new Absolute Immutable FloatScalar
         * @param unit U; the unit of the new Absolute Immutable FloatScalar
         */
        public Abs(final float value, final U unit)
        {
            super(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar from an existing Absolute Immutable FloatScalar.
         * @param value FloatScalar.Abs&lt;U&gt;; the reference
         */
        public Abs(final FloatScalar.Abs<U> value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatScalar.Abs<U> instantiateAbs(final float value, final U unit)
        {
            return new FloatScalar.Abs<>(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatScalar.Rel<U> instantiateRel(final float value, final U unit)
        {
            return new FloatScalar.Rel<>(value, unit);
        }

    }

    /**
     * Relative Immutable FloatScalar.
     * @param <U> Unit
     */
    public static class Rel<U extends Unit<U>> extends AbstractFloatScalarRel<U, FloatScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Relative Immutable FloatScalar.
         * @param value float; the value of the new Relative Immutable FloatScalar
         * @param unit U; the unit of the new Relative Immutable FloatScalar
         */
        public Rel(final float value, final U unit)
        {
            super(value, unit);
        }

        /**
         * Construct a new Relative Immutable FloatScalar from an existing Relative Immutable FloatScalar.
         * @param value FloatScalar.Rel&lt;U&gt;; the reference
         */
        public Rel(final FloatScalar.Rel<U> value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatScalar.Rel<U> instantiateRel(final float value, final U unit)
        {
            return new FloatScalar.Rel<>(value, unit);
        }

    }

    /**********************************************************************************/
    /********************************* STATIC METHODS *********************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to an Absolute value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left A, an absolute typed FloatScalar; the left argument
     * @param right R, a relative typed FloatScalar; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return A, an absolute typed FloatScalar; the sum of the values as an Absolute value
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>, A extends AbstractFloatScalarAbs<U, A, R>> A plus(
            final A left, final R right)
    {
        return left.instantiateAbs(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Add an Absolute value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left A, an absolute typed FloatScalar; the left argument
     * @param right R, a relative typed FloatScalar; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return A, an absolute typed FloatScalar; the sum of the values as an Absolute value
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>, A extends AbstractFloatScalarAbs<U, A, R>> A plus(
            final R left, final A right)
    {
        return right.instantiateAbs(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Add a Relative value to a Relative value. Return a new instance of the value. The unit of the return value will be the
     * unit of the left argument.
     * @param left R, a relative typed FloatScalar; the left argument
     * @param right R, a relative typed FloatScalar; the right argument
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @return R, a relative typed FloatScalar; the sum of the values as a Relative value
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>> R plus(final R left, final R right)
    {
        return left.instantiateRel(left.getInUnit() + right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract a Relative value from an absolute value. Return a new instance of the value. The unit of the return value will
     * be the unit of the left argument.
     * @param left A, an absolute typed FloatScalar; the left value
     * @param right R, a relative typed FloatScalar; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return A, an absolute typed FloatScalar; the resulting value as an absolute value
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>, A extends AbstractFloatScalarAbs<U, A, R>> A minus(
            final A left, final R right)
    {
        return left.instantiateAbs(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract a relative value from a relative value. Return a new instance of the value. The unit of the value will be the
     * unit of the first argument.
     * @param left R, a relative typed FloatScalar; the left value
     * @param right R, a relative typed FloatScalar; the right value
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @return R, a relative typed FloatScalar; the resulting value as a relative value
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>> R minus(final R left, final R right)
    {
        return left.instantiateRel(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Subtract two absolute values. Return a new instance of a relative value of the difference. The unit of the value will be
     * the unit of the first argument.
     * @param left A, an absolute typed FloatScalar; value 1
     * @param right A, an absolute typed FloatScalar; value 2
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return R, a relative typed FloatScalar; the difference of the two absolute values as a relative value
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>, A extends AbstractFloatScalarAbs<U, A, R>> R minus(
            final A left, final A right)
    {
        return left.instantiateRel(left.getInUnit() - right.getInUnit(left.getUnit()), left.getUnit());
    }

    /**
     * Interpolate between or extrapolate over two values.
     * @param zero A, an absolute typed FloatScalar; zero reference (returned when ratio == 0)
     * @param one A, an absolute typed FloatScalar; one reference (returned when ratio == 1)
     * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @param <A> the corresponding absolute type
     * @return Absolute FloatScalar
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>, A extends AbstractFloatScalarAbs<U, A, R>> A interpolate(
            final A zero, final A one, final float ratio)
    {
        return zero.instantiateAbs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between or extrapolate over two values.
     * @param zero R, a relative typed FloatScalar; zero reference (returned when ratio == 0)
     * @param one R, a relative typed FloatScalar; one reference (returned when ratio == 1)
     * @param ratio float; the ratio that determines where between (or outside) zero and one the result lies
     * @param <U> Unit; the unit of the parameters and the result
     * @param <R> the relative type
     * @return Relative FloatScalar
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>> R interpolate(final R zero, final R one,
            final float ratio)
    {
        return zero.instantiateRel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Abs&lt;?&gt;; the left operand
     * @param right FloatScalar.Abs&lt;?&gt;; the right operand
     * @return FloatScalar.Abs&lt;SIUnit&gt;; the product of the two values
     */
    public static FloatScalar.Abs<SIUnit> multiply(final AbstractFloatScalarAbs<?, ?, ?> left,
            final AbstractFloatScalarAbs<?, ?, ?> right)
    {
        SIUnit targetUnit = Unit.lookupOrCreateSIUnitWithSICoefficients(
                SICoefficients.multiply(left.getUnit().getSICoefficients(), right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Abs<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Multiply two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Rel&lt;?&gt;; the left operand
     * @param right FloatScalar.Rel&lt;?&gt;; the right operand
     * @return FloatScalar.Rel&lt;SIUnit&gt;; the product of the two values
     */
    public static FloatScalar.Rel<SIUnit> multiply(final AbstractFloatScalarRel<?, ?> left,
            final AbstractFloatScalarRel<?, ?> right)
    {
        SIUnit targetUnit = Unit.lookupOrCreateSIUnitWithSICoefficients(
                SICoefficients.multiply(left.getUnit().getSICoefficients(), right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Rel<SIUnit>(left.getSI() * right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Abs&lt;?&gt;; the left operand
     * @param right FloatScalar.Abs&lt;?&gt;; the right operand
     * @return FloatScalar.Abs&lt;SIUnit&gt;; the ratio of the two values
     */
    public static FloatScalar.Abs<SIUnit> divide(final AbstractFloatScalarAbs<?, ?, ?> left,
            final AbstractFloatScalarAbs<?, ?, ?> right)
    {
        SIUnit targetUnit = Unit.lookupOrCreateSIUnitWithSICoefficients(
                SICoefficients.divide(left.getUnit().getSICoefficients(), right.getUnit().getSICoefficients()).toString());
        return new FloatScalar.Abs<SIUnit>(left.getSI() / right.getSI(), targetUnit);
    }

    /**
     * Divide two values; the result is a new instance with a different (existing or generated) SI unit.
     * @param left FloatScalar.Rel&lt;?&gt;; the left operand
     * @param right FloatScalar.Rel&lt;?&gt;; the right operand
     * @return FloatScalar.Rel&lt;SIUnit&gt;; the ratio of the two values
     */
    public static FloatScalar.Rel<SIUnit> divide(final AbstractFloatScalarRel<?, ?> left,
            final AbstractFloatScalarRel<?, ?> right)
    {
        SIUnit targetUnit = Unit.lookupOrCreateSIUnitWithSICoefficients(
                SICoefficients.divide(left.getUnit().getSICoefficients(), right.getUnit().getSICoefficients()).toString());
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
        return new FloatScalar.Abs<U>(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
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
        return new FloatScalar.Rel<U>(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

}