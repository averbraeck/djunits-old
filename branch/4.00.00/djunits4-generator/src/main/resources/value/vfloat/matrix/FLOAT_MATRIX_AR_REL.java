package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float%TypeRel% Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeRel%Matrix extends AbstractFloatMatrixRel<%TypeRelUnit%, Float%TypeRel%Matrix, MutableFloat%TypeRel%Matrix, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Float%TypeRel%Matrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable Float%TypeRel%Matrix
     * @param unit %TypeRelUnit%; the unit of the new Relative Immutable Float%TypeRel%Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Float%TypeRel%Matrix(final float[][] values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Matrix.
     * @param values Float%TypeRel%[][]; the values of the entries in the new Relative Immutable Float%TypeRel%Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Float%TypeRel%Matrix(final Float%TypeRel%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Matrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit %TypeRelUnit%; the unit
     */
    Float%TypeRel%Matrix(final FloatMatrixData data, final %TypeRelUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TypeRel%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TypeRel%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Matrix instantiateType(final FloatMatrixData fmd, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeRel%Matrix
        instantiateMutableType(final FloatMatrixData fmd, final %TypeRelUnit% unit)
    {
        return new MutableFloat%TypeRel%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel% instantiateScalar(final float value, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }
        
%FORMULAS%%TypeRel%%
}
