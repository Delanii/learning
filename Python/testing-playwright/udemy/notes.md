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
- it is possible to run a group of tests based on their name: `pytest -k e2e` runs only tests that contain "e2e" in their name (in the name of the test function)
- running tests in parallel is done with the `pytest-xdist` package and with the command `pytest -n number`, where `number` is the number of workers for testing
- to generate HTML test reports, install the `pytest-html` package and add the `--html=file_name.html` cmdline option
- test tracing is available from pytest directly:

  - `pytest --tracing on`: store tracing for all tests
  - `off`: default
  - `retain_on_failure`: store tracing for failed tests only

- out the contents of the `test_results` folder in the link `trace.playwright.dev`

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
- alert pop-ups are javascript events, and they are not in DOM: They are handled with event listener `page.on`. The listener can listen for multiple events. One of them is the `dialog` event, so `page.on("dialog", function)`. The second argument is a function that is called when the event happens.

## Locators

- locators allow you to find objects on web pages through their attributes. For example:

  - `page.get_by_label("Label text")` gets you the object (for example, text box), that is connected to the label. The object has to be wrapped in the `<label>` tag though; or, the label has to refer in it's `for` attribute the `id` of the object zou want to locate. For example:

  ```html
  <label for=username>Username</label>
  <input type="text" id="username">
  ```

  - `page.get_by_role("button")` gets the object based on its type. There is a list of options available, like `button` or `checkbox`
  - `page.locator("CSS selector")` gets the object based on its CSS selector. This is universal option, but requires writing a little bit of CSS ...

- locators always return all objects on the page that match the locator criteria. To get a specific element, you need to use selection or filtering
- there is no option to filter locators based on exact text directly, the only direct option checks if the locator contains the text. To get exact matching, you either need to use a regex or nest another locator in the filter, like: `page.locator("th").filter(has = page.get_by_text("Price", exact = True))`

## Codegen

```sh
playwright codegen https://project-base-url
```

opens two browsers:

- internet browser (chrome)
- playwright inspector, which records your actions in the browser as playwright code

## API testing

- uses the `playwright` fixture the same as UI testing; but a specific member of the fixture: `playwright.request`
- the API context is set up with the `playwright.request.new_context()` method. One of the main features is defining the `base_url`.
- the `request` member has methods connected with the HTTP methods: `post`, `get`, ...

## Mocking API calls and responses

### Mocking API responses

- intercept the API response and change it before the response reaches the client browser. With that, you can mock different application states which might be hard to reach otherwise.
- the actual interception is set up with a listener `page.route(url, handler, times)`:

  + `url`: the API call URL. Accepts wildcards, so `https://dest/orders/*` intercepts all orders
  + `handler`: is a function that is triggerred when playwright registers the `url`. The function has to accept the `route` meta argument that refers to the `url`, like `def myfunction(route): pass`
  + `times`: how many times should the interception happen. 

### Mocking API calls

- API call mocking is done with the same `page.route` listener as in the previos section

## Using cookies

- after login, the login token is stored in the browser's local storage
- until the token expires, it is loaded again to the browser local storage when you return to the page
- `page.add_init_script` is used to add JS to run before opening the page
- interaction with the browser local storage is with:

```js
localStorage.setItem('key', 'value')
```

# Best practices

- avoid hardcoding test data in test cases
- put test data in separate (data) files to create isolation between test data and test logic
- use the "page object model" desing pattern to separate page locators from page actions
- put reusable code in dedicated files like utility scripts or the `confetest.py` file
- create global environment variables to set up the test environment
- use grouping and tags to run targeted tests
- generate test reposts
- capture logs and screenshots for failed test cases
- add CI/CD (for example with Jenkins)

# Test parametrization

- test parametrization goes further than just adding parameters to a test function. Test parametrization sets up the test in a way that it's running multiple times with different data. For example, in finance, you might want to test an active user, inactive user, a user with a business account, and similar
- parametrization is set up with the `@pytest.mark.parametrize(identifier, iterable_data)` annotation
- in addition, you need a fixture `identifier`, which returns that actual items from the `iterable_data`
- the fixture is provided to the test as an argument:

```py
@pytest.fixture(scope = "session")
def user_credentials(request):
    return request.param

@pytest.mark.parametrize("user_credentials", user_credentials_list)
def test_my_test(user_credentials):
    assert user_credentials
```

- `request` is a global fixture that contains the test parameters and command-line arguments used to run the test

# Page object model design

- the idea behind the page object model design is to separate page actions and navigation to a dedicated class instead of keeping it in the test logic
- each page that the tests visit should have it's own page class

# Set up the test environment through global variables

- the variables defined on CLI when running the tests are available in the `request.config.getoption("key_name")`, where `key_name` is the key provided on the cmdline, so `pytest --key_name value` gets the `value`
- it's also necessary to add the cmdline option to the pytest parser, so it stores the key-value pair:

```python conftest.py
def pytest_addoption(parser):
    parser.addoption(
        "--browser_name", action = "store", default = "chromium", help = "Select the browser to run the tests."
    )
```

# BDD

- = behavior driven development
- the test is described in a plain language as a scenario. The steps of the scenario are linked with the actual code.
- BDD definition forms a sort of a contract, where the test implementation has to reference all entries (steps) in the scenario
- the test execution sequence is defined in the feature file -- each `given`, `when`, `then` line is linked with a function and the linked functions run in the sequence defined by the order of descriptions in the feature file
- BDD functionality is available through the `pytest-bdd` package

