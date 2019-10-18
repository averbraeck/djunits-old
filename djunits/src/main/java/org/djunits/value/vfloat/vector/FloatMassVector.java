package org.djunits.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits.unit.MassUnit;
import org.djunits.value.vfloat.scalar.FloatMass;
import org.djunits.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatMassVector, a vector of values with a MassUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-18T12:12:25.568Z")
public class FloatMassVector extends AbstractFloatVectorRel<MassUnit, FloatMass, FloatMassVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatMassVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit MassUnit; the unit
     */
    public FloatMassVector(final FloatVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatMass> getScalarClass()
    {
        return FloatMass.class;
    }
        
    /** {@inheritDoc} */
    @Override
    public FloatMassVector instantiateVector(final FloatVectorData fvd, final MassUnit displayUnit)
    {
        return new FloatMassVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatMass instantiateScalarSI(final float valueSI, final MassUnit displayUnit)
    {
        FloatMass result = FloatMass.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

   
}

