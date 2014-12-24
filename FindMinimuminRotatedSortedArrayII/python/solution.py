class threesum.Solution2:
  # @param num, a list of integer
  # @return an integer
  def findMin(self, num):
    if len(num) == 0:
      raise Exception("Empty input array!")
    return self.findMinWithinIndex(num, 0, len(num)-1)
  def findMinWithinIndex(self, num, start, end):
    if start == end:
      return num[start]
    if start == (end-1):
      return num[start] if num[start] < num[end] else num[end]

    mid = (start + end) / 2
    if (num[start] == num[mid]) and (num[mid] == num[end]):
      start += 1
      while (start != mid):
        if (num[start] == num[start-1]):
          start += 1
        else:
          break
      end -= 1
      while (end != mid):
        if (num[end] == num[end+1]):
          end -= 1
        else:
          break
      return self.findMinWithinIndex(num, start, end)

    if num[start] < num[end]:
      if (num[start] > num[mid]) or (num[mid] > num[end]):
        raise Exception("Invalid input, not a rotated sorted list!")
      return num[start]

    if (num[start] <= num[mid]) and (num[mid] > num[end]):
      if num[start] < num[end]:
        raise Exception("Invalid input, not a rotated sorted list!")
      return self.findMinWithinIndex(num, mid+1, end)

    if (num[start] > num[mid]) and (num[mid] <= num[end]):
      if num[start] < num[end]:
        raise Exception("Invalid input, not a rotated sorted list!")
      return self.findMinWithinIndex(num, start+1, mid)

    raise Exception("Invalid input!")