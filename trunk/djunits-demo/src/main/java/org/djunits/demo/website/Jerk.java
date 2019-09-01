package org.djunits.demo.website;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarRel;
import org.djunits.value.vdouble.scalar.Acceleration;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Frequency;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 16, 2016 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class Jerk extends AbstractDoubleScalarRel<JerkUnit, Jerk>
{

    public Jerk(final double value, final JerkUnit unit)
    {
        super(value, unit);
    }

    public Jerk(final Jerk value)
    {
        super(value);
    }

    @Override
    public final Jerk instantiateRel(final double value, final JerkUnit unit)
    {
        return new Jerk(value, unit);
    }

    public final Acceleration multiplyBy(final Duration v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    public final Frequency divideBy(final Acceleration v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    public static Jerk interpolate(final Jerk zero, final Jerk one, final double ratio)
    {
        return new Jerk(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
}
