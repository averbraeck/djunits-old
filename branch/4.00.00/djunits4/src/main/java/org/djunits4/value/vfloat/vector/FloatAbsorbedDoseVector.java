package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.value.vfloat.scalar.FloatAbsorbedDose;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatAbsorbedDoseVector, a vector of values with a AbsorbedDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatAbsorbedDoseVector
        extends AbstractFloatVectorRel<AbsorbedDoseUnit, FloatAbsorbedDose, FloatAbsorbedDoseVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatAbsorbedDoseVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit AbsorbedDoseUnit; the unit
     */
    public FloatAbsorbedDoseVector(final FloatVectorData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAbsorbedDose> getScalarClass()
    {
        return FloatAbsorbedDose.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsorbedDoseVector instantiateVector(final FloatVectorData fvd, final AbsorbedDoseUnit displayUnit)
    {
        return new FloatAbsorbedDoseVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsorbedDose instantiateScalar(final float value, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDose(value, unit);
    }

}
