#Author: rew@ti8m.ch
@web @CMB-206 @CMB-470 @CMB-467 @CMB-469 @CMB-466 @sprint1
Feature: todo

  Background:
    Given is the "Web" Banking App


  Scenario Outline: Main Navigation is available
    Given is the startpage
    And <language> is selected 
    Then the <element> is shown

    Examples:
      | element | language |
      |  Icon X   |  Deutsch  |
      |  Submenü |  Deutsch  |
      |  Hoover   |  Deutsch  |
      |  Stickiness |  Deutsch  |
      |  Mehrsprachigkeit   |  Deutsch  |


  Scenario: Breadcrump is available in German
    Given is the startpage
    And "German" is selected
    Then the "Breadcrump" is shown


  Scenario: Breadcrump is available in English
    Given is the startpage
    And "English" is selected
    Then the "Breadcrump" is shown


  Scenario: Meta Navigation is available
    Given is the startpage
    And "German" is selected
    Then the "Suche" is shown
    Then the "Icon X" is shown
    Then the "Logout Button" is shown
