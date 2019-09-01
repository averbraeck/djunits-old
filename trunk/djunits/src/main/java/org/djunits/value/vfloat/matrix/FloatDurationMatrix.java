package org.djunits.value.vfloat.matrix;

import org.djunits.unit.DurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDuration;

/**
 * Immutable FloatDuration Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatDurationMatrix
        extends AbstractFloatMatrixRel<DurationUnit, FloatDurationMatrix, MutableFloatDurationMatrix, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatDurationMatrix
     * @param unit DurationUnit; the unit of the new Relative Immutable FloatDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationMatrix(final float[][] values, final DurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param values FloatDuration[][]; the values of the entries in the new Relative Immutable FloatDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationMatrix(final FloatDuration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit DurationUnit; the unit
     */
    FloatDurationMatrix(final FloatMatrixData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationMatrix instantiateType(final FloatMatrixData fmd, final DurationUnit unit)
    {
        return new FloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDurationMatrix instantiateMutableType(final FloatMatrixData fmd, final DurationUnit unit)
    {
        return new MutableFloatDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDuration instantiateScalar(final float value, final DurationUnit unit)
    {
        return new FloatDuration(value, unit);
    }

}
