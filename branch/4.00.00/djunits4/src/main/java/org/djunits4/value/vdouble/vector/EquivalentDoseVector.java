package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.EquivalentDoseUnit;
import org.djunits4.value.vdouble.scalar.EquivalentDose;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double EquivalentDoseVector, a vector of values with a EquivalentDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class EquivalentDoseVector extends AbstractDoubleVectorRel<EquivalentDoseUnit, EquivalentDose, EquivalentDoseVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an EquivalentDoseVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit EquivalentDoseUnit; the unit
     */
    public EquivalentDoseVector(final DoubleVectorData data, final EquivalentDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<EquivalentDose> getScalarClass()
    {
        return EquivalentDose.class;
    }

}
