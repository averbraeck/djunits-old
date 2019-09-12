package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatDuration;

/**
 * Immutable FloatDuration Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatDurationMatrix
        extends AbstractFloatMatrixRel<DurationUnit, FloatDurationMatrix, MutableFloatDurationMatrix, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatDurationMatrix
     * @param unit DurationUnit; the unit of the new Relative Immutable FloatDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatDurationMatrix(final float[][] values, final DurationUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param values FloatDuration[][]; the values of the entries in the new Relative Immutable FloatDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatDurationMatrix(final FloatDuration[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit DurationUnit; the unit
     */
    FloatDurationMatrix(final FloatMatrixData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationMatrix instantiateType(final FloatMatrixData fmd, final DurationUnit unit)
    {
        return new FloatDurationMatrix(fmd, unit);
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
