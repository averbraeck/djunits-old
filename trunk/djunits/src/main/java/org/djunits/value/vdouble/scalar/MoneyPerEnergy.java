package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerEnergy DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerEnergyUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerEnergyUnit&gt;(100.0, MoneyPerEnergyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerEnergy value = new MoneyPerEnergy(100.0, MoneyPerEnergyUnit.SI);
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
public class MoneyPerEnergy extends AbstractDoubleScalarRel<MoneyPerEnergyUnit, MoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerEnergy scalar.
     * @param value double; double value
     * @param unit MoneyPerEnergyUnit; unit for the double value
     */
    public MoneyPerEnergy(final double value, final MoneyPerEnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerEnergy scalar.
     * @param value MoneyPerEnergy; Scalar from which to construct this instance
     */
    public MoneyPerEnergy(final MoneyPerEnergy value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergy instantiateRel(final double value, final MoneyPerEnergyUnit unit)
    {
        return new MoneyPerEnergy(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero MoneyPerEnergy; the low value
     * @param one MoneyPerEnergy; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerEnergy interpolate(final MoneyPerEnergy zero, final MoneyPerEnergy one, final double ratio)
    {
        return new MoneyPerEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 MoneyPerEnergy; the first scalar
     * @param r2 MoneyPerEnergy; the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerEnergy max(final MoneyPerEnergy r1, final MoneyPerEnergy r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 MoneyPerEnergy; the first scalar
     * @param r2 MoneyPerEnergy; the second scalar
     * @param rn MoneyPerEnergy...; the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static MoneyPerEnergy max(final MoneyPerEnergy r1, final MoneyPerEnergy r2, final MoneyPerEnergy... rn)
    {
        MoneyPerEnergy maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerEnergy r : rn)
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
     * @param r1 MoneyPerEnergy; the first scalar
     * @param r2 MoneyPerEnergy; the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static MoneyPerEnergy min(final MoneyPerEnergy r1, final MoneyPerEnergy r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 MoneyPerEnergy; the first scalar
     * @param r2 MoneyPerEnergy; the second scalar
     * @param rn MoneyPerEnergy...; the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static MoneyPerEnergy min(final MoneyPerEnergy r1, final MoneyPerEnergy r2, final MoneyPerEnergy... rn)
    {
        MoneyPerEnergy minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerEnergy r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerEnergy and MoneyPerEnergy, which results in a Dimensionless scalar.
     * @param v MoneyPerEnergy; MoneyPerEnergy scalar
     * @return Dimensionless scalar as a division of MoneyPerEnergy and MoneyPerEnergy
     */
    public final Dimensionless divideBy(final MoneyPerEnergy v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerEnergy and Energy, which results in a Money scalar.
     * @param v Energy; MoneyPerEnergy scalar
     * @return Money scalar as a multiplication of MoneyPerEnergy and Energy
     */
    public final Money multiplyBy(final Energy v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
