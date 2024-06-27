from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Navigate to the website
    driver.get('https://alchemy.hguy.co/jobs/')
    
    # Locate the navigation menu and click the menu item that says “Post a Job”
    post_job_link = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.LINK_TEXT, "Post a Job"))
    )
    post_job_link.click()
    
    # Fill in the necessary details
    title = driver.find_element(By.ID,"job_title")
    title.send_keys("Test Job")
    
    description = driver.find_element(By.ID,"job_description_ifr")
    driver.switch_to.frame(description)
    description_body = driver.find_element("xpath","//body[@id='tinymce']")
    description_body.send_keys("This is a test job description.")
    driver.switch_to.default_content()
    
    # Click the button that says “Preview”
    submit_preview = driver.find_element(By.NAME,"continue")
    submit_preview.click()
    
    # Click on the button that says “Submit Listing”
    submit_listing = driver.find_element(By.NAME,"submit_job")
    submit_listing.click()
    
    # Verify that the job listing was posted by visiting the jobs page
    driver.get('https://alchemy.hguy.co/jobs/jobs/')
    WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CLASS_NAME, "job_listing")))
    job_titles = driver.find_elements(By.CSS_SELECTOR,".job_listing .job_listing_title")
    job_titles_text = [job.text for job in job_titles]
    assert "Test Job" in job_titles_text, "Job listing was not posted"
    print("Job listing posted successfully.")

finally:
    # Close the browser
    driver.quit()
