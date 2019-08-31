package org.djunits4.value;

/**
 * CLASSNAMES.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class CLASSNAMES
{
    /** The classes that are absolute/relative (name = class name). Do not check Dimensionless. */
    public static final String[] ALL_NODIM = new String[] {"AbsoluteTemperature", "Direction", "Position", "Time",
            "Temperature", "Angle", "Length", "Duration", "AbsorbedDose", "Acceleration", "AmountOfSubstance", "AngleSolid",
            "Area", "CatalyticActivity", "Density", "Dimensionless", "ElectricalCapacitance", "ElectricalCharge",
            "ElectricalConductance", "ElectricalCurrent", "ElectricalInductance", "ElectricalPotential", "ElectricalResistance",
            "Energy", "EquivalentDose", "FlowMass", "FlowVolume", "Force", "Frequency", "Illuminance", "LinearDensity",
            "LuminousFlux", "LuminousIntensity", "MagneticFluxDensity", "MagneticFlux", "Mass", "Power", "Pressure",
            "RadioActivity", "Speed", "Torque", "Volume"};

    /** The classes that are absolute (name = class name). */
    public static final String[] ABS = new String[] {"AbsoluteTemperature", "Direction", "Position", "Time"};

    /** The relative classes that mirror the absolute ones (name = class name). */
    public static final String[] ABS_REL = new String[] {"Temperature", "Angle", "Length", "Duration"};

    /** The classes that are just relative (name = class name). */
    public static final String[] REL = new String[] {"Temperature", "Angle", "Length", "Duration", "AbsorbedDose",
            "Acceleration", "AmountOfSubstance", "AngleSolid", "Area", "CatalyticActivity", "Density", "Dimensionless",
            "ElectricalCapacitance", "ElectricalCharge", "ElectricalConductance", "ElectricalCurrent", "ElectricalInductance",
            "ElectricalPotential", "ElectricalResistance", "Energy", "EquivalentDose", "FlowMass", "FlowVolume", "Force",
            "Frequency", "Illuminance", "LinearDensity", "LuminousFlux", "LuminousIntensity", "MagneticFluxDensity",
            "MagneticFlux", "Mass", "Power", "Pressure", "RadioActivity", "Speed", "Torque", "Volume"};
}
