package org.djunits.value.vfloat.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPosition;

/**
 * Immutable FloatPosition Matrix.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPositionMatrix extends AbstractFloatMatrixAbs<PositionUnit, LengthUnit, FloatPositionMatrix,
        FloatLengthMatrix, MutableFloatPositionMatrix, FloatPosition>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatPositionMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatPositionMatrix
     * @param unit U; the unit of the new Absolute Immutable FloatPositionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPositionMatrix(final float[][] values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable FloatPositionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPositionMatrix(final FloatPosition[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatPositionMatrix(final FloatMatrixData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPositionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPositionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPositionMatrix instantiateTypeAbs(final FloatMatrixData fmd, final PositionUnit unit)
    {
        return new FloatPositionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthMatrix instantiateTypeRel(final FloatMatrixData fmd, final LengthUnit unit)
    {
        return new FloatLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPositionMatrix instantiateMutableType(final FloatMatrixData fmd, final PositionUnit unit)
    {
        return new MutableFloatPositionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPosition instantiateScalar(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }

}