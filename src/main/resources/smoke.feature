Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check that user is able to log in and log out to account
    Given User opens '<homePage>' page
    And User checks login button visibility
    And User clicks login button
    And User checks id field visibility
    And User enters valid '<id>' to id field
    And User clicks continue button
    And User checks password field visibility
    And User enters valid '<password>' to password field
    When User clicks submit button
    And User checks '<homePage>' is opened
    And User clicks logout link
    Then User checks login page is opened after the logout
    Examples:
      | homePage                | id                      | password  |
      | https://www.amazon.com/ | konaginata101@gmail.com | qwe123!@# |

  Scenario Outline: Check searching by a keyword returns corresponding items
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    And User clicks on the first matching visible result
    Then User checks that item name contains '<keyword>'
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | sax     |

  Scenario Outline: Check all search results
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    And User checks Alienware checkbox visibility
    And User clicks Alienware checkbox
    And User checks search results visibility
    Then User checks each result contains '<keyword>'
    Examples:
      | homePage                | keyword   |
      | https://www.amazon.com/ | Alienware |

  Scenario Outline: Check adding item to cart
    Given User opens '<homePage>' page
    And User checks for deals button visibility
    And User clicks deals button
    And User checks books filter visibility
    And User clicks on books filter
    When User clicks add to cart on the first result
    And User checks cart widget visibility
    And User clicks cart widget
    Then User checks items quantity in cart
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check multiple items price calculation
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by '<keyword>'
    And User clicks search button
    When User clicks on the first matching visible result
    And User checks add to cart button visibility
    And User clicks add to cart button
    And User navigates to previous page
    And User checks add to cart button visibility
    And User clicks add to cart button
    And User checks cart widget visibility
    And User clicks cart widget
    Then User checks price calculation for two items
    Examples:
      | homePage                | keyword        |
      | https://www.amazon.com/ | Oculus Quest 2 |

  Scenario Outline: Check price limit filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    And User checks price limiter visibility
    And User clicks on price limiter
    Then User checks prices of all search results do not exceed '<limit>'
    Examples:
      | homePage                | keyword      | limit |
      | https://www.amazon.com/ | amazonbasics | 25.00 |

  Scenario Outline: Check the error message on entering invalid zipCode
    Given User opens '<homePage>' page
    And User checks delivery settings button visibility
    And User clicks delivery settings button
    And User checks that location setting popup visibility
    And User checks the header to contain '<text>'
    And User checks zipCode field visibility
    When User enters invalid '<zipCode>'
    And User checks apply zipCode button visibility
    And User clicks apply button
    Then User checks '<message>' is shown
    Examples:
      | homePage                | text                 | zipCode | message                          |
      | https://www.amazon.com/ | Choose your location | &&&&!   | Please enter a valid US zip code |

  Scenario Outline: Check that items are located on corresponding pages
    Given User opens '<homePage>' page
    And User checks Oculus button visibility
    When User clicks Oculus button
    Then User checks page url to contain'<urlText>'
    Examples:
      | homePage                | urlText |
      | https://www.amazon.com/ | oculus  |

  Scenario Outline: Check that products can be ordered with different parameters
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by '<keyword>'
    And User clicks search button
    And User clicks on the first matching visible result
    And User checks that item name contains '<keyword>'
    And User checks parameter switcher visibility
    When User clicks parameter switcher
    Then User checks the '<parameter>' is updated
    Examples:
      | homePage                | keyword        | parameter |
      | https://www.amazon.com/ | oculus quest 2 | 256GB     |

  Scenario Outline: Spell-checking and search advisory
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    And User checks hint visibility
    Then User checks search '<hint>' on result page
    Examples:
      | homePage                | keyword | hint  |
      | https://www.amazon.com/ | appple  | apple |