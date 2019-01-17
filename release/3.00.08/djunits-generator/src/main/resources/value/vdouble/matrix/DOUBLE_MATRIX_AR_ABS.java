package org.djunits.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Immutable %TypeAbs% Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %TypeAbs%Matrix extends
        AbstractDoubleMatrixAbs<%TypeAbsUnit%, %TypeRelUnit%, %TypeAbs%Matrix, %TypeRel%Matrix, Mutable%TypeAbs%Matrix, %TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double %TypeRel%Matrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable Double %TypeRel%Matrix
     * @param unit U; the unit of the new Absolute Immutable Double %TypeRel%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeAbs%Matrix(final double[][] values, final %TypeAbsUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeRel%Matrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double %TypeRel%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeAbs%Matrix(final %TypeAbs%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeRel%Matrix.
     * @param data an internal data object
     * @param unit the unit
     */
    %TypeAbs%Matrix(final DoubleMatrixData data, final %TypeAbsUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs%Matrix instantiateTypeAbs(final DoubleMatrixData dmd, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Matrix instantiateTypeRel(final DoubleMatrixData dmd, final %TypeRelUnit% unit)
    {
        return new %TypeRel%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeAbs%Matrix
        instantiateMutableType(final DoubleMatrixData dmd, final %TypeAbsUnit% unit)
    {
        return new Mutable%TypeAbs%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs% instantiateScalar(final double value, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }
    
%FORMULAS%%TypeAbs%%
}
