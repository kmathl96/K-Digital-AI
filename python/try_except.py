try:
    print(1/0)
except:
    print("예외가 발생했습니다.")

my_list = [1,2,3]

# 복수 개의 except절
def except1(n):
    try:
        print(my_list[n]/0)
    except ZeroDivisionError:
        print("0으로 나눌 수 없습니다.")
    except IndexError:
        print("잘못된 첨자입니다.")
except1(2)
except1(10)

# as : 예외 인스턴스를 활용
def except2(n):
    try:
        print(my_list[n]/0)
    except ZeroDivisionError as err:
        print(f'0으로 나눌 수 없습니다. ({err})')
    except IndexError as err:
        print(f'잘못된 첨자입니다. ({err})')
except2(2)
except2(10)

# else
def except3(n):
    try:
        print(f'my_list[{n}]:{my_list[n]}')
    except Exception as err:
        print(f'예외가 발생했습니다. ({err})')
    else: print("리스트 요소 출력 성공")
except3(2)
except3(10)

# raise : 예외 발생 시키기
try:
    raise Exception("예외를 일으킴")
except Exception as err:
    print(f'예외 발생 : {err}')

def f(n):
    if n < 1 or n > 10:
        raise Exception(f'유효하지 않은 숫자 : {n}')
    else:
        print(f'{n}')
def f_caller(n):
    try:
        f(n)
    except Exception as err:
        print(f'1) 예외 발생 : {err}')
        raise
try:
    f_caller(12)
except Exception as err:
    print(f'2) 예외 발생 : {err}')

# 예외 정의 : Exception 클래스 상속
class MyException1(Exception):
    pass
class MyException2(Exception):
    # 필요에 따라 데이터 속성/메소드 추가 가능
    def __init__(self):
        super().__init__("MyExcetpion 발생")
raise MyException2