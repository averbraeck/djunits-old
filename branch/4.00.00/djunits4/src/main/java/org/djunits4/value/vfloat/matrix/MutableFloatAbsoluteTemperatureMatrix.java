package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatAbsoluteTemperature;

/**
 * Mutable FloatAbsoluteTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatAbsoluteTemperatureMatrix
        extends AbstractMutableFloatMatrixAbs<AbsoluteTemperatureUnit, TemperatureUnit, FloatAbsoluteTemperatureMatrix,
                FloatTemperatureMatrix, MutableFloatAbsoluteTemperatureMatrix, FloatAbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureMatrix
     * @param unit AbsoluteTemperatureUnit; the unit of the new Absolute Mutable FloatAbsoluteTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureMatrix(final float[][] values, final AbsoluteTemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureMatrix.
     * @param values FloatAbsoluteTemperature[][]; the values of the entries in the new Absolute Mutable
     *            FloatAbsoluteTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureMatrix(final FloatAbsoluteTemperature[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit AbsoluteTemperatureUnit; the unit
     */
    MutableFloatAbsoluteTemperatureMatrix(final FloatMatrixData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsoluteTemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsoluteTemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperatureMatrix instantiateTypeAbs(final FloatMatrixData fmd,
            final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureMatrix instantiateTypeRel(final FloatMatrixData fmd, final TemperatureUnit unit)
    {
        return new FloatTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAbsoluteTemperatureMatrix instantiateMutableType(final FloatMatrixData fmd,
            final AbsoluteTemperatureUnit unit)
    {
        return new MutableFloatAbsoluteTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperature instantiateScalar(final float value, final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperature(value, unit);
    }

}