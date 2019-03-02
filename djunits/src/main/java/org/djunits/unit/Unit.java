package org.djunits.unit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.djunits.locale.Localization;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.scale.StandardScale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * All units are internally <i>stored</i> relative to a standard unit with conversion factor. This means that e.g., a meter is
 * stored with conversion factor 1.0, whereas kilometer is stored with a conversion factor 1000.0. This means that if we want to
 * express a length meter in kilometers, we have to <i>divide</i> by the conversion factor.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @param <U> the unit for transformation reasons
 */
public abstract class Unit<U extends Unit<U>> implements Serializable
{
    /** */
    private static final long serialVersionUID = 20140607;

    /** The key to the locale file for the abbreviation of the unit, or null when it is a user-defined unit. */
    private final String abbreviationKey;

    /**
     * The long name of the unit in case it does not exist in the locale file, e.g. when defining a run-time unit. The name will
     * be null if the locale has to be used, i.e. for standard units.
     */
    private final String name;

    /**
     * The abbreviation of the unit in case it does not exist in the locale file, e.g. when defining a run-time unit. The
     * abbreviation will be null if the locale has to be used, i.e. for standard units.
     */
    private final String abbreviation;

    /** The unit system, e.g. SI or Imperial. */
    private final UnitSystem unitSystem;

    /** The scale to use to convert between this unit and the standard (e.g., SI) unit. */
    private final Scale scale;

    /** SI unit information. */
    private SICoefficients siCoefficients;

    /** A static map of all defined coefficient strings, to avoid double creation and allow lookup. */
    private static final Map<String, SICoefficients> SI_COEFFICIENTS = new HashMap<String, SICoefficients>();

    /** A static map of all defined coefficient strings, mapped to the existing units. */
    private static final Map<String, Map<Class<Unit<?>>, Unit<?>>> SI_UNITS =
            new HashMap<String, Map<Class<Unit<?>>, Unit<?>>>();

    /** A static map of all defined units. */
    private static final Map<String, Set<Unit<?>>> UNITS = new HashMap<String, Set<Unit<?>>>();

    /** Has this class been initialized? */
    private static boolean standardUnitsInitialized = false;

    /** Standard (SI) unit or not? */
    private boolean baseSIUnit;

    /** The array of the names of the standard units. */
    public static final String[] STANDARD_UNITS = new String[] {"AbsoluteTemperatureUnit", "AccelerationUnit", "AngleSolidUnit",
            "AngleUnit", "AreaUnit", "DensityUnit", "DimensionlessUnit", "DirectionUnit", "DurationUnit",
            "ElectricalChargeUnit", "ElectricalCurrentUnit", "ElectricalPotentialUnit", "ElectricalResistanceUnit",
            "EnergyUnit", "FlowMassUnit", "FlowVolumeUnit", "ForceUnit", "FrequencyUnit", "LengthUnit", "LinearDensityUnit",
            "MassUnit", "MoneyUnit", "MoneyPerAreaUnit", "MoneyPerEnergyUnit", "MoneyPerLengthUnit", "MoneyPerMassUnit",
            "MoneyPerDurationUnit", "MoneyPerVolumeUnit", "PositionUnit", "PowerUnit", "PressureUnit", "SpeedUnit",
            "TemperatureUnit", "TimeUnit", "TorqueUnit", "VolumeUnit"};

    /** the cached hashcode. */
    private final int cachedHashCode;

    /** The default locale. */
    private static Localization localization = new Localization("localeunit");

    /** The cached default locale information. */
    private String[] cachedDefaultLocaleInfo;

    /**
     * Force all units to be loaded so we can use static lookup functions for the standard units.
     */
    private static void initializeStandardUnits()
    {
        for (String className : STANDARD_UNITS)
        {
            try
            {
                Class.forName("org.djunits.unit." + className);
            }
            catch (Exception exception)
            {
                // TODO professional logging of errors
                System.err.println("Could not load class org.djunits.unit." + className);
            }
        }
        standardUnitsInitialized = true;
    }

