#Author: rew@ti8m.ch
@web @CMB-206 @CMB-470 @CMB-467 @CMB-469 @CMB-466 @CMB-690 @sprint5
Feature: Dashboard Navigation
  Der Benutzer kann mit Hilfe der Navigation alle relevanten Bereiche des Mobile Banking intuitiv erreichen und dies auf allen Kanälen.
  Das Chrome unterscheidet folgende Bereiche:
  Hauptmenü, Suchfeld, Service Navigation, Content Area, Footer.

  secarios for
  - Check elements of main navigation
  - Check multilingualism of main navigation
  - Check breadcrump availability
  - Check meta navigation

  Background:
    Given is the "Web" Banking
    Given is the "Dashboard Web"

  Scenario Outline: Main Navigation is available on desktop
    When I click <_elements_>
    Then the header <_header_> is shown

    Examples:
      | _elements_ | _header_ |
      |  "Dashboard"   |  "Dashboard" |
      |  "Vermögen"   |  "Vermögen im Überblick" |

  Scenario Outline: Main Navigation is available in English on desktop
    And <_language_> is selected
    Then the <_element_G> icon is displayed as <_element_E>

    Examples:
      | _element_G | _element_E | _language_ |
      |  "Dashboard"   |  "Dashboard" |  "English"  |
      |  "Vermögen"   |  "Fortune" |  "English"  |

  Scenario Outline: Breadcump is available on desktop
    When I click <_element_>
    Then the breadcrump contains: <_elements_>

    Examples:
      | _element_ | _elements_ |
      |  "Dashboard"   |  "Dashboard" |
      |  "Vermögen"   |  "Dashboard, Vermögen im Überblick" |


  Scenario Outline: Meta Navigation is available on desktop dashboard
    Then the <_elements_> are shown in Meta Navigation
    And the <_elements_> are clickable
    Examples:
      | _elements_ |
      |  "Account"   |
