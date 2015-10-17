package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAnglePlane;

/**
 * Mutable FloatAnglePlane Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatAnglePlaneVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatAnglePlaneVector.
     */
    class Abs
        extends
        MutableTypedFloatVectorAbs<AnglePlaneUnit, FloatAnglePlaneVector.Abs, FloatAnglePlaneVector.Rel, MutableFloatAnglePlaneVector.Abs, FloatAnglePlane.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param values float[]; the values of the entries in the new Absolute Mutable FloatAnglePlaneVector
         * @param unit U; the unit of the new Absolute Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatAnglePlaneVector
         * @param unit U; the unit of the new Absolute Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatAnglePlane.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatAnglePlane.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatAnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatAnglePlane.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatAnglePlaneVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatAnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final AnglePlaneUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlaneVector.Abs instantiateTypeAbs(final FloatVectorData dvd,
            final AnglePlaneUnit unit)
        {
            return new FloatAnglePlaneVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlaneVector.Rel instantiateTypeRel(final FloatVectorData dvd,
            final AnglePlaneUnit unit)
        {
            return new FloatAnglePlaneVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAnglePlaneVector.Abs instantiateMutableType(final FloatVectorData dvd,
            final AnglePlaneUnit unit)
        {
            return new MutableFloatAnglePlaneVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs get(final int index) throws ValueException
        {
            return new FloatAnglePlane.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatAnglePlane vector.
         */
        public final MutableFloatAnglePlaneVector.Rel toRel()
        {
            return new MutableFloatAnglePlaneVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatAnglePlaneVector.
     */
    class Rel
        extends
        MutableTypedFloatVectorRel<AnglePlaneUnit, FloatAnglePlaneVector.Rel, MutableFloatAnglePlaneVector.Rel, FloatAnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param values float[]; the values of the entries in the new Relative Mutable FloatAnglePlaneVector
         * @param unit U; the unit of the new Relative Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatAnglePlaneVector
         * @param unit U; the unit of the new Relative Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatAnglePlane.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatAnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatAnglePlane.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatAnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatAnglePlane.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatAnglePlaneVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatAnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final AnglePlaneUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlaneVector.Rel instantiateType(final FloatVectorData dvd, final AnglePlaneUnit unit)
        {
            return new FloatAnglePlaneVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAnglePlaneVector.Rel instantiateMutableType(final FloatVectorData dvd,
            final AnglePlaneUnit unit)
        {
            return new MutableFloatAnglePlaneVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel get(final int index) throws ValueException
        {
            return new FloatAnglePlane.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatAnglePlane vector.
         */
        public final MutableFloatAnglePlaneVector.Abs toAbs()
        {
            return new MutableFloatAnglePlaneVector.Abs(getData(), getUnit());
        }

    }

}
