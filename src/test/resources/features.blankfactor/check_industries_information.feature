Feature: Check sections and subsections under information

  @DesktopTest
  Scenario: Validating Industries sections
    Given David choose a header section
      | section    |
      | INDUSTRIES |
    And he selects a subsection
      | subsection |
      | RETIREMENT |
    When he wants to read the section "AI"
    And he wants to start the page
    Then he should be see right URL and Title's page
      | url                              | title                  |
      | https://blankfactor.com/contact/ | Contact \| Blankfactor |
