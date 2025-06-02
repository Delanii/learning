from playwright.sync_api import Playwright, expect

from page_objects.login import LoginPage
from utils.api_base import APIUtils 

import pytest
import json

# Load test data
with open("./data/credentials.json", 'r') as credentials_data:
    credentials_loaded = json.load(credentials_data)
    user_credentials_list = credentials_loaded["user_credentials"]

@pytest.mark.parametrize("user_credentials", user_credentials_list)
def test_e2e_frameworked(playwright: Playwright, setup_browser_instance, user_credentials):

    """
    Scenario:

    1. Create order with the API.
    2. Login in to the shop.
    3. Check the order history if the order is recorded in the history.
    """

    # Create order
    api_utils = APIUtils()
    base_url = "https://rahulshettyacademy.com/api/"
    order_id = api_utils.create_order(playwright, base_url, user_credentials)

    # Log in
    login_page = LoginPage(setup_browser_instance)
    login_page.navigate()
    dashboard_page = login_page.login(user_credentials)

    # Check if the order is in the order history in the UI
    order_history_page = dashboard_page.view_order_history()
    order_detail_page = order_history_page.view_order(order_id)
    order_detail_page.check_order_successful()