package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatVolumeMatrix, a matrix of values with a VolumeUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatVolumeMatrix extends
    AbstractFloatMatrixRel<VolumeUnit, FloatVolumeMatrix, MutableFloatVolumeMatrix, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatVolumeMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatVolumeMatrix
     * @param unit VolumeUnit; the unit of the new Relative Immutable FloatVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatVolumeMatrix(final float[][] values, final VolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVolumeMatrix.
     * @param values FloatVolume; the values of the entries in the new Relative Immutable FloatVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatVolumeMatrix(final FloatVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit VolumeUnit; the unit
     */
    FloatVolumeMatrix(final FloatMatrixData data, final VolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatVolumeMatrix instantiateType(final FloatMatrixData fmd, final VolumeUnit unit)
    {
        return new FloatVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatVolumeMatrix instantiateMutableType(final FloatMatrixData fmd, final VolumeUnit unit)
    {
        return new MutableFloatVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatVolume instantiateScalar(final float value, final VolumeUnit unit)
    {
        return new FloatVolume(value, unit);
    }

    
}
