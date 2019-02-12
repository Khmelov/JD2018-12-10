<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/users">
        <table border="1">
            <tr><td>Name</td><td>Email</td><td>Password</td><td>Bets</td></tr>
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
        <td>
            <table border="1">
                <tr><td>Kind of Bet</td><td>Race</td><td>Total Horses</td><td>Horse</td>
                    <td>Odds</td><td>Bet Amount</td><td>Payout</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/description">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/race">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/totalHorses">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/horse">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/odds">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/betAmount">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bets/bet/payout">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>