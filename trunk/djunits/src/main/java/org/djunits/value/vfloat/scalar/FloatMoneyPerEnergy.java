package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerEnergy FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyPerEnergyUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerEnergyUnit&gt;(100.0, MoneyPerEnergyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoneyPerEnergy value = new FloatMoneyPerEnergy(100.0, MoneyPerEnergyUnit.SI);
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
public class FloatMoneyPerEnergy extends AbstractFloatScalarRel<MoneyPerEnergyUnit, FloatMoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerEnergy scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerEnergy(final float value, final MoneyPerEnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerEnergy scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerEnergy(final FloatMoneyPerEnergy value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerEnergy scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoneyPerEnergy(final double value, final MoneyPerEnergyUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy instantiateRel(final float value, final MoneyPerEnergyUnit unit)
    {
        return new FloatMoneyPerEnergy(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerEnergy interpolate(final FloatMoneyPerEnergy zero, final FloatMoneyPerEnergy one,
            final float ratio)
    {
        return new FloatMoneyPerEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoneyPerEnergy max(final FloatMoneyPerEnergy r1, final FloatMoneyPerEnergy r2)
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
    public static FloatMoneyPerEnergy max(final FloatMoneyPerEnergy r1, final FloatMoneyPerEnergy r2,
            final FloatMoneyPerEnergy... rn)
    {
        FloatMoneyPerEnergy maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoneyPerEnergy r : rn)
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
    public static FloatMoneyPerEnergy min(final FloatMoneyPerEnergy r1, final FloatMoneyPerEnergy r2)
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
    public static FloatMoneyPerEnergy min(final FloatMoneyPerEnergy r1, final FloatMoneyPerEnergy r2,
            final FloatMoneyPerEnergy... rn)
    {
        FloatMoneyPerEnergy minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoneyPerEnergy r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMoneyPerEnergy and FloatMoneyPerEnergy, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerEnergy scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerEnergy and FloatMoneyPerEnergy
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerEnergy v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerEnergy and FloatEnergy, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerEnergy scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerEnergy and FloatEnergy
     */
    public final FloatMoney multiplyBy(final FloatEnergy v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
