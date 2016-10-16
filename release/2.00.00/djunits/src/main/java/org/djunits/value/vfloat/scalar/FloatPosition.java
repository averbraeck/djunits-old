package org.djunits.value.vfloat.scalar;

import org.djunits.unit.LengthUnit;

/**
 * Easy access methods for the Position FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Abs&lt;LengthUnit&gt; value = new FloatScalar.Abs&lt;LengthUnit&gt;(100.0, LengthUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatPosition value = new FloatPosition(100.0, LengthUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2016-05-28 14:25:52 +0200 (Sat, 28 May 2016) $, @version $Revision: 202 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPosition extends AbstractFloatScalarAbs<LengthUnit, FloatPosition, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatPosition ZERO = new FloatPosition(0.0f, LengthUnit.SI);

    /**
     * Construct FloatPosition scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPosition(final float value, final LengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPosition scalar using a double value.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPosition(final double value, final LengthUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatPosition scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatPosition(final FloatPosition value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPosition instantiateAbs(final float value, final LengthUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLength instantiateRel(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPosition interpolate(final FloatPosition zero, final FloatPosition one, final float ratio)
    {
        return new FloatPosition(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static FloatPosition max(final FloatPosition a1, final FloatPosition a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static FloatPosition max(final FloatPosition a1, final FloatPosition a2, final FloatPosition... an)
    {
        FloatPosition maxa = (a1.gt(a2)) ? a1 : a2;
        for (FloatPosition a : an)
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
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static FloatPosition min(final FloatPosition a1, final FloatPosition a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static FloatPosition min(final FloatPosition a1, final FloatPosition a2, final FloatPosition... an)
    {
        FloatPosition mina = (a1.lt(a2)) ? a1 : a2;
        for (FloatPosition a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

}
