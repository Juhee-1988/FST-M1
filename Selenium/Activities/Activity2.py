from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://v1.training-support.net/selenium/login-form")

    print("Login page title: ",driver.title)

    driver.find_element(By.NAME, "Username").send_keys("admin")

    driver.find_element(By.NAME, "Password").send_keys("password")

    driver.find_element(By.XPATH, "//button[text()='Log in']").click()

    message = driver.find_element(By.ID, "action-confirmation")

    print("Login message: ",message.text)

    driver.quit()