package org.djunits.value.vdouble.matrix;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AnglePlane;

/**
 * Immutable AnglePlane Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AnglePlaneMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AnglePlaneMatrix.
     */
    class Abs
        extends
        TypedDoubleMatrixAbs<AnglePlaneUnit, AnglePlaneMatrix.Abs, AnglePlaneMatrix.Rel, MutableAnglePlaneMatrix.Abs, AnglePlane.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double AnglePlaneMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable Double AnglePlaneMatrix
         * @param unit U; the unit of the new Absolute Immutable Double AnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
         *            AnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final AnglePlane.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double AnglePlaneMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlaneMatrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd, final AnglePlaneUnit unit)
        {
            return new AnglePlaneMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlaneMatrix.Rel instantiateTypeRel(final DoubleMatrixData dmd, final AnglePlaneUnit unit)
        {
            return new AnglePlaneMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAnglePlaneMatrix.Abs instantiateMutableType(final DoubleMatrixData dmd,
            final AnglePlaneUnit unit)
        {
            return new MutableAnglePlaneMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs get(final int row, final int column) throws ValueException
        {
            return new AnglePlane.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute AnglePlane matrix.
         */
        public final AnglePlaneMatrix.Rel toRel()
        {
            return new AnglePlaneMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AnglePlaneMatrix.
     */
    class Rel extends
        TypedDoubleMatrixRel<AnglePlaneUnit, AnglePlaneMatrix.Rel, MutableAnglePlaneMatrix.Rel, AnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double AnglePlaneMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable Double AnglePlaneMatrix
         * @param unit U; the unit of the new Relative Immutable Double AnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final AnglePlaneUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
         *            AnglePlaneMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final AnglePlane.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double AnglePlaneMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final AnglePlaneUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlaneMatrix.Rel instantiateType(final DoubleMatrixData dmd, final AnglePlaneUnit unit)
        {
            return new AnglePlaneMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAnglePlaneMatrix.Rel instantiateMutableType(final DoubleMatrixData dmd,
            final AnglePlaneUnit unit)
        {
            return new MutableAnglePlaneMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel get(final int row, final int column) throws ValueException
        {
            return new AnglePlane.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative AnglePlane matrix.
         */
        public final AnglePlaneMatrix.Abs toAbs()
        {
            return new AnglePlaneMatrix.Abs(getData(), getUnit());
        }

    }

}
