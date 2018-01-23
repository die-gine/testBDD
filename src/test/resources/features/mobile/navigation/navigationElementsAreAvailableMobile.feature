#Author: rew@ti8m.ch
@mobile @CMB-206
Feature: todo

  Background:
    Given is the "Mobile" Banking App

  @CMB-406
  Scenario Outline: Main Navigation is available for mobile
    Given is the startpage for <device>
    And <language> is selected 
    Then the <element> is shown

    Examples:
      | device | element | language |
      | android|  Icon X   |  Deutsch  |
      | android|  Submenü |  Deutsch  |
      | android |  Hoover   |  Deutsch  |
      | android |  Stickiness |  Deutsch  |
      | android |  Mehrsprachigkeit   |  Deutsch  |

  @CMB-470
  Scenario: Breadcrump is available in German for mobile
    Given is the startpage
    And "German" is selected
    Then the "Breadcrump" is shown

  @CMB-467
  Scenario: Breadcrump is available in English  for mobile
    Given is the startpage
    And "English" is selected
    Then the "Breadcrump" is shown

  @CMB-469
  Scenario: Meta Navigation is available  for mobile
    Given is the startpage
    And "German" is selected
    Then the "Suche" is shown
    Then the "Icon X" is shown
    Then the "Logout Button" is shown

  @CMB-466
  Scenario: Meta Navigation is available  for mobile
    Given is the startpage
    And "German" is selected
    When I switch to "tablet" resolution
    Then the "Icon X" is shown