    /**
     * Build a standard unit and create the fields for that unit. For a standard unit, a UnitException is silently ignored.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    protected Unit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        this.scale = StandardScale.SCALE;
        this.baseSIUnit = true;
        this.abbreviationKey = abbreviationKey;
        this.name = null;
        this.abbreviation = null;
        this.cachedDefaultLocaleInfo = localization.getDefaultString(this.abbreviationKey).split("\\|");
        this.unitSystem = unitSystem;
        this.cachedHashCode = generateHashCode();
        try
        {
            addUnit(this);
        }
        catch (UnitException ue)
        {
            // silently ignore.
        }
    }

    /**
     * Build a standard unit with a specific conversion scale to/from the standard unit. For a standard unit, a UnitException is
     * silently ignored.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit, otherwise the abbreviation
     *            itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scale Scale; the conversion scale to use for this unit
     */
    protected Unit(final String abbreviationKey, final UnitSystem unitSystem, final Scale scale)
    {
        this.scale = scale;
        this.baseSIUnit = scale.isBaseSIScale();
        this.abbreviationKey = abbreviationKey;
        this.name = null;
        this.abbreviation = null;
        this.cachedDefaultLocaleInfo = localization.getDefaultString(this.abbreviationKey).split("\\|");
        this.unitSystem = unitSystem;
        this.cachedHashCode = generateHashCode();
        try
        {
            addUnit(this);
        }
        catch (UnitException ue)
        {
            // silently ignore
        }
    }

    /**
     * Build a user-defined unit and create the fields for that unit. This unit is a user-defined unit where the localization
     * files do not have an entry. A UnitException is thrown as a RunTimeException.
     * @param name String; the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit, otherwise the abbreviation
     *            itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    protected Unit(final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        this.scale = StandardScale.SCALE;
        this.baseSIUnit = true;
        this.abbreviationKey = null;
        this.name = name;
        this.abbreviation = abbreviation;
        this.unitSystem = unitSystem;
        this.cachedHashCode = generateHashCode();
        try
        {
            addUnit(this);
        }
        catch (UnitException ue)
        {
            throw new RuntimeException(ue);
        }
    }

    /**
     * Build a user-defined unit with a specific conversion scale to/from the standard unit. This unit is a user-defined unit
     * where the localization files do not have an entry. A UnitException is thrown as a RunTimeException.
     * @param name String; the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit, otherwise the abbreviation
     *            itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param scale Scale; the conversion scale to use for this unit
     */
    protected Unit(final String name, final String abbreviation, final UnitSystem unitSystem, final Scale scale)
    {
        this.scale = scale;
        this.baseSIUnit = scale.isBaseSIScale();
        this.abbreviationKey = null;
        this.name = name;
        this.abbreviation = abbreviation;
        this.unitSystem = unitSystem;
        this.cachedHashCode = generateHashCode();
        try
        {
            addUnit(this);
        }
        catch (UnitException ue)
        {
            throw new RuntimeException(ue);
        }
    }

    /**
     * Report if this unit support localization.
     * @return boolean; true if this unit supports localization; false if it does not
     */
    public final boolean isLocalizable()
    {
        return this.abbreviationKey != null;
    }

    /**
     * Add a unit to the overview collection of existing units, and resolve the coefficients.
     * @param unit Unit&lt;U&gt;; the unit to add. It will be stored in a set belonging to the simple class name String, e.g.
     *            "ForceUnit".
     * @throws UnitException when parsing or normalizing the SI coefficient string fails.
     */
    private void addUnit(final Unit<U> unit) throws UnitException
    {
        if (!UNITS.containsKey(unit.getClass().getSimpleName()))
        {
            UNITS.put(unit.getClass().getSimpleName(), new HashSet<Unit<?>>());
        }
        UNITS.get(unit.getClass().getSimpleName()).add(unit);

        // resolve the SI coefficients, and normalize string
        String siCoefficientsString = SICoefficients.normalize(getSICoefficientsString()).toString();
        if (SI_COEFFICIENTS.containsKey(siCoefficientsString))
        {
            this.siCoefficients = SI_COEFFICIENTS.get(siCoefficientsString);
        }
        else
        {
            this.siCoefficients = new SICoefficients(SICoefficients.parse(siCoefficientsString));
            SI_COEFFICIENTS.put(siCoefficientsString, this.siCoefficients);
        }

        // add the standard unit
        Map<Class<Unit<?>>, Unit<?>> unitMap = SI_UNITS.get(siCoefficientsString);
        if (unitMap == null)
        {
            unitMap = new HashMap<Class<Unit<?>>, Unit<?>>();
            SI_UNITS.put(siCoefficientsString, unitMap);
        }
        if (!unitMap.containsKey(unit.getClass()))
        {
            @SuppressWarnings("unchecked")
            Class<Unit<?>> clazz = (Class<Unit<?>>) unit.getClass();
            if (this.getStandardUnit() == null)
            {
                unitMap.put(clazz, this);
            }
            else
            {
                unitMap.put(clazz, this.getStandardUnit());
            }
        }
    }

