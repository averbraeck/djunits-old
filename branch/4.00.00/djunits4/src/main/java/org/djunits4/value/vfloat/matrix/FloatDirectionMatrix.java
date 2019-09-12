package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatDirection;

/**
 * Immutable FloatDirection Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatDirectionMatrix extends AbstractFloatMatrixAbs<DirectionUnit, AngleUnit, FloatDirectionMatrix,
        FloatAngleMatrix, MutableFloatDirectionMatrix, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatDirectionMatrix
     * @param unit DirectionUnit; the unit of the new Absolute Immutable FloatDirectionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatDirectionMatrix(final float[][] values, final DirectionUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param values FloatDirection[][]; the values of the entries in the new Absolute Immutable FloatDirectionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatDirectionMatrix(final FloatDirection[][] values, final StorageType storageType) throws ValueRuntimeException
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
    protected final MutableFloatDirectionMatrix instantiateMutableType(final FloatMatrixData fmd, final DirectionUnit unit)
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
