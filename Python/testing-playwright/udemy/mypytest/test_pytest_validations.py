import pytest

# Fixtures -- reusable code to setup the environment for each test
@pytest.fixture
def my_prepare():
    print("This can be reused anywhere")

def test_initial_check(my_prepare):
    print("First test")