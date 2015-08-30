package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the DoubleScalar. Instead of <br>
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
    "checkstyle:javadocvariable", "checkstyle:linelength", "checkstyle:leftcurly", "checkstyle:rightcurly", "javadoc",
    "serial"})
public interface DOUBLE_SCALAR extends UNITS
{
    // @formatter:off
    
    /****************************************************************************************************************/
    /**************************************************** LENGTH ****************************************************/ 
    /****************************************************************************************************************/

    abstract class Length extends DoubleScalar<LengthUnit>
    {
        protected Length(final LengthUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<LengthUnit>
        {
            public Rel(final double value, final LengthUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<LengthUnit> value) { super(value); }
            
            public Length.Rel abs()    { return new Length.Rel(Math.abs(getInUnit()), getUnit()); }
            public Length.Rel acos()   { return new Length.Rel(Math.acos(getInUnit()), getUnit()); }
            public Length.Rel asin()   { return new Length.Rel(Math.asin(getInUnit()), getUnit()); }
            public Length.Rel atan()   { return new Length.Rel(Math.atan(getInUnit()), getUnit()); }
            public Length.Rel cbrt()   { return new Length.Rel(Math.cbrt(getInUnit()), getUnit()); }
            public Length.Rel ceil()   { return new Length.Rel(Math.ceil(getInUnit()), getUnit()); }
            public Length.Rel cos()    { return new Length.Rel(Math.cos(getInUnit()), getUnit()); }
            public Length.Rel cosh()   { return new Length.Rel(Math.cosh(getInUnit()), getUnit()); }
            public Length.Rel exp()    { return new Length.Rel(Math.exp(getInUnit()), getUnit()); }
            public Length.Rel expm1()  { return new Length.Rel(Math.expm1(getInUnit()), getUnit()); }
            public Length.Rel floor()  { return new Length.Rel(Math.floor(getInUnit()), getUnit()); }
            public Length.Rel log()    { return new Length.Rel(Math.log(getInUnit()), getUnit()); }
            public Length.Rel log10()  { return new Length.Rel(Math.log10(getInUnit()), getUnit()); }
            public Length.Rel log1p()  { return new Length.Rel(Math.log1p(getInUnit()), getUnit()); }
            public Length.Rel rint()   { return new Length.Rel(Math.rint(getInUnit()), getUnit()); }
            public Length.Rel round()  { return new Length.Rel(Math.round(getInUnit()), getUnit()); }
            public Length.Rel signum() { return new Length.Rel(Math.signum(getInUnit()), getUnit()); }
            public Length.Rel sin()    { return new Length.Rel(Math.sin(getInUnit()), getUnit()); }
            public Length.Rel sinh()   { return new Length.Rel(Math.sinh(getInUnit()), getUnit()); }
            public Length.Rel sqrt()   { return new Length.Rel(Math.sqrt(getInUnit()), getUnit()); }
            public Length.Rel tan()    { return new Length.Rel(Math.tan(getInUnit()), getUnit()); }
            public Length.Rel tanh()   { return new Length.Rel(Math.tanh(getInUnit()), getUnit()); }
            public Length.Rel inv()    { return new Length.Rel(1.0 / getInUnit(), getUnit()); }
            public Length.Rel toDegrees() { return new Length.Rel(Math.toDegrees(getInUnit()), getUnit()); }
            public Length.Rel toRadians() { return new Length.Rel(Math.toRadians(getInUnit()), getUnit()); }
            public Length.Rel pow(final double x) { return new Length.Rel(Math.pow(getInUnit(), x), getUnit()); }
            
            public Length.Rel multiplyBy(final double factor) { return new Length.Rel(getInUnit() * factor, getUnit()); }
            public Length.Rel divideBy(final double divisor)  { return new Length.Rel(getInUnit() / divisor, getUnit()); }
            
            public Length.Rel plus(final Length.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Length.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Length.Rel(this.si + v.si, LengthUnit.SI); } 

            public Length.Rel minus(final Length.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Length.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Length.Rel(this.si - v.si, LengthUnit.SI); } 

            public Length.Abs plus(final Length.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Length.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Length.Abs(this.si + v.si, LengthUnit.SI); } 
            
            public Area.Rel multiplyBy(final Length.Rel v) { return new Area.Rel(this.si * v.si, AreaUnit.SI); }
            public Speed.Rel divideBy(final Time.Rel v) { return new Speed.Rel(this.si / v.si, SpeedUnit.SI); }

        }
        
        public static class Abs extends DoubleScalar.Abs<LengthUnit>
        {
            public Abs(final double value, final LengthUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<LengthUnit> value) { super(value); }
        }
    }
    
    /****************************************************************************************************************/
    /***************************************************** TIME *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Time extends DoubleScalar<TimeUnit>
    {
        protected Time(final TimeUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<TimeUnit>
        {
            public Rel(final double value, final TimeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<TimeUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<TimeUnit>
        {
            public Abs(final double value, final TimeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<TimeUnit> value) { super(value); }
        }
    }
    
    /****************************************************************************************************************/
    /***************************************************** SPEED ****************************************************/ 
    /****************************************************************************************************************/

