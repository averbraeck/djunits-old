package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.DoubleScalar;

/**
 * Immutable DoubleMatrix.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class DoubleMatrix
{
    /**
     * ABSOLUTE implementation of DoubleMatrix.
     * @param <AU> Absolute unit
     * @param <RU> Relative unit
     */
    public static class Abs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> extends AbstractDoubleMatrixAbs<AU, RU,
            DoubleMatrix.Abs<AU, RU>, DoubleMatrix.Rel<RU>, MutableDoubleMatrix.Abs<AU, RU>, DoubleScalar.Abs<AU, RU>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
         * @param unit AU; the unit of the new Absolute Immutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final AU unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleMatrix.
         * @param values DoubleScalar.Abs&lt;AU, RU&gt;[][]; the values of the entries in the new Absolute Immutable
         *            DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final DoubleScalar.Abs<AU, RU>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleMatrix.
         * @param data DoubleMatrixData; an internal data object
         * @param unit AU; the unit
         */
        Abs(final DoubleMatrixData data, final AU unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<AU, RU> toDense()
        {
            return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<AU, RU> toSparse()
        {
            return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleMatrix.Abs<AU, RU> instantiateTypeAbs(final DoubleMatrixData dmd, final AU unit)
        {
            return new DoubleMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleMatrix.Rel<RU> instantiateTypeRel(final DoubleMatrixData dmd, final RU unit)
        {
            return new DoubleMatrix.Rel<RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDoubleMatrix.Abs<AU, RU> instantiateMutableType(final DoubleMatrixData dmd, final AU unit)
        {
            return new MutableDoubleMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleScalar.Abs<AU, RU> instantiateScalar(final double value, final AU unit)
        {
            return new DoubleScalar.Abs<AU, RU>(value, unit);
        }
    }

    /**
     * RELATIVE implementation of DoubleMatrix.
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public static class Rel<U extends Unit<U>>
            extends AbstractDoubleMatrixRel<U, DoubleMatrix.Rel<U>, MutableDoubleMatrix.Rel<U>, DoubleScalar.Rel<U>>

    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable DoubleMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable DoubleMatrix
         * @param unit U; the unit of the new Relative Immutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final DoubleScalar.Rel<U>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleMatrix.
         * @param data DoubleMatrixData; an internal data object
         * @param unit U; the unit
         */
        Rel(final DoubleMatrixData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Rel<U> toDense()
        {
            return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleMatrix.Rel<U> instantiateType(final DoubleMatrixData dmd, final U unit)
        {
            return new DoubleMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDoubleMatrix.Rel<U> instantiateMutableType(final DoubleMatrixData dmd, final U unit)
        {
            return new MutableDoubleMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleScalar.Rel<U> instantiateScalar(final double value, final U unit)
        {
            return new DoubleScalar.Rel<U>(value, unit);
        }
    }

    /* ============================================================================================ */
    /* =========================== STATIC CALCULATION MATRIX METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Abs + Rel = Abs.
     * @param left DoubleMatrix.Abs&lt;AU,RU&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;RU&gt;; the second matrix
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @return the sum of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> DoubleMatrix.Abs<AU, RU> plus(
            final DoubleMatrix.Abs<AU, RU> left, final DoubleMatrix.Rel<RU> right) throws ValueException
    {
        return left.mutable().plus(right);
    }

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Rel + Rel = Rel.
     * @param left DoubleMatrix.Rel&lt;U&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the relative unit
     * @return the sum of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> plus(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().plus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Abs - Rel = Abs.
     * @param left DoubleMatrix.Abs&lt;AU,RU&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;RU&gt;; the second matrix
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> DoubleMatrix.Abs<AU, RU> minus(
            final DoubleMatrix.Abs<AU, RU> left, final DoubleMatrix.Rel<RU> right) throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Abs - Abs = Rel.
     * @param left DoubleMatrix.Abs&lt;AU,RU&gt;; the first matrix
     * @param right DoubleMatrix.Abs&lt;AU,RU&gt;; the second matrix
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> DoubleMatrix.Rel<RU> minus(
            final DoubleMatrix.Abs<AU, RU> left, final DoubleMatrix.Abs<AU, RU> right) throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Rel - Rel = Rel.
     * @param left DoubleMatrix.Rel&lt;U&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> minus(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Multiply the content of two matrices with a static method on a cell-by-cell basis; Rel * Rel = Rel. The unit is not
     * changed by this method.
     * @param left DoubleMatrix.Rel&lt;U&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the cell-by-cell multiplication of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> times(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().times(right);
    }

    /**
     * Divide the content of two matrices with a static method on a cell-by-cell basis; Rel / Rel = Rel. The unit is not changed
     * by this method.
     * @param left DoubleMatrix.Rel&lt;U&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the cell-by-cell division of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> divide(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().divide(right);
    }

}
