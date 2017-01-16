#!/usr/bin/env python3
from sklearn import tree

features = [[140, 0], [130, 0], [150, 1],[ 170, 1]]  # 0 - smooth, 1 - bumpy
labels = [1, 1, 0, 0]  # 1 - apples, 0 - oranges

clf = tree.DecisionTreeClassifier()
clf = clf.fit(features, labels)
print(clf.predict([[160, 0]]))
cost = []
print("hello")
