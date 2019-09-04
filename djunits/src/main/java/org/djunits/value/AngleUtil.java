package org.djunits.value;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;
import org.djunits.value.vdouble.scalar.Angle;
import org.djunits.value.vdouble.scalar.Direction;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vfloat.scalar.FloatAngle;
import org.djunits.value.vfloat.scalar.FloatDirection;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Utilities for Angles, such as normalization between 0 and 2 * PI.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public interface AngleUtil
{
    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle double; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static double normalize(final double angle)
    {
        double normalized = angle % (2 * Math.PI);
        if (normalized < 0.0)
        {
            normalized += 2 * Math.PI;
        }
        return normalized;
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle float; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static float normalize(final float angle)
    {
        float normalized = (float) (angle % (2 * Math.PI));
        if (normalized < 0.0)
        {
            normalized += 2 * Math.PI;
        }
        return normalized;
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle DoubleScalar.Abs&lt;DirectionUnit,AngleUnit&gt;; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static DoubleScalar.Abs<DirectionUnit, AngleUnit> normalize(final DoubleScalar.Abs<DirectionUnit, AngleUnit> angle)
    {
        double normalized = angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new DoubleScalar.Abs<>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle DoubleScalar.Rel&lt;AngleUnit&gt;; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static DoubleScalar.Rel<AngleUnit> normalize(final DoubleScalar.Rel<AngleUnit> angle)
    {
        double normalized = angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new DoubleScalar.Rel<AngleUnit>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle FloatScalar.Abs&lt;DirectionUnit,AngleUnit&gt;; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static FloatScalar.Abs<DirectionUnit, AngleUnit> normalize(final FloatScalar.Abs<DirectionUnit, AngleUnit> angle)
    {
        float normalized = (float) angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new FloatScalar.Abs<DirectionUnit, AngleUnit>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle FloatScalar.Rel&lt;AngleUnit&gt;; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static FloatScalar.Rel<AngleUnit> normalize(final FloatScalar.Rel<AngleUnit> angle)
    {
        float normalized = (float) angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new FloatScalar.Rel<AngleUnit>(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle Direction; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static Direction normalize(final Direction angle)
    {
        double normalized = angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new Direction(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle Angle; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static Angle normalize(final Angle angle)
    {
        double normalized = angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new Angle(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle FloatDirection; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static FloatDirection normalize(final FloatDirection angle)
    {
        float normalized = (float) angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new FloatDirection(normalized, angle.getUnit());
    }

    /**
     * Normalize an angle between 0 and 2 * PI.
     * @param angle FloatAngle; original angle.
     * @return angle between 0 and 2 * PI.
     */
    static FloatAngle normalize(final FloatAngle angle)
    {
        float normalized = (float) angle.getUnit().getScale().fromStandardUnit(normalize(angle.getSI()));
        return new FloatAngle(normalized, angle.getUnit());
    }
}
