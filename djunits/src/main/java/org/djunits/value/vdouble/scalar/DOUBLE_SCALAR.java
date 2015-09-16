package org.djunits.value.vdouble.scalar;

import org.djunits.unit.UNITS;

/**
 * The DOUBLE_SCALAR interface provides easy access to all double types in one go. If you extend the interface, all DoubleScalar
 * types will be available without the need to import them. This makes quick switching between FloatScalar and DoubleScalar
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
@SuppressWarnings({ "checkstyle:javadoctype", "checkstyle:leftcurly", "checkstyle:rightcurly", "javadoc" })
public interface DOUBLE_SCALAR extends UNITS
{
    // @formatter:off
    
    public interface Acceleration extends org.djunits.value.vdouble.scalar.Acceleration { /* */} 
    public interface AnglePlane extends org.djunits.value.vdouble.scalar.AnglePlane { /* */} 
    public interface AngleSlope extends org.djunits.value.vdouble.scalar.AngleSlope { /* */} 
    public interface AngleSolid extends org.djunits.value.vdouble.scalar.AngleSolid { /* */} 
    public interface Area extends org.djunits.value.vdouble.scalar.Area { /* */} 
    public interface Density extends org.djunits.value.vdouble.scalar.Density { /* */} 
    public interface Dimensionless extends org.djunits.value.vdouble.scalar.Dimensionless { /* */} 
    public interface ElectricalCharge extends org.djunits.value.vdouble.scalar.ElectricalCharge { /* */} 
    public interface ElectricalCurrent extends org.djunits.value.vdouble.scalar.ElectricalCurrent { /* */} 
    public interface ElectricalPotential extends org.djunits.value.vdouble.scalar.ElectricalPotential { /* */} 
    public interface ElectricalResistance extends org.djunits.value.vdouble.scalar.ElectricalResistance { /* */} 
    public interface Energy extends org.djunits.value.vdouble.scalar.Energy { /* */} 
    public interface FlowMass extends org.djunits.value.vdouble.scalar.FlowMass { /* */} 
    public interface FlowVolume extends org.djunits.value.vdouble.scalar.FlowVolume { /* */} 
    public interface Force extends org.djunits.value.vdouble.scalar.Force { /* */} 
    public interface Frequency extends org.djunits.value.vdouble.scalar.Frequency { /* */} 
    public interface Length extends org.djunits.value.vdouble.scalar.Length { /* */} 
    public interface LinearDensity extends org.djunits.value.vdouble.scalar.LinearDensity { /* */} 
    public interface Mass extends org.djunits.value.vdouble.scalar.Mass { /* */} 
    public interface Power extends org.djunits.value.vdouble.scalar.Power { /* */} 
    public interface Pressure extends org.djunits.value.vdouble.scalar.Pressure { /* */} 
    public interface Speed extends org.djunits.value.vdouble.scalar.Speed { /* */} 
    public interface Temperature extends org.djunits.value.vdouble.scalar.Temperature { /* */} 
    public interface Time extends org.djunits.value.vdouble.scalar.Time { /* */} 
    public interface Torque extends org.djunits.value.vdouble.scalar.Torque { /* */} 
    public interface Volume extends org.djunits.value.vdouble.scalar.Volume { /* */}  
}
