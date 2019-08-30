package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Volume DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;VolumeUnit&gt; value = new DoubleScalar.Rel&lt;VolumeUnit&gt;(100.0,
 * VolumeUnit.SI);</pre>
 * we can now write:
 * <pre>Volume value = new Volume(100.0, VolumeUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Volume extends AbstractDoubleScalarRel<VolumeUnit, Volume> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Volume ZERO = new Volume(0.0, VolumeUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Volume NaN = new Volume(Double.NaN, VolumeUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Volume POSITIVE_INFINITY = new Volume(Double.POSITIVE_INFINITY, VolumeUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Volume NEGATIVE_INFINITY = new Volume(Double.NEGATIVE_INFINITY, VolumeUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Volume POS_MAXVALUE = new Volume(Double.MAX_VALUE, VolumeUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Volume NEG_MAXVALUE = new Volume(-Double.MAX_VALUE, VolumeUnit.SI);

    /**
     * Construct Volume scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Volume(final double value, final VolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Volume scalar.
     * @param value Scalar from which to construct this instance
     */
    public Volume(final Volume value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Volume instantiateRel(final double value, final VolumeUnit unit)
    {
        return new Volume(value, unit);
    }

    /**
     * Construct Volume scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Volume createSI(final double value)
    {
        return new Volume(value, VolumeUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Volume interpolate(final Volume zero, final Volume one, final double ratio)
    {
        return new Volume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Volume max(final Volume r1, final Volume r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Volume max(final Volume r1, final Volume r2, final Volume... rn)
    {
        Volume maxr = (r1.gt(r2)) ? r1 : r2;
        for (Volume r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Volume min(final Volume r1, final Volume r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Volume min(final Volume r1, final Volume r2, final Volume... rn)
    {
        Volume minr = (r1.lt(r2)) ? r1 : r2;
        for (Volume r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Volume representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a Volume
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Volume valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Volume -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (VolumeUnit unit : VolumeUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Volume(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Volume from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Volume from " + text);
    }
    
            /**
         * Calculate the division of Volume and Volume, which results in a Dimensionless scalar.
         * @param v Volume scalar
         * @return Dimensionless scalar as a division of Volume and Volume
         */
        public final Dimensionless divideBy(final Volume v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and Density, which results in a Mass scalar.
         * @param v Volume scalar
         * @return Mass scalar as a multiplication of Volume and Density
         */
        public final Mass multiplyBy(final Density v)
        {
            return new Mass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and Pressure, which results in a Energy scalar.
         * @param v Volume scalar
         * @return Energy scalar as a multiplication of Volume and Pressure
         */
        public final Energy multiplyBy(final Pressure v)
        {
            return new Energy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Volume and Length, which results in a Area scalar.
         * @param v Volume scalar
         * @return Area scalar as a division of Volume and Length
         */
        public final Area divideBy(final Length v)
        {
            return new Area(this.si / v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Volume and Area, which results in a Length scalar.
         * @param v Volume scalar
         * @return Length scalar as a division of Volume and Area
         */
        public final Length divideBy(final Area v)
        {
            return new Length(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and LinearDensity, which results in a Area scalar.
         * @param v Volume scalar
         * @return Area scalar as a multiplication of Volume and LinearDensity
         */
        public final Area multiplyBy(final LinearDensity v)
        {
            return new Area(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Volume and Duration, which results in a FlowVolume scalar.
         * @param v Volume scalar
         * @return FlowVolume scalar as a division of Volume and Duration
         */
        public final FlowVolume divideBy(final Duration v)
        {
            return new FlowVolume(this.si / v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the division of Volume and FlowVolume, which results in a Duration scalar.
         * @param v Volume scalar
         * @return Duration scalar as a division of Volume and FlowVolume
         */
        public final Duration divideBy(final FlowVolume v)
        {
            return new Duration(this.si / v.si, DurationUnit.SI);
        }


}

