from playwright.sync_api import Page, expect, Playwright
import time

def test_playwright_basics(playwright):

    browser = playwright.chromium.launch(headless = False) # Omit to run in headless mode; store the engine instance in the `browser` object
    context = browser.new_context() # creates a new browser context. FOr example, stores a new set of cookies (avoid previously stored cookies); create a `context` object to store the new browser context
    page = context.new_page()
    page.goto("https://rahulshettyacademy.com")

def test_playwright_shortcut(page:Page): # Explicitly use the `page` fixture from the `Page` class
    page.goto("https://example.com")

def test_core_locators(page: Page):
    page.goto("https://rahulshettyacademy.com/loginpagePractise")

    # Select by the page object label
    page.get_by_label("Username:").fill("rahulshettyacademy")
    page.get_by_label("Password:").fill("learning")

    # Select by the object role -- "combobox" is a select box
    page.get_by_role("combobox").select_option("teach")

    # Select with a CSS selector
    page.locator("#terms").check()

    # Select a button and click it
    page.get_by_role("button", name = "Sign In").click()
    time.sleep(5) # to see the result of the automation

def test_invalid_login(page: Page):
    page.goto("https://rahulshettyacademy.com/loginpagePractise")

    # Select by the page object label
    page.get_by_label("Username:").fill("rahulshettyacademy")
    page.get_by_label("Password:").fill("wrongpassword")

    # Select by the object role -- "combobox" is a select box
    page.get_by_role("combobox").select_option("stud")

    # Select with a CSS selector
    page.locator("#terms").check()

    # Select a button and click it
    page.get_by_role("button", name = "Sign In").click()

    # Get the invalid login banner
    expect(page.get_by_text("Incorrect username/password.")).to_be_visible()

def test_in_firefox(playwright: Playwright):

    browser = playwright.firefox.launch(headless = False)
    context = browser.new_context() # can be skipped if we don't need a new context
    page = context.new_page()
    page.goto("https://rahulshettyacademy.com/loginpagePractise")

    # Select by the page object label
    page.get_by_label("Username:").fill("rahulshettyacademy")
    page.get_by_label("Password:").fill("wrongpassword")

    # Select by the object role -- "combobox" is a select box
    page.get_by_role("combobox").select_option("stud")

    # Select with a CSS selector
    page.locator("#terms").check()

    # Select a button and click it
    page.get_by_role("button", name = "Sign In").click()

    # Get the invalid login banner
    expect(page.get_by_text("Incorrect username/password.")).to_be_visible()