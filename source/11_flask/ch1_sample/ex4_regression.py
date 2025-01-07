import pandas as pd          # csv 파일 read
import statsmodels.api as sm # 회귀분석 모델 생성
import joblib                # pkl 모델 저장하거나 load

df = pd.read_csv('../data/trade_apt_api.csv', encoding = 'cp949')
# 독립변수
# 분석의 편의상 모델 단순화를 위해 법정동(지역)은 독립변수에서 제외
# 법정동명은 One-Hot Encoding 필요하기 때문
x = df[['건축년도', '전용면적', '층']]
# 상수항(1) 추가하기 위한 add_constant 함수
X = sm.add_constant(x)
# 종속변수
y = df['거래금액']

# Model 생성
model = sm.OLS(y, X).fit()

# Model 저장
joblib.dump(model, '../model/ex1_apt_price_regression.pkl')