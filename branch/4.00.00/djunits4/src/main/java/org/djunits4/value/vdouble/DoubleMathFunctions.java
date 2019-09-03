package org.djunits4.value.vdouble;

/**
 * Force implementation of multiplyBy and divideBy, and provide static implementation of Math functions.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <T> the type that these MathFunctions manipulate
 */
public interface DoubleMathFunctions<T>
{
    /**
     * Scale the value(s) by a factor.
     * @param factor double; the multiplier
     * @return T; the modified T
     */
    T multiplyBy(double factor);

    /**
     * Scale the value(s) by the inverse of a factor; i.e. a divisor.
     * @param divisor double; the divisor
     * @return T; the modified T
     */
    T divideBy(double divisor);

    /**
     * Function that returns <tt>Math.abs(a)</tt>.
     */
    DoubleFunction ABS = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.abs(a);
        }
    };

    /**
     * Function that returns <tt>Math.acos(a)</tt>.
     */
    DoubleFunction ACOS = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.acos(a);
        }
    };

    /**
     * Function that returns <tt>Math.asin(a)</tt>.
     */
    DoubleFunction ASIN = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.asin(a);
        }
    };

    /**
     * Function that returns <tt>Math.atan(a)</tt>.
     */
    DoubleFunction ATAN = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.atan(a);
        }
    };

    /**
     * Function that returns <tt>Math.cbrt(a)</tt>.
     */
    DoubleFunction CBRT = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.cbrt(a);
        }
    };

    /**
     * Function that returns <tt>Math.ceil(a)</tt>.
     */
    DoubleFunction CEIL = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.ceil(a);
        }
    };

    /**
     * Function that returns <tt>Math.cos(a)</tt>.
     */
    DoubleFunction COS = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.cos(a);
        }
    };

    /**
     * Function that returns <tt>Math.cosh(a)</tt>.
     */
    DoubleFunction COSH = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.cosh(a);
        }
    };

    /**
     * Function that returns <tt>Math.exp(a)</tt>.
     */
    DoubleFunction EXP = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.exp(a);
        }
    };

    /**
     * Function that returns <tt>Math.expm1(a)</tt>.
     */
    DoubleFunction EXPM1 = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.expm1(a);
        }
    };

    /**
     * Function that returns <tt>Math.floor(a)</tt>.
     */
    DoubleFunction FLOOR = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.floor(a);
        }
    };

    /**
     * Function that returns <tt>Math.log(a)</tt>.
     */
    DoubleFunction LOG = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.log(a);
        }
    };

    /**
     * Function that returns <tt>Math.log10(a)</tt>.
     */
    DoubleFunction LOG10 = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.log10(a);
        }
    };

    /**
     * Function that returns <tt>Math.log1p(a)</tt>.
     */
    DoubleFunction LOG1P = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.log1p(a);
        }
    };

    /**
     * Function that returns <tt>-a</tt>.
     */
    DoubleFunction NEG = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return -a;
        }
    };

    /**
     * Function that returns <tt>Math.pow(a, b)</tt>.
     * @param b double; power parameter
     * @return power function
     */
    @SuppressWarnings("checkstyle:methodname")
    static DoubleFunction POW(final double b)
    {
        return new DoubleFunction()
        {
            @Override
            public double apply(final double a)
            {
                return Math.pow(a, b);
            }
        };
    }

    /**
     * Function that returns <tt>Math.rint(a)</tt>.
     */
    DoubleFunction RINT = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.rint(a);
        }
    };

    /**
     * Function that returns <tt>Math.round(a)</tt>.
     */
    DoubleFunction ROUND = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.round(a);
        }
    };

    /**
     * Function that returns <tt>Math.signum(a)</tt>.
     */
    DoubleFunction SIGNUM = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.signum(a);
        }
    };

    /**
     * Function that returns <tt>Math.sin(a)</tt>.
     */
    DoubleFunction SIN = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.sin(a);
        }
    };

    /**
     * Function that returns <tt>Math.sinh(a)</tt>.
     */
    DoubleFunction SINH = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.sinh(a);
        }
    };

    /**
     * Function that returns <tt>Math.sqrt(a)</tt>.
     */
    DoubleFunction SQRT = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.sqrt(a);
        }
    };

    /**
     * Function that returns <tt>Math.tan(a)</tt>.
     */
    DoubleFunction TAN = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.tan(a);
        }
    };

    /**
     * Function that returns <tt>Math.tanh(a)</tt>.
     */
    DoubleFunction TANH = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return Math.tanh(a);
        }
    };

    /**
     * Function that returns <tt>1/a</tt>.
     */
    DoubleFunction INV = new DoubleFunction()
    {
        @Override
        public double apply(final double a)
        {
            return 1 / a;
        }
    };

    /**
     * Function that returns <tt>a * b</tt>.
     * @param b double; power parameter
     * @return power function
     */
    @SuppressWarnings("checkstyle:methodname")
    static DoubleFunction MULT(final double b)
    {
        return new DoubleFunction()
        {
            @Override
            public double apply(final double a)
            {
                return a * b;
            }
        };
    }

    /**
     * Function that returns <tt>a / b</tt>.
     * @param b double; power parameter
     * @return power function
     */
    @SuppressWarnings("checkstyle:methodname")
    static DoubleFunction DIV(final double b)
    {
        return new DoubleFunction()
        {
            @Override
            public double apply(final double a)
            {
                return a / b;
            }
        };
    }

}
