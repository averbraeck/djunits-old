package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Area DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;AreaUnit&gt; value = new DoubleScalar.Rel&lt;AreaUnit&gt;(100.0, AreaUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Area value = new Area(100.0, AreaUnit.SI);
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
public class Area extends AbstractDoubleScalarRel<AreaUnit, Area>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Area ZERO = new Area(0.0, AreaUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Area NaN = new Area(Double.NaN, AreaUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Area POSITIVE_INFINITY = new Area(Double.POSITIVE_INFINITY, AreaUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Area NEGATIVE_INFINITY = new Area(Double.NEGATIVE_INFINITY, AreaUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Area POS_MAXVALUE = new Area(Double.MAX_VALUE, AreaUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Area NEG_MAXVALUE = new Area(-Double.MAX_VALUE, AreaUnit.SI);

    /**
     * Construct Area scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Area(final double value, final AreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Area scalar.
     * @param value Scalar from which to construct this instance
     */
    public Area(final Area value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Area instantiateRel(final double value, final AreaUnit unit)
    {
        return new Area(value, unit);
    }

    /**
     * Construct Area scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Area createSI(final double value)
    {
        return new Area(value, AreaUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Area interpolate(final Area zero, final Area one, final double ratio)
    {
        return new Area(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Area max(final Area r1, final Area r2)
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
    public static Area max(final Area r1, final Area r2, final Area... rn)
    {
        Area maxr = (r1.gt(r2)) ? r1 : r2;
        for (Area r : rn)
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
    public static Area min(final Area r1, final Area r2)
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
    public static Area min(final Area r1, final Area r2, final Area... rn)
    {
        Area minr = (r1.lt(r2)) ? r1 : r2;
        for (Area r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Area and Area, which results in a Dimensionless scalar.
     * @param v Area scalar
     * @return Dimensionless scalar as a division of Area and Area
     */
    public final Dimensionless divideBy(final Area v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and Length, which results in a Volume scalar.
     * @param v Area scalar
     * @return Volume scalar as a multiplication of Area and Length
     */
    public final Volume multiplyBy(final Length v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Area and LinearDensity, which results in a Volume scalar.
     * @param v Area scalar
     * @return Volume scalar as a division of Area and LinearDensity
     */
    public final Volume divideBy(final LinearDensity v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Area and Volume, which results in a LinearDensity scalar.
     * @param v Area scalar
     * @return LinearDensity scalar as a division of Area and Volume
     */
    public final LinearDensity divideBy(final Volume v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of Area and Length, which results in a Length scalar.
     * @param v Area scalar
     * @return Length scalar as a division of Area and Length
     */
    public final Length divideBy(final Length v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and LinearDensity, which results in a Length scalar.
     * @param v Area scalar
     * @return Length scalar as a multiplication of Area and LinearDensity
     */
    public final Length multiplyBy(final LinearDensity v)
    {
        return new Length(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and Speed, which results in a FlowVolume scalar.
     * @param v Area scalar
     * @return FlowVolume scalar as a multiplication of Area and Speed
     */
    public final FlowVolume multiplyBy(final Speed v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and Pressure, which results in a Force scalar.
     * @param v Area scalar
     * @return Force scalar as a multiplication of Area and Pressure
     */
    public final Force multiplyBy(final Pressure v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and MoneyPerArea, which results in a Money scalar.
     * @param v Area scalar
     * @return Money scalar as a multiplication of Area and MoneyPerArea
     */
    public final Money multiplyBy(final MoneyPerArea v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
