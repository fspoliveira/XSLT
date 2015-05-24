<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<catalogo>
			<CdPt>
				<xsl:for-each select="/catalog/CdEn/cdItem">
					<cdItem>
						<titulo>
							<xsl:value-of select="title" />
						</titulo>
						<artista>
							<xsl:value-of select="artist" />
						</artista>
						<pais>
							<xsl:value-of select="country" />
						</pais>
						<compania>
							<xsl:value-of select="company" />
						</compania>
						<preco>
							<xsl:value-of select="price" />
						</preco>
						<ano>
							<xsl:value-of select="year" />
						</ano>
					</cdItem>
				</xsl:for-each>
			</CdPt>
		</catalogo>
	</xsl:template>
</xsl:stylesheet>