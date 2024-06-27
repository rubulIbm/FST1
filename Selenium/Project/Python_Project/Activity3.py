from selenium import webdriver

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website
    driver.get('https://alchemy.hguy.co/jobs/')
    
    # Get the url of the header image
    header_image_url = driver.find_element("xpath","//img[@class='attachment-large size-large wp-post-image']").get_attribute('src')
    
    # Print the url to the console
    print("Header image URL:", header_image_url)

finally:
    # Close the browser
    driver.quit()
