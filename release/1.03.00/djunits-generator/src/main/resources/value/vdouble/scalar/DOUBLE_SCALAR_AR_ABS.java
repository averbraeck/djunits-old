package org.djunits.value.vdouble.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the Absolute %Type% DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Abs&lt;%TypeUnit%&gt; value = new DoubleScalar.Abs&lt;%TypeUnit%&gt;(100.0, %TypeUnit%.SI);</i><br>
 * we can now write <br>
 * <i>%TypeAbs% value = new %TypeAbs%(100.0, %TypeUnit%.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %TypeAbs% extends TypedDoubleScalarAbs<%TypeUnit%, %TypeAbs%, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final %TypeAbs% ZERO = new %TypeAbs%(0.0, %TypeUnit%.SI);

    /**
     * Construct %TypeAbs% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %TypeAbs%(final double value, final %TypeUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TypeAbs% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %TypeAbs%(final %TypeAbs% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs% instantiateTypeAbs(final double value, final %TypeUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel% instantiateTypeRel(final double value, final %TypeUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %TypeAbs% interpolate(final %TypeAbs% zero, final %TypeAbs% one, final double ratio)
    {
        return new %TypeAbs%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

%FORMULAS%%TypeAbs%%
}

