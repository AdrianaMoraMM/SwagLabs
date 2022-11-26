
@test
Feature: Login scenarios

  Scenario Outline: Login without username
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with an error "<error>"
    Examples:
      | username | password | error |
      |  | secret_sauce |Usuario es requerido |

  Scenario Outline: Login without password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with an error "<error>"
    Examples:
      | username | password | error |
      | standard_user |  |Contraseña es requerida |

  Scenario Outline: Login with invalid password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then Login should fail with an error "<err>"
    Examples:
      | username | password | err |
      | standard_user | invalidPassword |  El usuario y contraseña no coinciden con ningun usuario en este servicio. |

  Scenario Outline: Login with valid user name and password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I should see Products page with title "<title>"
    Examples:
      | username | password | title |
      | standard_user | secret_sauce | PRODUCTOS |