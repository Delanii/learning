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
            assert email == "mentor@rahulshettyacademy.com"

def test_more_ui_checks(page: Page):
    page.goto("https://rahulshettyacademy.com/AutomationPractice/")

    # Check if the testing edit box is visible
    expect(page.get_by_placeholder("Hide/Show Example")).to_be_visible()

    # Click the "Hide" button
    page.locator("#hide-textbox").click()

    # Check if the testing edit box is hidden
    expect(page.get_by_placeholder("Hide/Show Example")).to_be_hidden()

def test_alert(page: Page):
    page.goto("https://rahulshettyacademy.com/AutomationPractice/")
    
    page.on("dialog", lambda dialog: dialog.accept())
    page.locator("#confirmbtn").click()

def test_iframe(page: Page):
    page.goto("https://rahulshettyacademy.com/AutomationPractice/")

    iframe = page.frame_locator("#courses-iframe")
    iframe.get_by_role("link", name = "All Access plan").click()
    expect(iframe.locator("body")).to_contain_text("Happy Subscibers") # Yes, there is a typo on the page ...

def test_tables(page: Page):
    page.goto("https://rahulshettyacademy.com/seleniumPractise/#/offers")

    headers = page.locator("th")
    price_col_index = 0

    for index in range(headers.count()):
        if page.locator("th").nth(index).filter(has = page.get_by_text("Price", exact = True)).count() > 0:
            price_col_index = index

    # print(price_col_index)

    rice_row = page.locator("tr").filter(has = page.get_by_text("Rice", exact = True))
    expect(rice_row.locator("td").nth(price_col_index)).to_have_text("37")

def test_hover(page: Page):
    page.goto("https://rahulshettyacademy.com/AutomationPractice/")

    page.locator("#mousehover").hover()
    page.get_by_role("link", name = "Top").click()