import asyncio
import json
from contextlib import suppress
from urllib.parse import parse_qs, urlparse

from playwright.async_api import Page, Playwright, Response, async_playwright

async def scroll_to_bottom(page: Page) -> None:
    # Get the initial scroll height
    last_height = await page.evaluate('document.body.scrollHeight')
    i = 1

    while True:
        print(f'Scrolling page ({i})...')

        # Scroll to the bottom of the page.
        await page.evaluate('window.scrollTo(0, document.body.scrollHeight);')

        # Wait for the page to load.
        await asyncio.sleep(1)

        # Calculate the new scroll height and compare it with the last scroll height.
        new_height = await page.evaluate('document.body.scrollHeight')
        if new_height == last_height:
            break  # Exit the loop when the bottom of the page is reached.

        last_height = new_height
        i += 1

async def maybe_extract_data(response: Response) -> None:
    parsed_url = urlparse(response.url)
    query_params = parse_qs(parsed_url.query)

    # Check if 'queryid=products' is in the URL
    if 'queryid' in query_params and query_params['queryid'][0] == 'products':
        data = await response.json()
        print('JSON data found in: ', response.url)

        extracted_info = []
        with suppress(KeyError):
            for product in data['data']['products']['products']:
                product_info = {
                    'colorDescription': product['colorDescription'],
                    'currency': product['price']['currency'],
                    'currentPrice': product['price']['currentPrice'],
                    'fullPrice': product['price']['fullPrice'],
                    'inStock': product['inStock'],
                    'title': product['title'],
                    'subtitle': product['subtitle'],
                    'url': product['url'].replace('{countryLang}', '<https://www.nike.com/en>'),
                }
                print(f'Extracted product: {product_info}')
                extracted_info.append(product_info)

        # Define the file name where data will be stored
        file_name = 'extracted_data.json'

        # Open a file in write mode (will create the file if it doesn't exist)
        # and dump the data into it in JSON format.
        with open(file_name, 'w') as file:
            json.dump(extracted_info, file, indent=4)

async def scrape_nike_shoes(playwright: Playwright, url: str) -> None:
    # Launch the Chromium browser in non-headless mode (visible UI), to see 
    # the browser in action.
    browser = await playwright.chromium.launch(headless=False)

    # Open a new browser page.
    page = await browser.new_page(viewport={'width': 1600, 'height': 900})

    # Use network event to set up a handler for response event to extract 
    # the data.
    page.on(event='response', f=lambda response: maybe_extract_data(response))
    await asyncio.sleep(1)

    # Navigate to the specified URL.
    await page.goto(url)
    await asyncio.sleep(1)

    # Click the "Accept All" button to accept the cookies.
    await page.click('text=Accept All')
    await asyncio.sleep(1)

    # Scroll to the bottom of the page to load all the products.
    await scroll_to_bottom(page)

    # Wait for the popup to be visible to ensure it has loaded on the page.
    await page.wait_for_selector('.bluecoreCloseButton')

    # Click on the close button of the advertisement popup.
    await page.click('.bluecoreCloseButton')
    await asyncio.sleep(1)

    # Close the browser.
    await browser.close()

async def main() -> None:
    async with async_playwright() as playwright:
        await scrape_nike_shoes(
            playwright=playwright,
            url='https://www.nike.com/cz/en/w/mens-shoes-nik1zy7ok',
        )

if __name__ == '__main__':
    asyncio.run(main())
