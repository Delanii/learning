from playwright.sync_api import Playwright, expect
from utils.api_base import APIUtils 
import time 

def test_e2e_web_api(playwright: Playwright, get_user_credentials):

    """
    Scenario:

    1. Create order with the API.
    2. Login in to the shop.
    3. Check the order history if the order is recorded in the history.
    """

    # Create order
    api_utils = APIUtils()
    base_url = "https://rahulshettyacademy.com/api/"
    order_id = api_utils.create_order(playwright, base_url, get_user_credentials)

    # Log in to the shop
    browser = playwright.chromium.launch() # Prod
    # browser = playwright.chromium.launch(headless = False) # Debug
    context = browser.new_context()
    page = context.new_page()
    page.goto("https://rahulshettyacademy.com/client/")
    page.locator("#userEmail").fill(get_user_credentials["email"])
    page.locator("#userPassword").fill(get_user_credentials["password"])
    page.get_by_role("button", name = "Login").click()

    # Check if the order is in the order history in the UI
    page.get_by_role("button", name = "ORDERS").click()

    order_row = page.locator("tr").filter(has = page.get_by_text(order_id))
    order_row.get_by_role("button", name = "View").click()

    expect(page.get_by_text("Thank you for Shopping With Us")).to_be_visible()
    context.close()