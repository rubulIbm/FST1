from selenium import webdriver

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website
    driver.get('https://alchemy.hguy.co/jobs/')
    
    # Get the second heading on the page
    second_heading = driver.find_element("xpath","//h2").text
    
    # Verify the second heading
    assert second_heading == "Quia quis non", "Second heading does not match"
    print("Second heading verification successful.")

finally:
    # Close the browser
    driver.quit()