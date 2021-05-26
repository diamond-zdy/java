import json
import requests
from requests.auth import HTTPBasicAuth

IP = "192.168.100.133"

index = 100

base_odl_url = "http://" + IP + \
    ":8181/restconf/operational/opendaylight-inventory:nodes/node/"

def get_all_flow():
    res = []
    url = "openflow:1/table/0/"
    headers = {'Content-Type': 'application/json'}
    resp = requests.get(base_odl_url + url,
                        headers=headers,
                        auth=HTTPBasicAuth('admin', 'admin'))
    flows = json.loads(resp.text)["flow-node-inventory:table"][0]["flow"]
    for flow in flows:
        temp = []
        temp.append(str(flow.get("id")))
        temp.append(str(flow.get("table_id")))
        temp.append(
            str(
                flow.get("opendaylight-flow-statistics:flow-statistics")
                ["duration"]["second"]))
        temp.append(
            str(
                flow.get("opendaylight-flow-statistics:flow-statistics")
                ["byte-count"]))
        temp.append(
            str(
                flow.get("opendaylight-flow-statistics:flow-statistics")
                ["packet-count"]))
        temp.append(str(flow.get("priority")))
        temp.append(str(flow.get("match")))
        res.append(temp)
    return res

def put_flow(dpid, name, dst, in_port, out_port, priority):
    dst = dst[-1]
    url = "http://192.168.100.133:8181/restconf/config/opendaylight-inventory:nodes/node/openflow:{}/table/0/flow/{}".format(dpid,name)
    headers = {'Content-Type':'application/json'}
    flow = {
    "flow": [
        {
            "id": name,
            "table_id": 0,
            "priority": int(priority),
            "match": {
            	"in-port":int(in_port),
                "ipv4-destination": "10.0.0.{}/32".format(dst),
                "ethernet-match": {
                    "ethernet-type": {
                        "type": "0x0800"
                    }
                }
            },
            "instructions": {
                "instruction": [
                    {
                        "order": "0",
                        "apply-actions": {
                            "action": [
                                {
                                    "order": "0",
                                    "output-action":{"output-node-connector":int(out_port)}
                                }
                            ]
                        }
                    }
                ]
            }
        }
    ]

}
    resp = requests.put(url, headers = headers, data = json.dumps(flow),auth=HTTPBasicAuth('admin', 'admin'))
    if resp.status_code == 200:
        print("send drop flow!")
    print( resp.text)
    print (resp.status_code)