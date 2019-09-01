package org.djunits.unit;

/**
 * Easy access methods for the DoubleScalar, DoubleVector, DoubleMatrix classes and their Float equivalents. Instead of <br>
 * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
 * we can now write <br>
 * <i>Length margin = new Length(0.2, METER);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@SuppressWarnings({"checkstyle:interfaceistype", "checkstyle:javadocmethod", "checkstyle:javadoctype",
        "checkstyle:javadocvariable", "checkstyle:linelength", "checkstyle:leftcurly", "checkstyle:rightcurly", "javadoc"})
public interface UNITS
{
    // @formatter:off
    
    /****************************************************************************************************************/
    /************************************************ ACCELERATION **************************************************/
    /****************************************************************************************************************/

    AccelerationUnit METER_PER_SECOND_2       = AccelerationUnit.METER_PER_SECOND_2;
    AccelerationUnit KM_PER_HOUR_2            = AccelerationUnit.KM_PER_HOUR_2;
    AccelerationUnit FOOT_PER_SECOND_2        = AccelerationUnit.FOOT_PER_SECOND_2;
    AccelerationUnit INCH_PER_SECOND_2        = AccelerationUnit.INCH_PER_SECOND_2;
    AccelerationUnit MILE_PER_HOUR_2          = AccelerationUnit.MILE_PER_HOUR_2;
    AccelerationUnit MILE_PER_SECOND_2        = AccelerationUnit.MILE_PER_SECOND_2;
    AccelerationUnit KNOT_PER_SECOND          = AccelerationUnit.KNOT_PER_SECOND;
    AccelerationUnit MILE_PER_HOUR_PER_SECOND = AccelerationUnit.MILE_PER_HOUR_PER_SECOND;
    AccelerationUnit STANDARD_GRAVITY         = AccelerationUnit.STANDARD_GRAVITY;
    AccelerationUnit GAL                      = AccelerationUnit.GAL;

    /****************************************************************************************************************/
    /************************************************* ANGLESOLID ***************************************************/
    /****************************************************************************************************************/

    AngleSolidUnit STERADIAN     = AngleSolidUnit.STERADIAN;
    AngleSolidUnit SQUARE_DEGREE = AngleSolidUnit.SQUARE_DEGREE;

    /****************************************************************************************************************/
    /*************************************************** ANGLE  *****************************************************/
    /****************************************************************************************************************/

    AngleUnit RADIAN               = AngleUnit.RADIAN;
    AngleUnit PERCENT              = AngleUnit.PERCENT;
    AngleUnit DEGREE               = AngleUnit.DEGREE;
    AngleUnit ARCMINUTE            = AngleUnit.ARCMINUTE;
    AngleUnit ARCSECOND            = AngleUnit.ARCSECOND;
    AngleUnit GRAD                 = AngleUnit.GRAD;
    AngleUnit CENTESIMAL_ARCMINUTE = AngleUnit.CENTESIMAL_ARCMINUTE;
    AngleUnit CENTESIMAL_ARCSECOND = AngleUnit.CENTESIMAL_ARCSECOND;

    /****************************************************************************************************************/
    /**************************************************** AREA ******************************************************/
    /****************************************************************************************************************/

    AreaUnit SQUARE_ATTOMETER     = AreaUnit.SQUARE_ATTOMETER;
    AreaUnit SQUARE_FEMTOMETER    = AreaUnit.SQUARE_FEMTOMETER;
    AreaUnit SQUARE_PICOMETER     = AreaUnit.SQUARE_PICOMETER;
    AreaUnit SQUARE_NANOMETER     = AreaUnit.SQUARE_NANOMETER;
    AreaUnit SQUARE_MICROMETER    = AreaUnit.SQUARE_MICROMETER;
    AreaUnit SQUARE_MILLIMETER    = AreaUnit.SQUARE_MILLIMETER;
    AreaUnit SQUARE_METER         = AreaUnit.SQUARE_METER;
    AreaUnit SQUARE_CENTIMETER    = AreaUnit.SQUARE_CENTIMETER;
    AreaUnit SQUARE_DECIMETER     = AreaUnit.SQUARE_DECIMETER;
    AreaUnit SQUARE_DEKAMETER     = AreaUnit.SQUARE_DEKAMETER;
    AreaUnit SQUARE_HECTOMETER    = AreaUnit.SQUARE_HECTOMETER;
    AreaUnit SQUARE_KILOMETER     = AreaUnit.SQUARE_KILOMETER;
    AreaUnit SQUARE_MEGAMETER     = AreaUnit.SQUARE_MEGAMETER;
    AreaUnit CENTIARE             = AreaUnit.CENTIARE;
    AreaUnit ARE                  = AreaUnit.ARE;
    AreaUnit HECTARE              = AreaUnit.HECTARE;
    AreaUnit SQUARE_MILE          = AreaUnit.SQUARE_MILE;
    AreaUnit SQUARE_NAUTICAL_MILE = AreaUnit.SQUARE_NAUTICAL_MILE;
    AreaUnit SQUARE_FOOT          = AreaUnit.SQUARE_FOOT;
    AreaUnit SQUARE_INCH          = AreaUnit.SQUARE_INCH;
    AreaUnit SQUARE_YARD          = AreaUnit.SQUARE_YARD;
    AreaUnit ACRE                 = AreaUnit.ACRE;

    /****************************************************************************************************************/
    /************************************************** DENSITY  ****************************************************/
    /****************************************************************************************************************/

    DensityUnit KG_PER_METER_3        = DensityUnit.KG_PER_METER_3;
    DensityUnit GRAM_PER_CENTIMETER_3 = DensityUnit.GRAM_PER_CENTIMETER_3;

    /****************************************************************************************************************/
    /************************************************** DURATION ****************************************************/
    /****************************************************************************************************************/

    DurationUnit SECOND      = DurationUnit.SECOND;
    DurationUnit ATTOSECOND  = DurationUnit.ATTOSECOND;
    DurationUnit FEMTOSECOND = DurationUnit.FEMTOSECOND;
    DurationUnit PICOSECOND  = DurationUnit.PICOSECOND;
    DurationUnit NANOSECOND  = DurationUnit.NANOSECOND;
    DurationUnit MICROSECOND = DurationUnit.MICROSECOND;
    DurationUnit MILLISECOND = DurationUnit.MILLISECOND;
    DurationUnit MINUTE      = DurationUnit.MINUTE;
    DurationUnit HOUR        = DurationUnit.HOUR;
    DurationUnit DAY         = DurationUnit.DAY;
    DurationUnit WEEK        = DurationUnit.WEEK;

    /****************************************************************************************************************/
    /********************************************** ELECTRICALCHARGE ************************************************/
    /****************************************************************************************************************/

    ElectricalChargeUnit COULOMB            = ElectricalChargeUnit.COULOMB;
    ElectricalChargeUnit PICOCOULOMB        = ElectricalChargeUnit.PICOCOULOMB;
    ElectricalChargeUnit NANOCOULOMB        = ElectricalChargeUnit.NANOCOULOMB;
    ElectricalChargeUnit MICROCOULOMB       = ElectricalChargeUnit.MICROCOULOMB;
    ElectricalChargeUnit MILLICOULOMB       = ElectricalChargeUnit.MILLICOULOMB;
    ElectricalChargeUnit MILLIAMPERE_HOUR   = ElectricalChargeUnit.MILLIAMPERE_HOUR;
    ElectricalChargeUnit MILLIAMPERE_SECOND = ElectricalChargeUnit.MILLIAMPERE_SECOND;
    ElectricalChargeUnit AMPERE_HOUR        = ElectricalChargeUnit.AMPERE_HOUR;
    ElectricalChargeUnit KILOAMPERE_HOUR    = ElectricalChargeUnit.KILOAMPERE_HOUR;
    ElectricalChargeUnit MEGAAMPERE_HOUR    = ElectricalChargeUnit.MEGAAMPERE_HOUR;
    ElectricalChargeUnit FARADAY            = ElectricalChargeUnit.FARADAY;
    ElectricalChargeUnit ATOMIC_UNIT        = ElectricalChargeUnit.ATOMIC_UNIT;
    ElectricalChargeUnit STATCOULOMB        = ElectricalChargeUnit.STATCOULOMB;
    ElectricalChargeUnit FRANKLIN           = ElectricalChargeUnit.FRANKLIN;
    ElectricalChargeUnit ESU                = ElectricalChargeUnit.ESU;
    ElectricalChargeUnit ABCOULOMB          = ElectricalChargeUnit.ABCOULOMB;
    ElectricalChargeUnit EMU                = ElectricalChargeUnit.EMU;

    /****************************************************************************************************************/
    /********************************************* ELECTRICALCURRENT  ***********************************************/
    /****************************************************************************************************************/

    ElectricalCurrentUnit AMPERE      = ElectricalCurrentUnit.AMPERE;
    ElectricalCurrentUnit NANOAMPERE  = ElectricalCurrentUnit.NANOAMPERE;
    ElectricalCurrentUnit MICROAMPERE = ElectricalCurrentUnit.MICROAMPERE;
    ElectricalCurrentUnit MILLIAMPERE = ElectricalCurrentUnit.MILLIAMPERE;
    ElectricalCurrentUnit KILOAMPERE  = ElectricalCurrentUnit.KILOAMPERE;
    ElectricalCurrentUnit MEGAAMPERE  = ElectricalCurrentUnit.MEGAAMPERE;
    ElectricalCurrentUnit STATAMPERE  = ElectricalCurrentUnit.STATAMPERE;
    ElectricalCurrentUnit ABAMPERE    = ElectricalCurrentUnit.ABAMPERE;

    /****************************************************************************************************************/
    /******************************************** ELECTRICALPOTENTIAL  **********************************************/
    /****************************************************************************************************************/

    ElectricalPotentialUnit VOLT      = ElectricalPotentialUnit.VOLT;
    ElectricalPotentialUnit NANOVOLT  = ElectricalPotentialUnit.NANOVOLT;
    ElectricalPotentialUnit MICROVOLT = ElectricalPotentialUnit.MICROVOLT;
    ElectricalPotentialUnit MILLIVOLT = ElectricalPotentialUnit.MILLIVOLT;
    ElectricalPotentialUnit KILOVOLT  = ElectricalPotentialUnit.KILOVOLT;
    ElectricalPotentialUnit MEGAVOLT  = ElectricalPotentialUnit.MEGAVOLT;
    ElectricalPotentialUnit GIGAVOLT  = ElectricalPotentialUnit.GIGAVOLT;
    ElectricalPotentialUnit STATVOLT  = ElectricalPotentialUnit.STATVOLT;
    ElectricalPotentialUnit ABVOLT    = ElectricalPotentialUnit.ABVOLT;

    /****************************************************************************************************************/
    /******************************************** ELECTRICALRESISTANCE **********************************************/
    /****************************************************************************************************************/

    ElectricalResistanceUnit OHM      = ElectricalResistanceUnit.OHM;
    ElectricalResistanceUnit NANOOHM  = ElectricalResistanceUnit.NANOOHM;
    ElectricalResistanceUnit MICROOHM = ElectricalResistanceUnit.MICROOHM;
    ElectricalResistanceUnit MILLIOHM = ElectricalResistanceUnit.MILLIOHM;
    ElectricalResistanceUnit KILOOHM  = ElectricalResistanceUnit.KILOOHM;
    ElectricalResistanceUnit MEGAOHM  = ElectricalResistanceUnit.MEGAOHM;
    ElectricalResistanceUnit GIGAOHM  = ElectricalResistanceUnit.GIGAOHM;
    ElectricalResistanceUnit ABOHM    = ElectricalResistanceUnit.ABOHM;
    ElectricalResistanceUnit STATOHM  = ElectricalResistanceUnit.STATOHM;

    /****************************************************************************************************************/
    /*************************************************** ENERGY *****************************************************/
    /****************************************************************************************************************/

    EnergyUnit PICOJOULE                = EnergyUnit.PICOJOULE;
    EnergyUnit NANOJOULE                = EnergyUnit.NANOJOULE;
    EnergyUnit MICROJOULE               = EnergyUnit.MICROJOULE;
    EnergyUnit MILLIJOULE               = EnergyUnit.MILLIJOULE;
    EnergyUnit JOULE                    = EnergyUnit.JOULE;
    EnergyUnit KILOJOULE                = EnergyUnit.KILOJOULE;
    EnergyUnit MEGAJOULE                = EnergyUnit.MEGAJOULE;
    EnergyUnit GIGAJOULE                = EnergyUnit.GIGAJOULE;
    EnergyUnit TERAJOULE                = EnergyUnit.TERAJOULE;
    EnergyUnit PETAJOULE                = EnergyUnit.PETAJOULE;
    EnergyUnit FOOT_POUND_FORCE         = EnergyUnit.FOOT_POUND_FORCE;
    EnergyUnit INCH_POUND_FORCE         = EnergyUnit.INCH_POUND_FORCE;
    EnergyUnit BTU_ISO                  = EnergyUnit.BTU_ISO;
    EnergyUnit BTU_IT                   = EnergyUnit.BTU_IT;
    EnergyUnit CALORIE_IT               = EnergyUnit.CALORIE_IT;
    EnergyUnit CALORIE                  = EnergyUnit.CALORIE;
    EnergyUnit KILOCALORIE              = EnergyUnit.KILOCALORIE;
    EnergyUnit FEMTOWATT_HOUR           = EnergyUnit.FEMTOWATT_HOUR;
    EnergyUnit PICOWATT_HOUR            = EnergyUnit.PICOWATT_HOUR;
    EnergyUnit NANOWATT_HOUR            = EnergyUnit.NANOWATT_HOUR;
    EnergyUnit MICROWATT_HOUR           = EnergyUnit.MICROWATT_HOUR;
    EnergyUnit MILLIWATT_HOUR           = EnergyUnit.MILLIWATT_HOUR;
    EnergyUnit WATT_HOUR                = EnergyUnit.WATT_HOUR;
    EnergyUnit KILOWATT_HOUR            = EnergyUnit.KILOWATT_HOUR;
    EnergyUnit MEGAWATT_HOUR            = EnergyUnit.MEGAWATT_HOUR;
    EnergyUnit GIGAWATT_HOUR            = EnergyUnit.GIGAWATT_HOUR;
    EnergyUnit TERAWATT_HOUR            = EnergyUnit.TERAWATT_HOUR;
    EnergyUnit PETAWATT_HOUR            = EnergyUnit.PETAWATT_HOUR;
    EnergyUnit ENERGY_ELECTRONVOLT      = EnergyUnit.ELECTRONVOLT;
    EnergyUnit ENERGY_MICROELECTRONVOLT = EnergyUnit.MICROELECTRONVOLT;
    EnergyUnit ENERGY_MILLIELECTRONVOLT = EnergyUnit.MILLIELECTRONVOLT;
    EnergyUnit ENERGY_KILOELECTRONVOLT  = EnergyUnit.KILOELECTRONVOLT;
    EnergyUnit ENERGY_MEGAELECTRONVOLT  = EnergyUnit.MEGAELECTRONVOLT;
    EnergyUnit ENERGY_GIGAELECTRONVOLT  = EnergyUnit.GIGAELECTRONVOLT;
    EnergyUnit ENERGY_TERAELECTRONVOLT  = EnergyUnit.TERAELECTRONVOLT;
    EnergyUnit ENERGY_PETAELECTRONVOLT  = EnergyUnit.PETAELECTRONVOLT;
    EnergyUnit ENERGY_EXAELECTRONVOLT   = EnergyUnit.EXAELECTRONVOLT;
    EnergyUnit STHENE_METER             = EnergyUnit.STHENE_METER;
    EnergyUnit ERG                      = EnergyUnit.ERG;

    /****************************************************************************************************************/
    /************************************************** FLOWMASS ****************************************************/
    /****************************************************************************************************************/

    FlowMassUnit KILOGRAM_PER_SECOND = FlowMassUnit.KILOGRAM_PER_SECOND;
    FlowMassUnit POUND_PER_SECOND    = FlowMassUnit.POUND_PER_SECOND;

    /****************************************************************************************************************/
    /************************************************* FLOWVOLUME ***************************************************/
    /****************************************************************************************************************/

    FlowVolumeUnit CUBIC_METER_PER_SECOND = FlowVolumeUnit.CUBIC_METER_PER_SECOND;
    FlowVolumeUnit CUBIC_METER_PER_MINUTE = FlowVolumeUnit.CUBIC_METER_PER_MINUTE;
    FlowVolumeUnit CUBIC_METER_PER_HOUR   = FlowVolumeUnit.CUBIC_METER_PER_HOUR;
    FlowVolumeUnit CUBIC_METER_PER_DAY    = FlowVolumeUnit.CUBIC_METER_PER_DAY;
    FlowVolumeUnit LITER_PER_SECOND       = FlowVolumeUnit.LITER_PER_SECOND;
    FlowVolumeUnit LITER_PER_MINUTE       = FlowVolumeUnit.LITER_PER_MINUTE;
    FlowVolumeUnit LITER_PER_HOUR         = FlowVolumeUnit.LITER_PER_HOUR;
    FlowVolumeUnit LITER_PER_DAY          = FlowVolumeUnit.LITER_PER_DAY;
    FlowVolumeUnit CUBIC_FEET_PER_SECOND  = FlowVolumeUnit.CUBIC_FEET_PER_SECOND;
    FlowVolumeUnit CUBIC_FEET_PER_MINUTE  = FlowVolumeUnit.CUBIC_FEET_PER_MINUTE;
    FlowVolumeUnit CUBIC_INCH_PER_SECOND  = FlowVolumeUnit.CUBIC_INCH_PER_SECOND;
    FlowVolumeUnit CUBIC_INCH_PER_MINUTE  = FlowVolumeUnit.CUBIC_INCH_PER_MINUTE;
    FlowVolumeUnit GALLON_PER_SECOND      = FlowVolumeUnit.GALLON_PER_SECOND;
    FlowVolumeUnit GALLON_PER_MINUTE      = FlowVolumeUnit.GALLON_PER_MINUTE;
    FlowVolumeUnit GALLON_PER_HOUR        = FlowVolumeUnit.GALLON_PER_HOUR;
    FlowVolumeUnit GALLON_PER_DAY         = FlowVolumeUnit.GALLON_PER_DAY;

    /****************************************************************************************************************/
    /*************************************************** FORCE  *****************************************************/
    /****************************************************************************************************************/

    ForceUnit NEWTON         = ForceUnit.NEWTON;
    ForceUnit DYNE           = ForceUnit.DYNE;
    ForceUnit KILOGRAM_FORCE = ForceUnit.KILOGRAM_FORCE;
    ForceUnit OUNCE_FORCE    = ForceUnit.OUNCE_FORCE;
    ForceUnit POUND_FORCE    = ForceUnit.POUND_FORCE;
    ForceUnit TON_FORCE      = ForceUnit.TON_FORCE;
    ForceUnit STHENE         = ForceUnit.STHENE;

    /****************************************************************************************************************/
    /************************************************* FREQUENCY  ***************************************************/
    /****************************************************************************************************************/

    FrequencyUnit HERTZ           = FrequencyUnit.HERTZ;
    FrequencyUnit KILOHERTZ       = FrequencyUnit.KILOHERTZ;
    FrequencyUnit MEGAHERTZ       = FrequencyUnit.MEGAHERTZ;
    FrequencyUnit GIGAHERTZ       = FrequencyUnit.GIGAHERTZ;
    FrequencyUnit TERAHERTZ       = FrequencyUnit.TERAHERTZ;
    FrequencyUnit RPM             = FrequencyUnit.RPM;
    FrequencyUnit PER_ATTOSECOND  = FrequencyUnit.PER_ATTOSECOND;
    FrequencyUnit PER_FEMTOSECOND = FrequencyUnit.PER_FEMTOSECOND;
    FrequencyUnit PER_PICOSECOND  = FrequencyUnit.PER_PICOSECOND;
    FrequencyUnit PER_NANOSECOND  = FrequencyUnit.PER_NANOSECOND;
    FrequencyUnit PER_MICROSECOND = FrequencyUnit.PER_MICROSECOND;
    FrequencyUnit PER_MILLISECOND = FrequencyUnit.PER_MILLISECOND;
    FrequencyUnit PER_SECOND      = FrequencyUnit.PER_SECOND;
    FrequencyUnit PER_MINUTE      = FrequencyUnit.PER_MINUTE;
    FrequencyUnit PER_HOUR        = FrequencyUnit.PER_HOUR;
    FrequencyUnit PER_DAY         = FrequencyUnit.PER_DAY;
    FrequencyUnit PER_WEEK        = FrequencyUnit.PER_WEEK;

    /****************************************************************************************************************/
    /*************************************************** LENGTH *****************************************************/
    /****************************************************************************************************************/

    LengthUnit ATTOMETER         = LengthUnit.ATTOMETER;
    LengthUnit FEMTOMETER        = LengthUnit.FEMTOMETER;
    LengthUnit PICOMETER         = LengthUnit.PICOMETER;
    LengthUnit NANOMETER         = LengthUnit.NANOMETER;
    LengthUnit MICROMETER        = LengthUnit.MICROMETER;
    LengthUnit MILLIMETER        = LengthUnit.MILLIMETER;
    LengthUnit METER             = LengthUnit.METER;
    LengthUnit CENTIMETER        = LengthUnit.CENTIMETER;
    LengthUnit DECIMETER         = LengthUnit.DECIMETER;
    LengthUnit DEKAMETER         = LengthUnit.DEKAMETER;
    LengthUnit HECTOMETER        = LengthUnit.HECTOMETER;
    LengthUnit KILOMETER         = LengthUnit.KILOMETER;
    LengthUnit MEGAMETER         = LengthUnit.MEGAMETER;
    LengthUnit INCH              = LengthUnit.INCH;
    LengthUnit FOOT              = LengthUnit.FOOT;
    LengthUnit YARD              = LengthUnit.YARD;
    LengthUnit MILE              = LengthUnit.MILE;
    LengthUnit NAUTICAL_MILE     = LengthUnit.NAUTICAL_MILE;
    LengthUnit ASTRONOMICAL_UNIT = LengthUnit.ASTRONOMICAL_UNIT;
    LengthUnit LIGHTYEAR         = LengthUnit.LIGHTYEAR;
    LengthUnit PARSEC            = LengthUnit.PARSEC;
    LengthUnit ANGSTROM          = LengthUnit.ANGSTROM;

    /****************************************************************************************************************/
    /*********************************************** LINEARDENSITY  *************************************************/
    /****************************************************************************************************************/

    LinearDensityUnit PER_ATTOMETER         = LinearDensityUnit.PER_ATTOMETER;
    LinearDensityUnit PER_FEMTOMETER        = LinearDensityUnit.PER_FEMTOMETER;
    LinearDensityUnit PER_PICOMETER         = LinearDensityUnit.PER_PICOMETER;
    LinearDensityUnit PER_NANOMETER         = LinearDensityUnit.PER_NANOMETER;
    LinearDensityUnit PER_MICROMETER        = LinearDensityUnit.PER_MICROMETER;
    LinearDensityUnit PER_METER             = LinearDensityUnit.PER_METER;
    LinearDensityUnit PER_MILLIMETER        = LinearDensityUnit.PER_MILLIMETER;
    LinearDensityUnit PER_CENTIMETER        = LinearDensityUnit.PER_CENTIMETER;
    LinearDensityUnit PER_DECIMETER         = LinearDensityUnit.PER_DECIMETER;
    LinearDensityUnit PER_DEKAMETER         = LinearDensityUnit.PER_DEKAMETER;
    LinearDensityUnit PER_HECTOMETER        = LinearDensityUnit.PER_HECTOMETER;
    LinearDensityUnit PER_KILOMETER         = LinearDensityUnit.PER_KILOMETER;
    LinearDensityUnit PER_MEGAMETER         = LinearDensityUnit.PER_MEGAMETER;
    LinearDensityUnit PER_FOOT              = LinearDensityUnit.PER_FOOT;
    LinearDensityUnit PER_INCH              = LinearDensityUnit.PER_INCH;
    LinearDensityUnit PER_MILE              = LinearDensityUnit.PER_MILE;
    LinearDensityUnit PER_NAUTICAL_MILE     = LinearDensityUnit.PER_NAUTICAL_MILE;
    LinearDensityUnit PER_YARD              = LinearDensityUnit.PER_YARD;
    LinearDensityUnit PER_ASTRONOMICAL_UNIT = LinearDensityUnit.PER_ASTRONOMICAL_UNIT;
    LinearDensityUnit PER_LIGHTYEAR         = LinearDensityUnit.PER_LIGHTYEAR;
    LinearDensityUnit PER_PARSEC            = LinearDensityUnit.PER_PARSEC;
    LinearDensityUnit PER_ANGSTROM          = LinearDensityUnit.PER_ANGSTROM;

    /****************************************************************************************************************/
    /**************************************************** MASS ******************************************************/
    /****************************************************************************************************************/

    MassUnit KILOGRAM               = MassUnit.KILOGRAM;
    MassUnit FEMTOGRAM              = MassUnit.FEMTOGRAM;
    MassUnit PICOGRAM               = MassUnit.PICOGRAM;
    MassUnit NANOGRAM               = MassUnit.NANOGRAM;
    MassUnit MICROGRAM              = MassUnit.MICROGRAM;
    MassUnit MILLIGRAM              = MassUnit.MILLIGRAM;
    MassUnit GRAM                   = MassUnit.GRAM;
    MassUnit MEGAGRAM               = MassUnit.MEGAGRAM;
    MassUnit GIGAGRAM               = MassUnit.GIGAGRAM;
    MassUnit TERAGRAM               = MassUnit.TERAGRAM;
    MassUnit PETAGRAM               = MassUnit.PETAGRAM;
    MassUnit POUND                  = MassUnit.POUND;
    MassUnit OUNCE                  = MassUnit.OUNCE;
    MassUnit TON_LONG               = MassUnit.TON_LONG;
    MassUnit TON_SHORT              = MassUnit.TON_SHORT;
    MassUnit TON_METRIC             = MassUnit.TON_METRIC;
    MassUnit TONNE                  = MassUnit.TONNE;
    MassUnit DALTON                 = MassUnit.DALTON;
    MassUnit MASS_MICROELECTRONVOLT = MassUnit.MICROELECTRONVOLT;
    MassUnit MASS_MILLIELECTRONVOLT = MassUnit.MILLIELECTRONVOLT;
    MassUnit MASS_ELECTRONVOLT      = MassUnit.ELECTRONVOLT;
    MassUnit MASS_KILOELECTRONVOLT  = MassUnit.KILOELECTRONVOLT;
    MassUnit MASS_MEGAELECTRONVOLT  = MassUnit.MEGAELECTRONVOLT;
    MassUnit MASS_GIGAELECTRONVOLT  = MassUnit.GIGAELECTRONVOLT;
    MassUnit MASS_TERAELECTRONVOLT  = MassUnit.TERAELECTRONVOLT;
    MassUnit MASS_PETAELECTRONVOLT  = MassUnit.PETAELECTRONVOLT;
    MassUnit MASS_EXAELECTRONVOLT   = MassUnit.EXAELECTRONVOLT;

    /****************************************************************************************************************/
    /*************************************************** POWER  *****************************************************/
    /****************************************************************************************************************/

    PowerUnit FEMTOWATT                   = PowerUnit.FEMTOWATT;
    PowerUnit PICOWATT                    = PowerUnit.PICOWATT;
    PowerUnit NANOWATT                    = PowerUnit.NANOWATT;
    PowerUnit MICROWATT                   = PowerUnit.MICROWATT;
    PowerUnit MILLIWATT                   = PowerUnit.MILLIWATT;
    PowerUnit WATT                        = PowerUnit.WATT;
    PowerUnit KILOWATT                    = PowerUnit.KILOWATT;
    PowerUnit MEGAWATT                    = PowerUnit.MEGAWATT;
    PowerUnit GIGAWATT                    = PowerUnit.GIGAWATT;
    PowerUnit TERAWATT                    = PowerUnit.TERAWATT;
    PowerUnit PETAWATT                    = PowerUnit.PETAWATT;
    PowerUnit FOOT_POUND_FORCE_PER_HOUR   = PowerUnit.FOOT_POUND_FORCE_PER_HOUR;
    PowerUnit FOOT_POUND_FORCE_PER_MINUTE = PowerUnit.FOOT_POUND_FORCE_PER_MINUTE;
    PowerUnit FOOT_POUND_FORCE_PER_SECOND = PowerUnit.FOOT_POUND_FORCE_PER_SECOND;
    PowerUnit HORSEPOWER_METRIC           = PowerUnit.HORSEPOWER_METRIC;
    PowerUnit STHENE_METER_PER_SECOND     = PowerUnit.STHENE_METER_PER_SECOND;
    PowerUnit ERG_PER_SECOND              = PowerUnit.ERG_PER_SECOND;

    /****************************************************************************************************************/
    /************************************************** PRESSURE ****************************************************/
    /****************************************************************************************************************/

    PressureUnit PASCAL                = PressureUnit.PASCAL;
    PressureUnit HECTOPASCAL           = PressureUnit.HECTOPASCAL;
    PressureUnit KILOPASCAL            = PressureUnit.KILOPASCAL;
    PressureUnit ATMOSPHERE_STANDARD   = PressureUnit.ATMOSPHERE_STANDARD;
    PressureUnit TORR                  = PressureUnit.TORR;
    PressureUnit ATMOSPHERE_TECHNICAL  = PressureUnit.ATMOSPHERE_TECHNICAL;
    PressureUnit BARYE                 = PressureUnit.BARYE;
    PressureUnit BAR                   = PressureUnit.BAR;
    PressureUnit MILLIBAR              = PressureUnit.MILLIBAR;
    PressureUnit CENTIMETER_MERCURY    = PressureUnit.CENTIMETER_MERCURY;
    PressureUnit MILLIMETER_MERCURY    = PressureUnit.MILLIMETER_MERCURY;
    PressureUnit FOOT_MERCURY          = PressureUnit.FOOT_MERCURY;
    PressureUnit INCH_MERCURY          = PressureUnit.INCH_MERCURY;
    PressureUnit KGF_PER_SQUARE_MM     = PressureUnit.KGF_PER_SQUARE_MM;
    PressureUnit POUND_PER_SQUARE_FOOT = PressureUnit.POUND_PER_SQUARE_FOOT;
    PressureUnit POUND_PER_SQUARE_INCH = PressureUnit.POUND_PER_SQUARE_INCH;
    PressureUnit PIEZE                 = PressureUnit.PIEZE;

    /****************************************************************************************************************/
    /*************************************************** SPEED  *****************************************************/
    /****************************************************************************************************************/

    SpeedUnit METER_PER_SECOND = SpeedUnit.METER_PER_SECOND;
    SpeedUnit METER_PER_HOUR   = SpeedUnit.METER_PER_HOUR;
    SpeedUnit KM_PER_SECOND    = SpeedUnit.KM_PER_SECOND;
    SpeedUnit KM_PER_HOUR      = SpeedUnit.KM_PER_HOUR;
    SpeedUnit INCH_PER_SECOND  = SpeedUnit.INCH_PER_SECOND;
    SpeedUnit INCH_PER_MINUTE  = SpeedUnit.INCH_PER_MINUTE;
    SpeedUnit INCH_PER_HOUR    = SpeedUnit.INCH_PER_HOUR;
    SpeedUnit FOOT_PER_SECOND  = SpeedUnit.FOOT_PER_SECOND;
    SpeedUnit FOOT_PER_MINUTE  = SpeedUnit.FOOT_PER_MINUTE;
    SpeedUnit FOOT_PER_HOUR    = SpeedUnit.FOOT_PER_HOUR;
    SpeedUnit MILE_PER_SECOND  = SpeedUnit.MILE_PER_SECOND;
    SpeedUnit MILE_PER_MINUTE  = SpeedUnit.MILE_PER_MINUTE;
    SpeedUnit MILE_PER_HOUR    = SpeedUnit.MILE_PER_HOUR;
    SpeedUnit KNOT             = SpeedUnit.KNOT;

    /****************************************************************************************************************/
    /************************************************ TEMPERATURE  **************************************************/
    /****************************************************************************************************************/

    TemperatureUnit KELVIN            = TemperatureUnit.KELVIN;
    TemperatureUnit DEGREE_CELSIUS    = TemperatureUnit.DEGREE_CELSIUS;
    TemperatureUnit DEGREE_FAHRENHEIT = TemperatureUnit.DEGREE_FAHRENHEIT;
    TemperatureUnit DEGREE_RANKINE    = TemperatureUnit.DEGREE_RANKINE;
    TemperatureUnit DEGREE_REAUMUR    = TemperatureUnit.DEGREE_REAUMUR;

    /****************************************************************************************************************/
    /*************************************************** TORQUE *****************************************************/
    /****************************************************************************************************************/

    TorqueUnit NEWTON_METER         = TorqueUnit.NEWTON_METER;
    TorqueUnit METER_KILOGRAM_FORCE = TorqueUnit.METER_KILOGRAM_FORCE;
    TorqueUnit POUND_FOOT           = TorqueUnit.POUND_FOOT;
    TorqueUnit POUND_INCH           = TorqueUnit.POUND_INCH;

    /****************************************************************************************************************/
    /*************************************************** VOLUME *****************************************************/
    /****************************************************************************************************************/

    VolumeUnit CUBIC_ATTOMETER  = VolumeUnit.CUBIC_ATTOMETER;
    VolumeUnit CUBIC_FEMTOMETER = VolumeUnit.CUBIC_FEMTOMETER;
    VolumeUnit CUBIC_PICOMETER  = VolumeUnit.CUBIC_PICOMETER;
    VolumeUnit CUBIC_NANOMETER  = VolumeUnit.CUBIC_NANOMETER;
    VolumeUnit CUBIC_MICROMETER = VolumeUnit.CUBIC_MICROMETER;
    VolumeUnit CUBIC_MILLIMETER = VolumeUnit.CUBIC_MILLIMETER;
    VolumeUnit CUBIC_CENTIMETER = VolumeUnit.CUBIC_CENTIMETER;
    VolumeUnit CUBIC_DECIMETER  = VolumeUnit.CUBIC_DECIMETER;
    VolumeUnit CUBIC_METER      = VolumeUnit.CUBIC_METER;
    VolumeUnit CUBIC_DEKAMETER  = VolumeUnit.CUBIC_DEKAMETER;
    VolumeUnit CUBIC_HECTOMETER = VolumeUnit.CUBIC_HECTOMETER;
    VolumeUnit CUBIC_KILOMETER  = VolumeUnit.CUBIC_KILOMETER;
    VolumeUnit CUBIC_MEGAMETER  = VolumeUnit.CUBIC_MEGAMETER;
    VolumeUnit LITER            = VolumeUnit.LITER;
    VolumeUnit CUBIC_MILE       = VolumeUnit.CUBIC_MILE;
    VolumeUnit CUBIC_FOOT       = VolumeUnit.CUBIC_FOOT;
    VolumeUnit CUBIC_INCH       = VolumeUnit.CUBIC_INCH;
    VolumeUnit CUBIC_YARD       = VolumeUnit.CUBIC_YARD;
    VolumeUnit GALLON_US_FLUID  = VolumeUnit.GALLON_US_FLUID;
    VolumeUnit GALLON_IMP       = VolumeUnit.GALLON_IMP;
    VolumeUnit OUNCE_US_FLUID   = VolumeUnit.OUNCE_US_FLUID;
    VolumeUnit OUNCE_IMP_FLUID  = VolumeUnit.OUNCE_IMP_FLUID;
    VolumeUnit PINT_US_FLUID    = VolumeUnit.PINT_US_FLUID;
    VolumeUnit PINT_IMP         = VolumeUnit.PINT_IMP;
    VolumeUnit QUART_US_FLUID   = VolumeUnit.QUART_US_FLUID;
    VolumeUnit QUART_IMP        = VolumeUnit.QUART_IMP;
    VolumeUnit CUBIC_LIGHTYEAR  = VolumeUnit.CUBIC_LIGHTYEAR;
    VolumeUnit CUBIC_PARSEC     = VolumeUnit.CUBIC_PARSEC;

    // @formatter:on

}
