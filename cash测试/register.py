from selenium import webdriver
import time

drive = webdriver.Chrome()
drive.get("http://localhost:8888/register.html")

drive.find_element_by_name("username").send_keys("哈哈")
drive.find_element_by_name("password").send_keys("123456")
drive.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/input").click()

time.sleep(3)
drive.quit()
