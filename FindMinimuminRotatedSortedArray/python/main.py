import solution

s = solution.threesum.Solution2();

# positive cases
num = [1, 2, 3, 4, 5]
print s.findMin(num)

num = [5, 1, 2, 3, 4]
print s.findMin(num)

num = [4, 5, 1, 2, 3]
print s.findMin(num)

num = [3, 4, 5, 1, 2]
print s.findMin(num)

num = [2, 3, 4, 5, 1]
print s.findMin(num)

# nagative cases
num = [