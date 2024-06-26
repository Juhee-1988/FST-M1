fruit_shop={
    "apple":240,
    "orange":80,
    "banana":100,
    "grapes":120
}

fruit_name=input("Which fruit are you looking for? ").lower()
if fruit_name in fruit_shop:
    print("Yes, this is available")
else:
    print("No, this is not available")