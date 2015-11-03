<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>DJUNITS - Delft Java UNIT System - Building a Unit</title>
<meta name="Author" content="Peter Knoppers, p.knoppers@tudelft.nl" />
<meta name="Author" content="Alexander Verbraeck, a.verbraeck@tudelft.nl" />
<meta name="Description" content="Delft Java Unit System" />
<meta name="Copyright" content="Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved." />
<meta name="Language" content="en" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="en" />
<link rev="made" href="mailto:p.knoppers@tudelft.nl" />
<link rel="StyleSheet" href="sinorcaish-screen.css" type="text/css" media="screen" />

<script type="text/javascript">
	/* Prevent another site from "framing" this web page */
	if (top != self) {
		top.location.href = location.href;
	}
</script>
</head>

<body>

  <?php
  include ("common.php");
  bodyStart ("building_unit");
  ?>

    <h2>Adding a unit instance to an existing unit</h2>

    DJUNITS defines a sizable number of instantiated units that are ready to use, but not all. Therefore, extra instantiated units can be easily added. Suppose,
    that a user would like to add a Furlong (an imperial length unit of one eighth of a mile, or 660 feet), a Fortnight (a time unit of 14 days), and a speed
    unit that indicates the speed in Furlongs per Fortnight. Suppose that the user wants to make these three units available as public static constants in a
    utility class. The code to do so looks as follows:

    <pre class="highlight">
public static LengthUnit FURLONG = new LengthUnit("Furlong", "fr", 
   UnitSystem.IMPERIAL, LengthUnit.FOOT, 660);
public static TimeUnit FORTNIGHT = new TimeUnit("Fortnight", "fn", 
   UnitSystem.OTHER, TimeUnit.DAY, 14);
public static SpeedUnit FURLONGS_PER_FORTNIGHT = new SpeedUnit(
   FURLONG, FORTNIGHT, "Furlongs per Fortnight", "fr/fn", UnitSystem.OTHER);
</pre>

    The first two definitions use a constructor that define a unit with respect to another unit using a factor, as the LengthUnit has been defined with a
    LinearScale and as it has a constructor with a factor. It is no problem that the Furlong is defined with respect to a Foot; the factor to the SI unit will
    be calculated as part of the constructor. The last definition uses the speed unit constructor that takes a length unit and a time unit, and constructs a
    speed unit from this. Again, the factor to map Furlongs per Fortnight to and from the SI unit meters per second, will be automatically calculated. These
    units can now be used in any piece of code, e.g.:

    <pre class="highlight">
Length.Rel fr1000 = new Length.Rel(1000.0, FURLONG);
Time.Rel twoWeeks = new Time.Rel(1.0, FORTNIGHT);
Speed speed = fr1000.divideBy(twoWeeks);
System.out.println(speed);
System.out.println(speed.toString(FURLONGS_PER_FORTNIGHT));
</pre>

    The program will print the following output:

    <pre class="highlight">
0.16630952m/s
1000.00000fr/fn
</pre>

    <h2>Defining a completely new Unit</h2>

    <p>Of course it is also possible to define a completely new unit from scratch. The instructions below show how to create a new unit.</p>
    <p>
      Every unit extends Unit with the defined unit as its generic; this ensures that the generic unit can do proper housekeeping, also for the units that are
      user-defined. Many units have a natural zero value and linear scales. These units extend the LinearUnit that provides a number of constructors with an
      easy-to-use factor to create a linear scale with respect to the standard (SI) unit. The header of the user-defined unit for jerk, the rate of change of
      acceleration (meter per second<sup>3</sup>) is therefore:
    </p>
    <pre class="highlight">
public class JerkUnit extends LinearUnit&lt;JerkUnit&gt;
</pre>

    <p>Often, the unit(s) on which the new unit is based are stored as part of the unit. In this case, a length unit and a time unit. Furthermore, several
      standard units are defined, among which the SI constant, if possible:</p>

    <pre class="highlight">
