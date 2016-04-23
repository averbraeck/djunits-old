package org.djunits.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Immutable Float%TypeRel% Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Float%TypeRel%Matrix extends TypedFloatMatrixRel<%TypeUnit%, Float%TypeRel%Matrix, MutableFloat%TypeRel%Matrix, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Float%TypeRel%Matrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable Float%TypeRel%Matrix
     * @param unit U; the unit of the new Relative Immutable Float%TypeRel%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Float%TypeRel%Matrix(final float[][] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Matrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float%TypeRel%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Float%TypeRel%Matrix(final Float%TypeRel%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Matrix.
     * @param data an internal data object
     * @param unit the unit
     */
    Float%TypeRel%Matrix(final FloatMatrixData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Matrix instantiateType(final FloatMatrixData fmd, final %TypeUnit% unit)
    {
        return new Float%TypeRel%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeRel%Matrix
        instantiateMutableType(final FloatMatrixData fmd, final %TypeUnit% unit)
    {
        return new MutableFloat%TypeRel%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TypeRel% get(final int row, final int column) throws ValueException
    {
        return new Float%TypeRel%(getInUnit(row, column, getUnit()), getUnit());
    }
    
    /**
     * Translate the relative matrix into an absolute matrix (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative Float%TypeRel% matrix.
     */
    public final Float%TypeAbs%Matrix toAbs()
    {
        return new Float%TypeAbs%Matrix(getData(), getUnit());
    }
        
%FORMULAS%%TypeRel%%
}
