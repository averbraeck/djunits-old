package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the Money DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; value = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.SI);</i><br>
 * we can now write <br>
 * <i>Money value = new Money(100.0, MoneyUnit.SI);</i><br>
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
public class Money extends TypedDoubleScalarRel<MoneyUnit, Money>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Money scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Money(final double value, final MoneyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Money scalar.
     * @param value Scalar from which to construct this instance
     */
    public Money(final Money value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Money instantiateTypeRel(final double value, final MoneyUnit unit)
    {
        return new Money(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Money interpolate(final Money zero, final Money one, final double ratio)
    {
        return new Money(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Money and Money, which results in a Dimensionless scalar.
     * @param v Money scalar
     * @return Dimensionless scalar as a division of Money and Money
     */
    public final Dimensionless divideBy(final Money v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Money and Area, which results in a MoneyPerArea scalar.
     * @param v Money scalar
     * @return MoneyPerArea scalar as a division of Money and Area
     */
    public final MoneyPerArea divideBy(final Area v)
    {
        return new MoneyPerArea(this.si / v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the division of Money and Energy, which results in a MoneyPerEnergy scalar.
     * @param v Money scalar
     * @return MoneyPerEnergy scalar as a division of Money and Energy
     */
    public final MoneyPerEnergy divideBy(final Energy v)
    {
        return new MoneyPerEnergy(this.si / v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the division of Money and Length, which results in a MoneyPerLength scalar.
     * @param v Money scalar
     * @return MoneyPerLength scalar as a division of Money and Length
     */
    public final MoneyPerLength divideBy(final Length v)
    {
        return new MoneyPerLength(this.si / v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of Money and LinearDensity, which results in a MoneyPerLength scalar.
     * @param v Money scalar
     * @return MoneyPerLength scalar as a multiplication of Money and LinearDensity
     */
    public final MoneyPerLength multiplyBy(final LinearDensity v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the division of Money and Mass, which results in a MoneyPerMass scalar.
     * @param v Money scalar
     * @return MoneyPerMass scalar as a division of Money and Mass
     */
    public final MoneyPerMass divideBy(final Mass v)
    {
        return new MoneyPerMass(this.si / v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the division of Money and Duration, which results in a MoneyPerTime scalar.
     * @param v Money scalar
     * @return MoneyPerTime scalar as a division of Money and Duration
     */
    public final MoneyPerTime divideBy(final Duration v)
    {
        return new MoneyPerTime(this.si / v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the multiplication of Money and Frequency, which results in a MoneyPerTime scalar.
     * @param v Money scalar
     * @return MoneyPerTime scalar as a multiplication of Money and Frequency
     */
    public final MoneyPerTime multiplyBy(final Frequency v)
    {
        return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the division of Money and Volume, which results in a MoneyPerVolume scalar.
     * @param v Money scalar
     * @return MoneyPerVolume scalar as a division of Money and Volume
     */
    public final MoneyPerVolume divideBy(final Volume v)
    {
        return new MoneyPerVolume(this.si / v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

}
