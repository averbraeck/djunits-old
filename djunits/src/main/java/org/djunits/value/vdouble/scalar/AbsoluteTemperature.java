package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Absolute AbsoluteTemperature DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar.Abs&lt;AbsoluteTemperatureUnit&gt; value =
 *         new DoubleScalar.Abs&lt;AbsoluteTemperatureUnit&gt;(100.0, AbsoluteTemperatureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * AbsoluteTemperature value = new AbsoluteTemperature(100.0, AbsoluteTemperatureUnit.BASE);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AbsoluteTemperature
        extends AbstractDoubleScalarAbs<AbsoluteTemperatureUnit, AbsoluteTemperature, TemperatureUnit, Temperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final AbsoluteTemperature ZERO = new AbsoluteTemperature(0.0, AbsoluteTemperatureUnit.BASE);

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value double; double value
     * @param unit AbsoluteTemperatureUnit; unit for the double value
     */
    public AbsoluteTemperature(final double value, final AbsoluteTemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AbsoluteTemperature scalar.
     * @param value AbsoluteTemperature; Scalar from which to construct this instance
     */
    public AbsoluteTemperature(final AbsoluteTemperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperature instantiateAbs(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Temperature instantiateRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

    /**
     * Construct %TypeAbsl% scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final AbsoluteTemperature createSI(final double value)
    {
        return new AbsoluteTemperature(value, AbsoluteTemperatureUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero AbsoluteTemperature; the low value
     * @param one AbsoluteTemperature; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static AbsoluteTemperature interpolate(final AbsoluteTemperature zero, final AbsoluteTemperature one,
            final double ratio)
    {
        return new AbsoluteTemperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static AbsoluteTemperature max(final AbsoluteTemperature a1, final AbsoluteTemperature a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @param an AbsoluteTemperature...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static AbsoluteTemperature max(final AbsoluteTemperature a1, final AbsoluteTemperature a2,
            final AbsoluteTemperature... an)
    {
        AbsoluteTemperature maxa = (a1.gt(a2)) ? a1 : a2;
        for (AbsoluteTemperature a : an)
        {
            if (a.gt(maxa))
            {
                maxa = a;
            }
        }
        return maxa;
    }

    /**
     * Return the minimum value of two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static AbsoluteTemperature min(final AbsoluteTemperature a1, final AbsoluteTemperature a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 AbsoluteTemperature; the first scalar
     * @param a2 AbsoluteTemperature; the second scalar
     * @param an AbsoluteTemperature...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static AbsoluteTemperature min(final AbsoluteTemperature a1, final AbsoluteTemperature a2,
            final AbsoluteTemperature... an)
    {
        AbsoluteTemperature mina = (a1.lt(a2)) ? a1 : a2;
        for (AbsoluteTemperature a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

}
