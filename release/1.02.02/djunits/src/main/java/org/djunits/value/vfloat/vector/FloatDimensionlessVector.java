package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDimensionless;

/**
 * Immutable Dimensionless Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatDimensionlessVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatDimensionlessVector.
     */
    class Abs
        extends
        TypedFloatVectorAbs<DimensionlessUnit, FloatDimensionlessVector.Abs, FloatDimensionlessVector.Rel, MutableFloatDimensionlessVector.Abs, FloatDimensionless.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param values float[]; the values of the entries in the new Absolute Immutable FloatDimensionlessVector
         * @param unit U; the unit of the new Absolute Immutable FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatDimensionlessVector
         * @param unit U; the unit of the new Absolute Immutable FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable
         *            FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatDimensionless.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatDimensionless.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatDimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatDimensionless.Abs> values, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatDimensionlessVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatDimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatDimensionlessVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatDimensionlessVector.Abs instantiateTypeAbs(final FloatVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new FloatDimensionlessVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatDimensionlessVector.Rel instantiateTypeRel(final FloatVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new FloatDimensionlessVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatDimensionlessVector.Abs instantiateMutableType(final FloatVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new MutableFloatDimensionlessVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs get(final int index) throws ValueException
        {
            return new FloatDimensionless.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatDimensionless vector.
         */
        public final FloatDimensionlessVector.Rel toRel()
        {
            return new FloatDimensionlessVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatDimensionlessVector.
     */
    class Rel
        extends
        TypedFloatVectorRel<DimensionlessUnit, FloatDimensionlessVector.Rel, MutableFloatDimensionlessVector.Rel, FloatDimensionless.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param values float[]; the values of the entries in the new Relative Immutable FloatDimensionlessVector
         * @param unit U; the unit of the new Relative Immutable FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatDimensionlessVector
         * @param unit U; the unit of the new Relative Immutable FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable
         *            FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatDimensionless.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatDimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatDimensionless.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatDimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatDimensionless.Rel> values, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatDimensionlessVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatDimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatDimensionlessVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatDimensionlessVector.Rel instantiateType(final FloatVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new FloatDimensionlessVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatDimensionlessVector.Rel instantiateMutableType(final FloatVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new MutableFloatDimensionlessVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel get(final int index) throws ValueException
        {
            return new FloatDimensionless.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatDimensionless vector.
         */
        public final FloatDimensionlessVector.Abs toAbs()
        {
            return new FloatDimensionlessVector.Abs(getData(), getUnit());
        }

    }

}
