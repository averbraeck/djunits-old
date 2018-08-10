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
  bodyStart ("vectors_matrices");
  ?>

    <h2>Introduction</h2>
    <p>
      Vectors and Matrices are implemented in eight different ways: Sparse or Dense data storage, Mutable or Immutable, and Double or Float, 
	  which gives eight combinations. Sparse storage is used when the vectors or matrices contain a lot of zeroes. Dense data storage would,
	  in that case, store all the zeroes, whereas in a sparse storage only the numbers unequal to zero are stored, together with an index.
	  As the index provides some overhead, sparse storage makes only sense when the number of zeroes is over 50% of the number of cells.
	  A second differentiation is Mutable versus Immutable. Normally, vectors and matrixes are immutable, just like the scalars. When, however, 
	  calculations on large matrices or vectors take place, results of those calculations always have to be stored in a new vector or matrix.
	  When the vector or matrix is mutable, however, the result can be stored in the vector or matrix itself. Suppose that we want to round
	  the data in a 1000x1000 matrix to the nearest integer value. With a mutable data type, this works as follows:
    </p>
	
    <pre class="highlight">
double[][] data = new double[1000][1000];
for (int i=0; i&lt;1000; i++) { for (int j=0; j&lt;1000; j++) {data[i][j] = 9*i + 2*j * 0.364; }}
LengthMatrix lengthMatrix = new LengthMatrix(data, LengthUnit.CENTIMETER, StorageType.DENSE);
LengthMatrix.mutable().round();
	</pre>

	<p>
	  Mutable vectors and matrices can be turned into immutable ones and vice versa. 
	</p>
	
	<p>
	  Note: One of the advantages is that operations on vectors and matrices take place in parallel when the vector or matrix is sufficiently large.
	</p>




  </div>

  <!-- ======== Footer ======== -->

  <div id="footer">
    <hr />
    Copyright &copy; 2015-2017, Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br /> DJUNITS uses a BSD-style
    license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
  </div>

</body>
</html>
