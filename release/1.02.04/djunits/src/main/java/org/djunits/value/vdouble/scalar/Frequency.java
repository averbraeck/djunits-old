package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Frequency DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;FrequencyUnit&gt; value = new DoubleScalar.Rel&lt;FrequencyUnit&gt;(100.0, FrequencyUnit.SI);</i><br>
 * we can now write <br>
 * <i>Frequency value = new Frequency(100.0, FrequencyUnit.SI);</i><br>
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
public class Frequency extends TypedDoubleScalarRel<FrequencyUnit, Frequency>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Frequency scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Frequency(final double value, final FrequencyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Frequency scalar.
     * @param value Scalar from which to construct this instance
     */
    public Frequency(final Frequency value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Frequency instantiateTypeRel(final double value, final FrequencyUnit unit)
    {
        return new Frequency(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Frequency interpolate(final Frequency zero, final Frequency one, final double ratio)
    {
        return new Frequency(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Frequency and Frequency, which results in a Dimensionless scalar.
     * @param v Frequency scalar
     * @return Dimensionless scalar as a division of Frequency and Frequency
     */
    public final Dimensionless divideBy(final Frequency v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Time, which results in a Dimensionless scalar.
     * @param v Frequency scalar
     * @return Dimensionless scalar as a multiplication of Frequency and Time
     */
    public final Dimensionless multiplyBy(final Time.Rel v)
    {
        return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Length, which results in a Speed scalar.
     * @param v Frequency scalar
     * @return Speed scalar as a multiplication of Frequency and Length
     */
    public final Speed multiplyBy(final Length.Rel v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Speed, which results in a Acceleration scalar.
     * @param v Frequency scalar
     * @return Acceleration scalar as a multiplication of Frequency and Speed
     */
    public final Acceleration multiplyBy(final Speed v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Energy, which results in a Power scalar.
     * @param v Frequency scalar
     * @return Power scalar as a multiplication of Frequency and Energy
     */
    public final Power multiplyBy(final Energy v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Money, which results in a MoneyPerTime scalar.
     * @param v Frequency scalar
     * @return MoneyPerTime scalar as a multiplication of Frequency and Money
     */
    public final MoneyPerTime multiplyBy(final Money v)
    {
        return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

}
