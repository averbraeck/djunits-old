package org.djunits.value.vdouble.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.MathFunctionsAbs;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleMathFunctions;

/**
 * The typed, abstract DoubleScalarAbs class that forms the basis of all DoubleScalar definitions and extensions.<br>
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
 * @param <A> the Absolute class for reference purposes
 * @param <R> the Relative class for reference purposes
 */
public abstract class AbstractDoubleScalarAbs<U extends Unit<U>, A extends AbstractDoubleScalarAbs<U, A, R>, R extends AbstractDoubleScalarRel<U, R>>
        extends AbstractDoubleScalar<U, A> implements Absolute, MathFunctionsAbs<A>, DoubleMathFunctions<A>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Absolute Immutable DoubleScalar.
     * @param value double; the value of the new Absolute Immutable DoubleScalar
     * @param unit U; the unit of the new Absolute Immutable DoubleScalar
     */
    public AbstractDoubleScalarAbs(final double value, final U unit)
    {
        super(unit, unit.isBaseSIUnit() ? value : ValueUtil.expressAsSIUnit(value, unit));
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar from an existing Absolute Immutable DoubleScalar.
     * @param value A, an absolute typed DoubleScalar; the reference
     */
    public AbstractDoubleScalarAbs(final A value)
    {
        super(value.getUnit(), value.si);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the double value
     * @param unit the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public abstract A instantiateAbs(final double value, final U unit);

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
    public final A plus(final R increment)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateAbs(this.si + increment.si, getUnit().getStandardUnit());
        }
        return getUnit().equals(increment.getUnit()) ? instantiateAbs(getInUnit() + increment.getInUnit(), getUnit())
                : instantiateAbs(this.si + increment.si, getUnit().getStandardUnit());
    }

    /**
     * Decrement the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param decrement R, a relative typed DoubleScalar; amount by which the value is decremented
     * @return Absolute DoubleScalar
     */
    public final A minus(final R decrement)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateAbs(this.si - decrement.si, getUnit().getStandardUnit());
        }
        return getUnit().equals(decrement.getUnit()) ? instantiateAbs(getInUnit() - decrement.getInUnit(), getUnit())
                : instantiateAbs(this.si - decrement.si, getUnit().getStandardUnit());
    }

    /**
     * Decrement the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param decrement A, an absolute typed DoubleScalar; amount by which the value is decremented
     * @return Relative DoubleScalar
     */
    public final R minus(final A decrement)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateRel(this.si - decrement.si, getUnit().getStandardUnit());
        }
        return getUnit().equals(decrement.getUnit()) ? instantiateRel(getInUnit() - decrement.getInUnit(), getUnit())
                : instantiateRel(this.si - decrement.si, getUnit().getStandardUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A ceil()
    {
        return instantiateAbs(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A floor()
    {
        return instantiateAbs(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A rint()
    {
        return instantiateAbs(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A round()
    {
        return instantiateAbs(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A multiplyBy(final double constant)
    {
        return instantiateAbs(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divideBy(final double constant)
    {
        return instantiateAbs(getInUnit() / constant, getUnit());
    }

    /**
     * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute length scalar.
     */
    public final R toRel()
    {
        return instantiateRel(getInUnit(), getUnit());
    }
}
