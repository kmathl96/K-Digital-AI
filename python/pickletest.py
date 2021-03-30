import pickle

# colors = ['red','green','black']
# with open('colors.bin', 'wb') as f:
#     pickle.dump(colors,f)

with open('colors.bin','rb') as f:
    colors = pickle.load(f)
    print(colors)