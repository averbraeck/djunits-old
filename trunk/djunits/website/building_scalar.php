<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>DJUNITS - Delft Java UNIT System - Building a Scalar</title>
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
  bodyStart ("building_scalar");
  ?>

    <h2>Introduction</h2>
    <p>
      When a new Unit has been defined, it can be immediately used in a Scalar, Vector, or Matrix. Suppose we have defined a JerkUnit with [m/s<sup>3</sup>] as
      the SI unit. We can use it in a Double or Float Scalar, Vector, or Matrix:
    </p>

    <pre class="highlight">
DoubleScalar.Rel&lt;JerkUnit&gt; jerk1 =
    new DoubleScalar.Rel&lt;&gt;(1.2, JerkUnit.SI);
DoubleScalar.Rel&lt;JerkUnit&gt; jerk2 = jerk1.multiplyBy(2.0);
double[] sv = new double[] {1, 2, 3, 4, 5}; 
DoubleVector.Rel&lt;JerkUnit&gt; jerkVector = 
    new DoubleVector.Rel&lt;JerkUnit&gt;(sv, 
    JerkUnit.SI, StorageType.DENSE);
</pre>

    <p>But it would be much nicer if we can define a Scalar called Jerk and a Vector called JerkVector that would allow us to code this as follows:</p>

    <pre class="highlight">
Jerk jerk1 = new Jerk(1.2, JerkUnit.SI);
Jerk jerk2 = jerk1.multiplyBy(2.0);
double[] sv = new double[] {1, 2, 3, 4, 5}; 
JerkVector jerkVector = 
    new JerkVector(sv, JerkUnit.SI, StorageType.DENSE);
</pre>

    <p>The next sections will explain how to quickly build a new Relative Scalar type, and a new Scalar type that has an absolute and a relative subtype.</p>

    <h2>Extending a Relative ScalarType from the Abstract Scalar Template</h2>
    <p>A number of Abstract classes have been created that help to quickly instantiate new Scalar, Vector, and Matrix classes. For the Scalar class, these are
      AbstractDoubleScalarAbs and AbstractDoubleScalarRel. The AbstractDoubleScalarRel class takes two generic arguments: the unit, and the name of the class itself. The
      2nd parameter might seem strange, as the definition looks to be self-referential. The way it is used is that in the methods of the Abstract class, the
      generics argument is used to indicate the return type and argument of methods that refer to the defined scalar type. So the first line of the new Jerk
      scalar is:</p>

    <pre class="highlight">
public class Jerk extends AbstractDoubleScalarRel&lt;JerkUnit, Jerk&gt;
</pre>

    <p>The next lines define two constructors, one that takes a double argument, and one that takes another Jerk scalar:</p>

    <pre class="highlight">
public Jerk(final double value, final JerkUnit unit)
{
    super(value, unit);
}

public Jerk(final Jerk value)
{
    super(value);
}
</pre>

    <p>Another method that has to be implemented is the instantiateTypeRel method. This method is used by the Abstract superclass to instantiate new scalar
      instances of the right type:</p>

    <pre class="highlight">
@Override
public final Jerk instantiateRel(final double value, final JerkUnit unit)
{
    return new Jerk(value, unit);
}
</pre>

    <p>With these constructors, and the instantiate method, the new Scalar is ready to use.</p>

    <h2>Extra methods to implement</h2>

    <p>
      Often, extra methods are implemented for multiplication and division from the just defined type to other types. E.g., when we multiply the Jerk by a
      (Relative) Time, we get an Acceleration. If we divide it by an Acceleration, we get a Frequency ([m/s<sup>3</sup>] / [m/s<sup>2</sup>] = [1/s]). These
      methods can be defined as follows:
    </p>

    <pre class="highlight">
public final Acceleration multiplyBy(final Duration v)
{
    return new Acceleration(this.si * v.si, AccelerationUnit.SI);
}

public final Frequency divideBy(final Acceleration v)
{
    return new Frequency(this.si / v.si, FrequencyUnit.SI);
}
</pre>

    <p>We can make good use of the fact that the internal storage of all scalars is always in standard (if possible, SI) units.</p>
    <p>Another methods that is often implemented is a static interpolate method, to interpolate between two Jerk scalars with a certain ratio (if the ration
      is less than zero, or greater than one, the same method can be used for linear extrapolation):</p>

    <pre class="highlight">
public static Jerk interpolate(final Jerk zero, 
    final Jerk one, final double ratio)
{
    return new Jerk(zero.getInUnit() * (1 - ratio) 
        + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
}
</pre>

    <p>
      The above interpolate method also shows how to get the result in the unit of the first argument. When the first argument has been defined in [ft/s<sup>3</sup>]
      and the second argument in [m/s<sup>3</sup>], the value of the second argument is first transformed into the [ft/s<sup>3</sup>] unit, before
      interpolating. The new unit is expressed in zero.getUnit(), so for the outside world, it will be visible in [ft/s<sup>3</sup>]. Note that the internal
      storage is <i>always</i> in the standard (SI) unit, so internally the value will still be stored in [m/s<sup>3</sup>].
    </p>

    <h2>Building a unit with absolute and relative subclasses</h2>
    <p>
      Most classes are just relative, and don't have an absolute version. <br />&nbsp;
    </p>
  </div>

  <!-- ======== Footer ======== -->

  <div id="footer">
    <hr />
    Copyright &copy; 2015-2016, Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br /> DJUNITS uses a BSD-style
    license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
  </div>

</body>
</html>
