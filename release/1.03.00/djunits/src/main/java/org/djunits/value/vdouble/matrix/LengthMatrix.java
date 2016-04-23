package org.djunits.value.vdouble.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Length;

/**
 * Immutable Length Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class LengthMatrix extends TypedDoubleMatrixRel<LengthUnit, LengthMatrix, MutableLengthMatrix, Length>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double LengthMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double LengthMatrix
     * @param unit U; the unit of the new Relative Immutable Double LengthMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LengthMatrix(final double[][] values, final LengthUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LengthMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double LengthMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LengthMatrix(final Length[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LengthMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    LengthMatrix(final DoubleMatrixData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LengthMatrix instantiateType(final DoubleMatrixData dmd, final LengthUnit unit)
    {
        return new LengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLengthMatrix instantiateMutableType(final DoubleMatrixData dmd, final LengthUnit unit)
    {
        return new MutableLengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Length get(final int row, final int column) throws ValueException
    {
        return new Length(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative Length matrix.
     */
    public final PositionMatrix toAbs()
    {
        return new PositionMatrix(getData(), getUnit());
    }

}
