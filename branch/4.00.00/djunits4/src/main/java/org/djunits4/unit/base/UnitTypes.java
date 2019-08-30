package org.djunits4.unit.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.djunits4.unit.si.SIDimensions;

/**
 * UnitTypes is a singleton where the BaseUnit SIDimensions 'fingerprints' are stored and mapped to the BaseUnits. It is
 * possible that more baseUnits have the same fingerprint. E.g., Energy and Torque.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public final class UnitTypes implements Serializable
{
    /** */
    private static final long serialVersionUID = 20190818L;

    /** the one instance. */
    public static final UnitTypes INSTANCE = new UnitTypes();

    /** the SI registry of the units. */
    private Map<SIDimensions, Set<BaseUnit<?>>> siRegistry = new LinkedHashMap<>();

    /** the name registry of the units. */
    private Map<String, BaseUnit<?>> registry = new LinkedHashMap<>();

    /** Only call once from a static field. */
    private UnitTypes()
    {
        //
    }

    /**
     * Register the baseUnit in the UnitType registries.
     * @param baseUnit the baseUnit to register.
     */
    public void register(final BaseUnit<?> baseUnit)
    {
        this.registry.put(baseUnit.getClass().getSimpleName(), baseUnit);
        Set<BaseUnit<?>> siSet = this.siRegistry.get(baseUnit.getSiDimensions());
        if (siSet == null)
        {
            siSet = new LinkedHashSet<>();
            this.siRegistry.put(baseUnit.getSiDimensions(), siSet);
        }
        siSet.add(baseUnit);
    }

    /**
     * Retrieve a safe copy of the baseUnit set registered for an SI fingerprint.
     * @param siDimensions the SI dimensions to search for
     * @return a safe copy of the baseUnit set registered for this SI dimensions fingerprint
     */
    public Set<BaseUnit<?>> getBaseUnits(final SIDimensions siDimensions)
    {
        Set<BaseUnit<?>> baseUnitsSet = new LinkedHashSet<>();
        if (this.siRegistry.containsKey(siDimensions))
        {
            baseUnitsSet.addAll(this.siRegistry.get(siDimensions));
        }
        return baseUnitsSet;
    }

}
