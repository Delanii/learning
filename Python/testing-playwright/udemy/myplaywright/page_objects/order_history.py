from playwright.sync_api import Page

from .order_detail import OrderDetailPage

class OrderHistoryPage:

    def __init__(self, page: Page):
        self.page = page

    def view_order(self, order_id):
        order_row = self.page.locator("tr").filter(has = self.page.get_by_text(order_id))
        order_row.get_by_role("button", name = "View").click()
        return OrderDetailPage(self.page)