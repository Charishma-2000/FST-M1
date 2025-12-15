from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title is: ", driver.title)

    checkbox = driver.find_element(By.ID, "checkbox")
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    print("Is checkbox displayed : ",checkbox.is_displayed())
    
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    print("Is checkbox displayed : ",checkbox.is_displayed())

driver.quit()