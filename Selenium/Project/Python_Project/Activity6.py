from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Initialize the WebDriver
driver = webdriver.Chrome()

try:
    # Open browser with Alchemy Jobs site and navigate to the Jobs page
    driver.get('https://alchemy.hguy.co/jobs/jobs/')
    
    # Search for a particular job
    search_job = driver.find_element(By.ID,"search_keywords")
    search_job.send_keys("Automation Engineer")  # You can change this to the job you want to search for
    search_job.submit()
    
    # Wait for listings to show
    WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CLASS_NAME, "job_listing")))
    
    # Click and open any one of the jobs listed
    job_link = driver.find_element("xpath","//ul[@class='job_listings']")
    job_link.click()
    
    # Click the apply button
    apply_button = driver.find_element(By.CSS_SELECTOR,".application_button")
    apply_button.click()
    
    # Print the email to the console
    email = driver.find_element(By.CSS_SELECTOR,".job_application_email").text
    print("Job application email:", email)

finally:
    # Close the browser
    driver.quit()
