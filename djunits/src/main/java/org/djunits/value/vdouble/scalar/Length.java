package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Relative Length DoubleScalar. Instead of:
 * 
 * <pre>
 * DoubleScalar&lt;LengthUnit&gt; value = new DoubleScalar&lt;LengthUnit&gt;(100.0, LengthUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Length value = new Length(100.0, LengthUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Length extends AbstractDoubleScalarRel<LengthUnit, Length>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Length ZERO = new Length(0.0, LengthUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Length NaN = new Length(Double.NaN, LengthUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Length POSITIVE_INFINITY = new Length(Double.POSITIVE_INFINITY, LengthUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Length NEGATIVE_INFINITY = new Length(Double.NEGATIVE_INFINITY, LengthUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Length POS_MAXVALUE = new Length(Double.MAX_VALUE, LengthUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Length NEG_MAXVALUE = new Length(-Double.MAX_VALUE, LengthUnit.SI);

    /**
     * Construct Length scalar.
     * @param value double; double value
     * @param unit LengthUnit; unit for the double value
     */
    public Length(final double value, final LengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Length scalar.
     * @param value Length; Scalar from which to construct this instance
     */
    public Length(final Length value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Length instantiateRel(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit PositionUnit; the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public final Position instantiateAbs(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

    /**
     * Construct Length scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Length createSI(final double value)
    {
        return new Length(value, LengthUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Length; the low value
     * @param one Length; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Length interpolate(final Length zero, final Length one, final double ratio)
    {
        return new Length(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v Position; the value to add
     * @return sum of this value and v as a new object
     */
    public final Position plus(final Position v)
    {
        PositionUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Length; the first scalar
     * @param r2 Length; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Length max(final Length r1, final Length r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Length; the first scalar
     * @param r2 Length; the second scalar
     * @param rn Length...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Length max(final Length r1, final Length r2, final Length... rn)
    {
        Length maxr = (r1.gt(r2)) ? r1 : r2;
        for (Length r : rn)
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
     * @param r1 Length; the first scalar
     * @param r2 Length; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Length min(final Length r1, final Length r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Length; the first scalar
     * @param r2 Length; the second scalar
     * @param rn Length...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Length min(final Length r1, final Length r2, final Length... rn)
    {
        Length minr = (r1.lt(r2)) ? r1 : r2;
        for (Length r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of Length and Length, which results in a Dimensionless scalar.
     * @param v Length; Length scalar
     * @return Dimensionless scalar as a division of Length and Length
     */
    public final Dimensionless divideBy(final Length v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Length and Length, which results in a Area scalar.
     * @param v Length; Length scalar
     * @return Area scalar as a multiplication of Length and Length
     */
    public final Area multiplyBy(final Length v)
    {
        return new Area(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of Length and LinearDensity, which results in a Area scalar.
     * @param v LinearDensity; Length scalar
     * @return Area scalar as a division of Length and LinearDensity
     */
    public final Area divideBy(final LinearDensity v)
    {
        return new Area(this.si / v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of Length and Area, which results in a LinearDensity scalar.
     * @param v Area; Length scalar
     * @return LinearDensity scalar as a division of Length and Area
     */
    public final LinearDensity divideBy(final Area v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Length and Area, which results in a Volume scalar.
     * @param v Area; Length scalar
     * @return Volume scalar as a multiplication of Length and Area
     */
    public final Volume multiplyBy(final Area v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Length and Force, which results in a Energy scalar.
     * @param v Force; Length scalar
     * @return Energy scalar as a multiplication of Length and Force
     */
    public final Energy multiplyBy(final Force v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of Length and Frequency, which results in a Speed scalar.
     * @param v Frequency; Length scalar
     * @return Speed scalar as a multiplication of Length and Frequency
     */
    public final Speed multiplyBy(final Frequency v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Length and Duration, which results in a Speed scalar.
     * @param v Duration; Length scalar
     * @return Speed scalar as a division of Length and Duration
     */
    public final Speed divideBy(final Duration v)
    {
        return new Speed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of Length and Speed, which results in a Duration scalar.
     * @param v Speed; Length scalar
     * @return Duration scalar as a division of Length and Speed
     */
    public final Duration divideBy(final Speed v)
    {
        return new Duration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of Length and MoneyPerLength, which results in a Money scalar.
     * @param v MoneyPerLength; Length scalar
     * @return Money scalar as a multiplication of Length and MoneyPerLength
     */
    public final Money multiplyBy(final MoneyPerLength v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
