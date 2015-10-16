package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyPerLengthUnit;

/**
 * Easy access methods for the LinearDensity DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;LinearDensityUnit&gt; value = new DoubleScalar.Rel&lt;LinearDensityUnit&gt;(100.0,
 * LinearDensityUnit.SI);</i><br>
 * we can now write <br>
 * <i>LinearDensity value = new LinearDensity(100.0, LinearDensityUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class LinearDensity extends TypedDoubleScalarRel<LinearDensityUnit, LinearDensity>
{
    /** */
    private static final long serialVersionUID = 20150905L;

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
    protected final LinearDensity instantiateTypeRel(final double value, final LinearDensityUnit unit)
    {
        return new LinearDensity(value, unit);
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
     * Calculate the division of LinearDensity and LinearDensity, which results in a Dimensionless scalar.
     * @param v LinearDensity scalar
     * @return Dimensionless scalar as a division of LinearDensity and LinearDensity
     */
    public final Dimensionless.Rel divideBy(final LinearDensity v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of LinearDensity and Area, which results in a Length scalar.
     * @param v LinearDensity scalar
     * @return Length scalar as a multiplication of LinearDensity and Area
     */
    public final Length.Rel multiplyBy(final Area v)
    {
        return new Length.Rel(this.si * v.si, LengthUnit.SI);
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
