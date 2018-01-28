package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AbsoluteLinearUnit;
import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Immutable FloatVector.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 30 Oct, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class FloatVector
{
    /**
     * Absolute Immutable FloatVector.
     * @param <AU> Absolute unit
     * @param <RU> Relative unit
     */
    public static class Abs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> extends AbstractFloatVectorAbs<AU, RU,
            FloatVector.Abs<AU, RU>, FloatVector.Rel<RU>, MutableFloatVector.Abs<AU, RU>, FloatScalar.Abs<AU, RU>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param values float[]; the values of the entries in the new Absolute Mutable FloatVector
         * @param unit AU; the unit of the new Absolute Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final AU unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatVector
         * @param unit AU; the unit of the new Absolute Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final AU unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatScalar.Abs<AU, RU>[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatScalar.Abs<AU, RU>> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatScalar.Abs<AU, RU>> values, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatVector
         * @param unit AU; the unit of the new Absolute Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final AU unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatVector.
         * @param data an internal data object
         * @param unit the unit
         */
        public Abs(final FloatVectorData data, final AU unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVector.Abs<AU, RU> instantiateTypeAbs(final FloatVectorData dvd, final AU unit)
        {
            return new FloatVector.Abs<AU, RU>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVector.Rel<RU> instantiateTypeRel(final FloatVectorData dvd, final RU unit)
        {
            return new FloatVector.Rel<RU>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatVector.Abs<AU, RU> instantiateMutableType(final FloatVectorData dvd, final AU unit)
        {
            return new MutableFloatVector.Abs<AU, RU>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatScalar.Abs<AU, RU> instantiateScalar(final float value, final AU unit)
        {
            return new FloatScalar.Abs<AU, RU>(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatVector.Abs<AU, RU> toDense()
        {
            return this.data.isDense() ? (FloatVector.Abs<AU, RU>) this : instantiateTypeAbs(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatVector.Abs<AU, RU> toSparse()
        {
            return this.data.isSparse() ? (FloatVector.Abs<AU, RU>) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
        }

    }

    /**
     * Relative Immutable FloatVector.
     * @param <U> Unit
     */
    public static class Rel<U extends Unit<U>>
            extends AbstractFloatVectorRel<U, FloatVector.Rel<U>, MutableFloatVector.Rel<U>, FloatScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param values float[]; the values of the entries in the new Relative Mutable FloatVector
         * @param unit U; the unit of the new Relative Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatVector
         * @param unit U; the unit of the new Relative Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatScalar.Rel<U>[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatScalar.Rel<U>> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatScalar.Rel<U>> values, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatVector.
         * @param data an internal data object
         * @param unit the unit
         */
        public Rel(final FloatVectorData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVector.Rel<U> instantiateType(final FloatVectorData dvd, final U unit)
        {
            return new FloatVector.Rel<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatVector.Rel<U> instantiateMutableType(final FloatVectorData dvd, final U unit)
        {
            return new MutableFloatVector.Rel<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatScalar.Rel<U> instantiateScalar(final float value, final U unit)
        {
            return new FloatScalar.Rel<U>(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatVector.Rel<U> toDense()
        {
            return this.data.isDense() ? (FloatVector.Rel<U>) this : instantiateType(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatVector.Rel<U> toSparse()
        {
            return this.data.isSparse() ? (FloatVector.Rel<U>) this : instantiateType(this.data.toSparse(), getUnit());
        }

    }
}
