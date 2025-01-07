import joblib
from dask.array import square

loaded_model = joblib.load('../model/ex1_apt_price_regression.pkl')

# pkl 안에 어떤 모델 있는지 모르니 predict 자동 완성 불가
def predict_apt_price(year, square, floor):
    input_data = [[1, int(year), int(square), int(floor)]]
    pred = loaded_model.predict(input_data)[0] # [12521.25154]
    return format(round(pred*10000), ',') + '원입니다'

# 현재 실행 중인 모듈의 이름이 __main__이면,
# 독립변수를 input 변수로 받기
if __name__ == '__main__':
    year   = input('몇 년? ')
    square = input('전용면적(m²)? ')
    floor  = input('층? ')
    print('예측한 금액은', predict_apt_price(year, square, floor))
    # print(__name__)