#Author: rew@ti8m.ch
@sprint5
Feature: TESTRUN ONLY
  Test cases for
  - FOR LOCAL TESTRUNS ONLY

  @testtest
  Scenario Outline: Super Main Navigation is available
    Given is the "Dashboard Web" test
    When I click <_elements_> test
    Then the header <_header_> is shown test

    Examples:
      | _elements_ | _header_ |
      |  "test"   |  "testrun" |


  @testtest
  Scenario Outline: I am a Super Main Navigation
    Given is the "Dashboard Web" test
    When I click <_elements_> test
    Then the header <_header_> is shown test

    Examples:
      | _elements_ | _header_ |
      |  "test"   |  "testrun" |

  @testtest @mobile @iphone @android
  Scenario Outline: I am a Super Main Navigation mobile android and iphone
    Given is the "Dashboard Web" test
    When I click <_elements_> test
    Then the header <_header_> is shown test

    Examples:
      | _elements_ | _header_ |
      |  "test"   |  "testrun" |