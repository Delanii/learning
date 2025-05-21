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