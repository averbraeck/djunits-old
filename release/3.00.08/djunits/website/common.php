<?php
function highlightItem ($text, $condition, $link)
{
        echo "        <li";
        if ($condition)
        {
                echo " class=\"highlight\"";
        }
        echo "><a href=\"$link\">$text</a></li>\n";
}
function bodyStart ($pageName)
{
        echo "  <!-- ======== Header ======== -->\n";
        echo "\n";
        echo "  <table width=\"100%\" cellpadding=\"0\">\n";
        echo "    <tr style=\"line-height:1px; height:60px\">\n";
        echo "      <td style=\"background-color: #0094FE\">\n";
        echo "        <p style=\"font-color:BLACK; font-size:30px\"> <b>&nbsp;DJUNITS - Delft Java UNIT System version 3.00 &nbsp;</b>\n";
        echo "        </p>\n";
        echo "      </td>\n";
        echo "    </tr>\n";
        echo "  </table>\n";
        echo "\n";
        echo "  <!-- ======== Left Sidebar ======== -->\n";
        echo "\n";
        echo "  <div id=\"sidebar\">\n";
        echo "    <div>\n";
        echo "      <p class=\"title\">\n";
        echo "        <a href=\"index.php\">DJUNITS</a>\n";
        echo "      </p>\n";
        echo "      <ul>\n";
        highlightItem("Overview", "index" == $pageName, "index.php");
        highlightItem("Source code", "source" == $pageName, "source.php");
        highlightItem("Maven use", "maven" == $pageName, "maven.php");
        highlightItem("Building a unit", "building_unit" == $pageName, "building_unit.php");
        highlightItem("Building a scalar", "building_scalar" == $pageName, "building_scalar.php");
        highlightItem("Vectors and matrices", "vectors_matrices" == $pageName, "vectors_matrices.php");
        highlightItem("Class diagrams", "vector_classes" == $pageName, "vector_classes.php");
        echo "         <br>\n";
        echo "         <li><i><a href=\"https://djunits.org/docs/current/index.html\" target=\"_blank\">Documentation</a></i></li>\n";
        echo "         <li><i><a href=\"https://djunits.org/docs/current/apidocs/index.html\" target=\"_blank\">JavaDocs</a></i></li>\n";
        echo "      </ul>\n";
        echo "    </div>\n";
        echo "  </div>\n";
        echo "\n";
        echo "  <!-- ======== Main Content ======== -->\n";
        echo "\n";
        echo "  <div id=\"main\">\n";
        echo "\n";
}
?>
