package org.djunits4.value.vdouble.vector.base;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.djunits4.Throw;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.AbstractValue;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.formatter.Format;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vdouble.function.DoubleFunction;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.scalar.base.DoubleScalar;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;
import org.djunits4.value.vdouble.vector.data.DoubleVectorDataDense;
import org.djunits4.value.vdouble.vector.data.DoubleVectorDataSparse;

/**
 * The most basic abstract class for the DoubleVector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <S> the scalar with unit U
 * @param <V> the generic vector type
 */
public abstract class AbstractDoubleVector<U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
        V extends AbstractDoubleVector<U, S, V>> extends AbstractValue<U, V> implements DoubleVectorInterface<U, S, V>
{
    /** */
    private static final long serialVersionUID = 20161015L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected DoubleVectorData data;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /** helper flag to indicate whether the data is mutable or not. */
    private boolean mutable = false;

    /**
     * Construct a new AbstractDoubleVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit U; the unit
     */
    AbstractDoubleVector(final DoubleVectorData data, final U unit)
    {
        super(unit);
        this.data = data;
    }

    /**
     * Retrieve the data.
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final DoubleVectorData getData()
    {
        return this.data;
    }

    /** {@inheritDoc} */
    @Override
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
    }

    /**
     * Check the copyOnWrite flag and, if it is set, make a deep copy of the data and clear the flag.
     * @throws ValueRuntimeException if the vector is immutable
     */
    protected final void checkCopyOnWrite()
    {
        Throw.when(!this.mutable, ValueRuntimeException.class, "Immutable Vector cannot be modified");
        if (isCopyOnWrite())
        {
            this.data = this.data.copy();
            setCopyOnWrite(false);
        }
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

    /**
     * Return helper flag to indicate whether the data is mutable or not.
     * @return boolean; helper flag to indicate whether the data is mutable or not
     */
    public boolean isMutable()
    {
        return this.mutable;
    }

    /** {@inheritDoc} */
    @Override
    public V immutable()
    {
        if (this.mutable)
        {
            setCopyOnWrite(true);
        }
        V result = DoubleVector.instantiate(this.data, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        result.setCopyOnWrite(false);
        result.setMutable(false);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public V mutable()
    {
        if (this.mutable)
        {
            setCopyOnWrite(true);
        }
        V result = DoubleVector.instantiate(this.data, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        result.setCopyOnWrite(true);
        result.setMutable(true);
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    protected AbstractDoubleVector<U, S, V> clone() throws CloneNotSupportedException
    {
        return (AbstractDoubleVector<U, S, V>) super.clone();
    }

    /**
     * Set helper flag to indicate whether the data is mutable or not.
     * @param mutable boolean; helper flag to indicate whether the data is mutable or not
     */
    protected void setMutable(final boolean mutable)
    {
        this.mutable = mutable;
    }

    /** {@inheritDoc} */
    @Override
    public final double[] getValuesSI()
    {
        return this.data.getDenseVectorSI();
    }

    /** {@inheritDoc} */
    @Override
    public final double[] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final double[] getValuesInUnit(final U targetUnit)
    {
        double[] values = getValuesSI();
        for (int i = values.length; --i >= 0;)
        {
            values[i] = ValueUtil.expressAsUnit(values[i], targetUnit);
        }
        return values;
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.data.size();
    }

    /**
     * Check that a provided index is valid.
     * @param index int; the value to check
     * @throws ValueRuntimeException when index is invalid
     */
    protected final void checkIndex(final int index) throws ValueRuntimeException
    {
        if (index < 0 || index >= size())
        {
            throw new ValueRuntimeException("index out of range (valid range is 0.." + (size() - 1) + ", got " + index + ")");
        }
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int index) throws ValueRuntimeException
    {
        checkIndex(index);
        return this.data.getSI(index);
    }

    /** {@inheritDoc} */
    @Override
    public S get(int index) throws ValueRuntimeException
    {
        return DoubleScalar.instantiateSI(getSI(index), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int index) throws ValueRuntimeException
    {
        return ValueUtil.expressAsUnit(getSI(index), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int index, final U targetUnit) throws ValueRuntimeException
    {
        return ValueUtil.expressAsUnit(getSI(index), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int index, final double valueSI) throws ValueRuntimeException
    {
        checkIndex(index);
        checkCopyOnWrite();
        this.data.setSI(index, valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public void setInUnit(int index, double valueInUnit) throws ValueRuntimeException
    {
        setSI(index, ValueUtil.expressAsSIUnit(valueInUnit, getUnit()));
    }

    /** {@inheritDoc} */
    @Override
    public void setInUnit(int index, double valueInUnit, U valueUnit) throws ValueRuntimeException
    {
        setSI(index, ValueUtil.expressAsSIUnit(valueInUnit, valueUnit));
    }

    /** {@inheritDoc} */
    @Override
    public void set(int index, S value) throws ValueRuntimeException
    {
        setSI(index, value.si);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public S[] getScalars()
    {
        S[] array = (S[]) Array.newInstance(getScalarClass(), size());
        for (int i = 0; i < size(); i++)
        {
            array[i] = get(i);
        }
        return array;
    }

    /** {@inheritDoc} */
    @Override
    public final double zSum()
    {
        return this.data.zSum();
    }

    /** {@inheritDoc} */
    @Override
    public final int cardinality()
    {
        return this.data.cardinality();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public V toSparse()
    {
        V result;
        if (getStorageType().equals(StorageType.SPARSE))
        {
            result = (V) this;
            result.setDisplayUnit(getUnit());
        }
        else
        {
            result = (V) DoubleVector.instantiate(this.data.toSparse(), getUnit());
        }
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public V toDense()
    {
        V result;
        if (getStorageType().equals(StorageType.DENSE))
        {
            result = (V) this;
            result.setDisplayUnit(getUnit());
        }
        else
        {
            result = (V) DoubleVector.instantiate(this.data.toDense(), getUnit());
        }
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public V copy()
    {
        return (V) DoubleVector.instantiate(this.data.copy(), getUnit());
    }

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
    public V times(final double multiplier)
    {
        V result = isMutable() ? (V) this : copy();
        result.assign(DoubleMathFunctions.MULT(multiplier));
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public V divide(final double divisor)
    {
        @SuppressWarnings("unchecked")
        V result = isMutable() ? (V) this : copy();
        result.assign(DoubleMathFunctions.DIV(divisor));
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public V times(final float multiplier)
    {
        return times((double) multiplier);
    }

    /** {@inheritDoc} */
    @Override
    public V divide(float divisor)
    {
        return divide((double) divisor);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public V incrementBy(final S increment)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.INC(increment.si));
        return (V) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public V decrementBy(final S decrement)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.DEC(decrement.si));
        return (V) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final V abs()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.ABS);
        return (V) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final V ceil()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.CEIL);
        return (V) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final V floor()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.FLOOR);
        return (V) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final V neg()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.NEG);
        return (V) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final V rint()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.RINT);
        return (V) this;
    }

    /** {@inheritDoc} */
    @Override
    public final String toString()
    {
        return toString(getUnit(), false, true);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            String ar = this instanceof Absolute ? "Abs " : "Rel ";
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
            if (isMutable())
            {
                buf.append("Mutable   " + ar + ds);
            }
            else
            {
                buf.append("Immutable " + ar + ds);
            }
        }
        buf.append("[");
        for (int i = 0; i < size(); i++)
        {
            try
            {
                double d = ValueUtil.expressAsUnit(getSI(i), displayUnit);
                buf.append(" " + Format.format(d));
            }
            catch (ValueRuntimeException ve)
            {
                buf.append(" " + "********************".substring(0, Format.DEFAULTSIZE));
            }
        }
        buf.append("]");
        if (withUnit)
        {
            buf.append(" " + displayUnit.getDefaultDisplayAbbreviation());
        }
        return buf.toString();
    }

    /**
     * Centralized size equality check.
     * @param other AbstractDoubleVector&lt;U, ?&gt;; other DoubleVector
     * @throws NullPointerException when other vector is null
     * @throws ValueRuntimeException when vectors have unequal size
     */
    protected final void checkSize(final DoubleVectorInterface<?, ?, ?> other) throws ValueRuntimeException
    {
        Throw.whenNull(other, "Other vector is null");
        Throw.when(size() != other.size(), ValueRuntimeException.class, "The vectors have different sizes: %d != %d", size(),
                other.size());
    }

    /**
     * Centralized size equality check.
     * @param other double[]; array of double
     * @throws NullPointerException when array is null
     * @throws ValueRuntimeException when vectors have unequal size
     */
    protected final void checkSize(final double[] other) throws ValueRuntimeException
    {
        Throw.whenNull(other, "Array is null");
        Throw.when(size() != other.length, ValueRuntimeException.class,
                "The vector and the array have different sizes: %d != %d", size(), other.length);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = getUnit().getStandardUnit().hashCode();
        result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "checkstyle:needbraces"})
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractDoubleVector<?, ?, ?> other = (AbstractDoubleVector<?, ?, ?>) obj;
        if (!getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
            return false;
        if (this.data == null)
        {
            if (other.data != null)
                return false;
        }
        else if (!this.data.equals(other.data))
            return false;
        return true;
    }

    /* ============================================================================================ */
    /* =============================== ITERATOR METHODS AND CLASS ================================= */
    /* ============================================================================================ */

    /** {@inheritDoc} */
    @Override
    public Iterator<S> iterator()
    {
        return new Itr();
    }

    /**
     * The iterator class is loosely based in AbstractList.Itr. It does not throw a ConcurrentModificationException, because the
     * size of the vector does not change. Normal (non-mutable) vectors cannot change their size, nor their content. The only
     * thing for the MutableVector that can change is its content, not its length.
     */
    protected class Itr implements Iterator<S>
    {
        /** index of next element to return. */
        private int cursor = 0;

        /** {@inheritDoc} */
        @Override
        public boolean hasNext()
        {
            return this.cursor != size();
        }

        /** {@inheritDoc} */
        @Override
        public S next()
        {
            if (this.cursor >= size())
            {
                throw new NoSuchElementException();
            }
            try
            {
                int i = this.cursor;
                S next = get(i);
                this.cursor = i + 1;
                return next;
            }
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }

        /** {@inheritDoc} */
        @Override
        public void remove()
        {
            throw new RuntimeException("Remove function cannot be applied on fixed-size DJUNITS Vector");
        }
    }

}
