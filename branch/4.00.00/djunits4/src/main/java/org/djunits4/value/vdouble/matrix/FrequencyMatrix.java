package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FrequencyUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Frequency;
import org.djunits4.value.vdouble.vector.FrequencyVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double FrequencyMatrix, a matrix of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FrequencyMatrix extends AbstractDoubleMatrixRel<FrequencyUnit, Frequency, FrequencyVector, FrequencyMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    public FrequencyMatrix(final DoubleMatrixData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Frequency> getScalarClass()
    {
        return Frequency.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FrequencyVector> getVectorClass()
    {
        return FrequencyVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FrequencyMatrix instantiateMatrix(final DoubleMatrixData dmd, final FrequencyUnit displayUnit)
    {
        return new FrequencyMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FrequencyVector instantiateVector(final DoubleVectorData dvd, final FrequencyUnit displayUnit)
    {
        return new FrequencyVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Frequency instantiateScalar(final double value, final FrequencyUnit unit)
    {
        return new Frequency(value, unit);
    }

}
