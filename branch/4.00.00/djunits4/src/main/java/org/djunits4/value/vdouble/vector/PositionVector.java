package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.Position;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double PositionVector, a vector of values with a PositionUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class PositionVector
        extends AbstractDoubleVectorAbs<PositionUnit, Position, PositionVector, LengthUnit, Length, LengthVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an PositionVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param unit PositionUnit; the display unit of the vector data
     */
    public PositionVector(final DoubleVectorData data, final PositionUnit unit)
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
