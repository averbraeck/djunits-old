package org.djunits.value.vfloat.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLength;

/**
 * Immutable FloatLength Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatLengthMatrix extends
        TypedFloatMatrixRel<LengthUnit, FloatLengthMatrix, MutableFloatLengthMatrix, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatLengthMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLengthMatrix
     * @param unit U; the unit of the new Relative Immutable FloatLengthMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLengthMatrix(final float[][] values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable FloatLengthMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLengthMatrix(final FloatLength[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatLengthMatrix(final FloatMatrixData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthMatrix instantiateType(final FloatMatrixData fmd, final LengthUnit unit)
    {
        return new FloatLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLengthMatrix instantiateMutableType(final FloatMatrixData fmd, final LengthUnit unit)
    {
        return new MutableFloatLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLength get(final int row, final int column) throws ValueException
    {
        return new FloatLength(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative FloatLength matrix.
     */
    public final FloatPositionMatrix toAbs()
    {
        return new FloatPositionMatrix(getData(), getUnit());
    }

}
