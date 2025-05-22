from playwright.sync_api import Page, expect

# Add Iphone X and Nokia Edge in the cart and check if 2 items are showing in the cart
def test_ui_validation_first(page: Page):

    # Login
    page.goto("https://rahulshettyacademy.com/loginpagePractise")
    page.get_by_label("Username:").fill("rahulshettyacademy")
    page.get_by_label("Password:").fill("learning")
    page.get_by_role("combobox").select_option("stud")
    page.locator("#terms").check()
    page.get_by_role("button", name = "Sign In").click()

    products = ["iphone X", "Nokia Edge"]
    for product in products:

        # Get the custom card element
        phone = page.locator("app-card").filter(has_text = product)
        # order phone
        phone.get_by_role("button").click()

    # Enter checkout
    page.get_by_text("Checkout ( " + str(len(products)) + " )").click()

    # There should be 2 products in the cart
    expect(page.locator(".media-body")).to_have_count(len(products))

    # Each product should be in the cart as well
    for product in products:
        expect(page.locator(".media-body").filter(has_text = product)).to_be_visible()