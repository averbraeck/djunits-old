package org.djunits4.unit;

import java.util.Set;

import org.djunits4.Throw;
import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIDimensions;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * SIUnit describes a unit with arbitrary SI dimensions for which no predefined unit exists.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIUnit extends Unit<SIUnit>
{
    /** */
    private static final long serialVersionUID = 20190829L;

    /**
     * Create or lookup a unit based on given SI dimensions. E.g., a unit with dimensions 1/s^2 or kg.m/s^2.
     * @param siDimensions the vector with the dimensionality of the unit
     * @return SIUnit; an SIUnit object with the right dimensions
     */
    @SuppressWarnings("unchecked")
    public static SIUnit lookupOrCreateUnitWithSIDimensions(final SIDimensions siDimensions)
    {
        Throw.whenNull(siDimensions, "siDimensions cannot be null");

        BaseUnit<SIUnit> baseUnit = null;
        SIUnit unit = null;

        Set<BaseUnit<?>> baseUnitSet = UnitTypes.INSTANCE.getBaseUnits(siDimensions);
        for (BaseUnit<?> bu : baseUnitSet)
        {
            if (bu.getStandardUnit() instanceof SIUnit)
            {
                baseUnit = (BaseUnit<SIUnit>) bu;
            }
        }

        if (baseUnit == null)
        {
            baseUnit = new BaseUnit<SIUnit>(siDimensions);
            Builder<SIUnit> builder = new Builder<>();
            builder.setId(siDimensions.toString());
            builder.setName(siDimensions.toString());
            builder.setBaseUnit(baseUnit);
            builder.setScale(new IdentityScale());
            builder.setGenerated(true);
            builder.setUnitSystem(UnitSystem.SI_DERIVED);
            builder.setSiPrefixes(SIPrefixes.NONE);
            unit = new SIUnit();
            unit.build(builder); // it will be registered at the BaseUnit
        }
        else
        {
            unit = baseUnit.getStandardUnit();
        }

        return unit;
    }
    
}
