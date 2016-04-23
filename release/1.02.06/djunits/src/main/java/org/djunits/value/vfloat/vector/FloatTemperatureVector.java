package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTemperature;

/**
 * Immutable Temperature Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatTemperatureVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatTemperatureVector.
     */
    class Abs
        extends
        TypedFloatVectorAbs<TemperatureUnit, FloatTemperatureVector.Abs, FloatTemperatureVector.Rel, MutableFloatTemperatureVector.Abs, FloatTemperature.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param values float[]; the values of the entries in the new Absolute Immutable FloatTemperatureVector
         * @param unit U; the unit of the new Absolute Immutable FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatTemperatureVector
         * @param unit U; the unit of the new Absolute Immutable FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable
         *            FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatTemperature.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatTemperature.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatTemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatTemperature.Abs> values, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatTemperatureVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatTemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperatureVector.Abs instantiateTypeAbs(final FloatVectorData dvd,
            final TemperatureUnit unit)
        {
            return new FloatTemperatureVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperatureVector.Rel instantiateTypeRel(final FloatVectorData dvd,
            final TemperatureUnit unit)
        {
            return new FloatTemperatureVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTemperatureVector.Abs instantiateMutableType(final FloatVectorData dvd,
            final TemperatureUnit unit)
        {
            return new MutableFloatTemperatureVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs get(final int index) throws ValueException
        {
            return new FloatTemperature.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatTemperature vector.
         */
        public final FloatTemperatureVector.Rel toRel()
        {
            return new FloatTemperatureVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatTemperatureVector.
     */
    class Rel
        extends
        TypedFloatVectorRel<TemperatureUnit, FloatTemperatureVector.Rel, MutableFloatTemperatureVector.Rel, FloatTemperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param values float[]; the values of the entries in the new Relative Immutable FloatTemperatureVector
         * @param unit U; the unit of the new Relative Immutable FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatTemperatureVector
         * @param unit U; the unit of the new Relative Immutable FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable
         *            FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatTemperature.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatTemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatTemperature.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatTemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatTemperature.Rel> values, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatTemperatureVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatTemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperatureVector.Rel
            instantiateType(final FloatVectorData dvd, final TemperatureUnit unit)
        {
            return new FloatTemperatureVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTemperatureVector.Rel instantiateMutableType(final FloatVectorData dvd,
            final TemperatureUnit unit)
        {
            return new MutableFloatTemperatureVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel get(final int index) throws ValueException
        {
            return new FloatTemperature.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatTemperature vector.
         */
        public final FloatTemperatureVector.Abs toAbs()
        {
            return new FloatTemperatureVector.Abs(getData(), getUnit());
        }

    }

}
