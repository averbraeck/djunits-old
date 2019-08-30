package org.djunits4.unit.si;

import java.io.Serializable;

import org.djunits4.Throw;

/**
 * SIPrefix contains information about one prefix, such as M for mega with the value 1.0E6.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIPrefix implements Serializable
{
    /** */
    private static final long serialVersionUID = 20190821L;

    /** the default textual prefix abbreviation, such as "M" for mega and "da" for deca. */
    private final String defaultTextualPrefix;

    /** the default display prefix abbreviation, such as "\u03BC" for micro. */
    private final String defaultDisplayPrefix;

    /** the prefix name such as "mega" or "deca". */
    private final String prefixName;

    /** the factor that the SI prefix represents, such as 1.0E6 for mega. */
    private final double factor;

    /**
     * Construct an SI prefix.
     * @param defaultTextualPrefix String; the prefix abbreviation, duch as "M" for mega and "da" for deca
     * @param prefixName String; the prefix name such as "mega" or "deca"
     * @param factor double; the factor that the SI prefix represents, such as 1.0E6 for mega
     * @param defaultDisplayPrefix the display prefix; "\u03BC" for micro
     */
    public SIPrefix(final String defaultTextualPrefix, final String prefixName, final double factor,
            final String defaultDisplayPrefix)
    {
        Throw.whenNull(defaultTextualPrefix, "SIPrefix.defaultTextualPrefix cannot be null");
        Throw.whenNull(prefixName, "SIPrefix.prefixName cannot be null");
        Throw.whenNull(defaultDisplayPrefix, "SIPrefix.defaultDisplayPrefix cannot be null");
        Throw.when(factor == 0, SIRuntimeException.class, "SIPrefix.factor cannot be 0");
        this.defaultTextualPrefix = defaultTextualPrefix;
        this.prefixName = prefixName;
        this.factor = factor;
        this.defaultDisplayPrefix = defaultDisplayPrefix;
    }

    /**
     * Construct an SI prefix with the defaultDisplayPrefix equal to the defaultTextualPrefix.
     * @param defaultTextualPrefix String; the prefix abbreviation, duch as "M" for mega and "da" for deca
     * @param prefixName String; the prefix name such as "mega" or "deca"
     * @param factor double; the factor that the SI prefix represents, such as 1.0E6 for mega
     */
    public SIPrefix(final String defaultTextualPrefix, final String prefixName, final double factor)
    {
        this(defaultTextualPrefix, prefixName, factor, defaultTextualPrefix);
    }

    /**
     * @return defaultTextualPrefix
     */
    public String getDefaultTextualPrefix()
    {
        return this.defaultTextualPrefix;
    }

    /**
     * @return prefixName
     */
    public String getPrefixName()
    {
        return this.prefixName;
    }

    /**
     * @return factor
     */
    public double getFactor()
    {
        return this.factor;
    }

    /**
     * @return defaultDisplayPrefix
     */
    public String getDefaultDisplayPrefix()
    {
        return this.defaultDisplayPrefix;
    }
}
