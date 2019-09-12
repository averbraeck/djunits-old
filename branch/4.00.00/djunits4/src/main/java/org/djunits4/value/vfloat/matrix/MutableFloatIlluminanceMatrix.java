package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.IlluminanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatIlluminance;

/**
 * Mutable FloatIlluminanceMatrix, a matrix of values with a IlluminanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatIlluminanceMatrix extends
        AbstractMutableFloatMatrixRel<IlluminanceUnit, FloatIlluminanceMatrix, MutableFloatIlluminanceMatrix, FloatIlluminance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatIlluminanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatIlluminanceMatrix
     * @param unit IlluminanceUnit; the unit of the new Relative Immutable FloatIlluminanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatIlluminanceMatrix(final float[][] values, final IlluminanceUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatIlluminanceMatrix.
     * @param values FloatIlluminance[][]; the values of the entries in the new Relative Immutable Float FloatIlluminanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatIlluminanceMatrix(final FloatIlluminance[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit IlluminanceUnit; the unit
     */
    MutableFloatIlluminanceMatrix(final FloatMatrixData data, final IlluminanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatIlluminanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatIlluminanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatIlluminanceMatrix instantiateType(final FloatMatrixData fmd, final IlluminanceUnit unit)
    {
        return new FloatIlluminanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatIlluminanceMatrix instantiateMutableType(final FloatMatrixData fmd, final IlluminanceUnit unit)
    {
        return new MutableFloatIlluminanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatIlluminance instantiateScalar(final float value, final IlluminanceUnit unit)
    {
        return new FloatIlluminance(value, unit);
    }

}
