package org.djunits.value.vdouble.matrix;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Dimensionless;

/**
 * Immutable Dimensionless Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface DimensionlessMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of DimensionlessMatrix.
     */
    class Abs
        extends
        TypedDoubleMatrixAbs<DimensionlessUnit, DimensionlessMatrix.Abs, DimensionlessMatrix.Rel, MutableDimensionlessMatrix.Abs, Dimensionless.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double DimensionlessMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable Double DimensionlessMatrix
         * @param unit U; the unit of the new Absolute Immutable Double DimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
         *            DimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Dimensionless.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double DimensionlessMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DimensionlessMatrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd,
            final DimensionlessUnit unit)
        {
            return new DimensionlessMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DimensionlessMatrix.Rel instantiateTypeRel(final DoubleMatrixData dmd,
            final DimensionlessUnit unit)
        {
            return new DimensionlessMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDimensionlessMatrix.Abs instantiateMutableType(final DoubleMatrixData dmd,
            final DimensionlessUnit unit)
        {
            return new MutableDimensionlessMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Abs get(final int row, final int column) throws ValueException
        {
            return new Dimensionless.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Dimensionless matrix.
         */
        public final DimensionlessMatrix.Rel toRel()
        {
            return new DimensionlessMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of DimensionlessMatrix.
     */
    class Rel
        extends
        TypedDoubleMatrixRel<DimensionlessUnit, DimensionlessMatrix.Rel, MutableDimensionlessMatrix.Rel, Dimensionless.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double DimensionlessMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable Double DimensionlessMatrix
         * @param unit U; the unit of the new Relative Immutable Double DimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
         *            DimensionlessMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Dimensionless.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double DimensionlessMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final DimensionlessUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DimensionlessMatrix.Rel
            instantiateType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
        {
            return new DimensionlessMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDimensionlessMatrix.Rel instantiateMutableType(final DoubleMatrixData dmd,
            final DimensionlessUnit unit)
        {
            return new MutableDimensionlessMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Dimensionless.Rel get(final int row, final int column) throws ValueException
        {
            return new Dimensionless.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Dimensionless matrix.
         */
        public final DimensionlessMatrix.Abs toAbs()
        {
            return new DimensionlessMatrix.Abs(getData(), getUnit());
        }

    }

}
