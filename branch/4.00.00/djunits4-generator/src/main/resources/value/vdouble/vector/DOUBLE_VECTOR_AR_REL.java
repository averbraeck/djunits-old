package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.*;
import org.djunits4.value.vdouble.vector.*;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRelWithAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double %TypeRel%Vector, a vector of values with a %TypeRelUnit%. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeRel%Vector extends AbstractDoubleVectorRelWithAbs<%TypeAbsUnit%, %TypeAbs%, %TypeAbs%Vector, 
        %TypeRelUnit%, %TypeRel%, %TypeRel%Vector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an %TypeRel%Vector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public %TypeRel%Vector(final DoubleVectorData data, final %TypeRelUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<%TypeRel%> getScalarClass()
    {
        return %TypeRel%.class;
    }
            
    %FORMULAS%%TypeRel%%
}
