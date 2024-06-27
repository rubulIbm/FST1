from selenium import webdriver

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website
    driver.get('https://alchemy.hguy.co/jobs/')
    
    # Get the title of the website
    title = driver.title
    
    # Verify the title
    assert title == "Alchemy Jobs – Job Board Application", "Website title does not match"
    print("Website title verification successful.")

finally:
    # Close the browser
    driver.quit()