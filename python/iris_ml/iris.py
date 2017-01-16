#!/usr/bin/env python3

import numpy as np
from sklearn import tree
from sklearn.datasets import load_iris

iris = load_iris()
print(iris.feature_names)
print(iris.target_names)
print(iris.data[0])
print(iris.target[0])

test_idx = [0, 50, 100]

train_target = np.delete(iris.target, test_idx)
train_data = np.delete(iris.data, test_idx, axis=0)

test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

print(test_target)
print(test_data)

clf = tree.DecisionTreeClassifier()
clf.fit(train_data, train_target)

print(clf.predict(test_data))

import pydotplus

dot_data = tree.export_graphviz(clf, out_file=None)
graph = pydotplus.graph_from_dot_data(dot_data)
graph.write_pdf("iris.pdf")
