# Set up the Firefox Driver with WebDriverManger
# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait 
from selenium.webdriver.support import expected_conditions as EC


# Initialize the WebDriver
driver = webdriver.Chrome()
try:
    # Navigate to URL
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    # Initialize wait object
    wait = WebDriverWait(driver, 10)

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the checkbox div
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    # Find the checkbox toggle button
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")

    # Click the checkbox_toggle button to hide checkbox
    checkbox_toggle.click()
    print("Checkbox hidden")
    # Wait till the checkbox diappears
    
    wait.until(EC.invisibility_of_element_located(checkbox))
    # Click the toggle button again
    checkbox_toggle.click()
    print("Checkbox visible")
    # Click the checkbox
    checkbox.click()
    print("Checkbox selected")


finally:
# Close the browser
    driver.quit()       
