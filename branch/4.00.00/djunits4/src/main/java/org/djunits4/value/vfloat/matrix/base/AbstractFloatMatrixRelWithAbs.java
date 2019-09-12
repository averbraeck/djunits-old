package org.djunits4.value.vfloat.matrix.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Relative;
import org.djunits4.value.base.Matrix;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarAbs;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRelWithAbs;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorAbs;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRelWithAbs;

/**
 * AbstractMutableFloatMatrixRelWithAbs.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <AU> the absolute unit belonging to the relative unit
 * @param <A> the absolute scalar type belonging to the absolute matrix type
 * @param <AV> the absolute vector type belonging to the absolute matrix type
 * @param <AM> the (immutable or mutable) absolute matrix type
 * @param <RU> the relative unit belonging to the absolute unit
 * @param <R> the relative scalar type belonging to the relative matrix type
 * @param <RV> the relative vector type belonging to the relative matrix type
 * @param <RM> the relative (immutable or mutable) matrix type with this unit
 */
// @formatter:off
public abstract class AbstractFloatMatrixRelWithAbs<
        AU  extends AbsoluteLinearUnit<AU, RU>, 
        A   extends AbstractFloatScalarAbs<AU, A, RU, R>,
        AV  extends AbstractFloatVectorAbs<AU, A, AV, RU, R, RV>,
        AM  extends AbstractFloatMatrixAbs<AU, A, AV, AM, RU, R, RV, RM>, 
        RU  extends Unit<RU>,
        R   extends AbstractFloatScalarRelWithAbs<AU, A, RU, R>,
        RV  extends AbstractFloatVectorRelWithAbs<AU, A, AV, RU, R, RV>,
        RM  extends AbstractFloatMatrixRelWithAbs<AU, A, AV, AM, RU, R, RV, RM>>
        extends AbstractFloatMatrixRel<RU, R, RV, RM>
        implements Matrix.RelWithAbs<AU, A, AV, AM, RU, R, RV, RM>, Relative
// @formatter:on
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractFloatMatrixRelWithAbs(final FloatMatrixData data, final RU unit)
    {
        // data will be copied in AbstractMutableFloatMatrixRel
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public AM plus(AM increment)
    {
        return FloatMatrix.instantiate(this.getData().plus(increment.getData()), increment.getUnit().getStandardUnit());
    }

}
