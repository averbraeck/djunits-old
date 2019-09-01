package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.ElectricalCurrent;

/**
 * Immutable Double ElectricalCurrentMatrix, a matrix of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class ElectricalCurrentMatrix extends AbstractDoubleMatrixRel<ElectricalCurrentUnit, ElectricalCurrentMatrix,
        MutableElectricalCurrentMatrix, ElectricalCurrent>
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
    public ElectricalCurrentMatrix(final double[][] values, final ElectricalCurrentUnit unit, final StorageType storageType)
            throws ValueException
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
    public ElectricalCurrentMatrix(final ElectricalCurrent[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalCurrentUnit; the unit
     */
    ElectricalCurrentMatrix(final DoubleMatrixData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrentMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrentMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
