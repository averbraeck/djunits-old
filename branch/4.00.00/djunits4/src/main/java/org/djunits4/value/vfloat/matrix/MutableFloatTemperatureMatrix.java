package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatTemperature;

/**
 * Mutable FloatTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatTemperatureMatrix extends
        AbstractMutableFloatMatrixRel<TemperatureUnit, FloatTemperatureMatrix, MutableFloatTemperatureMatrix, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatTemperatureMatrix.
     * @param values float[][]; the values of the entries in the new Relative Mutable FloatTemperatureMatrix
     * @param unit TemperatureUnit; the unit of the new Relative Mutable FloatTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatTemperatureMatrix(final float[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureMatrix.
     * @param values FloatTemperature[][]; the values of the entries in the new Relative Mutable FloatTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatTemperatureMatrix(final FloatTemperature[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit TemperatureUnit; the unit
     */
    MutableFloatTemperatureMatrix(final FloatMatrixData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureMatrix instantiateType(final FloatMatrixData fmd, final TemperatureUnit unit)
    {
        return new FloatTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTemperatureMatrix instantiateMutableType(final FloatMatrixData fmd, final TemperatureUnit unit)
    {
        return new MutableFloatTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperature instantiateScalar(final float value, final TemperatureUnit unit)
    {
        return new FloatTemperature(value, unit);
    }

}
