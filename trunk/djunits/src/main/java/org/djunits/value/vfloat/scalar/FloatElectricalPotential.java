package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;

/**
 * Easy access methods for the ElectricalPotential FloatScalar, which is relative by definition. An example is Speed. Instead
 * of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;ElectricalPotentialUnit&gt; value =
 *         new FloatScalar.Rel&lt;ElectricalPotentialUnit&gt;(100.0, ElectricalPotentialUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatElectricalPotential value = new FloatElectricalPotential(100.0, ElectricalPotentialUnit.SI);
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
public class FloatElectricalPotential extends AbstractFloatScalarRel<ElectricalPotentialUnit, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalPotential ZERO = new FloatElectricalPotential(0.0f, ElectricalPotentialUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalPotential NaN = new FloatElectricalPotential(Float.NaN, ElectricalPotentialUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalPotential POSITIVE_INFINITY =
            new FloatElectricalPotential(Float.POSITIVE_INFINITY, ElectricalPotentialUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalPotential NEGATIVE_INFINITY =
            new FloatElectricalPotential(Float.NEGATIVE_INFINITY, ElectricalPotentialUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalPotential POS_MAXVALUE =
            new FloatElectricalPotential(Float.MAX_VALUE, ElectricalPotentialUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalPotential NEG_MAXVALUE =
            new FloatElectricalPotential(-Float.MAX_VALUE, ElectricalPotentialUnit.SI);

    /**
     * Construct FloatElectricalPotential scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalPotential(final float value, final ElectricalPotentialUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalPotential scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalPotential(final FloatElectricalPotential value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalPotential scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalPotential(final double value, final ElectricalPotentialUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotential instantiateRel(final float value, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotential(value, unit);
    }

    /**
     * Construct FloatElectricalPotential scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalPotential createSI(final float value)
    {
        return new FloatElectricalPotential(value, ElectricalPotentialUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalPotential interpolate(final FloatElectricalPotential zero, final FloatElectricalPotential one,
            final float ratio)
    {
        return new FloatElectricalPotential(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalPotential max(final FloatElectricalPotential r1, final FloatElectricalPotential r2)
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
    public static FloatElectricalPotential max(final FloatElectricalPotential r1, final FloatElectricalPotential r2,
            final FloatElectricalPotential... rn)
    {
        FloatElectricalPotential maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalPotential r : rn)
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
    public static FloatElectricalPotential min(final FloatElectricalPotential r1, final FloatElectricalPotential r2)
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
    public static FloatElectricalPotential min(final FloatElectricalPotential r1, final FloatElectricalPotential r2,
            final FloatElectricalPotential... rn)
    {
        FloatElectricalPotential minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalPotential r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatElectricalPotential and FloatElectricalPotential, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalPotential and FloatElectricalPotential
     */
    public final FloatDimensionless divideBy(final FloatElectricalPotential v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalPotential and FloatElectricalCurrent, which results in a FloatPower
     * scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatPower scalar as a multiplication of FloatElectricalPotential and FloatElectricalCurrent
     */
    public final FloatPower multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalPotential and FloatElectricalCurrent, which results in a
     * FloatElectricalResistance scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatElectricalResistance scalar as a division of FloatElectricalPotential and FloatElectricalCurrent
     */
    public final FloatElectricalResistance divideBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalResistance(this.si / v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalPotential and FloatElectricalResistance, which results in a
     * FloatElectricalCurrent scalar.
     * @param v FloatElectricalPotential scalar
     * @return FloatElectricalCurrent scalar as a division of FloatElectricalPotential and FloatElectricalResistance
     */
    public final FloatElectricalCurrent divideBy(final FloatElectricalResistance v)
    {
        return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

}
