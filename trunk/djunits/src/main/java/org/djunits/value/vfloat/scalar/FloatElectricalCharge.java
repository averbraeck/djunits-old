package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the ElectricalCharge FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;ElectricalChargeUnit&gt; value = new FloatScalar.Rel&lt;ElectricalChargeUnit&gt;(100.0,
 * ElectricalChargeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatElectricalCharge value = new FloatElectricalCharge(100.0, ElectricalChargeUnit.SI);</i><br>
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
public class FloatElectricalCharge extends TypedFloatScalarRel<ElectricalChargeUnit, FloatElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalCharge(final float value, final ElectricalChargeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalCharge scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalCharge(final FloatElectricalCharge value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalCharge scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalCharge(final double value, final ElectricalChargeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCharge instantiateTypeRel(final float value, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalCharge(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalCharge interpolate(final FloatElectricalCharge zero, final FloatElectricalCharge one,
        final float ratio)
    {
        return new FloatElectricalCharge(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatElectricalCharge, which results in a FloatDimensionless scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalCharge and FloatElectricalCharge
     */
    public final FloatDimensionless divideBy(final FloatElectricalCharge v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatTime, which results in a FloatElectricalCurrent scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatElectricalCurrent scalar as a division of FloatElectricalCharge and FloatTime
     */
    public final FloatElectricalCurrent divideBy(final FloatTime.Rel v)
    {
        return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of FloatElectricalCharge and FloatElectricalCurrent, which results in a FloatTime scalar.
     * @param v FloatElectricalCharge scalar
     * @return FloatTime scalar as a division of FloatElectricalCharge and FloatElectricalCurrent
     */
    public final FloatTime.Rel divideBy(final FloatElectricalCurrent v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
    }

}
