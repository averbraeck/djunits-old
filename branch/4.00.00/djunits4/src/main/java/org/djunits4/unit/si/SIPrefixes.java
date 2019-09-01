package org.djunits4.unit.si;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SIPrefixes.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public enum SIPrefixes
{
    /** No SI prefixes allowed. E.g., for the "inch". */
    NONE,

    /** All SI prefixes allowed. E.g., for the "meter". */
    UNIT,

    /** All positive SI prefixes allowed. E.g., for the electronVolt to avoid underflow with float values. */
    UNIT_POS,

    /** SI prefixes allowed, but default starts with "kilo" / "k", e.g., for the "kilogram". */
    KILO;

    /** the SI prefixes and their values for the "UNIT" settings. */
    public static final Map<String, SIPrefix> UNIT_PREFIXES = new LinkedHashMap<>();

    /** the positive SI prefixes and their values for the "UNIT_POS" settings. */
    public static final Map<String, SIPrefix> UNIT_POS_PREFIXES = new LinkedHashMap<>();

    /** the SI prefixes and their values for the "KILO" settings. */
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
     * Return the prefix information for the given prefix key (e.g., "G" for "giga").
     * @param prefixKey String; the prefix key, e.g., "G" for "giga"
     * @return the SIPrefix information
     */
    public static SIPrefix getUnit(final String prefixKey)
    {
        return UNIT_PREFIXES.get(prefixKey);
    }

    /**
     * Return the prefix information for the given prefix key (e.g., "G" for "giga"), with an offset of a factor 1000 for units
     * that have "kilo" as the default.
     * @param prefixKey String; the prefix key, e.g., "G" for "giga"
     * @return the SIPrefix information, with an offset of 1000. So "k" will return 1, and "" will return 1.0E-3.
     */
    public static SIPrefix getKiloUnit(final String prefixKey)
    {
        return KILO_PREFIXES.get(prefixKey);
    }

}
