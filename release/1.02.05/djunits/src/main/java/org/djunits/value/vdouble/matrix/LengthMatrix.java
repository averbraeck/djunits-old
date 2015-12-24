package org.djunits.value.vdouble.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Length;

/**
 * Immutable Length Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface LengthMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of LengthMatrix.
     */
    class Abs extends
        TypedDoubleMatrixAbs<LengthUnit, LengthMatrix.Abs, LengthMatrix.Rel, MutableLengthMatrix.Abs, Length.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double LengthMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable Double LengthMatrix
         * @param unit U; the unit of the new Absolute Immutable Double LengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final LengthUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
         *            LengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Length.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double LengthMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final LengthMatrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd, final LengthUnit unit)
        {
            return new LengthMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final LengthMatrix.Rel instantiateTypeRel(final DoubleMatrixData dmd, final LengthUnit unit)
        {
            return new LengthMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableLengthMatrix.Abs
            instantiateMutableType(final DoubleMatrixData dmd, final LengthUnit unit)
        {
            return new MutableLengthMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Abs get(final int row, final int column) throws ValueException
        {
            return new Length.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Length matrix.
         */
        public final LengthMatrix.Rel toRel()
        {
            return new LengthMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of LengthMatrix.
     */
    class Rel extends TypedDoubleMatrixRel<LengthUnit, LengthMatrix.Rel, MutableLengthMatrix.Rel, Length.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double LengthMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable Double LengthMatrix
         * @param unit U; the unit of the new Relative Immutable Double LengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final LengthUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double LengthMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
         *            LengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Length.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double LengthMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final LengthMatrix.Rel instantiateType(final DoubleMatrixData dmd, final LengthUnit unit)
        {
            return new LengthMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableLengthMatrix.Rel
            instantiateMutableType(final DoubleMatrixData dmd, final LengthUnit unit)
        {
            return new MutableLengthMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Length.Rel get(final int row, final int column) throws ValueException
        {
            return new Length.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Length matrix.
         */
        public final LengthMatrix.Abs toAbs()
        {
            return new LengthMatrix.Abs(getData(), getUnit());
        }

    }

}
