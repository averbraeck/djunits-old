package org.djunits4.value.vfloat.vector.base;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Vector;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.vector.FloatSIVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * AbstractMutableFloatVectorRel.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit
 * @param <S> the scalar type belonging to the vector type
 * @param <RV> the relative vector type with this unit
 */
public abstract class AbstractFloatVectorRel<U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>,
        RV extends AbstractFloatVectorRel<U, S, RV>> extends AbstractFloatVector<U, S, RV>
        implements Vector.Rel<U, S, RV>, Relative
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param data FloatVectorData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractFloatVectorRel(final FloatVectorData data, final U unit)
    {
        super(data.copy(), unit);
    }

    /** {@inheritDoc} */
    @Override
    public final RV plus(final RV rel) throws ValueRuntimeException
    {
        return FloatVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final RV minus(final RV rel) throws ValueRuntimeException
    {
        return FloatVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public RV multiplyBy(final double multiplier)
    {
        checkCopyOnWrite();
        this.data.multiplyBy((float) multiplier);
        return (RV) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public RV divideBy(final double divisor)
    {
        checkCopyOnWrite();
        this.data.divideBy((float) divisor);
        return (RV) this;
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel VT; the right operand, which can be any vector type
     * @return FloatSIVector; the multiplication of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     * @throws UnitException on unit error
     */
    public final <VT extends AbstractFloatVector<?, ?, ?> & Relative> FloatSIVector times(final VT rel)
            throws ValueRuntimeException, UnitException
    {
        checkSize(rel);
        return new FloatSIVector(this.getData().times(rel.getData()),
                SIUnit.of(getUnit().getUnitBase().getSiDimensions().plus(rel.getUnit().getUnitBase().getSiDimensions())));
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel VT; the right operand, which can be any vector type
     * @return FloatSIVector; the division of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     * @throws UnitException on unit error
     */
    public final <VT extends AbstractFloatVector<?, ?, ?> & Relative> FloatSIVector divide(final VT rel)
            throws ValueRuntimeException, UnitException
    {
        checkSize(rel);
        return new FloatSIVector(this.getData().divide(rel.getData()),
                SIUnit.of(getUnit().getUnitBase().getSiDimensions().minus(rel.getUnit().getUnitBase().getSiDimensions())));
    }
}
