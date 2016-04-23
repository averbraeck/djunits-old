package org.djunits.value.vfloat.matrix;

import org.djunits.unit.PressureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPressure;

/**
 * Mutable FloatPressureMatrix, a matrix of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatPressureMatrix extends
        MutableTypedFloatMatrixRel<PressureUnit, FloatPressureMatrix, MutableFloatPressureMatrix, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatPressureMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatPressureMatrix
     * @param unit U; the unit of the new Relative Immutable FloatPressureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureMatrix(final float[][] values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatPressureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureMatrix(final FloatPressure[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatPressureMatrix(final FloatMatrixData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressureMatrix instantiateType(final FloatMatrixData fmd, final PressureUnit unit)
    {
        return new FloatPressureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPressureMatrix instantiateMutableType(final FloatMatrixData fmd, final PressureUnit unit)
    {
        return new MutableFloatPressureMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure get(final int row, final int column) throws ValueException
    {
        return new FloatPressure(getInUnit(row, column, getUnit()), getUnit());
    }

}
