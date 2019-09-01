package org.djunits.unit;

import java.util.ArrayList;

import org.djunits.unit.unitsystem.UnitSystem;
import org.joda.money.CurrencyUnit;

/**
 * MoneyUnit defines a monetary unit, and wraps the joda money currency unit. At this time, conversion rates between monetary
 * units are not used. A standard monetary unit, defined as a static variable, can be set to be used in the code.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 03, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        CurrencyUnit.registerCurrency("XBT", -1, 8, new ArrayList<String>());

        AED = new MoneyUnit(CurrencyUnit.of("AED"), "MoneyUnit.AED");
        AFN = new MoneyUnit(CurrencyUnit.of("AFN"), "MoneyUnit.AFN");
        ALL = new MoneyUnit(CurrencyUnit.of("ALL"), "MoneyUnit.ALL");
        AMD = new MoneyUnit(CurrencyUnit.of("AMD"), "MoneyUnit.AMD");
        ANG = new MoneyUnit(CurrencyUnit.of("ANG"), "MoneyUnit.ANG");
        AOA = new MoneyUnit(CurrencyUnit.of("AOA"), "MoneyUnit.AOA");
        ARS = new MoneyUnit(CurrencyUnit.of("ARS"), "MoneyUnit.ARS");
        AUD = new MoneyUnit(CurrencyUnit.of("AUD"), "MoneyUnit.AUD");
        AWG = new MoneyUnit(CurrencyUnit.of("AWG"), "MoneyUnit.AWG");
        AZN = new MoneyUnit(CurrencyUnit.of("AZN"), "MoneyUnit.AZN");
        BAM = new MoneyUnit(CurrencyUnit.of("BAM"), "MoneyUnit.BAM");
        BBD = new MoneyUnit(CurrencyUnit.of("BBD"), "MoneyUnit.BBD");
        BDT = new MoneyUnit(CurrencyUnit.of("BDT"), "MoneyUnit.BDT");
        BGN = new MoneyUnit(CurrencyUnit.of("BGN"), "MoneyUnit.BGN");
        BHD = new MoneyUnit(CurrencyUnit.of("BHD"), "MoneyUnit.BHD");
        BIF = new MoneyUnit(CurrencyUnit.of("BIF"), "MoneyUnit.BIF");
        BMD = new MoneyUnit(CurrencyUnit.of("BMD"), "MoneyUnit.BMD");
        BND = new MoneyUnit(CurrencyUnit.of("BND"), "MoneyUnit.BND");
        BOB = new MoneyUnit(CurrencyUnit.of("BOB"), "MoneyUnit.BOB");
        BOV = new MoneyUnit(CurrencyUnit.of("BOV"), "MoneyUnit.BOV");
        BRL = new MoneyUnit(CurrencyUnit.of("BRL"), "MoneyUnit.BRL");
        BSD = new MoneyUnit(CurrencyUnit.of("BSD"), "MoneyUnit.BSD");
        BTN = new MoneyUnit(CurrencyUnit.of("BTN"), "MoneyUnit.BTN");
        BWP = new MoneyUnit(CurrencyUnit.of("BWP"), "MoneyUnit.BWP");
        BYN = new MoneyUnit(CurrencyUnit.of("BYN"), "MoneyUnit.BYN");
        BYR = new MoneyUnit(CurrencyUnit.of("BYR"), "MoneyUnit.BYR");
        BZD = new MoneyUnit(CurrencyUnit.of("BZD"), "MoneyUnit.BZD");
        CAD = new MoneyUnit(CurrencyUnit.of("CAD"), "MoneyUnit.CAD");
        CDF = new MoneyUnit(CurrencyUnit.of("CDF"), "MoneyUnit.CDF");
        CHE = new MoneyUnit(CurrencyUnit.of("CHE"), "MoneyUnit.CHE");
        CHF = new MoneyUnit(CurrencyUnit.of("CHF"), "MoneyUnit.CHF");
        CHW = new MoneyUnit(CurrencyUnit.of("CHW"), "MoneyUnit.CHW");
        CLF = new MoneyUnit(CurrencyUnit.of("CLF"), "MoneyUnit.CLF");
        CLP = new MoneyUnit(CurrencyUnit.of("CLP"), "MoneyUnit.CLP");
        CNY = new MoneyUnit(CurrencyUnit.of("CNY"), "MoneyUnit.CNY");
        COP = new MoneyUnit(CurrencyUnit.of("COP"), "MoneyUnit.COP");
        COU = new MoneyUnit(CurrencyUnit.of("COU"), "MoneyUnit.COU");
        CRC = new MoneyUnit(CurrencyUnit.of("CRC"), "MoneyUnit.CRC");
        CUC = new MoneyUnit(CurrencyUnit.of("CUC"), "MoneyUnit.CUC");
        CUP = new MoneyUnit(CurrencyUnit.of("CUP"), "MoneyUnit.CUP");
        CVE = new MoneyUnit(CurrencyUnit.of("CVE"), "MoneyUnit.CVE");
        CZK = new MoneyUnit(CurrencyUnit.of("CZK"), "MoneyUnit.CZK");
        DJF = new MoneyUnit(CurrencyUnit.of("DJF"), "MoneyUnit.DJF");
        DKK = new MoneyUnit(CurrencyUnit.of("DKK"), "MoneyUnit.DKK");
        DOP = new MoneyUnit(CurrencyUnit.of("DOP"), "MoneyUnit.DOP");
        DZD = new MoneyUnit(CurrencyUnit.of("DZD"), "MoneyUnit.DZD");
        EGP = new MoneyUnit(CurrencyUnit.of("EGP"), "MoneyUnit.EGP");
        ERN = new MoneyUnit(CurrencyUnit.of("ERN"), "MoneyUnit.ERN");
        ETB = new MoneyUnit(CurrencyUnit.of("ETB"), "MoneyUnit.ETB");
        EUR = new MoneyUnit(CurrencyUnit.of("EUR"), "MoneyUnit.EUR");
        FJD = new MoneyUnit(CurrencyUnit.of("FJD"), "MoneyUnit.FJD");
        FKP = new MoneyUnit(CurrencyUnit.of("FKP"), "MoneyUnit.FKP");
        GBP = new MoneyUnit(CurrencyUnit.of("GBP"), "MoneyUnit.GBP");
        GEL = new MoneyUnit(CurrencyUnit.of("GEL"), "MoneyUnit.GEL");
        GHS = new MoneyUnit(CurrencyUnit.of("GHS"), "MoneyUnit.GHS");
        GIP = new MoneyUnit(CurrencyUnit.of("GIP"), "MoneyUnit.GIP");
        GMD = new MoneyUnit(CurrencyUnit.of("GMD"), "MoneyUnit.GMD");
        GNF = new MoneyUnit(CurrencyUnit.of("GNF"), "MoneyUnit.GNF");
        GTQ = new MoneyUnit(CurrencyUnit.of("GTQ"), "MoneyUnit.GTQ");
        GYD = new MoneyUnit(CurrencyUnit.of("GYD"), "MoneyUnit.GYD");
        HKD = new MoneyUnit(CurrencyUnit.of("HKD"), "MoneyUnit.HKD");
        HNL = new MoneyUnit(CurrencyUnit.of("HNL"), "MoneyUnit.HNL");
        HRK = new MoneyUnit(CurrencyUnit.of("HRK"), "MoneyUnit.HRK");
        HTG = new MoneyUnit(CurrencyUnit.of("HTG"), "MoneyUnit.HTG");
        HUF = new MoneyUnit(CurrencyUnit.of("HUF"), "MoneyUnit.HUF");
        IDR = new MoneyUnit(CurrencyUnit.of("IDR"), "MoneyUnit.IDR");
        ILS = new MoneyUnit(CurrencyUnit.of("ILS"), "MoneyUnit.ILS");
        INR = new MoneyUnit(CurrencyUnit.of("INR"), "MoneyUnit.INR");
        IQD = new MoneyUnit(CurrencyUnit.of("IQD"), "MoneyUnit.IQD");
        IRR = new MoneyUnit(CurrencyUnit.of("IRR"), "MoneyUnit.IRR");
        ISK = new MoneyUnit(CurrencyUnit.of("ISK"), "MoneyUnit.ISK");
        JMD = new MoneyUnit(CurrencyUnit.of("JMD"), "MoneyUnit.JMD");
        JOD = new MoneyUnit(CurrencyUnit.of("JOD"), "MoneyUnit.JOD");
        JPY = new MoneyUnit(CurrencyUnit.of("JPY"), "MoneyUnit.JPY");
        KES = new MoneyUnit(CurrencyUnit.of("KES"), "MoneyUnit.KES");
        KGS = new MoneyUnit(CurrencyUnit.of("KGS"), "MoneyUnit.KGS");
        KHR = new MoneyUnit(CurrencyUnit.of("KHR"), "MoneyUnit.KHR");
        KMF = new MoneyUnit(CurrencyUnit.of("KMF"), "MoneyUnit.KMF");
        KPW = new MoneyUnit(CurrencyUnit.of("KPW"), "MoneyUnit.KPW");
        KRW = new MoneyUnit(CurrencyUnit.of("KRW"), "MoneyUnit.KRW");
        KWD = new MoneyUnit(CurrencyUnit.of("KWD"), "MoneyUnit.KWD");
        KYD = new MoneyUnit(CurrencyUnit.of("KYD"), "MoneyUnit.KYD");
        KZT = new MoneyUnit(CurrencyUnit.of("KZT"), "MoneyUnit.KZT");
        LAK = new MoneyUnit(CurrencyUnit.of("LAK"), "MoneyUnit.LAK");
        LBP = new MoneyUnit(CurrencyUnit.of("LBP"), "MoneyUnit.LBP");
        LKR = new MoneyUnit(CurrencyUnit.of("LKR"), "MoneyUnit.LKR");
        LRD = new MoneyUnit(CurrencyUnit.of("LRD"), "MoneyUnit.LRD");
        LSL = new MoneyUnit(CurrencyUnit.of("LSL"), "MoneyUnit.LSL");
        LYD = new MoneyUnit(CurrencyUnit.of("LYD"), "MoneyUnit.LYD");
        MAD = new MoneyUnit(CurrencyUnit.of("MAD"), "MoneyUnit.MAD");
        MDL = new MoneyUnit(CurrencyUnit.of("MDL"), "MoneyUnit.MDL");
        MGA = new MoneyUnit(CurrencyUnit.of("MGA"), "MoneyUnit.MGA");
        MKD = new MoneyUnit(CurrencyUnit.of("MKD"), "MoneyUnit.MKD");
        MMK = new MoneyUnit(CurrencyUnit.of("MMK"), "MoneyUnit.MMK");
        MNT = new MoneyUnit(CurrencyUnit.of("MNT"), "MoneyUnit.MNT");
        MOP = new MoneyUnit(CurrencyUnit.of("MOP"), "MoneyUnit.MOP");
        MRO = new MoneyUnit(CurrencyUnit.of("MRO"), "MoneyUnit.MRO");
        MUR = new MoneyUnit(CurrencyUnit.of("MUR"), "MoneyUnit.MUR");
        MVR = new MoneyUnit(CurrencyUnit.of("MVR"), "MoneyUnit.MVR");
        MWK = new MoneyUnit(CurrencyUnit.of("MWK"), "MoneyUnit.MWK");
        MXN = new MoneyUnit(CurrencyUnit.of("MXN"), "MoneyUnit.MXN");
        MXV = new MoneyUnit(CurrencyUnit.of("MXV"), "MoneyUnit.MXV");
        MYR = new MoneyUnit(CurrencyUnit.of("MYR"), "MoneyUnit.MYR");
        MZN = new MoneyUnit(CurrencyUnit.of("MZN"), "MoneyUnit.MZN");
        NAD = new MoneyUnit(CurrencyUnit.of("NAD"), "MoneyUnit.NAD");
        NGN = new MoneyUnit(CurrencyUnit.of("NGN"), "MoneyUnit.NGN");
        NIO = new MoneyUnit(CurrencyUnit.of("NIO"), "MoneyUnit.NIO");
        NOK = new MoneyUnit(CurrencyUnit.of("NOK"), "MoneyUnit.NOK");
        NPR = new MoneyUnit(CurrencyUnit.of("NPR"), "MoneyUnit.NPR");
        NZD = new MoneyUnit(CurrencyUnit.of("NZD"), "MoneyUnit.NZD");
        OMR = new MoneyUnit(CurrencyUnit.of("OMR"), "MoneyUnit.OMR");
        PAB = new MoneyUnit(CurrencyUnit.of("PAB"), "MoneyUnit.PAB");
        PEN = new MoneyUnit(CurrencyUnit.of("PEN"), "MoneyUnit.PEN");
        PGK = new MoneyUnit(CurrencyUnit.of("PGK"), "MoneyUnit.PGK");
        PHP = new MoneyUnit(CurrencyUnit.of("PHP"), "MoneyUnit.PHP");
        PKR = new MoneyUnit(CurrencyUnit.of("PKR"), "MoneyUnit.PKR");
        PLN = new MoneyUnit(CurrencyUnit.of("PLN"), "MoneyUnit.PLN");
        PYG = new MoneyUnit(CurrencyUnit.of("PYG"), "MoneyUnit.PYG");
        QAR = new MoneyUnit(CurrencyUnit.of("QAR"), "MoneyUnit.QAR");
        RON = new MoneyUnit(CurrencyUnit.of("RON"), "MoneyUnit.RON");
        RSD = new MoneyUnit(CurrencyUnit.of("RSD"), "MoneyUnit.RSD");
        RUB = new MoneyUnit(CurrencyUnit.of("RUB"), "MoneyUnit.RUB");
        RWF = new MoneyUnit(CurrencyUnit.of("RWF"), "MoneyUnit.RWF");
        SAR = new MoneyUnit(CurrencyUnit.of("SAR"), "MoneyUnit.SAR");
        SBD = new MoneyUnit(CurrencyUnit.of("SBD"), "MoneyUnit.SBD");
        SCR = new MoneyUnit(CurrencyUnit.of("SCR"), "MoneyUnit.SCR");
        SDG = new MoneyUnit(CurrencyUnit.of("SDG"), "MoneyUnit.SDG");
        SEK = new MoneyUnit(CurrencyUnit.of("SEK"), "MoneyUnit.SEK");
        SGD = new MoneyUnit(CurrencyUnit.of("SGD"), "MoneyUnit.SGD");
        SHP = new MoneyUnit(CurrencyUnit.of("SHP"), "MoneyUnit.SHP");
        SLL = new MoneyUnit(CurrencyUnit.of("SLL"), "MoneyUnit.SLL");
        SOS = new MoneyUnit(CurrencyUnit.of("SOS"), "MoneyUnit.SOS");
        SRD = new MoneyUnit(CurrencyUnit.of("SRD"), "MoneyUnit.SRD");
        SSP = new MoneyUnit(CurrencyUnit.of("SSP"), "MoneyUnit.SSP");
        STD = new MoneyUnit(CurrencyUnit.of("STD"), "MoneyUnit.STD");
        SVC = new MoneyUnit(CurrencyUnit.of("SVC"), "MoneyUnit.SVC");
        SYP = new MoneyUnit(CurrencyUnit.of("SYP"), "MoneyUnit.SYP");
        SZL = new MoneyUnit(CurrencyUnit.of("SZL"), "MoneyUnit.SZL");
        THB = new MoneyUnit(CurrencyUnit.of("THB"), "MoneyUnit.THB");
        TJS = new MoneyUnit(CurrencyUnit.of("TJS"), "MoneyUnit.TJS");
        TMT = new MoneyUnit(CurrencyUnit.of("TMT"), "MoneyUnit.TMT");
        TND = new MoneyUnit(CurrencyUnit.of("TND"), "MoneyUnit.TND");
        TOP = new MoneyUnit(CurrencyUnit.of("TOP"), "MoneyUnit.TOP");
        TRY = new MoneyUnit(CurrencyUnit.of("TRY"), "MoneyUnit.TRY");
        TTD = new MoneyUnit(CurrencyUnit.of("TTD"), "MoneyUnit.TTD");
        TWD = new MoneyUnit(CurrencyUnit.of("TWD"), "MoneyUnit.TWD");
        TZS = new MoneyUnit(CurrencyUnit.of("TZS"), "MoneyUnit.TZS");
        UAH = new MoneyUnit(CurrencyUnit.of("UAH"), "MoneyUnit.UAH");
        UGX = new MoneyUnit(CurrencyUnit.of("UGX"), "MoneyUnit.UGX");
        USD = new MoneyUnit(CurrencyUnit.of("USD"), "MoneyUnit.USD");
        USN = new MoneyUnit(CurrencyUnit.of("USN"), "MoneyUnit.USN");
        UYI = new MoneyUnit(CurrencyUnit.of("UYI"), "MoneyUnit.UYI");
        UYU = new MoneyUnit(CurrencyUnit.of("UYU"), "MoneyUnit.UYU");
        UZS = new MoneyUnit(CurrencyUnit.of("UZS"), "MoneyUnit.UZS");
        VEF = new MoneyUnit(CurrencyUnit.of("VEF"), "MoneyUnit.VEF");
        VND = new MoneyUnit(CurrencyUnit.of("VND"), "MoneyUnit.VND");
        VUV = new MoneyUnit(CurrencyUnit.of("VUV"), "MoneyUnit.VUV");
        WST = new MoneyUnit(CurrencyUnit.of("WST"), "MoneyUnit.WST");
        XAF = new MoneyUnit(CurrencyUnit.of("XAF"), "MoneyUnit.XAF");
        XAG = new MoneyUnit(CurrencyUnit.of("XAG"), "MoneyUnit.XAG");
        XAU = new MoneyUnit(CurrencyUnit.of("XAU"), "MoneyUnit.XAU");
        XBA = new MoneyUnit(CurrencyUnit.of("XBA"), "MoneyUnit.XBA");
        XBB = new MoneyUnit(CurrencyUnit.of("XBB"), "MoneyUnit.XBB");
        XBC = new MoneyUnit(CurrencyUnit.of("XBC"), "MoneyUnit.XBC");
        XBD = new MoneyUnit(CurrencyUnit.of("XBD"), "MoneyUnit.XBD");
        XCD = new MoneyUnit(CurrencyUnit.of("XCD"), "MoneyUnit.XCD");
        XDR = new MoneyUnit(CurrencyUnit.of("XDR"), "MoneyUnit.XDR");
        XOF = new MoneyUnit(CurrencyUnit.of("XOF"), "MoneyUnit.XOF");
        XPD = new MoneyUnit(CurrencyUnit.of("XPD"), "MoneyUnit.XPD");
        XPF = new MoneyUnit(CurrencyUnit.of("XPF"), "MoneyUnit.XPF");
        XPT = new MoneyUnit(CurrencyUnit.of("XPT"), "MoneyUnit.XPT");
        XSU = new MoneyUnit(CurrencyUnit.of("XSU"), "MoneyUnit.XSU");
        XTS = new MoneyUnit(CurrencyUnit.of("XTS"), "MoneyUnit.XTS");
        XUA = new MoneyUnit(CurrencyUnit.of("XUA"), "MoneyUnit.XUA");
        XXX = new MoneyUnit(CurrencyUnit.of("XXX"), "MoneyUnit.XXX");
        YER = new MoneyUnit(CurrencyUnit.of("YER"), "MoneyUnit.YER");
        ZAR = new MoneyUnit(CurrencyUnit.of("ZAR"), "MoneyUnit.ZAR");
        ZMW = new MoneyUnit(CurrencyUnit.of("ZMW"), "MoneyUnit.ZMW");
        ZWL = new MoneyUnit(CurrencyUnit.of("ZWL"), "MoneyUnit.ZWL");
        XBT = new MoneyUnit(CurrencyUnit.of("XBT"), "MoneyUnit.XBT");

        standardMoneyUnit = USD;
    }

    /**
     * Define money unit.
     * @param currencyUnit CurrencyUnit; the joda-money CurrencyUnit on which this djunits unit is based
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     */
    private MoneyUnit(final CurrencyUnit currencyUnit, final String abbreviationKey)
    {
        super(abbreviationKey, UnitSystem.OTHER);
        this.currencyUnit = currencyUnit;
        this.codeNumber = currencyUnit.getNumericCode();
        this.codeString = currencyUnit.getCode();
    }

    /**
     * Build a user-defined money unit.
     * @param currencyUnit CurrencyUnit; the joda-money CurrencyUnit on which this djunits unit is based
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     */
    public MoneyUnit(final CurrencyUnit currencyUnit, final String name, final String abbreviation)
    {
        super(name, abbreviation, UnitSystem.OTHER);
        this.currencyUnit = currencyUnit;
        this.codeNumber = currencyUnit.getNumericCode();
        this.codeString = currencyUnit.getCode();
    }

    /**
     * Build a money unit based on another money unit with a conversion factor.
     * @param currencyUnit CurrencyUnit; the joda-money CurrencyUnit on which this djunits unit is based
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param referenceUnit MoneyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private MoneyUnit(final CurrencyUnit currencyUnit, final String abbreviationKey, final MoneyUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.currencyUnit = currencyUnit;
        this.codeNumber = currencyUnit.getNumericCode();
        this.codeString = currencyUnit.getCode();
    }

    /**
     * Build a user-defined money unit based on another money unit with a conversion factor.
     * @param currencyUnit CurrencyUnit; the joda-money CurrencyUnit on which this djunits unit is based
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param referenceUnit MoneyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MoneyUnit(final CurrencyUnit currencyUnit, final String name, final String abbreviation,
            final MoneyUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.currencyUnit = currencyUnit;
        this.codeNumber = currencyUnit.getNumericCode();
        this.codeString = currencyUnit.getCode();
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
     * @param moneyUnit MoneyUnit; the new standard money unit.
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
