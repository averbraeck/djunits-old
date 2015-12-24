package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Mass FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;MassUnit&gt; value = new FloatScalar.Rel&lt;MassUnit&gt;(100.0, MassUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatMass value = new FloatMass(100.0, MassUnit.SI);</i><br>
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
public class FloatMass extends TypedFloatScalarRel<MassUnit, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatMass ZERO = new FloatMass(0.0f, MassUnit.SI);

    /**
     * Construct FloatMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMass(final float value, final MassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMass(final FloatMass value)
    {
        super(value);
    }

    /**
     * Construct FloatMass scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMass(final double value, final MassUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMass instantiateTypeRel(final float value, final MassUnit unit)
    {
        return new FloatMass(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMass interpolate(final FloatMass zero, final FloatMass one, final float ratio)
    {
        return new FloatMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatMass and FloatMass, which results in a FloatDimensionless scalar.
     * @param v FloatMass scalar
     * @return FloatDimensionless scalar as a division of FloatMass and FloatMass
     */
    public final FloatDimensionless divideBy(final FloatMass v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatFlowMass, which results in a FloatTime scalar.
     * @param v FloatMass scalar
     * @return FloatTime scalar as a division of FloatMass and FloatFlowMass
     */
    public final FloatTime.Rel divideBy(final FloatFlowMass v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatTime, which results in a FloatFlowMass scalar.
     * @param v FloatMass scalar
     * @return FloatFlowMass scalar as a division of FloatMass and FloatTime
     */
    public final FloatFlowMass divideBy(final FloatTime.Rel v)
    {
        return new FloatFlowMass(this.si / v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatAcceleration, which results in a FloatForce scalar.
     * @param v FloatMass scalar
     * @return FloatForce scalar as a multiplication of FloatMass and FloatAcceleration
     */
    public final FloatForce multiplyBy(final FloatAcceleration v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatFrequency, which results in a FloatFlowMass scalar.
     * @param v FloatMass scalar
     * @return FloatFlowMass scalar as a multiplication of FloatMass and FloatFrequency
     */
    public final FloatFlowMass multiplyBy(final FloatFrequency v)
    {
        return new FloatFlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatDensity, which results in a FloatVolume scalar.
     * @param v FloatMass scalar
     * @return FloatVolume scalar as a division of FloatMass and FloatDensity
     */
    public final FloatVolume divideBy(final FloatDensity v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatVolume, which results in a FloatDensity scalar.
     * @param v FloatMass scalar
     * @return FloatDensity scalar as a division of FloatMass and FloatVolume
     */
    public final FloatDensity divideBy(final FloatVolume v)
    {
        return new FloatDensity(this.si / v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatMoneyPerMass, which results in a FloatMoney scalar.
     * @param v FloatMass scalar
     * @return FloatMoney scalar as a multiplication of FloatMass and FloatMoneyPerMass
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerMass v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
