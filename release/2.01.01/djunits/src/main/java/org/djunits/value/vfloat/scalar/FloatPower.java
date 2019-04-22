package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Power FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;PowerUnit&gt; value = new FloatScalar.Rel&lt;PowerUnit&gt;(100.0, PowerUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatPower value = new FloatPower(100.0, PowerUnit.SI);
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
public class FloatPower extends AbstractFloatScalarRel<PowerUnit, FloatPower>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatPower ZERO = new FloatPower(0.0f, PowerUnit.SI);

    /**
     * Construct FloatPower scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatPower(final float value, final PowerUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatPower scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatPower(final FloatPower value)
    {
        super(value);
    }

    /**
     * Construct FloatPower scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatPower(final double value, final PowerUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower instantiateRel(final float value, final PowerUnit unit)
    {
        return new FloatPower(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatPower interpolate(final FloatPower zero, final FloatPower one, final float ratio)
    {
        return new FloatPower(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatPower max(final FloatPower r1, final FloatPower r2)
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
    public static FloatPower max(final FloatPower r1, final FloatPower r2, final FloatPower... rn)
    {
        FloatPower maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatPower r : rn)
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
    public static FloatPower min(final FloatPower r1, final FloatPower r2)
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
    public static FloatPower min(final FloatPower r1, final FloatPower r2, final FloatPower... rn)
    {
        FloatPower minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatPower r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatPower and FloatPower, which results in a FloatDimensionless scalar.
     * @param v FloatPower scalar
     * @return FloatDimensionless scalar as a division of FloatPower and FloatPower
     */
    public final FloatDimensionless divideBy(final FloatPower v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatPower and FloatDuration, which results in a FloatEnergy scalar.
     * @param v FloatPower scalar
     * @return FloatEnergy scalar as a multiplication of FloatPower and FloatDuration
     */
    public final FloatEnergy multiplyBy(final FloatDuration v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of FloatPower and FloatFrequency, which results in a FloatEnergy scalar.
     * @param v FloatPower scalar
     * @return FloatEnergy scalar as a division of FloatPower and FloatFrequency
     */
    public final FloatEnergy divideBy(final FloatFrequency v)
    {
        return new FloatEnergy(this.si / v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of FloatPower and FloatEnergy, which results in a FloatFrequency scalar.
     * @param v FloatPower scalar
     * @return FloatFrequency scalar as a division of FloatPower and FloatEnergy
     */
    public final FloatFrequency divideBy(final FloatEnergy v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatPower and FloatSpeed, which results in a FloatForce scalar.
     * @param v FloatPower scalar
     * @return FloatForce scalar as a division of FloatPower and FloatSpeed
     */
    public final FloatForce divideBy(final FloatSpeed v)
    {
        return new FloatForce(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of FloatPower and FloatForce, which results in a FloatSpeed scalar.
     * @param v FloatPower scalar
     * @return FloatSpeed scalar as a division of FloatPower and FloatForce
     */
    public final FloatSpeed divideBy(final FloatForce v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatPower and FloatElectricalPotential, which results in a FloatElectricalCurrent scalar.
     * @param v FloatPower scalar
     * @return FloatElectricalCurrent scalar as a division of FloatPower and FloatElectricalPotential
     */
    public final FloatElectricalCurrent divideBy(final FloatElectricalPotential v)
    {
        return new FloatElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of FloatPower and FloatElectricalCurrent, which results in a FloatElectricalPotential scalar.
     * @param v FloatPower scalar
     * @return FloatElectricalPotential scalar as a division of FloatPower and FloatElectricalCurrent
     */
    public final FloatElectricalPotential divideBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalPotential(this.si / v.si, ElectricalPotentialUnit.SI);
    }

}