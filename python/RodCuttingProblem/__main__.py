#!/usr/bin/env python3
<<<<<<< HEAD
from sklearn import tree

features = [[140, 0], [130, 0], [150, 1],[ 170, 1]]  # 0 - smooth, 1 - bumpy
labels = [1, 1, 0, 0]  # 1 - apples, 0 - oranges

clf = tree.DecisionTreeClassifier()
clf = clf.fit(features, labels)
print(clf.predict([[160, 0]]))
cost = []
print("hello")
=======


def max_revenue(cost, n):
    if n == 0:
        return 0
    q = -1
    for i in range(1, n + 1):
        revenue = cost[i - 1] + max_revenue(cost, n - i)
        if q < revenue:
            q = revenue
    return q


def max_revenue_memoization_aux(cost, r, n):
    if n == 0:
        return 0
    if r[n] != -1:
        return r[n]
    q = -1
    for i in range(1, n + 1):
        revenue = cost[i - 1] + max_revenue_memoization_aux(cost, r, n - i)
        if q < revenue:
            q = revenue
    r[n] = q
    return q


def max_revenue_memoization(cost, n):
    r = [-1 for x in range(0, len(cost) + 1)]
    return max_revenue_memoization_aux(cost, r, n)


def max_revenue_bottom_up(cost, n):
    r = [0 for x in range(0, len(cost) + 1)]

    for i in range(1, n + 1):
        q = -1
        for j in range(1, i + 1):
            revenue = cost[j - 1] + r[i - j]
            if q < revenue:
                q = revenue
        r[i] = q
    return r[n]


def max_revenue_bottom_up_extended(cost, n):
    r = [0 for x in range(0, len(cost) + 1)]
    s = [0 for x in range(0, len(cost) + 1)]
    for i in range(1, n + 1):
        q = -1
        for j in range(1, i + 1):
            revenue = cost[j - 1] + r[i - j]
            if q < revenue:
                q = revenue
                s[i] = j
        r[i] = q
    print("optimal cut", s)
    return r[n]


cost = [1, 5, 8, 9, 10, 17, 17, 20, 24, 30]
n = 8
print(max_revenue_bottom_up_extended(cost, n))

assert (max_revenue(cost, 1) == 1)
assert (max_revenue(cost, 2) == 5)
assert (max_revenue(cost, 3) == 8)
assert (max_revenue(cost, 4) == 10)
assert (max_revenue(cost, 5) == 13)
assert (max_revenue(cost, 6) == 17)
assert (max_revenue(cost, 7) == 18)
assert (max_revenue(cost, 8) == 22)
assert (max_revenue(cost, 9) == 25)
assert (max_revenue(cost, 10) == 30)

assert (max_revenue_memoization(cost, 1) == 1)
assert (max_revenue_memoization(cost, 2) == 5)
assert (max_revenue_memoization(cost, 3) == 8)
assert (max_revenue_memoization(cost, 4) == 10)
assert (max_revenue_memoization(cost, 5) == 13)
assert (max_revenue_memoization(cost, 6) == 17)
assert (max_revenue_memoization(cost, 7) == 18)
assert (max_revenue_memoization(cost, 8) == 22)
assert (max_revenue_memoization(cost, 9) == 25)
assert (max_revenue_memoization(cost, 10) == 30)

assert (max_revenue_bottom_up(cost, 1) == 1)
assert (max_revenue_bottom_up(cost, 2) == 5)
assert (max_revenue_bottom_up(cost, 3) == 8)
assert (max_revenue_bottom_up(cost, 4) == 10)
assert (max_revenue_bottom_up(cost, 5) == 13)
assert (max_revenue_bottom_up(cost, 6) == 17)
assert (max_revenue_bottom_up(cost, 7) == 18)
assert (max_revenue_bottom_up(cost, 8) == 22)
assert (max_revenue_bottom_up(cost, 9) == 25)
assert (max_revenue_bottom_up(cost, 10) == 30)
>>>>>>> ffb463e8a8119e77ae993aed332baf4d6ca2db59