private final LengthUnit lengthUnit;
private final TimeUnit lengthUnit;
public static final JerkUnit SI;
public static final JerkUnit M_PER_S3;
public static final JerkUnit CM_PER_S3;
public static final JerkUnit FT_PER_S3;
public static final JerkUnit JERK;
</pre>

    <p>
      We usually define the constants in a static code block, to ensure the <i>order</i> in which the static units are defined. If the units are defined as part
      of the public static definitions, one cannot guarantee that the SI unit will be defined before other units that are defined on the basis of the SI unit,
      for instance. The static code block (also called the class constructor or &lt;clinit&gt;) is executed only once when the class is loaded for the first
      time. Also see the different ways that the constructors are used. The FT_PER_S3 is defined on the basis of the LengthUnit FOOT, while the JERK (also a
      [ft/s<sup>3</sup>]) is defined respective to the SI unit with a factor.
    </p>

    <pre class="highlight">
static 
{
  SI = new JerkUnit(LengthUnit.METER, TimeUnit.SECOND, 
    "meter per cubed second", "m/s^3", UnitSystem.SI_BASE); 
  M_PER_S3 = SI;
  CM_PER_S3 = new JerkUnit(LengthUnit.CENTIMETER, TimeUnit.SECOND, 
    "centimeter per cubed second", "cm/s^3", UnitSystem.SI_BASE); 
  FT_PER_S3 = new JerkUnit(LengthUnit.FOOT, TimeUnit.SECOND, 
    "foot per cubed second", "ft/s^3", UnitSystem.IMPERIAL);
  JERK = new JerkUnit("jerk, "jerk", UnitSystem.OTHER, SI, 0.3048);
}
</pre>

    <p>The constructors are pretty straightforward; they define the unit either on the basis of the SI unit, or on the basis of a length unit and a time
      unit (the factor of which is cubed):</p>

    <pre class="highlight">
public JerkUnit(final LengthUnit lengthUnit, final TimeUnit timeUnit, final String name,
         final String abbreviation, final UnitSystem unitSystem)
{
  super(name, abbreviation, unitSystem, SI, lengthUnit.getConversionFactorToStandardUnit()
          / Math.pow(timeUnit.getConversionFactorToStandardUnit(), 3.0), false);
  this.lengthUnit = lengthUnit;
  this.timeUnit = timeUnit;
}

 public JerkUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final JerkUnit referenceUnit, final double conversionFactorToReferenceUnit)
{
  super(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
	      false);
  this.lengthUnit = referenceUnit.getLengthUnit();
  this.timeUnit = referenceUnit.getTimeUnit();
}
</pre>

    <p>
      The "false" as the last argument to the super-constructor of the Unit indicates that this is not a standard unit. This means it is not localized, nor
      looked up in the "localeunit.properties" file. Instead, the strings given as "name" and "abbreviation" are used when printing the unit. In case you <i>add</i>
      the units to the localization files, use the <i>key</i> to the items in the localization file as name and abbreviation. The Unit class will then look up
      the (localized) strings for the name and abbreviation in the corresponding language locale files.
    </p>

    <p>Finally, add the methods that are prescribed by Unit, and allow the user of the class to retrieve the length unit and time unit on which this class
      has been based (if necessary):</p>

    <pre class="highlight">
public final LengthUnit getLengthUnit() { return this.lengthUnit; }
public final TimeUnit getTimeUnit() { return this.timeUnit; }

@Override
public final JerkUnit getStandardUnit() { return SI; }

@Override
public final String getSICoefficientsString() { return "m/s3"; }
</pre>

    <p>The getSICoefficientsString() method should return a String with SI coefficients in a fixed order: kg - m - s - A - K - cd - mol. If necessary, one
      divider can be used; in that case the coefficients should only appear in the numerator or the denominator, but not in both. For the numerator and the
      denominator, the order given should be used. Coefficients are indicated as a positive number. So, Volts have an SI unit of: kgm2/s3A. If there is only a
      denominator, use 1/ as the start of the string. Frequency has 1/s as the SI coefficient string.</p>

    <p></p>
    <p style="font-size: 9pt">
      Note: the amount of one Jerk is a foot per cubed second, and comes from several sources, e.g., <a href="https://www.unc.edu/~rowlett/units/dictJ.html"
        target="_blank">https://www.unc.edu/~rowlett/units/dictJ.html</a>.<br /> Note: the above code is for instructional purposes and does not include
      documentation and JavaDoc. Never write code without it!
    </p>
    <p></p>

  </div>

  <!-- ======== Footer ======== -->

  <div id="footer">
    <hr />
    Copyright &copy; 2015, Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br />DJUNITS uses a BSD-style
    license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
  </div>

</body>
</html>
