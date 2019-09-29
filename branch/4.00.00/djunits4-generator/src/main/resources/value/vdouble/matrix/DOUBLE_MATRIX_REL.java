package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.vector.*;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double %Type%Matrix, a matrix of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %Type%Matrix extends AbstractDoubleMatrixRel<%Type%Unit, %Type%, %Type%Vector, %Type%Matrix>
%DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public %Type%Matrix(final DoubleMatrixData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<%Type%> getScalarClass()
    {
        return %Type%.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<%Type%Vector> getVectorClass()
    {
        return %Type%Vector.class;
    }

    /** {@inheritDoc} */
    @Override
    public %Type%Matrix instantiateMatrix(final DoubleMatrixData dmd, final %Type%Unit displayUnit)
    {
        return new %Type%Matrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public %Type%Vector instantiateVector(final DoubleVectorData dvd, final %Type%Unit displayUnit)
    {
        return new %Type%Vector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public %Type% instantiateScalar(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }
    
%FORMULAS%%Type%%
}

