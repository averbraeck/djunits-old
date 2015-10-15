package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Dimensionless;

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
public interface DimensionlessVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of DimensionlessVector.
     */
    class Abs
        extends
        TypedDoubleVectorAbs<DimensionlessUnit, DimensionlessVector.Abs, DimensionlessVector.Rel, MutableDimensionlessVector.Abs, Dimensionless.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param values double[]; the values of the entries in the new Absolute Immutable Double DimensionlessVector
         * @param unit U; the unit of the new Absolute Immutable Double DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final DimensionlessUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double DimensionlessVector
         * @param unit U; the unit of the new Absolute Immutable Double DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double
         *            DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Dimensionless.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<Dimensionless.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            DimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, Dimensionless.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double DimensionlessVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double DimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DimensionlessVector.Abs instantiateTypeAbs(final DoubleVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new DimensionlessVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DimensionlessVector.Rel instantiateTypeRel(final DoubleVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new DimensionlessVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDimensionlessVector.Abs instantiateMutableType(final DoubleVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new MutableDimensionlessVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs get(final int index) throws ValueException
        {
            return new Dimensionless.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Dimensionless vector.
         */
        public final DimensionlessVector.Rel toRel()
        {
            return new DimensionlessVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of DimensionlessVector.
     */
    class Rel
        extends
        TypedDoubleVectorRel<DimensionlessUnit, DimensionlessVector.Rel, MutableDimensionlessVector.Rel, Dimensionless.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param values double[]; the values of the entries in the new Relative Immutable Double DimensionlessVector
         * @param unit U; the unit of the new Relative Immutable Double DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final DimensionlessUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param values List; the values of the entries in the new Relative Immutable Double DimensionlessVector
         * @param unit U; the unit of the new Relative Immutable Double DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
         *            DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Dimensionless.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param values List; the values of the entries in the new Relative Immutable Double DimensionlessVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<Dimensionless.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            DimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, Dimensionless.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double DimensionlessVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double DimensionlessVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DimensionlessVector.Rel
            instantiateType(final DoubleVectorData dvd, final DimensionlessUnit unit)
        {
            return new DimensionlessVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDimensionlessVector.Rel instantiateMutableType(final DoubleVectorData dvd,
            final DimensionlessUnit unit)
        {
            return new MutableDimensionlessVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel get(final int index) throws ValueException
        {
            return new Dimensionless.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Dimensionless vector.
         */
        public final DimensionlessVector.Abs toAbs()
        {
            return new DimensionlessVector.Abs(getData(), getUnit());
        }

    }

}
