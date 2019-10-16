package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Dimensionless;
import org.djunits4.value.vdouble.vector.DimensionlessVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double DimensionlessMatrix, a matrix of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class DimensionlessMatrix
        extends AbstractDoubleMatrixRel<DimensionlessUnit, Dimensionless, DimensionlessVector, DimensionlessMatrix>
        implements DimensionlessFunctions<DimensionlessUnit, DimensionlessMatrix>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    public DimensionlessMatrix(final DoubleMatrixData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Dimensionless> getScalarClass()
    {
        return Dimensionless.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<DimensionlessVector> getVectorClass()
    {
        return DimensionlessVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public DimensionlessMatrix instantiateMatrix(final DoubleMatrixData dmd, final DimensionlessUnit displayUnit)
    {
        return new DimensionlessMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public DimensionlessVector instantiateVector(final DoubleVectorData dvd, final DimensionlessUnit displayUnit)
    {
        return new DimensionlessVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Dimensionless instantiateScalarSI(final double valueSI, final DimensionlessUnit displayUnit)
    {
        Dimensionless result = Dimensionless.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix acos()
    {
        return assign(DoubleMathFunctions.ACOS);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix asin()
    {
        return assign(DoubleMathFunctions.ASIN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix atan()
    {
        return assign(DoubleMathFunctions.ATAN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix cbrt()
    {
        return assign(DoubleMathFunctions.CBRT);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix cos()
    {
        return assign(DoubleMathFunctions.COS);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix cosh()
    {
        return assign(DoubleMathFunctions.COSH);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix exp()
    {
        return assign(DoubleMathFunctions.EXP);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix expm1()
    {
        return assign(DoubleMathFunctions.EXPM1);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix log()
    {
        return assign(DoubleMathFunctions.LOG);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix log10()
    {
        return assign(DoubleMathFunctions.LOG10);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix log1p()
    {
        return assign(DoubleMathFunctions.LOG1P);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix pow(final double x)
    {
        return assign(DoubleMathFunctions.POW((float) x));
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix signum()
    {
        return assign(DoubleMathFunctions.SIGNUM);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix sin()
    {
        return assign(DoubleMathFunctions.SIN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix sinh()
    {
        return assign(DoubleMathFunctions.SINH);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix sqrt()
    {
        return assign(DoubleMathFunctions.SQRT);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix tan()
    {
        return assign(DoubleMathFunctions.TAN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix tanh()
    {
        return assign(DoubleMathFunctions.TANH);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix inv()
    {
        return assign(DoubleMathFunctions.INV);
    }

}
