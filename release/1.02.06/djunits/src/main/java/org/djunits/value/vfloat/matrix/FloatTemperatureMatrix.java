package org.djunits.value.vfloat.matrix;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTemperature;

/**
 * Immutable FloatTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatTemperatureMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatTemperatureMatrix.
     */
    class Abs
        extends
        TypedFloatMatrixAbs<TemperatureUnit, FloatTemperatureMatrix.Abs, FloatTemperatureMatrix.Rel, MutableFloatTemperatureMatrix.Abs, FloatTemperature.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatTemperatureMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Immutable FloatTemperatureMatrix
         * @param unit U; the unit of the new Absolute Immutable FloatTemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable
         *            FloatTemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatTemperature.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTemperatureMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperatureMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd,
            final TemperatureUnit unit)
        {
            return new FloatTemperatureMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperatureMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd,
            final TemperatureUnit unit)
        {
            return new FloatTemperatureMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTemperatureMatrix.Abs instantiateMutableType(final FloatMatrixData fmd,
            final TemperatureUnit unit)
        {
            return new MutableFloatTemperatureMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatTemperature.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatTemperature matrix.
         */
        public final FloatTemperatureMatrix.Rel toRel()
        {
            return new FloatTemperatureMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatTemperatureMatrix.
     */
    class Rel
        extends
        TypedFloatMatrixRel<TemperatureUnit, FloatTemperatureMatrix.Rel, MutableFloatTemperatureMatrix.Rel, FloatTemperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable FloatTemperatureMatrix.
         * @param values float[][]; the values of the entries in the new Relative Immutable FloatTemperatureMatrix
         * @param unit U; the unit of the new Relative Immutable FloatTemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable
         *            FloatTemperatureMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatTemperature.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTemperatureMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final TemperatureUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperatureMatrix.Rel
            instantiateType(final FloatMatrixData fmd, final TemperatureUnit unit)
        {
            return new FloatTemperatureMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTemperatureMatrix.Rel instantiateMutableType(final FloatMatrixData fmd,
            final TemperatureUnit unit)
        {
            return new MutableFloatTemperatureMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTemperature.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatTemperature.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatTemperature matrix.
         */
        public final FloatTemperatureMatrix.Abs toAbs()
        {
            return new FloatTemperatureMatrix.Abs(getData(), getUnit());
        }

    }

}
