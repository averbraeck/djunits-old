package org.djunits.value.vfloat.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Interface with specific (write) functions for the Mutable FloatMatrix classes.
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
public interface MutableFloatMatrixInterface<U extends Unit<U>> extends FloatMatrixInterface<U>
{
    /**
     * Create a deep copy of this MutableFloatMatrix. <br>
     * @return FloatMatrix&lt;U&gt;; deep copy of this MutableFloatMatrix
     */
    MutableFloatMatrixInterface<U> copy();

    /**
     * Create a immutable version of this MutableFloatMatrix. <br>
     * @return FloatMatrix&lt;U&gt;; mutable version of this MutableFloatMatrix
     */
    FloatMatrixInterface<U> immutable();

    /**
     * Replace the value at row, column by the supplied value which is expressed in the standard SI unit.
     * @param row int; row of the value to replace
     * @param column int; column of the value to replace
     * @param valueSI float; the value to store (expressed in the standard SI unit)
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    void setSI(int row, int column, float valueSI) throws ValueException;

    /**
     * Replace the value at row, column by the supplied value which is in a compatible unit.
     * @param row int; row of the value to replace
     * @param column int; column of the value to replace
     * @param value FloatScalar&lt;U&gt;; the strongly typed value to store
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    void set(int row, int column, FloatScalar<U> value) throws ValueException;

    /**
     * Replace the value at row, column by the supplied value which is expressed in a supplied (compatible) unit.
     * @param row int; row of the value to replace
     * @param column int; column of the value to replace
     * @param value float; the value to store (which is expressed in valueUnit)
     * @param valueUnit U; unit of the supplied value
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    void setInUnit(int row, int column, float value, U valueUnit) throws ValueException;

    /**
     * Normalize the matrix, i.e. scale the values to make the sum equal to 1.
     * @throws ValueException when the sum of the values is zero and normalization is not possible
     */
    void normalize() throws ValueException;

    /** {@inheritDoc} */
    MutableFloatMatrixInterface<U> toDense();

    /** {@inheritDoc} */
    MutableFloatMatrixInterface<U> toSparse();

}