package org.djunits.value.vdouble.vector;

import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.AbstractValue;
import org.djunits.value.FunctionsAbs;
import org.djunits.value.FunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Immutable DoubleVector.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 30 Oct, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit the unit for which this Vector will be created
 */
public abstract class DoubleVector<U extends Unit<U>> extends AbstractValue<U> implements DoubleVectorInterface<U>,
        Serializable
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected DoubleVectorData data;

    /**
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final DoubleVectorData getData()
    {
        return this.data;
    }

    /**
     * Construct a new Immutable DoubleVector.
     * @param unit U; the unit of the new Absolute Immutable DoubleVector
     */
    protected DoubleVector(final U unit)
    {
        super(unit);
    }

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Vector.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Vector
     */
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
    }

    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of DoubleVector.
     * @param <U> Unit the unit for which this Vector will be created
     */
    public static class Abs<U extends Unit<U>> extends DoubleVector<U> implements Absolute,
            FunctionsAbs<U, DoubleVector.Abs<U>, DoubleVector.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param values double[]; the values of the entries in the new Absolute Immutable DoubleVector
         * @param unit U; the unit of the new Absolute Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = DoubleVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param values List; the values of the entries in the new Absolute Immutable DoubleVector
         * @param unit U; the unit of the new Absolute Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = DoubleVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final DoubleScalar.Abs<U>[] values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleVectorData.instantiate(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param values List; the values of the entries in the new Absolute Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends DoubleScalar.Abs<U>> Abs(final List<S> values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleVectorData.instantiateLD(values, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends DoubleScalar.Abs<U>> Abs(final SortedMap<Integer, S> values, final int length,
                final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleVectorData.instantiateMD(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable DoubleVector
         * @param unit U; the unit of the new Relative Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(unit);
            this.data = DoubleVectorData.instantiate(values, length, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final U unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @SuppressWarnings("checkstyle:designforextension")
        @Override
        public MutableDoubleVector.Abs<U> mutable()
        {
            return MutableDoubleVector.instantiateMutableAbs(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> toDense()
        {
            return this.data.isDense() ? this : instantiateAbs(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateAbs(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleScalar.Abs<U> get(final int index) throws ValueException
        {
            return new DoubleScalar.Abs<U>(getInUnit(index, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> plus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> minus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Rel<U> minus(final DoubleVector.Abs<U> abs) throws ValueException
        {
            return instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of DoubleVector.
     * @param <U> Unit the unit for which this Vector will be created
     */
    public static class Rel<U extends Unit<U>> extends DoubleVector<U> implements Relative,
            FunctionsRel<U, DoubleVector.Abs<U>, DoubleVector.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values double[]; the values of the entries in the new Relative Immutable DoubleVector
         * @param unit U; the unit of the new Relative Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = DoubleVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values List; the values of the entries in the new Relative Immutable DoubleVector
         * @param unit U; the unit of the new Relative Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            this.data = DoubleVectorData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final DoubleScalar.Rel<U>[] values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleVectorData.instantiate(values, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values List; the values of the entries in the new Relative Immutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends DoubleScalar.Rel<U>> Rel(final List<S> values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleVectorData.instantiateLD(values, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @param <S> the Scalar type used
         * @throws ValueException when values has zero entries
         */
        public <S extends DoubleScalar.Rel<U>> Rel(final SortedMap<Integer, S> values, final int length,
                final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleVectorData.instantiateMD(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable DoubleVector
         * @param unit U; the unit of the new Relative Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(unit);
            this.data = DoubleVectorData.instantiate(values, length, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final U unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @SuppressWarnings("checkstyle:designforextension")
        @Override
        public MutableDoubleVector.Rel<U> mutable()
        {
            return new MutableDoubleVector.Rel<U>(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Rel<U> toDense()
        {
            return this.data.isDense() ? this : instantiateRel(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateRel(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleScalar.Rel<U> get(final int index) throws ValueException
        {
            return new DoubleScalar.Rel<U>(getInUnit(index, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Rel<U> plus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleVector.Abs<U> plus(final DoubleVector.Abs<U> abs) throws ValueException
        {
            return instantiateAbs(this.getData().plus(abs.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleVector.Rel<U> minus(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleVector.Rel<U> times(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleVector.Rel<U> divide(final DoubleVector.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a DoubleVector, and return the Unit.
     * @param dsArray the array to check and get the unit for
     * @param <U> the unit
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>> U checkUnit(final DoubleScalar<U>[] dsArray) throws ValueException
    {
        if (dsArray != null && dsArray.length > 0)
        {
            return dsArray[0].getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty array of DoubleScalar");
    }

    /**
     * Check that a provided list can be used to create some descendant of a DoubleVector, and return the Unit.
     * @param dsList the list to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar in the list
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends DoubleScalar<U>> U checkUnit(final List<S> dsList) throws ValueException
    {
        if (dsList != null && dsList.size() > 0)
        {
            return dsList.get(0).getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty list of DoubleScalar");
    }

    /**
     * Check that a provided Map can be used to create some descendant of a DoubleVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the DoubleScalar list
     * @param <S> the scalar in the list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>, S extends DoubleScalar<U>> U checkUnit(final SortedMap<Integer, S> dsMap) throws ValueException
    {
        if (dsMap != null && dsMap.size() > 0)
        {
            return dsMap.get(dsMap.firstKey()).getUnit();
        }
        throw new ValueException("Cannot create a DoubleVector or MutableDoubleVector from a null or empty Map of DoubleScalar");
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the DoubleVectorData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> DoubleVector.Rel<U> instantiateRel(final DoubleVectorData dvData, final U unit)
    {
        return new DoubleVector.Rel<U>(dvData, unit);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the DoubleVectorData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> DoubleVector.Abs<U> instantiateAbs(final DoubleVectorData dvData, final U unit)
    {
        return new DoubleVector.Abs<U>(dvData, unit);
    }

    /* ============================================================================================ */
    /* ================================== GENERIC VECTOR METHODS ================================== */
    /* ============================================================================================ */

    /**
     * Create a double[] array filled with the values in the standard SI unit.
     * @return double[]; array of values in the standard SI unit
     */
    public final double[] getValuesSI()
    {
        return this.data.getDenseVectorSI();
    }

    /**
     * Create a double[] array filled with the values in the original unit.
     * @return double[]; the values in the original unit
     */
    public final double[] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /**
     * Create a double[] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return double[]; the values converted into the specified unit
     */
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
     * @throws ValueException when index is invalid
     */
    protected final void checkIndex(final int index) throws ValueException
    {
        if (index < 0 || index >= size())
        {
            throw new ValueException("index out of range (valid range is 0.." + (size() - 1) + ", got " + index + ")");
        }
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int index) throws ValueException
    {
        checkIndex(index);
        return this.data.getSI(index);
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int index) throws ValueException
    {
        return expressAsSpecifiedUnit(getSI(index));
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int index, final U targetUnit) throws ValueException
    {
        return ValueUtil.expressAsUnit(getSI(index), targetUnit);
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
    @Override
    public final String toString()
    {
        return toString(getUnit(), false, true);
    }

    /**
     * Print this DoubleVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the vector contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this DoubleVector with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this DoubleVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            String ab = this instanceof Absolute ? "Abs " : this instanceof Relative ? "Rel " : "??? ";
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
            if (this instanceof MutableDoubleVector)
            {
                buf.append("Mutable   " + ab + ds);
            }
            else
            {
                buf.append("Immutable " + ab + ds);
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
            catch (ValueException ve)
            {
                buf.append(" " + "********************".substring(0, Format.DEFAULTSIZE));
            }
        }
        buf.append("]");
        if (withUnit)
        {
            buf.append(" " + displayUnit.getAbbreviation());
        }
        return buf.toString();
    }

    /**
     * Centralized size equality check.
     * @param other DoubleVector&lt;?&gt;; other DoubleVector
     * @throws ValueException when other is null, or vectors have unequal size
     */
    protected final void checkSize(final DoubleVector<?> other) throws ValueException
    {
        if (null == other)
        {
            throw new ValueException("other is null");
        }
        if (size() != other.size())
        {
            throw new ValueException("The vectors have different sizes: " + size() + " != " + other.size());
        }
    }

    /**
     * Centralized size equality check.
     * @param other double[]; array of double
     * @throws ValueException when vectors have unequal size
     */
    protected final void checkSize(final double[] other) throws ValueException
    {
        if (size() != other.length)
        {
            throw new ValueException("The vector and the array have different sizes: " + size() + " != " + other.length);
        }
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({ "checkstyle:needbraces", "checkstyle:designforextension" })
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleVector<?> other = (DoubleVector<?>) obj;
        if (this.data == null)
        {
            if (other.data != null)
                return false;
        }
        else if (!this.data.equals(other.data))
            return false;
        return true;
    }

    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Abs.Dense&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Abs.Dense&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Abs.Dense&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Abs<U> interpolate(final DoubleVector.Abs.Dense<U> zero,
    // final DoubleVector.Abs.Dense<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Abs<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Rel.Dense&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Rel.Dense&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Rel.Dense&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Rel<U> interpolate(final DoubleVector.Rel.Dense<U> zero,
    // final DoubleVector.Rel.Dense<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Rel<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Abs.Sparse&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Abs.Sparse&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Abs.Sparse&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Abs<U> interpolate(final DoubleVector.Abs.Sparse<U> zero,
    // final DoubleVector.Abs.Sparse<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Abs<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }
    //
    // /**
    // * Interpolate between or extrapolate over two values.
    // * @param zero DoubleVector.Rel.Sparse&lt;U&gt;; zero reference (returned when ratio == 0)
    // * @param one DoubleVector.Rel.Sparse&lt;U&gt;; one reference (returned when ratio == 1)
    // * @param ratio double; the ratio that determines where between (or outside) zero and one the result lies
    // * @param <U> Unit; the unit of the parameters and the result
    // * @return MutableDoubleVector.Rel.Sparse&lt;U&gt;
    // * @throws ValueException when zero and one do not have the same size
    // */
    // public static <U extends Unit<U>> MutableDoubleVector.Rel<U> interpolate(final DoubleVector.Rel.Sparse<U> zero,
    // final DoubleVector.Rel.Sparse<U> one, final double ratio) throws ValueException
    // {
    // MutableDoubleVector.Rel<U> result = zero.mutable();
    // for (int index = result.size(); --index >= 0;)
    // {
    // result.setSI(index, result.getSI(index) * (1 - ratio) + one.getSI(index) * ratio);
    // }
    // return result;
    // }

}
