package org.djunits.value.vdouble.matrix;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Time;

/**
 * Immutable Time Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface TimeMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TimeMatrix.
     */
    class Abs extends TypedDoubleMatrixAbs<TimeUnit, TimeMatrix.Abs, TimeMatrix.Rel, MutableTimeMatrix.Abs, Time.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double TimeMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable Double TimeMatrix
         * @param unit U; the unit of the new Absolute Immutable Double TimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
         *            TimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Time.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double TimeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TimeMatrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd, final TimeUnit unit)
        {
            return new TimeMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TimeMatrix.Rel instantiateTypeRel(final DoubleMatrixData dmd, final TimeUnit unit)
        {
            return new TimeMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTimeMatrix.Abs instantiateMutableType(final DoubleMatrixData dmd, final TimeUnit unit)
        {
            return new MutableTimeMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Abs get(final int row, final int column) throws ValueException
        {
            return new Time.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Time matrix.
         */
        public final TimeMatrix.Rel toRel()
        {
            return new TimeMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TimeMatrix.
     */
    class Rel extends TypedDoubleMatrixRel<TimeUnit, TimeMatrix.Rel, MutableTimeMatrix.Rel, Time.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double TimeMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable Double TimeMatrix
         * @param unit U; the unit of the new Relative Immutable Double TimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double TimeMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
         *            TimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Time.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double TimeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TimeMatrix.Rel instantiateType(final DoubleMatrixData dmd, final TimeUnit unit)
        {
            return new TimeMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTimeMatrix.Rel instantiateMutableType(final DoubleMatrixData dmd, final TimeUnit unit)
        {
            return new MutableTimeMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Time.Rel get(final int row, final int column) throws ValueException
        {
            return new Time.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Time matrix.
         */
        public final TimeMatrix.Abs toAbs()
        {
            return new TimeMatrix.Abs(getData(), getUnit());
        }

    }

}
