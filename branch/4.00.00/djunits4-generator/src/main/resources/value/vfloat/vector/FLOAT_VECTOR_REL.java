package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.vfloat.function.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.*;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;
import org.djunits4.value.vfloat.vector.base.*;

/**
 * Immutable Float Float%Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%Type%Vector extends AbstractFloatVectorRel<%Type%Unit, Float%Type%, Float%Type%Vector>
%DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an Float%Type%Vector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public Float%Type%Vector(final FloatVectorData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Float%Type%> getScalarClass()
    {
        return Float%Type%.class;
    }
        
    /** {@inheritDoc} */
    @Override
    public Float%Type%Vector instantiateVector(final FloatVectorData fvd, final %Type%Unit displayUnit)
    {
        return new Float%Type%Vector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%Type% instantiateScalarSI(final float valueSI, final %Type%Unit displayUnit)
    {
        Float%Type% result = Float%Type%.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    %FORMULAS%%Type%%
}

