package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatSpeed;

/**
 * Mutable FloatSpeedMatrix, a matrix of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatSpeedMatrix
        extends AbstractMutableFloatMatrixRel<SpeedUnit, FloatSpeedMatrix, MutableFloatSpeedMatrix, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatSpeedMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatSpeedMatrix
     * @param unit SpeedUnit; the unit of the new Relative Immutable FloatSpeedMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatSpeedMatrix(final float[][] values, final SpeedUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatSpeedMatrix.
     * @param values FloatSpeed[][]; the values of the entries in the new Relative Immutable Float FloatSpeedMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatSpeedMatrix(final FloatSpeed[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit SpeedUnit; the unit
     */
    MutableFloatSpeedMatrix(final FloatMatrixData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatSpeedMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatSpeedMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeedMatrix instantiateType(final FloatMatrixData fmd, final SpeedUnit unit)
    {
        return new FloatSpeedMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatSpeedMatrix instantiateMutableType(final FloatMatrixData fmd, final SpeedUnit unit)
    {
        return new MutableFloatSpeedMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeed instantiateScalar(final float value, final SpeedUnit unit)
    {
        return new FloatSpeed(value, unit);
    }

}