class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        rList = ()
        nums.sort()
        i = 0
        while i < len(nums)-2:
            j = i + 1
            k = len(nums)-1
            while j < k:
                sum = nums[i] + nums[j] + nums[k]
                if sum == 0:
                    rList.insert((nums[i], nums[j], nums[k]))
                elif sum < 0:
                    while j < k and nums[j+1] == nums[j]:
                        j++
                    j++
                else
                    while j < k and nums[k] == nums[k-1]:
                        k--
                    k--
            while i < len(nums) - 2 and nums[i+1] == nums[i]:
                i++
            i++

        return rList
