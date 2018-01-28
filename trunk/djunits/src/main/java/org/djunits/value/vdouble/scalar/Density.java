package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MassUnit;

/**
 * Easy access methods for the Density DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;DensityUnit&gt; value = new DoubleScalar.Rel&lt;DensityUnit&gt;(100.0, DensityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Density value = new Density(100.0, DensityUnit.SI);
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
public class Density extends AbstractDoubleScalarRel<DensityUnit, Density>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Density ZERO = new Density(0.0, DensityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Density NaN = new Density(Double.NaN, DensityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Density POSITIVE_INFINITY = new Density(Double.POSITIVE_INFINITY, DensityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Density NEGATIVE_INFINITY = new Density(Double.NEGATIVE_INFINITY, DensityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Density POS_MAXVALUE = new Density(Double.MAX_VALUE, DensityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Density NEG_MAXVALUE = new Density(-Double.MAX_VALUE, DensityUnit.SI);

    /**
     * Construct Density scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Density(final double value, final DensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Density scalar.
     * @param value Scalar from which to construct this instance
     */
    public Density(final Density value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Density instantiateRel(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
    }

    /**
     * Construct Density scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Density createSI(final double value)
    {
        return new Density(value, DensityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Density interpolate(final Density zero, final Density one, final double ratio)
    {
        return new Density(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Density max(final Density r1, final Density r2)
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
    public static Density max(final Density r1, final Density r2, final Density... rn)
    {
        Density maxr = (r1.gt(r2)) ? r1 : r2;
        for (Density r : rn)
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
    public static Density min(final Density r1, final Density r2)
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
    public static Density min(final Density r1, final Density r2, final Density... rn)
    {
        Density minr = (r1.lt(r2)) ? r1 : r2;
        for (Density r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Density and Density, which results in a Dimensionless scalar.
     * @param v Density scalar
     * @return Dimensionless scalar as a division of Density and Density
     */
    public final Dimensionless divideBy(final Density v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Density and Volume, which results in a Mass scalar.
     * @param v Density scalar
     * @return Mass scalar as a multiplication of Density and Volume
     */
    public final Mass multiplyBy(final Volume v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

}
