package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatLinearDensityMatrix, a matrix of values with a LinearDensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatLinearDensityMatrix extends
    AbstractFloatMatrixRel<LinearDensityUnit, FloatLinearDensityMatrix, MutableFloatLinearDensityMatrix, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLinearDensityMatrix
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable FloatLinearDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLinearDensityMatrix(final float[][] values, final LinearDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values FloatLinearDensity; the values of the entries in the new Relative Immutable FloatLinearDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLinearDensityMatrix(final FloatLinearDensity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LinearDensityUnit; the unit
     */
    FloatLinearDensityMatrix(final FloatMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensityMatrix instantiateType(final FloatMatrixData fmd, final LinearDensityUnit unit)
    {
        return new FloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLinearDensityMatrix instantiateMutableType(final FloatMatrixData fmd, final LinearDensityUnit unit)
    {
        return new MutableFloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensity instantiateScalar(final float value, final LinearDensityUnit unit)
    {
        return new FloatLinearDensity(value, unit);
    }

    
}
