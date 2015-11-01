package org.djunits.value.vfloat.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Absolute Mutable typed Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <A> the absolute matrix type
 * @param <R> the relative matrix type
 * @param <MA> the mutable absolute matrix type
 * @param <S> the absolute scalar type
 */
abstract class MutableTypedFloatMatrixAbs<U extends Unit<U>, A extends TypedFloatMatrixAbs<U, A, R, MA, S>, R extends TypedFloatMatrixRel<U, R, ?, ?>, MA extends MutableTypedFloatMatrixAbs<U, A, R, MA, S>, S extends FloatScalar.Abs<U>>
    extends MutableFloatMatrix.Abs<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatMatrix
     * @param unit U; the unit of the new Relative Mutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedFloatMatrixAbs(final float[][] values, final U unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedFloatMatrixAbs(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTypedFloatMatrixAbs(final FloatMatrixData data, final U unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MA mutable()
    {
        setCopyOnWrite(true);
        final MA result = instantiateMutableType(getData(), getUnit());
        result.setCopyOnWrite(true);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public A immutable()
    {
        setCopyOnWrite(true);
        return instantiateTypeAbs(getData(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA toDense()
    {
        return this.data.isDense() ? (MA) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA toSparse()
    {
        return this.data.isSparse() ? (MA) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract A instantiateTypeAbs(final FloatMatrixData dmd, final U unit);

    /**
     * Construct a new Relative Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract R instantiateTypeRel(final FloatMatrixData dmd, final U unit);

    /**
     * Construct a new Absolute Mutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract MA instantiateMutableType(final FloatMatrixData dmd, final U unit);

    /** {@inheritDoc} */
    @Override
    public abstract S get(final int row, final int column) throws ValueException;

    /** {@inheritDoc} */
    @Override
    public final MA copy()
    {
        return mutable();
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA abs()
    {
        return (MA) super.abs();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA acos()
    {
        return (MA) super.acos();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA asin()
    {
        return (MA) super.asin();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA atan()
    {
        return (MA) super.atan();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA cbrt()
    {
        return (MA) super.cbrt();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA ceil()
    {
        return (MA) super.ceil();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA cos()
    {
        return (MA) super.cos();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA cosh()
    {
        return (MA) super.cosh();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA exp()
    {
        return (MA) super.exp();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA expm1()
    {
        return (MA) super.expm1();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA floor()
    {
        return (MA) super.floor();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA log()
    {
        return (MA) super.log();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA log10()
    {
        return (MA) super.log10();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA log1p()
    {
        return (MA) super.log1p();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA pow(final double x)
    {
        return (MA) super.pow((float) x);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA rint()
    {
        return (MA) super.rint();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA round()
    {
        return (MA) super.round();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA signum()
    {
        return (MA) super.signum();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA sin()
    {
        return (MA) super.sin();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA sinh()
    {
        return (MA) super.sinh();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA sqrt()
    {
        return (MA) super.sqrt();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA tan()
    {
        return (MA) super.tan();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA tanh()
    {
        return (MA) super.tanh();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA toDegrees()
    {
        return (MA) super.toDegrees();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA toRadians()
    {
        return (MA) super.toRadians();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA inv()
    {
        return (MA) super.inv();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA multiplyBy(final float constant)
    {
        return (MA) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA divideBy(final float constant)
    {
        return (MA) super.divideBy(constant);
    }

}
