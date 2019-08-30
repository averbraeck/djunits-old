package org.djunits4.unit.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.djunits4.Throw;
import org.djunits4.unit.Unit;
import org.djunits4.unit.UnitException;
import org.djunits4.unit.UnitRuntimeException;
import org.djunits4.unit.si.SIDimensions;
import org.djunits4.unit.si.SIPrefix;
import org.djunits4.unit.si.SIPrefixes;

/**
 * BaseUnit is an extension of Unit that contains a map of all registered units belonging to this base unit. It also contains
 * the SI 'fingerprint' of the unit. The fingerprint is registered in the UnitTypes singleton where are unit types are
 * registered.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit to reference the actual unit in return values
 */
public class BaseUnit<U extends Unit<U>> implements Serializable
{
    /** */
    private static final long serialVersionUID = 20190818L;

    /**
     * The SI dimensions of the unit. Also filled for e.g., imperial values with a conversion factor to an SIDimensions. When a
     * value has no SI dimensions, all 9 dimensions can be set to zero.
     */
    private final SIDimensions siDimensions;

    /** Derived units for this base unit, retrievable by id. The key is the unit id (e.g., "m"). */
    private final Map<String, U> unitsById = new LinkedHashMap<String, U>();

    /** Derived units for this base unit, retrievable by abbreviation. The key is the unit abbreviation (e.g., "kWh"). */
    private final Map<String, U> unitsByAbbreviation = new LinkedHashMap<String, U>();

    /** The standard unit belonging to this base unit. The first unit that gets registered is considered to be standard. */
    private U standardUnit = null;

    /**
     * Create a base unit with the SI dimensions.
     * @param siDimensions the 9 dimensions of the unit, wrapped in an SIDimensions object
     * @throws NullPointerException when one of the arguments is null
     */
    public BaseUnit(final SIDimensions siDimensions)
    {
        Throw.whenNull(siDimensions, "siDimensions cannot be null");
        this.siDimensions = siDimensions;
        UnitTypes.INSTANCE.register(this);
    }

    /**
     * Create a base unit with the SI dimensions as a String.
     * @param siString the 9 dimensions of the unit, represented as an SI string
     * @throws UnitRuntimeException when the String cannot be translated into an SIDimensions object
     * @throws NullPointerException when one of the arguments is null
     */
    public BaseUnit(final String siString) throws UnitRuntimeException
    {
        Throw.whenNull(siString, "siString cannot be null");
        try
        {
            this.siDimensions = SIDimensions.of(siString);
        }
        catch (UnitException exception)
        {
            throw new UnitRuntimeException(exception);
        }
        UnitTypes.INSTANCE.register(this);
    }

    /**
     * Create a base unit with the SI dimensions, provided as a byte array.
     * @param siSignature the 9 dimensions of the unit
     * @throws NullPointerException when one of the arguments is null
     */
    public BaseUnit(final byte[] siSignature)
    {
        Throw.whenNull(siSignature, "siSignature cannot be null");
        this.siDimensions = new SIDimensions(siSignature);
        UnitTypes.INSTANCE.register(this);
    }

