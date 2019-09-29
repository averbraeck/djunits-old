package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.Position;
import org.djunits4.value.vdouble.vector.LengthVector;
import org.djunits4.value.vdouble.vector.PositionVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Position Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class PositionMatrix extends AbstractDoubleMatrixAbs<PositionUnit, Position, PositionVector, PositionMatrix, LengthUnit,
        Length, LengthVector, LengthMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit PositionUnit; the unit
     */
    public PositionMatrix(final DoubleMatrixData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Position> getScalarClass()
    {
        return Position.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<PositionVector> getVectorClass()
    {
        return PositionVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public PositionMatrix instantiateMatrix(final DoubleMatrixData dmd, final PositionUnit displayUnit)
    {
        return new PositionMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public PositionVector instantiateVector(final DoubleVectorData dvd, final PositionUnit displayUnit)
    {
        return new PositionVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Position instantiateScalar(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public LengthMatrix instantiateMatrixRel(final DoubleMatrixData dmd, final LengthUnit displayUnit)
    {
        return new LengthMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LengthVector instantiateVectorRel(final DoubleVectorData dvd, final LengthUnit displayUnit)
    {
        return new LengthVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Length instantiateScalarRel(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }

}
