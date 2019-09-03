package org.djunits4.value.vdouble.scalar;

import org.djunits4.unit.Unit;
import org.djunits4.value.MathFunctionsRel;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueUtil;
import org.djunits4.value.vdouble.DoubleMathFunctions;

/**
 * The typed, abstract DoubleScalarRel class that forms the basis of all DoubleScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <R> the Relative class for reference purposes
 */
public abstract class AbstractDoubleScalarRel<U extends Unit<U>, R extends AbstractDoubleScalarRel<U, R>>
        extends AbstractDoubleScalar<U, R> implements Relative, MathFunctionsRel<R>, DoubleMathFunctions<R>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Relative Immutable DoubleScalar.
     * @param value double; the value of the new Relative Immutable DoubleScalar
     * @param unit U; the unit of the new Relative Immutable DoubleScalar
     */
    public AbstractDoubleScalarRel(final double value, final U unit)
    {
        super(unit, unit.isBaseSIUnit() ? value : ValueUtil.expressAsSIUnit(value, unit));
    }

    /**
     * Construct a new Relative Immutable DoubleScalar from an existing Relative Immutable DoubleScalar.
     * @param value R, a relative typed DoubleScalar; the reference
     */
    public AbstractDoubleScalarRel(final R value)
    {
        super(value.getUnit(), value.getSI());
    }

    /**
     * Construct a new Relative Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit U; the unit
     * @return R a new relative instance of the DoubleScalar of the right type
     */
    public abstract R instantiateRel(double value, U unit);

    /**
     * Increment the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param increment R, a relative typed DoubleScalar; amount by which the value is incremented
     * @return Absolute DoubleScalar
     */
    public final R plus(final R increment)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateRel(this.getSI() + increment.getSI(), getUnit().getStandardUnit());
        }
        return getUnit().equals(increment.getUnit()) ? instantiateRel(getInUnit() + increment.getInUnit(), getUnit())
                : instantiateRel(this.getSI() + increment.getSI(), getUnit().getStandardUnit());
    }

    /**
     * Decrement the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param decrement R, a relative typed DoubleScalar; amount by which the value is decremented
     * @return Relative DoubleScalar
     */
    public final R minus(final R decrement)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateRel(this.getSI() - decrement.getSI(), getUnit().getStandardUnit());
        }
        return getUnit().equals(decrement.getUnit()) ? instantiateRel(getInUnit() - decrement.getInUnit(), getUnit())
                : instantiateRel(this.getSI() - decrement.getSI(), getUnit().getStandardUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero R; the low value
     * @param one R; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     * @param <U> the unit
     * @param <R> the Relative class for reference purposes
     */
    public static <U extends Unit<U>, R extends AbstractDoubleScalarRel<U, R>> R interpolate(final R zero, final R one,
            final double ratio)
    {
        return zero.instantiateRel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Multiply this scalar by another scalar and create a new scalar.
     * @param otherScalar AbstractDoubleScalarRel&lt;?, ?&gt;; the value by which this scalar is multiplied
     * @return DoubleScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public SIScalar multiplyBy(AbstractDoubleScalarRel<?, ?> otherScalar)
    {
        return DoubleScalar.multiply(this, otherScalar);
    }

    /**
     * Create the reciprocal of this scalar with the correct dimensions.
     * @return DoubleScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public SIScalar reciprocal()
    {
        return DoubleScalar.divide(Dimensionless.ONE, this);
    }

    /**
     * Divide this scalar by another scalar and create a new scalar.
     * @param otherScalar AbstractDoubleScalarRel&lt;?, ?&gt;; the value by which this scalar is divided
     * @return DoubleScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public SIScalar divideBy(AbstractDoubleScalarRel<?, ?> otherScalar)
    {
        return DoubleScalar.divide(this, otherScalar);
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R abs()
    {
        return instantiateRel(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R ceil()
    {
        return instantiateRel(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R floor()
    {
        return instantiateRel(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R rint()
    {
        return instantiateRel(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R round()
    {
        return instantiateRel(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R neg()
    {
        return instantiateRel(-getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R multiplyBy(final double constant)
    {
        return instantiateRel(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R divideBy(final double constant)
    {
        return instantiateRel(getInUnit() / constant, getUnit());
    }

}
