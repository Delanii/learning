from playwright.sync_api import Page, expect

class OrderDetailPage:

    def __init__(self, page: Page):
        self.page = page

    def check_order_successful(self):
        expect(self.page.get_by_text("Thank you for Shopping With Us")).to_be_visible()