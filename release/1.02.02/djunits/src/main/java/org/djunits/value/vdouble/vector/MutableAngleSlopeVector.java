package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AngleSlope;

/**
 * Mutable AngleSlope Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableAngleSlopeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AngleSlopeVector.
     */
    class Abs
        extends
        MutableTypedDoubleVectorAbs<AngleSlopeUnit, AngleSlopeVector.Abs, AngleSlopeVector.Rel, MutableAngleSlopeVector.Abs, AngleSlope.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param values double[]; the values of the entries in the new Absolute Mutable Double AngleSlopeVector
         * @param unit U; the unit of the new Absolute Mutable Double AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final AngleSlopeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param values List; the values of the entries in the new Absolute Mutable Double AngleSlopeVector
         * @param unit U; the unit of the new Absolute Mutable Double AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final AngleSlopeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Double
         *            AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final AngleSlope.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param values List; the values of the entries in the new Absolute Mutable Double AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<AngleSlope.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            AngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, AngleSlope.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double AngleSlopeVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double AngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final AngleSlopeUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlopeVector.Abs instantiateTypeAbs(final DoubleVectorData dvd, final AngleSlopeUnit unit)
        {
            return new AngleSlopeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlopeVector.Rel instantiateTypeRel(final DoubleVectorData dvd, final AngleSlopeUnit unit)
        {
            return new AngleSlopeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleSlopeVector.Abs instantiateMutableType(final DoubleVectorData dvd,
            final AngleSlopeUnit unit)
        {
            return new MutableAngleSlopeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs get(final int index) throws ValueException
        {
            return new AngleSlope.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute AngleSlope vector.
         */
        public final MutableAngleSlopeVector.Rel toRel()
        {
            return new MutableAngleSlopeVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AngleSlopeVector.
     */
    class Rel extends
        MutableTypedDoubleVectorRel<AngleSlopeUnit, AngleSlopeVector.Rel, MutableAngleSlopeVector.Rel, AngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param values double[]; the values of the entries in the new Relative Mutable Double AngleSlopeVector
         * @param unit U; the unit of the new Relative Mutable Double AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final AngleSlopeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param values List; the values of the entries in the new Relative Mutable Double AngleSlopeVector
         * @param unit U; the unit of the new Relative Mutable Double AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final AngleSlopeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable Double
         *            AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final AngleSlope.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param values List; the values of the entries in the new Relative Mutable Double AngleSlopeVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<AngleSlope.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            AngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, AngleSlope.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AngleSlopeVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double AngleSlopeVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final AngleSlopeUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlopeVector.Rel instantiateType(final DoubleVectorData dvd, final AngleSlopeUnit unit)
        {
            return new AngleSlopeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleSlopeVector.Rel instantiateMutableType(final DoubleVectorData dvd,
            final AngleSlopeUnit unit)
        {
            return new MutableAngleSlopeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel get(final int index) throws ValueException
        {
            return new AngleSlope.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative AngleSlope vector.
         */
        public final MutableAngleSlopeVector.Abs toAbs()
        {
            return new MutableAngleSlopeVector.Abs(getData(), getUnit());
        }

    }

}
