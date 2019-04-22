package org.djunits.value.vfloat.matrix;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDuration;

/**
 * Immutable FloatDuration Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDurationMatrix extends
        TypedFloatMatrixRel<TimeUnit, FloatDurationMatrix, MutableFloatDurationMatrix, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatDurationMatrix
     * @param unit U; the unit of the new Relative Immutable FloatDurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationMatrix(final float[][] values, final TimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable FloatDurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationMatrix(final FloatDuration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatDurationMatrix(final FloatMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationMatrix instantiateType(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new FloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDurationMatrix instantiateMutableType(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new MutableFloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDuration get(final int row, final int column) throws ValueException
    {
        return new FloatDuration(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative FloatDuration matrix.
     */
    public final FloatTimeMatrix toAbs()
    {
        return new FloatTimeMatrix(getData(), getUnit());
    }

}