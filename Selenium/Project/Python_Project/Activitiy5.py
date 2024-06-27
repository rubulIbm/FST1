from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website
    driver.get('https://alchemy.hguy.co/jobs/')
    
    # Find the navigation bar and select the menu item that says “Jobs”
    jobs_link = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.LINK_TEXT, "Jobs"))
    )
    jobs_link.click()
    
    # Read the page title and verify that you are on the correct page
    WebDriverWait(driver, 10).until(EC.title_contains("Jobs"))
    assert "Jobs" in driver.title, "Not on the Jobs page"
    print("Navigated to the Jobs page successfully.")

finally:
    # Close the browser
    driver.quit()
