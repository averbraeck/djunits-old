package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsRel;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleFunction;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarRel;

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
abstract class AbstractMutableDoubleVectorRel<U extends Unit<U>, R extends AbstractDoubleVectorRel<U, R, MR, S>,
        MR extends AbstractMutableDoubleVectorRel<U, R, MR, S>, S extends AbstractDoubleScalarRel<U, S>>
        extends AbstractDoubleVectorRel<U, R, MR, S>
        implements MathFunctionsRel<MR>, DoubleMathFunctions<MR>, MutableDoubleVectorInterface<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values double[]; the values of the entries in the new Relative Mutable DoubleVector
     * @param unit U; the unit of the new Relative Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleVectorRel(final double[] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Mutable DoubleVector
     * @param unit U; the unit of the new Relative Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleVectorRel(final List<Double> values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values S[]; the values of the entries in the new Relative Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleVectorRel(final S[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values List&lt;S&gt;; the values of the entries in the new Relative Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleVectorRel(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values SortedMap&lt;Integer, S&gt;; the values of the entries in the new Relative Sparse Mutable DoubleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleVectorRel(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable DoubleVector
     * @param unit U; the unit of the new Relative Sparse Mutable DoubleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleVectorRel(final SortedMap<Integer, Double> values, final U unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit U; the unit
     */
    AbstractMutableDoubleVectorRel(final DoubleVectorData data, final U unit)
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
     * Create a immutable version of this MutableDoubleVector. <br>
     * @return DoubleVector&lt;U&gt;; mutable version of this MutableDoubleVector
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
     * Create a deep copy of this MutableDoubleVector. <br>
     * @return DoubleVector&lt;U&gt;; deep copy of this MutableDoubleVector
     */
    public final MR copy()
    {
        return mutable();
    }

    /**
     * Increment the value by the supplied value and return the changed vector.
     * @param increment R; amount by which the value is incremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final R increment) throws ValueException
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (MR) this;
    }

    /**
     * Increment the value by the supplied value and return the changed vector.
     * @param increment S; amount by which the value is incremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    public final MR incrementBy(final S increment)
    {
        return incrementBy(increment.si);
    }

    /**
     * Increment the value by the supplied constant and return the changed vector.
     * @param increment double; amount by which the value is incremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final double increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed vector.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final R decrement) throws ValueException
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed vector.
     * @param decrement S; amount by which the value is decremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    public final MR decrementBy(final S decrement)
    {
        return decrementBy(decrement.si);
    }

    /**
     * Decrement the value by the supplied constant and return the changed vector.
     * @param decrement double; amount by which the value is decremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final double decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MR) this;
    }

    /**
     * Multiply the values in the vector by the supplied values and return the changed vector.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     * @throws ValueException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR multiplyBy(final R factors) throws ValueException
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factors.getData());
        return (MR) this;
    }

    /**
     * Multiply the values in the vector by the supplied value and return the changed vector.
     * @param factor S; amount by which the values in the vector are multiplied
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    public final MR multiplyBy(final S factor)
    {
        return multiplyBy(factor.si);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR multiplyBy(final double factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the vector by the supplied values and return the changed vector.
     * @param factors R; amounts by which the value is divided
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     * @throws ValueException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR divideBy(final R factors) throws ValueException
    {
        checkCopyOnWrite();
        this.data.divideBy(factors.getData());
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "unchecked"})
    public MR divideBy(final double factor)
    {
        this.data.divideBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the vector by the supplied value and return the changed vector.
     * @param factor S; amount by which the values in the vector are divided
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    public final MR divideBy(final S factor)
    {
        return divideBy(factor.si);
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param doubleFunction DoubleFunction; the function to apply
     */
    public final void assign(final DoubleFunction doubleFunction)
    {
        checkCopyOnWrite();
        if (this.data instanceof DoubleVectorDataDense)
        {
            ((DoubleVectorDataDense) this.data).assign(doubleFunction);
        }
        else
        {
            DoubleVectorDataDense dvdd = ((DoubleVectorDataSparse) this.data).toDense();
            dvdd.assign(doubleFunction);
            this.data = dvdd.toSparse();
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR abs()
    {
        assign(DoubleMathFunctions.ABS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR ceil()
    {
        assign(DoubleMathFunctions.CEIL);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR floor()
    {
        assign(DoubleMathFunctions.FLOOR);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR neg()
    {
        assign(DoubleMathFunctions.NEG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR rint()
    {
        assign(DoubleMathFunctions.RINT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR round()
    {
        assign(DoubleMathFunctions.ROUND);
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
     * @param valueSI double; the value to store (expressed in the standard SI unit)
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void setSI(final int index, final double valueSI) throws ValueException
    {
        checkIndex(index);
        checkCopyOnWrite();
        this.data.setSI(index, valueSI);
    }

    /**
     * Replace the value at index by the supplied value which is in a compatible unit.
     * @param index int; index of the value to replace
     * @param value S; the strongly typed value to store
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void set(final int index, final S value) throws ValueException
    {
        setSI(index, value.getSI());
    }

    /**
     * Replace the value at index by the supplied value which is expressed in a supplied (compatible) unit.
     * @param index int; index of the value to replace
     * @param value double; the value to store (which is expressed in valueUnit)
     * @param valueUnit U; unit of the supplied value
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void setInUnit(final int index, final double value, final U valueUnit) throws ValueException
    {
        setSI(index, ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Normalize the vector, i.e. scale the values to make the sum equal to 1.
     * @throws ValueException when the sum of the values is zero and normalization is not possible
     */
    public final void normalize() throws ValueException
    {
        double sum = zSum();
        if (0 == sum)
        {
            throw new ValueException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        this.data.divideBy(sum);
    }
}
