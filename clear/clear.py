from os import listdir
from os.path import isfile, join
onlyfiles = [f for f in listdir('./') if isfile(join('./', f))]

i = 0
for f in onlyfiles:
    if onlyfiles[i] != "clear.py":
        #print(onlyfiles[i])
        f = open(onlyfiles[i],"r")
        s1 = f.read()
        s2 = s1.replace("\n%","")
        s3 = s2.replace("\n0","")
        f.close()

        f = open("./output/"+onlyfiles[i],"w")
        f.write(s3)

        i +=1
    else: i+=1