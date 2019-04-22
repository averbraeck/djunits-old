package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS_EMU;
import static org.djunits.unit.unitsystem.UnitSystem.CGS_ESU;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard units for electrical current.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalCurrentUnit extends LinearUnit<ElectricalCurrentUnit>
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

    /** megaampere. */
    public static final ElectricalCurrentUnit MEGAAMPERE;

    /** statampere (GCS ESU). */
    public static final ElectricalCurrentUnit STATAMPERE;

    /** abampere (GCS EMU). */
    public static final ElectricalCurrentUnit ABAMPERE;

    static
    {
        SI = new ElectricalCurrentUnit("ElectricalCurrentUnit.A", SI_BASE);
        AMPERE = SI;
        NANOAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.nA", SI_BASE, AMPERE, 1.0E-9);
        MICROAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.muA", SI_BASE, AMPERE, 1.0E-6);
        MILLIAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.mA", SI_BASE, AMPERE, 0.001);
        KILOAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.kA", SI_BASE, AMPERE, 1000.0);
        MEGAAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.MA", SI_BASE, AMPERE, 1.0E6);
        STATAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.statA", CGS_ESU, AMPERE, 3.335641E-10);
        ABAMPERE = new ElectricalCurrentUnit("ElectricalCurrentUnit.abA", CGS_EMU, AMPERE, 10.0);
    }

    /**
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ElectricalCurrentUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a unit with a conversion factor to another unit, e.g., a milli Ampere is 0.001 Ampere.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalCurrentUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private ElectricalCurrentUnit(final String abbreviationKey, final UnitSystem unitSystem,
            final ElectricalCurrentUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalCurrentUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public ElectricalCurrentUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalCurrentUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
