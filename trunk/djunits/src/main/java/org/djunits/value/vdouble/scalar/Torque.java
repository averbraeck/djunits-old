package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Torque DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;TorqueUnit&gt; value = new DoubleScalar.Rel&lt;TorqueUnit&gt;(100.0, TorqueUnit.SI);</i><br>
 * we can now write <br>
 * <i>Torque value = new Torque(100.0, TorqueUnit.SI);</i><br>
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
public class Torque extends TypedDoubleScalarRel<TorqueUnit, Torque>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Torque scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Torque(final double value, final TorqueUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Torque scalar.
     * @param value Scalar from which to construct this instance
     */
    public Torque(final Torque value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Torque instantiateTypeRel(final double value, final TorqueUnit unit)
    {
        return new Torque(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Torque interpolate(final Torque zero, final Torque one, final double ratio)
    {
        return new Torque(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Torque and Torque, which results in a Dimensionless scalar.
     * @param v Torque scalar
     * @return Dimensionless scalar as a division of Torque and Torque
     */
    public final Dimensionless.Rel divideBy(final Torque v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of Torque and Force, which results in a Length scalar.
     * @param v Torque scalar
     * @return Length scalar as a division of Torque and Force
     */
    public final Length.Rel divideBy(final Force v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Torque and Length, which results in a Force scalar.
     * @param v Torque scalar
     * @return Force scalar as a division of Torque and Length
     */
    public final Force divideBy(final Length.Rel v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Torque and LinearDensity, which results in a Force scalar.
     * @param v Torque scalar
     * @return Force scalar as a multiplication of Torque and LinearDensity
     */
    public final Force multiplyBy(final LinearDensity v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Torque and Time, which results in a Power scalar.
     * @param v Torque scalar
     * @return Power scalar as a division of Torque and Time
     */
    public final Power divideBy(final Time.Rel v)
    {
        return new Power(this.si / v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Torque and Power, which results in a Time scalar.
     * @param v Torque scalar
     * @return Time scalar as a division of Torque and Power
     */
    public final Time.Rel divideBy(final Power v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of Torque and Frequency, which results in a Power scalar.
     * @param v Torque scalar
     * @return Power scalar as a multiplication of Torque and Frequency
     */
    public final Power multiplyBy(final Frequency v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of Torque and Volume, which results in a Pressure scalar.
     * @param v Torque scalar
     * @return Pressure scalar as a division of Torque and Volume
     */
    public final Pressure divideBy(final Volume v)
    {
        return new Pressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of Torque and Pressure, which results in a Volume scalar.
     * @param v Torque scalar
     * @return Volume scalar as a division of Torque and Pressure
     */
    public final Volume divideBy(final Pressure v)
    {
        return new Volume(this.si / v.si, VolumeUnit.SI);
    }

}
