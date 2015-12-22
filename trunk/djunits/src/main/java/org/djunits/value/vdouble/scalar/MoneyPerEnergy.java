package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerEnergy DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyPerEnergyUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerEnergyUnit&gt;(100.0,
 * MoneyPerEnergyUnit.SI);</i><br>
 * we can now write <br>
 * <i>MoneyPerEnergy value = new MoneyPerEnergy(100.0, MoneyPerEnergyUnit.SI);</i><br>
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
public class MoneyPerEnergy extends TypedDoubleScalarRel<MoneyPerEnergyUnit, MoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerEnergy scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerEnergy(final double value, final MoneyPerEnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerEnergy scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerEnergy(final MoneyPerEnergy value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerEnergy instantiateTypeRel(final double value, final MoneyPerEnergyUnit unit)
    {
        return new MoneyPerEnergy(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerEnergy interpolate(final MoneyPerEnergy zero, final MoneyPerEnergy one, final double ratio)
    {
        return new MoneyPerEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
            zero.getUnit());
    }

    /**
     * Calculate the division of MoneyPerEnergy and MoneyPerEnergy, which results in a Dimensionless scalar.
     * @param v MoneyPerEnergy scalar
     * @return Dimensionless scalar as a division of MoneyPerEnergy and MoneyPerEnergy
     */
    public final Dimensionless divideBy(final MoneyPerEnergy v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerEnergy and Energy, which results in a Money scalar.
     * @param v MoneyPerEnergy scalar
     * @return Money scalar as a multiplication of MoneyPerEnergy and Energy
     */
    public final Money multiplyBy(final Energy v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
