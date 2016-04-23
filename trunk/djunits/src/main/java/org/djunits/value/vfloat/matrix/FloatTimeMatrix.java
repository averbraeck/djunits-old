package org.djunits.value.vfloat.matrix;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTime;

/**
 * Immutable FloatTime Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatTimeMatrix extends
        TypedFloatMatrixAbs<TimeUnit, FloatTimeMatrix, FloatDurationMatrix, MutableFloatTimeMatrix, FloatTime>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatTimeMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatTimeMatrix
     * @param unit U; the unit of the new Absolute Immutable FloatTimeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTimeMatrix(final float[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable FloatTimeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTimeMatrix(final FloatTime[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatTimeMatrix(final FloatMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTimeMatrix instantiateTypeAbs(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new FloatTimeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationMatrix instantiateTypeRel(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new FloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTimeMatrix instantiateMutableType(final FloatMatrixData fmd, final TimeUnit unit)
    {
        return new MutableFloatTimeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTime get(final int row, final int column) throws ValueException
    {
        return new FloatTime(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute FloatTime matrix.
     */
    public final FloatDurationMatrix toRel()
    {
        return new FloatDurationMatrix(getData(), getUnit());
    }

}
