<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/clients">
        <table border="1">
            <tr><td>ID</td><td>Name</td><td>Passport</td><td>Login</td><td>Password</td>
                <td>Account_1 Balance/Currency/Status</td>
                <td>Account_2 Balance/Currency/Status</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/clients/client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/clients/client/client_ID">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/passport">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/accounts/account">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>