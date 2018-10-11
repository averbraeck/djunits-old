package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Mass FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MassUnit&gt; value = new FloatScalar.Rel&lt;MassUnit&gt;(100.0, MassUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMass value = new FloatMass(100.0, MassUnit.SI);
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
public class FloatMass extends AbstractFloatScalarRel<MassUnit, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatMass ZERO = new FloatMass(0.0f, MassUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatMass NaN = new FloatMass(Float.NaN, MassUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatMass POSITIVE_INFINITY = new FloatMass(Float.POSITIVE_INFINITY, MassUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatMass NEGATIVE_INFINITY = new FloatMass(Float.NEGATIVE_INFINITY, MassUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatMass POS_MAXVALUE = new FloatMass(Float.MAX_VALUE, MassUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatMass NEG_MAXVALUE = new FloatMass(-Float.MAX_VALUE, MassUnit.SI);

    /**
     * Construct FloatMass scalar.
     * @param value float; float value
     * @param unit MassUnit; unit for the float value
     */
    public FloatMass(final float value, final MassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMass scalar.
     * @param value FloatMass; Scalar from which to construct this instance
     */
    public FloatMass(final FloatMass value)
    {
        super(value);
    }

    /**
     * Construct FloatMass scalar using a double value.
     * @param value double; double value
     * @param unit MassUnit; unit for the resulting float value
     */
    public FloatMass(final double value, final MassUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMass instantiateRel(final float value, final MassUnit unit)
    {
        return new FloatMass(value, unit);
    }

    /**
     * Construct FloatMass scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatMass createSI(final float value)
    {
        return new FloatMass(value, MassUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatMass; the low value
     * @param one FloatMass; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMass interpolate(final FloatMass zero, final FloatMass one, final float ratio)
    {
        return new FloatMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatMass; the first scalar
     * @param r2 FloatMass; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatMass max(final FloatMass r1, final FloatMass r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatMass; the first scalar
     * @param r2 FloatMass; the second scalar
     * @param rn FloatMass...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatMass max(final FloatMass r1, final FloatMass r2, final FloatMass... rn)
    {
        FloatMass maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMass r : rn)
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
     * @param r1 FloatMass; the first scalar
     * @param r2 FloatMass; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatMass min(final FloatMass r1, final FloatMass r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatMass; the first scalar
     * @param r2 FloatMass; the second scalar
     * @param rn FloatMass...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatMass min(final FloatMass r1, final FloatMass r2, final FloatMass... rn)
    {
        FloatMass minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatMass and FloatMass, which results in a FloatDimensionless scalar.
     * @param v FloatMass; FloatMass scalar
     * @return FloatDimensionless scalar as a division of FloatMass and FloatMass
     */
    public final FloatDimensionless divideBy(final FloatMass v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatFlowMass, which results in a FloatDuration scalar.
     * @param v FloatFlowMass; FloatMass scalar
     * @return FloatDuration scalar as a division of FloatMass and FloatFlowMass
     */
    public final FloatDuration divideBy(final FloatFlowMass v)
    {
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatDuration, which results in a FloatFlowMass scalar.
     * @param v FloatDuration; FloatMass scalar
     * @return FloatFlowMass scalar as a division of FloatMass and FloatDuration
     */
    public final FloatFlowMass divideBy(final FloatDuration v)
    {
        return new FloatFlowMass(this.si / v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatAcceleration, which results in a FloatForce scalar.
     * @param v FloatAcceleration; FloatMass scalar
     * @return FloatForce scalar as a multiplication of FloatMass and FloatAcceleration
     */
    public final FloatForce multiplyBy(final FloatAcceleration v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatFrequency, which results in a FloatFlowMass scalar.
     * @param v FloatFrequency; FloatMass scalar
     * @return FloatFlowMass scalar as a multiplication of FloatMass and FloatFrequency
     */
    public final FloatFlowMass multiplyBy(final FloatFrequency v)
    {
        return new FloatFlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatDensity, which results in a FloatVolume scalar.
     * @param v FloatDensity; FloatMass scalar
     * @return FloatVolume scalar as a division of FloatMass and FloatDensity
     */
    public final FloatVolume divideBy(final FloatDensity v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatMass and FloatVolume, which results in a FloatDensity scalar.
     * @param v FloatVolume; FloatMass scalar
     * @return FloatDensity scalar as a division of FloatMass and FloatVolume
     */
    public final FloatDensity divideBy(final FloatVolume v)
    {
        return new FloatDensity(this.si / v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatMass and FloatMoneyPerMass, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerMass; FloatMass scalar
     * @return FloatMoney scalar as a multiplication of FloatMass and FloatMoneyPerMass
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerMass v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
