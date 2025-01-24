from pydantic import BaseModel

class ToDoRequest(BaseModel):
  contents : str | None = ''
  is_done : bool | None = False