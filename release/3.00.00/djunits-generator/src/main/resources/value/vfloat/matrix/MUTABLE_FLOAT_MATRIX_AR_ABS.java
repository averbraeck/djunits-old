package org.djunits.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Mutable Float%TypeAbs% Matrix.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloat%TypeAbs%Matrix
        extends
        AbstractMutableFloatMatrixAbs<%TypeAbsUnit%, %TypeRelUnit%, Float%TypeAbs%Matrix, Float%TypeRel%Matrix, MutableFloat%TypeAbs%Matrix, Float%TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Matrix.
     * @param values float[][]; the values of the entries in the new Absolute Mutable Float%TypeAbs%Matrix
     * @param unit U; the unit of the new Absolute Mutable Float%TypeAbs%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Matrix(final float[][] values, final %TypeAbsUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Matrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable Float%TypeAbs%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeAbs%Matrix(final Float%TypeAbs%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Matrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%TypeAbs%Matrix(final FloatMatrixData data, final %TypeAbsUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%TypeAbs%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%TypeAbs%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeAbs%Matrix instantiateTypeAbs(final FloatMatrixData fmd, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Matrix instantiateTypeRel(final FloatMatrixData fmd, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeAbs%Matrix
        instantiateMutableType(final FloatMatrixData fmd, final %TypeAbsUnit% unit)
    {
        return new MutableFloat%TypeAbs%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeAbs% instantiateScalar(final float value, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }
        
%FORMULAS%%TypeAbs%%
}
