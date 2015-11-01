package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MassUnit;

/**
 * Easy access methods for the Density DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;DensityUnit&gt; value = new DoubleScalar.Rel&lt;DensityUnit&gt;(100.0, DensityUnit.SI);</i><br>
 * we can now write <br>
 * <i>Density value = new Density(100.0, DensityUnit.SI);</i><br>
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
public class Density extends TypedDoubleScalarRel<DensityUnit, Density>
{
    /** */
    private static final long serialVersionUID = 20150905L;

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
    protected final Density instantiateTypeRel(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
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
