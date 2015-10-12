package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.value.DataType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Length;

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
public interface LengthVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of LengthVector.
     */
    class Abs extends
        TypedDoubleVectorAbs<LengthUnit, LengthVector.Abs, LengthVector.Rel, MutableLengthVector.Abs, Length.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param values double[]; the values of the entries in the new Absolute Immutable Double LengthVector
         * @param unit U; the unit of the new Absolute Immutable Double LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final LengthUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double LengthVector
         * @param unit U; the unit of the new Absolute Immutable Double LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final LengthUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double
         *            LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Length.Abs[] values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param values List; the values of the entries in the new Absolute Immutable Double LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<Length.Abs> values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            LengthVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, Length.Abs> values, final int length, final DataType dataType)
            throws ValueException
        {
            super(values, length, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double LengthVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double LengthVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final LengthUnit unit, final int length,
            final DataType dataType) throws ValueException
        {
            super(values, unit, length, dataType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final LengthVector.Abs instantiateTypeAbs(final DoubleVectorData dvd, final LengthUnit unit)
        {
            return new LengthVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final LengthVector.Rel instantiateTypeRel(final DoubleVectorData dvd, final LengthUnit unit)
        {
            return new LengthVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableLengthVector.Abs
            instantiateMutableType(final DoubleVectorData dvd, final LengthUnit unit)
        {
            return new MutableLengthVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs get(final int index) throws ValueException
        {
            return new Length.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Length vector.
         */
        public final LengthVector.Rel toRel()
        {
            return new LengthVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of LengthVector.
     */
    class Rel extends TypedDoubleVectorRel<LengthUnit, LengthVector.Rel, MutableLengthVector.Rel, Length.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param values double[]; the values of the entries in the new Relative Immutable Double LengthVector
         * @param unit U; the unit of the new Relative Immutable Double LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final LengthUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param values List; the values of the entries in the new Relative Immutable Double LengthVector
         * @param unit U; the unit of the new Relative Immutable Double LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final LengthUnit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
         *            LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Length.Rel[] values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param values List; the values of the entries in the new Relative Immutable Double LengthVector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<Length.Rel> values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            LengthVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, Length.Rel> values, final int length, final DataType dataType)
            throws ValueException
        {
            super(values, length, dataType);
        }

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double LengthVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double LengthVector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final LengthUnit unit, final int length,
            final DataType dataType) throws ValueException
        {
            super(values, unit, length, dataType);
        }

        /**
         * Construct a new Relative Immutable Double LengthVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final LengthVector.Rel instantiateType(final DoubleVectorData dvd, final LengthUnit unit)
        {
            return new LengthVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableLengthVector.Rel
            instantiateMutableType(final DoubleVectorData dvd, final LengthUnit unit)
        {
            return new MutableLengthVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel get(final int index) throws ValueException
        {
            return new Length.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Length vector.
         */
        public final LengthVector.Abs toAbs()
        {
            return new LengthVector.Abs(getData(), getUnit());
        }

    }

}
