package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.MTS;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;
import static org.djunits.unit.unitsystem.UnitSystem.US_CUSTOMARY;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard mass units. Several conversion factors have been taken from <a
 * href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MassUnit extends Unit<MassUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for mass is kilogram. */
    public static final MassUnit SI;

    /** kilogram. */
    public static final MassUnit KILOGRAM;

    /** gram. */
    public static final MassUnit GRAM;

    /** pound. */
    public static final MassUnit POUND;

    /** pound. */
    public static final MassUnit OUNCE;

    /** long ton = 2240 lb. */
    public static final MassUnit TON_LONG;

    /** short ton = 2000 lb. */
    public static final MassUnit TON_SHORT;

    /** metric ton = 1000 kg. */
    public static final MassUnit TON_METRIC;

    /** metric ton = 1000 kg. */
    public static final MassUnit TONNE;

    /** dalton. */
    public static final MassUnit DALTON;

    static
    {
        SI = new MassUnit("MassUnit.kilogram", "MassUnit.kg", SI_BASE);
        KILOGRAM = SI;
        GRAM = new MassUnit("MassUnit.gram", "MassUnit.g", SI_BASE, KILOGRAM, 0.001, true);
        POUND = new MassUnit("MassUnit.pound", "MassUnit.lb", IMPERIAL, KILOGRAM, 0.45359237, true);
        OUNCE = new MassUnit("MassUnit.ounce", "MassUnit.oz", IMPERIAL, POUND, 1.0 / 16.0, true);
        TON_LONG = new MassUnit("MassUnit.long_ton", "MassUnit.long_tn", IMPERIAL, POUND, 2240.0, true);
        TON_SHORT = new MassUnit("MassUnit.short_ton", "MassUnit.sh_tn", US_CUSTOMARY, POUND, 2000.0, true);
        TON_METRIC = new MassUnit("MassUnit.metric_ton", "MassUnit.t", SI_ACCEPTED, KILOGRAM, 1000.0, true);
        TONNE = new MassUnit("MassUnit.tonne_(mts)", "MassUnit.t_(mts)", MTS, KILOGRAM, 1000.0, true);
        DALTON = new MassUnit("MassUnit.dalton", "MassUnit.Da", SI_ACCEPTED, KILOGRAM, 1.6605388628E-27, true);
    }

    /**
     * Build a standard MassUnit.
     * @param nameKey the key to the locale file for the long name of the unit
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    private MassUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(nameKey, abbreviationKey, unitSystem, true);
    }

    /**
     * Build a MassUnit with a conversion factor to another MassUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MassUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
        final MassUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
    }

    /**
     * Build a user-defined MassUnit with a conversion factor to another MassUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MassUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final MassUnit referenceUnit,
        final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /** {@inheritDoc} */
    @Override
    public final MassUnit getStandardUnit()
    {
        return KILOGRAM;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kg";
    }

}
