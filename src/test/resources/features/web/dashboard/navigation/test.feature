#Author: rew@ti8m.ch
@browserstacktest
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