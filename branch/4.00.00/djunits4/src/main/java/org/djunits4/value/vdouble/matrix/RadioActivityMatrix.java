package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.RadioActivity;
import org.djunits4.value.vdouble.vector.RadioActivityVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double RadioActivityMatrix, a matrix of values with a RadioActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class RadioActivityMatrix
        extends AbstractDoubleMatrixRel<RadioActivityUnit, RadioActivity, RadioActivityVector, RadioActivityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    public RadioActivityMatrix(final DoubleMatrixData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<RadioActivity> getScalarClass()
    {
        return RadioActivity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<RadioActivityVector> getVectorClass()
    {
        return RadioActivityVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public RadioActivityMatrix instantiateMatrix(final DoubleMatrixData dmd, final RadioActivityUnit displayUnit)
    {
        return new RadioActivityMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public RadioActivityVector instantiateVector(final DoubleVectorData dvd, final RadioActivityUnit displayUnit)
    {
        return new RadioActivityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public RadioActivity instantiateScalar(final double value, final RadioActivityUnit unit)
    {
        return new RadioActivity(value, unit);
    }

}
