package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerAreaUnit defines a unit for the cost or benefit per area, e.g. the cost of land per hectare.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerAreaUnit extends LinearUnit<MoneyPerAreaUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per area unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of area for the money per area unit, e.g., m2. */
    private final AreaUnit areaUnit;

    /** Euro per square meter. */
    public static final MoneyPerAreaUnit EUR_PER_SQUARE_METER;

    /** Euro per hectare. */
    public static final MoneyPerAreaUnit EUR_PER_HECTARE;

    /** US$ per acre. */
    public static final MoneyPerAreaUnit USD_PER_ACRE;

    /** US$ per square foot. */
    public static final MoneyPerAreaUnit USD_PER_SQUARE_FOOT;

    /** The standard unit to use. */
    private static MoneyPerAreaUnit standardMoneyPerAreaUnit;

    static
    {
        EUR_PER_SQUARE_METER =
                new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.SQUARE_METER, "EUR per square meter", "\u20AC/m^2", false);
        EUR_PER_HECTARE = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR per hectare", "\u20AC/ha", false);
        USD_PER_ACRE = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.ACRE, "USD per acre", "US$/acre", false);
        USD_PER_SQUARE_FOOT =
                new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_FOOT, "USD per square foot", "US$/ft^2", false);
        standardMoneyPerAreaUnit = EUR_PER_SQUARE_METER;
    }

    /**
     * Build a money per area unit from a money unit and an area unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per area unit, e.g., EUR
     * @param areaUnit AreaUnit; the unit of area for the money per area unit, e.g., m^2
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private MoneyPerAreaUnit(final MoneyUnit moneyUnit, final AreaUnit areaUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, standardMoneyPerAreaUnit,
                moneyUnit.getScaleFactor() / areaUnit.getScaleFactor(), standardUnit);
        this.moneyUnit = moneyUnit;
        this.areaUnit = areaUnit;
    }

    /**
     * Build a user-defined money per area unit from a money unit and an area unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per area unit, e.g., EUR
     * @param areaUnit AreaUnit; the unit of area for the money per area unit, e.g., m^2
     * @param name String; the key to the locale file for the long name of the unit
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerAreaUnit(final MoneyUnit moneyUnit, final AreaUnit areaUnit, final String name, final String abbreviation)
    {
        this(moneyUnit, areaUnit, name, abbreviation, false);
    }

    /**
     * Build a MoneyPerAreaUnit unit based on another MoneyPerAreaUnit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param referenceUnit MoneyPerAreaUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private MoneyPerAreaUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final MoneyPerAreaUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.areaUnit = referenceUnit.getAreaUnit();
    }

    /**
     * Build a user-defined MoneyPerAreaUnit with a conversion factor to another MoneyPerAreaUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param referenceUnit MoneyPerAreaUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MoneyPerAreaUnit(final String name, final String abbreviation, final MoneyPerAreaUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        this(name, abbreviation, referenceUnit, scaleFactorToReferenceUnit, false);
    }

    /**
     * @return moneyUnit
     */
    public final MoneyUnit getMoneyUnit()
    {
        return this.moneyUnit;
    }

    /**
     * @return areaUnit
     */
    public final AreaUnit getAreaUnit()
    {
        return this.areaUnit;
    }

    /**
     * Set the standard MoneyPerAreaUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit MoneyUnit; the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerAreaUnit = new MoneyPerAreaUnit(standardMoneyUnit, AreaUnit.SQUARE_METER,
                    standardMoneyUnit.getName() + " per square meter", standardMoneyUnit.getAbbreviation() + "/m^2");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerAreaUnit getStandardUnit()
    {
        return standardMoneyPerAreaUnit;
    }

    /**
     * @return standard MoneyPerAreaUnit
     */
    public static MoneyPerAreaUnit getStandardMoneyPerAreaUnit()
    {
        return standardMoneyPerAreaUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/m2";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.areaUnit == null) ? 0 : this.areaUnit.hashCode());
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
        MoneyPerAreaUnit other = (MoneyPerAreaUnit) obj;
        if (this.areaUnit == null)
        {
            if (other.areaUnit != null)
                return false;
        }
        else if (!this.areaUnit.equals(other.areaUnit))
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
