from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Page title is: ", driver.title)

    ip = driver.find_element(By.ID, "textInput")
    print("Is text field enabled : ",ip.is_enabled())

    driver.find_element(By.XPATH, "//button[text()='Enable Input']").click()
    print("Is text field enabled : ",ip.is_enabled())

    driver.quit()
