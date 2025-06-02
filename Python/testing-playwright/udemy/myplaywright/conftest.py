import pytest
from playwright.sync_api import Playwright

@pytest.fixture(scope = "session")
def get_user_credentials():
    return {"email": "rumbatumpa@gmail.com", "password": "MySecretPass#1"}
    # other user creds: {"email": "tumpadum@gmail.com", "password": "MySecretPass1#"}

@pytest.fixture(scope = "session")
def user_credentials(request):
    return request.param

def pytest_addoption(parser):
    parser.addoption(
        "--browser_name", action = "store", default = "chromium", help = "Select the browser to run the tests."
    )

@pytest.fixture
def setup_browser_instance(playwright: Playwright, request):
    # Select the browser when the tests should run
    browser_name = request.config.getoption("browser_name")

    if browser_name == "chromium":
        browser = playwright.chromium.launch()
    elif browser_name == "firefox":
        browser = playwright.firefox.launch()

    context = browser.new_context() # type: ignore
    page = context.new_page()
    yield page
    # After yield, the execution goes back to the actual test.
    # After the test finishes, the execution returns back to the code in the fixture after yielding
    context.close()
    browser.close() # type: ignore