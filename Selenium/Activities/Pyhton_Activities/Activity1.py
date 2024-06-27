# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


# Initialize the WebDriver
driver = webdriver.Chrome()
 
try:
    # Navigate to the website
    driver.get("https://v1.training-support.net/")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the "About Us" button on the page using ID and click it
    driver.find_element(By.ID, "about-link").click()

    # Print the title of the new page
    print("New page title is: ", driver.title)

finally:
    # Close the browser
    driver.quit()