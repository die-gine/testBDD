#Author: rew@ti8m.ch
@web @CMB-484 @sprint3
Feature: Search for Money Accounts
  Suchmaske:
  Ein registrierter und angemeldeter Nutzer kann die Suchmaske durch Eingabe von
  Kontonummer/IBAN
  Inhabername
  Kontobezeichnung/Produktname
  Rubrik
  bedienen. Auf dem dynamischen Search-Overlay wird ein Link "Alle Resultate anzeigen" eingeblendet.
  Mit einem Klick auf diesen Link oder einer Bestätigung der Sucheingabe mit ENTER gelangt der Nutzer auf die Search Result Page.

  Search Result Page:
  Die Search Result "Suchresultate [Search-Term]", Gruppenfilter und Resultatliste
  Für Treffer vom Typ Konto werden folgende Daten angezeigt:

  Spalte1: Kontobezeichnung/Produktname, Rubrik
  Spalte2: Währung, Saldo
  Spalte3:

  test scenarios:
  - Suche über Parameter [siehe oben] in Suchmaske
  - Weiterleitung auf result page
  - Auswertung der Elemente

  Background:
    Given is the "Web" Banking
    Given is logged in user "Markus Moniter"

  Scenario: User inserts entry in search mask and checks dynamic search overlay in desktop app
    Given
    When
    Then

  Scenario: User enters search result page and checks results in desktop app
    Given
    When
    Then
