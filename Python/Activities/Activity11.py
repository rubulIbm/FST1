fruit_shop={
    "apple":10,
    "banana":20,
    "orange":8,
    "peaches":15
}

key_to_work=input("what are you looking for: ").lower()
if(key_to_work in fruit_shop):
    print(f"yes {key_to_work} is available in friut shop")
else:
    print(f"yes {key_to_work} is not available in friut shop")   