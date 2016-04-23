package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Relative Duration DoubleScalar. Instead of <br>
 * <i>DoubleScalar&lt;TimeUnit&gt; value = new DoubleScalar&lt;TimeUnit&gt;(100.0, TimeUnit.SI);</i><br>
 * we can now write <br>
 * <i>Duration value = new Duration(100.0, TimeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Duration extends TypedDoubleScalarRel<TimeUnit, Duration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Duration ZERO = new Duration(0.0, TimeUnit.SI);

    /**
     * Construct Duration scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Duration(final double value, final TimeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Duration scalar.
     * @param value Scalar from which to construct this instance
     */
    public Duration(final Duration value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Duration instantiateTypeRel(final double value, final TimeUnit unit)
    {
        return new Duration(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the double value
     * @param unit the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    protected final Time instantiateTypeAbs(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Duration interpolate(final Duration zero, final Duration one, final double ratio)
    {
        return new Duration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Time plus(final Time v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit()) : instantiateTypeAbs(
                this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
     * @return an absolute version of this duration scalar.
     */
    public final Time toAbs()
    {
        return new Time(getInUnit(), getUnit());
    }

    /**
     * Calculate the division of Duration and Duration, which results in a Dimensionless scalar.
     * @param v Duration scalar
     * @return Dimensionless scalar as a division of Duration and Duration
     */
    public final Dimensionless divideBy(final Duration v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and Frequency, which results in a Dimensionless scalar.
     * @param v Duration scalar
     * @return Dimensionless scalar as a multiplication of Duration and Frequency
     */
    public final Dimensionless multiplyBy(final Frequency v)
    {
        return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and ElectricalCurrent, which results in a ElectricalCharge scalar.
     * @param v Duration scalar
     * @return ElectricalCharge scalar as a multiplication of Duration and ElectricalCurrent
     */
    public final ElectricalCharge multiplyBy(final ElectricalCurrent v)
    {
        return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and FlowMass, which results in a Mass scalar.
     * @param v Duration scalar
     * @return Mass scalar as a multiplication of Duration and FlowMass
     */
    public final Mass multiplyBy(final FlowMass v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and FlowVolume, which results in a Volume scalar.
     * @param v Duration scalar
     * @return Volume scalar as a multiplication of Duration and FlowVolume
     */
    public final Volume multiplyBy(final FlowVolume v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and Acceleration, which results in a Speed scalar.
     * @param v Duration scalar
     * @return Speed scalar as a multiplication of Duration and Acceleration
     */
    public final Speed multiplyBy(final Acceleration v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and Power, which results in a Energy scalar.
     * @param v Duration scalar
     * @return Energy scalar as a multiplication of Duration and Power
     */
    public final Energy multiplyBy(final Power v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and Speed, which results in a Length scalar.
     * @param v Duration scalar
     * @return Length scalar as a multiplication of Duration and Speed
     */
    public final Length multiplyBy(final Speed v)
    {
        return new Length(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Duration and MoneyPerTime, which results in a Money scalar.
     * @param v Duration scalar
     * @return Money scalar as a multiplication of Duration and MoneyPerTime
     */
    public final Money multiplyBy(final MoneyPerTime v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
