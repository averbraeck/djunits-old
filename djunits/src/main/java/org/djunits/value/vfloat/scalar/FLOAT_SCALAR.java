package org.djunits.value.vfloat.scalar;

import org.djunits.unit.UNITS;

/**
 * The FLOAT_SCALAR interface provides easy access to all float types in one go. If you extend the interface, all FloatScalar
 * types will be available without the need to import them. This makes quick switching between FloatScalar and FloatScalar
 * possible.
 * <p>
 * Copyright (c) 2013-2014 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
@SuppressWarnings({"checkstyle:javadoctype", "checkstyle:leftcurly", "checkstyle:rightcurly", "javadoc"})
public interface FLOAT_SCALAR extends UNITS
{
    // @formatter:off
    
    public abstract interface Acceleration extends org.djunits.value.vfloat.scalar.Acceleration { /* */} 
    public abstract interface AnglePlane extends org.djunits.value.vfloat.scalar.AnglePlane { /* */} 
    public abstract interface AngleSlope extends org.djunits.value.vfloat.scalar.AngleSlope { /* */} 
    public abstract interface AngleSolid extends org.djunits.value.vfloat.scalar.AngleSolid { /* */} 
    public abstract interface Area extends org.djunits.value.vfloat.scalar.Area { /* */} 
    public abstract interface Density extends org.djunits.value.vfloat.scalar.Density { /* */} 
    public abstract interface Dimensionless extends org.djunits.value.vfloat.scalar.Dimensionless { /* */} 
    public abstract interface ElectricalCharge extends org.djunits.value.vfloat.scalar.ElectricalCharge { /* */} 
    public abstract interface ElectricalCurrent extends org.djunits.value.vfloat.scalar.ElectricalCurrent { /* */} 
    public abstract interface ElectricalPotential extends org.djunits.value.vfloat.scalar.ElectricalPotential { /* */} 
    public abstract interface ElectricalResistance extends org.djunits.value.vfloat.scalar.ElectricalResistance { /* */} 
    public abstract interface Energy extends org.djunits.value.vfloat.scalar.Energy { /* */} 
    public abstract interface FlowMass extends org.djunits.value.vfloat.scalar.FlowMass { /* */} 
    public abstract interface FlowVolume extends org.djunits.value.vfloat.scalar.FlowVolume { /* */} 
    public abstract interface Force extends org.djunits.value.vfloat.scalar.Force { /* */} 
    public abstract interface Frequency extends org.djunits.value.vfloat.scalar.Frequency { /* */} 
    public abstract interface Length extends org.djunits.value.vfloat.scalar.Length { /* */} 
    public abstract interface LinearDensity extends org.djunits.value.vfloat.scalar.LinearDensity { /* */} 
    public abstract interface Mass extends org.djunits.value.vfloat.scalar.Mass { /* */} 
    public abstract interface Power extends org.djunits.value.vfloat.scalar.Power { /* */} 
    public abstract interface Pressure extends org.djunits.value.vfloat.scalar.Pressure { /* */} 
    public abstract interface Speed extends org.djunits.value.vfloat.scalar.Speed { /* */} 
    public abstract interface Temperature extends org.djunits.value.vfloat.scalar.Temperature { /* */} 
    public abstract interface Time extends org.djunits.value.vfloat.scalar.Time { /* */} 
    public abstract interface Torque extends org.djunits.value.vfloat.scalar.Torque { /* */} 
    public abstract interface Volume extends org.djunits.value.vfloat.scalar.Volume { /* */}  
}
