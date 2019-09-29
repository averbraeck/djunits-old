package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DensityUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Density;
import org.djunits4.value.vdouble.vector.DensityVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double DensityMatrix, a matrix of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class DensityMatrix extends AbstractDoubleMatrixRel<DensityUnit, Density, DensityVector, DensityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DensityUnit; the unit
     */
    public DensityMatrix(final DoubleMatrixData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Density> getScalarClass()
    {
        return Density.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<DensityVector> getVectorClass()
    {
        return DensityVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public DensityMatrix instantiateMatrix(final DoubleMatrixData dmd, final DensityUnit displayUnit)
    {
        return new DensityMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public DensityVector instantiateVector(final DoubleVectorData dvd, final DensityUnit displayUnit)
    {
        return new DensityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Density instantiateScalar(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
    }

}
