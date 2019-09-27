package org.djunits4.value.vfloat.matrix.base;

import org.djunits4.unit.Unit;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.scalar.base.FloatScalarInterface;

/**
 * Data point for a matrix that can be used for constructing sparse matrices.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit type of the value
 * @param <S> the scalar type of the value
 */
public class FloatSparseValue<U extends Unit<U>, S extends FloatScalarInterface<U, S>>
{
    /** the row in the matrix. */
    private final int row;

    /** the column in the matrix. */
    private final int column;

    /** the value of the data point in the matrix. */
    private final float valueSI;

    /**
     * Create a data point for a sparse matrix.
     * @param row the row of the sparse data point in the matrix
     * @param column the column of the sparse data point in the matrix
     * @param value the value in the given unit of the data point in the matrix
     */
    public FloatSparseValue(final int row, final int column, final S value)
    {
        super();
        this.row = row;
        this.column = column;
        this.valueSI = value.getSI();
    }

    /**
     * Create a data point for a sparse matrix.
     * @param row the row of the sparse data point in the matrix
     * @param column the column of the sparse data point in the matrix
     * @param valueInUnit the value in the given unit of the data point in the matrix
     * @param unit the unit of the value
     */
    public FloatSparseValue(final int row, final int column, final float valueInUnit, final U unit)
    {
        super();
        this.row = row;
        this.column = column;
        this.valueSI = (float) ValueUtil.expressAsSIUnit(valueInUnit, unit);
    }

    /**
     * Create a data point for a sparse matrix.
     * @param row the row of the sparse data point in the matrix
     * @param column the column of the sparse data point in the matrix
     * @param valueSI the SI value of the data point in the matrix
     */
    public FloatSparseValue(final int row, final int column, final float valueSI)
    {
        super();
        this.row = row;
        this.column = column;
        this.valueSI = valueSI;
    }

    /**
     * @return the row in the matrix
     */
    public final int getRow()
    {
        return this.row;
    }

    /**
     * @return the column in the matrix
     */
    public final int getColumn()
    {
        return this.column;
    }

    /**
     * @return the SI value of the data point in the matrix
     */
    public final float getValueSI()
    {
        return this.valueSI;
    }
}