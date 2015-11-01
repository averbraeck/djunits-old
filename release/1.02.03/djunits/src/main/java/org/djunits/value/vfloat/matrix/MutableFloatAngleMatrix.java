package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngle;

/**
 * Mutable FloatAngle Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatAngleMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatAngleMatrix.
     */
    class Abs
        extends
        MutableTypedFloatMatrixAbs<AngleUnit, FloatAngleMatrix.Abs, FloatAngleMatrix.Rel, MutableFloatAngleMatrix.Abs, FloatAngle.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatAngleMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Mutable FloatAngleMatrix
         * @param unit U; the unit of the new Absolute Mutable FloatAngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable FloatAngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatAngle.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAngleMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd, final AngleUnit unit)
        {
            return new FloatAngleMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd, final AngleUnit unit)
        {
            return new FloatAngleMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleMatrix.Abs instantiateMutableType(final FloatMatrixData fmd,
            final AngleUnit unit)
        {
            return new MutableFloatAngleMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngle.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatAngle.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatAngle matrix.
         */
        public final MutableFloatAngleMatrix.Rel toRel()
        {
            return new MutableFloatAngleMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatAngleMatrix.
     */
    class Rel extends
        MutableTypedFloatMatrixRel<AngleUnit, FloatAngleMatrix.Rel, MutableFloatAngleMatrix.Rel, FloatAngle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatAngleMatrix.
         * @param values float[][]; the values of the entries in the new Relative Mutable FloatAngleMatrix
         * @param unit U; the unit of the new Relative Mutable FloatAngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable FloatAngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatAngle.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAngleMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleMatrix.Rel instantiateType(final FloatMatrixData fmd, final AngleUnit unit)
        {
            return new FloatAngleMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAngleMatrix.Rel instantiateMutableType(final FloatMatrixData fmd,
            final AngleUnit unit)
        {
            return new MutableFloatAngleMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAngle.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatAngle.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatAngle matrix.
         */
        public final MutableFloatAngleMatrix.Abs toAbs()
        {
            return new MutableFloatAngleMatrix.Abs(getData(), getUnit());
        }

    }

}
