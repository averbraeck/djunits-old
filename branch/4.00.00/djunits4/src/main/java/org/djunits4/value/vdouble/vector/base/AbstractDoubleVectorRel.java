package org.djunits4.value.vdouble.vector.base;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Vector;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.scalar.base.DoubleScalar;
import org.djunits4.value.vdouble.vector.SIVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * AbstractMutableDoubleVectorRel.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit
 * @param <S> the scalar type belonging to the vector type
 * @param <RV> the relative vector type with this unit
 */
public abstract class AbstractDoubleVectorRel<U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>,
        RV extends AbstractDoubleVectorRel<U, S, RV>> extends AbstractDoubleVector<U, S, RV>
        implements Vector.Rel<U, S, RV>, Relative
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractDoubleVectorRel(final DoubleVectorData data, final U unit)
    {
        super(data.copy(), unit);
    }

    /**
     * Compute the sum of all SI values of this vector.
     * @return S; the sum of all SI values of this vector with the same display unit as this vector
     */
    public final S zSum()
    {
        S result = DoubleScalar.instantiate(this.data.zSum(), getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final RV plus(final RV rel) throws ValueRuntimeException
    {
        return DoubleVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final RV minus(final RV rel) throws ValueRuntimeException
    {
        return DoubleVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public RV multiplyBy(final double multiplier)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(multiplier);
        return (RV) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public RV divideBy(final double divisor)
    {
        checkCopyOnWrite();
        this.data.divideBy(divisor);
        return (RV) this;
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel VT; the right operand, which can be any vector type
     * @return SIVector; the multiplication of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     * @throws UnitException on unit error
     */
    public final <VT extends AbstractDoubleVector<?, ?, ?> & Relative> SIVector times(final VT rel)
            throws ValueRuntimeException, UnitException
    {
        checkSize(rel);
        return new SIVector(this.getData().times(rel.getData()),
                SIUnit.of(getUnit().getUnitBase().getSiDimensions().plus(rel.getUnit().getUnitBase().getSiDimensions())));
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel VT; the right operand, which can be any vector type
     * @return SIVector; the division of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     * @throws UnitException on unit error
     */
    public final <VT extends AbstractDoubleVector<?, ?, ?> & Relative> SIVector divide(final VT rel)
            throws ValueRuntimeException, UnitException
    {
        checkSize(rel);
        return new SIVector(this.getData().divide(rel.getData()),
                SIUnit.of(getUnit().getUnitBase().getSiDimensions().minus(rel.getUnit().getUnitBase().getSiDimensions())));
    }
}
