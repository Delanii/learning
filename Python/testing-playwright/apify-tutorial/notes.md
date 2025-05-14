# Playwright tutorial notes

- source: https://blog.apify.com/python-playwright/

```sh
playwright codegen test_url
```

- opens up the browser window and records your actions in the window. This generates a script you can use for testing
- playwright supports only Ubuntu and Debian. Arch-based distributions have to use the AUR package: https://aur.archlinux.org/packages/python-playwright-git
- the key part of testing (or crawling/scraping) with playwright are **locators** and **selectors**

## Selectors

- CSS selectors
- XPath
- plain text

## Locators

