package org.djunits.unit;

/**
 * Easy access methods for the DoubleScalar, DoubleVector, DoubleMatrix classes and their Float equivalents. Instead of <br>
 * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
 * we can now write <br>
 * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
@SuppressWarnings({"checkstyle:interfaceistype", "checkstyle:javadocmethod", "checkstyle:javadoctype",
    "checkstyle:javadocvariable", "checkstyle:linelength", "checkstyle:leftcurly", "checkstyle:rightcurly", "javadoc"})
public interface UNITS
{
    // @formatter:off
    
    /****************************************************************************************************************/
    /************************************************** ACCELERATION ************************************************/ 
    /****************************************************************************************************************/

    AccelerationUnit METER_PER_SECOND_2       = AccelerationUnit.METER_PER_SECOND_2;
    AccelerationUnit FOOT_PER_SECOND_2        = AccelerationUnit.FOOT_PER_SECOND_2;
    AccelerationUnit GAL                      = AccelerationUnit.GAL;
    AccelerationUnit INCH_PER_SECOND_2        = AccelerationUnit.INCH_PER_SECOND_2;
    AccelerationUnit KM_PER_HOUR_2            = AccelerationUnit.KM_PER_HOUR_2;
    AccelerationUnit KNOT_PER_SECOND          = AccelerationUnit.KNOT_PER_SECOND;
    AccelerationUnit MILE_PER_HOUR_2          = AccelerationUnit.MILE_PER_HOUR_2;
    AccelerationUnit MILE_PER_HOUR_PER_SECOND = AccelerationUnit.MILE_PER_HOUR_PER_SECOND;
    AccelerationUnit STANDARD_GRAVITY         = AccelerationUnit.STANDARD_GRAVITY;
        
    /****************************************************************************************************************/
    /***************************************************** ANGLE ****************************************************/ 
    /****************************************************************************************************************/

    AngleUnit RADIAN               = AngleUnit.RADIAN;
    AngleUnit ARCMINUTE            = AngleUnit.ARCMINUTE;
    AngleUnit ARCSECOND            = AngleUnit.ARCSECOND;
    AngleUnit CENTESIMAL_ARCMINUTE = AngleUnit.CENTESIMAL_ARCMINUTE;
    AngleUnit CENTESIMAL_ARCSECOND = AngleUnit.CENTESIMAL_ARCSECOND;
    AngleUnit DEGREE               = AngleUnit.DEGREE;
    AngleUnit GRAD                 = AngleUnit.GRAD;
    
    /****************************************************************************************************************/
    /************************************************** ANGLE_SOLID *************************************************/ 
    /****************************************************************************************************************/

    AngleSolidUnit STERADIAN     = AngleSolidUnit.STERADIAN;
    AngleSolidUnit SQUARE_DEGREE = AngleSolidUnit.SQUARE_DEGREE;
    
    /****************************************************************************************************************/
    /***************************************************** AREA *****************************************************/ 
    /****************************************************************************************************************/

    AreaUnit SQUARE_METER         = AreaUnit.SQUARE_METER;
    AreaUnit SQUARE_CENTIMETER    = AreaUnit.SQUARE_CENTIMETER;
    AreaUnit SQUARE_FOOT          = AreaUnit.SQUARE_FOOT;
    AreaUnit SQUARE_INCH          = AreaUnit.SQUARE_INCH;
    AreaUnit SQUARE_MILE          = AreaUnit.SQUARE_MILE;
    AreaUnit SQUARE_MILLIMETER    = AreaUnit.SQUARE_MILLIMETER;
    AreaUnit SQUARE_YARD          = AreaUnit.SQUARE_YARD;
    AreaUnit ACRE                 = AreaUnit.ACRE;
    AreaUnit ARE                  = AreaUnit.ARE;
    AreaUnit HECTARE              = AreaUnit.HECTARE;
    
    /****************************************************************************************************************/
    /**************************************************** DENSITY ***************************************************/ 
    /****************************************************************************************************************/

    DensityUnit GRAM_PER_CENTIMETER_3 = DensityUnit.GRAM_PER_CENTIMETER_3;
    DensityUnit KG_PER_METER_3        = DensityUnit.KG_PER_METER_3;
    
    /****************************************************************************************************************/
    /*********************************************** ELECTRICAL_CHARGE **********************************************/ 
    /****************************************************************************************************************/

    ElectricalChargeUnit COULOMB          = ElectricalChargeUnit.COULOMB;
    ElectricalChargeUnit ABCOULOMB        = ElectricalChargeUnit.ABCOULOMB;
    ElectricalChargeUnit ATOMIC_UNIT      = ElectricalChargeUnit.ATOMIC_UNIT;
    ElectricalChargeUnit EMU              = ElectricalChargeUnit.EMU;
    ElectricalChargeUnit ESU              = ElectricalChargeUnit.ESU;
    ElectricalChargeUnit FARADAY          = ElectricalChargeUnit.FARADAY;
    ElectricalChargeUnit FRANKLIN         = ElectricalChargeUnit.FRANKLIN;
    ElectricalChargeUnit MILLIAMPERE_HOUR = ElectricalChargeUnit.MILLIAMPERE_HOUR;
    ElectricalChargeUnit STATCOULOMB      = ElectricalChargeUnit.STATCOULOMB;
    
    /****************************************************************************************************************/
    /********************************************** ELECTRICAL_CURRENT **********************************************/ 
    /****************************************************************************************************************/

    ElectricalCurrentUnit AMPERE      = ElectricalCurrentUnit.AMPERE;
    ElectricalCurrentUnit ABAMPERE    = ElectricalCurrentUnit.ABAMPERE;
    ElectricalCurrentUnit KILOAMPERE  = ElectricalCurrentUnit.KILOAMPERE;
    ElectricalCurrentUnit MICROAMPERE = ElectricalCurrentUnit.MICROAMPERE;
    ElectricalCurrentUnit MILLIAMPERE = ElectricalCurrentUnit.MILLIAMPERE;
    ElectricalCurrentUnit NANOAMPERE  = ElectricalCurrentUnit.NANOAMPERE;
    ElectricalCurrentUnit STATAMPERE  = ElectricalCurrentUnit.STATAMPERE;
    
    /****************************************************************************************************************/
    /********************************************* ELECTRICAL_POTENTIAL *********************************************/ 
    /****************************************************************************************************************/

    ElectricalPotentialUnit VOLT      = ElectricalPotentialUnit.VOLT;
    ElectricalPotentialUnit ABVOLT    = ElectricalPotentialUnit.ABVOLT;
    ElectricalPotentialUnit KILOVOLT  = ElectricalPotentialUnit.KILOVOLT;
    ElectricalPotentialUnit MEGAVOLT  = ElectricalPotentialUnit.MEGAVOLT;
    ElectricalPotentialUnit MICROVOLT = ElectricalPotentialUnit.MICROVOLT;
    ElectricalPotentialUnit MILLIVOLT = ElectricalPotentialUnit.MILLIVOLT;
    ElectricalPotentialUnit STATVOLT  = ElectricalPotentialUnit.STATVOLT;
    
    /****************************************************************************************************************/
    /******************************************** ELECTRICAL_RESISTANCE *********************************************/ 
    /****************************************************************************************************************/

    ElectricalResistanceUnit OHM      = ElectricalResistanceUnit.OHM;
    ElectricalResistanceUnit KILOOHM  = ElectricalResistanceUnit.KILOOHM;
    ElectricalResistanceUnit MEGAOHM  = ElectricalResistanceUnit.MEGAOHM;
    ElectricalResistanceUnit MILLIOHM = ElectricalResistanceUnit.MILLIOHM;
    
    /****************************************************************************************************************/
    /*************************************************** ENERGY *****************************************************/ 
    /****************************************************************************************************************/

    EnergyUnit JOULE              = EnergyUnit.JOULE;
    EnergyUnit BTU_ISO            = EnergyUnit.BTU_ISO;
    EnergyUnit BTU_IT             = EnergyUnit.BTU_IT;
    EnergyUnit CALORIE_IT         = EnergyUnit.CALORIE_IT;
    EnergyUnit ELECTRONVOLT       = EnergyUnit.ELECTRONVOLT;
    EnergyUnit ERG                = EnergyUnit.ERG;
    EnergyUnit EXA_ELECTRONVOLT   = EnergyUnit.EXA_ELECTRONVOLT;
    EnergyUnit FOOT_POUND_FORCE   = EnergyUnit.FOOT_POUND_FORCE;
    EnergyUnit GIGA_ELECTRONVOLT  = EnergyUnit.GIGA_ELECTRONVOLT;
    EnergyUnit GIGAWATT_HOUR      = EnergyUnit.GIGAWATT_HOUR;
    EnergyUnit INCH_POUND_FORCE   = EnergyUnit.INCH_POUND_FORCE;
    EnergyUnit KILO_ELECTRONVOLT  = EnergyUnit.KILO_ELECTRONVOLT;
    EnergyUnit KILOCALORIE        = EnergyUnit.KILOCALORIE;
    EnergyUnit KILOWATT_HOUR      = EnergyUnit.KILOWATT_HOUR;
    EnergyUnit MEGA_ELECTRONVOLT  = EnergyUnit.MEGA_ELECTRONVOLT;
    EnergyUnit MEGAWATT_HOUR      = EnergyUnit.MEGAWATT_HOUR;
    EnergyUnit MICROWATT_HOUR     = EnergyUnit.MICROWATT_HOUR;
    EnergyUnit MILLI_ELECTRONVOLT = EnergyUnit.MILLI_ELECTRONVOLT;
    EnergyUnit MILLIWATT_HOUR     = EnergyUnit.MILLIWATT_HOUR;
    EnergyUnit PETA_ELECTRONVOLT  = EnergyUnit.PETA_ELECTRONVOLT;
    EnergyUnit STHENE_METER       = EnergyUnit.STHENE_METER;
    EnergyUnit TERA_ELECTRONVOLT  = EnergyUnit.TERA_ELECTRONVOLT;
    EnergyUnit TERAWATT_HOUR      = EnergyUnit.TERAWATT_HOUR;
    EnergyUnit WATT_HOUR          = EnergyUnit.WATT_HOUR;
    
    /****************************************************************************************************************/
    /************************************************** FLOW_MASS ***************************************************/ 
    /****************************************************************************************************************/

    FlowMassUnit KILOGRAM_PER_SECOND = FlowMassUnit.KILOGRAM_PER_SECOND;
    FlowMassUnit POUND_PER_SECOND    = FlowMassUnit.POUND_PER_SECOND;
    
    /****************************************************************************************************************/
    /************************************************* FLOW_VOLUME **************************************************/ 
    /****************************************************************************************************************/

    FlowVolumeUnit CUBIC_FEET_PER_MINUTE  = FlowVolumeUnit.CUBIC_FEET_PER_MINUTE;
    FlowVolumeUnit CUBIC_FEET_PER_SECOND  = FlowVolumeUnit.CUBIC_FEET_PER_SECOND;
    FlowVolumeUnit CUBIC_INCH_PER_MINUTE  = FlowVolumeUnit.CUBIC_INCH_PER_MINUTE;
    FlowVolumeUnit CUBIC_INCH_PER_SECOND  = FlowVolumeUnit.CUBIC_INCH_PER_SECOND;
    FlowVolumeUnit CUBIC_METER_PER_DAY    = FlowVolumeUnit.CUBIC_METER_PER_DAY;
    FlowVolumeUnit CUBIC_METER_PER_HOUR   = FlowVolumeUnit.CUBIC_METER_PER_HOUR;
    FlowVolumeUnit CUBIC_METER_PER_MINUTE = FlowVolumeUnit.CUBIC_METER_PER_MINUTE;
    FlowVolumeUnit CUBIC_METER_PER_SECOND = FlowVolumeUnit.CUBIC_METER_PER_SECOND;
    FlowVolumeUnit GALLON_PER_DAY         = FlowVolumeUnit.GALLON_PER_DAY;
    FlowVolumeUnit GALLON_PER_HOUR        = FlowVolumeUnit.GALLON_PER_HOUR;
    FlowVolumeUnit GALLON_PER_MINUTE      = FlowVolumeUnit.GALLON_PER_MINUTE;
    FlowVolumeUnit GALLON_PER_SECOND      = FlowVolumeUnit.GALLON_PER_SECOND;
    FlowVolumeUnit LITER_PER_DAY          = FlowVolumeUnit.LITER_PER_DAY;
    FlowVolumeUnit LITER_PER_HOUR         = FlowVolumeUnit.LITER_PER_HOUR;
    FlowVolumeUnit LITER_PER_MINUTE       = FlowVolumeUnit.LITER_PER_MINUTE;
    FlowVolumeUnit LITER_PER_SECOND       = FlowVolumeUnit.LITER_PER_SECOND;
    
    /****************************************************************************************************************/
    /**************************************************** FORCE *****************************************************/ 
    /****************************************************************************************************************/

    ForceUnit DYNE           = ForceUnit.DYNE;
    ForceUnit KILOGRAM_FORCE = ForceUnit.KILOGRAM_FORCE;
    ForceUnit NEWTON         = ForceUnit.NEWTON;
    ForceUnit OUNCE_FORCE    = ForceUnit.OUNCE_FORCE;
    ForceUnit POUND_FORCE    = ForceUnit.POUND_FORCE;
    ForceUnit STHENE         = ForceUnit.STHENE;
    ForceUnit TON_FORCE      = ForceUnit.TON_FORCE;

    /****************************************************************************************************************/
    /************************************************** FREQUENCY ***************************************************/ 
    /****************************************************************************************************************/

    FrequencyUnit HERTZ           = FrequencyUnit.HERTZ;
    FrequencyUnit TERAHERTZ       = FrequencyUnit.TERAHERTZ;
    FrequencyUnit GIGAHERTZ       = FrequencyUnit.GIGAHERTZ;
    FrequencyUnit KILOHERTZ       = FrequencyUnit.KILOHERTZ;
    FrequencyUnit MEGAHERTZ       = FrequencyUnit.MEGAHERTZ;
    FrequencyUnit PER_DAY         = FrequencyUnit.PER_DAY;
    FrequencyUnit PER_HOUR        = FrequencyUnit.PER_HOUR;
    FrequencyUnit PER_MILLISECOND = FrequencyUnit.PER_MILLISECOND;
    FrequencyUnit PER_MINUTE      = FrequencyUnit.PER_MINUTE;
    FrequencyUnit PER_SECOND      = FrequencyUnit.PER_SECOND;
    FrequencyUnit PER_WEEK        = FrequencyUnit.PER_WEEK;
    FrequencyUnit RPM             = FrequencyUnit.RPM;

    /****************************************************************************************************************/
    /**************************************************** LENGTH ****************************************************/ 
    /****************************************************************************************************************/

    LengthUnit METER         = LengthUnit.METER;
    LengthUnit CENTIMETER    = LengthUnit.CENTIMETER;
    LengthUnit DECIMETER     = LengthUnit.DECIMETER;
    LengthUnit DEKAMETER     = LengthUnit.DEKAMETER;
    LengthUnit FOOT          = LengthUnit.FOOT;
    LengthUnit HECTOMETER    = LengthUnit.HECTOMETER;
    LengthUnit INCH          = LengthUnit.INCH;
    LengthUnit KILOMETER     = LengthUnit.KILOMETER;
    LengthUnit MILE          = LengthUnit.MILE;
    LengthUnit MILLIMETER    = LengthUnit.MILLIMETER;
    LengthUnit NAUTICAL_MILE = LengthUnit.NAUTICAL_MILE;
    LengthUnit YARD          = LengthUnit.YARD;
    
    /****************************************************************************************************************/
    /************************************************ LINEAR_DENSITY ************************************************/ 
    /****************************************************************************************************************/

    LinearDensityUnit PER_METER         = LinearDensityUnit.PER_METER;
    LinearDensityUnit PER_CENTIMETER    = LinearDensityUnit.PER_CENTIMETER;
    LinearDensityUnit PER_DECIMETER     = LinearDensityUnit.PER_DECIMETER;
    LinearDensityUnit PER_DEKAMETER     = LinearDensityUnit.PER_DEKAMETER;
    LinearDensityUnit PER_FOOT          = LinearDensityUnit.PER_FOOT;
    LinearDensityUnit PER_HECTOMETER    = LinearDensityUnit.PER_HECTOMETER;
    LinearDensityUnit PER_INCH          = LinearDensityUnit.PER_INCH;
    LinearDensityUnit PER_KILOMETER     = LinearDensityUnit.PER_KILOMETER;
    LinearDensityUnit PER_MILE          = LinearDensityUnit.PER_MILE;
    LinearDensityUnit PER_MILLIMETER    = LinearDensityUnit.PER_MILLIMETER;
    LinearDensityUnit PER_NAUTICAL_MILE = LinearDensityUnit.PER_NAUTICAL_MILE;
    LinearDensityUnit PER_YARD          = LinearDensityUnit.PER_YARD;

    /****************************************************************************************************************/
    /***************************************************** MASS *****************************************************/ 
    /****************************************************************************************************************/

    MassUnit KILOGRAM     = MassUnit.KILOGRAM;
    MassUnit DALTON       = MassUnit.DALTON;
    MassUnit GRAM         = MassUnit.GRAM;
    MassUnit OUNCE        = MassUnit.OUNCE;
    MassUnit POUND        = MassUnit.POUND;
    MassUnit TON_LONG     = MassUnit.TON_LONG;
    MassUnit TON_METRIC   = MassUnit.TON_METRIC;
    MassUnit TON_SHORT    = MassUnit.TON_SHORT;
    MassUnit TONNE        = MassUnit.TONNE;

    /****************************************************************************************************************/
    /**************************************************** POWER *****************************************************/ 
    /****************************************************************************************************************/

    PowerUnit WATT                        = PowerUnit.WATT;
    PowerUnit KILOWATT                    = PowerUnit.KILOWATT;
    PowerUnit MEGAWATT                    = PowerUnit.MEGAWATT;
    PowerUnit GIGAWATT                    = PowerUnit.GIGAWATT;
    PowerUnit ERG_PER_SECOND              = PowerUnit.ERG_PER_SECOND;
    PowerUnit FOOT_POUND_FORCE_PER_HOUR   = PowerUnit.FOOT_POUND_FORCE_PER_HOUR;
    PowerUnit FOOT_POUND_FORCE_PER_MINUTE = PowerUnit.FOOT_POUND_FORCE_PER_MINUTE;
    PowerUnit FOOT_POUND_FORCE_PER_SECOND = PowerUnit.FOOT_POUND_FORCE_PER_SECOND;
    PowerUnit HORSEPOWER_METRIC           = PowerUnit.HORSEPOWER_METRIC;
    PowerUnit STHENE_METER_PER_SECOND     = PowerUnit.STHENE_METER_PER_SECOND;

    /****************************************************************************************************************/
    /************************************************** PRESSURE ****************************************************/ 
    /****************************************************************************************************************/

    PressureUnit PASCAL                = PressureUnit.PASCAL;
    PressureUnit ATMOSPHERE_STANDARD   = PressureUnit.ATMOSPHERE_STANDARD;
    PressureUnit ATMOSPHERE_TECHNICAL  = PressureUnit.ATMOSPHERE_TECHNICAL;
    PressureUnit BAR                   = PressureUnit.BAR;
    PressureUnit BARYE                 = PressureUnit.BARYE;
    PressureUnit CENTIMETER_MERCURY    = PressureUnit.CENTIMETER_MERCURY;
    PressureUnit FOOT_MERCURY          = PressureUnit.FOOT_MERCURY;
    PressureUnit HECTOPASCAL           = PressureUnit.HECTOPASCAL;
    PressureUnit INCH_MERCURY          = PressureUnit.INCH_MERCURY;
    PressureUnit KGF_PER_SQUARE_MM     = PressureUnit.KGF_PER_SQUARE_MM;
    PressureUnit KILOPASCAL            = PressureUnit.KILOPASCAL;
    PressureUnit MILLIBAR              = PressureUnit.MILLIBAR;
    PressureUnit MILLIMETER_MERCURY    = PressureUnit.MILLIMETER_MERCURY;
    PressureUnit PIEZE                 = PressureUnit.PIEZE;
    PressureUnit POUND_PER_SQUARE_FOOT = PressureUnit.POUND_PER_SQUARE_FOOT;
    PressureUnit POUND_PER_SQUARE_INCH = PressureUnit.POUND_PER_SQUARE_INCH;
    PressureUnit TORR                  = PressureUnit.TORR;

    /****************************************************************************************************************/
    /***************************************************** SPEED ****************************************************/ 
    /****************************************************************************************************************/

    SpeedUnit METER_PER_SECOND = SpeedUnit.METER_PER_SECOND;
    SpeedUnit FOOT_PER_SECOND  = SpeedUnit.FOOT_PER_SECOND;
    SpeedUnit KM_PER_HOUR      = SpeedUnit.KM_PER_HOUR;
    SpeedUnit KNOT             = SpeedUnit.KNOT;
    SpeedUnit MILE_PER_HOUR    = SpeedUnit.MILE_PER_HOUR;
    
    /****************************************************************************************************************/
    /************************************************* TEMPERATURE **************************************************/ 
    /****************************************************************************************************************/

    TemperatureUnit KELVIN            = TemperatureUnit.KELVIN;
    TemperatureUnit DEGREE_CELSIUS    = TemperatureUnit.DEGREE_CELSIUS;
    TemperatureUnit DEGREE_FAHRENHEIT = TemperatureUnit.DEGREE_FAHRENHEIT;
    TemperatureUnit DEGREE_RANKINE    = TemperatureUnit.DEGREE_RANKINE;
    TemperatureUnit DEGREE_REAUMUR    = TemperatureUnit.DEGREE_REAUMUR;

    /****************************************************************************************************************/
    /***************************************************** TIME *****************************************************/ 
    /****************************************************************************************************************/

    TimeUnit SECOND      = TimeUnit.SECOND;
    TimeUnit DAY         = TimeUnit.DAY;
    TimeUnit HOUR        = TimeUnit.HOUR;
    TimeUnit MILLISECOND = TimeUnit.MILLISECOND;
    TimeUnit MINUTE      = TimeUnit.MINUTE;
    TimeUnit WEEK        = TimeUnit.WEEK;
    
    /****************************************************************************************************************/
    /*************************************************** TORQUE *****************************************************/ 
    /****************************************************************************************************************/

    TorqueUnit NEWTON_METER         = TorqueUnit.NEWTON_METER;
    TorqueUnit POUND_FOOT           = TorqueUnit.POUND_FOOT;
    TorqueUnit POUND_INCH           = TorqueUnit.POUND_INCH;
    TorqueUnit METER_KILOGRAM_FORCE = TorqueUnit.METER_KILOGRAM_FORCE;
    
    /****************************************************************************************************************/
    /*************************************************** VOLUME *****************************************************/ 
    /****************************************************************************************************************/
 
    VolumeUnit CUBIC_METER       = VolumeUnit.CUBIC_METER;
    VolumeUnit CUBIC_CENTIMETER  = VolumeUnit.CUBIC_CENTIMETER;
    VolumeUnit CUBIC_FOOT        = VolumeUnit.CUBIC_FOOT;
    VolumeUnit CUBIC_INCH        = VolumeUnit.CUBIC_INCH;
    VolumeUnit CUBIC_MILE        = VolumeUnit.CUBIC_MILE;
    VolumeUnit CUBIC_DECIMETER   = VolumeUnit.CUBIC_DECIMETER;
    VolumeUnit CUBIC_YARD        = VolumeUnit.CUBIC_YARD;
    VolumeUnit CUBIC_KM          = VolumeUnit.CUBIC_KM;
    VolumeUnit LITER             = VolumeUnit.LITER;
    VolumeUnit GALLON_IMP        = VolumeUnit.GALLON_IMP;
    VolumeUnit GALLON_US_FLUID   = VolumeUnit.GALLON_US_FLUID;
    VolumeUnit OUNCE_IMP_FLUID   = VolumeUnit.OUNCE_IMP_FLUID;
    VolumeUnit OUNCE_US_FLUID    = VolumeUnit.OUNCE_US_FLUID;
    VolumeUnit PINT_IMP          = VolumeUnit.PINT_IMP;
    VolumeUnit PINT_US_FLUID     = VolumeUnit.PINT_US_FLUID;
    VolumeUnit QUART_IMP         = VolumeUnit.QUART_IMP;
    VolumeUnit QUART_US_FLUID    = VolumeUnit.QUART_US_FLUID;
    
}

