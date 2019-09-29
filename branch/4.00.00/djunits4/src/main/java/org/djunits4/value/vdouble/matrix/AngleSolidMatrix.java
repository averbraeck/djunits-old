package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.AngleSolid;
import org.djunits4.value.vdouble.vector.AngleSolidVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double AngleSolidMatrix, a matrix of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class AngleSolidMatrix extends AbstractDoubleMatrixRel<AngleSolidUnit, AngleSolid, AngleSolidVector, AngleSolidMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AngleSolidUnit; the unit
     */
    public AngleSolidMatrix(final DoubleMatrixData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<AngleSolid> getScalarClass()
    {
        return AngleSolid.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<AngleSolidVector> getVectorClass()
    {
        return AngleSolidVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public AngleSolidMatrix instantiateMatrix(final DoubleMatrixData dmd, final AngleSolidUnit displayUnit)
    {
        return new AngleSolidMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AngleSolidVector instantiateVector(final DoubleVectorData dvd, final AngleSolidUnit displayUnit)
    {
        return new AngleSolidVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AngleSolid instantiateScalar(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

}
