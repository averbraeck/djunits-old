package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatPressureMatrix, a matrix of values with a PressureUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatPressureMatrix extends
    AbstractMutableFloatMatrixRel<PressureUnit, FloatPressureMatrix, MutableFloatPressureMatrix, FloatPressure> 
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
    public MutableFloatPressureMatrix(final float[][] values, final PressureUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureMatrix.
     * @param values FloatPressure[][]; the values of the entries in the new Relative Immutable Float
     *            FloatPressureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureMatrix(final FloatPressure[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit PressureUnit; the unit
     */
    MutableFloatPressureMatrix(final FloatMatrixData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPressureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPressureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
