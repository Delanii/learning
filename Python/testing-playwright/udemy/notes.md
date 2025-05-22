# General

- testing sites:

  + https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/
  + https://ultimateqa.com/dummy-automation-websites/
  + https://reqres.in/

# Pytest

- pytest recognizes test functions that have the `test` prefix or postfix in their name. So, a function `test_function` or `function_test` will be recognized as test function
- pytest fixtures provide a reusable code. For example, to set up the environment for each test.
- to use a fixture in a test, provide the fixture name as an argument to the `test` function.
- fixtures have scope:

  - function(default): applies only to the test function and runs for each function
  - module: runs once for the module file
  - class: runs once within the code of the class
  - session: runs once for all of the tests

- to see all pytest output (including `print` statements in test), you have to run `pytest -s` in terminal or use the "debug testing" in Vs code
- it's possible to run individual files with `pytest -s test_rest_of_the_filename.py`, or even individual functions like `pytest -s test_rest_of_the_filename.py::function_name`
- to define fixtures common for a folder, put them in a `conftest.py` file
- fixtures can return values. The returned value is available to the calling function under the identifier with the name of the fixture 
- `yield` keyword is used to introduce async to the tests. `yield` pauses the execution until the rest of the tests finishes
- skipping tests is done with an anotation `@pytest.mark.skip`
- you can tag tests with the anotation `@pytest.mark.tag_name` and then run only tagged tests with `pytest -m tag_name`

# Playwright

- playwright has automatic waiting mechanism, so there shouldn't be a need to manually manage async code
- playwright provides a global `playwright` fixture, which contains methods to interact with browser engines; for example, `playwright.chromium.launch()` starts the chromium browser
- by default, playwright runs browesers in headless mode (no browser window)
- frequently, it's good to create new context with the `new_context()` method. In the new context, you have a clear cookies store, which is good for, for example, user login testing. This is similar to starting a new incognito window in Chrome.
- from the context, you create a new `Page` objects, which have methods to visit a URL
- playwright has a `page` fixture, which creates a new chromium browser in the headless mode and with a single context. 
- it is possible to enforce the headed mode on the CLI with the `--headed` option (for example: `pytest -s --headed`)
- playwright automatically awaits and retries during wait times. For example, it automatically awaits until page reloads after clicking a button or until a component appears. Full reference for supported waiting events: https://playwright.dev/docs/actionability
- playwright awaitable assertions are used with the `expect` keyword together with an assertion method, like `expect(locator).to_be_visible()`. `locator` compatibility is in the same reference as above(not all locators support all assertion methods)

## Locators

- locators allow you to find objects on web pages through their attributes. For example:

  - `page.get_by_label("Label text")` gets you the object (for example, text box), that is connected to the label. The object has to be wrapped in the `<label>` tag though; or, the label has to refer in it's `for` attribute the `id` of the object zou want to locate. For example:

  ```html
  <label for=username>Username</label>
  <input type="text" id="username">
  ```

  - `page.get_by_role("button")` gets the object based on its type. There is a list of options available, like `button` or `checkbox`
  - `page.locator("CSS selector")` gets the object based on its CSS selector. This is universal option, but requires writing a little bit of CSS ...

- locators always return all objects on the page that match the locator criteria. To get a specific element, you need to use selection or filtering.