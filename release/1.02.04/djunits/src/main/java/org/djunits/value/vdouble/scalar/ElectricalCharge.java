package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.TimeUnit;

/**
 * Easy access methods for the ElectricalCharge DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;ElectricalChargeUnit&gt; value = new DoubleScalar.Rel&lt;ElectricalChargeUnit&gt;(100.0,
 * ElectricalChargeUnit.SI);</i><br>
 * we can now write <br>
 * <i>ElectricalCharge value = new ElectricalCharge(100.0, ElectricalChargeUnit.SI);</i><br>
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
public class ElectricalCharge extends TypedDoubleScalarRel<ElectricalChargeUnit, ElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct ElectricalCharge scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public ElectricalCharge(final double value, final ElectricalChargeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalCharge scalar.
     * @param value Scalar from which to construct this instance
     */
    public ElectricalCharge(final ElectricalCharge value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCharge instantiateTypeRel(final double value, final ElectricalChargeUnit unit)
    {
        return new ElectricalCharge(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static ElectricalCharge interpolate(final ElectricalCharge zero, final ElectricalCharge one,
        final double ratio)
    {
        return new ElectricalCharge(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Calculate the division of ElectricalCharge and ElectricalCharge, which results in a Dimensionless scalar.
     * @param v ElectricalCharge scalar
     * @return Dimensionless scalar as a division of ElectricalCharge and ElectricalCharge
     */
    public final Dimensionless divideBy(final ElectricalCharge v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the division of ElectricalCharge and Time, which results in a ElectricalCurrent scalar.
     * @param v ElectricalCharge scalar
     * @return ElectricalCurrent scalar as a division of ElectricalCharge and Time
     */
    public final ElectricalCurrent divideBy(final Time.Rel v)
    {
        return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the division of ElectricalCharge and ElectricalCurrent, which results in a Time scalar.
     * @param v ElectricalCharge scalar
     * @return Time scalar as a division of ElectricalCharge and ElectricalCurrent
     */
    public final Time.Rel divideBy(final ElectricalCurrent v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

}
