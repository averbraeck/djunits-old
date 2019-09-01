package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AngleUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.MathFunctionsDimensionless;

/**
 * Easy access methods for the Dimensionless FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;DimensionlessUnit&gt; value = new FloatScalar.Rel&lt;DimensionlessUnit&gt;(100.0, DimensionlessUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatDimensionless value = new FloatDimensionless(100.0, DimensionlessUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatDimensionless extends AbstractFloatScalarRel<DimensionlessUnit, FloatDimensionless>
        implements MathFunctionsDimensionless<FloatDimensionless>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDimensionless ZERO = new FloatDimensionless(0.0f, DimensionlessUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatDimensionless NaN = new FloatDimensionless(Float.NaN, DimensionlessUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatDimensionless POSITIVE_INFINITY =
            new FloatDimensionless(Float.POSITIVE_INFINITY, DimensionlessUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatDimensionless NEGATIVE_INFINITY =
            new FloatDimensionless(Float.NEGATIVE_INFINITY, DimensionlessUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatDimensionless POS_MAXVALUE = new FloatDimensionless(Float.MAX_VALUE, DimensionlessUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatDimensionless NEG_MAXVALUE = new FloatDimensionless(-Float.MAX_VALUE, DimensionlessUnit.SI);

    /**
     * Construct FloatDimensionless scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDimensionless(final float value, final DimensionlessUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDimensionless scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatDimensionless(final FloatDimensionless value)
    {
        super(value);
    }

    /**
     * Construct FloatDimensionless scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatDimensionless(final double value, final DimensionlessUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless instantiateRel(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }

    /**
     * Construct FloatDimensionless scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatDimensionless createSI(final float value)
    {
        return new FloatDimensionless(value, DimensionlessUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDimensionless interpolate(final FloatDimensionless zero, final FloatDimensionless one, final float ratio)
    {
        return new FloatDimensionless(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatDimensionless max(final FloatDimensionless r1, final FloatDimensionless r2)
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
    public static FloatDimensionless max(final FloatDimensionless r1, final FloatDimensionless r2,
            final FloatDimensionless... rn)
    {
        FloatDimensionless maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatDimensionless r : rn)
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
    public static FloatDimensionless min(final FloatDimensionless r1, final FloatDimensionless r2)
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
    public static FloatDimensionless min(final FloatDimensionless r1, final FloatDimensionless r2,
            final FloatDimensionless... rn)
    {
        FloatDimensionless minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatDimensionless r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatDimensionless representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatDimensionless
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatDimensionless valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatDimensionless -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (DimensionlessUnit unit : Unit.getUnits(DimensionlessUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatDimensionless(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatDimensionless from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatDimensionless from " + text);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless acos()
    {
        return instantiateRel((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless asin()
    {
        return instantiateRel((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless atan()
    {
        return instantiateRel((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless cbrt()
    {
        return instantiateRel((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless cos()
    {
        return instantiateRel((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless cosh()
    {
        return instantiateRel((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless exp()
    {
        return instantiateRel((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless expm1()
    {
        return instantiateRel((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless log()
    {
        return instantiateRel((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless log10()
    {
        return instantiateRel((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless log1p()
    {
        return instantiateRel((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless pow(final double x)
    {
        return instantiateRel((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless signum()
    {
        return instantiateRel(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless sin()
    {
        return instantiateRel((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless sinh()
    {
        return instantiateRel((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless sqrt()
    {
        return instantiateRel((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless tan()
    {
        return instantiateRel((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless tanh()
    {
        return instantiateRel((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless inv()
    {
        return instantiateRel(1.0f / getInUnit(), getUnit());
    }

    /**
     * Calculate the division of FloatDimensionless and FloatDimensionless, which results in a FloatDimensionless scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDimensionless scalar as a division of FloatDimensionless and FloatDimensionless
     */
    public final FloatDimensionless divideBy(final FloatDimensionless v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatAcceleration, which results in a FloatAcceleration scalar.
     * @param v FloatDimensionless scalar
     * @return FloatAcceleration scalar as a multiplication of FloatDimensionless and FloatAcceleration
     */
    public final FloatAcceleration multiplyBy(final FloatAcceleration v)
    {
        return new FloatAcceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatAngle, which results in a FloatAngle scalar.
     * @param v FloatDimensionless scalar
     * @return FloatAngle scalar as a multiplication of FloatDimensionless and FloatAngle
     */
    public final FloatAngle multiplyBy(final FloatAngle v)
    {
        return new FloatAngle(this.si * v.si, AngleUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatAngleSolid, which results in a FloatAngleSolid scalar.
     * @param v FloatDimensionless scalar
     * @return FloatAngleSolid scalar as a multiplication of FloatDimensionless and FloatAngleSolid
     */
    public final FloatAngleSolid multiplyBy(final FloatAngleSolid v)
    {
        return new FloatAngleSolid(this.si * v.si, AngleSolidUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatArea, which results in a FloatArea scalar.
     * @param v FloatDimensionless scalar
     * @return FloatArea scalar as a multiplication of FloatDimensionless and FloatArea
     */
    public final FloatArea multiplyBy(final FloatArea v)
    {
        return new FloatArea(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatDensity, which results in a FloatDensity scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDensity scalar as a multiplication of FloatDimensionless and FloatDensity
     */
    public final FloatDensity multiplyBy(final FloatDensity v)
    {
        return new FloatDensity(this.si * v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatDimensionless, which results in a FloatDimensionless scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDimensionless scalar as a multiplication of FloatDimensionless and FloatDimensionless
     */
    public final FloatDimensionless multiplyBy(final FloatDimensionless v)
    {
        return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalCharge, which results in a FloatElectricalCharge
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalCharge scalar as a multiplication of FloatDimensionless and FloatElectricalCharge
     */
    public final FloatElectricalCharge multiplyBy(final FloatElectricalCharge v)
    {
        return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalCurrent, which results in a FloatElectricalCurrent
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalCurrent scalar as a multiplication of FloatDimensionless and FloatElectricalCurrent
     */
    public final FloatElectricalCurrent multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalCurrent(this.si * v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalPotential, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatDimensionless and FloatElectricalPotential
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalPotential v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalResistance, which results in a
     * FloatElectricalResistance scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalResistance scalar as a multiplication of FloatDimensionless and FloatElectricalResistance
     */
    public final FloatElectricalResistance multiplyBy(final FloatElectricalResistance v)
    {
        return new FloatElectricalResistance(this.si * v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatEnergy, which results in a FloatEnergy scalar.
     * @param v FloatDimensionless scalar
     * @return FloatEnergy scalar as a multiplication of FloatDimensionless and FloatEnergy
     */
    public final FloatEnergy multiplyBy(final FloatEnergy v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatFlowMass, which results in a FloatFlowMass scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFlowMass scalar as a multiplication of FloatDimensionless and FloatFlowMass
     */
    public final FloatFlowMass multiplyBy(final FloatFlowMass v)
    {
        return new FloatFlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatFlowVolume, which results in a FloatFlowVolume scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFlowVolume scalar as a multiplication of FloatDimensionless and FloatFlowVolume
     */
    public final FloatFlowVolume multiplyBy(final FloatFlowVolume v)
    {
        return new FloatFlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatForce, which results in a FloatForce scalar.
     * @param v FloatDimensionless scalar
     * @return FloatForce scalar as a multiplication of FloatDimensionless and FloatForce
     */
    public final FloatForce multiplyBy(final FloatForce v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatFrequency, which results in a FloatFrequency scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFrequency scalar as a multiplication of FloatDimensionless and FloatFrequency
     */
    public final FloatFrequency multiplyBy(final FloatFrequency v)
    {
        return new FloatFrequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatLength, which results in a FloatLength scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLength scalar as a multiplication of FloatDimensionless and FloatLength
     */
    public final FloatLength multiplyBy(final FloatLength v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatLinearDensity, which results in a FloatLinearDensity scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLinearDensity scalar as a multiplication of FloatDimensionless and FloatLinearDensity
     */
    public final FloatLinearDensity multiplyBy(final FloatLinearDensity v)
    {
        return new FloatLinearDensity(this.si * v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMass, which results in a FloatMass scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMass scalar as a multiplication of FloatDimensionless and FloatMass
     */
    public final FloatMass multiplyBy(final FloatMass v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoney, which results in a FloatMoney scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoney scalar as a multiplication of FloatDimensionless and FloatMoney
     */
    public final FloatMoney multiplyBy(final FloatMoney v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerArea, which results in a FloatMoneyPerArea scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerArea scalar as a multiplication of FloatDimensionless and FloatMoneyPerArea
     */
    public final FloatMoneyPerArea multiplyBy(final FloatMoneyPerArea v)
    {
        return new FloatMoneyPerArea(this.si * v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerEnergy, which results in a FloatMoneyPerEnergy
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerEnergy scalar as a multiplication of FloatDimensionless and FloatMoneyPerEnergy
     */
    public final FloatMoneyPerEnergy multiplyBy(final FloatMoneyPerEnergy v)
    {
        return new FloatMoneyPerEnergy(this.si * v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerLength, which results in a FloatMoneyPerLength
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerLength scalar as a multiplication of FloatDimensionless and FloatMoneyPerLength
     */
    public final FloatMoneyPerLength multiplyBy(final FloatMoneyPerLength v)
    {
        return new FloatMoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerMass, which results in a FloatMoneyPerMass scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerMass scalar as a multiplication of FloatDimensionless and FloatMoneyPerMass
     */
    public final FloatMoneyPerMass multiplyBy(final FloatMoneyPerMass v)
    {
        return new FloatMoneyPerMass(this.si * v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerDuration, which results in a FloatMoneyPerDuration
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerDuration scalar as a multiplication of FloatDimensionless and FloatMoneyPerDuration
     */
    public final FloatMoneyPerDuration multiplyBy(final FloatMoneyPerDuration v)
    {
        return new FloatMoneyPerDuration(this.si * v.si, MoneyPerDurationUnit.getStandardMoneyPerDurationUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerVolume, which results in a FloatMoneyPerVolume
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerVolume scalar as a multiplication of FloatDimensionless and FloatMoneyPerVolume
     */
    public final FloatMoneyPerVolume multiplyBy(final FloatMoneyPerVolume v)
    {
        return new FloatMoneyPerVolume(this.si * v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatPower, which results in a FloatPower scalar.
     * @param v FloatDimensionless scalar
     * @return FloatPower scalar as a multiplication of FloatDimensionless and FloatPower
     */
    public final FloatPower multiplyBy(final FloatPower v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatPressure, which results in a FloatPressure scalar.
     * @param v FloatDimensionless scalar
     * @return FloatPressure scalar as a multiplication of FloatDimensionless and FloatPressure
     */
    public final FloatPressure multiplyBy(final FloatPressure v)
    {
        return new FloatPressure(this.si * v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatSpeed, which results in a FloatSpeed scalar.
     * @param v FloatDimensionless scalar
     * @return FloatSpeed scalar as a multiplication of FloatDimensionless and FloatSpeed
     */
    public final FloatSpeed multiplyBy(final FloatSpeed v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatTemperature, which results in a FloatTemperature scalar.
     * @param v FloatDimensionless scalar
     * @return FloatTemperature scalar as a multiplication of FloatDimensionless and FloatTemperature
     */
    public final FloatTemperature multiplyBy(final FloatTemperature v)
    {
        return new FloatTemperature(this.si * v.si, TemperatureUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatDuration, which results in a FloatDuration scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDuration scalar as a multiplication of FloatDimensionless and FloatDuration
     */
    public final FloatDuration multiplyBy(final FloatDuration v)
    {
        return new FloatDuration(this.si * v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatTorque, which results in a FloatTorque scalar.
     * @param v FloatDimensionless scalar
     * @return FloatTorque scalar as a multiplication of FloatDimensionless and FloatTorque
     */
    public final FloatTorque multiplyBy(final FloatTorque v)
    {
        return new FloatTorque(this.si * v.si, TorqueUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatVolume, which results in a FloatVolume scalar.
     * @param v FloatDimensionless scalar
     * @return FloatVolume scalar as a multiplication of FloatDimensionless and FloatVolume
     */
    public final FloatVolume multiplyBy(final FloatVolume v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatLength, which results in a FloatLinearDensity scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLinearDensity scalar as a division of FloatDimensionless and FloatLength
     */
    public final FloatLinearDensity divideBy(final FloatLength v)
    {
        return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatLinearDensity, which results in a FloatLength scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLength scalar as a division of FloatDimensionless and FloatLinearDensity
     */
    public final FloatLength divideBy(final FloatLinearDensity v)
    {
        return new FloatLength(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatDuration, which results in a FloatFrequency scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFrequency scalar as a division of FloatDimensionless and FloatDuration
     */
    public final FloatFrequency divideBy(final FloatDuration v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatFrequency, which results in a FloatDuration scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDuration scalar as a division of FloatDimensionless and FloatFrequency
     */
    public final FloatDuration divideBy(final FloatFrequency v)
    {
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
    }

}
