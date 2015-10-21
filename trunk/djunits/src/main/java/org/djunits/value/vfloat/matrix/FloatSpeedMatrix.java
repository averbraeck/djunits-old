package org.djunits.value.vfloat.matrix;

import org.djunits.unit.SpeedUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatSpeed;

/**
 * Immutable FloatSpeedMatrix, a matrix of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatSpeedMatrix extends
    TypedFloatMatrixRel<SpeedUnit, FloatSpeedMatrix, MutableFloatSpeedMatrix, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatSpeedMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatSpeedMatrix
     * @param unit U; the unit of the new Relative Immutable FloatSpeedMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatSpeedMatrix(final float[][] values, final SpeedUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatSpeedMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatSpeedMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatSpeedMatrix(final FloatSpeed[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatSpeedMatrix(final FloatMatrixData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeedMatrix instantiateType(final FloatMatrixData fmd, final SpeedUnit unit)
    {
        return new FloatSpeedMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatSpeedMatrix instantiateMutableType(final FloatMatrixData fmd, final SpeedUnit unit)
    {
        return new MutableFloatSpeedMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed get(final int row, final int column) throws ValueException
    {
        return new FloatSpeed(getInUnit(row, column, getUnit()), getUnit());
    }

}