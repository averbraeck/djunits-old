package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatTime;

/**
 * Mutable FloatTime Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatTimeMatrix extends AbstractMutableFloatMatrixAbs<TimeUnit, DurationUnit, FloatTimeMatrix,
        FloatDurationMatrix, MutableFloatTimeMatrix, FloatTime>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatTimeMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Mutable FloatTimeMatrix
     * @param unit TimeUnit; the unit of the new Absolute Mutable FloatTimeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatTimeMatrix(final float[][] values, final TimeUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeMatrix.
     * @param values FloatTime[][]; the values of the entries in the new Absolute Mutable FloatTimeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatTimeMatrix(final FloatTime[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit TimeUnit; the unit
     */
    MutableFloatTimeMatrix(final FloatMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTimeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTimeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTimeMatrix instantiateTypeAbs(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new FloatTimeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationMatrix instantiateTypeRel(final FloatMatrixData fmd, final DurationUnit unit)
    {
        return new FloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTimeMatrix instantiateMutableType(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new MutableFloatTimeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTime instantiateScalar(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

}
