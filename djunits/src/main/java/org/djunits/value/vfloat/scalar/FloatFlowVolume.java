package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the FlowVolume FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;FlowVolumeUnit&gt; value = new FloatScalar.Rel&lt;FlowVolumeUnit&gt;(100.0, FlowVolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatFlowVolume value = new FloatFlowVolume(100.0, FlowVolumeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatFlowVolume extends TypedFloatScalarRel<FlowVolumeUnit, FloatFlowVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatFlowVolume scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFlowVolume(final float value, final FlowVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFlowVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFlowVolume(final FloatFlowVolume value)
    {
        super(value);
    }

    /**
     * Construct FloatFlowVolume scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatFlowVolume(final double value, final FlowVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowVolume instantiateTypeRel(final float value, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFlowVolume interpolate(final FloatFlowVolume zero, final FloatFlowVolume one, final float ratio)
    {
        return new FloatFlowVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatFlowVolume, which results in a FloatDimensionless scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatDimensionless scalar as a division of FloatFlowVolume and FloatFlowVolume
     */
    public final FloatDimensionless divideBy(final FloatFlowVolume v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFlowVolume and FloatTime, which results in a FloatVolume scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatVolume scalar as a multiplication of FloatFlowVolume and FloatTime
     */
    public final FloatVolume multiplyBy(final FloatTime.Rel v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatFrequency, which results in a FloatVolume scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatVolume scalar as a division of FloatFlowVolume and FloatFrequency
     */
    public final FloatVolume divideBy(final FloatFrequency v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatVolume, which results in a FloatFrequency scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatFrequency scalar as a division of FloatFlowVolume and FloatVolume
     */
    public final FloatFrequency divideBy(final FloatVolume v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatArea, which results in a FloatSpeed scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatSpeed scalar as a division of FloatFlowVolume and FloatArea
     */
    public final FloatSpeed divideBy(final FloatArea v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowVolume and FloatSpeed, which results in a FloatArea scalar.
     * @param v FloatFlowVolume scalar
     * @return FloatArea scalar as a division of FloatFlowVolume and FloatSpeed
     */
    public final FloatArea divideBy(final FloatSpeed v)
    {
        return new FloatArea(this.si / v.si, AreaUnit.SI);
    }

}
