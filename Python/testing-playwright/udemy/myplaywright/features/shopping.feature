Feature: Create order

    Test where you create an order and check if the order is in the history.

    Scenario Outline: Check if a new order is in the order history

        Given Create an order with user <name> and <password> with the API.
        And Navigate to the landing page.

        When A user logs in with the user <name> and <password>
        And gets to the order history page
        And opens the order detail.

        Then Order confirmation is visible on the page.

        Examples:
        | name                 | password       |
        | rumbatumpa@gmail.com | MySecretPass#1 |
        | tumpadum@gmail.com   | MySecretPass1# |