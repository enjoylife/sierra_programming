<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="music">
  <html>
  <body>
  <h1 style="color:green;">Music Collection</h1>
 
  <xsl:for-each select="/music/cd">
  	 <hr/>
  	<pre><xsl:value-of select="@upc"/>       <xsl:value-of select="@genre"/></pre>
  	
  <h2 style="color:blue;"><xsl:value-of select="title"/></h2>
  <p><xsl:value-of select="artist"/></p>
  <p><xsl:value-of select="publishingInfo/label"/></p>
  <p><xsl:value-of select="publishingInfo/year"/></p>
  <p><xsl:value-of select="songInfo/numberOfSongs"/></p>
  <ul>
  <xsl:for-each select="songInfo/song">
  <li style="font-style:italic;"><xsl:value-of select="songTitle"/></li>
  </xsl:for-each>
  </ul>
  
  </xsl:for-each>
  
  
  </body>
  </html>
</xsl:template>

</xsl:stylesheet> 
