package org.djunits.value.vfloat.matrix;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTemperature;

/**
 * Immutable FloatTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatTemperatureMatrix extends
        TypedFloatMatrixRel<TemperatureUnit, FloatTemperatureMatrix, MutableFloatTemperatureMatrix, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatTemperatureMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatTemperatureMatrix
     * @param unit U; the unit of the new Relative Immutable FloatTemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTemperatureMatrix(final float[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable
     *            FloatTemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTemperatureMatrix(final FloatTemperature[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatTemperatureMatrix(final FloatMatrixData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureMatrix instantiateType(final FloatMatrixData fmd, final TemperatureUnit unit)
    {
        return new FloatTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTemperatureMatrix instantiateMutableType(final FloatMatrixData fmd, final TemperatureUnit unit)
    {
        return new MutableFloatTemperatureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTemperature get(final int row, final int column) throws ValueException
    {
        return new FloatTemperature(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative FloatTemperature matrix.
     */
    public final FloatAbsoluteTemperatureMatrix toAbs()
    {
        return new FloatAbsoluteTemperatureMatrix(getData(), getUnit());
    }

}
