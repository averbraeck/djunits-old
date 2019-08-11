package org.djunits.value.vdouble.scalar;

import org.djunits.unit.MoneyUnit;
import org.djunits.unit.Unit;

/**
 * MoneyPerScalar is a generic class to indicate an amount of money in a certain currency per unit of a certain scalar. An
 * example would be a cost of 20 dollars per meter (Currency would be USD, Scalar would be Length, value would be 20). The idea
 * is to code this as follows:
 * 
 * <pre>
 * MoneyPerScalar<Length> costPerMeter = new MoneyPerScalar<>(20.0, MoneyUnit.USD, LengthUnit.METER);
 * </pre>
 * 
 * It is possible to calculate costs for a given scalar. The code below should output 200.0 USD:
 * 
 * <pre>
 * MoneyPerScalar<Length> costPerMeter = new MoneyPerScalar<>(20.0, MoneyUnit.USD, LengthUnit.METER);
 * Length len = new Length(10.0, LengthUnit.METER);
 * Money cost = costPerMeter.calculateFor(len);
 * System.out.println(cost);
 * </pre>
 * 
 * <br>
 * Copyright (c) 2003-2018 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://www.simulation.tudelft.nl/" target="_blank">www.simulation.tudelft.nl</a>. The
 * source code and binary code of this software is proprietary information of Delft University of Technology.
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit to use for the scalar
 */
public class MoneyPerScalar<U extends Unit<U>> extends AbstractDoubleScalarRel<U, MoneyPerScalar<U>>
{
    /** */
    private static final long serialVersionUID = 1L;

    /**
     * @param moneyValue the amount of money in the given unit per unit for the scalar
     * @param moneyUnit the unit for the money
     * @param unit the unit for the scalar
     */
    public MoneyPerScalar(final double moneyValue, final MoneyUnit moneyUnit, final U unit)
    {
        super(moneyValue, unit);
    }

    /** {@inheritDoc} */
    @Override
    public MoneyPerScalar<U> instantiateRel(final double value, final U unit)
    {
        return null;
    }
}
