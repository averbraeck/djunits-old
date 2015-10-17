package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTime;

/**
 * Immutable Time Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatTimeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatTimeVector.
     */
    class Abs
        extends
        TypedFloatVectorAbs<TimeUnit, FloatTimeVector.Abs, FloatTimeVector.Rel, MutableFloatTimeVector.Abs, FloatTime.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param values float[]; the values of the entries in the new Absolute Immutable FloatTimeVector
         * @param unit U; the unit of the new Absolute Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatTimeVector
         * @param unit U; the unit of the new Absolute Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatTime.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatTime.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatTimeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatTime.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatTimeVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatTimeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTimeVector.Abs instantiateTypeAbs(final FloatVectorData dvd, final TimeUnit unit)
        {
            return new FloatTimeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTimeVector.Rel instantiateTypeRel(final FloatVectorData dvd, final TimeUnit unit)
        {
            return new FloatTimeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTimeVector.Abs
            instantiateMutableType(final FloatVectorData dvd, final TimeUnit unit)
        {
            return new MutableFloatTimeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs get(final int index) throws ValueException
        {
            return new FloatTime.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatTime vector.
         */
        public final FloatTimeVector.Rel toRel()
        {
            return new FloatTimeVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatTimeVector.
     */
    class Rel extends TypedFloatVectorRel<TimeUnit, FloatTimeVector.Rel, MutableFloatTimeVector.Rel, FloatTime.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param values float[]; the values of the entries in the new Relative Immutable FloatTimeVector
         * @param unit U; the unit of the new Relative Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatTimeVector
         * @param unit U; the unit of the new Relative Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatTime.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatTimeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatTime.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatTimeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatTime.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatTimeVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatTimeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTimeVector.Rel instantiateType(final FloatVectorData dvd, final TimeUnit unit)
        {
            return new FloatTimeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTimeVector.Rel
            instantiateMutableType(final FloatVectorData dvd, final TimeUnit unit)
        {
            return new MutableFloatTimeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel get(final int index) throws ValueException
        {
            return new FloatTime.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatTime vector.
         */
        public final FloatTimeVector.Abs toAbs()
        {
            return new FloatTimeVector.Abs(getData(), getUnit());
        }

    }

}
