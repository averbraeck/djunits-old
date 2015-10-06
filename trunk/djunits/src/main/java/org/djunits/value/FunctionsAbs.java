package org.djunits.value;

import org.djunits.unit.Unit;

/**
 * The functions to be implemented for absolute vectors and matrices.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the Unit type
 * @param <A> the absolute type
 * @param <R> the corresponding relative type
 */
public interface FunctionsAbs<U extends Unit<U>, A extends Absolute & Value<U>, R extends Relative & Value<U>>
{
    /**
     * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the result is
     * stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel R the right operand
     * @return A the sum of this vector and the operand
     * @throws ValueException in case this vector and the operand have a different size
     */
    A plus(R rel) throws ValueException;

    /**
     * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and the
     * result is stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel R the right operand
     * @return A the subtraction of this vector and the operand
     * @throws ValueException in case this vector and the operand have a different size
     */
    A minus(R rel) throws ValueException;

    /**
     * Subtract an Absolute value from this Absolute value for a vector or matrix. The subtraction is done value by value and
     * the result is stored in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
     * otherwise the result is a dense vector or matrix.
     * @param rel A the right operand
     * @return R the subtraction of this vector and the operand
     * @throws ValueException in case this vector and the operand have a different size
     */
    R minus(A rel) throws ValueException;

}