#!/usr/bin/env python3

from sklearn import tree

# weight (in grams), skin tone (0 - smooth, 1 - rough)
features = [[130, 0], [140, 0], [125, 0], [150, 1], [155, 1]]
# 0 - apple, 1 = orange
set = [0, 0, 0, 1, 1]
clf = tree.DecisionTreeClassifier()
clf = clf.fit(features, set)
example = [[140, 0]]
print(clf.predict(example))
