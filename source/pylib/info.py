"""
In Java...
Cal obj = new Cal(10, 20)

class Cal{
    private int num1;
    private int num2;

    public Cal(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public Cal(){
        num1 = num2 = 1;
    }
    public int add(){
        return num1 + num2
    }

    public int sub(){
        return num1 - num2
    }
}
"""
PI = 3.141592

# 생성자 함수
class Cal:
    def __init__(self, num1 = 1 , num2 = 1):
        self.num1 = num1
        self.num2 = num2
    def add(self):
        return self.num1 + self.num2
    def sub(self):
        return self.num1 - self.num2
    
def main():
    print('Cal 객체 생성 test입니다')
    obj = Cal(10, 20)
    print('obj.num1:', obj.num1)
    print('obj.num2:', obj.num2)
    print('add test:', obj.add())
    print('sub test:', obj.sub())

if __name__ == '__main__':
    main()