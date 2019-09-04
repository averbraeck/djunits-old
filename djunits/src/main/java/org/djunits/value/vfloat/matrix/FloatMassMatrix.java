package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMass;

/**
 * Immutable FloatMassMatrix, a matrix of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMassMatrix extends AbstractFloatMatrixRel<MassUnit, FloatMassMatrix, MutableFloatMassMatrix, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMassMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMassMatrix
     * @param unit MassUnit; the unit of the new Relative Immutable FloatMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMassMatrix(final float[][] values, final MassUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMassMatrix.
     * @param values FloatMass[][]; the values of the entries in the new Relative Immutable Float FloatMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMassMatrix(final FloatMass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MassUnit; the unit
     */
    FloatMassMatrix(final FloatMatrixData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMassMatrix instantiateType(final FloatMatrixData fmd, final MassUnit unit)
    {
        return new FloatMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMassMatrix instantiateMutableType(final FloatMatrixData fmd, final MassUnit unit)
    {
        return new MutableFloatMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMass instantiateScalar(final float value, final MassUnit unit)
    {
        return new FloatMass(value, unit);
    }

}
