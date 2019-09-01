package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.EnergyUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Energy;

/**
 * Mutable Double EnergyMatrix, a matrix of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableEnergyMatrix extends AbstractMutableDoubleMatrixRel<EnergyUnit, EnergyMatrix, MutableEnergyMatrix, Energy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EnergyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double EnergyMatrix
     * @param unit EnergyUnit; the unit of the new Relative Immutable Double EnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableEnergyMatrix(final double[][] values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double EnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableEnergyMatrix(final Energy[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    MutableEnergyMatrix(final DoubleMatrixData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
