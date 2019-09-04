package org.djunits.value.vfloat.matrix;

import org.djunits.unit.DurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDuration;

/**
 * Mutable FloatDuration Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatDurationMatrix
        extends AbstractMutableFloatMatrixRel<DurationUnit, FloatDurationMatrix, MutableFloatDurationMatrix, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatDurationMatrix.
     * @param values float[][]; the values of the entries in the new Relative Mutable FloatDurationMatrix
     * @param unit DurationUnit; the unit of the new Relative Mutable FloatDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDurationMatrix(final float[][] values, final DurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationMatrix.
     * @param values FloatDuration[][]; the values of the entries in the new Relative Mutable FloatDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDurationMatrix(final FloatDuration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit DurationUnit; the unit
     */
    MutableFloatDurationMatrix(final FloatMatrixData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationMatrix instantiateType(final FloatMatrixData fmd, final DurationUnit unit)
    {
        return new FloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDurationMatrix instantiateMutableType(final FloatMatrixData fmd, final DurationUnit unit)
    {
        return new MutableFloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDuration instantiateScalar(final float value, final DurationUnit unit)
    {
        return new FloatDuration(value, unit);
    }

}
