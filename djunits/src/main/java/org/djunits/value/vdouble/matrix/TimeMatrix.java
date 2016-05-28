package org.djunits.value.vdouble.matrix;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Time;

/**
 * Immutable Time Matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class TimeMatrix extends TypedDoubleMatrixAbs<TimeUnit, TimeMatrix, DurationMatrix, MutableTimeMatrix, Time>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double DurationMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable Double DurationMatrix
     * @param unit U; the unit of the new Absolute Immutable Double DurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeMatrix(final double[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DurationMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
     *            DurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeMatrix(final Time[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DurationMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    TimeMatrix(final DoubleMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TimeMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final TimeUnit unit)
    {
        return new TimeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DurationMatrix instantiateTypeRel(final DoubleMatrixData dmd, final TimeUnit unit)
    {
        return new DurationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTimeMatrix instantiateMutableType(final DoubleMatrixData dmd, final TimeUnit unit)
    {
        return new MutableTimeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Time get(final int row, final int column) throws ValueException
    {
        return new Time(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute Duration matrix.
     */
    public final DurationMatrix toRel()
    {
        return new DurationMatrix(getData(), getUnit());
    }

}
