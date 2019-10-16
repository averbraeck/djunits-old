package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.scalar.Dimensionless;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double DimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class DimensionlessVector extends AbstractDoubleVectorRel<DimensionlessUnit, Dimensionless, DimensionlessVector>
        implements DoubleMathFunctions, DimensionlessFunctions<DimensionlessUnit, DimensionlessVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an DimensionlessVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit DimensionlessUnit; the display unit of the vector data
     */
    public DimensionlessVector(final DoubleVectorData data, final DimensionlessUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Dimensionless> getScalarClass()
    {
        return Dimensionless.class;
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
    public final DimensionlessVector acos()
    {
        return assign(DoubleMathFunctions.ACOS);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector asin()
    {
        return assign(DoubleMathFunctions.ASIN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector atan()
    {
        return assign(DoubleMathFunctions.ATAN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector cbrt()
    {
        return assign(DoubleMathFunctions.CBRT);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector cos()
    {
        return assign(DoubleMathFunctions.COS);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector cosh()
    {
        return assign(DoubleMathFunctions.COSH);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector exp()
    {
        return assign(DoubleMathFunctions.EXP);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector expm1()
    {
        return assign(DoubleMathFunctions.EXPM1);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector log()
    {
        return assign(DoubleMathFunctions.LOG);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector log10()
    {
        return assign(DoubleMathFunctions.LOG10);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector log1p()
    {
        return assign(DoubleMathFunctions.LOG1P);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector pow(final double x)
    {
        return assign(DoubleMathFunctions.POW((float) x));
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector signum()
    {
        return assign(DoubleMathFunctions.SIGNUM);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector sin()
    {
        return assign(DoubleMathFunctions.SIN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector sinh()
    {
        return assign(DoubleMathFunctions.SINH);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector sqrt()
    {
        return assign(DoubleMathFunctions.SQRT);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector tan()
    {
        return assign(DoubleMathFunctions.TAN);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector tanh()
    {
        return assign(DoubleMathFunctions.TANH);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector inv()
    {
        return assign(DoubleMathFunctions.INV);
    }

}
