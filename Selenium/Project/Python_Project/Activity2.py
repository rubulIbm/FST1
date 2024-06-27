from selenium import webdriver

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website
    driver.get('https://alchemy.hguy.co/jobs/')
    
    # Get the heading of the webpage
    heading = driver.find_element("xpath","//h1[text()='Welcome to Alchemy Jobs']").text
    
    # Verify the heading
    assert heading == "Welcome to Alchemy Jobs", "Website heading does not match"
    print("Website heading verification successful.")

finally:
    # Close the browser
    driver.quit()