print('Hello python!') # 화면에 문자열 출력

def print_personnel(name, position='staff', nationality='Korea'):
    print('name = {0}'.format(name))
    print('position = {0}'.format(position))
    print('nationality = {0}'.format(nationality))
print_personnel(name='홍길동')

def print_args(argc, *argv):
    for i in range(argc):
        print(argv[i])
print_args(3, "argv1", "argv2", "argv3")

arr=[3,4,1,5,2]
def bubble_sort(compare):
    for i in range(len(arr)-1):
        for j in range(len(arr)-1-i):
            if compare(arr[j],arr[j+1]):
                t=arr[j]
                arr[j]=arr[j+1]
                arr[j+1]=t

def assending(x,y):
    return x>y
def descending(x,y):
    return x<y
bubble_sort(assending)
print(arr)
bubble_sort(descending)
print(arr)