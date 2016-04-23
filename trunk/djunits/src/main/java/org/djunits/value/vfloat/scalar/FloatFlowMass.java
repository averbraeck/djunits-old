package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;

/**
 * Easy access methods for the FlowMass FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;FlowMassUnit&gt; value = new FloatScalar.Rel&lt;FlowMassUnit&gt;(100.0, FlowMassUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatFlowMass value = new FloatFlowMass(100.0, FlowMassUnit.SI);</i><br>
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
public class FloatFlowMass extends TypedFloatScalarRel<FlowMassUnit, FloatFlowMass>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatFlowMass ZERO = new FloatFlowMass(0.0f, FlowMassUnit.SI);

    /**
     * Construct FloatFlowMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFlowMass(final float value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFlowMass(final FloatFlowMass value)
    {
        super(value);
    }

    /**
     * Construct FloatFlowMass scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatFlowMass(final double value, final FlowMassUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMass instantiateTypeRel(final float value, final FlowMassUnit unit)
    {
        return new FloatFlowMass(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFlowMass interpolate(final FloatFlowMass zero, final FloatFlowMass one, final float ratio)
    {
        return new FloatFlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatFlowMass and FloatFlowMass, which results in a FloatDimensionless scalar.
     * @param v FloatFlowMass scalar
     * @return FloatDimensionless scalar as a division of FloatFlowMass and FloatFlowMass
     */
    public final FloatDimensionless divideBy(final FloatFlowMass v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFlowMass and FloatDuration, which results in a FloatMass scalar.
     * @param v FloatFlowMass scalar
     * @return FloatMass scalar as a multiplication of FloatFlowMass and FloatDuration
     */
    public final FloatMass multiplyBy(final FloatDuration v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowMass and FloatFrequency, which results in a FloatMass scalar.
     * @param v FloatFlowMass scalar
     * @return FloatMass scalar as a division of FloatFlowMass and FloatFrequency
     */
    public final FloatMass divideBy(final FloatFrequency v)
    {
        return new FloatMass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FloatFlowMass and FloatMass, which results in a FloatFrequency scalar.
     * @param v FloatFlowMass scalar
     * @return FloatFrequency scalar as a division of FloatFlowMass and FloatMass
     */
    public final FloatFrequency divideBy(final FloatMass v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatFlowMass and FloatSpeed, which results in a FloatForce scalar.
     * @param v FloatFlowMass scalar
     * @return FloatForce scalar as a multiplication of FloatFlowMass and FloatSpeed
     */
    public final FloatForce multiplyBy(final FloatSpeed v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

}
