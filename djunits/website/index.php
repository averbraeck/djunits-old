<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>DJUNITS - Delft Java UNIT System, version 3.01</title>
<meta name="Author" content="Peter Knoppers, p.knoppers@tudelft.nl" />
<meta name="Author" content="Alexander Verbraeck, a.verbraeck@tudelft.nl" />
<meta name="Description" content="Delft Java Unit System" />
<meta name="Copyright" content="Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved." />
<meta name="Language" content="en" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="en" />
<link rev="made" href="mailto:p.knoppers@tudelft.nl" />
<link rel="StyleSheet" href="sinorcaish-screen.css" type="text/css" media="screen" />
<link href="/favicon.ico" type="image/x-icon" rel="icon" />

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
  bodyStart ("index");
  ?>

    <h2>Introduction</h2>
    <p>DJUNITS is a set of Java classes that make life easy for scientific software writers by catching many common errors at compile time.</p>
    <ul>
      <li>DJUNITS performs automatic conversions between most commonly used units of the same type. E.g. conversion of distances from Miles to kilometers.</li>
      <li>DJUNITS stores all values internally in the basic SI unit for that value. The value can be converted to any (user-selectable) suitable unit for
        display.</li>
      <li>DJUNITS distinguishes Absolute and Relative values to catch common errors at compile time,</li>
      <li>DJUNITS ensures that a quantities expressed in different (but compatible) units are correctly added together. E.g. a distance in Miles is
        correctly added to a distance in kilometers.</li>
      <li>DJUNITS knows or computes the SI type of the result when a value in one unit is multiplied, or divided by another value (that may have another
        unit),</li>
      <li>DJUNITS handles Scalars, Vectors and Matrices.</li>
      <li>DJUNITS stores almost everything in immutable objects. Vectors and Matrices also come in a Mutable variant where the stored values can be modified
        one by one or all at once.</li>
      <li>DJUNITS stores values as Float or Double values.</li>
    </ul>
    <h2>Origin</h2>
    <p>
      DJUNITS was developed at the <a href="https://www.tudelft.nl" target="_blank">Delft University of Technology</a> as part of the <a href="https://www.opentrafficsim.org/">Open
        Traffic Simulator</a> project (started in 2014).
    </p>
    <p>In August 2015 it became obvious that the units and values classes developed for the Open Traffic Simulator were sufficiently mature to be used in
      other projects.</p>
    <p>
      The main authors/contributors of the DJUNITS project are <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a> and <a
        href="https://www.tudelft.nl/pknoppers" target="_blank">Peter Knoppers</a>.
    </p>

    <h2>Absolute and Relative values</h2>
    <p>Values in DJUNITS are either Absolute or Relative.</p>
    <p>
      An Absolute value is a value measured from a standard reference. For geographical directions <i>North</i> and <i>East</i> should be Absolute values.
      Adding two absolute values together makes no sense. Subtracting one absolute value from another <i>does</i> make sense (and results in a Relative value).
      Subtracting <i>East</i> from <i>North</i> should result in an angle of &plusmn;90&deg; or &plusmn;&pi;/2 (depending on the unit used to express the
      result). This means that an absolute unit needs to have a description of that reference to make it useful. Scalars subtracted from each other need
      to know their reference to be able to carry out the subtraction. 
    </p>
    <p>A Relative value expresses the difference between two (Absolute or Relative) values. The angle in the example above is a Relative value. Relative
      values can be added together and subtracted from each other (resulting in Relative values). Adding a Relative value to an Absolute value result in an
      Absolute value. Subtracting a Relative value from an Absolute value also results in an Absolute value.</p>
    <p>In the geographical example, directions are Absolute and angles are Relative. Similarly, when applied to lengths, positions are Absolute and
      distances are Relative.</p>
    <p>Generally, if adding a value to itself makes no sense, the value is Absolute; otherwise it is Relative.</p>
    <table class="simple">
      <tr>
        <th valign="bottom">&nbsp;<br />Operation
        </th>
        <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Right operand &rarr;<br />&darr; Left operand&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </th>
        <th valign="top">Absolute<br />&nbsp;
        </th>
        <th valign="top">Relative<br />&nbsp;
        </th>
      </tr>
      <tr>
        <th rowspan="2">+ (plus)</th>
        <th>Absolute</th>
        <td align="center">Not allowed</td>
        <td align="center">Absolute</td>
      </tr>
      <tr>
        <th>Relative</th>
        <td align="center">Absolute</td>
        <td align="center">Relative</td>
      </tr>
      <tr>
        <th rowspan="2">- (minus)</th>
        <th>Absolute</th>
        <td align="center">Relative</td>
        <td align="center">Absolute</td>
      </tr>
      <tr>
        <th>Relative</th>
        <td align="center">Not allowed</td>
        <td align="center">Relative</td>
      </tr>
      <tr>
        <th rowspan="2">* (times)</th>
        <th>Absolute</th>
        <td align="center">Not allowed</td>
        <td align="center">Not allowed</td>
      </tr>
      <tr>
        <th>Relative</th>
        <td align="center">Not allowed</td>
        <td align="center">Relative</td>
      </tr>
      <tr>
        <th rowspan="2">/ (divide)</th>
        <th>Absolute</th>
        <td align="center">Not allowed</td>
        <td align="center">Not allowed</td>
      </tr>
      <tr>
        <th>Relative</th>
        <td align="center">Not allowed</td>
        <td align="center">Relative</td>
      </tr>
    </table>
    Attempts to perform operations that are marked <i>not allowed</i> are caught at compile time.
    <p>All quantities make sense as Relative values. The only quantities that make sense as Absolute values are listed in the table below.</p>
    <table class="simple nowrap">
      <tr>
        <th>Quantity</th>
        <th>Absolute interpretation</th>
        <th>Absolute class</th>
        <th>Unit</th>
        <th>Relative interpretation</th>
        <th>Relative class</th>
        <th>Unit</th>
        </tr>
      <tr>
        <th>Length</th>
        <td>Position</td>
        <td>Position</td>
        <td>PositionUnit</td>
        <td>Distance</td>
        <td>Length</td>
        <td>LengthUnit</td>
        </tr>
      <tr>
        <th>Angle</th>
        <td>Direction or Slope</td>
        <td>Direction</td>
        <td>DirectionUnit</td>
        <td>Angle (direction/slope difference)</td>
        <td>Angle</td>
        <td>AngleUnit</td>
        </tr>
      <tr>
        <th>Temperature</th>
        <td>Temperature</td>
        <td>AbsoluteTemperature</td>
        <td>AbsoluteTemperatureUnit</td>
        <td>Temperature difference</td>
        <td>Temperature</td>
        <td>TemperatureUnit</td>
        </tr>
      <tr>
        <th>Time</th>
        <td>Time (instant)</td>
        <td>Time</td>
        <td>TimeUnit</td>
        <td>Duration</td>
        <td>Duration</td>
        <td>DurationUnit</td>
      </tr>
    </table>
    <p>The use of Absolute in relation to Temperature here may be confusing. In the table above, an absolute temperature is not necessarily expressed in
      Kelvin. E.g. the melting temperature of water at normal atmospheric pressure is an Absolute value (it does not make sense to add this temperature to
      itself). In DJUNITS this value would internally be stored as 273.15K, but on display it may be converted (back) to Celsius and displayed as 0&deg;C. A
      temperature difference of 5K (Kelvin) is a Relative, even though Kelvin is often called absolute temperature.</p>

    <p>Dimensionless is a special relative unit in DJUNITS that has a unit of 1.</p>

    <h2>Units</h2>
    DJUNITS has a large number of pre-defined units. Internally, all values are stored in SI-units or an equivalent standard unit. The field is called 'si' and
    can be retrieved as it is a public (immutable) field. Alternatively, the getSI() method can be used. The internal storage in SI units allows addition and
    subtraction of values that have been initialized using different units. Formatting and expressing the unit can be done using any defined unit. The code
    below illustrates some of the features.
    <pre class="highlight">
