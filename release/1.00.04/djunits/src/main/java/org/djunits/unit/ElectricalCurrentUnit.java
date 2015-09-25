package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS_EMU;
import static org.djunits.unit.unitsystem.UnitSystem.CGS_ESU;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard units for electrical current.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalCurrentUnit extends Unit<ElectricalCurrentUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for electrical current is Ampere. */
    public static final ElectricalCurrentUnit SI;

    /** Ampere. */
    public static final ElectricalCurrentUnit AMPERE;

    /** nanoampere. */
    public static final ElectricalCurrentUnit NANOAMPERE;

    /** microampere. */
    public static final ElectricalCurrentUnit MICROAMPERE;

    /** milliampere. */
    public static final ElectricalCurrentUnit MILLIAMPERE;

    /** kiloampere. */
    public static final ElectricalCurrentUnit KILOAMPERE;

    /** statampere (GCS ESU). */
    public static final ElectricalCurrentUnit STATAMPERE;

    /** abampere (GCS EMU). */
    public static final ElectricalCurrentUnit ABAMPERE;

    static
    {
        SI = new ElectricalCurrentUnit("ElectricalCurrentUnit.ampere", "ElectricalCurrentUnit.A", SI_BASE);
        AMPERE = SI;
        NANOAMPERE =
                new ElectricalCurrentUnit("ElectricalCurrentUnit.nanoampere", "ElectricalCurrentUnit.nA", SI_BASE, AMPERE,
                        1.0E-9, true);
        MICROAMPERE =
                new ElectricalCurrentUnit("ElectricalCurrentUnit.microampere", "ElectricalCurrentUnit.muA", SI_BASE, AMPERE,
                        1.0E-6, true);
        MILLIAMPERE =
                new ElectricalCurrentUnit("ElectricalCurrentUnit.milliampere", "ElectricalCurrentUnit.mA", SI_BASE, AMPERE,
                        0.001, true);
        KILOAMPERE =
                new ElectricalCurrentUnit("ElectricalCurrentUnit.kiloampere", "ElectricalCurrentUnit.kA", SI_BASE, AMPERE,
                        1000.0, true);
        STATAMPERE =
                new ElectricalCurrentUnit("ElectricalCurrentUnit.statampere", "ElectricalCurrentUnit.statA", CGS_ESU, AMPERE,
                        3.335641E-10, true);
        ABAMPERE =
                new ElectricalCurrentUnit("ElectricalCurrentUnit.abampere", "ElectricalCurrentUnit.abA", CGS_EMU, AMPERE, 10.0,
                        true);
    }

    /**
     * @param nameKey the key to the locale file for the long name of the unit
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    private ElectricalCurrentUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(nameKey, abbreviationKey, unitSystem, true);
    }

    /**
     * Build a unit with a conversion factor to another unit, e.g., a milli Ampere is 0.001 Ampere.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalCurrentUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final ElectricalCurrentUnit referenceUnit,
            final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public ElectricalCurrentUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalCurrentUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrentUnit getStandardUnit()
    {
        return AMPERE;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "A";
    }

}
