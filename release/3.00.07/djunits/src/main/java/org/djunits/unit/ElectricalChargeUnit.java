package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS_EMU;
import static org.djunits.unit.unitsystem.UnitSystem.CGS_ESU;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Units for electrical charge.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalChargeUnit extends LinearUnit<ElectricalChargeUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of electrical current, e.g., Ampere. */
    private final ElectricalCurrentUnit electricalCurrentUnit;

    /** the unit of time, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for electrical charge is Coulomb = A.s. */
    public static final ElectricalChargeUnit SI;

    /** Coulomb = A.s. */
    public static final ElectricalChargeUnit COULOMB;

    /** picoCoulomb = pA.s. */
    public static final ElectricalChargeUnit PICOCOULOMB;

    /** nanoCoulomb = nA.s. */
    public static final ElectricalChargeUnit NANOCOULOMB;

    /** microCoulomb = muA.s. */
    public static final ElectricalChargeUnit MICROCOULOMB;

    /** milliCoulomb = mA.s. */
    public static final ElectricalChargeUnit MILLICOULOMB;

    /** milliampere hour. */
    public static final ElectricalChargeUnit MILLIAMPERE_HOUR;

    /** milliampere second. */
    public static final ElectricalChargeUnit MILLIAMPERE_SECOND;

    /** ampere hour. */
    public static final ElectricalChargeUnit AMPERE_HOUR;

    /** kiloampere hour. */
    public static final ElectricalChargeUnit KILOAMPERE_HOUR;

    /** megaampere hour. */
    public static final ElectricalChargeUnit MEGAAMPERE_HOUR;

    /** Faraday. */
    public static final ElectricalChargeUnit FARADAY;

    /** atomic unit of charge. */
    public static final ElectricalChargeUnit ATOMIC_UNIT;

    /** statcoulomb (CGS ESU). */
    public static final ElectricalChargeUnit STATCOULOMB;

    /** franklin (CGS ESU). */
    public static final ElectricalChargeUnit FRANKLIN;

    /** esu (CGS ESU). */
    public static final ElectricalChargeUnit ESU;

    /** abcoulomb (CGS EMU). */
    public static final ElectricalChargeUnit ABCOULOMB;

    /** emu (CGS EMU). */
    public static final ElectricalChargeUnit EMU;

    static
    {
        SI = new ElectricalChargeUnit(ElectricalCurrentUnit.AMPERE, DurationUnit.SECOND, "ElectricalChargeUnit.coulomb",
                "ElectricalChargeUnit.C", SI_DERIVED, true);
        COULOMB = SI;
        PICOCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.picocoulomb", "ElectricalChargeUnit.pC", SI_DERIVED,
                COULOMB, 1.0E-12, true);
        NANOCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.nanocoulomb", "ElectricalChargeUnit.nC", SI_DERIVED,
                COULOMB, 1.0E-9, true);
        MICROCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.microcoulomb", "ElectricalChargeUnit.muC", SI_DERIVED,
                COULOMB, 1.0E-6, true);
        MILLICOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.millicoulomb", "ElectricalChargeUnit.mC", SI_DERIVED,
                COULOMB, 1.0E-3, true);
        MILLIAMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.MILLIAMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.milliampere_hour", "ElectricalChargeUnit.mAh", SI_DERIVED, true);
        AMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.AMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.ampere_hour", "ElectricalChargeUnit.Ah", SI_DERIVED, true);
        KILOAMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.KILOAMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.kiloampere_hour", "ElectricalChargeUnit.kAh", SI_DERIVED, true);
        MEGAAMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.MEGAAMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.megaampere_hour", "ElectricalChargeUnit.MAh", SI_DERIVED, true);
        MILLIAMPERE_SECOND = new ElectricalChargeUnit(ElectricalCurrentUnit.MILLIAMPERE, DurationUnit.SECOND,
                "ElectricalChargeUnit.milliampere_hour", "ElectricalChargeUnit.mAh", SI_DERIVED, true);
        FARADAY = new ElectricalChargeUnit("ElectricalChargeUnit.faraday", "ElectricalChargeUnit.F", OTHER, COULOMB, 96485.3383,
                true);
        ATOMIC_UNIT = new ElectricalChargeUnit("ElectricalChargeUnit.atomic_unit_of_charge", "ElectricalChargeUnit.e",
                SI_ACCEPTED, COULOMB, 1.6021765314E-19, true);
        STATCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.statcoulomb", "ElectricalChargeUnit.statC", CGS_ESU,
                COULOMB, 3.335641E-10, true);
        FRANKLIN = new ElectricalChargeUnit("ElectricalChargeUnit.franklin", "ElectricalChargeUnit.Fr", CGS_ESU, STATCOULOMB,
                1.0, true);
        ESU = new ElectricalChargeUnit("ElectricalChargeUnit.electrostatic_unit", "ElectricalChargeUnit.esu", CGS_ESU,
                STATCOULOMB, 1.0, true);
        ABCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.abcoulomb", "ElectricalChargeUnit.abC", CGS_EMU, COULOMB,
                10.0, true);
        EMU = new ElectricalChargeUnit("ElectricalChargeUnit.electromagnetic_unit", "ElectricalChargeUnit.emu", CGS_EMU,
                ABCOULOMB, 1.0, true);
    }

    /**
     * Build an ElectricalChargeUnit as an electrical current unit times a time unit. A Coulomb is an Ampere.second.
     * @param electricalCurrentUnit the unit of electrical current for the electrical charge unit, e.g., Ampere
     * @param durationUnit the unit of time for the electrical charge unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalChargeUnit(final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit,
            final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, COULOMB,
                electricalCurrentUnit.getScaleFactor() * durationUnit.getScaleFactor(), standardUnit);
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a user-defined ElectricalChargeUnit as an electrical current unit times a time unit.
     * @param electricalCurrentUnit the unit of electrical current for the electrical charge unit, e.g., Ampere
     * @param durationUnit the unit of time for the electrical charge unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ElectricalChargeUnit(final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit,
            final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        this(electricalCurrentUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a unit with a conversion factor to another unit, e.g., an abcoulomb is 10 Coulomb.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalChargeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final ElectricalChargeUnit referenceUnit, final double scaleFactorToReferenceUnit,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public ElectricalChargeUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalChargeUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit, false);
    }

    /**
     * @return electricalCurrentUnit
     */
    public final ElectricalCurrentUnit getElectricalCurrentUnit()
    {
        return this.electricalCurrentUnit;
    }

    /**
     * @return durationUnit
     */
    public final DurationUnit getDurationUnit()
    {
        return this.durationUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalChargeUnit getStandardUnit()
    {
        return COULOMB;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "sA";
    }

}
