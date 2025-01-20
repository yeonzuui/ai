# 받을 파일이 많을 경우, model.py에 분리하기도 함
from pydantic import BaseModel

class ToDoRequest(BaseModel):
    id      : int
    contents: str
    # 수행 여부 # 입력 안 하면 False
    is_done : bool | None = False
