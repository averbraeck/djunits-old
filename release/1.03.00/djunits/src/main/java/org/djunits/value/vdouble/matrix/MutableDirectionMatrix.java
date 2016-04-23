package org.djunits.value.vdouble.matrix;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Direction;

/**
 * Mutable Direction Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableDirectionMatrix extends
        MutableTypedDoubleMatrixAbs<AngleUnit, DirectionMatrix, AngleMatrix, MutableDirectionMatrix, Direction>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double DirectionMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Mutable Double DirectionMatrix
     * @param unit U; the unit of the new Absolute Mutable Double DirectionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDirectionMatrix(final double[][] values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable Double DirectionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDirectionMatrix(final Direction[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableDirectionMatrix(final DoubleMatrixData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DirectionMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final AngleUnit unit)
    {
        return new DirectionMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleMatrix instantiateTypeRel(final DoubleMatrixData dmd, final AngleUnit unit)
    {
        return new AngleMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDirectionMatrix instantiateMutableType(final DoubleMatrixData dmd, final AngleUnit unit)
    {
        return new MutableDirectionMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Direction get(final int row, final int column) throws ValueException
    {
        return new Direction(getInUnit(row, column, getUnit()), getUnit());
    }

    /**
     * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute Direction matrix.
     */
    public final MutableAngleMatrix toRel()
    {
        return new MutableAngleMatrix(getData(), getUnit());
    }

}