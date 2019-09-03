package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatElectricalInductanceMatrix, a matrix of values with a ElectricalInductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalInductanceMatrix extends
    AbstractFloatMatrixRel<ElectricalInductanceUnit, FloatElectricalInductanceMatrix, MutableFloatElectricalInductanceMatrix, FloatElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalInductanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalInductanceMatrix
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable FloatElectricalInductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalInductanceMatrix(final float[][] values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalInductanceMatrix.
     * @param values FloatElectricalInductance; the values of the entries in the new Relative Immutable FloatElectricalInductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalInductanceMatrix(final FloatElectricalInductance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalInductanceUnit; the unit
     */
    FloatElectricalInductanceMatrix(final FloatMatrixData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalInductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalInductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductanceMatrix instantiateType(final FloatMatrixData fmd, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalInductanceMatrix instantiateMutableType(final FloatMatrixData fmd, final ElectricalInductanceUnit unit)
    {
        return new MutableFloatElectricalInductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductance instantiateScalar(final float value, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductance(value, unit);
    }

    
}
