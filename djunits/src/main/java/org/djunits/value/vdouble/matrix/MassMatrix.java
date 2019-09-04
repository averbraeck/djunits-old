package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Mass;

/**
 * Immutable Double MassMatrix, a matrix of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MassMatrix extends AbstractDoubleMatrixRel<MassUnit, MassMatrix, MutableMassMatrix, Mass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MassMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MassMatrix
     * @param unit MassUnit; the unit of the new Relative Immutable Double MassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MassMatrix(final double[][] values, final MassUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassMatrix.
     * @param values Mass[][]; the values of the entries in the new Relative Immutable Double MassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MassMatrix(final Mass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MassUnit; the unit
     */
    MassMatrix(final DoubleMatrixData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
