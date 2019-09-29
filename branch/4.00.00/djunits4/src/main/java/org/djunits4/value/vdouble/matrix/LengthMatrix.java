package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRelWithAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.Position;
import org.djunits4.value.vdouble.vector.LengthVector;
import org.djunits4.value.vdouble.vector.PositionVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Length Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class LengthMatrix extends AbstractDoubleMatrixRelWithAbs<PositionUnit, Position, PositionVector, PositionMatrix,
        LengthUnit, Length, LengthVector, LengthMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit LengthUnit; the unit
     */
    public LengthMatrix(final DoubleMatrixData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Length> getScalarClass()
    {
        return Length.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<LengthVector> getVectorClass()
    {
        return LengthVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public LengthMatrix instantiateMatrix(final DoubleMatrixData dmd, final LengthUnit displayUnit)
    {
        return new LengthMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LengthVector instantiateVector(final DoubleVectorData dvd, final LengthUnit displayUnit)
    {
        return new LengthVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Length instantiateScalar(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public PositionMatrix instantiateMatrixAbs(final DoubleMatrixData dmd, final PositionUnit displayUnit)
    {
        return new PositionMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public PositionVector instantiateVectorAbs(final DoubleVectorData dvd, final PositionUnit displayUnit)
    {
        return new PositionVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Position instantiateScalarAbs(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

}
