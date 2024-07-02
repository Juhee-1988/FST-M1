from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:

    driver.get("https://v1.training-support.net/selenium/target-practice")

    print("Title of the page: ",driver.title)

    third_header = driver.find_element(By.XPATH,"//h3[@id='third-header']")

    print("Text of the 3rd header: ",third_header.text)

    fifth_header = driver.find_element(By.XPATH,"//h5[text()='Fifth header']")

    print("Color of the 5th header: ",fifth_header.value_of_css_property("color"))

    violet_button = driver.find_element(By.XPATH,"//button[text()='Violet']")

    print("Classes of the Violet button: ",violet_button.get_attribute("class"))
    
    grey_button = driver.find_element(By.CLASS_NAME,"grey")
		
    print("Text of the Grey button: " + grey_button.text)

    driver.quit()



