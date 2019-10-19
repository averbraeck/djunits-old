<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>DJUNITS - Delft Java UNIT System - Building a Unit</title>
<meta name="Author" content="Peter Knoppers, p.knoppers@tudelft.nl" />
<meta name="Author" content="Alexander Verbraeck, a.verbraeck@tudelft.nl" />
<meta name="Description" content="Delft Java Unit System" />
<meta name="Copyright" content="Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved." />
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
  bodyStart ("source");
  ?>

    <h2>SVN Location</h2>

    <p>
      Source code can be checked out as an anonymous user from <a href="https://svn.tbm.tudelft.nl/DJUNITS/trunk" target="_blank">https://svn.tbm.tudelft.nl/DJUNITS/</a>.
      Releases can be found at <a href="https://svn.tbm.tudelft.nl/DJUNITS/release" target="_blank">https://svn.tbm.tudelft.nl/DJUNITS/release</a>.
    </p>

    <h2>Package structure</h2>

    <p>DJUNITS is divided into a number of packages:</p>

    <ul>
      <li><b>org.djunits.locale</b> for localization of the units. Currently, localization files are provided for English and Dutch. The localization files
        can be found in src/main/resources. If you like to write a localization for your own language, please do so (but contact us first so we can prevent two
        persons doing the same task).<br />&nbsp;</li>

      <li><b>org.djunits.unit</b> where the unit classes are stored. Each unit has one or more constructors. A SpeedUnit can e.g. be created as a factor of
        the standard, SI-based speed unit SpeedUnit.METER_PER_SECOND, or as a combination of a LengthUnit and a DurationUnit, e.g., LengthUnit.MILE and
        DurationUnit.HOUR, leading to a SpeedUnit that indicates speed in miles per hour. Conversions take place automatically. The unit package also contains
        difference 'scales' for units, such as the linear scale that is used in most units, the OffsetUnit scale that is used in e.g., Temperature, the
        PercentageUnit scale that is used in percentage angles, and the LogarithmicUnit scale that can be used in e.g., Decibels.<br />&nbsp;</li>

      <li><b>org.djunits.unit.scale</b> which defines the scales that can be used for a unit. Examples are the LinearScale that is used in most units, the
        OffsetLinearScale that is used in e.g., Temperature, the GradeScale that is used in percentage angles, and the LogarithmicScale that can be used in
        e.g., Decibels. The Scale offers two methods: a method to convert to the standard unit of that type (e.g. from degree Fahrenheit to Kelvin) and a method
        to convert from the standard unit of that type to the given type (e.g. from Kelvin to degree Fahrenheit)<br />&nbsp;</li>

      <li><b>org.djunits.unitsystem</b> defines the different unit systems such as SI [meter, kilogram, second, mol, Ampere, candela, and Kelvin], SI
        Derived [e.g., degree Celcius, Joule, Ohm or kWh], SI Accepted [e.g, minute, hour or kilometer], and Imperial [e.g., degree Fahrenheit, mile, or pound].
        Additionally, some less used unit systems are defined such as AU (Atomic Units), MTS (meter-tonne-second), and CGS (centimeter-gram-second).<br />&nbsp;</li>

      <li><b>org.djunits.value</b> provides the base interfaces for the value implementations. Example interfaces are Relative, Absolute, Scalar, and
        MathFunctions that each are used to ensure implementations of methods in the scalar, vector, and matrix subpackages.<br />&nbsp;</li>

      <li><b>org.djunits.value.formatter</b> provides classes that can help in formatting unitized values. <br />&nbsp;</li>

      <li><b>org.djunits.value.vdouble</b> contains the interface and implementation of the double precision math functions, such as cbrt, log10, exp1m,
        etc., as well as an interface that defines multiplication and division of double precision values.<br />&nbsp;</li>

      <li><b>org.djunits.value.vdouble.scalar</b> provides two types of classes for double precision implementations. The first one is the generic
        DoubleScalar that can be instantiated with any unit in absolute or relative form through generalization: <br /> <pre>DoubleScalar.Rel&lt;NoiseUnit&gt; noise = <b>new</b> DoubleScalar.Rel&lt;&gt;(10.0, NoiseUnit.DECIBEL);</pre>
          The second class of scalars are the predefined scalars such as Area, Temperature, Duration, and Length. A number of these scalars have both an absolute
          and a relative implementation. Time/Duration, Position/Length, AbsoluteTemperature/Temperature, and Direction/Angle have both an absolute and a 
          relative form. All other scalars are always relative. Each class has a multitude of mathematical operations
          that can be applied on the scalar, such as goniometric functions, logarithms, power functions, etc. Furthermore, many multiplications and divisions
          are implemented in a strongly typed way that is checked by the compiler. If an ElectricalPotential scalar (e.g. in Volts) is divided by an
          ElectricalCurrent scalar (e.g. in Amperes), the result can only be assigned to a scalar thas has an ElectricalResistance unit (e.g., in Ohms). Please
          note that the scalars are stored as a public double precision value internally with the name <i>si</i>, and are always in a base unit (SI if
          possible). In addition, the unit in which the scalar was created is stored (not necessarily the SI unit). In total the scalar consists therefore of
          the standard fields of an Object plus 64 bits for the si double and 64 bits of the pointer to its unit.<br />&nbsp;</li>
      <li><b>org.djunits.value.vdouble.vector</b> contains Dense and Sparse implementations of vectors. In addition, the vectors can be absolute or
        relative, depending on the unit that is used. For now, only the generic DoubleVector is supported, which can be instantiated with any unit. An example
        is:<br /> <pre>
