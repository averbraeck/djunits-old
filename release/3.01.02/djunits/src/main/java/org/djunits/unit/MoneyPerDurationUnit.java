package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerDurationUnit defines a unit for the cost or benefit per time, e.g. wage per hour.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerDurationUnit extends LinearUnit<MoneyPerDurationUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per time unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of time for the money per time unit, e.g., hour. */
    private final DurationUnit durationUnit;

    /** Euro per hour. */
    public static final MoneyPerDurationUnit EUR_PER_HOUR;

    /** Euro per day. */
    public static final MoneyPerDurationUnit EUR_PER_DAY;

    /** US$ per hour. */
    public static final MoneyPerDurationUnit USD_PER_HOUR;

    /** US$ per day. */
    public static final MoneyPerDurationUnit USD_PER_DAY;

    /** The standard unit to use. */
    private static MoneyPerDurationUnit standardMoneyPerDurationUnit;

    static
    {
        EUR_PER_HOUR = new MoneyPerDurationUnit(MoneyUnit.EUR, DurationUnit.HOUR, "EUR/h", "\u20AC/h");
        EUR_PER_DAY = new MoneyPerDurationUnit(MoneyUnit.EUR, DurationUnit.DAY, "EUR/day", "\u20AC/day");
        USD_PER_HOUR = new MoneyPerDurationUnit(MoneyUnit.USD, DurationUnit.HOUR, "US$/h", "US$/h");
        USD_PER_DAY = new MoneyPerDurationUnit(MoneyUnit.USD, DurationUnit.DAY, "US$/day", "US$/day");
        standardMoneyPerDurationUnit = EUR_PER_HOUR;
    }

    /**
     * Build a money per time unit from a money unit and an time unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per time unit, e.g., EUR
     * @param durationUnit DurationUnit; the unit of time for the money per time unit, e.g., hour
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     */
    private MoneyPerDurationUnit(final MoneyUnit moneyUnit, final DurationUnit durationUnit, final String abbreviationKey)
    {
        super(abbreviationKey, UnitSystem.OTHER, standardMoneyPerDurationUnit,
                moneyUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.moneyUnit = moneyUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a user-defined money per time unit from a money unit and an time unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per time unit, e.g., EUR
     * @param durationUnit DurationUnit; the unit of time for the money per time unit, e.g., hour
     * @param name String; the key to the locale file for the long name of the unit
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerDurationUnit(final MoneyUnit moneyUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation)
    {
        super(name, abbreviation, UnitSystem.OTHER, standardMoneyPerDurationUnit,
                moneyUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.moneyUnit = moneyUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a MoneyPerDurationUnit unit based on another MoneyPerDurationUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param referenceUnit MoneyPerDurationUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private MoneyPerDurationUnit(final String abbreviationKey, final MoneyPerDurationUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined MoneyPerDurationUnit with a conversion factor to another MoneyPerDurationUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param referenceUnit MoneyPerDurationUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MoneyPerDurationUnit(final String name, final String abbreviation, final MoneyPerDurationUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * @return moneyUnit
     */
    public final MoneyUnit getMoneyUnit()
    {
        return this.moneyUnit;
    }

    /**
     * @return durationUnit
     */
    public final DurationUnit getDurationUnit()
    {
        return this.durationUnit;
    }

    /**
     * Set the standard MoneyPerDurationUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit MoneyUnit; the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerDurationUnit = new MoneyPerDurationUnit(standardMoneyUnit, DurationUnit.HOUR,
                    standardMoneyUnit.getName() + " per hour", standardMoneyUnit.getAbbreviation() + "/h");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerDurationUnit getStandardUnit()
    {
        return standardMoneyPerDurationUnit;
    }

    /**
     * @return standard MoneyPerDurationUnit
     */
    public static MoneyPerDurationUnit getStandardMoneyPerDurationUnit()
    {
        return standardMoneyPerDurationUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/s";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.durationUnit == null) ? 0 : this.durationUnit.hashCode());
        result = prime * result + ((this.moneyUnit == null) ? 0 : this.moneyUnit.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MoneyPerDurationUnit other = (MoneyPerDurationUnit) obj;
        if (this.durationUnit == null)
        {
            if (other.durationUnit != null)
                return false;
        }
        else if (!this.durationUnit.equals(other.durationUnit))
            return false;
        if (this.moneyUnit == null)
        {
            if (other.moneyUnit != null)
                return false;
        }
        else if (!this.moneyUnit.equals(other.moneyUnit))
            return false;
        return true;
    }

}