from flask import Flask,request
from flow import flow
from flask import render_template
import random
app = Flask(__name__)

@app.route('/', methods=['POST', 'GET'])
def index():
    if request.method == 'POST':
        dpid = request.form.get('model1')
        host = request.form.get('model2')
        in_port = request.form.get('model3')
        out_port = request.form.get('model4')
        priority = request.form.get('model5')
        print(dpid, host, in_port,out_port,priority)
        name = ''.join(random.sample(['z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'], 10))
        flow.put_flow(dpid, name, host, in_port, out_port, priority)
        content = flow.get_all_flow()
        labels = [
            "ID", "Table_Id", "Duration", "byte-count", "packet-count", "Priority",
            "match"
        ]
        content = flow.get_all_flow()
        return render_template('index.html', labels=labels, content=content)
    if request.method == 'GET':
        print ("1")
        content = flow.get_all_flow()
        labels = [
            "ID", "Table_Id", "Duration", "byte-count", "packet-count", "Priority",
            "match"
        ]
        return render_template('index.html', labels=labels, content=content)       
    return "test"


if __name__ == '__main__':
    app.run(debug=True)
