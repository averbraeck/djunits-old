package org.djunits4.value.vdouble.matrix.base;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Matrix;
import org.djunits4.value.vdouble.matrix.SIMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;

/**
 * AbstractMutableDoubleMatrixRel.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit
 * @param <S> the scalar type belonging to the matrix type
 * @param <RV> the relative vector type belonging to the relative matrix type
 * @param <RM> the relative matrix type with this unit
 */
public abstract class AbstractDoubleMatrixRel<U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>,
        RV extends AbstractDoubleVectorRel<U, S, RV>,
        RM extends AbstractDoubleMatrixRel<U, S, RV, RM>> extends AbstractDoubleMatrix<U, S, RV, RM>
        implements Matrix.Rel<U, S, RV, RM>, Relative
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractDoubleMatrixRel(final DoubleMatrixData data, final U unit)
    {
        super(data.copy(), unit);
    }

    /** {@inheritDoc} */
    @Override
    public final RM plus(final RM rel) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final RM minus(final RM rel) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public RM multiplyBy(final double multiplier)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(multiplier);
        return (RM) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public RM divideBy(final double divisor)
    {
        checkCopyOnWrite();
        this.data.divideBy(divisor);
        return (RM) this;
    }

    /**
     * Multiply a Relative value with this Relative value for a matrix or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise
     * the result is a sparse matrix or matrix.
     * @param rel VT; the right operand, which can be any matrix type
     * @return SIMatrix; the multiplication of this matrix and the operand
     * @throws ValueRuntimeException in case this matrix or matrix and the operand have a different size
     * @throws UnitException on unit error
     */
    public final <VT extends AbstractDoubleMatrix<?, ?, ?, ?> & Relative> SIMatrix times(final VT rel)
            throws ValueRuntimeException, UnitException
    {
        checkSize(rel);
        return new SIMatrix(this.getData().times(rel.getData()),
                SIUnit.of(getUnit().getUnitBase().getSiDimensions().plus(rel.getUnit().getUnitBase().getSiDimensions())));
    }

    /**
     * Divide this Relative value by a Relative value for a matrix or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise the result
     * is a sparse matrix or matrix.
     * @param rel VT; the right operand, which can be any matrix type
     * @return SIMatrix; the division of this matrix and the operand
     * @throws ValueRuntimeException in case this matrix or matrix and the operand have a different size
     * @throws UnitException on unit error
     */
    public final <VT extends AbstractDoubleMatrix<?, ?, ?, ?> & Relative> SIMatrix divide(final VT rel)
            throws ValueRuntimeException, UnitException
    {
        checkSize(rel);
        return new SIMatrix(this.getData().divide(rel.getData()),
                SIUnit.of(getUnit().getUnitBase().getSiDimensions().minus(rel.getUnit().getUnitBase().getSiDimensions())));
    }
}
