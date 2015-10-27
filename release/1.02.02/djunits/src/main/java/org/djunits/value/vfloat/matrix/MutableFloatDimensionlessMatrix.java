package org.djunits.value.vfloat.matrix;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDimensionless;

/**
 * Mutable FloatDimensionless Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatDimensionlessMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatDimensionlessMatrix.
     */
    class Abs
        extends
        MutableTypedFloatMatrixAbs<DimensionlessUnit, FloatDimensionlessMatrix.Abs, FloatDimensionlessMatrix.Rel, MutableFloatDimensionlessMatrix.Abs, FloatDimensionless.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatDimensionlessMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Mutable FloatDimensionlessMatrix
         * @param unit U; the unit of the new Absolute Mutable FloatDimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatDimensionlessMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable
         *            FloatDimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatDimensionless.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatDimensionlessMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatDimensionlessMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd,
            final DimensionlessUnit unit)
        {
            return new FloatDimensionlessMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatDimensionlessMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd,
            final DimensionlessUnit unit)
        {
            return new FloatDimensionlessMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatDimensionlessMatrix.Abs instantiateMutableType(final FloatMatrixData fmd,
            final DimensionlessUnit unit)
        {
            return new MutableFloatDimensionlessMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatDimensionless.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatDimensionless matrix.
         */
        public final MutableFloatDimensionlessMatrix.Rel toRel()
        {
            return new MutableFloatDimensionlessMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatDimensionlessMatrix.
     */
    class Rel
        extends
        MutableTypedFloatMatrixRel<DimensionlessUnit, FloatDimensionlessMatrix.Rel, MutableFloatDimensionlessMatrix.Rel, FloatDimensionless.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatDimensionlessMatrix.
         * @param values float[][]; the values of the entries in the new Relative Mutable FloatDimensionlessMatrix
         * @param unit U; the unit of the new Relative Mutable FloatDimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatDimensionlessMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable
         *            FloatDimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatDimensionless.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatDimensionlessMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatDimensionlessMatrix.Rel instantiateType(final FloatMatrixData fmd,
            final DimensionlessUnit unit)
        {
            return new FloatDimensionlessMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatDimensionlessMatrix.Rel instantiateMutableType(final FloatMatrixData fmd,
            final DimensionlessUnit unit)
        {
            return new MutableFloatDimensionlessMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatDimensionless.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatDimensionless matrix.
         */
        public final MutableFloatDimensionlessMatrix.Abs toAbs()
        {
            return new MutableFloatDimensionlessMatrix.Abs(getData(), getUnit());
        }

    }

}
