package org.djunits.unit.si;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Useful sets of SI prefixes.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public enum SIPrefixes
{
    /** No SI prefixes allowed. E.g., for the "inch". */
    NONE,

    /** All standard SI prefixes allowed. E.g., for the "meter". */
    UNIT,

    /** All SI prefixes indicating larger than 1. E.g., for the electronVolt to avoid underflow with float values. */
    UNIT_POS,

    /** All standard SI prefixes allowed for "per unit". E.g., for the "per second". */
    PER_UNIT,

    /** SI prefixes allowed, but default starts with "kilo" / "k", e.g., for the "kilogram". */
    KILO;

    /** The SI prefixes and their values for the "UNIT" settings. */
    public static final Map<String, SIPrefix> UNIT_PREFIXES = new LinkedHashMap<>();

    /** The SI prefixes and their values for the "PER_UNIT" settings. */
    public static final Map<String, SIPrefix> PER_UNIT_PREFIXES = new LinkedHashMap<>();

    /** The larger than 1 SI prefixes and their values for the "UNIT_POS" settings. */
    public static final Map<String, SIPrefix> UNIT_POS_PREFIXES = new LinkedHashMap<>();

    /** The SI prefixes and their values for the "KILO" settings. */
    public static final Map<String, SIPrefix> KILO_PREFIXES = new LinkedHashMap<>();

    static
    {
        UNIT_PREFIXES.put("y", new SIPrefix("y", "yocto", 1.0E-24));
        UNIT_PREFIXES.put("z", new SIPrefix("z", "zepto", 1.0E-21));
        UNIT_PREFIXES.put("a", new SIPrefix("a", "atto", 1.0E-18));
        UNIT_PREFIXES.put("f", new SIPrefix("f", "femto", 1.0E-15));
        UNIT_PREFIXES.put("p", new SIPrefix("p", "pico", 1.0E-12));
        UNIT_PREFIXES.put("n", new SIPrefix("n", "nano", 1.0E-9));
        UNIT_PREFIXES.put("mu", new SIPrefix("mu", "micro", 1.0E-6, "\u03BC"));
        UNIT_PREFIXES.put("m", new SIPrefix("m", "milli", 1.0E-3));
        UNIT_PREFIXES.put("c", new SIPrefix("c", "centi", 1.0E-2));
        UNIT_PREFIXES.put("d", new SIPrefix("d", "deci", 1.0E-1));

        UNIT_PREFIXES.put("da", new SIPrefix("da", "deca", 1.0E1));
        UNIT_PREFIXES.put("h", new SIPrefix("h", "hecto", 1.0E2));
        UNIT_PREFIXES.put("k", new SIPrefix("k", "kilo", 1.0E3));
        UNIT_PREFIXES.put("M", new SIPrefix("M", "mega", 1.0E6));
        UNIT_PREFIXES.put("G", new SIPrefix("G", "giga", 1.0E9));
        UNIT_PREFIXES.put("T", new SIPrefix("T", "tera", 1.0E12));
        UNIT_PREFIXES.put("P", new SIPrefix("P", "peta", 1.0E15));
        UNIT_PREFIXES.put("E", new SIPrefix("E", "exa", 1.0E18));
        UNIT_PREFIXES.put("Z", new SIPrefix("Z", "zetta", 1.0E21));
        UNIT_PREFIXES.put("Y", new SIPrefix("Y", "yotta", 1.0E24));

        PER_UNIT_PREFIXES.put("/y", new SIPrefix("/y", "per yocto", 1.0E24));
        PER_UNIT_PREFIXES.put("/z", new SIPrefix("/z", "per zepto", 1.0E21));
        PER_UNIT_PREFIXES.put("/a", new SIPrefix("/a", "per atto", 1.0E18));
        PER_UNIT_PREFIXES.put("/f", new SIPrefix("/f", "per femto", 1.0E15));
        PER_UNIT_PREFIXES.put("/p", new SIPrefix("/p", "per pico", 1.0E12));
        PER_UNIT_PREFIXES.put("/n", new SIPrefix("/n", "per nano", 1.0E9));
        PER_UNIT_PREFIXES.put("/mu", new SIPrefix("/mu", "per micro", 1.0E6, "/\u03BC"));
        PER_UNIT_PREFIXES.put("/m", new SIPrefix("/m", "per milli", 1.0E3));
        PER_UNIT_PREFIXES.put("/c", new SIPrefix("/c", "per centi", 1.0E2));
        PER_UNIT_PREFIXES.put("/d", new SIPrefix("/d", "per deci", 1.0E1));

        PER_UNIT_PREFIXES.put("/da", new SIPrefix("/da", "per deca", 1.0E-1));
        PER_UNIT_PREFIXES.put("/h", new SIPrefix("/h", "per hecto", 1.0E-2));
        PER_UNIT_PREFIXES.put("/k", new SIPrefix("/k", "per kilo", 1.0E-3));
        PER_UNIT_PREFIXES.put("/M", new SIPrefix("/M", "per mega", 1.0E-6));
        PER_UNIT_PREFIXES.put("/G", new SIPrefix("/G", "per giga", 1.0E-9));
        PER_UNIT_PREFIXES.put("/T", new SIPrefix("/T", "per tera", 1.0E-12));
        PER_UNIT_PREFIXES.put("/P", new SIPrefix("/P", "per peta", 1.0E-15));
        PER_UNIT_PREFIXES.put("/E", new SIPrefix("/E", "per exa", 1.0E-18));
        PER_UNIT_PREFIXES.put("/Z", new SIPrefix("/Z", "per zetta", 1.0E-21));
        PER_UNIT_PREFIXES.put("/Y", new SIPrefix("/Y", "per yotta", 1.0E-24));

        UNIT_POS_PREFIXES.put("da", new SIPrefix("da", "deca", 1.0E1));
        UNIT_POS_PREFIXES.put("h", new SIPrefix("h", "hecto", 1.0E2));
        UNIT_POS_PREFIXES.put("k", new SIPrefix("k", "kilo", 1.0E3));
        UNIT_POS_PREFIXES.put("M", new SIPrefix("M", "mega", 1.0E6));
        UNIT_POS_PREFIXES.put("G", new SIPrefix("G", "giga", 1.0E9));
        UNIT_POS_PREFIXES.put("T", new SIPrefix("T", "tera", 1.0E12));
        UNIT_POS_PREFIXES.put("P", new SIPrefix("P", "peta", 1.0E15));
        UNIT_POS_PREFIXES.put("E", new SIPrefix("E", "exa", 1.0E18));
        UNIT_POS_PREFIXES.put("Z", new SIPrefix("Z", "zetta", 1.0E21));
        UNIT_POS_PREFIXES.put("Y", new SIPrefix("Y", "yotta", 1.0E24));

        KILO_PREFIXES.put("y", new SIPrefix("y", "yocto", 1.0E-27));
        KILO_PREFIXES.put("z", new SIPrefix("z", "zepto", 1.0E-24));
        KILO_PREFIXES.put("a", new SIPrefix("a", "atto", 1.0E-21));
        KILO_PREFIXES.put("f", new SIPrefix("f", "femto", 1.0E-18));
        KILO_PREFIXES.put("p", new SIPrefix("p", "pico", 1.0E-15));
        KILO_PREFIXES.put("n", new SIPrefix("n", "nano", 1.0E-12));
        KILO_PREFIXES.put("mu", new SIPrefix("mu", "micro", 1.0E-9, "\u03BC"));
        KILO_PREFIXES.put("m", new SIPrefix("m", "milli", 1.0E-6));
        KILO_PREFIXES.put("c", new SIPrefix("c", "centi", 1.0E-5));
        KILO_PREFIXES.put("d", new SIPrefix("d", "deci", 1.0E-4));
        KILO_PREFIXES.put("", new SIPrefix("", "", 1.0E-3));
        KILO_PREFIXES.put("da", new SIPrefix("da", "deca", 1.0E-2));
        KILO_PREFIXES.put("h", new SIPrefix("h", "hecto", 1.0E-1));

        KILO_PREFIXES.put("M", new SIPrefix("M", "mega", 1.0E3));
        KILO_PREFIXES.put("G", new SIPrefix("G", "giga", 1.0E6));
        KILO_PREFIXES.put("T", new SIPrefix("T", "tera", 1.0E9));
        KILO_PREFIXES.put("P", new SIPrefix("P", "peta", 1.0E12));
        KILO_PREFIXES.put("E", new SIPrefix("E", "exa", 1.0E15));
        KILO_PREFIXES.put("Z", new SIPrefix("Z", "zetta", 1.0E18));
        KILO_PREFIXES.put("Y", new SIPrefix("Y", "yotta", 1.0E21));
    }

    /**
     * Look up and return the prefix information for the given prefix key (e.g., "G" for "giga").
     * @param prefixKey String; the prefix key, e.g., "G" for "giga"
     * @return SIPrefix; the SIPrefix information, or null if the <code>prefixKey</code> does not exist
     */
    public static SIPrefix getUnit(final String prefixKey)
    {
        return UNIT_PREFIXES.get(prefixKey);
    }

    /**
     * Look up and return the prefix information for the given prefix key (e.g., "/n" for "per nano").
     * @param prefixKey String; the prefix key, e.g., "/n" for "per nano"
     * @return SIPrefix; the SIPrefix information, or null if the <code>prefixKey</code> does not exist
     */
    public static SIPrefix getPerUnit(final String prefixKey)
    {
        return PER_UNIT_PREFIXES.get(prefixKey);
    }

    /**
     * Return the prefix information for the given prefix key (e.g., "G" for "giga"), with an offset of a factor 1000 for units
     * that have "kilo" as the default.
     * @param prefixKey String; the prefix key, e.g., "G" for "giga"
     * @return SIPrefix; the SIPrefix information, with an offset of 1000. So "k" will return 1, and "" will return 1.0E-3.
     */
    public static SIPrefix getKiloUnit(final String prefixKey)
    {
        return KILO_PREFIXES.get(prefixKey);
    }

}
