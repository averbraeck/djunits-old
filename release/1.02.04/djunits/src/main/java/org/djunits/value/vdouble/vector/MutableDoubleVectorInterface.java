package org.djunits.value.vdouble.vector;

import org.djunits.unit.Unit;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Interface with specific (write) functions for the Mutable DoubleVector classes.
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
public interface MutableDoubleVectorInterface<U extends Unit<U>> extends DoubleVectorInterface<U>
{
    /**
     * Create a deep copy of this MutableDoubleVector. <br>
     * @return DoubleVector&lt;U&gt;; deep copy of this MutableDoubleVector
     */
    MutableDoubleVectorInterface<U> copy();

    /**
     * Create a immutable version of this MutableDoubleVector. <br>
     * @return DoubleVector&lt;U&gt;; mutable version of this MutableDoubleVector
     */
    DoubleVectorInterface<U> immutable();

    /**
     * Replace the value at index by the supplied value which is expressed in the standard SI unit.
     * @param index int; index of the value to replace
     * @param valueSI double; the value to store (expressed in the standard SI unit)
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    void setSI(int index, double valueSI) throws ValueException;

    /**
     * Replace the value at index by the supplied value which is in a compatible unit.
     * @param index int; index of the value to replace
     * @param value DoubleScalar&lt;U&gt;; the strongly typed value to store
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    void set(int index, DoubleScalar<U> value) throws ValueException;

    /**
     * Replace the value at index by the supplied value which is expressed in a supplied (compatible) unit.
     * @param index int; index of the value to replace
     * @param value double; the value to store (which is expressed in valueUnit)
     * @param valueUnit U; unit of the supplied value
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    void setInUnit(int index, double value, U valueUnit) throws ValueException;

    /**
     * Normalize the vector, i.e. scale the values to make the sum equal to 1.
     * @throws ValueException when the sum of the values is zero and normalization is not possible
     */
    void normalize() throws ValueException;

    /** {@inheritDoc} */
    MutableDoubleVectorInterface<U> toDense();

    /** {@inheritDoc} */
    MutableDoubleVectorInterface<U> toSparse();

}
