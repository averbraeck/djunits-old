package org.djunits.value.vdouble.matrix;

import org.djunits.unit.FrequencyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Frequency;

/**
 * Immutable Double FrequencyMatrix, a matrix of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FrequencyMatrix extends TypedDoubleMatrixRel<FrequencyUnit, FrequencyMatrix, MutableFrequencyMatrix, Frequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FrequencyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double FrequencyMatrix
     * @param unit U; the unit of the new Relative Immutable Double FrequencyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FrequencyMatrix(final double[][] values, final FrequencyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            FrequencyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FrequencyMatrix(final Frequency[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FrequencyMatrix(final DoubleMatrixData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FrequencyMatrix instantiateType(final DoubleMatrixData dmd, final FrequencyUnit unit)
    {
        return new FrequencyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFrequencyMatrix instantiateMutableType(final DoubleMatrixData dmd, final FrequencyUnit unit)
    {
        return new MutableFrequencyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency get(final int row, final int column) throws ValueException
    {
        return new Frequency(getInUnit(row, column, getUnit()), getUnit());
    }

}
