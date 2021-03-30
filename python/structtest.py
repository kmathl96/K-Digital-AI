import struct

packed = struct.pack('if',123,3.14)
print(packed)
unpacked = struct.unpack('if',packed)
print(unpacked)

fmt = '=16s2fi' # char[16], float[2], int
# city_info = [
#     # CITY, Latitude, Longitude, Population
#     ('서울'.encode(encoding='utf-8'), 37.566535, 126.977969, 9820000),
#     ('뉴욕'.encode(encoding='utf-8'), 40.712784, -74.005941, 8400000),
#     ('파리'.encode(encoding='utf-8'), 48.856614, 2.352222,   2210000),
#     ('런던'.encode(encoding='utf-8'), 51.507351, -0.127758,  8300000)
# ]
# with open('cities.dat','wb') as file:
#     for city in city_info:
#         file.write(struct.pack(fmt,*city))

struct_len = struct.calcsize(fmt)
cities = []
with open('cities.dat','rb') as file:
    while True:
        buffer = file.read(struct_len)
        if not buffer: break
        city = struct.unpack(fmt, buffer)
        cities.append(city)
    for city in cities:
        name = city[0].decode(encoding='utf-8').replace('\x00','')
        # print(f'city:{name}, Lat/Long:{city[1]}/{city[2]}, Population:{city[3]}')
        print(f'city:%s, Lat/Long:%f/%f, Population:%d'%(name,city[1],city[2],city[3]))