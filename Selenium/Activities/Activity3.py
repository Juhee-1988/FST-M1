from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://v1.training-support.net")

    print("Home page title: ",driver.title)

    driver.find_element(By.XPATH, "//a[@id='about-link']").click()

    print("About us page title: ",driver.title)

    driver.quit()
    