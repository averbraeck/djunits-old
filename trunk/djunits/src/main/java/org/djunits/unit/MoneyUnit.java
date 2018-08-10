package org.djunits.unit;

import java.util.ArrayList;

import org.djunits.unit.unitsystem.UnitSystem;
import org.joda.money.CurrencyUnit;

/**
 * MoneyUnit defines a monetary unit, and wraps the joda money currency unit. At this time, conversion rates between monetary
 * units are not used. A standard monetary unit, defined as a static variable, can be set to be used in the code.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 03, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyUnit extends LinearUnit<MoneyUnit>
{
    // TODO allow for static conversion factors between MoneyUnits.
    // TODO allow for dynamic conversion factors between MoneyUnits.

    /** */
    private static final long serialVersionUID = 20150903L;

    /** The joda-money CurrencyUnit on which this djunits unit is based. */
    private final CurrencyUnit currencyUnit;
    
    /** the code number of the currency to identify it uniquely. */
    private final int codeNumber;

    /** the code string of the currency to identify it uniquely. */
    private final String codeString;

    /** The currency 'AED' - United Arab Emirates dirham. */
    public static final MoneyUnit AED;

    /** The currency 'AFN' - Afghan afghani. */
    public static final MoneyUnit AFN;

    /** The currency 'ALL' - Albanian lek. */
    public static final MoneyUnit ALL;

    /** The currency 'AMD' - Armenian dram. */
    public static final MoneyUnit AMD;

    /** The currency 'ANG' - Netherlands Antillean guilder. */
    public static final MoneyUnit ANG;

    /** The currency 'AOA' - Angolan kwanza. */
    public static final MoneyUnit AOA;

    /** The currency 'ARS' - Argentine peso. */
    public static final MoneyUnit ARS;

    /** The currency 'AUD' - Australian dollar. */
    public static final MoneyUnit AUD;

    /** The currency 'AWG' - Aruban florin. */
    public static final MoneyUnit AWG;

    /** The currency 'AZN' - Azerbaijani manat. */
    public static final MoneyUnit AZN;

    /** The currency 'BAM' - Bosnia and Herzegovina convertible mark. */
    public static final MoneyUnit BAM;

    /** The currency 'BBD' - Barbados dollar. */
    public static final MoneyUnit BBD;

    /** The currency 'BDT' - Bangladeshi taka. */
    public static final MoneyUnit BDT;

    /** The currency 'BGN' - Bulgarian lev. */
    public static final MoneyUnit BGN;

    /** The currency 'BHD' - Bahraini dinar. */
    public static final MoneyUnit BHD;

    /** The currency 'BIF' - Burundian franc. */
    public static final MoneyUnit BIF;

    /** The currency 'BMD' - Bermudian dollar. */
    public static final MoneyUnit BMD;

    /** The currency 'BND' - Brunei dollar. */
    public static final MoneyUnit BND;

    /** The currency 'BOB' - Boliviano. */
    public static final MoneyUnit BOB;

    /** The currency 'BOV' - Bolivian Mvdol (funds code). */
    public static final MoneyUnit BOV;

    /** The currency 'BRL' - Brazilian real. */
    public static final MoneyUnit BRL;

    /** The currency 'BSD' - Bahamian dollar. */
    public static final MoneyUnit BSD;

    /** The currency 'BTN' - Bhutanese ngultrum. */
    public static final MoneyUnit BTN;

    /** The currency 'BWP' - Botswana pula. */
    public static final MoneyUnit BWP;

    /** The currency 'BYN' - New Belarusian ruble. */
    public static final MoneyUnit BYN;

    /** The currency 'BYR' - Belarusian ruble. */
    public static final MoneyUnit BYR;

    /** The currency 'BZD' - Belize dollar. */
    public static final MoneyUnit BZD;

    /** The currency 'CAD' - Canadian dollar. */
    public static final MoneyUnit CAD;

    /** The currency 'CDF' - Congolese franc. */
    public static final MoneyUnit CDF;

    /** The currency 'CHE' - WIR Euro (complementary currency). */
    public static final MoneyUnit CHE;

    /** The currency 'CHF' - Swiss franc. */
    public static final MoneyUnit CHF;

    /** The currency 'CHW' - WIR Franc (complementary currency). */
    public static final MoneyUnit CHW;

    /** The currency 'CLF' - Unidad de Fomento (funds code). */
    public static final MoneyUnit CLF;

    /** The currency 'CLP' - Chilean peso. */
    public static final MoneyUnit CLP;

    /** The currency 'CNY' - Chinese yuan. */
    public static final MoneyUnit CNY;

    /** The currency 'COP' - Colombian peso. */
    public static final MoneyUnit COP;

    /** The currency 'COU' - Unidad de Valor Real (UVR) (funds code)[7]. */
    public static final MoneyUnit COU;

    /** The currency 'CRC' - Costa Rican colon. */
    public static final MoneyUnit CRC;

    /** The currency 'CUC' - Cuban convertible peso. */
    public static final MoneyUnit CUC;

    /** The currency 'CUP' - Cuban peso. */
    public static final MoneyUnit CUP;

    /** The currency 'CVE' - Cape Verde escudo. */
    public static final MoneyUnit CVE;

    /** The currency 'CZK' - Czech koruna. */
    public static final MoneyUnit CZK;

    /** The currency 'DJF' - Djiboutian franc. */
    public static final MoneyUnit DJF;

    /** The currency 'DKK' - Danish krone. */
    public static final MoneyUnit DKK;

    /** The currency 'DOP' - Dominican peso. */
    public static final MoneyUnit DOP;

    /** The currency 'DZD' - Algerian dinar. */
    public static final MoneyUnit DZD;

    /** The currency 'EGP' - Egyptian pound. */
    public static final MoneyUnit EGP;

    /** The currency 'ERN' - Eritrean nakfa. */
    public static final MoneyUnit ERN;

    /** The currency 'ETB' - Ethiopian birr. */
    public static final MoneyUnit ETB;

    /** The currency 'EUR' - Euro. */
    public static final MoneyUnit EUR;

    /** The currency 'FJD' - Fiji dollar. */
    public static final MoneyUnit FJD;

    /** The currency 'FKP' - Falkland Islands pound. */
    public static final MoneyUnit FKP;

    /** The currency 'GBP' - Pound sterling. */
    public static final MoneyUnit GBP;

    /** The currency 'GEL' - Georgian lari. */
    public static final MoneyUnit GEL;

    /** The currency 'GHS' - Ghanaian cedi. */
    public static final MoneyUnit GHS;

    /** The currency 'GIP' - Gibraltar pound. */
    public static final MoneyUnit GIP;

    /** The currency 'GMD' - Gambian dalasi. */
    public static final MoneyUnit GMD;

    /** The currency 'GNF' - Guinean franc. */
    public static final MoneyUnit GNF;

    /** The currency 'GTQ' - Guatemalan quetzal. */
    public static final MoneyUnit GTQ;

    /** The currency 'GYD' - Guyanese dollar. */
    public static final MoneyUnit GYD;

    /** The currency 'HKD' - Hong Kong dollar. */
    public static final MoneyUnit HKD;

    /** The currency 'HNL' - Honduran lempira. */
    public static final MoneyUnit HNL;

    /** The currency 'HRK' - Croatian kuna. */
    public static final MoneyUnit HRK;

    /** The currency 'HTG' - Haitian gourde. */
    public static final MoneyUnit HTG;

    /** The currency 'HUF' - Hungarian forint. */
    public static final MoneyUnit HUF;

    /** The currency 'IDR' - Indonesian rupiah. */
    public static final MoneyUnit IDR;

    /** The currency 'ILS' - Israeli new shekel. */
    public static final MoneyUnit ILS;

    /** The currency 'INR' - Indian rupee. */
    public static final MoneyUnit INR;

    /** The currency 'IQD' - Iraqi dinar. */
    public static final MoneyUnit IQD;

    /** The currency 'IRR' - Iranian rial. */
    public static final MoneyUnit IRR;

    /** The currency 'ISK' - Icelandic króna. */
    public static final MoneyUnit ISK;

    /** The currency 'JMD' - Jamaican dollar. */
    public static final MoneyUnit JMD;

    /** The currency 'JOD' - Jordanian dinar. */
    public static final MoneyUnit JOD;

    /** The currency 'JPY' - Japanese yen. */
    public static final MoneyUnit JPY;

    /** The currency 'KES' - Kenyan shilling. */
    public static final MoneyUnit KES;

    /** The currency 'KGS' - Kyrgyzstani som. */
    public static final MoneyUnit KGS;

    /** The currency 'KHR' - Cambodian riel. */
    public static final MoneyUnit KHR;

    /** The currency 'KMF' - Comoro franc. */
    public static final MoneyUnit KMF;

    /** The currency 'KPW' - North Korean won. */
    public static final MoneyUnit KPW;

    /** The currency 'KRW' - South Korean won. */
    public static final MoneyUnit KRW;

    /** The currency 'KWD' - Kuwaiti dinar. */
    public static final MoneyUnit KWD;

    /** The currency 'KYD' - Cayman Islands dollar. */
    public static final MoneyUnit KYD;

    /** The currency 'KZT' - Kazakhstani tenge. */
    public static final MoneyUnit KZT;

    /** The currency 'LAK' - Lao kip. */
    public static final MoneyUnit LAK;

    /** The currency 'LBP' - Lebanese pound. */
    public static final MoneyUnit LBP;

    /** The currency 'LKR' - Sri Lankan rupee. */
    public static final MoneyUnit LKR;

    /** The currency 'LRD' - Liberian dollar. */
    public static final MoneyUnit LRD;

    /** The currency 'LSL' - Lesotho loti. */
    public static final MoneyUnit LSL;

    /** The currency 'LYD' - Libyan dinar. */
    public static final MoneyUnit LYD;

    /** The currency 'MAD' - Moroccan dirham. */
    public static final MoneyUnit MAD;

    /** The currency 'MDL' - Moldovan leu. */
    public static final MoneyUnit MDL;

    /** The currency 'MGA' - Malagasy ariary. */
    public static final MoneyUnit MGA;

    /** The currency 'MKD' - Macedonian denar. */
    public static final MoneyUnit MKD;

    /** The currency 'MMK' - Myanmar kyat. */
    public static final MoneyUnit MMK;

    /** The currency 'MNT' - Mongolian tögrög. */
    public static final MoneyUnit MNT;

    /** The currency 'MOP' - Macanese pataca. */
    public static final MoneyUnit MOP;

    /** The currency 'MRO' - Mauritanian ouguiya. */
    public static final MoneyUnit MRO;

    /** The currency 'MUR' - Mauritian rupee. */
    public static final MoneyUnit MUR;

    /** The currency 'MVR' - Maldivian rufiyaa. */
    public static final MoneyUnit MVR;

    /** The currency 'MWK' - Malawian kwacha. */
    public static final MoneyUnit MWK;

    /** The currency 'MXN' - Mexican peso. */
    public static final MoneyUnit MXN;

    /** The currency 'MXV' - Mexican Unidad de Inversion (UDI) (funds code). */
    public static final MoneyUnit MXV;

    /** The currency 'MYR' - Malaysian ringgit. */
    public static final MoneyUnit MYR;

    /** The currency 'MZN' - Mozambican metical. */
    public static final MoneyUnit MZN;

    /** The currency 'NAD' - Namibian dollar. */
    public static final MoneyUnit NAD;

    /** The currency 'NGN' - Nigerian naira. */
    public static final MoneyUnit NGN;

    /** The currency 'NIO' - Nicaraguan córdoba. */
    public static final MoneyUnit NIO;

    /** The currency 'NOK' - Norwegian krone. */
    public static final MoneyUnit NOK;

    /** The currency 'NPR' - Nepalese rupee. */
    public static final MoneyUnit NPR;

    /** The currency 'NZD' - New Zealand dollar. */
    public static final MoneyUnit NZD;

    /** The currency 'OMR' - Omani rial. */
    public static final MoneyUnit OMR;

    /** The currency 'PAB' - Panamanian balboa. */
    public static final MoneyUnit PAB;

    /** The currency 'PEN' - Peruvian Sol. */
    public static final MoneyUnit PEN;

    /** The currency 'PGK' - Papua New Guinean kina. */
    public static final MoneyUnit PGK;

    /** The currency 'PHP' - Philippine peso. */
    public static final MoneyUnit PHP;

    /** The currency 'PKR' - Pakistani rupee. */
    public static final MoneyUnit PKR;

    /** The currency 'PLN' - Polish zloty. */
    public static final MoneyUnit PLN;

    /** The currency 'PYG' - Paraguayan guaraní. */
    public static final MoneyUnit PYG;

    /** The currency 'QAR' - Qatari riyal. */
    public static final MoneyUnit QAR;

    /** The currency 'RON' - Romanian leu. */
    public static final MoneyUnit RON;

    /** The currency 'RSD' - Serbian dinar. */
    public static final MoneyUnit RSD;

    /** The currency 'RUB' - Russian ruble. */
    public static final MoneyUnit RUB;

    /** The currency 'RWF' - Rwandan franc. */
    public static final MoneyUnit RWF;

    /** The currency 'SAR' - Saudi riyal. */
    public static final MoneyUnit SAR;

    /** The currency 'SBD' - Solomon Islands dollar. */
    public static final MoneyUnit SBD;

    /** The currency 'SCR' - Seychelles rupee. */
    public static final MoneyUnit SCR;

    /** The currency 'SDG' - Sudanese pound. */
    public static final MoneyUnit SDG;

    /** The currency 'SEK' - Swedish krona/kronor. */
    public static final MoneyUnit SEK;

    /** The currency 'SGD' - Singapore dollar. */
    public static final MoneyUnit SGD;

    /** The currency 'SHP' - Saint Helena pound. */
    public static final MoneyUnit SHP;

    /** The currency 'SLL' - Sierra Leonean leone. */
    public static final MoneyUnit SLL;

    /** The currency 'SOS' - Somali shilling. */
    public static final MoneyUnit SOS;

    /** The currency 'SRD' - Surinamese dollar. */
    public static final MoneyUnit SRD;

    /** The currency 'SSP' - South Sudanese pound. */
    public static final MoneyUnit SSP;

    /** The currency 'STD' - São Tomé and Príncipe dobra. */
    public static final MoneyUnit STD;

    /** The currency 'SVC' - Salvadoran colón. */
    public static final MoneyUnit SVC;

    /** The currency 'SYP' - Syrian pound. */
    public static final MoneyUnit SYP;

    /** The currency 'SZL' - Swazi lilangeni. */
    public static final MoneyUnit SZL;

    /** The currency 'THB' - Thai baht. */
    public static final MoneyUnit THB;

    /** The currency 'TJS' - Tajikistani somoni. */
    public static final MoneyUnit TJS;

    /** The currency 'TMT' - Turkmenistani manat. */
    public static final MoneyUnit TMT;

    /** The currency 'TND' - Tunisian dinar. */
    public static final MoneyUnit TND;

    /** The currency 'TOP' - Tongan pa?anga. */
    public static final MoneyUnit TOP;

    /** The currency 'TRY' - Turkish lira. */
    public static final MoneyUnit TRY;

    /** The currency 'TTD' - Trinidad and Tobago dollar. */
    public static final MoneyUnit TTD;

    /** The currency 'TWD' - New Taiwan dollar. */
    public static final MoneyUnit TWD;

    /** The currency 'TZS' - Tanzanian shilling. */
    public static final MoneyUnit TZS;

    /** The currency 'UAH' - Ukrainian hryvnia. */
    public static final MoneyUnit UAH;

    /** The currency 'UGX' - Ugandan shilling. */
    public static final MoneyUnit UGX;

    /** The currency 'USD' - United States dollar. */
    public static final MoneyUnit USD;

    /** The currency 'USN' - United States dollar (next day) (funds code). */
    public static final MoneyUnit USN;

    /** The currency 'UYI' - Uruguay Peso en Unidades Indexadas (URUIURUI) (funds code). */
    public static final MoneyUnit UYI;

    /** The currency 'UYU' - Uruguayan peso. */
    public static final MoneyUnit UYU;

    /** The currency 'UZS' - Uzbekistan som. */
    public static final MoneyUnit UZS;

    /** The currency 'VEF' - Venezuelan bolívar. */
    public static final MoneyUnit VEF;

    /** The currency 'VND' - Vietnamese dong. */
    public static final MoneyUnit VND;

    /** The currency 'VUV' - Vanuatu vatu. */
    public static final MoneyUnit VUV;

    /** The currency 'WST' - Samoan tala. */
    public static final MoneyUnit WST;

    /** The currency 'XAF' - CFA franc BEAC. */
    public static final MoneyUnit XAF;

    /** The currency 'XAG' - Silver (one troy ounce). */
    public static final MoneyUnit XAG;

    /** The currency 'XAU' - Gold (one troy ounce). */
    public static final MoneyUnit XAU;

    /** The currency 'XBA' - European Composite Unit (EURCO) (bond market unit). */
    public static final MoneyUnit XBA;

    /** The currency 'XBB' - European Monetary Unit (E.M.U.-6) (bond market unit). */
    public static final MoneyUnit XBB;

    /** The currency 'XBC' - European Unit of Account 9 (E.U.A.-9) (bond market unit). */
    public static final MoneyUnit XBC;

    /** The currency 'XBD' - European Unit of Account 17 (E.U.A.-17) (bond market unit). */
    public static final MoneyUnit XBD;

    /** The currency 'XCD' - East Caribbean dollar. */
    public static final MoneyUnit XCD;

    /** The currency 'XDR' - Special drawing rights. */
    public static final MoneyUnit XDR;

    /** The currency 'XOF' - CFA franc BCEAO. */
    public static final MoneyUnit XOF;

    /** The currency 'XPD' - Palladium (one troy ounce). */
    public static final MoneyUnit XPD;

    /** The currency 'XPF' - CFP franc (franc Pacifique). */
    public static final MoneyUnit XPF;

    /** The currency 'XPT' - Platinum (one troy ounce). */
    public static final MoneyUnit XPT;

    /** The currency 'XSU' - SUCRE. */
    public static final MoneyUnit XSU;

    /** The currency 'XTS' - Code reserved for testing purposes. */
    public static final MoneyUnit XTS;

    /** The currency 'XUA' - ADB Unit of Account. */
    public static final MoneyUnit XUA;

    /** The currency 'X X X' - No currency. */
    public static final MoneyUnit XXX;

    /** The currency 'YER' - Yemeni rial. */
    public static final MoneyUnit YER;

    /** The currency 'ZAR' - South African rand. */
    public static final MoneyUnit ZAR;

    /** The currency 'ZMW' - Zambian kwacha. */
    public static final MoneyUnit ZMW;

    /** The currency 'ZWL' - Zimbabwean dollar A/10. */
    public static final MoneyUnit ZWL;

    /** The currency 'XBT' - Bitcoin. */
    public static final MoneyUnit XBT;

    /** The standard unit to use. */
    private static MoneyUnit standardMoneyUnit;

    static
    {
        CurrencyUnit.registerCurrency("BOV", 984, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("BYR", 974, 0, new ArrayList<String>());
        CurrencyUnit.registerCurrency("CHE", 947, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("CHW", 948, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("CLF", 990, 4, new ArrayList<String>());
        CurrencyUnit.registerCurrency("COU", 970, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("CUC", 931, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("MXV", 979, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("USN", 997, 2, new ArrayList<String>());
        CurrencyUnit.registerCurrency("UYI", 940, 0, new ArrayList<String>());
        CurrencyUnit.registerCurrency("XBT", -1, 8, new ArrayList<String>());

        AED = new MoneyUnit(CurrencyUnit.getInstance("AED"), "MoneyUnit.AED", "AED", true);
        AFN = new MoneyUnit(CurrencyUnit.getInstance("AFN"), "MoneyUnit.AFN", "AFN", true);
        ALL = new MoneyUnit(CurrencyUnit.getInstance("ALL"), "MoneyUnit.ALL", "ALL", true);
        AMD = new MoneyUnit(CurrencyUnit.getInstance("AMD"), "MoneyUnit.AMD", "AMD", true);
        ANG = new MoneyUnit(CurrencyUnit.getInstance("ANG"), "MoneyUnit.ANG", "ANG", true);
        AOA = new MoneyUnit(CurrencyUnit.getInstance("AOA"), "MoneyUnit.AOA", "AOA", true);
        ARS = new MoneyUnit(CurrencyUnit.getInstance("ARS"), "MoneyUnit.ARS", "ARS", true);
        AUD = new MoneyUnit(CurrencyUnit.getInstance("AUD"), "MoneyUnit.AUD", "AUD", true);
        AWG = new MoneyUnit(CurrencyUnit.getInstance("AWG"), "MoneyUnit.AWG", "AWG", true);
        AZN = new MoneyUnit(CurrencyUnit.getInstance("AZN"), "MoneyUnit.AZN", "AZN", true);
        BAM = new MoneyUnit(CurrencyUnit.getInstance("BAM"), "MoneyUnit.BAM", "BAM", true);
        BBD = new MoneyUnit(CurrencyUnit.getInstance("BBD"), "MoneyUnit.BBD", "BBD", true);
        BDT = new MoneyUnit(CurrencyUnit.getInstance("BDT"), "MoneyUnit.BDT", "BDT", true);
        BGN = new MoneyUnit(CurrencyUnit.getInstance("BGN"), "MoneyUnit.BGN", "BGN", true);
        BHD = new MoneyUnit(CurrencyUnit.getInstance("BHD"), "MoneyUnit.BHD", "BHD", true);
        BIF = new MoneyUnit(CurrencyUnit.getInstance("BIF"), "MoneyUnit.BIF", "BIF", true);
        BMD = new MoneyUnit(CurrencyUnit.getInstance("BMD"), "MoneyUnit.BMD", "BMD", true);
        BND = new MoneyUnit(CurrencyUnit.getInstance("BND"), "MoneyUnit.BND", "BND", true);
        BOB = new MoneyUnit(CurrencyUnit.getInstance("BOB"), "MoneyUnit.BOB", "BOB", true);
        BOV = new MoneyUnit(CurrencyUnit.getInstance("BOV"), "MoneyUnit.BOV", "BOV", true);
        BRL = new MoneyUnit(CurrencyUnit.getInstance("BRL"), "MoneyUnit.BRL", "BRL", true);
        BSD = new MoneyUnit(CurrencyUnit.getInstance("BSD"), "MoneyUnit.BSD", "BSD", true);
        BTN = new MoneyUnit(CurrencyUnit.getInstance("BTN"), "MoneyUnit.BTN", "BTN", true);
        BWP = new MoneyUnit(CurrencyUnit.getInstance("BWP"), "MoneyUnit.BWP", "BWP", true);
        BYN = new MoneyUnit(CurrencyUnit.getInstance("BYN"), "MoneyUnit.BYN", "BYN", true);
         BYR = new MoneyUnit(CurrencyUnit.getInstance(" BYR"), "MoneyUnit. BYR", " BYR", true);
        BZD = new MoneyUnit(CurrencyUnit.getInstance("BZD"), "MoneyUnit.BZD", "BZD", true);
        CAD = new MoneyUnit(CurrencyUnit.getInstance("CAD"), "MoneyUnit.CAD", "CAD", true);
        CDF = new MoneyUnit(CurrencyUnit.getInstance("CDF"), "MoneyUnit.CDF", "CDF", true);
        CHE = new MoneyUnit(CurrencyUnit.getInstance("CHE"), "MoneyUnit.CHE", "CHE", true);
        CHF = new MoneyUnit(CurrencyUnit.getInstance("CHF"), "MoneyUnit.CHF", "CHF", true);
        CHW = new MoneyUnit(CurrencyUnit.getInstance("CHW"), "MoneyUnit.CHW", "CHW", true);
        CLF = new MoneyUnit(CurrencyUnit.getInstance("CLF"), "MoneyUnit.CLF", "CLF", true);
        CLP = new MoneyUnit(CurrencyUnit.getInstance("CLP"), "MoneyUnit.CLP", "CLP", true);
        CNY = new MoneyUnit(CurrencyUnit.getInstance("CNY"), "MoneyUnit.CNY", "CNY", true);
        COP = new MoneyUnit(CurrencyUnit.getInstance("COP"), "MoneyUnit.COP", "COP", true);
        COU = new MoneyUnit(CurrencyUnit.getInstance("COU"), "MoneyUnit.COU", "COU", true);
        CRC = new MoneyUnit(CurrencyUnit.getInstance("CRC"), "MoneyUnit.CRC", "CRC", true);
        CUC = new MoneyUnit(CurrencyUnit.getInstance("CUC"), "MoneyUnit.CUC", "CUC", true);
        CUP = new MoneyUnit(CurrencyUnit.getInstance("CUP"), "MoneyUnit.CUP", "CUP", true);
        CVE = new MoneyUnit(CurrencyUnit.getInstance("CVE"), "MoneyUnit.CVE", "CVE", true);
        CZK = new MoneyUnit(CurrencyUnit.getInstance("CZK"), "MoneyUnit.CZK", "CZK", true);
        DJF = new MoneyUnit(CurrencyUnit.getInstance("DJF"), "MoneyUnit.DJF", "DJF", true);
        DKK = new MoneyUnit(CurrencyUnit.getInstance("DKK"), "MoneyUnit.DKK", "DKK", true);
        DOP = new MoneyUnit(CurrencyUnit.getInstance("DOP"), "MoneyUnit.DOP", "DOP", true);
        DZD = new MoneyUnit(CurrencyUnit.getInstance("DZD"), "MoneyUnit.DZD", "DZD", true);
        EGP = new MoneyUnit(CurrencyUnit.getInstance("EGP"), "MoneyUnit.EGP", "EGP", true);
        ERN = new MoneyUnit(CurrencyUnit.getInstance("ERN"), "MoneyUnit.ERN", "ERN", true);
        ETB = new MoneyUnit(CurrencyUnit.getInstance("ETB"), "MoneyUnit.ETB", "ETB", true);
        EUR = new MoneyUnit(CurrencyUnit.getInstance("EUR"), "MoneyUnit.EUR", "EUR", true);
        FJD = new MoneyUnit(CurrencyUnit.getInstance("FJD"), "MoneyUnit.FJD", "FJD", true);
        FKP = new MoneyUnit(CurrencyUnit.getInstance("FKP"), "MoneyUnit.FKP", "FKP", true);
        GBP = new MoneyUnit(CurrencyUnit.getInstance("GBP"), "MoneyUnit.GBP", "GBP", true);
        GEL = new MoneyUnit(CurrencyUnit.getInstance("GEL"), "MoneyUnit.GEL", "GEL", true);
        GHS = new MoneyUnit(CurrencyUnit.getInstance("GHS"), "MoneyUnit.GHS", "GHS", true);
        GIP = new MoneyUnit(CurrencyUnit.getInstance("GIP"), "MoneyUnit.GIP", "GIP", true);
        GMD = new MoneyUnit(CurrencyUnit.getInstance("GMD"), "MoneyUnit.GMD", "GMD", true);
        GNF = new MoneyUnit(CurrencyUnit.getInstance("GNF"), "MoneyUnit.GNF", "GNF", true);
        GTQ = new MoneyUnit(CurrencyUnit.getInstance("GTQ"), "MoneyUnit.GTQ", "GTQ", true);
        GYD = new MoneyUnit(CurrencyUnit.getInstance("GYD"), "MoneyUnit.GYD", "GYD", true);
        HKD = new MoneyUnit(CurrencyUnit.getInstance("HKD"), "MoneyUnit.HKD", "HKD", true);
        HNL = new MoneyUnit(CurrencyUnit.getInstance("HNL"), "MoneyUnit.HNL", "HNL", true);
        HRK = new MoneyUnit(CurrencyUnit.getInstance("HRK"), "MoneyUnit.HRK", "HRK", true);
        HTG = new MoneyUnit(CurrencyUnit.getInstance("HTG"), "MoneyUnit.HTG", "HTG", true);
        HUF = new MoneyUnit(CurrencyUnit.getInstance("HUF"), "MoneyUnit.HUF", "HUF", true);
        IDR = new MoneyUnit(CurrencyUnit.getInstance("IDR"), "MoneyUnit.IDR", "IDR", true);
        ILS = new MoneyUnit(CurrencyUnit.getInstance("ILS"), "MoneyUnit.ILS", "ILS", true);
        INR = new MoneyUnit(CurrencyUnit.getInstance("INR"), "MoneyUnit.INR", "INR", true);
        IQD = new MoneyUnit(CurrencyUnit.getInstance("IQD"), "MoneyUnit.IQD", "IQD", true);
        IRR = new MoneyUnit(CurrencyUnit.getInstance("IRR"), "MoneyUnit.IRR", "IRR", true);
        ISK = new MoneyUnit(CurrencyUnit.getInstance("ISK"), "MoneyUnit.ISK", "ISK", true);
        JMD = new MoneyUnit(CurrencyUnit.getInstance("JMD"), "MoneyUnit.JMD", "JMD", true);
        JOD = new MoneyUnit(CurrencyUnit.getInstance("JOD"), "MoneyUnit.JOD", "JOD", true);
        JPY = new MoneyUnit(CurrencyUnit.getInstance("JPY"), "MoneyUnit.JPY", "JPY", true);
        KES = new MoneyUnit(CurrencyUnit.getInstance("KES"), "MoneyUnit.KES", "KES", true);
        KGS = new MoneyUnit(CurrencyUnit.getInstance("KGS"), "MoneyUnit.KGS", "KGS", true);
        KHR = new MoneyUnit(CurrencyUnit.getInstance("KHR"), "MoneyUnit.KHR", "KHR", true);
        KMF = new MoneyUnit(CurrencyUnit.getInstance("KMF"), "MoneyUnit.KMF", "KMF", true);
        KPW = new MoneyUnit(CurrencyUnit.getInstance("KPW"), "MoneyUnit.KPW", "KPW", true);
        KRW = new MoneyUnit(CurrencyUnit.getInstance("KRW"), "MoneyUnit.KRW", "KRW", true);
        KWD = new MoneyUnit(CurrencyUnit.getInstance("KWD"), "MoneyUnit.KWD", "KWD", true);
        KYD = new MoneyUnit(CurrencyUnit.getInstance("KYD"), "MoneyUnit.KYD", "KYD", true);
        KZT = new MoneyUnit(CurrencyUnit.getInstance("KZT"), "MoneyUnit.KZT", "KZT", true);
        LAK = new MoneyUnit(CurrencyUnit.getInstance("LAK"), "MoneyUnit.LAK", "LAK", true);
        LBP = new MoneyUnit(CurrencyUnit.getInstance("LBP"), "MoneyUnit.LBP", "LBP", true);
        LKR = new MoneyUnit(CurrencyUnit.getInstance("LKR"), "MoneyUnit.LKR", "LKR", true);
        LRD = new MoneyUnit(CurrencyUnit.getInstance("LRD"), "MoneyUnit.LRD", "LRD", true);
        LSL = new MoneyUnit(CurrencyUnit.getInstance("LSL"), "MoneyUnit.LSL", "LSL", true);
        LYD = new MoneyUnit(CurrencyUnit.getInstance("LYD"), "MoneyUnit.LYD", "LYD", true);
        MAD = new MoneyUnit(CurrencyUnit.getInstance("MAD"), "MoneyUnit.MAD", "MAD", true);
        MDL = new MoneyUnit(CurrencyUnit.getInstance("MDL"), "MoneyUnit.MDL", "MDL", true);
        MGA = new MoneyUnit(CurrencyUnit.getInstance("MGA"), "MoneyUnit.MGA", "MGA", true);
        MKD = new MoneyUnit(CurrencyUnit.getInstance("MKD"), "MoneyUnit.MKD", "MKD", true);
        MMK = new MoneyUnit(CurrencyUnit.getInstance("MMK"), "MoneyUnit.MMK", "MMK", true);
        MNT = new MoneyUnit(CurrencyUnit.getInstance("MNT"), "MoneyUnit.MNT", "MNT", true);
        MOP = new MoneyUnit(CurrencyUnit.getInstance("MOP"), "MoneyUnit.MOP", "MOP", true);
        MRO = new MoneyUnit(CurrencyUnit.getInstance("MRO"), "MoneyUnit.MRO", "MRO", true);
        MUR = new MoneyUnit(CurrencyUnit.getInstance("MUR"), "MoneyUnit.MUR", "MUR", true);
        MVR = new MoneyUnit(CurrencyUnit.getInstance("MVR"), "MoneyUnit.MVR", "MVR", true);
        MWK = new MoneyUnit(CurrencyUnit.getInstance("MWK"), "MoneyUnit.MWK", "MWK", true);
        MXN = new MoneyUnit(CurrencyUnit.getInstance("MXN"), "MoneyUnit.MXN", "MXN", true);
        MXV = new MoneyUnit(CurrencyUnit.getInstance("MXV"), "MoneyUnit.MXV", "MXV", true);
        MYR = new MoneyUnit(CurrencyUnit.getInstance("MYR"), "MoneyUnit.MYR", "MYR", true);
        MZN = new MoneyUnit(CurrencyUnit.getInstance("MZN"), "MoneyUnit.MZN", "MZN", true);
        NAD = new MoneyUnit(CurrencyUnit.getInstance("NAD"), "MoneyUnit.NAD", "NAD", true);
        NGN = new MoneyUnit(CurrencyUnit.getInstance("NGN"), "MoneyUnit.NGN", "NGN", true);
        NIO = new MoneyUnit(CurrencyUnit.getInstance("NIO"), "MoneyUnit.NIO", "NIO", true);
        NOK = new MoneyUnit(CurrencyUnit.getInstance("NOK"), "MoneyUnit.NOK", "NOK", true);
        NPR = new MoneyUnit(CurrencyUnit.getInstance("NPR"), "MoneyUnit.NPR", "NPR", true);
        NZD = new MoneyUnit(CurrencyUnit.getInstance("NZD"), "MoneyUnit.NZD", "NZD", true);
        OMR = new MoneyUnit(CurrencyUnit.getInstance("OMR"), "MoneyUnit.OMR", "OMR", true);
        PAB = new MoneyUnit(CurrencyUnit.getInstance("PAB"), "MoneyUnit.PAB", "PAB", true);
        PEN = new MoneyUnit(CurrencyUnit.getInstance("PEN"), "MoneyUnit.PEN", "PEN", true);
        PGK = new MoneyUnit(CurrencyUnit.getInstance("PGK"), "MoneyUnit.PGK", "PGK", true);
        PHP = new MoneyUnit(CurrencyUnit.getInstance("PHP"), "MoneyUnit.PHP", "PHP", true);
        PKR = new MoneyUnit(CurrencyUnit.getInstance("PKR"), "MoneyUnit.PKR", "PKR", true);
        PLN = new MoneyUnit(CurrencyUnit.getInstance("PLN"), "MoneyUnit.PLN", "PLN", true);
        PYG = new MoneyUnit(CurrencyUnit.getInstance("PYG"), "MoneyUnit.PYG", "PYG", true);
        QAR = new MoneyUnit(CurrencyUnit.getInstance("QAR"), "MoneyUnit.QAR", "QAR", true);
        RON = new MoneyUnit(CurrencyUnit.getInstance("RON"), "MoneyUnit.RON", "RON", true);
        RSD = new MoneyUnit(CurrencyUnit.getInstance("RSD"), "MoneyUnit.RSD", "RSD", true);
        RUB = new MoneyUnit(CurrencyUnit.getInstance("RUB"), "MoneyUnit.RUB", "RUB", true);
        RWF = new MoneyUnit(CurrencyUnit.getInstance("RWF"), "MoneyUnit.RWF", "RWF", true);
        SAR = new MoneyUnit(CurrencyUnit.getInstance("SAR"), "MoneyUnit.SAR", "SAR", true);
        SBD = new MoneyUnit(CurrencyUnit.getInstance("SBD"), "MoneyUnit.SBD", "SBD", true);
        SCR = new MoneyUnit(CurrencyUnit.getInstance("SCR"), "MoneyUnit.SCR", "SCR", true);
        SDG = new MoneyUnit(CurrencyUnit.getInstance("SDG"), "MoneyUnit.SDG", "SDG", true);
        SEK = new MoneyUnit(CurrencyUnit.getInstance("SEK"), "MoneyUnit.SEK", "SEK", true);
        SGD = new MoneyUnit(CurrencyUnit.getInstance("SGD"), "MoneyUnit.SGD", "SGD", true);
        SHP = new MoneyUnit(CurrencyUnit.getInstance("SHP"), "MoneyUnit.SHP", "SHP", true);
        SLL = new MoneyUnit(CurrencyUnit.getInstance("SLL"), "MoneyUnit.SLL", "SLL", true);
        SOS = new MoneyUnit(CurrencyUnit.getInstance("SOS"), "MoneyUnit.SOS", "SOS", true);
        SRD = new MoneyUnit(CurrencyUnit.getInstance("SRD"), "MoneyUnit.SRD", "SRD", true);
        SSP = new MoneyUnit(CurrencyUnit.getInstance("SSP"), "MoneyUnit.SSP", "SSP", true);
        STD = new MoneyUnit(CurrencyUnit.getInstance("STD"), "MoneyUnit.STD", "STD", true);
        SVC = new MoneyUnit(CurrencyUnit.getInstance("SVC"), "MoneyUnit.SVC", "SVC", true);
        SYP = new MoneyUnit(CurrencyUnit.getInstance("SYP"), "MoneyUnit.SYP", "SYP", true);
        SZL = new MoneyUnit(CurrencyUnit.getInstance("SZL"), "MoneyUnit.SZL", "SZL", true);
        THB = new MoneyUnit(CurrencyUnit.getInstance("THB"), "MoneyUnit.THB", "THB", true);
        TJS = new MoneyUnit(CurrencyUnit.getInstance("TJS"), "MoneyUnit.TJS", "TJS", true);
        TMT = new MoneyUnit(CurrencyUnit.getInstance("TMT"), "MoneyUnit.TMT", "TMT", true);
        TND = new MoneyUnit(CurrencyUnit.getInstance("TND"), "MoneyUnit.TND", "TND", true);
        TOP = new MoneyUnit(CurrencyUnit.getInstance("TOP"), "MoneyUnit.TOP", "TOP", true);
        TRY = new MoneyUnit(CurrencyUnit.getInstance("TRY"), "MoneyUnit.TRY", "TRY", true);
        TTD = new MoneyUnit(CurrencyUnit.getInstance("TTD"), "MoneyUnit.TTD", "TTD", true);
        TWD = new MoneyUnit(CurrencyUnit.getInstance("TWD"), "MoneyUnit.TWD", "TWD", true);
        TZS = new MoneyUnit(CurrencyUnit.getInstance("TZS"), "MoneyUnit.TZS", "TZS", true);
        UAH = new MoneyUnit(CurrencyUnit.getInstance("UAH"), "MoneyUnit.UAH", "UAH", true);
        UGX = new MoneyUnit(CurrencyUnit.getInstance("UGX"), "MoneyUnit.UGX", "UGX", true);
        USD = new MoneyUnit(CurrencyUnit.getInstance("USD"), "MoneyUnit.USD", "USD", true);
        USN = new MoneyUnit(CurrencyUnit.getInstance("USN"), "MoneyUnit.USN", "USN", true);
        UYI = new MoneyUnit(CurrencyUnit.getInstance("UYI"), "MoneyUnit.UYI", "UYI", true);
        UYU = new MoneyUnit(CurrencyUnit.getInstance("UYU"), "MoneyUnit.UYU", "UYU", true);
        UZS = new MoneyUnit(CurrencyUnit.getInstance("UZS"), "MoneyUnit.UZS", "UZS", true);
        VEF = new MoneyUnit(CurrencyUnit.getInstance("VEF"), "MoneyUnit.VEF", "VEF", true);
        VND = new MoneyUnit(CurrencyUnit.getInstance("VND"), "MoneyUnit.VND", "VND", true);
        VUV = new MoneyUnit(CurrencyUnit.getInstance("VUV"), "MoneyUnit.VUV", "VUV", true);
        WST = new MoneyUnit(CurrencyUnit.getInstance("WST"), "MoneyUnit.WST", "WST", true);
        XAF = new MoneyUnit(CurrencyUnit.getInstance("XAF"), "MoneyUnit.XAF", "XAF", true);
        XAG = new MoneyUnit(CurrencyUnit.getInstance("XAG"), "MoneyUnit.XAG", "XAG", true);
        XAU = new MoneyUnit(CurrencyUnit.getInstance("XAU"), "MoneyUnit.XAU", "XAU", true);
        XBA = new MoneyUnit(CurrencyUnit.getInstance("XBA"), "MoneyUnit.XBA", "XBA", true);
        XBB = new MoneyUnit(CurrencyUnit.getInstance("XBB"), "MoneyUnit.XBB", "XBB", true);
        XBC = new MoneyUnit(CurrencyUnit.getInstance("XBC"), "MoneyUnit.XBC", "XBC", true);
        XBD = new MoneyUnit(CurrencyUnit.getInstance("XBD"), "MoneyUnit.XBD", "XBD", true);
        XBT = new MoneyUnit(CurrencyUnit.getInstance("XBT"), "MoneyUnit.XBT", "XBT", true);
        XCD = new MoneyUnit(CurrencyUnit.getInstance("XCD"), "MoneyUnit.XCD", "XCD", true);
        XDR = new MoneyUnit(CurrencyUnit.getInstance("XDR"), "MoneyUnit.XDR", "XDR", true);
        XOF = new MoneyUnit(CurrencyUnit.getInstance("XOF"), "MoneyUnit.XOF", "XOF", true);
        XPD = new MoneyUnit(CurrencyUnit.getInstance("XPD"), "MoneyUnit.XPD", "XPD", true);
        XPF = new MoneyUnit(CurrencyUnit.getInstance("XPF"), "MoneyUnit.XPF", "XPF", true);
        XPT = new MoneyUnit(CurrencyUnit.getInstance("XPT"), "MoneyUnit.XPT", "XPT", true);
        XSU = new MoneyUnit(CurrencyUnit.getInstance("XSU"), "MoneyUnit.XSU", "XSU", true);
        XTS = new MoneyUnit(CurrencyUnit.getInstance("XTS"), "MoneyUnit.XTS", "XTS", true);
        XUA = new MoneyUnit(CurrencyUnit.getInstance("XUA"), "MoneyUnit.XUA", "XUA", true);
        XXX = new MoneyUnit(CurrencyUnit.getInstance("XXX"), "MoneyUnit.XXX", "XXX", true);
        YER = new MoneyUnit(CurrencyUnit.getInstance("YER"), "MoneyUnit.YER", "YER", true);
        ZAR = new MoneyUnit(CurrencyUnit.getInstance("ZAR"), "MoneyUnit.ZAR", "ZAR", true);
        ZMW = new MoneyUnit(CurrencyUnit.getInstance("ZMW"), "MoneyUnit.ZMW", "ZMW", true);
        ZWL = new MoneyUnit(CurrencyUnit.getInstance("ZWL"), "MoneyUnit.ZWL", "ZWL", true);

        standardMoneyUnit = USD;
    }

    /**
     * Define money unit.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyUnit(final CurrencyUnit currencyUnit, final String nameOrNameKey, final String abbreviationKey,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationKey, UnitSystem.OTHER, standardUnit);
        this.currencyUnit = currencyUnit;
        this.codeNumber = currencyUnit.getNumericCode();
        this.codeString = currencyUnit.getCode();
    }

    /**
     * Build a user-defined money unit.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     */
    public MoneyUnit(final CurrencyUnit currencyUnit, final String name, final String abbreviation)
    {
        this(currencyUnit, name, abbreviation, false);
    }

    /**
     * Build a money unit based on another money unit with a conversion factor.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyUnit(final CurrencyUnit currencyUnit, final String nameOrNameKey, final String abbreviationKey,
            final MoneyUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit, standardUnit);
        this.currencyUnit = currencyUnit;
        this.codeNumber = currencyUnit.getNumericCode();
        this.codeString = currencyUnit.getCode();
    }

    /**
     * Build a user-defined money unit based on another money unit with a conversion factor.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MoneyUnit(final CurrencyUnit currencyUnit, final String name, final String abbreviation,
            final MoneyUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        this(currencyUnit, name, abbreviation, referenceUnit, scaleFactorToReferenceUnit, false);
    }

    /**
     * @return the joda-money CurrencyUnit on which this djunits unit is based.
     */
    public final CurrencyUnit getCurrencyUnit()
    {
        return this.currencyUnit;
    }

    /**
     * Set the standard money unit to be used.
     * @param moneyUnit the new standard money unit.
     */
    public static final void setStandardUnit(final MoneyUnit moneyUnit)
    {
        standardMoneyUnit = moneyUnit;
        MoneyPerAreaUnit.setStandardUnit(moneyUnit);
        MoneyPerEnergyUnit.setStandardUnit(moneyUnit);
        MoneyPerLengthUnit.setStandardUnit(moneyUnit);
        MoneyPerMassUnit.setStandardUnit(moneyUnit);
        MoneyPerDurationUnit.setStandardUnit(moneyUnit);
        MoneyPerVolumeUnit.setStandardUnit(moneyUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyUnit getStandardUnit()
    {
        return standardMoneyUnit;
    }

    /**
     * @return the current standard money unit
     */
    public static final MoneyUnit getStandardMoneyUnit()
    {
        return standardMoneyUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

    
    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + this.codeNumber;
        result = prime * result + ((this.codeString == null) ? 0 : this.codeString.hashCode());
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
        MoneyUnit other = (MoneyUnit) obj;
        if (this.codeNumber != other.codeNumber)
            return false;
        if (this.codeString == null)
        {
            if (other.codeString != null)
                return false;
        }
        else if (!this.codeString.equals(other.codeString))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equalsIgnoreNaming(final Object obj)
    {
        // the difference lies in the codenumber.
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        MoneyUnit other = (MoneyUnit) obj;
        return (this.codeNumber == other.codeNumber);
    }

}
