<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>DJUNITS - Delft Java UNIT System - Vectors and Matrices</title>
<meta name="Author" content="Peter Knoppers, p.knoppers@tudelft.nl" />
<meta name="Author" content="Alexander Verbraeck, a.verbraeck@tudelft.nl" />
<meta name="Description" content="Delft Java Unit System" />
<meta name="Copyright" content="Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved." />
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
  bodyStart ("vector_classes");
  ?>

    <h2>Class diagram for the Scalar classes</h2>
    <p>The below class diagram shows the relationships between the main classes that make up the DoubleScalars. Several examples of implemented 
	  classes and their relations are shown.</p>
    <br /> <img src="abs-rel-dimless.png" alt="DoubleScalar class diagram" /> <br />

    <h2>Class diagram for the Vector classes</h2>
    <p>The below class diagram shows the relationships between the main classes that make up the DoubleVector. As an example, the relationships of the
      relative AreaVector and MutableAreaVector are shown.</p>
    <br /> <img src="DoubleVector.png" alt="DoubleVector class diagram" /> <br />

    <h2>Class diagram for the Matrix classes</h2>
    <p>The below class diagram shows the relationships between the main classes that make up the DoubleMatrix. As an example, the relationships of the
      absolute and relative TimeMatrix and MutableTimeMatrix are shown.</p>
    <br /> <img src="DoubleMatrix.png" alt="DoubleMatrix class diagram" /> <br /> <br />
  </div>

  <!-- ======== Footer ======== -->
  <?php include ('./footer.php'); ?>

</body>
</html>
