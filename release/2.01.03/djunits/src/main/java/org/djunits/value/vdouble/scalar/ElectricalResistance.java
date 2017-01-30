package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;

/**
 * Easy access methods for the ElectricalResistance DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;ElectricalResistanceUnit&gt; value =
 *         new DoubleScalar.Rel&lt;ElectricalResistanceUnit&gt;(100.0, ElectricalResistanceUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * ElectricalResistance value = new ElectricalResistance(100.0, ElectricalResistanceUnit.SI);
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
public class ElectricalResistance extends AbstractDoubleScalarRel<ElectricalResistanceUnit, ElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalResistance ZERO = new ElectricalResistance(0.0, ElectricalResistanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final ElectricalResistance NaN = new ElectricalResistance(Double.NaN, ElectricalResistanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final ElectricalResistance POSITIVE_INFINITY =
            new ElectricalResistance(Double.POSITIVE_INFINITY, ElectricalResistanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final ElectricalResistance NEGATIVE_INFINITY =
            new ElectricalResistance(Double.NEGATIVE_INFINITY, ElectricalResistanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final ElectricalResistance POS_MAXVALUE =
            new ElectricalResistance(Double.MAX_VALUE, ElectricalResistanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final ElectricalResistance NEG_MAXVALUE =
            new ElectricalResistance(-Double.MAX_VALUE, ElectricalResistanceUnit.SI);

    /**
     * Construct ElectricalResistance scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalResistance(final double value, final ElectricalResistanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalResistance scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalResistance(final ElectricalResistance value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance instantiateRel(final double value, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistance(value, unit);
    }

    /**
     * Construct ElectricalResistance scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final ElectricalResistance createSI(final double value)
    {
        return new ElectricalResistance(value, ElectricalResistanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalResistance interpolate(final ElectricalResistance zero, final ElectricalResistance one,
            final double ratio)
    {
        return new ElectricalResistance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static ElectricalResistance max(final ElectricalResistance r1, final ElectricalResistance r2)
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
    public static ElectricalResistance max(final ElectricalResistance r1, final ElectricalResistance r2,
            final ElectricalResistance... rn)
    {
        ElectricalResistance maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalResistance r : rn)
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
    public static ElectricalResistance min(final ElectricalResistance r1, final ElectricalResistance r2)
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
    public static ElectricalResistance min(final ElectricalResistance r1, final ElectricalResistance r2,
            final ElectricalResistance... rn)
    {
        ElectricalResistance minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalResistance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of ElectricalResistance and ElectricalResistance, which results in a Dimensionless scalar.
     * @param v ElectricalResistance scalar
     * @return Dimensionless scalar as a division of ElectricalResistance and ElectricalResistance
     */
    public final Dimensionless divideBy(final ElectricalResistance v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalResistance and ElectricalCurrent, which results in a ElectricalPotential
     * scalar.
     * @param v ElectricalResistance scalar
     * @return ElectricalPotential scalar as a multiplication of ElectricalResistance and ElectricalCurrent
     */
    public final ElectricalPotential multiplyBy(final ElectricalCurrent v)
    {
        return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
