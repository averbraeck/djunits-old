package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the Money FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyUnit&gt; value = new FloatScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoney value = new FloatMoney(100.0, MoneyUnit.SI);
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
public class FloatMoney extends TypedFloatScalarRel<MoneyUnit, FloatMoney>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoney scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoney(final float value, final MoneyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoney scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoney(final FloatMoney value)
    {
        super(value);
    }

    /**
     * Construct FloatMoney scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoney(final double value, final MoneyUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoney instantiateTypeRel(final float value, final MoneyUnit unit)
    {
        return new FloatMoney(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoney interpolate(final FloatMoney zero, final FloatMoney one, final float ratio)
    {
        return new FloatMoney(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoney max(final FloatMoney r1, final FloatMoney r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static FloatMoney max(final FloatMoney r1, final FloatMoney r2, final FloatMoney... rn)
    {
        FloatMoney maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoney r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static FloatMoney min(final FloatMoney r1, final FloatMoney r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static FloatMoney min(final FloatMoney r1, final FloatMoney r2, final FloatMoney... rn)
    {
        FloatMoney minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoney r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMoney and FloatMoney, which results in a FloatDimensionless scalar.
     * @param v FloatMoney scalar
     * @return FloatDimensionless scalar as a division of FloatMoney and FloatMoney
     */
    public final FloatDimensionless divideBy(final FloatMoney v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatMoney and FloatArea, which results in a FloatMoneyPerArea scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerArea scalar as a division of FloatMoney and FloatArea
     */
    public final FloatMoneyPerArea divideBy(final FloatArea v)
    {
        return new FloatMoneyPerArea(this.si / v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatEnergy, which results in a FloatMoneyPerEnergy scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerEnergy scalar as a division of FloatMoney and FloatEnergy
     */
    public final FloatMoneyPerEnergy divideBy(final FloatEnergy v)
    {
        return new FloatMoneyPerEnergy(this.si / v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatLength, which results in a FloatMoneyPerLength scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerLength scalar as a division of FloatMoney and FloatLength
     */
    public final FloatMoneyPerLength divideBy(final FloatLength v)
    {
        return new FloatMoneyPerLength(this.si / v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of FloatMoney and FloatLinearDensity, which results in a FloatMoneyPerLength scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerLength scalar as a multiplication of FloatMoney and FloatLinearDensity
     */
    public final FloatMoneyPerLength multiplyBy(final FloatLinearDensity v)
    {
        return new FloatMoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatMass, which results in a FloatMoneyPerMass scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerMass scalar as a division of FloatMoney and FloatMass
     */
    public final FloatMoneyPerMass divideBy(final FloatMass v)
    {
        return new FloatMoneyPerMass(this.si / v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatDuration, which results in a FloatMoneyPerTime scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerTime scalar as a division of FloatMoney and FloatDuration
     */
    public final FloatMoneyPerTime divideBy(final FloatDuration v)
    {
        return new FloatMoneyPerTime(this.si / v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the multiplication of FloatMoney and FloatFrequency, which results in a FloatMoneyPerTime scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerTime scalar as a multiplication of FloatMoney and FloatFrequency
     */
    public final FloatMoneyPerTime multiplyBy(final FloatFrequency v)
    {
        return new FloatMoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the division of FloatMoney and FloatVolume, which results in a FloatMoneyPerVolume scalar.
     * @param v FloatMoney scalar
     * @return FloatMoneyPerVolume scalar as a division of FloatMoney and FloatVolume
     */
    public final FloatMoneyPerVolume divideBy(final FloatVolume v)
    {
        return new FloatMoneyPerVolume(this.si / v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

}
