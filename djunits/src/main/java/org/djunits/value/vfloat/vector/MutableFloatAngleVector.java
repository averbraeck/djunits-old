package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngle;

/**
 * Mutable FloatAngle Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatAngleVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatAngleVector.
     */
    class Abs
        extends
        MutableTypedFloatVectorAbs<AngleUnit, FloatAngleVector.Abs, FloatAngleVector.Rel, MutableFloatAngleVector.Abs, FloatAngle.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param values float[]; the values of the entries in the new Absolute Mutable FloatAngleVector
         * @param unit U; the unit of the new Absolute Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatAngleVector
         * @param unit U; the unit of the new Absolute Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatAngle.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param values List; the values of the entries in the new Absolute Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<FloatAngle.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
         *            FloatAngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, FloatAngle.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatAngleVector
         * @param unit U; the unit of the new Absolute Sparse Mutable FloatAngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleVector.Abs instantiateTypeAbs(final FloatVectorData dvd, final AngleUnit unit)
        {
            return new FloatAngleVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleVector.Rel instantiateTypeRel(final FloatVectorData dvd, final AngleUnit unit)
        {
            return new FloatAngleVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleVector.Abs instantiateMutableType(final FloatVectorData dvd,
            final AngleUnit unit)
        {
            return new MutableFloatAngleVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngle.Abs get(final int index) throws ValueException
        {
            return new FloatAngle.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatAngle vector.
         */
        public final MutableFloatAngleVector.Rel toRel()
        {
            return new MutableFloatAngleVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatAngleVector.
     */
    class Rel extends
        MutableTypedFloatVectorRel<AngleUnit, FloatAngleVector.Rel, MutableFloatAngleVector.Rel, FloatAngle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param values float[]; the values of the entries in the new Relative Mutable FloatAngleVector
         * @param unit U; the unit of the new Relative Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatAngleVector
         * @param unit U; the unit of the new Relative Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatAngle.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param values List; the values of the entries in the new Relative Mutable FloatAngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<FloatAngle.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
         *            FloatAngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, FloatAngle.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatAngleVector
         * @param unit U; the unit of the new Relative Sparse Mutable FloatAngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleVector.Rel instantiateType(final FloatVectorData dvd, final AngleUnit unit)
        {
            return new FloatAngleVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleVector.Rel instantiateMutableType(final FloatVectorData dvd,
            final AngleUnit unit)
        {
            return new MutableFloatAngleVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngle.Rel get(final int index) throws ValueException
        {
            return new FloatAngle.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatAngle vector.
         */
        public final MutableFloatAngleVector.Abs toAbs()
        {
            return new MutableFloatAngleVector.Abs(getData(), getUnit());
        }

    }

}