    abstract class Speed extends DoubleScalar<SpeedUnit>
    {
        protected Speed(final SpeedUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<SpeedUnit>
        {
            public Rel(final double value, final SpeedUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<SpeedUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<SpeedUnit>
        {
            public Abs(final double value, final SpeedUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<SpeedUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** ACCELERATION ************************************************/ 
    /****************************************************************************************************************/

    abstract class Acceleration extends DoubleScalar<AccelerationUnit>
    {
        protected Acceleration(final AccelerationUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<AccelerationUnit>
        {
            public Rel(final double value, final AccelerationUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<AccelerationUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<AccelerationUnit>
        {
            public Abs(final double value, final AccelerationUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<AccelerationUnit> value) { super(value); }
        }
    }
    
    /****************************************************************************************************************/
    /************************************************** ANGLE_PLANE *************************************************/ 
    /****************************************************************************************************************/

    abstract class AnglePlane extends DoubleScalar<AnglePlaneUnit>
    {
        protected AnglePlane(final AnglePlaneUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<AnglePlaneUnit>
        {
            public Rel(final double value, final AnglePlaneUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<AnglePlaneUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<AnglePlaneUnit>
        {
            public Abs(final double value, final AnglePlaneUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<AnglePlaneUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** ANGLE_SLOPE *************************************************/ 
    /****************************************************************************************************************/

    abstract class AngleSlope extends DoubleScalar<AngleSlopeUnit>
    {
        protected AngleSlope(final AngleSlopeUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<AngleSlopeUnit>
        {
            public Rel(final double value, final AngleSlopeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<AngleSlopeUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<AngleSlopeUnit>
        {
            public Abs(final double value, final AngleSlopeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<AngleSlopeUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** ANGLE_SOLID *************************************************/ 
    /****************************************************************************************************************/

    abstract class AngleSolid extends DoubleScalar<AngleSolidUnit>
    {
        protected AngleSolid(final AngleSolidUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<AngleSolidUnit>
        {
            public Rel(final double value, final AngleSolidUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<AngleSolidUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<AngleSolidUnit>
        {
            public Abs(final double value, final AngleSolidUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<AngleSolidUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /***************************************************** AREA *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Area extends DoubleScalar<AreaUnit>
    {
        protected Area(final AreaUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<AreaUnit>
        {
            public Rel(final double value, final AreaUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<AreaUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<AreaUnit>
        {
            public Abs(final double value, final AreaUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<AreaUnit> value) { super(value); }
        }
    }
    
    /****************************************************************************************************************/
    /**************************************************** DENSITY ***************************************************/ 
    /****************************************************************************************************************/

    abstract class Density extends DoubleScalar<DensityUnit>
    {
        protected Density(final DensityUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<DensityUnit>
        {
            public Rel(final double value, final DensityUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<DensityUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<DensityUnit>
        {
            public Abs(final double value, final DensityUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<DensityUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /*********************************************** ELECTRICAL_CHARGE **********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalCharge extends DoubleScalar<ElectricalChargeUnit>
    {
        protected ElectricalCharge(final ElectricalChargeUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<ElectricalChargeUnit>
        {
            public Rel(final double value, final ElectricalChargeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<ElectricalChargeUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<ElectricalChargeUnit>
        {
            public Abs(final double value, final ElectricalChargeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<ElectricalChargeUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /********************************************** ELECTRICAL_CURRENT **********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalCurrent extends DoubleScalar<ElectricalCurrentUnit>
    {
        protected ElectricalCurrent(final ElectricalCurrentUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<ElectricalCurrentUnit>
        {
            public Rel(final double value, final ElectricalCurrentUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<ElectricalCurrentUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<ElectricalCurrentUnit>
        {
            public Abs(final double value, final ElectricalCurrentUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<ElectricalCurrentUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /********************************************* ELECTRICAL_POTENTIAL *********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalPotential extends DoubleScalar<ElectricalPotentialUnit>
    {
        protected ElectricalPotential(final ElectricalPotentialUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<ElectricalPotentialUnit>
        {
            public Rel(final double value, final ElectricalPotentialUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<ElectricalPotentialUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<ElectricalPotentialUnit>
        {
            public Abs(final double value, final ElectricalPotentialUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<ElectricalPotentialUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /******************************************** ELECTRICAL_RESISTANCE *********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalResistance extends DoubleScalar<ElectricalResistanceUnit>
    {
        protected ElectricalResistance(final ElectricalResistanceUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<ElectricalResistanceUnit>
        {
            public Rel(final double value, final ElectricalResistanceUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<ElectricalResistanceUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<ElectricalResistanceUnit>
        {
            public Abs(final double value, final ElectricalResistanceUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<ElectricalResistanceUnit> value) { super(value); }
        }
    }

    /****************************************************************************************************************/
    /*************************************************** ENERGY *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Energy extends DoubleScalar<EnergyUnit>
    {
        protected Energy(final EnergyUnit unit) { super(unit); }
        
        public static class Rel extends DoubleScalar.Rel<EnergyUnit>
        {
            public Rel(final double value, final EnergyUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vdouble.scalar.DoubleScalar.Rel<EnergyUnit> value) { super(value); }
        }
        
        public static class Abs extends DoubleScalar.Abs<EnergyUnit>
        {
            public Abs(final double value, final EnergyUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vdouble.scalar.DoubleScalar.Abs<EnergyUnit> value) { super(value); }
        }
    }

}

