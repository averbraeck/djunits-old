package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Immutable DoubleVector.
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 30 Oct, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class DoubleVector
{
    /**
     * Absolute Immutable DoubleVector.
     * @param <U> Unit
     */
    public static class Abs<U extends Unit<U>> extends
            AbstractDoubleVectorAbs<U, DoubleVector.Abs<U>, DoubleVector.Rel<U>, MutableDoubleVector.Abs<U>, DoubleScalar.Abs<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param values double[]; the values of the entries in the new Absolute Mutable DoubleVector
         * @param unit U; the unit of the new Absolute Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param values List; the values of the entries in the new Absolute Mutable DoubleVector
         * @param unit U; the unit of the new Absolute Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final DoubleScalar.Abs<U>[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param values List; the values of the entries in the new Absolute Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<DoubleScalar.Abs<U>> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, DoubleScalar.Abs<U>> values, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable DoubleVector
         * @param unit U; the unit of the new Absolute Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        public Abs(final DoubleVectorData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVector.Abs<U> instantiateTypeAbs(final DoubleVectorData dvd, final U unit)
        {
            return new DoubleVector.Abs<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVector.Rel<U> instantiateTypeRel(final DoubleVectorData dvd, final U unit)
        {
            return new DoubleVector.Rel<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDoubleVector.Abs<U> instantiateMutableType(final DoubleVectorData dvd, final U unit)
        {
            return new MutableDoubleVector.Abs<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleScalar.Abs<U> instantiateScalar(final double value, final U unit)
        {
            return new DoubleScalar.Abs<U>(value, unit);
        }

        /**
         * Create a dense version of this DoubleVector.
         * @return the dense version of this DoubleVector
         */
        public final DoubleVector.Abs<U> toDense()
        {
            return this.data.isDense() ? (DoubleVector.Abs<U>) this : instantiateTypeAbs(this.data.toDense(), getUnit());
        }

        /**
         * Create a sparse version of this DoubleVector.
         * @return the sparse version of this DoubleVector
         */
        public final DoubleVector.Abs<U> toSparse()
        {
            return this.data.isSparse() ? (DoubleVector.Abs<U>) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
        }

    }

    /**
     * Relative Immutable DoubleVector.
     * @param <U> Unit
     */
    public static class Rel<U extends Unit<U>>
            extends AbstractDoubleVectorRel<U, DoubleVector.Rel<U>, MutableDoubleVector.Rel<U>, DoubleScalar.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20150626L;

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param values double[]; the values of the entries in the new Relative Mutable DoubleVector
         * @param unit U; the unit of the new Relative Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param values List; the values of the entries in the new Relative Mutable DoubleVector
         * @param unit U; the unit of the new Relative Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final DoubleScalar.Rel<U>[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param values List; the values of the entries in the new Relative Mutable DoubleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<DoubleScalar.Rel<U>> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, DoubleScalar.Rel<U>> values, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable DoubleVector
         * @param unit U; the unit of the new Relative Sparse Mutable DoubleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final U unit, final int length, final StorageType storageType)
                throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        public Rel(final DoubleVectorData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVector.Rel<U> instantiateType(final DoubleVectorData dvd, final U unit)
        {
            return new DoubleVector.Rel<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDoubleVector.Rel<U> instantiateMutableType(final DoubleVectorData dvd, final U unit)
        {
            return new MutableDoubleVector.Rel<U>(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleScalar.Rel<U> instantiateScalar(final double value, final U unit)
        {
            return new DoubleScalar.Rel<U>(value, unit);
        }

        /**
         * Create a dense version of this DoubleVector.
         * @return the dense version of this DoubleVector
         */
        public final DoubleVector.Rel<U> toDense()
        {
            return this.data.isDense() ? (DoubleVector.Rel<U>) this : instantiateType(this.data.toDense(), getUnit());
        }

        /**
         * Create a sparse version of this DoubleVector.
         * @return the sparse version of this DoubleVector
         */
        public final DoubleVector.Rel<U> toSparse()
        {
            return this.data.isSparse() ? (DoubleVector.Rel<U>) this : instantiateType(this.data.toSparse(), getUnit());
        }

    }
}
