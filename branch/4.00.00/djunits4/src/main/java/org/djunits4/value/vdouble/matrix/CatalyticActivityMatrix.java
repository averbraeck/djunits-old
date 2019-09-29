package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.CatalyticActivity;
import org.djunits4.value.vdouble.vector.CatalyticActivityVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double CatalyticActivityMatrix, a matrix of values with a CatalyticActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class CatalyticActivityMatrix extends
        AbstractDoubleMatrixRel<CatalyticActivityUnit, CatalyticActivity, CatalyticActivityVector, CatalyticActivityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit CatalyticActivityUnit; the unit
     */
    public CatalyticActivityMatrix(final DoubleMatrixData data, final CatalyticActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<CatalyticActivity> getScalarClass()
    {
        return CatalyticActivity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<CatalyticActivityVector> getVectorClass()
    {
        return CatalyticActivityVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public CatalyticActivityMatrix instantiateMatrix(final DoubleMatrixData dmd, final CatalyticActivityUnit displayUnit)
    {
        return new CatalyticActivityMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public CatalyticActivityVector instantiateVector(final DoubleVectorData dvd, final CatalyticActivityUnit displayUnit)
    {
        return new CatalyticActivityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public CatalyticActivity instantiateScalar(final double value, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivity(value, unit);
    }

}
