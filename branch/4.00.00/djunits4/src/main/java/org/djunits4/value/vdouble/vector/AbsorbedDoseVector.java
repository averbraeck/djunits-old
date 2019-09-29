package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.value.vdouble.scalar.AbsorbedDose;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AbsorbedDoseVector, a vector of values with a AbsorbedDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class AbsorbedDoseVector extends AbstractDoubleVectorRel<AbsorbedDoseUnit, AbsorbedDose, AbsorbedDoseVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AbsorbedDoseVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit AbsorbedDoseUnit; the display unit of the vector data
     */
    public AbsorbedDoseVector(final DoubleVectorData data, final AbsorbedDoseUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<AbsorbedDose> getScalarClass()
    {
        return AbsorbedDose.class;
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
