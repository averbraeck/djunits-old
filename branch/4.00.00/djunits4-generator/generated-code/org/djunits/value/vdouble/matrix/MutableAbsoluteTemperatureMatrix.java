package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable AbsoluteTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableAbsoluteTemperatureMatrix
        extends
        AbstractMutableDoubleMatrixAbs<AbsoluteTemperatureUnit, TemperatureUnit, AbsoluteTemperatureMatrix, TemperatureMatrix, MutableAbsoluteTemperatureMatrix, AbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Mutable Double AbsoluteTemperatureMatrix
     * @param unit AbsoluteTemperatureUnit; the unit of the new Absolute Mutable Double AbsoluteTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAbsoluteTemperatureMatrix(final double[][] values, final AbsoluteTemperatureUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureMatrix.
     * @param values AbsoluteTemperature[][]; the values of the entries in the new Absolute Mutable Double AbsoluteTemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAbsoluteTemperatureMatrix(final AbsoluteTemperature[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit AbsoluteTemperatureUnit; the unit
     */
    MutableAbsoluteTemperatureMatrix(final DoubleMatrixData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAbsoluteTemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAbsoluteTemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsoluteTemperatureMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TemperatureMatrix instantiateTypeRel(final DoubleMatrixData dmd, final TemperatureUnit unit)
    {
        return new TemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAbsoluteTemperatureMatrix
        instantiateMutableType(final DoubleMatrixData dmd, final AbsoluteTemperatureUnit unit)
    {
        return new MutableAbsoluteTemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsoluteTemperature instantiateScalar(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }
        
}