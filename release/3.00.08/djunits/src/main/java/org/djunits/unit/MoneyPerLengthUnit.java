package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerLengthUnit defines a unit for the cost or benefit per length, e.g. the cost of driving a kilometer.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerLengthUnit extends LinearUnit<MoneyPerLengthUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per length unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of length for the money per length unit, e.g., m. */
    private final LengthUnit lengthUnit;

    /** Euro per meter. */
    public static final MoneyPerLengthUnit EUR_PER_METER;

    /** Euro per kilometer. */
    public static final MoneyPerLengthUnit EUR_PER_KILOMETER;

    /** US$ per mile. */
    public static final MoneyPerLengthUnit USD_PER_MILE;

    /** US$ per foot. */
    public static final MoneyPerLengthUnit USD_PER_FOOT;

    /** The standard unit to use. */
    private static MoneyPerLengthUnit standardMoneyPerLengthUnit;

    static
    {
        EUR_PER_METER = new MoneyPerLengthUnit(MoneyUnit.EUR, LengthUnit.METER, "EUR per meter", "\u20AC/m", false);
        EUR_PER_KILOMETER =
                new MoneyPerLengthUnit(MoneyUnit.EUR, LengthUnit.KILOMETER, "EUR per kilometer", "\u20AC/km", false);
        USD_PER_MILE = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.MILE, "USD per mile", "US$/mi", false);
        USD_PER_FOOT = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.FOOT, "USD per foot", "US$/ft", false);
        standardMoneyPerLengthUnit = EUR_PER_METER;
    }

    /**
     * Build a money per length unit from a money unit and an length unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per length unit, e.g., EUR
     * @param lengthUnit LengthUnit; the unit of length for the money per length unit, e.g., meter
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private MoneyPerLengthUnit(final MoneyUnit moneyUnit, final LengthUnit lengthUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, standardMoneyPerLengthUnit,
                moneyUnit.getScaleFactor() / lengthUnit.getScaleFactor(), standardUnit);
        this.moneyUnit = moneyUnit;
        this.lengthUnit = lengthUnit;
    }

    /**
     * Build a user-defined money per length unit from a money unit and an length unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per length unit, e.g., EUR
     * @param lengthUnit LengthUnit; the unit of length for the money per length unit, e.g., meter
     * @param name String; the key to the locale file for the long name of the unit
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerLengthUnit(final MoneyUnit moneyUnit, final LengthUnit lengthUnit, final String name,
            final String abbreviation)
    {
        this(moneyUnit, lengthUnit, name, abbreviation, false);
    }

    /**
     * Build a MoneyPerLengthUnit unit based on another MoneyPerLengthUnit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param referenceUnit MoneyPerLengthUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private MoneyPerLengthUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final MoneyPerLengthUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
    }

    /**
     * Build a user-defined MoneyPerLengthUnit with a conversion factor to another MoneyPerLengthUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param referenceUnit MoneyPerLengthUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MoneyPerLengthUnit(final String name, final String abbreviation, final MoneyPerLengthUnit referenceUnit,
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
     * @return lengthUnit
     */
    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    /**
     * Set the standard MoneyPerLengthUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit MoneyUnit; the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerLengthUnit = new MoneyPerLengthUnit(standardMoneyUnit, LengthUnit.METER,
                    standardMoneyUnit.getName() + " per meter", standardMoneyUnit.getAbbreviation() + "/m");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLengthUnit getStandardUnit()
    {
        return standardMoneyPerLengthUnit;
    }

    /**
     * @return standard MoneyPerLengthUnit
     */
    public static MoneyPerLengthUnit getStandardMoneyPerLengthUnit()
    {
        return standardMoneyPerLengthUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/m";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.lengthUnit == null) ? 0 : this.lengthUnit.hashCode());
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
        MoneyPerLengthUnit other = (MoneyPerLengthUnit) obj;
        if (this.lengthUnit == null)
        {
            if (other.lengthUnit != null)
                return false;
        }
        else if (!this.lengthUnit.equals(other.lengthUnit))
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
