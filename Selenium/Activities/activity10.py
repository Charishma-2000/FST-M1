from selenium import webdriver
from selenium.webdriver import Keys, ActionChains
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
 
    actions = ActionChains(driver)
  
    driver.get("https://training-support.net/webelements/drag-drop")

    print("Page title is: ", driver.title)

    ball = driver.find_element(By.ID, "ball")
    print("found the ball!!")
    dz1 = driver.find_element(By.ID, "dropzone1")
    dz2 = driver.find_element(By.ID, "dropzone2")

    actions.click_and_hold(ball).drag_and_drop(dz1,ball).perform()
    message = driver.find_element(By.CSS_SELECTOR, "span.dropzone-text").text
    print(message)

    actions.click_and_hold(ball).drag_and_drop(dz2,dz2).perform()
    print("Verifying that the ball has entered Dropzone 2: ")
    message = driver.find_element(By.CSS_SELECTOR, "span.dropzone-text").text
    print(message)
