package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable %TypeRel% Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeRel%Matrix extends AbstractDoubleMatrixRel<%TypeRelUnit%, %TypeRel%Matrix, Mutable%TypeRel%Matrix, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double %TypeRel%Matrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double %TypeRel%Matrix
     * @param unit %TypeRelUnit%; the unit of the new Relative Immutable Double %TypeRel%Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeRel%Matrix(final double[][] values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Matrix.
     * @param values %TypeRel%[][]; the values of the entries in the new Relative Immutable Double %TypeRel%Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeRel%Matrix(final %TypeRel%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Matrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit %TypeRelUnit%; the unit
     */
    %TypeRel%Matrix(final DoubleMatrixData data, final %TypeRelUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Matrix instantiateType(final DoubleMatrixData dmd, final %TypeRelUnit% unit)
    {
        return new %TypeRel%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeRel%Matrix
        instantiateMutableType(final DoubleMatrixData dmd, final %TypeRelUnit% unit)
    {
        return new Mutable%TypeRel%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel% instantiateScalar(final double value, final %TypeRelUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }
        
%FORMULAS%%TypeRel%%
}