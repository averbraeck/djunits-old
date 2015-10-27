package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngleSlope;

/**
 * Mutable FloatAngleSlope Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatAngleSlopeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatAngleSlopeVector.
     */
    class Abs
        extends
        MutableTypedFloatVectorAbs<AngleSlopeUnit, FloatAngleSlopeVector.Abs, FloatAngleSlopeVector.Rel, MutableFloatAngleSlopeVector.Abs, FloatAngleSlope.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param values float[]; the values of the entries in the new Absolute Mutable FloatAngleSlopeVector
         * @param unit U; the unit of the new Absolute Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatAngleSlopeVector
         * @param unit U; the unit of the new Absolute Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatAngleSlope.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatAngleSlope.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatAngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatAngleSlope.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatAngleSlopeVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatAngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final AngleSlopeUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlopeVector.Abs instantiateTypeAbs(final FloatVectorData dvd,
            final AngleSlopeUnit unit)
        {
            return new FloatAngleSlopeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlopeVector.Rel instantiateTypeRel(final FloatVectorData dvd,
            final AngleSlopeUnit unit)
        {
            return new FloatAngleSlopeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleSlopeVector.Abs instantiateMutableType(final FloatVectorData dvd,
            final AngleSlopeUnit unit)
        {
            return new MutableFloatAngleSlopeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs get(final int index) throws ValueException
        {
            return new FloatAngleSlope.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatAngleSlope vector.
         */
        public final MutableFloatAngleSlopeVector.Rel toRel()
        {
            return new MutableFloatAngleSlopeVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatAngleSlopeVector.
     */
    class Rel
        extends
        MutableTypedFloatVectorRel<AngleSlopeUnit, FloatAngleSlopeVector.Rel, MutableFloatAngleSlopeVector.Rel, FloatAngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param values float[]; the values of the entries in the new Relative Mutable FloatAngleSlopeVector
         * @param unit U; the unit of the new Relative Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatAngleSlopeVector
         * @param unit U; the unit of the new Relative Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatAngleSlope.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatAngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatAngleSlope.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatAngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatAngleSlope.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatAngleSlopeVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatAngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final AngleSlopeUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlopeVector.Rel instantiateType(final FloatVectorData dvd, final AngleSlopeUnit unit)
        {
            return new FloatAngleSlopeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleSlopeVector.Rel instantiateMutableType(final FloatVectorData dvd,
            final AngleSlopeUnit unit)
        {
            return new MutableFloatAngleSlopeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel get(final int index) throws ValueException
        {
            return new FloatAngleSlope.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatAngleSlope vector.
         */
        public final MutableFloatAngleSlopeVector.Abs toAbs()
        {
            return new MutableFloatAngleSlopeVector.Abs(getData(), getUnit());
        }

    }

}
