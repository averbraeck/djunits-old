package org.djunits.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Immutable Float%Type% Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Float%Type%Matrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of Float%Type%Matrix.
     */
    class Abs extends
        TypedFloatMatrixAbs<%Type%Unit, Float%Type%Matrix.Abs, Float%Type%Matrix.Rel, MutableFloat%Type%Matrix.Abs, Float%Type%.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Float%Type%Matrix.
         * @param values float[][]; the values of the entries in the new Absolute Immutable Float%Type%Matrix
         * @param unit U; the unit of the new Absolute Immutable Float%Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Matrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Float%Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Float%Type%.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Matrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatMatrixData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%Matrix.Abs instantiateTypeAbs(final FloatMatrixData fmd, final %Type%Unit unit)
        {
            return new Float%Type%Matrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%Matrix.Rel instantiateTypeRel(final FloatMatrixData fmd, final %Type%Unit unit)
        {
            return new Float%Type%Matrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloat%Type%Matrix.Abs
            instantiateMutableType(final FloatMatrixData fmd, final %Type%Unit unit)
        {
            return new MutableFloat%Type%Matrix.Abs(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs get(final int row, final int column) throws ValueException
        {
            return new Float%Type%.Abs(getInUnit(row, column, getUnit()), getUnit());
        }
        
        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Float%Type% matrix.
         */
        public final Float%Type%Matrix.Rel toRel()
        {
            return new Float%Type%Matrix.Rel(getData(), getUnit());
        }
        
%FORMULAS%%Type%.Abs%
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of Float%Type%Matrix.
     */
    class Rel extends TypedFloatMatrixRel<%Type%Unit, Float%Type%Matrix.Rel, MutableFloat%Type%Matrix.Rel, Float%Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Float%Type%Matrix.
         * @param values float[][]; the values of the entries in the new Relative Immutable Float%Type%Matrix
         * @param unit U; the unit of the new Relative Immutable Float%Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Matrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float%Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Float%Type%.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Matrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatMatrixData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%Matrix.Rel instantiateType(final FloatMatrixData fmd, final %Type%Unit unit)
        {
            return new Float%Type%Matrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloat%Type%Matrix.Rel
            instantiateMutableType(final FloatMatrixData fmd, final %Type%Unit unit)
        {
            return new MutableFloat%Type%Matrix.Rel(fmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel get(final int row, final int column) throws ValueException
        {
            return new Float%Type%.Rel(getInUnit(row, column, getUnit()), getUnit());
        }
        
        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Float%Type% matrix.
         */
        public final Float%Type%Matrix.Abs toAbs()
        {
            return new Float%Type%Matrix.Abs(getData(), getUnit());
        }
        
%FORMULAS%%Type%.Rel%
    }

}
