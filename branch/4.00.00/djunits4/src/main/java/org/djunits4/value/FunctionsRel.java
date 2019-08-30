package org.djunits4.value;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;

/**
 * The functions to be implemented for relative vectors and matrices.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <AU> the Absolute Unit type
 * @param <RU> the Relative Unit type
 * @param <A> the absolute type
 * @param <R> the corresponding relative type
 */
public interface FunctionsRel<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>, A extends Absolute & Value<AU>,
        R extends Relative & Value<RU>>
{
    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and the result is
     * stored in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel R; R the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    R plus(R rel) throws ValueException;

    /**
     * Add an Absolute value to this Relative value for a vector or matrix. The addition is done value by value and the result
     * is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param abs A; A the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    A plus(A abs) throws ValueException;

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and the
     * result is stored in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel R; R the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    R minus(R rel) throws ValueException;

    /**
     * Multiply a Relative value by this Relative value for a vector or matrix. The multiplication is done value by value and
     * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
     * otherwise the result is a sparse vector or matrix.
     * @param rel R; R the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    R times(R rel) throws ValueException;

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and the result
     * is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the
     * result is a sparse vector or matrix.
     * @param rel R; R the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    R divide(R rel) throws ValueException;

}
