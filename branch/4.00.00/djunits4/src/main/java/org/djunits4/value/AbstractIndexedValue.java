package org.djunits4.value;

import org.djunits4.unit.Unit;
import org.djunits4.value.base.Scalar;

/**
 * AbstractIndexedValue.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit type
 * @param <S> the scalar type for the U unit
 * @param <T> the value type for this unit
 */
public abstract class AbstractIndexedValue<U extends Unit<U>, S extends Scalar<U, S>, T extends AbstractIndexedValue<U, S, T>>
        extends AbstractValue<U, T> implements IndexedValue<U, S, T>
{
    /** */
    private static final long serialVersionUID = 20190927L;

    /**
     * Construct a new AbstractIndexedValue.
     * @param unit U; the unit of the new AbstractIndexedValue
     */
    protected AbstractIndexedValue(final U unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isMutable()
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public T immutable()
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public T mutable()
    {
        return null;
    }

}
