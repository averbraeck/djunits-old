package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.MTS;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;
import static org.djunits.unit.unitsystem.UnitSystem.US_CUSTOMARY;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard mass units. Several conversion factors have been taken from
 * <a href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MassUnit extends LinearUnit<MassUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for mass is kilogram. */
    public static final MassUnit SI;

    /** kilogram. */
    public static final MassUnit KILOGRAM;

    /** femtogram. */
    public static final MassUnit FEMTOGRAM;

    /** picogram. */
    public static final MassUnit PICOGRAM;

    /** nanogram. */
    public static final MassUnit NANOGRAM;

    /** microgram. */
    public static final MassUnit MICROGRAM;

    /** milligram. */
    public static final MassUnit MILLIGRAM;

    /** gram. */
    public static final MassUnit GRAM;

    /** megagram. */
    public static final MassUnit MEGAGRAM;

    /** gigagram. */
    public static final MassUnit GIGAGRAM;

    /** teragram. */
    public static final MassUnit TERAGRAM;

    /** petagram. */
    public static final MassUnit PETAGRAM;

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

    /** microelectronvolt. */
    public static final MassUnit MICROELECTRONVOLT;

    /** millielectronvolt. */
    public static final MassUnit MILLIELECTRONVOLT;

    /** electronvolt = 1.782661907E-36 kg. See http://physics.nist.gov/cuu/Constants/Table/allascii.txt. */
    public static final MassUnit ELECTRONVOLT;

    /** kiloelectronvolt. */
    public static final MassUnit KILOELECTRONVOLT;

    /** megaelectronvolt. */
    public static final MassUnit MEGAELECTRONVOLT;

    /** gigaelectronvolt. */
    public static final MassUnit GIGAELECTRONVOLT;

    /** teraelectronvolt. */
    public static final MassUnit TERAELECTRONVOLT;

    /** petaelectronvolt. */
    public static final MassUnit PETAELECTRONVOLT;

    /** exaelectronvolt. */
    public static final MassUnit EXAELECTRONVOLT;

    static
    {
        SI = new MassUnit("MassUnit.kg", SI_BASE);
        KILOGRAM = SI;
        GRAM = new MassUnit("MassUnit.g", SI_BASE, KILOGRAM, 0.001);
        FEMTOGRAM = new MassUnit("MassUnit.fg", SI_DERIVED, GRAM, 1.0E-15);
        PICOGRAM = new MassUnit("MassUnit.pg", SI_DERIVED, GRAM, 1.0E-12);
        NANOGRAM = new MassUnit("MassUnit.ng", SI_DERIVED, GRAM, 1.0E-9);
        MICROGRAM = new MassUnit("MassUnit.mug", SI_DERIVED, GRAM, 1.0E-6);
        MILLIGRAM = new MassUnit("MassUnit.mg", SI_DERIVED, GRAM, 0.001);
        MEGAGRAM = new MassUnit("MassUnit.Mg", SI_DERIVED, GRAM, 1.0E6);
        GIGAGRAM = new MassUnit("MassUnit.Gg", SI_DERIVED, GRAM, 1.0E9);
        TERAGRAM = new MassUnit("MassUnit.Tg", SI_DERIVED, GRAM, 1.0E12);
        PETAGRAM = new MassUnit("MassUnit.Pg", SI_DERIVED, GRAM, 1.0E15);
        POUND = new MassUnit("MassUnit.lb", IMPERIAL, KILOGRAM, 0.45359237);
        OUNCE = new MassUnit("MassUnit.oz", IMPERIAL, POUND, 1.0 / 16.0);
        TON_LONG = new MassUnit("MassUnit.long_tn", IMPERIAL, POUND, 2240.0);
        TON_SHORT = new MassUnit("MassUnit.sh_tn", US_CUSTOMARY, POUND, 2000.0);
        TON_METRIC = new MassUnit("MassUnit.t", SI_ACCEPTED, KILOGRAM, 1000.0);
        TONNE = new MassUnit("MassUnit.t_(mts)", MTS, KILOGRAM, 1000.0);
        DALTON = new MassUnit("MassUnit.Da", SI_ACCEPTED, KILOGRAM, 1.6605388628E-27);
        ELECTRONVOLT = new MassUnit("MassUnit.eV", OTHER, KILOGRAM, 1.782661907E-36);
        MICROELECTRONVOLT = new MassUnit("MassUnit.mueV", OTHER, ELECTRONVOLT, 1.0E-6);
        MILLIELECTRONVOLT = new MassUnit("MassUnit.meV", OTHER, ELECTRONVOLT, 1.0E-3);
        KILOELECTRONVOLT = new MassUnit("MassUnit.keV", OTHER, ELECTRONVOLT, 1.0E3);
        MEGAELECTRONVOLT = new MassUnit("MassUnit.MeV", OTHER, ELECTRONVOLT, 1.0E6);
        GIGAELECTRONVOLT = new MassUnit("MassUnit.GeV", OTHER, ELECTRONVOLT, 1.0E9);
        TERAELECTRONVOLT = new MassUnit("MassUnit.TeV", OTHER, ELECTRONVOLT, 1.0E12);
        PETAELECTRONVOLT = new MassUnit("MassUnit.PeV", OTHER, ELECTRONVOLT, 1.0E15);
        EXAELECTRONVOLT = new MassUnit("MassUnit.EeV", OTHER, ELECTRONVOLT, 1.0E18);
    }

    /**
     * Build a standard MassUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private MassUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a MassUnit with a conversion factor to another MassUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit MassUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private MassUnit(final String abbreviationKey, final UnitSystem unitSystem, final MassUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
    }

    /**
     * Build a user-defined MassUnit with a conversion factor to another MassUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit MassUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MassUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final MassUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
