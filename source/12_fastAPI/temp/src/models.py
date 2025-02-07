# FastAPI에서 POST 방식 요청 파라미터를 보낼 때 데이터 검증
from pydantic import BaseModel

class ToDoRequest(BaseModel):
    contents : str | None = ''
    is_done  : bool | None = False