package org.djunits4.value;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.djunits4.unit.Unit;

/**
 * Basics of the Scalar type.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit of the values in the constructor and for display
 */
public abstract class Scalar<U extends Unit<U>> extends Number implements Value<U>, Serializable, Cloneable
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /** The display unit of the Scalar. */
    private U unit;

    /** Number pattern regex to be used in valueOf() method. */
    protected static final Pattern NUMBER_PATTERN;

    /** Compile number pattern regex to be used in valueOf() method of derived classes. */
    static
    {
        String regex = "[+-]?\\d+\\.?\\d*([Ee][+-]?\\d+)?";
        NUMBER_PATTERN = Pattern.compile(regex);
    }

    /**
     * Construct a new Scalar.
     * @param unit U; the unit of the new Scalar
     */
    public Scalar(final U unit)
    {
        this.unit = unit;
    }

    /** {@inheritDoc} */
    @Override
    public final U getUnit()
    {
        return this.unit;
    }

    /** {@inheritDoc} */
    @Override
    public final double expressAsSIUnit(final double value)
    {
        if (this.unit.isBaseSIUnit())
        {
            return value;
        }
        return ValueUtil.expressAsSIUnit(value, this.unit);
    }

    /**
     * Convert a value from the standard SI unit into the unit of this Scalar.
     * @param value double; the value to convert
     * @return double; the value in the unit of this Scalar
     */
    protected final double expressAsSpecifiedUnit(final double value)
    {
        if (this.unit.isBaseSIUnit())
        {
            return value;
        }
        return ValueUtil.expressAsUnit(value, this.unit);
    }

    /** {@inheritDoc} */
    @Override
    public void setDisplayUnit(final U newUnit)
    {
        this.unit = newUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isAbsolute()
    {
        return this instanceof Absolute;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isRelative()
    {
        return this instanceof Relative;
    }

    /**
     * Returns a String representation of the scalar value that can be parsed back into its scalar type. The String
     * representation is the double value in the unit, followed by the official abbreviation of the unit without spaces, in the
     * current locale.
     * @param value Scalar&lt;U&gt;; the value to parse into a String
     * @param <U> the unit type for the scalar
     * @return String; the String representation of the value in its unit, followed by one space and the official abbreviation
     *         of the unit
     */
    public static <U extends Unit<U>> String stringOf(final Scalar<U> value)
    {
        return value.expressAsSpecifiedUnit(value.doubleValue()) + " " + value.getUnit().getDefaultDisplayAbbreviation();
    }

    /**
     * Returns a String representation of the scalar value that can be parsed back into its scalar type. The String
     * representation is the double value in the unit, followed by the official abbreviation of the unit without spaces, in the
     * English locale.
     * @param value Scalar&lt;U&gt;; the value to parse into a String
     * @param <U> the unit type for the scalar
     * @return String; the String representation of the value in its unit, followed by one space and the official abbreviation
     *         of the unit
     */
    public static <U extends Unit<U>> String stringOfDefaultLocale(final Scalar<U> value)
    {
        return value.expressAsSpecifiedUnit(value.doubleValue()) + " " + value.getUnit().getDefaultDisplayAbbreviation();
        // TODO: getDefaultLocaleAbbreviation();
    }

    /**
     * Returns a String representation of the scalar value that can be parsed back into its scalar type. The String
     * representation is the double value in the unit, followed by the default textual abbreviation of the unit without spaces,
     * in the current locale.
     * @param value Scalar&lt;U&gt;; the value to parse into a String
     * @param <U> the unit type for the scalar
     * @return String; the String representation of the value in its unit, followed by one space and the official abbreviation
     *         of the unit
     */
    public static <U extends Unit<U>> String textualStringOf(final Scalar<U> value)
    {
        return value.expressAsSpecifiedUnit(value.doubleValue()) + " " + value.getUnit().getDefaultTextualAbbreviation();
    }

    /**
     * Returns a String representation of the scalar value that can be parsed back into its scalar type. The String
     * representation is the double value in the unit, followed by the default textual abbreviation of the unit without spaces,
     * in the English locale.
     * @param value Scalar&lt;U&gt;; the value to parse into a String
     * @param <U> the unit type for the scalar
     * @return String; the String representation of the value in its unit, followed by one space and the official abbreviation
     *         of the unit
     */
    public static <U extends Unit<U>> String textualStringOfDefaultLocale(final Scalar<U> value)
    {
        return value.expressAsSpecifiedUnit(value.doubleValue()) + " " + value.getUnit().getDefaultTextualAbbreviation();
        // TODO: getDefaultLocaleTextualRepresentation();
    }

    // No hashcode or equals -- has to be implemented on a deeper level

}
