package org.djunits4.value.vfloat;

/**
 * Force implementation of multiplyBy and divideBy and implement various math functions.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <T> the type that these MathFunctions manipulate
 */
public interface FloatMathFunctions<T>
{
    /**
     * Scale the value(s) by a factor.
     * @param factor float; the multiplier
     * @return T; the modified T
     */
    T multiplyBy(float factor);

    /**
     * Scale the value(s) by the inverse of a factor; i.e. a divisor.
     * @param divisor float; the divisor
     * @return T; the modified T
     */
    T divideBy(float divisor);

    /**
     * Function that returns <tt>Math.abs(a)</tt>.
     */
    FloatFunction ABS = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return Math.abs(a);
        }
    };

    /**
     * Function that returns <tt>Math.acos(a)</tt>.
     */
    FloatFunction ACOS = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.acos(a);
        }
    };

    /**
     * Function that returns <tt>Math.asin(a)</tt>.
     */
    FloatFunction ASIN = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.asin(a);
        }
    };

    /**
     * Function that returns <tt>Math.atan(a)</tt>.
     */
    FloatFunction ATAN = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.atan(a);
        }
    };

    /**
     * Function that returns <tt>Math.cbrt(a)</tt>.
     */
    FloatFunction CBRT = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.cbrt(a);
        }
    };

    /**
     * Function that returns <tt>Math.ceil(a)</tt>.
     */
    FloatFunction CEIL = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.ceil(a);
        }
    };

    /**
     * Function that returns <tt>Math.cos(a)</tt>.
     */
    FloatFunction COS = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.cos(a);
        }
    };

    /**
     * Function that returns <tt>Math.cosh(a)</tt>.
     */
    FloatFunction COSH = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.cosh(a);
        }
    };

    /**
     * Function that returns <tt>Math.exp(a)</tt>.
     */
    FloatFunction EXP = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.exp(a);
        }
    };

    /**
     * Function that returns <tt>Math.expm1(a)</tt>.
     */
    FloatFunction EXPM1 = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.expm1(a);
        }
    };

    /**
     * Function that returns <tt>Math.floor(a)</tt>.
     */
    FloatFunction FLOOR = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.floor(a);
        }
    };

    /**
     * Function that returns <tt>Math.log(a)</tt>.
     */
    FloatFunction LOG = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.log(a);
        }
    };

    /**
     * Function that returns <tt>Math.log10(a)</tt>.
     */
    FloatFunction LOG10 = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.log10(a);
        }
    };

    /**
     * Function that returns <tt>Math.log1p(a)</tt>.
     */
    FloatFunction LOG1P = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.log1p(a);
        }
    };

    /**
     * Function that returns <tt>-a</tt>.
     */
    FloatFunction NEG = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return -a;
        }
    };

    /**
     * Function that returns <tt>Math.pow(a, b)</tt>.
     * @param b float; power parameter
     * @return power function
     */
    @SuppressWarnings("checkstyle:methodname")
    static FloatFunction POW(final float b)
    {
        return new FloatFunction()
        {
            @Override
            public float apply(final float a)
            {
                return (float) Math.pow(a, b);
            }
        };
    }

    /**
     * Function that returns <tt>Math.rint(a)</tt>.
     */
    FloatFunction RINT = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.rint(a);
        }
    };

    /**
     * Function that returns <tt>Math.round(a)</tt>.
     */
    FloatFunction ROUND = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return Math.round(a);
        }
    };

    /**
     * Function that returns <tt>Math.signum(a)</tt>.
     */
    FloatFunction SIGNUM = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return Math.signum(a);
        }
    };

    /**
     * Function that returns <tt>Math.sin(a)</tt>.
     */
    FloatFunction SIN = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.sin(a);
        }
    };

    /**
     * Function that returns <tt>Math.sinh(a)</tt>.
     */
    FloatFunction SINH = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.sinh(a);
        }
    };

    /**
     * Function that returns <tt>Math.sqrt(a)</tt>.
     */
    FloatFunction SQRT = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.sqrt(a);
        }
    };

    /**
     * Function that returns <tt>Math.tan(a)</tt>.
     */
    FloatFunction TAN = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.tan(a);
        }
    };

    /**
     * Function that returns <tt>Math.tanh(a)</tt>.
     */
    FloatFunction TANH = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.tanh(a);
        }
    };

    /**
     * Function that returns <tt>Math.toDegrees(a)</tt>.
     */
    FloatFunction TO_DEGREES = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.toDegrees(a);
        }
    };

    /**
     * Function that returns <tt>Math.toRadians(a)</tt>.
     */
    FloatFunction TO_RADIANS = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return (float) Math.toRadians(a);
        }
    };

    /**
     * Function that returns <tt>1/a</tt>.
     */
    FloatFunction INV = new FloatFunction()
    {
        @Override
        public float apply(final float a)
        {
            return 1 / a;
        }
    };

    /**
     * Function that returns <tt>a * b</tt>.
     * @param b float; power parameter
     * @return power function
     */
    @SuppressWarnings("checkstyle:methodname")
    static FloatFunction MULT(final float b)
    {
        return new FloatFunction()
        {
            @Override
            public float apply(final float a)
            {
                return a * b;
            }
        };
    }

    /**
     * Function that returns <tt>a / b</tt>.
     * @param b float; power parameter
     * @return power function
     */
    @SuppressWarnings("checkstyle:methodname")
    static FloatFunction DIV(final float b)
    {
        return new FloatFunction()
        {
            @Override
            public float apply(final float a)
            {
                return a / b;
            }
        };
    }
}
