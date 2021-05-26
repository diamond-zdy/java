import requests
from requests.auth import HTTPBasicAuth

url = "http://127.0.0.1:8181/restconf/config/opendaylight-inventory:nodes/node/openflow:1/flow-node-inventory:table/0/flow/pfurjzygch"
headers = {'Content-Type': 'application/json'}
resp = requests.delete(url,
                    headers=headers,
                    auth=HTTPBasicAuth('admin', 'admin'))
