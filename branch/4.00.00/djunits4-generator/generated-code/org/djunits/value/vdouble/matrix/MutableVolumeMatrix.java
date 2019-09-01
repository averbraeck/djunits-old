package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double VolumeMatrix, a matrix of values with a VolumeUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableVolumeMatrix extends
    AbstractMutableDoubleMatrixRel<VolumeUnit, VolumeMatrix, MutableVolumeMatrix, Volume> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double VolumeMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double VolumeMatrix
     * @param unit VolumeUnit; the unit of the new Relative Immutable Double VolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableVolumeMatrix(final double[][] values, final VolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double VolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableVolumeMatrix(final Volume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit VolumeUnit; the unit
     */
    MutableVolumeMatrix(final DoubleMatrixData data, final VolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final VolumeMatrix instantiateType(final DoubleMatrixData dmd, final VolumeUnit unit)
    {
        return new VolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableVolumeMatrix instantiateMutableType(final DoubleMatrixData dmd, final VolumeUnit unit)
    {
        return new MutableVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Volume instantiateScalar(final double value, final VolumeUnit unit)
    {
        return new Volume(value, unit);
    }
    


}
