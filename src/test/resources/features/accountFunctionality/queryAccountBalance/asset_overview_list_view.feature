#Author: rew@ti8m.ch
@web @CMB-313 @sprint2
Feature: Assets overview: List view web
  todo

  Test cases for
  - todo

  Background:
    Given is the "Web" Banking
    Given is the "Dashboard Web"
    When I click "Vermögen"

  Scenario: Main page elements on asset overview are available in desktop app
    Given
    When
    Then

  Scenario: Go to detail page and check current balance in desktop app
    Given
    When
    Then

  Scenario Outline: Switch account overview between tile and list view
    And I select <_icon_before_>
    And I select <_icon_after_>
    Then the content is shown as <_view_after_>
    Then the content is not shown as <_view_before_>
    Examples:
      |_icon_before_|_icon_after_|_view_after_|_view_before_|
      |"Button Listenansicht"|"Button Kachelansicht"|"Kachelansicht"|"Listenansicht"|
      |"Button Kachelansicht"|"Button Listenansicht" |"Listenansicht"|"Kachelansicht"|