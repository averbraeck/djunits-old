package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.PressureUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatPressure;

/**
 * Immutable FloatPressureMatrix, a matrix of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatPressureMatrix
        extends AbstractFloatMatrixRel<PressureUnit, FloatPressureMatrix, MutableFloatPressureMatrix, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatPressureMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatPressureMatrix
     * @param unit PressureUnit; the unit of the new Relative Immutable FloatPressureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPressureMatrix(final float[][] values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureMatrix.
     * @param values FloatPressure; the values of the entries in the new Relative Immutable FloatPressureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPressureMatrix(final FloatPressure[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit PressureUnit; the unit
     */
    FloatPressureMatrix(final FloatMatrixData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressureMatrix instantiateType(final FloatMatrixData fmd, final PressureUnit unit)
    {
        return new FloatPressureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPressureMatrix instantiateMutableType(final FloatMatrixData fmd, final PressureUnit unit)
    {
        return new MutableFloatPressureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressure instantiateScalar(final float value, final PressureUnit unit)
    {
        return new FloatPressure(value, unit);
    }

}