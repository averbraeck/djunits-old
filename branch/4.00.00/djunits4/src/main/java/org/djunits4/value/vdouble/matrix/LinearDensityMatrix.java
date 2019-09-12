package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.LinearDensity;
import org.djunits4.value.vdouble.vector.LinearDensityVector;

/**
 * Immutable Double LinearDensityMatrix, a matrix of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T20:33:12.910Z")
public class LinearDensityMatrix
        extends AbstractDoubleMatrixRel<LinearDensityUnit, LinearDensity, LinearDensityVector, LinearDensityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit LinearDensityUnit; the unit
     */
    public LinearDensityMatrix(final DoubleMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<LinearDensity> getScalarClass()
    {
        return LinearDensity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<LinearDensityVector> getVectorClass()
    {
        return LinearDensityVector.class;
    }

}
