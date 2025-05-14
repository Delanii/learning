import asyncio
from playwright.async_api import Playwright, async_playwright

async def run(playwright: Playwright, *, url: str) -> dict:
    """This function navigates to a given URL using a browser and returns 
    the page's URL and title."""

    # Launch the Chromium browser in non-headless mode (visible UI), to see 
    # the browser in action.
    browser = await playwright.chromium.launch(headless=False)

    # Open a new browser page.
    page = await browser.new_page(viewport={'width': 1600, 'height': 900})

    # Short sleep to be able to see the browser in action.
    await asyncio.sleep(1)

    # Navigate to the specified URL.
    await page.goto(url)

    await asyncio.sleep(1)

    # Retrieve the title of the page.
    title = await page.title()

    # Close the browser.
    await browser.close()

    # Return the page's URL and title as a dictionary.
    return {'url': url, 'title': title}

async def main() -> None:
    # Use async_playwright context manager to close the Playwright instance
    # automatically.
    async with async_playwright() as playwright:
        result = await run(playwright, url='https://crawlee.dev')
        print(result)

if __name__ == '__main__':
    asyncio.run(main())
