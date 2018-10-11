package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Mass DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MassUnit&gt; value = new DoubleScalar.Rel&lt;MassUnit&gt;(100.0, MassUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Mass value = new Mass(100.0, MassUnit.SI);
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
public class Mass extends AbstractDoubleScalarRel<MassUnit, Mass>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Mass ZERO = new Mass(0.0, MassUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Mass NaN = new Mass(Double.NaN, MassUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Mass POSITIVE_INFINITY = new Mass(Double.POSITIVE_INFINITY, MassUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Mass NEGATIVE_INFINITY = new Mass(Double.NEGATIVE_INFINITY, MassUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Mass POS_MAXVALUE = new Mass(Double.MAX_VALUE, MassUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Mass NEG_MAXVALUE = new Mass(-Double.MAX_VALUE, MassUnit.SI);

    /**
     * Construct Mass scalar.
     * @param value double; double value
     * @param unit MassUnit; unit for the double value
     */
    public Mass(final double value, final MassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Mass scalar.
     * @param value Mass; Scalar from which to construct this instance
     */
    public Mass(final Mass value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Mass instantiateRel(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }

    /**
     * Construct Mass scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Mass createSI(final double value)
    {
        return new Mass(value, MassUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Mass; the low value
     * @param one Mass; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Mass interpolate(final Mass zero, final Mass one, final double ratio)
    {
        return new Mass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Mass; the first scalar
     * @param r2 Mass; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Mass max(final Mass r1, final Mass r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Mass; the first scalar
     * @param r2 Mass; the second scalar
     * @param rn Mass...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Mass max(final Mass r1, final Mass r2, final Mass... rn)
    {
        Mass maxr = (r1.gt(r2)) ? r1 : r2;
        for (Mass r : rn)
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
     * @param r1 Mass; the first scalar
     * @param r2 Mass; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Mass min(final Mass r1, final Mass r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Mass; the first scalar
     * @param r2 Mass; the second scalar
     * @param rn Mass...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Mass min(final Mass r1, final Mass r2, final Mass... rn)
    {
        Mass minr = (r1.lt(r2)) ? r1 : r2;
        for (Mass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Mass and Mass, which results in a Dimensionless scalar.
     * @param v Mass; Mass scalar
     * @return Dimensionless scalar as a division of Mass and Mass
     */
    public final Dimensionless divideBy(final Mass v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Mass and FlowMass, which results in a Duration scalar.
     * @param v FlowMass; Mass scalar
     * @return Duration scalar as a division of Mass and FlowMass
     */
    public final Duration divideBy(final FlowMass v)
    {
        return new Duration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the division of Mass and Duration, which results in a FlowMass scalar.
     * @param v Duration; Mass scalar
     * @return FlowMass scalar as a division of Mass and Duration
     */
    public final FlowMass divideBy(final Duration v)
    {
        return new FlowMass(this.si / v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and Acceleration, which results in a Force scalar.
     * @param v Acceleration; Mass scalar
     * @return Force scalar as a multiplication of Mass and Acceleration
     */
    public final Force multiplyBy(final Acceleration v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and Frequency, which results in a FlowMass scalar.
     * @param v Frequency; Mass scalar
     * @return FlowMass scalar as a multiplication of Mass and Frequency
     */
    public final FlowMass multiplyBy(final Frequency v)
    {
        return new FlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of Mass and Density, which results in a Volume scalar.
     * @param v Density; Mass scalar
     * @return Volume scalar as a division of Mass and Density
     */
    public final Volume divideBy(final Density v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Mass and Volume, which results in a Density scalar.
     * @param v Volume; Mass scalar
     * @return Density scalar as a division of Mass and Volume
     */
    public final Density divideBy(final Volume v)
    {
        return new Density(this.si / v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and MoneyPerMass, which results in a Money scalar.
     * @param v MoneyPerMass; Mass scalar
     * @return Money scalar as a multiplication of Mass and MoneyPerMass
     */
    public final Money multiplyBy(final MoneyPerMass v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
