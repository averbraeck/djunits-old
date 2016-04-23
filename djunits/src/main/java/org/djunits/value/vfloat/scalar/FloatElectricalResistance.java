package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;

/**
 * Easy access methods for the ElectricalResistance FloatScalar, which is relative by definition. An example is Speed. Instead
 * of <br>
 * <i>FloatScalar.Rel&lt;ElectricalResistanceUnit&gt; value = new FloatScalar.Rel&lt;ElectricalResistanceUnit&gt;(100.0,
 * ElectricalResistanceUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatElectricalResistance value = new FloatElectricalResistance(100.0, ElectricalResistanceUnit.SI);</i><br>
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
public class FloatElectricalResistance extends TypedFloatScalarRel<ElectricalResistanceUnit, FloatElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalResistance ZERO = new FloatElectricalResistance(0.0f, ElectricalResistanceUnit.SI);

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalResistance(final float value, final ElectricalResistanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalResistance(final FloatElectricalResistance value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalResistance scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalResistance(final double value, final ElectricalResistanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalResistance instantiateTypeRel(final float value, final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistance(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalResistance interpolate(final FloatElectricalResistance zero,
            final FloatElectricalResistance one, final float ratio)
    {
        return new FloatElectricalResistance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Calculate the division of FloatElectricalResistance and FloatElectricalResistance, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalResistance scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalResistance and FloatElectricalResistance
     */
    public final FloatDimensionless divideBy(final FloatElectricalResistance v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalResistance and FloatElectricalCurrent, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatElectricalResistance scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatElectricalResistance and FloatElectricalCurrent
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
