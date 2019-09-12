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
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class DimensionlessVector extends AbstractDoubleVectorRel<DimensionlessUnit, Dimensionless, DimensionlessVector>
        implements DoubleMathFunctions, DimensionlessFunctions<DimensionlessUnit, DimensionlessVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an DimensionlessVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    public DimensionlessVector(final DoubleVectorData data, final DimensionlessUnit unit)
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
    public final DimensionlessVector acos()
    {
        assign(DoubleMathFunctions.ACOS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector asin()
    {
        assign(DoubleMathFunctions.ASIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector atan()
    {
        assign(DoubleMathFunctions.ATAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector cbrt()
    {
        assign(DoubleMathFunctions.CBRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector cos()
    {
        assign(DoubleMathFunctions.COS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector cosh()
    {
        assign(DoubleMathFunctions.COSH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector exp()
    {
        assign(DoubleMathFunctions.EXP);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector expm1()
    {
        assign(DoubleMathFunctions.EXPM1);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector log()
    {
        assign(DoubleMathFunctions.LOG);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector log10()
    {
        assign(DoubleMathFunctions.LOG10);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector log1p()
    {
        assign(DoubleMathFunctions.LOG1P);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector pow(final double x)
    {
        assign(DoubleMathFunctions.POW((float) x));
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector signum()
    {
        assign(DoubleMathFunctions.SIGNUM);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector sin()
    {
        assign(DoubleMathFunctions.SIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector sinh()
    {
        assign(DoubleMathFunctions.SINH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector sqrt()
    {
        assign(DoubleMathFunctions.SQRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector tan()
    {
        assign(DoubleMathFunctions.TAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector tanh()
    {
        assign(DoubleMathFunctions.TANH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector inv()
    {
        assign(DoubleMathFunctions.INV);
        return this;
    }

}
