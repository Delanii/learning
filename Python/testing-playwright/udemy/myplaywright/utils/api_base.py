from playwright.sync_api import Playwright

new_order_payload = {"orders":[{"country":"India","productOrderedId":"67a8dde5c0d3e6622a297cc8"}]}

class APIUtils:

    def get_login_token(self, playwright: Playwright, base_url, user_credentials):

        api_request_context = playwright.request.new_context(base_url = base_url)
        response = api_request_context.post(
            "ecom/auth/login",
            data = {
                "userEmail": user_credentials["email"],
                "userPassword": user_credentials["password"]
            }
        )

        # Check if the login was a success
        assert response.ok
        return response.json()["token"]

    def create_order(self, playwright: Playwright, base_url, user_credentials):

        api_request_context = playwright.request.new_context(base_url = base_url)
        response = api_request_context.post(
            "ecom/order/create-order",
            headers = {"Authorization": self.get_login_token(playwright,
                                                             base_url,
                                                             user_credentials),
                        "Content-Type": "application/json"},
            data = new_order_payload
            )

        assert response.ok
        order_id = response.json()["orders"][0]
        return order_id