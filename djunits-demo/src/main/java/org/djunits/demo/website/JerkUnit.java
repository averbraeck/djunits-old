package org.djunits.demo.website;

import org.djunits.unit.DurationUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearUnit;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Example from the website to test if the code on the website is correct
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
@SuppressWarnings({"javadoc"})
public class JerkUnit extends LinearUnit<JerkUnit>
{
    private final LengthUnit lengthUnit;

    private final DurationUnit durationUnit;

    public static final JerkUnit SI;

    public static final JerkUnit M_PER_S3;

    public static final JerkUnit CM_PER_S3;

    public static final JerkUnit FT_PER_S3;

    public static final JerkUnit JERK;

    static
    {
        SI = new JerkUnit(LengthUnit.METER, DurationUnit.SECOND, "meter per cubed second", "m/s^3", UnitSystem.SI_BASE);
        M_PER_S3 = SI;
        CM_PER_S3 = new JerkUnit(LengthUnit.CENTIMETER, DurationUnit.SECOND, "centimeter per cubed second", "cm/s^3",
                UnitSystem.SI_BASE);
        FT_PER_S3 = new JerkUnit(LengthUnit.FOOT, DurationUnit.SECOND, "foot per cubed second", "ft/s^3", UnitSystem.IMPERIAL);
        JERK = new JerkUnit("jerk", "jerk", UnitSystem.OTHER, SI, 0.3048);
    }

    public JerkUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, SI, lengthUnit.getScaleFactor() / Math.pow(durationUnit.getScaleFactor(), 3.0));
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    public JerkUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final JerkUnit referenceUnit,
            final double conversionFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    public final DurationUnit getDurationUnit()
    {
        return this.durationUnit;
    }

    @Override
    public final JerkUnit getStandardUnit()
    {
        return SI;
    }

    @Override
    public final String getSICoefficientsString()
    {
        return "m/s3";
    }
}
