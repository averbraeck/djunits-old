package org.djunits.value.vdouble.matrix;

import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.ElectricalCurrent;

/**
 * Mutable Double ElectricalCurrentMatrix, a matrix of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableElectricalCurrentMatrix extends AbstractMutableDoubleMatrixRel<ElectricalCurrentUnit,
        ElectricalCurrentMatrix, MutableElectricalCurrentMatrix, ElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalCurrentMatrix
     * @param unit ElectricalCurrentUnit; the unit of the new Relative Immutable Double ElectricalCurrentMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalCurrentMatrix(final double[][] values, final ElectricalCurrentUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentMatrix.
     * @param values ElectricalCurrent[][]; the values of the entries in the new Relative Immutable Double
     *            ElectricalCurrentMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalCurrentMatrix(final ElectricalCurrent[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalCurrentUnit; the unit
     */
    MutableElectricalCurrentMatrix(final DoubleMatrixData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrentMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrentMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalCurrentMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final ElectricalCurrentUnit unit)
    {
        return new MutableElectricalCurrentMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrent instantiateScalar(final double value, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrent(value, unit);
    }

}
