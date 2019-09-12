package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Angle;
import org.djunits4.value.vdouble.scalar.Direction;
import org.djunits4.value.vdouble.vector.AngleVector;
import org.djunits4.value.vdouble.vector.DirectionVector;

/**
 * Immutable Direction Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T20:33:12.910Z")
public class DirectionMatrix extends AbstractDoubleMatrixAbs<DirectionUnit, Direction, DirectionVector, DirectionMatrix,
        AngleUnit, Angle, AngleVector, AngleMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DirectionUnit; the unit
     */
    public DirectionMatrix(final DoubleMatrixData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Direction> getScalarClass()
    {
        return Direction.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<DirectionVector> getVectorClass()
    {
        return DirectionVector.class;
    }

}
