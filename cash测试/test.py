import unittest,csv
import os,sys
import time
from unittest.suite import TestSuite
import HTMLTestRunner

import unitcash

def createsuite():
    suite = unittest.TestSuite()
    suite.addTest(unitcash.cashTest("test_login"))
    suite.addTest(unitcash.cashTest("test_inbound"))
    suite.addTest(unitcash.cashTest("test_goodsbrowse"))
    suite.addTest(unitcash.cashTest("test_updategoods"))
    suite.addTest(unitcash.cashTest("test_orderbrowse"))
    suite.addTest(unitcash.cashTest("test_pay"))
    return suite


if __name__=="__main__":
    curpath = sys.path[0]
    print(sys.path)
    print("=============")
    print(sys.path[0])
    if not os.path.exists(curpath + 'resultreport'):
        os.makedirs(curpath + 'resultreport')

    now = time.strftime("%Y-%m-%d-%H %M %S", time.localtime(time.time()))
    print("-------------------")
    print(time.time())
    print("-----------------------")
    print(time.localtime(time.time()))
    print("------------------------")
    print(now)
    filename = curpath + '/resultreport/' + now + 'resultreport.html'
    with open(filename, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp, title=u"测试报告", description=u"用例执行情况",
                                               verbosity=1)
        suite = createsuite()
        runner.run(suite)
