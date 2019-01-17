package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Relative Temperature DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar&lt;TemperatureUnit&gt; value = new DoubleScalar&lt;TemperatureUnit&gt;(100.0, TemperatureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Temperature value = new Temperature(100.0, TemperatureUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Temperature extends AbstractDoubleScalarRel<TemperatureUnit, Temperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Temperature ZERO = new Temperature(0.0, TemperatureUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Temperature NaN = new Temperature(Double.NaN, TemperatureUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Temperature POSITIVE_INFINITY = new Temperature(Double.POSITIVE_INFINITY, TemperatureUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Temperature NEGATIVE_INFINITY = new Temperature(Double.NEGATIVE_INFINITY, TemperatureUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Temperature POS_MAXVALUE = new Temperature(Double.MAX_VALUE, TemperatureUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Temperature NEG_MAXVALUE = new Temperature(-Double.MAX_VALUE, TemperatureUnit.SI);

    /**
     * Construct Temperature scalar.
     * @param value double; double value
     * @param unit TemperatureUnit; unit for the double value
     */
    public Temperature(final double value, final TemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Temperature scalar.
     * @param value Temperature; Scalar from which to construct this instance
     */
    public Temperature(final Temperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Temperature instantiateRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit AbsoluteTemperatureUnit; the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public final AbsoluteTemperature instantiateAbs(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /**
     * Construct Temperature scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Temperature createSI(final double value)
    {
        return new Temperature(value, TemperatureUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Temperature; the low value
     * @param one Temperature; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Temperature interpolate(final Temperature zero, final Temperature one, final double ratio)
    {
        return new Temperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v AbsoluteTemperature; the value to add
     * @return sum of this value and v as a new object
     */
    public final AbsoluteTemperature plus(final AbsoluteTemperature v)
    {
        AbsoluteTemperatureUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Temperature; the first scalar
     * @param r2 Temperature; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Temperature max(final Temperature r1, final Temperature r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Temperature; the first scalar
     * @param r2 Temperature; the second scalar
     * @param rn Temperature...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Temperature max(final Temperature r1, final Temperature r2, final Temperature... rn)
    {
        Temperature maxr = (r1.gt(r2)) ? r1 : r2;
        for (Temperature r : rn)
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
     * @param r1 Temperature; the first scalar
     * @param r2 Temperature; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Temperature min(final Temperature r1, final Temperature r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Temperature; the first scalar
     * @param r2 Temperature; the second scalar
     * @param rn Temperature...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Temperature min(final Temperature r1, final Temperature r2, final Temperature... rn)
    {
        Temperature minr = (r1.lt(r2)) ? r1 : r2;
        for (Temperature r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Temperature and Temperature, which results in a Dimensionless scalar.
     * @param v Temperature; Temperature scalar
     * @return Dimensionless scalar as a division of Temperature and Temperature
     */
    public final Dimensionless divideBy(final Temperature v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}
