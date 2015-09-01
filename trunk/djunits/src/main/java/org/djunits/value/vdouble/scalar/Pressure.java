package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Pressure DoubleScalar. Instead of <br>
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
public interface Pressure extends UNITS
{
    /**
     * Easy access methods for the Pressure DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<PressureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Pressure.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final PressureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Pressure.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<PressureUnit> value)
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
        public static Pressure.Rel interpolate(final Pressure.Rel zero, final Pressure.Rel one, final double ratio)
        {
            return new Pressure.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel abs()
        {
            return new Pressure.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel acos()
        {
            return new Pressure.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel asin()
        {
            return new Pressure.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel atan()
        {
            return new Pressure.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel cbrt()
        {
            return new Pressure.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel ceil()
        {
            return new Pressure.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel cos()
        {
            return new Pressure.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel cosh()
        {
            return new Pressure.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel exp()
        {
            return new Pressure.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel expm1()
        {
            return new Pressure.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel floor()
        {
            return new Pressure.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel log()
        {
            return new Pressure.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel log10()
        {
            return new Pressure.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel log1p()
        {
            return new Pressure.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel rint()
        {
            return new Pressure.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel round()
        {
            return new Pressure.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel signum()
        {
            return new Pressure.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel sin()
        {
            return new Pressure.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel sinh()
        {
            return new Pressure.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel sqrt()
        {
            return new Pressure.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel tan()
        {
            return new Pressure.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel tanh()
        {
            return new Pressure.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel inv()
        {
            return new Pressure.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel toDegrees()
        {
            return new Pressure.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel toRadians()
        {
            return new Pressure.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel pow(final double x)
        {
            return new Pressure.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel multiplyBy(final double factor)
        {
            return new Pressure.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel divideBy(final double divisor)
        {
            return new Pressure.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Pressure.Rel plus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Pressure.Rel(this.si + v.si, PressureUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Pressure.Rel minus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Pressure.Rel(this.si - v.si, PressureUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Pressure.Abs plus(final Pressure.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Pressure.Abs(this.si + v.si, PressureUnit.SI);
        }

        /**
         * @param v Pressure scalar
         * @return Dimensionless scalar as a division of Pressure and Pressure
         */
        public final Dimensionless.Rel divideBy(final Pressure.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v Pressure scalar
         * @return Force scalar as a multiplication of Pressure and Area
         */
        public final Force.Rel multiplyBy(final Area.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * @param v Pressure scalar
         * @return Energy scalar as a multiplication of Pressure and Volume
         */
        public final Energy.Rel multiplyBy(final Volume.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

    }

    /**
     * Easy access methods for the Pressure DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<PressureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Pressure.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final PressureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Pressure.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<PressureUnit> value)
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
        public static Pressure.Abs interpolate(final Pressure.Abs zero, final Pressure.Abs one, final double ratio)
        {
            return new Pressure.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs abs()
        {
            return new Pressure.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs acos()
        {
            return new Pressure.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs asin()
        {
            return new Pressure.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs atan()
        {
            return new Pressure.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs cbrt()
        {
            return new Pressure.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs ceil()
        {
            return new Pressure.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs cos()
        {
            return new Pressure.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs cosh()
        {
            return new Pressure.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs exp()
        {
            return new Pressure.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs expm1()
        {
            return new Pressure.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs floor()
        {
            return new Pressure.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs log()
        {
            return new Pressure.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs log10()
        {
            return new Pressure.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs log1p()
        {
            return new Pressure.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs rint()
        {
            return new Pressure.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs round()
        {
            return new Pressure.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs signum()
        {
            return new Pressure.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs sin()
        {
            return new Pressure.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs sinh()
        {
            return new Pressure.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs sqrt()
        {
            return new Pressure.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs tan()
        {
            return new Pressure.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs tanh()
        {
            return new Pressure.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs inv()
        {
            return new Pressure.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs toDegrees()
        {
            return new Pressure.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs toRadians()
        {
            return new Pressure.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs pow(final double x)
        {
            return new Pressure.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs multiplyBy(final double factor)
        {
            return new Pressure.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs divideBy(final double divisor)
        {
            return new Pressure.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Pressure.Abs plus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Pressure.Abs(this.si + v.si, PressureUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Pressure.Rel minus(final Pressure.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Pressure.Rel(this.si - v.si, PressureUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Pressure.Abs minus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Pressure.Abs(this.si - v.si, PressureUnit.SI);
        }

        /**
         * @param v Pressure scalar
         * @return Dimensionless scalar as a division of Pressure and Pressure
         */
        public final Dimensionless.Abs divideBy(final Pressure.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v Pressure scalar
         * @return Force scalar as a multiplication of Pressure and Area
         */
        public final Force.Abs multiplyBy(final Area.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * @param v Pressure scalar
         * @return Energy scalar as a multiplication of Pressure and Volume
         */
        public final Energy.Abs multiplyBy(final Volume.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

    }
}
