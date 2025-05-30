import pytest

@pytest.fixture(scope = "session")
def get_user_credentials():
    return {"email": "rumbatumpa@gmail.com", "password": "MySecretPass#1"}
    # other user creds: {"email": "tumpadum@gmail.com", "password": "MySecretPass1#"}

@pytest.fixture(scope = "session")
def user_credentials(request):
    return request.param