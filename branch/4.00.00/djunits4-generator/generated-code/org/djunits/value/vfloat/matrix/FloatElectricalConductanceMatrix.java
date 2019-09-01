package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatElectricalConductanceMatrix, a matrix of values with a ElectricalConductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatElectricalConductanceMatrix extends
    AbstractFloatMatrixRel<ElectricalConductanceUnit, FloatElectricalConductanceMatrix, MutableFloatElectricalConductanceMatrix, FloatElectricalConductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalConductanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalConductanceMatrix
     * @param unit ElectricalConductanceUnit; the unit of the new Relative Immutable FloatElectricalConductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalConductanceMatrix(final float[][] values, final ElectricalConductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalConductanceMatrix.
     * @param values FloatElectricalConductance; the values of the entries in the new Relative Immutable FloatElectricalConductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalConductanceMatrix(final FloatElectricalConductance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalConductanceUnit; the unit
     */
    FloatElectricalConductanceMatrix(final FloatMatrixData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalConductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalConductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductanceMatrix instantiateType(final FloatMatrixData fmd, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalConductanceMatrix instantiateMutableType(final FloatMatrixData fmd, final ElectricalConductanceUnit unit)
    {
        return new MutableFloatElectricalConductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductance instantiateScalar(final float value, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductance(value, unit);
    }

    
}
