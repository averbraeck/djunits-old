package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PressureUnit;

/**
 * Easy access methods for the Pressure DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;PressureUnit&gt; value = new DoubleScalar.Rel&lt;PressureUnit&gt;(100.0, PressureUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Pressure value = new Pressure(100.0, PressureUnit.SI);
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
public class Pressure extends AbstractDoubleScalarRel<PressureUnit, Pressure>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Pressure ZERO = new Pressure(0.0, PressureUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Pressure NaN = new Pressure(Double.NaN, PressureUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Pressure POSITIVE_INFINITY = new Pressure(Double.POSITIVE_INFINITY, PressureUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Pressure NEGATIVE_INFINITY = new Pressure(Double.NEGATIVE_INFINITY, PressureUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Pressure POS_MAXVALUE = new Pressure(Double.MAX_VALUE, PressureUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Pressure NEG_MAXVALUE = new Pressure(-Double.MAX_VALUE, PressureUnit.SI);

    /**
     * Construct Pressure scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Pressure(final double value, final PressureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Pressure scalar.
     * @param value Scalar from which to construct this instance
     */
    public Pressure(final Pressure value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure instantiateRel(final double value, final PressureUnit unit)
    {
        return new Pressure(value, unit);
    }

    /**
     * Construct Pressure scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Pressure createSI(final double value)
    {
        return new Pressure(value, PressureUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Pressure interpolate(final Pressure zero, final Pressure one, final double ratio)
    {
        return new Pressure(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Pressure max(final Pressure r1, final Pressure r2)
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
    public static Pressure max(final Pressure r1, final Pressure r2, final Pressure... rn)
    {
        Pressure maxr = (r1.gt(r2)) ? r1 : r2;
        for (Pressure r : rn)
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
    public static Pressure min(final Pressure r1, final Pressure r2)
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
    public static Pressure min(final Pressure r1, final Pressure r2, final Pressure... rn)
    {
        Pressure minr = (r1.lt(r2)) ? r1 : r2;
        for (Pressure r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Pressure and Pressure, which results in a Dimensionless scalar.
     * @param v Pressure scalar
     * @return Dimensionless scalar as a division of Pressure and Pressure
     */
    public final Dimensionless divideBy(final Pressure v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Pressure and Area, which results in a Force scalar.
     * @param v Pressure scalar
     * @return Force scalar as a multiplication of Pressure and Area
     */
    public final Force multiplyBy(final Area v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Pressure and Volume, which results in a Energy scalar.
     * @param v Pressure scalar
     * @return Energy scalar as a multiplication of Pressure and Volume
     */
    public final Energy multiplyBy(final Volume v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

}