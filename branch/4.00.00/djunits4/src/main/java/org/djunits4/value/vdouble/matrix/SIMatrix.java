package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.SIUnit;
import org.djunits4.value.vdouble.scalar.SIScalar;

/**
 * SIMatrix.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIMatrix extends AbstractDoubleMatrixRel<SIUnit, SIMatrix, SIMatrix.Mutable, SIScalar>
{

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * @param data d
     * @param unit u
     */
    SIMatrix(DoubleMatrixData data, SIUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public DoubleMatrixInterface<SIUnit> toDense()
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public DoubleMatrixInterface<SIUnit> toSparse()
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    protected SIMatrix instantiateType(DoubleMatrixData dmd, SIUnit unit)
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    protected Mutable instantiateMutableType(DoubleMatrixData dmd, SIUnit unit)
    {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    protected SIScalar instantiateScalar(double value, SIUnit unit)
    {
        return null;
    }

    /**
     * SIMatrix.Mutable.
     * <p>
     * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
     * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
     * <p>
     * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
     */
    public static class Mutable extends AbstractMutableDoubleMatrixRel<SIUnit, SIMatrix, SIMatrix.Mutable, SIScalar>
    {
        /** */
        private static final long serialVersionUID = 1L;

        /**
         * @param data d 
         * @param unit u
         */
        Mutable(DoubleMatrixData data, SIUnit unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        public DoubleMatrixInterface<SIUnit> toDense()
        {
            return null;
        }

        /** {@inheritDoc} */
        @Override
        public DoubleMatrixInterface<SIUnit> toSparse()
        {
            return null;
        }

        /** {@inheritDoc} */
        @Override
        protected SIMatrix instantiateType(DoubleMatrixData dmd, SIUnit unit)
        {
            return null;
        }

        /** {@inheritDoc} */
        @Override
        protected Mutable instantiateMutableType(DoubleMatrixData dmd, SIUnit unit)
        {
            return null;
        }

        /** {@inheritDoc} */
        @Override
        protected SIScalar instantiateScalar(double value, SIUnit unit)
        {
            return null;
        }
        
    }
}

