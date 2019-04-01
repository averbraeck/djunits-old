    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless acos()
    {
        return instantiateRel((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless asin()
    {
        return instantiateRel((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless atan()
    {
        return instantiateRel((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless cbrt()
    {
        return instantiateRel((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless cos()
    {
        return instantiateRel((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless cosh()
    {
        return instantiateRel((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless exp()
    {
        return instantiateRel((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless expm1()
    {
        return instantiateRel((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless log()
    {
        return instantiateRel((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless log10()
    {
        return instantiateRel((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless log1p()
    {
        return instantiateRel((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless pow(final double x)
    {
        return instantiateRel((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless signum()
    {
        return instantiateRel(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless sin()
    {
        return instantiateRel((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless sinh()
    {
        return instantiateRel((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless sqrt()
    {
        return instantiateRel((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless tan()
    {
        return instantiateRel((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless tanh()
    {
        return instantiateRel((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionless inv()
    {
        return instantiateRel(1.0f / getInUnit(), getUnit());
    }