## Cucumber BDD

- `Feature`: references the whole suite of tests in the related test file
- `Scenario`: is a descrption of a specific test
- `Given`: discloses all prerequisites or all steps before validating the test
- `When`: defines the action that is being evaluated/checked with the test
- `Then`: describes the state which means the test success
- `And`: adds items to `Given`, `When` or `Then`, basically concatenating them
- `Scenario Outline`: allows you to put in placeholders like <number>, where you later on define an example value for the number like:

```
Examples:
| number  |
| 6       |
```
- to get the placeholder values into the test from the feature file:

  1. Update the BDD description in the decorator as: `Then This is starting to get <ridiculous>` => `Then This is starting to get {ridiculous}` to get the `ridiculous` value available in the test.
  2. The parameters have to be a part of the implementing function signature.
  3. The parameters are available in the function body.

- the feature file is linked with the test implementation through the `@given`, `@when` and `@then` decorators, like `@when("This seems like a bit of a nonsense)`, which have to match _literally_ with the descriptions in the feature file
- each decorator has to be assigned to one method, so you have to develop the test structure with the methods dictated by the feature file

# Jenkins CI/CD 

- running: `jenkins --httpPort=portNumber`, then, the Jenkins dashboard is available on localhost:portNumber
- it's possible to run tests on the local device -- "General" -> "Advanced" -> "Use custom workspace" and input the absolute folder path of the test suite in the text field
- in build steps, it's possible to just run shell in the folder selected previously -- add the "Execute shell" step and write the shell command there (`pytest -s --html=report.html`)
- to parametrize the shell command, go to "General", select "This project is parametrized", then select the parameter type, name, available values and fill in the parameter description. The parameter can be referenced in the shell build step like: `pytest -s --browser_name="$browser" --html=report.html` (double-quoted environment variable)
- scheduling is set up in the "Triggers" section. The "Build periodically" option accepts schedule specification as a crontab entry
- to trigger manually, click "Build now". When you click on the running build, you can inspect the console in the "Console output"

# Interview Q&A

## Difference between a list and a tuple

- lists are mutable
- individual list items can have different types

## Python built-in data types

- string
- char
- integer
- float
- buffer
- list
- tuple
- dictionary
- boolean

## Inheritance in Python

```python
class Parent:
  def greet(self):
    print("Hello from parent.")

class Child(Parent): # just add `Parent` as an argument to the `Child` class
  def hi(self):
    print(super().greet() + "Hi from child.")

c = Child()
c.hi()
c.greet()
```

## What is `__init__` in Python

- class constructor
- defines the initial state of an object of the class

## Open or write file

```python
with open("file/path", 'w') as file: # (there's `a` for appending to a file or `r` for reading from a file, `w` overwrites)
file.write("content") # reading is with `f.read()`
```

## What are fixtures

- Covered at the top of the notes

## How to use `yield` for setup teardown

```python
import pytest

@pytest.fixture
def sample_data():
	print("\nCreating test data")
	data = {"name" = "John", "age" = 30}
	yield data
	print("Cleaning up test environment")
	
def test_my_test(sample_data):
	assert sample_data["age"] == 30
	print("Test OK")
```

Order of execution:

1. Pytest starts running the test. Since the test has a fixture as an argument, pytest switches to running the fixture first.
2. Fixture runs up until the keyword `yield`. `yield` returns the data and hands over the execution to the test function.
3. Test runs.
4. After the test finishes, pytest switches to running the rest of the fixture, which can be used for the script teardown.

## How to work with list of dictionaries?

```python
data = [{"name" = "John", "age" = 30},
		{"name" = "Pete", "age" = 35}]
pete = data[1]["name"]
```

## What is `lambda` and how it's used with the `map` and `filter` functions

- `lambda` is to define anonymous functions
- `map()` applies the function to each item in the list, `filter()` applies a boolean function to each item in the list; if the function's result is `True`, the item stays, otherwise it's removed

```python
numbers = [1, 2, 3, 4, 5]
new_list = list(map(lambda x: x * 2, numbers)) # `map()` returns the `Map` object
another_list = list(filter(lambda x: x > 3, numbers))
```

## Is Python sync or async?

Python execution is synchronous by default. Asynchronous code is provided by the `asyncio` library.

```python
import asyncio

async def mytask(name):
	print(f"My name is {name}.")
	await asyncio.sleep(2)
	print(f"I specified this name: {name}.")
	
async def main():
	await asyncio.gather(
	  mytask("myself"),
	  mytask("other"))

asyncio.run(main())
```

## What is `self`

`self` refers to the current instance of the class/current object of the class.

## Reverse list

```python
mylist = [1, 2, 5, 6]
reversed = mylist[::-1]
```

## What is the difference between `@classmethod` and instance method

- `@classmethod` is the same as a static method in Java -- it doesn't need an instance of the class for calling

```python
class MyClass:

	@classmethod
	def class_method(cls):
		return "classmethod"

	def instance_method(self):
		return "instance"
		
obj = MyClass()
print(obj.instance_method())
print(MyClass.class_method())
```

## How to rerun only failed tests

```
pytest --last-failed
```

## How handle exceptions in Python

- `try`/`except` blocks to gracefuly handle errors or issues
- the `finally` block always runs, regardless of errors

```python
try:
	with open("nonexistent.txt", 'r') as missing:
		data = missing.read()
		print(data)
except FileNotFoundError as not_found:
	print(not_found)
finally:
	print("Always printed.")
```