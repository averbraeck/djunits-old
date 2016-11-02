package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;

/**
 * Easy access methods for the Force DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;ForceUnit&gt; value = new DoubleScalar.Rel&lt;ForceUnit&gt;(100.0, ForceUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Force value = new Force(100.0, ForceUnit.SI);
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
public class Force extends AbstractDoubleScalarRel<ForceUnit, Force>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Force ZERO = new Force(0.0, ForceUnit.SI);

    /**
     * Construct Force scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Force(final double value, final ForceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Force scalar.
     * @param value Scalar from which to construct this instance
     */
    public Force(final Force value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Force instantiateRel(final double value, final ForceUnit unit)
    {
        return new Force(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Force interpolate(final Force zero, final Force one, final double ratio)
    {
        return new Force(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Force max(final Force r1, final Force r2)
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
    public static Force max(final Force r1, final Force r2, final Force... rn)
    {
        Force maxr = (r1.gt(r2)) ? r1 : r2;
        for (Force r : rn)
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
    public static Force min(final Force r1, final Force r2)
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
    public static Force min(final Force r1, final Force r2, final Force... rn)
    {
        Force minr = (r1.lt(r2)) ? r1 : r2;
        for (Force r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Force and Force, which results in a Dimensionless scalar.
     * @param v Force scalar
     * @return Dimensionless scalar as a division of Force and Force
     */
    public final Dimensionless divideBy(final Force v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Force and Length, which results in a Energy scalar.
     * @param v Force scalar
     * @return Energy scalar as a multiplication of Force and Length
     */
    public final Energy multiplyBy(final Length v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Force and LinearDensity, which results in a Energy scalar.
     * @param v Force scalar
     * @return Energy scalar as a division of Force and LinearDensity
     */
    public final Energy divideBy(final LinearDensity v)
    {
        return new Energy(this.si / v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Force and Energy, which results in a LinearDensity scalar.
     * @param v Force scalar
     * @return LinearDensity scalar as a division of Force and Energy
     */
    public final LinearDensity divideBy(final Energy v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Force and Speed, which results in a Power scalar.
     * @param v Force scalar
     * @return Power scalar as a multiplication of Force and Speed
     */
    public final Power multiplyBy(final Speed v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Force and Mass, which results in a Acceleration scalar.
     * @param v Force scalar
     * @return Acceleration scalar as a division of Force and Mass
     */
    public final Acceleration divideBy(final Mass v)
    {
        return new Acceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Force and Acceleration, which results in a Mass scalar.
     * @param v Force scalar
     * @return Mass scalar as a division of Force and Acceleration
     */
    public final Mass divideBy(final Acceleration v)
    {
        return new Mass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of Force and Area, which results in a Pressure scalar.
     * @param v Force scalar
     * @return Pressure scalar as a division of Force and Area
     */
    public final Pressure divideBy(final Area v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of Force and Pressure, which results in a Area scalar.
     * @param v Force scalar
     * @return Area scalar as a division of Force and Pressure
     */
    public final Area divideBy(final Pressure v)
    {
        return new Area(this.si / v.si, AreaUnit.SI);
    }

}
