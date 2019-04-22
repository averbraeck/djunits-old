package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyPerLengthUnit;

/**
 * Easy access methods for the LinearDensity DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;LinearDensityUnit&gt; value = new DoubleScalar.Rel&lt;LinearDensityUnit&gt;(100.0, LinearDensityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * LinearDensity value = new LinearDensity(100.0, LinearDensityUnit.SI);
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
public class LinearDensity extends AbstractDoubleScalarRel<LinearDensityUnit, LinearDensity>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final LinearDensity ZERO = new LinearDensity(0.0, LinearDensityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final LinearDensity NaN = new LinearDensity(Double.NaN, LinearDensityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final LinearDensity POSITIVE_INFINITY = new LinearDensity(Double.POSITIVE_INFINITY, LinearDensityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final LinearDensity NEGATIVE_INFINITY = new LinearDensity(Double.NEGATIVE_INFINITY, LinearDensityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final LinearDensity POS_MAXVALUE = new LinearDensity(Double.MAX_VALUE, LinearDensityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final LinearDensity NEG_MAXVALUE = new LinearDensity(-Double.MAX_VALUE, LinearDensityUnit.SI);

    /**
     * Construct LinearDensity scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public LinearDensity(final double value, final LinearDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct LinearDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public LinearDensity(final LinearDensity value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final LinearDensity instantiateRel(final double value, final LinearDensityUnit unit)
    {
        return new LinearDensity(value, unit);
    }

    /**
     * Construct LinearDensity scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final LinearDensity createSI(final double value)
    {
        return new LinearDensity(value, LinearDensityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static LinearDensity interpolate(final LinearDensity zero, final LinearDensity one, final double ratio)
    {
        return new LinearDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static LinearDensity max(final LinearDensity r1, final LinearDensity r2)
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
    public static LinearDensity max(final LinearDensity r1, final LinearDensity r2, final LinearDensity... rn)
    {
        LinearDensity maxr = (r1.gt(r2)) ? r1 : r2;
        for (LinearDensity r : rn)
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
    public static LinearDensity min(final LinearDensity r1, final LinearDensity r2)
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
    public static LinearDensity min(final LinearDensity r1, final LinearDensity r2, final LinearDensity... rn)
    {
        LinearDensity minr = (r1.lt(r2)) ? r1 : r2;
        for (LinearDensity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of LinearDensity and LinearDensity, which results in a Dimensionless scalar.
     * @param v LinearDensity scalar
     * @return Dimensionless scalar as a division of LinearDensity and LinearDensity
     */
    public final Dimensionless divideBy(final LinearDensity v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Area, which results in a Length scalar.
     * @param v LinearDensity scalar
     * @return Length scalar as a multiplication of LinearDensity and Area
     */
    public final Length multiplyBy(final Area v)
    {
        return new Length(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Energy, which results in a Force scalar.
     * @param v LinearDensity scalar
     * @return Force scalar as a multiplication of LinearDensity and Energy
     */
    public final Force multiplyBy(final Energy v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Speed, which results in a Frequency scalar.
     * @param v LinearDensity scalar
     * @return Frequency scalar as a multiplication of LinearDensity and Speed
     */
    public final Frequency multiplyBy(final Speed v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Money, which results in a MoneyPerLength scalar.
     * @param v LinearDensity scalar
     * @return MoneyPerLength scalar as a multiplication of LinearDensity and Money
     */
    public final MoneyPerLength multiplyBy(final Money v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

}