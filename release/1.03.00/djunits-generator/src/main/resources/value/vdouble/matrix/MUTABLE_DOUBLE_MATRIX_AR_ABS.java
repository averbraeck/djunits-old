package org.djunits.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Mutable %TypeAbs% Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Mutable%TypeAbs%Matrix
        extends
        MutableTypedDoubleMatrixAbs<%TypeUnit%, %TypeAbs%Matrix, %TypeRel%Matrix, Mutable%TypeAbs%Matrix, %TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Matrix.
     * @param values double[][]; the values of the entries in the new Absolute Mutable Double %TypeAbs%Matrix
     * @param unit U; the unit of the new Absolute Mutable Double %TypeAbs%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeAbs%Matrix(final double[][] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Matrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable Double %TypeAbs%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeAbs%Matrix(final %TypeAbs%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Matrix.
     * @param data an internal data object
     * @param unit the unit
     */
    Mutable%TypeAbs%Matrix(final DoubleMatrixData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs%Matrix instantiateTypeAbs(final DoubleMatrixData dmd, final %TypeUnit% unit)
    {
        return new %TypeAbs%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Matrix instantiateTypeRel(final DoubleMatrixData dmd, final %TypeUnit% unit)
    {
        return new %TypeRel%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeAbs%Matrix
        instantiateMutableType(final DoubleMatrixData dmd, final %TypeUnit% unit)
    {
        return new Mutable%TypeAbs%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs% get(final int row, final int column) throws ValueException
    {
        return new %TypeAbs%(getInUnit(row, column, getUnit()), getUnit());
    }
    
    /**
     * Translate the absolute matrix into a relative matrix (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute %TypeAbs% matrix.
     */
    public final Mutable%TypeRel%Matrix toRel()
    {
        return new Mutable%TypeRel%Matrix(getData(), getUnit());
    }
        
%FORMULAS%%TypeAbs%%
}
