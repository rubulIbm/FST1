# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains


# Initialize the WebDriver
driver = webdriver.Chrome()
try:

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/input-events")

    # Print the title of the page
    print("Page title is: ", driver.title)
    actions = ActionChains(driver)


    # Perform a LEFT CLICK action
    actions.click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after left click: ", active_side.text)
    
    # Perform a DOUBLE CLICK action
    actions.double_click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after double click: ", active_side.text)

    # Perform a RIGHT CLICK action
    actions.context_click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after right click: ", active_side.text)
finally:
    # Close the browser
    driver.quit()        
