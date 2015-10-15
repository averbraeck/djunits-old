package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Temperature;

/**
 * Mutable Temperature Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableTemperatureVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TemperatureVector.
     */
    class Abs
        extends
        MutableTypedDoubleVectorAbs<TemperatureUnit, TemperatureVector.Abs, TemperatureVector.Rel, MutableTemperatureVector.Abs, Temperature.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param values double[]; the values of the entries in the new Absolute Mutable Double TemperatureVector
         * @param unit U; the unit of the new Absolute Mutable Double TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final TemperatureUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param values List; the values of the entries in the new Absolute Mutable Double TemperatureVector
         * @param unit U; the unit of the new Absolute Mutable Double TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Double
         *            TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Temperature.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param values List; the values of the entries in the new Absolute Mutable Double TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<Temperature.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            TemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, Temperature.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double TemperatureVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double TemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double TemperatureVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TemperatureVector.Abs
            instantiateTypeAbs(final DoubleVectorData dvd, final TemperatureUnit unit)
        {
            return new TemperatureVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TemperatureVector.Rel
            instantiateTypeRel(final DoubleVectorData dvd, final TemperatureUnit unit)
        {
            return new TemperatureVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTemperatureVector.Abs instantiateMutableType(final DoubleVectorData dvd,
            final TemperatureUnit unit)
        {
            return new MutableTemperatureVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs get(final int index) throws ValueException
        {
            return new Temperature.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Temperature vector.
         */
        public final MutableTemperatureVector.Rel toRel()
        {
            return new MutableTemperatureVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TemperatureVector.
     */
    class Rel
        extends
        MutableTypedDoubleVectorRel<TemperatureUnit, TemperatureVector.Rel, MutableTemperatureVector.Rel, Temperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param values double[]; the values of the entries in the new Relative Mutable Double TemperatureVector
         * @param unit U; the unit of the new Relative Mutable Double TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final TemperatureUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param values List; the values of the entries in the new Relative Mutable Double TemperatureVector
         * @param unit U; the unit of the new Relative Mutable Double TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable Double
         *            TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Temperature.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param values List; the values of the entries in the new Relative Mutable Double TemperatureVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<Temperature.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            TemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, Temperature.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double TemperatureVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double TemperatureVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable Double TemperatureVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TemperatureVector.Rel instantiateType(final DoubleVectorData dvd, final TemperatureUnit unit)
        {
            return new TemperatureVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTemperatureVector.Rel instantiateMutableType(final DoubleVectorData dvd,
            final TemperatureUnit unit)
        {
            return new MutableTemperatureVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel get(final int index) throws ValueException
        {
            return new Temperature.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Temperature vector.
         */
        public final MutableTemperatureVector.Abs toAbs()
        {
            return new MutableTemperatureVector.Abs(getData(), getUnit());
        }

    }

}
