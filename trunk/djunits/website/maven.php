<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>DJUNITS - Delft Java UNIT System - Maven use</title>
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
  bodyStart ("maven");
  ?>

    <h2>Maven use</h2>
    <p>
      Maven is one of the easiest ways to include DJUNITS in a Java project. The Maven files for DJUNITS reside at <a href="https://djunits.org/maven">https://djunits.org/maven</a>.
      When a POM-file is created for the project, the following snippet needs to be included to include DJUNITS:
    </p>

    <pre class="highlight">
&lt;dependencies&gt;
  &lt;dependency&gt;
    &lt;groupId&gt;org.djunits&lt;/groupId&gt;
    &lt;artifactId&gt;djunits&lt;/artifactId&gt;
    &lt;version&gt;3.01.00&lt;/version&gt;
  &lt;/dependency&gt;
&lt;/dependencies&gt;
</pre>

    <p>Of course, the version number (3.01.07 in the above example) needs to be replaced with the version that one wants to include in the project.</p>
    <p>Right now, the DJUNITS files are kept on a server at TU Delft, and are not yet made available on Maven Central. Therefore, the repository location
      has to be specified separately in the Maven POM-file:</p>

    <pre class="highlight">
&lt;repositories&gt;
  &lt;repository&gt;
    &lt;name&gt;djunits Public Repository&lt;/name&gt;
    &lt;id&gt;djunits&lt;/id&gt;
    &lt;url&gt;https://djunits.org/maven&lt;/url&gt;
  &lt;/repository&gt;
&lt;/repositories&gt;
</pre>

    <h2>Dependencies</h2>
    <p>DJUNITS is directly dependent on two packages, which have no further dependencies:</p>
    <ul>
      <li><b>ojalgo</b> for vector and matrix calculations. ojAlgo has no further dependencies.</li>
      <li><b>joda-money</b> for the money units. Joda-money has no further dependencies.</li>
    </ul>
    <p>If the DJUNITS library is used as a part of a Maven project, all dependencies will be automatically resolved, and the programmer / user does not have
      to worry about finding the libraries.</p>

  </div>

  <!-- ======== Footer ======== -->
  <?php include ('./footer.php'); ?>

</body>
</html>
