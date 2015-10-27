package org.djunits.value.vdouble.matrix;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Angle;

/**
 * Mutable Angle Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableAngleMatrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AngleMatrix.
     */
    class Abs extends
        MutableTypedDoubleMatrixAbs<AngleUnit, AngleMatrix.Abs, AngleMatrix.Rel, MutableAngleMatrix.Abs, Angle.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable Double AngleMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Mutable Double AngleMatrix
         * @param unit U; the unit of the new Absolute Mutable Double AngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable Double AngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Angle.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleMatrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd, final AngleUnit unit)
        {
            return new AngleMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleMatrix.Rel instantiateTypeRel(final DoubleMatrixData dmd, final AngleUnit unit)
        {
            return new AngleMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleMatrix.Abs instantiateMutableType(final DoubleMatrixData dmd, final AngleUnit unit)
        {
            return new MutableAngleMatrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Angle.Abs get(final int row, final int column) throws ValueException
        {
            return new Angle.Abs(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Angle matrix.
         */
        public final MutableAngleMatrix.Rel toRel()
        {
            return new MutableAngleMatrix.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AngleMatrix.
     */
    class Rel extends MutableTypedDoubleMatrixRel<AngleUnit, AngleMatrix.Rel, MutableAngleMatrix.Rel, Angle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable Double AngleMatrix.
         * @param values double[][]; the values of the entries in the new Relative Mutable Double AngleMatrix
         * @param unit U; the unit of the new Relative Mutable Double AngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable Double AngleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Angle.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleMatrix.Rel instantiateType(final DoubleMatrixData dmd, final AngleUnit unit)
        {
            return new AngleMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleMatrix.Rel instantiateMutableType(final DoubleMatrixData dmd, final AngleUnit unit)
        {
            return new MutableAngleMatrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Angle.Rel get(final int row, final int column) throws ValueException
        {
            return new Angle.Rel(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Angle matrix.
         */
        public final MutableAngleMatrix.Abs toAbs()
        {
            return new MutableAngleMatrix.Abs(getData(), getUnit());
        }

    }

}
