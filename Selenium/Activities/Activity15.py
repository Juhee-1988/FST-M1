from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")

    print("Title of the page: ",driver.title)

    driver.find_element(By.CSS_SELECTOR, "input[class^='username-']").send_keys("admin")

    driver.find_element(By.XPATH, "//input[starts-with(@class,'password-')]").send_keys("password")

    driver.find_element(By.XPATH, "//button[text()='Log in']").click()

    message = driver.find_element(By.XPATH, "//div[@id='action-confirmation']").text

    print("Login message: ",message)

    driver.quit()