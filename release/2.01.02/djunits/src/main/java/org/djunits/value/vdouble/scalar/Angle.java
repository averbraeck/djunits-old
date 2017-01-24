package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the Relative Angle DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar&lt;AngleUnit&gt; value = new DoubleScalar&lt;AngleUnit&gt;(100.0, AngleUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Angle value = new Angle(100.0, AngleUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Angle extends AbstractDoubleScalarRel<AngleUnit, Angle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Angle ZERO = new Angle(0.0, AngleUnit.SI);

    /**
     * Construct Angle scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Angle(final double value, final AngleUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Angle scalar.
     * @param value Scalar from which to construct this instance
     */
    public Angle(final Angle value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Angle instantiateRel(final double value, final AngleUnit unit)
    {
        return new Angle(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the double value
     * @param unit the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public final Direction instantiateAbs(final double value, final AngleUnit unit)
    {
        return new Direction(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Angle interpolate(final Angle zero, final Angle one, final double ratio)
    {
        return new Angle(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Direction plus(final Direction v)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateAbs(this.si + v.si, getUnit().getStandardUnit());
        }
        return getUnit().equals(v.getUnit()) ? instantiateAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateAbs(this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
     * @return an absolute version of this angle scalar.
     */
    public final Direction toAbs()
    {
        return new Direction(getInUnit(), getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Angle max(final Angle r1, final Angle r2)
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
    public static Angle max(final Angle r1, final Angle r2, final Angle... rn)
    {
        Angle maxr = (r1.gt(r2)) ? r1 : r2;
        for (Angle r : rn)
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
    public static Angle min(final Angle r1, final Angle r2)
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
    public static Angle min(final Angle r1, final Angle r2, final Angle... rn)
    {
        Angle minr = (r1.lt(r2)) ? r1 : r2;
        for (Angle r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Angle and Angle, which results in a Dimensionless scalar.
     * @param v Angle scalar
     * @return Dimensionless scalar as a division of Angle and Angle
     */
    public final Dimensionless divideBy(final Angle v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}
