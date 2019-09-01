package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double ElectricalPotentialMatrix, a matrix of values with a ElectricalPotentialUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class ElectricalPotentialMatrix extends
AbstractDoubleMatrixRel<ElectricalPotentialUnit, ElectricalPotentialMatrix, MutableElectricalPotentialMatrix, ElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalPotentialMatrix
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Double ElectricalPotentialMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalPotentialMatrix(final double[][] values, final ElectricalPotentialUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialMatrix.
     * @param values ElectricalPotential[][]; the values of the entries in the new Relative Immutable Double ElectricalPotentialMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalPotentialMatrix(final ElectricalPotential[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalPotentialUnit; the unit
     */
    ElectricalPotentialMatrix(final DoubleMatrixData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotentialMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotentialMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalPotentialMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotentialMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalPotentialMatrix instantiateMutableType(final DoubleMatrixData dmd, final ElectricalPotentialUnit unit)
    {
        return new MutableElectricalPotentialMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalPotential instantiateScalar(final double value, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotential(value, unit);
    }


    
}
