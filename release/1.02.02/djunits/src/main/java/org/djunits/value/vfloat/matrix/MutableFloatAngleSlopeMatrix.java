package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngleSlope;

/**
 * Mutable FloatAngleSlope Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatAngleSlopeMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatAngleSlopeMatrix.
     */
    class Abs
        extends
        MutableTypedFloatMatrixAbs<AngleSlopeUnit, FloatAngleSlopeMatrix.Abs, FloatAngleSlopeMatrix.Rel, MutableFloatAngleSlopeMatrix.Abs, FloatAngleSlope.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Mutable FloatAngleSlopeMatrix
         * @param unit U; the unit of the new Absolute Mutable FloatAngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable
         *            FloatAngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatAngleSlope.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleSlopeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlopeMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd,
            final AngleSlopeUnit unit)
        {
            return new FloatAngleSlopeMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlopeMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd,
            final AngleSlopeUnit unit)
        {
            return new FloatAngleSlopeMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleSlopeMatrix.Abs instantiateMutableType(final FloatMatrixData fmd,
            final AngleSlopeUnit unit)
        {
            return new MutableFloatAngleSlopeMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatAngleSlope.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatAngleSlope matrix.
         */
        public final MutableFloatAngleSlopeMatrix.Rel toRel()
        {
            return new MutableFloatAngleSlopeMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatAngleSlopeMatrix.
     */
    class Rel
        extends
        MutableTypedFloatMatrixRel<AngleSlopeUnit, FloatAngleSlopeMatrix.Rel, MutableFloatAngleSlopeMatrix.Rel, FloatAngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatAngleSlopeMatrix.
         * @param values float[][]; the values of the entries in the new Relative Mutable FloatAngleSlopeMatrix
         * @param unit U; the unit of the new Relative Mutable FloatAngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable
         *            FloatAngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatAngleSlope.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleSlopeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlopeMatrix.Rel instantiateType(final FloatMatrixData fmd, final AngleSlopeUnit unit)
        {
            return new FloatAngleSlopeMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleSlopeMatrix.Rel instantiateMutableType(final FloatMatrixData fmd,
            final AngleSlopeUnit unit)
        {
            return new MutableFloatAngleSlopeMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngleSlope.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatAngleSlope.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatAngleSlope matrix.
         */
        public final MutableFloatAngleSlopeMatrix.Abs toAbs()
        {
            return new MutableFloatAngleSlopeMatrix.Abs(getData(), getUnit());
        }

    }

}
