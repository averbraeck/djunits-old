package org.djunits.value.vdouble.scalar;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;

/**
 * Easy access methods for the Absolute Position DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar.Abs&lt;PositionUnit&gt; value = new DoubleScalar.Abs&lt;PositionUnit&gt;(100.0, PositionUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Position value = new Position(100.0, PositionUnit.BASE);
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
public class Position extends AbstractDoubleScalarAbs<PositionUnit, Position, LengthUnit, Length>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Position ZERO = new Position(0.0, PositionUnit.BASE);

    /**
     * Construct Position scalar.
     * @param value double; double value
     * @param unit PositionUnit; unit for the double value
     */
    public Position(final double value, final PositionUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Position scalar.
     * @param value Position; Scalar from which to construct this instance
     */
    public Position(final Position value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Position instantiateAbs(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Length instantiateRel(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }

    /**
     * Construct %TypeAbsl% scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Position createSI(final double value)
    {
        return new Position(value, PositionUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero Position; the low value
     * @param one Position; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Position interpolate(final Position zero, final Position one, final double ratio)
    {
        return new Position(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static Position max(final Position a1, final Position a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @param an Position...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static Position max(final Position a1, final Position a2, final Position... an)
    {
        Position maxa = (a1.gt(a2)) ? a1 : a2;
        for (Position a : an)
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
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static Position min(final Position a1, final Position a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 Position; the first scalar
     * @param a2 Position; the second scalar
     * @param an Position...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static Position min(final Position a1, final Position a2, final Position... an)
    {
        Position mina = (a1.lt(a2)) ? a1 : a2;
        for (Position a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

}
