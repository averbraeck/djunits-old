package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the AnglePlane DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass.Rel margin = new Mass.Rel(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AnglePlane extends UNITS
{
    /**
     * Easy access methods for the AnglePlane DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
     * we can now write <br>
     * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Rel extends DoubleScalar.Rel<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AnglePlane.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AnglePlane.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<AnglePlaneUnit> value)
        {
            super(value);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AnglePlane.Rel interpolate(final AnglePlane.Rel zero, final AnglePlane.Rel one, final double ratio)
        {
            return new AnglePlane.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel abs()
        {
            return new AnglePlane.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel acos()
        {
            return new AnglePlane.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel asin()
        {
            return new AnglePlane.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel atan()
        {
            return new AnglePlane.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel cbrt()
        {
            return new AnglePlane.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel ceil()
        {
            return new AnglePlane.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel cos()
        {
            return new AnglePlane.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel cosh()
        {
            return new AnglePlane.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel exp()
        {
            return new AnglePlane.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel expm1()
        {
            return new AnglePlane.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel floor()
        {
            return new AnglePlane.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel log()
        {
            return new AnglePlane.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel log10()
        {
            return new AnglePlane.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel log1p()
        {
            return new AnglePlane.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel rint()
        {
            return new AnglePlane.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel round()
        {
            return new AnglePlane.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel signum()
        {
            return new AnglePlane.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel sin()
        {
            return new AnglePlane.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel sinh()
        {
            return new AnglePlane.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel sqrt()
        {
            return new AnglePlane.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel tan()
        {
            return new AnglePlane.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel tanh()
        {
            return new AnglePlane.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel inv()
        {
            return new AnglePlane.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel toDegrees()
        {
            return new AnglePlane.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel toRadians()
        {
            return new AnglePlane.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel pow(final double x)
        {
            return new AnglePlane.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel multiplyBy(final double factor)
        {
            return new AnglePlane.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Rel divideBy(final double divisor)
        {
            return new AnglePlane.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AnglePlane.Rel plus(final AnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AnglePlane.Rel(getInUnit() + v.getInUnit(), getUnit())
                    : new AnglePlane.Rel(this.si + v.si, AnglePlaneUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AnglePlane.Rel minus(final AnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AnglePlane.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new AnglePlane.Rel(this.si - v.si, AnglePlaneUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AnglePlane.Abs plus(final AnglePlane.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new AnglePlane.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new AnglePlane.Abs(this.si + v.si, AnglePlaneUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleplane scalar.
         */
        public final AnglePlane.Abs toAbs()
        {
            return new AnglePlane.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AnglePlane and AnglePlane, which results in a Dimensionless scalar.
         * @param v AnglePlane scalar
         * @return Dimensionless scalar as a division of AnglePlane and AnglePlane
         */
        public final Dimensionless.Rel divideBy(final AnglePlane.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AnglePlane DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
     * we can now write <br>
     * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Abs extends DoubleScalar.Abs<AnglePlaneUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AnglePlane.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AnglePlane.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<AnglePlaneUnit> value)
        {
            super(value);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AnglePlane.Abs interpolate(final AnglePlane.Abs zero, final AnglePlane.Abs one, final double ratio)
        {
            return new AnglePlane.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs abs()
        {
            return new AnglePlane.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs acos()
        {
            return new AnglePlane.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs asin()
        {
            return new AnglePlane.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs atan()
        {
            return new AnglePlane.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs cbrt()
        {
            return new AnglePlane.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs ceil()
        {
            return new AnglePlane.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs cos()
        {
            return new AnglePlane.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs cosh()
        {
            return new AnglePlane.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs exp()
        {
            return new AnglePlane.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs expm1()
        {
            return new AnglePlane.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs floor()
        {
            return new AnglePlane.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs log()
        {
            return new AnglePlane.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs log10()
        {
            return new AnglePlane.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs log1p()
        {
            return new AnglePlane.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs rint()
        {
            return new AnglePlane.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs round()
        {
            return new AnglePlane.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs signum()
        {
            return new AnglePlane.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs sin()
        {
            return new AnglePlane.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs sinh()
        {
            return new AnglePlane.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs sqrt()
        {
            return new AnglePlane.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs tan()
        {
            return new AnglePlane.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs tanh()
        {
            return new AnglePlane.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs inv()
        {
            return new AnglePlane.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs toDegrees()
        {
            return new AnglePlane.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs toRadians()
        {
            return new AnglePlane.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs pow(final double x)
        {
            return new AnglePlane.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs multiplyBy(final double factor)
        {
            return new AnglePlane.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final AnglePlane.Abs divideBy(final double divisor)
        {
            return new AnglePlane.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AnglePlane.Abs plus(final AnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AnglePlane.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new AnglePlane.Abs(this.si + v.si, AnglePlaneUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AnglePlane.Rel minus(final AnglePlane.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new AnglePlane.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new AnglePlane.Rel(this.si - v.si, AnglePlaneUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final AnglePlane.Abs minus(final AnglePlane.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new AnglePlane.Abs(getInUnit() - v.getInUnit(), getUnit())
                    : new AnglePlane.Abs(this.si - v.si, AnglePlaneUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute angleplane scalar.
         */
        public final AnglePlane.Rel toRel()
        {
            return new AnglePlane.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AnglePlane and AnglePlane, which results in a Dimensionless scalar.
         * @param v AnglePlane scalar
         * @return Dimensionless scalar as a division of AnglePlane and AnglePlane
         */
        public final Dimensionless.Abs divideBy(final AnglePlane.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

    }
}
