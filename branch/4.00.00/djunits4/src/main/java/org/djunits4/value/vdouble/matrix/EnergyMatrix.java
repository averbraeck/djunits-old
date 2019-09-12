package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.EnergyUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Energy;

/**
 * Immutable Double EnergyMatrix, a matrix of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class EnergyMatrix extends AbstractDoubleMatrixRel<EnergyUnit, EnergyMatrix, MutableEnergyMatrix, Energy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EnergyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double EnergyMatrix
     * @param unit EnergyUnit; the unit of the new Relative Immutable Double EnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public EnergyMatrix(final double[][] values, final EnergyUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyMatrix.
     * @param values Energy[][]; the values of the entries in the new Relative Immutable Double EnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public EnergyMatrix(final Energy[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    EnergyMatrix(final DoubleMatrixData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final EnergyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final EnergyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final EnergyMatrix instantiateType(final DoubleMatrixData dmd, final EnergyUnit unit)
    {
        return new EnergyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableEnergyMatrix instantiateMutableType(final DoubleMatrixData dmd, final EnergyUnit unit)
    {
        return new MutableEnergyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Energy instantiateScalar(final double value, final EnergyUnit unit)
    {
        return new Energy(value, unit);
    }

}
