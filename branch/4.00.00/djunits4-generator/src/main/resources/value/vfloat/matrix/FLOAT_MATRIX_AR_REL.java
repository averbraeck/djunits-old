package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float%TypeRel% Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeRel%Matrix extends AbstractFloatMatrixRelWithAbs<%TypeAbsUnit%, Float%TypeAbs%, Float%TypeAbs%Vector, Float%TypeAbs%Matrix,
%TypeRelUnit%, Float%TypeRel%, Float%TypeRel%Vector, Float%TypeRel%Matrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;
    
    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit %TypeRel%Unit; the unit
     */
    public Float%TypeRel%Matrix(final FloatMatrixData data, final %TypeRel%Unit unit)
    {
        super(data, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public Class<Float%TypeRel%> getScalarClass()
    {
        return Float%TypeRel%.class;
    }
    
    /** {@inheritDoc} */
    @Override
    public Class<Float%TypeRel%Vector> getVectorClass()
    {
        return Float%TypeRel%Vector.class;
    }
        
%FORMULAS%%TypeRel%%
}
