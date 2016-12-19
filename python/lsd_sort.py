#/usr/bin/env python3
list = ['4PGC938', '2IYE230', '3CIO720', '1ICK750', '1OHV845', '4JZY524', '1ICK750', ',3CIO720', '1OHV845', '1OHV845', '2RLA629', '2RLA629', '3ATW723']
def lsd_sort(array):
	W = 7
	R = 256
	N = len(array)
	for d in range(W-1, -1, -1):
		count = [0 for x in range(0, 256)]
		for str in array:
			count[ord(str[d]) + 1]+= 1;
		for i in range(1, R-1):
			count[i + 1] += count[i]; 
	print(count)
lsd_sort(list)
#print(list)
