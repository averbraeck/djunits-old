package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatAngleSolidMatrix, a matrix of values with a AngleSolidUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatAngleSolidMatrix extends
    AbstractFloatMatrixRel<AngleSolidUnit, FloatAngleSolidMatrix, MutableFloatAngleSolidMatrix, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAngleSolidMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAngleSolidMatrix
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable FloatAngleSolidMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidMatrix(final float[][] values, final AngleSolidUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleSolidMatrix.
     * @param values FloatAngleSolid; the values of the entries in the new Relative Immutable FloatAngleSolidMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidMatrix(final FloatAngleSolid[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AngleSolidUnit; the unit
     */
    FloatAngleSolidMatrix(final FloatMatrixData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolidMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolidMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolidMatrix instantiateType(final FloatMatrixData fmd, final AngleSolidUnit unit)
    {
        return new FloatAngleSolidMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleSolidMatrix instantiateMutableType(final FloatMatrixData fmd, final AngleSolidUnit unit)
    {
        return new MutableFloatAngleSolidMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolid instantiateScalar(final float value, final AngleSolidUnit unit)
    {
        return new FloatAngleSolid(value, unit);
    }

    
}
