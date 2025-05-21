def test_playwright_basics(playwright):

    browser = playwright.chromium.launch(headless = False) # Omit to run in headless mode; store the engine instance in the `browser` object
    context = browser.new_context() # creates a new browser context. FOr example, stores a new set of cookies (avoid previously stored cookies); create a `context` object to store the new browser context
    page = context.new_page()
    page.goto("https://rahulshettyacademy.com")
