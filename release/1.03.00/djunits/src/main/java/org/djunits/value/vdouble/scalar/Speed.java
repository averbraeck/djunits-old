package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the Speed DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SpeedUnit&gt; value = new DoubleScalar.Rel&lt;SpeedUnit&gt;(100.0, SpeedUnit.SI);</i><br>
 * we can now write <br>
 * <i>Speed value = new Speed(100.0, SpeedUnit.SI);</i><br>
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
public class Speed extends TypedDoubleScalarRel<SpeedUnit, Speed>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Speed ZERO = new Speed(0.0, SpeedUnit.SI);

    /**
     * Construct Speed scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Speed(final double value, final SpeedUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Speed scalar.
     * @param value Scalar from which to construct this instance
     */
    public Speed(final Speed value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Speed instantiateTypeRel(final double value, final SpeedUnit unit)
    {
        return new Speed(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Speed interpolate(final Speed zero, final Speed one, final double ratio)
    {
        return new Speed(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Speed and Speed, which results in a Dimensionless scalar.
     * @param v Speed scalar
     * @return Dimensionless scalar as a division of Speed and Speed
     */
    public final Dimensionless divideBy(final Speed v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Area, which results in a FlowVolume scalar.
     * @param v Speed scalar
     * @return FlowVolume scalar as a multiplication of Speed and Area
     */
    public final FlowVolume multiplyBy(final Area v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Force, which results in a Power scalar.
     * @param v Speed scalar
     * @return Power scalar as a multiplication of Speed and Force
     */
    public final Power multiplyBy(final Force v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Frequency, which results in a Acceleration scalar.
     * @param v Speed scalar
     * @return Acceleration scalar as a multiplication of Speed and Frequency
     */
    public final Acceleration multiplyBy(final Frequency v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Speed and Length, which results in a Frequency scalar.
     * @param v Speed scalar
     * @return Frequency scalar as a division of Speed and Length
     */
    public final Frequency divideBy(final Length v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Speed and Frequency, which results in a Length scalar.
     * @param v Speed scalar
     * @return Length scalar as a division of Speed and Frequency
     */
    public final Length divideBy(final Frequency v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and LinearDensity, which results in a Frequency scalar.
     * @param v Speed scalar
     * @return Frequency scalar as a multiplication of Speed and LinearDensity
     */
    public final Frequency multiplyBy(final LinearDensity v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Duration, which results in a Length scalar.
     * @param v Speed scalar
     * @return Length scalar as a multiplication of Speed and Duration
     */
    public final Length multiplyBy(final Duration v)
    {
        return new Length(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Speed and Duration, which results in a Acceleration scalar.
     * @param v Speed scalar
     * @return Acceleration scalar as a division of Speed and Duration
     */
    public final Acceleration divideBy(final Duration v)
    {
        return new Acceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Speed and Acceleration, which results in a Duration scalar.
     * @param v Speed scalar
     * @return Duration scalar as a division of Speed and Acceleration
     */
    public final Duration divideBy(final Acceleration v)
    {
        return new Duration(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and FlowMass, which results in a Force scalar.
     * @param v Speed scalar
     * @return Force scalar as a multiplication of Speed and FlowMass
     */
    public final Force multiplyBy(final FlowMass v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}
