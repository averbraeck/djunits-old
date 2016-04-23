package org.djunits.value.vfloat.matrix;

import org.djunits.unit.LinearDensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLinearDensity;

/**
 * Immutable FloatLinearDensityMatrix, a matrix of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatLinearDensityMatrix extends
        TypedFloatMatrixRel<LinearDensityUnit, FloatLinearDensityMatrix, MutableFloatLinearDensityMatrix, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLinearDensityMatrix
     * @param unit U; the unit of the new Relative Immutable FloatLinearDensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLinearDensityMatrix(final float[][] values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatLinearDensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLinearDensityMatrix(final FloatLinearDensity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatLinearDensityMatrix(final FloatMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensityMatrix instantiateType(final FloatMatrixData fmd, final LinearDensityUnit unit)
    {
        return new FloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLinearDensityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final LinearDensityUnit unit)
    {
        return new MutableFloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity get(final int row, final int column) throws ValueException
    {
        return new FloatLinearDensity(getInUnit(row, column, getUnit()), getUnit());
    }

}