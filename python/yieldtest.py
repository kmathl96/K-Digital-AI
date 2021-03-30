def number_generator(n):
    print('Function start')
    while n<6:
        yield n # return과 비슷
        n += 1
    print('Function end')

if __name__=='__main__':
    for i in number_generator(0):
        print(i)