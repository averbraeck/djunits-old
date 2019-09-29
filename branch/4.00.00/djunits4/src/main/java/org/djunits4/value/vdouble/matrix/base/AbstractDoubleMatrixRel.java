package org.djunits4.value.vdouble.matrix.base;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Matrix;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.matrix.SIMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.scalar.base.DoubleScalar;
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
        RV extends AbstractDoubleVectorRel<U, S, RV>, RM extends AbstractDoubleMatrixRel<U, S, RV, RM>>
        extends AbstractDoubleMatrix<U, S, RV, RM> implements Matrix.Rel<U, S, RV, RM>, Relative
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

    /**
     * Compute the sum of all SI values of this matrix.
     * @return S; the sum of all SI values of this matrix with the same display unit as this matrix
     */
    public final S zSum()
    {
        S result = DoubleScalar.instantiate(this.data.zSum(), getDisplayUnit().getStandardUnit());
        result.setDisplayUnit(getDisplayUnit());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final RM plus(final RM rel) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().plus(rel.getData()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final RM minus(final RM rel) throws ValueRuntimeException
    {
        return DoubleMatrix.instantiate(this.getData().minus(rel.getData()), getDisplayUnit());
    }

    /**
     * Increment all values of this matrix by the increment. This only works if this matrix is mutable.
     * @param increment S; the scalar by which to increment all values
     * @return RM; this modified matrix
     * @throws ValueRuntimeException in case this matrix is immutable
     */
    @SuppressWarnings("unchecked")
    public RM incrementBy(final S increment)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.INC(increment.si));
        return (RM) this;
    }

    /**
     * Increment all values of this matrix by the increment on a value by value basis. This only works if this matrix is
     * mutable.
     * @param increment RM; the matrix that contains the values by which to increment the corresponding values
     * @return RM; this modified matrix
     * @throws ValueRuntimeException in case this matrix is immutable
     * @Throws ValueException when the sizes of the matrices differ, or <code>increment</code> is null
     */
    @SuppressWarnings("unchecked")
    public RM incrementBy(RM increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (RM) this;
    }

    /**
     * Decrement all values of this matrix by the decrement. This only works if this matrix is mutable.
     * @param decrement S; the scalar by which to decrement all values
     * @return RM; this modified matrix
     * @throws ValueRuntimeException in case this matrix is immutable
     */
    @SuppressWarnings("unchecked")
    public RM decrementBy(final S decrement)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.DEC(decrement.si));
        return (RM) this;
    }

    /**
     * Decrement all values of this matrix by the decrement on a value by value basis. This only works if this matrix is
     * mutable.
     * @param decrement RM; the matrix that contains the values by which to decrement the corresponding values
     * @return RM; this modified matrix
     * @throws ValueRuntimeException in case this matrix is immutable
     * @Throws ValueException when the sizes of the matrices differ, or <code>decrement</code> is null
     */
    @SuppressWarnings("unchecked")
    public RM decrementBy(RM decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (RM) this;
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
        return new SIMatrix(this.getData().times(rel.getData()), SIUnit.of(
                getDisplayUnit().getUnitBase().getSiDimensions().plus(rel.getDisplayUnit().getUnitBase().getSiDimensions())));
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
        return new SIMatrix(this.getData().divide(rel.getData()), SIUnit.of(
                getDisplayUnit().getUnitBase().getSiDimensions().minus(rel.getDisplayUnit().getUnitBase().getSiDimensions())));
    }
}
