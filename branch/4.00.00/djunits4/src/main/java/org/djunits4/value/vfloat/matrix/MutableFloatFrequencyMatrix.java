package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FrequencyUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatFrequency;

/**
 * Mutable FloatFrequencyMatrix, a matrix of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatFrequencyMatrix
        extends AbstractMutableFloatMatrixRel<FrequencyUnit, FloatFrequencyMatrix, MutableFloatFrequencyMatrix, FloatFrequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatFrequencyMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatFrequencyMatrix
     * @param unit FrequencyUnit; the unit of the new Relative Immutable FloatFrequencyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatFrequencyMatrix(final float[][] values, final FrequencyUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFrequencyMatrix.
     * @param values FloatFrequency[][]; the values of the entries in the new Relative Immutable Float FloatFrequencyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatFrequencyMatrix(final FloatFrequency[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    MutableFloatFrequencyMatrix(final FloatMatrixData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFrequencyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFrequencyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFrequencyMatrix instantiateType(final FloatMatrixData fmd, final FrequencyUnit unit)
    {
        return new FloatFrequencyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFrequencyMatrix instantiateMutableType(final FloatMatrixData fmd, final FrequencyUnit unit)
    {
        return new MutableFloatFrequencyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFrequency instantiateScalar(final float value, final FrequencyUnit unit)
    {
        return new FloatFrequency(value, unit);
    }

}
