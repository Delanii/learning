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

def test_child_window(page: Page):
    page.goto("https://rahulshettyacademy.com/loginpagePractise")

    # Waiting for popups or new tabs is done with closures
    # `page.expect_popup()` is a event listener -- it waits until a specific event happens (popup window). When the event triggers (a new page pops up), the event result is stored in `newtab`.
    with page.expect_popup() as newtab:
        page.locator(".blinkingText").filter(has_text = "Free").click()
        child_page = newtab.value # Store the page created from clicking at the link in a new `page` object
        content = child_page.locator(".red").text_content()

        if content is not None:
            email = [word for word in content.split(" ") if "@" in word][0]
            domain = email.split("@")[1]
            print(domain)