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
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public final class UnitTypes implements Serializable
{
    /** */
    private static final long serialVersionUID = 20190818L;

    /** The one instance. */
    public static final UnitTypes INSTANCE = new UnitTypes();

    /** The SI registry of the units. */
    private Map<SIDimensions, Set<UnitBase<?>>> siRegistry = new LinkedHashMap<>();

    /** The name registry of the units. */
    private Map<String, UnitBase<?>> registry = new LinkedHashMap<>();

    /**
     * Only called once to initialize a static final field.
     */
    private UnitTypes()
    {
        //
    }

    /**
     * Register the baseUnit in the UnitType registries.
     * @param baseUnit UnitBase&lt;?&gt;; the baseUnit to register.
     */
    public void register(final UnitBase<?> baseUnit)
    {
        this.registry.put(baseUnit.getStandardUnit().getClass().getSimpleName(), baseUnit);
        Set<UnitBase<?>> siSet = this.siRegistry.get(baseUnit.getSiDimensions());
        if (siSet == null)
        {
            siSet = new LinkedHashSet<>();
            this.siRegistry.put(baseUnit.getSiDimensions(), siSet);
        }
        siSet.add(baseUnit);
    }

    /**
     * Unregister the baseUnit in the UnitType registries.
     * @param baseUnit UnitBase&lt;?&gt;; the baseUnit to register.
     */
    public void unregister(final UnitBase<?> baseUnit)
    {
        if (baseUnit.getStandardUnit() != null)
        {
            this.registry.remove(baseUnit.getStandardUnit().getClass().getSimpleName());
        }
    }

    /**
     * Retrieve a safe copy of the baseUnit set registered for an SI fingerprint.
     * @param siDimensions SIDimensions; the SI dimensions to search for
     * @return a safe copy of the baseUnit set registered for this SI dimensions fingerprint
     */
    public Set<UnitBase<?>> getUnitBases(final SIDimensions siDimensions)
    {
        Set<UnitBase<?>> baseUnitsSet = new LinkedHashSet<>();
        if (this.siRegistry.containsKey(siDimensions))
        {
            baseUnitsSet.addAll(this.siRegistry.get(siDimensions));
        }
        return baseUnitsSet;
    }

    /**
     * Return the UnitBase for a given name of a unit class, or null if it has not been registered.
     * @param unitClassName String; the unit class name to search for, e.g., "LengthUnit"
     * @return UnitBase; the unitBase belonging to the class, or null if not found
     */
    public UnitBase<?> getUnitBase(final String unitClassName)
    {
        return this.registry.get(unitClassName);
    }

    @Override
    public String toString()
    {
        return "UnitTypes [siRegistry=" + siRegistry + ", registry=" + registry + "]";
    }

}
