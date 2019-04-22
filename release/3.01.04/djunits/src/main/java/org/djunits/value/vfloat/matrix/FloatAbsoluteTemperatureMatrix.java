package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAbsoluteTemperature;

/**
 * Immutable FloatAbsoluteTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAbsoluteTemperatureMatrix extends AbstractFloatMatrixAbs<AbsoluteTemperatureUnit, TemperatureUnit,
        FloatAbsoluteTemperatureMatrix, FloatTemperatureMatrix, MutableFloatAbsoluteTemperatureMatrix, FloatAbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatAbsoluteTemperatureMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatAbsoluteTemperatureMatrix
     * @param unit AbsoluteTemperatureUnit; the unit of the new Absolute Immutable FloatAbsoluteTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAbsoluteTemperatureMatrix(final float[][] values, final AbsoluteTemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatAbsoluteTemperatureMatrix.
     * @param values FloatAbsoluteTemperature[][]; the values of the entries in the new Absolute Immutable
     *            FloatAbsoluteTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAbsoluteTemperatureMatrix(final FloatAbsoluteTemperature[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatAbsoluteTemperatureMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit AbsoluteTemperatureUnit; the unit
     */
    FloatAbsoluteTemperatureMatrix(final FloatMatrixData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsoluteTemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsoluteTemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
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
