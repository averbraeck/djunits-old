package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AngleSolid DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;AngleSolidUnit&gt; value = new DoubleScalar.Rel&lt;AngleSolidUnit&gt;(100.0, AngleSolidUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * AngleSolid value = new AngleSolid(100.0, AngleSolidUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleSolid extends AbstractDoubleScalarRel<AngleSolidUnit, AngleSolid>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final AngleSolid ZERO = new AngleSolid(0.0, AngleSolidUnit.SI);

    /**
     * Construct AngleSolid scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AngleSolid(final double value, final AngleSolidUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AngleSolid scalar.
     * @param value Scalar from which to construct this instance
     */
    public AngleSolid(final AngleSolid value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid instantiateRel(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static AngleSolid interpolate(final AngleSolid zero, final AngleSolid one, final double ratio)
    {
        return new AngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static AngleSolid max(final AngleSolid r1, final AngleSolid r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static AngleSolid max(final AngleSolid r1, final AngleSolid r2, final AngleSolid... rn)
    {
        AngleSolid maxr = (r1.gt(r2)) ? r1 : r2;
        for (AngleSolid r : rn)
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
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static AngleSolid min(final AngleSolid r1, final AngleSolid r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static AngleSolid min(final AngleSolid r1, final AngleSolid r2, final AngleSolid... rn)
    {
        AngleSolid minr = (r1.lt(r2)) ? r1 : r2;
        for (AngleSolid r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
     * @param v AngleSolid scalar
     * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
     */
    public final Dimensionless divideBy(final AngleSolid v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}