package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatPosition Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatPositionMatrix
        extends
        AbstractMutableFloatMatrixAbs<PositionUnit, LengthUnit, FloatPositionMatrix, FloatLengthMatrix, MutableFloatPositionMatrix, FloatPosition>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatPositionMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Mutable FloatPositionMatrix
     * @param unit PositionUnit; the unit of the new Absolute Mutable FloatPositionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPositionMatrix(final float[][] values, final PositionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionMatrix.
     * @param values FloatPosition[][]; the values of the entries in the new Absolute Mutable FloatPositionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPositionMatrix(final FloatPosition[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit PositionUnit; the unit
     */
    MutableFloatPositionMatrix(final FloatMatrixData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPositionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPositionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPositionMatrix instantiateTypeAbs(final FloatMatrixData fmd, final PositionUnit unit)
    {
        return new FloatPositionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthMatrix instantiateTypeRel(final FloatMatrixData fmd, final LengthUnit unit)
    {
        return new FloatLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPositionMatrix
        instantiateMutableType(final FloatMatrixData fmd, final PositionUnit unit)
    {
        return new MutableFloatPositionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPosition instantiateScalar(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }
        
}