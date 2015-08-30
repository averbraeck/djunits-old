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
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
@SuppressWarnings({"checkstyle:interfaceistype", "checkstyle:javadocmethod", "checkstyle:javadoctype",
    "checkstyle:javadocvariable", "checkstyle:linelength", "checkstyle:leftcurly", "checkstyle:rightcurly", "javadoc"})
public interface UNITS
{
    // @formatter:off
    
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
    LengthUnit M             = LengthUnit.METER;
    LengthUnit CM            = LengthUnit.CENTIMETER;
    LengthUnit DM            = LengthUnit.DECIMETER;
    LengthUnit DAM           = LengthUnit.DEKAMETER;
    LengthUnit FT            = LengthUnit.FOOT;
    LengthUnit HM            = LengthUnit.HECTOMETER;
    LengthUnit IN            = LengthUnit.INCH;
    LengthUnit KM            = LengthUnit.KILOMETER;
    LengthUnit MI            = LengthUnit.MILE;
    LengthUnit MM            = LengthUnit.MILLIMETER;
    LengthUnit NM            = LengthUnit.NAUTICAL_MILE;
    LengthUnit YD            = LengthUnit.YARD;
    
    /****************************************************************************************************************/
    /***************************************************** TIME *****************************************************/ 
    /****************************************************************************************************************/

    TimeUnit SECOND      = TimeUnit.SECOND;
    TimeUnit DAY         = TimeUnit.DAY;
    TimeUnit HOUR        = TimeUnit.HOUR;
    TimeUnit MILLISECOND = TimeUnit.MILLISECOND;
    TimeUnit MINUTE      = TimeUnit.MINUTE;
    TimeUnit WEEK        = TimeUnit.WEEK;
    TimeUnit S           = TimeUnit.SECOND;
    TimeUnit HR          = TimeUnit.HOUR;
    TimeUnit MS          = TimeUnit.MILLISECOND;
    TimeUnit MIN         = TimeUnit.MINUTE;
    TimeUnit WK          = TimeUnit.WEEK;
    
    /****************************************************************************************************************/
    /***************************************************** SPEED ****************************************************/ 
    /****************************************************************************************************************/

    SpeedUnit METER_PER_SECOND = SpeedUnit.METER_PER_SECOND;
    SpeedUnit FOOT_PER_SECOND  = SpeedUnit.FOOT_PER_SECOND;
    SpeedUnit KM_PER_HOUR      = SpeedUnit.KM_PER_HOUR;
    SpeedUnit KNOT             = SpeedUnit.KNOT;
    SpeedUnit MILE_PER_HOUR    = SpeedUnit.MILE_PER_HOUR;
    SpeedUnit MPS              = SpeedUnit.METER_PER_SECOND;
    SpeedUnit FTPS             = SpeedUnit.FOOT_PER_SECOND;
    SpeedUnit KMPH             = SpeedUnit.KM_PER_HOUR;
    SpeedUnit MPH              = SpeedUnit.MILE_PER_HOUR;
    
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
    AccelerationUnit MPS_2                    = AccelerationUnit.METER_PER_SECOND_2;
    AccelerationUnit FTPS_2                   = AccelerationUnit.FOOT_PER_SECOND_2;
    AccelerationUnit INPS_2                   = AccelerationUnit.INCH_PER_SECOND_2;
    AccelerationUnit KMPH_2                   = AccelerationUnit.KM_PER_HOUR_2;
    AccelerationUnit MPH_2                    = AccelerationUnit.MILE_PER_HOUR_2;
    AccelerationUnit MPHPS                    = AccelerationUnit.MILE_PER_HOUR_PER_SECOND;
    AccelerationUnit G                        = AccelerationUnit.STANDARD_GRAVITY;
        
    /****************************************************************************************************************/
    /************************************************** ANGLE_PLANE *************************************************/ 
    /****************************************************************************************************************/

    AnglePlaneUnit RADIAN               = AnglePlaneUnit.RADIAN;
    AnglePlaneUnit ARCMINUTE            = AnglePlaneUnit.ARCMINUTE;
    AnglePlaneUnit ARCSECOND            = AnglePlaneUnit.ARCSECOND;
    AnglePlaneUnit CENTESIMAL_ARCMINUTE = AnglePlaneUnit.CENTESIMAL_ARCMINUTE;
    AnglePlaneUnit CENTESIMAL_ARCSECOND = AnglePlaneUnit.CENTESIMAL_ARCSECOND;
    AnglePlaneUnit DEGREE               = AnglePlaneUnit.DEGREE;
    AnglePlaneUnit GRAD                 = AnglePlaneUnit.GRAD;
    AnglePlaneUnit RAD                  = AnglePlaneUnit.RADIAN;
    AnglePlaneUnit DEG                  = AnglePlaneUnit.DEGREE;
    
    /****************************************************************************************************************/
    /************************************************** ANGLE_SLOPE *************************************************/ 
    /****************************************************************************************************************/

    AngleSlopeUnit SLOPE_RADIAN               = AngleSlopeUnit.RADIAN;
    AngleSlopeUnit SLOPE_ARCMINUTE            = AngleSlopeUnit.ARCMINUTE;
    AngleSlopeUnit SLOPE_ARCSECOND            = AngleSlopeUnit.ARCSECOND;
    AngleSlopeUnit SLOPE_CENTESIMAL_ARCMINUTE = AngleSlopeUnit.CENTESIMAL_ARCMINUTE;
    AngleSlopeUnit SLOPE_CENTESIMAL_ARCSECOND = AngleSlopeUnit.CENTESIMAL_ARCSECOND;
    AngleSlopeUnit SLOPE_DEGREE               = AngleSlopeUnit.DEGREE;
    AngleSlopeUnit SLOPE_GRAD                 = AngleSlopeUnit.GRAD;
    
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
    AreaUnit M_2                  = AreaUnit.SQUARE_METER;
    AreaUnit CM_2                 = AreaUnit.SQUARE_CENTIMETER;
    AreaUnit FT_2                 = AreaUnit.SQUARE_FOOT;
    AreaUnit IN_2                 = AreaUnit.SQUARE_INCH;
    AreaUnit MI_2                 = AreaUnit.SQUARE_MILE;
    AreaUnit MM_2                 = AreaUnit.SQUARE_MILLIMETER;
    AreaUnit YD_2                 = AreaUnit.SQUARE_YARD;
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
}

