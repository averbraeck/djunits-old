package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLength;

/**
 * Immutable Length Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatLengthVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatLengthVector.
     */
    class Abs
        extends
        TypedFloatVectorAbs<LengthUnit, FloatLengthVector.Abs, FloatLengthVector.Rel, MutableFloatLengthVector.Abs, FloatLength.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param values float[]; the values of the entries in the new Absolute Immutable FloatLengthVector
         * @param unit U; the unit of the new Absolute Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final LengthUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatLengthVector
         * @param unit U; the unit of the new Absolute Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatLength.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param values List; the values of the entries in the new Absolute Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatLength.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatLengthVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatLength.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatLengthVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatLengthVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final LengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatLengthVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLengthVector.Abs instantiateTypeAbs(final FloatVectorData dvd, final LengthUnit unit)
        {
            return new FloatLengthVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLengthVector.Rel instantiateTypeRel(final FloatVectorData dvd, final LengthUnit unit)
        {
            return new FloatLengthVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatLengthVector.Abs instantiateMutableType(final FloatVectorData dvd,
            final LengthUnit unit)
        {
            return new MutableFloatLengthVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs get(final int index) throws ValueException
        {
            return new FloatLength.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatLength vector.
         */
        public final FloatLengthVector.Rel toRel()
        {
            return new FloatLengthVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatLengthVector.
     */
    class Rel extends
        TypedFloatVectorRel<LengthUnit, FloatLengthVector.Rel, MutableFloatLengthVector.Rel, FloatLength.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param values float[]; the values of the entries in the new Relative Immutable FloatLengthVector
         * @param unit U; the unit of the new Relative Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final LengthUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatLengthVector
         * @param unit U; the unit of the new Relative Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatLength.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param values List; the values of the entries in the new Relative Immutable FloatLengthVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatLength.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatLengthVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatLength.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatLengthVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatLengthVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final LengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatLengthVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLengthVector.Rel instantiateType(final FloatVectorData dvd, final LengthUnit unit)
        {
            return new FloatLengthVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatLengthVector.Rel instantiateMutableType(final FloatVectorData dvd,
            final LengthUnit unit)
        {
            return new MutableFloatLengthVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel get(final int index) throws ValueException
        {
            return new FloatLength.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatLength vector.
         */
        public final FloatLengthVector.Abs toAbs()
        {
            return new FloatLengthVector.Abs(getData(), getUnit());
        }

    }

}
