package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.DataType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Time;

/**
 * Immutable Time Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface TimeVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TimeVector.
     */
    class Abs extends TypedDoubleVectorAbs<TimeUnit, TimeVector.Abs, TimeVector.Rel, MutableTimeVector.Abs, Time.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param values double[]; the values of the entries in the new Absolute Immutable Double TimeVector
         * @param unit U; the unit of the new Absolute Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final TimeUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double TimeVector
         * @param unit U; the unit of the new Absolute Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final TimeUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Time.Abs[] values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<Time.Abs> values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            TimeVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, Time.Abs> values, final int length, final DataType dataType)
            throws ValueException
        {
            super(values, length, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double TimeVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double TimeVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final TimeUnit unit, final int length,
            final DataType dataType) throws ValueException
        {
            super(values, unit, length, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TimeVector.Abs instantiateTypeAbs(final DoubleVectorData dvd, final TimeUnit unit)
        {
            return new TimeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TimeVector.Rel instantiateTypeRel(final DoubleVectorData dvd, final TimeUnit unit)
        {
            return new TimeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTimeVector.Abs instantiateMutableType(final DoubleVectorData dvd, final TimeUnit unit)
        {
            return new MutableTimeVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs get(final int index) throws ValueException
        {
            return new Time.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Time vector.
         */
        public final TimeVector.Rel toRel()
        {
            return new TimeVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TimeVector.
     */
    class Rel extends TypedDoubleVectorRel<TimeUnit, TimeVector.Rel, MutableTimeVector.Rel, Time.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param values double[]; the values of the entries in the new Relative Immutable Double TimeVector
         * @param unit U; the unit of the new Relative Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final TimeUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param values List; the values of the entries in the new Relative Immutable Double TimeVector
         * @param unit U; the unit of the new Relative Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final TimeUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Time.Rel[] values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param values List; the values of the entries in the new Relative Immutable Double TimeVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<Time.Rel> values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            TimeVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, Time.Rel> values, final int length, final DataType dataType)
            throws ValueException
        {
            super(values, length, dataType);
        }

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double TimeVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double TimeVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final TimeUnit unit, final int length,
            final DataType dataType) throws ValueException
        {
            super(values, unit, length, dataType);
        }

        /**
         * Construct a new Relative Immutable Double TimeVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TimeVector.Rel instantiateType(final DoubleVectorData dvd, final TimeUnit unit)
        {
            return new TimeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTimeVector.Rel instantiateMutableType(final DoubleVectorData dvd, final TimeUnit unit)
        {
            return new MutableTimeVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel get(final int index) throws ValueException
        {
            return new Time.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Time vector.
         */
        public final TimeVector.Abs toAbs()
        {
            return new TimeVector.Abs(getData(), getUnit());
        }

    }

}
