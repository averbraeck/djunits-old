package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;

/**
 * Easy access methods for the ElectricalPotential DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;ElectricalPotentialUnit&gt; value = new DoubleScalar.Rel&lt;ElectricalPotentialUnit&gt;(100.0,
 * ElectricalPotentialUnit.SI);</i><br>
 * we can now write <br>
 * <i>ElectricalPotential value = new ElectricalPotential(100.0, ElectricalPotentialUnit.SI);</i><br>
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
public class ElectricalPotential extends TypedDoubleScalarRel<ElectricalPotentialUnit, ElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalPotential ZERO = new ElectricalPotential(0.0, ElectricalPotentialUnit.SI);

    /**
     * Construct ElectricalPotential scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalPotential(final double value, final ElectricalPotentialUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalPotential scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalPotential(final ElectricalPotential value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalPotential instantiateTypeRel(final double value, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotential(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalPotential interpolate(final ElectricalPotential zero, final ElectricalPotential one,
            final double ratio)
    {
        return new ElectricalPotential(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalPotential, which results in a Dimensionless scalar.
     * @param v ElectricalPotential scalar
     * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
     */
    public final Dimensionless divideBy(final ElectricalPotential v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of ElectricalPotential and ElectricalCurrent, which results in a Power scalar.
     * @param v ElectricalPotential scalar
     * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
     */
    public final Power multiplyBy(final ElectricalCurrent v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalCurrent, which results in a ElectricalResistance scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
     */
    public final ElectricalResistance divideBy(final ElectricalCurrent v)
    {
        return new ElectricalResistance(this.si / v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the division of ElectricalPotential and ElectricalResistance, which results in a ElectricalCurrent scalar.
     * @param v ElectricalPotential scalar
     * @return ElectricalCurrent scalar as a division of ElectricalPotential and ElectricalResistance
     */
    public final ElectricalCurrent divideBy(final ElectricalResistance v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

}
