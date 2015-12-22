package org.djunits.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Immutable %Type% Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface %Type%Matrix
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of %Type%Matrix.
     */
    class Abs extends
        TypedDoubleMatrixAbs<%Type%Unit, %Type%Matrix.Abs, %Type%Matrix.Rel, Mutable%Type%Matrix.Abs, %Type%.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Double %Type%Matrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable Double %Type%Matrix
         * @param unit U; the unit of the new Absolute Immutable Double %Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double %Type%Matrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double %Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final %Type%.Abs[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Double %Type%Matrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%Matrix.Abs instantiateTypeAbs(final DoubleMatrixData dmd, final %Type%Unit unit)
        {
            return new %Type%Matrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%Matrix.Rel instantiateTypeRel(final DoubleMatrixData dmd, final %Type%Unit unit)
        {
            return new %Type%Matrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Mutable%Type%Matrix.Abs
            instantiateMutableType(final DoubleMatrixData dmd, final %Type%Unit unit)
        {
            return new Mutable%Type%Matrix.Abs(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Abs get(final int row, final int column) throws ValueException
        {
            return new %Type%.Abs(getInUnit(row, column, getUnit()), getUnit());
        }
        
        /**
         * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute %Type% matrix.
         */
        public final %Type%Matrix.Rel toRel()
        {
            return new %Type%Matrix.Rel(getData(), getUnit());
        }
        
%FORMULAS%%Type%.Abs%
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of %Type%Matrix.
     */
    class Rel extends TypedDoubleMatrixRel<%Type%Unit, %Type%Matrix.Rel, Mutable%Type%Matrix.Rel, %Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Double %Type%Matrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable Double %Type%Matrix
         * @param unit U; the unit of the new Relative Immutable Double %Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Double %Type%Matrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double %Type%Matrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final %Type%.Rel[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Double %Type%Matrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%Matrix.Rel instantiateType(final DoubleMatrixData dmd, final %Type%Unit unit)
        {
            return new %Type%Matrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Mutable%Type%Matrix.Rel
            instantiateMutableType(final DoubleMatrixData dmd, final %Type%Unit unit)
        {
            return new Mutable%Type%Matrix.Rel(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final %Type%.Rel get(final int row, final int column) throws ValueException
        {
            return new %Type%.Rel(getInUnit(row, column, getUnit()), getUnit());
        }
        
        /**
         * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %Type% matrix.
         */
        public final %Type%Matrix.Abs toAbs()
        {
            return new %Type%Matrix.Abs(getData(), getUnit());
        }
        
%FORMULAS%%Type%.Rel%
    }

}
