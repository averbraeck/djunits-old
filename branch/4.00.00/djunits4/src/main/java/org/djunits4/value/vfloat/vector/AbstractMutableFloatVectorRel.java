package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.Unit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.function.MathFunctionsRel;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.FloatFunction;
import org.djunits4.value.vfloat.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalarRel;

/**
 * Relative Mutable typed Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the vector type
 * @param <MR> the mutable vector type
 * @param <S> the scalar type
 */
abstract class AbstractMutableFloatVectorRel<U extends Unit<U>, R extends AbstractFloatVectorRel<U, R, MR, S>,
        MR extends AbstractMutableFloatVectorRel<U, R, MR, S>, S extends AbstractFloatScalarRel<U, S>>
        extends AbstractFloatVectorRel<U, R, MR, S>
        implements MathFunctionsRel<MR>, FloatMathFunctions<MR>, MutableFloatVectorInterface<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatVector
     * @param unit U; the unit of the new Relative Mutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractMutableFloatVectorRel(final float[] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Mutable FloatVector
     * @param unit U; the unit of the new Relative Mutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractMutableFloatVectorRel(final List<Float> values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values S[]; the values of the entries in the new Relative Mutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractMutableFloatVectorRel(final S[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values List&lt;S&gt;; the values of the entries in the new Relative Mutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractMutableFloatVectorRel(final List<S> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values SortedMap&lt;Integer, S&gt;; the values of the entries in the new Relative Sparse Mutable FloatVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractMutableFloatVectorRel(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable FloatVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractMutableFloatVectorRel(final SortedMap<Integer, Float> values, final U unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param data FloatVectorData; an internal data object
     * @param unit U; the unit
     */
    AbstractMutableFloatVectorRel(final FloatVectorData data, final U unit)
    {
        super(data, unit);
    }

    /**
     * Retrieve the value of the copyOnWrite flag.
     * @return boolean
     */
    private boolean isCopyOnWrite()
    {
        return this.copyOnWrite;
    }

    /**
     * Change the copyOnWrite flag.
     * @param copyOnWrite boolean; the new value for the copyOnWrite flag
     */
    final void setCopyOnWrite(final boolean copyOnWrite)
    {
        this.copyOnWrite = copyOnWrite;
    }

    /** {@inheritDoc} */
    @Override
    public final MR mutable()
    {
        setCopyOnWrite(true);
        final MR result = instantiateMutableType(getData(), getUnit());
        result.setCopyOnWrite(true);
        return result;
    }

    /**
     * Create a immutable version of this MutableFloatVector. <br>
     * @return FloatVector&lt;U&gt;; mutable version of this MutableFloatVector
     */
    @Override
    public R immutable()
    {
        setCopyOnWrite(true);
        return instantiateType(getData(), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Create a deep copy of this MutableFloatVector. <br>
     * @return FloatVector&lt;U&gt;; deep copy of this MutableFloatVector
     */
    public final MR copy()
    {
        return mutable();
    }

    /**
     * Increment the value by the supplied value and return the changed vector.
     * @param increment R; amount by which the value is incremented
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final R increment) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (MR) this;
    }

    /**
     * Increment the value by the supplied value and return the changed vector.
     * @param increment S; amount by which the value is incremented
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     */
    public final MR incrementBy(final S increment)
    {
        return incrementBy(increment.getSI());
    }

    /**
     * Increment the value by the supplied constant and return the changed vector.
     * @param increment float; amount by which the value is incremented
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final float increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed vector.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final R decrement) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed vector.
     * @param decrement S; amount by which the value is decremented
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     */
    public final MR decrementBy(final S decrement)
    {
        return decrementBy(decrement.getSI());
    }

    /**
     * Decrement the value by the supplied constant and return the changed vector.
     * @param decrement float; amount by which the value is decremented
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final float decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MR) this;
    }

    /**
     * Multiply the values in the vector by the supplied values and return the changed vector.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR multiplyBy(final R factors) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factors.getData());
        return (MR) this;
    }

    /**
     * Multiply the values in the vector by the supplied value and return the changed vector.
     * @param factor S; amount by which the values in the vector are multiplied
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     */
    public final MR multiplyBy(final S factor)
    {
        return multiplyBy(factor.getSI());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR multiplyBy(final float factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the vector by the supplied values and return the changed vector.
     * @param factors R; amounts by which the value is divided
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR divideBy(final R factors) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.divideBy(factors.getData());
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "unchecked"})
    public MR divideBy(final float divisor)
    {
        this.data.divideBy(divisor);
        return (MR) this;
    }

    /**
     * Divide the values in the vector by the supplied value and return the changed vector.
     * @param factor S; amount by which the values in the vector are divided
     * @return the changed MutableFloatVector.Rel&lt;U&gt;
     */
    public final MR divideBy(final S factor)
    {
        return divideBy(factor.getSI());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param floatFunction FloatFunction; the function to apply
     */
    public final void assign(final FloatFunction floatFunction)
    {
        checkCopyOnWrite();
        if (this.data instanceof FloatVectorDataDense)
        {
            ((FloatVectorDataDense) this.data).assign(floatFunction);
        }
        else
        {
            FloatVectorDataDense dvdd = ((FloatVectorDataSparse) this.data).toDense();
            dvdd.assign(floatFunction);
            this.data = dvdd.toSparse();
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR abs()
    {
        assign(FloatMathFunctions.ABS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR ceil()
    {
        assign(FloatMathFunctions.CEIL);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR floor()
    {
        assign(FloatMathFunctions.FLOOR);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR neg()
    {
        assign(FloatMathFunctions.NEG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR rint()
    {
        assign(FloatMathFunctions.RINT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR round()
    {
        assign(FloatMathFunctions.ROUND);
        return (MR) this;
    }

    /**
     * Check the copyOnWrite flag and, if it is set, make a deep copy of the data and clear the flag.
     */
    protected final void checkCopyOnWrite()
    {
        if (isCopyOnWrite())
        {
            this.data = this.data.copy();
            setCopyOnWrite(false);
        }
    }

    /**
     * Replace the value at index by the supplied value which is expressed in the standard SI unit.
     * @param index int; index of the value to replace
     * @param valueSI float; the value to store (expressed in the standard SI unit)
     * @throws ValueRuntimeException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void setSI(final int index, final float valueSI) throws ValueRuntimeException
    {
        checkIndex(index);
        checkCopyOnWrite();
        this.data.setSI(index, valueSI);
    }

    /**
     * Replace the value at index by the supplied value which is in a compatible unit.
     * @param index int; index of the value to replace
     * @param value S; the strongly typed value to store
     * @throws ValueRuntimeException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void set(final int index, final S value) throws ValueRuntimeException
    {
        setSI(index, value.getSI());
    }

    /**
     * Replace the value at index by the supplied value which is expressed in a supplied (compatible) unit.
     * @param index int; index of the value to replace
     * @param value float; the value to store (which is expressed in valueUnit)
     * @param valueUnit U; unit of the supplied value
     * @throws ValueRuntimeException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void setInUnit(final int index, final float value, final U valueUnit) throws ValueRuntimeException
    {
        setSI(index, (float) ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Normalize the vector, i.e. scale the values to make the sum equal to 1.
     * @throws ValueRuntimeException when the sum of the values is zero and normalization is not possible
     */
    public final void normalize() throws ValueRuntimeException
    {
        float sum = zSum();
        if (0 == sum)
        {
            throw new ValueRuntimeException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        this.data.divideBy(sum);
    }
}
