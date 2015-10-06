    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * the result is stored in a new Relative value. If both operands are dense, the result is a dense vector or matrix,
     * otherwise the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final %Result%Vector%ResultDotRel% times(final %Argument%Vector%ArgumentDotRel% rel) throws ValueException
    {
        return %Result%Vector.instantiate%ResultRel%(this.getData().times(rel.getData()), getUnit());
    }
