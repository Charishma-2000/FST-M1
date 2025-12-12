from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
  
  driver.get("https://training-support.net/webelements/login-form")
  
  print("Title is: ", driver.title)

  element1 = driver.find_element(By.ID, "username")
  element1.send_keys("admin")

  element2 = driver.find_element(By.ID, "password")
  element2.send_keys("password")
  
  element3 = driver.find_element(By.XPATH, "//button[text()='Submit']")
  element3.click()

  print("Closing the browser")

  driver.quit()