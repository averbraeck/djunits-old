package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.DataType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Mutable %Type% Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Mutable%Type%Vector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of %Type%Vector.
     */
    class Abs
        extends
        MutableTypedDoubleVectorAbs<%Type%Unit, %Type%Vector.Abs, %Type%Vector.Rel, Mutable%Type%Vector.Abs, %Type%.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param values double[]; the values of the entries in the new Absolute Mutable Double %Type%Vector
         * @param unit U; the unit of the new Absolute Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final %Type%Unit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param values List; the values of the entries in the new Absolute Mutable Double %Type%Vector
         * @param unit U; the unit of the new Absolute Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final %Type%Unit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final %Type%.Abs[] values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param values List; the values of the entries in the new Absolute Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<%Type%.Abs> values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double %Type%Vector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, %Type%.Abs> values, final int length, final DataType dataType)
            throws ValueException
        {
            super(values, length, dataType);
        }

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double %Type%Vector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double %Type%Vector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int length,
            final DataType dataType) throws ValueException
        {
            super(values, unit, length, dataType);
        }

        /**
         * Construct a new Absolute Mutable Double %Type%Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%Vector.Abs instantiateTypeAbs(final DoubleVectorData dvd, final %Type%Unit unit)
        {
            return new %Type%Vector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%Vector.Rel instantiateTypeRel(final DoubleVectorData dvd, final %Type%Unit unit)
        {
            return new %Type%Vector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Mutable%Type%Vector.Abs
            instantiateMutableType(final DoubleVectorData dvd, final %Type%Unit unit)
        {
            return new Mutable%Type%Vector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs get(final int index) throws ValueException
        {
            return new %Type%.Abs(getInUnit(index, getUnit()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of %Type%Vector.
     */
    class Rel extends MutableTypedDoubleVectorRel<%Type%Unit, %Type%Vector.Rel, Mutable%Type%Vector.Rel, %Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param values double[]; the values of the entries in the new Relative Mutable Double %Type%Vector
         * @param unit U; the unit of the new Relative Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final %Type%Unit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param values List; the values of the entries in the new Relative Mutable Double %Type%Vector
         * @param unit U; the unit of the new Relative Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final %Type%Unit unit, final DataType dataType) throws ValueException
        {
            super(values, unit, dataType);
        }

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final %Type%.Rel[] values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param values List; the values of the entries in the new Relative Mutable Double %Type%Vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<%Type%.Rel> values, final DataType dataType) throws ValueException
        {
            super(values, dataType);
        }

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double %Type%Vector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, %Type%.Rel> values, final int length, final DataType dataType)
            throws ValueException
        {
            super(values, length, dataType);
        }

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double %Type%Vector
         * @param unit U; the unit of the new Relative Sparse Mutable Double %Type%Vector
         * @param length the size of the vector
         * @param dataType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int length,
            final DataType dataType) throws ValueException
        {
            super(values, unit, length, dataType);
        }

        /**
         * Construct a new Relative Mutable Double %Type%Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%Vector.Rel instantiateType(final DoubleVectorData dvd, final %Type%Unit unit)
        {
            return new %Type%Vector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Mutable%Type%Vector.Rel
            instantiateMutableType(final DoubleVectorData dvd, final %Type%Unit unit)
        {
            return new Mutable%Type%Vector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel get(final int index) throws ValueException
        {
            return new %Type%.Rel(getInUnit(index, getUnit()), getUnit());
        }
    }

}
