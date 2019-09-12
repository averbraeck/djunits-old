package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.base.DoubleScalar;

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
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> DoubleMatrix.Abs<AU, RU> plus(
            final DoubleMatrix.Abs<AU, RU> left, final DoubleMatrix.ImmutableRel<RU> right) throws ValueRuntimeException
    {
        return left.mutable().plus(right);
    }

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Rel + Rel = Rel.
     * @param left DoubleMatrix.Rel&lt;U&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the relative unit
     * @return the sum of the two matrices
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.ImmutableRel<U> plus(final DoubleMatrix.ImmutableRel<U> left, final DoubleMatrix.ImmutableRel<U> right)
            throws ValueRuntimeException
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
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> DoubleMatrix.Abs<AU, RU> minus(
            final DoubleMatrix.Abs<AU, RU> left, final DoubleMatrix.ImmutableRel<RU> right) throws ValueRuntimeException
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
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> DoubleMatrix.ImmutableRel<RU> minus(
            final DoubleMatrix.Abs<AU, RU> left, final DoubleMatrix.Abs<AU, RU> right) throws ValueRuntimeException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Rel - Rel = Rel.
     * @param left DoubleMatrix.Rel&lt;U&gt;; the first matrix
     * @param right DoubleMatrix.Rel&lt;U&gt;; the second matrix
     * @param <U> the unit
     * @return the difference of the two matrices
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.ImmutableRel<U> minus(final DoubleMatrix.ImmutableRel<U> left, final DoubleMatrix.ImmutableRel<U> right)
            throws ValueRuntimeException
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
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.ImmutableRel<U> times(final DoubleMatrix.ImmutableRel<U> left, final DoubleMatrix.ImmutableRel<U> right)
            throws ValueRuntimeException
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
     * @throws ValueRuntimeException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.ImmutableRel<U> divide(final DoubleMatrix.ImmutableRel<U> left, final DoubleMatrix.ImmutableRel<U> right)
            throws ValueRuntimeException
    {
        return left.mutable().divide(right);
    }

}
