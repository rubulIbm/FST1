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
    username_field = WebDriverWait(driver, 50).until(
        EC.presence_of_element_located((By.ID, "user_login"))
    )
    username_field.send_keys("root")  # Enter the username
    
    # Find the password field of the login form and enter the password
    password_field = driver.find_element(By.ID,"user_pass")
    password_field.send_keys("pa$$w0rd")  # Enter the password
    
    # Find the login button and click it
    login_button = driver.find_element(By.ID,"wp-submit")
    login_button.click()
    
    # Navigate to "Job Listings" in the left-hand menu
    job_listings_menu = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//div[contains(@class, 'wp-menu-name') and text()='Job Listings']"))
    )
    job_listings_menu.click()
    
    # Click the "Add New" button
    add_new_button = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.CLASS_NAME, "page-title-action"))
    )
    add_new_button.click()
    
    # Fill in the necessary details
    title_field = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "job_title"))
    )
    title_field.send_keys("Backend Test Job")
    
    description_field = driver.find_element(By.ID,"job_description_ifr")
    driver.switch_to.frame(description_field)
    description_body = driver.find_element("xpath","//body[@id='tinymce']")
    description_body.send_keys("This is a backend test job description.")
    driver.switch_to.default_content()
    
    # Click the "Publish" button
    publish_button = driver.find_element(By.ID,"publish")
    publish_button.click()
    
    # Verify that the job listing was created
    WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, "message")))
    assert "Job listing created" in driver.page_source, "Job listing creation failed"
    print("Job listing created successfully.")

finally:
    # Close the browser
    driver.quit()
