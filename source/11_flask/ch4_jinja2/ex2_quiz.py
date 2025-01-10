from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/', methods = ["get", "post"])
def index():
    if request.method == 'GET':             # get방식 파라미터값
        number = request.args.get('number') # 파라미터 못 받으면 None
    else:
        number = request.form["number"]     # post방식 파라미터 값
    return render_template("2_quiz.html",
                           number = number)

if __name__ == "__main__":
    app.run(debug = True)