package org.djunits.value.vfloat.matrix;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTime;

/**
 * Immutable FloatTime Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatTimeMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatTimeMatrix.
     */
    class Abs
        extends
        TypedFloatMatrixAbs<TimeUnit, FloatTimeMatrix.Abs, FloatTimeMatrix.Rel, MutableFloatTimeMatrix.Abs, FloatTime.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatTimeMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Immutable FloatTimeMatrix
         * @param unit U; the unit of the new Absolute Immutable FloatTimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable FloatTimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatTime.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatTimeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTimeMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd, final TimeUnit unit)
        {
            return new FloatTimeMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTimeMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd, final TimeUnit unit)
        {
            return new FloatTimeMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTimeMatrix.Abs
            instantiateMutableType(final FloatMatrixData fmd, final TimeUnit unit)
        {
            return new MutableFloatTimeMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatTime.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatTime matrix.
         */
        public final FloatTimeMatrix.Rel toRel()
        {
            return new FloatTimeMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatTimeMatrix.
     */
    class Rel extends TypedFloatMatrixRel<TimeUnit, FloatTimeMatrix.Rel, MutableFloatTimeMatrix.Rel, FloatTime.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable FloatTimeMatrix.
         * @param values float[][]; the values of the entries in the new Relative Immutable FloatTimeMatrix
         * @param unit U; the unit of the new Relative Immutable FloatTimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable FloatTimeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatTime.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatTimeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final TimeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTimeMatrix.Rel instantiateType(final FloatMatrixData fmd, final TimeUnit unit)
        {
            return new FloatTimeMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatTimeMatrix.Rel
            instantiateMutableType(final FloatMatrixData fmd, final TimeUnit unit)
        {
            return new MutableFloatTimeMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatTime.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatTime.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatTime matrix.
         */
        public final FloatTimeMatrix.Abs toAbs()
        {
            return new FloatTimeMatrix.Abs(getData(), getUnit());
        }

    }

}
