package org.djunits.value.vfloat.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass.Rel margin = new Mass.Rel(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Float%Type%
{
    /**
     * Easy access methods for the %Type% FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;%Type%Unit&gt; value = new FloatScalar.Rel&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>Float%Type%.Rel value = new Float%Type%.Rel(100.0, %Type%Unit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Rel extends TypedFloatScalarRel<%Type%Unit, Float%Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Float%Type%.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Float%Type%.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final Float%Type%.Rel value)
        {
            super(value);
        }

        /**
         * Construct Float%Type%.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final %Type%Unit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%.Rel instantiateTypeRel(final float value, final %Type%Unit unit)
        {
            return new Float%Type%.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final Float%Type%.Abs instantiateTypeAbs(final float value, final %Type%Unit unit)
        {
            return new Float%Type%.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Float%Type%.Rel interpolate(final Float%Type%.Rel zero, final Float%Type%.Rel one, final float ratio)
        {
            return new Float%Type%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }
        
        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final  Float%Type%.Abs plus(final Float%Type%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %type% scalar.
         */
        public final Float%Type%.Abs toAbs()
        {
            return new Float%Type%.Abs(getInUnit(), getUnit());
        }

%FORMULAS%%Type%.Rel%
    }

    /**
     * Easy access methods for the %Type% FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;%Type%Unit&gt; value = new FloatScalar.Abs&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>Float%Type%.Abs value = new Float%Type%.Abs(100.0, %Type%Unit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Abs extends TypedFloatScalarAbs<%Type%Unit, Float%Type%.Abs, Float%Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Float%Type%.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Float%Type%.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final %Type%Unit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Float%Type%.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final Float%Type%.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%.Abs instantiateTypeAbs(final float value, final %Type%Unit unit)
        {
            return new Float%Type%.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Float%Type%.Rel instantiateTypeRel(final float value, final %Type%Unit unit)
        {
            return new Float%Type%.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Float%Type%.Abs interpolate(final Float%Type%.Abs zero, final Float%Type%.Abs one, final float ratio)
        {
            return new Float%Type%.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }
        
%FORMULAS%%Type%.Abs%
    }
}

