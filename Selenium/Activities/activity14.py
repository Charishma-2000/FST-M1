from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
   
   driver.get("https://training-support.net/webelements/tables")
   
   print("Page title is: ", driver.title)
   rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
   print("Number of rows: ",len(rows))

   cols = driver.find_elements(By.XPATH, "//table/thead/tr/th")
   print("Number of cols: ",len(cols))
    
   row5 = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
   print("Book Name in the 5th row is: ", row5.text)

   driver.find_element(By.XPATH, "//th[text()='Price']").click()

   print("Clicked on header of the Price column")

   row5 = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
   print("Book Name in the 5th row is: ", row5.text)


driver.quit()
