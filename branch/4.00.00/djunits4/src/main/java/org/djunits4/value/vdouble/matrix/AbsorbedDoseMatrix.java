package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.AbsorbedDose;
import org.djunits4.value.vdouble.vector.AbsorbedDoseVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double AbsorbedDoseMatrix, a matrix of values with a AbsorbedDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class AbsorbedDoseMatrix
        extends AbstractDoubleMatrixRel<AbsorbedDoseUnit, AbsorbedDose, AbsorbedDoseVector, AbsorbedDoseMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AbsorbedDoseUnit; the unit
     */
    public AbsorbedDoseMatrix(final DoubleMatrixData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<AbsorbedDose> getScalarClass()
    {
        return AbsorbedDose.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<AbsorbedDoseVector> getVectorClass()
    {
        return AbsorbedDoseVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public AbsorbedDoseMatrix instantiateMatrix(final DoubleMatrixData dmd, final AbsorbedDoseUnit displayUnit)
    {
        return new AbsorbedDoseMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AbsorbedDoseVector instantiateVector(final DoubleVectorData dvd, final AbsorbedDoseUnit displayUnit)
    {
        return new AbsorbedDoseVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AbsorbedDose instantiateScalarSI(final double valueSI, final AbsorbedDoseUnit displayUnit)
    {
        AbsorbedDose result = AbsorbedDose.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
