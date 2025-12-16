from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
   
   driver.get("https://training-support.net/webelements/tables")
   
   print("Page title is: ", driver.title)

   rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
   print("Number of rows: ",len(rows))

   cols = driver.find_elements(By.XPATH, "//table/thead/tr/th")
   print("Number of cols: ",len(cols))

   rows3 = driver.find_elements(By.XPATH, "//table/tbody/tr[3]")
   for row3 in rows3:
      print("3rd rows of the table: ",row3.text)
    
   cellValue = driver.find_element(By.XPATH, "//table/tbody/tr[2]/td[2]")
   print("2nd rows & 2nd cols of the table: ", cellValue.text)

driver.quit()