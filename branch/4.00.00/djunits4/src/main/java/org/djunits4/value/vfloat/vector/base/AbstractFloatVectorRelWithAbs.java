package org.djunits4.value.vfloat.vector.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Relative;
import org.djunits4.value.base.Vector;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarAbs;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRelWithAbs;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * AbstractMutableFloatVectorRelWithAbs.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <AU> the absolute unit belonging to the relative unit
 * @param <A> the absolute scalar type belonging to the absolute vector type
 * @param <AV> the (immutable or mutable) absolute vector type
 * @param <RU> the relative unit belonging to the absolute unit
 * @param <R> the relative scalar type belonging to the relative vector type
 * @param <RV> the relative (immutable or mutable) vector type with this unit
 */
// @formatter:off
public abstract class AbstractFloatVectorRelWithAbs<
        AU  extends AbsoluteLinearUnit<AU, RU>, 
        A   extends AbstractFloatScalarAbs<AU, A, RU, R>,
        AV  extends AbstractFloatVectorAbs<AU, A, AV, RU, R, RV>,
        RU  extends Unit<RU>,
        R   extends AbstractFloatScalarRelWithAbs<AU, A, RU, R>,
        RV  extends AbstractFloatVectorRelWithAbs<AU, A, AV, RU, R, RV>>
        extends AbstractFloatVectorRel<RU, R, RV>
        implements Vector.RelWithAbs<AU, A, AV, RU, R, RV>, Relative
// @formatter:on
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param data FloatVectorData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractFloatVectorRelWithAbs(final FloatVectorData data, final RU unit)
    {
        // data will be copied in AbstractMutableFloatVectorRel
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public AV plus(AV increment)
    {
        return FloatVector.instantiate(this.getData().plus(increment.getData()), increment.getDisplayUnit().getStandardUnit());
    }

}
