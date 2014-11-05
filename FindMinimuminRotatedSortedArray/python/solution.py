class Solution:
  # @param num, a list of integer
  # @return an integer
  def findMin(self, num):
    if len(num) == 0:
      raise Exception("Empty input array!")
    return self.findMinInArray(num, 0, len(num)-1)

  def findMinInArray(self, num, start, end):
    if start == end:
      return num[start]
    if start == (end-1):
      return num[start] if num[start] < num[end] else num[end]

    mid = (start + end) / 2
    if (num[start] < num[mid]) and (num[mid] < num[end]):
      return num[start]

    if (num[start] > num[mid]) and (num[mid] < num[end]):
      return self.findMinInArray(num, start + 1, mid)

    if (num[start] < num[mid]) and (num[mid] > num[end]):
      return self.findMinInArray(num, mid+1, end)

    raise Exception("Recursion Error!")