package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatDensityMatrix, a matrix of values with a DensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatDensityMatrix extends
    AbstractMutableFloatMatrixRel<DensityUnit, FloatDensityMatrix, MutableFloatDensityMatrix, FloatDensity> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatDensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatDensityMatrix
     * @param unit DensityUnit; the unit of the new Relative Immutable FloatDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityMatrix(final float[][] values, final DensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDensityMatrix.
     * @param values FloatDensity[][]; the values of the entries in the new Relative Immutable Float
     *            FloatDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityMatrix(final FloatDensity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit DensityUnit; the unit
     */
    MutableFloatDensityMatrix(final FloatMatrixData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDensityMatrix instantiateType(final FloatMatrixData fmd, final DensityUnit unit)
    {
        return new FloatDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDensityMatrix instantiateMutableType(final FloatMatrixData fmd, final DensityUnit unit)
    {
        return new MutableFloatDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDensity instantiateScalar(final float value, final DensityUnit unit)
    {
        return new FloatDensity(value, unit);
    }
    


}
