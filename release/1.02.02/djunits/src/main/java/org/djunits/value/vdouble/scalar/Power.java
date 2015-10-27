package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;

/**
 * Easy access methods for the Power DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;PowerUnit&gt; value = new DoubleScalar.Rel&lt;PowerUnit&gt;(100.0, PowerUnit.SI);</i><br>
 * we can now write <br>
 * <i>Power value = new Power(100.0, PowerUnit.SI);</i><br>
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
public class Power extends TypedDoubleScalarRel<PowerUnit, Power>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Power scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Power(final double value, final PowerUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Power scalar.
     * @param value Scalar from which to construct this instance
     */
    public Power(final Power value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Power instantiateTypeRel(final double value, final PowerUnit unit)
    {
        return new Power(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Power interpolate(final Power zero, final Power one, final double ratio)
    {
        return new Power(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Power and Power, which results in a Dimensionless scalar.
     * @param v Power scalar
     * @return Dimensionless scalar as a division of Power and Power
     */
    public final Dimensionless.Rel divideBy(final Power v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Power and Time, which results in a Energy scalar.
     * @param v Power scalar
     * @return Energy scalar as a multiplication of Power and Time
     */
    public final Energy multiplyBy(final Time.Rel v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Power and Frequency, which results in a Energy scalar.
     * @param v Power scalar
     * @return Energy scalar as a division of Power and Frequency
     */
    public final Energy divideBy(final Frequency v)
    {
        return new Energy(this.si / v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of Power and Energy, which results in a Frequency scalar.
     * @param v Power scalar
     * @return Frequency scalar as a division of Power and Energy
     */
    public final Frequency divideBy(final Energy v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Power and Speed, which results in a Force scalar.
     * @param v Power scalar
     * @return Force scalar as a division of Power and Speed
     */
    public final Force divideBy(final Speed v)
    {
        return new Force(this.si / v.si, ForceUnit.SI);
    }

    /**
     * Calculate the division of Power and Force, which results in a Speed scalar.
     * @param v Power scalar
     * @return Speed scalar as a division of Power and Force
     */
    public final Speed divideBy(final Force v)
    {
        return new Speed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Power and ElectricalPotential, which results in a ElectricalCurrent scalar.
     * @param v Power scalar
     * @return ElectricalCurrent scalar as a division of Power and ElectricalPotential
     */
    public final ElectricalCurrent divideBy(final ElectricalPotential v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of Power and ElectricalCurrent, which results in a ElectricalPotential scalar.
     * @param v Power scalar
     * @return ElectricalPotential scalar as a division of Power and ElectricalCurrent
     */
    public final ElectricalPotential divideBy(final ElectricalCurrent v)
    {
        return new ElectricalPotential(this.si / v.si, ElectricalPotentialUnit.SI);
    }

}
