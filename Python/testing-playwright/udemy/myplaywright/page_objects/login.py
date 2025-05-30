from playwright.sync_api import Page

from .dashboard import DashboardPage

class LoginPage:

    def __init__(self, page: Page):
        self.page = page

    def navigate(self):
        self.page.goto("https://rahulshettyacademy.com/client/")

    def login(self, user_credentials):
        self.page.locator("#userEmail").fill(user_credentials["email"])
        self.page.locator("#userPassword").fill(user_credentials["password"])
        self.page.get_by_role("button", name = "Login").click()
        return DashboardPage(self.page)