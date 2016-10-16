package org.djunits.value.vfloat.matrix;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAbsoluteTemperature;

/**
 * Mutable FloatAbsoluteTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAbsoluteTemperatureMatrix extends
        AbstractMutableFloatMatrixAbs<TemperatureUnit, FloatAbsoluteTemperatureMatrix, FloatTemperatureMatrix, MutableFloatAbsoluteTemperatureMatrix, FloatAbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureMatrix
     * @param unit U; the unit of the new Absolute Mutable FloatAbsoluteTemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureMatrix(final float[][] values, final TemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable
     *            FloatAbsoluteTemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureMatrix(final FloatAbsoluteTemperature[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAbsoluteTemperatureMatrix(final FloatMatrixData data, final TemperatureUnit unit)
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
    protected final FloatAbsoluteTemperatureMatrix instantiateTypeAbs(final FloatMatrixData fmd, final TemperatureUnit unit)
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
            final TemperatureUnit unit)
    {
        return new MutableFloatAbsoluteTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperature instantiateScalar(final float value, final TemperatureUnit unit)
    {
        return new FloatAbsoluteTemperature(value, unit);
    }

    /**
     * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute FloatAbsoluteTemperature matrix.
     */
    public final MutableFloatTemperatureMatrix toRel()
    {
        return new MutableFloatTemperatureMatrix(getData(), getUnit());
    }

}
