<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/users">
        <table border="1">
            <tr><td>Name</td><td>NickName</td><td>Phone</td><td>Address</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>