Speed speed1 = <b>new</b> Speed(20, SpeedUnit.<b>METER_PER_SECOND</b>);
Speed speed2 = <b>new</b> Speed(10, SpeedUnit.<b>MILE_PER_HOUR</b>);
Speed diff = speed1.minus(speed2);
<b>double</b> d = diff.getInUnit(SpeedUnit.<b>KNOT</b>);
<b>double</b> si = diff.si;
System.out.println(d + " knot");
System.out.println(si + " m/s (si)");
System.out.println(diff);
System.out.println(diff.toString(SpeedUnit.<b>KM_PER_HOUR</b>, false, true));
</pre>
    This would create the following output:
    <pre class="highlight">
30.187127429805614 knot
15.5296 m/s (si)
15.5296000m/s
55.9065600km/h
</pre>
    When a class implements the interface UNITS (org.djunits.unit.UNITS), all defined units are available without the prefix XxxUnit. So, in that case a
    Length can be defined as <b>new</b> Length(12.0, <b>METER</b>).

    <h2>Multiplication and Division</h2>
    <p>Multiplying or dividing physical quantities produces a result in a different physical unit. There is no general way (we could think of) where the
      Java compiler can check the type of the result in the general case. Therefore DJUNITS has an extensive list of built-in multiplication and division
      operations with known result type. For instance</p>
    <pre class="highlight">
