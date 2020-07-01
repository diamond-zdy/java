from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import time
import unittest,csv,re
import os,sys
#import HTMLTestRunner


class cashTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.first_url = "http://localhost:8888/login.html"
        self.second_url = "http://localhost:8888/index.html"

    def tearDown(self):
        self.driver.quit()

    def test_login(self):
        driver = self.driver
        driver.get(self.first_url)
        driver.find_element_by_name("username").send_keys("zdy")
        driver.find_element_by_name("password").send_keys("123")
        driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()
        time.sleep(3)

    def test_inbound(self):
        driver = self.driver
        driver.get(self.first_url)
        driver.find_element_by_name("username").send_keys("zdy")
        driver.find_element_by_name("password").send_keys("123")
        driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()
        time.sleep(3)
        #商品入库
        driver.find_element_by_xpath("/html/body/ul/li/ul/a[1]/li").click()
        time.sleep(3)
        driver.find_element_by_name("name").send_keys("手表")
        driver.find_element_by_name("stock").send_keys("20")
        driver.find_element_by_name("introduce").send_keys("国产")
        driver.find_element_by_name("unit").send_keys("个")
        driver.find_element_by_name("price").send_keys("500")
        driver.find_element_by_name("discount").send_keys("2")
        driver.find_element_by_xpath("/html/body/div/div/div/div[2]/ul/div/div/div/div/div/div[2]/form/div[7]/div/input").submit()
        time.sleep(3)

    def test_goodsbrowse(self):
        driver = self.driver
        driver.get(self.first_url)
        driver.find_element_by_name("username").send_keys("zdy")
        driver.find_element_by_name("password").send_keys("123")
        driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()
        time.sleep(3)
        #浏览商品
        driver.find_element_by_xpath("/html/body/ul/li/ul/a[2]/li").click()
        time.sleep(3)
        #driver.find_element_by_xpath("//*[@id='tbRecord']/tbody/tr[4]/td[8]/button").click()
        #alert = driver.switch_to.alert
        #alert.accept()
        #time.sleep(3)
        driver.back()
        time.sleep(3)

    def test_updategoods(self):
        driver = self.driver
        driver.get(self.first_url)
        driver.find_element_by_name("username").send_keys("zdy")
        driver.find_element_by_name("password").send_keys("123")
        driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()
        time.sleep(3)
        #更新商品信息
        driver.find_element_by_xpath("/html/body/ul/li/ul/a[3]/li").click()
        time.sleep(3)
        driver.find_element_by_id("goodsID").send_keys("1")
        driver.find_element_by_id("name").send_keys("草莓")
        driver.find_element_by_id("stock").send_keys("10")
        driver.find_element_by_id("introduce").send_keys("甜甜的")
        driver.find_element_by_id("unit").send_keys("盒")
        driver.find_element_by_id("price").send_keys("30")
        driver.find_element_by_id("discount").send_keys("3")
        driver.find_element_by_xpath("/html/body/div/div/div/div[2]/ul/div/div/div/div/div/div[2]/form/div[8]/div/input").click()
        time.sleep(3)
        driver.get(self.second_url)
        time.sleep(3)

    def test_orderbrowse(self):
        driver = self.driver
        driver.get(self.first_url)
        driver.find_element_by_name("username").send_keys("zdy")
        driver.find_element_by_name("password").send_keys("123")
        driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()
        time.sleep(3)
        #浏览订单
        driver.find_element_by_xpath("/html/body/ul/li/ul/a[4]/li").click()
        time.sleep(3)
        driver.back()
        time.sleep(3)


    def test_pay(self):
        driver = self.driver
        driver.get(self.first_url)
        driver.find_element_by_name("username").send_keys("zdy")
        driver.find_element_by_name("password").send_keys("123")
        driver.find_element_by_xpath("/html/body/div/div/div/div/form/div[3]/button").click()
        time.sleep(3)
        #购买商品
        driver.find_element_by_xpath("/html/body/ul/li/ul/a[5]/li").click()
        driver.find_element_by_xpath("//*[@id='goodsIDandNum']").send_keys("1-1")
        driver.find_element_by_xpath("/html/body/div/div/div/div[2]/ul/div/div/div/div/div/div[2]/form/div[2]/div/input").click()
        time.sleep(3)
        #driver.find_element_by_xpath("/html/body/a[1]").click()
        #time.sleep(3)
        #driver.find_element_by_xpath("/html/body/a").click()
        #time.sleep(3)



if __name__=="__main__":
    unittest.main()