package org.djunits4.unit;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.djunits4.Throw;
import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.LinearScale;
import org.djunits4.unit.scale.OffsetLinearScale;
import org.djunits4.unit.scale.Scale;
import org.djunits4.unit.scale.StandardScale;
import org.djunits4.unit.si.SIPrefix;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * All units are internally <i>stored</i> relative to a standard unit with conversion factor. This means that e.g., a meter is
 * stored with conversion factor 1.0, whereas kilometer is stored with a conversion factor 1000.0. This means that if we want to
 * express a length meter in kilometers, we have to <i>divide</i> by the conversion factor.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit to reference the actual unit in return values
 */
public abstract class Unit<U extends Unit<U>> implements Serializable, Cloneable
{
    /** */
    private static final long serialVersionUID = 20190818L;

    /** The id of the unit; has to be unique within the unit name. Used for, e.g., localization and retrieval. */
    private String id;

    /** The abbreviations in the default locale. All abbreviations an be used in the valueOf() and of() methods. */
    private Set<String> abbreviations;

    /** the default display abbreviation in the default locale for printing. Included in the abbreviations list. */
    private String defaultDisplayAbbreviation;

    /** the default textual abbreviation in the default locale for data entry. Included in the abbreviations list. */
    private String defaultTextualAbbreviation;

    /** the long name of the unit in the default locale. */
    private String name;

    /** The scale to use to convert between this unit and the standard (e.g., SI, BASE) unit. */
    private Scale scale;

    /** The unit system, e.g. SI or Imperial. */
    private UnitSystem unitSystem;

    /** whether the unit has been automatically generated or not. */
    private boolean generated;

    /** does the unit have the standard SI signature? */
    private boolean baseSIUnit;

    /**
     * /** The corresponding base unit that contains all registered units for the unit as well as SI dimension information. The
     * base unit is null for base units themselves.
     */
    private BaseUnit<U> baseUnit;

    /**
     * Initialize a blank unit that can be built through reflection with several 'setter' methods followed by calling the
     * build(...) method.
     */
    protected Unit()
    {
        //
    }

    /**
     * Build the unit, using the information of the provided builder class. First check rigorously if all necessary fields in
     * the builder have been set, and whether they are consistent and valid. The behavior is as follows: the defaultAbbreviation
     * and defaultTextualAbbreviation are added to the abbreviations set, if they are not yet already there. When the
     * defaultAbbreviation is set and the defaultTextualAbbreviation is not set, the defaultTextualAbbreviation gets the value
     * of defaultAbbreviation. The reverse also holds: When the defaultTextualAbbreviation is set and the defaultAbbreviation is
     * not set, the defaultAbbreviation gets the value of defaultTextualAbbreviation. When neither the
     * defaultTextualAbbreviation, nor the defaultAbbreviation are set, both get the value of the unitId provided in the
     * builder.
     * @param builder Builder&lt;U&gt; the object that contains the information about the construction of the class
     * @return the constructed unit
     * @throws UnitRuntimeException when not all fields have been set
     */
    @SuppressWarnings("unchecked")
    protected U build(final Builder<U> builder) throws UnitRuntimeException
    {
        // check the validity
        String cName = getClass().getSimpleName();
        Throw.whenNull(builder.getId(), "Constructing unit %s: id cannot be null", cName);
        Throw.when(builder.getId().length() == 0, UnitRuntimeException.class, "Constructing unit %s: id.length cannot be 0",
                cName);
        String unitId = builder.getId();
        Throw.whenNull(builder.getBaseUnit(), "Constructing unit %s.%s: baseUnit cannot be null", cName, unitId);
        Throw.whenNull(builder.getName(), "Constructing unit %s.%s: name cannot be null", cName, unitId);
        Throw.when(builder.getName().length() == 0, UnitRuntimeException.class,
                "Constructing unit %s.%s: name.length cannot be 0", cName, unitId);
        Throw.whenNull(builder.getScale(), "Constructing unit %s.%s: scale cannot be null", cName, unitId);
        Throw.whenNull(builder.getUnitSystem(), "Constructing unit %s.%s: unitSystem cannot be null", cName, unitId);

        // set the key fields
        this.id = unitId;
        this.name = builder.getName();
        this.baseUnit = builder.getBaseUnit();
        this.unitSystem = builder.getUnitSystem();
        this.scale = builder.getScale();
        this.generated = builder.isGenerated();
        this.baseSIUnit = this.scale.isBaseSIScale();

        // set and check the abbreviations
        if (builder.getDefaultDisplayAbbreviation() == null)
        {
            if (builder.getDefaultTextualAbbreviation() == null)
            {
                this.defaultDisplayAbbreviation = unitId;
            }
            else
            {
                this.defaultDisplayAbbreviation = builder.getDefaultTextualAbbreviation();
            }
        }
        else
        {
            this.defaultDisplayAbbreviation = builder.getDefaultDisplayAbbreviation();
        }
        if (builder.getDefaultTextualAbbreviation() == null)
        {
            this.defaultTextualAbbreviation = this.defaultDisplayAbbreviation;
        }
        else
        {
            this.defaultTextualAbbreviation = builder.getDefaultTextualAbbreviation();
        }
        this.abbreviations = new LinkedHashSet<>();
        this.abbreviations.add(this.defaultDisplayAbbreviation);
        this.abbreviations.add(this.defaultTextualAbbreviation);
        this.abbreviations.addAll(builder.getAdditionalAbbreviations());

        // see what SI prefixes have to be registered. If not specified: NONE.
        SIPrefixes siPrefixes = builder.getSiPrefixes() == null ? SIPrefixes.NONE : builder.getSiPrefixes();

        // register the unit, possibly including all SI prefixes
        this.baseUnit.registerUnit((U) this, siPrefixes);
        return (U) this;
    }

