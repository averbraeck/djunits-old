package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AnglePlane;

/**
 * Immutable AnglePlane Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AnglePlaneVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AnglePlaneVector.
     */
    class Abs
        extends
        TypedDoubleVectorAbs<AnglePlaneUnit, AnglePlaneVector.Abs, AnglePlaneVector.Rel, MutableAnglePlaneVector.Abs, AnglePlane.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param values double[]; the values of the entries in the new Absolute Immutable Double AnglePlaneVector
         * @param unit U; the unit of the new Absolute Immutable Double AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final AnglePlaneUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double AnglePlaneVector
         * @param unit U; the unit of the new Absolute Immutable Double AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final AnglePlaneUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double
         *            AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final AnglePlane.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<AnglePlane.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            AnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, AnglePlane.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double AnglePlaneVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double AnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final AnglePlaneUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlaneVector.Abs instantiateTypeAbs(final DoubleVectorData dvd, final AnglePlaneUnit unit)
        {
            return new AnglePlaneVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlaneVector.Rel instantiateTypeRel(final DoubleVectorData dvd, final AnglePlaneUnit unit)
        {
            return new AnglePlaneVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAnglePlaneVector.Abs instantiateMutableType(final DoubleVectorData dvd,
            final AnglePlaneUnit unit)
        {
            return new MutableAnglePlaneVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs get(final int index) throws ValueException
        {
            return new AnglePlane.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute AnglePlane vector.
         */
        public final AnglePlaneVector.Rel toRel()
        {
            return new AnglePlaneVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AnglePlaneVector.
     */
    class Rel extends
        TypedDoubleVectorRel<AnglePlaneUnit, AnglePlaneVector.Rel, MutableAnglePlaneVector.Rel, AnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param values double[]; the values of the entries in the new Relative Immutable Double AnglePlaneVector
         * @param unit U; the unit of the new Relative Immutable Double AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final AnglePlaneUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param values List; the values of the entries in the new Relative Immutable Double AnglePlaneVector
         * @param unit U; the unit of the new Relative Immutable Double AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final AnglePlaneUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
         *            AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final AnglePlane.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param values List; the values of the entries in the new Relative Immutable Double AnglePlaneVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<AnglePlane.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            AnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, AnglePlane.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AnglePlaneVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double AnglePlaneVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final AnglePlaneUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlaneVector.Rel instantiateType(final DoubleVectorData dvd, final AnglePlaneUnit unit)
        {
            return new AnglePlaneVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAnglePlaneVector.Rel instantiateMutableType(final DoubleVectorData dvd,
            final AnglePlaneUnit unit)
        {
            return new MutableAnglePlaneVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel get(final int index) throws ValueException
        {
            return new AnglePlane.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative AnglePlane vector.
         */
        public final AnglePlaneVector.Abs toAbs()
        {
            return new AnglePlaneVector.Abs(getData(), getUnit());
        }

    }

}
