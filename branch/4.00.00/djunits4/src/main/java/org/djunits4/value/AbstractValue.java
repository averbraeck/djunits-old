package org.djunits4.value;

import java.io.Serializable;

import org.djunits4.unit.Unit;

/**
 * AbstractValue is a class to help construct Matrix, Complex, and Vector but it does not extend java.lang.Number. The Scalar
 * class <i>does</i> extend Number, and implements the same interfaces from Value.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the Unit of the value(s) in this AbstractValue. Used for setting, getting and displaying the value(s)
 */
public abstract class AbstractValue<U extends Unit<U>> implements Value<U>, Serializable
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /** The display unit of this AbstractValue. */
    private U unit;

    /**
     * Construct a new AbstractValue.
     * @param unit U; the unit of the new AbstractValue
     */
    protected AbstractValue(final U unit)
    {
        this.unit = unit;
    }

    /** {@inheritDoc} */
    @Override
    public final U getUnit()
    {
        return this.unit;
    }

    /** {@inheritDoc} */
    @Override
    public final double expressAsSIUnit(final double value)
    {
        return ValueUtil.expressAsSIUnit(value, this.unit);
    }

    /**
     * Convert a value in SI standard unit into the unit of this AbstractValue.
     * @param value double; the value in the standard SI unit
     * @return double; the value in the unit as specified for this AbstractValue
     */
    protected final double expressAsSpecifiedUnit(final double value)
    {
        return ValueUtil.expressAsUnit(value, this.unit);
    }

    /** {@inheritDoc} */
    @Override
    public void setDisplayUnit(final U newUnit)
    {
        this.unit = newUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isAbsolute()
    {
        return this instanceof Absolute;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isRelative()
    {
        return this instanceof Relative;
    }

    // No hashcode or equals -- has to be implemented on a deeper level

}