    /**
     * Return a set of defined units for a given unit type.
     * @param <V> the unit type to use in this method.
     * @param unitClass Class&lt;V&gt;; the class for which the units are requested, e.g. ForceUnit.class
     * @return the set of defined units belonging to the provided class. The empty set will be returned in case the unit type
     *         does not have any units.
     */
    @SuppressWarnings("unchecked")
    public static <V extends Unit<V>> Set<V> getUnits(final Class<V> unitClass)
    {
        if (!standardUnitsInitialized)
        {
            initializeStandardUnits();
        }
        Set<V> returnSet = new HashSet<V>();
        if (UNITS.containsKey(unitClass.getSimpleName()))
        {
            for (Unit<?> unit : UNITS.get(unitClass.getSimpleName()))
            {
                returnSet.add((V) unit);
            }
        }
        return returnSet;
    }

    /**
     * Return a copy of the set of all defined units for this unit type.
     * @return the set of defined units belonging to this Unit class. The empty set will be returned in case the unit type does
     *         not have any units.
     */
    @SuppressWarnings("unchecked")
    public final Set<Unit<U>> getAllUnitsOfThisType()
    {
        if (!standardUnitsInitialized)
        {
            initializeStandardUnits();
        }
        Set<Unit<U>> returnSet = new HashSet<Unit<U>>();
        if (UNITS.containsKey(this.getClass().getSimpleName()))
        {
            for (Unit<?> unit : UNITS.get(this.getClass().getSimpleName()))
            {
                returnSet.add((Unit<U>) unit);
            }
        }
        return returnSet;
    }

    /**
     * @return name, e.g. meters per second
     */
    public final String getName()
    {
        if (this.name != null)
        {
            return this.name;
        }
        if (localization.isDefault())
        {
            return getDefaultLocaleName();
        }
        String[] loc = localization.getString(this.abbreviationKey).split("\\|");
        if (loc.length >= 2)
        {
            return loc[1].trim();
        }
        if (loc.length >= 1)
        {
            return loc[0].trim();
        }
        return this.abbreviationKey;
    }

    /**
     * @return the name in the default locale, e.g. meters per second
     */
    public final String getDefaultLocaleName()
    {
        if (this.name != null)
        {
            return this.name;
        }
        if (this.cachedDefaultLocaleInfo.length >= 2)
        {
            return this.cachedDefaultLocaleInfo[1].trim();
        }
        if (this.cachedDefaultLocaleInfo.length >= 1)
        {
            return this.cachedDefaultLocaleInfo[0].trim();
        }
        return this.abbreviationKey;
    }

    /**
     * @return abbreviation, e.g., m/s
     */
    public final String getAbbreviation()
    {
        if (this.abbreviation != null)
        {
            return this.abbreviation;
        }
        if (localization.isDefault())
        {
            return getDefaultLocaleAbbreviation();
        }
        String[] loc = localization.getString(this.abbreviationKey).split("\\|");
        if (loc.length >= 1)
        {
            return loc[0].trim();
        }
        return this.abbreviationKey;
    }

    /**
     * @return the abbreviation in the default locale, e.g., m/s
     */
    public final String getDefaultLocaleAbbreviation()
    {
        if (this.abbreviation != null)
        {
            return this.abbreviation;
        }
        if (this.cachedDefaultLocaleInfo.length >= 1)
        {
            return this.cachedDefaultLocaleInfo[0].trim();
        }
        return this.abbreviationKey;
    }

