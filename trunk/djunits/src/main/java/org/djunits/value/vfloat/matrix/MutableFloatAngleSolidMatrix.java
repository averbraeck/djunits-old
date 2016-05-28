package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngleSolid;

/**
 * Mutable FloatAngleSolidMatrix, a matrix of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAngleSolidMatrix extends
        MutableTypedFloatMatrixRel<AngleSolidUnit, FloatAngleSolidMatrix, MutableFloatAngleSolidMatrix, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAngleSolidMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAngleSolidMatrix
     * @param unit U; the unit of the new Relative Immutable FloatAngleSolidMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleSolidMatrix(final float[][] values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleSolidMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatAngleSolidMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleSolidMatrix(final FloatAngleSolid[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAngleSolidMatrix(final FloatMatrixData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolidMatrix instantiateType(final FloatMatrixData fmd, final AngleSolidUnit unit)
    {
        return new FloatAngleSolidMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleSolidMatrix instantiateMutableType(final FloatMatrixData fmd, final AngleSolidUnit unit)
    {
        return new MutableFloatAngleSolidMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid get(final int row, final int column) throws ValueException
    {
        return new FloatAngleSolid(getInUnit(row, column, getUnit()), getUnit());
    }

}
