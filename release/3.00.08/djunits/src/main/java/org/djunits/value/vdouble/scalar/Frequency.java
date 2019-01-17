package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Frequency DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;FrequencyUnit&gt; value = new DoubleScalar.Rel&lt;FrequencyUnit&gt;(100.0, FrequencyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Frequency value = new Frequency(100.0, FrequencyUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Frequency extends AbstractDoubleScalarRel<FrequencyUnit, Frequency>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Frequency ZERO = new Frequency(0.0, FrequencyUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Frequency NaN = new Frequency(Double.NaN, FrequencyUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Frequency POSITIVE_INFINITY = new Frequency(Double.POSITIVE_INFINITY, FrequencyUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Frequency NEGATIVE_INFINITY = new Frequency(Double.NEGATIVE_INFINITY, FrequencyUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Frequency POS_MAXVALUE = new Frequency(Double.MAX_VALUE, FrequencyUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Frequency NEG_MAXVALUE = new Frequency(-Double.MAX_VALUE, FrequencyUnit.SI);

    /**
     * Construct Frequency scalar.
     * @param value double; double value
     * @param unit FrequencyUnit; unit for the double value
     */
    public Frequency(final double value, final FrequencyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Frequency scalar.
     * @param value Frequency; Scalar from which to construct this instance
     */
    public Frequency(final Frequency value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency instantiateRel(final double value, final FrequencyUnit unit)
    {
        return new Frequency(value, unit);
    }

    /**
     * Construct Frequency scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Frequency createSI(final double value)
    {
        return new Frequency(value, FrequencyUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Frequency; the low value
     * @param one Frequency; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Frequency interpolate(final Frequency zero, final Frequency one, final double ratio)
    {
        return new Frequency(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Frequency; the first scalar
     * @param r2 Frequency; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Frequency max(final Frequency r1, final Frequency r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Frequency; the first scalar
     * @param r2 Frequency; the second scalar
     * @param rn Frequency...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Frequency max(final Frequency r1, final Frequency r2, final Frequency... rn)
    {
        Frequency maxr = (r1.gt(r2)) ? r1 : r2;
        for (Frequency r : rn)
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
     * @param r1 Frequency; the first scalar
     * @param r2 Frequency; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Frequency min(final Frequency r1, final Frequency r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Frequency; the first scalar
     * @param r2 Frequency; the second scalar
     * @param rn Frequency...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Frequency min(final Frequency r1, final Frequency r2, final Frequency... rn)
    {
        Frequency minr = (r1.lt(r2)) ? r1 : r2;
        for (Frequency r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Frequency and Frequency, which results in a Dimensionless scalar.
     * @param v Frequency; Frequency scalar
     * @return Dimensionless scalar as a division of Frequency and Frequency
     */
    public final Dimensionless divideBy(final Frequency v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Duration, which results in a Dimensionless scalar.
     * @param v Duration; Frequency scalar
     * @return Dimensionless scalar as a multiplication of Frequency and Duration
     */
    public final Dimensionless multiplyBy(final Duration v)
    {
        return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Length, which results in a Speed scalar.
     * @param v Length; Frequency scalar
     * @return Speed scalar as a multiplication of Frequency and Length
     */
    public final Speed multiplyBy(final Length v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Speed, which results in a Acceleration scalar.
     * @param v Speed; Frequency scalar
     * @return Acceleration scalar as a multiplication of Frequency and Speed
     */
    public final Acceleration multiplyBy(final Speed v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Energy, which results in a Power scalar.
     * @param v Energy; Frequency scalar
     * @return Power scalar as a multiplication of Frequency and Energy
     */
    public final Power multiplyBy(final Energy v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Frequency and Money, which results in a MoneyPerDuration scalar.
     * @param v Money; Frequency scalar
     * @return MoneyPerDuration scalar as a multiplication of Frequency and Money
     */
    public final MoneyPerDuration multiplyBy(final Money v)
    {
        return new MoneyPerDuration(this.si * v.si, MoneyPerDurationUnit.getStandardMoneyPerDurationUnit());
    }

}
