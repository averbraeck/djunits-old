package org.djunits.value;

/**
 * Interface to force most functions of Math, which have not yet been implemented by MathFunctionsRel, to be implemented, with
 * the exception of toRadians() and toDegrees() -- these functions are available for angles.
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-04 20:48:33 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 87 $, by $Author: averbraeck $, initial
 * version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <T> the type of the value that the functions operate on
 */
public interface MathFunctionsDimensionless<T>
{
    /**
     * Set the value(s) to the arc cosine of the value(s); the resulting angle is in the range 0.0 through pi.
     * @return T; the modified T
     */
    T acos();

    /**
     * Set the value(s) to the arc sine of the value(s); the resulting angle is in the range -pi/2 through pi/2.
     * @return T; the modified T
     */
    T asin();

    /**
     * Set the value(s) to the arc tangent of the value(s); the resulting angle is in the range -pi/2 through pi/2.
     * @return T; the modified T
     */
    T atan();

    /**
     * Set the value(s) to the(ir) cube root.
     * @return T; the modified T
     */
    T cbrt();

    /**
     * Set the value(s) to the trigonometric cosine of the value(s).
     * @return T; the modified T
     */
    T cos();

    /**
     * Set the value(s) to the hyperbolic cosine of the value(s).
     * @return T; the modified T
     */
    T cosh();

    /**
     * Set the value(s) to Euler's number e raised to the power of the value(s).
     * @return T; the modified T
     */
    T exp();

    /**
     * Set the value(s) to Euler's number e raised to the power of the value(s) minus 1 (e^x - 1).
     * @return T; the modified T
     */
    T expm1();

    /**
     * Set the value(s) to the natural logarithm (base e) of the value(s).
     * @return T; the modified T
     */
    T log();

    /**
     * Set the value(s) to the base 10 logarithm of the value(s).
     * @return T; the modified T
     */
    T log10();

    /**
     * Set the value(s) to the natural logarithm of the sum of the value(s) and 1.
     * @return T; the modified T
     */
    T log1p();

    /**
     * Set the value(s) to the minus value.
     * @return T; the modified T
     */
    T neg();

    /**
     * Set the value(s) to the value(s) raised to the power of the argument.
     * @param x double; the value to use as the power
     * @return T; the modified T
     */
    T pow(double x);

    /**
     * Set the value(s) to the signum function of the value(s); zero if the argument is zero, 1.0 if the argument is greater
     * than zero, -1.0 if the argument is less than zero.
     * @return T; the modified T
     */
    T signum();

    /**
     * Set the value(s) to the trigonometric sine of the value(s).
     * @return T; the modified T
     */
    T sin();

    /**
     * Set the value(s) to the hyperbolic sine of the value(s).
     * @return T; the modified T
     */
    T sinh();

    /**
     * Set the value(s) to the correctly rounded positive square root of the value(s).
     * @return T; the modified T
     */
    T sqrt();

    /**
     * Set the value(s) to the trigonometric tangent of the value(s).
     * @return T; the modified T
     */
    T tan();

    /**
     * Set the value(s) to the hyperbolic tangent of the value(s).
     * @return T; the modified T
     */
    T tanh();

    /**
     * Set the value(s) to the complement (1.0/x) of the value(s).
     * @return T; the modified T
     */
    T inv();

}
