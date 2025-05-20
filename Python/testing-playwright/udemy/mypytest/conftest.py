import pytest

@pytest.fixture(scope = "session")
def my_ready():
    print("This is from conftest.py")
