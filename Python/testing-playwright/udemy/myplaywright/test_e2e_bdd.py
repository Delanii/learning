from playwright.sync_api import Playwright, expect
from pytest_bdd import given, when, then, parsers, scenarios

from page_objects.login import LoginPage
from utils.api_base import APIUtils 

import pytest

# This is the dumbest idea I've seen in a training course.
# Introduce shared object (dictionary) for data.
@pytest.fixture
def bdd_shared_data():
    return {}

scenarios("features/shopping.feature")

@given(parsers.parse("Create an order with user {name} and {password} with the API."))
def create_order_bdd(playwright, name, password, bdd_shared_data):

    user_credentials = {
        "email": name,
        "password": password
    }

    api_utils = APIUtils()
    base_url = "https://rahulshettyacademy.com/api/"

    order_id = api_utils.create_order(playwright, base_url, user_credentials)
    bdd_shared_data["order_id"] = order_id

@given("Navigate to the landing page.")
def get_to_the_login_page(setup_browser_instance, bdd_shared_data):
    login_page = LoginPage(setup_browser_instance)
    login_page.navigate()
    bdd_shared_data["login_page"] = login_page

@when(parsers.parse("A user logs in with the user {name} and {password}"))
def login(name, password, bdd_shared_data):

    user_credentials = {
        "email": name,
        "password": password
    }

    login_page = bdd_shared_data["login_page"]
    dashboard_page = login_page.login(user_credentials)
    bdd_shared_data["dashboard_page"] = dashboard_page

@when("gets to the order history page")
def go_to_order_history(bdd_shared_data):
    dashboard_page = bdd_shared_data["dashboard_page"]
    order_history_page = dashboard_page.view_order_history()
    bdd_shared_data["order_history_page"] = order_history_page

@when("opens the order detail.")
def open_order_detail(bdd_shared_data):
    order_history_page = bdd_shared_data["order_history_page"]
    order_detail_page = order_history_page.view_order(bdd_shared_data["order_id"])
    bdd_shared_data["order_detail_page"] = order_detail_page

@then("Order confirmation is visible on the page.")
def check_order_confirmation(bdd_shared_data):
    bdd_shared_data["order_detail_page"].check_order_successful()
