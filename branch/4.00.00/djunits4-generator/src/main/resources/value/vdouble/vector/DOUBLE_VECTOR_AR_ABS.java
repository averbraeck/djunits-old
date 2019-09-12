package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.*;
import org.djunits4.value.vdouble.vector.*;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double %TypeAbs%Vector, a vector of values with a %TypeAbsUnit%. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeAbs%Vector extends AbstractDoubleVectorAbs<%TypeAbsUnit%, %TypeAbs%, %TypeAbs%Vector, 
        %TypeRelUnit%, %TypeRel%, %TypeRel%Vector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an %TypeAbs%Vector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public %TypeAbs%Vector(final DoubleVectorData data, final %TypeAbsUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<%TypeAbs%> getScalarClass()
    {
        return %TypeAbs%.class;
    }

    %FORMULAS%%TypeAbs%%
}
