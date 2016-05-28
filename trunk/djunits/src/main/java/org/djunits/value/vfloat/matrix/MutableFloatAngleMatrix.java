package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngle;

/**
 * Mutable FloatAngle Matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAngleMatrix extends
        MutableTypedFloatMatrixRel<AngleUnit, FloatAngleMatrix, MutableFloatAngleMatrix, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatAngleMatrix.
     * @param values float[][]; the values of the entries in the new Relative Mutable FloatAngleMatrix
     * @param unit U; the unit of the new Relative Mutable FloatAngleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleMatrix(final float[][] values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable FloatAngleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleMatrix(final FloatAngle[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAngleMatrix(final FloatMatrixData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleMatrix instantiateType(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new FloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleMatrix instantiateMutableType(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new MutableFloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngle get(final int row, final int column) throws ValueException
    {
        return new FloatAngle(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative FloatAngle matrix.
     */
    public final MutableFloatDirectionMatrix toAbs()
    {
        return new MutableFloatDirectionMatrix(getData(), getUnit());
    }

}
