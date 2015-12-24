package org.djunits.value.vfloat.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLength;

/**
 * Mutable FloatLength Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableFloatLengthMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of FloatLengthMatrix.
     */
    class Abs
        extends
        MutableTypedFloatMatrixAbs<LengthUnit, FloatLengthMatrix.Abs, FloatLengthMatrix.Rel, MutableFloatLengthMatrix.Abs, FloatLength.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatLengthMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Mutable FloatLengthMatrix
         * @param unit U; the unit of the new Absolute Mutable FloatLengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final LengthUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatLengthMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable FloatLengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatLength.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatLengthMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLengthMatrix.Abs instantiateTypeAbs(final FloatMatrixData fmd, final LengthUnit unit)
        {
            return new FloatLengthMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLengthMatrix.Rel instantiateTypeRel(final FloatMatrixData fmd, final LengthUnit unit)
        {
            return new FloatLengthMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatLengthMatrix.Abs instantiateMutableType(final FloatMatrixData fmd,
            final LengthUnit unit)
        {
            return new MutableFloatLengthMatrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Abs get(final int row, final int column) throws ValueException
        {
            return new FloatLength.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute FloatLength matrix.
         */
        public final MutableFloatLengthMatrix.Rel toRel()
        {
            return new MutableFloatLengthMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of FloatLengthMatrix.
     */
    class Rel extends
        MutableTypedFloatMatrixRel<LengthUnit, FloatLengthMatrix.Rel, MutableFloatLengthMatrix.Rel, FloatLength.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable FloatLengthMatrix.
         * @param values float[][]; the values of the entries in the new Relative Mutable FloatLengthMatrix
         * @param unit U; the unit of the new Relative Mutable FloatLengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final LengthUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatLengthMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable FloatLengthMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatLength.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatLengthMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final LengthUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatLengthMatrix.Rel instantiateType(final FloatMatrixData fmd, final LengthUnit unit)
        {
            return new FloatLengthMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatLengthMatrix.Rel instantiateMutableType(final FloatMatrixData fmd,
            final LengthUnit unit)
        {
            return new MutableFloatLengthMatrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatLength.Rel get(final int row, final int column) throws ValueException
        {
            return new FloatLength.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative FloatLength matrix.
         */
        public final MutableFloatLengthMatrix.Abs toAbs()
        {
            return new MutableFloatLengthMatrix.Abs(getData(), getUnit());
        }

    }

}
