from playwright.sync_api import Page, Route, expect, Playwright
import time
from utils.api_base import APIUtils 

order_details_url = "https://rahulshettyacademy.com/api/ecom/order/get-orders-details"
empty_order_history_response = {"data":[],"message":"No Orders"}

def intercept_response(route: Route):
    """
    Handler function to change the intercepted API call responses.
    """
    
    route.fulfill(
        json = empty_order_history_response
    )

def intercept_request(route: Route):
    """
    Handler function to change the intercepted API calls.
    """

    other_user_order_id = "6839599d81a206953052c452"
    route.continue_(url = order_details_url + "?id=" + other_user_order_id)

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

def test_mock_api_call(page: Page, get_user_credentials):
    page.goto("https://rahulshettyacademy.com/client/")

    # Set up a listener for API calls with the URL
    page.route(order_details_url + "?id=*", intercept_request)

    # Login
    page.locator("#userEmail").fill(get_user_credentials["email"])
    page.locator("#userPassword").fill(get_user_credentials["password"])
    page.get_by_role("button", name = "Login").click()

    # Go to order history
    page.get_by_role("button", name = "ORDERS").click()
    # Trigger the order ID listener
    # It doesn't matter which order we choose becase the call is intercepted to attempt to view a different user's order
    page.get_by_role("button", name = "View").first.click()
    # time.sleep(60) # debug
    expect(page.get_by_text("not authorize")).to_be_visible()

def test_session_storage(playwright: Playwright, page: Page, get_user_credentials):
    api_utils = APIUtils()
    user_token = api_utils.get_login_token(playwright, "https://rahulshettyacademy.com/api/", get_user_credentials)
    browser = playwright.chromium.launch()
    context = browser.new_context()
    page = context.new_page()

    # Add the `user_token` to the browser local storage
    page.add_init_script(f"""
        localStorage.setItem('token', '{user_token}')
    """)

    page.goto("https://rahulshettyacademy.com/client/")

    # Go to order history
    page.get_by_role("button", name = "ORDERS").click()
    expect(page.get_by_text("Your Orders")).to_be_visible()