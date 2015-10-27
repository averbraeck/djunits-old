package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAnglePlane;

/**
 * Mutable FloatAnglePlane Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatAnglePlaneMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatAnglePlaneMatrix.
     */
    class Abs
        extends
        MutableTypedFloatMatrixAbs<AnglePlaneUnit, FloatAnglePlaneMatrix.Abs, FloatAnglePlaneMatrix.Rel, MutableFloatAnglePlaneMatrix.Abs, FloatAnglePlane.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Mutable FloatAnglePlaneMatrix
         * @param unit U; the unit of the new Absolute Mutable FloatAnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable
         *            FloatAnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatAnglePlane.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatAnglePlaneMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlaneMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd,
            final AnglePlaneUnit unit)
        {
            return new FloatAnglePlaneMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlaneMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd,
            final AnglePlaneUnit unit)
        {
            return new FloatAnglePlaneMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAnglePlaneMatrix.Abs instantiateMutableType(final FloatMatrixData fmd,
            final AnglePlaneUnit unit)
        {
            return new MutableFloatAnglePlaneMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatAnglePlane.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatAnglePlane matrix.
         */
        public final MutableFloatAnglePlaneMatrix.Rel toRel()
        {
            return new MutableFloatAnglePlaneMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatAnglePlaneMatrix.
     */
    class Rel
        extends
        MutableTypedFloatMatrixRel<AnglePlaneUnit, FloatAnglePlaneMatrix.Rel, MutableFloatAnglePlaneMatrix.Rel, FloatAnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatAnglePlaneMatrix.
         * @param values float[][]; the values of the entries in the new Relative Mutable FloatAnglePlaneMatrix
         * @param unit U; the unit of the new Relative Mutable FloatAnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable
         *            FloatAnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatAnglePlane.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatAnglePlaneMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlaneMatrix.Rel instantiateType(final FloatMatrixData fmd, final AnglePlaneUnit unit)
        {
            return new FloatAnglePlaneMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatAnglePlaneMatrix.Rel instantiateMutableType(final FloatMatrixData fmd,
            final AnglePlaneUnit unit)
        {
            return new MutableFloatAnglePlaneMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAnglePlane.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatAnglePlane.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatAnglePlane matrix.
         */
        public final MutableFloatAnglePlaneMatrix.Abs toAbs()
        {
            return new MutableFloatAnglePlaneMatrix.Abs(getData(), getUnit());
        }

    }

}
