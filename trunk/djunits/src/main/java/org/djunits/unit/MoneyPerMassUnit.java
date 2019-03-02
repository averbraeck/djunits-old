package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerMassUnit defines a unit for the cost or benefit per mass, e.g. the cost of a kilogram of material.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerMassUnit extends LinearUnit<MoneyPerMassUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per mass unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of mass for the money per mass unit, e.g., kg. */
    private final MassUnit massUnit;

    /** Euro per kg. */
    public static final MoneyPerMassUnit EUR_PER_KILOGRAM;

    /** Euro per metric ton. */
    public static final MoneyPerMassUnit EUR_PER_METRIC_TON;

    /** US$ per pound. */
    public static final MoneyPerMassUnit USD_PER_POUND;

    /** US$ per long ton. */
    public static final MoneyPerMassUnit USD_PER_LONG_TON;

    /** US$ per short ton. */
    public static final MoneyPerMassUnit USD_PER_SHORT_TON;

    /** The standard unit to use. */
    private static MoneyPerMassUnit standardMoneyPerMassUnit;

    static
    {
        EUR_PER_KILOGRAM = new MoneyPerMassUnit(MoneyUnit.EUR, MassUnit.KILOGRAM, "EUR per kilogram", "\u20AC/kg");
        EUR_PER_METRIC_TON =
                new MoneyPerMassUnit(MoneyUnit.EUR, MassUnit.TON_METRIC, "EUR per metric ton", "\u20AC/ton(metric)");
        USD_PER_POUND = new MoneyPerMassUnit(MoneyUnit.USD, MassUnit.POUND, "USD per pound", "US$/lb");
        USD_PER_LONG_TON = new MoneyPerMassUnit(MoneyUnit.USD, MassUnit.TON_LONG, "USD per long ton", "US$/ton(long)");
        USD_PER_SHORT_TON = new MoneyPerMassUnit(MoneyUnit.USD, MassUnit.TON_SHORT, "USD per short ton", "US$/ton(short)");
        standardMoneyPerMassUnit = EUR_PER_KILOGRAM;
    }

    /**
     * Build a money per mass unit from a money unit and an mass unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per mass unit, e.g., EUR
     * @param massUnit MassUnit; the unit of mass for the money per mass unit, e.g., kg
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     */
    private MoneyPerMassUnit(final MoneyUnit moneyUnit, final MassUnit massUnit, final String abbreviationKey)
    {
        super(abbreviationKey, UnitSystem.OTHER, standardMoneyPerMassUnit,
                moneyUnit.getScaleFactor() / massUnit.getScaleFactor());
        this.moneyUnit = moneyUnit;
        this.massUnit = massUnit;
    }

    /**
     * Build a user-defined money per mass unit from a money unit and an mass unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per mass unit, e.g., EUR
     * @param massUnit MassUnit; the unit of mass for the money per mass unit, e.g., kg
     * @param name String; the key to the locale file for the long name of the unit
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerMassUnit(final MoneyUnit moneyUnit, final MassUnit massUnit, final String name, final String abbreviation)
    {
        super(name, abbreviation, UnitSystem.OTHER, standardMoneyPerMassUnit,
                moneyUnit.getScaleFactor() / massUnit.getScaleFactor());
        this.moneyUnit = moneyUnit;
        this.massUnit = massUnit;
    }

    /**
     * Build a MoneyPerMassUnit unit based on another MoneyPerMassUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param referenceUnit MoneyPerMassUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private MoneyPerMassUnit(final String abbreviationKey, final MoneyPerMassUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.massUnit = referenceUnit.getMassUnit();
    }

    /**
     * Build a user-defined MoneyPerMassUnit with a conversion factor to another MoneyPerMassUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param referenceUnit MoneyPerMassUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MoneyPerMassUnit(final String name, final String abbreviation, final MoneyPerMassUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.massUnit = referenceUnit.getMassUnit();
    }

    /**
     * @return moneyUnit
     */
    public final MoneyUnit getMoneyUnit()
    {
        return this.moneyUnit;
    }

    /**
     * @return massUnit
     */
    public final MassUnit getMassUnit()
    {
        return this.massUnit;
    }

    /**
     * Set the standard MoneyPerMassUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit MoneyUnit; the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerMassUnit = new MoneyPerMassUnit(standardMoneyUnit, MassUnit.KILOGRAM,
                    standardMoneyUnit.getName() + " per kilogram", standardMoneyUnit.getAbbreviation() + "/kg");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMassUnit getStandardUnit()
    {
        return standardMoneyPerMassUnit;
    }

    /**
     * @return standard MoneyPerMassUnit
     */
    public static MoneyPerMassUnit getStandardMoneyPerMassUnit()
    {
        return standardMoneyPerMassUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/kg";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.massUnit == null) ? 0 : this.massUnit.hashCode());
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
        MoneyPerMassUnit other = (MoneyPerMassUnit) obj;
        if (this.massUnit == null)
        {
            if (other.massUnit != null)
                return false;
        }
        else if (!this.massUnit.equals(other.massUnit))
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
