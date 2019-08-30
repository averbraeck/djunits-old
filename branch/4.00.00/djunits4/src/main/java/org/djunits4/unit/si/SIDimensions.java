package org.djunits4.unit.si;

import java.io.Serializable;
import java.util.Arrays;

import org.djunits4.Throw;
import org.djunits4.unit.util.UnitException;

/**
 * SIDimensions stores the dimensionality of a unit using the SI standards. Angle (rad) and solid angle (sr) have been added to
 * be able to specify often used units regarding rotation.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIDimensions implements Serializable
{
    /** */
    private static final long serialVersionUID = 20190818L;

    /** the number of dimensions we take into account (currently 9: rad, sr, kg, m, s, A, K, mol, cd. */
    public static final int NUMBER_DIMENSIONS = 9;

    /** the default denominator which consists of all "1"s. */
    private static final byte[] UNIT_DENOMINATOR = new byte[] {1, 1, 1, 1, 1, 1, 1, 1, 1};

    /** The abbreviations of the SI units we use in SIDimensions. */
    public static final String[] SI_ABBREVIATIONS = new String[] {"rad", "sr", "kg", "m", "s", "A", "K", "mol", "cd"};

    /**
     * The currently 9 dimensions of the SI unit we distinguish: 0: angle (rad), 1: solid angle (sr), 2: mass (kg), 3: length
     * (m), 4: time (s), 5: current (A), 6: temperature (K), 7: amount of substance (mol), 8: luminous intensity (cd). As an
     * example, speed is indicated as length = 1; time = -1.
     */
    private final byte[] dimensions;

    /** In case the dimensions are fractional, the denominator will contain values different from 1. */
    private final byte[] denominator;

    /** stores whether the dimensions are fractional or not. */
    private final boolean fractional;

    /**
     * Create an immutable SIDimensions instance based on a safe copy of a given dimensions specification. As an example, speed
     * is indicated as length = 1; time = -1 with the other dimensions equal to zero.
     * @param dimensions byte[]; The currently 9 dimensions of the SI unit we distinguish: 0: angle (rad), 1: solid angle (sr),
     *            2: mass (kg), 3: length (m), 4: time (s), 5: current (A), 6: temperature (K), 7: amount of substance (mol), 8:
     *            luminous intensity (cd).
     */
    public SIDimensions(final byte[] dimensions)
    {
        Throw.whenNull(dimensions, "dimensions cannot be null");
        Throw.when(dimensions.length != NUMBER_DIMENSIONS, SIRuntimeException.class, "SIDimensions wrong dimensionality");
        this.dimensions = dimensions.clone(); // safe copy
        this.denominator = UNIT_DENOMINATOR;
        this.fractional = false;
    }

    /**
     * Create an immutable fractional SIDimensions instance based on a safe copy of a given specification, separated in a
     * numerator and a denominator.
     * @param numerator byte[]; The currently 9 dimensions of the SI unit we distinguish: 0: angle (rad), 1: solid angle (sr),
     *            2: mass (kg), 3: length (m), 4: time (s), 5: current (A), 6: temperature (K), 7: amount of substance (mol), 8:
     *            luminous intensity (cd).
     * @param denominator byte[]; The currently 9 dimensions of the SI unit we distinguish: 0: angle (rad), 1: solid angle (sr),
     *            2: mass (kg), 3: length (m), 4: time (s), 5: current (A), 6: temperature (K), 7: amount of substance (mol), 8:
     *            luminous intensity (cd).
     */
    protected SIDimensions(final byte[] numerator, final byte[] denominator)
    {
        // TODO: all operators on fractional dimensions
        Throw.whenNull(numerator, "numerator cannot be null");
        Throw.whenNull(denominator, "denominator cannot be null");
        Throw.when(numerator.length != NUMBER_DIMENSIONS, SIRuntimeException.class, "numerator wrong dimensionality");
        Throw.when(denominator.length != NUMBER_DIMENSIONS, SIRuntimeException.class, "denominator wrong dimensionality");
        this.dimensions = numerator.clone(); // safe copy
        this.denominator = denominator.clone(); // safe copy
        this.fractional = !Arrays.equals(denominator, UNIT_DENOMINATOR);
    }

    /**
     * Create an immutable SIDimensions instance based on a safe copy of a given dimensions specification.
     * @param angle int; dimension of the angle (rad)
     * @param solidAngle int; dimension of the solidAngle (sr)
     * @param mass int; dimension of the mass (kg)
     * @param length int; dimension of the length (m)
     * @param time int; dimension of the time (s)
     * @param current int; dimension of the current (A)
     * @param temperature int; dimension of the temperature (K)
     * @param amountOfSubstance int; dimension of the amount of substance (mol)
     * @param luminousIntensity int; dimension of the luminous intensity (cd)
     */
    @SuppressWarnings("checkstyle:parameternumber")
    public SIDimensions(final int angle, final int solidAngle, final int mass, final int length, final int time,
            final int current, final int temperature, final int amountOfSubstance, final int luminousIntensity)
    {
        this.dimensions = new byte[NUMBER_DIMENSIONS];
        this.dimensions[0] = (byte) angle;
        this.dimensions[1] = (byte) solidAngle;
        this.dimensions[2] = (byte) mass;
        this.dimensions[3] = (byte) length;
        this.dimensions[4] = (byte) time;
        this.dimensions[5] = (byte) current;
        this.dimensions[6] = (byte) temperature;
        this.dimensions[7] = (byte) amountOfSubstance;
        this.dimensions[8] = (byte) luminousIntensity;
        this.denominator = UNIT_DENOMINATOR;
        this.fractional = false;
    }

    /**
     * Translate a string representing SI dimensions to an SIDimensions object. Example: SIDimensions.of("kgm/s2") and
     * SIDimensions.of("kgms-2") will both be translated to a dimensions object with vector {0,0,1,1,-2,0,0,0,0}. It is allowed
     * to use 0 or 1 for the dimensions. Having the same unit in the numerator and the denominator is not seen as a problem: the
     * values are subtracted from each other, so m/m will have a length dimensionality of 0. Dimensions between -9 and 9 are
     * allowed.
     * @param siString String; the string to translate
     * @return the corresponding SI dimensions
     * @throws UnitException when the string could not be parsed into dimensions
     */
    public static SIDimensions of(final String siString) throws UnitException
    {
        Throw.whenNull(siString, "siString cannot be null");
        // TODO: remove ^ and .
        // TODO: fractional: ^(-1/2)
        if (siString.contains("/"))
        {
            String[] parts = siString.split("\\/");
            if (parts.length != 2)
            {
                throw new UnitException("SI String " + siString + " contains more than one division sign");
            }
            byte[] numerator = parse(parts[0]);
            byte[] denominator = parse(parts[1]);
            for (int i = 0; i < NUMBER_DIMENSIONS; i++)
            {
                numerator[i] -= denominator[i];
            }
            return new SIDimensions(numerator);
        }
        return new SIDimensions(parse(siString));
    }

    /**
     * Translate a string representing SI dimensions to an SIDimensions object. Example: SIDimensions.of("kgm2") is translated
     * to a vector {0,0,1,2,0,0,0,0,0}. It is allowed to use 0 or 1 for the dimensions. Dimensions between -9 and 9 are allowed.
     * @param siString String; concatenation of SI units with positive or negative dimensions. No divisions sign is allowed.
     * @return a vector of length NUMBER_DIMENSIONS with the dimensions for the SI units
     * @throws UnitException when the String cannot be parsed, e.g. due to units not being recognized
     */
    private static byte[] parse(final String siString) throws UnitException
    {
        Throw.whenNull(siString, "siString cannot be null");
        byte[] dim = new byte[NUMBER_DIMENSIONS];
        if (siString.equals("1") || siString.length() == 0)
        {
            return dim;
        }
        String copy = siString;
        for (int i = 0; i < SI_ABBREVIATIONS.length; i++)
        {
            String si = SI_ABBREVIATIONS[i];
            if (copy.startsWith(si))
            {
                copy = copy.substring(si.length());
                if (copy.length() == 0)
                {
                    dim[i] = 1;
                }
                else if (copy.startsWith("-"))
                {
                    if (copy.length() == 1)
                    {
                        throw new UnitException("SI string " + siString + " ends with a minus sign");
                    }
                    if (Character.isDigit(copy.charAt(1)))
                    {
                        dim[i] = (byte) (-1 * (copy.charAt(1) - '0'));
                    }
                    else
                    {
                        throw new UnitException(
                                "SI string " + siString + " has a minus sign for unit " + si + " but no dimension");
                    }
                    copy = copy.substring(2);
                }
                else if (Character.isDigit(copy.charAt(0)))
                {
                    dim[i] = (byte) (copy.charAt(0) - '0');
                    copy = copy.substring(1);
                }
                else
                {
                    dim[i] = 1;
                }
            }
        }
        if (copy.length() != 0)
        {
            throw new UnitException("Trailing information in SI string " + siString);
        }
        return dim;
    }

    /**
     * Add a set of SI dimensions to this SIDimensions. Note: as dimensions are considered to be immutable, a new dimension is
     * returned. The original dimension remains unaltered.
     * @param dim2 the dimensions to add (usually as a result of multiplication of scalars)
     * @return the new dimensions with the dimensions of this object plus the dimensions in the parameter
     */
    public SIDimensions plus(final SIDimensions dim2)
    {
        byte[] dim = new byte[NUMBER_DIMENSIONS];
        for (int i = 0; i < NUMBER_DIMENSIONS; i++)
        {
            dim[i] = (byte) (this.dimensions[i] + dim2.dimensions[i]);
        }
        return new SIDimensions(dim);
    }

    /**
     * Subtract a set of SI dimensions from this SIDimensions. Note: as dimensions are considered to be immutable, a new
     * dimension is returned. The original dimension remains unaltered.
     * @param dim2 the dimensions to add (usually as a result of multiplication of scalars)
     * @return the new dimensions with the dimensions of this object minus the dimensions in the parameter
     */
    public SIDimensions minus(final SIDimensions dim2)
    {
        byte[] dim = new byte[NUMBER_DIMENSIONS];
        for (int i = 0; i < NUMBER_DIMENSIONS; i++)
        {
            dim[i] = (byte) (this.dimensions[i] - dim2.dimensions[i]);
        }
        return new SIDimensions(dim);
    }

    /**
     * Invert a set of SI dimensions; instead of m/s we get s/m. Note: as dimensions are considered to be immutable, a new
     * dimension is returned. The original dimension remains unaltered.
     * @return the new dimensions that are the inverse of the dimensions in this object
     */
    public SIDimensions invert()
    {
        byte[] dim = new byte[NUMBER_DIMENSIONS];
        for (int i = 0; i < NUMBER_DIMENSIONS; i++)
        {
            dim[i] = (byte) (-this.dimensions[i]);
        }
        return new SIDimensions(dim);
    }

    /**
     * Add two SIDimensions and return the new SIDimensions. Usually, dimensions are added as a result of multiplication of
     * scalars.
     * @param dim1 the first set of dimensions
     * @param dim2 the second set of dimensions
     * @return the new dimensions with the sum of the dimensions in the parameters
     */
    public static SIDimensions add(final SIDimensions dim1, final SIDimensions dim2)
    {
        byte[] dim = new byte[NUMBER_DIMENSIONS];
        for (int i = 0; i < NUMBER_DIMENSIONS; i++)
        {
            dim[i] = (byte) (dim1.dimensions[i] + dim2.dimensions[i]);
        }
        return new SIDimensions(dim);
    }

    /**
     * Subtract an SIDimensions (dim2) from another SIDimensions (dim1) and return the new SIDimensions. Usually, dimensions are
     * added as a result of division of scalars.
     * @param dim1 the first set of dimensions
     * @param dim2 the second set of dimensions that will be subtracted from dim1
     * @return the new dimensions with the difference of the dimensions in the parameters
     */
    public static SIDimensions subtract(final SIDimensions dim1, final SIDimensions dim2)
    {
        byte[] dim = new byte[NUMBER_DIMENSIONS];
        for (int i = 0; i < NUMBER_DIMENSIONS; i++)
        {
            dim[i] = (byte) (dim1.dimensions[i] - dim2.dimensions[i]);
        }
        return new SIDimensions(dim);
    }

    /**
     * Indicate whether this SIDImensions contains one or more fractional dimensions.
     * @return boolean; whether this SIDImensions contains one or more fractional dimensions
     */
    public boolean isFractional()
    {
        return this.fractional;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.denominator);
        result = prime * result + Arrays.hashCode(this.dimensions);
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
        SIDimensions other = (SIDimensions) obj;
        if (!Arrays.equals(this.denominator, other.denominator))
            return false;
        if (!Arrays.equals(this.dimensions, other.dimensions))
            return false;
        return true;
    }

    /**
     * Return a string such as "kgm/s2" or "kg.m/s^2" or "kg.m.s^-2" from this SIDimensions.
     * @param divided if true, return m/s2 for acceleration; if false return ms-2
     * @param separator if true, add dots between successive units, e.g. kg.m.s-2 instead of kgms-2
     * @return a 'divided' string from this SIDimensions
     */
    public String toString(final boolean divided, final boolean separator)
    // TODO: final String separator, final String powerPrefix, final String powerPostfix)
    {
        StringBuffer s = new StringBuffer();
        boolean first = true;
        boolean negative = false;
        for (int i = 0; i < NUMBER_DIMENSIONS; i++)
        {
            if (this.dimensions[i] < 0)
            {
                negative = true;
            }
            if ((!divided && this.dimensions[i] != 0) || (divided && this.dimensions[i] > 0))
            {
                if (!first && separator)
                {
                    s.append(".");
                }
                else
                {
                    first = false;
                }
                s.append(SI_ABBREVIATIONS[i]);
                if (this.dimensions[i] != 1)
                {
                    s.append(this.dimensions[i]);
                }
            }
        }
        if (s.length() == 0)
        {
            s.append("1");
        }
        if (divided && negative)
        {
            s.append("/");
        }
        if (divided)
        {
            first = true;
            for (int i = 0; i < NUMBER_DIMENSIONS; i++)
            {
                if (this.dimensions[i] < 0)
                {
                    if (!first && separator)
                    {
                        s.append(".");
                    }
                    else
                    {
                        first = false;
                    }
                    s.append(SI_ABBREVIATIONS[i]);
                    if (this.dimensions[i] < -1)
                    {
                        s.append(-this.dimensions[i]);
                    }
                }
            }
        }
        return s.toString();
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        if (this.fractional)
        {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int i = 0; i < NUMBER_DIMENSIONS; i++)
            {
                if (i > 0)
                {
                    sb.append(", ");
                }
                if (this.denominator[i] != 1 && this.dimensions[i] != 0)
                {
                    sb.append(this.dimensions[i] + "/" + this.denominator[i]);
                }
                else
                {
                    sb.append(this.dimensions[i]);
                }
            }
            sb.append("]");
            return sb.toString();
        }
        else
        {
            return Arrays.toString(this.dimensions);
        }
    }
}
