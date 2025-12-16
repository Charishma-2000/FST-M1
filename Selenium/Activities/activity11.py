from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    
    wait = WebDriverWait(driver, timeout=20)
    
    driver.get("https://training-support.net/webelements/dynamic-controls")
   
    print(" Title is: ", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")
    print("Is checkbox visible? ", checkbox.is_displayed())

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    
    wait.until(EC.invisibility_of_element(checkbox))
    
    print("Is checkbox visible? ", checkbox.is_displayed())

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    wait.until(EC.element_to_be_clickable(checkbox)).click()
   
    print("Is checkbox Selected? ", checkbox.is_selected())