    /**
     * This method returns the abbreviation key, or null in case the abbreviation is hard coded.
     * @return abbreviation key, e.g. DurationUnit.m/s, or null for a user-defined unit
     */
    public final String getAbbreviationKey()
    {
        return this.abbreviationKey;
    }

    /**
     * @return the textual display types of the unit. In case the list contains more than one abbreviation, the first one is the
     *         default one. In case none is available, the standard abbreviation is used. In case that one is also not available
     *         the abbreviation key is used.
     */
    public final List<String> getTextualRepresentations()
    {
        if (this.abbreviation != null)
        {
            return Arrays.asList(new String[] {this.abbreviation});
        }
        if (localization.isDefault())
        {
            return getDefaultLocaleTextualRepresentations();
        }
        String[] loc = localization.getString(this.abbreviationKey).split("\\|");
        if (loc.length >= 3)
        {
            List<String> textList = new ArrayList<>();
            for (int i = 2; i < loc.length; i++)
            {
                textList.add(loc[i].trim());
            }
            return textList;
        }
        if (loc.length >= 1)
        {
            return Arrays.asList(new String[] {loc[0].trim()});
        }
        return Arrays.asList(new String[] {this.abbreviationKey});
    }

    /**
     * @return the textual display types of the unit in the default locale; In case the list contains more than one
     *         abbreviation, the first one is the default one. In case none is available, the standard abbreviation is used. In
     *         case that one is also not available the abbreviation key is used.
     */
    public final List<String> getDefaultLocaleTextualRepresentations()
    {
        if (this.abbreviation != null)
        {
            return Arrays.asList(new String[] {this.abbreviation});
        }
        if (this.cachedDefaultLocaleInfo.length >= 3)
        {
            List<String> textList = new ArrayList<>();
            for (int i = 2; i < this.cachedDefaultLocaleInfo.length; i++)
            {
                textList.add(this.cachedDefaultLocaleInfo[i].trim());
            }
            return textList;
        }
        if (this.cachedDefaultLocaleInfo.length >= 1)
        {
            return Arrays.asList(new String[] {this.cachedDefaultLocaleInfo[0].trim()});
        }
        return Arrays.asList(new String[] {this.abbreviationKey});
    }

    /**
     * @return the default textual display representation of the unit; In case there are more textual representations, the first
     *         one is the default one. In case none is available, the standard abbreviation is used. In case that one is also
     *         not available the abbreviation key is used.
     */
    public final String getDefaultTextualRepresentation()
    {
        if (this.abbreviation != null)
        {
            return this.abbreviation;
        }
        if (localization.isDefault())
        {
            return getDefaultLocaleTextualRepresentation();
        }
        String[] loc = localization.getString(this.abbreviationKey).split("\\|");
        if (loc.length >= 3)
        {
            return loc[2].trim();
        }
        if (loc.length >= 1)
        {
            return loc[0].trim();
        }
        return this.abbreviationKey;
    }

    /**
     * @return the default textual display representation of the unit in the default locale; In case there are more textual
     *         representations, the first one is the default one. In case none is available, the standard abbreviation is used.
     *         In case that one is also not available the abbreviation key is used.
     */
    public final String getDefaultLocaleTextualRepresentation()
    {
        if (this.abbreviation != null)
        {
            return this.abbreviation;
        }
        if (this.cachedDefaultLocaleInfo.length >= 3)
        {
            return this.cachedDefaultLocaleInfo[2].trim();
        }
        if (this.cachedDefaultLocaleInfo.length >= 1)
        {
            return this.cachedDefaultLocaleInfo[0].trim();
        }
        return this.abbreviationKey;
    }

    /**
     * @return the scale to transform between this unit and the reference (e.g., SI) unit.
     */
    @SuppressWarnings("checkstyle:designforextension")
    public Scale getScale()
    {
        return this.scale;
    }

    /**
     * @return unitSystem, e.g. SI or Imperial
     */
    public final UnitSystem getUnitSystem()
    {
        return this.unitSystem;
    }

    /**
     * @return the SI standard unit for this unit, or the de facto standard unit if SI is not available
     */
    public abstract U getStandardUnit();

    /**
     * @return the SI standard coefficients for this unit, e.g., kgm/s2 or m-2s2A or m^-2.s^2.A or m^-2s^2A (not necessarily
     *         normalized)
     */
    public abstract String getSICoefficientsString();

