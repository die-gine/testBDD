#Author: rew@ti8m.ch
@mobile @CMB-206
Feature: todo

  Background:
    Given is the "Mobile" Banking App

  @CMB-406 @android
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

  @CMB-406 @iphone
  Scenario Outline: Main Navigation is available for mobile
    Given is the startpage for <device>
    And <language> is selected
    Then the <element> is shown

    Examples:
      | device | element | language |
      | iphone|  Icon X   |  Deutsch  |
      | iphone|  Submenü |  Deutsch  |
      | iphone |  Hoover   |  Deutsch  |
      | iphone |  Stickiness |  Deutsch  |
      | iphone |  Mehrsprachigkeit   |  Deutsch  |

  @CMB-470 @CMB-467
  Scenario: Breadcrump is available for mobile
    Given is the startpage
    Then the "Breadcrump" is shown


  @CMB-466 @CMB-469
  Scenario: Meta Navigation is available for mobile
    Given is the startpage
    And "German" is selected
    When I switch to "tablet" resolution
    Then the "Icon X" is shown
