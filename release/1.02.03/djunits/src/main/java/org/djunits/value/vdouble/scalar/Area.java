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
 * Easy access methods for the Area DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;AreaUnit&gt; value = new DoubleScalar.Rel&lt;AreaUnit&gt;(100.0, AreaUnit.SI);</i><br>
 * we can now write <br>
 * <i>Area value = new Area(100.0, AreaUnit.SI);</i><br>
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
public class Area extends TypedDoubleScalarRel<AreaUnit, Area>
{
    /** */
    private static final long serialVersionUID = 20150905L;

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
    protected final Area instantiateTypeRel(final double value, final AreaUnit unit)
    {
        return new Area(value, unit);
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
    public final Volume multiplyBy(final Length.Rel v)
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
    public final Length.Rel divideBy(final Length.Rel v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Area and LinearDensity, which results in a Length scalar.
     * @param v Area scalar
     * @return Length scalar as a multiplication of Area and LinearDensity
     */
    public final Length.Rel multiplyBy(final LinearDensity v)
    {
        return new Length.Rel(this.si * v.si, LengthUnit.SI);
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