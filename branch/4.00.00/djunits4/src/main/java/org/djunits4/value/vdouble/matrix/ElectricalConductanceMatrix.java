package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.ElectricalConductanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.ElectricalConductance;

/**
 * Immutable Double ElectricalConductanceMatrix, a matrix of values with a ElectricalConductanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class ElectricalConductanceMatrix extends AbstractDoubleMatrixRel<ElectricalConductanceUnit, ElectricalConductanceMatrix,
        MutableElectricalConductanceMatrix, ElectricalConductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalConductanceMatrix
     * @param unit ElectricalConductanceUnit; the unit of the new Relative Immutable Double ElectricalConductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalConductanceMatrix(final double[][] values, final ElectricalConductanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceMatrix.
     * @param values ElectricalConductance[][]; the values of the entries in the new Relative Immutable Double
     *            ElectricalConductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalConductanceMatrix(final ElectricalConductance[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalConductanceUnit; the unit
     */
    ElectricalConductanceMatrix(final DoubleMatrixData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalConductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalConductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalConductanceMatrix instantiateType(final DoubleMatrixData dmd,
            final ElectricalConductanceUnit unit)
    {
        return new ElectricalConductanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalConductanceMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final ElectricalConductanceUnit unit)
    {
        return new MutableElectricalConductanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalConductance instantiateScalar(final double value, final ElectricalConductanceUnit unit)
    {
        return new ElectricalConductance(value, unit);
    }

}
