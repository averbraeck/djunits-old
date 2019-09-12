package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.EquivalentDoseUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.EquivalentDose;

/**
 * Immutable Double EquivalentDoseMatrix, a matrix of values with a EquivalentDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class EquivalentDoseMatrix
        extends AbstractDoubleMatrixRel<EquivalentDoseUnit, EquivalentDoseMatrix, MutableEquivalentDoseMatrix, EquivalentDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EquivalentDoseMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double EquivalentDoseMatrix
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable Double EquivalentDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public EquivalentDoseMatrix(final double[][] values, final EquivalentDoseUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseMatrix.
     * @param values EquivalentDose[][]; the values of the entries in the new Relative Immutable Double EquivalentDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public EquivalentDoseMatrix(final EquivalentDose[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit EquivalentDoseUnit; the unit
     */
    EquivalentDoseMatrix(final DoubleMatrixData data, final EquivalentDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final EquivalentDoseMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final EquivalentDoseMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final EquivalentDoseMatrix instantiateType(final DoubleMatrixData dmd, final EquivalentDoseUnit unit)
    {
        return new EquivalentDoseMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableEquivalentDoseMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final EquivalentDoseUnit unit)
    {
        return new MutableEquivalentDoseMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final EquivalentDose instantiateScalar(final double value, final EquivalentDoseUnit unit)
    {
        return new EquivalentDose(value, unit);
    }

}
