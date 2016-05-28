package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MassUnit;

/**
 * Easy access methods for the Density FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;DensityUnit&gt; value = new FloatScalar.Rel&lt;DensityUnit&gt;(100.0, DensityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatDensity value = new FloatDensity(100.0, DensityUnit.SI);
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
public class FloatDensity extends TypedFloatScalarRel<DensityUnit, FloatDensity>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDensity ZERO = new FloatDensity(0.0f, DensityUnit.SI);

    /**
     * Construct FloatDensity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDensity(final float value, final DensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatDensity(final FloatDensity value)
    {
        super(value);
    }

    /**
     * Construct FloatDensity scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatDensity(final double value, final DensityUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDensity instantiateTypeRel(final float value, final DensityUnit unit)
    {
        return new FloatDensity(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDensity interpolate(final FloatDensity zero, final FloatDensity one, final float ratio)
    {
        return new FloatDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatDensity max(final FloatDensity r1, final FloatDensity r2)
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
    public static FloatDensity max(final FloatDensity r1, final FloatDensity r2, final FloatDensity... rn)
    {
        FloatDensity maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatDensity r : rn)
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
    public static FloatDensity min(final FloatDensity r1, final FloatDensity r2)
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
    public static FloatDensity min(final FloatDensity r1, final FloatDensity r2, final FloatDensity... rn)
    {
        FloatDensity minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatDensity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatDensity and FloatDensity, which results in a FloatDimensionless scalar.
     * @param v FloatDensity scalar
     * @return FloatDimensionless scalar as a division of FloatDensity and FloatDensity
     */
    public final FloatDimensionless divideBy(final FloatDensity v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDensity and FloatVolume, which results in a FloatMass scalar.
     * @param v FloatDensity scalar
     * @return FloatMass scalar as a multiplication of FloatDensity and FloatVolume
     */
    public final FloatMass multiplyBy(final FloatVolume v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

}
