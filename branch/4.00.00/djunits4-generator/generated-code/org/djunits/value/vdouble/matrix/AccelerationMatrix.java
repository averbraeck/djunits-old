package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double AccelerationMatrix, a matrix of values with a AccelerationUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class AccelerationMatrix extends
AbstractDoubleMatrixRel<AccelerationUnit, AccelerationMatrix, MutableAccelerationMatrix, Acceleration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AccelerationMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AccelerationMatrix
     * @param unit AccelerationUnit; the unit of the new Relative Immutable Double AccelerationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AccelerationMatrix(final double[][] values, final AccelerationUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationMatrix.
     * @param values Acceleration[][]; the values of the entries in the new Relative Immutable Double AccelerationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AccelerationMatrix(final Acceleration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AccelerationUnit; the unit
     */
    AccelerationMatrix(final DoubleMatrixData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AccelerationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AccelerationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AccelerationMatrix instantiateType(final DoubleMatrixData dmd, final AccelerationUnit unit)
    {
        return new AccelerationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAccelerationMatrix instantiateMutableType(final DoubleMatrixData dmd, final AccelerationUnit unit)
    {
        return new MutableAccelerationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Acceleration instantiateScalar(final double value, final AccelerationUnit unit)
    {
        return new Acceleration(value, unit);
    }


    
}
