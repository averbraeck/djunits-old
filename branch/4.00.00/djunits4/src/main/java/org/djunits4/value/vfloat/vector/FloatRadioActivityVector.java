package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.value.vfloat.scalar.FloatRadioActivity;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatRadioActivityVector, a vector of values with a RadioActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatRadioActivityVector
        extends AbstractFloatVectorRel<RadioActivityUnit, FloatRadioActivity, FloatRadioActivityVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatRadioActivityVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    public FloatRadioActivityVector(final FloatVectorData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatRadioActivity> getScalarClass()
    {
        return FloatRadioActivity.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatRadioActivityVector instantiateVector(final FloatVectorData fvd, final RadioActivityUnit displayUnit)
    {
        return new FloatRadioActivityVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatRadioActivity instantiateScalar(final float value, final RadioActivityUnit unit)
    {
        return new FloatRadioActivity(value, unit);
    }

}
