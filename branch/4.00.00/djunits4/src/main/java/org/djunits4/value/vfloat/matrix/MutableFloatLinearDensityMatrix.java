package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatLinearDensity;

/**
 * Mutable FloatLinearDensityMatrix, a matrix of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatLinearDensityMatrix extends AbstractMutableFloatMatrixRel<LinearDensityUnit, FloatLinearDensityMatrix,
        MutableFloatLinearDensityMatrix, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLinearDensityMatrix
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable FloatLinearDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityMatrix(final float[][] values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values FloatLinearDensity[][]; the values of the entries in the new Relative Immutable Float
     *            FloatLinearDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityMatrix(final FloatLinearDensity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LinearDensityUnit; the unit
     */
    MutableFloatLinearDensityMatrix(final FloatMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLinearDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLinearDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensityMatrix instantiateType(final FloatMatrixData fmd, final LinearDensityUnit unit)
    {
        return new FloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLinearDensityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final LinearDensityUnit unit)
    {
        return new MutableFloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensity instantiateScalar(final float value, final LinearDensityUnit unit)
    {
        return new FloatLinearDensity(value, unit);
    }

}
