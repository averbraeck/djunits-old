package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatEnergyMatrix, a matrix of values with a EnergyUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatEnergyMatrix extends
    AbstractFloatMatrixRel<EnergyUnit, FloatEnergyMatrix, MutableFloatEnergyMatrix, FloatEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatEnergyMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatEnergyMatrix
     * @param unit EnergyUnit; the unit of the new Relative Immutable FloatEnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEnergyMatrix(final float[][] values, final EnergyUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatEnergyMatrix.
     * @param values FloatEnergy; the values of the entries in the new Relative Immutable FloatEnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEnergyMatrix(final FloatEnergy[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    FloatEnergyMatrix(final FloatMatrixData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEnergyMatrix instantiateType(final FloatMatrixData fmd, final EnergyUnit unit)
    {
        return new FloatEnergyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatEnergyMatrix instantiateMutableType(final FloatMatrixData fmd, final EnergyUnit unit)
    {
        return new MutableFloatEnergyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEnergy instantiateScalar(final float value, final EnergyUnit unit)
    {
        return new FloatEnergy(value, unit);
    }

    
}
