package org.djunits.value.vdouble.matrix;

import org.djunits.unit.PressureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Pressure;

/**
 * Immutable Double PressureMatrix, a matrix of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class PressureMatrix extends AbstractDoubleMatrixRel<PressureUnit, PressureMatrix, MutablePressureMatrix, Pressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double PressureMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double PressureMatrix
     * @param unit PressureUnit; the unit of the new Relative Immutable Double PressureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PressureMatrix(final double[][] values, final PressureUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PressureMatrix.
     * @param values Pressure[][]; the values of the entries in the new Relative Immutable Double PressureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PressureMatrix(final Pressure[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit PressureUnit; the unit
     */
    PressureMatrix(final DoubleMatrixData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final PressureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final PressureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final PressureMatrix instantiateType(final DoubleMatrixData dmd, final PressureUnit unit)
    {
        return new PressureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePressureMatrix instantiateMutableType(final DoubleMatrixData dmd, final PressureUnit unit)
    {
        return new MutablePressureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Pressure instantiateScalar(final double value, final PressureUnit unit)
    {
        return new Pressure(value, unit);
    }

}