    /**
     * @return the SI coefficients
     */
    public final SICoefficients getSICoefficients()
    {
        return this.siCoefficients;
    }

    /**
     * Determine whether this unit is the standard unit.
     * @return boolean; whether this is the standard unit or not
     */
    public final boolean isBaseSIUnit()
    {
        return this.baseSIUnit;
    }

    /**
     * @param normalizedSICoefficientsString String; the normalized string (e.g., kg.m/s2) to look up
     * @return a set with the Units belonging to this string, or an empty set when it does not exist
     */
    public static Set<Unit<?>> lookupUnitWithSICoefficients(final String normalizedSICoefficientsString)
    {
        if (!standardUnitsInitialized)
        {
            initializeStandardUnits();
        }
        if (SI_UNITS.containsKey(normalizedSICoefficientsString))
        {
            return new HashSet<Unit<?>>(SI_UNITS.get(normalizedSICoefficientsString).values());
        }
        return new HashSet<Unit<?>>();
    }

    /**
     * @param normalizedSICoefficientsString the normalized string (e.g., kg.m/s2) to look up
     * @return a set of Units belonging to this string, or a set with a new unit when it does not yet exist
     */
    public static Set<Unit<?>> lookupOrCreateUnitWithSICoefficients(final String normalizedSICoefficientsString)
    {
        if (!standardUnitsInitialized)
        {
            initializeStandardUnits();
        }
        if (SI_UNITS.containsKey(normalizedSICoefficientsString))
        {
            return new HashSet<Unit<?>>(SI_UNITS.get(normalizedSICoefficientsString).values());
        }
        SIUnit unit = new SIUnit("SIUnit." + normalizedSICoefficientsString);
        Set<Unit<?>> unitSet = new HashSet<Unit<?>>();
        unitSet.add(unit);
        return unitSet;
    }

    /**
     * @param normalizedSICoefficientsString String; the normalized string (e.g., kg.m/s2) to look up
     * @return the Unit belonging to this string, or a new unit when it does not yet exist
     */
    public static SIUnit lookupOrCreateSIUnitWithSICoefficients(final String normalizedSICoefficientsString)
    {
        if (!standardUnitsInitialized)
        {
            initializeStandardUnits();
        }
        if (SI_UNITS.containsKey(normalizedSICoefficientsString)
                && SI_UNITS.get(normalizedSICoefficientsString).containsKey(SIUnit.class))
        {
            return (SIUnit) SI_UNITS.get(normalizedSICoefficientsString).get(SIUnit.class);
        }
        SIUnit unit = new SIUnit("SIUnit." + normalizedSICoefficientsString);
        return unit;
    }

    /** {@inheritDoc} */
    @Override
    public final String toString()
    {
        return getAbbreviation();
    }

    /**
     * Generate a hashCode for caching.
     * @return a hashCode that is consistent with the equals() method.
     */
    public final int generateHashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.abbreviation == null) ? 0 : this.abbreviation.hashCode());
        result = prime * result + ((this.abbreviationKey == null) ? 0 : this.abbreviationKey.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:designforextension")
    @Override
    public int hashCode()
    {
        return this.cachedHashCode;
    }

    /** {@inheritDoc} */
    @SuppressWarnings({"checkstyle:designforextension", "checkstyle:needbraces"})
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Unit<?> other = (Unit<?>) obj;
        if (this.abbreviation == null)
        {
            if (other.abbreviation != null)
                return false;
        }
        else if (!this.abbreviation.equals(other.abbreviation))
            return false;
        if (this.abbreviationKey == null)
        {
            if (other.abbreviationKey != null)
                return false;
        }
        else if (!this.abbreviationKey.equals(other.abbreviationKey))
            return false;
        if (this.name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    /**
     * Test if two units are the same, except for the name and abbreviation. This means for instance that for the MassUnits
     * METRIC_TON and MEGAGRAM (both 1000 kg) equals(...) will yield false, but equalsIgnoreNaming will yield true.
     * @param obj Object; the object to compare with
     * @return true if the two units are the same numerically, except for the naming and/or abbreviation
     */
    public abstract boolean equalsIgnoreNaming(Object obj);

}
