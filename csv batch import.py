import os
import pandas as pd

def listdirInMac(path):
    os_list = os.listdir(path)
    for item in os_list:
        if item.startswith('.') and os.path.isfile(os.path.join(path, item)):
            os_list.remove(item)
    os_list.sort()
    return os_list
 
root='/Users/alex/Documents/data/want/test/'
newfile=pd.DataFrame()
pieces=[]
#all txt data will append on this variable
for file in listdirInMac(root):
    if 'CSV' in file:          
        pathname=os.path.join(root,file)  #file path <--add additional tab here
        print pathname
        temp=pd.read_csv(pathname,usecols=[1],header=None)  # read csv <--add additional tab here
        pieces.append(temp)
        
newfile = pd.concat(pieces, axis=1)
newfile.to_csv('/Users/alex/Documents/data/want/test/merge.csv')                 #save as a newfile