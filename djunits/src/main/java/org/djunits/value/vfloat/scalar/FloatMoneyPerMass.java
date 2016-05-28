package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerMass FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MoneyPerMassUnit&gt; value = new FloatScalar.Rel&lt;MoneyPerMassUnit&gt;(100.0, MoneyPerMassUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMoneyPerMass value = new FloatMoneyPerMass(100.0, MoneyPerMassUnit.SI);
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
public class FloatMoneyPerMass extends TypedFloatScalarRel<MoneyPerMassUnit, FloatMoneyPerMass>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatMoneyPerMass scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMoneyPerMass(final float value, final MoneyPerMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMoneyPerMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMoneyPerMass(final FloatMoneyPerMass value)
    {
        super(value);
    }

    /**
     * Construct FloatMoneyPerMass scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMoneyPerMass(final double value, final MoneyPerMassUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerMass instantiateTypeRel(final float value, final MoneyPerMassUnit unit)
    {
        return new FloatMoneyPerMass(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMoneyPerMass interpolate(final FloatMoneyPerMass zero, final FloatMoneyPerMass one, final float ratio)
    {
        return new FloatMoneyPerMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static FloatMoneyPerMass max(final FloatMoneyPerMass r1, final FloatMoneyPerMass r2)
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
    public static FloatMoneyPerMass max(final FloatMoneyPerMass r1, final FloatMoneyPerMass r2, final FloatMoneyPerMass... rn)
    {
        FloatMoneyPerMass maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMoneyPerMass r : rn)
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
    public static FloatMoneyPerMass min(final FloatMoneyPerMass r1, final FloatMoneyPerMass r2)
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
    public static FloatMoneyPerMass min(final FloatMoneyPerMass r1, final FloatMoneyPerMass r2, final FloatMoneyPerMass... rn)
    {
        FloatMoneyPerMass minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMoneyPerMass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMoneyPerMass and FloatMoneyPerMass, which results in a FloatDimensionless scalar.
     * @param v FloatMoneyPerMass scalar
     * @return FloatDimensionless scalar as a division of FloatMoneyPerMass and FloatMoneyPerMass
     */
    public final FloatDimensionless divideBy(final FloatMoneyPerMass v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMoneyPerMass and FloatMass, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerMass scalar
     * @return FloatMoney scalar as a multiplication of FloatMoneyPerMass and FloatMass
     */
    public final FloatMoney multiplyBy(final FloatMass v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
