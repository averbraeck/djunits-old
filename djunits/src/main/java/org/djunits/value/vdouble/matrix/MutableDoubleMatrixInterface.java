package org.djunits.value.vdouble.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 */
public interface MutableDoubleMatrixInterface<U extends Unit<U>> extends DoubleMatrixInterface<U>
{
    /**
     * Create a deep copy of this MutableDoubleMatrix. <br>
     * @return DoubleMatrix&lt;U&gt;; deep copy of this MutableDoubleMatrix
     */
    MutableDoubleMatrixInterface<U> copy();

    /**
     * Create a immutable version of this MutableDoubleMatrix. <br>
     * @return DoubleMatrix&lt;U&gt;; mutable version of this MutableDoubleMatrix
     */
    DoubleMatrixInterface<U> immutable();

    /**
     * Replace the value at row, column by the supplied value which is expressed in the standard SI unit.
     * @param row int; row of the value to replace
     * @param column int; column of the value to replace
     * @param valueSI double; the value to store (expressed in the standard SI unit)
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    void setSI(int row, int column, double valueSI) throws ValueException;

    /**
     * Replace the value at row, column by the supplied value which is in a compatible unit.
     * @param row int; row of the value to replace
     * @param column int; column of the value to replace
     * @param value DoubleScalar&lt;U&gt;; the strongly typed value to store
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    void set(int row, int column, DoubleScalar<U> value) throws ValueException;

    /**
     * Replace the value at row, column by the supplied value which is expressed in a supplied (compatible) unit.
     * @param row int; row of the value to replace
     * @param column int; column of the value to replace
     * @param value double; the value to store (which is expressed in valueUnit)
     * @param valueUnit U; unit of the supplied value
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    void setInUnit(int row, int column, double value, U valueUnit) throws ValueException;

    /**
     * Normalize the matrix, i.e. scale the values to make the sum equal to 1.
     * @throws ValueException when the sum of the values is zero and normalization is not possible
     */
    void normalize() throws ValueException;

    /** {@inheritDoc} */
    MutableDoubleMatrixInterface<U> toDense();

    /** {@inheritDoc} */
    MutableDoubleMatrixInterface<U> toSparse();

}
