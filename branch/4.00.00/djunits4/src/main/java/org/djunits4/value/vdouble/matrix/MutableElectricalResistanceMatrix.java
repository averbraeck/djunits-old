package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.ElectricalResistance;

/**
 * Mutable Double ElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableElectricalResistanceMatrix extends AbstractMutableDoubleMatrixRel<ElectricalResistanceUnit,
        ElectricalResistanceMatrix, MutableElectricalResistanceMatrix, ElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalResistanceMatrix
     * @param unit ElectricalResistanceUnit; the unit of the new Relative Immutable Double ElectricalResistanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableElectricalResistanceMatrix(final double[][] values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double ElectricalResistanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableElectricalResistanceMatrix(final ElectricalResistance[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalResistanceUnit; the unit
     */
    MutableElectricalResistanceMatrix(final DoubleMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalResistanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalResistanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistanceMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalResistanceMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final ElectricalResistanceUnit unit)
    {
        return new MutableElectricalResistanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistance instantiateScalar(final double value, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistance(value, unit);
    }

}
