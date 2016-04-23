package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;TimeUnit&gt; value = new FloatScalar.Rel&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatDuration value = new FloatDuration(100.0, TimeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDuration extends TypedFloatScalarRel<TimeUnit, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDuration ZERO = new FloatDuration(0.0f, TimeUnit.SI);

    /**
     * Construct FloatDuration scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDuration(final float value, final TimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDuration scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatDuration(final FloatDuration value)
    {
        super(value);
    }

    /**
     * Construct FloatDuration scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatDuration(final double value, final TimeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDuration instantiateTypeRel(final float value, final TimeUnit unit)
    {
        return new FloatDuration(value, unit);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    protected final FloatTime instantiateTypeAbs(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDuration interpolate(final FloatDuration zero, final FloatDuration one, final float ratio)
    {
        return new FloatDuration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatTime plus(final FloatTime v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit()) : instantiateTypeAbs(
                this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
     * @return an absolute version of this duration scalar.
     */
    public final FloatTime toAbs()
    {
        return new FloatTime(getInUnit(), getUnit());
    }

    /**
     * Calculate the division of FloatDuration and FloatDuration, which results in a FloatDimensionless scalar.
     * @param v FloatDuration scalar
     * @return FloatDimensionless scalar as a division of FloatDuration and FloatDuration
     */
    public final FloatDimensionless divideBy(final FloatDuration v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatFrequency, which results in a FloatDimensionless scalar.
     * @param v FloatDuration scalar
     * @return FloatDimensionless scalar as a multiplication of FloatDuration and FloatFrequency
     */
    public final FloatDimensionless multiplyBy(final FloatFrequency v)
    {
        return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatElectricalCurrent, which results in a FloatElectricalCharge
     * scalar.
     * @param v FloatDuration scalar
     * @return FloatElectricalCharge scalar as a multiplication of FloatDuration and FloatElectricalCurrent
     */
    public final FloatElectricalCharge multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatFlowMass, which results in a FloatMass scalar.
     * @param v FloatDuration scalar
     * @return FloatMass scalar as a multiplication of FloatDuration and FloatFlowMass
     */
    public final FloatMass multiplyBy(final FloatFlowMass v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatFlowVolume, which results in a FloatVolume scalar.
     * @param v FloatDuration scalar
     * @return FloatVolume scalar as a multiplication of FloatDuration and FloatFlowVolume
     */
    public final FloatVolume multiplyBy(final FloatFlowVolume v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatAcceleration, which results in a FloatSpeed scalar.
     * @param v FloatDuration scalar
     * @return FloatSpeed scalar as a multiplication of FloatDuration and FloatAcceleration
     */
    public final FloatSpeed multiplyBy(final FloatAcceleration v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatPower, which results in a FloatEnergy scalar.
     * @param v FloatDuration scalar
     * @return FloatEnergy scalar as a multiplication of FloatDuration and FloatPower
     */
    public final FloatEnergy multiplyBy(final FloatPower v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatSpeed, which results in a FloatLength scalar.
     * @param v FloatDuration scalar
     * @return FloatLength scalar as a multiplication of FloatDuration and FloatSpeed
     */
    public final FloatLength multiplyBy(final FloatSpeed v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatMoneyPerTime, which results in a FloatMoney scalar.
     * @param v FloatDuration scalar
     * @return FloatMoney scalar as a multiplication of FloatDuration and FloatMoneyPerTime
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerTime v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
