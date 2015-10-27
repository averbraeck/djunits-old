package org.djunits.value.vdouble.matrix;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AngleSlope;

/**
 * Mutable AngleSlope Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableAngleSlopeMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AngleSlopeMatrix.
     */
    class Abs
        extends
        MutableTypedDoubleMatrixAbs<AngleSlopeUnit, AngleSlopeMatrix.Abs, AngleSlopeMatrix.Rel, MutableAngleSlopeMatrix.Abs, AngleSlope.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable Double AngleSlopeMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Mutable Double AngleSlopeMatrix
         * @param unit U; the unit of the new Absolute Mutable Double AngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable Double
         *            AngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final AngleSlope.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleSlopeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlopeMatrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd, final AngleSlopeUnit unit)
        {
            return new AngleSlopeMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlopeMatrix.Rel instantiateTypeRel(final DoubleMatrixData dmd, final AngleSlopeUnit unit)
        {
            return new AngleSlopeMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleSlopeMatrix.Abs instantiateMutableType(final DoubleMatrixData dmd,
            final AngleSlopeUnit unit)
        {
            return new MutableAngleSlopeMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Abs get(final int row, final int column) throws ValueException
        {
            return new AngleSlope.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute AngleSlope matrix.
         */
        public final MutableAngleSlopeMatrix.Rel toRel()
        {
            return new MutableAngleSlopeMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AngleSlopeMatrix.
     */
    class Rel extends
        MutableTypedDoubleMatrixRel<AngleSlopeUnit, AngleSlopeMatrix.Rel, MutableAngleSlopeMatrix.Rel, AngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable Double AngleSlopeMatrix.
         * @param values double[][]; the values of the entries in the new Relative Mutable Double AngleSlopeMatrix
         * @param unit U; the unit of the new Relative Mutable Double AngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final AngleSlopeUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable Double
         *            AngleSlopeMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final AngleSlope.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleSlopeMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final AngleSlopeUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlopeMatrix.Rel instantiateType(final DoubleMatrixData dmd, final AngleSlopeUnit unit)
        {
            return new AngleSlopeMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleSlopeMatrix.Rel instantiateMutableType(final DoubleMatrixData dmd,
            final AngleSlopeUnit unit)
        {
            return new MutableAngleSlopeMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSlope.Rel get(final int row, final int column) throws ValueException
        {
            return new AngleSlope.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative AngleSlope matrix.
         */
        public final MutableAngleSlopeMatrix.Abs toAbs()
        {
            return new MutableAngleSlopeMatrix.Abs(getData(), getUnit());
        }

    }

}
