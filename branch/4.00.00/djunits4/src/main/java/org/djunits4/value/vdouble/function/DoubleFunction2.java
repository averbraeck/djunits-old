package org.djunits4.value.vdouble.function;

/**
 * DoubleFunction carries out a specific transformation function on a double value that takes two operands.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public interface DoubleFunction2
{
    /**
     * Carry out a specific transformation function on a double value.
     * @param leftValue double; the value of the left operand
     * @param rightValue double; the value of the right operand
     * @return double; the result of the operation
     */
    double apply(double leftValue, double rightValue);

}
