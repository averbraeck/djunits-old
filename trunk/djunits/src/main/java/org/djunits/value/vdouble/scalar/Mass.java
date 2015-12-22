package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Mass DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MassUnit&gt; value = new DoubleScalar.Rel&lt;MassUnit&gt;(100.0, MassUnit.SI);</i><br>
 * we can now write <br>
 * <i>Mass value = new Mass(100.0, MassUnit.SI);</i><br>
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
public class Mass extends TypedDoubleScalarRel<MassUnit, Mass>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Mass ZERO = new Mass(0.0, MassUnit.SI);

    /**
     * Construct Mass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Mass(final double value, final MassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Mass scalar.
     * @param value Scalar from which to construct this instance
     */
    public Mass(final Mass value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mass instantiateTypeRel(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Mass interpolate(final Mass zero, final Mass one, final double ratio)
    {
        return new Mass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Mass and Mass, which results in a Dimensionless scalar.
     * @param v Mass scalar
     * @return Dimensionless scalar as a division of Mass and Mass
     */
    public final Dimensionless divideBy(final Mass v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Mass and FlowMass, which results in a Time scalar.
     * @param v Mass scalar
     * @return Time scalar as a division of Mass and FlowMass
     */
    public final Time.Rel divideBy(final FlowMass v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the division of Mass and Time, which results in a FlowMass scalar.
     * @param v Mass scalar
     * @return FlowMass scalar as a division of Mass and Time
     */
    public final FlowMass divideBy(final Time.Rel v)
    {
        return new FlowMass(this.si / v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and Acceleration, which results in a Force scalar.
     * @param v Mass scalar
     * @return Force scalar as a multiplication of Mass and Acceleration
     */
    public final Force multiplyBy(final Acceleration v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and Frequency, which results in a FlowMass scalar.
     * @param v Mass scalar
     * @return FlowMass scalar as a multiplication of Mass and Frequency
     */
    public final FlowMass multiplyBy(final Frequency v)
    {
        return new FlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the division of Mass and Density, which results in a Volume scalar.
     * @param v Mass scalar
     * @return Volume scalar as a division of Mass and Density
     */
    public final Volume divideBy(final Density v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Mass and Volume, which results in a Density scalar.
     * @param v Mass scalar
     * @return Density scalar as a division of Mass and Volume
     */
    public final Density divideBy(final Volume v)
    {
        return new Density(this.si / v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Mass and MoneyPerMass, which results in a Money scalar.
     * @param v Mass scalar
     * @return Money scalar as a multiplication of Mass and MoneyPerMass
     */
    public final Money multiplyBy(final MoneyPerMass v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
