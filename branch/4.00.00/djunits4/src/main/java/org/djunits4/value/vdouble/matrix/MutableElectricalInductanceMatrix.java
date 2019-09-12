package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalInductanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.ElectricalInductance;

/**
 * Mutable Double ElectricalInductanceMatrix, a matrix of values with a ElectricalInductanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableElectricalInductanceMatrix extends AbstractMutableDoubleMatrixRel<ElectricalInductanceUnit,
        ElectricalInductanceMatrix, MutableElectricalInductanceMatrix, ElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalInductanceMatrix
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Double ElectricalInductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableElectricalInductanceMatrix(final double[][] values, final ElectricalInductanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double ElectricalInductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableElectricalInductanceMatrix(final ElectricalInductance[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalInductanceUnit; the unit
     */
    MutableElectricalInductanceMatrix(final DoubleMatrixData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalInductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalInductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalInductanceMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalInductanceMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final ElectricalInductanceUnit unit)
    {
        return new MutableElectricalInductanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalInductance instantiateScalar(final double value, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductance(value, unit);
    }

}
