package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRelWithAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Angle;
import org.djunits4.value.vdouble.scalar.Direction;
import org.djunits4.value.vdouble.vector.AngleVector;
import org.djunits4.value.vdouble.vector.DirectionVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Angle Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class AngleMatrix extends AbstractDoubleMatrixRelWithAbs<DirectionUnit, Direction, DirectionVector, DirectionMatrix,
        AngleUnit, Angle, AngleVector, AngleMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AngleUnit; the unit
     */
    public AngleMatrix(final DoubleMatrixData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Angle> getScalarClass()
    {
        return Angle.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<AngleVector> getVectorClass()
    {
        return AngleVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public AngleMatrix instantiateMatrix(final DoubleMatrixData dmd, final AngleUnit displayUnit)
    {
        return new AngleMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AngleVector instantiateVector(final DoubleVectorData dvd, final AngleUnit displayUnit)
    {
        return new AngleVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Angle instantiateScalarSI(final double valueSI, final AngleUnit displayUnit)
    {
        Angle result = Angle.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public DirectionMatrix instantiateMatrixAbs(final DoubleMatrixData dmd, final DirectionUnit displayUnit)
    {
        return new DirectionMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public DirectionVector instantiateVectorAbs(final DoubleVectorData dvd, final DirectionUnit displayUnit)
    {
        return new DirectionVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Direction instantiateScalarAbsSI(final double valueSI, final DirectionUnit displayUnit)
    {
        Direction result = Direction.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
