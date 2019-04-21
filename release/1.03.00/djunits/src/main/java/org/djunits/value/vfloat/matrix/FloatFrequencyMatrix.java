package org.djunits.value.vfloat.matrix;

import org.djunits.unit.FrequencyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatFrequency;

/**
 * Immutable FloatFrequencyMatrix, a matrix of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatFrequencyMatrix extends
        TypedFloatMatrixRel<FrequencyUnit, FloatFrequencyMatrix, MutableFloatFrequencyMatrix, FloatFrequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatFrequencyMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatFrequencyMatrix
     * @param unit U; the unit of the new Relative Immutable FloatFrequencyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFrequencyMatrix(final float[][] values, final FrequencyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFrequencyMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatFrequencyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFrequencyMatrix(final FloatFrequency[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatFrequencyMatrix(final FloatMatrixData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFrequencyMatrix instantiateType(final FloatMatrixData fmd, final FrequencyUnit unit)
    {
        return new FloatFrequencyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFrequencyMatrix instantiateMutableType(final FloatMatrixData fmd, final FrequencyUnit unit)
    {
        return new MutableFloatFrequencyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency get(final int row, final int column) throws ValueException
    {
        return new FloatFrequency(getInUnit(row, column, getUnit()), getUnit());
    }

}