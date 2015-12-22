package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Volume DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;VolumeUnit&gt; value = new DoubleScalar.Rel&lt;VolumeUnit&gt;(100.0, VolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>Volume value = new Volume(100.0, VolumeUnit.SI);</i><br>
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
public class Volume extends TypedDoubleScalarRel<VolumeUnit, Volume>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Volume ZERO = new Volume(0.0, VolumeUnit.SI);

    /**
     * Construct Volume scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Volume(final double value, final VolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Volume scalar.
     * @param value Scalar from which to construct this instance
     */
    public Volume(final Volume value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Volume instantiateTypeRel(final double value, final VolumeUnit unit)
    {
        return new Volume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Volume interpolate(final Volume zero, final Volume one, final double ratio)
    {
        return new Volume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Volume and Volume, which results in a Dimensionless scalar.
     * @param v Volume scalar
     * @return Dimensionless scalar as a division of Volume and Volume
     */
    public final Dimensionless divideBy(final Volume v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Volume and Density, which results in a Mass scalar.
     * @param v Volume scalar
     * @return Mass scalar as a multiplication of Volume and Density
     */
    public final Mass multiplyBy(final Density v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of Volume and Pressure, which results in a Energy scalar.
     * @param v Volume scalar
     * @return Energy scalar as a multiplication of Volume and Pressure
     */
    public final Energy multiplyBy(final Pressure v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Volume and Length, which results in a Area scalar.
     * @param v Volume scalar
     * @return Area scalar as a division of Volume and Length
     */
    public final Area divideBy(final Length.Rel v)
    {
        return new Area(this.si / v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of Volume and Area, which results in a Length scalar.
     * @param v Volume scalar
     * @return Length scalar as a division of Volume and Area
     */
    public final Length.Rel divideBy(final Area v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Volume and LinearDensity, which results in a Area scalar.
     * @param v Volume scalar
     * @return Area scalar as a multiplication of Volume and LinearDensity
     */
    public final Area multiplyBy(final LinearDensity v)
    {
        return new Area(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of Volume and Time, which results in a FlowVolume scalar.
     * @param v Volume scalar
     * @return FlowVolume scalar as a division of Volume and Time
     */
    public final FlowVolume divideBy(final Time.Rel v)
    {
        return new FlowVolume(this.si / v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the division of Volume and FlowVolume, which results in a Time scalar.
     * @param v Volume scalar
     * @return Time scalar as a division of Volume and FlowVolume
     */
    public final Time.Rel divideBy(final FlowVolume v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of Volume and MoneyPerVolume, which results in a Money scalar.
     * @param v Volume scalar
     * @return Money scalar as a multiplication of Volume and MoneyPerVolume
     */
    public final Money multiplyBy(final MoneyPerVolume v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
