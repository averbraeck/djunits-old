package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerVolume FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyPerVolumeUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerVolumeUnit&gt;(100.0, MoneyPerVolumeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoneyPerVolume value = new FloatMoneyPerVolume(100.0, MoneyPerVolumeUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMoneyPerVolume extends AbstractFloatScalarRel<MoneyPerVolumeUnit, FloatMoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerVolume scalar.
     * @param value float; float value
     * @param unit MoneyPerVolumeUnit; unit for the float value
     */
    public FloatMoneyPerVolume(final float value, final MoneyPerVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerVolume scalar.
     * @param value FloatMoneyPerVolume; Scalar from which to construct this instance
     */
    public FloatMoneyPerVolume(final FloatMoneyPerVolume value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerVolume scalar using a double value.
     * @param value double; double value
     * @param unit MoneyPerVolumeUnit; unit for the resulting float value
     */
    public FloatMoneyPerVolume(final double value, final MoneyPerVolumeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolume instantiateRel(final float value, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatMoneyPerVolume; the low value
     * @param one FloatMoneyPerVolume; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerVolume interpolate(final FloatMoneyPerVolume zero, final FloatMoneyPerVolume one,
            final float ratio)
    {
        return new FloatMoneyPerVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 FloatMoneyPerVolume; the first scalar
     * @param r2 FloatMoneyPerVolume; the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoneyPerVolume max(final FloatMoneyPerVolume r1, final FloatMoneyPerVolume r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 FloatMoneyPerVolume; the first scalar
     * @param r2 FloatMoneyPerVolume; the second scalar
     * @param rn FloatMoneyPerVolume...; the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static FloatMoneyPerVolume max(final FloatMoneyPerVolume r1, final FloatMoneyPerVolume r2,
            final FloatMoneyPerVolume... rn)
    {
        FloatMoneyPerVolume maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoneyPerVolume r : rn)
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
     * @param r1 FloatMoneyPerVolume; the first scalar
     * @param r2 FloatMoneyPerVolume; the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static FloatMoneyPerVolume min(final FloatMoneyPerVolume r1, final FloatMoneyPerVolume r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 FloatMoneyPerVolume; the first scalar
     * @param r2 FloatMoneyPerVolume; the second scalar
     * @param rn FloatMoneyPerVolume...; the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static FloatMoneyPerVolume min(final FloatMoneyPerVolume r1, final FloatMoneyPerVolume r2,
            final FloatMoneyPerVolume... rn)
    {
        FloatMoneyPerVolume minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoneyPerVolume r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMoneyPerVolume and FloatMoneyPerVolume, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerVolume; FloatMoneyPerVolume scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerVolume and FloatMoneyPerVolume
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerVolume v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerVolume and FloatVolume, which results in a FloatMoney scalar.
     * @param v FloatVolume; FloatMoneyPerVolume scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerVolume and FloatVolume
     */
    public final FloatMoney multiplyBy(final FloatVolume v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
