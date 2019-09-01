package org.djunits4.value;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;

/**
 * The functions to be implemented for absolute vectors and matrices.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <AU> Absolute unit
 * @param <RU> Relative unit
 * @param <A> the absolute type
 * @param <R> the corresponding relative type
 */
public interface FunctionsAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, A extends Absolute & Value<AU>,
        R extends Relative & Value<RU>>
{
    /**
     * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the result is
     * stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel R; R the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector and the operand have a different size
     */
    A plus(R rel) throws ValueException;

    /**
     * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and the
     * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel R; R the right operand
     * @return A the subtraction of this vector and the operand
     * @throws ValueException in case this vector and the operand have a different size
     */
    A minus(R rel) throws ValueException;

    /**
     * Subtract an Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
     * the result is stored in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
     * otherwise the result is a dense vector or matrix.
     * @param abs A; A the right operand
     * @return R the subtraction of this vector and the operand
     * @throws ValueException in case this vector and the operand have a different size
     */
    R minus(A abs) throws ValueException;

}
