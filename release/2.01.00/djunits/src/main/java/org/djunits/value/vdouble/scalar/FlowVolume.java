package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the FlowVolume DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;FlowVolumeUnit&gt; value = new DoubleScalar.Rel&lt;FlowVolumeUnit&gt;(100.0, FlowVolumeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FlowVolume value = new FlowVolume(100.0, FlowVolumeUnit.SI);
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
public class FlowVolume extends AbstractDoubleScalarRel<FlowVolumeUnit, FlowVolume>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final FlowVolume ZERO = new FlowVolume(0.0, FlowVolumeUnit.SI);

    /**
     * Construct FlowVolume scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public FlowVolume(final double value, final FlowVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FlowVolume(final FlowVolume value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolume instantiateRel(final double value, final FlowVolumeUnit unit)
    {
        return new FlowVolume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FlowVolume interpolate(final FlowVolume zero, final FlowVolume one, final double ratio)
    {
        return new FlowVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FlowVolume max(final FlowVolume r1, final FlowVolume r2)
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
    public static FlowVolume max(final FlowVolume r1, final FlowVolume r2, final FlowVolume... rn)
    {
        FlowVolume maxr = (r1.gt(r2)) ? r1 : r2;
        for (FlowVolume r : rn)
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
    public static FlowVolume min(final FlowVolume r1, final FlowVolume r2)
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
    public static FlowVolume min(final FlowVolume r1, final FlowVolume r2, final FlowVolume... rn)
    {
        FlowVolume minr = (r1.lt(r2)) ? r1 : r2;
        for (FlowVolume r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FlowVolume and FlowVolume, which results in a Dimensionless scalar.
     * @param v FlowVolume scalar
     * @return Dimensionless scalar as a division of FlowVolume and FlowVolume
     */
    public final Dimensionless divideBy(final FlowVolume v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowVolume and Duration, which results in a Volume scalar.
     * @param v FlowVolume scalar
     * @return Volume scalar as a multiplication of FlowVolume and Duration
     */
    public final Volume multiplyBy(final Duration v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Frequency, which results in a Volume scalar.
     * @param v FlowVolume scalar
     * @return Volume scalar as a division of FlowVolume and Frequency
     */
    public final Volume divideBy(final Frequency v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Volume, which results in a Frequency scalar.
     * @param v FlowVolume scalar
     * @return Frequency scalar as a division of FlowVolume and Volume
     */
    public final Frequency divideBy(final Volume v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Area, which results in a Speed scalar.
     * @param v FlowVolume scalar
     * @return Speed scalar as a division of FlowVolume and Area
     */
    public final Speed divideBy(final Area v)
    {
        return new Speed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FlowVolume and Speed, which results in a Area scalar.
     * @param v FlowVolume scalar
     * @return Area scalar as a division of FlowVolume and Speed
     */
    public final Area divideBy(final Speed v)
    {
        return new Area(this.si / v.si, AreaUnit.SI);
    }

}
