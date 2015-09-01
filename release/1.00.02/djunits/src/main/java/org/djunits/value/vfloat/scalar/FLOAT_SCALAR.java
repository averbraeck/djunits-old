package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;LengthUnit&gt; margin = new FloatScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
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
    "checkstyle:filelength", "checkstyle:javadocvariable", "checkstyle:linelength", "checkstyle:leftcurly",
    "checkstyle:rightcurly", "javadoc", "serial"})
public interface FLOAT_SCALAR extends UNITS
{
    // @formatter:off
    
    /****************************************************************************************************************/
    /************************************************** ACCELERATION ************************************************/ 
    /****************************************************************************************************************/

    abstract class Acceleration extends FloatScalar<AccelerationUnit>
    {
        protected Acceleration(final AccelerationUnit unit) { super(unit); }
        
        public static Acceleration.Abs interpolate(final Acceleration.Abs zero, final Acceleration.Abs one, final float ratio)
        { return new Acceleration.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Acceleration.Rel interpolate(final Acceleration.Rel zero, final Acceleration.Rel one, final float ratio)
        { return new Acceleration.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<AccelerationUnit>
        {
            public Rel(final float value, final AccelerationUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<AccelerationUnit> value) { super(value); }
            
            public Acceleration.Rel abs()    { return new Acceleration.Rel(Math.abs(getInUnit()), getUnit()); }
            public Acceleration.Rel acos()   { return new Acceleration.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Acceleration.Rel asin()   { return new Acceleration.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Acceleration.Rel atan()   { return new Acceleration.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Acceleration.Rel cbrt()   { return new Acceleration.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Acceleration.Rel ceil()   { return new Acceleration.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Acceleration.Rel cos()    { return new Acceleration.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Acceleration.Rel cosh()   { return new Acceleration.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Acceleration.Rel exp()    { return new Acceleration.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Acceleration.Rel expm1()  { return new Acceleration.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Acceleration.Rel floor()  { return new Acceleration.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Acceleration.Rel log()    { return new Acceleration.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Acceleration.Rel log10()  { return new Acceleration.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Acceleration.Rel log1p()  { return new Acceleration.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Acceleration.Rel rint()   { return new Acceleration.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Acceleration.Rel round()  { return new Acceleration.Rel(Math.round(getInUnit()), getUnit()); }
            public Acceleration.Rel signum() { return new Acceleration.Rel(Math.signum(getInUnit()), getUnit()); }
            public Acceleration.Rel sin()    { return new Acceleration.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Acceleration.Rel sinh()   { return new Acceleration.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Acceleration.Rel sqrt()   { return new Acceleration.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Acceleration.Rel tan()    { return new Acceleration.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Acceleration.Rel tanh()   { return new Acceleration.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Acceleration.Rel inv()    { return new Acceleration.Rel(1.0f / getInUnit(), getUnit()); }
            public Acceleration.Rel toDegrees() { return new Acceleration.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Acceleration.Rel toRadians() { return new Acceleration.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Acceleration.Rel pow(final float x) { return new Acceleration.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Acceleration.Rel multiplyBy(final float factor) { return new Acceleration.Rel(getInUnit() * factor, getUnit()); }
            public Acceleration.Rel divideBy(final float divisor)  { return new Acceleration.Rel(getInUnit() / divisor, getUnit()); }
            
            public Acceleration.Rel plus(final Acceleration.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Acceleration.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Acceleration.Rel(this.si + v.si, AccelerationUnit.SI); } 

            public Acceleration.Rel minus(final Acceleration.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Acceleration.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Acceleration.Rel(this.si - v.si, AccelerationUnit.SI); } 

            public Acceleration.Abs plus(final Acceleration.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Acceleration.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Acceleration.Abs(this.si + v.si, AccelerationUnit.SI); } 
            
            public Speed.Rel multiplyBy(final Time.Rel v) { return new Speed.Rel(this.si * v.si, SpeedUnit.SI); }
            public Dimensionless.Rel divideBy(final Acceleration.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<AccelerationUnit>
        {
            public Abs(final float value, final AccelerationUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<AccelerationUnit> value) { super(value); }
            public Acceleration.Abs abs()    { return new Acceleration.Abs(Math.abs(getInUnit()), getUnit()); }
            public Acceleration.Abs acos()   { return new Acceleration.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Acceleration.Abs asin()   { return new Acceleration.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Acceleration.Abs atan()   { return new Acceleration.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Acceleration.Abs cbrt()   { return new Acceleration.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Acceleration.Abs ceil()   { return new Acceleration.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Acceleration.Abs cos()    { return new Acceleration.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Acceleration.Abs cosh()   { return new Acceleration.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Acceleration.Abs exp()    { return new Acceleration.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Acceleration.Abs expm1()  { return new Acceleration.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Acceleration.Abs floor()  { return new Acceleration.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Acceleration.Abs log()    { return new Acceleration.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Acceleration.Abs log10()  { return new Acceleration.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Acceleration.Abs log1p()  { return new Acceleration.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Acceleration.Abs rint()   { return new Acceleration.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Acceleration.Abs round()  { return new Acceleration.Abs(Math.round(getInUnit()), getUnit()); }
            public Acceleration.Abs signum() { return new Acceleration.Abs(Math.signum(getInUnit()), getUnit()); }
            public Acceleration.Abs sin()    { return new Acceleration.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Acceleration.Abs sinh()   { return new Acceleration.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Acceleration.Abs sqrt()   { return new Acceleration.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Acceleration.Abs tan()    { return new Acceleration.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Acceleration.Abs tanh()   { return new Acceleration.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Acceleration.Abs inv()    { return new Acceleration.Abs(1.0f / getInUnit(), getUnit()); }
            public Acceleration.Abs toDegrees() { return new Acceleration.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Acceleration.Abs toRadians() { return new Acceleration.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Acceleration.Abs pow(final float x) { return new Acceleration.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Acceleration.Abs multiplyBy(final float factor) { return new Acceleration.Abs(getInUnit() * factor, getUnit()); }
            public Acceleration.Abs divideBy(final float divisor)  { return new Acceleration.Abs(getInUnit() / divisor, getUnit()); }
            
            public Acceleration.Abs plus(final Acceleration.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Acceleration.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Acceleration.Abs(this.si + v.si, AccelerationUnit.SI); } 

            public Acceleration.Rel minus(final Acceleration.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Acceleration.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Acceleration.Rel(this.si - v.si, AccelerationUnit.SI); } 

            public Acceleration.Abs minus(final Acceleration.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Acceleration.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Acceleration.Abs(this.si - v.si, AccelerationUnit.SI); } 

            public Speed.Abs multiplyBy(final Time.Abs v) { return new Speed.Abs(this.si * v.si, SpeedUnit.SI); }
            public Dimensionless.Abs divideBy(final Acceleration.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }
    
    /****************************************************************************************************************/
    /************************************************** ANGLE_PLANE *************************************************/ 
    /****************************************************************************************************************/

    abstract class AnglePlane extends FloatScalar<AnglePlaneUnit>
    {
        protected AnglePlane(final AnglePlaneUnit unit) { super(unit); }
        
        public static AnglePlane.Abs interpolate(final AnglePlane.Abs zero, final AnglePlane.Abs one, final float ratio)
        { return new AnglePlane.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static AnglePlane.Rel interpolate(final AnglePlane.Rel zero, final AnglePlane.Rel one, final float ratio)
        { return new AnglePlane.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<AnglePlaneUnit>
        {
            public Rel(final float value, final AnglePlaneUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<AnglePlaneUnit> value) { super(value); }
            
            public AnglePlane.Rel abs()    { return new AnglePlane.Rel(Math.abs(getInUnit()), getUnit()); }
            public AnglePlane.Rel acos()   { return new AnglePlane.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public AnglePlane.Rel asin()   { return new AnglePlane.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public AnglePlane.Rel atan()   { return new AnglePlane.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public AnglePlane.Rel cbrt()   { return new AnglePlane.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public AnglePlane.Rel ceil()   { return new AnglePlane.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public AnglePlane.Rel cos()    { return new AnglePlane.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public AnglePlane.Rel cosh()   { return new AnglePlane.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public AnglePlane.Rel exp()    { return new AnglePlane.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public AnglePlane.Rel expm1()  { return new AnglePlane.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public AnglePlane.Rel floor()  { return new AnglePlane.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public AnglePlane.Rel log()    { return new AnglePlane.Rel((float) Math.log(getInUnit()), getUnit()); }
            public AnglePlane.Rel log10()  { return new AnglePlane.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public AnglePlane.Rel log1p()  { return new AnglePlane.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public AnglePlane.Rel rint()   { return new AnglePlane.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public AnglePlane.Rel round()  { return new AnglePlane.Rel(Math.round(getInUnit()), getUnit()); }
            public AnglePlane.Rel signum() { return new AnglePlane.Rel(Math.signum(getInUnit()), getUnit()); }
            public AnglePlane.Rel sin()    { return new AnglePlane.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public AnglePlane.Rel sinh()   { return new AnglePlane.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public AnglePlane.Rel sqrt()   { return new AnglePlane.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public AnglePlane.Rel tan()    { return new AnglePlane.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public AnglePlane.Rel tanh()   { return new AnglePlane.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public AnglePlane.Rel inv()    { return new AnglePlane.Rel(1.0f / getInUnit(), getUnit()); }
            public AnglePlane.Rel toDegrees() { return new AnglePlane.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public AnglePlane.Rel toRadians() { return new AnglePlane.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public AnglePlane.Rel pow(final float x) { return new AnglePlane.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public AnglePlane.Rel multiplyBy(final float factor) { return new AnglePlane.Rel(getInUnit() * factor, getUnit()); }
            public AnglePlane.Rel divideBy(final float divisor)  { return new AnglePlane.Rel(getInUnit() / divisor, getUnit()); }
            
            public AnglePlane.Rel plus(final AnglePlane.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AnglePlane.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AnglePlane.Rel(this.si + v.si, AnglePlaneUnit.SI); } 

            public AnglePlane.Rel minus(final AnglePlane.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AnglePlane.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AnglePlane.Rel(this.si - v.si, AnglePlaneUnit.SI); } 

            public AnglePlane.Abs plus(final AnglePlane.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new AnglePlane.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AnglePlane.Abs(this.si + v.si, AnglePlaneUnit.SI); } 
            
            public Dimensionless.Rel divideBy(final AnglePlane.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<AnglePlaneUnit>
        {
            public Abs(final float value, final AnglePlaneUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<AnglePlaneUnit> value) { super(value); }
            public AnglePlane.Abs abs()    { return new AnglePlane.Abs(Math.abs(getInUnit()), getUnit()); }
            public AnglePlane.Abs acos()   { return new AnglePlane.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public AnglePlane.Abs asin()   { return new AnglePlane.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public AnglePlane.Abs atan()   { return new AnglePlane.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public AnglePlane.Abs cbrt()   { return new AnglePlane.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public AnglePlane.Abs ceil()   { return new AnglePlane.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public AnglePlane.Abs cos()    { return new AnglePlane.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public AnglePlane.Abs cosh()   { return new AnglePlane.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public AnglePlane.Abs exp()    { return new AnglePlane.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public AnglePlane.Abs expm1()  { return new AnglePlane.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public AnglePlane.Abs floor()  { return new AnglePlane.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public AnglePlane.Abs log()    { return new AnglePlane.Abs((float) Math.log(getInUnit()), getUnit()); }
            public AnglePlane.Abs log10()  { return new AnglePlane.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public AnglePlane.Abs log1p()  { return new AnglePlane.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public AnglePlane.Abs rint()   { return new AnglePlane.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public AnglePlane.Abs round()  { return new AnglePlane.Abs(Math.round(getInUnit()), getUnit()); }
            public AnglePlane.Abs signum() { return new AnglePlane.Abs(Math.signum(getInUnit()), getUnit()); }
            public AnglePlane.Abs sin()    { return new AnglePlane.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public AnglePlane.Abs sinh()   { return new AnglePlane.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public AnglePlane.Abs sqrt()   { return new AnglePlane.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public AnglePlane.Abs tan()    { return new AnglePlane.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public AnglePlane.Abs tanh()   { return new AnglePlane.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public AnglePlane.Abs inv()    { return new AnglePlane.Abs(1.0f / getInUnit(), getUnit()); }
            public AnglePlane.Abs toDegrees() { return new AnglePlane.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public AnglePlane.Abs toRadians() { return new AnglePlane.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public AnglePlane.Abs pow(final float x) { return new AnglePlane.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public AnglePlane.Abs multiplyBy(final float factor) { return new AnglePlane.Abs(getInUnit() * factor, getUnit()); }
            public AnglePlane.Abs divideBy(final float divisor)  { return new AnglePlane.Abs(getInUnit() / divisor, getUnit()); }
            
            public AnglePlane.Abs plus(final AnglePlane.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AnglePlane.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AnglePlane.Abs(this.si + v.si, AnglePlaneUnit.SI); } 

            public AnglePlane.Rel minus(final AnglePlane.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new AnglePlane.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AnglePlane.Rel(this.si - v.si, AnglePlaneUnit.SI); } 

            public AnglePlane.Abs minus(final AnglePlane.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AnglePlane.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AnglePlane.Abs(this.si - v.si, AnglePlaneUnit.SI); } 

            public Dimensionless.Abs divideBy(final AnglePlane.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** ANGLE_SLOPE *************************************************/ 
    /****************************************************************************************************************/

    abstract class AngleSlope extends FloatScalar<AngleSlopeUnit>
    {
        protected AngleSlope(final AngleSlopeUnit unit) { super(unit); }
        
        public static AngleSlope.Abs interpolate(final AngleSlope.Abs zero, final AngleSlope.Abs one, final float ratio)
        { return new AngleSlope.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static AngleSlope.Rel interpolate(final AngleSlope.Rel zero, final AngleSlope.Rel one, final float ratio)
        { return new AngleSlope.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<AngleSlopeUnit>
        {
            public Rel(final float value, final AngleSlopeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<AngleSlopeUnit> value) { super(value); }
            
            public AngleSlope.Rel abs()    { return new AngleSlope.Rel(Math.abs(getInUnit()), getUnit()); }
            public AngleSlope.Rel acos()   { return new AngleSlope.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public AngleSlope.Rel asin()   { return new AngleSlope.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public AngleSlope.Rel atan()   { return new AngleSlope.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public AngleSlope.Rel cbrt()   { return new AngleSlope.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public AngleSlope.Rel ceil()   { return new AngleSlope.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public AngleSlope.Rel cos()    { return new AngleSlope.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public AngleSlope.Rel cosh()   { return new AngleSlope.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public AngleSlope.Rel exp()    { return new AngleSlope.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public AngleSlope.Rel expm1()  { return new AngleSlope.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public AngleSlope.Rel floor()  { return new AngleSlope.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public AngleSlope.Rel log()    { return new AngleSlope.Rel((float) Math.log(getInUnit()), getUnit()); }
            public AngleSlope.Rel log10()  { return new AngleSlope.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public AngleSlope.Rel log1p()  { return new AngleSlope.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public AngleSlope.Rel rint()   { return new AngleSlope.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public AngleSlope.Rel round()  { return new AngleSlope.Rel(Math.round(getInUnit()), getUnit()); }
            public AngleSlope.Rel signum() { return new AngleSlope.Rel(Math.signum(getInUnit()), getUnit()); }
            public AngleSlope.Rel sin()    { return new AngleSlope.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public AngleSlope.Rel sinh()   { return new AngleSlope.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public AngleSlope.Rel sqrt()   { return new AngleSlope.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public AngleSlope.Rel tan()    { return new AngleSlope.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public AngleSlope.Rel tanh()   { return new AngleSlope.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public AngleSlope.Rel inv()    { return new AngleSlope.Rel(1.0f / getInUnit(), getUnit()); }
            public AngleSlope.Rel toDegrees() { return new AngleSlope.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public AngleSlope.Rel toRadians() { return new AngleSlope.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public AngleSlope.Rel pow(final float x) { return new AngleSlope.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public AngleSlope.Rel multiplyBy(final float factor) { return new AngleSlope.Rel(getInUnit() * factor, getUnit()); }
            public AngleSlope.Rel divideBy(final float divisor)  { return new AngleSlope.Rel(getInUnit() / divisor, getUnit()); }
            
            public AngleSlope.Rel plus(final AngleSlope.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSlope.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AngleSlope.Rel(this.si + v.si, AngleSlopeUnit.SI); } 

            public AngleSlope.Rel minus(final AngleSlope.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSlope.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AngleSlope.Rel(this.si - v.si, AngleSlopeUnit.SI); } 

            public AngleSlope.Abs plus(final AngleSlope.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSlope.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AngleSlope.Abs(this.si + v.si, AngleSlopeUnit.SI); } 
            
            public Dimensionless.Rel divideBy(final AngleSlope.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<AngleSlopeUnit>
        {
            public Abs(final float value, final AngleSlopeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<AngleSlopeUnit> value) { super(value); }
            public AngleSlope.Abs abs()    { return new AngleSlope.Abs(Math.abs(getInUnit()), getUnit()); }
            public AngleSlope.Abs acos()   { return new AngleSlope.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public AngleSlope.Abs asin()   { return new AngleSlope.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public AngleSlope.Abs atan()   { return new AngleSlope.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public AngleSlope.Abs cbrt()   { return new AngleSlope.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public AngleSlope.Abs ceil()   { return new AngleSlope.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public AngleSlope.Abs cos()    { return new AngleSlope.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public AngleSlope.Abs cosh()   { return new AngleSlope.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public AngleSlope.Abs exp()    { return new AngleSlope.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public AngleSlope.Abs expm1()  { return new AngleSlope.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public AngleSlope.Abs floor()  { return new AngleSlope.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public AngleSlope.Abs log()    { return new AngleSlope.Abs((float) Math.log(getInUnit()), getUnit()); }
            public AngleSlope.Abs log10()  { return new AngleSlope.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public AngleSlope.Abs log1p()  { return new AngleSlope.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public AngleSlope.Abs rint()   { return new AngleSlope.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public AngleSlope.Abs round()  { return new AngleSlope.Abs(Math.round(getInUnit()), getUnit()); }
            public AngleSlope.Abs signum() { return new AngleSlope.Abs(Math.signum(getInUnit()), getUnit()); }
            public AngleSlope.Abs sin()    { return new AngleSlope.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public AngleSlope.Abs sinh()   { return new AngleSlope.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public AngleSlope.Abs sqrt()   { return new AngleSlope.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public AngleSlope.Abs tan()    { return new AngleSlope.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public AngleSlope.Abs tanh()   { return new AngleSlope.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public AngleSlope.Abs inv()    { return new AngleSlope.Abs(1.0f / getInUnit(), getUnit()); }
            public AngleSlope.Abs toDegrees() { return new AngleSlope.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public AngleSlope.Abs toRadians() { return new AngleSlope.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public AngleSlope.Abs pow(final float x) { return new AngleSlope.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public AngleSlope.Abs multiplyBy(final float factor) { return new AngleSlope.Abs(getInUnit() * factor, getUnit()); }
            public AngleSlope.Abs divideBy(final float divisor)  { return new AngleSlope.Abs(getInUnit() / divisor, getUnit()); }
            
            public AngleSlope.Abs plus(final AngleSlope.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSlope.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AngleSlope.Abs(this.si + v.si, AngleSlopeUnit.SI); } 

            public AngleSlope.Rel minus(final AngleSlope.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSlope.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AngleSlope.Rel(this.si - v.si, AngleSlopeUnit.SI); } 

            public AngleSlope.Abs minus(final AngleSlope.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSlope.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AngleSlope.Abs(this.si - v.si, AngleSlopeUnit.SI); } 

            public Dimensionless.Abs divideBy(final AngleSlope.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** ANGLE_SOLID *************************************************/ 
    /****************************************************************************************************************/

    abstract class AngleSolid extends FloatScalar<AngleSolidUnit>
    {
        protected AngleSolid(final AngleSolidUnit unit) { super(unit); }
        
        public static AngleSolid.Abs interpolate(final AngleSolid.Abs zero, final AngleSolid.Abs one, final float ratio)
        { return new AngleSolid.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static AngleSolid.Rel interpolate(final AngleSolid.Rel zero, final AngleSolid.Rel one, final float ratio)
        { return new AngleSolid.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<AngleSolidUnit>
        {
            public Rel(final float value, final AngleSolidUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<AngleSolidUnit> value) { super(value); }
            
            public AngleSolid.Rel abs()    { return new AngleSolid.Rel(Math.abs(getInUnit()), getUnit()); }
            public AngleSolid.Rel acos()   { return new AngleSolid.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public AngleSolid.Rel asin()   { return new AngleSolid.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public AngleSolid.Rel atan()   { return new AngleSolid.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public AngleSolid.Rel cbrt()   { return new AngleSolid.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public AngleSolid.Rel ceil()   { return new AngleSolid.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public AngleSolid.Rel cos()    { return new AngleSolid.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public AngleSolid.Rel cosh()   { return new AngleSolid.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public AngleSolid.Rel exp()    { return new AngleSolid.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public AngleSolid.Rel expm1()  { return new AngleSolid.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public AngleSolid.Rel floor()  { return new AngleSolid.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public AngleSolid.Rel log()    { return new AngleSolid.Rel((float) Math.log(getInUnit()), getUnit()); }
            public AngleSolid.Rel log10()  { return new AngleSolid.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public AngleSolid.Rel log1p()  { return new AngleSolid.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public AngleSolid.Rel rint()   { return new AngleSolid.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public AngleSolid.Rel round()  { return new AngleSolid.Rel(Math.round(getInUnit()), getUnit()); }
            public AngleSolid.Rel signum() { return new AngleSolid.Rel(Math.signum(getInUnit()), getUnit()); }
            public AngleSolid.Rel sin()    { return new AngleSolid.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public AngleSolid.Rel sinh()   { return new AngleSolid.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public AngleSolid.Rel sqrt()   { return new AngleSolid.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public AngleSolid.Rel tan()    { return new AngleSolid.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public AngleSolid.Rel tanh()   { return new AngleSolid.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public AngleSolid.Rel inv()    { return new AngleSolid.Rel(1.0f / getInUnit(), getUnit()); }
            public AngleSolid.Rel toDegrees() { return new AngleSolid.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public AngleSolid.Rel toRadians() { return new AngleSolid.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public AngleSolid.Rel pow(final float x) { return new AngleSolid.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public AngleSolid.Rel multiplyBy(final float factor) { return new AngleSolid.Rel(getInUnit() * factor, getUnit()); }
            public AngleSolid.Rel divideBy(final float divisor)  { return new AngleSolid.Rel(getInUnit() / divisor, getUnit()); }
            
            public AngleSolid.Rel plus(final AngleSolid.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSolid.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AngleSolid.Rel(this.si + v.si, AngleSolidUnit.SI); } 

            public AngleSolid.Rel minus(final AngleSolid.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSolid.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AngleSolid.Rel(this.si - v.si, AngleSolidUnit.SI); } 

            public AngleSolid.Abs plus(final AngleSolid.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSolid.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AngleSolid.Abs(this.si + v.si, AngleSolidUnit.SI); } 
            
            public Dimensionless.Rel divideBy(final AngleSolid.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<AngleSolidUnit>
        {
            public Abs(final float value, final AngleSolidUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<AngleSolidUnit> value) { super(value); }
            public AngleSolid.Abs abs()    { return new AngleSolid.Abs(Math.abs(getInUnit()), getUnit()); }
            public AngleSolid.Abs acos()   { return new AngleSolid.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public AngleSolid.Abs asin()   { return new AngleSolid.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public AngleSolid.Abs atan()   { return new AngleSolid.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public AngleSolid.Abs cbrt()   { return new AngleSolid.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public AngleSolid.Abs ceil()   { return new AngleSolid.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public AngleSolid.Abs cos()    { return new AngleSolid.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public AngleSolid.Abs cosh()   { return new AngleSolid.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public AngleSolid.Abs exp()    { return new AngleSolid.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public AngleSolid.Abs expm1()  { return new AngleSolid.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public AngleSolid.Abs floor()  { return new AngleSolid.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public AngleSolid.Abs log()    { return new AngleSolid.Abs((float) Math.log(getInUnit()), getUnit()); }
            public AngleSolid.Abs log10()  { return new AngleSolid.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public AngleSolid.Abs log1p()  { return new AngleSolid.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public AngleSolid.Abs rint()   { return new AngleSolid.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public AngleSolid.Abs round()  { return new AngleSolid.Abs(Math.round(getInUnit()), getUnit()); }
            public AngleSolid.Abs signum() { return new AngleSolid.Abs(Math.signum(getInUnit()), getUnit()); }
            public AngleSolid.Abs sin()    { return new AngleSolid.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public AngleSolid.Abs sinh()   { return new AngleSolid.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public AngleSolid.Abs sqrt()   { return new AngleSolid.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public AngleSolid.Abs tan()    { return new AngleSolid.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public AngleSolid.Abs tanh()   { return new AngleSolid.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public AngleSolid.Abs inv()    { return new AngleSolid.Abs(1.0f / getInUnit(), getUnit()); }
            public AngleSolid.Abs toDegrees() { return new AngleSolid.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public AngleSolid.Abs toRadians() { return new AngleSolid.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public AngleSolid.Abs pow(final float x) { return new AngleSolid.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public AngleSolid.Abs multiplyBy(final float factor) { return new AngleSolid.Abs(getInUnit() * factor, getUnit()); }
            public AngleSolid.Abs divideBy(final float divisor)  { return new AngleSolid.Abs(getInUnit() / divisor, getUnit()); }
            
            public AngleSolid.Abs plus(final AngleSolid.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSolid.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new AngleSolid.Abs(this.si + v.si, AngleSolidUnit.SI); } 

            public AngleSolid.Rel minus(final AngleSolid.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSolid.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AngleSolid.Rel(this.si - v.si, AngleSolidUnit.SI); } 

            public AngleSolid.Abs minus(final AngleSolid.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new AngleSolid.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new AngleSolid.Abs(this.si - v.si, AngleSolidUnit.SI); } 

            public Dimensionless.Abs divideBy(final AngleSolid.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /***************************************************** AREA *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Area extends FloatScalar<AreaUnit>
    {
        protected Area(final AreaUnit unit) { super(unit); }
        
        public static Area.Abs interpolate(final Area.Abs zero, final Area.Abs one, final float ratio)
        { return new Area.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Area.Rel interpolate(final Area.Rel zero, final Area.Rel one, final float ratio)
        { return new Area.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<AreaUnit>
        {
            public Rel(final float value, final AreaUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<AreaUnit> value) { super(value); }
            
            public Area.Rel abs()    { return new Area.Rel(Math.abs(getInUnit()), getUnit()); }
            public Area.Rel acos()   { return new Area.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Area.Rel asin()   { return new Area.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Area.Rel atan()   { return new Area.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Area.Rel cbrt()   { return new Area.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Area.Rel ceil()   { return new Area.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Area.Rel cos()    { return new Area.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Area.Rel cosh()   { return new Area.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Area.Rel exp()    { return new Area.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Area.Rel expm1()  { return new Area.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Area.Rel floor()  { return new Area.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Area.Rel log()    { return new Area.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Area.Rel log10()  { return new Area.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Area.Rel log1p()  { return new Area.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Area.Rel rint()   { return new Area.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Area.Rel round()  { return new Area.Rel(Math.round(getInUnit()), getUnit()); }
            public Area.Rel signum() { return new Area.Rel(Math.signum(getInUnit()), getUnit()); }
            public Area.Rel sin()    { return new Area.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Area.Rel sinh()   { return new Area.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Area.Rel sqrt()   { return new Area.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Area.Rel tan()    { return new Area.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Area.Rel tanh()   { return new Area.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Area.Rel inv()    { return new Area.Rel(1.0f / getInUnit(), getUnit()); }
            public Area.Rel toDegrees() { return new Area.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Area.Rel toRadians() { return new Area.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Area.Rel pow(final float x) { return new Area.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Area.Rel multiplyBy(final float factor) { return new Area.Rel(getInUnit() * factor, getUnit()); }
            public Area.Rel divideBy(final float divisor)  { return new Area.Rel(getInUnit() / divisor, getUnit()); }
            
            public Area.Rel plus(final Area.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Area.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Area.Rel(this.si + v.si, AreaUnit.SI); } 

            public Area.Rel minus(final Area.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Area.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Area.Rel(this.si - v.si, AreaUnit.SI); } 

            public Area.Abs plus(final Area.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Area.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Area.Abs(this.si + v.si, AreaUnit.SI); } 
            
            public Volume.Rel multiplyBy(final Length.Rel v) { return new Volume.Rel(this.si * v.si, VolumeUnit.SI); }
            public Length.Rel divideBy(final Length.Rel v) { return new Length.Rel(this.si / v.si, LengthUnit.SI); }
            public FlowVolume.Rel multiplyBy(final Speed.Rel v) { return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI); }
            public Dimensionless.Rel divideBy(final Area.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<AreaUnit>
        {
            public Abs(final float value, final AreaUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<AreaUnit> value) { super(value); }
            public Area.Abs abs()    { return new Area.Abs(Math.abs(getInUnit()), getUnit()); }
            public Area.Abs acos()   { return new Area.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Area.Abs asin()   { return new Area.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Area.Abs atan()   { return new Area.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Area.Abs cbrt()   { return new Area.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Area.Abs ceil()   { return new Area.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Area.Abs cos()    { return new Area.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Area.Abs cosh()   { return new Area.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Area.Abs exp()    { return new Area.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Area.Abs expm1()  { return new Area.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Area.Abs floor()  { return new Area.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Area.Abs log()    { return new Area.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Area.Abs log10()  { return new Area.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Area.Abs log1p()  { return new Area.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Area.Abs rint()   { return new Area.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Area.Abs round()  { return new Area.Abs(Math.round(getInUnit()), getUnit()); }
            public Area.Abs signum() { return new Area.Abs(Math.signum(getInUnit()), getUnit()); }
            public Area.Abs sin()    { return new Area.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Area.Abs sinh()   { return new Area.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Area.Abs sqrt()   { return new Area.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Area.Abs tan()    { return new Area.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Area.Abs tanh()   { return new Area.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Area.Abs inv()    { return new Area.Abs(1.0f / getInUnit(), getUnit()); }
            public Area.Abs toDegrees() { return new Area.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Area.Abs toRadians() { return new Area.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Area.Abs pow(final float x) { return new Area.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Area.Abs multiplyBy(final float factor) { return new Area.Abs(getInUnit() * factor, getUnit()); }
            public Area.Abs divideBy(final float divisor)  { return new Area.Abs(getInUnit() / divisor, getUnit()); }
            
            public Area.Abs plus(final Area.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Area.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Area.Abs(this.si + v.si, AreaUnit.SI); } 

            public Area.Rel minus(final Area.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Area.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Area.Rel(this.si - v.si, AreaUnit.SI); } 

            public Area.Abs minus(final Area.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Area.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Area.Abs(this.si - v.si, AreaUnit.SI); } 

            public Volume.Abs multiplyBy(final Length.Abs v) { return new Volume.Abs(this.si * v.si, VolumeUnit.SI); }
            public Length.Abs divideBy(final Length.Abs v) { return new Length.Abs(this.si / v.si, LengthUnit.SI); }
            public FlowVolume.Abs multiplyBy(final Speed.Abs v) { return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI); }

            public Dimensionless.Abs divideBy(final Area.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }
    
    /****************************************************************************************************************/
    /**************************************************** DENSITY ***************************************************/ 
    /****************************************************************************************************************/

    abstract class Density extends FloatScalar<DensityUnit>
    {
        protected Density(final DensityUnit unit) { super(unit); }
        
        public static Density.Abs interpolate(final Density.Abs zero, final Density.Abs one, final float ratio)
        { return new Density.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Density.Rel interpolate(final Density.Rel zero, final Density.Rel one, final float ratio)
        { return new Density.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<DensityUnit>
        {
            public Rel(final float value, final DensityUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<DensityUnit> value) { super(value); }
            
            public Density.Rel abs()    { return new Density.Rel(Math.abs(getInUnit()), getUnit()); }
            public Density.Rel acos()   { return new Density.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Density.Rel asin()   { return new Density.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Density.Rel atan()   { return new Density.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Density.Rel cbrt()   { return new Density.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Density.Rel ceil()   { return new Density.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Density.Rel cos()    { return new Density.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Density.Rel cosh()   { return new Density.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Density.Rel exp()    { return new Density.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Density.Rel expm1()  { return new Density.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Density.Rel floor()  { return new Density.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Density.Rel log()    { return new Density.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Density.Rel log10()  { return new Density.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Density.Rel log1p()  { return new Density.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Density.Rel rint()   { return new Density.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Density.Rel round()  { return new Density.Rel(Math.round(getInUnit()), getUnit()); }
            public Density.Rel signum() { return new Density.Rel(Math.signum(getInUnit()), getUnit()); }
            public Density.Rel sin()    { return new Density.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Density.Rel sinh()   { return new Density.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Density.Rel sqrt()   { return new Density.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Density.Rel tan()    { return new Density.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Density.Rel tanh()   { return new Density.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Density.Rel inv()    { return new Density.Rel(1.0f / getInUnit(), getUnit()); }
            public Density.Rel toDegrees() { return new Density.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Density.Rel toRadians() { return new Density.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Density.Rel pow(final float x) { return new Density.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Density.Rel multiplyBy(final float factor) { return new Density.Rel(getInUnit() * factor, getUnit()); }
            public Density.Rel divideBy(final float divisor)  { return new Density.Rel(getInUnit() / divisor, getUnit()); }
            
            public Density.Rel plus(final Density.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Density.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Density.Rel(this.si + v.si, DensityUnit.SI); } 

            public Density.Rel minus(final Density.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Density.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Density.Rel(this.si - v.si, DensityUnit.SI); } 

            public Density.Abs plus(final Density.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Density.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Density.Abs(this.si + v.si, DensityUnit.SI); } 

            public Mass.Rel multiplyBy(final Volume.Rel v) { return new Mass.Rel(this.si * v.si, MassUnit.SI); }
            public Dimensionless.Rel divideBy(final Density.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<DensityUnit>
        {
            public Abs(final float value, final DensityUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<DensityUnit> value) { super(value); }
            public Density.Abs abs()    { return new Density.Abs(Math.abs(getInUnit()), getUnit()); }
            public Density.Abs acos()   { return new Density.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Density.Abs asin()   { return new Density.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Density.Abs atan()   { return new Density.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Density.Abs cbrt()   { return new Density.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Density.Abs ceil()   { return new Density.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Density.Abs cos()    { return new Density.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Density.Abs cosh()   { return new Density.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Density.Abs exp()    { return new Density.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Density.Abs expm1()  { return new Density.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Density.Abs floor()  { return new Density.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Density.Abs log()    { return new Density.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Density.Abs log10()  { return new Density.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Density.Abs log1p()  { return new Density.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Density.Abs rint()   { return new Density.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Density.Abs round()  { return new Density.Abs(Math.round(getInUnit()), getUnit()); }
            public Density.Abs signum() { return new Density.Abs(Math.signum(getInUnit()), getUnit()); }
            public Density.Abs sin()    { return new Density.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Density.Abs sinh()   { return new Density.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Density.Abs sqrt()   { return new Density.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Density.Abs tan()    { return new Density.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Density.Abs tanh()   { return new Density.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Density.Abs inv()    { return new Density.Abs(1.0f / getInUnit(), getUnit()); }
            public Density.Abs toDegrees() { return new Density.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Density.Abs toRadians() { return new Density.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Density.Abs pow(final float x) { return new Density.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Density.Abs multiplyBy(final float factor) { return new Density.Abs(getInUnit() * factor, getUnit()); }
            public Density.Abs divideBy(final float divisor)  { return new Density.Abs(getInUnit() / divisor, getUnit()); }
            
            public Density.Abs plus(final Density.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Density.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Density.Abs(this.si + v.si, DensityUnit.SI); } 

            public Density.Rel minus(final Density.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Density.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Density.Rel(this.si - v.si, DensityUnit.SI); } 

            public Density.Abs minus(final Density.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Density.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Density.Abs(this.si - v.si, DensityUnit.SI); } 
            
            public Mass.Abs multiplyBy(final Volume.Abs v) { return new Mass.Abs(this.si * v.si, MassUnit.SI); }
            public Dimensionless.Abs divideBy(final Density.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /*********************************************** ELECTRICAL_CHARGE **********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalCharge extends FloatScalar<ElectricalChargeUnit>
    {
        protected ElectricalCharge(final ElectricalChargeUnit unit) { super(unit); }
        
        public static ElectricalCharge.Abs interpolate(final ElectricalCharge.Abs zero, final ElectricalCharge.Abs one, final float ratio)
        { return new ElectricalCharge.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static ElectricalCharge.Rel interpolate(final ElectricalCharge.Rel zero, final ElectricalCharge.Rel one, final float ratio)
        { return new ElectricalCharge.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<ElectricalChargeUnit>
        {
            public Rel(final float value, final ElectricalChargeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<ElectricalChargeUnit> value) { super(value); }
            
            public ElectricalCharge.Rel abs()    { return new ElectricalCharge.Rel(Math.abs(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel acos()   { return new ElectricalCharge.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel asin()   { return new ElectricalCharge.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel atan()   { return new ElectricalCharge.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel cbrt()   { return new ElectricalCharge.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel ceil()   { return new ElectricalCharge.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel cos()    { return new ElectricalCharge.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel cosh()   { return new ElectricalCharge.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel exp()    { return new ElectricalCharge.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel expm1()  { return new ElectricalCharge.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel floor()  { return new ElectricalCharge.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel log()    { return new ElectricalCharge.Rel((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel log10()  { return new ElectricalCharge.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel log1p()  { return new ElectricalCharge.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel rint()   { return new ElectricalCharge.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel round()  { return new ElectricalCharge.Rel(Math.round(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel signum() { return new ElectricalCharge.Rel(Math.signum(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel sin()    { return new ElectricalCharge.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel sinh()   { return new ElectricalCharge.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel sqrt()   { return new ElectricalCharge.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel tan()    { return new ElectricalCharge.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel tanh()   { return new ElectricalCharge.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel inv()    { return new ElectricalCharge.Rel(1.0f / getInUnit(), getUnit()); }
            public ElectricalCharge.Rel toDegrees() { return new ElectricalCharge.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel toRadians() { return new ElectricalCharge.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalCharge.Rel pow(final float x) { return new ElectricalCharge.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalCharge.Rel multiplyBy(final float factor) { return new ElectricalCharge.Rel(getInUnit() * factor, getUnit()); }
            public ElectricalCharge.Rel divideBy(final float divisor)  { return new ElectricalCharge.Rel(getInUnit() / divisor, getUnit()); }
            
            public ElectricalCharge.Rel plus(final ElectricalCharge.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalCharge.Rel(this.si + v.si, ElectricalChargeUnit.SI); } 

            public ElectricalCharge.Rel minus(final ElectricalCharge.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalCharge.Rel(this.si - v.si, ElectricalChargeUnit.SI); } 

            public ElectricalCharge.Abs plus(final ElectricalCharge.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalCharge.Abs(this.si + v.si, ElectricalChargeUnit.SI); } 
            
            public ElectricalCurrent.Rel divideBy(final Time.Rel v) { 
                return new ElectricalCurrent.Rel(this.si / v.si, ElectricalCurrentUnit.SI); }
            public Time.Rel divideBy(final ElectricalCurrent.Rel v) { return new Time.Rel(this.si / v.si, TimeUnit.SI); }
            public Dimensionless.Rel divideBy(final ElectricalCharge.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<ElectricalChargeUnit>
        {
            public Abs(final float value, final ElectricalChargeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<ElectricalChargeUnit> value) { super(value); }
            public ElectricalCharge.Abs abs()    { return new ElectricalCharge.Abs(Math.abs(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs acos()   { return new ElectricalCharge.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs asin()   { return new ElectricalCharge.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs atan()   { return new ElectricalCharge.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs cbrt()   { return new ElectricalCharge.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs ceil()   { return new ElectricalCharge.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs cos()    { return new ElectricalCharge.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs cosh()   { return new ElectricalCharge.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs exp()    { return new ElectricalCharge.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs expm1()  { return new ElectricalCharge.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs floor()  { return new ElectricalCharge.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs log()    { return new ElectricalCharge.Abs((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs log10()  { return new ElectricalCharge.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs log1p()  { return new ElectricalCharge.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs rint()   { return new ElectricalCharge.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs round()  { return new ElectricalCharge.Abs(Math.round(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs signum() { return new ElectricalCharge.Abs(Math.signum(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs sin()    { return new ElectricalCharge.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs sinh()   { return new ElectricalCharge.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs sqrt()   { return new ElectricalCharge.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs tan()    { return new ElectricalCharge.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs tanh()   { return new ElectricalCharge.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs inv()    { return new ElectricalCharge.Abs(1.0f / getInUnit(), getUnit()); }
            public ElectricalCharge.Abs toDegrees() { return new ElectricalCharge.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs toRadians() { return new ElectricalCharge.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalCharge.Abs pow(final float x) { return new ElectricalCharge.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalCharge.Abs multiplyBy(final float factor) { return new ElectricalCharge.Abs(getInUnit() * factor, getUnit()); }
            public ElectricalCharge.Abs divideBy(final float divisor)  { return new ElectricalCharge.Abs(getInUnit() / divisor, getUnit()); }
            
            public ElectricalCharge.Abs plus(final ElectricalCharge.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalCharge.Abs(this.si + v.si, ElectricalChargeUnit.SI); } 

            public ElectricalCharge.Rel minus(final ElectricalCharge.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalCharge.Rel(this.si - v.si, ElectricalChargeUnit.SI); } 

            public ElectricalCharge.Abs minus(final ElectricalCharge.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalCharge.Abs(this.si - v.si, ElectricalChargeUnit.SI); } 

            public ElectricalCurrent.Abs divideBy(final Time.Abs v) { 
                return new ElectricalCurrent.Abs(this.si / v.si, ElectricalCurrentUnit.SI); }
            public Time.Abs divideBy(final ElectricalCurrent.Abs v) { return new Time.Abs(this.si / v.si, TimeUnit.SI); }
            public Dimensionless.Abs divideBy(final ElectricalCharge.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /********************************************** ELECTRICAL_CURRENT **********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalCurrent extends FloatScalar<ElectricalCurrentUnit>
    {
        protected ElectricalCurrent(final ElectricalCurrentUnit unit) { super(unit); }
        
        public static ElectricalCurrent.Abs interpolate(final ElectricalCurrent.Abs zero, final ElectricalCurrent.Abs one, final float ratio)
        { return new ElectricalCurrent.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static ElectricalCurrent.Rel interpolate(final ElectricalCurrent.Rel zero, final ElectricalCurrent.Rel one, final float ratio)
        { return new ElectricalCurrent.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<ElectricalCurrentUnit>
        {
            public Rel(final float value, final ElectricalCurrentUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<ElectricalCurrentUnit> value) { super(value); }
            
            public ElectricalCurrent.Rel abs()    { return new ElectricalCurrent.Rel(Math.abs(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel acos()   { return new ElectricalCurrent.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel asin()   { return new ElectricalCurrent.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel atan()   { return new ElectricalCurrent.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel cbrt()   { return new ElectricalCurrent.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel ceil()   { return new ElectricalCurrent.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel cos()    { return new ElectricalCurrent.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel cosh()   { return new ElectricalCurrent.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel exp()    { return new ElectricalCurrent.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel expm1()  { return new ElectricalCurrent.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel floor()  { return new ElectricalCurrent.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel log()    { return new ElectricalCurrent.Rel((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel log10()  { return new ElectricalCurrent.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel log1p()  { return new ElectricalCurrent.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel rint()   { return new ElectricalCurrent.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel round()  { return new ElectricalCurrent.Rel(Math.round(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel signum() { return new ElectricalCurrent.Rel(Math.signum(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel sin()    { return new ElectricalCurrent.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel sinh()   { return new ElectricalCurrent.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel sqrt()   { return new ElectricalCurrent.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel tan()    { return new ElectricalCurrent.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel tanh()   { return new ElectricalCurrent.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel inv()    { return new ElectricalCurrent.Rel(1.0f / getInUnit(), getUnit()); }
            public ElectricalCurrent.Rel toDegrees() { return new ElectricalCurrent.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel toRadians() { return new ElectricalCurrent.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalCurrent.Rel pow(final float x) { return new ElectricalCurrent.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalCurrent.Rel multiplyBy(final float factor) { return new ElectricalCurrent.Rel(getInUnit() * factor, getUnit()); }
            public ElectricalCurrent.Rel divideBy(final float divisor)  { return new ElectricalCurrent.Rel(getInUnit() / divisor, getUnit()); }
            
            public ElectricalCurrent.Rel plus(final ElectricalCurrent.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalCurrent.Rel(this.si + v.si, ElectricalCurrentUnit.SI); } 

            public ElectricalCurrent.Rel minus(final ElectricalCurrent.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalCurrent.Rel(this.si - v.si, ElectricalCurrentUnit.SI); } 

            public ElectricalCurrent.Abs plus(final ElectricalCurrent.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalCurrent.Abs(this.si + v.si, ElectricalCurrentUnit.SI); } 
            
            public Power.Rel multiplyBy(final ElectricalPotential.Rel v) { return new Power.Rel(this.si * v.si, PowerUnit.SI); }
            public ElectricalCharge.Rel multiplyBy(final Time.Rel v) { 
                return new ElectricalCharge.Rel(this.si * v.si, ElectricalChargeUnit.SI); }
            public Dimensionless.Rel divideBy(final ElectricalCurrent.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<ElectricalCurrentUnit>
        {
            public Abs(final float value, final ElectricalCurrentUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<ElectricalCurrentUnit> value) { super(value); }
            public ElectricalCurrent.Abs abs()    { return new ElectricalCurrent.Abs(Math.abs(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs acos()   { return new ElectricalCurrent.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs asin()   { return new ElectricalCurrent.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs atan()   { return new ElectricalCurrent.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs cbrt()   { return new ElectricalCurrent.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs ceil()   { return new ElectricalCurrent.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs cos()    { return new ElectricalCurrent.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs cosh()   { return new ElectricalCurrent.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs exp()    { return new ElectricalCurrent.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs expm1()  { return new ElectricalCurrent.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs floor()  { return new ElectricalCurrent.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs log()    { return new ElectricalCurrent.Abs((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs log10()  { return new ElectricalCurrent.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs log1p()  { return new ElectricalCurrent.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs rint()   { return new ElectricalCurrent.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs round()  { return new ElectricalCurrent.Abs(Math.round(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs signum() { return new ElectricalCurrent.Abs(Math.signum(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs sin()    { return new ElectricalCurrent.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs sinh()   { return new ElectricalCurrent.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs sqrt()   { return new ElectricalCurrent.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs tan()    { return new ElectricalCurrent.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs tanh()   { return new ElectricalCurrent.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs inv()    { return new ElectricalCurrent.Abs(1.0f / getInUnit(), getUnit()); }
            public ElectricalCurrent.Abs toDegrees() { return new ElectricalCurrent.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs toRadians() { return new ElectricalCurrent.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalCurrent.Abs pow(final float x) { return new ElectricalCurrent.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalCurrent.Abs multiplyBy(final float factor) { return new ElectricalCurrent.Abs(getInUnit() * factor, getUnit()); }
            public ElectricalCurrent.Abs divideBy(final float divisor)  { return new ElectricalCurrent.Abs(getInUnit() / divisor, getUnit()); }
            
            public ElectricalCurrent.Abs plus(final ElectricalCurrent.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalCurrent.Abs(this.si + v.si, ElectricalCurrentUnit.SI); } 

            public ElectricalCurrent.Rel minus(final ElectricalCurrent.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalCurrent.Rel(this.si - v.si, ElectricalCurrentUnit.SI); } 

            public ElectricalCurrent.Abs minus(final ElectricalCurrent.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalCurrent.Abs(this.si - v.si, ElectricalCurrentUnit.SI); } 

            public Power.Abs multiplyBy(final ElectricalPotential.Abs v) { return new Power.Abs(this.si * v.si, PowerUnit.SI); }
            public ElectricalCharge.Abs multiplyBy(final Time.Abs v) { 
                return new ElectricalCharge.Abs(this.si * v.si, ElectricalChargeUnit.SI); }
            public Dimensionless.Abs divideBy(final ElectricalCurrent.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /********************************************* ELECTRICAL_POTENTIAL *********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalPotential extends FloatScalar<ElectricalPotentialUnit>
    {
        protected ElectricalPotential(final ElectricalPotentialUnit unit) { super(unit); }
        
        public static ElectricalPotential.Abs interpolate(final ElectricalPotential.Abs zero, final ElectricalPotential.Abs one, final float ratio)
        { return new ElectricalPotential.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static ElectricalPotential.Rel interpolate(final ElectricalPotential.Rel zero, final ElectricalPotential.Rel one, final float ratio)
        { return new ElectricalPotential.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<ElectricalPotentialUnit>
        {
            public Rel(final float value, final ElectricalPotentialUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<ElectricalPotentialUnit> value) { super(value); }
            
            public ElectricalPotential.Rel abs()    { return new ElectricalPotential.Rel(Math.abs(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel acos()   { return new ElectricalPotential.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel asin()   { return new ElectricalPotential.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel atan()   { return new ElectricalPotential.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel cbrt()   { return new ElectricalPotential.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel ceil()   { return new ElectricalPotential.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel cos()    { return new ElectricalPotential.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel cosh()   { return new ElectricalPotential.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel exp()    { return new ElectricalPotential.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel expm1()  { return new ElectricalPotential.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel floor()  { return new ElectricalPotential.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel log()    { return new ElectricalPotential.Rel((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel log10()  { return new ElectricalPotential.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel log1p()  { return new ElectricalPotential.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel rint()   { return new ElectricalPotential.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel round()  { return new ElectricalPotential.Rel(Math.round(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel signum() { return new ElectricalPotential.Rel(Math.signum(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel sin()    { return new ElectricalPotential.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel sinh()   { return new ElectricalPotential.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel sqrt()   { return new ElectricalPotential.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel tan()    { return new ElectricalPotential.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel tanh()   { return new ElectricalPotential.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel inv()    { return new ElectricalPotential.Rel(1.0f / getInUnit(), getUnit()); }
            public ElectricalPotential.Rel toDegrees() { return new ElectricalPotential.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel toRadians() { return new ElectricalPotential.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalPotential.Rel pow(final float x) { return new ElectricalPotential.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalPotential.Rel multiplyBy(final float factor) { return new ElectricalPotential.Rel(getInUnit() * factor, getUnit()); }
            public ElectricalPotential.Rel divideBy(final float divisor)  { return new ElectricalPotential.Rel(getInUnit() / divisor, getUnit()); }
            
            public ElectricalPotential.Rel plus(final ElectricalPotential.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalPotential.Rel(this.si + v.si, ElectricalPotentialUnit.SI); } 

            public ElectricalPotential.Rel minus(final ElectricalPotential.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalPotential.Rel(this.si - v.si, ElectricalPotentialUnit.SI); } 

            public ElectricalPotential.Abs plus(final ElectricalPotential.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalPotential.Abs(this.si + v.si, ElectricalPotentialUnit.SI); } 
            
            public Power.Rel multiplyBy(final ElectricalCurrent.Rel v) { return new Power.Rel(this.si * v.si, PowerUnit.SI); }
            public ElectricalResistance.Rel divideBy(final ElectricalCurrent.Rel v) { 
                return new ElectricalResistance.Rel(this.si / v.si, ElectricalResistanceUnit.SI); }
            public Dimensionless.Rel divideBy(final ElectricalPotential.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<ElectricalPotentialUnit>
        {
            public Abs(final float value, final ElectricalPotentialUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<ElectricalPotentialUnit> value) { super(value); }
            public ElectricalPotential.Abs abs()    { return new ElectricalPotential.Abs(Math.abs(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs acos()   { return new ElectricalPotential.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs asin()   { return new ElectricalPotential.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs atan()   { return new ElectricalPotential.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs cbrt()   { return new ElectricalPotential.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs ceil()   { return new ElectricalPotential.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs cos()    { return new ElectricalPotential.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs cosh()   { return new ElectricalPotential.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs exp()    { return new ElectricalPotential.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs expm1()  { return new ElectricalPotential.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs floor()  { return new ElectricalPotential.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs log()    { return new ElectricalPotential.Abs((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs log10()  { return new ElectricalPotential.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs log1p()  { return new ElectricalPotential.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs rint()   { return new ElectricalPotential.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs round()  { return new ElectricalPotential.Abs(Math.round(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs signum() { return new ElectricalPotential.Abs(Math.signum(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs sin()    { return new ElectricalPotential.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs sinh()   { return new ElectricalPotential.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs sqrt()   { return new ElectricalPotential.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs tan()    { return new ElectricalPotential.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs tanh()   { return new ElectricalPotential.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs inv()    { return new ElectricalPotential.Abs(1.0f / getInUnit(), getUnit()); }
            public ElectricalPotential.Abs toDegrees() { return new ElectricalPotential.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs toRadians() { return new ElectricalPotential.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalPotential.Abs pow(final float x) { return new ElectricalPotential.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalPotential.Abs multiplyBy(final float factor) { return new ElectricalPotential.Abs(getInUnit() * factor, getUnit()); }
            public ElectricalPotential.Abs divideBy(final float divisor)  { return new ElectricalPotential.Abs(getInUnit() / divisor, getUnit()); }
            
            public ElectricalPotential.Abs plus(final ElectricalPotential.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalPotential.Abs(this.si + v.si, ElectricalPotentialUnit.SI); } 

            public ElectricalPotential.Rel minus(final ElectricalPotential.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalPotential.Rel(this.si - v.si, ElectricalPotentialUnit.SI); } 

            public ElectricalPotential.Abs minus(final ElectricalPotential.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalPotential.Abs(this.si - v.si, ElectricalPotentialUnit.SI); } 

            public Power.Abs multiplyBy(final ElectricalCurrent.Abs v) { return new Power.Abs(this.si * v.si, PowerUnit.SI); }
            public ElectricalResistance.Abs divideBy(final ElectricalCurrent.Abs v) { 
                return new ElectricalResistance.Abs(this.si / v.si, ElectricalResistanceUnit.SI); }
            public Dimensionless.Abs divideBy(final ElectricalPotential.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /******************************************** ELECTRICAL_RESISTANCE *********************************************/ 
    /****************************************************************************************************************/

    abstract class ElectricalResistance extends FloatScalar<ElectricalResistanceUnit>
    {
        protected ElectricalResistance(final ElectricalResistanceUnit unit) { super(unit); }
        
        public static ElectricalResistance.Abs interpolate(final ElectricalResistance.Abs zero, final ElectricalResistance.Abs one, final float ratio)
        { return new ElectricalResistance.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static ElectricalResistance.Rel interpolate(final ElectricalResistance.Rel zero, final ElectricalResistance.Rel one, final float ratio)
        { return new ElectricalResistance.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<ElectricalResistanceUnit>
        {
            public Rel(final float value, final ElectricalResistanceUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<ElectricalResistanceUnit> value) { super(value); }
            
            public ElectricalResistance.Rel abs()    { return new ElectricalResistance.Rel(Math.abs(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel acos()   { return new ElectricalResistance.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel asin()   { return new ElectricalResistance.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel atan()   { return new ElectricalResistance.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel cbrt()   { return new ElectricalResistance.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel ceil()   { return new ElectricalResistance.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel cos()    { return new ElectricalResistance.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel cosh()   { return new ElectricalResistance.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel exp()    { return new ElectricalResistance.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel expm1()  { return new ElectricalResistance.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel floor()  { return new ElectricalResistance.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel log()    { return new ElectricalResistance.Rel((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel log10()  { return new ElectricalResistance.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel log1p()  { return new ElectricalResistance.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel rint()   { return new ElectricalResistance.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel round()  { return new ElectricalResistance.Rel(Math.round(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel signum() { return new ElectricalResistance.Rel(Math.signum(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel sin()    { return new ElectricalResistance.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel sinh()   { return new ElectricalResistance.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel sqrt()   { return new ElectricalResistance.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel tan()    { return new ElectricalResistance.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel tanh()   { return new ElectricalResistance.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel inv()    { return new ElectricalResistance.Rel(1.0f / getInUnit(), getUnit()); }
            public ElectricalResistance.Rel toDegrees() { return new ElectricalResistance.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel toRadians() { return new ElectricalResistance.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalResistance.Rel pow(final float x) { return new ElectricalResistance.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalResistance.Rel multiplyBy(final float factor) { return new ElectricalResistance.Rel(getInUnit() * factor, getUnit()); }
            public ElectricalResistance.Rel divideBy(final float divisor)  { return new ElectricalResistance.Rel(getInUnit() / divisor, getUnit()); }
            
            public ElectricalResistance.Rel plus(final ElectricalResistance.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalResistance.Rel(this.si + v.si, ElectricalResistanceUnit.SI); } 

            public ElectricalResistance.Rel minus(final ElectricalResistance.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalResistance.Rel(this.si - v.si, ElectricalResistanceUnit.SI); } 

            public ElectricalResistance.Abs plus(final ElectricalResistance.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalResistance.Abs(this.si + v.si, ElectricalResistanceUnit.SI); } 
            
            public ElectricalPotential.Rel multiplyBy(final ElectricalCurrent.Rel v) { 
                return new ElectricalPotential.Rel(this.si * v.si, ElectricalPotentialUnit.SI); }
            public Dimensionless.Rel divideBy(final ElectricalResistance.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<ElectricalResistanceUnit>
        {
            public Abs(final float value, final ElectricalResistanceUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<ElectricalResistanceUnit> value) { super(value); }
            public ElectricalResistance.Abs abs()    { return new ElectricalResistance.Abs(Math.abs(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs acos()   { return new ElectricalResistance.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs asin()   { return new ElectricalResistance.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs atan()   { return new ElectricalResistance.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs cbrt()   { return new ElectricalResistance.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs ceil()   { return new ElectricalResistance.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs cos()    { return new ElectricalResistance.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs cosh()   { return new ElectricalResistance.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs exp()    { return new ElectricalResistance.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs expm1()  { return new ElectricalResistance.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs floor()  { return new ElectricalResistance.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs log()    { return new ElectricalResistance.Abs((float) Math.log(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs log10()  { return new ElectricalResistance.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs log1p()  { return new ElectricalResistance.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs rint()   { return new ElectricalResistance.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs round()  { return new ElectricalResistance.Abs(Math.round(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs signum() { return new ElectricalResistance.Abs(Math.signum(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs sin()    { return new ElectricalResistance.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs sinh()   { return new ElectricalResistance.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs sqrt()   { return new ElectricalResistance.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs tan()    { return new ElectricalResistance.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs tanh()   { return new ElectricalResistance.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs inv()    { return new ElectricalResistance.Abs(1.0f / getInUnit(), getUnit()); }
            public ElectricalResistance.Abs toDegrees() { return new ElectricalResistance.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs toRadians() { return new ElectricalResistance.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public ElectricalResistance.Abs pow(final float x) { return new ElectricalResistance.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public ElectricalResistance.Abs multiplyBy(final float factor) { return new ElectricalResistance.Abs(getInUnit() * factor, getUnit()); }
            public ElectricalResistance.Abs divideBy(final float divisor)  { return new ElectricalResistance.Abs(getInUnit() / divisor, getUnit()); }
            
            public ElectricalResistance.Abs plus(final ElectricalResistance.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new ElectricalResistance.Abs(this.si + v.si, ElectricalResistanceUnit.SI); } 

            public ElectricalResistance.Rel minus(final ElectricalResistance.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalResistance.Rel(this.si - v.si, ElectricalResistanceUnit.SI); } 

            public ElectricalResistance.Abs minus(final ElectricalResistance.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new ElectricalResistance.Abs(this.si - v.si, ElectricalResistanceUnit.SI); } 

            public ElectricalPotential.Abs multiplyBy(final ElectricalCurrent.Rel v) { 
                return new ElectricalPotential.Abs(this.si * v.si, ElectricalPotentialUnit.SI); }
            public Dimensionless.Abs divideBy(final ElectricalResistance.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /*************************************************** ENERGY *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Energy extends FloatScalar<EnergyUnit>
    {
        protected Energy(final EnergyUnit unit) { super(unit); }
        
        public static Energy.Abs interpolate(final Energy.Abs zero, final Energy.Abs one, final float ratio)
        { return new Energy.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Energy.Rel interpolate(final Energy.Rel zero, final Energy.Rel one, final float ratio)
        { return new Energy.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<EnergyUnit>
        {
            public Rel(final float value, final EnergyUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<EnergyUnit> value) { super(value); }
            
            public Energy.Rel abs()    { return new Energy.Rel(Math.abs(getInUnit()), getUnit()); }
            public Energy.Rel acos()   { return new Energy.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Energy.Rel asin()   { return new Energy.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Energy.Rel atan()   { return new Energy.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Energy.Rel cbrt()   { return new Energy.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Energy.Rel ceil()   { return new Energy.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Energy.Rel cos()    { return new Energy.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Energy.Rel cosh()   { return new Energy.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Energy.Rel exp()    { return new Energy.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Energy.Rel expm1()  { return new Energy.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Energy.Rel floor()  { return new Energy.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Energy.Rel log()    { return new Energy.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Energy.Rel log10()  { return new Energy.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Energy.Rel log1p()  { return new Energy.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Energy.Rel rint()   { return new Energy.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Energy.Rel round()  { return new Energy.Rel(Math.round(getInUnit()), getUnit()); }
            public Energy.Rel signum() { return new Energy.Rel(Math.signum(getInUnit()), getUnit()); }
            public Energy.Rel sin()    { return new Energy.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Energy.Rel sinh()   { return new Energy.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Energy.Rel sqrt()   { return new Energy.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Energy.Rel tan()    { return new Energy.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Energy.Rel tanh()   { return new Energy.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Energy.Rel inv()    { return new Energy.Rel(1.0f / getInUnit(), getUnit()); }
            public Energy.Rel toDegrees() { return new Energy.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Energy.Rel toRadians() { return new Energy.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Energy.Rel pow(final float x) { return new Energy.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Energy.Rel multiplyBy(final float factor) { return new Energy.Rel(getInUnit() * factor, getUnit()); }
            public Energy.Rel divideBy(final float divisor)  { return new Energy.Rel(getInUnit() / divisor, getUnit()); }
            
            public Energy.Rel plus(final Energy.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Energy.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Energy.Rel(this.si + v.si, EnergyUnit.SI); } 

            public Energy.Rel minus(final Energy.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Energy.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Energy.Rel(this.si - v.si, EnergyUnit.SI); } 

            public Energy.Abs plus(final Energy.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Energy.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Energy.Abs(this.si + v.si, EnergyUnit.SI); } 
            
            public Length.Rel divideBy(final Force.Rel v) { return new Length.Rel(this.si / v.si, LengthUnit.SI); }
            public Force.Rel divideBy(final Length.Rel v) { return new Force.Rel(this.si / v.si, ForceUnit.SI); }
            public Power.Rel divideBy(final Time.Rel v) { return new Power.Rel(this.si / v.si, PowerUnit.SI); }
            public Pressure.Rel divideBy(final Volume.Rel v) { return new Pressure.Rel(this.si / v.si, PressureUnit.SI); }
            public Dimensionless.Rel divideBy(final Energy.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
       }
        
        public static class Abs extends FloatScalar.Abs<EnergyUnit>
        {
            public Abs(final float value, final EnergyUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<EnergyUnit> value) { super(value); }
            public Energy.Abs abs()    { return new Energy.Abs(Math.abs(getInUnit()), getUnit()); }
            public Energy.Abs acos()   { return new Energy.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Energy.Abs asin()   { return new Energy.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Energy.Abs atan()   { return new Energy.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Energy.Abs cbrt()   { return new Energy.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Energy.Abs ceil()   { return new Energy.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Energy.Abs cos()    { return new Energy.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Energy.Abs cosh()   { return new Energy.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Energy.Abs exp()    { return new Energy.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Energy.Abs expm1()  { return new Energy.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Energy.Abs floor()  { return new Energy.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Energy.Abs log()    { return new Energy.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Energy.Abs log10()  { return new Energy.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Energy.Abs log1p()  { return new Energy.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Energy.Abs rint()   { return new Energy.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Energy.Abs round()  { return new Energy.Abs(Math.round(getInUnit()), getUnit()); }
            public Energy.Abs signum() { return new Energy.Abs(Math.signum(getInUnit()), getUnit()); }
            public Energy.Abs sin()    { return new Energy.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Energy.Abs sinh()   { return new Energy.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Energy.Abs sqrt()   { return new Energy.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Energy.Abs tan()    { return new Energy.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Energy.Abs tanh()   { return new Energy.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Energy.Abs inv()    { return new Energy.Abs(1.0f / getInUnit(), getUnit()); }
            public Energy.Abs toDegrees() { return new Energy.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Energy.Abs toRadians() { return new Energy.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Energy.Abs pow(final float x) { return new Energy.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Energy.Abs multiplyBy(final float factor) { return new Energy.Abs(getInUnit() * factor, getUnit()); }
            public Energy.Abs divideBy(final float divisor)  { return new Energy.Abs(getInUnit() / divisor, getUnit()); }
            
            public Energy.Abs plus(final Energy.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Energy.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Energy.Abs(this.si + v.si, EnergyUnit.SI); } 

            public Energy.Rel minus(final Energy.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Energy.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Energy.Rel(this.si - v.si, EnergyUnit.SI); } 

            public Energy.Abs minus(final Energy.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Energy.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Energy.Abs(this.si - v.si, EnergyUnit.SI); } 

            public Length.Abs divideBy(final Force.Abs v) { return new Length.Abs(this.si / v.si, LengthUnit.SI); }
            public Force.Abs divideBy(final Length.Abs v) { return new Force.Abs(this.si / v.si, ForceUnit.SI); }
            public Power.Abs divideBy(final Time.Abs v) { return new Power.Abs(this.si / v.si, PowerUnit.SI); }
            public Pressure.Abs divideBy(final Volume.Abs v) { return new Pressure.Abs(this.si / v.si, PressureUnit.SI); }
            public Dimensionless.Abs divideBy(final Energy.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** FLOW_MASS ***************************************************/ 
    /****************************************************************************************************************/

    abstract class FlowMass extends FloatScalar<FlowMassUnit>
    {
        protected FlowMass(final FlowMassUnit unit) { super(unit); }
        
        public static FlowMass.Abs interpolate(final FlowMass.Abs zero, final FlowMass.Abs one, final float ratio)
        { return new FlowMass.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static FlowMass.Rel interpolate(final FlowMass.Rel zero, final FlowMass.Rel one, final float ratio)
        { return new FlowMass.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<FlowMassUnit>
        {
            public Rel(final float value, final FlowMassUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<FlowMassUnit> value) { super(value); }
            
            public FlowMass.Rel abs()    { return new FlowMass.Rel(Math.abs(getInUnit()), getUnit()); }
            public FlowMass.Rel acos()   { return new FlowMass.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public FlowMass.Rel asin()   { return new FlowMass.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public FlowMass.Rel atan()   { return new FlowMass.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public FlowMass.Rel cbrt()   { return new FlowMass.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public FlowMass.Rel ceil()   { return new FlowMass.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public FlowMass.Rel cos()    { return new FlowMass.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public FlowMass.Rel cosh()   { return new FlowMass.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public FlowMass.Rel exp()    { return new FlowMass.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public FlowMass.Rel expm1()  { return new FlowMass.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public FlowMass.Rel floor()  { return new FlowMass.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public FlowMass.Rel log()    { return new FlowMass.Rel((float) Math.log(getInUnit()), getUnit()); }
            public FlowMass.Rel log10()  { return new FlowMass.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public FlowMass.Rel log1p()  { return new FlowMass.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public FlowMass.Rel rint()   { return new FlowMass.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public FlowMass.Rel round()  { return new FlowMass.Rel(Math.round(getInUnit()), getUnit()); }
            public FlowMass.Rel signum() { return new FlowMass.Rel(Math.signum(getInUnit()), getUnit()); }
            public FlowMass.Rel sin()    { return new FlowMass.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public FlowMass.Rel sinh()   { return new FlowMass.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public FlowMass.Rel sqrt()   { return new FlowMass.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public FlowMass.Rel tan()    { return new FlowMass.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public FlowMass.Rel tanh()   { return new FlowMass.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public FlowMass.Rel inv()    { return new FlowMass.Rel(1.0f / getInUnit(), getUnit()); }
            public FlowMass.Rel toDegrees() { return new FlowMass.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public FlowMass.Rel toRadians() { return new FlowMass.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public FlowMass.Rel pow(final float x) { return new FlowMass.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public FlowMass.Rel multiplyBy(final float factor) { return new FlowMass.Rel(getInUnit() * factor, getUnit()); }
            public FlowMass.Rel divideBy(final float divisor)  { return new FlowMass.Rel(getInUnit() / divisor, getUnit()); }
            
            public FlowMass.Rel plus(final FlowMass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowMass.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new FlowMass.Rel(this.si + v.si, FlowMassUnit.SI); } 

            public FlowMass.Rel minus(final FlowMass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowMass.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new FlowMass.Rel(this.si - v.si, FlowMassUnit.SI); } 

            public FlowMass.Abs plus(final FlowMass.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new FlowMass.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new FlowMass.Abs(this.si + v.si, FlowMassUnit.SI); } 
            
            public Mass.Rel multiplyBy(final Time.Rel v) { return new Mass.Rel(this.si * v.si, MassUnit.SI); }
            public Frequency.Rel multiplyBy(final Mass.Rel v) { return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI); }
            public Dimensionless.Rel divideBy(final FlowMass.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<FlowMassUnit>
        {
            public Abs(final float value, final FlowMassUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<FlowMassUnit> value) { super(value); }
            public FlowMass.Abs abs()    { return new FlowMass.Abs(Math.abs(getInUnit()), getUnit()); }
            public FlowMass.Abs acos()   { return new FlowMass.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public FlowMass.Abs asin()   { return new FlowMass.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public FlowMass.Abs atan()   { return new FlowMass.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public FlowMass.Abs cbrt()   { return new FlowMass.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public FlowMass.Abs ceil()   { return new FlowMass.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public FlowMass.Abs cos()    { return new FlowMass.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public FlowMass.Abs cosh()   { return new FlowMass.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public FlowMass.Abs exp()    { return new FlowMass.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public FlowMass.Abs expm1()  { return new FlowMass.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public FlowMass.Abs floor()  { return new FlowMass.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public FlowMass.Abs log()    { return new FlowMass.Abs((float) Math.log(getInUnit()), getUnit()); }
            public FlowMass.Abs log10()  { return new FlowMass.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public FlowMass.Abs log1p()  { return new FlowMass.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public FlowMass.Abs rint()   { return new FlowMass.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public FlowMass.Abs round()  { return new FlowMass.Abs(Math.round(getInUnit()), getUnit()); }
            public FlowMass.Abs signum() { return new FlowMass.Abs(Math.signum(getInUnit()), getUnit()); }
            public FlowMass.Abs sin()    { return new FlowMass.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public FlowMass.Abs sinh()   { return new FlowMass.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public FlowMass.Abs sqrt()   { return new FlowMass.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public FlowMass.Abs tan()    { return new FlowMass.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public FlowMass.Abs tanh()   { return new FlowMass.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public FlowMass.Abs inv()    { return new FlowMass.Abs(1.0f / getInUnit(), getUnit()); }
            public FlowMass.Abs toDegrees() { return new FlowMass.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public FlowMass.Abs toRadians() { return new FlowMass.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public FlowMass.Abs pow(final float x) { return new FlowMass.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public FlowMass.Abs multiplyBy(final float factor) { return new FlowMass.Abs(getInUnit() * factor, getUnit()); }
            public FlowMass.Abs divideBy(final float divisor)  { return new FlowMass.Abs(getInUnit() / divisor, getUnit()); }
            
            public FlowMass.Abs plus(final FlowMass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowMass.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new FlowMass.Abs(this.si + v.si, FlowMassUnit.SI); } 

            public FlowMass.Rel minus(final FlowMass.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new FlowMass.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new FlowMass.Rel(this.si - v.si, FlowMassUnit.SI); } 

            public FlowMass.Abs minus(final FlowMass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowMass.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new FlowMass.Abs(this.si - v.si, FlowMassUnit.SI); } 

            public Mass.Abs multiplyBy(final Time.Abs v) { return new Mass.Abs(this.si * v.si, MassUnit.SI); }
            public Frequency.Abs multiplyBy(final Mass.Abs v) { return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI); }
            public Dimensionless.Abs divideBy(final FlowMass.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************* FLOW_VOLUME **************************************************/ 
    /****************************************************************************************************************/

    abstract class FlowVolume extends FloatScalar<FlowVolumeUnit>
    {
        protected FlowVolume(final FlowVolumeUnit unit) { super(unit); }
        
        public static FlowVolume.Abs interpolate(final FlowVolume.Abs zero, final FlowVolume.Abs one, final float ratio)
        { return new FlowVolume.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static FlowVolume.Rel interpolate(final FlowVolume.Rel zero, final FlowVolume.Rel one, final float ratio)
        { return new FlowVolume.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<FlowVolumeUnit>
        {
            public Rel(final float value, final FlowVolumeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<FlowVolumeUnit> value) { super(value); }
            
            public FlowVolume.Rel abs()    { return new FlowVolume.Rel(Math.abs(getInUnit()), getUnit()); }
            public FlowVolume.Rel acos()   { return new FlowVolume.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public FlowVolume.Rel asin()   { return new FlowVolume.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public FlowVolume.Rel atan()   { return new FlowVolume.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public FlowVolume.Rel cbrt()   { return new FlowVolume.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public FlowVolume.Rel ceil()   { return new FlowVolume.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public FlowVolume.Rel cos()    { return new FlowVolume.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public FlowVolume.Rel cosh()   { return new FlowVolume.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public FlowVolume.Rel exp()    { return new FlowVolume.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public FlowVolume.Rel expm1()  { return new FlowVolume.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public FlowVolume.Rel floor()  { return new FlowVolume.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public FlowVolume.Rel log()    { return new FlowVolume.Rel((float) Math.log(getInUnit()), getUnit()); }
            public FlowVolume.Rel log10()  { return new FlowVolume.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public FlowVolume.Rel log1p()  { return new FlowVolume.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public FlowVolume.Rel rint()   { return new FlowVolume.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public FlowVolume.Rel round()  { return new FlowVolume.Rel(Math.round(getInUnit()), getUnit()); }
            public FlowVolume.Rel signum() { return new FlowVolume.Rel(Math.signum(getInUnit()), getUnit()); }
            public FlowVolume.Rel sin()    { return new FlowVolume.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public FlowVolume.Rel sinh()   { return new FlowVolume.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public FlowVolume.Rel sqrt()   { return new FlowVolume.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public FlowVolume.Rel tan()    { return new FlowVolume.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public FlowVolume.Rel tanh()   { return new FlowVolume.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public FlowVolume.Rel inv()    { return new FlowVolume.Rel(1.0f / getInUnit(), getUnit()); }
            public FlowVolume.Rel toDegrees() { return new FlowVolume.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public FlowVolume.Rel toRadians() { return new FlowVolume.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public FlowVolume.Rel pow(final float x) { return new FlowVolume.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public FlowVolume.Rel multiplyBy(final float factor) { return new FlowVolume.Rel(getInUnit() * factor, getUnit()); }
            public FlowVolume.Rel divideBy(final float divisor)  { return new FlowVolume.Rel(getInUnit() / divisor, getUnit()); }
            
            public FlowVolume.Rel plus(final FlowVolume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowVolume.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new FlowVolume.Rel(this.si + v.si, FlowVolumeUnit.SI); } 

            public FlowVolume.Rel minus(final FlowVolume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowVolume.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new FlowVolume.Rel(this.si - v.si, FlowVolumeUnit.SI); } 

            public FlowVolume.Abs plus(final FlowVolume.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new FlowVolume.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new FlowVolume.Abs(this.si + v.si, FlowVolumeUnit.SI); } 
            
            public Volume.Rel multiplyBy(final Time.Rel v) { return new Volume.Rel(this.si * v.si, VolumeUnit.SI); }
            public Frequency.Rel multiplyBy(final Mass.Rel v) { return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI); }
            public Dimensionless.Rel divideBy(final FlowVolume.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<FlowVolumeUnit>
        {
            public Abs(final float value, final FlowVolumeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<FlowVolumeUnit> value) { super(value); }
            public FlowVolume.Abs abs()    { return new FlowVolume.Abs(Math.abs(getInUnit()), getUnit()); }
            public FlowVolume.Abs acos()   { return new FlowVolume.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public FlowVolume.Abs asin()   { return new FlowVolume.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public FlowVolume.Abs atan()   { return new FlowVolume.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public FlowVolume.Abs cbrt()   { return new FlowVolume.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public FlowVolume.Abs ceil()   { return new FlowVolume.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public FlowVolume.Abs cos()    { return new FlowVolume.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public FlowVolume.Abs cosh()   { return new FlowVolume.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public FlowVolume.Abs exp()    { return new FlowVolume.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public FlowVolume.Abs expm1()  { return new FlowVolume.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public FlowVolume.Abs floor()  { return new FlowVolume.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public FlowVolume.Abs log()    { return new FlowVolume.Abs((float) Math.log(getInUnit()), getUnit()); }
            public FlowVolume.Abs log10()  { return new FlowVolume.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public FlowVolume.Abs log1p()  { return new FlowVolume.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public FlowVolume.Abs rint()   { return new FlowVolume.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public FlowVolume.Abs round()  { return new FlowVolume.Abs(Math.round(getInUnit()), getUnit()); }
            public FlowVolume.Abs signum() { return new FlowVolume.Abs(Math.signum(getInUnit()), getUnit()); }
            public FlowVolume.Abs sin()    { return new FlowVolume.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public FlowVolume.Abs sinh()   { return new FlowVolume.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public FlowVolume.Abs sqrt()   { return new FlowVolume.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public FlowVolume.Abs tan()    { return new FlowVolume.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public FlowVolume.Abs tanh()   { return new FlowVolume.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public FlowVolume.Abs inv()    { return new FlowVolume.Abs(1.0f / getInUnit(), getUnit()); }
            public FlowVolume.Abs toDegrees() { return new FlowVolume.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public FlowVolume.Abs toRadians() { return new FlowVolume.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public FlowVolume.Abs pow(final float x) { return new FlowVolume.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public FlowVolume.Abs multiplyBy(final float factor) { return new FlowVolume.Abs(getInUnit() * factor, getUnit()); }
            public FlowVolume.Abs divideBy(final float divisor)  { return new FlowVolume.Abs(getInUnit() / divisor, getUnit()); }
            
            public FlowVolume.Abs plus(final FlowVolume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowVolume.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new FlowVolume.Abs(this.si + v.si, FlowVolumeUnit.SI); } 

            public FlowVolume.Rel minus(final FlowVolume.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new FlowVolume.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new FlowVolume.Rel(this.si - v.si, FlowVolumeUnit.SI); } 

            public FlowVolume.Abs minus(final FlowVolume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new FlowVolume.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new FlowVolume.Abs(this.si - v.si, FlowVolumeUnit.SI); } 

            public Volume.Abs multiplyBy(final Time.Abs v) { return new Volume.Abs(this.si * v.si, VolumeUnit.SI); }
            public Frequency.Abs multiplyBy(final Mass.Abs v) { return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI); }
            public Dimensionless.Abs divideBy(final FlowVolume.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /**************************************************** FORCE *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Force extends FloatScalar<ForceUnit>
    {
        protected Force(final ForceUnit unit) { super(unit); }
        
        public static Force.Abs interpolate(final Force.Abs zero, final Force.Abs one, final float ratio)
        { return new Force.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Force.Rel interpolate(final Force.Rel zero, final Force.Rel one, final float ratio)
        { return new Force.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<ForceUnit>
        {
            public Rel(final float value, final ForceUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<ForceUnit> value) { super(value); }
            
            public Force.Rel abs()    { return new Force.Rel(Math.abs(getInUnit()), getUnit()); }
            public Force.Rel acos()   { return new Force.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Force.Rel asin()   { return new Force.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Force.Rel atan()   { return new Force.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Force.Rel cbrt()   { return new Force.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Force.Rel ceil()   { return new Force.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Force.Rel cos()    { return new Force.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Force.Rel cosh()   { return new Force.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Force.Rel exp()    { return new Force.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Force.Rel expm1()  { return new Force.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Force.Rel floor()  { return new Force.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Force.Rel log()    { return new Force.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Force.Rel log10()  { return new Force.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Force.Rel log1p()  { return new Force.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Force.Rel rint()   { return new Force.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Force.Rel round()  { return new Force.Rel(Math.round(getInUnit()), getUnit()); }
            public Force.Rel signum() { return new Force.Rel(Math.signum(getInUnit()), getUnit()); }
            public Force.Rel sin()    { return new Force.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Force.Rel sinh()   { return new Force.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Force.Rel sqrt()   { return new Force.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Force.Rel tan()    { return new Force.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Force.Rel tanh()   { return new Force.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Force.Rel inv()    { return new Force.Rel(1.0f / getInUnit(), getUnit()); }
            public Force.Rel toDegrees() { return new Force.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Force.Rel toRadians() { return new Force.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Force.Rel pow(final float x) { return new Force.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Force.Rel multiplyBy(final float factor) { return new Force.Rel(getInUnit() * factor, getUnit()); }
            public Force.Rel divideBy(final float divisor)  { return new Force.Rel(getInUnit() / divisor, getUnit()); }
            
            public Force.Rel plus(final Force.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Force.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Force.Rel(this.si + v.si, ForceUnit.SI); } 

            public Force.Rel minus(final Force.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Force.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Force.Rel(this.si - v.si, ForceUnit.SI); } 

            public Force.Abs plus(final Force.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Force.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Force.Abs(this.si + v.si, ForceUnit.SI); } 
            
            public Energy.Rel multiplyBy(final Length.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public Power.Rel multiplyBy(final Speed.Rel v) { return new Power.Rel(this.si * v.si, PowerUnit.SI); }
            public Acceleration.Rel divideBy(final Mass.Rel v) { return new Acceleration.Rel(this.si / v.si, AccelerationUnit.SI); }
            public Mass.Rel divideBy(final Acceleration.Rel v) { return new Mass.Rel(this.si / v.si, MassUnit.SI); }
            public Pressure.Rel divideBy(final Area.Rel v) { return new Pressure.Rel(this.si / v.si, PressureUnit.SI); }
            public Dimensionless.Rel divideBy(final Force.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<ForceUnit>
        {
            public Abs(final float value, final ForceUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<ForceUnit> value) { super(value); }
            public Force.Abs abs()    { return new Force.Abs(Math.abs(getInUnit()), getUnit()); }
            public Force.Abs acos()   { return new Force.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Force.Abs asin()   { return new Force.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Force.Abs atan()   { return new Force.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Force.Abs cbrt()   { return new Force.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Force.Abs ceil()   { return new Force.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Force.Abs cos()    { return new Force.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Force.Abs cosh()   { return new Force.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Force.Abs exp()    { return new Force.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Force.Abs expm1()  { return new Force.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Force.Abs floor()  { return new Force.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Force.Abs log()    { return new Force.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Force.Abs log10()  { return new Force.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Force.Abs log1p()  { return new Force.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Force.Abs rint()   { return new Force.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Force.Abs round()  { return new Force.Abs(Math.round(getInUnit()), getUnit()); }
            public Force.Abs signum() { return new Force.Abs(Math.signum(getInUnit()), getUnit()); }
            public Force.Abs sin()    { return new Force.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Force.Abs sinh()   { return new Force.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Force.Abs sqrt()   { return new Force.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Force.Abs tan()    { return new Force.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Force.Abs tanh()   { return new Force.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Force.Abs inv()    { return new Force.Abs(1.0f / getInUnit(), getUnit()); }
            public Force.Abs toDegrees() { return new Force.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Force.Abs toRadians() { return new Force.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Force.Abs pow(final float x) { return new Force.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Force.Abs multiplyBy(final float factor) { return new Force.Abs(getInUnit() * factor, getUnit()); }
            public Force.Abs divideBy(final float divisor)  { return new Force.Abs(getInUnit() / divisor, getUnit()); }
            
            public Force.Abs plus(final Force.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Force.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Force.Abs(this.si + v.si, ForceUnit.SI); } 

            public Force.Rel minus(final Force.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Force.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Force.Rel(this.si - v.si, ForceUnit.SI); } 

            public Force.Abs minus(final Force.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Force.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Force.Abs(this.si - v.si, ForceUnit.SI); } 

            public Energy.Abs multiplyBy(final Length.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public Power.Abs multiplyBy(final Speed.Abs v) { return new Power.Abs(this.si * v.si, PowerUnit.SI); }
            public Acceleration.Abs divideBy(final Mass.Abs v) { return new Acceleration.Abs(this.si / v.si, AccelerationUnit.SI); }
            public Mass.Abs divideBy(final Acceleration.Abs v) { return new Mass.Abs(this.si / v.si, MassUnit.SI); }
            public Pressure.Abs divideBy(final Area.Abs v) { return new Pressure.Abs(this.si / v.si, PressureUnit.SI); }
            public Dimensionless.Abs divideBy(final Force.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** FREQUENCY ***************************************************/ 
    /****************************************************************************************************************/

    abstract class Frequency extends FloatScalar<FrequencyUnit>
    {
        protected Frequency(final FrequencyUnit unit) { super(unit); }
        
        public static Frequency.Abs interpolate(final Frequency.Abs zero, final Frequency.Abs one, final float ratio)
        { return new Frequency.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Frequency.Rel interpolate(final Frequency.Rel zero, final Frequency.Rel one, final float ratio)
        { return new Frequency.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<FrequencyUnit>
        {
            public Rel(final float value, final FrequencyUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<FrequencyUnit> value) { super(value); }
            
            public Frequency.Rel abs()    { return new Frequency.Rel(Math.abs(getInUnit()), getUnit()); }
            public Frequency.Rel acos()   { return new Frequency.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Frequency.Rel asin()   { return new Frequency.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Frequency.Rel atan()   { return new Frequency.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Frequency.Rel cbrt()   { return new Frequency.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Frequency.Rel ceil()   { return new Frequency.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Frequency.Rel cos()    { return new Frequency.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Frequency.Rel cosh()   { return new Frequency.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Frequency.Rel exp()    { return new Frequency.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Frequency.Rel expm1()  { return new Frequency.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Frequency.Rel floor()  { return new Frequency.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Frequency.Rel log()    { return new Frequency.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Frequency.Rel log10()  { return new Frequency.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Frequency.Rel log1p()  { return new Frequency.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Frequency.Rel rint()   { return new Frequency.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Frequency.Rel round()  { return new Frequency.Rel(Math.round(getInUnit()), getUnit()); }
            public Frequency.Rel signum() { return new Frequency.Rel(Math.signum(getInUnit()), getUnit()); }
            public Frequency.Rel sin()    { return new Frequency.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Frequency.Rel sinh()   { return new Frequency.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Frequency.Rel sqrt()   { return new Frequency.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Frequency.Rel tan()    { return new Frequency.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Frequency.Rel tanh()   { return new Frequency.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Frequency.Rel inv()    { return new Frequency.Rel(1.0f / getInUnit(), getUnit()); }
            public Frequency.Rel toDegrees() { return new Frequency.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Frequency.Rel toRadians() { return new Frequency.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Frequency.Rel pow(final float x) { return new Frequency.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Frequency.Rel multiplyBy(final float factor) { return new Frequency.Rel(getInUnit() * factor, getUnit()); }
            public Frequency.Rel divideBy(final float divisor)  { return new Frequency.Rel(getInUnit() / divisor, getUnit()); }
            
            public Frequency.Rel plus(final Frequency.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Frequency.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Frequency.Rel(this.si + v.si, FrequencyUnit.SI); } 

            public Frequency.Rel minus(final Frequency.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Frequency.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Frequency.Rel(this.si - v.si, FrequencyUnit.SI); } 

            public Frequency.Abs plus(final Frequency.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Frequency.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Frequency.Abs(this.si + v.si, FrequencyUnit.SI); } 
            
            public Dimensionless.Rel multiplyBy(final Time.Rel v) { return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI); }
            public Speed.Rel multiplyBy(final Length.Rel v) { return new Speed.Rel(this.si * v.si, SpeedUnit.SI); }
            public Acceleration.Rel multiplyBy(final Speed.Rel v) { return new Acceleration.Rel(this.si * v.si, AccelerationUnit.SI); }
            public Power.Rel multiplyBy(final Energy.Rel v) { return new Power.Rel(this.si * v.si, PowerUnit.SI); }
            public FlowMass.Rel multiplyBy(final Mass.Rel v) { return new FlowMass.Rel(this.si * v.si, FlowMassUnit.SI); }
            public FlowVolume.Rel multiplyBy(final Volume.Rel v) { return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI); }
            public ElectricalCurrent.Rel multiplyBy(final ElectricalCharge.Rel v) { 
                return new ElectricalCurrent.Rel(this.si * v.si, ElectricalCurrentUnit.SI); }
            public Dimensionless.Rel divideBy(final Frequency.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<FrequencyUnit>
        {
            public Abs(final float value, final FrequencyUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<FrequencyUnit> value) { super(value); }
            public Frequency.Abs abs()    { return new Frequency.Abs(Math.abs(getInUnit()), getUnit()); }
            public Frequency.Abs acos()   { return new Frequency.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Frequency.Abs asin()   { return new Frequency.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Frequency.Abs atan()   { return new Frequency.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Frequency.Abs cbrt()   { return new Frequency.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Frequency.Abs ceil()   { return new Frequency.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Frequency.Abs cos()    { return new Frequency.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Frequency.Abs cosh()   { return new Frequency.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Frequency.Abs exp()    { return new Frequency.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Frequency.Abs expm1()  { return new Frequency.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Frequency.Abs floor()  { return new Frequency.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Frequency.Abs log()    { return new Frequency.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Frequency.Abs log10()  { return new Frequency.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Frequency.Abs log1p()  { return new Frequency.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Frequency.Abs rint()   { return new Frequency.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Frequency.Abs round()  { return new Frequency.Abs(Math.round(getInUnit()), getUnit()); }
            public Frequency.Abs signum() { return new Frequency.Abs(Math.signum(getInUnit()), getUnit()); }
            public Frequency.Abs sin()    { return new Frequency.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Frequency.Abs sinh()   { return new Frequency.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Frequency.Abs sqrt()   { return new Frequency.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Frequency.Abs tan()    { return new Frequency.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Frequency.Abs tanh()   { return new Frequency.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Frequency.Abs inv()    { return new Frequency.Abs(1.0f / getInUnit(), getUnit()); }
            public Frequency.Abs toDegrees() { return new Frequency.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Frequency.Abs toRadians() { return new Frequency.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Frequency.Abs pow(final float x) { return new Frequency.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Frequency.Abs multiplyBy(final float factor) { return new Frequency.Abs(getInUnit() * factor, getUnit()); }
            public Frequency.Abs divideBy(final float divisor)  { return new Frequency.Abs(getInUnit() / divisor, getUnit()); }
            
            public Frequency.Abs plus(final Frequency.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Frequency.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Frequency.Abs(this.si + v.si, FrequencyUnit.SI); } 

            public Frequency.Rel minus(final Frequency.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Frequency.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Frequency.Rel(this.si - v.si, FrequencyUnit.SI); } 

            public Frequency.Abs minus(final Frequency.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Frequency.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Frequency.Abs(this.si - v.si, FrequencyUnit.SI); } 

            public Dimensionless.Abs multiplyBy(final Time.Abs v) { return new Dimensionless.Abs(this.si * v.si, DimensionlessUnit.SI); }
            public Speed.Abs multiplyBy(final Length.Abs v) { return new Speed.Abs(this.si * v.si, SpeedUnit.SI); }
            public Acceleration.Abs multiplyBy(final Speed.Abs v) { return new Acceleration.Abs(this.si * v.si, AccelerationUnit.SI); }
            public Power.Abs multiplyBy(final Energy.Abs v) { return new Power.Abs(this.si * v.si, PowerUnit.SI); }
            public FlowMass.Abs multiplyBy(final Mass.Abs v) { return new FlowMass.Abs(this.si * v.si, FlowMassUnit.SI); }
            public FlowVolume.Abs multiplyBy(final Volume.Abs v) { return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI); }
            public ElectricalCurrent.Abs multiplyBy(final ElectricalCharge.Abs v) { 
                return new ElectricalCurrent.Abs(this.si * v.si, ElectricalCurrentUnit.SI); }
            public Dimensionless.Abs divideBy(final Frequency.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /**************************************************** LENGTH ****************************************************/ 
    /****************************************************************************************************************/

    abstract class Length extends FloatScalar<LengthUnit>
    {
        protected Length(final LengthUnit unit) { super(unit); }
        
        public static Length.Abs interpolate(final Length.Abs zero, final Length.Abs one, final float ratio)
        { return new Length.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Length.Rel interpolate(final Length.Rel zero, final Length.Rel one, final float ratio)
        { return new Length.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<LengthUnit>
        {
            public Rel(final float value, final LengthUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<LengthUnit> value) { super(value); }
            
            public Length.Rel abs()    { return new Length.Rel(Math.abs(getInUnit()), getUnit()); }
            public Length.Rel acos()   { return new Length.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Length.Rel asin()   { return new Length.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Length.Rel atan()   { return new Length.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Length.Rel cbrt()   { return new Length.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Length.Rel ceil()   { return new Length.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Length.Rel cos()    { return new Length.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Length.Rel cosh()   { return new Length.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Length.Rel exp()    { return new Length.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Length.Rel expm1()  { return new Length.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Length.Rel floor()  { return new Length.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Length.Rel log()    { return new Length.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Length.Rel log10()  { return new Length.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Length.Rel log1p()  { return new Length.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Length.Rel rint()   { return new Length.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Length.Rel round()  { return new Length.Rel(Math.round(getInUnit()), getUnit()); }
            public Length.Rel signum() { return new Length.Rel(Math.signum(getInUnit()), getUnit()); }
            public Length.Rel sin()    { return new Length.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Length.Rel sinh()   { return new Length.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Length.Rel sqrt()   { return new Length.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Length.Rel tan()    { return new Length.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Length.Rel tanh()   { return new Length.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Length.Rel inv()    { return new Length.Rel(1.0f / getInUnit(), getUnit()); }
            public Length.Rel toDegrees() { return new Length.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Length.Rel toRadians() { return new Length.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Length.Rel pow(final float x) { return new Length.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Length.Rel multiplyBy(final float factor) { return new Length.Rel(getInUnit() * factor, getUnit()); }
            public Length.Rel divideBy(final float divisor)  { return new Length.Rel(getInUnit() / divisor, getUnit()); }
            
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
            public Volume.Rel multiplyBy(final Area.Rel v) { return new Volume.Rel(this.si * v.si, VolumeUnit.SI); }
            public Speed.Rel divideBy(final Time.Rel v) { return new Speed.Rel(this.si / v.si, SpeedUnit.SI); }
            public Speed.Rel multiplyBy(final Frequency.Rel v) { return new Speed.Rel(this.si * v.si, SpeedUnit.SI); }
            public Energy.Rel multiplyBy(final Force.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public Dimensionless.Rel divideBy(final Length.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<LengthUnit>
        {
            public Abs(final float value, final LengthUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<LengthUnit> value) { super(value); }
            
            public Length.Abs abs()    { return new Length.Abs(Math.abs(getInUnit()), getUnit()); }
            public Length.Abs acos()   { return new Length.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Length.Abs asin()   { return new Length.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Length.Abs atan()   { return new Length.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Length.Abs cbrt()   { return new Length.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Length.Abs ceil()   { return new Length.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Length.Abs cos()    { return new Length.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Length.Abs cosh()   { return new Length.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Length.Abs exp()    { return new Length.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Length.Abs expm1()  { return new Length.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Length.Abs floor()  { return new Length.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Length.Abs log()    { return new Length.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Length.Abs log10()  { return new Length.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Length.Abs log1p()  { return new Length.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Length.Abs rint()   { return new Length.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Length.Abs round()  { return new Length.Abs(Math.round(getInUnit()), getUnit()); }
            public Length.Abs signum() { return new Length.Abs(Math.signum(getInUnit()), getUnit()); }
            public Length.Abs sin()    { return new Length.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Length.Abs sinh()   { return new Length.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Length.Abs sqrt()   { return new Length.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Length.Abs tan()    { return new Length.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Length.Abs tanh()   { return new Length.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Length.Abs inv()    { return new Length.Abs(1.0f / getInUnit(), getUnit()); }
            public Length.Abs toDegrees() { return new Length.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Length.Abs toRadians() { return new Length.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Length.Abs pow(final float x) { return new Length.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Length.Abs multiplyBy(final float factor) { return new Length.Abs(getInUnit() * factor, getUnit()); }
            public Length.Abs divideBy(final float divisor)  { return new Length.Abs(getInUnit() / divisor, getUnit()); }
            
            public Length.Abs plus(final Length.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Length.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Length.Abs(this.si + v.si, LengthUnit.SI); } 

            public Length.Rel minus(final Length.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Length.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Length.Rel(this.si - v.si, LengthUnit.SI); } 

            public Length.Abs minus(final Length.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Length.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Length.Abs(this.si - v.si, LengthUnit.SI); } 

            public Area.Abs multiplyBy(final Length.Abs v) { return new Area.Abs(this.si * v.si, AreaUnit.SI); }
            public Volume.Abs multiplyBy(final Area.Abs v) { return new Volume.Abs(this.si * v.si, VolumeUnit.SI); }
            public Speed.Abs divideBy(final Time.Abs v) { return new Speed.Abs(this.si / v.si, SpeedUnit.SI); }
            public Speed.Abs multiplyBy(final Frequency.Abs v) { return new Speed.Abs(this.si * v.si, SpeedUnit.SI); }
            public Energy.Abs multiplyBy(final Force.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public Dimensionless.Abs divideBy(final Length.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************ LINEAR_DENSITY ************************************************/ 
    /****************************************************************************************************************/

    abstract class LinearDensity extends FloatScalar<LinearDensityUnit>
    {
        protected LinearDensity(final LinearDensityUnit unit) { super(unit); }
        
        public static LinearDensity.Abs interpolate(final LinearDensity.Abs zero, final LinearDensity.Abs one, final float ratio)
        { return new LinearDensity.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static LinearDensity.Rel interpolate(final LinearDensity.Rel zero, final LinearDensity.Rel one, final float ratio)
        { return new LinearDensity.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<LinearDensityUnit>
        {
            public Rel(final float value, final LinearDensityUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<LinearDensityUnit> value) { super(value); }
            
            public LinearDensity.Rel abs()    { return new LinearDensity.Rel(Math.abs(getInUnit()), getUnit()); }
            public LinearDensity.Rel acos()   { return new LinearDensity.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public LinearDensity.Rel asin()   { return new LinearDensity.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public LinearDensity.Rel atan()   { return new LinearDensity.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public LinearDensity.Rel cbrt()   { return new LinearDensity.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public LinearDensity.Rel ceil()   { return new LinearDensity.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public LinearDensity.Rel cos()    { return new LinearDensity.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public LinearDensity.Rel cosh()   { return new LinearDensity.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public LinearDensity.Rel exp()    { return new LinearDensity.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public LinearDensity.Rel expm1()  { return new LinearDensity.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public LinearDensity.Rel floor()  { return new LinearDensity.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public LinearDensity.Rel log()    { return new LinearDensity.Rel((float) Math.log(getInUnit()), getUnit()); }
            public LinearDensity.Rel log10()  { return new LinearDensity.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public LinearDensity.Rel log1p()  { return new LinearDensity.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public LinearDensity.Rel rint()   { return new LinearDensity.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public LinearDensity.Rel round()  { return new LinearDensity.Rel(Math.round(getInUnit()), getUnit()); }
            public LinearDensity.Rel signum() { return new LinearDensity.Rel(Math.signum(getInUnit()), getUnit()); }
            public LinearDensity.Rel sin()    { return new LinearDensity.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public LinearDensity.Rel sinh()   { return new LinearDensity.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public LinearDensity.Rel sqrt()   { return new LinearDensity.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public LinearDensity.Rel tan()    { return new LinearDensity.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public LinearDensity.Rel tanh()   { return new LinearDensity.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public LinearDensity.Rel inv()    { return new LinearDensity.Rel(1.0f / getInUnit(), getUnit()); }
            public LinearDensity.Rel toDegrees() { return new LinearDensity.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public LinearDensity.Rel toRadians() { return new LinearDensity.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public LinearDensity.Rel pow(final float x) { return new LinearDensity.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public LinearDensity.Rel multiplyBy(final float factor) { return new LinearDensity.Rel(getInUnit() * factor, getUnit()); }
            public LinearDensity.Rel divideBy(final float divisor)  { return new LinearDensity.Rel(getInUnit() / divisor, getUnit()); }
            
            public LinearDensity.Rel plus(final LinearDensity.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new LinearDensity.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new LinearDensity.Rel(this.si + v.si, LinearDensityUnit.SI); } 

            public LinearDensity.Rel minus(final LinearDensity.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new LinearDensity.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new LinearDensity.Rel(this.si - v.si, LinearDensityUnit.SI); } 

            public LinearDensity.Abs plus(final LinearDensity.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new LinearDensity.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new LinearDensity.Abs(this.si + v.si, LinearDensityUnit.SI); } 
            
            public Force.Rel multiplyBy(final Energy.Rel v) { return new Force.Rel(this.si * v.si, ForceUnit.SI); }
            public Frequency.Rel multiplyBy(final Speed.Rel v) { return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI); }
            public Dimensionless.Rel divideBy(final LinearDensity.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<LinearDensityUnit>
        {
            public Abs(final float value, final LinearDensityUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<LinearDensityUnit> value) { super(value); }
            public LinearDensity.Abs abs()    { return new LinearDensity.Abs(Math.abs(getInUnit()), getUnit()); }
            public LinearDensity.Abs acos()   { return new LinearDensity.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public LinearDensity.Abs asin()   { return new LinearDensity.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public LinearDensity.Abs atan()   { return new LinearDensity.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public LinearDensity.Abs cbrt()   { return new LinearDensity.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public LinearDensity.Abs ceil()   { return new LinearDensity.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public LinearDensity.Abs cos()    { return new LinearDensity.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public LinearDensity.Abs cosh()   { return new LinearDensity.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public LinearDensity.Abs exp()    { return new LinearDensity.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public LinearDensity.Abs expm1()  { return new LinearDensity.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public LinearDensity.Abs floor()  { return new LinearDensity.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public LinearDensity.Abs log()    { return new LinearDensity.Abs((float) Math.log(getInUnit()), getUnit()); }
            public LinearDensity.Abs log10()  { return new LinearDensity.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public LinearDensity.Abs log1p()  { return new LinearDensity.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public LinearDensity.Abs rint()   { return new LinearDensity.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public LinearDensity.Abs round()  { return new LinearDensity.Abs(Math.round(getInUnit()), getUnit()); }
            public LinearDensity.Abs signum() { return new LinearDensity.Abs(Math.signum(getInUnit()), getUnit()); }
            public LinearDensity.Abs sin()    { return new LinearDensity.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public LinearDensity.Abs sinh()   { return new LinearDensity.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public LinearDensity.Abs sqrt()   { return new LinearDensity.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public LinearDensity.Abs tan()    { return new LinearDensity.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public LinearDensity.Abs tanh()   { return new LinearDensity.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public LinearDensity.Abs inv()    { return new LinearDensity.Abs(1.0f / getInUnit(), getUnit()); }
            public LinearDensity.Abs toDegrees() { return new LinearDensity.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public LinearDensity.Abs toRadians() { return new LinearDensity.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public LinearDensity.Abs pow(final float x) { return new LinearDensity.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public LinearDensity.Abs multiplyBy(final float factor) { return new LinearDensity.Abs(getInUnit() * factor, getUnit()); }
            public LinearDensity.Abs divideBy(final float divisor)  { return new LinearDensity.Abs(getInUnit() / divisor, getUnit()); }
            
            public LinearDensity.Abs plus(final LinearDensity.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new LinearDensity.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new LinearDensity.Abs(this.si + v.si, LinearDensityUnit.SI); } 

            public LinearDensity.Rel minus(final LinearDensity.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new LinearDensity.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new LinearDensity.Rel(this.si - v.si, LinearDensityUnit.SI); } 

            public LinearDensity.Abs minus(final LinearDensity.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new LinearDensity.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new LinearDensity.Abs(this.si - v.si, LinearDensityUnit.SI); } 

            public Force.Abs multiplyBy(final Energy.Abs v) { return new Force.Abs(this.si * v.si, ForceUnit.SI); }
            public Frequency.Abs multiplyBy(final Speed.Abs v) { return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI); }
            public Dimensionless.Abs divideBy(final LinearDensity.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /***************************************************** MASS *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Mass extends FloatScalar<MassUnit>
    {
        protected Mass(final MassUnit unit) { super(unit); }
        
        public static Mass.Abs interpolate(final Mass.Abs zero, final Mass.Abs one, final float ratio)
        { return new Mass.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Mass.Rel interpolate(final Mass.Rel zero, final Mass.Rel one, final float ratio)
        { return new Mass.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<MassUnit>
        {
            public Rel(final float value, final MassUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<MassUnit> value) { super(value); }
            
            public Mass.Rel abs()    { return new Mass.Rel(Math.abs(getInUnit()), getUnit()); }
            public Mass.Rel acos()   { return new Mass.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Mass.Rel asin()   { return new Mass.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Mass.Rel atan()   { return new Mass.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Mass.Rel cbrt()   { return new Mass.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Mass.Rel ceil()   { return new Mass.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Mass.Rel cos()    { return new Mass.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Mass.Rel cosh()   { return new Mass.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Mass.Rel exp()    { return new Mass.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Mass.Rel expm1()  { return new Mass.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Mass.Rel floor()  { return new Mass.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Mass.Rel log()    { return new Mass.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Mass.Rel log10()  { return new Mass.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Mass.Rel log1p()  { return new Mass.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Mass.Rel rint()   { return new Mass.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Mass.Rel round()  { return new Mass.Rel(Math.round(getInUnit()), getUnit()); }
            public Mass.Rel signum() { return new Mass.Rel(Math.signum(getInUnit()), getUnit()); }
            public Mass.Rel sin()    { return new Mass.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Mass.Rel sinh()   { return new Mass.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Mass.Rel sqrt()   { return new Mass.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Mass.Rel tan()    { return new Mass.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Mass.Rel tanh()   { return new Mass.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Mass.Rel inv()    { return new Mass.Rel(1.0f / getInUnit(), getUnit()); }
            public Mass.Rel toDegrees() { return new Mass.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Mass.Rel toRadians() { return new Mass.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Mass.Rel pow(final float x) { return new Mass.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Mass.Rel multiplyBy(final float factor) { return new Mass.Rel(getInUnit() * factor, getUnit()); }
            public Mass.Rel divideBy(final float divisor)  { return new Mass.Rel(getInUnit() / divisor, getUnit()); }
            
            public Mass.Rel plus(final Mass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Mass.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Mass.Rel(this.si + v.si, MassUnit.SI); } 

            public Mass.Rel minus(final Mass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Mass.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Mass.Rel(this.si - v.si, MassUnit.SI); } 

            public Mass.Abs plus(final Mass.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Mass.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Mass.Abs(this.si + v.si, MassUnit.SI); } 
            
            public Force.Rel multiplyBy(final Acceleration.Rel v) { return new Force.Rel(this.si * v.si, ForceUnit.SI); }
            public FlowMass.Rel divideBy(final Time.Rel v) { return new FlowMass.Rel(this.si / v.si, FlowMassUnit.SI); }
            public FlowMass.Rel multiplyBy(final Frequency.Rel v) { return new FlowMass.Rel(this.si * v.si, FlowMassUnit.SI); }
            public Volume.Rel divideBy(final Density.Rel v) { return new Volume.Rel(this.si / v.si, VolumeUnit.SI); }
            public Dimensionless.Rel divideBy(final Mass.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<MassUnit>
        {
            public Abs(final float value, final MassUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<MassUnit> value) { super(value); }
            public Mass.Abs abs()    { return new Mass.Abs(Math.abs(getInUnit()), getUnit()); }
            public Mass.Abs acos()   { return new Mass.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Mass.Abs asin()   { return new Mass.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Mass.Abs atan()   { return new Mass.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Mass.Abs cbrt()   { return new Mass.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Mass.Abs ceil()   { return new Mass.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Mass.Abs cos()    { return new Mass.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Mass.Abs cosh()   { return new Mass.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Mass.Abs exp()    { return new Mass.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Mass.Abs expm1()  { return new Mass.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Mass.Abs floor()  { return new Mass.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Mass.Abs log()    { return new Mass.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Mass.Abs log10()  { return new Mass.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Mass.Abs log1p()  { return new Mass.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Mass.Abs rint()   { return new Mass.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Mass.Abs round()  { return new Mass.Abs(Math.round(getInUnit()), getUnit()); }
            public Mass.Abs signum() { return new Mass.Abs(Math.signum(getInUnit()), getUnit()); }
            public Mass.Abs sin()    { return new Mass.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Mass.Abs sinh()   { return new Mass.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Mass.Abs sqrt()   { return new Mass.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Mass.Abs tan()    { return new Mass.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Mass.Abs tanh()   { return new Mass.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Mass.Abs inv()    { return new Mass.Abs(1.0f / getInUnit(), getUnit()); }
            public Mass.Abs toDegrees() { return new Mass.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Mass.Abs toRadians() { return new Mass.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Mass.Abs pow(final float x) { return new Mass.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Mass.Abs multiplyBy(final float factor) { return new Mass.Abs(getInUnit() * factor, getUnit()); }
            public Mass.Abs divideBy(final float divisor)  { return new Mass.Abs(getInUnit() / divisor, getUnit()); }
            
            public Mass.Abs plus(final Mass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Mass.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Mass.Abs(this.si + v.si, MassUnit.SI); } 

            public Mass.Rel minus(final Mass.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Mass.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Mass.Rel(this.si - v.si, MassUnit.SI); } 

            public Mass.Abs minus(final Mass.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Mass.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Mass.Abs(this.si - v.si, MassUnit.SI); } 

            public Force.Abs multiplyBy(final Acceleration.Abs v) { return new Force.Abs(this.si * v.si, ForceUnit.SI); }
            public FlowMass.Abs divideBy(final Time.Abs v) { return new FlowMass.Abs(this.si / v.si, FlowMassUnit.SI); }
            public FlowMass.Abs multiplyBy(final Frequency.Abs v) { return new FlowMass.Abs(this.si * v.si, FlowMassUnit.SI); }
            public Volume.Abs divideBy(final Density.Abs v) { return new Volume.Abs(this.si / v.si, VolumeUnit.SI); }
            public Dimensionless.Abs divideBy(final Mass.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /**************************************************** POWER *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Power extends FloatScalar<PowerUnit>
    {
        protected Power(final PowerUnit unit) { super(unit); }
        
        public static Power.Abs interpolate(final Power.Abs zero, final Power.Abs one, final float ratio)
        { return new Power.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Power.Rel interpolate(final Power.Rel zero, final Power.Rel one, final float ratio)
        { return new Power.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<PowerUnit>
        {
            public Rel(final float value, final PowerUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<PowerUnit> value) { super(value); }
            
            public Power.Rel abs()    { return new Power.Rel(Math.abs(getInUnit()), getUnit()); }
            public Power.Rel acos()   { return new Power.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Power.Rel asin()   { return new Power.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Power.Rel atan()   { return new Power.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Power.Rel cbrt()   { return new Power.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Power.Rel ceil()   { return new Power.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Power.Rel cos()    { return new Power.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Power.Rel cosh()   { return new Power.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Power.Rel exp()    { return new Power.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Power.Rel expm1()  { return new Power.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Power.Rel floor()  { return new Power.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Power.Rel log()    { return new Power.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Power.Rel log10()  { return new Power.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Power.Rel log1p()  { return new Power.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Power.Rel rint()   { return new Power.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Power.Rel round()  { return new Power.Rel(Math.round(getInUnit()), getUnit()); }
            public Power.Rel signum() { return new Power.Rel(Math.signum(getInUnit()), getUnit()); }
            public Power.Rel sin()    { return new Power.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Power.Rel sinh()   { return new Power.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Power.Rel sqrt()   { return new Power.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Power.Rel tan()    { return new Power.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Power.Rel tanh()   { return new Power.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Power.Rel inv()    { return new Power.Rel(1.0f / getInUnit(), getUnit()); }
            public Power.Rel toDegrees() { return new Power.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Power.Rel toRadians() { return new Power.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Power.Rel pow(final float x) { return new Power.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Power.Rel multiplyBy(final float factor) { return new Power.Rel(getInUnit() * factor, getUnit()); }
            public Power.Rel divideBy(final float divisor)  { return new Power.Rel(getInUnit() / divisor, getUnit()); }
            
            public Power.Rel plus(final Power.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Power.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Power.Rel(this.si + v.si, PowerUnit.SI); } 

            public Power.Rel minus(final Power.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Power.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Power.Rel(this.si - v.si, PowerUnit.SI); } 

            public Power.Abs plus(final Power.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Power.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Power.Abs(this.si + v.si, PowerUnit.SI); } 
            
            public Energy.Rel multiplyBy(final Time.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public Energy.Rel divideBy(final Frequency.Rel v) { return new Energy.Rel(this.si / v.si, EnergyUnit.SI); }
            public Force.Rel divideBy(final Speed.Rel v) { return new Force.Rel(this.si / v.si, ForceUnit.SI); }
            public ElectricalCurrent.Rel divideBy(final ElectricalPotential.Rel v) { 
                return new ElectricalCurrent.Rel(this.si / v.si, ElectricalCurrentUnit.SI); }
            public ElectricalPotential.Rel divideBy(final ElectricalCurrent.Rel v) { 
                return new ElectricalPotential.Rel(this.si / v.si, ElectricalPotentialUnit.SI); }
            public Dimensionless.Rel divideBy(final Power.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<PowerUnit>
        {
            public Abs(final float value, final PowerUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<PowerUnit> value) { super(value); }
            public Power.Abs abs()    { return new Power.Abs(Math.abs(getInUnit()), getUnit()); }
            public Power.Abs acos()   { return new Power.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Power.Abs asin()   { return new Power.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Power.Abs atan()   { return new Power.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Power.Abs cbrt()   { return new Power.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Power.Abs ceil()   { return new Power.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Power.Abs cos()    { return new Power.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Power.Abs cosh()   { return new Power.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Power.Abs exp()    { return new Power.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Power.Abs expm1()  { return new Power.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Power.Abs floor()  { return new Power.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Power.Abs log()    { return new Power.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Power.Abs log10()  { return new Power.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Power.Abs log1p()  { return new Power.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Power.Abs rint()   { return new Power.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Power.Abs round()  { return new Power.Abs(Math.round(getInUnit()), getUnit()); }
            public Power.Abs signum() { return new Power.Abs(Math.signum(getInUnit()), getUnit()); }
            public Power.Abs sin()    { return new Power.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Power.Abs sinh()   { return new Power.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Power.Abs sqrt()   { return new Power.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Power.Abs tan()    { return new Power.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Power.Abs tanh()   { return new Power.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Power.Abs inv()    { return new Power.Abs(1.0f / getInUnit(), getUnit()); }
            public Power.Abs toDegrees() { return new Power.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Power.Abs toRadians() { return new Power.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Power.Abs pow(final float x) { return new Power.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Power.Abs multiplyBy(final float factor) { return new Power.Abs(getInUnit() * factor, getUnit()); }
            public Power.Abs divideBy(final float divisor)  { return new Power.Abs(getInUnit() / divisor, getUnit()); }
            
            public Power.Abs plus(final Power.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Power.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Power.Abs(this.si + v.si, PowerUnit.SI); } 

            public Power.Rel minus(final Power.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Power.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Power.Rel(this.si - v.si, PowerUnit.SI); } 

            public Power.Abs minus(final Power.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Power.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Power.Abs(this.si - v.si, PowerUnit.SI); } 

            public Energy.Abs multiplyBy(final Time.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public Energy.Abs divideBy(final Frequency.Abs v) { return new Energy.Abs(this.si / v.si, EnergyUnit.SI); }
            public Force.Abs divideBy(final Speed.Abs v) { return new Force.Abs(this.si / v.si, ForceUnit.SI); }
            public ElectricalCurrent.Abs divideBy(final ElectricalPotential.Abs v) { 
                return new ElectricalCurrent.Abs(this.si / v.si, ElectricalCurrentUnit.SI); }
            public ElectricalPotential.Abs divideBy(final ElectricalCurrent.Abs v) { 
                return new ElectricalPotential.Abs(this.si / v.si, ElectricalPotentialUnit.SI); }
            public Dimensionless.Abs divideBy(final Power.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************** PRESSURE ****************************************************/ 
    /****************************************************************************************************************/

    abstract class Pressure extends FloatScalar<PressureUnit>
    {
        protected Pressure(final PressureUnit unit) { super(unit); }
        
        public static Pressure.Abs interpolate(final Pressure.Abs zero, final Pressure.Abs one, final float ratio)
        { return new Pressure.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Pressure.Rel interpolate(final Pressure.Rel zero, final Pressure.Rel one, final float ratio)
        { return new Pressure.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<PressureUnit>
        {
            public Rel(final float value, final PressureUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<PressureUnit> value) { super(value); }
            
            public Pressure.Rel abs()    { return new Pressure.Rel(Math.abs(getInUnit()), getUnit()); }
            public Pressure.Rel acos()   { return new Pressure.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Pressure.Rel asin()   { return new Pressure.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Pressure.Rel atan()   { return new Pressure.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Pressure.Rel cbrt()   { return new Pressure.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Pressure.Rel ceil()   { return new Pressure.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Pressure.Rel cos()    { return new Pressure.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Pressure.Rel cosh()   { return new Pressure.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Pressure.Rel exp()    { return new Pressure.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Pressure.Rel expm1()  { return new Pressure.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Pressure.Rel floor()  { return new Pressure.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Pressure.Rel log()    { return new Pressure.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Pressure.Rel log10()  { return new Pressure.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Pressure.Rel log1p()  { return new Pressure.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Pressure.Rel rint()   { return new Pressure.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Pressure.Rel round()  { return new Pressure.Rel(Math.round(getInUnit()), getUnit()); }
            public Pressure.Rel signum() { return new Pressure.Rel(Math.signum(getInUnit()), getUnit()); }
            public Pressure.Rel sin()    { return new Pressure.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Pressure.Rel sinh()   { return new Pressure.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Pressure.Rel sqrt()   { return new Pressure.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Pressure.Rel tan()    { return new Pressure.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Pressure.Rel tanh()   { return new Pressure.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Pressure.Rel inv()    { return new Pressure.Rel(1.0f / getInUnit(), getUnit()); }
            public Pressure.Rel toDegrees() { return new Pressure.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Pressure.Rel toRadians() { return new Pressure.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Pressure.Rel pow(final float x) { return new Pressure.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Pressure.Rel multiplyBy(final float factor) { return new Pressure.Rel(getInUnit() * factor, getUnit()); }
            public Pressure.Rel divideBy(final float divisor)  { return new Pressure.Rel(getInUnit() / divisor, getUnit()); }
            
            public Pressure.Rel plus(final Pressure.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Pressure.Rel(this.si + v.si, PressureUnit.SI); } 

            public Pressure.Rel minus(final Pressure.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Pressure.Rel(this.si - v.si, PressureUnit.SI); } 

            public Pressure.Abs plus(final Pressure.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Pressure.Abs(this.si + v.si, PressureUnit.SI); } 
            
            public Force.Rel multiplyBy(final Area.Rel v) { return new Force.Rel(this.si * v.si, ForceUnit.SI); }
            public Energy.Rel multiplyBy(final Volume.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public Dimensionless.Rel divideBy(final Pressure.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<PressureUnit>
        {
            public Abs(final float value, final PressureUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<PressureUnit> value) { super(value); }
            public Pressure.Abs abs()    { return new Pressure.Abs(Math.abs(getInUnit()), getUnit()); }
            public Pressure.Abs acos()   { return new Pressure.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Pressure.Abs asin()   { return new Pressure.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Pressure.Abs atan()   { return new Pressure.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Pressure.Abs cbrt()   { return new Pressure.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Pressure.Abs ceil()   { return new Pressure.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Pressure.Abs cos()    { return new Pressure.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Pressure.Abs cosh()   { return new Pressure.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Pressure.Abs exp()    { return new Pressure.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Pressure.Abs expm1()  { return new Pressure.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Pressure.Abs floor()  { return new Pressure.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Pressure.Abs log()    { return new Pressure.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Pressure.Abs log10()  { return new Pressure.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Pressure.Abs log1p()  { return new Pressure.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Pressure.Abs rint()   { return new Pressure.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Pressure.Abs round()  { return new Pressure.Abs(Math.round(getInUnit()), getUnit()); }
            public Pressure.Abs signum() { return new Pressure.Abs(Math.signum(getInUnit()), getUnit()); }
            public Pressure.Abs sin()    { return new Pressure.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Pressure.Abs sinh()   { return new Pressure.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Pressure.Abs sqrt()   { return new Pressure.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Pressure.Abs tan()    { return new Pressure.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Pressure.Abs tanh()   { return new Pressure.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Pressure.Abs inv()    { return new Pressure.Abs(1.0f / getInUnit(), getUnit()); }
            public Pressure.Abs toDegrees() { return new Pressure.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Pressure.Abs toRadians() { return new Pressure.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Pressure.Abs pow(final float x) { return new Pressure.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Pressure.Abs multiplyBy(final float factor) { return new Pressure.Abs(getInUnit() * factor, getUnit()); }
            public Pressure.Abs divideBy(final float divisor)  { return new Pressure.Abs(getInUnit() / divisor, getUnit()); }
            
            public Pressure.Abs plus(final Pressure.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Pressure.Abs(this.si + v.si, PressureUnit.SI); } 

            public Pressure.Rel minus(final Pressure.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Pressure.Rel(this.si - v.si, PressureUnit.SI); } 

            public Pressure.Abs minus(final Pressure.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Pressure.Abs(this.si - v.si, PressureUnit.SI); } 

            public Force.Abs multiplyBy(final Area.Abs v) { return new Force.Abs(this.si * v.si, ForceUnit.SI); }
            public Energy.Abs multiplyBy(final Volume.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public Dimensionless.Abs divideBy(final Pressure.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /***************************************************** SPEED ****************************************************/ 
    /****************************************************************************************************************/

    abstract class Speed extends FloatScalar<SpeedUnit>
    {
        protected Speed(final SpeedUnit unit) { super(unit); }
        
        public static Speed.Abs interpolate(final Speed.Abs zero, final Speed.Abs one, final float ratio)
        { return new Speed.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Speed.Rel interpolate(final Speed.Rel zero, final Speed.Rel one, final float ratio)
        { return new Speed.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<SpeedUnit>
        {
            public Rel(final float value, final SpeedUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<SpeedUnit> value) { super(value); }
            
            public Speed.Rel abs()    { return new Speed.Rel(Math.abs(getInUnit()), getUnit()); }
            public Speed.Rel acos()   { return new Speed.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Speed.Rel asin()   { return new Speed.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Speed.Rel atan()   { return new Speed.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Speed.Rel cbrt()   { return new Speed.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Speed.Rel ceil()   { return new Speed.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Speed.Rel cos()    { return new Speed.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Speed.Rel cosh()   { return new Speed.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Speed.Rel exp()    { return new Speed.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Speed.Rel expm1()  { return new Speed.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Speed.Rel floor()  { return new Speed.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Speed.Rel log()    { return new Speed.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Speed.Rel log10()  { return new Speed.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Speed.Rel log1p()  { return new Speed.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Speed.Rel rint()   { return new Speed.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Speed.Rel round()  { return new Speed.Rel(Math.round(getInUnit()), getUnit()); }
            public Speed.Rel signum() { return new Speed.Rel(Math.signum(getInUnit()), getUnit()); }
            public Speed.Rel sin()    { return new Speed.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Speed.Rel sinh()   { return new Speed.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Speed.Rel sqrt()   { return new Speed.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Speed.Rel tan()    { return new Speed.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Speed.Rel tanh()   { return new Speed.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Speed.Rel inv()    { return new Speed.Rel(1.0f / getInUnit(), getUnit()); }
            public Speed.Rel toDegrees() { return new Speed.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Speed.Rel toRadians() { return new Speed.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Speed.Rel pow(final float x) { return new Speed.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Speed.Rel multiplyBy(final float factor) { return new Speed.Rel(getInUnit() * factor, getUnit()); }
            public Speed.Rel divideBy(final float divisor)  { return new Speed.Rel(getInUnit() / divisor, getUnit()); }
            
            public Speed.Rel plus(final Speed.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Speed.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Speed.Rel(this.si + v.si, SpeedUnit.SI); } 

            public Speed.Rel minus(final Speed.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Speed.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Speed.Rel(this.si - v.si, SpeedUnit.SI); } 

            public Speed.Abs plus(final Speed.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Speed.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Speed.Abs(this.si + v.si, SpeedUnit.SI); } 
            
            public Length.Rel multiplyBy(final Time.Rel v) { return new Length.Rel(this.si * v.si, LengthUnit.SI); }
            public FlowVolume.Rel multiplyBy(final Area.Rel v) { return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI); }
            public Force.Rel multiplyBy(final FlowMass.Rel v) { return new Force.Rel(this.si * v.si, ForceUnit.SI); }
            public Power.Rel multiplyBy(final Force.Rel v) { return new Power.Rel(this.si * v.si, PowerUnit.SI); }
            public Frequency.Rel divideBy(final Length.Rel v) { return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI); }
            public Acceleration.Rel divideBy(final Time.Rel v) { return new Acceleration.Rel(this.si / v.si, AccelerationUnit.SI); }
            public Length.Rel divideBy(final Frequency.Rel v) { return new Length.Rel(this.si / v.si, LengthUnit.SI); }
            public Dimensionless.Rel divideBy(final Speed.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<SpeedUnit>
        {
            public Abs(final float value, final SpeedUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<SpeedUnit> value) { super(value); }
            public Speed.Abs abs()    { return new Speed.Abs(Math.abs(getInUnit()), getUnit()); }
            public Speed.Abs acos()   { return new Speed.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Speed.Abs asin()   { return new Speed.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Speed.Abs atan()   { return new Speed.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Speed.Abs cbrt()   { return new Speed.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Speed.Abs ceil()   { return new Speed.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Speed.Abs cos()    { return new Speed.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Speed.Abs cosh()   { return new Speed.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Speed.Abs exp()    { return new Speed.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Speed.Abs expm1()  { return new Speed.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Speed.Abs floor()  { return new Speed.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Speed.Abs log()    { return new Speed.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Speed.Abs log10()  { return new Speed.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Speed.Abs log1p()  { return new Speed.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Speed.Abs rint()   { return new Speed.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Speed.Abs round()  { return new Speed.Abs(Math.round(getInUnit()), getUnit()); }
            public Speed.Abs signum() { return new Speed.Abs(Math.signum(getInUnit()), getUnit()); }
            public Speed.Abs sin()    { return new Speed.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Speed.Abs sinh()   { return new Speed.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Speed.Abs sqrt()   { return new Speed.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Speed.Abs tan()    { return new Speed.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Speed.Abs tanh()   { return new Speed.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Speed.Abs inv()    { return new Speed.Abs(1.0f / getInUnit(), getUnit()); }
            public Speed.Abs toDegrees() { return new Speed.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Speed.Abs toRadians() { return new Speed.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Speed.Abs pow(final float x) { return new Speed.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Speed.Abs multiplyBy(final float factor) { return new Speed.Abs(getInUnit() * factor, getUnit()); }
            public Speed.Abs divideBy(final float divisor)  { return new Speed.Abs(getInUnit() / divisor, getUnit()); }
            
            public Speed.Abs plus(final Speed.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Speed.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Speed.Abs(this.si + v.si, SpeedUnit.SI); } 

            public Speed.Rel minus(final Speed.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Speed.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Speed.Rel(this.si - v.si, SpeedUnit.SI); } 

            public Speed.Abs minus(final Speed.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Speed.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Speed.Abs(this.si - v.si, SpeedUnit.SI); } 

            public Length.Abs multiplyBy(final Time.Abs v) { return new Length.Abs(this.si * v.si, LengthUnit.SI); }
            public FlowVolume.Abs multiplyBy(final Area.Abs v) { return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI); }
            public Force.Abs multiplyBy(final FlowMass.Abs v) { return new Force.Abs(this.si * v.si, ForceUnit.SI); }
            public Power.Abs multiplyBy(final Force.Abs v) { return new Power.Abs(this.si * v.si, PowerUnit.SI); }
            public Frequency.Abs divideBy(final Length.Abs v) { return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI); }
            public Acceleration.Abs divideBy(final Time.Abs v) { return new Acceleration.Abs(this.si / v.si, AccelerationUnit.SI); }
            public Length.Abs divideBy(final Frequency.Abs v) { return new Length.Abs(this.si / v.si, LengthUnit.SI); }
            public Dimensionless.Abs divideBy(final Speed.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /************************************************* TEMPERATURE **************************************************/ 
    /****************************************************************************************************************/

    abstract class Temperature extends FloatScalar<TemperatureUnit>
    {
        protected Temperature(final TemperatureUnit unit) { super(unit); }
        
        public static Temperature.Abs interpolate(final Temperature.Abs zero, final Temperature.Abs one, final float ratio)
        { return new Temperature.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Temperature.Rel interpolate(final Temperature.Rel zero, final Temperature.Rel one, final float ratio)
        { return new Temperature.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<TemperatureUnit>
        {
            public Rel(final float value, final TemperatureUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<TemperatureUnit> value) { super(value); }
            
            public Temperature.Rel abs()    { return new Temperature.Rel(Math.abs(getInUnit()), getUnit()); }
            public Temperature.Rel acos()   { return new Temperature.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Temperature.Rel asin()   { return new Temperature.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Temperature.Rel atan()   { return new Temperature.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Temperature.Rel cbrt()   { return new Temperature.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Temperature.Rel ceil()   { return new Temperature.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Temperature.Rel cos()    { return new Temperature.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Temperature.Rel cosh()   { return new Temperature.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Temperature.Rel exp()    { return new Temperature.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Temperature.Rel expm1()  { return new Temperature.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Temperature.Rel floor()  { return new Temperature.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Temperature.Rel log()    { return new Temperature.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Temperature.Rel log10()  { return new Temperature.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Temperature.Rel log1p()  { return new Temperature.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Temperature.Rel rint()   { return new Temperature.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Temperature.Rel round()  { return new Temperature.Rel(Math.round(getInUnit()), getUnit()); }
            public Temperature.Rel signum() { return new Temperature.Rel(Math.signum(getInUnit()), getUnit()); }
            public Temperature.Rel sin()    { return new Temperature.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Temperature.Rel sinh()   { return new Temperature.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Temperature.Rel sqrt()   { return new Temperature.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Temperature.Rel tan()    { return new Temperature.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Temperature.Rel tanh()   { return new Temperature.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Temperature.Rel inv()    { return new Temperature.Rel(1.0f / getInUnit(), getUnit()); }
            public Temperature.Rel toDegrees() { return new Temperature.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Temperature.Rel toRadians() { return new Temperature.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Temperature.Rel pow(final float x) { return new Temperature.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Temperature.Rel multiplyBy(final float factor) { return new Temperature.Rel(getInUnit() * factor, getUnit()); }
            public Temperature.Rel divideBy(final float divisor)  { return new Temperature.Rel(getInUnit() / divisor, getUnit()); }
            
            public Temperature.Rel plus(final Temperature.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Temperature.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Temperature.Rel(this.si + v.si, TemperatureUnit.SI); } 

            public Temperature.Rel minus(final Temperature.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Temperature.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Temperature.Rel(this.si - v.si, TemperatureUnit.SI); } 

            public Temperature.Abs plus(final Temperature.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Temperature.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Temperature.Abs(this.si + v.si, TemperatureUnit.SI); } 

            public Dimensionless.Rel divideBy(final Temperature.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<TemperatureUnit>
        {
            public Abs(final float value, final TemperatureUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<TemperatureUnit> value) { super(value); }
            public Temperature.Abs abs()    { return new Temperature.Abs(Math.abs(getInUnit()), getUnit()); }
            public Temperature.Abs acos()   { return new Temperature.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Temperature.Abs asin()   { return new Temperature.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Temperature.Abs atan()   { return new Temperature.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Temperature.Abs cbrt()   { return new Temperature.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Temperature.Abs ceil()   { return new Temperature.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Temperature.Abs cos()    { return new Temperature.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Temperature.Abs cosh()   { return new Temperature.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Temperature.Abs exp()    { return new Temperature.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Temperature.Abs expm1()  { return new Temperature.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Temperature.Abs floor()  { return new Temperature.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Temperature.Abs log()    { return new Temperature.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Temperature.Abs log10()  { return new Temperature.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Temperature.Abs log1p()  { return new Temperature.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Temperature.Abs rint()   { return new Temperature.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Temperature.Abs round()  { return new Temperature.Abs(Math.round(getInUnit()), getUnit()); }
            public Temperature.Abs signum() { return new Temperature.Abs(Math.signum(getInUnit()), getUnit()); }
            public Temperature.Abs sin()    { return new Temperature.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Temperature.Abs sinh()   { return new Temperature.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Temperature.Abs sqrt()   { return new Temperature.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Temperature.Abs tan()    { return new Temperature.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Temperature.Abs tanh()   { return new Temperature.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Temperature.Abs inv()    { return new Temperature.Abs(1.0f / getInUnit(), getUnit()); }
            public Temperature.Abs toDegrees() { return new Temperature.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Temperature.Abs toRadians() { return new Temperature.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Temperature.Abs pow(final float x) { return new Temperature.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Temperature.Abs multiplyBy(final float factor) { return new Temperature.Abs(getInUnit() * factor, getUnit()); }
            public Temperature.Abs divideBy(final float divisor)  { return new Temperature.Abs(getInUnit() / divisor, getUnit()); }
            
            public Temperature.Abs plus(final Temperature.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Temperature.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Temperature.Abs(this.si + v.si, TemperatureUnit.SI); } 

            public Temperature.Rel minus(final Temperature.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Temperature.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Temperature.Rel(this.si - v.si, TemperatureUnit.SI); } 

            public Temperature.Abs minus(final Temperature.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Temperature.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Temperature.Abs(this.si - v.si, TemperatureUnit.SI); } 

            public Dimensionless.Abs divideBy(final Temperature.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /***************************************************** TIME *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Time extends FloatScalar<TimeUnit>
    {
        protected Time(final TimeUnit unit) { super(unit); }
        
        public static Time.Abs interpolate(final Time.Abs zero, final Time.Abs one, final float ratio)
        { return new Time.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Time.Rel interpolate(final Time.Rel zero, final Time.Rel one, final float ratio)
        { return new Time.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<TimeUnit>
        {
            public Rel(final float value, final TimeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<TimeUnit> value) { super(value); }
            
            public Time.Rel abs()    { return new Time.Rel(Math.abs(getInUnit()), getUnit()); }
            public Time.Rel acos()   { return new Time.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Time.Rel asin()   { return new Time.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Time.Rel atan()   { return new Time.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Time.Rel cbrt()   { return new Time.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Time.Rel ceil()   { return new Time.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Time.Rel cos()    { return new Time.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Time.Rel cosh()   { return new Time.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Time.Rel exp()    { return new Time.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Time.Rel expm1()  { return new Time.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Time.Rel floor()  { return new Time.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Time.Rel log()    { return new Time.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Time.Rel log10()  { return new Time.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Time.Rel log1p()  { return new Time.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Time.Rel rint()   { return new Time.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Time.Rel round()  { return new Time.Rel(Math.round(getInUnit()), getUnit()); }
            public Time.Rel signum() { return new Time.Rel(Math.signum(getInUnit()), getUnit()); }
            public Time.Rel sin()    { return new Time.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Time.Rel sinh()   { return new Time.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Time.Rel sqrt()   { return new Time.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Time.Rel tan()    { return new Time.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Time.Rel tanh()   { return new Time.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Time.Rel inv()    { return new Time.Rel(1.0f / getInUnit(), getUnit()); }
            public Time.Rel toDegrees() { return new Time.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Time.Rel toRadians() { return new Time.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Time.Rel pow(final float x) { return new Time.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Time.Rel multiplyBy(final float factor) { return new Time.Rel(getInUnit() * factor, getUnit()); }
            public Time.Rel divideBy(final float divisor)  { return new Time.Rel(getInUnit() / divisor, getUnit()); }
            
            public Time.Rel plus(final Time.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Time.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Time.Rel(this.si + v.si, TimeUnit.SI); } 

            public Time.Rel minus(final Time.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Time.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Time.Rel(this.si - v.si, TimeUnit.SI); } 

            public Time.Abs plus(final Time.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Time.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Time.Abs(this.si + v.si, TimeUnit.SI); } 
            
            public Dimensionless.Rel multiplyBy(final Frequency.Rel v) { return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI); }
            public Length.Rel multiplyBy(final Speed.Rel v) { return new Length.Rel(this.si * v.si, LengthUnit.SI); }
            public Speed.Rel multiplyBy(final Acceleration.Rel v) { return new Speed.Rel(this.si * v.si, SpeedUnit.SI); }
            public Mass.Rel multiplyBy(final FlowMass.Rel v) { return new Mass.Rel(this.si * v.si, MassUnit.SI); }
            public Volume.Rel multiplyBy(final FlowVolume.Rel v) { return new Volume.Rel(this.si * v.si, VolumeUnit.SI); }
            public Energy.Rel multiplyBy(final Power.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public ElectricalCharge.Rel multiplyBy(final ElectricalCurrent.Rel v) { 
                return new ElectricalCharge.Rel(this.si * v.si, ElectricalChargeUnit.SI); }
            public Dimensionless.Rel divideBy(final Time.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<TimeUnit>
        {
            public Abs(final float value, final TimeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<TimeUnit> value) { super(value); }
            public Time.Abs abs()    { return new Time.Abs(Math.abs(getInUnit()), getUnit()); }
            public Time.Abs acos()   { return new Time.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Time.Abs asin()   { return new Time.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Time.Abs atan()   { return new Time.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Time.Abs cbrt()   { return new Time.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Time.Abs ceil()   { return new Time.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Time.Abs cos()    { return new Time.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Time.Abs cosh()   { return new Time.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Time.Abs exp()    { return new Time.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Time.Abs expm1()  { return new Time.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Time.Abs floor()  { return new Time.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Time.Abs log()    { return new Time.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Time.Abs log10()  { return new Time.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Time.Abs log1p()  { return new Time.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Time.Abs rint()   { return new Time.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Time.Abs round()  { return new Time.Abs(Math.round(getInUnit()), getUnit()); }
            public Time.Abs signum() { return new Time.Abs(Math.signum(getInUnit()), getUnit()); }
            public Time.Abs sin()    { return new Time.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Time.Abs sinh()   { return new Time.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Time.Abs sqrt()   { return new Time.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Time.Abs tan()    { return new Time.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Time.Abs tanh()   { return new Time.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Time.Abs inv()    { return new Time.Abs(1.0f / getInUnit(), getUnit()); }
            public Time.Abs toDegrees() { return new Time.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Time.Abs toRadians() { return new Time.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Time.Abs pow(final float x) { return new Time.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Time.Abs multiplyBy(final float factor) { return new Time.Abs(getInUnit() * factor, getUnit()); }
            public Time.Abs divideBy(final float divisor)  { return new Time.Abs(getInUnit() / divisor, getUnit()); }
            
            public Time.Abs plus(final Time.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Time.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Time.Abs(this.si + v.si, TimeUnit.SI); } 

            public Time.Rel minus(final Time.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Time.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Time.Rel(this.si - v.si, TimeUnit.SI); } 

            public Time.Abs minus(final Time.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Time.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Time.Abs(this.si - v.si, TimeUnit.SI); } 

            public Dimensionless.Abs multiplyBy(final Frequency.Abs v) { return new Dimensionless.Abs(this.si * v.si, DimensionlessUnit.SI); }
            public Length.Abs multiplyBy(final Speed.Abs v) { return new Length.Abs(this.si * v.si, LengthUnit.SI); }
            public Speed.Abs multiplyBy(final Acceleration.Abs v) { return new Speed.Abs(this.si * v.si, SpeedUnit.SI); }
            public Mass.Abs multiplyBy(final FlowMass.Abs v) { return new Mass.Abs(this.si * v.si, MassUnit.SI); }
            public Volume.Abs multiplyBy(final FlowVolume.Abs v) { return new Volume.Abs(this.si * v.si, VolumeUnit.SI); }
            public Energy.Abs multiplyBy(final Power.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public ElectricalCharge.Abs multiplyBy(final ElectricalCurrent.Abs v) { 
                return new ElectricalCharge.Abs(this.si * v.si, ElectricalChargeUnit.SI); }
            public Dimensionless.Abs divideBy(final Time.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }
        
    /****************************************************************************************************************/
    /*************************************************** TORQUE *****************************************************/ 
    /****************************************************************************************************************/

    abstract class Torque extends FloatScalar<TorqueUnit>
    {
        protected Torque(final TorqueUnit unit) { super(unit); }
        
        public static Torque.Abs interpolate(final Torque.Abs zero, final Torque.Abs one, final float ratio)
        { return new Torque.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Torque.Rel interpolate(final Torque.Rel zero, final Torque.Rel one, final float ratio)
        { return new Torque.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<TorqueUnit>
        {
            public Rel(final float value, final TorqueUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<TorqueUnit> value) { super(value); }
            
            public Torque.Rel abs()    { return new Torque.Rel(Math.abs(getInUnit()), getUnit()); }
            public Torque.Rel acos()   { return new Torque.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Torque.Rel asin()   { return new Torque.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Torque.Rel atan()   { return new Torque.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Torque.Rel cbrt()   { return new Torque.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Torque.Rel ceil()   { return new Torque.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Torque.Rel cos()    { return new Torque.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Torque.Rel cosh()   { return new Torque.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Torque.Rel exp()    { return new Torque.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Torque.Rel expm1()  { return new Torque.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Torque.Rel floor()  { return new Torque.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Torque.Rel log()    { return new Torque.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Torque.Rel log10()  { return new Torque.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Torque.Rel log1p()  { return new Torque.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Torque.Rel rint()   { return new Torque.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Torque.Rel round()  { return new Torque.Rel(Math.round(getInUnit()), getUnit()); }
            public Torque.Rel signum() { return new Torque.Rel(Math.signum(getInUnit()), getUnit()); }
            public Torque.Rel sin()    { return new Torque.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Torque.Rel sinh()   { return new Torque.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Torque.Rel sqrt()   { return new Torque.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Torque.Rel tan()    { return new Torque.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Torque.Rel tanh()   { return new Torque.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Torque.Rel inv()    { return new Torque.Rel(1.0f / getInUnit(), getUnit()); }
            public Torque.Rel toDegrees() { return new Torque.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Torque.Rel toRadians() { return new Torque.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Torque.Rel pow(final float x) { return new Torque.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Torque.Rel multiplyBy(final float factor) { return new Torque.Rel(getInUnit() * factor, getUnit()); }
            public Torque.Rel divideBy(final float divisor)  { return new Torque.Rel(getInUnit() / divisor, getUnit()); }
            
            public Torque.Rel plus(final Torque.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Torque.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Torque.Rel(this.si + v.si, TorqueUnit.SI); } 

            public Torque.Rel minus(final Torque.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Torque.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Torque.Rel(this.si - v.si, TorqueUnit.SI); } 

            public Torque.Abs plus(final Torque.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Torque.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Torque.Abs(this.si + v.si, TorqueUnit.SI); } 
            
            public Length.Rel divideBy(final Force.Rel v) { return new Length.Rel(this.si / v.si, LengthUnit.SI); }
            public Force.Rel divideBy(final Length.Rel v) { return new Force.Rel(this.si / v.si, ForceUnit.SI); }
            public Power.Rel divideBy(final Time.Rel v) { return new Power.Rel(this.si / v.si, PowerUnit.SI); }
            public Pressure.Rel divideBy(final Volume.Rel v) { return new Pressure.Rel(this.si / v.si, PressureUnit.SI); }
            public Dimensionless.Rel divideBy(final Torque.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<TorqueUnit>
        {
            public Abs(final float value, final TorqueUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<TorqueUnit> value) { super(value); }
            public Torque.Abs abs()    { return new Torque.Abs(Math.abs(getInUnit()), getUnit()); }
            public Torque.Abs acos()   { return new Torque.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Torque.Abs asin()   { return new Torque.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Torque.Abs atan()   { return new Torque.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Torque.Abs cbrt()   { return new Torque.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Torque.Abs ceil()   { return new Torque.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Torque.Abs cos()    { return new Torque.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Torque.Abs cosh()   { return new Torque.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Torque.Abs exp()    { return new Torque.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Torque.Abs expm1()  { return new Torque.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Torque.Abs floor()  { return new Torque.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Torque.Abs log()    { return new Torque.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Torque.Abs log10()  { return new Torque.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Torque.Abs log1p()  { return new Torque.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Torque.Abs rint()   { return new Torque.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Torque.Abs round()  { return new Torque.Abs(Math.round(getInUnit()), getUnit()); }
            public Torque.Abs signum() { return new Torque.Abs(Math.signum(getInUnit()), getUnit()); }
            public Torque.Abs sin()    { return new Torque.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Torque.Abs sinh()   { return new Torque.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Torque.Abs sqrt()   { return new Torque.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Torque.Abs tan()    { return new Torque.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Torque.Abs tanh()   { return new Torque.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Torque.Abs inv()    { return new Torque.Abs(1.0f / getInUnit(), getUnit()); }
            public Torque.Abs toDegrees() { return new Torque.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Torque.Abs toRadians() { return new Torque.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Torque.Abs pow(final float x) { return new Torque.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Torque.Abs multiplyBy(final float factor) { return new Torque.Abs(getInUnit() * factor, getUnit()); }
            public Torque.Abs divideBy(final float divisor)  { return new Torque.Abs(getInUnit() / divisor, getUnit()); }
            
            public Torque.Abs plus(final Torque.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Torque.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Torque.Abs(this.si + v.si, TorqueUnit.SI); } 

            public Torque.Rel minus(final Torque.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Torque.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Torque.Rel(this.si - v.si, TorqueUnit.SI); } 

            public Torque.Abs minus(final Torque.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Torque.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Torque.Abs(this.si - v.si, TorqueUnit.SI); } 

            public Length.Abs divideBy(final Force.Abs v) { return new Length.Abs(this.si / v.si, LengthUnit.SI); }
            public Force.Abs divideBy(final Length.Abs v) { return new Force.Abs(this.si / v.si, ForceUnit.SI); }
            public Power.Abs divideBy(final Time.Abs v) { return new Power.Abs(this.si / v.si, PowerUnit.SI); }
            public Pressure.Abs divideBy(final Volume.Abs v) { return new Pressure.Abs(this.si / v.si, PressureUnit.SI); }
            public Dimensionless.Abs divideBy(final Torque.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /*************************************************** VOLUME *****************************************************/ 
    /****************************************************************************************************************/
 
    abstract class Volume extends FloatScalar<VolumeUnit>
    {
        protected Volume(final VolumeUnit unit) { super(unit); }
        
        public static Volume.Abs interpolate(final Volume.Abs zero, final Volume.Abs one, final float ratio)
        { return new Volume.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Volume.Rel interpolate(final Volume.Rel zero, final Volume.Rel one, final float ratio)
        { return new Volume.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<VolumeUnit>
        {
            public Rel(final float value, final VolumeUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<VolumeUnit> value) { super(value); }
            
            public Volume.Rel abs()    { return new Volume.Rel(Math.abs(getInUnit()), getUnit()); }
            public Volume.Rel acos()   { return new Volume.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Volume.Rel asin()   { return new Volume.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Volume.Rel atan()   { return new Volume.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Volume.Rel cbrt()   { return new Volume.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Volume.Rel ceil()   { return new Volume.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Volume.Rel cos()    { return new Volume.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Volume.Rel cosh()   { return new Volume.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Volume.Rel exp()    { return new Volume.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Volume.Rel expm1()  { return new Volume.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Volume.Rel floor()  { return new Volume.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Volume.Rel log()    { return new Volume.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Volume.Rel log10()  { return new Volume.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Volume.Rel log1p()  { return new Volume.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Volume.Rel rint()   { return new Volume.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Volume.Rel round()  { return new Volume.Rel(Math.round(getInUnit()), getUnit()); }
            public Volume.Rel signum() { return new Volume.Rel(Math.signum(getInUnit()), getUnit()); }
            public Volume.Rel sin()    { return new Volume.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Volume.Rel sinh()   { return new Volume.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Volume.Rel sqrt()   { return new Volume.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Volume.Rel tan()    { return new Volume.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Volume.Rel tanh()   { return new Volume.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Volume.Rel inv()    { return new Volume.Rel(1.0f / getInUnit(), getUnit()); }
            public Volume.Rel toDegrees() { return new Volume.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Volume.Rel toRadians() { return new Volume.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Volume.Rel pow(final float x) { return new Volume.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Volume.Rel multiplyBy(final float factor) { return new Volume.Rel(getInUnit() * factor, getUnit()); }
            public Volume.Rel divideBy(final float divisor)  { return new Volume.Rel(getInUnit() / divisor, getUnit()); }
            
            public Volume.Rel plus(final Volume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Volume.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Volume.Rel(this.si + v.si, VolumeUnit.SI); } 

            public Volume.Rel minus(final Volume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Volume.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Volume.Rel(this.si - v.si, VolumeUnit.SI); } 

            public Volume.Abs plus(final Volume.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Volume.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Volume.Abs(this.si + v.si, VolumeUnit.SI); } 
            
            public Energy.Rel multiplyBy(final Pressure.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public Area.Rel divideBy(final Length.Rel v) { return new Area.Rel(this.si / v.si, AreaUnit.SI); }
            public Length.Rel divideBy(final Area.Rel v) { return new Length.Rel(this.si / v.si, LengthUnit.SI); }
            public FlowVolume.Rel divideBy(final Time.Rel v) { return new FlowVolume.Rel(this.si / v.si, FlowVolumeUnit.SI); }
            public Mass.Rel multiplyBy(final Density.Rel v) { return new Mass.Rel(this.si * v.si, MassUnit.SI); }
            public Dimensionless.Rel divideBy(final Volume.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<VolumeUnit>
        {
            public Abs(final float value, final VolumeUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<VolumeUnit> value) { super(value); }
            public Volume.Abs abs()    { return new Volume.Abs(Math.abs(getInUnit()), getUnit()); }
            public Volume.Abs acos()   { return new Volume.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Volume.Abs asin()   { return new Volume.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Volume.Abs atan()   { return new Volume.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Volume.Abs cbrt()   { return new Volume.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Volume.Abs ceil()   { return new Volume.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Volume.Abs cos()    { return new Volume.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Volume.Abs cosh()   { return new Volume.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Volume.Abs exp()    { return new Volume.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Volume.Abs expm1()  { return new Volume.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Volume.Abs floor()  { return new Volume.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Volume.Abs log()    { return new Volume.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Volume.Abs log10()  { return new Volume.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Volume.Abs log1p()  { return new Volume.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Volume.Abs rint()   { return new Volume.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Volume.Abs round()  { return new Volume.Abs(Math.round(getInUnit()), getUnit()); }
            public Volume.Abs signum() { return new Volume.Abs(Math.signum(getInUnit()), getUnit()); }
            public Volume.Abs sin()    { return new Volume.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Volume.Abs sinh()   { return new Volume.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Volume.Abs sqrt()   { return new Volume.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Volume.Abs tan()    { return new Volume.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Volume.Abs tanh()   { return new Volume.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Volume.Abs inv()    { return new Volume.Abs(1.0f / getInUnit(), getUnit()); }
            public Volume.Abs toDegrees() { return new Volume.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Volume.Abs toRadians() { return new Volume.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Volume.Abs pow(final float x) { return new Volume.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Volume.Abs multiplyBy(final float factor) { return new Volume.Abs(getInUnit() * factor, getUnit()); }
            public Volume.Abs divideBy(final float divisor)  { return new Volume.Abs(getInUnit() / divisor, getUnit()); }
            
            public Volume.Abs plus(final Volume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Volume.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Volume.Abs(this.si + v.si, VolumeUnit.SI); } 

            public Volume.Rel minus(final Volume.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Volume.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Volume.Rel(this.si - v.si, VolumeUnit.SI); } 

            public Volume.Abs minus(final Volume.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Volume.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Volume.Abs(this.si - v.si, VolumeUnit.SI); } 

            public Energy.Abs multiplyBy(final Pressure.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public Area.Abs divideBy(final Length.Abs v) { return new Area.Abs(this.si / v.si, AreaUnit.SI); }
            public Length.Abs divideBy(final Area.Abs v) { return new Length.Abs(this.si / v.si, LengthUnit.SI); }
            public FlowVolume.Abs divideBy(final Time.Abs v) { return new FlowVolume.Abs(this.si / v.si, FlowVolumeUnit.SI); }
            public Mass.Abs multiplyBy(final Density.Abs v) { return new Mass.Abs(this.si * v.si, MassUnit.SI); }
            public Dimensionless.Abs divideBy(final Volume.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
        }
    }

    /****************************************************************************************************************/
    /*********************************************** DIMENSIONLESS **************************************************/ 
    /****************************************************************************************************************/

    abstract class Dimensionless extends FloatScalar<DimensionlessUnit>
    {
        protected Dimensionless(final DimensionlessUnit unit) { super(unit); }
        
        public static Dimensionless.Abs interpolate(final Dimensionless.Abs zero, final Dimensionless.Abs one, final float ratio)
        { return new Dimensionless.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }
        public static Dimensionless.Rel interpolate(final Dimensionless.Rel zero, final Dimensionless.Rel one, final float ratio)
        { return new Dimensionless.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit()); }

        public static class Rel extends FloatScalar.Rel<DimensionlessUnit>
        {
            public Rel(final float value, final DimensionlessUnit unit) { super(value, unit); }
            public Rel(final org.djunits.value.vfloat.scalar.FloatScalar.Rel<DimensionlessUnit> value) { super(value); }
            
            public Dimensionless.Rel abs()    { return new Dimensionless.Rel(Math.abs(getInUnit()), getUnit()); }
            public Dimensionless.Rel acos()   { return new Dimensionless.Rel((float) Math.acos(getInUnit()), getUnit()); }
            public Dimensionless.Rel asin()   { return new Dimensionless.Rel((float) Math.asin(getInUnit()), getUnit()); }
            public Dimensionless.Rel atan()   { return new Dimensionless.Rel((float) Math.atan(getInUnit()), getUnit()); }
            public Dimensionless.Rel cbrt()   { return new Dimensionless.Rel((float) Math.cbrt(getInUnit()), getUnit()); }
            public Dimensionless.Rel ceil()   { return new Dimensionless.Rel((float) Math.ceil(getInUnit()), getUnit()); }
            public Dimensionless.Rel cos()    { return new Dimensionless.Rel((float) Math.cos(getInUnit()), getUnit()); }
            public Dimensionless.Rel cosh()   { return new Dimensionless.Rel((float) Math.cosh(getInUnit()), getUnit()); }
            public Dimensionless.Rel exp()    { return new Dimensionless.Rel((float) Math.exp(getInUnit()), getUnit()); }
            public Dimensionless.Rel expm1()  { return new Dimensionless.Rel((float) Math.expm1(getInUnit()), getUnit()); }
            public Dimensionless.Rel floor()  { return new Dimensionless.Rel((float) Math.floor(getInUnit()), getUnit()); }
            public Dimensionless.Rel log()    { return new Dimensionless.Rel((float) Math.log(getInUnit()), getUnit()); }
            public Dimensionless.Rel log10()  { return new Dimensionless.Rel((float) Math.log10(getInUnit()), getUnit()); }
            public Dimensionless.Rel log1p()  { return new Dimensionless.Rel((float) Math.log1p(getInUnit()), getUnit()); }
            public Dimensionless.Rel rint()   { return new Dimensionless.Rel((float) Math.rint(getInUnit()), getUnit()); }
            public Dimensionless.Rel round()  { return new Dimensionless.Rel(Math.round(getInUnit()), getUnit()); }
            public Dimensionless.Rel signum() { return new Dimensionless.Rel(Math.signum(getInUnit()), getUnit()); }
            public Dimensionless.Rel sin()    { return new Dimensionless.Rel((float) Math.sin(getInUnit()), getUnit()); }
            public Dimensionless.Rel sinh()   { return new Dimensionless.Rel((float) Math.sinh(getInUnit()), getUnit()); }
            public Dimensionless.Rel sqrt()   { return new Dimensionless.Rel((float) Math.sqrt(getInUnit()), getUnit()); }
            public Dimensionless.Rel tan()    { return new Dimensionless.Rel((float) Math.tan(getInUnit()), getUnit()); }
            public Dimensionless.Rel tanh()   { return new Dimensionless.Rel((float) Math.tanh(getInUnit()), getUnit()); }
            public Dimensionless.Rel inv()    { return new Dimensionless.Rel(1.0f / getInUnit(), getUnit()); }
            public Dimensionless.Rel toDegrees() { return new Dimensionless.Rel((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Dimensionless.Rel toRadians() { return new Dimensionless.Rel((float) Math.toRadians(getInUnit()), getUnit()); }
            public Dimensionless.Rel pow(final float x) { return new Dimensionless.Rel((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Dimensionless.Rel multiplyBy(final float factor) { return new Dimensionless.Rel(getInUnit() * factor, getUnit()); }
            public Dimensionless.Rel divideBy(final float divisor)  { return new Dimensionless.Rel(getInUnit() / divisor, getUnit()); }
            
            public Dimensionless.Rel plus(final Dimensionless.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Dimensionless.Rel(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Dimensionless.Rel(this.si + v.si, DimensionlessUnit.SI); } 

            public Dimensionless.Rel minus(final Dimensionless.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Dimensionless.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Dimensionless.Rel(this.si - v.si, DimensionlessUnit.SI); } 

            public Dimensionless.Abs plus(final Dimensionless.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Dimensionless.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Dimensionless.Abs(this.si + v.si, DimensionlessUnit.SI); } 
            
            public Acceleration.Rel multiplyBy(final Acceleration.Rel v) { return new Acceleration.Rel(this.si * v.si, AccelerationUnit.SI); }
            public AnglePlane.Rel multiplyBy(final AnglePlane.Rel v) { return new AnglePlane.Rel(this.si * v.si, AnglePlaneUnit.SI); }
            public AngleSlope.Rel multiplyBy(final AngleSlope.Rel v) { return new AngleSlope.Rel(this.si * v.si, AngleSlopeUnit.SI); }
            public AngleSolid.Rel multiplyBy(final AngleSolid.Rel v) { return new AngleSolid.Rel(this.si * v.si, AngleSolidUnit.SI); }
            public Area.Rel multiplyBy(final Area.Rel v) { return new Area.Rel(this.si * v.si, AreaUnit.SI); }
            public Density.Rel multiplyBy(final Density.Rel v) { return new Density.Rel(this.si * v.si, DensityUnit.SI); }
            public Dimensionless.Rel multiplyBy(final Dimensionless.Rel v) { return new Dimensionless.Rel(this.si * v.si, DimensionlessUnit.SI); }
            public ElectricalCharge.Rel multiplyBy(final ElectricalCharge.Rel v) { return new ElectricalCharge.Rel(this.si * v.si, ElectricalChargeUnit.SI); }
            public ElectricalCurrent.Rel multiplyBy(final ElectricalCurrent.Rel v) { return new ElectricalCurrent.Rel(this.si * v.si, ElectricalCurrentUnit.SI); }
            public ElectricalPotential.Rel multiplyBy(final ElectricalPotential.Rel v) { return new ElectricalPotential.Rel(this.si * v.si, ElectricalPotentialUnit.SI); }
            public ElectricalResistance.Rel multiplyBy(final ElectricalResistance.Rel v) { return new ElectricalResistance.Rel(this.si * v.si, ElectricalResistanceUnit.SI); }
            public Energy.Rel multiplyBy(final Energy.Rel v) { return new Energy.Rel(this.si * v.si, EnergyUnit.SI); }
            public FlowMass.Rel multiplyBy(final FlowMass.Rel v) { return new FlowMass.Rel(this.si * v.si, FlowMassUnit.SI); }
            public FlowVolume.Rel multiplyBy(final FlowVolume.Rel v) { return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI); }
            public Force.Rel multiplyBy(final Force.Rel v) { return new Force.Rel(this.si * v.si, ForceUnit.SI); }
            public Frequency.Rel multiplyBy(final Frequency.Rel v) { return new Frequency.Rel(this.si * v.si, FrequencyUnit.SI); }
            public Length.Rel multiplyBy(final Length.Rel v) { return new Length.Rel(this.si * v.si, LengthUnit.SI); }
            public LinearDensity.Rel multiplyBy(final LinearDensity.Rel v) { return new LinearDensity.Rel(this.si * v.si, LinearDensityUnit.SI); }
            public Mass.Rel multiplyBy(final Mass.Rel v) { return new Mass.Rel(this.si * v.si, MassUnit.SI); }
            public Power.Rel multiplyBy(final Power.Rel v) { return new Power.Rel(this.si * v.si, PowerUnit.SI); }
            public Pressure.Rel multiplyBy(final Pressure.Rel v) { return new Pressure.Rel(this.si * v.si, PressureUnit.SI); }
            public Speed.Rel multiplyBy(final Speed.Rel v) { return new Speed.Rel(this.si * v.si, SpeedUnit.SI); }
            public Temperature.Rel multiplyBy(final Temperature.Rel v) { return new Temperature.Rel(this.si * v.si, TemperatureUnit.SI); }
            public Time.Rel multiplyBy(final Time.Rel v) { return new Time.Rel(this.si * v.si, TimeUnit.SI); }
            public Torque.Rel multiplyBy(final Torque.Rel v) { return new Torque.Rel(this.si * v.si, TorqueUnit.SI); }
            public Volume.Rel multiplyBy(final Volume.Rel v) { return new Volume.Rel(this.si * v.si, VolumeUnit.SI); }

            public Dimensionless.Rel divideBy(final Dimensionless.Rel v) { return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI); }
            public Frequency.Rel divideBy(final Time.Rel v) { return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI); }
            public Time.Rel divideBy(final Frequency.Rel v) { return new Time.Rel(this.si / v.si, TimeUnit.SI); }
            public Length.Rel divideBy(final LinearDensity.Rel v) { return new Length.Rel(this.si / v.si, LengthUnit.SI); }
            public LinearDensity.Rel divideBy(final Length.Rel v) { return new LinearDensity.Rel(this.si / v.si, LinearDensityUnit.SI); }
        }
        
        public static class Abs extends FloatScalar.Abs<DimensionlessUnit>
        {
            public Abs(final float value, final DimensionlessUnit unit) { super(value, unit); }
            public Abs(final org.djunits.value.vfloat.scalar.FloatScalar.Abs<DimensionlessUnit> value) { super(value); }
            public Dimensionless.Abs abs()    { return new Dimensionless.Abs(Math.abs(getInUnit()), getUnit()); }
            public Dimensionless.Abs acos()   { return new Dimensionless.Abs((float) Math.acos(getInUnit()), getUnit()); }
            public Dimensionless.Abs asin()   { return new Dimensionless.Abs((float) Math.asin(getInUnit()), getUnit()); }
            public Dimensionless.Abs atan()   { return new Dimensionless.Abs((float) Math.atan(getInUnit()), getUnit()); }
            public Dimensionless.Abs cbrt()   { return new Dimensionless.Abs((float) Math.cbrt(getInUnit()), getUnit()); }
            public Dimensionless.Abs ceil()   { return new Dimensionless.Abs((float) Math.ceil(getInUnit()), getUnit()); }
            public Dimensionless.Abs cos()    { return new Dimensionless.Abs((float) Math.cos(getInUnit()), getUnit()); }
            public Dimensionless.Abs cosh()   { return new Dimensionless.Abs((float) Math.cosh(getInUnit()), getUnit()); }
            public Dimensionless.Abs exp()    { return new Dimensionless.Abs((float) Math.exp(getInUnit()), getUnit()); }
            public Dimensionless.Abs expm1()  { return new Dimensionless.Abs((float) Math.expm1(getInUnit()), getUnit()); }
            public Dimensionless.Abs floor()  { return new Dimensionless.Abs((float) Math.floor(getInUnit()), getUnit()); }
            public Dimensionless.Abs log()    { return new Dimensionless.Abs((float) Math.log(getInUnit()), getUnit()); }
            public Dimensionless.Abs log10()  { return new Dimensionless.Abs((float) Math.log10(getInUnit()), getUnit()); }
            public Dimensionless.Abs log1p()  { return new Dimensionless.Abs((float) Math.log1p(getInUnit()), getUnit()); }
            public Dimensionless.Abs rint()   { return new Dimensionless.Abs((float) Math.rint(getInUnit()), getUnit()); }
            public Dimensionless.Abs round()  { return new Dimensionless.Abs(Math.round(getInUnit()), getUnit()); }
            public Dimensionless.Abs signum() { return new Dimensionless.Abs(Math.signum(getInUnit()), getUnit()); }
            public Dimensionless.Abs sin()    { return new Dimensionless.Abs((float) Math.sin(getInUnit()), getUnit()); }
            public Dimensionless.Abs sinh()   { return new Dimensionless.Abs((float) Math.sinh(getInUnit()), getUnit()); }
            public Dimensionless.Abs sqrt()   { return new Dimensionless.Abs((float) Math.sqrt(getInUnit()), getUnit()); }
            public Dimensionless.Abs tan()    { return new Dimensionless.Abs((float) Math.tan(getInUnit()), getUnit()); }
            public Dimensionless.Abs tanh()   { return new Dimensionless.Abs((float) Math.tanh(getInUnit()), getUnit()); }
            public Dimensionless.Abs inv()    { return new Dimensionless.Abs(1.0f / getInUnit(), getUnit()); }
            public Dimensionless.Abs toDegrees() { return new Dimensionless.Abs((float) Math.toDegrees(getInUnit()), getUnit()); }
            public Dimensionless.Abs toRadians() { return new Dimensionless.Abs((float) Math.toRadians(getInUnit()), getUnit()); }
            public Dimensionless.Abs pow(final float x) { return new Dimensionless.Abs((float) Math.pow(getInUnit(), x), getUnit()); }
            
            public Dimensionless.Abs multiplyBy(final float factor) { return new Dimensionless.Abs(getInUnit() * factor, getUnit()); }
            public Dimensionless.Abs divideBy(final float divisor)  { return new Dimensionless.Abs(getInUnit() / divisor, getUnit()); }
            
            public Dimensionless.Abs plus(final Dimensionless.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Dimensionless.Abs(getInUnit() + v.getInUnit(), getUnit()) 
                    : new Dimensionless.Abs(this.si + v.si, DimensionlessUnit.SI); } 

            public Dimensionless.Rel minus(final Dimensionless.Abs v) {  
                return getUnit().equals(v.getUnit()) ? new Dimensionless.Rel(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Dimensionless.Rel(this.si - v.si, DimensionlessUnit.SI); } 

            public Dimensionless.Abs minus(final Dimensionless.Rel v) {  
                return getUnit().equals(v.getUnit()) ? new Dimensionless.Abs(getInUnit() - v.getInUnit(), getUnit()) 
                    : new Dimensionless.Abs(this.si - v.si, DimensionlessUnit.SI); } 

            public Acceleration.Abs multiplyBy(final Acceleration.Abs v) { return new Acceleration.Abs(this.si * v.si, AccelerationUnit.SI); }
            public AnglePlane.Abs multiplyBy(final AnglePlane.Abs v) { return new AnglePlane.Abs(this.si * v.si, AnglePlaneUnit.SI); }
            public AngleSlope.Abs multiplyBy(final AngleSlope.Abs v) { return new AngleSlope.Abs(this.si * v.si, AngleSlopeUnit.SI); }
            public AngleSolid.Abs multiplyBy(final AngleSolid.Abs v) { return new AngleSolid.Abs(this.si * v.si, AngleSolidUnit.SI); }
            public Area.Abs multiplyBy(final Area.Abs v) { return new Area.Abs(this.si * v.si, AreaUnit.SI); }
            public Density.Abs multiplyBy(final Density.Abs v) { return new Density.Abs(this.si * v.si, DensityUnit.SI); }
            public Dimensionless.Abs multiplyBy(final Dimensionless.Abs v) { return new Dimensionless.Abs(this.si * v.si, DimensionlessUnit.SI); }
            public ElectricalCharge.Abs multiplyBy(final ElectricalCharge.Abs v) { return new ElectricalCharge.Abs(this.si * v.si, ElectricalChargeUnit.SI); }
            public ElectricalCurrent.Abs multiplyBy(final ElectricalCurrent.Abs v) { return new ElectricalCurrent.Abs(this.si * v.si, ElectricalCurrentUnit.SI); }
            public ElectricalPotential.Abs multiplyBy(final ElectricalPotential.Abs v) { return new ElectricalPotential.Abs(this.si * v.si, ElectricalPotentialUnit.SI); }
            public ElectricalResistance.Abs multiplyBy(final ElectricalResistance.Abs v) { return new ElectricalResistance.Abs(this.si * v.si, ElectricalResistanceUnit.SI); }
            public Energy.Abs multiplyBy(final Energy.Abs v) { return new Energy.Abs(this.si * v.si, EnergyUnit.SI); }
            public FlowMass.Abs multiplyBy(final FlowMass.Abs v) { return new FlowMass.Abs(this.si * v.si, FlowMassUnit.SI); }
            public FlowVolume.Abs multiplyBy(final FlowVolume.Abs v) { return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI); }
            public Force.Abs multiplyBy(final Force.Abs v) { return new Force.Abs(this.si * v.si, ForceUnit.SI); }
            public Frequency.Abs multiplyBy(final Frequency.Abs v) { return new Frequency.Abs(this.si * v.si, FrequencyUnit.SI); }
            public Length.Abs multiplyBy(final Length.Abs v) { return new Length.Abs(this.si * v.si, LengthUnit.SI); }
            public LinearDensity.Abs multiplyBy(final LinearDensity.Abs v) { return new LinearDensity.Abs(this.si * v.si, LinearDensityUnit.SI); }
            public Mass.Abs multiplyBy(final Mass.Abs v) { return new Mass.Abs(this.si * v.si, MassUnit.SI); }
            public Power.Abs multiplyBy(final Power.Abs v) { return new Power.Abs(this.si * v.si, PowerUnit.SI); }
            public Pressure.Abs multiplyBy(final Pressure.Abs v) { return new Pressure.Abs(this.si * v.si, PressureUnit.SI); }
            public Speed.Abs multiplyBy(final Speed.Abs v) { return new Speed.Abs(this.si * v.si, SpeedUnit.SI); }
            public Temperature.Abs multiplyBy(final Temperature.Abs v) { return new Temperature.Abs(this.si * v.si, TemperatureUnit.SI); }
            public Time.Abs multiplyBy(final Time.Abs v) { return new Time.Abs(this.si * v.si, TimeUnit.SI); }
            public Torque.Abs multiplyBy(final Torque.Abs v) { return new Torque.Abs(this.si * v.si, TorqueUnit.SI); }
            public Volume.Abs multiplyBy(final Volume.Abs v) { return new Volume.Abs(this.si * v.si, VolumeUnit.SI); }

            public Dimensionless.Abs divideBy(final Dimensionless.Abs v) { return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI); }
            public Frequency.Abs divideBy(final Time.Abs v) { return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI); }
            public Time.Abs divideBy(final Frequency.Abs v) { return new Time.Abs(this.si / v.si, TimeUnit.SI); }
            public Length.Abs divideBy(final LinearDensity.Abs v) { return new Length.Abs(this.si / v.si, LengthUnit.SI); }
            public LinearDensity.Abs divideBy(final Length.Abs v) { return new LinearDensity.Abs(this.si / v.si, LinearDensityUnit.SI); }
        }
    }

}

