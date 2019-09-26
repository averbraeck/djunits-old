package org.djunits4.value.vdouble.matrix.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Matrix;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarAbs;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRelWithAbs;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRelWithAbs;

/**
 * AbstractMutableDoubleMatrixRelWithAbs.java.
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
public abstract class AbstractDoubleMatrixAbs<
        AU  extends AbsoluteLinearUnit<AU, RU>, 
        A   extends AbstractDoubleScalarAbs<AU, A, RU, R>,
        AV  extends AbstractDoubleVectorAbs<AU, A, AV, RU, R, RV>,
        AM  extends AbstractDoubleMatrixAbs<AU, A, AV, AM, RU, R, RV, RM>, 
        RU  extends Unit<RU>,
        R   extends AbstractDoubleScalarRelWithAbs<AU, A, RU, R>,
        RV  extends AbstractDoubleVectorRelWithAbs<AU, A, AV, RU, R, RV>,
        RM  extends AbstractDoubleMatrixRelWithAbs<AU, A, AV, AM, RU, R, RV, RM>>
        extends AbstractDoubleMatrix<AU, A, AV, AM>
        implements Matrix.Abs<AU, A, AV, AM, RU, R, RV, RM>, Absolute
// @formatter:on
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractDoubleMatrixAbs(final DoubleMatrixData data, final AU unit)
    {
        super(data.copy(), unit);
    }

    /** {@inheritDoc} */
    @Override
    public AM plus(RM increment) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().plus(increment.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public AM minus(RM decrement) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().minus(decrement.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public RM minus(AM decrement) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().minus(decrement.getData()), decrement.getUnit().getRelativeUnit());
    }

    /**
     * Decrement all values of this matrix by the decrement. This only works if this matrix is mutable.
     * @param decrement R; the scalar by which to decrement all values
     * @return AM; this modified vector
     * @throws ValueRuntimeException in case this vector is immutable
     */
    @SuppressWarnings("unchecked")
    public AM decrementBy(final R decrement)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.DEC(decrement.si));
        return (AM) this;
    }

    /**
     * Decrement all values of this matrix by the decrement on a value by value basis. This only works if this matrix is mutable.
     * @param decrement RV; the matrix that contains the values by which to decrement the corresponding values
     * @return AV; this modified matrix
     * @throws ValueRuntimeException in case this matrix is immutable
     * @Throws ValueException when the sizes of the matrices differ, or <code>decrement</code> is null
     */
    @SuppressWarnings("unchecked")
    public AM decrementBy(RM decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (AM) this;
    }

}
