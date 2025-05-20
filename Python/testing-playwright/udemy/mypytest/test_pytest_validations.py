import pytest

# Fixtures -- reusable code to setup the environment for each test
@pytest.fixture(scope = "module")
def my_prepare():
    print("This can be reused anywhere")
    return "pass"

@pytest.fixture(scope = "function")
def my_bad():
    print("Failing fixture.")
    return "fail"

@pytest.fixture(scope = "module")
def teardown():
    print("Final step.")
    yield # Pause the execution
    print("Closes all contexts and connections.")

def test_initial_check(my_prepare):
    print("First test")
    assert my_prepare == "pass"

def test_followup(my_prepare, my_bad):
    print("First test")
    assert my_prepare == "pass"
    # assert my_bad == "pass"