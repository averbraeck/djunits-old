package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.vfloat.scalar.*;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;
import org.djunits4.value.vfloat.vector.base.*;

/**
 * Absolute Float%TypeAbs% Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeAbs%Vector extends AbstractFloatVectorAbs<%TypeAbsUnit%, Float%TypeAbs%, Float%TypeAbs%Vector,
    %TypeRelUnit%, Float%TypeRel%, Float%TypeRel%Vector>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absative Immutable Float%TypeAbs%Vector.
     * @param data FloatVectorData; an internal data object
     * @param unit %TypeAbsUnit%; the unit
     */
    public Float%TypeAbs%Vector(final FloatVectorData data, final %TypeAbsUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Float%TypeAbs%>

    getScalarClass()
    {
        return Float%TypeAbs%.class;
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeAbs%Vector instantiateVector(final FloatVectorData fvd, final %TypeAbsUnit% displayUnit)
    {
        return new Float%TypeAbs%Vector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeAbs% instantiateScalar(final float value, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeRel%Vector instantiateVectorRel(final FloatVectorData fvd, final %TypeRelUnit% displayUnit)
    {
        return new Float%TypeRel%Vector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeRel% instantiateScalarRel(final float value, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }

    %FORMULAS%%TypeAbs%%
}
