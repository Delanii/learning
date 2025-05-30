from playwright.sync_api import Page

from .order_history import OrderHistoryPage

class DashboardPage:

    def __init__(self, page: Page):
        self.page = page

    def view_order_history(self):
        self.page.get_by_role("button", name = "ORDERS").click()
        return OrderHistoryPage(self.page)