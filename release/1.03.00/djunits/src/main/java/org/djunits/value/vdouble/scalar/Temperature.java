package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Relative Temperature DoubleScalar. Instead of <br>
 * <i>DoubleScalar&lt;TemperatureUnit&gt; value = new DoubleScalar&lt;TemperatureUnit&gt;(100.0, TemperatureUnit.SI);</i><br>
 * we can now write <br>
 * <i>Temperature value = new Temperature(100.0, TemperatureUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Temperature extends TypedDoubleScalarRel<TemperatureUnit, Temperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Temperature ZERO = new Temperature(0.0, TemperatureUnit.SI);

    /**
     * Construct Temperature scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Temperature(final double value, final TemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Temperature scalar.
     * @param value Scalar from which to construct this instance
     */
    public Temperature(final Temperature value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Temperature instantiateTypeRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the double value
     * @param unit the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    protected final AbsoluteTemperature instantiateTypeAbs(final double value, final TemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Temperature interpolate(final Temperature zero, final Temperature one, final double ratio)
    {
        return new Temperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final AbsoluteTemperature plus(final AbsoluteTemperature v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit()) : instantiateTypeAbs(
                this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
     * @return an absolute version of this temperature scalar.
     */
    public final AbsoluteTemperature toAbs()
    {
        return new AbsoluteTemperature(getInUnit(), getUnit());
    }

    /**
     * Calculate the division of Temperature and Temperature, which results in a Dimensionless scalar.
     * @param v Temperature scalar
     * @return Dimensionless scalar as a division of Temperature and Temperature
     */
    public final Dimensionless divideBy(final Temperature v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}
