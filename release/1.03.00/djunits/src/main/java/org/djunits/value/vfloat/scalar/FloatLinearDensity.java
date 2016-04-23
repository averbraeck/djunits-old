package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyPerLengthUnit;

/**
 * Easy access methods for the LinearDensity FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;LinearDensityUnit&gt; value = new FloatScalar.Rel&lt;LinearDensityUnit&gt;(100.0,
 * LinearDensityUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatLinearDensity value = new FloatLinearDensity(100.0, LinearDensityUnit.SI);</i><br>
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
public class FloatLinearDensity extends TypedFloatScalarRel<LinearDensityUnit, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatLinearDensity ZERO = new FloatLinearDensity(0.0f, LinearDensityUnit.SI);

    /**
     * Construct FloatLinearDensity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatLinearDensity(final float value, final LinearDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatLinearDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatLinearDensity(final FloatLinearDensity value)
    {
        super(value);
    }

    /**
     * Construct FloatLinearDensity scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatLinearDensity(final double value, final LinearDensityUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensity instantiateTypeRel(final float value, final LinearDensityUnit unit)
    {
        return new FloatLinearDensity(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatLinearDensity interpolate(final FloatLinearDensity zero, final FloatLinearDensity one, final float ratio)
    {
        return new FloatLinearDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatLinearDensity and FloatLinearDensity, which results in a FloatDimensionless scalar.
     * @param v FloatLinearDensity scalar
     * @return FloatDimensionless scalar as a division of FloatLinearDensity and FloatLinearDensity
     */
    public final FloatDimensionless divideBy(final FloatLinearDensity v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLinearDensity and FloatArea, which results in a FloatLength scalar.
     * @param v FloatLinearDensity scalar
     * @return FloatLength scalar as a multiplication of FloatLinearDensity and FloatArea
     */
    public final FloatLength multiplyBy(final FloatArea v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLinearDensity and FloatEnergy, which results in a FloatForce scalar.
     * @param v FloatLinearDensity scalar
     * @return FloatForce scalar as a multiplication of FloatLinearDensity and FloatEnergy
     */
    public final FloatForce multiplyBy(final FloatEnergy v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLinearDensity and FloatSpeed, which results in a FloatFrequency scalar.
     * @param v FloatLinearDensity scalar
     * @return FloatFrequency scalar as a multiplication of FloatLinearDensity and FloatSpeed
     */
    public final FloatFrequency multiplyBy(final FloatSpeed v)
    {
        return new FloatFrequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLinearDensity and FloatMoney, which results in a FloatMoneyPerLength scalar.
     * @param v FloatLinearDensity scalar
     * @return FloatMoneyPerLength scalar as a multiplication of FloatLinearDensity and FloatMoney
     */
    public final FloatMoneyPerLength multiplyBy(final FloatMoney v)
    {
        return new FloatMoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

}
