package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Immutable %Type% Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Float%Type%Vector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of Float%Type%Vector.
     */
    class Abs extends
        TypedFloatVectorAbs<%Type%Unit, Float%Type%Vector.Abs, Float%Type%Vector.Rel, MutableFloat%Type%Vector.Abs, Float%Type%.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param values float[]; the values of the entries in the new Absolute Immutable Float%Type%Vector
         * @param unit U; the unit of the new Absolute Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[] values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param values List; the values of the entries in the new Absolute Immutable Float%Type%Vector
         * @param unit U; the unit of the new Absolute Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Float> values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Float%Type%.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param values List; the values of the entries in the new Absolute Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<Float%Type%.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Float%Type%Vector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, Float%Type%.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Float%Type%Vector
         * @param unit U; the unit of the new Absolute Sparse Mutable Float%Type%Vector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Immutable Float%Type%Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final FloatVectorData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%Vector.Abs instantiateTypeAbs(final FloatVectorData dvd, final %Type%Unit unit)
        {
            return new Float%Type%Vector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%Vector.Rel instantiateTypeRel(final FloatVectorData dvd, final %Type%Unit unit)
        {
            return new Float%Type%Vector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloat%Type%Vector.Abs
            instantiateMutableType(final FloatVectorData dvd, final %Type%Unit unit)
        {
            return new MutableFloat%Type%Vector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Abs get(final int index) throws ValueException
        {
            return new Float%Type%.Abs(getInUnit(index, getUnit()), getUnit());
        }
        
        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Float%Type% vector.
         */
        public final Float%Type%Vector.Rel toRel()
        {
            return new Float%Type%Vector.Rel(getData(), getUnit());
        }
        
%FORMULAS%%Type%.Abs%
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of Float%Type%Vector.
     */
    class Rel extends TypedFloatVectorRel<%Type%Unit, Float%Type%Vector.Rel, MutableFloat%Type%Vector.Rel, Float%Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param values float[]; the values of the entries in the new Relative Immutable Float%Type%Vector
         * @param unit U; the unit of the new Relative Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[] values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param values List; the values of the entries in the new Relative Immutable Float%Type%Vector
         * @param unit U; the unit of the new Relative Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Float> values, final %Type%Unit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Float%Type%.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param values List; the values of the entries in the new Relative Immutable Float%Type%Vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<Float%Type%.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float%Type%Vector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, Float%Type%.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float%Type%Vector
         * @param unit U; the unit of the new Relative Sparse Mutable Float%Type%Vector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Immutable Float%Type%Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final FloatVectorData data, final %Type%Unit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%Vector.Rel instantiateType(final FloatVectorData dvd, final %Type%Unit unit)
        {
            return new Float%Type%Vector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloat%Type%Vector.Rel
            instantiateMutableType(final FloatVectorData dvd, final %Type%Unit unit)
        {
            return new MutableFloat%Type%Vector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Float%Type%.Rel get(final int index) throws ValueException
        {
            return new Float%Type%.Rel(getInUnit(index, getUnit()), getUnit());
        }
        
        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Float%Type% vector.
         */
        public final Float%Type%Vector.Abs toAbs()
        {
            return new Float%Type%Vector.Abs(getData(), getUnit());
        }
        
%FORMULAS%%Type%.Rel%
    }

}
