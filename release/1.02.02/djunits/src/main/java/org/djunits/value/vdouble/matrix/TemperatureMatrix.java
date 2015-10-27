package org.djunits.value.vdouble.matrix;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Temperature;

/**
 * Immutable Temperature Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface TemperatureMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of TemperatureMatrix.
     */
    class Abs
        extends
        TypedDoubleMatrixAbs<TemperatureUnit, TemperatureMatrix.Abs, TemperatureMatrix.Rel, MutableTemperatureMatrix.Abs, Temperature.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double TemperatureMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable Double TemperatureMatrix
         * @param unit U; the unit of the new Absolute Immutable Double TemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double TemperatureMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
         *            TemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Temperature.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double TemperatureMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TemperatureMatrix.Abs
            instantiateTypeAbs(final DoubleMatrixData dmd, final TemperatureUnit unit)
        {
            return new TemperatureMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TemperatureMatrix.Rel
            instantiateTypeRel(final DoubleMatrixData dmd, final TemperatureUnit unit)
        {
            return new TemperatureMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTemperatureMatrix.Abs instantiateMutableType(final DoubleMatrixData dmd,
            final TemperatureUnit unit)
        {
            return new MutableTemperatureMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Abs get(final int row, final int column) throws ValueException
        {
            return new Temperature.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Temperature matrix.
         */
        public final TemperatureMatrix.Rel toRel()
        {
            return new TemperatureMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of TemperatureMatrix.
     */
    class Rel extends
        TypedDoubleMatrixRel<TemperatureUnit, TemperatureMatrix.Rel, MutableTemperatureMatrix.Rel, Temperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double TemperatureMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable Double TemperatureMatrix
         * @param unit U; the unit of the new Relative Immutable Double TemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double TemperatureMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
         *            TemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Temperature.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double TemperatureMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final TemperatureMatrix.Rel instantiateType(final DoubleMatrixData dmd, final TemperatureUnit unit)
        {
            return new TemperatureMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableTemperatureMatrix.Rel instantiateMutableType(final DoubleMatrixData dmd,
            final TemperatureUnit unit)
        {
            return new MutableTemperatureMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Temperature.Rel get(final int row, final int column) throws ValueException
        {
            return new Temperature.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Temperature matrix.
         */
        public final TemperatureMatrix.Abs toAbs()
        {
            return new TemperatureMatrix.Abs(getData(), getUnit());
        }

    }

}
