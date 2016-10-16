package org.djunits.value.vdouble.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleMathFunctions;

/**
 * The typed, abstract DoubleScalarRel class that forms the basis of all DoubleScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 13, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <R> the Relative class for reference purposes
 */
public abstract class AbstractDoubleScalarRel<U extends Unit<U>, R extends AbstractDoubleScalarRel<U, R>>
        extends AbstractDoubleScalar<U, R>
        implements Relative, MathFunctionsRel<R>, DoubleMathFunctions<R>
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
        super(unit, unit.equals(unit.getStandardUnit()) ? value : ValueUtil.expressAsSIUnit(value, unit));
    }

    /**
     * Construct a new Relative Immutable DoubleScalar from an existing Relative Immutable DoubleScalar.
     * @param value R, a relative typed DoubleScalar; the reference
     */
    public AbstractDoubleScalarRel(final R value)
    {
        super(value.getUnit(), value.si);
    }

    /**
     * Construct a new Relative Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the double value
     * @param unit the unit
     * @return R a new relative instance of the DoubleScalar of the right type
     */
    public abstract R instantiateRel(final double value, final U unit);

    /**
     * Increment the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param increment R, a relative typed DoubleScalar; amount by which the value is incremented
     * @return Absolute DoubleScalar
     */
    public final R plus(final R increment)
    {
        return getUnit().equals(increment.getUnit()) ? instantiateRel(getInUnit() + increment.getInUnit(), getUnit())
                : instantiateRel(this.si + increment.si, getUnit().getStandardUnit());
    }

    /**
     * Decrement the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param decrement R, a relative typed DoubleScalar; amount by which the value is decremented
     * @return Relative DoubleScalar
     */
    public final R minus(final R decrement)
    {
        return getUnit().equals(decrement.getUnit()) ? instantiateRel(getInUnit() - decrement.getInUnit(), getUnit())
                : instantiateRel(this.si - decrement.si, getUnit().getStandardUnit());
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
