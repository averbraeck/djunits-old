package org.djunits.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Immutable %TypeRel% Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %TypeRel%Matrix extends TypedDoubleMatrixRel<%TypeUnit%, %TypeRel%Matrix, Mutable%TypeRel%Matrix, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double %TypeRel%Matrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double %TypeRel%Matrix
     * @param unit U; the unit of the new Relative Immutable Double %TypeRel%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeRel%Matrix(final double[][] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Matrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double %TypeRel%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeRel%Matrix(final %TypeRel%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Matrix.
     * @param data an internal data object
     * @param unit the unit
     */
    %TypeRel%Matrix(final DoubleMatrixData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Matrix instantiateType(final DoubleMatrixData dmd, final %TypeUnit% unit)
    {
        return new %TypeRel%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeRel%Matrix
        instantiateMutableType(final DoubleMatrixData dmd, final %TypeUnit% unit)
    {
        return new Mutable%TypeRel%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel% get(final int row, final int column) throws ValueException
    {
        return new %TypeRel%(getInUnit(row, column, getUnit()), getUnit());
    }
    
    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative %TypeRel% matrix.
     */
    public final %TypeAbs%Matrix toAbs()
    {
        return new %TypeAbs%Matrix(getData(), getUnit());
    }
        
%FORMULAS%%TypeRel%%
}
