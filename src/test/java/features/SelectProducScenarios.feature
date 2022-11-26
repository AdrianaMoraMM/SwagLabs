@test
Feature: Product scenarios

  Scenario Outline: Add to cart products on Products page
    Given The products list "<title>"
    When I looking for the product listed with title "<products>"
    When I click in the "<products>"
    Then I add the product in the cart
    Then I back to  the list "<title>"
    Examples:
      | title      | products |
      | PRODUCTOS  | Camisa Sauce Labs Bolt |
      | PRODUCTOS  |Chamarra Sauce Labs|


