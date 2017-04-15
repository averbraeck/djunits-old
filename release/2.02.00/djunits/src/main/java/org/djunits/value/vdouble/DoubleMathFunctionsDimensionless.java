package org.djunits.value.vdouble;

import org.djunits.value.MathFunctionsDimensionless;

/**
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 14, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <T> the return type
 */
public interface DoubleMathFunctionsDimensionless<T> extends MathFunctionsDimensionless<T>
{
    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param doubleFunction the function to apply
     */
    void assign(final DoubleFunction doubleFunction);

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
