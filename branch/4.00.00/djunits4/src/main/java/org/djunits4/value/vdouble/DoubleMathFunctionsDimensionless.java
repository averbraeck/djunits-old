package org.djunits4.value.vdouble;

import org.djunits4.value.MathFunctionsDimensionless;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <T> the return type
 */
public interface DoubleMathFunctionsDimensionless<T> extends MathFunctionsDimensionless<T>
{
    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param doubleFunction DoubleFunction; the function to apply
     */
    void assign(DoubleFunction doubleFunction);

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T acos()
    {
        assign(DoubleMathFunctions.ACOS);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T asin()
    {
        assign(DoubleMathFunctions.ASIN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T atan()
    {
        assign(DoubleMathFunctions.ATAN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T cbrt()
    {
        assign(DoubleMathFunctions.CBRT);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T cos()
    {
        assign(DoubleMathFunctions.COS);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T cosh()
    {
        assign(DoubleMathFunctions.COSH);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T exp()
    {
        assign(DoubleMathFunctions.EXP);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T expm1()
    {
        assign(DoubleMathFunctions.EXPM1);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T log()
    {
        assign(DoubleMathFunctions.LOG);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T log10()
    {
        assign(DoubleMathFunctions.LOG10);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T log1p()
    {
        assign(DoubleMathFunctions.LOG1P);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T neg()
    {
        assign(DoubleMathFunctions.NEG);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T pow(final double x)
    {
        assign(DoubleMathFunctions.POW((float) x));
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T signum()
    {
        assign(DoubleMathFunctions.SIGNUM);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T sin()
    {
        assign(DoubleMathFunctions.SIN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T sinh()
    {
        assign(DoubleMathFunctions.SINH);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T sqrt()
    {
        assign(DoubleMathFunctions.SQRT);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T tan()
    {
        assign(DoubleMathFunctions.TAN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T tanh()
    {
        assign(DoubleMathFunctions.TANH);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T inv()
    {
        assign(DoubleMathFunctions.INV);
        return (T) this;
    }

}
