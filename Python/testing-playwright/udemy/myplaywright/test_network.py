from playwright.sync_api import Page, expect

empty_order_history_response = {"data":[],"message":"No Orders"}

def intercept_response(route):
    """
    Handler function to change the intercepted API call responses.
    """
    
    route.fulfill(
        json = empty_order_history_response
    )

def test_intercept_api_responses(page: Page, get_user_credentials):
    page.goto("https://rahulshettyacademy.com/client/")

    # Set up a listener for API calls with the URL
    page.route("https://rahulshettyacademy.com/api/ecom/order/get-orders-for-customer/*", intercept_response)

    # Login
    page.locator("#userEmail").fill(get_user_credentials["email"])
    page.locator("#userPassword").fill(get_user_credentials["password"])
    page.get_by_role("button", name = "Login").click()

    # Check order history
    page.get_by_role("button", name = "ORDERS").click()

    expect(page.get_by_text("You have No Orders")).to_be_visible()