#Author: rew@ti8m.ch
@web @CMB-206 @CMB-470 @CMB-467 @CMB-469 @CMB-466 @sprint1
Feature: todo
  Test cases for
  - Check elements of main navigation
  - Check multilingualism of main navigation
  - Check breadcrump availability
  - Check meta navigation

  Background:
    Given is the "Web" Banking

  Scenario Outline: Main Navigation is available
    Given is the "Dashboard Web"
    When I click <_elements_>
    Then the header <_header_> is shown

    Examples:
      | _elements_ | _header_ |
      |  "Vermögen"   |  "Vermögen im Überblick" |

  Scenario Outline: Main Navigation is available in English
    Given is the "Dashboard Web"
    And <_language_> is selected
    Then the <_element_G> icon is displayed as <_element_E>

    Examples:
      | _element_G | _element_E | _language_ |
      |  "Dashboard"   |  "Dashboard" |  "English"  |
      |  "Vermögen"   |  "Fortune" |  "English"  |

  Scenario Outline: Breadcump is available
    Given is the "Dashboard Web"
    When I click <_element_>
    Then the breadcrump contains: <_elements_>

    Examples:
      | _element_ | _elements_ |
      |  "Dashboard"   |  "Dashboard" |
      |  "Vermögen"   |  "Dashboard, Vermögensübersicht" |


  Scenario Outline: Meta Navigation on dashboard is available
    Given is the "Dashboard Web"
    Then the <_elements_> are shown in Meta Navigation
    And the <_elements> are clickable
    Examples:
      | _elements_ |
      |  "Account"   |