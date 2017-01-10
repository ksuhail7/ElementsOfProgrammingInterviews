#!/usr/bin/env python3
from activity import Activity

t = [(1,4),(3,5),(0,6),(5,7),(3,9),(5,9),(6,10),(8,11),(8,12),(2,14),(12,16)]
activities = [Activity(*x) for x in t]
sorted_activities = sorted(activities, key=lambda act: act.getFinish())

A = [sorted_activities[0]]
finish = sorted_activities[0].getFinish()
for i in range(1, len(sorted_activities)):
	activity = sorted_activities[i]
	if activity.getStart() >= finish:
		A.append(activity)
		finish = activity.getFinish()

for activity in A:
	print(activity.getStart(), activity.getFinish())