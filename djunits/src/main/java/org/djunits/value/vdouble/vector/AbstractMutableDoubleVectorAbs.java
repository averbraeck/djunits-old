package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AbsoluteLinearUnit;
import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsAbs;
import org.djunits.value.Mutable;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleFunction;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarAbs;

/**
 * Absolute Mutable typed Vector.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <AU> the absolute unit
 * @param <RU> the relative unit
 * @param <A> the absolute vector type
 * @param <R> the relative vector type
 * @param <MA> the mutable absolute vector type
 * @param <S> the absolute scalar type
 */
abstract class AbstractMutableDoubleVectorAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractDoubleVectorAbs<AU, RU, A, R, MA, S>, R extends AbstractDoubleVectorRel<RU, R, ?, ?>,
        MA extends AbstractMutableDoubleVectorAbs<AU, RU, A, R, MA, S>, S extends AbstractDoubleScalarAbs<AU, S, RU, ?>>
        extends AbstractDoubleVectorAbs<AU, RU, A, R, MA, S>
        implements Mutable, MathFunctionsAbs<MA>, DoubleMathFunctions<MA>, MutableDoubleVectorInterface<AU>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param values double[]; the values of the entries in the new Absolute Mutable DoubleVector
     * @param unit AU; the unit of the new Absolute Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleVectorAbs(final double[] values, final AU unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Absolute Mutable DoubleVector
     * @param unit AU; the unit of the new Absolute Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleVectorAbs(final List<Double> values, final AU unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param values S[]; the values of the entries in the new Absolute Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleVectorAbs(final S[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param values List&lt;S&gt;; the values of the entries in the new Absolute Mutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleVectorAbs(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param values SortedMap&lt;Integer, S&gt;; the values of the entries in the new Absolute Sparse Mutable DoubleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleVectorAbs(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Absolute Sparse Mutable DoubleVector
     * @param unit AU; the unit of the new Absolute Sparse Mutable DoubleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleVectorAbs(final SortedMap<Integer, Double> values, final AU unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit AU; the unit
     */
    AbstractMutableDoubleVectorAbs(final DoubleVectorData data, final AU unit)
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
    public final MA mutable()
    {
        setCopyOnWrite(true);
        final MA result = instantiateMutableType(getData(), getUnit());
        result.setCopyOnWrite(true);
        return result;
    }

    /**
     * Create a immutable version of this MutableDoubleVector. <br>
     * @return DoubleVector&lt;U&gt;; mutable version of this MutableDoubleVector
     */
    @Override
    public A immutable()
    {
        setCopyOnWrite(true);
        return instantiateTypeAbs(getData(), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Create a deep copy of this MutableDoubleVector. <br>
     * @return DoubleVector&lt;U&gt;; deep copy of this MutableDoubleVector
     */
    public final MA copy()
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
    public final MA incrementBy(final R increment) throws ValueException
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (MA) this;
    }

    /**
     * Increment the value by the supplied value and return the changed vector.
     * @param increment S; amount by which the value is incremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    public final MA incrementBy(final S increment)
    {
        return incrementBy(increment.si);
    }

    /**
     * Increment the value by the supplied constant and return the changed vector.
     * @param increment double; amount by which the value is incremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MA incrementBy(final double increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MA) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed vector.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MA decrementBy(final R decrement) throws ValueException
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (MA) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed vector.
     * @param decrement S; amount by which the value is decremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    public final MA decrementBy(final S decrement)
    {
        return decrementBy(decrement.si);
    }

    /**
     * Decrement the value by the supplied constant and return the changed vector.
     * @param decrement double; amount by which the value is decremented
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MA decrementBy(final double decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA multiplyBy(final double factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({ "checkstyle:designforextension", "unchecked" })
    public MA divideBy(final double factor)
    {
        this.data.divideBy(factor);
        return (MA) this;
    }

    /**
     * Multiply the values in the vector by the supplied values and return the changed vector.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableDoubleVector.Rel&lt;U&gt;
     * @throws ValueException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MA multiplyBy(final R factors) throws ValueException
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factors.getData());
        return (MA) this;
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
    @Override
    @SuppressWarnings("unchecked")
    public final MA ceil()
    {
        assign(DoubleMathFunctions.CEIL);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA floor()
    {
        assign(DoubleMathFunctions.FLOOR);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA rint()
    {
        assign(DoubleMathFunctions.RINT);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA round()
    {
        assign(DoubleMathFunctions.ROUND);
        return (MA) this;
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
     * @param valueUnit AU; unit of the supplied value
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    public final void setInUnit(final int index, final double value, final AU valueUnit) throws ValueException
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
