package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Angle;

/**
 * Mutable Angle Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface MutableAngleVector
{
    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of AngleVector.
     */
    class Abs extends
        MutableTypedDoubleVectorAbs<AngleUnit, AngleVector.Abs, AngleVector.Rel, MutableAngleVector.Abs, Angle.Abs>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param values double[]; the values of the entries in the new Absolute Mutable Double AngleVector
         * @param unit U; the unit of the new Absolute Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param values List; the values of the entries in the new Absolute Mutable Double AngleVector
         * @param unit U; the unit of the new Absolute Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final List<Double> values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final Angle.Abs[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param values List; the values of the entries in the new Absolute Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final List<Angle.Abs> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
         *            AngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final SortedMap<Integer, Angle.Abs> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double AngleVector
         * @param unit U; the unit of the new Absolute Sparse Mutable Double AngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final SortedMap<Integer, Double> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Absolute Mutable Double AngleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleVectorData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleVector.Abs instantiateTypeAbs(final DoubleVectorData dvd, final AngleUnit unit)
        {
            return new AngleVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleVector.Rel instantiateTypeRel(final DoubleVectorData dvd, final AngleUnit unit)
        {
            return new AngleVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleVector.Abs instantiateMutableType(final DoubleVectorData dvd, final AngleUnit unit)
        {
            return new MutableAngleVector.Abs(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Angle.Abs get(final int index) throws ValueException
        {
            return new Angle.Abs(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute Angle vector.
         */
        public final MutableAngleVector.Rel toRel()
        {
            return new MutableAngleVector.Rel(getData(), getUnit());
        }

    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of AngleVector.
     */
    class Rel extends MutableTypedDoubleVectorRel<AngleUnit, AngleVector.Rel, MutableAngleVector.Rel, Angle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20151006L;

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param values double[]; the values of the entries in the new Relative Mutable Double AngleVector
         * @param unit U; the unit of the new Relative Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[] values, final AngleUnit unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param values List; the values of the entries in the new Relative Mutable Double AngleVector
         * @param unit U; the unit of the new Relative Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final List<Double> values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final Angle.Rel[] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param values List; the values of the entries in the new Relative Mutable Double AngleVector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final List<Angle.Rel> values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
         *            AngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final SortedMap<Integer, Angle.Rel> values, final int length, final StorageType storageType)
            throws ValueException
        {
            super(values, length, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AngleVector
         * @param unit U; the unit of the new Relative Sparse Mutable Double AngleVector
         * @param length the size of the vector
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final SortedMap<Integer, Double> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
        {
            super(values, unit, length, storageType);
        }

        /**
         * Construct a new Relative Mutable Double AngleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleVectorData data, final AngleUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleVector.Rel instantiateType(final DoubleVectorData dvd, final AngleUnit unit)
        {
            return new AngleVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableAngleVector.Rel instantiateMutableType(final DoubleVectorData dvd, final AngleUnit unit)
        {
            return new MutableAngleVector.Rel(dvd, unit);
        }

        /** {@inheritDoc} */
        @Override
        public final Angle.Rel get(final int index) throws ValueException
        {
            return new Angle.Rel(getInUnit(index, getUnit()), getUnit());
        }

        /**
         * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative Angle vector.
         */
        public final MutableAngleVector.Abs toAbs()
        {
            return new MutableAngleVector.Abs(getData(), getUnit());
        }

    }

}