    /**
     * Register the unit in the map. If the unit supports SI prefixes from yocto to yotta, 20 additional abbreviations are
     * registered. When there is both a unit with an "SI prefix" and a separately registered unit, the most specific
     * specification will be registered in the map. As an example, when the LengthUnit "METER" is registered, all 20 units such
     * as the millimeter and the kilometer are registered as well. When earlier or later the "KILOMETER" is created as a
     * separate unit, the "km" lookup will result in the "KILOMETER" registration rather than in the "METER" registration with a
     * factor of 1000.
     * @param unit the unit to register in the map.
     * @param siPrefixes SIPrefixes; indicates whether and which SI prefixes should be generated.
     */
    public void registerUnit(final U unit, final SIPrefixes siPrefixes)
    {
        Throw.whenNull(unit, "unit cannot be null");
        if (this.standardUnit == null)
        {
            this.standardUnit = unit; // The first unit that gets registered is considered to be standard
        }
        if (siPrefixes.equals(SIPrefixes.UNIT))
        {
            for (SIPrefix siPrefix : SIPrefixes.UNIT_PREFIXES.values())
            {
                unit.deriveSI(siPrefix, true); // true = automatically generated
                // the unit will register itself as a generated unit
            }
        }
        else if (siPrefixes.equals(SIPrefixes.KILO))
        {
            for (SIPrefix siPrefix : SIPrefixes.KILO_PREFIXES.values())
            {
                unit.deriveSIKilo(siPrefix, true); // true = automatically generated
            }
        }

        // register the (generated) unit
        if (this.unitsById.containsKey(unit.getId()))
        {
            // if both are generated or both are not generated, give an error
            if (this.unitsById.get(unit.getId()).isGenerated() == unit.isGenerated())
            {
                throw new UnitRuntimeException("A unit with id " + unit.getId() + " has already been registered for unit type "
                        + unit.getClass().getSimpleName());
            }
            else
            {
                if (!unit.isGenerated())
                {
                    // if the new unit is explicit, register and overwrite the existing one
                    this.unitsById.put(unit.getId(), unit);
                }
                // otherwise, the new unit is generated, and the existing one was explicit: ignore the generated one
            }
        }
        else
        {
            // not registered yet
            this.unitsById.put(unit.getId(), unit);
        }

        // register the abbreviation(s) of the (generated) unit
        for (String abbreviation : unit.getAbbreviations())
        {
            if (this.unitsByAbbreviation.containsKey(abbreviation))
            {
                // if both are generated or both are not generated, give an error
                if (getUnitByAbbreviation(abbreviation).isGenerated() == unit.isGenerated())
                {
                    throw new UnitRuntimeException("A unit with abbreviation " + abbreviation
                            + " has already been registered for unit type " + unit.getClass().getSimpleName());
                }
                else
                {
                    if (!unit.isGenerated())
                    {
                        // overwrite the automatically generated unit with the explicit one
                        this.unitsByAbbreviation.put(abbreviation, unit);
                    }
                    // otherwise, the new unit is generated, and the existing one was explicit: ignore the generated one
                }
            }
            else
            {
                // not registered yet
                this.unitsByAbbreviation.put(abbreviation, unit);
            }
        }
    }

    /**
     * Unregister a unit from the registry, e.g. after a Unit test, or to insert a replacement for an already existing unit.
     * @param unit U; the unit to unregister.
     */
    public void unregister(final U unit)
    {
        Throw.whenNull(unit, "null unit cannot be removed from the unit registry");
        if (this.unitsById.containsValue(unit))
        {
            this.unitsById.remove(unit.getId(), unit);
        }
        for (String abbreviation : unit.getAbbreviations())
        {
            if (this.unitsByAbbreviation.containsKey(abbreviation))
            {
                if (unit.equals(this.unitsByAbbreviation.get(abbreviation)))
                {
                    this.unitsByAbbreviation.remove(abbreviation, unit);
                }
            }
        }
    }

    /**
     * @return the siDimensions
     */
    public SIDimensions getSiDimensions()
    {
        return this.siDimensions;
    }

    /**
     * Retrieve a unit by Id.
     * @param id String; the id to look up
     * @return the corresponding unit or null when it was not found
     */
    public U getUnitById(final String id)
    {
        return this.unitsById.get(id);
    }

    /**
     * Retrieve a unit by one of its abbreviations.
     * @param abbreviation String; the abbreviation to look up
     * @return the corresponding unit or null when it was not found
     */
    public U getUnitByAbbreviation(final String abbreviation)
    {
        return this.unitsByAbbreviation.get(abbreviation);
    }

    /**
     * Retrieve a unit by one of its abbreviations.
     * @param abbreviation String; the abbreviation to look up
     * @return the corresponding unit or null when it was not found
     */
    public U of(final String abbreviation)
    {
        return this.unitsByAbbreviation.get(abbreviation);
    }

    /**
     * @return a safe copy of the registryById
     */
    public Map<String, U> getUnitsById()
    {
        return new LinkedHashMap<>(this.unitsById);
    }

    /**
     * @return a safe copy of the registryByAbbreviation
     */
    public Map<String, U> getUnitsByAbbreviation()
    {
        return new LinkedHashMap<>(this.unitsByAbbreviation);
    }

    /**
     * @return U; the standardUnit for this base unit, usually the first registered unit.
     */
    public U getStandardUnit()
    {
        return this.standardUnit;
    }
}
