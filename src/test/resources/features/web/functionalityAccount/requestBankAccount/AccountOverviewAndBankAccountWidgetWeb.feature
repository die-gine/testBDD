#Author: rew@ti8m.ch
@web @CMB-16 @sprint1
Feature: todo

  Background:
    Given is the "Web" Banking App


  @markusMonitor
  Scenario Outline: Go to personal Account Overview via main navigation
    Given is the logged in user <user>
    Given is the startpage
    And <language> is selected
    When I click on <btn>
    Then I am on <page> page

  Examples:
  | user | language | btn | page |
  |  Markus Monitor   |  Deutsch  |  Kontoübersicht   |  Kontoübersicht   |
  |  Markus Monitor   |  English  |  Account Overview  |  Account Overview  |

  @test1 @markusMonitor
  Scenario: Login as existing customer with several bank accounts
    Given is the logged in user "Markus Monitor"
    Given is the startpage
    And "Deutsch" is selected
    Then I see "7" bank account tiles
    Then I see the "Neue Konto eröffnen" tile
    Then the tiles are orderd by "ältestes Konto"

  @evaMonitor
  Scenario: Login as existing customer without bank account
    Given is the logged in user "Eva Monitor"
    Given is the startpage
    And "Deutsch" is selected
    Then I see "0" bank account tiles
    Then I see the "Neue Konto eröffnen" tile

  @markusMonitor
  Scenario: Navigate from Account Overview to detail page of specific bank account
    Given is the logged in user "Markus Monitor"
    Given is the startpage
    And "Deutsch" is selected
    When I click on "Girokonto"
    Then I am on "Konto Detail" page