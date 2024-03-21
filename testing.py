import requests
import base64

url = 'http://localhost:8080/api/products/add'

# Read the image file and encode it to base64
with open('hello.jpeg', 'rb') as f:
    image_data = f.read()
    base64_encoded_image = base64.b64encode(image_data).decode('utf-8')

# Limit the size of the image data to avoid truncation
# For example, you can take only the first 10000 characters of the base64 encoded image
limited_base64_encoded_image = base64_encoded_image[:10000]

data = {
    "id": 127,
    "name": "seed 2",
    "company": "10.0",
    "var": [
        {
            "product": {
                "id": 127 # Set the whole Product object here
            },
            "variantId": 4,
            "variant": "Variant 1",
            "quantity": 200,
            "price": 100.0,
            "discount": 15.89
        }
    ],
    "image": limited_base64_encoded_image,
    "content": "Some content about the product",
    "features": ["feature5", "feature8", "feature3"],
    "productUsage": "How to use the product",
    "crops": "Crops where the product can be used",
    "timeOfApplication": "Time of application",
    "dosage": "Dosage information"
}


response = requests.post(url, json=data)

print(response.status_code)
print(response.text)