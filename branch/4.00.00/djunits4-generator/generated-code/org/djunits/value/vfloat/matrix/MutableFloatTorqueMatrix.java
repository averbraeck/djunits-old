package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatTorqueMatrix, a matrix of values with a TorqueUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatTorqueMatrix extends
    AbstractMutableFloatMatrixRel<TorqueUnit, FloatTorqueMatrix, MutableFloatTorqueMatrix, FloatTorque> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatTorqueMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatTorqueMatrix
     * @param unit TorqueUnit; the unit of the new Relative Immutable FloatTorqueMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTorqueMatrix(final float[][] values, final TorqueUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTorqueMatrix.
     * @param values FloatTorque[][]; the values of the entries in the new Relative Immutable Float
     *            FloatTorqueMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTorqueMatrix(final FloatTorque[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    MutableFloatTorqueMatrix(final FloatMatrixData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTorqueMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTorqueMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTorqueMatrix instantiateType(final FloatMatrixData fmd, final TorqueUnit unit)
    {
        return new FloatTorqueMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTorqueMatrix instantiateMutableType(final FloatMatrixData fmd, final TorqueUnit unit)
    {
        return new MutableFloatTorqueMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTorque instantiateScalar(final float value, final TorqueUnit unit)
    {
        return new FloatTorque(value, unit);
    }
    


}
