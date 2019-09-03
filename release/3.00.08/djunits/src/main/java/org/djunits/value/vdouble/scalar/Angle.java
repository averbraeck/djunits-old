package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DirectionUnit;

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
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
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

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Angle NaN = new Angle(Double.NaN, AngleUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Angle POSITIVE_INFINITY = new Angle(Double.POSITIVE_INFINITY, AngleUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Angle NEGATIVE_INFINITY = new Angle(Double.NEGATIVE_INFINITY, AngleUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Angle POS_MAXVALUE = new Angle(Double.MAX_VALUE, AngleUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Angle NEG_MAXVALUE = new Angle(-Double.MAX_VALUE, AngleUnit.SI);

    /**
     * Construct Angle scalar.
     * @param value double; double value
     * @param unit AngleUnit; unit for the double value
     */
    public Angle(final double value, final AngleUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Angle scalar.
     * @param value Angle; Scalar from which to construct this instance
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
     * @param value double; the double value
     * @param unit DirectionUnit; the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public final Direction instantiateAbs(final double value, final DirectionUnit unit)
    {
        return new Direction(value, unit);
    }

    /**
     * Construct Angle scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Angle createSI(final double value)
    {
        return new Angle(value, AngleUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Angle; the low value
     * @param one Angle; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Angle interpolate(final Angle zero, final Angle one, final double ratio)
    {
        return new Angle(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v Direction; the value to add
     * @return sum of this value and v as a new object
     */
    public final Direction plus(final Direction v)
    {
        DirectionUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Angle max(final Angle r1, final Angle r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @param rn Angle...; the other scalars
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
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Angle min(final Angle r1, final Angle r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Angle; the first scalar
     * @param r2 Angle; the second scalar
     * @param rn Angle...; the other scalars
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
     * @param v Angle; Angle scalar
     * @return Dimensionless scalar as a division of Angle and Angle
     */
    public final Dimensionless divideBy(final Angle v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}