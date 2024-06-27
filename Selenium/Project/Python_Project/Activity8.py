from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website's backend login page
    driver.get('https://alchemy.hguy.co/jobs/wp-admin/')
    
    # Find the username field of the login form and enter the username
    username_field = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "user_login"))
    )
    username_field.send_keys("root")  # Enter the username
    
    # Find the password field of the login form and enter the password
    password_field = driver.find_element(By.ID,"user_pass")
    password_field.send_keys("pa$$w0rd")  # Enter the password
    
    # Find the login button and click it
    login_button = driver.find_element(By.ID,"wp-submit")
    login_button.click()
    
    # Verify that you have logged in
    WebDriverWait(driver, 10).until(EC.title_contains("Dashboard"))
    assert "Dashboard" in driver.title, "Login failed"
    print("Logged in successfully.")

finally:
    # Close the browser
    driver.quit()
