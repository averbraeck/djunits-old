package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.PowerUnit;

/**
 * Easy access methods for the ElectricalCurrent DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;ElectricalCurrentUnit&gt; value = new DoubleScalar.Rel&lt;ElectricalCurrentUnit&gt;(100.0,
 * ElectricalCurrentUnit.SI);</i><br>
 * we can now write <br>
 * <i>ElectricalCurrent value = new ElectricalCurrent(100.0, ElectricalCurrentUnit.SI);</i><br>
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
public class ElectricalCurrent extends TypedDoubleScalarRel<ElectricalCurrentUnit, ElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct ElectricalCurrent scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalCurrent(final double value, final ElectricalCurrentUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalCurrent scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalCurrent(final ElectricalCurrent value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrent instantiateTypeRel(final double value, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrent(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalCurrent interpolate(final ElectricalCurrent zero, final ElectricalCurrent one,
        final double ratio)
    {
        return new ElectricalCurrent(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of ElectricalCurrent and ElectricalCurrent, which results in a Dimensionless scalar.
     * @param v ElectricalCurrent scalar
     * @return Dimensionless scalar as a division of ElectricalCurrent and ElectricalCurrent
     */
    public final Dimensionless.Rel divideBy(final ElectricalCurrent v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalCurrent and ElectricalPotential, which results in a Power scalar.
     * @param v ElectricalCurrent scalar
     * @return Power scalar as a multiplication of ElectricalCurrent and ElectricalPotential
     */
    public final Power multiplyBy(final ElectricalPotential v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalCurrent and Time, which results in a ElectricalCharge scalar.
     * @param v ElectricalCurrent scalar
     * @return ElectricalCharge scalar as a multiplication of ElectricalCurrent and Time
     */
    public final ElectricalCharge multiplyBy(final Time.Rel v)
    {
        return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalCurrent and ElectricalResistance, which results in a ElectricalPotential
     * scalar.
     * @param v ElectricalCurrent scalar
     * @return ElectricalPotential scalar as a multiplication of ElectricalCurrent and ElectricalResistance
     */
    public final ElectricalPotential multiplyBy(final ElectricalResistance v)
    {
        return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
