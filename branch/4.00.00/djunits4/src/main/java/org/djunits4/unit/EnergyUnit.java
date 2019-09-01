package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.scale.LinearScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of energy.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class EnergyUnit extends Unit<EnergyUnit>
{
    /** */
    private static final long serialVersionUID = 20140604L;

    /** The base, with "kgm2/s2" as the SI signature. */
    public static final UnitBase<EnergyUnit> BASE = new UnitBase<>("kgm2/s2");

    /** The SI unit for energy is Joule (J) = kgm2/s2. */
    public static final EnergyUnit SI =
            new EnergyUnit().build(new Unit.Builder<EnergyUnit>().setUnitBase(BASE).setId("J").setName("joule")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Joule. */
    public static final EnergyUnit JOULE = SI;

    /** microjoule. */
    public static final EnergyUnit MICROJOULE = JOULE.deriveSI(SIPrefixes.getUnit("mu"));

    /** millijoule. */
    public static final EnergyUnit MILLIJOULE = JOULE.deriveSI(SIPrefixes.getUnit("m"));

    /** kilojoule. */
    public static final EnergyUnit KILOJOULE = JOULE.deriveSI(SIPrefixes.getUnit("k"));

    /** megajoule. */
    public static final EnergyUnit MEGAJOULE = JOULE.deriveSI(SIPrefixes.getUnit("M"));

    /** gigajoule. */
    public static final EnergyUnit GIGAJOULE = JOULE.deriveSI(SIPrefixes.getUnit("G"));

    /** terajoule. */
    public static final EnergyUnit TERAJOULE = JOULE.deriveSI(SIPrefixes.getUnit("T"));

    /** petajoule. */
    public static final EnergyUnit PETAJOULE = JOULE.deriveSI(SIPrefixes.getUnit("P"));

    /** foot-pound force. */
    public static final EnergyUnit FOOT_POUND_FORCE = JOULE.deriveLinear(factorFL(ForceUnit.POUND_FORCE, LengthUnit.FOOT),
            "ft.lbf", "foot pound-force", UnitSystem.IMPERIAL);

    /** inch-pound force. */
    public static final EnergyUnit INCH_POUND_FORCE = JOULE.deriveLinear(factorFL(ForceUnit.POUND_FORCE, LengthUnit.INCH),
            "in.lbf", "inch pound-force", UnitSystem.IMPERIAL);

    /** British thermal unit (ISO). */
    public static final EnergyUnit BTU_ISO =
            JOULE.deriveLinear(1.0545E3, "BTU(ISO)", "British thermal unit (ISO)", UnitSystem.IMPERIAL);

    /** British thermal unit (International Table). */
    public static final EnergyUnit BTU_IT =
            JOULE.deriveLinear(1.05505585262E3, "BTU(IT)", "British thermal unit (International Table)", UnitSystem.IMPERIAL);

    /** calorie (International Table). */
    public static final EnergyUnit CALORIE_IT =
            JOULE.deriveLinear(4.1868, "cal(IT)", "calorie (International Table)", UnitSystem.IMPERIAL);

    /** calorie. */
    public static final EnergyUnit CALORIE = JOULE.deriveLinear(4.184, "cal", "calorie", UnitSystem.OTHER);

    /** kilocalorie. */
    public static final EnergyUnit KILOCALORIE = CALORIE.deriveLinear(1000.0, "kcal", "kilocalorie");

    /** watt-hour. */
    public static final EnergyUnit WATT_HOUR =
            new EnergyUnit().build(new Unit.Builder<EnergyUnit>().setUnitBase(BASE).setId("Wh").setName("watt-hour")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(new LinearScale(3600.0)));

    /** microwatt-hour. */
    public static final EnergyUnit MICROWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("mu"));

    /** milliwatt-hour. */
    public static final EnergyUnit MILLIWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("m"));

    /** kilowatt-hour. */
    public static final EnergyUnit KILOWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("k"));

    /** megawatt-hour. */
    public static final EnergyUnit MEGAWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("M"));

    /** gigawatt-hour. */
    public static final EnergyUnit GIGAWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("G"));

    /** terawatt-hour. */
    public static final EnergyUnit TERAWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("T"));

    /** petawatt-hour. */
    public static final EnergyUnit PETAWATT_HOUR = WATT_HOUR.deriveSI(SIPrefixes.getUnit("P"));

    /** electronvolt. */
    public static final EnergyUnit ELECTRONVOLT = new EnergyUnit().build(new Unit.Builder<EnergyUnit>().setUnitBase(BASE)
            .setId("eV").setName("electronvolt").setUnitSystem(UnitSystem.SI_ACCEPTED).setSiPrefixes(SIPrefixes.UNIT)
            .setScale(new LinearScale(1.602176565314E-19)));

    /** micro-electronvolt. */
    public static final EnergyUnit MICROELECTRONVOLT = ELECTRONVOLT.deriveSI(SIPrefixes.getUnit("mu"));

    /** milli-electronvolt. */
    public static final EnergyUnit MILLIELECTRONVOLT = ELECTRONVOLT.deriveSI(SIPrefixes.getUnit("m"));

    /** kilo-electronvolt. */
    public static final EnergyUnit KILOELECTRONVOLT = ELECTRONVOLT.deriveSI(SIPrefixes.getUnit("k"));

    /** mega-electronvolt. */
    public static final EnergyUnit MEGAELECTRONVOLT = ELECTRONVOLT.deriveSI(SIPrefixes.getUnit("M"));

    /** giga-electronvolt. */
    public static final EnergyUnit GIGAELECTRONVOLT = ELECTRONVOLT.deriveSI(SIPrefixes.getUnit("G"));

    /** sthene-meter (mts). */
    public static final EnergyUnit STHENE_METER = JOULE.deriveLinear(1000.0, "sn.m", "sthene meter", UnitSystem.MTS);

    /** erg (cgs). */
    public static final EnergyUnit ERG = JOULE.deriveLinear(1.0E-7, "erg", "erg", UnitSystem.CGS);

    /**
     * Determine the conversion factor to the base energy unit, given a force unit and a length unit.
     * @param force ForceUnit; the used force unit, e.g. lbf
     * @param distance LengthUnit; the used length unit, e.g. ft
     * @return double; the conversion factor from the provided units (e.g. ft.lbf) to the standard unit (e.g., J)
     */
    private static double factorFL(final ForceUnit force, final LengthUnit distance)
    {
        return force.getScale().toStandardUnit(1.0) * distance.getScale().toStandardUnit(1.0);
    }

}
