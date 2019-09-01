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
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        SI = new ElectricalChargeUnit(ElectricalCurrentUnit.AMPERE, DurationUnit.SECOND, "ElectricalChargeUnit.C", SI_DERIVED);
        COULOMB = SI;
        PICOCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.pC", SI_DERIVED, COULOMB, 1.0E-12);
        NANOCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.nC", SI_DERIVED, COULOMB, 1.0E-9);
        MICROCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.muC", SI_DERIVED, COULOMB, 1.0E-6);
        MILLICOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.mC", SI_DERIVED, COULOMB, 1.0E-3);
        MILLIAMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.MILLIAMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.mAh", SI_DERIVED);
        AMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.AMPERE, DurationUnit.HOUR, "ElectricalChargeUnit.Ah",
                SI_DERIVED);
        KILOAMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.KILOAMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.kAh", SI_DERIVED);
        MEGAAMPERE_HOUR = new ElectricalChargeUnit(ElectricalCurrentUnit.MEGAAMPERE, DurationUnit.HOUR,
                "ElectricalChargeUnit.MAh", SI_DERIVED);
        MILLIAMPERE_SECOND = new ElectricalChargeUnit(ElectricalCurrentUnit.MILLIAMPERE, DurationUnit.SECOND,
                "ElectricalChargeUnit.mAs", SI_DERIVED);
        FARADAY = new ElectricalChargeUnit("ElectricalChargeUnit.F", OTHER, COULOMB, 96485.3383);
        ATOMIC_UNIT = new ElectricalChargeUnit("ElectricalChargeUnit.e", SI_ACCEPTED, COULOMB, 1.6021765314E-19);
        STATCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.statC", CGS_ESU, COULOMB, 3.335641E-10);
        FRANKLIN = new ElectricalChargeUnit("ElectricalChargeUnit.Fr", CGS_ESU, STATCOULOMB, 1.0);
        ESU = new ElectricalChargeUnit("ElectricalChargeUnit.esu", CGS_ESU, STATCOULOMB, 1.0);
        ABCOULOMB = new ElectricalChargeUnit("ElectricalChargeUnit.abC", CGS_EMU, COULOMB, 10.0);
        EMU = new ElectricalChargeUnit("ElectricalChargeUnit.emu", CGS_EMU, ABCOULOMB, 1.0);
    }

    /**
     * Build an ElectricalChargeUnit as an electrical current unit times a time unit. A Coulomb is an Ampere.second.
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical charge unit, e.g.,
     *            Ampere
     * @param durationUnit DurationUnit; the unit of time for the electrical charge unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ElectricalChargeUnit(final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, COULOMB, electricalCurrentUnit.getScaleFactor() * durationUnit.getScaleFactor());
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a user-defined ElectricalChargeUnit as an electrical current unit times a time unit.
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical charge unit, e.g.,
     *            Ampere
     * @param durationUnit DurationUnit; the unit of time for the electrical charge unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ElectricalChargeUnit(final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit,
            final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, COULOMB, electricalCurrentUnit.getScaleFactor() * durationUnit.getScaleFactor());
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a unit with a conversion factor to another unit, e.g., an abcoulomb is 10 Coulomb.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalChargeUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private ElectricalChargeUnit(final String abbreviationKey, final UnitSystem unitSystem,
            final ElectricalChargeUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalChargeUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public ElectricalChargeUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalChargeUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
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
