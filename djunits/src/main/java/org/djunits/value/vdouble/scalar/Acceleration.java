package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Acceleration DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;AccelerationUnit&gt; value = new DoubleScalar.Rel&lt;AccelerationUnit&gt;(100.0, AccelerationUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Acceleration value = new Acceleration(100.0, AccelerationUnit.SI);
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
public class Acceleration extends TypedDoubleScalarRel<AccelerationUnit, Acceleration>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Acceleration ZERO = new Acceleration(0.0, AccelerationUnit.SI);

    /**
     * Construct Acceleration scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Acceleration(final double value, final AccelerationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Acceleration scalar.
     * @param value Scalar from which to construct this instance
     */
    public Acceleration(final Acceleration value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Acceleration instantiateTypeRel(final double value, final AccelerationUnit unit)
    {
        return new Acceleration(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Acceleration interpolate(final Acceleration zero, final Acceleration one, final double ratio)
    {
        return new Acceleration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Acceleration max(final Acceleration r1, final Acceleration r2)
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
    public static Acceleration max(final Acceleration r1, final Acceleration r2, final Acceleration... rn)
    {
        Acceleration maxr = (r1.gt(r2)) ? r1 : r2;
        for (Acceleration r : rn)
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
    public static Acceleration min(final Acceleration r1, final Acceleration r2)
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
    public static Acceleration min(final Acceleration r1, final Acceleration r2, final Acceleration... rn)
    {
        Acceleration minr = (r1.lt(r2)) ? r1 : r2;
        for (Acceleration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Acceleration and Acceleration, which results in a Dimensionless scalar.
     * @param v Acceleration scalar
     * @return Dimensionless scalar as a division of Acceleration and Acceleration
     */
    public final Dimensionless divideBy(final Acceleration v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Acceleration and Mass, which results in a Force scalar.
     * @param v Acceleration scalar
     * @return Force scalar as a multiplication of Acceleration and Mass
     */
    public final Force multiplyBy(final Mass v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Acceleration and Duration, which results in a Speed scalar.
     * @param v Acceleration scalar
     * @return Speed scalar as a multiplication of Acceleration and Duration
     */
    public final Speed multiplyBy(final Duration v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Acceleration and Frequency, which results in a Speed scalar.
     * @param v Acceleration scalar
     * @return Speed scalar as a division of Acceleration and Frequency
     */
    public final Speed divideBy(final Frequency v)
    {
        return new Speed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Acceleration and Speed, which results in a Frequency scalar.
     * @param v Acceleration scalar
     * @return Frequency scalar as a division of Acceleration and Speed
     */
    public final Frequency divideBy(final Speed v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

}
