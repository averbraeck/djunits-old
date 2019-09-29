package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.value.vdouble.scalar.AmountOfSubstance;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AmountOfSubstanceVector, a vector of values with a AmountOfSubstanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class AmountOfSubstanceVector
        extends AbstractDoubleVectorRel<AmountOfSubstanceUnit, AmountOfSubstance, AmountOfSubstanceVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AmountOfSubstanceVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit AmountOfSubstanceUnit; the display unit of the vector data
     */
    public AmountOfSubstanceVector(final DoubleVectorData data, final AmountOfSubstanceUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<AmountOfSubstance> getScalarClass()
    {
        return AmountOfSubstance.class;
    }

    /** {@inheritDoc} */
    @Override
    public AmountOfSubstanceVector instantiateVector(final DoubleVectorData dvd, final AmountOfSubstanceUnit displayUnit)
    {
        return new AmountOfSubstanceVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AmountOfSubstance instantiateScalar(final double value, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstance(value, unit);
    }

}
