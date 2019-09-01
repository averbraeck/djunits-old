package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatAngle Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatAngleMatrix extends AbstractFloatMatrixRel<AngleUnit, FloatAngleMatrix, MutableFloatAngleMatrix, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatAngleMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAngleMatrix
     * @param unit AngleUnit; the unit of the new Relative Immutable FloatAngleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleMatrix(final float[][] values, final AngleUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleMatrix.
     * @param values FloatAngle[][]; the values of the entries in the new Relative Immutable FloatAngleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleMatrix(final FloatAngle[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit AngleUnit; the unit
     */
    FloatAngleMatrix(final FloatMatrixData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleMatrix instantiateType(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new FloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleMatrix
        instantiateMutableType(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new MutableFloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngle instantiateScalar(final float value, final AngleUnit unit)
    {
        return new FloatAngle(value, unit);
    }
        
}