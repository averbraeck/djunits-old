package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDirection;

/**
 * Immutable FloatDirection Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDirectionMatrix extends
        TypedFloatMatrixAbs<AngleUnit, FloatDirectionMatrix, FloatAngleMatrix, MutableFloatDirectionMatrix, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatDirectionMatrix
     * @param unit U; the unit of the new Absolute Immutable FloatDirectionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDirectionMatrix(final float[][] values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable FloatDirectionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDirectionMatrix(final FloatDirection[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatDirectionMatrix(final FloatMatrixData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirectionMatrix instantiateTypeAbs(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new FloatDirectionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleMatrix instantiateTypeRel(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new FloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDirectionMatrix instantiateMutableType(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new MutableFloatDirectionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDirection get(final int row, final int column) throws ValueException
    {
        return new FloatDirection(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute FloatDirection matrix.
     */
    public final FloatAngleMatrix toRel()
    {
        return new FloatAngleMatrix(getData(), getUnit());
    }

}
