package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Torque;

/**
 * Mutable Double TorqueMatrix, a matrix of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableTorqueMatrix extends AbstractMutableDoubleMatrixRel<TorqueUnit, TorqueMatrix, MutableTorqueMatrix, Torque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double TorqueMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double TorqueMatrix
     * @param unit TorqueUnit; the unit of the new Relative Immutable Double TorqueMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableTorqueMatrix(final double[][] values, final TorqueUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double TorqueMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableTorqueMatrix(final Torque[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    MutableTorqueMatrix(final DoubleMatrixData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final TorqueMatrix instantiateType(final DoubleMatrixData dmd, final TorqueUnit unit)
    {
        return new TorqueMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTorqueMatrix instantiateMutableType(final DoubleMatrixData dmd, final TorqueUnit unit)
    {
        return new MutableTorqueMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Torque instantiateScalar(final double value, final TorqueUnit unit)
    {
        return new Torque(value, unit);
    }

}
