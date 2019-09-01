package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatDirection Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatDirectionMatrix extends
        AbstractFloatMatrixAbs<DirectionUnit, AngleUnit, FloatDirectionMatrix, FloatAngleMatrix, MutableFloatDirectionMatrix, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatDirectionMatrix
     * @param unit DirectionUnit; the unit of the new Absolute Immutable FloatDirectionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDirectionMatrix(final float[][] values, final DirectionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param values FloatDirection[][]; the values of the entries in the new Absolute Immutable FloatDirectionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDirectionMatrix(final FloatDirection[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit DirectionUnit; the unit
     */
    FloatDirectionMatrix(final FloatMatrixData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDirectionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDirectionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirectionMatrix instantiateTypeAbs(final FloatMatrixData fmd, final DirectionUnit unit)
    {
        return new FloatDirectionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleMatrix instantiateTypeRel(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new FloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDirectionMatrix
        instantiateMutableType(final FloatMatrixData fmd, final DirectionUnit unit)
    {
        return new MutableFloatDirectionMatrix(fmd, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    protected final FloatDirection instantiateScalar(final float value, final DirectionUnit unit)
    {
        return new FloatDirection(value, unit);
    }
    
}