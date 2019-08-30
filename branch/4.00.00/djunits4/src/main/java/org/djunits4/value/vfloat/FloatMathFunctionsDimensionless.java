package org.djunits4.value.vfloat;

import org.djunits4.value.MathFunctionsDimensionless;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 14, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <T> the return type
 */
public interface FloatMathFunctionsDimensionless<T> extends MathFunctionsDimensionless<T>
{
    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param floatFunction FloatFunction; the function to apply
     */
    void assign(FloatFunction floatFunction);

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T acos()
    {
        assign(FloatMathFunctions.ACOS);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T asin()
    {
        assign(FloatMathFunctions.ASIN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T atan()
    {
        assign(FloatMathFunctions.ATAN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T cbrt()
    {
        assign(FloatMathFunctions.CBRT);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T cos()
    {
        assign(FloatMathFunctions.COS);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T cosh()
    {
        assign(FloatMathFunctions.COSH);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T exp()
    {
        assign(FloatMathFunctions.EXP);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T expm1()
    {
        assign(FloatMathFunctions.EXPM1);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T log()
    {
        assign(FloatMathFunctions.LOG);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T log10()
    {
        assign(FloatMathFunctions.LOG10);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T log1p()
    {
        assign(FloatMathFunctions.LOG1P);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T neg()
    {
        assign(FloatMathFunctions.NEG);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T pow(final double x)
    {
        assign(FloatMathFunctions.POW((float) x));
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T signum()
    {
        assign(FloatMathFunctions.SIGNUM);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T sin()
    {
        assign(FloatMathFunctions.SIN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T sinh()
    {
        assign(FloatMathFunctions.SINH);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T sqrt()
    {
        assign(FloatMathFunctions.SQRT);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T tan()
    {
        assign(FloatMathFunctions.TAN);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T tanh()
    {
        assign(FloatMathFunctions.TANH);
        return (T) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    default T inv()
    {
        assign(FloatMathFunctions.INV);
        return (T) this;
    }

}
