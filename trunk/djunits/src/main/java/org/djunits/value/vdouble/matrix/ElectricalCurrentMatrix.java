package org.djunits.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.value.vdouble.scalar.ElectricalCurrent;
import org.djunits.value.vdouble.vector.ElectricalCurrentVector;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double ElectricalCurrentMatrix, a matrix of values with a ElectricalCurrentUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-18T12:12:25.568Z")
public class ElectricalCurrentMatrix extends AbstractDoubleMatrixRel<ElectricalCurrentUnit, ElectricalCurrent, ElectricalCurrentVector, ElectricalCurrentMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalCurrentUnit; the unit
     */
    public ElectricalCurrentMatrix(final DoubleMatrixData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalCurrent> getScalarClass()
    {
        return ElectricalCurrent.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalCurrentVector> getVectorClass()
    {
        return ElectricalCurrentVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalCurrentMatrix instantiateMatrix(final DoubleMatrixData dmd, final ElectricalCurrentUnit displayUnit)
    {
        return new ElectricalCurrentMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalCurrentVector instantiateVector(final DoubleVectorData dvd, final ElectricalCurrentUnit displayUnit)
    {
        return new ElectricalCurrentVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalCurrent instantiateScalarSI(final double valueSI, final ElectricalCurrentUnit displayUnit)
    {
        ElectricalCurrent result = ElectricalCurrent.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }
    
}