Speed speed = <b>new</b> Speed(50, SpeedUnit.<b>KM_PER_HOUR</b>);
Duration duration = <b>new</b> Duration(0.5, DurationUnit.<b>HOUR</b>);
Length distance = speed.multiplyBy(duration);
Acceleration acc0 = speed.divideBy(duration);
Area area = distance.multiplyBy(distance);
Volume vol = area.multiplyBy(distance);
</pre>
    DJUNITS knows that the result of multiplication of a speed and a time is a distance. The value of distance is 2500m.

    <p>Although we're not entirely sure, we believe that there is never a need for multiplication or division with an Absolute operand. It just does not
      make sense to multiply 23 September 2015, 3 PM (an absolute Time) by 2...</p>

    <h2>Scalars, Vectors and Matrices</h2>
    Simple values are referred to as scalars. DJUNITS also handles groups of values (these must all be of the same type) as vectors or matrices. Vectors and
    matrices come in four varieties:
    <ul>
      <li>Dense, Immutable</li>
      <li>Dense, Mutable</li>
      <li>Sparse, Immutable</li>
      <li>Sparse, Mutable</li>
    </ul>
    <p>Dense vectors and matrices use arrays to store the values. Sparse vectors and matrices use an indexed structure to store only the non-zero values.
      Numeric 0.0 values are not stored explicitly in Sparse vectors and matrices. Very large vectors and matrices with lots of 0.0 values are more efficiently
      stored in Sparse organization.</p>
    <p>Immutable vectors and matrices do not provide methods to change any of their values. Mutable vectors and matrices have methods to update their
      values.</p>

    <h2>Doubles and Floats</h2>
    <p>The Java double precision floating point value takes 8 bytes of memory, the float value takes 4 bytes. Both are available in DJUNITS. The typed
      Double values are indicated without any prefix. So a Speed scalar is Double, and SpeedVector and SpeedMatrix are Double types. If the type differs from
      Double, and is, e.g., Float, the type is used as a prefix. The float speed scalar class is therefore FloatSpeed, and the equivalent vector and matrix
      classes are FloatSpeedVector and FloatSpeedMatrix.</p>

    <h2>Extensions</h2>
    <p>Several extensions are planned:</p>
    <ul>
      <li>Typed vectors and matrices, so a LengthMatrix can be multiplied with the inverse of a DurationMatrix (units in 1/s) to give a SpeedMatrix.
        This can be cell-cell multiplication (n x m matrix 'times' an n x m matrix yielding an n x m matrix) or real matrix multiplication (n x m matrix times
        an m x p matrix yielding an n x p matrix).</li>
      <li>Operations on matrices such as Transposition, Linear Equations, Eigenvalues, Eigenvectors, LU-decomposition, QR-decomposition, etc. ojAlgo is
        already linked to djunits as the vector and matrix calculations engine, and djunits will expose many of the ojAlgo algorithms for typed vectors and
        matrices. See <a href="http://ojalgo.org" target="_blank">http://ojalgo.org</a> for more information.
      </li>
      <li>Adding complex scalars, vectors and matrices. With the code generator, it should be quite easy to ready DJUNITS for complex typed scalars,
        vectors, and matrices. For algorithms, ojAlgo implements several Complex operations.</li>
      <li>Adding BigDecimal scalars, vectors and matrices. With the code generator, it should be quite easy to ready DJUNITS for BigDecimal typed scalars,
        vectors, and matrices. For algorithms, ojAlgo implements the BigDecimal type.</li>
    </ul>

    <h2>Documentations and test reports</h2>
    DJUNITS documentation and test reports for the current version can be found at <a href="https://djunits.org/docs/current" target="_blank">https://djunits.org/docs/current</a>
    and the API can be found at <a href="https://djunits.org/docs/current/apidocs/index.html" target="_blank">https://djunits.org/docs/current/apidocs/index.html</a>.
    <p>&nbsp;</p>
  </div>

  <!-- ======== Footer ======== -->
  <?php include ('./footer.php'); ?>

</body>
</html>
