package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double RadioActivityMatrix, a matrix of values with a RadioActivityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.259Z")
public class RadioActivityMatrix extends
AbstractDoubleMatrixRel<RadioActivityUnit, RadioActivityMatrix, MutableRadioActivityMatrix, RadioActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double RadioActivityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double RadioActivityMatrix
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable Double RadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public RadioActivityMatrix(final double[][] values, final RadioActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityMatrix.
     * @param values RadioActivity[][]; the values of the entries in the new Relative Immutable Double RadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public RadioActivityMatrix(final RadioActivity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    RadioActivityMatrix(final DoubleMatrixData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final RadioActivityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final RadioActivityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final RadioActivityMatrix instantiateType(final DoubleMatrixData dmd, final RadioActivityUnit unit)
    {
        return new RadioActivityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableRadioActivityMatrix instantiateMutableType(final DoubleMatrixData dmd, final RadioActivityUnit unit)
    {
        return new MutableRadioActivityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final RadioActivity instantiateScalar(final double value, final RadioActivityUnit unit)
    {
        return new RadioActivity(value, unit);
    }


    
}
