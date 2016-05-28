package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;

/**
 * Easy access methods for the ElectricalPotential DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;ElectricalPotentialUnit&gt; value = new DoubleScalar.Rel&lt;ElectricalPotentialUnit&gt;(100.0,
 *         ElectricalPotentialUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * ElectricalPotential value = new ElectricalPotential(100.0, ElectricalPotentialUnit.SI);
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
public class ElectricalPotential extends TypedDoubleScalarRel<ElectricalPotentialUnit, ElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalPotential ZERO = new ElectricalPotential(0.0, ElectricalPotentialUnit.SI);

    /**
     * Construct ElectricalPotential scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalPotential(final double value, final ElectricalPotentialUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalPotential scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalPotential(final ElectricalPotential value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalPotential instantiateTypeRel(final double value, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotential(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalPotential interpolate(final ElectricalPotential zero, final ElectricalPotential one,
            final double ratio)
    {
        return new ElectricalPotential(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static ElectricalPotential max(final ElectricalPotential r1, final ElectricalPotential r2)
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
    public static ElectricalPotential max(final ElectricalPotential r1, final ElectricalPotential r2,
            final ElectricalPotential... rn)
    {
        ElectricalPotential maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalPotential r : rn)
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
    public static ElectricalPotential min(final ElectricalPotential r1, final ElectricalPotential r2)
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
    public static ElectricalPotential min(final ElectricalPotential r1, final ElectricalPotential r2,
            final ElectricalPotential... rn)
    {
        ElectricalPotential minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalPotential r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalPotential, which results in a Dimensionless scalar.
     * @param v ElectricalPotential scalar
     * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
     */
    public final Dimensionless divideBy(final ElectricalPotential v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalPotential and ElectricalCurrent, which results in a Power scalar.
     * @param v ElectricalPotential scalar
     * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
     */
    public final Power multiplyBy(final ElectricalCurrent v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalCurrent, which results in a ElectricalResistance scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
     */
    public final ElectricalResistance divideBy(final ElectricalCurrent v)
    {
        return new ElectricalResistance(this.si / v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalResistance, which results in a ElectricalCurrent scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalCurrent scalar as a division of ElectricalPotential and ElectricalResistance
     */
    public final ElectricalCurrent divideBy(final ElectricalResistance v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

}
