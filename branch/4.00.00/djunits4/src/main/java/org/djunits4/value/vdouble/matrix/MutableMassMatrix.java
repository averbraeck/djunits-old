package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Mass;

/**
 * Mutable Double MassMatrix, a matrix of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableMassMatrix extends AbstractMutableDoubleMatrixRel<MassUnit, MassMatrix, MutableMassMatrix, Mass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MassMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MassMatrix
     * @param unit MassUnit; the unit of the new Relative Immutable Double MassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableMassMatrix(final double[][] values, final MassUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double MassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableMassMatrix(final Mass[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MassUnit; the unit
     */
    MutableMassMatrix(final DoubleMatrixData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MassMatrix instantiateType(final DoubleMatrixData dmd, final MassUnit unit)
    {
        return new MassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMassMatrix instantiateMutableType(final DoubleMatrixData dmd, final MassUnit unit)
    {
        return new MutableMassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mass instantiateScalar(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }

}
