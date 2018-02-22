#Author: rew@ti8m.ch
@mobile @CMB-473 @CMB-690 @sprint2
Feature: Mobile App Navigation
  todo

  Test cases for
  - todo

  Background:
    Given is the "Mobile App" Banking

  Scenario Outline: Main Navigation in mobile app is available
    Given is the "Dashboard Mobile"
    When I click <_elements_> in app
    Then the header <_header_> is shown

    Examples:
      | _elements_ | _header_ |
      |  "Dashboard"   |  "Dashboard" |
      |  "Vermögen"   |  "Vermögen im Überblick" |

  Scenario Outline: Main Navigation in mobile app is available in English
    Given is the "Dashboard Web"
    And <_language_> is selected
    Then the <_element_G> icon is displayed as <_element_E>

    Examples:
      | _element_G | _element_E | _language_ |
      |  "Dashboard"   |  "Dashboard" |  "English"  |
      |  "Vermögen"   |  "Fortune" |  "English"  |


  Scenario Outline: Meta Navigation in mobile app is available
    Given is the "Dashboard Web"
    Then the <_elements_> are shown in Meta Navigation
    And the <_elements_> are clickable
    Examples:
      | _elements_ |
      |  "Account"   |
