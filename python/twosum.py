#!/usr/bin/python

class Solution:
	# @return a tuple, (index1, index2)
	def twoSum(self, num, target):
		lenNum = len(num)
		d = {}
		for i in xrange(lenNum):
			d[num[i]] = [i + 1] if num[i] not in d else d[num[i]] + [i + 1]
		print d
		for i in num:
			if target - i in d:
				if i == target - i:
					if len(d[i]) == 2: return (d[i][0], d[i][1])
				else:
					return (d[i][0], d[target - i][0]) if d[i][0] < d[target - i][0] else (d[target - i][0], d[i][0])
if __name__ == '__main__':
	s = Solution()
	nums = [3, 2, 4]
	target = 6
	print s.twoSum(nums, target)
