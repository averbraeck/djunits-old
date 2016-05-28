package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the Energy DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;EnergyUnit&gt; value = new DoubleScalar.Rel&lt;EnergyUnit&gt;(100.0, EnergyUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Energy value = new Energy(100.0, EnergyUnit.SI);
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
public class Energy extends TypedDoubleScalarRel<EnergyUnit, Energy>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Energy ZERO = new Energy(0.0, EnergyUnit.SI);

    /**
     * Construct Energy scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Energy(final double value, final EnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Energy scalar.
     * @param value Scalar from which to construct this instance
     */
    public Energy(final Energy value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Energy instantiateTypeRel(final double value, final EnergyUnit unit)
    {
        return new Energy(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Energy interpolate(final Energy zero, final Energy one, final double ratio)
    {
        return new Energy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Energy max(final Energy r1, final Energy r2)
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
    public static Energy max(final Energy r1, final Energy r2, final Energy... rn)
    {
        Energy maxr = (r1.gt(r2)) ? r1 : r2;
        for (Energy r : rn)
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
    public static Energy min(final Energy r1, final Energy r2)
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
    public static Energy min(final Energy r1, final Energy r2, final Energy... rn)
    {
        Energy minr = (r1.lt(r2)) ? r1 : r2;
        for (Energy r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Energy and Energy, which results in a Dimensionless scalar.
     * @param v Energy scalar
     * @return Dimensionless scalar as a division of Energy and Energy
     */
    public final Dimensionless divideBy(final Energy v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Energy and Force, which results in a Length scalar.
     * @param v Energy scalar
     * @return Length scalar as a division of Energy and Force
     */
    public final Length divideBy(final Force v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Energy and Length, which results in a Force scalar.
     * @param v Energy scalar
     * @return Force scalar as a division of Energy and Length
     */
    public final Force divideBy(final Length v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and LinearDensity, which results in a Force scalar.
     * @param v Energy scalar
     * @return Force scalar as a multiplication of Energy and LinearDensity
     */
    public final Force multiplyBy(final LinearDensity v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Energy and Duration, which results in a Power scalar.
     * @param v Energy scalar
     * @return Power scalar as a division of Energy and Duration
     */
    public final Power divideBy(final Duration v)
    {
        return new Power(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Energy and Power, which results in a Duration scalar.
     * @param v Energy scalar
     * @return Duration scalar as a division of Energy and Power
     */
    public final Duration divideBy(final Power v)
    {
        return new Duration(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of Energy and Volume, which results in a Pressure scalar.
     * @param v Energy scalar
     * @return Pressure scalar as a division of Energy and Volume
     */
    public final Pressure divideBy(final Volume v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and Frequency, which results in a Power scalar.
     * @param v Energy scalar
     * @return Power scalar as a multiplication of Energy and Frequency
     */
    public final Power multiplyBy(final Frequency v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Energy and MoneyPerEnergy, which results in a Money scalar.
     * @param v Energy scalar
     * @return Money scalar as a multiplication of Energy and MoneyPerEnergy
     */
    public final Money multiplyBy(final MoneyPerEnergy v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
