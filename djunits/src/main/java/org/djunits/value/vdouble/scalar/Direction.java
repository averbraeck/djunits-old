package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;

/**
 * Easy access methods for the Absolute Direction DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar.Abs&lt;DirectionUnit&gt; value = new DoubleScalar.Abs&lt;DirectionUnit&gt;(100.0, DirectionUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Direction value = new Direction(100.0, DirectionUnit.BASE);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Direction extends AbstractDoubleScalarAbs<DirectionUnit, Direction, AngleUnit, Angle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Direction ZERO = new Direction(0.0, DirectionUnit.BASE);

    /**
     * Construct Direction scalar.
     * @param value double; double value
     * @param unit DirectionUnit; unit for the double value
     */
    public Direction(final double value, final DirectionUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Direction scalar.
     * @param value Direction; Scalar from which to construct this instance
     */
    public Direction(final Direction value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Direction instantiateAbs(final double value, final DirectionUnit unit)
    {
        return new Direction(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Angle instantiateRel(final double value, final AngleUnit unit)
    {
        return new Angle(value, unit);
    }

    /**
     * Construct %TypeAbsl% scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Direction createSI(final double value)
    {
        return new Direction(value, DirectionUnit.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero Direction; the low value
     * @param one Direction; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Direction interpolate(final Direction zero, final Direction one, final double ratio)
    {
        return new Direction(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 Direction; the first scalar
     * @param a2 Direction; the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static Direction max(final Direction a1, final Direction a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 Direction; the first scalar
     * @param a2 Direction; the second scalar
     * @param an Direction...; the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static Direction max(final Direction a1, final Direction a2, final Direction... an)
    {
        Direction maxa = (a1.gt(a2)) ? a1 : a2;
        for (Direction a : an)
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
     * @param a1 Direction; the first scalar
     * @param a2 Direction; the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static Direction min(final Direction a1, final Direction a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 Direction; the first scalar
     * @param a2 Direction; the second scalar
     * @param an Direction...; the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static Direction min(final Direction a1, final Direction a2, final Direction... an)
    {
        Direction mina = (a1.lt(a2)) ? a1 : a2;
        for (Direction a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

}
