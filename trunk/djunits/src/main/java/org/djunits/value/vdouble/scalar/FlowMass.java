package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;

/**
 * Easy access methods for the FlowMass DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;FlowMassUnit&gt; value = new DoubleScalar.Rel&lt;FlowMassUnit&gt;(100.0, FlowMassUnit.SI);</i><br>
 * we can now write <br>
 * <i>FlowMass value = new FlowMass(100.0, FlowMassUnit.SI);</i><br>
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
public class FlowMass extends TypedDoubleScalarRel<FlowMassUnit, FlowMass>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FlowMass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public FlowMass(final double value, final FlowMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FlowMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public FlowMass(final FlowMass value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowMass instantiateTypeRel(final double value, final FlowMassUnit unit)
    {
        return new FlowMass(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FlowMass interpolate(final FlowMass zero, final FlowMass one, final double ratio)
    {
        return new FlowMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
     * @param v FlowMass scalar
     * @return Dimensionless scalar as a division of FlowMass and FlowMass
     */
    public final Dimensionless.Rel divideBy(final FlowMass v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Time, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a multiplication of FlowMass and Time
     */
    public final Mass multiplyBy(final Time.Rel v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
     * @param v FlowMass scalar
     * @return Mass scalar as a division of FlowMass and Frequency
     */
    public final Mass divideBy(final Frequency v)
    {
        return new Mass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
     * @param v FlowMass scalar
     * @return Frequency scalar as a division of FlowMass and Mass
     */
    public final Frequency divideBy(final Mass v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
     * @param v FlowMass scalar
     * @return Force scalar as a multiplication of FlowMass and Speed
     */
    public final Force multiplyBy(final Speed v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}
