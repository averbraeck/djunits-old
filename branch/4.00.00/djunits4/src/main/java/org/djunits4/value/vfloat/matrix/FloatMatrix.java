package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatScalar;

/**
 * Immutable FloatMatrix.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class FloatMatrix
{
    /**
     * ABSOLUTE implementation of FloatMatrix.
     * @param <AU> Absolute unit
     * @param <RU> Relative unit
     */
    public static class Abs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> extends AbstractFloatMatrixAbs<AU, RU,
            FloatMatrix.Abs<AU, RU>, FloatMatrix.Rel<RU>, MutableFloatMatrix.Abs<AU, RU>, FloatScalar.Abs<AU, RU>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable FloatMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Immutable FloatMatrix
         * @param unit AU; the unit of the new Absolute Immutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final AU unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatMatrix.
         * @param values FloatScalar.Abs&lt;AU, RU&gt;[][]; the values of the entries in the new Absolute Immutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatScalar.Abs<AU, RU>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable FloatMatrix.
         * @param data FloatMatrixData; an internal data object
         * @param unit AU; the unit
         */
        Abs(final FloatMatrixData data, final AU unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatMatrix.Abs<AU, RU> toDense()
        {
            return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatMatrix.Abs<AU, RU> toSparse()
        {
            return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatMatrix.Abs<AU, RU> instantiateTypeAbs(final FloatMatrixData dmd, final AU unit)
        {
            return new FloatMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatMatrix.Rel<RU> instantiateTypeRel(final FloatMatrixData dmd, final RU unit)
        {
            return new FloatMatrix.Rel<RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatMatrix.Abs<AU, RU> instantiateMutableType(final FloatMatrixData dmd, final AU unit)
        {
            return new MutableFloatMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatScalar.Abs<AU, RU> instantiateScalar(final float value, final AU unit)
        {
            return new FloatScalar.Abs<AU, RU>(value, unit);
        }
    }

    /**
     * RELATIVE implementation of FloatMatrix.
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public static class Rel<U extends Unit<U>>
            extends AbstractFloatMatrixRel<U, FloatMatrix.Rel<U>, MutableFloatMatrix.Rel<U>, FloatScalar.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable FloatMatrix.
         * @param values float[][]; the values of the entries in the new Relative Immutable FloatMatrix
         * @param unit U; the unit of the new Relative Immutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatScalar.Rel<U>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable FloatMatrix.
         * @param data FloatMatrixData; an internal data object
         * @param unit U; the unit
         */
        Rel(final FloatMatrixData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatMatrix.Rel<U> toDense()
        {
            return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public FloatMatrix.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatMatrix.Rel<U> instantiateType(final FloatMatrixData dmd, final U unit)
        {
            return new FloatMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatMatrix.Rel<U> instantiateMutableType(final FloatMatrixData dmd, final U unit)
        {
            return new MutableFloatMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatScalar.Rel<U> instantiateScalar(final float value, final U unit)
        {
            return new FloatScalar.Rel<U>(value, unit);
        }
    }

    /* ============================================================================================ */
    /* =========================== STATIC CALCULATION MATRIX METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Abs + Rel = Abs.
     * @param left FloatMatrix.Abs&lt;AU,RU&gt;; the first matrix
     * @param right FloatMatrix.Rel&lt;RU&gt;; the second matrix
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @return the sum of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> FloatMatrix.Abs<AU, RU> plus(
            final FloatMatrix.Abs<AU, RU> left, final FloatMatrix.Rel<RU> right) throws ValueException
    {
        return left.mutable().plus(right);
    }

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Rel + Rel = Rel.
     * @param left FloatMatrix.Rel&lt;U&gt;; the first matrix
     * @param right FloatMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the relative unit
     * @return the sum of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> FloatMatrix.Rel<U> plus(final FloatMatrix.Rel<U> left, final FloatMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().plus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Abs - Rel = Abs.
     * @param left FloatMatrix.Abs&lt;AU,RU&gt;; the first matrix
     * @param right FloatMatrix.Rel&lt;RU&gt;; the second matrix
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> FloatMatrix.Abs<AU, RU> minus(
            final FloatMatrix.Abs<AU, RU> left, final FloatMatrix.Rel<RU> right) throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Abs - Abs = Rel.
     * @param left FloatMatrix.Abs&lt;AU,RU&gt;; the first matrix
     * @param right FloatMatrix.Abs&lt;AU,RU&gt;; the second matrix
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> FloatMatrix.Rel<RU> minus(
            final FloatMatrix.Abs<AU, RU> left, final FloatMatrix.Abs<AU, RU> right) throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Rel - Rel = Rel.
     * @param left FloatMatrix.Rel&lt;U&gt;; the first matrix
     * @param right FloatMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> FloatMatrix.Rel<U> minus(final FloatMatrix.Rel<U> left, final FloatMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Multiply the content of two matrices with a static method on a cell-by-cell basis; Rel * Rel = Rel. The unit is not
     * changed by this method.
     * @param left FloatMatrix.Rel&lt;U&gt;; the first matrix
     * @param right FloatMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the cell-by-cell multiplication of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> FloatMatrix.Rel<U> times(final FloatMatrix.Rel<U> left, final FloatMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().times(right);
    }

    /**
     * Divide the content of two matrices with a static method on a cell-by-cell basis; Rel / Rel = Rel. The unit is not changed
     * by this method.
     * @param left FloatMatrix.Rel&lt;U&gt;; the first matrix
     * @param right FloatMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the cell-by-cell division of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> FloatMatrix.Rel<U> divide(final FloatMatrix.Rel<U> left, final FloatMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().divide(right);
    }

}