    /**
     * Create a scaled version of this unit with the same unit system but another SI prefix and scale.
     * @param siPrefix the prefix for which to scale the unit
     * @param automaticallyGenerated indicate whether the unit has been automatically generated
     * @return a scaled instance of this unit
     * @throws UnitRuntimeException when cloning fails
     */
    public U deriveSI(final SIPrefix siPrefix, final boolean automaticallyGenerated)
    {
        Throw.whenNull(siPrefix, "siPrefix cannot be null");
        try
        {
            U clone = clone();

            // get values: combine all prefixes with all names / abbreviations
            String cloneId = siPrefix.getDefaultTextualPrefix() + clone.getId();
            String cloneName = siPrefix.getPrefixName() + clone.getName();
            Set<String> cloneAbbreviations = new LinkedHashSet<>();
            for (String abbreviation : clone.getAbbreviations())
            {
                cloneAbbreviations.add(siPrefix.getDefaultTextualPrefix() + abbreviation);
            }
            String cloneDefaultAbbreviation = siPrefix.getDefaultDisplayPrefix() + clone.getDefaultDisplayAbbreviation();
            String cloneDefaultTextualAbbreviation = siPrefix.getDefaultTextualPrefix() + clone.getDefaultTextualAbbreviation();

            // make a builder and set values
            Builder<U> builder = makeBuilder();
            builder.setId(cloneId);
            builder.setName(cloneName);
            builder.setBaseUnit(this.baseUnit);
            builder.setSiPrefixes(SIPrefixes.NONE);
            builder.setDefaultDisplayAbbreviation(cloneDefaultAbbreviation);
            builder.setDefaultTextualAbbreviation(cloneDefaultTextualAbbreviation);
            builder.setAdditionalAbbreviations(cloneAbbreviations.toArray(new String[cloneAbbreviations.size()]));
            if (getScale() instanceof OffsetLinearScale)
            {
                builder.setScale(new OffsetLinearScale(
                        siPrefix.getFactor() * ((LinearScale) getScale()).getConversionFactorToStandardUnit(), 0.0));
            }
            else
            {
                builder.setScale(
                        new LinearScale(siPrefix.getFactor() * ((LinearScale) getScale()).getConversionFactorToStandardUnit()));
            }
            builder.setUnitSystem(this.unitSystem); // SI_BASE stays SI_BASE with prefix
            builder.setGenerated(automaticallyGenerated);

            return clone.build(builder);
        }
        catch (CloneNotSupportedException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    /**
     * Create a scaled version of this unit with the same unit system but another SI prefix and scale. This method is used for a
     * unit that is explicitly scaled with an SI prefix.
     * @param siPrefix the prefix for which to scale the unit
     * @return a scaled instance of this unit
     * @throws UnitRuntimeException when cloning fails
     */
    protected U deriveSI(final SIPrefix siPrefix)
    {
        return deriveSI(siPrefix, false);
    }

    /**
     * Create a scaled version of this unit with the same unit system but another SI prefix and scale, where the "k" and "kilo"
     * abbreviations at the start will be replaced by the new information from the SIPrefix.
     * @param siPrefix the prefix for which to scale the unit
     * @param automaticallyGenerated indicate whether the unit has been automatically generated
     * @return a scaled instance of this unit
     * @throws UnitRuntimeException when cloning fails
     */
    public U deriveSIKilo(final SIPrefix siPrefix, final boolean automaticallyGenerated)
    {
        Throw.whenNull(siPrefix, "siPrefix cannot be null");
        Throw.when(!this.id.startsWith("k"), UnitRuntimeException.class, "deriving from a kilo-unit: id should start with 'k'");
        Throw.when(!this.defaultTextualAbbreviation.startsWith("k"), UnitRuntimeException.class,
                "deriving from a kilo-unit: defaultTextualAbbreviation should start with 'k'");
        Throw.when(!this.defaultDisplayAbbreviation.startsWith("k"), UnitRuntimeException.class,
                "deriving from a kilo-unit: defaultDisplayAbbreviation should start with 'k'");
        Throw.when(!this.name.startsWith("kilo"), UnitRuntimeException.class,
                "deriving from a kilo-unit: name should start with 'kilo'");
        for (String abbreviation : getAbbreviations())
        {
            Throw.when(!abbreviation.startsWith("k"), UnitRuntimeException.class,
                    "deriving from a kilo-unit: each abbreviation should start with 'k'");
        }

        try
        {
            U clone = clone();

            // get values: combine all prefixes with all names / abbreviations
            String cloneId = siPrefix.getDefaultTextualPrefix() + clone.getId().substring(1);
            String cloneName = siPrefix.getPrefixName() + clone.getName().substring(4);
            Set<String> cloneAbbreviations = new LinkedHashSet<>();
            for (String abbreviation : clone.getAbbreviations())
            {
                cloneAbbreviations.add(siPrefix.getDefaultTextualPrefix() + abbreviation.substring(1));
            }
            String cloneDefaultAbbreviation =
                    siPrefix.getDefaultDisplayPrefix() + clone.getDefaultDisplayAbbreviation().substring(1);
            String cloneDefaultTextualAbbreviation =
                    siPrefix.getDefaultTextualPrefix() + clone.getDefaultTextualAbbreviation().substring(1);

            // make a builder and set values
            Builder<U> builder = makeBuilder();
            builder.setId(cloneId);
            builder.setName(cloneName);
            builder.setBaseUnit(this.baseUnit);
            builder.setSiPrefixes(SIPrefixes.NONE);
            builder.setDefaultDisplayAbbreviation(cloneDefaultAbbreviation);
            builder.setDefaultTextualAbbreviation(cloneDefaultTextualAbbreviation);
            builder.setAdditionalAbbreviations(cloneAbbreviations.toArray(new String[cloneAbbreviations.size()]));
            if (getScale() instanceof OffsetLinearScale)
            {
                builder.setScale(new OffsetLinearScale(
                        siPrefix.getFactor() * ((LinearScale) getScale()).getConversionFactorToStandardUnit(), 0.0));
            }
            else
            {
                builder.setScale(
                        new LinearScale(siPrefix.getFactor() * ((LinearScale) getScale()).getConversionFactorToStandardUnit()));
            }

            builder.setUnitSystem(this.unitSystem);
            builder.setGenerated(automaticallyGenerated);

            return clone.build(builder);
        }
        catch (CloneNotSupportedException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    /**
     * Create a linearly scaled version of this unit. The scale field will be filled with the correct scaleFactor. Note that the
     * unit that is used for derivation can already have a scaleFactor.
     * @param scaleFactor the linear scale factor of the unit
     * @param derivedId String; the new id of the derived unit
     * @param derivedName String; the new name of the derived unit
     * @param derivedUnitSystem the unit system of the derived unit
     * @param derivedDefaultDisplayAbbreviation the default abbreviation to use in e.g, the toString() method. Can be null.
     * @param derivedDefaultTextualAbbreviation the default textual abbreviation to use in, e.g, typing. Can be null.
     * @param derivedAbbreviations the other valid abbreviations for the unit, e.g. {"h", "hr", "hour"}. Can be left out.
     * @return a linearly scaled instance of this unit with new id, abbreviation, name, and unit system
     * @throws UnitRuntimeException when cloning fails
     */
    protected U deriveLinear(final double scaleFactor, final String derivedId, final String derivedName,
            final UnitSystem derivedUnitSystem, final String derivedDefaultDisplayAbbreviation,
            final String derivedDefaultTextualAbbreviation, final String... derivedAbbreviations)
    {
        String cName = getClass().getSimpleName();
        Throw.whenNull(derivedId, "deriving unit from %s.%s; derivedId cannot be null", cName, this.id);
        Throw.whenNull(derivedName, "deriving unit from %s.%s; derivedName cannot be null", cName, this.id);
        Throw.whenNull(derivedUnitSystem, "deriving unit from %s.%s; derivedUnitSystem cannot be null", cName, this.id);
        if (!getScale().getClass().equals(LinearScale.class) && !getScale().getClass().equals(StandardScale.class))
        {
            throw new UnitRuntimeException("Cannot derive from unit " + cName + "." + getId() + " with scale "
                    + getScale().getClass().getSimpleName() + ". Scale should be Linear");
        }

        try
        {
            U clone = clone();

            // make a builder and set values
            Builder<U> builder = makeBuilder();
            builder.setId(derivedId);
            builder.setName(derivedName);
            builder.setBaseUnit(this.baseUnit);
            builder.setSiPrefixes(SIPrefixes.NONE);
            builder.setScale(new LinearScale(scaleFactor * ((LinearScale) getScale()).getConversionFactorToStandardUnit()));
            builder.setUnitSystem(derivedUnitSystem);
            builder.setDefaultDisplayAbbreviation(derivedDefaultDisplayAbbreviation);
            builder.setDefaultTextualAbbreviation(derivedDefaultTextualAbbreviation);
            if (derivedAbbreviations != null)
            {
                builder.setAdditionalAbbreviations(derivedAbbreviations);
            }

            return clone.build(builder);
        }
        catch (CloneNotSupportedException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    /**
     * Create a linearly scaled version of this unit. The scale field will be filled with the correct scaleFactor. Note that the
     * unit that is used for derivation can already have a scaleFactor.
     * @param scaleFactor the linear scale factor of the unit
     * @param derivedId String; the new id of the derived unit
     * @param derivedName String; the new name of the derived unit
     * @param derivedUnitSystem the unit system of the derived unit
     * @return a linearly scaled instance of this unit with new id, abbreviation, name, and unit system
     * @throws UnitRuntimeException when cloning fails
     */
    protected U deriveLinear(final double scaleFactor, final String derivedId, final String derivedName,
            final UnitSystem derivedUnitSystem)
    {
        return deriveLinear(scaleFactor, derivedId, derivedName, derivedUnitSystem, null, null);
    }

    /**
     * Create a linearly scaled version of this unit. The unitSystem will be copied. The scale field will be filled with the
     * correct scaleFactor. Note that the unit that is used for derivation can already have a scaleFactor.
     * @param scaleFactor the linear scale factor of the unit
     * @param derivedId String; the new id of the derived unit
     * @param derivedName String; the new name of the derived unit
     * @return a linearly scaled instance of this unit with new id, abbreviation, name, and unit system
     * @throws UnitRuntimeException when cloning fails
     */
    protected U deriveLinear(final double scaleFactor, final String derivedId, final String derivedName)
    {
        return deriveLinear(scaleFactor, derivedId, derivedName, getUnitSystem());
    }

    /**
     * Create a Builder. Override at subclasses to create extended builder.
     * @return an instance of a builder.
     */
    protected Builder<U> makeBuilder()
    {
        return new Builder<U>();
    }

    /**
     * @return id
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * @return abbreviations
     */
    public Set<String> getAbbreviations()
    {
        return this.abbreviations;
    }

    /**
     * @return defaultAbbreviation
     */
    public String getDefaultDisplayAbbreviation()
    {
        return this.defaultDisplayAbbreviation;
    }

    /**
     * @return defaultTextualAbbreviation
     */
    public String getDefaultTextualAbbreviation()
    {
        return this.defaultTextualAbbreviation;
    }

    /**
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return scale
     */
    public Scale getScale()
    {
        return this.scale;
    }

    /**
     * @return unitSystem
     */
    public UnitSystem getUnitSystem()
    {
        return this.unitSystem;
    }

    /**
     * @return baseUnit
     */
    public BaseUnit<U> getBaseUnit()
    {
        return this.baseUnit;
    }

    /**
     * @return whether the unit has been automatically generated or not
     */
    public boolean isGenerated()
    {
        return this.generated;
    }

    /**
     * @return whether the unit has the standard SI signature
     */
    public boolean isBaseSIUnit()
    {
        return this.baseSIUnit;
    }

    /**
     * @return U the standard unit (SI unit) belonging to this unit. 
     */
    public U getStandardUnit()
    {
        return getBaseUnit().getStandardUnit();
    }
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public U clone() throws CloneNotSupportedException
    {
        return (U) super.clone();
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.abbreviations == null) ? 0 : this.abbreviations.hashCode());
        result = prime * result + ((this.baseUnit == null) ? 0 : this.baseUnit.hashCode());
        result = prime * result + ((this.defaultDisplayAbbreviation == null) ? 0 : this.defaultDisplayAbbreviation.hashCode());
        result = prime * result + ((this.defaultTextualAbbreviation == null) ? 0 : this.defaultTextualAbbreviation.hashCode());
        result = prime * result + (this.generated ? 1231 : 1237);
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.scale == null) ? 0 : this.scale.hashCode());
        result = prime * result + ((this.unitSystem == null) ? 0 : this.unitSystem.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Unit<?> other = (Unit<?>) obj;
        if (this.abbreviations == null)
        {
            if (other.abbreviations != null)
                return false;
        }
        else if (!this.abbreviations.equals(other.abbreviations))
            return false;
        if (this.baseUnit == null)
        {
            if (other.baseUnit != null)
                return false;
        }
        else if (!this.baseUnit.equals(other.baseUnit))
            return false;
        if (this.defaultDisplayAbbreviation == null)
        {
            if (other.defaultDisplayAbbreviation != null)
                return false;
        }
        else if (!this.defaultDisplayAbbreviation.equals(other.defaultDisplayAbbreviation))
            return false;
        if (this.defaultTextualAbbreviation == null)
        {
            if (other.defaultTextualAbbreviation != null)
                return false;
        }
        else if (!this.defaultTextualAbbreviation.equals(other.defaultTextualAbbreviation))
            return false;
        if (this.generated != other.generated)
            return false;
        if (this.id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.scale == null)
        {
            if (other.scale != null)
                return false;
        }
        else if (!this.scale.equals(other.scale))
            return false;
        if (this.unitSystem == null)
        {
            if (other.unitSystem != null)
                return false;
        }
        else if (!this.unitSystem.equals(other.unitSystem))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "Unit[id=" + this.id + ", name=" + this.name + "]";
    }

    /**
     * The class that contains the information to build a unit.
     * <p>
     * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved.
     * <br>
     * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
     * <p>
     * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
     * @param <U> the unit for which the builder contains the information.
     */
    public static class Builder<U extends Unit<U>>
    {
        /** The id of the unit; has to be unique within the unit name. Used for, e.g., localization and retrieval. */
        private String id;

        /** The abbreviations in the default locale. All abbreviations an be used in the valueOf() and of() methods. */
        private Set<String> additionalAbbreviations = new LinkedHashSet<>();

        /** the default abbreviation in the default locale for printing. Included in the abbreviations list. */
        private String defaultDisplayAbbreviation;

        /** the default textual abbreviation in the default locale for data entry. Included in the abbreviations list. */
        private String defaultTextualAbbreviation;

        /** the long name of the unit in the default locale. */
        private String name;

        /** The scale to use to convert between this unit and the standard (e.g., SI, BASE) unit. */
        private Scale scale;

        /** The unit system, e.g. SI or Imperial. */
        private UnitSystem unitSystem;

        /** Whether or not the unit supports SI prefixes from "yotta" (y) to "yocto" (Y). */
        private SIPrefixes siPrefixes;

        /** Whether the unit has been automatically generated or not. */
        private boolean generated = false;

        /**
         * /** The corresponding base unit that contains all registered units for the unit as well as SI dimension information.
         * The base unit is null for base units themselves.
         */
        private BaseUnit<U> baseUnit;

        /**
         * Empty constructor. Content is generated through chaining: new Unit.Builder<TypeUnit>().setId("id").setName("name");
         */
        public Builder()
        {
            // empty constructor. Content is generated through chaining
        }

        /**
         * Return whether SI prefixes, ranging from yotta (y) to yocto (Y), will be generated.
         * @return siPrefixes, NONE (e.g., for inch), ALL (e.g., for meter) or KILO (e.g., for kilometer)
         */
        public SIPrefixes getSiPrefixes()
        {
            return this.siPrefixes;
        }

        /**
         * Set whether SI prefixes, ranging from yotta (y) to yocto (Y), are allowed.
         * @param siPrefixes SIPrefixes set siPrefixes, NONE (e.g., for inch), ALL (e.g., for meter) or KILO (e.g., for
         *            kilometer)
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setSiPrefixes(final SIPrefixes siPrefixes)
        {
            this.siPrefixes = siPrefixes;
            return this;
        }

        /**
         * @return id
         */
        public String getId()
        {
            return this.id;
        }

        /**
         * @param id set id
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setId(final String id)
        {
            this.id = id;
            return this;
        }

        /**
         * @return abbreviations
         */
        public Set<String> getAdditionalAbbreviations()
        {
            return this.additionalAbbreviations;
        }

        /**
         * @param additionalAbbreviations set abbreviations
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setAdditionalAbbreviations(final String... additionalAbbreviations)
        {
            this.additionalAbbreviations = new LinkedHashSet<>(Arrays.asList(additionalAbbreviations)); // safe copy
            return this;
        }

        /**
         * @return defaultDisplayAbbreviation
         */
        public String getDefaultDisplayAbbreviation()
        {
            return this.defaultDisplayAbbreviation;
        }

        /**
         * @param defaultDisplayAbbreviation set defaultDisplayAbbreviation
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setDefaultDisplayAbbreviation(final String defaultDisplayAbbreviation)
        {
            this.defaultDisplayAbbreviation = defaultDisplayAbbreviation;
            return this;
        }

        /**
         * @return defaultTextualAbbreviation
         */
        public String getDefaultTextualAbbreviation()
        {
            return this.defaultTextualAbbreviation;
        }

        /**
         * @param defaultTextualAbbreviation set defaultTextualAbbreviation
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setDefaultTextualAbbreviation(final String defaultTextualAbbreviation)
        {
            this.defaultTextualAbbreviation = defaultTextualAbbreviation;
            return this;
        }

        /**
         * @return name
         */
        public String getName()
        {
            return this.name;
        }

        /**
         * @param name set name
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setName(final String name)
        {
            this.name = name;
            return this;
        }

        /**
         * @return scale
         */
        public Scale getScale()
        {
            return this.scale;
        }

        /**
         * @param scale set scale
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setScale(final Scale scale)
        {
            this.scale = scale;
            return this;
        }

        /**
         * @return unitSystem
         */
        public UnitSystem getUnitSystem()
        {
            return this.unitSystem;
        }

        /**
         * @param unitSystem set unitSystem
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setUnitSystem(final UnitSystem unitSystem)
        {
            this.unitSystem = unitSystem;
            return this;
        }

        /**
         * @return generated
         */
        public boolean isGenerated()
        {
            return this.generated;
        }

        /**
         * @param generated set generated
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setGenerated(final boolean generated)
        {
            this.generated = generated;
            return this;
        }

        /**
         * @return baseUnit
         */
        public BaseUnit<U> getBaseUnit()
        {
            return this.baseUnit;
        }

        /**
         * @param baseUnit set baseUnit
         * @return the instance that is being constructed for chaining
         */
        public Builder<U> setBaseUnit(final BaseUnit<U> baseUnit)
        {
            this.baseUnit = baseUnit;
            return this;
        }
    }
}
