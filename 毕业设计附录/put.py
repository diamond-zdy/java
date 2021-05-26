import requests
import json
from requests.auth import HTTPBasicAuth

base_odl_url = "http://127.0.0.1:8181/restconf/config/opendaylight-inventory:nodes/node/"

def send_drop_flow():
    headers = {'Content-Type':'application/json'}
    index = 110
    for item in [[1,3,5,1],[3,3,5,1],[5,1,5,3],[5,3,1,2],[4,1,1,3],[1,2,1,3],[1,4,5,1],[5,3,2,2],[4,1,2,3],[1,2,2,4]]:
        dpid = str(item[0])
        in_port = str(item[1])
        dst = str(item[2])
        flow = "flow" + str(index)
        out_port = str(item[3])
        print (flow)
        url = "openflow:{}/flow-node-inventory:table/0/flow/{}".format(dpid, flow)
        flow = {"flow":[{"id":flow,"table_id":0,"priority":120,"instructions":{"instruction":[{"order":0,"apply-actions":{"action":[{"order":"0", "output-action":{"output-node-connector":out_port}}]}}]},
            "match":
                {
                    "ethernet-match":
                        {"ethernet-type":
                            {"type":"0x0800"}},
                            "in-port":in_port,
                            "ipv4-destination": "10.0.0.{}/32".format(dst)
                }}]}
        resp = requests.put(base_odl_url+url, headers = headers, data = json.dumps(flow),auth=HTTPBasicAuth('admin', 'admin'))
        if resp.status_code == 200:
            print("send drop flow!")
        print (resp.text)
        index += 1

send_drop_flow()