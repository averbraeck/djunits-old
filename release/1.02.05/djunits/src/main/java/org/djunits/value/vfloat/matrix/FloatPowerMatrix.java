package org.djunits.value.vfloat.matrix;

import org.djunits.unit.PowerUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPower;

/**
 * Immutable FloatPowerMatrix, a matrix of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPowerMatrix extends
    TypedFloatMatrixRel<PowerUnit, FloatPowerMatrix, MutableFloatPowerMatrix, FloatPower>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatPowerMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatPowerMatrix
     * @param unit U; the unit of the new Relative Immutable FloatPowerMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerMatrix(final float[][] values, final PowerUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPowerMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatPowerMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerMatrix(final FloatPower[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatPowerMatrix(final FloatMatrixData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPowerMatrix instantiateType(final FloatMatrixData fmd, final PowerUnit unit)
    {
        return new FloatPowerMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPowerMatrix instantiateMutableType(final FloatMatrixData fmd, final PowerUnit unit)
    {
        return new MutableFloatPowerMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPower get(final int row, final int column) throws ValueException
    {
        return new FloatPower(getInUnit(row, column, getUnit()), getUnit());
    }

}