TemperatureUnit tempUnit = TemperatureUnit.KELVIN;
double[] value = new double[]{273.15, 290.4, 280.5, 279.1};
DoubleVector.Abs&lt;AbsoluteTemperatureUnit&gt; dv 
  = new DoubleVector.Abs&lt;&gt;(value, tempUnit, StorageType.DENSE);
			</pre>Note that the vector is just defined as an absolute vector, independent of its (dense) implementation.<br />&nbsp; </li>

      <li><b>org.djunits.value.vdouble.matrix</b> contains Dense and Sparse implementations of matrices. The way to use the matrices is very much like the
        examples above for vectors. Matrices and vectors can be added, subtracted, multiplied, and divided. All standard functions such as LU-decomposition,
        calculation of the determinant, etc. are available as well.<br />&nbsp;</li>

      <li><b>org.djunits.value.vfloat.scalar</b> provides two types of classes for float implementations. The first one is the generic FloatScalar that can
        be instantiated with any unit in absolute or relative form through generalization: <br /> <pre>FloatScalar.Rel&lt;NoiseUnit&gt; noise = <b>new</b> FloatScalar.Rel&lt;&gt;(10.0f, NoiseUnit.DECIBEL);</pre>
          The second class of scalars are the predefined scalars such as Area, Temperature, Duration, and Length. A number of these scalars have both an absolute
          and a relative implementation, indicated by adding '.Rel' or '.Abs' after the class name. Time/Duration, Position/Length, AbsoluteTemperature/Temperature, 
          and Direction/Angle have both an absolute and a relative form. All other scalars are always relative. Each class has a multitude of mathematical operations
          that can be applied on the scalar, such as goniometric functions, logarithms, power functions, etc. Furthermore, many multiplications and divisions
          are implemented in a strongly typed way that is checked by the compiler. If an ElectricalPotential scalar (e.g. in Volts) is divided by an
          ElectricalCurrent scalar (e.g. in Amperes), the result can only be allocated to an ElectricalResistance unit (e.g., in Ohms). Please note that the
          scalars are stored as a public float value internally with the name <i>si</i>, and are always in a base unit (SI if possible). In addition, the unit
          in which the scalar was created is stored (not necessarily the SI unit). In total the scalar consists therefore of the standard fields of an Object
          plus 32 bits for the si float and 64 bits of the pointer to its unit.<br />&nbsp;</li>

      <li><b>org.djunits.value.vfloat.vector</b> contains Dense and Sparse implementations of vectors. In addition, the vectors can be absolute or
        relative, depending on the unit that is used. For now, only the generic DoubleVector is supported, which can be instantiated with any unit. An example
        is:<br /> <pre>
float[] value = new float[]{10.0f, 0.0f, 10.0f, 0.0f, 0.0f, 20.0f, 0.0f};
FloatVector.Rel&lt;AreaUnit&gt; dv 
  = new FloatVector.Rel&lt;&gt;(value, AreaUnit.SQUARE_KM, StorageType.SPARSE);
FloatVector.Rel&lt;AreaUnit&gt; dv2 = dv.exp();
			</pre>Note that the vector is just defined as a relative vector, independent of its (sparse) implementation.<br />&nbsp; </li>

      <li><b>org.djunits.value.vfloat.matrix</b> contains Dense and Sparse implementations of matrices. The way to use the matrices is very much like the
        examples above for vectors. Matrices and vectors can be added, subtracted, multiplied, and divided. All standard functions such as LU-decomposition,
        calculation of the determinant, etc. are available as well.<br />&nbsp;</li>
    </ul>

  </div>

  <!-- ======== Footer ======== -->
  <?php include ('./footer.php'); ?>

</body>
</html>
