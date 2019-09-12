package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRelWithAbs;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatLength;
import org.djunits4.value.vfloat.scalar.FloatPosition;
import org.djunits4.value.vfloat.vector.FloatLengthVector;
import org.djunits4.value.vfloat.vector.FloatPositionVector;

/**
 * Immutable FloatLength Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatLengthMatrix extends AbstractFloatMatrixRelWithAbs<PositionUnit, FloatPosition, FloatPositionVector,
        FloatPositionMatrix, LengthUnit, FloatLength, FloatLengthVector, FloatLengthMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LengthUnit; the unit
     */
    public FloatLengthMatrix(final FloatMatrixData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLength> getScalarClass()
    {
        return FloatLength.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLengthVector> getVectorClass()
    {
        return FloatLengthVector.class;
    }

}
