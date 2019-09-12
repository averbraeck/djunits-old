package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AccelerationUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Acceleration;

/**
 * Mutable Double AccelerationMatrix, a matrix of values with a AccelerationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableAccelerationMatrix
        extends AbstractMutableDoubleMatrixRel<AccelerationUnit, AccelerationMatrix, MutableAccelerationMatrix, Acceleration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AccelerationMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AccelerationMatrix
     * @param unit AccelerationUnit; the unit of the new Relative Immutable Double AccelerationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableAccelerationMatrix(final double[][] values, final AccelerationUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double AccelerationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableAccelerationMatrix(final Acceleration[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AccelerationUnit; the unit
     */
    MutableAccelerationMatrix(final DoubleMatrixData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
