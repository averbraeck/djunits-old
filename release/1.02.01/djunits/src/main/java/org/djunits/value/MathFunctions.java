package org.djunits.value;

import java.io.Serializable;

/**
 * Interface to force all functions of Math to be implemented.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <T> the type of the value that the functions operate on
 */
public interface MathFunctions<T> extends Serializable
{
    /**
     * Set the value(s) to their absolute value.
     * @return T; the modified T
     */
    T abs();

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
     * Set the value(s) to the smallest (closest to negative infinity) value(s) that are greater than or equal to the argument
     * and equal to a mathematical integer.
     * @return T; the modified T
     */
    T ceil();

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
     * Set the value(s) to the largest (closest to positive infinity) value(s) that are less than or equal to the argument and
     * equal to a mathematical integer.
     * @return T; the modified T
     */
    T floor();

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
     * Set the value(s) to the value(s) raised to the power of the argument.
     * @param x double; the value to use as the power
     * @return T; the modified T
     */
    T pow(double x);

    /**
     * Set the value(s) to the value(s) that are closest in value to the argument and equal to a mathematical integer.
     * @return T; the modified T
     */
    T rint();

    /**
     * Set the value(s) to the closest long to the argument with ties rounding up.
     * @return T; the modified T
     */
    T round();

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
     * Set the value(s) to approximately equivalent angle(s) measured in degrees.
     * @return T; the modified T
     */
    T toDegrees();

    /**
     * Set the value(s) to approximately equivalent angle(s) measured in radians.
     * @return T; the modified T
     */
    T toRadians();

    /**
     * Set the value(s) to the complement (1.0/x) of the value(s).
     * @return T; the modified T
     */
    T inv();

}
