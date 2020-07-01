from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("http://localhost:8888/login.html")
driver.maximize_window()

driver.find_element_by_name("username").send_keys("zdy")
driver.find_element_by_name("password").send_keys("123")
driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()

time.sleep(6)
driver.quit()
