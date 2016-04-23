package org.djunits.value.vdouble.scalar;

import org.djunits.unit.*;
import org.djunits.value.vdouble.scalar.Acceleration;

/**
 * Easy access methods for the %Type% DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;%Type%Unit&gt; value = new DoubleScalar.Rel&lt;%Type%Unit&gt;(100.0,
 * %Type%Unit.SI);</i><br>
 * we can now write <br>
 * <i>%Type% value = new %Type%(100.0, %Type%Unit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-16 02:04:00 +0200 (Fri, 16 Oct 2015) $, @version $Revision: 113 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %Type% extends TypedDoubleScalarRel<%Type%Unit, %Type%>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct %Type% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %Type%(final double value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %Type%(final %Type% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final %Type% instantiateTypeRel(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %Type% interpolate(final %Type% zero, final %Type% one, final double ratio)
    {
        return new %Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
%FORMULAS%%Type%%
}

