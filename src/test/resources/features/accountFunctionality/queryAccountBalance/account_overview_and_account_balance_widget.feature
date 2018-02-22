#Author: rew@ti8m.ch
@web @CMB-312 @sprint5
Feature: Account/Asset overview and account balance widget
  Auswahl und Darstellung der Kontenübersicht auf dem Desktop durch Navigation über das Dashboard. Auf der Kontoübersicht
  wird pro Konto ein Widget angezeigt

  Szenen:
  - Standardelemente der Vermögensübersicht (Filtern nach, Kachel- und Listenübersicht)sind vorhanden und klickbar
  - Neuer Account Kachel ist vorhanden
  - Alle erwarteten Elemente (Name, Titel, Währung, Betrag) werden in der Kachel angezeigt
  - Wechsel auf die Detail-Seite einer Kachel und check identische Elemente

  Background:
    Given is the "Web" Banking
    Given is the "Dashboard Web"
    When I click "Vermögen"

  Scenario Outline: Main button on asset overview are available in desktop app
    Then the <_icon_> is clickable
    Examples:
      | _icon_ |
      |"Filtern nach"|
      |"Button Listenansicht"|
      |"Button Kachelansicht"|

  Scenario: Create new account widget is available in desktop app
    Then the widget "Neues Konto eröffnen" is diplayed

  Scenario Outline: Account widget contains all elements in desktop app
    Then I see account widget with <name_>, <title_>, <currency_> and <balance_>
    Examples:
      | name_ | title_ |  currency_ |  balance_|
      |  "Markus Moniter"   | "CURRENT" | "EUR"   |  "156791,15" |
      |  "Eva Moniter"   | "CURRENT" | "USD"   |  "7964,91" |

  Scenario Outline: Go to detail page and check current balance in desktop app
    When I click <name_>
    Then the account detail page <title_> is shown
    And I see account detail with <h2>, <currency_> and <balance_>
    Examples:
      | name_ | title_ |  h2 | currency_ |  balance_|
      |  "Markus Moniter"   | "CURRENT" |"Kontobewegungen"| "EUR"   |  "156791,15" |
      |  "Eva Moniter"   |  "CURRENT" |"Kontobewegungen"| "USD"   |  "7964,91" |

